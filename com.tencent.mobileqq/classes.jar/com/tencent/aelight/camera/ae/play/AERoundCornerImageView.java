package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;

public class AERoundCornerImageView
  extends KandianUrlImageView
{
  public static final int ALL = 0;
  public static final int TOP = 1;
  private int corner = 0;
  private int mMode = 0;
  private Path mPath = new Path();
  private RectF mRectF = new RectF();
  
  public AERoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AERoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AERoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    if (this.corner > 0)
    {
      this.mPath.reset();
      int j = getWidth() - getPaddingLeft() - getPaddingRight();
      int i = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      this.mRectF.left = getPaddingLeft();
      this.mRectF.top = getPaddingTop();
      this.mRectF.right = (getPaddingLeft() + j);
      this.mRectF.bottom = (getPaddingTop() + (i - k - m));
      i = this.corner;
      if (i <= 0) {
        i = j / 30;
      }
      j = this.mMode;
      RectF localRectF;
      float f;
      if (j == 0)
      {
        localObject = this.mPath;
        localRectF = this.mRectF;
        f = i;
        ((Path)localObject).addRoundRect(localRectF, f, f, Path.Direction.CCW);
      }
      else if (j == 1)
      {
        f = i;
        localObject = this.mPath;
        localRectF = this.mRectF;
        Path.Direction localDirection = Path.Direction.CCW;
        ((Path)localObject).addRoundRect(localRectF, new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      }
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
    }
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("e:");
      ((StringBuilder)localObject).append(paramCanvas.getMessage());
      QLog.e("RoundCornerImageView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setCorner(int paramInt)
  {
    setCorner(paramInt, 0);
  }
  
  public void setCorner(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    this.mMode = paramInt2;
    this.corner = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AERoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */