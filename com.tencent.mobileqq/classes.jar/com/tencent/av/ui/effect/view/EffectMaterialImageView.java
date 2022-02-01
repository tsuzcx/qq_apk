package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class EffectMaterialImageView
  extends EffectMaterialBaseImageView
{
  private RectF g = new RectF();
  private boolean h = false;
  
  public EffectMaterialImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectMaterialImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EffectMaterialImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = AIOUtils.b(this.d, getResources()) - 2;
    int n = AIOUtils.b(this.e, getResources());
    int i1 = AIOUtils.b(12.0F, getResources());
    int k = getWidth() / 2;
    int m = getHeight() / 2;
    int j = Math.min(getWidth(), getHeight()) / 2;
    paramCanvas.drawARGB(0, 0, 0, 0);
    Object localObject = getDrawable();
    if (localObject != null)
    {
      if (this.b)
      {
        if (!(localObject instanceof TintStateDrawable)) {
          ((Drawable)localObject).setColorFilter(-10591367, PorterDuff.Mode.MULTIPLY);
        }
      }
      else if ((localObject instanceof URLDrawable)) {
        ((Drawable)localObject).setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      } else if (!(localObject instanceof TintStateDrawable)) {
        ((Drawable)localObject).clearColorFilter();
      }
      ((Drawable)localObject).setBounds(i, i, getWidth() - i, getHeight() - i);
      ((Drawable)localObject).draw(paramCanvas);
    }
    if ((this.a) && (!this.b))
    {
      this.c.reset();
      this.c.setAntiAlias(true);
      this.c.setColor(this.f);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setStrokeWidth(n);
      if (this.h)
      {
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
        return;
      }
      this.g.left = (this.e + i);
      this.g.top = (this.e + i);
      this.g.right = (getWidth() - this.e - i);
      this.g.bottom = (getHeight() - this.e - i);
      localObject = this.g;
      float f = i1;
      paramCanvas.drawRoundRect((RectF)localObject, f, f, this.c);
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.EffectMaterialImageView
 * JD-Core Version:    0.7.0.1
 */