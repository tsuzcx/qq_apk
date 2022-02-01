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
      if (InfoRecognizer.b == null)
      {
        System.loadLibrary("wxvoiceembedqqegg");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder("init by soWXVoiceEmbedPath: ");
        localStringBuilder.append(InfoRecognizer.b);
        LogTool.d(localStringBuilder.toString());
        if (!new File(InfoRecognizer.b).exists())
        {
          localStringBuilder = new StringBuilder("no found: ");
          localStringBuilder.append(InfoRecognizer.b);
          LogTool.d(localStringBuilder.toString());
        }
        System.load(InfoRecognizer.b);
      }
      InfoRecognizer.a = paramContext;
      if (this.m.a() < 0) {
        return -1;
      }
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.d, InfoRecorder.e, InfoRecorder.f) != 0)
      {
        InfoRecognizer.d.b(-304);
        return -1;
      }
      this.a = true;
      return 0;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      break label190;
    }
    catch (Exception paramContext)
    {
      label172:
      break label172;
    }
    InfoRecognizer.b = null;
    InfoRecognizer.c = null;
    InfoRecognizer.d.b(-103);
    return -1;
    label190:
    InfoRecognizer.b = null;
    InfoRecognizer.c = null;
    InfoRecognizer.d.b(-103);
    return -1;
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
    Object localObject1 = new StringBuilder("append Data: len = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" isComplete = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    LogTool.d(((StringBuilder)localObject1).toString());
    if (this.k) {
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
    localObject1 = this.b.toByteArray();
    int i1;
    Object localObject2;
    if (InfoRecognizer.i)
    {
      int i2 = InfoRecorder.b;
      paramInt1 = 0;
      for (;;)
      {
        if (localObject1.length - paramInt1 <= i2)
        {
          paramInt2 = paramInt1;
        }
        else
        {
          paramArrayOfByte = new byte[InfoRecorder.b];
          System.arraycopy(localObject1, paramInt1, paramArrayOfByte, 0, i2);
          paramInt2 = paramInt1 + i2;
          if (this.i == 0)
          {
            paramInt1 = 0;
            i1 = 0;
            while ((paramInt1 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt1] == 0))
            {
              i1 += 1;
              paramInt1 += 1;
            }
            paramInt1 = paramInt2;
            if (i1 > paramArrayOfByte.length / 2) {
              continue;
            }
          }
          this.i += i2;
          paramInt1 = Common.calculateVolumn(paramArrayOfByte, i2);
          InfoRecognizer.d.a(paramInt1);
          this.e = this.c.AddData(paramArrayOfByte, i2);
          if ((!this.d) && (this.e == 2) && (this.f == 3))
          {
            this.d = true;
            localObject2 = new StringBuilder("speaking start: preAudio size = ");
            ((StringBuilder)localObject2).append(this.g.size());
            LogTool.d(((StringBuilder)localObject2).toString());
            if (!this.g.isEmpty())
            {
              localObject2 = new b((byte[])this.g.removeFirst(), InnerAudioState.begin);
              paramInt1 = this.i;
              if (!this.l.a((b)localObject2))
              {
                InfoRecognizer.d.b(-305);
                break label596;
              }
            }
            while (!this.g.isEmpty())
            {
              localObject2 = new b((byte[])this.g.removeFirst(), InnerAudioState.middle);
              if (!this.l.a((b)localObject2)) {
                InfoRecognizer.d.b(-305);
              }
            }
          }
          else
          {
            if (!this.d) {
              break label746;
            }
            if ((this.e == 3) && (this.f == 2))
            {
              if (!InfoRecognizer.f)
              {
                localObject2 = VoiceRecordState.Complete;
                InfoRecognizer.d.a((VoiceRecordState)localObject2);
              }
              this.d = false;
              LogTool.d("speaking stop");
              this.g.clear();
              if (!InfoRecognizer.f)
              {
                paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
                paramInt1 = this.i;
                if (!this.l.a(paramArrayOfByte))
                {
                  InfoRecognizer.d.b(-305);
                }
                else
                {
                  this.k = true;
                  return 0;
                }
              }
              else
              {
                localObject2 = new b(paramArrayOfByte, InnerAudioState.end);
                paramInt1 = this.i;
                if (this.l.a((b)localObject2)) {
                  break label746;
                }
                InfoRecognizer.d.b(-305);
              }
            }
            else
            {
              localObject2 = new b(paramArrayOfByte, InnerAudioState.middle);
              if (this.l.a((b)localObject2)) {
                break label746;
              }
              InfoRecognizer.d.b(-305);
            }
          }
        }
        label596:
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break;
        }
        paramArrayOfByte = VoiceRecordState.Complete;
        InfoRecognizer.d.a(paramArrayOfByte);
        this.k = true;
        boolean bool = this.d;
        if (!bool)
        {
          paramArrayOfByte = new b(null, InnerAudioState.cancel);
          if (!this.l.a(paramArrayOfByte))
          {
            InfoRecognizer.d.b(-305);
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
        paramArrayOfByte = new byte[localObject1.length - paramInt2];
        System.arraycopy(localObject1, paramInt2, paramArrayOfByte, 0, localObject1.length - paramInt2);
        paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
        paramInt1 = this.i;
        if (!this.l.a(paramArrayOfByte))
        {
          InfoRecognizer.d.b(-305);
          return -1;
        }
        return 0;
        label746:
        this.f = this.e;
        this.g.add(paramArrayOfByte);
        paramInt1 = paramInt2;
        if (this.g.size() > this.h)
        {
          this.g.removeFirst();
          paramInt1 = paramInt2;
        }
      }
    }
    paramInt1 = 0;
    paramInt2 = paramInt1;
    if (!InfoRecognizer.i)
    {
      i1 = InfoRecorder.b;
      while (localObject1.length - paramInt1 > i1)
      {
        localObject2 = new byte[InfoRecorder.b];
        System.arraycopy(localObject1, paramInt1, localObject2, 0, i1);
        paramInt2 = paramInt1 + i1;
        this.i += i1;
        paramInt1 = Common.calculateVolumn((byte[])localObject2, i1);
        InfoRecognizer.d.a(paramInt1);
        if (this.j) {
          paramArrayOfByte = InnerAudioState.begin;
        } else {
          paramArrayOfByte = InnerAudioState.middle;
        }
        paramArrayOfByte = new b((byte[])localObject2, paramArrayOfByte);
        this.j = false;
        paramInt1 = paramInt2;
        if (!this.l.a(paramArrayOfByte))
        {
          InfoRecognizer.d.b(-305);
          paramInt1 = paramInt2;
        }
      }
      paramInt2 = paramInt1;
      if (paramBoolean)
      {
        paramArrayOfByte = VoiceRecordState.Complete;
        InfoRecognizer.d.a(paramArrayOfByte);
        this.k = true;
        paramArrayOfByte = new byte[localObject1.length - paramInt1];
        System.arraycopy(localObject1, paramInt1, paramArrayOfByte, 0, localObject1.length - paramInt1);
        paramArrayOfByte = new b(paramArrayOfByte, InnerAudioState.stop);
        paramInt2 = paramInt1;
        if (!this.l.a(paramArrayOfByte))
        {
          InfoRecognizer.d.b(-305);
          return -1;
        }
      }
    }
    this.b.reset();
    this.b.write((byte[])localObject1, paramInt2, localObject1.length - paramInt2);
    return 0;
  }
  
  protected final void a()
  {
    if (this.n != null)
    {
      Object localObject = VoiceRecordState.Canceling;
      InfoRecognizer.d.a((VoiceRecordState)localObject);
      localObject = this.m;
      if (localObject != null)
      {
        ((InnerSender)localObject).b();
        this.m.d();
      }
      localObject = this.n;
      if (localObject != null) {
        try
        {
          ((Thread)localObject).join();
          this.n = null;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      VoiceRecordState localVoiceRecordState = VoiceRecordState.Canceled;
      InfoRecognizer.d.a(localVoiceRecordState);
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
      Object localObject = this.m;
      if (localObject != null)
      {
        ((InnerSender)localObject).b();
        this.m.d();
      }
      localObject = this.n;
      if (localObject != null) {
        try
        {
          ((Thread)localObject).join();
          this.n = null;
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
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
    Object localObject1 = VoiceRecordState.Start;
    InfoRecognizer.d.a((VoiceRecordState)localObject1);
    localObject1 = this.n;
    if ((localObject1 != null) && (((Thread)localObject1).isAlive()))
    {
      this.m.b();
      this.m.d();
      try
      {
        this.n.join();
        this.n = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
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
    Object localObject2 = new StringBuilder("preAudioMax = ");
    ((StringBuilder)localObject2).append(this.h);
    LogTool.d(((StringBuilder)localObject2).toString());
    this.n = new Thread(this.m);
    this.n.start();
    localObject2 = VoiceRecordState.Recording;
    InfoRecognizer.d.a((VoiceRecordState)localObject2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.c
 * JD-Core Version:    0.7.0.1
 */