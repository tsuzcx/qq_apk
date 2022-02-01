package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpandLocationStickerDrawable
  extends InfoStickerDrawable
{
  private static int e = 30;
  private static int h = 30;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int i = 0;
  private int j = 0;
  private int k = 16;
  private int l = 16;
  
  public ExpandLocationStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("locationString", paramString2);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExpandLocationStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExpandLocationStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int n = e;
    int m = 0;
    int i2 = n + 0;
    n = h;
    int i3 = ((Integer)paramArrayList.get(this.jdField_c_of_type_Int)).intValue();
    n += (this.jdField_c_of_type_JavaLangString.length() - 1) * (this.k - i3) / 2;
    int i1 = ((Integer)paramArrayList.get(this.d)).intValue();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i1);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(i1);
    PerLineFontBitmapsInfo.a(i1, this.jdField_a_of_type_AndroidTextTextPaint);
    paramArrayList = new Rect(n, a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + i2, this.j + n, this.i + i2 + a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    n = n + this.j + this.l;
    while (m < this.jdField_c_of_type_JavaLangString.length())
    {
      paramArrayList = this.jdField_c_of_type_JavaLangString;
      i1 = m + 1;
      paramArrayList = paramArrayList.substring(m, i1);
      paramCanvas.drawText(paramArrayList, n, this.i + i2, this.jdField_a_of_type_AndroidTextTextPaint);
      n = n + (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramArrayList) + i3;
      m = i1;
    }
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
      this.jdField_b_of_type_JavaLangString = paramString.optString("iconpath", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("locationString", "");
    }
    return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString };
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    e = a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    h = e;
    this.l = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.k = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_c_of_type_JavaLangString = InfoStickerUtils.a(this.jdField_c_of_type_JavaLangString);
    Object localObject = this.jdField_c_of_type_JavaLangString;
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.jdField_c_of_type_JavaLangString = ChnToSpell.a(this.jdField_c_of_type_JavaLangString, 1);
      this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.toUpperCase();
    }
    else
    {
      this.jdField_c_of_type_JavaLangString = "YOUR CITY";
    }
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("X", 190L, 630L, 0, this.k, new DecelerateInterpolator());
    this.d = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("T", 190L, 2110L, 0, 255, new DecelerateInterpolator());
    if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
    } else {
      QLog.e("ExpandLocationStickerDrawable", 2, "mIconPath not exist");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    int m;
    int n;
    if (localBitmap != null)
    {
      m = localBitmap.getWidth();
      n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    else
    {
      m = 0;
      n = 0;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, m, n);
    this.i = (-(int)((Paint.FontMetrics)localObject).ascent - (int)((Paint.FontMetrics)localObject).descent + a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (n != 0) {
      this.j = (this.i * m / n);
    }
    this.jdField_b_of_type_Int = (this.i + e * 2);
    float f = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_Int = (this.j + h * 2 + this.l + (int)f + this.k * (this.jdField_c_of_type_JavaLangString.length() - 1) + a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.ExpandLocationStickerDrawable
 * JD-Core Version:    0.7.0.1
 */