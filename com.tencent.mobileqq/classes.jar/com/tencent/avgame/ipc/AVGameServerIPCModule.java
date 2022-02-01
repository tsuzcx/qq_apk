package com.tencent.avgame.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.GameResultUploadCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class AVGameServerIPCModule
  extends QIPCModule
{
  private static AVGameServerIPCModule a;
  private static int b = 0;
  private static boolean c = false;
  private final ConcurrentHashMap<String, AVGameServerIPCModule.UserFlag> d = new ConcurrentHashMap(8);
  private FriendListObserver e = null;
  private AvatarObserver f = null;
  private AVGameServerIPCModule.PtvSoLoadCallback g = null;
  private GameResultUploadMgrForRemote.GameResultUploadCallback h = null;
  
  private AVGameServerIPCModule(String paramString)
  {
    super(paramString);
    if (b != 1) {
      b = 1;
    }
  }
  
  public static AVGameServerIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVGameServerIPCModule("AVGameServerIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private UserInfo a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    UserInfo localUserInfo = new UserInfo(paramString);
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).m(paramString);
      if (localObject != null)
      {
        localUserInfo.c = ((Friends)localObject).getFriendNickWithAlias();
        localUserInfo.e = ((Friends)localObject).age;
        localUserInfo.f = ((Friends)localObject).gender;
        localUserInfo.d = ((Friends)localObject).isFriend();
      }
      localUserInfo.g = paramQQAppInterface.getCustomFaceFilePath(1, paramString, 200);
    }
    if ((TextUtils.equals(paramString, localUserInfo.c)) || (TextUtils.isEmpty(localUserInfo.c)))
    {
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.getFriendInfo(paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getUserInfo, type[");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append("], uin[");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append("], info[");
      paramQQAppInterface.append(localUserInfo);
      paramQQAppInterface.append("]");
      QLog.i("AVGameServerIPCModule", 2, paramQQAppInterface.toString());
    }
    return localUserInfo;
  }
  
  private EIPCResult a(@NotNull QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class);
      if (paramQQAppInterface != null)
      {
        bool = paramQQAppInterface.isLobbyEntryStatus();
        break label30;
      }
    }
    boolean bool = true;
    label30:
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkLobbyEntryStatus, isLobbyEntryStatus ret[");
    paramQQAppInterface.append(bool);
    paramQQAppInterface.append("]");
    QLog.w("AVGameServerIPCModule", 1, paramQQAppInterface.toString());
    int i;
    if (!bool) {
      i = 0;
    } else {
      i = -102;
    }
    return EIPCResult.createResult(i, null);
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramBundle = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class);
      if (paramBundle != null) {
        paramBundle.startStrangerMatchNotCheck(9);
      }
    }
  }
  
  private void a(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramBundle.getString("key_room_id");
    int i = paramBundle.getInt("status");
    paramBundle = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class);
    if (paramBundle == null)
    {
      QLog.e("AVGameServerIPCModule", 2, "setCurrentAvGameStatus AV_GAME_MANAGER NULL");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    paramBundle.setCurrentAvGameRoomInfo(i, str);
    callbackResult(paramInt, EIPCResult.createSuccessResult(null));
  }
  
  private void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    AVGameServerIPCModule.UserFlag localUserFlag2 = (AVGameServerIPCModule.UserFlag)this.d.get(paramString);
    AVGameServerIPCModule.UserFlag localUserFlag1 = localUserFlag2;
    if (localUserFlag2 == null)
    {
      localUserFlag1 = new AVGameServerIPCModule.UserFlag();
      localUserFlag1.a = paramString;
      this.d.put(paramString, localUserFlag1);
    }
    if ((paramInt >= 0) && (paramInt < localUserFlag1.b.length)) {
      localUserFlag1.b[paramInt] = true;
    }
    if ((paramQQAppInterface != null) && (this.e == null) && (paramInt == 1))
    {
      this.e = new AVGameServerIPCModule.MyFriendListObserver(this, paramQQAppInterface);
      paramQQAppInterface.addObserver(this.e, true);
    }
    if ((paramQQAppInterface != null) && (this.f == null) && (paramInt == 0))
    {
      this.f = new AVGameServerIPCModule.MyAvatarObserver(this);
      paramQQAppInterface.addObserver(this.f, true);
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = (AVGameServerIPCModule.UserFlag)this.d.get(paramString);
    if ((paramString != null) && (paramInt >= 0) && (paramInt < paramString.b.length)) {
      return paramString.b[paramInt];
    }
    return false;
  }
  
  private EIPCResult b(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_type", 0);
    paramBundle = paramBundle.getString("key_uin");
    a(paramBundle, 1, paramQQAppInterface);
    Bundle localBundle = new Bundle();
    paramQQAppInterface = a(i, paramBundle, paramQQAppInterface);
    localBundle.putString("key_uin", paramBundle);
    localBundle.putInt("key_type", i);
    localBundle.putParcelable("key_result", paramQQAppInterface);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private void b(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("key_type");
    String str = paramBundle.getString("key_uin");
    paramBundle = paramBundle.getString("key_room_id");
    paramQQAppInterface = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class);
    if (paramQQAppInterface == null)
    {
      QLog.e("AVGameServerIPCModule", 2, "notifySendMsg AV_GAME_MANAGER NULL");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    paramQQAppInterface.notifySendMsg(i, str, paramBundle);
    callbackResult(paramInt, EIPCResult.createSuccessResult(null));
  }
  
  static boolean b()
  {
    if (b == 0) {
      c();
    }
    return b == 1;
  }
  
  private EIPCResult c(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_face_type");
    String str = paramBundle.getString("key_uin");
    byte b1 = paramBundle.getByte("key_shape");
    int j = paramBundle.getInt("key_id_type");
    a(str, 0, paramQQAppInterface);
    if (!TextUtils.isEmpty(str)) {
      paramBundle = paramQQAppInterface.getFaceBitmap(i, str, b1, true, j);
    } else {
      paramBundle = null;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getUserHead, type[");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append("], uin[");
      paramQQAppInterface.append(str);
      paramQQAppInterface.append("], shape[");
      paramQQAppInterface.append(b1);
      paramQQAppInterface.append("], idType[");
      paramQQAppInterface.append(j);
      paramQQAppInterface.append("]");
      QLog.i("AVGameServerIPCModule", 2, paramQQAppInterface.toString());
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putParcelable("key_result", paramBundle);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  private static void c()
  {
    if (c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "init");
    }
    c = true;
    QIPCServerHelper.getInstance().getServer().addListener(new AVGameServerIPCModule.MyEIPCOnGetConnectionListener());
  }
  
  private void c(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str1 = paramBundle.getString("key_play_game_id");
    String str2 = paramBundle.getString("key_pic_path");
    paramBundle = paramBundle.getString("key_video_path");
    if (this.h == null) {
      this.h = new AVGameServerIPCModule.GameResultCallback(this);
    }
    ((IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class)).getGameResultShareMgr().a(paramQQAppInterface, str1, str2, paramBundle, this.h);
  }
  
  private EIPCResult d()
  {
    if (this.g == null) {
      this.g = new AVGameServerIPCModule.PtvSoLoadCallback(this);
    }
    boolean bool = PtuResChecker.a(this.g);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPtvSoIsLoadOk, ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("AVGameServerIPCModule", 2, localStringBuilder.toString());
    }
    int i;
    if (bool) {
      i = 0;
    } else {
      i = -102;
    }
    return EIPCResult.createResult(i, null);
  }
  
  private EIPCResult d(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_type");
    Object localObject = paramBundle.getStringArrayList("key_uin_list");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new ArrayList();
    }
    localObject = new MapParcelable();
    Iterator localIterator = paramBundle.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = ContactUtils.d(paramQQAppInterface, str1);
      if ((!TextUtils.isEmpty(str2)) && (!str2.equalsIgnoreCase(str1))) {
        ((MapParcelable)localObject).a.put(str1, str2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, String.format(Locale.getDefault(), "getNicks %d size=%d foundSize=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.size()), Integer.valueOf(((MapParcelable)localObject).a.size()) }));
    }
    paramBundle = new Bundle();
    paramBundle.putInt("key_type", i);
    paramBundle.putParcelable("key_result", (Parcelable)localObject);
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private void d(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramBundle = paramBundle.getString("key_play_game_id");
    ((IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class)).getGameResultShareMgr().a(paramBundle);
  }
  
  private void e(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramBundle = paramBundle.getString("key_play_game_id");
    ((IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class)).getGameResultShareMgr().b(paramBundle);
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_face_type", paramInt1);
    localBundle.putString("key_uin", paramString);
    localBundle.putInt("key_id_type", paramInt2);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_user_head_change", localBundle);
  }
  
  protected void a(int paramInt, String paramString, UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_type", paramInt);
    localBundle.putString("key_uin", paramString);
    localBundle.putParcelable("key_result", paramUserInfo);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_user_info_change", localBundle);
  }
  
  protected void a(int paramInt, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_event_id", paramInt);
    localBundle.putBoolean("key_event_ret", paramBoolean);
    localBundle.putString("key_event_msg", paramString);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_event", localBundle);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_event_ret", paramBoolean);
    localBundle.putString("key_play_game_id", paramString1);
    localBundle.putInt("key_file_type", paramInt);
    localBundle.putString("key_file_url", paramString2);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_game_result_upload", localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], state[");
      localStringBuilder.append(b);
      localStringBuilder.append("]");
      QLog.i("AVGameServerIPCModule", 2, localStringBuilder.toString());
    }
    if (b != 1) {
      b = 1;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool = localObject instanceof QQAppInterface;
    StringBuilder localStringBuilder = null;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVGameServerIPCModule", 2, "[onCall] get app failed.");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("action_get_user_info".equals(paramString)) {
      return b(paramBundle, (QQAppInterface)localObject);
    }
    if ("action_get_user_head".equals(paramString)) {
      return c(paramBundle, (QQAppInterface)localObject);
    }
    if ("action_get_nicks".equals(paramString)) {
      return d(paramBundle, (QQAppInterface)localObject);
    }
    if ("action_check_ptv_so_load_ok".equals(paramString)) {
      return d();
    }
    if ("action_set_cur_av_game_status".equals(paramString))
    {
      a(paramBundle, (QQAppInterface)localObject, paramInt);
      return null;
    }
    if ("action_notify_send_msg".equals(paramString))
    {
      b(paramBundle, (QQAppInterface)localObject, paramInt);
      return null;
    }
    if ("action_upload_game_result_resources".equals(paramString))
    {
      c(paramBundle, (QQAppInterface)localObject, paramInt);
      return null;
    }
    if ("action_clean_game_result_resources".equals(paramString))
    {
      e(paramBundle, (QQAppInterface)localObject, paramInt);
      return null;
    }
    if ("action_upload_game_result_video".equals(paramString))
    {
      d(paramBundle, (QQAppInterface)localObject, paramInt);
      return null;
    }
    if ("action_notify_game_start_match".equals(paramString))
    {
      a(paramBundle, (QQAppInterface)localObject);
      return null;
    }
    paramBundle = localStringBuilder;
    if ("action_get_lobby_status".equals(paramString)) {
      paramBundle = a((QQAppInterface)localObject);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule
 * JD-Core Version:    0.7.0.1
 */