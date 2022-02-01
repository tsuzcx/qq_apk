import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.net.ReportLocationHandler.1;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.location.RoomOperate.ReqReportLocation;
import tencent.im.oidb.location.RoomOperate.RspReportLocation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class avxf
  extends avwr<avwv>
{
  private static int jdField_a_of_type_Int = 2000;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private avxg jdField_a_of_type_Avxg;
  private Long jdField_a_of_type_JavaLangLong;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private int b;
  
  public avxf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b() {}
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "stopReport: invoked. ", " loopReportStopped: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  int a()
  {
    return this.b;
  }
  
  protected avwv a()
  {
    return avwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangLong + "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, "destroy: invoked. ");
    }
    c();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, long paramLong, avwn paramavwn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", "uinType = [" + paramInt + "], sessionUin = [" + paramLong + "], locationItem = [" + paramavwn + "]" });
    }
    RoomOperate.ReqReportLocation localReqReportLocation = new RoomOperate.ReqReportLocation();
    qq_lbs_share.RoomKey localRoomKey = awbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, paramLong);
    localReqReportLocation.room_key.set(localRoomKey);
    localReqReportLocation.room_key.setHasFlag(true);
    localReqReportLocation.direction.set(paramavwn.a());
    paramavwn = paramavwn.a();
    if (paramavwn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", " latLng: ", paramavwn });
      }
      return;
    }
    localReqReportLocation.lat.set(paramavwn.latitude);
    localReqReportLocation.lon.set(paramavwn.longitude);
    paramavwn = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQLBSShareSvc.report_location");
    paramavwn.putWupBuffer(localReqReportLocation.toByteArray());
    a().sendPbReq(paramavwn);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject))
    {
      try
      {
        paramToServiceMsg = (RoomOperate.RspReportLocation)new RoomOperate.RspReportLocation().mergeFrom((byte[])paramObject);
        if (awbi.a((qq_lbs_share.ResultInfo)paramToServiceMsg.msg_result.get()))
        {
          i = paramToServiceMsg.req_interval.get();
          if (i != 0) {
            jdField_a_of_type_Int = i * 1000;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " intervalMillis: ", Integer.valueOf(jdField_a_of_type_Int) });
          return;
        }
        b();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ReportLocationHandler", 1, "requestReportLocationResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    else
    {
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
        }
      }
      b();
    }
  }
  
  public void a(String paramString, avxg paramavxg)
  {
    this.jdField_a_of_type_Avxg = paramavxg;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "startReportInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaLangRunnable = new ReportLocationHandler.1(this);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(avwp paramavwp)
  {
    if (!a()) {
      return false;
    }
    return new avwp(this.b, "" + this.jdField_a_of_type_JavaLangLong).equals(paramavwp);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(a())) && (a().equals(paramString)) && (a() == paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxf
 * JD-Core Version:    0.7.0.1
 */