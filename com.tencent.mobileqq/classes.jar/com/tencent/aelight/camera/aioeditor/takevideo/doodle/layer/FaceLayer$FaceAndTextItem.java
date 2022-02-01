package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;

public final class FaceLayer$FaceAndTextItem
  extends FaceLayer.FaceItem
{
  public int a;
  public Path a;
  public StaticLayout a;
  public final String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt);
    this.jdField_a_of_type_JavaLangString = "...";
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_Int = paramLayerParams.d;
    this.jdField_b_of_type_Int = paramLayerParams.jdField_c_of_type_Int;
    a(paramLayerParams.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.jdField_f_of_type_Int = paramInt2;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new FaceLayer.FaceAndTextItem.1(this));
    localValueAnimator.addListener(new FaceLayer.FaceAndTextItem.2(this));
    localValueAnimator.start();
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this));
    DisplayUtil.a();
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, 10.0F);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.d.setAlpha(this.d);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.d);
    }
    paramCanvas.restore();
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.n, 6);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_f_of_type_Boolean)
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
      int j;
      if (this.jdField_j_of_type_Int == 1) {
        j = 2130844620;
      } else {
        j = 2130844619;
      }
      int k;
      if (this.jdField_j_of_type_Int == 2) {
        k = 2130844627;
      } else {
        k = 2130844626;
      }
      DisplayUtil.a(paramCanvas, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper, this, i, j, k);
      paramCanvas.restore();
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    float f2 = this.n;
    float f1 = this.o;
    if (f2 * this.jdField_j_of_type_Float < 200.0F) {
      f2 = this.jdField_j_of_type_Float;
    }
    if (f1 * this.jdField_j_of_type_Float < 200.0F) {
      f1 = this.jdField_j_of_type_Float;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.d.setAlpha(this.d);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.d);
      }
      paramCanvas.restore();
    }
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.n, 6);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
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
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e(FaceLayer.jdField_a_of_type_JavaLangString, "text is empty.");
      localObject = "";
    }
    paramString = FaceLayer.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text:");
    localStringBuilder.append((String)localObject);
    SLog.b(paramString, localStringBuilder.toString());
    this.jdField_c_of_type_JavaLangString = ((String)localObject);
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    int j = (int)(this.n - 12.0F);
    int i = j;
    if (j < 0)
    {
      QLog.d(FaceLayer.jdField_a_of_type_JavaLangString, 2, "faceItem setText width < 0");
      i = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2)
    {
      j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(1);
      paramString = this.jdField_c_of_type_JavaLangString.substring(0, j);
      localObject = FaceLayer.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("subString : ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramString);
      SLog.b((String)localObject, localStringBuilder.toString());
      this.jdField_c_of_type_JavaLangString = paramString;
      j = this.jdField_c_of_type_JavaLangString.length() - 1;
      paramString = new StringBuilder();
      paramString.append(this.jdField_c_of_type_JavaLangString);
      paramString.append("...");
      this.jdField_c_of_type_JavaLangString = paramString.toString();
      for (this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false); (j > 0) && (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2); this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false))
      {
        paramString = new StringBuilder();
        paramString.append(this.jdField_c_of_type_JavaLangString.substring(0, j));
        paramString.append("...");
        paramString = paramString.toString();
        j -= 1;
        localObject = FaceLayer.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete last char : ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(paramString);
        SLog.b((String)localObject, localStringBuilder.toString());
        this.jdField_c_of_type_JavaLangString = paramString;
      }
      if (j == 0)
      {
        paramString = FaceLayer.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("text size is too large :");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        SLog.e(paramString, ((StringBuilder)localObject).toString());
      }
    }
    paramString = FaceLayer.jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("final text : ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" , original text : ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    SLog.b(paramString, ((StringBuilder)localObject).toString());
    paramString = new Rect();
    this.jdField_a_of_type_AndroidTextStaticLayout.getLineBounds(0, paramString);
    this.jdField_c_of_type_Int = paramString.height();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, this.n, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceAndTextItem
 * JD-Core Version:    0.7.0.1
 */