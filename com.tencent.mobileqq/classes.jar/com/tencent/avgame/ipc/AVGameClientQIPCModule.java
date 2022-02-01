package com.tencent.avgame.ipc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AVGameClientQIPCModule
  extends QIPCModule
{
  private final BaseAVGameAppInterface a;
  private final AVGameClientQIPCModule.MyIPCConListener b;
  
  public AVGameClientQIPCModule(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    super("AVGameClientQIPCModule");
    this.a = paramBaseAVGameAppInterface;
    this.b = new AVGameClientQIPCModule.MyIPCConListener(this, null);
    QIPCClientHelper.getInstance().register(this);
    QIPCClientHelper.getInstance().getClient().addListener(this.b);
    e();
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("key_event_id");
    boolean bool = paramBundle.getBoolean("key_event_ret");
    paramBundle = paramBundle.getString("key_event_msg");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyEvent, eventId[");
      localStringBuilder.append(i);
      localStringBuilder.append("], result[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], msg[");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i("AVGameClientQIPCModule", 4, localStringBuilder.toString());
    }
    ObserverCenter.a().a(IPCEventObserver.class, i, bool, paramBundle);
  }
  
  private void a(Bundle paramBundle, BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    if (paramBundle != null)
    {
      if (paramBaseAVGameAppInterface == null) {
        return;
      }
      int i = paramBundle.getInt("key_type");
      String str = paramBundle.getString("key_uin");
      paramBundle.setClassLoader(UserInfo.class.getClassLoader());
      paramBundle = (UserInfo)paramBundle.getParcelable("key_result");
      paramBaseAVGameAppInterface = (UserInfoHandler)paramBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.b);
      if (paramBaseAVGameAppInterface != null) {
        paramBaseAVGameAppInterface.a(i, str, paramBundle);
      }
      if (QLog.isDevelopLevel())
      {
        paramBaseAVGameAppInterface = new StringBuilder();
        paramBaseAVGameAppInterface.append("notifyUserInfoChange, uinType[");
        paramBaseAVGameAppInterface.append(i);
        paramBaseAVGameAppInterface.append("], uin[");
        paramBaseAVGameAppInterface.append(str);
        paramBaseAVGameAppInterface.append("], info[");
        paramBaseAVGameAppInterface.append(paramBundle);
        paramBaseAVGameAppInterface.append("]");
        QLog.i("AVGameClientQIPCModule", 4, paramBaseAVGameAppInterface.toString());
      }
    }
  }
  
  private void b(Bundle paramBundle, BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    if (paramBundle != null)
    {
      if (paramBaseAVGameAppInterface == null) {
        return;
      }
      int i = paramBundle.getInt("key_face_type");
      String str = paramBundle.getString("key_uin");
      int j = paramBundle.getInt("key_id_type");
      paramBundle = (UserInfoHandler)paramBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.b);
      if (paramBundle != null) {
        paramBundle.notifyUI(1, true, new Object[] { Integer.valueOf(i), str, Integer.valueOf(j) });
      }
      if (QLog.isDevelopLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("notifyUserHeadChange, faceType[");
        paramBundle.append(i);
        paramBundle.append("], uin[");
        paramBundle.append(str);
        paramBundle.append("], idType[");
        paramBundle.append(j);
        paramBundle.append("]");
        QLog.i("AVGameClientQIPCModule", 4, paramBundle.toString());
      }
    }
  }
  
  private void c(Bundle paramBundle, BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    if (paramBundle != null)
    {
      if (paramBaseAVGameAppInterface == null) {
        return;
      }
      boolean bool = paramBundle.getBoolean("key_event_ret");
      String str = paramBundle.getString("key_play_game_id");
      int i = paramBundle.getInt("key_file_type");
      paramBundle = paramBundle.getString("key_file_url");
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyGameResultUpload, playId[");
        localStringBuilder.append(str);
        localStringBuilder.append("], fileType[");
        localStringBuilder.append(i);
        localStringBuilder.append("], fileUrl[");
        localStringBuilder.append(paramBundle);
        localStringBuilder.append("]");
        QLog.i("AVGameClientQIPCModule_GameRC", 4, localStringBuilder.toString());
      }
      ((GamePlayHandler)paramBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).notifyUI(11, bool, new Object[] { str, Integer.valueOf(i), paramBundle });
    }
  }
  
  private void e()
  {
    if (this.b.a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connect, [");
      localStringBuilder.append(this.b.a.get());
      localStringBuilder.append("]");
      QLog.i("AVGameClientQIPCModule", 2, localStringBuilder.toString());
    }
    QIPCClientHelper.getInstance().getClient().connect(this.b);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    e();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_face_type", paramInt1);
    ((Bundle)localObject2).putString("key_uin", paramString);
    ((Bundle)localObject2).putByte("key_shape", paramByte);
    ((Bundle)localObject2).putInt("key_id_type", paramInt2);
    localObject2 = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_user_head", (Bundle)localObject2);
    paramString = localObject1;
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((EIPCResult)localObject2).isSuccess())
      {
        paramString = localObject1;
        if (((EIPCResult)localObject2).data != null) {
          paramString = (Bitmap)((EIPCResult)localObject2).data.getParcelable("key_result");
        }
      }
    }
    return paramString;
  }
  
  public UserInfo a(int paramInt, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    e();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_type", paramInt);
    ((Bundle)localObject2).putString("key_uin", paramString);
    localObject2 = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_user_info", (Bundle)localObject2);
    paramString = localObject1;
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((EIPCResult)localObject2).isSuccess())
      {
        paramString = localObject1;
        if (((EIPCResult)localObject2).data != null)
        {
          ((EIPCResult)localObject2).data.setClassLoader(UserInfo.class.getClassLoader());
          paramString = (UserInfo)((EIPCResult)localObject2).data.getParcelable("key_result");
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameClientQIPCModule", 2, "disconnect");
    }
    QIPCClientHelper.getInstance().disconnect();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifySendMsg shareType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" friendUin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" roomId:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("AVGameClientQIPCModule", 2, ((StringBuilder)localObject).toString(), new Throwable("print stack"));
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_type", paramInt);
    ((Bundle)localObject).putString("key_uin", paramString1);
    ((Bundle)localObject).putString("key_room_id", paramString2);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_notify_send_msg", (Bundle)localObject, null);
  }
  
  public void a(int paramInt, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramHashMap == null) {
        return;
      }
      e();
      ArrayList localArrayList = new ArrayList(paramList.size());
      localArrayList.addAll(paramList);
      paramList = new Bundle();
      paramList.putInt("key_type", paramInt);
      paramList.putStringArrayList("key_uin_list", localArrayList);
      paramList = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_nicks", paramList);
      if ((paramList != null) && (paramList.isSuccess()) && (paramList.data != null))
      {
        paramList.data.setClassLoader(MapParcelable.class.getClassLoader());
        paramList = (MapParcelable)paramList.data.getParcelable("key_result");
        if (paramList != null) {
          paramHashMap.putAll(paramList.a);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_play_game_id", paramString);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_upload_game_result_video", localBundle, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_play_game_id", paramString1);
    localBundle.putString("key_pic_path", paramString2);
    localBundle.putString("key_video_path", paramString3);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_upload_game_result_resources", localBundle, null);
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentAvGameStatus nCurrentStatus:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" roomId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AVGameClientQIPCModule", 2, ((StringBuilder)localObject).toString(), new Throwable("not crash, print stack"));
    }
    if ((paramInt != 0) && (paramInt != 2))
    {
      if ((paramInt == 1) || (paramInt == 3)) {
        AVBizModuleFactory.getModuleByName("一起派对").requestAVFocus();
      }
    }
    else
    {
      AVBizModuleFactory.getModuleByName("一起派对").abandonAVFocus();
      AVBizModuleFactory.removeModuleByName("一起派对");
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("status", paramInt);
    ((Bundle)localObject).putString("key_room_id", paramString);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_set_cur_av_game_status", (Bundle)localObject, new AVGameClientQIPCModule.1(this, paramString, paramInt));
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_play_game_id", paramString);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_clean_game_result_resources", localBundle, null);
  }
  
  public boolean b()
  {
    e();
    Object localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_check_ptv_so_load_ok", (Bundle)localObject);
    return (localObject != null) && (((EIPCResult)localObject).isSuccess());
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_notify_game_start_match", localBundle, null);
  }
  
  public boolean d()
  {
    e();
    Object localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_lobby_status", (Bundle)localObject);
    boolean bool;
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkLobbyEntryStatus, isEntryLobby[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    QLog.w("AVGameClientQIPCModule", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("AVGameClientQIPCModule", 4, localStringBuilder.toString());
    }
    if ("action_notify_user_info_change".equals(paramString))
    {
      a(paramBundle, this.a);
      return null;
    }
    if ("action_notify_user_head_change".equals(paramString))
    {
      b(paramBundle, this.a);
      return null;
    }
    if ("action_notify_event".equals(paramString))
    {
      a(paramBundle);
      return null;
    }
    if ("action_notify_game_result_upload".equals(paramString)) {
      c(paramBundle, this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */