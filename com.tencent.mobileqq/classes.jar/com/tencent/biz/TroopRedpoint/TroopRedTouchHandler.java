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
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
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
  protected TroopRedTouchHandler.NetInfoHandler b;
  protected boolean c = false;
  protected BusinessObserver d = new TroopRedTouchHandler.5(this);
  private QQAppInterface e;
  
  public TroopRedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.e = paramQQAppInterface;
    this.b = new TroopRedTouchHandler.NetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.b);
    this.a = 0;
  }
  
  public static oidb_0x791.RedDotInfo a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramQQAppInterface == null) {}
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new Submsgtype0x69();
        ((Submsgtype0x69)localObject3).mergeFrom(paramArrayOfByte);
        boolean bool = ((Submsgtype0x69)localObject3).bool_test_env.get();
        if (bool != PushServlet.a)
        {
          SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, sIsTestEnv = %b", Boolean.valueOf(bool), Boolean.valueOf(PushServlet.a));
          if (bool != QQStoryNetReqUtils.a())
          {
            SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, QQStoryNetReqUtils.isDevEnv() = %b", Boolean.valueOf(bool), Boolean.valueOf(QQStoryNetReqUtils.a()));
            return null;
          }
        }
        localObject1 = new oidb_0x791.RedDotInfo();
        ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.set(((Submsgtype0x69)localObject3).uint32_appid.get());
        ((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.set(((Submsgtype0x69)localObject3).bool_display_reddot.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_number.set(((Submsgtype0x69)localObject3).uint32_number.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_reason.set(((Submsgtype0x69)localObject3).uint32_reason.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.set(((Submsgtype0x69)localObject3).uint32_last_time.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.set(((Submsgtype0x69)localObject3).uint64_cmd_uin.get());
        ((oidb_0x791.RedDotInfo)localObject1).str_face_url.set(((Submsgtype0x69)localObject3).bytes_face_url.get());
        ((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.set(((Submsgtype0x69)localObject3).bytes_custom_buffer.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_expire_time.set(((Submsgtype0x69)localObject3).uint32_expire_time.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_cmd_uin_type.set(((Submsgtype0x69)localObject3).uint32_cmd_uin_type.get());
        ((oidb_0x791.RedDotInfo)localObject1).uint32_report_type.set(((Submsgtype0x69)localObject3).uint32_report_type.get());
        bool = QLog.isColorLevel();
        if (bool)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parsePushRedPointInfo:");
          paramArrayOfByte.append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, paramArrayOfByte.toString());
        }
        i = ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get();
        if (i == 38) {
          try
          {
            paramArrayOfByte = new JSONObject(((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get().toStringUtf8());
            if (paramArrayOfByte.optInt("official_topic") != 1) {
              break label1152;
            }
            i = 1;
            int j = paramArrayOfByte.optInt("red_content_type");
            int k = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
            if (i != 0)
            {
              new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("push_red_send").a(new String[] { String.valueOf(k), "0", String.valueOf(j), "0" }).a();
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("retport push_red_send d1 = ");
              paramArrayOfByte.append(k);
              paramArrayOfByte.append(" d3 = ");
              paramArrayOfByte.append(j);
              Log.i("redreport", paramArrayOfByte.toString());
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
        }
        paramArrayOfByte = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        if (TroopRedTouchConfigure.b(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()))
        {
          bool = ((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get();
          if (bool)
          {
            paramQQAppInterface = (StoryConfigManager)SuperManager.a(10);
            long l1 = NetConnInfoCenter.getServerTimeMillis();
            long l2 = paramQQAppInterface.j();
            if (l1 < l2)
            {
              if (!QLog.isColorLevel()) {
                break label1157;
              }
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("故事红点下发到达时间：");
              paramQQAppInterface.append(l1);
              paramQQAppInterface.append("小于最近更新刷新时间：");
              paramQQAppInterface.append(l2);
              paramQQAppInterface.append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, paramQQAppInterface.toString());
              return null;
            }
            paramQQAppInterface = paramArrayOfByte.q();
            i = TroopRedTouchConfigure.a((oidb_0x791.RedDotInfo)localObject1, paramQQAppInterface);
            if (i < 0)
            {
              if (!QLog.isColorLevel()) {
                break label1159;
              }
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("comparePriority:比上一个红点优先级低，current：");
              paramArrayOfByte.append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
              paramArrayOfByte.append("|lastRedPoint:");
              paramArrayOfByte.append(TroopRedTouchManager.b(paramQQAppInterface));
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, paramArrayOfByte.toString());
              return null;
            }
            if ((i == 0) && (((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get() < paramQQAppInterface.uint32_last_time.get()))
            {
              if (!QLog.isColorLevel()) {
                break label1161;
              }
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("当前红点比上一个红点旧，current：");
              paramArrayOfByte.append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
              paramArrayOfByte.append("|lastRedPoint:");
              paramArrayOfByte.append(TroopRedTouchManager.b(paramQQAppInterface));
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, paramArrayOfByte.toString());
              return null;
            }
          }
          else
          {
            paramQQAppInterface = paramArrayOfByte.q();
            if ((paramQQAppInterface == null) || (paramQQAppInterface.uint64_cmd_uin.get() != ((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get()) || (paramQQAppInterface.uint32_cmd_uin_type.get() != ((oidb_0x791.RedDotInfo)localObject1).uint32_cmd_uin_type.get()) || (paramQQAppInterface.uint32_last_time.get() != ((oidb_0x791.RedDotInfo)localObject1).uint32_last_time.get()))
            {
              if (!QLog.isColorLevel()) {
                break label1163;
              }
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("故事的撤回红点需要判断uin和lasttime，强校验，和上一个不一致的话直接返回，不处理，current：");
              paramArrayOfByte.append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
              paramArrayOfByte.append("|lastRedPoint:");
              paramArrayOfByte.append(TroopRedTouchManager.b(paramQQAppInterface));
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, paramArrayOfByte.toString());
              return null;
            }
          }
        }
        else if (46 == ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get())
        {
          if (!((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(paramQQAppInterface)) {
            break;
          }
          localObject3 = paramArrayOfByte.a(46, false);
          if ((localObject3 == null) || (!((oidb_0x791.RedDotInfo)localObject3).uint32_last_time.has())) {
            break label1165;
          }
          i = ((oidb_0x791.RedDotInfo)localObject3).uint32_last_time.get();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("TENCENT_DOCS_ASSISTANT  show redDot");
            localStringBuilder.append(((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get());
            QLog.i("TroopRedTouchHandler", 2, localStringBuilder.toString());
          }
          paramArrayOfByte.a((oidb_0x791.RedDotInfo)localObject3, (oidb_0x791.RedDotInfo)localObject1);
          paramArrayOfByte.a((oidb_0x791.RedDotInfo)localObject1);
          a(paramQQAppInterface, (oidb_0x791.RedDotInfo)localObject1, i, false);
          return null;
        }
        if (TroopRedTouchConfigure.c(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get())) {
          return null;
        }
        paramArrayOfByte.a((oidb_0x791.RedDotInfo)localObject1);
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        localObject1 = localObject2;
      }
      SLog.a("TroopRedTouchHandler", "parsePushRedPointInfo() return %s", localObject1);
      return localObject1;
      label1152:
      int i = 0;
      continue;
      label1157:
      return null;
      label1159:
      return null;
      label1161:
      return null;
      label1163:
      return null;
      label1165:
      i = 0;
    }
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
    if (paramQQAppInterface != null)
    {
      if (paramRedDotInfo == null) {
        return;
      }
      TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      if ((localTroopRedTouchManager != null) && (paramRedDotInfo != null))
      {
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
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.has()))
    {
      int j = paramRedDotInfo.uint32_appid.get();
      int i;
      if (paramRedDotInfo.uint32_number.has()) {
        i = paramRedDotInfo.uint32_number.get();
      } else {
        i = 0;
      }
      if (j == 46)
      {
        boolean bool2 = paramRedDotInfo.uint32_last_time.has();
        boolean bool1 = true;
        if ((bool2) && (paramRedDotInfo.uint32_last_time.get() != paramInt)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
        if (localRecentUserProxy.c(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004) == null) {
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" hasRecentUser ");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(" isClicked ");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(" redDotInfo.bool_display_reddot");
          ((StringBuilder)localObject).append(paramRedDotInfo.bool_display_reddot.get());
          QLog.i("TroopRedTouchHandler", 2, ((StringBuilder)localObject).toString());
        }
        if ((!bool1) && (!paramRedDotInfo.bool_display_reddot.get()) && (!paramBoolean)) {
          return;
        }
        Object localObject = localRecentUserProxy.b(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004);
        if ((i > 0) && ((paramRedDotInfo.bool_display_reddot.get()) || (paramBoolean)))
        {
          long l;
          if (paramRedDotInfo.uint32_last_time.has()) {
            l = paramRedDotInfo.uint32_last_time.get();
          } else {
            l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          }
          ((RecentUser)localObject).lastmsgtime = l;
        }
        ((RecentUser)localObject).msgType = 0;
        ((RecentUser)localObject).displayName = paramQQAppInterface.getApp().getString(2131917162);
        if (paramInt != 0) {
          localRecentUserProxy.b((RecentUser)localObject);
        }
        paramQQAppInterface.getMessageFacade().a(localObject);
        if (paramQQAppInterface.isLogin()) {
          ((IAppBadgeService)paramQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
      }
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
      if ((localOIDBSSOPkg.uint32_result.has()) && (localOIDBSSOPkg.uint32_result.get() == 0) && (localOIDBSSOPkg.bytes_bodybuffer.has()) && (localOIDBSSOPkg.bytes_bodybuffer.get() != null))
      {
        paramArrayOfByte = new oidb_0x791.RspBody();
        paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramArrayOfByte = (oidb_0x791.GetRedDotRes)paramArrayOfByte.msg_get_reddot_res.get();
        if (paramArrayOfByte != null)
        {
          a(paramQQAppInterface, paramArrayOfByte.uint32_interval.get());
          return ((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(paramList, paramArrayOfByte);
        }
      }
      else
      {
        a(paramQQAppInterface, 120L);
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  private void d()
  {
    if (this.a != 0)
    {
      localObject1 = this.e.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("RedTouchExManager_GetTime");
      localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      long l1 = ((SharedPreferences)localObject1).getLong("last_get_time", 0L);
      long l2 = ((SharedPreferences)localObject1).getLong("interval_time", 0L);
      long l3 = Math.abs(System.currentTimeMillis() / 1000L - l1);
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getRedPointInfo() start getRedPointInfoAsync,last_get_time:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(" |detal(current_time - last_get_time):");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(" |interval_time:");
        ((StringBuilder)localObject1).append(l2);
        QLog.d("TroopRedTouchHandler", 4, ((StringBuilder)localObject1).toString());
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
    if (((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(this.e)) {
      ((List)localObject1).add(Integer.valueOf(46));
    }
    Object localObject3 = new oidb_0x791.GetRedDotOpt();
    ((oidb_0x791.GetRedDotOpt)localObject3).uint64_uin.set(Long.parseLong(this.e.getCurrentAccountUin()));
    ((oidb_0x791.GetRedDotOpt)localObject3).rpt_uint32_appid.addAll((Collection)localObject1);
    Object localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_get_reddot.set((MessageMicro)localObject3);
    localObject3 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.e.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).setWithouLogin(true);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
    ((NewIntent)localObject2).setObserver(new TroopRedTouchHandler.2(this, (List)localObject1));
    this.e.startServlet((NewIntent)localObject2);
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = "7719.771901";
    Object localObject1;
    if (paramInt == 60)
    {
      a(60, false);
      localObject1 = localObject2;
    }
    else
    {
      if (paramInt == 59)
      {
        a(59, false);
        localObject1 = "7719.771903";
      }
      for (;;)
      {
        break;
        if (paramInt == 38)
        {
          localObject1 = "7719.771904";
        }
        else
        {
          localObject1 = localObject2;
          if (paramInt != 53) {
            if (paramInt == 54)
            {
              localObject1 = localObject2;
            }
            else if (paramInt == 70)
            {
              a(70, false);
              localObject1 = localObject2;
            }
            else if (paramInt == 42)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = "";
            }
          }
        }
      }
    }
    if (((String)localObject1).length() <= 0) {
      return;
    }
    localObject2 = (IRedTouchManager)this.e.getRuntimeService(IRedTouchManager.class, "");
    ((IRedTouchManager)localObject2).onRedTouchItemClick((String)localObject1);
    if (((IRedTouchManager)localObject2).getNumRedPathListByAppId(7719) == null) {
      return;
    }
    ((IRedTouchManager)localObject2).onReportNumRedPoint(7719, (String)localObject1);
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
    NewIntent localNewIntent = new NewIntent(this.e.getApplication(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", StoryApi.a("StorySvc.clr_710_message_list"));
    localNewIntent.putExtra("data", localReqClearMessage.toByteArray());
    localNewIntent.setObserver(new TroopRedTouchHandler.6(this));
    this.e.startServlet(localNewIntent);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (TroopRedTouchManager)this.e.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
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
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.e.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.e.getCurrentAccountUin())));
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
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_set_reddot.set((MessageMicro)localObject1);
    paramRedDotInfo = new oidb_sso.OIDBSSOPkg();
    localObject1 = paramRedDotInfo.uint32_command;
    if (paramBoolean4) {
      paramInt2 = 2887;
    } else {
      paramInt2 = 1937;
    }
    ((PBUInt32Field)localObject1).set(paramInt2);
    paramRedDotInfo.uint32_result.set(0);
    paramRedDotInfo.uint32_service_type.set(paramInt1);
    paramRedDotInfo.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject1 = new NewIntent(this.e.getApplication(), ProtoServlet.class);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OidbSvc.0x791_");
    ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
    ((NewIntent)localObject1).putExtra("cmd", ((StringBuilder)localObject2).toString());
    ((NewIntent)localObject1).putExtra("data", paramRedDotInfo.toByteArray());
    ((NewIntent)localObject1).setObserver(new TroopRedTouchHandler.7(this));
    this.e.startServlet((NewIntent)localObject1);
  }
  
  public void a(TroopRedTouchManager paramTroopRedTouchManager, int paramInt)
  {
    paramTroopRedTouchManager = paramTroopRedTouchManager.e(paramInt);
    a(this.e, paramTroopRedTouchManager);
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.e.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.e.getCurrentAccountUin())));
    ((oidb_0x791.SetRedDotOpt)localObject1).rpt_uint64_uin.set((List)localObject2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_clear.set(true);
    if (paramRedDotInfo.uint32_appid.get() == 46) {
      ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(true);
    } else {
      ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(false);
    }
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_set_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramRedDotInfo.uint32_appid.get());
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.e.getApplication(), ProtoServlet.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OidbSvc.0x791_");
    localStringBuilder.append(String.valueOf(paramRedDotInfo.uint32_appid.get()));
    ((NewIntent)localObject2).putExtra("cmd", localStringBuilder.toString());
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new TroopRedTouchHandler.3(this));
    this.e.startServlet((NewIntent)localObject2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRedPointInfo<requestedRedPoint:");
    localStringBuilder.append(this.a);
    QLog.d("TroopRedTouchHandler", 2, localStringBuilder.toString());
    if ((this.a != 1) && (this.c))
    {
      ThreadManager.post(new TroopRedTouchHandler.1(this), 5, null, true);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.e.addObserver(this.d);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void c()
  {
    this.e.removeObserver(this.d);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GetRedPointExObserver.class;
  }
  
  public void onDestroy()
  {
    TroopRedTouchHandler.NetInfoHandler localNetInfoHandler = this.b;
    if (localNetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(localNetInfoHandler);
    }
    this.a = 0;
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler
 * JD-Core Version:    0.7.0.1
 */