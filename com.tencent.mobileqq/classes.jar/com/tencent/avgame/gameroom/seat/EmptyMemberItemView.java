package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import nbo;

public class EmptyMemberItemView
  extends RelativeLayout
{
  private View a;
  
  public EmptyMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmptyMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmptyMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = findViewById(2131366055);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = nbo.w;
    localLayoutParams.height = nbo.w;
    this.a.setLayoutParams(localLayoutParams);
    this.a.setBackgroundColor(getContext().getResources().getColor(2131165334));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.EmptyMemberItemView
 * JD-Core Version:    0.7.0.1
 */