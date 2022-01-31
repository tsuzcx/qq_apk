package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqClearMessage;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kmg;
import kmh;
import kmi;
import kmj;
import kmk;
import kml;
import kmm;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
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
  public int a;
  protected TroopRedTouchHandler.NetInfoHandler a;
  protected BusinessObserver a;
  
  public TroopRedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new kmk(this);
    this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler = new TroopRedTouchHandler.NetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static oidb_0x791.RedDotInfo a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    int j = 0;
    if ((paramArrayOfByte != null) && (paramQQAppInterface != null))
    {
      Object localObject;
      try
      {
        localObject = new Submsgtype0x69();
        ((Submsgtype0x69)localObject).mergeFrom(paramArrayOfByte);
        if (((Submsgtype0x69)localObject).bool_test_env.get() != PushServlet.a) {
          return null;
        }
        paramArrayOfByte = new oidb_0x791.RedDotInfo();
        paramArrayOfByte.uint32_appid.set(((Submsgtype0x69)localObject).uint32_appid.get());
        paramArrayOfByte.bool_display_reddot.set(((Submsgtype0x69)localObject).bool_display_reddot.get());
        paramArrayOfByte.uint32_number.set(((Submsgtype0x69)localObject).uint32_number.get());
        paramArrayOfByte.uint32_reason.set(((Submsgtype0x69)localObject).uint32_reason.get());
        paramArrayOfByte.uint32_last_time.set(((Submsgtype0x69)localObject).uint32_last_time.get());
        paramArrayOfByte.uint64_cmd_uin.set(((Submsgtype0x69)localObject).uint64_cmd_uin.get());
        paramArrayOfByte.str_face_url.set(((Submsgtype0x69)localObject).bytes_face_url.get());
        paramArrayOfByte.str_custom_buffer.set(((Submsgtype0x69)localObject).bytes_custom_buffer.get());
        paramArrayOfByte.uint32_expire_time.set(((Submsgtype0x69)localObject).uint32_expire_time.get());
        paramArrayOfByte.uint32_cmd_uin_type.set(((Submsgtype0x69)localObject).uint32_cmd_uin_type.get());
        paramArrayOfByte.uint32_report_type.set(((Submsgtype0x69)localObject).uint32_report_type.get());
        if (QLog.isColorLevel()) {
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "parsePushRedPointInfo:" + TroopRedTouchManager.a(paramArrayOfByte));
        }
        localObject = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
        if (!TroopRedTouchConfigure.b(paramArrayOfByte.uint32_appid.get())) {
          break label612;
        }
        if (!paramArrayOfByte.bool_display_reddot.get()) {
          break label502;
        }
        paramQQAppInterface = (StoryConfigManager)SuperManager.a(10);
        long l1 = NetConnInfoCenter.getServerTimeMillis();
        long l2 = paramQQAppInterface.a();
        if (l1 < l2)
        {
          if (!QLog.isColorLevel()) {
            break label718;
          }
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "故事红点下发到达时间：" + l1 + "小于最近更新刷新时间：" + l2 + TroopRedTouchManager.a(paramArrayOfByte));
          return null;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      paramQQAppInterface = ((TroopRedTouchManager)localObject).a();
      int i = TroopRedTouchConfigure.a(paramArrayOfByte, paramQQAppInterface);
      if (i < 0)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "comparePriority:比上一个红点优先级低，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
          return null;
        }
      }
      else
      {
        if ((i == 0) && (paramArrayOfByte.uint32_last_time.get() < paramQQAppInterface.uint32_last_time.get()))
        {
          if (!QLog.isColorLevel()) {
            break label718;
          }
          QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "当前红点比上一个红点旧，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
          return null;
          label502:
          paramQQAppInterface = ((TroopRedTouchManager)localObject).a();
          if ((paramQQAppInterface == null) || (paramQQAppInterface.uint64_cmd_uin.get() != paramArrayOfByte.uint64_cmd_uin.get()) || (paramQQAppInterface.uint32_cmd_uin_type.get() != paramArrayOfByte.uint32_cmd_uin_type.get()) || (paramQQAppInterface.uint32_last_time.get() != paramArrayOfByte.uint32_last_time.get()))
          {
            if (!QLog.isColorLevel()) {
              break label718;
            }
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "故事的撤回红点需要判断uin和lasttime，强校验，和上一个不一致的话直接返回，不处理，current：" + TroopRedTouchManager.a(paramArrayOfByte) + "|lastRedPoint:" + TroopRedTouchManager.a(paramQQAppInterface));
            return null;
            label612:
            if (46 == paramArrayOfByte.uint32_appid.get())
            {
              if (!TeamWorkUtils.a(paramQQAppInterface)) {
                break label718;
              }
              oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(46, false);
              i = j;
              if (localRedDotInfo != null)
              {
                i = j;
                if (localRedDotInfo.uint32_last_time.has()) {
                  i = localRedDotInfo.uint32_last_time.get();
                }
              }
              ((TroopRedTouchManager)localObject).a(paramArrayOfByte);
              a(paramQQAppInterface, paramArrayOfByte, i);
              return null;
            }
          }
        }
        if (TroopRedTouchConfigure.c(paramArrayOfByte.uint32_appid.get())) {
          ((TroopRedTouchManager)localObject).a(true);
        }
        ((TroopRedTouchManager)localObject).a(paramArrayOfByte);
      }
    }
    else
    {
      for (paramQQAppInterface = paramArrayOfByte;; paramQQAppInterface = null) {
        return paramQQAppInterface;
      }
    }
    label718:
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new kmj(paramQQAppInterface, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramQQAppInterface == null) || (paramRedDotInfo == null)) {}
    TroopRedTouchManager localTroopRedTouchManager;
    do
    {
      return;
      localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(69);
    } while ((localTroopRedTouchManager == null) || (paramRedDotInfo == null));
    paramRedDotInfo.bool_display_reddot.set(false);
    paramRedDotInfo.uint32_number.set(0);
    localTroopRedTouchManager.a(paramRedDotInfo);
    ((TroopRedTouchHandler)paramQQAppInterface.a(43)).a(paramRedDotInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo, int paramInt)
  {
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    if ((paramQQAppInterface != null) && (paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.has()) && (paramRedDotInfo.uint32_appid.get() == 46))
    {
      if ((!paramRedDotInfo.uint32_last_time.has()) || (paramRedDotInfo.uint32_last_time.get() == paramInt)) {
        break label146;
      }
      paramInt = 1;
      localRecentUserProxy = paramQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.aH, 6004);
      if (!paramRedDotInfo.uint32_last_time.has()) {
        break label151;
      }
    }
    label146:
    label151:
    for (long l = paramRedDotInfo.uint32_last_time.get();; l = NetConnInfoCenter.getServerTimeMillis() / 1000L)
    {
      localRecentUser.lastmsgtime = l;
      localRecentUser.msgType = 0;
      localRecentUser.displayName = paramQQAppInterface.getApp().getString(2131439227);
      if (paramInt != 0) {
        localRecentUserProxy.a(localRecentUser);
      }
      paramQQAppInterface.a().a(localRecentUser);
      paramQQAppInterface.C();
      return;
      paramInt = 0;
      break;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, List paramList, byte[] paramArrayOfByte)
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
        boolean bool = ((TroopRedTouchManager)paramQQAppInterface.getManager(69)).a(paramList, paramArrayOfByte);
        return bool;
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
    if (this.jdField_a_of_type_Int != 0)
    {
      localObject1 = this.b.getApplication().getSharedPreferences(this.b.getCurrentAccountUin() + "RedTouchExManager_GetTime", 0);
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
    ((List)localObject1).add(Integer.valueOf(1));
    ((List)localObject1).add(Integer.valueOf(6));
    ((List)localObject1).add(Integer.valueOf(7));
    ((List)localObject1).add(Integer.valueOf(8));
    ((List)localObject1).add(Integer.valueOf(11));
    ((List)localObject1).add(Integer.valueOf(49));
    ((List)localObject1).add(Integer.valueOf(28));
    ((List)localObject1).add(Integer.valueOf(48));
    ((List)localObject1).add(Integer.valueOf(21));
    ((List)localObject1).add(Integer.valueOf(35));
    ((List)localObject1).add(Integer.valueOf(23));
    ((List)localObject1).add(Integer.valueOf(24));
    ((List)localObject1).add(Integer.valueOf(25));
    ((List)localObject1).add(Integer.valueOf(26));
    ((List)localObject1).add(Integer.valueOf(27));
    ((List)localObject1).add(Integer.valueOf(29));
    ((List)localObject1).add(Integer.valueOf(30));
    ((List)localObject1).add(Integer.valueOf(37));
    ((List)localObject1).add(Integer.valueOf(38));
    ((List)localObject1).add(Integer.valueOf(39));
    ((List)localObject1).add(Integer.valueOf(40));
    ((List)localObject1).add(Integer.valueOf(41));
    ((List)localObject1).add(Integer.valueOf(42));
    if (TeamWorkUtils.a(this.b)) {
      ((List)localObject1).add(Integer.valueOf(46));
    }
    Object localObject3 = new oidb_0x791.GetRedDotOpt();
    ((oidb_0x791.GetRedDotOpt)localObject3).uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    ((oidb_0x791.GetRedDotOpt)localObject3).rpt_uint32_appid.addAll((Collection)localObject1);
    Object localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_get_reddot.set((MessageMicro)localObject3);
    localObject3 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.b.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).setWithouLogin(true);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
    ((NewIntent)localObject2).setObserver(new kmh(this, (List)localObject1));
    this.b.startServlet((NewIntent)localObject2);
  }
  
  protected Class a()
  {
    return GetRedPointExObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler$NetInfoHandler);
    }
    this.jdField_a_of_type_Int = 0;
    super.a();
  }
  
  public void a(int paramInt)
  {
    Object localObject = (TroopRedTouchManager)this.b.getManager(69);
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
        a(paramInt, false, 0, true, (oidb_0x791.RedDotInfo)localObject, true, true);
      }
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
    localReqClearMessage.version_ctrl.set(760);
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", StoryApi.a("StorySvc.clr_710_message_list"));
    localNewIntent.putExtra("data", localReqClearMessage.toByteArray());
    localNewIntent.setObserver(new kml(this, paramInt2));
    this.b.startServlet(localNewIntent);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, oidb_0x791.RedDotInfo paramRedDotInfo, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.b.getCurrentAccountUin())));
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
      paramRedDotInfo = new NewIntent(this.b.getApplication(), ProtoServlet.class);
      paramRedDotInfo.putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramInt1));
      paramRedDotInfo.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      paramRedDotInfo.setObserver(new kmm(this));
      this.b.startServlet(paramRedDotInfo);
      return;
    }
  }
  
  public void a(TroopRedTouchManager paramTroopRedTouchManager, int paramInt)
  {
    paramTroopRedTouchManager = paramTroopRedTouchManager.a(paramInt);
    a(this.b, paramTroopRedTouchManager);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.b.getCurrentAccountUin())));
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
      localObject2 = new NewIntent(this.b.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramRedDotInfo.uint32_appid.get()));
      ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((NewIntent)localObject2).setObserver(new kmi(this));
      this.b.startServlet((NewIntent)localObject2);
      return;
      ((oidb_0x791.SetRedDotOpt)localObject1).bool_push_to_client.set(false);
    }
  }
  
  public boolean a()
  {
    QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo<requestedRedPoint:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int != 1)
    {
      ThreadManager.post(new kmg(this), 5, null, true);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void c()
  {
    this.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler
 * JD-Core Version:    0.7.0.1
 */