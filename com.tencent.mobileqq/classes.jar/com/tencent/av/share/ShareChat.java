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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ShareChat.MyTroopObserver jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = null;
  ShareChat.SharePanel jdField_a_of_type_ComTencentAvShareShareChat$SharePanel;
  protected QBaseActivity a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopInfoData a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  protected String b;
  protected String c;
  
  public ShareChat()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return this.c;
    }
    return this.b;
  }
  
  static String a(Context paramContext)
  {
    return paramContext.getString(2131693111);
  }
  
  static String a(ShareChat.SharePanel.IHandle paramIHandle)
  {
    if (paramIHandle != null) {
      return paramIHandle.a();
    }
    return null;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    String str = ContactUtils.b(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    paramString = ContactUtils.a(paramQQAppInterface, paramString, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(String.format(paramQQAppInterface.getApp().getString(2131693114), new Object[] { paramString }));
    return localStringBuilder.toString();
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
    int i = paramIntent.getIntExtra("param_entrance", 0);
    String str = paramIntent.getStringExtra("group_uin");
    if (i == 35)
    {
      ShareChatReport.g();
      a((QQAppInterface)paramBaseQQAppInterface, paramQBaseActivity, paramView, str);
      return;
    }
    long l = paramIntent.getLongExtra("room_id", 0L);
    i = paramIntent.getIntExtra("room_create_time", 0);
    ShareChatReport.b();
    new ShareChat().a((QQAppInterface)paramBaseQQAppInterface, paramQBaseActivity, str, l, i);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    long l = AudioHelper.b();
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
      int i;
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
            break label714;
          }
          str1 = ((JSONObject)localObject2).getString("gav_ark_group_name_key");
          if (((JSONObject)localObject2).isNull("gav_ark_group_card_key")) {
            break label721;
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
            break label727;
          }
          paramString1 = paramBaseQQAppInterface.getCurrentAccountUin();
          break label727;
          l2 = ((JSONObject)localObject2).getLong("gav_ark_room_id_key");
          j = ((JSONObject)localObject2).getInt("gav_ark_room_create_time_key");
          l3 = StringUtil.a("ShareChat", paramString2);
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
        int j;
        long l3;
        long l1;
        label655:
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
          break label655;
        }
        try
        {
          ((PBUInt64Field)localObject1).set(paramBaseQQAppInterface.getLongAccountUin());
          paramString2.room_id.set(l2);
          paramString2.room_create_time.set(j);
          paramString2.send_type.set(l1);
          paramString2.recv_uin.set(l3);
          paramString2.group_name.set(ByteStringMicro.copyFromUtf8(str1));
          paramString2.share_name.set(ByteStringMicro.copyFromUtf8(paramString1));
          paramString2.role.set(i);
          localObject2 = paramString2.group_code;
          localObject1 = "ShareChat";
          try
          {
            ((PBUInt64Field)localObject2).set(StringUtil.a((String)localObject1, str2));
            MessageHandler.a(AudioHelper.b(), paramBaseQQAppInterface, "QQRTCSvc.push_share_ark", paramString2, local4);
            paramString2 = Locale.ENGLISH;
            long l4 = paramBaseQQAppInterface.getLongAccountUin();
            QLog.d((String)localObject1, 1, String.format(paramString2, "shareGAVArkMsg success : uin[%d], roomId[%d], room_create_time[%d], send_type[%d], recv_uin[%d], group_name[%s], share_name[%s], role[%d], groupUin[%s]", new Object[] { Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l3), str1, paramString1, Integer.valueOf(i), str2 }));
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
          break label655;
        }
      }
      paramString1 = "]";
      continue;
      boolean bool1 = false;
      return bool1;
      label714:
      String str1 = "";
      continue;
      label721:
      paramString1 = "";
      continue;
      label727:
      if (bool1) {
        i = 1;
      } else if (bool2) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static boolean a(JumpAction paramJumpAction)
  {
    if ("avshare/group".equals(paramJumpAction.c)) {
      return b(paramJumpAction);
    }
    if ("avshare/forward".equals(paramJumpAction.c)) {
      return d(paramJumpAction);
    }
    return false;
  }
  
  static String b(ShareChat.SharePanel.IHandle paramIHandle)
  {
    if (paramIHandle != null) {
      return paramIHandle.b();
    }
    return null;
  }
  
  public static boolean b(JumpAction paramJumpAction)
  {
    if (!"avshare/group".equals(paramJumpAction.c)) {
      return false;
    }
    String str = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("guid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    AudioHelper.b("handle_startGAudio");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("guid", str);
    PublicFragmentActivity.Launcher.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, AVSchema.class);
    ShareChatReport.c();
    return true;
  }
  
  static boolean c(JumpAction paramJumpAction)
  {
    if (!paramJumpAction.d())
    {
      paramJumpAction = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("from_url_InternalCheck");
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
    if (!"avshare/forward".equals(paramJumpAction.c)) {
      return false;
    }
    if (!c(paramJumpAction)) {
      return false;
    }
    Object localObject1 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("url");
    Object localObject2 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("exp");
    String str = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject3 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("fromchannel");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    int i = (int)StringUtil.a("ShareChat", (String)localObject3);
    if (i == 0) {
      return false;
    }
    ShareChatReport.a(i, str);
    AudioHelper.b("handle_forward");
    long l1 = StringUtil.a("ShareChat", (String)localObject2);
    long l2 = AudioHelper.a();
    if (l1 < l2)
    {
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693115, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      paramJumpAction = new StringBuilder();
      paramJumpAction.append("handle_forward, expTime[");
      paramJumpAction.append(l1);
      paramJumpAction.append("], curTime[");
      paramJumpAction.append(l2);
      paramJumpAction.append("]");
      QLog.w("ShareChat", 1, paramJumpAction.toString());
      return true;
    }
    if (((TroopManager)paramJumpAction.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(str) == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle_forward, troopUin[");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ShareChat", 1, ((StringBuilder)localObject1).toString());
      }
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693115, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      return true;
    }
    localObject2 = (QQAppInterface)paramJumpAction.a();
    localObject3 = (TroopGagMgr)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    boolean bool1 = ((TroopGagMgr)localObject3).a(str);
    boolean bool2 = ((TroopGagMgr)localObject3).b(str);
    if ((!bool1) && (!bool2))
    {
      if (AudioHelper.b())
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
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693116, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      return true;
    }
    paramJumpAction.f = false;
    if ((paramJumpAction.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) {
      ((JumpActivity)paramJumpAction.jdField_a_of_type_AndroidContentContext).initFinishBroadcastReceiver();
    }
    a((QQAppInterface)localObject2, paramJumpAction.jdField_a_of_type_AndroidContentContext, str, (String)localObject1, i);
    return true;
  }
  
  void a(long paramLong1, long paramLong2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reRequest, mIsRequesting[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    b(paramLong1, paramLong2, paramInt);
  }
  
  void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, String paramString, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (!a()) {
      return;
    }
    a(paramQQAppInterface, paramString);
    paramQQAppInterface = QAVGroupConfig.a().a(paramString);
    long l = AudioHelper.b();
    int i = 1;
    if (paramQQAppInterface == null)
    {
      b(l, paramLong, paramInt);
    }
    else
    {
      this.b = paramQQAppInterface.jdField_a_of_type_JavaLangString;
      this.c = paramQQAppInterface.b;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("ShareChat, 从缓存中找到url, groupUin[");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append("], mShareUrlWithNoSig[");
      paramQQAppInterface.append(this.b);
      paramQQAppInterface.append("], mShareUrl[");
      paramQQAppInterface.append(this.c);
      paramQQAppInterface.append("], seq[");
      paramQQAppInterface.append(l);
      paramQQAppInterface.append("], mSharePanel[");
      paramQQAppInterface.append(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel);
      paramQQAppInterface.append("]");
      QLog.w("ShareChat", 1, paramQQAppInterface.toString());
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() instanceof QQAppInterface;
    int j = 0;
    if (bool) {
      bool = ((TroopManager)((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).m(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    } else {
      bool = false;
    }
    paramInt = j;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      paramInt = j;
      if (!bool)
      {
        if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 1) {
          i = 0;
        }
        if ((paramInt | i) != 0) {
          paramInt = j;
        } else {
          paramInt = -1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel = new ShareChat.SharePanel(l, paramInt);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, 99, new ShareChat.1(this, l));
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((ITroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString, false);
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = new ShareChat.MyTroopObserver(this, null);
      ShareChat.MyTroopObserver localMyTroopObserver = this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver;
      localMyTroopObserver.jdField_a_of_type_JavaLangString = paramString;
      paramQQAppInterface.addObserver(localMyTroopObserver);
    }
  }
  
  boolean a()
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData fail, mGroupUin[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]");
      QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return true;
  }
  
  void b(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    long l = StringUtil.a("ShareChat", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCard;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ContactUtils.a((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentAccountUin(), true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      i = 1;
    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
      i = 2;
    }
    localObject1 = new ShareChat.2(this);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("requestGetUrlFromServer, shareName[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("], role[");
    ((StringBuilder)localObject3).append(i);
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
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_group_code.set(l);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint64_room_id.set(paramLong2);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).uint32_room_create_time.set(paramInt);
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).group_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName));
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).share_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    ((ReqGroupVideo.ReqCreateShareUrl)localObject3).role.set(i);
    MessageHandler.a(paramLong1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQRTCSvc.group_video_create_share_url", (MessageMicro)localObject3, (MessageHandler.MsgListener)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat
 * JD-Core Version:    0.7.0.1
 */