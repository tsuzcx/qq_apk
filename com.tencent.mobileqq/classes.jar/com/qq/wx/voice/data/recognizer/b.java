package com.qq.wx.voice.data.recognizer;

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
  private volatile boolean a = false;
  private ByteArrayOutputStream b = new ByteArrayOutputStream();
  private EVad c = new EVad();
  private boolean d = false;
  private int e = 3;
  private int f = 3;
  private LinkedList g = new LinkedList();
  private int h = InfoRecorder.g / InfoRecorder.b;
  private int i = 0;
  private boolean j = true;
  private boolean k = true;
  private InnerAudioList l = null;
  private InnerSender m = new InnerSender();
  private Thread n = null;
  
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
    InfoHttp.e = paramInt;
  }
  
  protected static void b(String paramString)
  {
    InfoRecognizer.n = paramString;
  }
  
  protected static void b(boolean paramBoolean)
  {
    InfoRecognizer.g = paramBoolean;
  }
  
  protected static void c(int paramInt)
  {
    InfoHttp.b = paramInt;
  }
  
  protected static void c(boolean paramBoolean)
  {
    InfoRecognizer.f = paramBoolean;
    if (paramBoolean)
    {
      InfoRecorder.e = 500;
      InfoRecorder.f = 350;
      InfoRecorder.g = 20000;
      return;
    }
    InfoRecorder.e = 200;
    InfoRecorder.f = 150;
    InfoRecorder.g = 10000;
  }
  
  protected static void d()
  {
    InfoRecognizer.o = false;
  }
  
  protected static void d(int paramInt)
  {
    InfoHttp.c = paramInt;
  }
  
  protected static void d(boolean paramBoolean)
  {
    InfoRecognizer.j = paramBoolean;
  }
  
  protected static void e(boolean paramBoolean)
  {
    InfoRecognizer.a(paramBoolean);
  }
  
  protected static void f(boolean paramBoolean)
  {
    InfoRecognizer.o = paramBoolean;
  }
  
  protected static void g(boolean paramBoolean)
  {
    InfoRecognizer.h = paramBoolean;
  }
  
  protected static void h(boolean paramBoolean)
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
    InfoRecognizer.b.a();
    VoiceRecordState localVoiceRecordState1 = VoiceRecordState.Start;
    InfoRecognizer.b.a(localVoiceRecordState1);
    if ((this.n != null) && (this.n.isAlive()))
    {
      this.m.a();
      this.m.b();
    }
    try
    {
      this.n.join();
      this.n = null;
      this.l = new InnerAudioList();
      this.l.a();
      this.b.reset();
      this.m.a(this.l);
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.d, InfoRecorder.e, InfoRecorder.f) != 0)
      {
        InfoRecognizer.b.b(-304);
        return -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.d = false;
      this.e = 3;
      this.f = 3;
      this.g.clear();
      this.h = (InfoRecorder.g / InfoRecorder.b);
      this.i = 0;
      this.j = true;
      this.k = false;
      LogTool.d("preAudioMax = " + this.h);
      this.n = new Thread(this.m);
      this.n.start();
      VoiceRecordState localVoiceRecordState2 = VoiceRecordState.Recording;
      InfoRecognizer.b.a(localVoiceRecordState2);
    }
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
      this.a = true;
      return 0;
    }
    catch (Exception paramContext)
    {
      InfoRecognizer.b.b(-103);
    }
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
      this.a = true;
      return 0;
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
    return -1;
  }
  
  protected final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.k) {
      return 0;
    }
    if (paramArrayOfByte != null) {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte;
    int i1;
    Object localObject;
    for (;;)
    {
      try
      {
        this.b.flush();
        arrayOfByte = this.b.toByteArray();
        paramInt2 = 0;
        paramInt1 = 0;
        if (!InfoRecognizer.j) {
          break label693;
        }
        paramInt2 = InfoRecorder.b;
        if (arrayOfByte.length - paramInt1 <= paramInt2)
        {
          paramInt2 = paramInt1;
          if (!paramBoolean) {
            break label693;
          }
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.b.a(paramArrayOfByte);
          this.k = true;
          if (this.d) {
            break label608;
          }
          paramArrayOfByte = new a(null, InnerAudioState.cancel);
          if (this.l.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.b.b(-305);
          return -1;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
      paramArrayOfByte = new byte[InfoRecorder.b];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, paramInt2);
      paramInt1 += paramInt2;
      this.i += paramInt2;
      i1 = Common.calculateVolumn(paramArrayOfByte, paramInt2);
      InfoRecognizer.b.a(i1);
      this.e = this.c.AddData(paramArrayOfByte, paramInt2);
      if ((!this.d) && (this.e == 2) && (this.f == 3))
      {
        this.d = true;
        LogTool.d("speaking start: preAudio size = " + this.g.size());
        if (this.g.isEmpty()) {
          break label461;
        }
        localObject = new a((byte[])this.g.removeFirst(), InnerAudioState.begin);
        ((a)localObject).c = this.i;
        if (this.l.a((a)localObject)) {
          break label461;
        }
        InfoRecognizer.b.b(-305);
        continue;
        label309:
        localObject = new a((byte[])this.g.removeFirst(), InnerAudioState.middle);
        if (this.l.a((a)localObject)) {
          break label461;
        }
        InfoRecognizer.b.b(-305);
      }
      for (;;)
      {
        if (this.d)
        {
          if ((this.e == 3) && (this.f == 2))
          {
            if (!InfoRecognizer.f)
            {
              localObject = VoiceRecordState.Complete;
              InfoRecognizer.b.a((VoiceRecordState)localObject);
            }
            this.d = false;
            LogTool.d("speaking stop");
            this.g.clear();
            if (!InfoRecognizer.f)
            {
              paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
              paramArrayOfByte.c = this.i;
              if (!this.l.a(paramArrayOfByte))
              {
                InfoRecognizer.b.b(-305);
                break;
                label461:
                if (!this.g.isEmpty()) {
                  break label309;
                }
                continue;
              }
              this.k = true;
              return 0;
            }
            localObject = new a(paramArrayOfByte, InnerAudioState.end);
            ((a)localObject).c = this.i;
            if (this.l.a((a)localObject)) {
              break label564;
            }
            InfoRecognizer.b.b(-305);
            break;
          }
          localObject = new a(paramArrayOfByte, InnerAudioState.middle);
          if (!this.l.a((a)localObject))
          {
            InfoRecognizer.b.b(-305);
            break;
          }
        }
      }
      label564:
      this.f = this.e;
      this.g.add(paramArrayOfByte);
      if (this.g.size() > this.h) {
        this.g.removeFirst();
      }
    }
    return 0;
    label608:
    paramInt2 = paramInt1;
    if (this.d)
    {
      this.d = false;
      LogTool.d("speaking stop");
      paramArrayOfByte = new byte[arrayOfByte.length - paramInt1];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, arrayOfByte.length - paramInt1);
      paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
      paramArrayOfByte.c = this.i;
      if (!this.l.a(paramArrayOfByte))
      {
        InfoRecognizer.b.b(-305);
        return -1;
      }
      return 0;
    }
    label693:
    paramInt1 = paramInt2;
    if (!InfoRecognizer.j)
    {
      i1 = InfoRecorder.b;
      if (arrayOfByte.length - paramInt2 <= i1)
      {
        label716:
        paramInt1 = paramInt2;
        if (paramBoolean)
        {
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.b.a(paramArrayOfByte);
          this.k = true;
          paramArrayOfByte = new byte[arrayOfByte.length - paramInt2];
          System.arraycopy(arrayOfByte, paramInt2, paramArrayOfByte, 0, arrayOfByte.length - paramInt2);
          paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
          paramInt1 = paramInt2;
          if (!this.l.a(paramArrayOfByte))
          {
            InfoRecognizer.b.b(-305);
            return -1;
          }
        }
      }
      else
      {
        localObject = new byte[InfoRecorder.b];
        System.arraycopy(arrayOfByte, paramInt2, localObject, 0, i1);
        paramInt1 = paramInt2 + i1;
        this.i += i1;
        paramInt2 = Common.calculateVolumn((byte[])localObject, i1);
        InfoRecognizer.b.a(paramInt2);
        if (this.j) {}
        for (paramArrayOfByte = InnerAudioState.begin;; paramArrayOfByte = InnerAudioState.middle)
        {
          paramArrayOfByte = new a((byte[])localObject, paramArrayOfByte);
          this.j = false;
          paramInt2 = paramInt1;
          if (this.l.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.b.b(-305);
          paramInt2 = paramInt1;
          break label716;
        }
      }
    }
    this.b.reset();
    this.b.write(arrayOfByte, paramInt1, arrayOfByte.length - paramInt1);
    return 0;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.m.a(paramArrayOfByte);
  }
  
  protected final void b()
  {
    VoiceRecordState localVoiceRecordState;
    if (this.n != null)
    {
      localVoiceRecordState = VoiceRecordState.Canceling;
      InfoRecognizer.b.a(localVoiceRecordState);
      if (this.m != null)
      {
        this.m.a();
        this.m.b();
      }
      if (this.n == null) {}
    }
    try
    {
      this.n.join();
      this.n = null;
      localVoiceRecordState = VoiceRecordState.Canceled;
      InfoRecognizer.b.a(localVoiceRecordState);
      this.k = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected final void c()
  {
    if (this.a)
    {
      b();
      this.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.b
 * JD-Core Version:    0.7.0.1
 */