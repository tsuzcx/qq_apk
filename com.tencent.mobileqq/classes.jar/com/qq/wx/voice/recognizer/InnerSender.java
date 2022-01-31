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
      parama = parama.a;
    }
    for (;;)
    {
      return parama;
      try
      {
        paramTRSilk = paramTRSilk.silkEncode(parama.a, 0, parama.a.length);
        parama = paramTRSilk;
        if (paramTRSilk != null) {
          continue;
        }
        return new byte[0];
      }
      catch (TRSilkException paramTRSilk)
      {
        for (;;)
        {
          paramTRSilk.printStackTrace();
          paramTRSilk = null;
        }
      }
    }
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
    if (this.i != null) {
      this.i.b();
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
    LogTool.d("mMergeNum = " + this.c);
    long l = -1L;
    if (!this.a) {}
    label68:
    Object localObject1;
    for (;;)
    {
      localTRSilk.silkRelease();
      return;
      if ((this.i.d()) || (this.h.isEmpty())) {
        break label356;
      }
      localObject1 = (InnerSender.a)this.h.removeFirst();
      if (((InnerSender.a)localObject1).c != InnerAudioState.cancel) {
        break;
      }
      localObject1 = new VoiceRecognizerResult(true);
      ((VoiceRecognizerResult)localObject1).isAllEnd = true;
      InfoRecognizer.b.a((VoiceRecognizerResult)localObject1);
      this.a = false;
    }
    if (((InnerSender.a)localObject1).c == InnerAudioState.begin)
    {
      this.i.a();
      this.i.a(((InnerSender.a)localObject1).d);
    }
    if (((InnerSender.a)localObject1).c == InnerAudioState.end) {
      this.i.b(((InnerSender.a)localObject1).d);
    }
    label432:
    label453:
    label474:
    label605:
    label610:
    for (int m = 1;; m = 0)
    {
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
      }
      for (;;)
      {
        if (((InnerSender.a)localObject1).c != InnerAudioState.middle) {
          LogTool.d("offset = " + ((InnerSender.a)localObject1).d + " state = " + ((InnerSender.a)localObject1).c);
        }
        if (((InnerSender.a)localObject1).c != InnerAudioState.stop) {
          break;
        }
        this.a = false;
        break label68;
        new Thread(this.i).start();
      }
      label356:
      if ((this.i.d()) && (l != -1L) && (System.currentTimeMillis() - l > this.j))
      {
        InfoRecognizer.b.b(-201);
        this.a = false;
        break label68;
      }
      int n;
      int i1;
      int i2;
      if (!this.g.isEmpty()) {
        if (this.g.size() >= this.c)
        {
          m = 1;
          if (((InnerSender.a)this.g.getFirst()).c != InnerAudioState.cancel) {
            break label600;
          }
          n = 1;
          if (((InnerSender.a)this.g.getLast()).c != InnerAudioState.end) {
            break label605;
          }
          i1 = 1;
          if (((InnerSender.a)this.g.getLast()).c != InnerAudioState.stop) {
            break label610;
          }
          i2 = 1;
        }
      }
      label496:
      for (m = i2 | m | 0x0 | n | i1;; m = 0)
      {
        if (m != 0)
        {
          if (((InnerSender.a)this.g.getFirst()).c == InnerAudioState.cancel)
          {
            localObject1 = (InnerSender.a)this.g.removeFirst();
            this.h.add(localObject1);
            if (this.f == null) {
              break label805;
            }
            this.g.add(this.f);
            this.d += this.f.b;
            this.f = null;
            break;
            m = 0;
            break label432;
            n = 0;
            break label453;
            i1 = 0;
            break label474;
            i2 = 0;
            break label496;
          }
          localObject1 = InnerAudioState.middle;
          if (((InnerSender.a)this.g.getFirst()).c != InnerAudioState.begin) {
            break label1312;
          }
          localObject1 = InnerAudioState.begin;
        }
        for (m = ((InnerSender.a)this.g.getFirst()).d;; m = 0)
        {
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
          for (;;)
          {
            for (;;)
            {
              Object localObject3;
              try
              {
                localObject3 = new ByteArrayOutputStream();
                n = 0;
                if (!this.g.isEmpty()) {
                  break label807;
                }
                ((ByteArrayOutputStream)localObject3).flush();
                localObject1 = new InnerSender.a(((ByteArrayOutputStream)localObject3).toByteArray(), n, (InnerAudioState)localObject1, m);
                this.h.add(localObject1);
                ((ByteArrayOutputStream)localObject3).close();
              }
              catch (IOException localIOException1)
              {
                localIOException1.printStackTrace();
              }
              break label552;
              break;
              InnerSender.a locala = (InnerSender.a)this.g.removeFirst();
              ((ByteArrayOutputStream)localObject3).write(locala.a);
              i1 = locala.b;
              n = i1 + n;
              continue;
              Object localObject2 = this.k.b();
              if (localObject2 != null)
              {
                if (((a)localObject2).b == InnerAudioState.cancel)
                {
                  localObject2 = new InnerSender.a(null, 0, ((a)localObject2).b, ((a)localObject2).c);
                  this.g.add(localObject2);
                  break;
                }
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
                for (;;)
                {
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
                      break;
                    }
                    InfoRecognizer.m.write((byte[])localObject3);
                    if (((a)localObject2).b == InnerAudioState.begin) {
                      InfoRecognizer.m.reset();
                    }
                    if ((((a)localObject2).b != InnerAudioState.end) && (((a)localObject2).b != InnerAudioState.stop)) {
                      break;
                    }
                    InfoRecognizer.m.flush();
                    if (!InfoRecognizer.i) {
                      break;
                    }
                    Common.saveFile(InfoRecognizer.m.toByteArray(), "Silk");
                  }
                  catch (IOException localIOException2)
                  {
                    localIOException2.printStackTrace();
                  }
                  break;
                  locala = new InnerSender.a((byte[])localObject3, localIOException2.a.length, localIOException2.b, localIOException2.c);
                  this.g.add(locala);
                  this.d += localIOException2.a.length;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerSender
 * JD-Core Version:    0.7.0.1
 */