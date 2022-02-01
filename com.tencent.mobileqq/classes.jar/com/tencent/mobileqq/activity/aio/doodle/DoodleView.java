package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

public class DoodleView
  extends View
{
  private LineLayer a;
  private DoodleView.DoodleViewListener b;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.a = new LineLayer(this);
    this.a.a();
    this.a.a(new DoodleView.1(this));
    this.a.a(LineLayer.d);
    super.requestLayout();
  }
  
  public int a(boolean paramBoolean)
  {
    LineLayer localLineLayer;
    if (!paramBoolean)
    {
      localLineLayer = this.a;
      if (localLineLayer != null) {
        return localLineLayer.l();
      }
    }
    else
    {
      localLineLayer = this.a;
      if (localLineLayer != null) {
        return localLineLayer.m();
      }
    }
    return 0;
  }
  
  public Bitmap a(int paramInt)
  {
    int i = getWidth();
    i = (int)(getHeight() * 1.0F / i * paramInt);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (this.a != null) {
        this.a.d(localCanvas);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError|Exception localOutOfMemoryError) {}
    return null;
  }
  
  public void a()
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.b();
    }
    this.b = null;
  }
  
  public void a(DoodleView.DoodleViewListener paramDoodleViewListener)
  {
    this.b = paramDoodleViewListener;
    c();
  }
  
  public DoodleItem b(boolean paramBoolean)
  {
    if (this.a == null) {
      return null;
    }
    DoodleItem localDoodleItem = new DoodleItem();
    localDoodleItem.a(getLinePathList(), paramBoolean, true);
    localDoodleItem.a().a(getDoodleParam());
    return localDoodleItem;
  }
  
  public void b()
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.i();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.a(paramBoolean);
    }
    super.invalidate();
  }
  
  public DoodleParam getDoodleParam()
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer == null) {
      return null;
    }
    return localLineLayer.k();
  }
  
  public List<PathData> getLinePathList()
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      return localLineLayer.j();
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      LineLayer localLineLayer = this.a;
      if (localLineLayer != null) {
        localLineLayer.a(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      return localLineLayer.a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
    if (paramInt != 0)
    {
      paramView = this.a;
      if ((paramView != null) && (paramView.l() == 0)) {
        this.a.a(true);
      }
    }
    else
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.g();
      }
    }
  }
  
  public void setLineColor(int paramInt)
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.a(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    LineLayer localLineLayer = this.a;
    if (localLineLayer != null) {
      localLineLayer.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */