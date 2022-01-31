package com.qq.wx.voice.data.recognizer;

import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.TRSilk;
import com.qq.wx.voice.vad.TRSilkException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class InnerSender
  implements Runnable
{
  private boolean a = false;
  private int b = 10000;
  private int c = 2;
  private LinkedList d = new LinkedList();
  private LinkedList e = new LinkedList();
  private InnerHttp f = null;
  private long g = 10000L;
  private InnerAudioList h = null;
  
  private void c()
  {
    try
    {
      wait(100L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (this.f != null) {
      this.f.b();
    }
    this.a = false;
  }
  
  protected final void a(InnerAudioList paramInnerAudioList)
  {
    this.f = new InnerHttp();
    this.h = paramInnerAudioList;
    this.d.clear();
    this.e.clear();
    InfoRecognizer.k.reset();
    InfoRecognizer.l.reset();
    this.a = true;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.f.a(paramArrayOfByte);
  }
  
  protected final void b()
  {
    try
    {
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    TRSilk localTRSilk = new TRSilk();
    localTRSilk.silkInit();
    this.c = Math.max(this.c, this.b / InfoRecorder.b);
    LogTool.d("mMergeNum = " + this.c);
    long l = -1L;
    if (!this.a) {}
    label68:
    Object localObject1;
    for (;;)
    {
      localTRSilk.silkRelease();
      return;
      if ((this.f.d()) || (this.e.isEmpty())) {
        break label345;
      }
      localObject1 = (a)this.e.removeFirst();
      if (((a)localObject1).c != InnerAudioState.cancel) {
        break;
      }
      localObject1 = new VoiceRecognizerResult(true);
      ((VoiceRecognizerResult)localObject1).isAllEnd = true;
      InfoRecognizer.b.a((VoiceRecognizerResult)localObject1);
      this.a = false;
    }
    if (((a)localObject1).c == InnerAudioState.begin)
    {
      this.f.a();
      this.f.a(((a)localObject1).d);
    }
    if (((a)localObject1).c == InnerAudioState.end) {
      this.f.b(((a)localObject1).d);
    }
    for (int i = 1;; i = 0)
    {
      if (((a)localObject1).c == InnerAudioState.stop)
      {
        this.f.b(((a)localObject1).d);
        this.f.c();
        i = 1;
      }
      this.f.a(((a)localObject1).a, ((a)localObject1).b, i);
      l = System.currentTimeMillis();
      if (InfoRecognizer.m) {
        this.f.e();
      }
      for (;;)
      {
        LogTool.d("size = " + ((a)localObject1).b + " state = " + ((a)localObject1).c);
        if (((a)localObject1).c != InnerAudioState.stop) {
          break;
        }
        this.a = false;
        break label68;
        new Thread(this.f).start();
      }
      label345:
      if ((this.f.d()) && (l != -1L) && (System.currentTimeMillis() - l > this.g))
      {
        InfoRecognizer.b.b(-201);
        this.a = false;
        break label68;
      }
      label411:
      int j;
      label442:
      int k;
      label473:
      int m;
      if (this.d.size() >= this.c)
      {
        i = 1;
        if ((this.d.isEmpty()) || (((a)this.d.getLast()).c != InnerAudioState.end)) {
          break label567;
        }
        j = 1;
        if ((this.d.isEmpty()) || (((a)this.d.getLast()).c != InnerAudioState.stop)) {
          break label572;
        }
        k = 1;
        if ((this.d.isEmpty()) || (((a)this.d.getFirst()).c != InnerAudioState.cancel)) {
          break label577;
        }
        m = 1;
      }
      for (;;)
      {
        if ((m | i | 0x0 | j | k) != 0)
        {
          if (((a)this.d.getFirst()).c == InnerAudioState.cancel)
          {
            localObject1 = (a)this.d.removeFirst();
            this.e.add(localObject1);
            break;
            i = 0;
            break label411;
            label567:
            j = 0;
            break label442;
            label572:
            k = 0;
            break label473;
            label577:
            m = 0;
            continue;
          }
          localObject1 = InnerAudioState.middle;
          if (((a)this.d.getFirst()).c != InnerAudioState.begin) {
            break label1176;
          }
          localObject1 = InnerAudioState.begin;
        }
      }
      label774:
      label1176:
      for (i = ((a)this.d.getFirst()).d;; i = 0)
      {
        if (((a)this.d.getLast()).c == InnerAudioState.end)
        {
          localObject1 = InnerAudioState.end;
          i = ((a)this.d.getLast()).d;
        }
        if (((a)this.d.getLast()).c == InnerAudioState.stop)
        {
          localObject1 = InnerAudioState.stop;
          i = ((a)this.d.getLast()).d;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              Object localObject4;
              try
              {
                localObject4 = new ByteArrayOutputStream();
                j = 0;
                if (!this.d.isEmpty()) {
                  break label774;
                }
                ((ByteArrayOutputStream)localObject4).flush();
                localObject1 = new a(((ByteArrayOutputStream)localObject4).toByteArray(), j, (InnerAudioState)localObject1, i);
                this.e.add(localObject1);
                ((ByteArrayOutputStream)localObject4).close();
              }
              catch (IOException localIOException1)
              {
                localIOException1.printStackTrace();
              }
              break;
              Object localObject5 = (a)this.d.removeFirst();
              ((ByteArrayOutputStream)localObject4).write(((a)localObject5).a);
              k = ((a)localObject5).b;
              j = k + j;
              continue;
              localObject5 = this.h.b();
              if (localObject5 != null)
              {
                Object localObject2;
                if (((a)localObject5).b == InnerAudioState.cancel)
                {
                  localObject2 = new a(null, 0, ((a)localObject5).b, ((a)localObject5).c);
                  this.d.add(localObject2);
                  break;
                }
                if (((a)localObject5).b == InnerAudioState.begin)
                {
                  localTRSilk.silkRelease();
                  localTRSilk.silkInit();
                }
                try
                {
                  for (;;)
                  {
                    localObject2 = localTRSilk.silkEncode(((a)localObject5).a, 0, ((a)localObject5).a.length);
                    localObject4 = localObject2;
                    if (localObject2 == null) {
                      localObject4 = new byte[0];
                    }
                    localObject2 = new a((byte[])localObject4, ((a)localObject5).a.length, ((a)localObject5).b, ((a)localObject5).c);
                    this.d.add(localObject2);
                    try
                    {
                      if ((InfoRecognizer.g) || (InfoRecognizer.h))
                      {
                        InfoRecognizer.k.write(((a)localObject5).a);
                        if (((a)localObject5).b == InnerAudioState.begin) {
                          InfoRecognizer.k.reset();
                        }
                        if ((((a)localObject5).b == InnerAudioState.end) || (((a)localObject5).b == InnerAudioState.stop))
                        {
                          InfoRecognizer.k.flush();
                          if (InfoRecognizer.h) {
                            Common.saveFile(InfoRecognizer.k.toByteArray(), "pcm");
                          }
                        }
                      }
                      if ((!InfoRecognizer.g) && (!InfoRecognizer.i)) {
                        break;
                      }
                      InfoRecognizer.l.write((byte[])localObject4);
                      if (((a)localObject5).b == InnerAudioState.begin) {
                        InfoRecognizer.l.reset();
                      }
                      if ((((a)localObject5).b != InnerAudioState.end) && (((a)localObject5).b != InnerAudioState.stop)) {
                        break;
                      }
                      InfoRecognizer.l.flush();
                      if (!InfoRecognizer.i) {
                        break;
                      }
                      Common.saveFile(InfoRecognizer.l.toByteArray(), "Silk");
                    }
                    catch (IOException localIOException2)
                    {
                      localIOException2.printStackTrace();
                    }
                  }
                }
                catch (TRSilkException localTRSilkException)
                {
                  for (;;)
                  {
                    localTRSilkException.printStackTrace();
                    Object localObject3 = null;
                  }
                }
              }
            }
            try
            {
              c();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
        }
      }
    }
  }
  
  final class a
  {
    int b = 0;
    InnerAudioState c = InnerAudioState.stop;
    int d = 0;
    
    a(int paramInt1, InnerAudioState paramInnerAudioState, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInnerAudioState;
      this.d = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.InnerSender
 * JD-Core Version:    0.7.0.1
 */