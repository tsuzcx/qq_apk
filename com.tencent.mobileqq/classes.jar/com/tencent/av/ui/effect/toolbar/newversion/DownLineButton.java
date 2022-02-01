package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class DownLineButton
  extends Button
{
  private static String a = "DownLineButton";
  private Paint b = new Paint();
  
  public DownLineButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public DownLineButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DownLineButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = getTextColors();
    if (localObject == null) {
      return;
    }
    int i = ((ColorStateList)localObject).getColorForState(View.SELECTED_STATE_SET, 0);
    if (!paramBoolean) {
      i = Color.parseColor("#00000000");
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("color = ");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.b.setAntiAlias(true);
    this.b.setColor(i);
    this.b.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(getPaddingLeft(), getHeight() - ViewUtils.dip2px(2.0F), getWidth() - getPaddingRight(), getHeight(), this.b);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onDraw");
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.DownLineButton
 * JD-Core Version:    0.7.0.1
 */