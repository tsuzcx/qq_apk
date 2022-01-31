package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShotView
  extends LinearLayout
{
  public ShotView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130970735, this);
    ((TextView)findViewById(2131363360)).setText("拍摄");
    ((ImageView)findViewById(2131371737)).setImageResource(2130843452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.ShotView
 * JD-Core Version:    0.7.0.1
 */