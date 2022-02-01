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
  private String a;
  private Bitmap b;
  private int c;
  private int d;
  private int e;
  private int n;
  private int o;
  private Rect p;
  private Rect q = new Rect();
  private Paint r;
  
  public CityStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
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
    if (this.b != null)
    {
      int i = 225;
      int m = this.o;
      int j;
      int k;
      if (paramArrayList != null)
      {
        try
        {
          j = ((Integer)paramArrayList.get(this.c)).intValue();
          try
          {
            k = ((Integer)paramArrayList.get(this.d)).intValue();
            i = k;
            int i1 = ((Integer)paramArrayList.get(this.e)).intValue();
            i = k;
            k = i1;
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
      this.r.setAlpha(i);
      paramCanvas.save();
      this.q.set(this.p);
      this.q.offset(0, j);
      paramCanvas.clipRect(0, 0, this.n, k);
      paramCanvas.drawBitmap(this.b, null, this.q, this.r);
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
      this.j = paramString.optInt("type", 0);
      this.a = paramString.optString("city_bitmap_path");
    }
    return new String[] { this.a };
  }
  
  protected void b()
  {
    String str = this.a;
    if ((str != null) && (new File(str).exists()))
    {
      this.b = BitmapFactory.decodeFile(this.a);
      this.r = new Paint(1);
      float f1 = this.b.getWidth() / 3.0F;
      float f2 = this.b.getHeight() / 3.0F;
      int i = a(f1, this.h.getResources());
      int j = a(f2, this.h.getResources());
      this.n = i;
      this.o = j;
      this.p = new Rect(0, 0, i, j);
      i = a(15.0F, this.h.getResources());
      this.c = this.f.a("offsetY", 0L, 500L, -i, 0, new LinearInterpolator());
      this.d = this.f.a("alpha", 0L, 500L, 0, 255, new LinearInterpolator());
      this.e = this.f.a("height", 0L, 500L, 0, this.o, new LinearInterpolator());
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.o;
  }
  
  public int getIntrinsicWidth()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CityStickerDrawable
 * JD-Core Version:    0.7.0.1
 */