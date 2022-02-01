package com.tencent.aelight.camera.aioeditor.setting;

import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import dov.com.qq.im.ae.current.SessionWrap;

public class CapturePicParams$CapturePicParamsBuilder
{
  public boolean a;
  public int b;
  private SessionWrap c;
  private String d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int i;
  private String j;
  private int k;
  
  public CapturePicParams$CapturePicParamsBuilder(int paramInt)
  {
    int m = 1;
    this.f = 1;
    this.g = true;
    this.h = 11;
    this.k = 0;
    this.a = true;
    this.b = 0;
    if (paramInt == 2) {
      m = 0;
    }
    this.e = m;
  }
  
  public CapturePicParamsBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder a(SessionWrap paramSessionWrap)
  {
    this.c = paramSessionWrap;
    if (paramSessionWrap != null) {
      this.h = AIOShortVideoUtil.a(paramSessionWrap.c);
    }
    return this;
  }
  
  public CapturePicParamsBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public CapturePicParams a()
  {
    return new CapturePicParams(this, null);
  }
  
  public CapturePicParamsBuilder b(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CapturePicParams.CapturePicParamsBuilder
 * JD-Core Version:    0.7.0.1
 */