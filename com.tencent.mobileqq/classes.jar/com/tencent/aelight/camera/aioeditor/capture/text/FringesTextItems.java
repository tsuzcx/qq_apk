package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.List;

public class FringesTextItems
  extends DynamicTextItem
{
  public static final float a;
  private static final String jdField_a_of_type_JavaLangString = "FringesTextItems";
  public static final float b;
  public static final float c;
  public static final float d;
  public static final float e;
  public static final float f;
  public static final float g;
  public static final float h;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  DrawFilter jdField_a_of_type_AndroidGraphicsDrawFilter = new PaintFlagsDrawFilter(0, 3);
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private Bitmap b;
  float i;
  float j;
  float k;
  float l;
  private float m;
  private float n;
  
  static
  {
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    jdField_a_of_type_Float = 2.0F * f1;
    jdField_b_of_type_Float = 13.0F * f1;
    c = 1.0F * f1;
    float f2 = 5.0F * f1;
    d = f2;
    e = 15.0F * f1;
    f = f2;
    g = f2;
    h = f1 * 6.0F;
  }
  
  public FringesTextItems(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(-0.25F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-6741743);
    boolean bool;
    try
    {
      Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE }).invoke(this.jdField_a_of_type_AndroidTextTextPaint, new Object[] { Float.valueOf(0.4F) });
      bool = true;
    }
    catch (Exception paramTypeface)
    {
      paramTypeface.printStackTrace();
      bool = false;
    }
    paramTypeface = TextLayer.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLetterSpacing");
    localStringBuilder.append(bool);
    QLog.i(paramTypeface, 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap2;
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.m - this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() + e - (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + g));
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(jdField_b_of_type_Float - (this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() - this.i) * 0.5F, e + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.save();
    float f1 = jdField_a_of_type_Float;
    paramCanvas.translate(-f1, -f1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-65536);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    f1 = jdField_a_of_type_Float;
    paramCanvas.translate(f1, f1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16776961);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.b(0))
    {
      f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f3 = this.i;
      localRectF.left = (f2 - f3 / 2.0F);
      float f4 = jdField_a_of_type_Float;
      localRectF.top = (-f4);
      localRectF.right = (f2 + f3 / 2.0F);
      localRectF.bottom = (f1 + f4);
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.n - c);
    paramCanvas.drawLine(0.0F, 0.0F, this.m, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.m - this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.k, this.l);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    if (this.k > 0.0F) {
      f1 = jdField_b_of_type_Float;
    } else {
      f1 = jdField_b_of_type_Float + (this.m - this.j) * 0.5F;
    }
    paramCanvas.translate(f1 - (this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() - this.i) * 0.5F, f + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.save();
    float f1 = jdField_a_of_type_Float;
    paramCanvas.translate(-f1, -f1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-65536);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    f1 = jdField_a_of_type_Float;
    paramCanvas.translate(f1, f1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16776961);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.b(0))
    {
      f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f3 = this.i;
      localRectF.left = (f2 - f3 / 2.0F);
      float f4 = jdField_a_of_type_Float;
      localRectF.top = (-f4);
      localRectF.right = (f2 + f3 / 2.0F);
      localRectF.bottom = (f1 + f4);
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.n - c);
    paramCanvas.drawLine(0.0F, 0.0F, this.m, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public float a()
  {
    return this.m;
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
    paramInt = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131705048));
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.2F, 0.0F, false);
    float f1 = 0.0F;
    this.i = 0.0F;
    int i1 = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      this.i = Math.max(this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt), this.i);
      paramInt += 1;
    }
    this.j = (this.i + jdField_a_of_type_Float * 2.0F + jdField_b_of_type_Float * 2.0F);
    if (i1 == 1)
    {
      this.m = this.j;
      this.n = (this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + jdField_a_of_type_Float * 2.0F + c + d + e + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
      return;
    }
    paramString = this.jdField_a_of_type_AndroidTextStaticLayout;
    paramInt = i1 - 2;
    float f2 = (paramString.getLineWidth(paramInt) * 0.5F + h + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) * 2.0F;
    this.m = Math.max(this.j, f2);
    this.n = (this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + jdField_a_of_type_Float * 2.0F + c + d + f + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    float f3 = this.j;
    if (f2 <= f3) {
      f1 = (f3 - f2) * 0.5F;
    }
    this.k = f1;
    this.l = (this.jdField_a_of_type_AndroidTextStaticLayout.getLineBottom(paramInt) - this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() + f);
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsDrawFilter);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      c(paramCanvas);
      return;
    }
    d(paramCanvas);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.n;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FringesTextItems
 * JD-Core Version:    0.7.0.1
 */