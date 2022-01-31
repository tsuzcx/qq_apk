package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.vad.TRSilkDecoder;
import com.qq.wx.voice.vad.TRSilkEncoder;

public class VoiceRecognizer
{
  private static VoiceRecognizer a = null;
  private b b = new b();
  
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
    this.b.c();
    return 0;
  }
  
  public void destroy()
  {
    this.b.d();
  }
  
  public int init(Context paramContext, String paramString)
  {
    return this.b.a(paramContext, paramString);
  }
  
  public int init(Context paramContext, String paramString1, String paramString2)
  {
    return this.b.a(paramContext, paramString1, paramString2);
  }
  
  public int initNoLoadSo(Context paramContext, String paramString)
  {
    return this.b.b(paramContext, paramString);
  }
  
  public byte[] processPCMToSilk(byte[] paramArrayOfByte)
  {
    b localb = this.b;
    return TRSilkEncoder.processPCMToSilk(paramArrayOfByte);
  }
  
  public byte[] processSilkToPCM(byte[] paramArrayOfByte)
  {
    b localb = this.b;
    return TRSilkDecoder.processSilkToPCM(paramArrayOfByte);
  }
  
  public void recvResponse(byte[] paramArrayOfByte)
  {
    this.b.a(paramArrayOfByte);
  }
  
  public void resetDomain()
  {
    b localb = this.b;
    InfoSender.resetDomain();
  }
  
  public void resetGetPureRes()
  {
    b localb = this.b;
    b.f();
  }
  
  public void resetUri()
  {
    b localb = this.b;
    InfoSender.resetUri();
  }
  
  public void setBackRecord(boolean paramBoolean)
  {
    b localb = this.b;
    b.e(paramBoolean);
  }
  
  public void setCompressOpen(boolean paramBoolean)
  {
    b localb = this.b;
    b.b(paramBoolean);
  }
  
  public void setContReco(boolean paramBoolean)
  {
    b localb = this.b;
    b.d(paramBoolean);
  }
  
  public void setContRes(boolean paramBoolean)
  {
    b localb = this.b;
    b.c(paramBoolean);
  }
  
  public void setDomain(String paramString1, int paramInt, String paramString2)
  {
    b localb = this.b;
    InfoSender.setDomain(paramString1, paramInt, paramString2);
  }
  
  public void setGetArgs(String paramString)
  {
    b localb = this.b;
    b.b(paramString);
  }
  
  public void setGetPackageMode(boolean paramBoolean)
  {
    b localb = this.b;
    b.f(paramBoolean);
  }
  
  public void setGetPureRes(boolean paramBoolean)
  {
    b localb = this.b;
    b.g(paramBoolean);
  }
  
  public void setListener(VoiceRecognizerListener paramVoiceRecognizerListener)
  {
    b localb = this.b;
    b.a(paramVoiceRecognizerListener);
  }
  
  public void setMaxResultCount(int paramInt)
  {
    b localb = this.b;
    b.d(paramInt);
  }
  
  public void setOpenLogCat(boolean paramBoolean)
  {
    b localb = this.b;
    com.qq.wx.voice.util.LogTool.isShow = paramBoolean;
  }
  
  public void setResultType(int paramInt)
  {
    b localb = this.b;
    b.e(paramInt);
  }
  
  public void setSaveSilk(boolean paramBoolean)
  {
    b localb = this.b;
    b.i(paramBoolean);
  }
  
  public void setSaveSpeex(boolean paramBoolean) {}
  
  public void setSaveVoice(boolean paramBoolean)
  {
    b localb = this.b;
    b.h(paramBoolean);
  }
  
  public void setSemanticType(String paramString)
  {
    if (paramString != null)
    {
      b localb = this.b;
      b.a(paramString);
    }
  }
  
  public void setSilentTime(int paramInt)
  {
    b localb = this.b;
    b.a(paramInt);
  }
  
  public void setTimeout(int paramInt)
  {
    b localb = this.b;
    b.b(paramInt);
  }
  
  public void setUri(String paramString)
  {
    b localb = this.b;
    InfoSender.setUri(paramString);
  }
  
  public void setVadOpen(boolean paramBoolean)
  {
    b localb = this.b;
    b.a(paramBoolean);
  }
  
  public void setVrDomain(int paramInt)
  {
    b localb = this.b;
    b.c(paramInt);
  }
  
  public int start()
  {
    return this.b.a();
  }
  
  public int startReceiving()
  {
    return this.b.e();
  }
  
  public int stop()
  {
    this.b.b();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.VoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */