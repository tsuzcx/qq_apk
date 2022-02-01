import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.qqcircle.launchbean.QCircleAggregationBean;
import com.tencent.biz.qqcircle.requests.QQCircleGetGroupCountRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class bglt
  extends bgkj
{
  private long jdField_a_of_type_Long;
  private bgkh jdField_a_of_type_Bgkh;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public bglt(BaseChatPie paramBaseChatPie, bgkh parambgkh)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bgkh = parambgkh;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return;
    }
    catch (Exception paramBaseChatPie) {}
  }
  
  private long a()
  {
    return a("key_last_close_troop_qcircle_msg_time", 0L);
  }
  
  private long a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return 0L;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    return localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramString + "_" + localQQAppInterface.c() + "_" + this.jdField_a_of_type_Long, paramLong);
  }
  
  private void a(long paramLong)
  {
    a("key_last_request_troop_qcircle_msg_time", paramLong);
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = paramString + "_" + localQQAppInterface.c() + "_" + this.jdField_a_of_type_Long;
    localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private void a(ArrayList<bgkm> paramArrayList)
  {
    if (this.jdField_a_of_type_Bgkh != null) {
      this.jdField_a_of_type_Bgkh.a(2, paramArrayList);
    }
  }
  
  private void a(QQCircleCountergroup.GetGroupCountRsp paramGetGroupCountRsp)
  {
    bgls localbgls = new bgls();
    localbgls.b(paramGetGroupCountRsp.iconUrl.get());
    localbgls.a(paramGetGroupCountRsp.content.get());
    localbgls.a(0);
    localbgls.a(paramGetGroupCountRsp.latestFeedTime.get());
    paramGetGroupCountRsp = new ArrayList();
    paramGetGroupCountRsp.add(localbgls);
    a(paramGetGroupCountRsp);
  }
  
  private boolean a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = a();
    long l3 = b();
    long l4 = c();
    if (QLog.isColorLevel()) {
      QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: curTime=%ss, lastCloseTime=%ss, lastRequestTime=%ss, reqIntervalTime=%ss, \nclose gap=%ss, request gap=%ss", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1 - l2), Long.valueOf(l1 - l3) }));
    }
    boolean bool1;
    if (l1 - l2 < 86400L)
    {
      bool1 = true;
      if (l1 - l3 >= l4) {
        break label177;
      }
    }
    label177:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: isInCloseCoolingTime=%b, isInRequestCoolingTime=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) && (!bool2)) {
        break label183;
      }
      return true;
      bool1 = false;
      break;
    }
    label183:
    return false;
  }
  
  private long b()
  {
    return a("key_last_request_troop_qcircle_msg_time", 0L);
  }
  
  private void b(long paramLong)
  {
    a("key_request_troop_qcircle_msg_time_interval", paramLong);
  }
  
  private long c()
  {
    return a("key_request_troop_qcircle_msg_time_interval", 1200L);
  }
  
  private void d()
  {
    if (!QzoneConfig.isQQCircleShowTroopToolBarEntrance()) {
      QLog.i("QCircleMsgProcessoronInit", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
    }
    do
    {
      return;
      if (!a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QCircleMsgProcessor", 2, "onInit: 冷却时间不发小世界快捷消息请求");
    return;
    VSNetworkHelper.a().a(new QQCircleGetGroupCountRequest(this.jdField_a_of_type_Long), new bglu(this));
  }
  
  private void e()
  {
    QCircleAggregationBean localQCircleAggregationBean = new QCircleAggregationBean();
    localQCircleAggregationBean.setEnableSplash(true);
    localQCircleAggregationBean.setTroopUin(String.valueOf(this.jdField_a_of_type_Long));
    uyx.a(BaseApplicationImpl.getContext(), localQCircleAggregationBean);
  }
  
  private void f()
  {
    a("key_last_close_troop_qcircle_msg_time", NetConnInfoCenter.getServerTimeMillis() / 1000L);
  }
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof bgls)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClick");
    e();
    bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B24F", "0X800B24F", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    d();
  }
  
  public void b(Object paramObject)
  {
    if (!(paramObject instanceof bgls)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClickMessageCloseBtn");
    a((ArrayList)null);
    f();
    bdll.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B252", "0X800B252", 0, 0, "", "", "", "");
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglt
 * JD-Core Version:    0.7.0.1
 */