package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CityStickerDrawable
  extends InfoStickerDrawable
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  public CityStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("city_bitmap_path", paramString);
      paramString = localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CityStickerDrawable", 2, paramString, new Object[0]);
      }
      paramString = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CityStickerDrawable", 2, paramString);
    }
    return paramString;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      int i = 225;
      int m = this.e;
      int j;
      int k;
      if (paramArrayList != null)
      {
        try
        {
          j = ((Integer)paramArrayList.get(this.jdField_a_of_type_Int)).intValue();
          try
          {
            k = ((Integer)paramArrayList.get(this.jdField_b_of_type_Int)).intValue();
            i = k;
            int n = ((Integer)paramArrayList.get(this.c)).intValue();
            i = k;
            k = n;
          }
          catch (RuntimeException paramArrayList) {}
          QLog.e("CityStickerDrawable", 1, paramArrayList, new Object[0]);
        }
        catch (RuntimeException paramArrayList)
        {
          j = 0;
        }
        k = m;
      }
      else
      {
        j = 0;
        k = m;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
      paramCanvas.save();
      this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsRect.offset(0, j);
      paramCanvas.clipRect(0, 0, this.d, k);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
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
      QLog.e("CityStickerDrawable", 1, paramString, new Object[0]);
      paramString = null;
    }
    if (paramString != null)
    {
      this.f = paramString.optInt("type", 0);
      this.jdField_b_of_type_JavaLangString = paramString.optString("city_bitmap_path");
    }
    return new String[] { this.jdField_b_of_type_JavaLangString };
  }
  
  protected void b()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if ((str != null) && (new File(str).exists()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 3.0F;
      float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 3.0F;
      int i = a(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.d = i;
      this.e = j;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i, j);
      i = a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("offsetY", 0L, 500L, -i, 0, new LinearInterpolator());
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("alpha", 0L, 500L, 0, 255, new LinearInterpolator());
      this.c = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("height", 0L, 500L, 0, this.e, new LinearInterpolator());
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CityStickerDrawable
 * JD-Core Version:    0.7.0.1
 */