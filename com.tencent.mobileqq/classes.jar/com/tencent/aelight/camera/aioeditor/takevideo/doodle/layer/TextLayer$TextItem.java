package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public class TextLayer$TextItem
  extends GestureHelper.ZoomItem
{
  public float a;
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public DynamicTextItem a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  
  public TextLayer$TextItem(TextLayer paramTextLayer)
  {
    this(paramTextLayer, new TextLayer.LayerParams(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramTextLayer.jdField_a_of_type_AndroidGraphicsPointF);
    this.jdField_i_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextLayer.LayerParams paramLayerParams)
  {
    super(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.b, paramLayerParams.c, paramLayerParams.d, paramLayerParams.jdField_e_of_type_Float, paramLayerParams.jdField_f_of_type_Float, true);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = new NormalTextItem();
    this.n = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a();
    this.o = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b();
    this.jdField_a_of_type_Float = TextLayer.jdField_a_of_type_Int;
    this.jdField_i_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextItem paramTextItem)
  {
    super(paramTextItem, 1.0F);
    paramTextLayer = paramTextItem.jdField_a_of_type_AndroidGraphicsRect;
    if (paramTextLayer == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    } else {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramTextLayer);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    this.jdField_a_of_type_Float = paramTextItem.jdField_a_of_type_Float;
    this.b = paramTextItem.b;
    this.c = paramTextItem.c;
    this.d = paramTextItem.d;
    this.jdField_e_of_type_Float = paramTextItem.jdField_e_of_type_Float;
    this.jdField_f_of_type_Float = paramTextItem.jdField_f_of_type_Float;
    this.g = paramTextItem.g;
    this.h = paramTextItem.h;
    this.jdField_i_of_type_Float = paramTextItem.jdField_i_of_type_Float;
    this.jdField_i_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.save();
    int j;
    if (this.jdField_j_of_type_Int == 0) {
      j = 2130844624;
    } else {
      j = 2130844623;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked()) {
      if (this.jdField_j_of_type_Int == 0) {
        j = 2130844630;
      } else {
        j = 2130844628;
      }
    }
    int m;
    if (this.jdField_j_of_type_Int == 1) {
      m = 2130844620;
    } else {
      m = 2130844619;
    }
    int k;
    if (this.jdField_j_of_type_Int == 2) {
      k = 2130844627;
    } else {
      k = 2130844626;
    }
    if (this.jdField_i_of_type_Boolean) {
      j = -1;
    }
    if (TextLayer.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer).a.e())
    {
      j = -1;
      k = -1;
    }
    DisplayUtil.a(paramCanvas, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper, this, j, m, k);
    paramCanvas.restore();
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.e);
    localValueAnimator.addUpdateListener(new TextLayer.TextItem.1(this));
    localValueAnimator.start();
  }
  
  private void e()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.e);
    localValueAnimator.addUpdateListener(new TextLayer.TextItem.2(this));
    localValueAnimator.start();
  }
  
  protected void a()
  {
    this.d = this.l;
    this.jdField_e_of_type_Float = this.m;
    this.b = this.jdField_j_of_type_Float;
    this.c = this.k;
    this.jdField_f_of_type_Float = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.n - this.jdField_a_of_type_AndroidGraphicsPointF.x - this.d);
    this.g = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.o - this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_e_of_type_Float);
    this.h = (1.0F - this.b);
    float f1 = this.c;
    if (f1 < 180.0F)
    {
      this.jdField_i_of_type_Float = (0.0F - f1);
      return;
    }
    this.jdField_i_of_type_Float = (360.0F - f1);
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(TextLayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer).a())) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this, true));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_f_of_type_Boolean) {
      c(paramCanvas);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TextLayer.TextItem.3(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new TextLayer.TextItem.4(this));
    }
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(TextLayer.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer).a())) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this, false));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b(paramCanvas);
    paramCanvas.restore();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      localStringBuilder.append("centerP x : ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.x);
      localStringBuilder.append(" y: ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.y);
    }
    localStringBuilder.append("textLeft: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append("mSaveScaleValue: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("mSaveRotateValue: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("mSaveTranslateXValue: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("mDistanceX: ");
    localStringBuilder.append(this.jdField_f_of_type_Float);
    localStringBuilder.append("mDistanceY: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("mDScale: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("mDRotate: ");
    localStringBuilder.append(this.jdField_i_of_type_Float);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem
 * JD-Core Version:    0.7.0.1
 */