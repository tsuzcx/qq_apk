package com.tencent.gdtad.views.canvas.components.fixedbutton;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData;

public class GdtCanvasFixedButtonComponentData
  extends GdtCanvasAppBtnComponentData
{
  public static final String BUTTON_STYLE_1 = "fixedBtn-1";
  public static final String BUTTON_STYLE_2 = "fixedBtn-2";
  public static final String POSITION_B0TTOM = "bottom";
  public static final String POSITION_TOP = "top";
  public String buttonStyle;
  public String desc;
  public long fileSize;
  public String imageUrl;
  public String name;
  public String position;
  public int toBottom;
  public int whiteSpace;
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.buttonStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentData
 * JD-Core Version:    0.7.0.1
 */