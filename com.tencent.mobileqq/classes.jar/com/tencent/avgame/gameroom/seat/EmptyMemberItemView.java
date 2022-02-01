package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;

public class EmptyMemberItemView
  extends RelativeLayout
{
  private View a;
  private ImageView b;
  
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
    this.a = findViewById(2131432535);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.a.setLayoutParams(localLayoutParams);
    this.a.setBackgroundColor(getContext().getResources().getColor(2131165547));
    this.b = ((ImageView)findViewById(2131437992));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.EmptyMemberItemView
 * JD-Core Version:    0.7.0.1
 */