package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqClearMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotOpt;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotOpt;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69;

public class TroopRedTouchHandler
  extends BusinessHandler
{
  protected int a;
  protected TroopRedTouchHandler.NetInfoHandler a;
  protected BusinessObserver a;
  private QQAppInterface a;
  protected boolean a;
  
  public TroopRedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new TroopRedTouchHandler.5(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler = new TroopRedTouchHandler.NetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static oidb_0x791.RedDotInfo a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    int j = 0;
    Object localObject1 = null;
    label703:
    label982:
    label1005:
    if ((paramArrayOfByte != null) && (paramQQAppInterface != null))
    {
      int i;
      for (;;)
      {
        try
        {
          localObject2 = new Submsgtype0x69();
          ((Submsgtype0x69)localObject2).mergeFrom(paramArrayOfByte);
          boolean bool = ((Submsgtype0x69)localObject2).bool_test_env.get();
          if (bool != PushServlet.jdField_a_of_type_Boolean)
          {
            SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, sIsTestEnv = %b", Boolean.valueOf(bool), Boolean.valueOf(PushServlet.jdField_a_of_type_Boolean));
            if (bool != QQStoryNetReqUtils.a())
            {
              SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, QQStoryNetReqUtils.isDevEnv() = %b", Boolean.valueOf(bool), Boolean.valueOf(QQStoryNetReqUtils.a()));
              return null;
            }
          }
          paramArrayOfByte = new oidb_0x791.RedDotInfo();
          paramArrayOfByte.uint32_appid.set(((Submsgtype0x69)localObject2).uint32_appid.get());
          paramArrayOfByte.bool_display_reddot.set(((Submsgtype0x69)localObject2).bool_display_reddot.get());
          paramArrayOfByte.uint32_number.set(((Submsgtype0x69)localObject2).uint32_number.get());
          paramArrayOfByte.uint32_reason.set(((Submsgtype0x69)localObject2).uint32_reason.get());
          paramArrayOfByte.uint32_last_time.set(((Submsgtype0x69)localObject2).uint32_last_time.get());
          paramArrayOfByte.uint64_cmd_uin.set(((Submsgtype0x69)localObject2).uint64_cmd_uin.get());
          paramArrayOfByte.str_face_url.set(((Submsgtype0x69)localObject2).bytes_face_url.get());
          paramArrayOfByte.str_custom_buffer.set(((Submsgtype0x69)localObject2).bytes_custom_buffer.get());
          paramArrayOfByte.uint32_expire_time.set(((Submsgtype0x69)localObject2).uint32_expire_time.get());
          paramArrayOfByte.uint32_cmd_uin_type.set(((Submsgtype0x69)localObject2).uint32_cmd_uin_type.get());
          paramArrayOfByte.uint32_report_type.set(((Submsgtype0x69)localObject2).uint32_report_type.get());
          if (QLog.isColorLevel()) {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "parsePushRedPointInfo:" + TroopRedTouchManager.a(paramArrayOfByte));
          }
          i = paramArrayOfByte.uint32_appid.get();
          if (i != 38) {}
        }
        catch (Exception paramQQAppInterface)
        {
          Object localObject2;
          int k;
          int m;
          long l1;
          long l2;
          paramQQAppInterface.printStackTrace();
          paramQQAppInterface = localObject1;
        }
        try
        {
          localObject2 = new JSONObject(paramArrayOfByte.str_custom_buffer.get().toStringUtf8());
          if (((JSONObject)localObject2).optInt("official_topic") != 1) {
            break label622;
          }
          i = 1;
          k = ((JSONObject)localObject2).optInt("red_content_type");
          m = ((Integer)NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
          if (i != 0)
          {
            new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("push_red_send").a(new String[] { String.valueOf(m), "0", String.valueOf(k), "0" }).a();
            Log.i("redreport", "retport push_red_send d1 = " + m + " d3 = " + k);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
          paramQQAppInterface = localException.a();
          i = TroopRedTouchConfigure.a(paramArrayOfByte, paramQQAppInterface);
          if (i >= 0) {
            break label703;
          }
          if (!QLog.isColorLevel()) {
            break label1034;
          }
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "comparePriority:比上一个红点优先级低，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
          return null;
          if ((i != 0) || (paramArrayOfByte.uint32_last_time.get() >= paramQQAppInterface.uint32_last_time.get())) {
            break label1005;
          }
          if (!QLog.isColorLevel()) {
            break label1034;
          }
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "当前红点比上一个红点旧，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
          return null;
          paramQQAppInterface = localException.a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.uint64_cmd_uin.get() == paramArrayOfByte.uint64_cmd_uin.get()) && (paramQQAppInterface.uint32_cmd_uin_type.get() == paramArrayOfByte.uint32_cmd_uin_type.get()) && (paramQQAppInterface.uint32_last_time.get() == paramArrayOfByte.uint32_last_time.get())) {
            break label1005;
          }
          if (!QLog.isColorLevel()) {
            break label1034;
          }
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "故事的撤回红点需要判断uin和lasttime，强校验，和上一个不一致的话直接返回，不处理，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
          return null;
          if (46 != paramArrayOfByte.uint32_appid.get()) {
            break label1005;
          }
          if (!TeamWorkUtils.a(paramQQAppInterface)) {
            break label1034;
          }
          oidb_0x791.RedDotInfo localRedDotInfo = localException.a(46, false);
          i = j;
          if (localRedDotInfo == null) {
            break label944;
          }
          i = j;
          if (!localRedDotInfo.uint32_last_time.has()) {
            break label944;
          }
          i = localRedDotInfo.uint32_last_time.get();
          if (!QLog.isColorLevel()) {
            break label982;
          }
          QLog.i("TroopRedTouchHandler", 2, "TENCENT_DOCS_ASSISTANT  show redDot" + paramArrayOfByte.bool_display_reddot.get());
          localException.a(localRedDotInfo, paramArrayOfByte);
          localException.a(paramArrayOfByte);
          a(paramQQAppInterface, paramArrayOfByte, i, false);
          return null;
          if (TroopRedTouchConfigure.c(paramArrayOfByte.uint32_appid.get())) {
            break label1034;
          }
        }
        localObject2 = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        if (!TroopRedTouchConfigure.b(paramArrayOfByte.uint32_appid.get())) {
          break label886;
        }
        if (!paramArrayOfByte.bool_display_reddot.get()) {
          break label774;
        }
        paramQQAppInterface = (StoryConfigManager)SuperManager.a(10);
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l2 = paramQQAppInterface.a();
        if (l1 >= l2) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1034;
        }
        QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "故事红点下发到达时间：" + l1 + "小于最近更新刷新时间：" + l2 + TroopRedTouchManager.a(paramArrayOfByte));
        return null;
        SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo() return %s", paramQQAppInterface);
        return paramQQAppInterface;
        label622:
        i = 0;
      }
      label886:
      localException.a(paramArrayOfByte);
    }
    label774:
    label944:
    for (paramQQAppInterface = paramArrayOfByte;; paramQQAppInterface = null) {
      break;
    }
    label1034:
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new TroopRedTouchHandler.4(paramQQAppInterface, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramQQAppInterface == null) || (paramRedDotInfo == null)) {}
    TroopRedTouchManager localTroopRedTouchManager;
    do
    {
      return;
      localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    } while ((localTroopRedTouchManager == null) || (paramRedDotInfo == null));
    int i = paramRedDotInfo.uint32_appid.get();
    if ((i != 56) && (i != 61))
    {
      paramRedDotInfo.bool_display_reddot.set(false);
      paramRedDotInfo.uint32_number.set(0);
      localTroopRedTouchManager.a(paramRedDotInfo);
    }
    paramQQAppInterface = (TroopRedTouchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    paramQQAppInterface.a(paramRedDotInfo);
    paramQQAppInterface.a(paramRedDotInfo.uint32_appid.get());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    label79:
    RecentUserProxy localRecentUserProxy;
    if ((paramQQAppInterface != null) && (paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.has()))
    {
      int j = paramRedDotInfo.uint32_appid.get();
      if (!paramRedDotInfo.uint32_number.has()) {
        break label183;
      }
      i = paramRedDotInfo.uint32_number.get();
      if (j == 46)
      {
        if ((!paramRedDotInfo.uint32_last_time.has()) || (paramRedDotInfo.uint32_last_time.get() == paramInt)) {
          break label189;
        }
        paramInt = 1;
        localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
        if (localRecentUserProxy.b(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004) == null) {
          break label194;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopRedTouchHandler", 2, " hasRecentUser " + bool + " isClicked " + paramBoolean + " redDotInfo.bool_display_reddot" + paramRedDotInfo.bool_display_reddot.get());
      }
      if ((bool) || (paramRedDotInfo.bool_display_reddot.get()) || (paramBoolean)) {
        break label200;
      }
      return;
      label183:
      i = 0;
      break;
      label189:
      paramInt = 0;
      break label79;
      label194:
      bool = false;
    }
    label200:
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004);
    if ((i > 0) && ((paramRedDotInfo.bool_display_reddot.get()) || (paramBoolean))) {
      if (!paramRedDotInfo.uint32_last_time.has()) {
        break label309;
      }
    }
    label309:
    for (long l = paramRedDotInfo.uint32_last_time.get();; l = NetConnInfoCenter.getServerTimeMillis() / 1000L)
    {
      localRecentUser.lastmsgtime = l;
      localRecentUser.msgType = 0;
      localRecentUser.displayName = paramQQAppInterface.getApp().getString(2131719867);
      if (paramInt != 0) {
        localRecentUserProxy.b(localRecentUser);
      }
      paramQQAppInterface.getMessageFacade().a(localRecentUser);
      paramQQAppInterface.refreshAppBadge();
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = (TroopRedTouchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRedTouchHandler", 2, "AfterSyncMsg doAfterLogin, getRedPointInfo");
      }
      paramQQAppInterface.a(paramBoolean);
      paramQQAppInterface.a();
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, List<Integer> paramList, byte[] paramArrayOfByte)
  {
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        a(paramQQAppInterface, 120L);
        return false;
      }
      paramArrayOfByte = new oidb_0x791.RspBody();
      paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramArrayOfByte = (oidb_0x791.GetRedDotRes)paramArrayOfByte.msg_get_reddot_res.get();
      if (paramArrayOfByte != null)
      {
        a(paramQQAppInterface, paramArrayOfByte.uint32_interval.get());
        boolean bool = ((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(paramList, paramArrayOfByte);
        return bool;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "RedTouchExManager_GetTime", 0);
      long l1 = ((SharedPreferences)localObject1).getLong("last_get_time", 0L);
      long l2 = ((SharedPreferences)localObject1).getLong("interval_time", 0L);
      long l3 = Math.abs(System.currentTimeMillis() / 1000L - l1);
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopRedTouchHandler", 4, "getRedPointInfo() start getRedPointInfoAsync,last_get_time:" + l1 + " |detal(current_time - last_get_time):" + l3 + " |interval_time:" + l2);
      }
      if (l3 < l2) {
        return;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopRedTouchHandler", 4, "getRedPointInfo() start");
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(Integer.valueOf(8));
    ((List)localObject1).add(Integer.valueOf(11));
    ((List)localObject1).add(Integer.valueOf(52));
    ((List)localObject1).add(Integer.valueOf(21));
    ((List)localObject1).add(Integer.valueOf(35));
    ((List)localObject1).add(Integer.valueOf(37));
    ((List)localObject1).add(Integer.valueOf(65));
    if (TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      ((List)localObject1).add(Integer.valueOf(46));
    }
    Object localObject3 = new oidb_0x791.GetRedDotOpt();
    ((oidb_0x791.GetRedDotOpt)localObject3).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((oidb_0x791.GetRedDotOpt)localObject3).rpt_uint32_appid.addAll((Collection)localObject1);
    Object localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_get_reddot.set((MessageMicro)localObject3);
    localObject3 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).setWithouLogin(true);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
    ((NewIntent)localObject2).setObserver(new TroopRedTouchHandler.2(this, (List)localObject1));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void a(int paramInt)
  {
    String str;
    if (paramInt == 60)
    {
      a(60, false);
      str = "7719.771901";
    }
    for (;;)
    {
      if (str.length() <= 0) {}
      RedTouchManager localRedTouchManager;
      do
      {
        return;
        if (paramInt == 59)
        {
          a(59, false);
          str = "7719.771903";
          break;
        }
        if (paramInt == 38)
        {
          str = "7719.771904";
          break;
        }
        if ((paramInt == 53) || (paramInt == 54))
        {
          str = "7719.771901";
          break;
        }
        if (paramInt == 70)
        {
          a(70, false);
          str = "7719.771901";
          break;
        }
        if (paramInt != 42) {
          break label148;
        }
        str = "7719.771901";
        break;
        localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        localRedTouchManager.b(str);
      } while (localRedTouchManager.a(7719) == null);
      localRedTouchManager.a(7719, str);
      return;
      label148:
      str = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "clearStoryMessageRedPoint");
    }
    qqstory_710_message.ReqClearMessage localReqClearMessage = new qqstory_710_message.ReqClearMessage();
    localReqClearMessage.start_time.set(paramInt1);
    localReqClearMessage.source.set(paramInt2);
    localReqClearMessage.version_ctrl.set(775);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", StoryApi.a("StorySvc.clr_710_message_list"));
    localNewIntent.putExtra("data", localReqClearMessage.toByteArray());
    localNewIntent.setObserver(new TroopRedTouchHandler.6(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(paramInt, false);
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_number.has()) && (localRedDotInfo.uint32_number.get() > 0))
      {
        localRedDotInfo.uint32_number.set(0);
        ((TroopRedTouchManager)localObject).a(localRedDotInfo);
        localObject = new oidb_0x791.RedDotInfo();
        ((oidb_0x791.RedDotInfo)localObject).uint32_appid.set(paramInt);
        if (localRedDotInfo.uint32_last_time.has()) {
          ((oidb_0x791.RedDotInfo)localObject).uint32_last_time.set(localRedDotInfo.uint32_last_time.get());
        }
        a(paramInt, false, 0, true, (oidb_0x791.RedDotInfo)localObject, true, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, oidb_0x791.RedDotInfo paramRedDotInfo, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())));
    ((oidb_0x791.SetRedDotOpt)localObject1).rpt_uint64_uin.set((List)localObject2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_clear.set(paramBoolean1);
    if (paramInt2 >= 0) {
      ((oidb_0x791.SetRedDotOpt)localObject1).uint32_total_number.set(paramInt2);
    }
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_keep_unchanged.set(paramBoolean2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(paramBoolean3);
    if (paramRedDotInfo != null)
    {
      if (paramRedDotInfo.bool_display_reddot.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).bool_display_reddot.set(paramRedDotInfo.bool_display_reddot.get());
      }
      if (paramRedDotInfo.uint32_number.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).int32_number.set(paramRedDotInfo.uint32_number.get());
      }
      if (paramRedDotInfo.str_custom_buffer.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).str_custom_buffer.set(paramRedDotInfo.str_custom_buffer.get());
      }
      if (paramRedDotInfo.str_face_url.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).str_face_url.set(paramRedDotInfo.str_face_url.get());
      }
      if (paramRedDotInfo.uint32_expire_time.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).uint32_expire_time.set(paramRedDotInfo.uint32_expire_time.get());
      }
      if (paramRedDotInfo.uint64_cmd_uin.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(paramRedDotInfo.uint64_cmd_uin.get());
      }
      if (paramRedDotInfo.uint32_reason.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).uint32_reason.set(paramRedDotInfo.uint32_reason.get());
      }
      if (paramRedDotInfo.uint32_last_time.has()) {
        ((oidb_0x791.SetRedDotOpt)localObject1).uint32_last_time.set(paramRedDotInfo.uint32_last_time.get());
      }
    }
    paramRedDotInfo = new oidb_0x791.ReqBody();
    paramRedDotInfo.msg_set_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    localObject2 = ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command;
    if (paramBoolean4) {}
    for (paramInt2 = 2887;; paramInt2 = 1937)
    {
      ((PBUInt32Field)localObject2).set(paramInt2);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramInt1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramRedDotInfo.toByteArray()));
      paramRedDotInfo = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
      paramRedDotInfo.putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramInt1));
      paramRedDotInfo.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      paramRedDotInfo.setObserver(new TroopRedTouchHandler.7(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRedDotInfo);
      return;
    }
  }
  
  public void a(TroopRedTouchManager paramTroopRedTouchManager, int paramInt)
  {
    paramTroopRedTouchManager = paramTroopRedTouchManager.a(paramInt);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopRedTouchManager);
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())));
    ((oidb_0x791.SetRedDotOpt)localObject1).rpt_uint64_uin.set((List)localObject2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_clear.set(true);
    if (paramRedDotInfo.uint32_appid.get() == 46) {
      ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(true);
    }
    for (;;)
    {
      localObject2 = new oidb_0x791.ReqBody();
      ((oidb_0x791.ReqBody)localObject2).msg_set_reddot.set((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramRedDotInfo.uint32_appid.get());
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramRedDotInfo.uint32_appid.get()));
      ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((NewIntent)localObject2).setObserver(new TroopRedTouchHandler.3(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo<requestedRedPoint:" + this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Boolean))
    {
      ThreadManager.post(new TroopRedTouchHandler.1(this), 5, null, true);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, true);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GetRedPointExObserver.class;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler);
    }
    this.jdField_a_of_type_Int = 0;
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler
 * JD-Core Version:    0.7.0.1
 */