package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;

final class b
{
  private boolean a = false;
  private InnerAudioList b = new InnerAudioList();
  private c c = new c();
  private Thread d = null;
  private InnerSender e = new InnerSender();
  private Thread f = null;
  
  protected static void a(int paramInt)
  {
    InfoRecorder.c = paramInt;
  }
  
  protected static void a(VoiceRecognizerListener paramVoiceRecognizerListener)
  {
    InfoRecognizer.b.b = paramVoiceRecognizerListener;
  }
  
  protected static void a(String paramString)
  {
    if (paramString != null) {
      InfoHttp.d = paramString;
    }
  }
  
  protected static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InfoHttp.f = 1;
      return;
    }
    InfoHttp.f = 0;
  }
  
  protected static void b(int paramInt)
  {
    InfoRecorder.d = paramInt;
  }
  
  protected static void b(String paramString)
  {
    InfoRecognizer.m = paramString;
  }
  
  protected static void b(boolean paramBoolean)
  {
    InfoRecognizer.f = paramBoolean;
    if (paramBoolean)
    {
      InfoRecorder.f = 500;
      InfoRecorder.g = 350;
      InfoRecorder.h = 20000;
      return;
    }
    InfoRecorder.f = 200;
    InfoRecorder.g = 150;
    InfoRecorder.h = 10000;
  }
  
  protected static void c(int paramInt)
  {
    InfoHttp.e = paramInt;
  }
  
  protected static void c(boolean paramBoolean)
  {
    InfoRecognizer.g = paramBoolean;
  }
  
  protected static void d(int paramInt)
  {
    InfoHttp.b = paramInt;
  }
  
  protected static void d(boolean paramBoolean)
  {
    InfoRecognizer.a(paramBoolean);
  }
  
  protected static void e()
  {
    InfoRecognizer.n = false;
  }
  
  protected static void e(int paramInt)
  {
    InfoHttp.c = paramInt;
  }
  
  protected static void e(boolean paramBoolean)
  {
    InfoRecognizer.n = paramBoolean;
  }
  
  protected static void f(boolean paramBoolean)
  {
    InfoRecognizer.h = paramBoolean;
  }
  
  protected static void g(boolean paramBoolean)
  {
    InfoRecognizer.i = paramBoolean;
  }
  
  protected final int a()
  {
    if (InfoRecognizer.b.b == null) {}
    do
    {
      return -1;
      if (!this.a)
      {
        InfoRecognizer.b.b(-101);
        return -1;
      }
      if ((this.d != null) && (this.d.isAlive()))
      {
        InfoRecognizer.b.b(-102);
        return -1;
      }
      InfoRecognizer.b.a();
    } while (this.c.a(this.b) < 0);
    if ((this.f != null) && (this.f.isAlive()))
    {
      this.e.a();
      this.e.b();
    }
    try
    {
      this.f.join();
      this.f = null;
      this.e.a(this.b);
      this.b.a();
      this.f = new Thread(this.e);
      this.f.start();
      this.d = new Thread(this.c);
      this.d.start();
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected final int a(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {}
    for (;;)
    {
      return -1;
      InfoRecognizer.b.a = this;
      if (this.a) {
        return 0;
      }
      try
      {
        System.loadLibrary("WXVoice");
        InfoRecognizer.a = paramString;
        InfoRecognizer.c.init(paramContext);
        InfoRecognizer.d.init(paramContext);
        InfoRecognizer.e.init(paramContext);
        if (this.c.a() >= 0)
        {
          this.a = true;
          return 0;
        }
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        InfoRecognizer.b.b(-103);
        return -1;
      }
      catch (Exception paramContext)
      {
        InfoRecognizer.b.b(-103);
      }
    }
    return -1;
  }
  
  protected final int a(Context paramContext, String paramString1, String paramString2)
  {
    if (InfoRecognizer.b.b == null) {}
    for (;;)
    {
      return -1;
      InfoRecognizer.b.a = this;
      if (this.a) {
        return 0;
      }
      try
      {
        System.load(paramString2);
        InfoRecognizer.a = paramString1;
        InfoRecognizer.c.init(paramContext);
        InfoRecognizer.d.init(paramContext);
        InfoRecognizer.e.init(paramContext);
        if (this.c.a() >= 0)
        {
          this.a = true;
          return 0;
        }
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        InfoRecognizer.b.b(-103);
        return -1;
      }
      catch (Exception paramContext)
      {
        InfoRecognizer.b.b(-103);
      }
    }
    return -1;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.e.a(paramArrayOfByte);
  }
  
  protected final int b(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {}
    do
    {
      return -1;
      InfoRecognizer.b.a = this;
      if (this.a) {
        return 0;
      }
      InfoRecognizer.a = paramString;
      InfoRecognizer.c.init(paramContext);
      InfoRecognizer.d.init(paramContext);
      InfoRecognizer.e.init(paramContext);
    } while (this.c.a() < 0);
    this.a = true;
    return 0;
  }
  
  protected final void b()
  {
    if (this.d != null) {
      if (this.c != null)
      {
        this.c.b();
        this.c.e();
      }
    }
    try
    {
      this.d.join();
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected final void c()
  {
    VoiceRecordState localVoiceRecordState;
    if ((this.d != null) || (this.f != null))
    {
      localVoiceRecordState = VoiceRecordState.Canceling;
      InfoRecognizer.b.a(localVoiceRecordState);
      if (this.c != null)
      {
        this.c.c();
        this.c.e();
      }
      if (this.d == null) {}
    }
    try
    {
      this.d.join();
      this.d = null;
      if (this.e != null)
      {
        this.e.a();
        this.e.b();
      }
      if (this.f == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.f.join();
        this.f = null;
        localVoiceRecordState = VoiceRecordState.Canceled;
        InfoRecognizer.b.a(localVoiceRecordState);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  protected final void d()
  {
    if (this.a)
    {
      c();
      this.c.d();
      this.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.b
 * JD-Core Version:    0.7.0.1
 */