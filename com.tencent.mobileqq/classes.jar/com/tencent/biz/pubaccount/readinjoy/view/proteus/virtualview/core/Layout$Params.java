package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class Layout$Params
{
  public int a = -1;
  public int b = -2;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  
  private static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    if (TextUtils.equals(paramString, "match_parent")) {
      return -1;
    }
    if (TextUtils.equals(paramString, "wrap_content")) {
      return -2;
    }
    try
    {
      int i = Utils.a(Double.valueOf(paramString).doubleValue());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("Layout_TMTEST", 2, "strAttributeToPx: " + paramString.getMessage());
    }
    return 0;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      this.a = a(paramString);
      continue;
      this.b = a(paramString);
      continue;
      this.e = a(paramString);
      continue;
      this.d = a(paramString);
      continue;
      this.f = a(paramString);
      continue;
      this.c = a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params
 * JD-Core Version:    0.7.0.1
 */