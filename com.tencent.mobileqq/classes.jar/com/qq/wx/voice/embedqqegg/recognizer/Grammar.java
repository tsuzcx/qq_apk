package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import java.io.UnsupportedEncodingException;

public class Grammar
{
  private a a = null;
  private Context b;
  private GrammarResult c = new GrammarResult();
  private int d = 0;
  private int e = 0;
  private int f = -1;
  
  public int begin()
  {
    if (this.f == 0)
    {
      this.f = 1;
      try
      {
        if (GrammarNative.setKeywordSetIndex(InfoRecognizer.e) < 0) {
          return -1;
        }
        int i = GrammarNative.begin();
        if (i < 0) {
          return -1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -1;
      }
    }
    return 0;
  }
  
  public int destroy()
  {
    try
    {
      int i = GrammarNative.destroy();
      if (i < 0) {
        return -1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int end()
  {
    if (this.f == 1)
    {
      this.f = 0;
      try
      {
        int i = GrammarNative.end();
        if (i < 0) {
          return -1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -1;
      }
    }
    return 0;
  }
  
  public int getResult(GrammarResult paramGrammarResult)
  {
    try
    {
      int i = GrammarNative.getResult(this);
      if (i < 0) {
        return -1;
      }
      paramGrammarResult.text = this.c.text;
      paramGrammarResult.name = this.c.name;
      paramGrammarResult.action = this.c.action;
      paramGrammarResult.type = this.c.type;
      return 0;
    }
    catch (Exception paramGrammarResult)
    {
      paramGrammarResult.printStackTrace();
    }
    return -1;
  }
  
  public int getVersion(SDKVersion paramSDKVersion)
  {
    try
    {
      int i = GrammarNative.getVersion(this);
      if (i < 0) {
        return -1;
      }
      paramSDKVersion.soVer = this.d;
      paramSDKVersion.binVer = this.e;
      return 0;
    }
    catch (Exception paramSDKVersion)
    {
      paramSDKVersion.printStackTrace();
    }
    return -1;
  }
  
  public int init(Context paramContext)
  {
    this.b = paramContext;
    if (this.a.a(this.b) < 0) {
      return -1;
    }
    try
    {
      int i = GrammarNative.init(this.a.a().getBytes(), this.a.b().getBytes(), null);
      if (i < 0) {
        return -1;
      }
      this.f = 0;
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public void onGetResult(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    GrammarResult localGrammarResult = this.c;
    localGrammarResult.type = paramInt;
    if (paramArrayOfByte1 != null) {}
    try
    {
      localGrammarResult.text = new String(paramArrayOfByte1, "GBK");
      if (this.c.type != 0) {
        this.c.text = "";
      }
      if (paramArrayOfByte2 != null) {
        this.c.action = new String(paramArrayOfByte2, "GBK");
      } else {
        this.c.action = "";
      }
      if (paramArrayOfByte3 != null)
      {
        this.c.name = new String(paramArrayOfByte3, "GBK");
        return;
      }
      this.c.name = "";
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
  }
  
  public void onGetVersion(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public int recognize(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f == 1) {
      try
      {
        int i = GrammarNative.recognize(paramArrayOfByte, paramInt);
        if (i < 0) {
          return -1;
        }
        paramInt = i;
        if (i != 1) {
          return paramInt;
        }
        this.f = 0;
        return 1;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public int setKeywordSetIndex(int paramInt)
  {
    return GrammarNative.setKeywordSetIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.Grammar
 * JD-Core Version:    0.7.0.1
 */