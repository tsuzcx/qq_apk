package com.tencent.av.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo.ReqPushShareArk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.ConfigInfo;
import com.tencent.mobileqq.utils.QAVGroupConfig.URLInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareChat
{
  String a;
  protected QBaseActivity b;
  QQAppInterface c;
  long d;
  int e;
  protected String f;
  protected String g;
  ShareChat.SharePanel h;
  protected TroopInfoData i = new TroopInfoData();
  boolean j = false;
  ShareChat.MyTroopObserver k = null;
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return this.g;
    }
    return this.f;
  }
  
  static String a(Context paramContext)
  {
    return paramContext.getString(2131890650);
  }
  
  static String a(ShareChat.SharePanel.IHandle paramIHandle)
  {
    if (paramIHandle != null) {
      return paramIHandle.d();
    }
    return null;
  }
  
  static String a(String paramString)
  {
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localITroopAvatarUtilApi.getAvatarAddress("", paramString, 0));
    localStringBuilder.append("100");
    return localStringBuilder.toString();
  }
  
  static void a(long paramLong, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finishJumpActivity, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast((Intent)localObject);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, View paramView, Intent paramIntent)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    int m = paramIntent.getIntExtra("param_entrance", 0);
    String str = paramIntent.getStringExtra("group_uin");
    if (m == 35)
    {
      ShareChatReport.g();
      a((QQAppInterface)paramBaseQQAppInterface, paramQBaseActivity, paramView, str);
      return;
    }
    long l = paramIntent.getLongExtra("room_id", 0L);
    m = paramIntent.getIntExtra("room_create_time", 0);
    ShareChatReport.b();
    new ShareChat().a((QQAppInterface)paramBaseQQAppInterface, paramQBaseActivity, str, l, m);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    long l = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("forward, url[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("], fromchannel[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("], app[");
    boolean bool;
    if (paramQQAppInterface != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], context[");
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("]");
    QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      localObject = new ShareChat.SharePanel(l, 0);
      WeakReference localWeakReference = new WeakReference(paramContext);
      if (paramContext != null) {
        ((Activity)paramContext).getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
      }
      ((ShareChat.SharePanel)localObject).a(paramContext, paramString1, paramInt, new ShareChat.3(paramString2, paramQQAppInterface, paramString1, paramInt, l, localWeakReference));
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, View paramView, String paramString)
  {
    RobotUtils.a(paramQBaseActivity, paramString);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    for (;;)
    {
      boolean bool2;
      int m;
      try
      {
        localObject2 = new JSONObject(paramString1).getJSONObject("news");
        if ((!((JSONObject)localObject2).isNull("gav_ark_from_type")) && ("gav_ark_share_from_chatting".equalsIgnoreCase(((JSONObject)localObject2).getString("gav_ark_from_type"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareChat", 2, "shareGAVArkMsg");
          }
          local4 = new ShareChat.4();
          bool1 = ((JSONObject)localObject2).isNull("gav_ark_group_name_key");
          str2 = "";
          if (bool1) {
            break label712;
          }
          str1 = ((JSONObject)localObject2).getString("gav_ark_group_name_key");
          if (((JSONObject)localObject2).isNull("gav_ark_group_card_key")) {
            break label719;
          }
          paramString1 = ((JSONObject)localObject2).getString("gav_ark_group_card_key");
          if (!((JSONObject)localObject2).isNull("gav_ark_group_uin_key")) {
            str2 = ((JSONObject)localObject2).getString("gav_ark_group_uin_key");
          }
          bool1 = ((JSONObject)localObject2).getBoolean("gav_ark_group_owner_key");
          bool2 = ((JSONObject)localObject2).getBoolean("gav_ark_group_admin_key");
          localObject1 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            localObject1 = ContactUtils.a((QQAppInterface)paramBaseQQAppInterface, paramBaseQQAppInterface.getCurrentAccountUin(), true);
          }
          paramString1 = (String)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label725;
          }
          paramString1 = paramBaseQQAppInterface.getCurrentAccountUin();
          break label725;
          l2 = ((JSONObject)localObject2).getLong("gav_ark_room_id_key");
          n = ((JSONObject)localObject2).getInt("gav_ark_room_create_time_key");
          l3 = StringUtil.stringToLong("ShareChat", paramString2);
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              if ((paramInt == 1000) || (paramInt == 1004)) {
                continue;
              }
              if (paramInt != 3000) {
                l1 = -1L;
              } else {
                l1 = 2L;
              }
            }
            else
            {
              l1 = 1L;
            }
            continue;
          }
          l1 = 0L;
          if ((l3 == 0L) || (l1 == -1L)) {}
        }
      }
      catch (JSONException paramBaseQQAppInterface)
      {
        Object localObject2;
        ShareChat.4 local4;
        String str2;
        Object localObject1;
        long l2;
        int n;
        long l3;
        long l1;
        label653:
        paramString1 = "]";
        paramString2 = new StringBuilder();
        paramString2.append("json error[");
        paramString2.append(paramBaseQQAppInterface.getMessage());
        paramString2.append(paramString1);
        QLog.e("ShareChat", 1, paramString2.toString());
        return false;
      }
      for (;;)
      {
        try
        {
          if ((!str1.isEmpty()) && (!paramString1.isEmpty()) && (!str2.isEmpty()))
          {
            paramString2 = new ReqGroupVideo.ReqPushShareArk();
            localObject1 = paramString2.uin;
          }
        }
        catch (JSONException paramBaseQQAppInterface)
        {
          break label653;
        }
        try
        {
          ((PBUInt64Field)localObject1).set(paramBaseQQAppInterface.getLongAccountUin());
          paramString2.room_id.set(l2);
          paramString2.room_create_time.set(n);
          paramString2.send_type.set(l1);
          paramString2.recv_uin.set(l3);
          paramString2.group_name.set(ByteStringMicro.copyFromUtf8(str1));
          paramString2.share_name.set(ByteStringMicro.copyFromUtf8(paramString1));
          paramString2.role.set(m);
          localObject2 = paramString2.group_code;
          localObject1 = "ShareChat";
          try
          {
            ((PBUInt64Field)localObject2).set(StringUtil.stringToLong((String)localObject1, str2));
            MessageHandler.a(AudioHelper.c(), paramBaseQQAppInterface, "QQRTCSvc.push_share_ark", paramString2, local4);
            paramString2 = Locale.ENGLISH;
            long l4 = paramBaseQQAppInterface.getLongAccountUin();
            QLog.d((String)localObject1, 1, String.format(paramString2, "shareGAVArkMsg success : uin[%d], roomId[%d], room_create_time[%d], send_type[%d], recv_uin[%d], group_name[%s], share_name[%s], role[%d], groupUin[%s]", new Object[] { Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l3), str1, paramString1, Integer.valueOf(m), str2 }));
            bool1 = true;
          }
          catch (JSONException paramBaseQQAppInterface) {}
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append("shareGAVArkMsg failed : sendUin[");
          paramBaseQQAppInterface.append(l3);
          paramBaseQQAppInterface.append("], sessionType[");
          paramBaseQQAppInterface.append(paramInt);
          paramBaseQQAppInterface.append("] troopName[");
          paramBaseQQAppInterface.append(str1);
          paramBaseQQAppInterface.append("] shareName[");
          paramBaseQQAppInterface.append(paramString1);
          paramString1 = "]";
          try
          {
            paramBaseQQAppInterface.append(paramString1);
            QLog.e("ShareChat", 1, paramBaseQQAppInterface.toString());
            return false;
          }
          catch (JSONException paramBaseQQAppInterface) {}
        }
        catch (JSONException paramBaseQQAppInterface)
        {
          break label653;
        }
      }
      paramString1 = "]";
      continue;
      boolean bool1 = false;
      return bool1;
      label712:
      String str1 = "";
      continue;
      label719:
      paramString1 = "";
      continue;
      label725:
      if (bool1) {
        m = 1;
      } else if (bool2) {
        m = 2;
      } else {
        m = 3;
      }
    }
  }
  
  public static boolean a(JumpAction paramJumpAction)
  {
    if ("avshare/group".equals(paramJumpAction.e)) {
      return b(paramJumpAction);
    }
    if ("avshare/forward".equals(paramJumpAction.e)) {
      return d(paramJumpAction);
    }
    return false;
  }
  
  static String b(ShareChat.SharePanel.IHandle paramIHandle)
  {
    if (paramIHandle != null) {
      return paramIHandle.e();
    }
    return null;
  }
  
  static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    String str = ContactUtils.b(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    paramString = ContactUtils.a(paramQQAppInterface, paramString, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(String.format(paramQQAppInterface.getApp().getString(2131890653), new Object[] { paramString }));
    return localStringBuilder.toString();
  }
  
  public static boolean b(JumpAction paramJumpAction)
  {
    if (!"avshare/group".equals(paramJumpAction.e)) {
      return false;
    }
    String str = (String)paramJumpAction.f.get("guid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    AudioHelper.b("handle_startGAudio");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("guid", str);
    PublicFragmentActivity.Launcher.a(paramJumpAction.b, localIntent, PublicTransFragmentActivity.class, AVSchema.class);
    ShareChatReport.c();
    return true;
  }
  
  static boolean c(JumpAction paramJumpAction)
  {
    if (!paramJumpAction.h())
    {
      paramJumpAction = (String)paramJumpAction.f.get("from_url_InternalCheck");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle_forward, KEY_CurrentUrl[");
      localStringBuilder.append(paramJumpAction);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramJumpAction))
      {
        paramJumpAction = paramJumpAction.replace('\\', '/');
        if ((paramJumpAction.startsWith("https://web.qun.qq.com/")) || (paramJumpAction.startsWith("http://web.qun.qq.com/"))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static boolean d(JumpAction paramJumpAction)
  {
    if (!"avshare/forward".equals(paramJumpAction.e)) {
      return false;
    }
    if (!c(paramJumpAction)) {
      return false;
    }
    Object localObject1 = (String)paramJumpAction.f.get("url");
    Object localObject2 = (String)paramJumpAction.f.get("exp");
    String str = (String)paramJumpAction.f.get("guin");
    Object localObject3 = (String)paramJumpAction.f.get("fromchannel");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    int m = (int)StringUtil.stringToLong("ShareChat", (String)localObject3);
    if (m == 0) {
      return false;
    }
    ShareChatReport.a(m, str);
    AudioHelper.b("handle_forward");
    long l1 = StringUtil.stringToLong("ShareChat", (String)localObject2);
    long l2 = AudioHelper.b();
    if (l1 < l2)
    {
      paramJumpAction = QQToast.makeText(paramJumpAction.b, 2131890654, 1);
      paramJumpAction.setAutoTextSize();
      paramJumpAction.show();
      paramJumpAction = new StringBuilder();
      paramJumpAction.append("handle_forward, expTime[");
      paramJumpAction.append(l1);
      paramJumpAction.append("], curTime[");
      paramJumpAction.append(l2);
      paramJumpAction.append("]");
      QLog.w("ShareChat", 1, paramJumpAction.toString());
      return true;
    }
    if (((TroopManager)paramJumpAction.p().getManager(QQManagerFactory.TROOP_MANAGER)).f(str) == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle_forward, troopUin[");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ShareChat", 1, ((StringBuilder)localObject1).toString());
      }
      paramJumpAction = QQToast.makeText(paramJumpAction.b, 2131890654, 1);
      paramJumpAction.setAutoTextSize();
      paramJumpAction.show();
      return true;
    }
    localObject2 = (QQAppInterface)paramJumpAction.p();
    localObject3 = (TroopGagMgr)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    boolean bool1 = ((TroopGagMgr)localObject3).c(str);
    boolean bool2 = ((TroopGagMgr)localObject3).d(str);
    if ((!bool1) && (!bool2))
    {
      if (AudioHelper.e())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle_forward, troopUin[");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("], isAdmin[");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append("], isOwner[");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ShareChat", 1, ((StringBuilder)localObject1).toString());
      }
      paramJumpAction = QQToast.makeText(paramJumpAction.b, 2131890655, 1);
      paramJumpAction.setAutoTextSize();
      paramJumpAction.show();
      return true;
    }
    paramJumpAction.v = false;
    if ((paramJumpAction.b instanceof JumpActivity)) {
      ((JumpActivity)paramJumpAction.b).initFinishBroadcastReceiver();
    }
    a((QQAppInterface)localObject2, paramJumpAction.b, str, (String)localObject1, m);
    return true;
  }
  
  void a(long paramLong1, long paramLong2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reRequest, mIsRequesting[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (this.j) {
      return;
    }
    a();
    b(paramLong1, paramLong2, paramInt);
  }
  
  void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, String paramString, long paramLong, int paramInt)
  {
    this.a = paramString;
    this.b = paramQBaseActivity;
    this.c = paramQQAppInterface;
    this.d = paramLong;
    this.e = paramInt;
    if (!a()) {
      return;
    }
    a(paramQQAppInterface, paramString);
    paramQQAppInterface = QAVGroupConfig.a().a(paramString);
    long l = AudioHelper.c();
    int m = 1;
    if (paramQQAppInterface == null)
    {
      b(l, paramLong, paramInt);
    }
    else
    {
      this.f = paramQQAppInterface.b;
      this.g = paramQQAppInterface.c;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("ShareChat, 从缓存中找到url, groupUin[");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append("], mShareUrlWithNoSig[");
      paramQQAppInterface.append(this.f);
      paramQQAppInterface.append("], mShareUrl[");
      paramQQAppInterface.append(this.g);
      paramQQAppInterface.append("], seq[");
      paramQQAppInterface.append(l);
      paramQQAppInterface.append("], mSharePanel[");
      paramQQAppInterface.append(this.h);
      paramQQAppInterface.append("]");
      QLog.w("ShareChat", 1, paramQQAppInterface.toString());
    }
    boolean bool = this.b.getAppRuntime() instanceof QQAppInterface;
    int n = 0;
    if (bool) {
      bool = ((TroopManager)((QQAppInterface)this.b.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).Z(this.i.troopUin);
    } else {
      bool = false;
    }
    paramInt = n;
    if (this.i.isOwnerOrAdim())
    {
      paramInt = n;
      if (!bool)
      {
        if ((TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 512))) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (this.i.cGroupOption != 1) {
          m = 0;
        }
        if ((paramInt | m) != 0) {
          paramInt = n;
        } else {
          paramInt = -1;
        }
      }
    }
    this.h = new ShareChat.SharePanel(l, paramInt);
    paramQQAppInterface = this.b;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
      this.h.a(this.b, this.a, 99, new ShareChat.1(this, l));
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((ITroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString, false);
    if (this.k == null)
    {
      this.k = new ShareChat.MyTroopObserver(this, null);
      ShareChat.MyTroopObserver localMyTroopObserver = this.k;
      localMyTroopObserver.a = paramString;
      paramQQAppInterface.addObserver(localMyTroopObserver);
    }
  }
  
  boolean a()
  {
    Object localObject = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.a);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData fail, mGroupUin[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]");
      QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.i.updateForTroopInfo((TroopInfo)localObject, this.c.getCurrentAccountUin());
    return true;
  }
  
  void b(long paramLong1, long paramLong2, int paramInt)
  {
    this.j = true;
    long l = StringUtil.stringToLong("ShareChat", this.i.troopUin);
    Object localObject2 = this.i.troopCard;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.c;
      localObject1 = ContactUtils.a((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentAccountUin(), true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.c.getCurrentAccountUin();
    }
    int m = 3;
    if (this.i.bOwner) {
      m = 1;
    } else if (this.i.bAdmin) {
      m = 2;
    }
    localObject1 = new ShareChat.2(this);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("requestGetUrlFromServer, shareName[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("], role[");
    ((StringBuilder)localObject3).append(m);
    ((StringBuilder)localObject3).append("], troopUin[");
    ((StringBuilder)localObject3).append(l);
    ((StringBuilder)localObject3).append("], roomID[");
    ((StringBuilder)localObject3).append(paramLong2);
    ((StringBuilder)localObject3).append("], roomCreateTime[");
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(paramLong1);
    ((StringBuilder)localObject3).append("]");
    QLog.w("ShareChat", 1, ((StringBuilder)localObject3).toString());
    localObject3 = new ReqGroupVideo.ReqCreateShareUrl();
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_uin.set(this.c.getLongAccountUin());
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_group_code.set(l);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_room_id.set(paramLong2);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint32_room_create_time.set(paramInt);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).group_name.set(ByteStringMicro.copyFromUtf8(this.i.troopName));
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).share_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).role.set(m);
    MessageHandler.a(paramLong1, this.c, "QQRTCSvc.group_video_create_share_url", (MessageMicro)localObject3, (MessageHandler.MsgListener)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat
 * JD-Core Version:    0.7.0.1
 */