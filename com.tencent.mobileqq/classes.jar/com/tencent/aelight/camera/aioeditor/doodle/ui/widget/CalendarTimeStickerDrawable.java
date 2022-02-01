package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CalendarTimeStickerDrawable
  extends InfoStickerDrawable
{
  private static int jdField_c_of_type_Int = 0;
  private static int jdField_d_of_type_Int = 1;
  private static int jdField_e_of_type_Int = 2;
  private static int jdField_h_of_type_Int = 3;
  private static int jdField_i_of_type_Int = 4;
  private static int j = 5;
  private int A;
  private int B = 0;
  private int C;
  private int D = 4;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = 0;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private String jdField_b_of_type_JavaLangString;
  private int[] jdField_b_of_type_ArrayOfInt;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_c_of_type_AndroidGraphicsCanvas;
  private String jdField_c_of_type_JavaLangString;
  private int[] jdField_c_of_type_ArrayOfInt;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_d_of_type_AndroidGraphicsCanvas;
  private String jdField_d_of_type_JavaLangString;
  private Bitmap jdField_e_of_type_AndroidGraphicsBitmap;
  private String jdField_e_of_type_JavaLangString;
  private Bitmap f;
  private Bitmap g;
  private Bitmap jdField_h_of_type_AndroidGraphicsBitmap;
  private Bitmap jdField_i_of_type_AndroidGraphicsBitmap;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = 4;
  private int r = 1;
  private int s = 4;
  private int t = 22;
  private int u = 2;
  private int v = 73;
  private int w = 62;
  private int x = 0;
  private int y = 0;
  private int z;
  
  public CalendarTimeStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
    b();
    c();
  }
  
  private Matrix a(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    int i2 = this.v;
    arrayOfFloat[2] = i2;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = i2;
    int i1 = this.w;
    arrayOfFloat[5] = i1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = i1;
    float f1;
    int i4;
    int i7;
    int i3;
    int i5;
    int i6;
    int i8;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (paramInt >= 0)
    {
      if (paramInt < 50)
      {
        f1 = paramInt / 50.0F;
        i4 = (int)((this.m - i2) * f1) + i2;
        i7 = this.k;
        paramInt = (i7 - i4) / 2;
        i3 = i7 / 2;
        i4 /= 2;
        i5 = i7 / 2;
        i6 = i2 / 2;
        i7 /= 2;
        i2 /= 2;
        i8 = (int)((1.0F - f1) * i1);
        f1 = paramInt;
        f2 = i1 - i8;
        f3 = i3 + i4;
        f4 = i7 + i2;
        f5 = i1;
        f6 = i5 - i6;
        paramInt = arrayOfFloat.length / 2;
        localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
        return localMatrix;
      }
      i1 = paramInt;
      if (paramInt > 100) {
        i1 = 100;
      }
      f1 = (i1 - 50) / 50.0F;
      i5 = this.v;
      double d1 = this.m - i5;
      double d2 = f1;
      Double.isNaN(d2);
      Double.isNaN(d1);
      i2 = (int)(d1 * (1.0D - d2)) + i5;
      i6 = this.k;
      paramInt = (i6 - i2) / 2;
      i1 = i6 / 2;
      i2 /= 2;
      i3 = i6 / 2;
      i4 = i5 / 2;
      i6 /= 2;
      i5 /= 2;
      i7 = (int)(f1 * this.w);
      f1 = i3 - i4;
      f2 = 0;
      f3 = i6 + i5;
      f4 = i1 + i2;
      f5 = i7;
      f6 = paramInt;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
      return localMatrix;
    }
    if (paramInt > -50)
    {
      f1 = (paramInt + 50) / 50.0F;
      paramInt = this.n;
      i4 = paramInt + (int)((i2 - paramInt) * f1);
      i7 = this.k;
      paramInt = (i7 - i4) / 2;
      i3 = i7 / 2;
      i4 /= 2;
      i5 = i7 / 2;
      i6 = i2 / 2;
      i7 /= 2;
      i2 /= 2;
      i8 = (int)(f1 * i1);
      f1 = paramInt;
      f2 = i1 - i8;
      f3 = i3 + i4;
      f4 = i7 + i2;
      f5 = i1;
      f6 = i5 - i6;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
    }
    return localMatrix;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("upFilePath", paramString1);
      localJSONObject.put("downFilePath", paramString2);
      localJSONObject.put("nowHhmm", paramString3);
      localJSONObject.put("lastHhmm", paramString4);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CalendarTimeStickerDrawable", 2, paramString1, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(String paramString, Canvas paramCanvas)
  {
    if (paramString.length() != 4) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    int i4 = (int)((Paint.FontMetrics)localObject1).descent;
    int i5 = (int)((Paint.FontMetrics)localObject1).top;
    int i6 = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i1 = this.w;
    int i3 = 0;
    localObject1 = new Rect(0, 0, 0, i1);
    i1 = this.w;
    int i2 = this.u;
    Rect localRect = new Rect(0, i1 + i2, 0, i1 * 2 + i2);
    Object localObject2 = this.jdField_d_of_type_AndroidGraphicsBitmap;
    if (localObject2 != null)
    {
      i1 = ((Bitmap)localObject2).getWidth();
      i2 = this.jdField_d_of_type_AndroidGraphicsBitmap.getHeight();
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    localObject2 = new Rect(0, 0, i1, i2);
    for (i1 = i3; i1 < 4; i1 = i2)
    {
      i2 = i1 + 1;
      String str = paramString.substring(i1, i2);
      int i7 = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str);
      i3 = this.v;
      i7 = (i3 - i7) / 2;
      int i8 = (this.w + (i4 - i5 - i6)) / 2;
      ((Rect)localObject1).left = (i1 * i3);
      ((Rect)localObject1).right = (((Rect)localObject1).left + this.v);
      Bitmap localBitmap = this.jdField_d_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, (Rect)localObject2, (Rect)localObject1, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      localRect.left = ((Rect)localObject1).left;
      localRect.right = ((Rect)localObject1).right;
      localBitmap = this.jdField_e_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, (Rect)localObject2, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      paramCanvas.drawText(str, i1 * i3 + i7, i8, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_JavaLangString.length() != 4) {
      this.jdField_d_of_type_JavaLangString = "0000";
    }
    if (this.jdField_e_of_type_JavaLangString.length() != 4) {
      this.jdField_e_of_type_JavaLangString = "0000";
    }
    int i1 = 0;
    this.r = 0;
    while (i1 < 4)
    {
      String str = this.jdField_d_of_type_JavaLangString;
      int i2 = i1 + 1;
      if (!str.substring(i1, i2).equals(this.jdField_e_of_type_JavaLangString.substring(i1, i2))) {
        this.r += 1;
      }
      i1 = i2;
    }
    if (this.r == 0) {
      this.r = 1;
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i4 = ((Integer)paramArrayList.get(this.z)).intValue();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
    int i1;
    int i3;
    if (((Integer)paramArrayList.get(this.A)).intValue() >= 1000)
    {
      i1 = j;
    }
    else if (i4 < 255)
    {
      i1 = jdField_c_of_type_Int;
    }
    else
    {
      i3 = 0;
      i1 = 1;
      while (i3 < this.r)
      {
        i2 = i1;
        if (((Integer)paramArrayList.get(this.jdField_b_of_type_ArrayOfInt[i3])).intValue() == 100) {
          i2 = i1 + 1;
        }
        i1 = i2;
        if (i2 == this.r + 1) {
          i1 = j;
        }
        i3 += 1;
      }
    }
    int i2 = 0;
    Rect localRect1;
    int i5;
    while (i2 < 4)
    {
      localRect1 = new Rect(0, 0, 0, 0);
      Rect localRect2 = new Rect(0, 0, 0, 0);
      Rect localRect3 = new Rect(0, 0, 0, this.w);
      i3 = this.w;
      i5 = this.u;
      Rect localRect4 = new Rect(0, i3 + i5, 0, i3 * 2 + i5);
      localRect1.top = (this.s + this.D);
      localRect1.bottom = (localRect1.top + this.w);
      if (i2 > 1) {
        i3 = this.t - this.s;
      } else {
        i3 = 0;
      }
      localRect1.left = ((this.v + this.s) * i2 + i3 + this.D);
      i3 = localRect1.left;
      i5 = this.v;
      localRect1.right = (i3 + i5);
      localRect3.left = (i5 * i2);
      localRect3.right = (localRect3.left + this.v);
      localRect2.top = (this.s + this.w + this.u + this.D);
      localRect2.bottom = (localRect2.top + this.w);
      localRect2.left = localRect1.left;
      localRect2.right = localRect1.right;
      localRect4.left = localRect3.left;
      localRect4.right = localRect3.right;
      i3 = 3 - i2;
      if (i1 == j)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else if (i1 == jdField_c_of_type_Int)
      {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else
      {
        i5 = i1 - 1;
        if (i5 < i3)
        {
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else if (i5 > i3)
        {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else if (i5 == i3)
        {
          i3 = ((Integer)paramArrayList.get(this.jdField_c_of_type_ArrayOfInt[i3])).intValue();
          if (i3 > 0)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i3);
            paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
            this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
          }
        }
      }
      i2 += 1;
    }
    if ((i1 != jdField_c_of_type_Int) && (i1 != j))
    {
      i3 = i1 - 1;
      i2 = 3 - i3;
      i1 = ((Integer)paramArrayList.get(this.jdField_a_of_type_ArrayOfInt[i3])).intValue();
      i3 = ((Integer)paramArrayList.get(this.jdField_b_of_type_ArrayOfInt[i3])).intValue();
      if (i1 > -50)
      {
        paramArrayList = a(i1);
        localRect1 = new Rect(0, 0, 0, this.w);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        double d1 = i1 + 50;
        Double.isNaN(d1);
        i5 = (int)(d1 * 255.0D / 50.0D);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_f_of_type_AndroidGraphicsBitmap, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        if (i2 > 1) {
          i1 = this.t - this.s;
        } else {
          i1 = 0;
        }
        paramArrayList.left = ((this.v + this.s) * i2 + i1 + this.D - this.q);
        paramArrayList.right = (paramArrayList.left + this.m);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i5);
        paramCanvas.drawBitmap(this.g, new Rect(0, 0, this.m, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
      }
      if (i3 < 50)
      {
        paramArrayList = a(i3);
        localRect1 = new Rect(0, 0, 0, this.w);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawBitmap(this.h, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        if (i2 > 1) {
          i1 = this.t - this.s;
        } else {
          i1 = 0;
        }
        paramArrayList.left = ((this.v + this.s) * i2 + i1 + this.D - this.q);
        i1 = paramArrayList.left;
        i4 = this.m;
        paramArrayList.right = (i1 + i4);
        paramCanvas.drawBitmap(this.i, new Rect(0, 0, i4, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (i3 > 50)
      {
        paramArrayList = a(i3);
        i1 = this.w;
        i3 = this.u;
        localRect1 = new Rect(0, i1 + i3, 0, i1 * 2 + i3);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawBitmap(this.h, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.w + this.u + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        if (i2 > 1) {
          i1 = this.t - this.s;
        } else {
          i1 = 0;
        }
        paramArrayList.left = ((this.v + this.s) * i2 + i1 + this.D - this.q);
        i1 = paramArrayList.left;
        i2 = this.m;
        paramArrayList.right = (i1 + i2);
        paramCanvas.drawBitmap(this.i, new Rect(0, 0, i2, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
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
      this.jdField_f_of_type_Int = paramString.optInt("type", 0);
      this.jdField_b_of_type_JavaLangString = paramString.optString("upFilePath", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("downFilePath", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("nowHhmm", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("lastHhmm", "");
    }
    return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString };
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void b()
  {
    a();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator;
    int i2 = 500;
    long l1 = 500;
    this.z = ((AnimStateTypeEvaluator)localObject).a("alpha", 165L, l1, 0, 255, new LinearInterpolator());
    int i1 = this.r;
    this.jdField_a_of_type_ArrayOfInt = new int[i1];
    this.jdField_b_of_type_ArrayOfInt = new int[i1];
    this.jdField_c_of_type_ArrayOfInt = new int[i1];
    i1 = 0;
    while (i1 < this.r)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      AnimStateTypeEvaluator localAnimStateTypeEvaluator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator;
      long l2 = i2;
      localObject[i1] = localAnimStateTypeEvaluator.a("alpha", l2, l1, -40, 0, new LinearInterpolator());
      this.jdField_b_of_type_ArrayOfInt[i1] = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("frontFlip", l2, l1, 0, 100, new LinearInterpolator());
      this.jdField_c_of_type_ArrayOfInt[i1] = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("groundOldFlip", l2, l1, 255, 0, new LinearInterpolator());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("groundOldFlip[i]: ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_ArrayOfInt[i1]);
      QLog.e("CalendarTimeStickerDrawable", 2, ((StringBuilder)localObject).toString());
      i2 += 500;
      i1 += 1;
    }
    this.B = i2;
    this.A = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("alpha", 0L, this.B, 0, 100, new LinearInterpolator());
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(255);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(InfoStickerDrawable.g, 0.0F, 0.0F, 1711276032);
    } else {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
    this.D = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.s = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.t = a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.u = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.v = a(36.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.w = a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.q = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i1 = this.v;
    this.m = (this.q * 2 + i1);
    double d1 = i1;
    Double.isNaN(d1);
    this.n = ((int)(d1 * 2.0D / 3.0D));
    i2 = this.w;
    this.o = i2;
    this.p = 0;
    int i3 = this.s;
    int i4 = this.t;
    int i5 = this.D;
    this.jdField_a_of_type_Int = (i3 * 4 + i4 + i1 * 4 + i5 * 2);
    this.jdField_b_of_type_Int = (i3 * 2 + this.u + i2 * 2 + i5 * 2);
    this.k = this.m;
    this.l = i2;
    this.jdField_f_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_f_of_type_AndroidGraphicsBitmap);
    this.g = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.ARGB_8888);
    this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.g);
    this.h = Bitmap.createBitmap(this.v, this.w, Bitmap.Config.ARGB_8888);
    this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.h);
    this.i = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.ARGB_8888);
    this.jdField_d_of_type_AndroidGraphicsCanvas = new Canvas(this.i);
    if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_d_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
    } else {
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
    }
    if (FileUtils.fileExists(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_c_of_type_JavaLangString);
    } else {
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
    }
    this.x = (this.v * 4);
    this.y = (this.w * 2 + this.u);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.x, this.y, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    a(this.jdField_d_of_type_JavaLangString, (Canvas)localObject);
    this.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.x, this.y, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(this.jdField_c_of_type_AndroidGraphicsBitmap);
    a(this.jdField_e_of_type_JavaLangString, (Canvas)localObject);
    this.C = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("X", 825L, 1000L, 0, 100, new DecelerateInterpolator());
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CalendarTimeStickerDrawable
 * JD-Core Version:    0.7.0.1
 */