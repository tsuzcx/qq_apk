package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class EffectMaterialBaseImageView
  extends ImageView
{
  protected boolean a = false;
  protected boolean b = false;
  protected Paint c = null;
  protected int d = 3;
  protected int e = 3;
  protected int f = -15550475;
  
  public EffectMaterialBaseImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectMaterialBaseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EffectMaterialBaseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      setAlpha(0.5F);
      return true;
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      setAlpha(1.0F);
    }
    return true;
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
  }
  
  public void setDimmedColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.a = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.EffectMaterialBaseImageView
 * JD-Core Version:    0.7.0.1
 */