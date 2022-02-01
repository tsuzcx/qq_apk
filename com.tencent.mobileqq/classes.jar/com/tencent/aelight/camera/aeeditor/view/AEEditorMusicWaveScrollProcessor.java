package com.tencent.aelight.camera.aeeditor.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class AEEditorMusicWaveScrollProcessor
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(2.0F);
  private static final int jdField_b_of_type_Int = ViewUtils.a(4.0F);
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new AEEditorMusicWaveScrollProcessor.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener;
  private AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  
  AEEditorMusicWaveScrollProcessor(AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent paramIMusicScrollProcessorParent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent = paramIMusicScrollProcessorParent;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = 60000;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.f = paramInt3;
    this.g = ViewUtils.a(7.0F);
    this.h = ViewUtils.a(3.0F);
    this.i = ViewUtils.a(2.0F);
    this.j = (this.i / 2);
    this.l = paramInt4;
    this.e = paramInt5;
    int i2 = this.l;
    int i1 = paramInt3 * 2;
    this.q = (i2 - i1);
    int i3 = this.jdField_c_of_type_Int;
    int i4 = this.jdField_d_of_type_Int;
    if (i3 < i4) {
      this.k = i2;
    } else {
      this.k = ((int)(i3 * 1.0F / i4 * this.q) + i1);
    }
    i3 = this.f;
    this.n = i3;
    i2 = this.k;
    this.o = (i2 - i3);
    i3 = this.jdField_d_of_type_Int;
    float f1 = 1000.0F / i3;
    i4 = this.q;
    f1 *= i4;
    this.jdField_c_of_type_Float = 0.0F;
    int i5 = this.jdField_c_of_type_Int;
    if (i5 < i3) {
      this.jdField_b_of_type_Float = (i5 * 1.0F / i3 * i4 - f1);
    } else {
      this.jdField_b_of_type_Float = (i2 - i1 - f1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.r = this.f;
      this.s = ViewUtils.a(9.0F);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent.a(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
    i2 = this.jdField_c_of_type_Int;
    i3 = this.jdField_d_of_type_Int;
    if (i2 < i3) {
      this.m = ((int)((i2 * 1.0F / i3 * this.q + i1) / jdField_b_of_type_Int));
    } else {
      this.m = ((int)(this.k * 1.0F / jdField_b_of_type_Int));
    }
    if (this.m > 10000)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AEEditorMusicWaveScrollProcessor() called with: parent = [");
      localStringBuilder.append(paramIMusicScrollProcessorParent);
      localStringBuilder.append("], audioPath = [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], audioDuration = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], perScreenDuration = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], padding = [");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], isFromLibrary = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], width = [");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], height = [");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("] lineCount=");
      localStringBuilder.append(this.m);
      AEQLog.c("AEEditorMusicWaveScrollProcessor", localStringBuilder.toString());
    }
    AEEditorMusicWaveRandomGenerator.a(paramString1, paramString2, this.m);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampledBitmapFromResource(BaseApplicationImpl.getApplication().getResources(), 2064056507, 16, 118);
    }
  }
  
  int a()
  {
    return this.r;
  }
  
  void a(int paramInt)
  {
    int i1 = this.f;
    if ((paramInt >= i1) && (paramInt <= this.l - i1)) {
      this.r = paramInt;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 * 1.0F / paramInt2;
    paramInt1 = this.k;
    paramInt2 = this.f;
    this.p = ((int)(f1 * (paramInt1 - paramInt2 * 2)) + paramInt2);
    AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent localIMusicScrollProcessorParent = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent;
    if (localIMusicScrollProcessorParent != null) {
      localIMusicScrollProcessorParent.a();
    }
  }
  
  void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    int i1 = BaseApplicationImpl.getContext().getResources().getColor(2063925293);
    Object localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063925293);
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i2 = BaseApplicationImpl.getContext().getResources().getColor(2063925295);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063925295);
    if (localObject != null) {
      i2 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i3 = BaseApplicationImpl.getContext().getResources().getColor(2063925294);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063925294);
    if (localObject != null) {
      i3 = ((ColorStateList)localObject).getDefaultColor();
    }
    if (!paramBoolean) {
      i2 = i1;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
      if ((localObject != null) && (paramCanvas != null))
      {
        ((Paint)localObject).setStyle(Paint.Style.FILL);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(BaseApplicationImpl.getContext().getResources().getColor(2063925291));
        i4 = this.f;
        i5 = this.j;
        f1 = i4 - i5;
        i6 = this.g;
        localObject = new RectF(f1, i6, this.l - i4 + i5, this.e - i6);
        i4 = this.h;
        paramCanvas.drawRoundRect((RectF)localObject, i4, i4, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    int i4 = this.l;
    float f1 = i4;
    int i5 = this.f;
    float f2 = i5;
    float f3 = i5;
    i5 = jdField_b_of_type_Int;
    int i6 = i4 / i5;
    double d1 = this.n;
    Double.isNaN(d1);
    double d2 = i5;
    Double.isNaN(d2);
    i5 = (int)Math.ceil(d1 * 1.0D / d2);
    i4 = Math.max(Math.min((int)this.jdField_a_of_type_Float / jdField_b_of_type_Int, this.m), i5);
    i6 = Math.min(i6 + i4, this.m);
    localObject = new RectF(0.0F, 0.0F, jdField_a_of_type_Int, this.e);
    while (i4 < i6)
    {
      int i7;
      int i8;
      if (!this.jdField_a_of_type_Boolean)
      {
        d1 = AEEditorMusicWaveRandomGenerator.a(i4 - i5);
        i7 = this.e;
        d2 = i7 - this.g * 4;
        Double.isNaN(d2);
        i8 = (int)(d1 * d2);
        ((RectF)localObject).top = ((i7 - i8) / 2);
        ((RectF)localObject).bottom = (((RectF)localObject).top + i8);
      }
      else
      {
        d1 = AEEditorMusicWaveRandomGenerator.a(i4 - i5);
        i7 = this.e;
        d2 = i7;
        Double.isNaN(d2);
        i8 = (int)(d1 * d2);
        ((RectF)localObject).top = ((i7 - i8) / 2);
        ((RectF)localObject).bottom = (((RectF)localObject).top + i8);
      }
      if ((this.jdField_a_of_type_Float + ((RectF)localObject).right >= this.n) && (this.jdField_a_of_type_Float + ((RectF)localObject).left <= this.o))
      {
        if ((((RectF)localObject).left >= f2 + 0.0F) && (((RectF)localObject).left <= f1 - f3))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            if (((RectF)localObject).left < this.p - this.jdField_a_of_type_Float) {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i3);
            } else {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i2);
            }
          }
          else if (((RectF)localObject).left < this.t) {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i3);
          } else {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i2);
          }
        }
        else {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
        }
        i7 = jdField_a_of_type_Int;
        paramCanvas.drawRoundRect((RectF)localObject, i7 / 2, i7 / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      ((RectF)localObject).left += jdField_b_of_type_Int;
      ((RectF)localObject).right += jdField_b_of_type_Int;
      i4 += 1;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
      if ((localObject != null) && (paramCanvas != null))
      {
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(BaseApplicationImpl.getContext().getResources().getColor(2063925292));
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
        i1 = this.f;
        i2 = this.j;
        f1 = i1 - i2;
        i3 = this.g;
        localObject = new RectF(f1, i3, this.l - i1 + i2, this.e - i3);
        i1 = this.h;
        paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.jdField_b_of_type_AndroidGraphicsPaint);
        a();
        localObject = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        i1 = this.r;
        i2 = this.s;
        RectF localRectF = new RectF(i1 - i2 / 2, 0.0F, i1 + i2 / 2, this.e);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, localRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
    }
    paramCanvas.restore();
  }
  
  void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.b();
      }
    }
    else
    {
      GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  void a(AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener = paramIMusicBarMoveListener;
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  int b()
  {
    return this.s;
  }
  
  void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  int c()
  {
    return this.f;
  }
  
  void c(int paramInt)
  {
    this.jdField_a_of_type_Float = (paramInt * 1.0F / this.jdField_d_of_type_Int * this.q);
    AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent localIMusicScrollProcessorParent = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicScrollProcessorParent;
    if (localIMusicScrollProcessorParent != null) {
      localIMusicScrollProcessorParent.a();
    }
  }
  
  int d()
  {
    return this.l;
  }
  
  int e()
  {
    return this.e;
  }
  
  int f()
  {
    int i1 = (int)(this.jdField_a_of_type_Float * 1.0F / this.q * this.jdField_d_of_type_Int);
    int i2 = this.jdField_c_of_type_Int;
    if (i1 > i2) {
      return i2;
    }
    return i1;
  }
  
  int g()
  {
    float f1 = this.jdField_a_of_type_Float * 1.0F / this.q;
    int i1 = this.jdField_d_of_type_Int;
    i1 = (int)(f1 * i1) + i1;
    int i2 = this.jdField_c_of_type_Int;
    if (i1 <= i2) {
      return i1;
    }
    return i2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveScrollProcessor
 * JD-Core Version:    0.7.0.1
 */