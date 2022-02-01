package com.tencent.aelight.camera.struct.editor;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.HardCodeUtil;

public class HorizontalStroke
{
  public static final int[] a = { -1, -2148308, -1009097, -8136876, -13338378 };
  public static final int[] b = { -16777216, -1, -2148308, -1009097, -8136876, -13338378 };
  public int c;
  public int d;
  public String e;
  public Drawable f;
  public String g;
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.f = paramDrawable;
    this.c = paramInt1;
    this.d = paramInt2;
    if (paramInt1 == 0) {
      this.g = a(paramInt2);
    }
  }
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.f = paramDrawable;
    this.c = paramInt;
    this.e = paramString;
    this.d = Color.parseColor(paramString);
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b[2];
    }
    return a[1];
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -1: 
      return HardCodeUtil.a(2131900348);
    case -274353: 
      return HardCodeUtil.a(2131900345);
    case -1009097: 
    case -27392: 
      return HardCodeUtil.a(2131900353);
    case -2148308: 
    case -845543: 
      return HardCodeUtil.a(2131900350);
    case -5789785: 
      return HardCodeUtil.a(2131900346);
    case -6989057: 
      return HardCodeUtil.a(2131900347);
    case -10233288: 
    case -8136876: 
      return HardCodeUtil.a(2131900351);
    case -13338378: 
    case -9576193: 
      return HardCodeUtil.a(2131900352);
    }
    return HardCodeUtil.a(2131900354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.HorizontalStroke
 * JD-Core Version:    0.7.0.1
 */