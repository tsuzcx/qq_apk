package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mvp.IBasePresenter;
import com.tencent.mvp.IBasePresenterView;
import com.tencent.mvp.SimpleMVPUtils;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends ImageView
  implements IBasePresenterView
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ICircleProcessViewPresenter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICircleProcessViewPresenter;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  private int c = -9013368;
  private int d = 6;
  private int e = ScreenUtil.dip2px(9.0F);
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public IBasePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICircleProcessViewPresenter;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int k = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 != null) {}
    try
    {
      localObject1 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label56:
      Object localObject2;
      int m;
      float f;
      break label56;
    }
    localObject1 = null;
    localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject2 != null) && (localObject1 != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject2).getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, j, k);
      j = this.jdField_a_of_type_Int * 360 / 100;
      localObject2 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject2).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      ((Canvas)localObject2).drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, j - 90, 360 - j, true, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap((Bitmap)localObject1, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      ((Bitmap)localObject1).recycle();
    }
    else
    {
      m = this.b;
      if (m > 0) {
        f = m;
      } else {
        f = 3.0F;
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRectF;
      m = this.e;
      ((RectF)localObject1).set(m + f, m + f, j - f - m, k - f - m);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      j = this.jdField_a_of_type_Int * 360 / 100;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, j, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(i);
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      SimpleMVPUtils.a(this, "startPlayAnim");
      this.jdField_a_of_type_Boolean = false;
    }
    catch (Exception localException)
    {
      label371:
      break label371;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CircleProgressView startPlayAnimByType error e=");
      ((StringBuilder)localObject1).append(toString());
      QLog.e("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_Boolean = false;
    super.onDraw(paramCanvas);
  }
  
  public void setAnimFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if (paramIBasePresenter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICircleProcessViewPresenter = null;
      return;
    }
    if ((paramIBasePresenter instanceof ICircleProcessViewPresenter)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICircleProcessViewPresenter = ((ICircleProcessViewPresenter)paramIBasePresenter);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setProgressBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setRingColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */