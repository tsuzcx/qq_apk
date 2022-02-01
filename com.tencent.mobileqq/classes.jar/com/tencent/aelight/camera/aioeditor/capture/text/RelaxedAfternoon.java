package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class RelaxedAfternoon
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  TextDrawImplement jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  TextDrawImplement jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
  private String jdField_b_of_type_JavaLangString;
  TextDrawImplement jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
  private String jdField_c_of_type_JavaLangString;
  int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = AIOUtils.b(18.0F, localResources);
    d = AIOUtils.b(6.0F, localResources);
    int n = DisplayUtil.a();
    jdField_c_of_type_Int = localResources.getDisplayMetrics().widthPixels - TextLayer.a - n * 2;
  }
  
  public RelaxedAfternoon(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    int n = 0;
    this.f = 0;
    this.jdField_a_of_type_JavaLangString = "jenny";
    this.jdField_b_of_type_JavaLangString = "05/09";
    this.jdField_c_of_type_JavaLangString = "by";
    this.g = 0;
    this.h = 0;
    this.k = 0;
    this.e = 0;
    this.jdField_a_of_type_AndroidTextInputFilter = null;
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSkewX(-0.15F);
    this.k = AIOUtils.b(41.0F, BaseApplicationImpl.getContext().getResources());
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.k);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.g = AIOUtils.b(34.0F, BaseApplicationImpl.getContext().getResources());
    this.h = AIOUtils.b(45.0F, BaseApplicationImpl.getContext().getResources());
    this.l = AIOUtils.b(4.0F, BaseApplicationImpl.getContext().getResources());
    this.m = AIOUtils.b(3.0F, BaseApplicationImpl.getContext().getResources());
    this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement = new TextDrawImplement(0);
    this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(new PathDrawBackground(-1, this.l, this.m));
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(-0.15F);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.j = AIOUtils.b(19.0F, BaseApplicationImpl.getContext().getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    TextPaint localTextPaint = new TextPaint();
    if (paramTypeface != null) {
      localTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_b_of_type_JavaLangString = InfoStickerUtils.a();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSkewX(-0.15F);
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.i = AIOUtils.b(23.0F, BaseApplicationImpl.getContext().getResources());
    localTextPaint.setTextSize(this.i);
    localTextPaint.setColor(-1);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement = new TextDrawImplement(0);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(new PathDrawBackground(-16777216, this.l, this.m));
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(this.jdField_b_of_type_JavaLangString, jdField_c_of_type_Int, this.i, localTextPaint);
    if (paramList == null) {
      paramInt = 0;
    } else {
      paramInt = paramList.size();
    }
    while (n < paramInt)
    {
      a(n, (String)paramList.get(n));
      n += 1;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if (paramRectF != null)
    {
      if (paramPointF == null) {
        return false;
      }
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
      if ((paramFloat1 > paramRectF.left) && (paramFloat1 < paramRectF.right) && (paramFloat2 > paramRectF.top) && (paramFloat2 < paramRectF.bottom)) {
        return true;
      }
    }
    return false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left * f1, this.jdField_b_of_type_AndroidGraphicsRectF.top * f1, this.jdField_b_of_type_AndroidGraphicsRectF.right * f1, this.jdField_b_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom * f1);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 1;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 0;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramTextItem != null) {
      return paramGestureHelper.a(paramTextItem, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - a()) / 2.0F, (paramFloat2 - b()) / 2.0F);
    if (a(f1, f2, this.jdField_b_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 1;
    }
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new RelaxedAfternoon.1(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= a()) {
        return;
      }
      super.a(paramInt, paramString);
      Object localObject = super.b(paramInt);
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "　　";
      }
      this.f = AIOUtils.b(18.0F, BaseApplicationImpl.getContext().getResources());
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement = new TextDrawImplement(0);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(new PathDrawBackground(-16777216, this.l, this.m));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramString, jdField_c_of_type_Int, this.k, this.jdField_b_of_type_AndroidTextTextPaint);
        this.jdField_a_of_type_Float = Math.max(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(), this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a());
        this.jdField_a_of_type_Float = Math.max(this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(), this.jdField_a_of_type_Float);
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b() + this.g + this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b() + this.h + this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b());
        return;
      }
      if (paramString.length() > 18) {
        this.jdField_a_of_type_JavaLangString = paramString.substring(0, 18);
      } else {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      paramString = this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      paramString.a(((StringBuilder)localObject).toString(), jdField_c_of_type_Int, this.j, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.e = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    this.e = ((int)(this.e + this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b()));
    this.e += this.g;
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    this.e = ((int)(this.e + this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b()));
    this.e += this.h;
    this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    RectF localRectF;
    if (super.b(1))
    {
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      TextDrawImplement localTextDrawImplement = this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
      localRectF.set(localTextDrawImplement.a(2, localTextDrawImplement.a()));
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.top += this.e;
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.bottom += this.e;
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    this.e = ((int)(this.e + this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b()));
    if (super.b(0))
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.top = 0.0F;
      localRectF.right = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a();
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b();
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RelaxedAfternoon
 * JD-Core Version:    0.7.0.1
 */