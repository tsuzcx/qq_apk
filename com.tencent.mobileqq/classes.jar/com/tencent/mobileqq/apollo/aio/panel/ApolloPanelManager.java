package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.Editable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloPanelManager
{
  public volatile int a = 0;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> b = new ConcurrentHashMap();
  public AtomicInteger c = new AtomicInteger(0);
  public String d = null;
  public int e = 0;
  public long f = 0L;
  public ApolloInfo g = null;
  public volatile boolean h = false;
  private WeakReference<AppInterface> i;
  private WeakReference<BaseChatPie> j;
  private WeakReference<ApolloPanelManager.PanelClickCallback> k;
  private boolean l = false;
  private ApolloInfo m = null;
  
  public ApolloPanelManager(AppInterface paramAppInterface)
  {
    this.i = new WeakReference(paramAppInterface);
  }
  
  private boolean a(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    AtTroopMemberSpan.a(paramBaseChatPie.Y.getEditableText(), localArrayList);
    if (paramApolloInfo.mAction.personNum == 1)
    {
      if ((localArrayList.size() == 1) && (0L != ((AtTroopMemberInfo)localArrayList.get(0)).uin) && (((AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
      {
        String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.Y.getText().toString());
        try
        {
          paramApolloInfo.mAction.atNickName = str.substring(0, ((AtTroopMemberInfo)localArrayList.get(0)).textLen);
          if (((AtTroopMemberInfo)localArrayList.get(0)).textLen >= paramBaseChatPie.Y.getText().length() - 1) {
            paramApolloInfo.mAction.inputText = "";
          } else {
            paramApolloInfo.mAction.inputText = str.substring(((AtTroopMemberInfo)localArrayList.get(0)).textLen);
          }
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("inputText err:");
          localStringBuilder.append(localException.getMessage());
          QLog.d("[cmshow]ApolloPanelManager", 2, localStringBuilder.toString());
          paramApolloInfo.mAction.inputText = "";
        }
        ApolloActionData localApolloActionData = paramApolloInfo.mAction;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((AtTroopMemberInfo)localArrayList.get(0)).uin);
        localStringBuilder.append("");
        localApolloActionData.peerUin = localStringBuilder.toString();
        paramBaseChatPie.Y.getText().clear();
        d(paramApolloInfo, paramBaseChatPie, paramSessionInfo);
        return false;
      }
      c(paramApolloInfo, paramBaseChatPie, paramSessionInfo);
      return true;
    }
    if (paramApolloInfo.mAction.personNum == 0)
    {
      paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.Y.getText().toString());
      paramBaseChatPie.Y.getText().clear();
    }
    return false;
  }
  
  private void b(ApolloInfo paramApolloInfo)
  {
    if ((a() != null) && (this.j.get() != null))
    {
      if (paramApolloInfo == null) {
        return;
      }
      Object localObject1 = (BaseChatPie)this.j.get();
      Object localObject3 = ((BaseChatPie)this.j.get()).aE();
      ((BaseChatPie)localObject1).aH = paramApolloInfo;
      if (((SessionInfo)localObject3).a == 3000) {
        n = 11;
      } else if (((SessionInfo)localObject3).a == 1) {
        n = 3;
      } else {
        n = 0;
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("troop_uin", ((SessionInfo)localObject3).b);
      ((Intent)localObject2).putExtra("param_from", n);
      if (((BaseChatPie)localObject1).aR() == 21) {
        ((Intent)localObject2).putExtra("param_troop_send_apollo_msg", true);
      }
      ((Intent)localObject2).putExtra("param_is_pop_up_style", true);
      ((Intent)localObject2).putExtra("param_troop_send_apollo_msg", true);
      RouteUtils.a(((BaseChatPie)localObject1).f, (Intent)localObject2, "/troop/memberlist/TroopMemberList", 6001);
      localObject1 = ((BaseChatPie)localObject1).d;
      localObject2 = ((SessionInfo)localObject3).b;
      int n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(((SessionInfo)localObject3).a);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramApolloInfo.mAction.actionId);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("655_");
      localStringBuilder.append(paramApolloInfo.mPackageId);
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "g_action_double_clk", (String)localObject2, -1, n, new String[] { localObject3, localStringBuilder.toString(), "1", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
  }
  
  private void b(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramApolloInfo.mAction.peerUin = paramSessionInfo.b;
    paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.Y.getText().toString());
  }
  
  private void c(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramApolloInfo.mAction.actionType == 5)
    {
      a(paramApolloInfo, paramBaseChatPie);
      return;
    }
    paramBaseChatPie.aH = paramApolloInfo;
    if (paramSessionInfo.a == 3000) {
      n = 11;
    } else if (paramSessionInfo.a == 1) {
      n = 3;
    } else {
      n = 0;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.b);
    ((Intent)localObject).putExtra("param_from", n);
    if (paramBaseChatPie.aR() == 21) {
      ((Intent)localObject).putExtra("param_troop_send_apollo_msg", true);
    }
    ((Intent)localObject).putExtra("param_is_pop_up_style", true);
    ((Intent)localObject).putExtra("param_troop_send_apollo_msg", true);
    RouteUtils.a(paramBaseChatPie.f, (Intent)localObject, "/troop/memberlist/TroopMemberList", 6001);
    paramBaseChatPie = paramBaseChatPie.d;
    localObject = paramSessionInfo.b;
    int n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramSessionInfo.a);
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("");
    paramSessionInfo.append(paramApolloInfo.mAction.actionId);
    paramSessionInfo = paramSessionInfo.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("655_");
    localStringBuilder.append(paramApolloInfo.mPackageId);
    VipUtils.a(paramBaseChatPie, "cmshow", "Apollo", "g_action_double_clk", (String)localObject, -1, n, new String[] { paramSessionInfo, localStringBuilder.toString(), "1", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  private void d(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int n;
    if (android.text.TextUtils.isEmpty(paramApolloInfo.mAction.inputText))
    {
      if (!android.text.TextUtils.isEmpty(paramApolloInfo.mActionText))
      {
        if (paramApolloInfo.mTextType == 0)
        {
          n = 6;
          break label104;
        }
        if (paramApolloInfo.mTextType == 1)
        {
          n = 7;
          break label104;
        }
      }
      n = 2;
    }
    else if (android.text.TextUtils.isEmpty(paramApolloInfo.mActionText))
    {
      n = 3;
    }
    else if (paramApolloInfo.mTextType == 0)
    {
      n = 4;
    }
    else if (paramApolloInfo.mTextType == 1)
    {
      n = 5;
    }
    else
    {
      n = 0;
    }
    label104:
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    String str1 = paramSessionInfo.b;
    int i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramSessionInfo.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramApolloInfo.mAction.actionId);
    String str2 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("655_");
    ((StringBuilder)localObject).append(paramApolloInfo.mPackageId);
    String str3 = ((StringBuilder)localObject).toString();
    localObject = "0";
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", str1, -1, i1, new String[] { str2, str3, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
    localQQAppInterface = paramBaseChatPie.d;
    str1 = paramSessionInfo.b;
    i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramSessionInfo.a);
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append("");
    paramBaseChatPie.append(paramApolloInfo.mAction.actionId);
    paramSessionInfo = paramBaseChatPie.toString();
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append("655_");
    paramBaseChatPie.append(paramApolloInfo.mPackageId);
    str2 = paramBaseChatPie.toString();
    if (android.text.TextUtils.isEmpty(paramApolloInfo.mActionText)) {
      paramBaseChatPie = (BaseChatPie)localObject;
    } else {
      paramBaseChatPie = paramApolloInfo.mActionText;
    }
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "g_action_double_sent", str1, n, i1, new String[] { paramSessionInfo, str2, paramBaseChatPie, paramApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  public AppInterface a()
  {
    WeakReference localWeakReference = this.i;
    if (localWeakReference == null) {
      return null;
    }
    return (AppInterface)localWeakReference.get();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = (ApolloPanelManager.PanelClickCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloPanelManager.PanelClickCallback)localObject).a(paramInt, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[onGetSlaveListFromSvr], ret:", Long.valueOf(paramLong), "resqData:", paramString1, ",reqData:", paramString2 });
    }
    if (0L != paramLong) {
      return;
    }
    for (;;)
    {
      int n;
      try
      {
        this.f = System.currentTimeMillis();
        n = new JSONObject(paramString2).optInt("actionId");
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "actionId:", Integer.valueOf(n), ",orgActionId:" });
        }
        paramString2 = a().getCurrentAccountUin();
        paramString1 = new JSONObject(paramString1);
        this.d = paramString1.toString();
        paramString1 = paramString1.getJSONObject("data");
        JSONArray localJSONArray = paramString1.getJSONArray("slaveInfoList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          n = 0;
          if (n < localJSONArray.length())
          {
            ApolloSlaveInfo localApolloSlaveInfo = (ApolloSlaveInfo)JSONUtils.a(localJSONArray.getJSONObject(n), ApolloSlaveInfo.class);
            if (localApolloSlaveInfo == null) {
              break label349;
            }
            this.b.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label349;
          }
        }
        this.e = paramString1.optInt("defaultActId");
        paramString1 = (ApolloSlaveInfo)this.b.get(Long.valueOf(Long.parseLong(paramString2)));
        this.c.set(paramString1.slaveTotal);
        if (paramString1.isCaptured != 1) {
          break label358;
        }
        bool = true;
        this.l = bool;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "my slave info", paramString1.toString() });
        }
        ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]ApolloPanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label349:
      n += 1;
      continue;
      label358:
      boolean bool = false;
    }
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, ApolloInfo paramApolloInfo)
  {
    if (!(paramBaseAIOContext instanceof AIOContext))
    {
      QLog.e("[cmshow]ApolloPanelManager", 1, "[sendActionMsg] error! param baseAIOContext is not instanceof AIOContext");
      return;
    }
    paramBaseAIOContext = ((AIOContext)paramBaseAIOContext).n();
    if ((paramApolloInfo != null) && (paramBaseAIOContext != null) && (paramBaseAIOContext.d != null) && (paramBaseAIOContext.Y != null))
    {
      if (paramBaseAIOContext.Y.getText() == null) {
        return;
      }
      b();
      QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramApolloInfo });
      SessionInfo localSessionInfo = paramBaseAIOContext.aE();
      paramApolloInfo.mAction.atNickName = "";
      paramApolloInfo.mAction.inputText = "";
      if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.a, 1)) {
        b(paramApolloInfo, paramBaseAIOContext, localSessionInfo);
      } else if ((CmShowAioMatcherImpl.judgeSupported(localSessionInfo.a, 2)) && (paramBaseAIOContext.f != null) && (a(paramApolloInfo, paramBaseAIOContext, localSessionInfo))) {
        return;
      }
      String str = paramBaseAIOContext.Y.getText().toString();
      if ((str != null) && (str.length() > 99))
      {
        ChatActivityUtils.a(paramBaseAIOContext.d.getApplication(), 2131916265, 1);
        return;
      }
      if ((localSessionInfo.a != 1) && (localSessionInfo.a != 3000)) {
        paramBaseAIOContext.Y.getText().clear();
      }
      if (paramBaseAIOContext.f != null) {
        paramBaseAIOContext.a(paramApolloInfo);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.d == null) {
        return;
      }
      this.m = paramApolloInfo;
      this.j = new WeakReference(paramBaseChatPie);
      this.h = true;
      ((ApolloExtensionHandler)paramBaseChatPie.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramBaseChatPie.d.getCurrentUin(), 262144, "get gold balance");
    }
  }
  
  public void a(ApolloPanelManager.PanelClickCallback paramPanelClickCallback)
  {
    this.k = new WeakReference(paramPanelClickCallback);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.g = paramApolloInfo;
    if ((System.currentTimeMillis() - this.f <= 120000L) && (paramApolloInfo != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.1(this, paramApolloInfo));
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if ((paramApolloInfo != null) && (paramApolloInfo.mAction != null))
        {
          paramApolloInfo = Integer.valueOf(paramApolloInfo.mAction.actionId);
          localJSONObject.put("actionId", paramApolloInfo);
          paramApolloInfo = new JSONArray();
          paramApolloInfo.put(Long.parseLong(a().getCurrentAccountUin()));
          localJSONObject.put("toUins", paramApolloInfo);
          ((ApolloExtensionHandler)a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), 7);
          return;
        }
      }
      catch (Throwable paramApolloInfo)
      {
        QLog.e("[cmshow]ApolloPanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramApolloInfo);
        return;
      }
      paramApolloInfo = null;
    }
  }
  
  public void a(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie)
  {
    this.j = new WeakReference(paramBaseChatPie);
    a(paramApolloInfo);
  }
  
  public void b()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = (ApolloPanelManager.PanelClickCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloPanelManager.PanelClickCallback)localObject).a();
      }
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
    {
      if (paramBaseChatPie.aE() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramApolloInfo });
      }
      SessionInfo localSessionInfo = paramBaseChatPie.aE();
      ApolloActionData localApolloActionData = paramApolloInfo.mAction;
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = localApolloActionData.actionId;
      localSpriteTaskParam.c = 0;
      localSpriteTaskParam.i = localSessionInfo.a;
      localSpriteTaskParam.g = 3;
      localSpriteTaskParam.h = -10000L;
      localSpriteTaskParam.m = 0;
      localSpriteTaskParam.n = 0.0F;
      boolean bool;
      if (paramApolloInfo.mTextType == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localSpriteTaskParam.q = bool;
      localSpriteTaskParam.o = paramApolloInfo.mActionText;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramApolloInfo = paramBaseChatPie.d.getCurrentUin();
      localSpriteTaskParam.j = String.valueOf(paramApolloInfo);
      if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.a, 1))
      {
        localSpriteTaskParam.k = localSessionInfo.b;
      }
      else if (localSpriteTaskParam.e != 0)
      {
        paramApolloInfo = ((FriendsManager)paramBaseChatPie.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramApolloInfo);
        int n;
        if ((paramApolloInfo != null) && (paramApolloInfo.gender != 1)) {
          n = 0;
        } else {
          n = 1;
        }
        if (n != 0) {
          paramApolloInfo = "-2";
        } else {
          paramApolloInfo = "-1";
        }
        localSpriteTaskParam.k = paramApolloInfo;
      }
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.c = 5;
        paramApolloInfo = (ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all");
        if ((paramApolloInfo != null) && (paramApolloInfo.getApolloPanelManager() != null))
        {
          localSpriteTaskParam.t = paramApolloInfo.getApolloPanelManager().d;
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.t });
          }
        }
      }
      paramApolloInfo = (ISpriteScriptManager)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramApolloInfo != null) {
        paramApolloInfo.getSpriteBridge().b(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.d, "cmshow", "Apollo", "action_preview_play", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(localSessionInfo.a), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
    }
  }
  
  public void c()
  {
    WeakReference localWeakReference = this.k;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.k = null;
    }
  }
  
  public void d()
  {
    Object localObject1 = this.j;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      if (this.m == null) {
        return;
      }
      this.h = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.j.get();
      Object localObject2 = localBaseChatPie.aE();
      ApolloActionData localApolloActionData = this.m.mAction;
      int n = this.a;
      if (localApolloActionData.currencyType == 1)
      {
        HashMap localHashMap = new HashMap();
        int i1 = this.a;
        String str1;
        String str2;
        String str3;
        if (localApolloActionData.currencyNum <= n)
        {
          str1 = HardCodeUtil.a(2131898722);
          str2 = String.format(localBaseChatPie.e.getResources().getString(2131886695), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(i1) });
          str3 = HardCodeUtil.a(2131898727);
          if (localObject2 != null)
          {
            localObject1 = localBaseChatPie.d;
            n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(((SessionInfo)localObject2).a);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localApolloActionData.actionId);
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "icon_alert_show", n, 0, new String[] { ((StringBuilder)localObject2).toString() });
          }
          localObject1 = "requestSSO";
        }
        else
        {
          str1 = HardCodeUtil.a(2131898719);
          str2 = String.format(localBaseChatPie.e.getString(2131886694), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(i1) });
          str3 = HardCodeUtil.a(2131898725);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(ApolloConstant.z);
          ((StringBuilder)localObject1).append("&adtag=authGold");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (localObject2 != null)
          {
            QQAppInterface localQQAppInterface = localBaseChatPie.d;
            n = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(((SessionInfo)localObject2).a);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localApolloActionData.actionId);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "debt_alert_show", n, 0, new String[] { ((StringBuilder)localObject2).toString() });
          }
        }
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(localApolloActionData.feeType));
        localHashMap.put("title", str1);
        localHashMap.put("content", str2);
        localHashMap.put("rightString", str3);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", String.valueOf(localApolloActionData.actionId));
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("packageId", String.valueOf(this.m.mPackageId));
        }
        catch (Exception localException)
        {
          QLog.e("[cmshow]ApolloPanelManager", 1, "[authGoldAction] Exception:", localException);
        }
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.d.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
          ((Message)localObject1).obj = localHashMap;
          ((Message)localObject1).sendToTarget();
        }
      }
    }
  }
  
  public void e()
  {
    this.b.clear();
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager
 * JD-Core Version:    0.7.0.1
 */