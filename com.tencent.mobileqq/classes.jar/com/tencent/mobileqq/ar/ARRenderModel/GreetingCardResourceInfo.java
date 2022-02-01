package com.tencent.mobileqq.ar.ARRenderModel;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class GreetingCardResourceInfo
  extends ARRenderResourceInfo
{
  public String i;
  public String j;
  
  public GreetingCardResourceInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.split("\\|");
      if (paramString1.length > 0) {
        this.i = paramString1[0];
      }
    }
    this.j = paramString3;
    QLog.d("GreetingCardResourceInfo", 2, String.format("GreetingCardResourceInfo mLuaScriptPath=%s mResourceDirPath=%s", new Object[] { this.i, this.j }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GreetingCardResourceInfo
 * JD-Core Version:    0.7.0.1
 */