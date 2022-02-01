package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;
import com.qq.wx.voice.vad.EVad;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

final class b
{
  private boolean a = false;
  private ByteArrayOutputStream b = new ByteArrayOutputStream();
  private EVad c = new EVad();
  private boolean d = false;
  private int e = 3;
  private int f = 3;
  private boolean g = true;
  private LinkedList h = new LinkedList();
  private int i = InfoRecorder.h / InfoRecorder.b;
  private int j = 0;
  private boolean k = true;
  private boolean l = true;
  private InnerAudioList m = new InnerAudioList();
  private c n = new c();
  private Thread o = null;
  private InnerSender p = new InnerSender();
  private Thread q = null;
  
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
    InfoRecognizer.j = paramBoolean;
  }
  
  protected static void b(int paramInt)
  {
    InfoRecorder.d = paramInt;
  }
  
  protected static void b(String paramString)
  {
    InfoRecognizer.o = paramString;
  }
  
  protected static void b(boolean paramBoolean)
  {
    InfoRecognizer.k = paramBoolean;
  }
  
  protected static void c(int paramInt)
  {
    InfoHttp.e = paramInt;
  }
  
  protected static void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InfoHttp.f = 1;
      return;
    }
    InfoHttp.f = 0;
  }
  
  protected static void d(int paramInt)
  {
    InfoHttp.b = paramInt;
  }
  
  protected static void d(boolean paramBoolean)
  {
    InfoRecognizer.f = paramBoolean;
    if (paramBoolean)
    {
      InfoRecorder.f = 500;
      InfoRecorder.g = 350;
      InfoRecorder.h = 20000;
      return;
    }
    InfoRecorder.f = 300;
    InfoRecorder.g = 225;
    InfoRecorder.h = 10000;
  }
  
  protected static void e(int paramInt)
  {
    InfoHttp.c = paramInt;
  }
  
  protected static void e(boolean paramBoolean)
  {
    InfoRecognizer.g = paramBoolean;
  }
  
  protected static void f()
  {
    InfoRecognizer.p = false;
  }
  
  protected static void f(boolean paramBoolean)
  {
    InfoRecognizer.a(paramBoolean);
  }
  
  protected static void g(boolean paramBoolean)
  {
    InfoRecognizer.p = paramBoolean;
  }
  
  protected static void h(boolean paramBoolean)
  {
    InfoRecognizer.h = paramBoolean;
  }
  
  protected static void i(boolean paramBoolean)
  {
    InfoRecognizer.i = paramBoolean;
  }
  
  protected final int a()
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    if (!this.a)
    {
      InfoRecognizer.b.b(-101);
      return -1;
    }
    Thread localThread = this.o;
    if ((localThread != null) && (localThread.isAlive()))
    {
      InfoRecognizer.b.b(-102);
      return -1;
    }
    InfoRecognizer.b.a();
    if (this.n.a(this.m) < 0) {
      return -1;
    }
    localThread = this.q;
    if ((localThread != null) && (localThread.isAlive()))
    {
      this.p.a();
      this.p.b();
      try
      {
        this.q.join();
        this.q = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.p.a(this.m);
    this.m.a();
    this.q = new Thread(this.p);
    this.q.start();
    this.o = new Thread(this.n);
    this.o.start();
    return 0;
  }
  
  protected final int a(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
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
      paramContext = this.n;
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
      {
        InfoRecognizer.b.b(-304);
        return -1;
      }
      this.a = true;
      return 0;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      break label116;
    }
    catch (Exception paramContext)
    {
      label106:
      label116:
      break label106;
    }
    InfoRecognizer.b.b(-103);
    return -1;
    InfoRecognizer.b.b(-103);
    return -1;
  }
  
  protected final int a(Context paramContext, String paramString1, String paramString2)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
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
      paramContext = this.n;
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
      {
        InfoRecognizer.b.b(-304);
        return -1;
      }
      this.a = true;
      return 0;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      break label115;
    }
    catch (Exception paramContext)
    {
      label105:
      label115:
      break label105;
    }
    InfoRecognizer.b.b(-103);
    return -1;
    InfoRecognizer.b.b(-103);
    return -1;
  }
  
  protected final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.l) {
      return 0;
    }
    if (paramArrayOfByte != null)
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      try
      {
        this.b.flush();
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
    }
    byte[] arrayOfByte = this.b.toByteArray();
    int i1;
    Object localObject;
    if (InfoRecognizer.j)
    {
      int i2 = InfoRecorder.b;
      paramInt1 = 0;
      label699:
      label854:
      label893:
      for (;;)
      {
        if (arrayOfByte.length - paramInt1 <= i2)
        {
          paramInt2 = paramInt1;
        }
        else
        {
          paramArrayOfByte = new byte[InfoRecorder.b];
          System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, i2);
          paramInt1 += i2;
          if (this.j == 0)
          {
            paramInt2 = 0;
            i1 = 0;
            while ((paramInt2 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt2] == 0))
            {
              i1 += 1;
              paramInt2 += 1;
            }
            if (i1 > paramArrayOfByte.length / 2) {
              break label893;
            }
          }
          this.j += i2;
          if (InfoRecorder.d > 0)
          {
            localObject = new StringBuilder("timeOffset = ");
            ((StringBuilder)localObject).append(this.j);
            ((StringBuilder)localObject).append(" timeOut = ");
            ((StringBuilder)localObject).append((InfoRecorder.a << 1) * InfoRecorder.d / 1000);
            LogTool.d(((StringBuilder)localObject).toString());
            if ((this.g) && (this.j > (InfoRecorder.a << 1) * InfoRecorder.d / 1000L))
            {
              InfoRecognizer.b.b(-307);
              break label699;
            }
          }
          paramInt2 = Common.calculateVolumn(paramArrayOfByte, i2);
          InfoRecognizer.b.a(paramInt2);
          this.e = this.c.AddData(paramArrayOfByte, i2);
          if ((!this.d) && (this.e == 2) && (this.f == 3))
          {
            this.d = true;
            this.g = false;
            localObject = new StringBuilder("speaking start: preAudio size = ");
            ((StringBuilder)localObject).append(this.h.size());
            LogTool.d(((StringBuilder)localObject).toString());
            if (!this.h.isEmpty())
            {
              localObject = new a((byte[])this.h.removeFirst(), InnerAudioState.begin);
              ((a)localObject).c = this.j;
              if (!this.m.a((a)localObject))
              {
                InfoRecognizer.b.b(-305);
                break label699;
              }
            }
            while (!this.h.isEmpty())
            {
              localObject = new a((byte[])this.h.removeFirst(), InnerAudioState.middle);
              ((a)localObject).c = this.j;
              if (!this.m.a((a)localObject)) {
                InfoRecognizer.b.b(-305);
              }
            }
          }
          else
          {
            if (!this.d) {
              break label854;
            }
            if ((this.e == 3) && (this.f == 2))
            {
              if (!InfoRecognizer.f)
              {
                localObject = VoiceRecordState.Complete;
                InfoRecognizer.b.a((VoiceRecordState)localObject);
              }
              this.d = false;
              LogTool.d("speaking stop");
              this.h.clear();
              if (!InfoRecognizer.f)
              {
                paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
                paramArrayOfByte.c = this.j;
                if (!this.m.a(paramArrayOfByte))
                {
                  InfoRecognizer.b.b(-305);
                }
                else
                {
                  this.l = true;
                  return 0;
                }
              }
              else
              {
                localObject = new a(paramArrayOfByte, InnerAudioState.end);
                ((a)localObject).c = this.j;
                if (this.m.a((a)localObject)) {
                  break label854;
                }
                InfoRecognizer.b.b(-305);
              }
            }
            else
            {
              localObject = new a(paramArrayOfByte, InnerAudioState.middle);
              ((a)localObject).c = this.j;
              if (this.m.a((a)localObject)) {
                break label854;
              }
              InfoRecognizer.b.b(-305);
            }
          }
          paramInt2 = paramInt1;
        }
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break;
        }
        paramArrayOfByte = VoiceRecordState.Complete;
        InfoRecognizer.b.a(paramArrayOfByte);
        this.l = true;
        boolean bool = this.d;
        if (!bool)
        {
          paramArrayOfByte = new a(null, InnerAudioState.cancel);
          if (!this.m.a(paramArrayOfByte))
          {
            InfoRecognizer.b.b(-305);
            return -1;
          }
          return 0;
        }
        paramInt1 = paramInt2;
        if (!bool) {
          break;
        }
        this.d = false;
        LogTool.d("speaking stop");
        paramArrayOfByte = new byte[arrayOfByte.length - paramInt2];
        System.arraycopy(arrayOfByte, paramInt2, paramArrayOfByte, 0, arrayOfByte.length - paramInt2);
        paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
        paramArrayOfByte.c = this.j;
        if (!this.m.a(paramArrayOfByte))
        {
          InfoRecognizer.b.b(-305);
          return -1;
        }
        return 0;
        this.f = this.e;
        this.h.add(paramArrayOfByte);
        if (this.h.size() > this.i) {
          this.h.removeFirst();
        }
      }
    }
    paramInt1 = 0;
    paramInt2 = paramInt1;
    if (!InfoRecognizer.j)
    {
      i1 = InfoRecorder.b;
      while (arrayOfByte.length - paramInt1 > i1)
      {
        localObject = new byte[InfoRecorder.b];
        System.arraycopy(arrayOfByte, paramInt1, localObject, 0, i1);
        paramInt2 = paramInt1 + i1;
        this.j += i1;
        paramInt1 = Common.calculateVolumn((byte[])localObject, i1);
        InfoRecognizer.b.a(paramInt1);
        if (this.k) {
          paramArrayOfByte = InnerAudioState.begin;
        } else {
          paramArrayOfByte = InnerAudioState.middle;
        }
        paramArrayOfByte = new a((byte[])localObject, paramArrayOfByte);
        this.k = false;
        paramInt1 = paramInt2;
        if (!this.m.a(paramArrayOfByte))
        {
          InfoRecognizer.b.b(-305);
          paramInt1 = paramInt2;
        }
      }
      paramInt2 = paramInt1;
      if (paramBoolean)
      {
        paramArrayOfByte = VoiceRecordState.Complete;
        InfoRecognizer.b.a(paramArrayOfByte);
        this.l = true;
        paramArrayOfByte = new byte[arrayOfByte.length - paramInt1];
        System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, arrayOfByte.length - paramInt1);
        paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
        paramInt2 = paramInt1;
        if (!this.m.a(paramArrayOfByte))
        {
          InfoRecognizer.b.b(-305);
          return -1;
        }
      }
    }
    this.b.reset();
    this.b.write(arrayOfByte, paramInt2, arrayOfByte.length - paramInt2);
    return 0;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.p.a(paramArrayOfByte);
  }
  
  protected final int b(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    InfoRecognizer.b.a = this;
    if (this.a) {
      return 0;
    }
    InfoRecognizer.a = paramString;
    InfoRecognizer.c.init(paramContext);
    InfoRecognizer.d.init(paramContext);
    InfoRecognizer.e.init(paramContext);
    paramContext = this.n;
    if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
    {
      InfoRecognizer.b.b(-304);
      return -1;
    }
    this.a = true;
    return 0;
  }
  
  protected final void b()
  {
    if (this.o != null)
    {
      c localc = this.n;
      if (localc != null)
      {
        localc.a();
        this.n.d();
      }
      try
      {
        this.o.join();
        this.o = null;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected final void c()
  {
    if ((this.o != null) || (this.q != null))
    {
      Object localObject1 = VoiceRecordState.Canceling;
      InfoRecognizer.b.a((VoiceRecordState)localObject1);
      localObject1 = this.n;
      if (localObject1 != null)
      {
        ((c)localObject1).b();
        this.n.d();
      }
      localObject1 = this.o;
      if (localObject1 != null) {
        try
        {
          ((Thread)localObject1).join();
          this.o = null;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      Object localObject2 = this.p;
      if (localObject2 != null)
      {
        ((InnerSender)localObject2).a();
        this.p.b();
      }
      localObject2 = this.q;
      if (localObject2 != null) {
        try
        {
          ((Thread)localObject2).join();
          this.q = null;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      VoiceRecordState localVoiceRecordState = VoiceRecordState.Canceled;
      InfoRecognizer.b.a(localVoiceRecordState);
    }
  }
  
  protected final void d()
  {
    if (this.a)
    {
      c();
      this.n.c();
      this.c.Release();
      this.a = false;
    }
  }
  
  protected final int e()
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    if (!this.a)
    {
      InfoRecognizer.b.b(-101);
      return -1;
    }
    InfoRecognizer.b.a();
    Object localObject1 = VoiceRecordState.Start;
    InfoRecognizer.b.a((VoiceRecordState)localObject1);
    localObject1 = this.q;
    if ((localObject1 != null) && (((Thread)localObject1).isAlive()))
    {
      this.p.a();
      this.p.b();
      try
      {
        this.q.join();
        this.q = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.m = new InnerAudioList();
    this.m.a();
    this.b.reset();
    this.p.a(this.m);
    this.c.Reset();
    this.d = false;
    this.e = 3;
    this.f = 3;
    this.g = true;
    this.h.clear();
    this.i = (InfoRecorder.h / InfoRecorder.b);
    this.j = 0;
    this.k = true;
    this.l = false;
    Object localObject2 = new StringBuilder("preAudioMax = ");
    ((StringBuilder)localObject2).append(this.i);
    LogTool.d(((StringBuilder)localObject2).toString());
    this.q = new Thread(this.p);
    this.q.start();
    localObject2 = VoiceRecordState.Recording;
    InfoRecognizer.b.a((VoiceRecordState)localObject2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.b
 * JD-Core Version:    0.7.0.1
 */