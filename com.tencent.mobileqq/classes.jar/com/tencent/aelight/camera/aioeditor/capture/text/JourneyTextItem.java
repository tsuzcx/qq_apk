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
  private RectF A = new RectF();
  private RectF B = new RectF();
  private List<String> C = new ArrayList();
  private String D = HardCodeUtil.a(2131903838);
  private int E;
  private Resources F = BaseApplicationImpl.getContext().getResources();
  private InputFilter G = null;
  private int a = 16;
  private int b = 8;
  private int c = -1;
  private int d = 12;
  private int e = 10;
  private int f = 15;
  private int g = 25;
  private int h = 20;
  private int i = 5;
  private int j = 3;
  private int p = -5;
  private int q;
  private TextPaint r;
  private TextPaint s;
  private TextPaint t;
  private NinePatch u;
  private NinePatch v;
  private RectF w = new RectF();
  private RectF x = new RectF();
  private RectF y = new RectF();
  private StaticLayout z;
  
  public JourneyTextItem(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.u = new NinePatch(paramBitmap1, paramBitmap1.getNinePatchChunk(), null);
    this.v = new NinePatch(paramBitmap2, paramBitmap2.getNinePatchChunk(), null);
    u();
    this.q = ((int)this.r.measureText(HardCodeUtil.a(2131903839)));
    this.E = ((int)(this.s.measureText(HardCodeUtil.a(2131903837)) * 10.0F));
    int k = 0;
    if (paramList == null) {
      paramInt = 0;
    } else {
      paramInt = paramList.size();
    }
    while (k < paramInt)
    {
      a(k, (String)paramList.get(k));
      paramBitmap1 = new StringBuilder();
      paramBitmap1.append("JourneyTextItem index: ");
      paramBitmap1.append(k);
      paramBitmap1.append(" text: ");
      paramBitmap1.append((String)paramList.get(k));
      QLog.i("JourneyTextItem", 2, paramBitmap1.toString());
      k += 1;
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
  
  private void u()
  {
    this.r = new TextPaint();
    this.r.setTypeface(Typeface.DEFAULT);
    this.r.setTextAlign(Paint.Align.CENTER);
    this.r.setAntiAlias(true);
    this.r.setStyle(Paint.Style.FILL_AND_STROKE);
    this.r.setTextSize(this.a);
    this.r.setColor(this.c);
    this.t = new TextPaint();
    this.t.setTypeface(Typeface.DEFAULT);
    this.t.setAntiAlias(true);
    this.t.setTextSize(this.a * 0.8F);
    this.t.setColor(this.c);
    this.s = new TextPaint();
    this.s.setAntiAlias(true);
    this.s.setColor(this.c);
    this.s.setTextSize(this.b);
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / c();
    RectF localRectF1 = new RectF(this.w.left * f1, this.w.top * f1, this.w.right * f1, this.w.bottom * f1);
    RectF localRectF2 = new RectF(this.B.left * f1, this.B.top * f1, this.B.right * f1, this.B.bottom * f1);
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
    paramMotionEvent = new PointF((paramFloat1 - c()) / 2.0F, (paramFloat2 - d()) / 2.0F);
    if (a(f1, f2, this.w, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.B, paramMotionEvent)) {
      return 1;
    }
    return -1;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= b()) {
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
        paramString = TroopFileUtils.c(str);
        this.C.clear();
      }
      else
      {
        this.D = str;
        if (this.D.length() >= 20) {
          this.D = this.D.substring(0, 20);
        }
        paramString = "";
      }
      float f5 = this.w.width();
      float f4 = this.w.height();
      float f1 = this.x.width();
      this.x.height();
      float f2 = this.A.width();
      float f3 = this.A.height();
      if (paramInt == 0)
      {
        paramString = paramString.split("\n");
        int n = paramString.length;
        int m = 0;
        paramInt = 0;
        int k;
        for (;;)
        {
          k = paramInt;
          if (m >= n) {
            break;
          }
          str = paramString[m];
          if (str.length() >= 20)
          {
            this.C.add(str.substring(0, 5));
            this.C.add(str.substring(5, 10));
            this.C.add(str.substring(10, 15));
            this.C.add(str.substring(15, 20));
          }
          for (;;)
          {
            paramInt = 5;
            break label561;
            if (str.length() > 15)
            {
              this.C.add(str.substring(0, 5));
              this.C.add(str.substring(5, 10));
              this.C.add(str.substring(10, 15));
              this.C.add(str.substring(15, str.length()));
            }
            else if (str.length() > 10)
            {
              this.C.add(str.substring(0, 5));
              this.C.add(str.substring(5, 10));
              this.C.add(str.substring(10, str.length()));
            }
            else
            {
              if (str.length() <= 5) {
                break;
              }
              this.C.add(str.substring(0, 5));
              this.C.add(str.substring(5, str.length()));
            }
          }
          this.C.add(str.substring(0, str.length()));
          paramInt = Math.max(paramInt, str.length());
          label561:
          if (this.C.size() > 4)
          {
            this.C = this.C.subList(0, 4);
            k = paramInt;
            break;
          }
          m += 1;
        }
        paramInt = this.C.size();
        m = this.g;
        n = this.f;
        int i1 = this.a;
        f5 = m * 2 + (paramInt - 1) * n + paramInt * i1;
        f4 = this.h * 2 + (k - 1) * this.e + k * i1;
      }
      else
      {
        this.z = StaticLayoutWithMaxLines.a(str, 0, str.length(), this.s, this.E, Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false, null, 0, 2);
        f2 = this.z.getLineWidth(0);
        f3 = this.z.getHeight();
        f1 = f2 + this.i;
      }
      paramInt = this.d;
      if (f5 > f1)
      {
        this.w.set(0.0F, 0.0F, f5, f4);
        paramString = this.A;
        f5 = (f5 - f2) * 0.5F;
        f4 += paramInt;
        paramInt = this.j;
        paramString.set(f5, paramInt + f4, f2 + f5, f4 + f3 + paramInt);
      }
      else
      {
        float f6 = (f1 - f5) * 0.5F;
        this.w.set(f6, 0.0F, f5 + f6, f4);
        paramString = this.A;
        f5 = (f1 - f2) * 0.5F;
        f4 += paramInt;
        paramInt = this.j;
        paramString.set(f5, paramInt + f4, f2 + f5, f4 + f3 + paramInt);
      }
      this.y.set(this.w.left + this.g * 0.8F, this.w.top + this.h * 0.7F, this.w.right - this.g * 0.8F, this.w.bottom - this.h * 0.7F);
      this.B.set(this.A.left - this.g * 0.3F, this.A.top - this.h * 0.2F, this.A.right + this.g * 0.3F, this.A.bottom + this.h * 0.2F);
      this.x.set(this.B.left, this.B.bottom + this.p, this.B.left + f1, this.B.bottom + f3 + this.p);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (f(0)) {
      paramCanvas.drawRoundRect(this.y, 6.0F, 6.0F, s());
    }
    if (f(1)) {
      paramCanvas.drawRoundRect(this.B, 6.0F, 6.0F, s());
    }
    this.u.draw(paramCanvas, this.w);
    this.v.draw(paramCanvas, this.x);
    double d1 = this.w.left;
    double d2 = this.g;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int n = (int)(d1 + d2 * 1.3D);
    d1 = this.h;
    d2 = this.q;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int k = (int)(d1 + d2 * 0.8D);
    int m = this.C.size() - 1;
    while (m >= 0)
    {
      localObject = (String)this.C.get(m);
      int i3 = ((String)localObject).length();
      int i2 = 0;
      int i1 = k;
      for (k = i2; k < i3; k = i2)
      {
        i2 = k + 1;
        paramCanvas.drawText(((String)localObject).substring(k, i2), n, i1, this.r);
        i1 += this.q + this.e;
      }
      k = this.q;
      n += this.f + k;
      d1 = this.h;
      d2 = k;
      Double.isNaN(d2);
      Double.isNaN(d1);
      k = (int)(d1 + d2 * 0.8D);
      m -= 1;
    }
    paramCanvas.translate(this.A.left, this.A.top);
    Object localObject = this.z;
    if (localObject != null) {
      ((StaticLayout)localObject).draw(paramCanvas);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public float c()
  {
    return (int)Math.max(this.w.width(), this.x.width());
  }
  
  public float d()
  {
    return this.x.bottom - this.w.top;
  }
  
  public boolean e()
  {
    Object localObject = new JourneyTextItem.2(this);
    boolean bool = false;
    localObject = a(0, (DynamicTextItem.PreHandleTextHandler)localObject);
    String str = c(1);
    if (((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str))) || (super.e())) {
      bool = true;
    }
    return bool;
  }
  
  public InputFilter f()
  {
    if (this.G == null) {
      this.G = new JourneyTextItem.3(this, 20);
    }
    return this.G;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.JourneyTextItem
 * JD-Core Version:    0.7.0.1
 */