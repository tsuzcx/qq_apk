package com.tencent.avgame.ipc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
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
  private final AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private final AVGameClientQIPCModule.MyIPCConListener jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener;
  
  public AVGameClientQIPCModule(AVGameAppInterface paramAVGameAppInterface)
  {
    super("AVGameClientQIPCModule");
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener = new AVGameClientQIPCModule.MyIPCConListener(this, null);
    QIPCClientHelper.getInstance().register(this);
    QIPCClientHelper.getInstance().getClient().addListener(this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener);
    c();
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("key_event_id");
    boolean bool = paramBundle.getBoolean("key_event_ret");
    paramBundle = paramBundle.getString("key_event_msg");
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameClientQIPCModule", 4, "notifyEvent, eventId[" + i + "], result[" + bool + "], msg[" + paramBundle + "]");
    }
    ObserverCenter.a().a(IPCEventObserver.class, i, bool, paramBundle);
  }
  
  private void a(Bundle paramBundle, AVGameAppInterface paramAVGameAppInterface)
  {
    if ((paramBundle == null) || (paramAVGameAppInterface == null)) {}
    int i;
    String str;
    do
    {
      return;
      i = paramBundle.getInt("key_type");
      str = paramBundle.getString("key_uin");
      paramBundle.setClassLoader(UserInfo.class.getClassLoader());
      paramBundle = (UserInfo)paramBundle.getParcelable("key_result");
      paramAVGameAppInterface = (UserInfoHandler)paramAVGameAppInterface.getBusinessHandler(HandlerFactory.b);
      if (paramAVGameAppInterface != null) {
        paramAVGameAppInterface.a(i, str, paramBundle);
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("AVGameClientQIPCModule", 4, "notifyUserInfoChange, uinType[" + i + "], uin[" + str + "], info[" + paramBundle + "]");
  }
  
  private void b(Bundle paramBundle, AVGameAppInterface paramAVGameAppInterface)
  {
    if ((paramBundle == null) || (paramAVGameAppInterface == null)) {}
    int i;
    String str;
    int j;
    do
    {
      return;
      i = paramBundle.getInt("key_face_type");
      str = paramBundle.getString("key_uin");
      j = paramBundle.getInt("key_id_type");
      paramBundle = (UserInfoHandler)paramAVGameAppInterface.getBusinessHandler(HandlerFactory.b);
      if (paramBundle != null) {
        paramBundle.notifyUI(1, true, new Object[] { Integer.valueOf(i), str, Integer.valueOf(j) });
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("AVGameClientQIPCModule", 4, "notifyUserHeadChange, faceType[" + i + "], uin[" + str + "], idType[" + j + "]");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameClientQIPCModule", 2, "connect, [" + this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener.a.get() + "]");
    }
    QIPCClientHelper.getInstance().getClient().connect(this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule$MyIPCConListener);
  }
  
  private void c(Bundle paramBundle, AVGameAppInterface paramAVGameAppInterface)
  {
    if ((paramBundle == null) || (paramAVGameAppInterface == null)) {
      return;
    }
    boolean bool = paramBundle.getBoolean("key_event_ret");
    String str = paramBundle.getString("key_play_game_id");
    int i = paramBundle.getInt("key_file_type");
    paramBundle = paramBundle.getString("key_file_url");
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameClientQIPCModule_GameRC", 4, "notifyGameResultUpload, playId[" + str + "], fileType[" + i + "], fileUrl[" + paramBundle + "]");
    }
    ((GamePlayHandler)paramAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).notifyUI(11, bool, new Object[] { str, Integer.valueOf(i), paramBundle });
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      c();
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_face_type", paramInt1);
      localBundle.putString("key_uin", paramString);
      localBundle.putByte("key_shape", paramByte);
      localBundle.putInt("key_id_type", paramInt2);
      paramString = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_user_head", localBundle);
    } while ((paramString == null) || (!paramString.isSuccess()) || (paramString.data == null));
    return (Bitmap)paramString.data.getParcelable("key_result");
  }
  
  public UserInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      c();
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_type", paramInt);
      localBundle.putString("key_uin", paramString);
      paramString = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_user_info", localBundle);
    } while ((paramString == null) || (!paramString.isSuccess()) || (paramString.data == null));
    paramString.data.setClassLoader(UserInfo.class.getClassLoader());
    return (UserInfo)paramString.data.getParcelable("key_result");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameClientQIPCModule", 2, "disconnect");
    }
    QIPCClientHelper.getInstance().disconnect();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameClientQIPCModule", 2, "setCurrentAvGameStatus nCurrentStatus:" + paramInt + " roomId:" + paramString, new Throwable("not crash, print stack"));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt);
    localBundle.putString("key_room_id", paramString);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_set_cur_av_game_status", localBundle, new AVGameClientQIPCModule.1(this, paramString, paramInt));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameClientQIPCModule", 2, "notifySendMsg shareType:" + paramInt + " friendUin:" + paramString1 + " roomId:" + paramString2, new Throwable("print stack"));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_type", paramInt);
    localBundle.putString("key_uin", paramString1);
    localBundle.putString("key_room_id", paramString2);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_notify_send_msg", localBundle, null);
  }
  
  public void a(int paramInt, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramHashMap == null)) {}
    do
    {
      do
      {
        return;
        c();
        ArrayList localArrayList = new ArrayList(paramList.size());
        localArrayList.addAll(paramList);
        paramList = new Bundle();
        paramList.putInt("key_type", paramInt);
        paramList.putStringArrayList("key_uin_list", localArrayList);
        paramList = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_nicks", paramList);
      } while ((paramList == null) || (!paramList.isSuccess()) || (paramList.data == null));
      paramList.data.setClassLoader(MapParcelable.class.getClassLoader());
      paramList = (MapParcelable)paramList.data.getParcelable("key_result");
    } while (paramList == null);
    paramHashMap.putAll(paramList.a);
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
  
  public boolean a()
  {
    boolean bool2 = false;
    c();
    Object localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_check_ptv_so_load_ok", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).isSuccess()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_notify_game_start_match", localBundle, null);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_play_game_id", paramString);
    QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_clean_game_result_resources", localBundle, null);
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    c();
    Object localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().callServer("AVGameServerIPCModule", "action_get_lobby_status", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).isSuccess()) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameClientQIPCModule", 4, "onCall, action[" + paramString + "]");
    }
    if ("action_notify_user_info_change".equals(paramString)) {
      a(paramBundle, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
    }
    do
    {
      return null;
      if ("action_notify_user_head_change".equals(paramString))
      {
        b(paramBundle, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
        return null;
      }
      if ("action_notify_event".equals(paramString))
      {
        a(paramBundle);
        return null;
      }
    } while (!"action_notify_game_result_upload".equals(paramString));
    c(paramBundle, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */