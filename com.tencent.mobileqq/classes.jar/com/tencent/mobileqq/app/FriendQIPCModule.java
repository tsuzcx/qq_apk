package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime.Status;

public class FriendQIPCModule
  extends QIPCModule
{
  private static volatile FriendQIPCModule a;
  
  public FriendQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static FriendQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FriendQIPCModule("FriendQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Bundle localBundle = new Bundle();
    boolean bool;
    if (paramQQAppInterface != null) {
      bool = paramQQAppInterface.n(paramBundle);
    } else {
      bool = false;
    }
    localBundle.putBoolean("KEY_IS_FRIEND", bool);
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, isFriend: %s", new Object[] { paramBundle, Boolean.valueOf(bool) }));
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ((IOnlineStatusService)paramQQAppInterface.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 1080L);
    paramQQAppInterface.addObserver(new FriendQIPCModule.IPCOnlineStatusObserver(this, paramInt, paramQQAppInterface));
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Bundle localBundle = new Bundle();
    boolean bool;
    if (localFriendsManager != null) {
      bool = localFriendsManager.n(paramBundle);
    } else {
      bool = false;
    }
    if (bool)
    {
      paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (paramQQAppInterface != null)
      {
        int i = paramQQAppInterface.getSelfBindState();
        if (((i == 9) || (i == 8) || (i == 4) || (i == 2)) && (PermissionChecker.a().e()))
        {
          paramQQAppInterface = paramQQAppInterface.queryPhoneContactByUin(paramBundle);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.unifiedCode;
            break label128;
          }
        }
      }
    }
    paramQQAppInterface = null;
    label128:
    localBundle.putString("PHONE_NUMBER", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, phoneNumber: %s", new Object[] { paramBundle, paramQQAppInterface }));
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("KEY_UIN");
    paramBundle = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).y(str1);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_SCF_INFO", paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("getSCFInfo: %s", new Object[] { paramBundle }));
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    paramBundle = new StringBuilder();
    paramBundle.append("special_care_voice_red_dot");
    paramBundle.append(paramQQAppInterface.getCurrentAccountUin());
    String str2 = paramBundle.toString();
    paramBundle = SharedPreferencesHandler.a(localSharedPreferences, str2, null);
    paramQQAppInterface = paramBundle;
    if (paramBundle == null) {
      paramQQAppInterface = new HashSet();
    }
    if (paramQQAppInterface.add(str1))
    {
      localBundle.putBoolean("KEY_SCF_VOICE_NEW_FLAG", true);
      paramBundle = localSharedPreferences.edit();
      SharedPreferencesHandler.a(paramBundle, str2, paramQQAppInterface.toArray());
      paramBundle.commit();
    }
    else
    {
      localBundle.putBoolean("KEY_SCF_VOICE_NEW_FLAG", false);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult d(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("KEY_UIN");
    ExtensionInfo localExtensionInfo = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramBundle, false);
    int i;
    if (localExtensionInfo != null) {
      i = localExtensionInfo.friendRingId;
    } else {
      i = 0;
    }
    paramQQAppInterface = MessageNotificationSettingManager.a(paramQQAppInterface).a(i, paramBundle, 0);
    paramBundle = new Bundle();
    paramBundle.putString("KEY_SCF_RING_NAME", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FriendQIPCModule", 2, String.format("SCP getRingName, ringId: %s, ringName: %s", new Object[] { Integer.valueOf(i), paramQQAppInterface }));
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private void e(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private EIPCResult f(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("KEY_BE_DELETE_SINGLE_WAY_FRIENDS");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete single way friends: ");
    localStringBuilder.append(paramBundle);
    QLog.d("FriendQIPCModule", 1, localStringBuilder.toString());
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramQQAppInterface = (IStrangerService)paramQQAppInterface.getRuntimeService(IStrangerService.class, "all");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.notifyUI(4, true, paramBundle);
      }
    }
    return EIPCResult.createSuccessResult(null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("ACTION_IS_FRIEND".equals(paramString)) {
      return a((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_PHONE_NUMBER".equals(paramString)) {
      return b((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_SPECIAL_CARE_INFO".equals(paramString)) {
      return c((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_GET_SCF_RING_NAME".equals(paramString)) {
      return d((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_SET_SAVE_SWITCH".equals(paramString))
    {
      e((QQAppInterface)localObject, paramBundle);
      return null;
    }
    if ("ACTION_DELETE_SINGLE_WAY_FRIENDS".equals(paramString)) {
      return f((QQAppInterface)localObject, paramBundle);
    }
    if ("ACTION_SET_OLYMPIC_ONLINE_STATUS".equals(paramString)) {
      a((QQAppInterface)localObject, paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendQIPCModule
 * JD-Core Version:    0.7.0.1
 */