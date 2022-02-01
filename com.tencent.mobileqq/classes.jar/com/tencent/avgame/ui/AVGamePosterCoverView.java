package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class AVGamePosterCoverView
  extends AsyncImageView
{
  private int a = 16;
  private int b = this.a << 1;
  private Paint c;
  private Path d;
  
  public AVGamePosterCoverView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGamePosterCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.d = new Path();
    this.c = new Paint();
    this.c.setColor(-1);
    this.c.setAntiAlias(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.d.moveTo(0.0F, this.a);
    this.d.lineTo(0.0F, 0.0F);
    this.d.lineTo(this.a, 0.0F);
    Path localPath = this.d;
    int i = this.b;
    localPath.arcTo(new RectF(0.0F, 0.0F, i, i), -90.0F, -90.0F);
    this.d.close();
    paramCanvas.drawPath(this.d, this.c);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.d.moveTo(getWidth(), this.a);
    this.d.lineTo(getWidth(), 0.0F);
    this.d.lineTo(getWidth() - this.a, 0.0F);
    this.d.arcTo(new RectF(getWidth() - this.b, 0.0F, getWidth(), this.b), -90.0F, 90.0F);
    this.d.close();
    paramCanvas.drawPath(this.d, this.c);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.d.moveTo(0.0F, getHeight() - this.a);
    this.d.lineTo(0.0F, getHeight());
    this.d.lineTo(this.a, getHeight());
    Path localPath = this.d;
    int i = getHeight();
    int j = this.b;
    localPath.arcTo(new RectF(0.0F, i - j, j, getHeight()), 90.0F, 90.0F);
    this.d.close();
    paramCanvas.drawPath(this.d, this.c);
  }
  
  private void d(Canvas paramCanvas)
  {
    this.d.moveTo(getWidth() - this.a, getHeight());
    this.d.lineTo(getWidth(), getHeight());
    this.d.lineTo(getWidth(), getHeight() - this.a);
    RectF localRectF = new RectF(getWidth() - this.b, getHeight() - this.b, getWidth(), getHeight());
    this.d.arcTo(localRectF, 0.0F, 90.0F);
    this.d.close();
    paramCanvas.drawPath(this.d, this.c);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
  }
  
  public void setRadius(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterCoverView
 * JD-Core Version:    0.7.0.1
 */