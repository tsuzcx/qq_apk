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
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        if (i != -1) {
          return bool;
        }
        if (paramAppRuntime == null)
        {
          bool = false;
        }
        else
        {
          String str = PreloadManager.a(paramAppRuntime, true, "/voicelibs/");
          if (TextUtils.isEmpty(str))
          {
            bool = false;
          }
          else
          {
            File localFile1 = new File(str, "libwxvoiceembed.so");
            File localFile2 = new File(str, "libwxvoiceembed.bin");
            if ((localFile1.exists()) && (localFile2.exists()))
            {
              i = 1;
              if (i == 0)
              {
                ((PreloadManager)paramAppRuntime.getManager(150)).a("2017112200");
                bool = false;
              }
              else
              {
                try
                {
                  System.load(localFile1.getAbsolutePath());
                  i = GrammarNative.init(str.getBytes(), "libwxvoiceembed.bin".getBytes(), null);
                  if (i >= 0) {
                    continue;
                  }
                  bool = false;
                }
                catch (Throwable paramAppRuntime)
                {
                  paramAppRuntime.printStackTrace();
                  bool = false;
                }
                continue;
                this.jdField_a_of_type_Int = 0;
              }
            }
            else
            {
              i = 0;
            }
          }
        }
      }
      finally {}
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
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 13	com/tencent/mobileqq/activity/qwallet/voice/VoiceRecognizer:jdField_a_of_type_Int	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_m1
    //   9: if_icmpeq +25 -> 34
    //   12: invokestatic 151	com/qq/wx/voice/embed/recognizer/GrammarNative:destroy	()I
    //   15: ifne +19 -> 34
    //   18: aload_0
    //   19: iconst_m1
    //   20: putfield 13	com/tencent/mobileqq/activity/qwallet/voice/VoiceRecognizer:jdField_a_of_type_Int	I
    //   23: iconst_1
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -11 -> 25
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	VoiceRecognizer
    //   6	4	1	i	int
    //   24	12	2	bool	boolean
    //   29	2	3	localException	java.lang.Exception
    //   39	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	29	java/lang/Exception
    //   2	7	39	finally
    //   12	23	39	finally
    //   30	34	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */