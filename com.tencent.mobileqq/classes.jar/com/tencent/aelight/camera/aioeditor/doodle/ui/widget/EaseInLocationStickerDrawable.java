package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class EaseInLocationStickerDrawable
  extends InfoStickerDrawable
{
  private int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  TextPaint jdField_a_of_type_AndroidTextTextPaint = null;
  private int jdField_b_of_type_Int = 0;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface = null;
  private String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2064515391);
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "DEC 06 15:39";
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = null;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = null;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  
  public EaseInLocationStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  private int a(int paramInt)
  {
    return (this.jdField_b_of_type_Int - paramInt) / 2;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("icon_path", paramString3);
      localJSONObject.put("font_path", paramString4);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EaseInLocationStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EaseInLocationStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int n = a(this.jdField_a_of_type_JavaUtilArrayList, this.j, 255);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(n);
    int i1 = a((int)this.jdField_a_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, 0.0F, i1 + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(11.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    PerLineFontBitmapsInfo.a(n, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    i1 = a(this.jdField_a_of_type_JavaUtilArrayList, this.k, 255);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(i1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(i1, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, a(this.jdField_d_of_type_Int), n + f1, this.jdField_a_of_type_AndroidTextTextPaint);
    int i2 = a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i1 = a(this.jdField_a_of_type_JavaUtilArrayList, this.m, 255);
    n = n + i2 + a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i1);
    PerLineFontBitmapsInfo.a(i1, this.jdField_a_of_type_AndroidTextTextPaint);
    f1 = a(this.jdField_a_of_type_Int);
    float f2 = n;
    paramCanvas.drawLine(f1, f2, a(this.jdField_a_of_type_Int) + this.jdField_a_of_type_Int, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    i1 = a(this.jdField_a_of_type_JavaUtilArrayList, this.l, 255);
    i2 = a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(i1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(i1, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, a(this.h), n + i2 + f1, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString != null)
    {
      this.f = paramString.optInt("type", 0);
      this.jdField_b_of_type_JavaLangString = paramString.optString("first_line", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("second_line", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("font_path", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("icon_path", "");
    }
    return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString };
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    if (new File(this.jdField_e_of_type_JavaLangString).exists()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_e_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840411);
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Int = a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    String str = this.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_Int = ((int)localTextPaint.measureText(str, 0, str.length()));
    this.jdField_e_of_type_Int = a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    str = this.jdField_c_of_type_JavaLangString;
    this.h = ((int)localTextPaint.measureText(str, 0, str.length()));
    this.i = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(11.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_b_of_type_Int = Math.max(Math.max(this.jdField_a_of_type_Int, this.jdField_d_of_type_Int), this.h);
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_AndroidGraphicsRectF.height() + this.jdField_e_of_type_Int + this.i + a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
    this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.jdField_d_of_type_JavaLangString).exists()) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_d_of_type_JavaLangString);
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("EaseInLocationStickerDrawable", 1, "createFromFile fail, ", localRuntimeException);
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
      }
    } else {
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
    }
    this.j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("iconAlpha", 20L, 230L, 0, 255, new LinearInterpolator());
    this.k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("firstLineAlpha", 120L, 230L, 0, 255, new LinearInterpolator());
    this.m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("lineAlpha", 220L, 230L, 0, 255, new LinearInterpolator());
    this.l = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("secondLineAlpha", 330L, 230L, 0, 255, new LinearInterpolator());
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.EaseInLocationStickerDrawable
 * JD-Core Version:    0.7.0.1
 */