package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

public class AnimationQIMCircleProgress
  extends QIMCircleProgress
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private AECircleCaptureStyle jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureStyle = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  
  public AnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i = (getWidth() - this.jdField_c_of_type_Int) / 2;
    int k = getHeight();
    int j = this.jdField_c_of_type_Int;
    k = (k - j) / 2;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i, k, i + j, k + j);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    i = this.jdField_d_of_type_Int;
    paramCanvas.drawRoundRect(localRectF, i, i, this.mPaintWhite);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      setBackgroundResource(2130837905);
      setCenterCircleColor(getResources().getColor(2131166325));
    }
    else
    {
      setBackgroundResource(2130844508);
      setCenterCircleColor(-1);
    }
    invalidate();
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureStyle = paramAECircleCaptureStyle;
    if (this.jdField_c_of_type_Boolean)
    {
      setBackgroundResource(this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureStyle.jdField_c_of_type_Int);
      setCenterCircleColor(0);
      setProgressOffset(AIOUtils.b(2.5F, getResources()));
      setProgressColor(this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureStyle.g);
    }
    else
    {
      setBackgroundResource(2130844508);
      setCenterCircleColor(-1);
    }
    invalidate();
  }
  
  protected void b(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_b_of_type_Int * this.mCenterScale, this.mPaintWhite);
  }
  
  protected void c(Canvas paramCanvas)
  {
    int i = UIUtils.a(getContext(), 3.0F);
    Color.parseColor("#33000000");
    float f1 = this.mWidth / 2;
    float f2 = this.mWidth / 2;
    float f3 = this.mWidth / 2 - i / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawCircle(f1, f2, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void changeMode(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      AECircleCaptureStyle localAECircleCaptureStyle = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureStyle;
      if (localAECircleCaptureStyle != null)
      {
        setBackgroundResource(localAECircleCaptureStyle.jdField_c_of_type_Int);
        break label69;
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      setBackgroundResource(2130837905);
    } else if ((paramInt != 1) && (this.jdField_a_of_type_Boolean)) {
      setBackgroundDrawable(null);
    } else {
      setBackgroundResource(2130844508);
    }
    label69:
    super.changeMode(paramInt);
  }
  
  protected void drawCenterCircle(Canvas paramCanvas)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.mMode == 3)
      {
        a(paramCanvas);
        return;
      }
      b(paramCanvas);
      return;
    }
    if (this.mMode == 1)
    {
      b(paramCanvas);
      return;
    }
    if (this.mMode == 3) {
      a(paramCanvas);
    }
    c(paramCanvas);
  }
  
  protected void init()
  {
    super.init();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.mPaintWhite.setStyle(Paint.Style.FILL);
    setBackgroundResource(2130844508);
    this.jdField_c_of_type_Int = ViewUtils.a(30.0F);
    this.jdField_d_of_type_Int = ViewUtils.a(6.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void setCenterView()
  {
    super.setCenterView();
    this.jdField_a_of_type_Int = ViewUtils.a(3.0F);
    this.jdField_b_of_type_Int = (ViewUtils.a(53.0F) / 2);
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void setIldeStyle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      setBackgroundDrawable(null);
    } else {
      setBackgroundResource(2130844508);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */