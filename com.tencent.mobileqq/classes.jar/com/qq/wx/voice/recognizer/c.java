package com.qq.wx.voice.recognizer;

import android.media.AudioRecord;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.EVad;
import java.util.LinkedList;

final class c
  implements Runnable
{
  private boolean a = false;
  private boolean b = false;
  private AudioRecord c = null;
  private int d = 16;
  private int e = 2;
  private EVad f = new EVad();
  private InnerAudioList g = null;
  
  protected final int a(InnerAudioList paramInnerAudioList)
  {
    this.g = paramInnerAudioList;
    paramInnerAudioList = this.c;
    if (paramInnerAudioList != null)
    {
      paramInnerAudioList.release();
      this.c = null;
    }
    try
    {
      InfoRecorder.b = AudioRecord.getMinBufferSize(InfoRecorder.a, this.d, this.e);
      this.c = new AudioRecord(1, InfoRecorder.a, this.d, this.e, InfoRecorder.b);
      if (this.c.getState() != 1)
      {
        InfoRecognizer.b.b(-301);
        return -1;
      }
      this.a = true;
      this.b = true;
      return 0;
    }
    catch (Exception paramInnerAudioList)
    {
      InfoRecognizer.b.b(-301);
      paramInnerAudioList.printStackTrace();
    }
    return -1;
  }
  
  protected final void a()
  {
    this.b = false;
  }
  
  protected final void b()
  {
    this.a = false;
  }
  
  protected final void c()
  {
    AudioRecord localAudioRecord = this.c;
    if (localAudioRecord != null)
    {
      localAudioRecord.release();
      this.c = null;
    }
  }
  
  protected final void d()
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
  
  public final void run()
  {
    Object localObject1 = VoiceRecordState.Start;
    InfoRecognizer.b.a((VoiceRecordState)localObject1);
    localObject1 = this.c;
    if (localObject1 == null)
    {
      InfoRecognizer.b.b(-302);
      return;
    }
    for (;;)
    {
      try
      {
        ((AudioRecord)localObject1).startRecording();
        localObject1 = VoiceRecordState.Recording;
        InfoRecognizer.b.a((VoiceRecordState)localObject1);
        if (this.f.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
        {
          InfoRecognizer.b.b(-304);
          return;
        }
        localObject1 = new LinkedList();
        i3 = InfoRecorder.h / InfoRecorder.b;
        localObject2 = new StringBuilder("preAudioMax = ");
        ((StringBuilder)localObject2).append(i3);
        LogTool.d(((StringBuilder)localObject2).toString());
        k = 0;
        int j = 1;
        i = 0;
        m = 3;
        if (this.a)
        {
          localObject2 = new byte[InfoRecorder.b];
          i2 = this.c.read((byte[])localObject2, 0, InfoRecorder.b);
          if (i2 == -3)
          {
            InfoRecognizer.b.b(10131);
          }
          else if (i2 == -2)
          {
            InfoRecognizer.b.b(10132);
          }
          else if (i2 != InfoRecorder.b)
          {
            InfoRecognizer.b.b(-303);
          }
          else
          {
            i1 = k + i2;
            Object localObject3;
            if (InfoRecorder.d > 0)
            {
              localObject3 = new StringBuilder("timeOffset = ");
              ((StringBuilder)localObject3).append(i1);
              ((StringBuilder)localObject3).append(" timeOut = ");
              ((StringBuilder)localObject3).append((InfoRecorder.a << 1) * InfoRecorder.d / 1000);
              LogTool.d(((StringBuilder)localObject3).toString());
              if ((j != 0) && (i1 > (InfoRecorder.a << 1) * InfoRecorder.d / 1000L))
              {
                InfoRecognizer.b.b(-307);
                continue;
              }
            }
            int n = j;
            j = Common.calculateVolumn((byte[])localObject2, i2);
            InfoRecognizer.b.a(j);
            if (!this.b)
            {
              localObject3 = VoiceRecordState.Complete;
              InfoRecognizer.b.a((VoiceRecordState)localObject3);
              if (i == 0)
              {
                localObject1 = new a(null, InnerAudioState.cancel);
                ((a)localObject1).c = i1;
                if (this.g.a((a)localObject1)) {
                  continue;
                }
                InfoRecognizer.b.b(-305);
                continue;
              }
              if (i != 0)
              {
                LogTool.d("speaking stop");
                localObject1 = new a((byte[])localObject2, InnerAudioState.stop);
                ((a)localObject1).c = i1;
                if (this.g.a((a)localObject1)) {
                  continue;
                }
                InfoRecognizer.b.b(-305);
                continue;
              }
            }
            i2 = this.f.AddData((byte[])localObject2, i2);
            k = i;
            j = n;
            if (i == 0)
            {
              k = i;
              j = n;
              if (i2 == 2)
              {
                k = i;
                j = n;
                if (m == 3)
                {
                  localObject3 = new StringBuilder("speaking start: preAudio size = ");
                  ((StringBuilder)localObject3).append(((LinkedList)localObject1).size());
                  LogTool.d(((StringBuilder)localObject3).toString());
                  if (!((LinkedList)localObject1).isEmpty())
                  {
                    localObject3 = new a((byte[])((LinkedList)localObject1).removeFirst(), InnerAudioState.begin);
                    ((a)localObject3).c = i1;
                    if (!this.g.a((a)localObject3))
                    {
                      InfoRecognizer.b.b(-305);
                      continue;
                    }
                  }
                  if (!((LinkedList)localObject1).isEmpty())
                  {
                    localObject3 = new a((byte[])((LinkedList)localObject1).removeFirst(), InnerAudioState.middle);
                    ((a)localObject3).c = i1;
                    if (this.g.a((a)localObject3)) {
                      continue;
                    }
                    InfoRecognizer.b.b(-305);
                  }
                  k = 1;
                  j = 0;
                }
              }
            }
            if (k == 0) {
              continue;
            }
            if ((i2 == 3) && (m == 2))
            {
              if (!InfoRecognizer.f)
              {
                localObject3 = VoiceRecordState.Complete;
                InfoRecognizer.b.a((VoiceRecordState)localObject3);
              }
              LogTool.d("speaking stop");
              ((LinkedList)localObject1).clear();
              if (!InfoRecognizer.f)
              {
                localObject1 = new a((byte[])localObject2, InnerAudioState.stop);
                ((a)localObject1).c = i1;
                if (!this.g.a((a)localObject1)) {
                  InfoRecognizer.b.b(-305);
                }
              }
              else
              {
                localObject3 = new a((byte[])localObject2, InnerAudioState.end);
                ((a)localObject3).c = i1;
                if (!this.g.a((a)localObject3))
                {
                  InfoRecognizer.b.b(-305);
                }
                else
                {
                  i = 0;
                  continue;
                }
              }
            }
            else
            {
              localObject3 = new a((byte[])localObject2, InnerAudioState.middle);
              ((a)localObject3).c = i1;
              i = k;
              if (this.g.a((a)localObject3)) {
                continue;
              }
              InfoRecognizer.b.b(-305);
            }
          }
        }
        this.f.Release();
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        int i3;
        Object localObject2;
        int k;
        int i;
        int m;
        int i2;
        int i1;
        continue;
      }
      try
      {
        this.c.stop();
        this.c.release();
        this.c = null;
        return;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        continue;
      }
      InfoRecognizer.b.b(-306);
      return;
      i = k;
      ((LinkedList)localObject1).add(localObject2);
      if (((LinkedList)localObject1).size() > i3) {
        ((LinkedList)localObject1).removeFirst();
      }
      m = i2;
      k = i1;
    }
    InfoRecognizer.b.b(-302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.c
 * JD-Core Version:    0.7.0.1
 */