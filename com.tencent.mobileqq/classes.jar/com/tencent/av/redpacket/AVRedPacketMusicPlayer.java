package com.tencent.av.redpacket;

import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.funchat.record.PCMLoader;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import jlv;

public class AVRedPacketMusicPlayer
  implements SdkAudioFrameCallback
{
  private int jdField_a_of_type_Int;
  public MediaPlayer a;
  public VideoController a;
  public VideoAppInterface a;
  public SoundPoolHelper.OnLoadFinishListener a;
  public SoundPoolHelper a;
  private PCMLoader jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AVRedPacketMusicPlayer(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer usePcm=" + paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.b = paramBoolean;
    if (!QavVideoRecordUICtrl.f())
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer system not support, using mp3");
      this.b = false;
    }
  }
  
  private String a(int paramInt)
  {
    AVRedBagConfig.Info localInfo = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if (!localInfo.c) {
      return null;
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return a(localInfo.b, "321go");
    case 2: 
      return a(localInfo.b, "cool");
    case 3: 
      return a(localInfo.b, "perfect");
    case 4: 
      return a(localInfo.b, "miss");
    case 5: 
      return a(localInfo.b, "excellent");
    }
    return a(localInfo.b, "background" + this.jdField_a_of_type_Int);
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder().append(paramString1).append(paramString2);
    if (this.b) {}
    for (paramString1 = ".pcm";; paramString1 = ".mp3") {
      return paramString1;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().C = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a(1, null);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, mix=" + this.jdField_a_of_type_ComTencentAvVideoController.a().B);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.b(3, this.jdField_a_of_type_ComTencentAvVideoController.a().B);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, ret3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().A = false;
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader != null) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.c();
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader = null;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_Boolean = false;
        return;
        if (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper != null)
        {
          this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a();
          this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper = null;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
          this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVRedPacketMusicPlayer", 1, "setGameFinish exception", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b) {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader != null)
      {
        if (paramInt != 7) {
          break label28;
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.a();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.b();
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper != null)
      {
        String str = a(paramInt);
        this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, soundPoolHelper is null");
  }
  
  public void a(int paramInt, AVRedBagConfig.Info paramInfo)
  {
    if ((paramInfo == null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "init ,configInfo == null || mHasInit || mVideoController == null");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    String str1 = a(paramInfo.b, "321go");
    String str2 = a(paramInfo.b, "cool");
    String str3 = a(paramInfo.b, "perfect");
    String str4 = a(paramInfo.b, "miss");
    String str5 = a(paramInfo.b, "excellent");
    paramInfo = a(paramInfo.b, "background" + this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("AVRedPacketMusicPlayer", 2, "init ,bgFilePath = " + paramInfo);
    }
    if (this.b)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader = new PCMLoader(4096);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
      this.jdField_a_of_type_JavaUtilArrayList.add(str1);
      this.jdField_a_of_type_JavaUtilArrayList.add(str2);
      this.jdField_a_of_type_JavaUtilArrayList.add(str3);
      this.jdField_a_of_type_JavaUtilArrayList.add(str4);
      this.jdField_a_of_type_JavaUtilArrayList.add(str5);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInfo);
      this.jdField_a_of_type_ComTencentAvVideoController.a(1, this);
      this.jdField_a_of_type_ComTencentAvVideoController.a().C = true;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y)
      {
        paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
        QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = true, ret3=" + paramInt + ", set3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().B = true;
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = false, ret3=" + paramInt + ", set3=" + i);
      this.jdField_a_of_type_ComTencentAvVideoController.a().A = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(0);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramInfo);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketMusicPlayer", 2, "init, mediaPlayer.prepare cost = " + (l2 - l1));
      }
      paramInfo = new ArrayList();
      paramInfo.add(str1);
      paramInfo.add(str2);
      paramInfo.add(str3);
      paramInfo.add(str4);
      paramInfo.add(str5);
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper = new SoundPoolHelper(paramInfo, 0);
      return;
    }
    catch (Exception paramInfo)
    {
      for (;;)
      {
        QLog.e("AVRedPacketMusicPlayer", 1, "init  exception", paramInfo);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, musicType = " + paramInt + ",loop = " + paramBoolean);
    }
    String str;
    if (this.b) {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader != null)
      {
        str = a(paramInt);
        if (paramInt != 7) {
          break label75;
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.a(str);
      }
    }
    label75:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.b(str);
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper != null)
      {
        str = a(paramInt);
        this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a(str, paramBoolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, soundPoolHelper is null");
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(SoundPoolHelper.OnLoadFinishListener paramOnLoadFinishListener)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.i("AVRedPacketMusicPlayer", 1, "preloadMusic MusicPlayer not init, return");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper$OnLoadFinishListener = paramOnLoadFinishListener;
        if (!this.b) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          paramOnLoadFinishListener = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramOnLoadFinishListener.hasNext())
          {
            String str = (String)paramOnLoadFinishListener.next();
            this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.a(str);
          }
        }
      } while (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper$OnLoadFinishListener == null);
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper$OnLoadFinishListener.a();
      return;
    } while (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper == null);
    this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a(new jlv(this));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader != null)) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordPCMLoader.a(paramArrayOfByte, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketMusicPlayer
 * JD-Core Version:    0.7.0.1
 */