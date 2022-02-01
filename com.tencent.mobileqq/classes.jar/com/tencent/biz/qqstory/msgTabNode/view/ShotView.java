package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

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
    LayoutInflater.from(paramContext).inflate(2131561865, this);
    ((TextView)findViewById(2131379432)).setText(HardCodeUtil.a(2131714042));
    ((ImageView)findViewById(2131368289)).setImageResource(2130846991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.ShotView
 * JD-Core Version:    0.7.0.1
 */