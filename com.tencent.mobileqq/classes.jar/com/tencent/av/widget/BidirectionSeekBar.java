package com.tencent.av.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.SeekBar;
import mxq;

public class BidirectionSeekBar
  extends SeekBar
{
  private int a;
  private int b;
  
  public BidirectionSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BidirectionSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BidirectionSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(11)
  private void a()
  {
    if (getThumbOffset() != 0) {
      setThumbOffset(0);
    }
    int i = getResources().getDrawable(2130841608).getIntrinsicWidth();
    Object localObject = getProgressDrawable();
    if ((localObject instanceof LayerDrawable))
    {
      localObject = (LayerDrawable)localObject;
      Drawable localDrawable = ((LayerDrawable)localObject).findDrawableByLayerId(16908301);
      mxq localmxq = new mxq(getResources().getDrawable(2130841600), getResources().getDrawable(2130841603), 1, i);
      localmxq.setLevel(localDrawable.getLevel());
      ((LayerDrawable)localObject).setDrawableByLayerId(16908301, localmxq);
    }
    if (Build.VERSION.SDK_INT >= 11) {}
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    super.setThumb(paramDrawable);
    setThumbOffset(0);
    onSizeChanged(this.a, this.b, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.BidirectionSeekBar
 * JD-Core Version:    0.7.0.1
 */