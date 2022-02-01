package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvp.IBasePresenter;
import com.tencent.mvp.IBasePresenterView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class MoveDistIndicateView
  extends ImageView
  implements IBasePresenterView
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private IThemeViewPresenter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelIThemeViewPresenter;
  public int b;
  private Bitmap b;
  private int c;
  private int d = 0;
  private int e = 0;
  
  public MoveDistIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_Int = ViewUtils.a(29.0F);
    this.jdField_b_of_type_Int = ViewUtils.a(42.0F);
    this.e = ViewUtils.a(10.0F);
    this.c = this.jdField_a_of_type_Int;
    if (QLog.isDevelopLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("init(), mRaidusMin:");
      paramContext.append(this.jdField_a_of_type_Int);
      paramContext.append(",mRaidusMax:");
      paramContext.append(this.jdField_b_of_type_Int);
      QLog.d("MoveDistIndicateView", 4, paramContext.toString());
    }
  }
  
  public IBasePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelIThemeViewPresenter;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    int m = i / 2;
    int n = j / 2;
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    int i1 = this.c;
    int i2 = this.jdField_a_of_type_Int;
    float f1;
    if (i1 > this.e + i2)
    {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        f1 = this.jdField_b_of_type_Int / i2;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((i - m * f1) / 2.0F, (j - n * f1) / 2.0F);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
      else
      {
        if (this.d == 1) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167173));
        } else {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167174));
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    else if (i1 > i2)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167055));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(m, n, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      Object localObject;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        f1 = i1 / i2;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        float f2 = (i - m * f1) * 0.5F + 0.5F;
        float f3 = (j - n * f1) * 0.5F + 0.5F;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dx is:");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(",dy is:");
          ((StringBuilder)localObject).append(f3);
          QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelIThemeViewPresenter;
        if ((localObject != null) && (((IThemeViewPresenter)localObject).a(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711423);
        } else {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    paramCanvas.restoreToCount(k);
    super.onDraw(paramCanvas);
  }
  
  public void setAfterBitmap(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setLevel(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.c = (i + (this.jdField_b_of_type_Int - i) * paramInt / 100);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLevel(), max=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" min=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" mRadius=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" type =");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" level=");
      localStringBuilder.append(paramInt);
      QLog.d("MoveDistIndicateView", 4, localStringBuilder.toString());
    }
    if (this.c > this.jdField_a_of_type_Int + this.e) {
      setPressed(true);
    } else {
      setPressed(false);
    }
    invalidate();
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if ((paramIBasePresenter != null) && ((paramIBasePresenter instanceof IThemeViewPresenter))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelIThemeViewPresenter = ((IThemeViewPresenter)paramIBasePresenter);
    }
    if (paramIBasePresenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelIThemeViewPresenter = null;
    }
  }
  
  public void setScaleBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setType(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView
 * JD-Core Version:    0.7.0.1
 */