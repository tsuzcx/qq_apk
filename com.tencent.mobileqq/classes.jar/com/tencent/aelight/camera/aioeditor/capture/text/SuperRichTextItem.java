package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class SuperRichTextItem
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  TextDrawImplement jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
  private boolean jdField_a_of_type_Boolean = true;
  private float b;
  private int e = 0;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = AIOUtils.b(36.0F, localResources);
    d = AIOUtils.b(6.0F, localResources);
    int i = DisplayUtil.a();
    c = localResources.getDisplayMetrics().widthPixels - TextLayer.a - i * 2;
  }
  
  public SuperRichTextItem(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.e = AIOUtils.b(18.0F, BaseApplicationImpl.getContext().getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement = new TextDrawImplement(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.b(new PerLineBackgoundDrawer(-65536, d));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramString, c, jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(new LineMarginCoverter(this.e));
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
    this.jdField_a_of_type_Float = paramString.a(1, paramString.a()).width();
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
    this.jdField_b_of_type_Float = paramString.a(1, paramString.a()).height();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(new CenterMarginCoverter(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float));
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement.a(paramCanvas, 0, 0);
    if (super.b(0))
    {
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      TextDrawImplement localTextDrawImplement = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawImplement;
      localRectF.set(localTextDrawImplement.a(1, localTextDrawImplement.a()));
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.SuperRichTextItem
 * JD-Core Version:    0.7.0.1
 */