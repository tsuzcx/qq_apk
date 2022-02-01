package com.tencent.mobileqq.apollo.lightGame;

import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.util.WeakReferenceHandler;
import cooperation.gmesdk.GMESDKIPC;
import cooperation.gmesdk.GMESDK_Event;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameAudioManager
  implements Handler.Callback, AudioPlayerBase.AudioPlayerListener, QQRecorder.OnQQRecorderListener, GMESDK_Event
{
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  public static String d;
  private int jdField_a_of_type_Int;
  public long a;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CmGameAudioManager.GameMsgListener jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$GameMsgListener;
  private CmGameAudioManager.TPHandler jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public WeakReference<CmGameAudioManager.RecorderEventListener> a;
  private int b;
  public WeakReference<CmGameAudioManager.UploadEventListener> b;
  private WeakReference<CmGameChatPie> jdField_c_of_type_JavaLangRefWeakReference;
  boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private String jdField_e_of_type_JavaLangString = "";
  private volatile boolean jdField_e_of_type_Boolean = false;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private String g;
  private String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "1400035750";
    jdField_b_of_type_JavaLangString = "5d3728db75adf458";
    jdField_c_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
    jdField_d_of_type_JavaLangString = "105d1e43c456bc800b4adacd57ac1199";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public CmGameAudioManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$GameMsgListener = new CmGameAudioManager.GameMsgListener(paramQQAppInterface);
    ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$GameMsgListener);
    GMESDKIPC.a().a(this);
    a();
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[onReportRecordInfoResp] upload record succ.");
        }
        ((CmGameAudioManager.UploadEventListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
      }
    }
    else {
      return;
    }
    ((CmGameAudioManager.UploadEventListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramInt);
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[onReportRecordInfoResp] uploadError,retcode:" + paramInt);
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt, CmGameAudioManager.RecorderEventListener paramRecorderEventListener)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRecorderEventListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      paramRecorderEventListener = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderEventListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    paramRecorderEventListener = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/audioRecord/");
    if (!paramRecorderEventListener.exists()) {
      paramRecorderEventListener.mkdirs();
    }
    paramRecorderEventListener = b();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderEventListener, true);
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] start record");
  }
  
  public void a(Bundle paramBundle)
  {
    int i = 2;
    String str = paramBundle.getString("gmesdk_event_key");
    int j = paramBundle.getInt("gmesdk_event_ret");
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j);
    if ("gmesdk_event_key_enterroom".equals(str))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j + ",roomId:" + this.h);
      if ((j == 0) || (j == 1003))
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_e_of_type_JavaLangString = this.g;
        this.jdField_f_of_type_JavaLangString = this.h;
        ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, true, this.jdField_a_of_type_Int);
        a(true, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 319) {
          i = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 0, new String[0]);
      }
    }
    while (!"gmesdk_event_key_exit_room".equals(str))
    {
      return;
      ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
      a(false, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 319) {
        i = 1;
      }
      VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 1, new String[0]);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
    a(false, this.jdField_e_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Int == 319) {
      i = 1;
    }
    VipUtils.a(null, "cmshow", "Apollo", "turnOffAudio", i, 0, new String[0]);
  }
  
  public void a(CmGameChatPie paramCmGameChatPie)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameChatPie);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[AudioPlayerListener] onError:" + paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[audioSwitch] friUin:" + paramString + ",from:" + paramInt + ",mCurrentFriUin:" + this.jdField_e_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!a());
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      if (paramString.equals(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
      if (paramInt == 318)
      {
        paramString = new Bundle();
        paramString.putString("key_game_friUin", this.jdField_e_of_type_JavaLangString);
        paramString.putString("key_dialog_type", "dialog_type_confirm");
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", paramString, null);
        return;
      }
    } while ((this.jdField_c_of_type_JavaLangRefWeakReference == null) || (this.jdField_c_of_type_JavaLangRefWeakReference.get() == null));
    ((CmGameChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get()).j("dialog_type_confirm");
    return;
    b(paramString, paramInt);
  }
  
  public void a(String paramString, CmGameAudioManager.UploadEventListener paramUploadEventListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[uploadFile] uploadFile:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler = new CmGameAudioManager.TPHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramUploadEventListener);
    if (localITransFileController != null)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        localITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler);
        this.jdField_c_of_type_Boolean = true;
      }
      paramUploadEventListener = new TransferRequest();
      paramUploadEventListener.mFileType = 24;
      paramUploadEventListener.mCommandId = 36;
      paramUploadEventListener.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      paramUploadEventListener.mPeerUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      paramUploadEventListener.mIsUp = true;
      paramUploadEventListener.mRequestLength = ((int)new File(paramString).length());
      paramUploadEventListener.mLocalPath = paramString;
      localITransFileController.transferAsync(paramUploadEventListener);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[enterRoom] friUin:" + paramString1 + ",roomId:" + paramString2 + ",from:" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[enterRoom] uin or roomId is empty");
      return;
    }
    Bundle localBundle;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      if (paramInt != 318) {
        break label225;
      }
      localBundle = new Bundle();
      localBundle.putString("key_dialog_type", "dialog_type_permission");
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", localBundle, null);
    }
    for (;;)
    {
      localBundle = new Bundle();
      localBundle.putString("uin", paramString1);
      localBundle.putString("friUin", paramString1);
      localBundle.putString("roomId", paramString2);
      localBundle.putInt("from", paramInt);
      paramString1 = Message.obtain();
      paramString1.setData(localBundle);
      paramString1.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
      label225:
      if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null)) {
        ((CmGameChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get()).j("dialog_type_permission");
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference != null)
    {
      CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
      if ((localCmGameChatPie != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localCmGameChatPie.b()))) {
        localCmGameChatPie.t(paramBoolean);
      }
    }
    CmGameServerQIPCModule.a().a(paramBoolean, paramString);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    if (this.jdField_f_of_type_Boolean) {
      return true;
    }
    boolean bool1;
    if (ApolloConfigUtils.d != null)
    {
      jdField_a_of_type_JavaLangString = ApolloConfigUtils.d.optString("appid", "1400035750");
      jdField_b_of_type_JavaLangString = ApolloConfigUtils.d.optString("key", "5d3728db75adf458");
      jdField_c_of_type_JavaLangString = ApolloConfigUtils.d.optString("url", "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip");
      jdField_d_of_type_JavaLangString = ApolloConfigUtils.d.optString("md5", "105d1e43c456bc800b4adacd57ac1199");
      if (ApolloConfigUtils.d.optInt("openAudio", 0) != 0)
      {
        bool1 = true;
        jdField_a_of_type_Boolean = bool1;
        bool1 = bool2;
        if (ApolloConfigUtils.d.optInt("display", 0) != 0) {
          bool1 = true;
        }
        jdField_b_of_type_Boolean = bool1;
        QLog.i("CmGameTemp_CmGameAudioManager", 1, "[initParams] appId:" + jdField_a_of_type_JavaLangString + ",key:" + jdField_b_of_type_JavaLangString + ",url:" + jdField_c_of_type_JavaLangString + ",md5:" + jdField_d_of_type_JavaLangString + ",OPEN_AUDIO:" + jdField_a_of_type_Boolean + ",sDISPLAY:" + jdField_b_of_type_Boolean);
        GMESDKIPC.a().a(jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString);
      }
    }
    for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = false)
    {
      return this.jdField_f_of_type_Boolean;
      bool1 = false;
      break;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[initParams] gameAudioConfig is null");
    }
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)) && (this.jdField_e_of_type_Boolean);
  }
  
  public String b()
  {
    return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/audioRecord/" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".amr";
  }
  
  public void b()
  {
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().b(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$GameMsgListener);
    GMESDKIPC.a().a();
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localITransFileController != null)
    {
      localITransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameAudioManager$TPHandler = null;
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[queryRoomAndEnter] friUin:" + paramString + ",currentRoom:" + this.jdField_f_of_type_JavaLangString);
    }
    if (!a()) {
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    localApolloManagerServiceImpl.getGameTempMsgHandler().b(paramString, paramInt);
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[playUserRecord] play record:" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
        {
          if (QLog.isColorLevel()) {
            QLog.i("CmGameTemp_CmGameAudioManager", 0, "record is playing");
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        if (TextUtils.isEmpty(paramString))
        {
          if (!new File(b()).exists())
          {
            QLog.e("CmGameTemp_CmGameAudioManager", 1, "audio file not exist.");
            return false;
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(b());
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return true;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return true;
      }
      catch (IOException paramString)
      {
        QLog.e("CmGameTemp_CmGameAudioManager", 1, paramString.getMessage());
        return false;
      }
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void c(String paramString, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[exitRoom] uin:" + paramString + ",from:" + paramInt + ",mCurrentUin:" + this.jdField_e_of_type_JavaLangString + ",mCurrentRoomId:" + this.jdField_f_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!paramString.equals(this.jdField_e_of_type_JavaLangString)));
      if (paramInt != 318) {
        break;
      }
      paramInt = i;
      if (this.jdField_c_of_type_JavaLangRefWeakReference != null)
      {
        paramInt = i;
        if (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null) {
          paramInt = 1;
        }
      }
    } while ((paramInt != 0) && (this.jdField_e_of_type_JavaLangString.equals(((CmGameChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get()).b())));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return;
    if (CmGameUtil.a(BaseApplicationImpl.getContext()))
    {
      paramString = new CmGameAudioManager.1(this);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", this.jdField_e_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_running", localBundle, paramString);
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[exitRoom] game is not exist. exit room");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] stop record");
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      bool = true;
    }
    return bool;
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public boolean d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[stopUserRecord] stop record:");
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        return true;
      }
      return false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] exitRoom,roomId:" + this.jdField_f_of_type_JavaLangString);
      GMESDKIPC.a().a(false);
      GMESDKIPC.a().b(false);
      GMESDKIPC.a().a(this.jdField_f_of_type_JavaLangString);
      return false;
    }
    paramMessage = paramMessage.getData();
    String str1 = paramMessage.getString("uin");
    String str2 = paramMessage.getString("roomId");
    int i = paramMessage.getInt("from");
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] enterRoom,uin:" + str1 + ",roomId:" + str2 + ",from:" + i);
    this.g = str1;
    this.h = str2;
    this.jdField_a_of_type_Int = i;
    GMESDKIPC.a().a(this.jdField_f_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      GMESDKIPC.a().a(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), jdField_b_of_type_JavaLangString, str2, true, true);
      return false;
    }
    QLog.e("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] appid or key is null!enter room failed");
    return false;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onBeginReceiveData");
    return this.jdField_b_of_type_Int * 1000;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitFailed");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-1);
    }
  }
  
  public void onInitSuccess()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitSuccess");
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderAbnormal");
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderEnd,totalTime:" + paramDouble);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    }
    int i;
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label107;
      }
      i = 1;
      if (i != 0) {
        break label113;
      }
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = (paramDouble);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      }
      return;
      label107:
      i = 0;
      break;
      label113:
      PttBuffer.b(paramString);
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderError");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-2);
    }
  }
  
  public void onRecorderNotReady(String paramString)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderNotReady");
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    int i = 1;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderPrepare");
    byte[] arrayOfByte = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    while (i == 0)
    {
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      return;
      i = 0;
    }
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, arrayOfByte, arrayOfByte.length);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderSilceEnd size：" + paramInt1);
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public int onRecorderStart()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderStart");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderVolumeStateChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager
 * JD-Core Version:    0.7.0.1
 */