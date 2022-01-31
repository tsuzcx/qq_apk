package com.tencent.biz.qqstory.msgTabNode.view;

import alpo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@Deprecated
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
    LayoutInflater.from(paramContext).inflate(2131561493, this);
    ((TextView)findViewById(2131377884)).setText(alpo.a(2131714476));
    ((ImageView)findViewById(2131367514)).setImageResource(2130846115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.ShotView
 * JD-Core Version:    0.7.0.1
 */