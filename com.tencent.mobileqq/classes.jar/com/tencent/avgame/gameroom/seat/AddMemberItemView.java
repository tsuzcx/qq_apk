package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.qphone.base.util.QLog;

public class AddMemberItemView
  extends RelativeLayout
{
  private View a;
  
  public AddMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AddMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = findViewById(2131427827);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.a.setLayoutParams(localLayoutParams);
    this.a.setBackgroundColor(getContext().getResources().getColor(2131165547));
  }
  
  public RectF getViewRect()
  {
    Object localObject = new int[2];
    GameRoomViewLayoutParamsDef.a(this, (int[])localObject);
    RectF localRectF = new RectF();
    localRectF.left = localObject[0];
    localRectF.top = localObject[1];
    localRectF.right = (localRectF.left + getMeasuredWidth());
    localRectF.bottom = (localRectF.top + getMeasuredHeight());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getViewRect rectF:");
      ((StringBuilder)localObject).append(localRectF);
      QLog.i("AddMemberItemView", 2, ((StringBuilder)localObject).toString());
    }
    return localRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.AddMemberItemView
 * JD-Core Version:    0.7.0.1
 */