import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.qcircleshadow.local.requests.QQCircleGetGroupCountRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class bgco
  extends bgax
{
  private long jdField_a_of_type_Long;
  private bgav jdField_a_of_type_Bgav;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public bgco(BaseChatPie paramBaseChatPie, bgav parambgav)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bgav = parambgav;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return 0L;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
    return localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramString + "_" + localQQAppInterface.getCurrentUin() + "_" + this.jdField_a_of_type_Long, paramLong);
  }
  
  private void a(long paramLong)
  {
    a("key_last_request_troop_qcircle_msg_time", paramLong);
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
    paramString = paramString + "_" + localQQAppInterface.getCurrentUin() + "_" + this.jdField_a_of_type_Long;
    localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private void a(ArrayList<bgba> paramArrayList)
  {
    if (this.jdField_a_of_type_Bgav != null) {
      this.jdField_a_of_type_Bgav.a(3, paramArrayList);
    }
  }
  
  private void a(QQCircleCountergroup.GetGroupCountRsp paramGetGroupCountRsp)
  {
    bgcn localbgcn = new bgcn();
    localbgcn.b(paramGetGroupCountRsp.iconUrl.get());
    localbgcn.a(paramGetGroupCountRsp.content.get());
    localbgcn.a(0);
    localbgcn.a(paramGetGroupCountRsp.latestFeedTime.get());
    paramGetGroupCountRsp = new ArrayList();
    paramGetGroupCountRsp.add(localbgcn);
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
  
  private void e()
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
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), new QQCircleGetGroupCountRequest(this.jdField_a_of_type_Long), new bgcp(this));
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_troop_uin", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("key_jump_from", "24");
    vvh.a(BaseApplicationImpl.getContext(), "openAggregation", localHashMap);
  }
  
  private void g()
  {
    a("key_last_close_troop_qcircle_msg_time", NetConnInfoCenter.getServerTimeMillis() / 1000L);
  }
  
  public void a()
  {
    VSNetworkHelper.getInstance().cancelRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof bgcn)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClick");
    f();
    bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B24F", "0X800B24F", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    e();
  }
  
  public void b(Object paramObject)
  {
    if (!(paramObject instanceof bgcn)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClickMessageCloseBtn");
    a((ArrayList)null);
    g();
    bdla.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B252", "0X800B252", 0, 0, "", "", "", "");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgco
 * JD-Core Version:    0.7.0.1
 */