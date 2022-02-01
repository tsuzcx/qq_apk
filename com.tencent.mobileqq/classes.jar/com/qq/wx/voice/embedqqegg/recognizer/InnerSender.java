package com.qq.wx.voice.embedqqegg.recognizer;

import com.qq.wx.voice.embedqqegg.util.Common;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InnerSender
  implements Runnable
{
  private boolean a = false;
  private Grammar b = new Grammar();
  private boolean c = false;
  private InnerAudioList d = null;
  
  private void a(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if ((paramVoiceRecognizerResult.text != null) && (!paramVoiceRecognizerResult.text.isEmpty())) {
      this.c = true;
    }
    try
    {
      InfoRecognizer.j.flush();
      paramVoiceRecognizerResult.voiceRecordPCMData = InfoRecognizer.j.toByteArray();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    InfoRecognizer.d.a(paramVoiceRecognizerResult);
  }
  
  private void e()
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
  
  protected final int a()
  {
    if (this.b.init(InfoRecognizer.a) < 0)
    {
      InfoRecognizer.d.b(-201);
      return -1;
    }
    SDKVersion localSDKVersion = new SDKVersion();
    a(localSDKVersion);
    StringBuilder localStringBuilder = new StringBuilder("soVer: ");
    localStringBuilder.append(localSDKVersion.soVer);
    localStringBuilder.append(" binVer: ");
    localStringBuilder.append(localSDKVersion.binVer);
    LogTool.d(localStringBuilder.toString());
    return 0;
  }
  
  protected final int a(SDKVersion paramSDKVersion)
  {
    if (this.b.getVersion(paramSDKVersion) < 0)
    {
      InfoRecognizer.d.b(-208);
      return -1;
    }
    return 0;
  }
  
  protected final void a(InnerAudioList paramInnerAudioList)
  {
    this.d = paramInnerAudioList;
    InfoRecognizer.j.reset();
    this.a = true;
  }
  
  protected final void b()
  {
    this.a = false;
  }
  
  protected final void c()
  {
    if (this.b.destroy() < 0) {
      InfoRecognizer.d.b(-206);
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
  
  public void run()
  {
    this.c = false;
    int j = 0;
    for (;;)
    {
      if (!this.a) {
        return;
      }
      b localb = this.d.b();
      if (localb != null)
      {
        if (localb.b == InnerAudioState.cancel)
        {
          a(new VoiceRecognizerResult(true));
        }
        else
        {
          int i = j;
          if (localb.b == InnerAudioState.begin)
          {
            if (this.b.begin() < 0)
            {
              InfoRecognizer.d.b(-202);
              return;
            }
            i = 0;
          }
          j = i;
          if (i == 0)
          {
            VoiceRecognizerResult localVoiceRecognizerResult;
            try
            {
              Object localObject1 = new StringBuilder("Recognize ");
              ((StringBuilder)localObject1).append(localb.a.length);
              ((StringBuilder)localObject1).append(" bytes begin");
              LogTool.d(((StringBuilder)localObject1).toString());
              int k = this.b.recognize(localb.a, localb.a.length);
              localObject1 = new StringBuilder("Recognize ");
              ((StringBuilder)localObject1).append(localb.a.length);
              ((StringBuilder)localObject1).append(" bytes finished");
              LogTool.d(((StringBuilder)localObject1).toString());
              if (k < 0)
              {
                InfoRecognizer.d.b(-203);
                return;
              }
              j = i;
              if (k == 1)
              {
                localObject1 = new GrammarResult();
                if (this.b.getResult((GrammarResult)localObject1) < 0)
                {
                  InfoRecognizer.d.b(-205);
                  return;
                }
                j = i;
                if (((GrammarResult)localObject1).text != null)
                {
                  j = i;
                  if (!((GrammarResult)localObject1).text.isEmpty())
                  {
                    localVoiceRecognizerResult = new VoiceRecognizerResult(true);
                    localVoiceRecognizerResult.text = ((GrammarResult)localObject1).text;
                    a(localVoiceRecognizerResult);
                    j = 1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              j = i;
            }
            if (localb.b != InnerAudioState.end)
            {
              i = j;
              if (localb.b != InnerAudioState.stop) {}
            }
            else
            {
              if (this.b.end() < 0)
              {
                InfoRecognizer.d.b(-204);
                return;
              }
              if (j == 0)
              {
                GrammarResult localGrammarResult = new GrammarResult();
                if (this.b.getResult(localGrammarResult) < 0)
                {
                  InfoRecognizer.d.b(-205);
                  return;
                }
                Object localObject2;
                if (InfoRecognizer.f)
                {
                  if ((localGrammarResult.text == null) || (localGrammarResult.text.isEmpty())) {
                    break label488;
                  }
                  localObject2 = new VoiceRecognizerResult(true);
                }
                else
                {
                  localVoiceRecognizerResult = new VoiceRecognizerResult(false);
                  localObject2 = localVoiceRecognizerResult;
                  if (localGrammarResult.text != null)
                  {
                    localObject2 = localVoiceRecognizerResult;
                    if (!localGrammarResult.text.isEmpty())
                    {
                      localVoiceRecognizerResult.isEnd = true;
                      localObject2 = localVoiceRecognizerResult;
                    }
                  }
                }
                ((VoiceRecognizerResult)localObject2).text = localGrammarResult.text;
                a((VoiceRecognizerResult)localObject2);
              }
              label488:
              i = 0;
            }
            try
            {
              if ((InfoRecognizer.g) || (InfoRecognizer.h))
              {
                if (localb.b == InnerAudioState.begin) {
                  InfoRecognizer.j.reset();
                }
                InfoRecognizer.j.write(localb.a);
                if ((localb.b == InnerAudioState.end) || (localb.b == InnerAudioState.stop) || (i != 0))
                {
                  InfoRecognizer.j.flush();
                  if (InfoRecognizer.h) {
                    Common.saveFile(InfoRecognizer.j.toByteArray(), "pcm", this.c);
                  }
                }
              }
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
            j = i;
            if (localb.b != InnerAudioState.stop) {}
          }
        }
      }
      else {
        try
        {
          e();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public int setKeywordSetIndex(int paramInt)
  {
    return this.b.setKeywordSetIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.InnerSender
 * JD-Core Version:    0.7.0.1
 */