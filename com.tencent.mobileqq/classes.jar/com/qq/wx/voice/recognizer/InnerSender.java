package com.qq.wx.voice.recognizer;

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
  private int d = 0;
  private int e = 1800000;
  private InnerSender.a f = null;
  private LinkedList g = new LinkedList();
  private LinkedList h = new LinkedList();
  private InnerHttp i = null;
  private long j = 10000L;
  private InnerAudioList k = null;
  
  private static byte[] a(TRSilk paramTRSilk, a parama)
  {
    if (!InfoRecognizer.k) {
      return parama.a;
    }
    Object localObject = null;
    try
    {
      paramTRSilk = paramTRSilk.silkEncode(parama.a, 0, parama.a.length);
    }
    catch (TRSilkException paramTRSilk)
    {
      paramTRSilk.printStackTrace();
      paramTRSilk = localObject;
    }
    parama = paramTRSilk;
    if (paramTRSilk == null) {
      parama = new byte[0];
    }
    return parama;
  }
  
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
    InnerHttp localInnerHttp = this.i;
    if (localInnerHttp != null) {
      localInnerHttp.b();
    }
    this.a = false;
  }
  
  protected final void a(InnerAudioList paramInnerAudioList)
  {
    this.i = new InnerHttp();
    this.k = paramInnerAudioList;
    this.g.clear();
    this.h.clear();
    InfoRecognizer.l.reset();
    InfoRecognizer.m.reset();
    this.a = true;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.i.a(paramArrayOfByte);
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
    Object localObject1 = new StringBuilder("mMergeNum = ");
    ((StringBuilder)localObject1).append(this.c);
    LogTool.d(((StringBuilder)localObject1).toString());
    long l = -1L;
    for (;;)
    {
      int i2;
      int i3;
      int m;
      Object localObject3;
      if (this.a)
      {
        boolean bool = this.i.d();
        i2 = 1;
        i3 = 0;
        if ((!bool) && (!this.h.isEmpty()))
        {
          localObject1 = (InnerSender.a)this.h.removeFirst();
          if (((InnerSender.a)localObject1).c == InnerAudioState.cancel)
          {
            localObject1 = new VoiceRecognizerResult(true);
            ((VoiceRecognizerResult)localObject1).isAllEnd = true;
            InfoRecognizer.b.a((VoiceRecognizerResult)localObject1);
            this.a = false;
          }
          else
          {
            if (((InnerSender.a)localObject1).c == InnerAudioState.begin)
            {
              this.i.a();
              this.i.a(((InnerSender.a)localObject1).d);
            }
            if (((InnerSender.a)localObject1).c == InnerAudioState.end)
            {
              this.i.b(((InnerSender.a)localObject1).d);
              m = 1;
            }
            else
            {
              m = 0;
            }
            if (((InnerSender.a)localObject1).c == InnerAudioState.stop)
            {
              this.i.b(((InnerSender.a)localObject1).d);
              this.i.c();
              m = 1;
            }
            this.i.a(((InnerSender.a)localObject1).a, ((InnerSender.a)localObject1).b, m);
            l = System.currentTimeMillis();
            if (InfoRecognizer.n) {
              this.i.e();
            } else {
              new Thread(this.i).start();
            }
            if (((InnerSender.a)localObject1).c != InnerAudioState.middle)
            {
              localObject3 = new StringBuilder("offset = ");
              ((StringBuilder)localObject3).append(((InnerSender.a)localObject1).d);
              ((StringBuilder)localObject3).append(" state = ");
              ((StringBuilder)localObject3).append(((InnerSender.a)localObject1).c);
              LogTool.d(((StringBuilder)localObject3).toString());
            }
            if (((InnerSender.a)localObject1).c == InnerAudioState.stop) {
              this.a = false;
            }
          }
        }
        else
        {
          if ((!this.i.d()) || (l == -1L) || (System.currentTimeMillis() - l <= this.j)) {
            break label444;
          }
          InfoRecognizer.b.b(-201);
          this.a = false;
        }
      }
      localTRSilk.silkRelease();
      return;
      label444:
      int n;
      int i1;
      if (!this.g.isEmpty())
      {
        if (this.g.size() >= this.c) {
          m = 1;
        } else {
          m = 0;
        }
        if (((InnerSender.a)this.g.getFirst()).c == InnerAudioState.cancel) {
          n = 1;
        } else {
          n = 0;
        }
        if (((InnerSender.a)this.g.getLast()).c == InnerAudioState.end) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (((InnerSender.a)this.g.getLast()).c != InnerAudioState.stop) {
          i2 = 0;
        }
        m = m | 0x0 | n | i1 | i2;
      }
      else
      {
        m = 0;
      }
      InnerSender.a locala;
      Object localObject2;
      if (m != 0)
      {
        if (((InnerSender.a)this.g.getFirst()).c == InnerAudioState.cancel)
        {
          localObject1 = (InnerSender.a)this.g.removeFirst();
          this.h.add(localObject1);
        }
        else
        {
          localObject1 = InnerAudioState.middle;
          if (((InnerSender.a)this.g.getFirst()).c == InnerAudioState.begin)
          {
            localObject1 = InnerAudioState.begin;
            m = ((InnerSender.a)this.g.getFirst()).d;
          }
          else
          {
            m = 0;
          }
          if (((InnerSender.a)this.g.getLast()).c == InnerAudioState.end)
          {
            localObject1 = InnerAudioState.end;
            m = ((InnerSender.a)this.g.getLast()).d;
          }
          if (((InnerSender.a)this.g.getLast()).c == InnerAudioState.stop)
          {
            localObject1 = InnerAudioState.stop;
            m = ((InnerSender.a)this.g.getLast()).d;
          }
          try
          {
            localObject3 = new ByteArrayOutputStream();
            n = i3;
            for (;;)
            {
              if (this.g.isEmpty())
              {
                ((ByteArrayOutputStream)localObject3).flush();
                localObject1 = new InnerSender.a(((ByteArrayOutputStream)localObject3).toByteArray(), n, (InnerAudioState)localObject1, m);
                this.h.add(localObject1);
                ((ByteArrayOutputStream)localObject3).close();
                break;
              }
              locala = (InnerSender.a)this.g.removeFirst();
              ((ByteArrayOutputStream)localObject3).write(locala.a);
              i1 = locala.b;
              n += i1;
            }
            localObject2 = this.f;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
        if (localObject2 != null)
        {
          this.g.add(localObject2);
          this.d += this.f.b;
          this.f = null;
        }
      }
      else
      {
        localObject2 = this.k.b();
        if (localObject2 != null)
        {
          if (((a)localObject2).b == InnerAudioState.cancel)
          {
            localObject2 = new InnerSender.a(null, 0, ((a)localObject2).b, ((a)localObject2).c);
            this.g.add(localObject2);
          }
          else
          {
            if (((a)localObject2).b == InnerAudioState.begin)
            {
              localTRSilk.silkRelease();
              localTRSilk.silkInit();
              this.d = 0;
              this.f = null;
            }
            localObject3 = a(localTRSilk, (a)localObject2);
            if ((((a)localObject2).b == InnerAudioState.middle) && (this.d >= this.e))
            {
              locala = new InnerSender.a((byte[])localObject3, ((a)localObject2).a.length, InnerAudioState.end, ((a)localObject2).c);
              this.g.add(locala);
              localTRSilk.silkRelease();
              localTRSilk.silkInit();
              this.d = 0;
              this.f = new InnerSender.a(a(localTRSilk, (a)localObject2), ((a)localObject2).a.length, InnerAudioState.begin, ((a)localObject2).c);
              LogTool.d("sentence is force cutted and rebegin");
            }
            else
            {
              locala = new InnerSender.a((byte[])localObject3, ((a)localObject2).a.length, ((a)localObject2).b, ((a)localObject2).c);
              this.g.add(locala);
              this.d += ((a)localObject2).a.length;
            }
            try
            {
              if ((InfoRecognizer.g) || (InfoRecognizer.h))
              {
                InfoRecognizer.l.write(((a)localObject2).a);
                if (((a)localObject2).b == InnerAudioState.begin) {
                  InfoRecognizer.l.reset();
                }
                if ((((a)localObject2).b == InnerAudioState.end) || (((a)localObject2).b == InnerAudioState.stop))
                {
                  InfoRecognizer.l.flush();
                  if (InfoRecognizer.h) {
                    Common.saveFile(InfoRecognizer.l.toByteArray(), "pcm");
                  }
                }
              }
              if ((!InfoRecognizer.g) && (!InfoRecognizer.i)) {
                continue;
              }
              InfoRecognizer.m.write((byte[])localObject3);
              if (((a)localObject2).b == InnerAudioState.begin) {
                InfoRecognizer.m.reset();
              }
              if ((((a)localObject2).b != InnerAudioState.end) && (((a)localObject2).b != InnerAudioState.stop)) {
                continue;
              }
              InfoRecognizer.m.flush();
              if (!InfoRecognizer.i) {
                continue;
              }
              Common.saveFile(InfoRecognizer.m.toByteArray(), "Silk");
            }
            catch (IOException localIOException2)
            {
              localIOException2.printStackTrace();
            }
          }
        }
        else {
          try
          {
            c();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerSender
 * JD-Core Version:    0.7.0.1
 */