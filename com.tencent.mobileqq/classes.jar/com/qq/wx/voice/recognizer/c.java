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
    if (this.c != null)
    {
      this.c.release();
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
    }
    catch (Exception paramInnerAudioList)
    {
      InfoRecognizer.b.b(-301);
      paramInnerAudioList.printStackTrace();
      return -1;
    }
    this.a = true;
    this.b = true;
    return 0;
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
    if (this.c != null)
    {
      this.c.release();
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
    VoiceRecordState localVoiceRecordState = VoiceRecordState.Start;
    InfoRecognizer.b.a(localVoiceRecordState);
    if (this.c == null)
    {
      InfoRecognizer.b.b(-302);
      return;
    }
    try
    {
      this.c.startRecording();
      localVoiceRecordState = VoiceRecordState.Recording;
      InfoRecognizer.b.a(localVoiceRecordState);
      if (this.f.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
      {
        InfoRecognizer.b.b(-304);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      InfoRecognizer.b.b(-302);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    int i3 = InfoRecorder.h / InfoRecorder.b;
    int k = 0;
    LogTool.d("preAudioMax = " + i3);
    int j = 0;
    int n = 3;
    int i = 1;
    for (;;)
    {
      if (!this.a) {}
      byte[] arrayOfByte;
      int i1;
      a locala;
      int i2;
      for (;;)
      {
        this.f.Release();
        try
        {
          this.c.stop();
          this.c.release();
          this.c = null;
          return;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          InfoRecognizer.b.b(-306);
          return;
        }
        arrayOfByte = new byte[InfoRecorder.b];
        int m = this.c.read(arrayOfByte, 0, InfoRecorder.b);
        if (m == -3)
        {
          InfoRecognizer.b.b(10131);
        }
        else if (m == -2)
        {
          InfoRecognizer.b.b(10132);
        }
        else if (m != InfoRecorder.b)
        {
          InfoRecognizer.b.b(-303);
        }
        else
        {
          i1 = k + m;
          if (InfoRecorder.d > 0)
          {
            LogTool.d("timeOffset = " + i1 + " timeOut = " + (InfoRecorder.a << 1) * InfoRecorder.d / 1000);
            if ((i != 0) && (i1 > (InfoRecorder.a << 1) * InfoRecorder.d / 1000L))
            {
              InfoRecognizer.b.b(-307);
              continue;
            }
          }
          k = Common.calculateVolumn(arrayOfByte, m);
          InfoRecognizer.b.a(k);
          if (!this.b)
          {
            localObject = VoiceRecordState.Complete;
            InfoRecognizer.b.a((VoiceRecordState)localObject);
            if (j == 0)
            {
              locala = new a(null, InnerAudioState.cancel);
              locala.c = i1;
              if (this.g.a(locala)) {
                continue;
              }
              InfoRecognizer.b.b(-305);
              continue;
            }
            if (j != 0)
            {
              LogTool.d("speaking stop");
              locala = new a(arrayOfByte, InnerAudioState.stop);
              locala.c = i1;
              if (this.g.a(locala)) {
                continue;
              }
              InfoRecognizer.b.b(-305);
              continue;
            }
          }
          i2 = this.f.AddData(arrayOfByte, m);
          k = i;
          m = j;
          if (j == 0)
          {
            k = i;
            m = j;
            if (i2 == 2)
            {
              k = i;
              m = j;
              if (n == 3)
              {
                m = 1;
                k = 0;
                i = 0;
                LogTool.d("speaking start: preAudio size = " + locala.size());
                if (!locala.isEmpty())
                {
                  localObject = new a((byte[])locala.removeFirst(), InnerAudioState.begin);
                  ((a)localObject).c = i1;
                  if (!this.g.a((a)localObject))
                  {
                    InfoRecognizer.b.b(-305);
                    continue;
                    label632:
                    localObject = new a((byte[])locala.removeFirst(), InnerAudioState.middle);
                    ((a)localObject).c = i1;
                    if (!this.g.a((a)localObject))
                    {
                      InfoRecognizer.b.b(-305);
                      j = 1;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            k = j;
            if (j == 0) {
              break label890;
            }
            if ((i2 != 3) || (n != 2)) {
              break label843;
            }
            if (!InfoRecognizer.f)
            {
              localObject = VoiceRecordState.Complete;
              InfoRecognizer.b.a((VoiceRecordState)localObject);
            }
            k = 0;
            LogTool.d("speaking stop");
            locala.clear();
            if (InfoRecognizer.f) {
              break label798;
            }
            locala = new a(arrayOfByte, InnerAudioState.stop);
            locala.c = i1;
            if (this.g.a(locala)) {
              break;
            }
            InfoRecognizer.b.b(-305);
            break;
            if (!locala.isEmpty()) {
              break label632;
            }
            j = m;
            i = k;
          }
          label798:
          Object localObject = new a(arrayOfByte, InnerAudioState.end);
          ((a)localObject).c = i1;
          if (this.g.a((a)localObject)) {
            break;
          }
          InfoRecognizer.b.b(-305);
          continue;
          label843:
          localObject = new a(arrayOfByte, InnerAudioState.middle);
          ((a)localObject).c = i1;
          k = j;
          if (this.g.a((a)localObject)) {
            break;
          }
          InfoRecognizer.b.b(-305);
        }
      }
      label890:
      locala.add(arrayOfByte);
      if (locala.size() > i3) {
        locala.removeFirst();
      }
      n = i2;
      j = k;
      k = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.c
 * JD-Core Version:    0.7.0.1
 */