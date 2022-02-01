package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import com.qq.wx.voice.embedqqegg.util.Common;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import com.qq.wx.voice.embedqqegg.vad.EVad;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

final class c
{
  private boolean a = false;
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
  private InnerAudioList l = new InnerAudioList();
  private InnerSender m = new InnerSender();
  private Thread n = null;
  
  protected static void a(int paramInt)
  {
    InfoRecorder.c = paramInt;
  }
  
  protected static void a(VoiceRecognizerListener paramVoiceRecognizerListener)
  {
    InfoRecognizer.d.b = paramVoiceRecognizerListener;
  }
  
  protected static void a(boolean paramBoolean)
  {
    InfoRecognizer.f = paramBoolean;
  }
  
  protected static void b(boolean paramBoolean)
  {
    InfoRecognizer.g = paramBoolean;
  }
  
  protected static int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      InfoRecognizer.e = paramInt;
      return 0;
    }
    return -1;
  }
  
  protected static void c(boolean paramBoolean)
  {
    InfoRecognizer.h = paramBoolean;
  }
  
  protected final int a(Context paramContext)
  {
    if (InfoRecognizer.d.b == null) {
      return -1;
    }
    InfoRecognizer.d.a = this;
    if (this.a) {
      return 0;
    }
    try
    {
      if (InfoRecognizer.b == null) {
        System.loadLibrary("wxvoiceembedqqegg");
      }
      for (;;)
      {
        InfoRecognizer.a = paramContext;
        if (this.m.a() >= 0) {
          break;
        }
        return -1;
        LogTool.d("init by soWXVoiceEmbedPath: " + InfoRecognizer.b);
        if (!new File(InfoRecognizer.b).exists()) {
          LogTool.d("no found: " + InfoRecognizer.b);
        }
        System.load(InfoRecognizer.b);
      }
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.d, InfoRecorder.e, InfoRecorder.f) == 0) {
        break label195;
      }
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      InfoRecognizer.b = null;
      InfoRecognizer.c = null;
      InfoRecognizer.d.b(-103);
      return -1;
    }
    catch (Exception paramContext)
    {
      InfoRecognizer.b = null;
      InfoRecognizer.c = null;
      InfoRecognizer.d.b(-103);
      return -1;
    }
    InfoRecognizer.d.b(-304);
    return -1;
    label195:
    this.a = true;
    return 0;
  }
  
  protected final int a(Context paramContext, String paramString1, String paramString2)
  {
    InfoRecognizer.b = paramString1;
    InfoRecognizer.c = paramString2;
    return a(paramContext);
  }
  
  protected final int a(SDKVersion paramSDKVersion)
  {
    return this.m.a(paramSDKVersion);
  }
  
  protected final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LogTool.d("append Data: len = " + paramInt2 + " isComplete = " + paramBoolean);
    if (this.k) {
      return 0;
    }
    if (paramArrayOfByte != null) {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte;
    int i1;
    Object localObject;
    label384:
    label533:
    label671:
    for (;;)
    {
      int i2;
      try
      {
        this.b.flush();
        arrayOfByte = this.b.toByteArray();
        paramInt2 = 0;
        paramInt1 = 0;
        if (!InfoRecognizer.i) {
          break label758;
        }
        i2 = InfoRecorder.b;
        if (arrayOfByte.length - paramInt1 <= i2)
        {
          paramInt2 = paramInt1;
          if (!paramBoolean) {
            break label758;
          }
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.d.a(paramArrayOfByte);
          this.k = true;
          if (this.d) {
            break label676;
          }
          paramArrayOfByte = new b(null, InnerAudioState.cancel);
          if (this.l.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.d.b(-305);
          return -1;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
      paramArrayOfByte = new byte[InfoRecorder.b];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, i2);
      paramInt1 += i2;
      if (this.i == 0)
      {
        i1 = 0;
        paramInt2 = 0;
      }
      for (;;)
      {
        if (paramInt2 >= paramArrayOfByte.length) {}
        while (paramArrayOfByte[paramInt2] != 0)
        {
          if (i1 > paramArrayOfByte.length / 2) {
            break label671;
          }
          this.i += i2;
          paramInt2 = Common.calculateVolumn(paramArrayOfByte, i2);
          InfoRecognizer.d.a(paramInt2);
          this.e = this.c.AddData(paramArrayOfByte, i2);
          if ((this.d) || (this.e != 2) || (this.f != 3)) {
            break label427;
          }
          this.d = true;
          LogTool.d("speaking start: preAudio size = " + this.g.size());
          if (this.g.isEmpty()) {
            break label533;
          }
          localObject = new b((byte[])this.g.removeFirst(), InnerAudioState.begin);
          paramInt2 = this.i;
          if (this.l.a((b)localObject)) {
            break label533;
          }
          InfoRecognizer.d.b(-305);
          break;
        }
        i1 += 1;
        paramInt2 += 1;
      }
      localObject = new b((byte[])this.g.removeFirst(), InnerAudioState.middle);
      if (!this.l.a((b)localObject)) {
        InfoRecognizer.d.b(-305);
      }
      for (;;)
      {
        label427:
        if (this.d)
        {
          if ((this.e == 3) && (this.f == 2))
          {
            if (!InfoRecognizer.f)
            {
              localObject = VoiceRecordState.Complete;
              InfoRecognizer.d.a((VoiceRecordState)localObject);
            }
            this.d = false;
            LogTool.d("speaking stop");
            this.g.clear();
            if (!InfoRecognizer.f)
            {
              paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
              paramInt2 = this.i;
              if (!this.l.a(paramArrayOfByte))
              {
                InfoRecognizer.d.b(-305);
                break;
                if (!this.g.isEmpty()) {
                  break label384;
                }
                continue;
              }
              this.k = true;
              return 0;
            }
            localObject = new b(paramArrayOfByte, InnerAudioState.end);
            paramInt2 = this.i;
            if (this.l.a((b)localObject)) {
              break label632;
            }
            InfoRecognizer.d.b(-305);
            break;
          }
          localObject = new b(paramArrayOfByte, InnerAudioState.middle);
          if (!this.l.a((b)localObject))
          {
            InfoRecognizer.d.b(-305);
            break;
          }
        }
      }
      label632:
      this.f = this.e;
      this.g.add(paramArrayOfByte);
      if (this.g.size() > this.h) {
        this.g.removeFirst();
      }
    }
    return 0;
    label676:
    paramInt2 = paramInt1;
    if (this.d)
    {
      this.d = false;
      LogTool.d("speaking stop");
      paramArrayOfByte = new byte[arrayOfByte.length - paramInt1];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, arrayOfByte.length - paramInt1);
      paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
      paramInt1 = this.i;
      if (!this.l.a(paramArrayOfByte))
      {
        InfoRecognizer.d.b(-305);
        return -1;
      }
      return 0;
    }
    label758:
    paramInt1 = paramInt2;
    if (!InfoRecognizer.i)
    {
      i1 = InfoRecorder.b;
      if (arrayOfByte.length - paramInt2 <= i1)
      {
        label781:
        paramInt1 = paramInt2;
        if (paramBoolean)
        {
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.d.a(paramArrayOfByte);
          this.k = true;
          paramArrayOfByte = new byte[arrayOfByte.length - paramInt2];
          System.arraycopy(arrayOfByte, paramInt2, paramArrayOfByte, 0, arrayOfByte.length - paramInt2);
          paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
          paramInt1 = paramInt2;
          if (!this.l.a(paramArrayOfByte))
          {
            InfoRecognizer.d.b(-305);
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
        InfoRecognizer.d.a(paramInt2);
        if (this.j) {}
        for (paramArrayOfByte = InnerAudioState.begin;; paramArrayOfByte = InnerAudioState.middle)
        {
          paramArrayOfByte = new b((byte[])localObject, paramArrayOfByte);
          this.j = false;
          paramInt2 = paramInt1;
          if (this.l.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.d.b(-305);
          paramInt2 = paramInt1;
          break label781;
        }
      }
    }
    this.b.reset();
    this.b.write(arrayOfByte, paramInt1, arrayOfByte.length - paramInt1);
    return 0;
  }
  
  protected final void a()
  {
    VoiceRecordState localVoiceRecordState;
    if (this.n != null)
    {
      localVoiceRecordState = VoiceRecordState.Canceling;
      InfoRecognizer.d.a(localVoiceRecordState);
      if (this.m != null)
      {
        this.m.b();
        this.m.d();
      }
      if (this.n == null) {}
    }
    try
    {
      this.n.join();
      this.n = null;
      localVoiceRecordState = VoiceRecordState.Canceled;
      InfoRecognizer.d.a(localVoiceRecordState);
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
  
  protected final int b(int paramInt)
  {
    return this.m.setKeywordSetIndex(paramInt);
  }
  
  protected final void b()
  {
    if (this.n != null)
    {
      if (this.m != null)
      {
        this.m.b();
        this.m.d();
      }
      if (this.n == null) {}
    }
    try
    {
      this.n.join();
      this.n = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected final void c()
  {
    if (this.a)
    {
      a();
      this.m.c();
      this.c.Release();
      InfoRecognizer.b = null;
      InfoRecognizer.c = null;
      this.a = false;
    }
  }
  
  protected final int d()
  {
    if (InfoRecognizer.d.b == null) {
      return -1;
    }
    if (!this.a)
    {
      InfoRecognizer.d.b(-101);
      return -1;
    }
    InfoRecognizer.d.a();
    VoiceRecordState localVoiceRecordState = VoiceRecordState.Start;
    InfoRecognizer.d.a(localVoiceRecordState);
    if ((this.n != null) && (this.n.isAlive()))
    {
      this.m.b();
      this.m.d();
    }
    try
    {
      this.n.join();
      this.n = null;
      this.m.a(this.l);
      this.l.a();
      this.b.reset();
      this.m.a(this.l);
      this.c.Reset();
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
      localVoiceRecordState = VoiceRecordState.Recording;
      InfoRecognizer.d.a(localVoiceRecordState);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.c
 * JD-Core Version:    0.7.0.1
 */