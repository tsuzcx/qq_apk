package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;

public class VoiceRecognizer
{
  private static VoiceRecognizer a = null;
  private c b = new c();
  
  public static VoiceRecognizer shareInstance()
  {
    if (a == null) {
      a = new VoiceRecognizer();
    }
    return a;
  }
  
  public int appendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.b.a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
  }
  
  public int cancel()
  {
    this.b.a();
    return 0;
  }
  
  public void destroy()
  {
    this.b.c();
  }
  
  public int getVersion(SDKVersion paramSDKVersion)
  {
    return this.b.a(paramSDKVersion);
  }
  
  public int init(Context paramContext)
  {
    return this.b.a(paramContext);
  }
  
  public int init(Context paramContext, String paramString1, String paramString2)
  {
    return this.b.a(paramContext, paramString1, paramString2);
  }
  
  public void setBackRecord(boolean paramBoolean)
  {
    c localc = this.b;
    c.b(paramBoolean);
  }
  
  public void setContReco(boolean paramBoolean)
  {
    c localc = this.b;
    c.a(paramBoolean);
  }
  
  public int setKeywordSetIndex(int paramInt)
  {
    return this.b.b(paramInt);
  }
  
  public void setListener(VoiceRecognizerListener paramVoiceRecognizerListener)
  {
    c localc = this.b;
    c.a(paramVoiceRecognizerListener);
  }
  
  public void setOpenLogCat(boolean paramBoolean)
  {
    c localc = this.b;
    com.qq.wx.voice.embedqqegg.util.LogTool.isShow = paramBoolean;
  }
  
  public void setSaveVoice(boolean paramBoolean)
  {
    c localc = this.b;
    c.c(paramBoolean);
  }
  
  public void setSilentTime(int paramInt)
  {
    c localc = this.b;
    c.a(paramInt);
  }
  
  public int setWakeupThres(int paramInt)
  {
    c localc = this.b;
    return c.c(paramInt);
  }
  
  public int start()
  {
    c localc = this.b;
    return 0;
  }
  
  public int startReceiving()
  {
    return this.b.d();
  }
  
  public int stop()
  {
    c localc = this.b;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */