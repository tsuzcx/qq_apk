package com.tencent.mobileqq.activity.qwallet.voice;

import android.text.TextUtils;
import com.qq.wx.voice.embed.recognizer.GrammarNative;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;

public class VoiceRecognizer
{
  private static volatile VoiceRecognizer jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRecognizer;
  private int jdField_a_of_type_Int = -1;
  
  public static VoiceRecognizer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRecognizer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRecognizer == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRecognizer = new VoiceRecognizer();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRecognizer;
    }
    finally {}
  }
  
  public float a()
  {
    try
    {
      float f = GrammarNative.getResultCfd();
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 1.0F;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      do
      {
        try
        {
          paramInt = GrammarNative.recognize(paramArrayOfByte, paramInt);
          if (paramInt < 0)
          {
            i = -1;
            return i;
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return -1;
        }
        int i = paramInt;
      } while (paramInt != 1);
      this.jdField_a_of_type_Int = 0;
      return 1;
    }
    return 0;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramAppRuntime = ((PreloadManager)paramAppRuntime.getManager(150)).b("2017112200");
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.getResList();
        if (paramAppRuntime != null)
        {
          int i = 0;
          while (i < paramAppRuntime.size())
          {
            PreloadResource localPreloadResource = (PreloadResource)paramAppRuntime.get(i);
            if (i != 0) {
              localStringBuilder.append("&");
            }
            localStringBuilder.append(localPreloadResource.mResId);
            i += 1;
          }
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      try
      {
        int i = GrammarNative.begin();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = GrammarNative.update(paramString.getBytes("GBK"));
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_a_of_type_Int != -1) {
      return true;
    }
    if (paramAppRuntime == null) {
      return false;
    }
    String str = PreloadManager.a(paramAppRuntime, true, "/voicelibs/");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    File localFile1 = new File(str, "libwxvoiceembed.so");
    File localFile2 = new File(str, "libwxvoiceembed.bin");
    if ((localFile1.exists()) && (localFile2.exists())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((PreloadManager)paramAppRuntime.getManager(150)).a("2017112200");
        return false;
      }
      try
      {
        System.load(localFile1.getAbsolutePath());
        i = GrammarNative.init(str.getBytes(), "libwxvoiceembed.bin".getBytes(), null);
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
        return false;
      }
      this.jdField_a_of_type_Int = 0;
      return true;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 0;
      try
      {
        int i = GrammarNative.end();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */