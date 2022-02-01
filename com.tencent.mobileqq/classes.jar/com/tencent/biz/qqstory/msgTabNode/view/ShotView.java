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
    LayoutInflater.from(paramContext).inflate(2131628095, this);
    ((TextView)findViewById(2131447463)).setText(HardCodeUtil.a(2131911504));
    ((ImageView)findViewById(2131434889)).setImageResource(2130848421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.ShotView
 * JD-Core Version:    0.7.0.1
 */