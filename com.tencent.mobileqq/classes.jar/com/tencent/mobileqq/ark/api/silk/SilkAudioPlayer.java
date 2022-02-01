package com.tencent.mobileqq.ark.api.silk;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class SilkAudioPlayer
{
  private final AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new SilkAudioPlayer.1(this);
  private final AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private final SilkAudioPlayer.SilkAudioPlayerListener jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public SilkAudioPlayer(@NonNull SilkAudioPlayer.SilkAudioPlayerListener paramSilkAudioPlayerListener)
  {
    if (paramSilkAudioPlayerListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener = paramSilkAudioPlayerListener;
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      return;
    }
    throw new NullPointerException("SilkAudioPlayer's listener is null");
  }
  
  private int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener.e();
      return 0;
    }
    return b(paramString);
  }
  
  private String a(String paramString)
  {
    String str;
    try
    {
      if (!FileUtil.b(paramString))
      {
        str = TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(paramString), 23, null);
        File localFile = new File(str);
        if (localFile.exists()) {
          if (localFile.length() > 0L) {
            return str;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("SilkAudioPlayer", 2, String.format("playLocal file not exist : %s", new Object[] { paramString }));
        }
        return null;
      }
      else
      {
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("SilkAudioPlayer", 1, "playLocal check resource file error ", paramString);
      return null;
    }
    return str;
  }
  
  private int b(String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, new Handler(ThreadManager.getSubThreadLooper()), 1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
          this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        }
        this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener.d();
        return 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener.e();
      QLog.e("SilkAudioPlayer", 1, "playLocal play audio error ", paramString);
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
        }
        if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
          this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop e=");
      localStringBuilder.append(localException);
      QLog.e("SilkAudioPlayer", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArkApiSilkSilkAudioPlayer$SilkAudioPlayerListener.b();
    if (a(paramString) != -1) {
      return;
    }
    ThreadManager.excute(new SilkAudioPlayer.2(this, paramString), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer
 * JD-Core Version:    0.7.0.1
 */