package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class JourneyTextItem
  extends DynamicTextItem
{
  private Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705958);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 16;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private int jdField_c_of_type_Int = 8;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_c_of_type_AndroidTextTextPaint;
  private int jdField_d_of_type_Int = -1;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_e_of_type_Int = 12;
  private RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private int f = 10;
  private int g = 15;
  private int h = 25;
  private int i = 20;
  private int j = 5;
  private int k = 3;
  private int l = -5;
  private int m;
  private int n;
  
  public JourneyTextItem(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap1, paramBitmap1.getNinePatchChunk(), null);
    this.jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap2, paramBitmap2.getNinePatchChunk(), null);
    d();
    this.m = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131705959)));
    this.n = ((int)(this.jdField_b_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131705957)) * 10.0F));
    int i1 = 0;
    if (paramList == null) {
      paramInt = 0;
    } else {
      paramInt = paramList.size();
    }
    while (i1 < paramInt)
    {
      a(i1, (String)paramList.get(i1));
      paramBitmap1 = new StringBuilder();
      paramBitmap1.append("JourneyTextItem index: ");
      paramBitmap1.append(i1);
      paramBitmap1.append(" text: ");
      paramBitmap1.append((String)paramList.get(i1));
      QLog.i("JourneyTextItem", 2, paramBitmap1.toString());
      i1 += 1;
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_c_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_c_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int * 0.8F);
    this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Int);
  }
  
  public float a()
  {
    return (int)Math.max(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.width());
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_e_of_type_AndroidGraphicsRectF.left * f1, this.jdField_e_of_type_AndroidGraphicsRectF.top * f1, this.jdField_e_of_type_AndroidGraphicsRectF.right * f1, this.jdField_e_of_type_AndroidGraphicsRectF.bottom * f1);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 0;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 1;
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
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.jdField_e_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 1;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new JourneyTextItem.3(this, 20);
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
      String str = a(paramInt, new JourneyTextItem.1(this));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setText index: ");
        paramString.append(paramInt);
        paramString.append(" text: ");
        paramString.append(str);
        QLog.i("JourneyTextItem", 2, paramString.toString());
      }
      if (paramInt == 0)
      {
        paramString = TroopFileUtils.b(str);
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = str;
        if (this.jdField_a_of_type_JavaLangString.length() >= 20) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 20);
        }
        paramString = "";
      }
      float f5 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
      float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.width();
      this.jdField_b_of_type_AndroidGraphicsRectF.height();
      float f2 = this.jdField_d_of_type_AndroidGraphicsRectF.width();
      float f3 = this.jdField_d_of_type_AndroidGraphicsRectF.height();
      if (paramInt == 0)
      {
        paramString = paramString.split("\n");
        int i3 = paramString.length;
        int i2 = 0;
        paramInt = 0;
        int i1;
        for (;;)
        {
          i1 = paramInt;
          if (i2 >= i3) {
            break;
          }
          str = paramString[i2];
          if (str.length() >= 20)
          {
            this.jdField_a_of_type_JavaUtilList.add(str.substring(0, 5));
            this.jdField_a_of_type_JavaUtilList.add(str.substring(5, 10));
            this.jdField_a_of_type_JavaUtilList.add(str.substring(10, 15));
            this.jdField_a_of_type_JavaUtilList.add(str.substring(15, 20));
          }
          for (;;)
          {
            paramInt = 5;
            break label561;
            if (str.length() > 15)
            {
              this.jdField_a_of_type_JavaUtilList.add(str.substring(0, 5));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(5, 10));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(10, 15));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(15, str.length()));
            }
            else if (str.length() > 10)
            {
              this.jdField_a_of_type_JavaUtilList.add(str.substring(0, 5));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(5, 10));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(10, str.length()));
            }
            else
            {
              if (str.length() <= 5) {
                break;
              }
              this.jdField_a_of_type_JavaUtilList.add(str.substring(0, 5));
              this.jdField_a_of_type_JavaUtilList.add(str.substring(5, str.length()));
            }
          }
          this.jdField_a_of_type_JavaUtilList.add(str.substring(0, str.length()));
          paramInt = Math.max(paramInt, str.length());
          label561:
          if (this.jdField_a_of_type_JavaUtilList.size() > 4)
          {
            this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, 4);
            i1 = paramInt;
            break;
          }
          i2 += 1;
        }
        paramInt = this.jdField_a_of_type_JavaUtilList.size();
        i2 = this.h;
        i3 = this.g;
        int i4 = this.jdField_b_of_type_Int;
        f5 = i2 * 2 + (paramInt - 1) * i3 + paramInt * i4;
        f4 = this.i * 2 + (i1 - 1) * this.f + i1 * i4;
      }
      else
      {
        this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(str, 0, str.length(), this.jdField_b_of_type_AndroidTextTextPaint, this.n, Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false, null, 0, 2);
        f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(0);
        f3 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
        f1 = f2 + this.j;
      }
      paramInt = this.jdField_e_of_type_Int;
      if (f5 > f1)
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f5, f4);
        paramString = this.jdField_d_of_type_AndroidGraphicsRectF;
        f5 = (f5 - f2) * 0.5F;
        f4 += paramInt;
        paramInt = this.k;
        paramString.set(f5, paramInt + f4, f2 + f5, f4 + f3 + paramInt);
      }
      else
      {
        float f6 = (f1 - f5) * 0.5F;
        this.jdField_a_of_type_AndroidGraphicsRectF.set(f6, 0.0F, f5 + f6, f4);
        paramString = this.jdField_d_of_type_AndroidGraphicsRectF;
        f5 = (f1 - f2) * 0.5F;
        f4 += paramInt;
        paramInt = this.k;
        paramString.set(f5, paramInt + f4, f2 + f5, f4 + f3 + paramInt);
      }
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.h * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.top + this.i * 0.7F, this.jdField_a_of_type_AndroidGraphicsRectF.right - this.h * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.i * 0.7F);
      this.jdField_e_of_type_AndroidGraphicsRectF.set(this.jdField_d_of_type_AndroidGraphicsRectF.left - this.h * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.top - this.i * 0.2F, this.jdField_d_of_type_AndroidGraphicsRectF.right + this.h * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.bottom + this.i * 0.2F);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.bottom + this.l, this.jdField_e_of_type_AndroidGraphicsRectF.left + f1, this.jdField_e_of_type_AndroidGraphicsRectF.bottom + f3 + this.l);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (b(0)) {
      paramCanvas.drawRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    if (b(1)) {
      paramCanvas.drawRoundRect(this.jdField_e_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    this.jdField_a_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_b_of_type_AndroidGraphicsRectF);
    double d1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    double d2 = this.h;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int i3 = (int)(d1 + d2 * 1.3D);
    d1 = this.i;
    d2 = this.m;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int i1 = (int)(d1 + d2 * 0.8D);
    int i2 = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i2 >= 0)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
      int i6 = ((String)localObject).length();
      int i5 = 0;
      int i4 = i1;
      for (i1 = i5; i1 < i6; i1 = i5)
      {
        i5 = i1 + 1;
        paramCanvas.drawText(((String)localObject).substring(i1, i5), i3, i4, this.jdField_a_of_type_AndroidTextTextPaint);
        i4 += this.m + this.f;
      }
      i1 = this.m;
      i3 += this.g + i1;
      d1 = this.i;
      d2 = i1;
      Double.isNaN(d2);
      Double.isNaN(d1);
      i1 = (int)(d1 + d2 * 0.8D);
      i2 -= 1;
    }
    paramCanvas.translate(this.jdField_d_of_type_AndroidGraphicsRectF.left, this.jdField_d_of_type_AndroidGraphicsRectF.top);
    Object localObject = this.jdField_a_of_type_AndroidTextStaticLayout;
    if (localObject != null) {
      ((StaticLayout)localObject).draw(paramCanvas);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.top;
  }
  
  public boolean b()
  {
    Object localObject = new JourneyTextItem.2(this);
    boolean bool = false;
    localObject = a(0, (DynamicTextItem.PreHandleTextHandler)localObject);
    String str = b(1);
    if (((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str))) || (super.b())) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.JourneyTextItem
 * JD-Core Version:    0.7.0.1
 */