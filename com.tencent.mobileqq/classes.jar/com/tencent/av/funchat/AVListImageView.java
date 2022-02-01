package com.tencent.av.funchat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.av.ui.effect.view.EffectMaterialBaseImageView;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AVListImageView
  extends EffectMaterialBaseImageView
{
  public AVListImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = AIOUtils.b(this.d, getResources()) - 2;
    int n = AIOUtils.b(this.e, getResources());
    int j = Math.min(getWidth(), getHeight()) / 2;
    int k = getWidth() / 2;
    int m = getHeight() / 2;
    paramCanvas.drawARGB(0, 0, 0, 0);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      if (this.b)
      {
        if (!(localDrawable instanceof TintStateDrawable)) {
          localDrawable.setColorFilter(-10591367, PorterDuff.Mode.MULTIPLY);
        }
      }
      else if ((localDrawable instanceof URLDrawable)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      } else if (!(localDrawable instanceof TintStateDrawable)) {
        localDrawable.clearColorFilter();
      }
      localDrawable.setBounds(i, i, getWidth() - i, getHeight() - i);
      localDrawable.draw(paramCanvas);
    }
    if ((this.a) && (!this.b))
    {
      this.c.reset();
      this.c.setAntiAlias(true);
      this.c.setColor(this.f);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setStrokeWidth(n);
      n = (n + 1) / 2;
      i = j;
      if (getParent() != null)
      {
        i = j;
        if ((getParent().getParent() instanceof LinearLayout)) {
          i = Math.min(((LinearLayout)getParent().getParent()).getWidth() / 2, j);
        }
      }
      paramCanvas.drawCircle(k, m, i - n, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.funchat.AVListImageView
 * JD-Core Version:    0.7.0.1
 */