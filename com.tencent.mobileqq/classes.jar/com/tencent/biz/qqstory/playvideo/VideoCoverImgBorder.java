package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;

public class VideoCoverImgBorder
  extends ImageView
{
  private final int a = UIUtils.a(getContext(), 1.0F);
  private final int b = UIUtils.a(getContext(), 2.0F);
  private Path c;
  private int d = this.b;
  private RectF e = new RectF();
  private RectF f = new RectF();
  private int g = 0;
  private int h = 0;
  private int i = this.b;
  private int j = -1;
  
  public VideoCoverImgBorder(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public VideoCoverImgBorder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.c == null) {
      this.c = new Path();
    }
    this.c.reset();
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    Object localObject = this.e;
    int m = this.g;
    int n = this.i;
    ((RectF)localObject).left = (m + n);
    ((RectF)localObject).top = (this.h + n);
    ((RectF)localObject).right = (getWidth() - this.i - this.g);
    this.e.bottom = (getHeight() - this.i - this.h);
    localObject = this.c;
    RectF localRectF = this.e;
    m = this.d;
    ((Path)localObject).addRoundRect(localRectF, m, m, Path.Direction.CCW);
    paramCanvas.clipPath(this.c);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(k);
    this.c.reset();
    localObject = this.f;
    ((RectF)localObject).left = this.g;
    ((RectF)localObject).top = this.h;
    ((RectF)localObject).right = (getWidth() - this.g);
    this.f.bottom = (getHeight() - this.h);
    localObject = this.c;
    localRectF = this.e;
    m = this.d;
    ((Path)localObject).addRoundRect(localRectF, m, m, Path.Direction.CCW);
    localObject = this.c;
    localRectF = this.f;
    m = this.d;
    n = this.i;
    ((Path)localObject).addRoundRect(localRectF, m + n, m + n, Path.Direction.CCW);
    this.c.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.c);
    paramCanvas.drawColor(this.j);
    paramCanvas.restoreToCount(k);
  }
  
  public void setState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramInt = this.a;
        this.g = paramInt;
        this.h = paramInt;
        this.i = paramInt;
        this.j = -1;
        return;
      }
      this.g = 0;
      this.h = 0;
      this.i = this.b;
      this.j = -15550475;
      return;
    }
    paramInt = this.a;
    this.g = paramInt;
    this.h = paramInt;
    this.i = paramInt;
    this.j = -570319;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverImgBorder
 * JD-Core Version:    0.7.0.1
 */