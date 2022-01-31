package com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;

public class a
  extends c
{
  public static final String BUTTON_STYLE_1 = "fixedBtn-1";
  public static final String BUTTON_STYLE_2 = "fixedBtn-2";
  public static final String POSITION_B0TTOM = "bottom";
  public static final String POSITION_TOP = "top";
  public int bottomWhiteSpace = 0;
  public String buttonStyle;
  public String desc;
  public long fileSize;
  public String imageUrl;
  public String name;
  public String position;
  public int topWhiteSpace = 0;
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.buttonStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a
 * JD-Core Version:    0.7.0.1
 */