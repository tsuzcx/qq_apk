package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;

public class FaceLayer$FaceItem
  extends GestureHelper.ZoomItem
{
  public long a;
  public RectF a;
  public Drawable a;
  public TroopBarPOI a;
  public boolean b;
  public boolean c;
  public final String d;
  public int e;
  public final String e;
  public int f;
  public final String f;
  public int g;
  public String g;
  public int h;
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.jdField_b_of_type_Float, paramLayerParams.c, paramLayerParams.d, paramLayerParams.jdField_a_of_type_Int, paramLayerParams.jdField_b_of_type_Int, true);
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.d = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
    this.jdField_b_of_type_Boolean = false;
    this.h = paramInt;
  }
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.jdField_f_of_type_Int = paramInt2;
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i;
    if (this.jdField_j_of_type_Int == 0) {
      i = 2130844622;
    } else {
      i = 2130844621;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked()) {
      if (this.jdField_j_of_type_Int == 0) {
        i = 2130844630;
      } else {
        i = 2130844628;
      }
    }
    int k;
    if (this.jdField_j_of_type_Int == 1) {
      k = 2130844620;
    } else {
      k = 2130844619;
    }
    int j;
    if (this.jdField_j_of_type_Int == 2) {
      j = 2130844627;
    } else {
      j = 2130844626;
    }
    if (this.i) {
      i = -1;
    }
    if (FaceLayer.d(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer).a.e())
    {
      i = -1;
      j = -1;
    }
    DisplayUtil.a(paramCanvas, this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper, this, i, k, j);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(FaceLayer.c(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer).a())) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this));
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_f_of_type_Boolean) {
      b(paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(FaceLayer.e(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer).a())) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = paramTroopBarPOI;
    if (paramTroopBarPOI != null)
    {
      a(paramTroopBarPOI.a());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(null);
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(String paramString)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      if ((localDrawable instanceof InfoStickerDrawable))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = InformationFaceConstant.a((InfoStickerDrawable)localDrawable, this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidContentContext, paramString);
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null) {
          this.g = ((InfoStickerDrawable)localDrawable).c();
        }
      }
      else if ((localDrawable instanceof BitmapDrawable))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = InformationFaceConstant.a(this.g, this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidContentContext, paramString);
      }
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable == null) {
        return;
      }
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      float f1 = this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_j_of_type_Float * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2.0F + this.l;
      if (f1 < ScreenUtil.dip2px(23.0F)) {
        this.jdField_a_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x - f1 + ScreenUtil.dip2px(23.0F));
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(FaceLayer.f(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer));
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
      this.n = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.o = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      ((PasterDataManager)QIMManager.a(4)).a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FaceLayer.FaceItem.1(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new FaceLayer.FaceItem.2(this));
    }
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem
 * JD-Core Version:    0.7.0.1
 */