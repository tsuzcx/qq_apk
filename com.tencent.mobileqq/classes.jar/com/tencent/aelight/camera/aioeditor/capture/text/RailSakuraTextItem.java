package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class RailSakuraTextItem
  extends DynamicTextItem
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final float d = ScreenUtil.dip2px(22.0F);
  public static final float e = ScreenUtil.dip2px(3.0F);
  private static int j = 0;
  boolean f = false;
  private RectF g = new RectF();
  private RectF h = new RectF();
  private Rect i = new Rect();
  private TextPaint p = new TextPaint();
  private float q;
  private float r;
  private String s;
  private int[] t;
  private int u;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    a = AIOUtils.b(27.0F, localResources);
    c = AIOUtils.b(6.0F, localResources);
    int k = DisplayUtil.a();
    b = localResources.getDisplayMetrics().widthPixels - TextLayer.b - k * 2;
  }
  
  public RailSakuraTextItem(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.p.setTypeface(Typeface.DEFAULT);
    this.p.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.p.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.p.setTypeface(paramTypeface);
    }
    this.p.setAntiAlias(true);
    this.p.setStyle(Paint.Style.FILL_AND_STROKE);
    this.p.setTextSize(a);
    this.p.setColor(-1);
    this.p.setTextAlign(Paint.Align.LEFT);
    paramTypeface = this.p.getFontMetrics();
    j = (int)Math.abs(paramTypeface.bottom - paramTypeface.top);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private static final boolean a(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static final boolean b(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static final boolean c(char paramChar)
  {
    return (paramChar >= '一') && (paramChar <= 40891);
  }
  
  private static final boolean d(char paramChar)
  {
    return paramChar == '\n';
  }
  
  private void u()
  {
    this.t = new int[this.s.length()];
    char[] arrayOfChar = new char[this.s.length()];
    String str = this.s;
    int k = str.length();
    int i2 = 0;
    str.getChars(0, k, arrayOfChar, 0);
    int n = 0;
    for (int i1 = -1; n < this.s.length(); i1 = k)
    {
      char c2 = arrayOfChar[n];
      if (n <= 0)
      {
        k = -1;
      }
      else
      {
        m = n - 1;
        for (;;)
        {
          k = i1;
          if (m < 0) {
            break label119;
          }
          if (arrayOfChar[m] != '\n') {
            break;
          }
          m -= 1;
        }
        k = m;
      }
      label119:
      char c1;
      if (k == -1) {
        c1 = '\000';
      } else {
        c1 = arrayOfChar[k];
      }
      if (c(c2))
      {
        this.t[n] = 2;
      }
      else if (a(c2))
      {
        this.t[n] = 3;
        if ((c1 != 0) && (a(c1))) {
          this.t[k] = -3;
        }
      }
      else if (b(c2))
      {
        this.t[n] = 4;
      }
      else if (d(c2))
      {
        this.t[n] = 5;
      }
      else
      {
        this.t[n] = 1;
        if (c1 != 0) {
          if (c(c1)) {
            this.t[k] = -2;
          } else if (a(c1)) {
            this.t[k] = -3;
          } else if (b(c1)) {
            this.t[k] = -4;
          } else {
            this.t[k] = -1;
          }
        }
      }
      n += 1;
    }
    this.u = 0;
    arrayOfChar = this.s.toCharArray();
    int m = arrayOfChar.length;
    k = i2;
    while ((k < m) && (d(arrayOfChar[k])))
    {
      this.u += 1;
      k += 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.c(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.s = paramString;
    this.n = new StaticLayout(paramString, this.p, b, Layout.Alignment.ALIGN_NORMAL, 1.0F, d, false);
    float f1 = 0.0F;
    paramInt = 0;
    while (paramInt < this.n.getLineCount())
    {
      f1 = Math.max(f1, this.n.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.q = f1;
    this.r = this.n.getHeight();
    u();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      this.p.setTextAlign(Paint.Align.LEFT);
      float f3 = super.a(this.n);
      float f4 = this.n.getHeight();
      int n = 0;
      int i1;
      Object localObject;
      for (int k = 0; n < this.n.getLineCount(); k = i1)
      {
        this.n.getLineBounds(n, this.i);
        i1 = this.n.getLineVisibleEnd(n);
        localObject = this.i;
        ((Rect)localObject).bottom = (((Rect)localObject).top + j);
        localObject = new float[i1 - k];
        this.p.getTextWidths(this.s, k, i1, (float[])localObject);
        int m = k;
        float f1 = 0.0F;
        while (m < i1)
        {
          if (String.valueOf(this.s.charAt(m)).equals("\n"))
          {
            this.f = true;
          }
          else
          {
            if ((m != this.u) && (!this.f)) {}
            for (;;)
            {
              break;
              if (this.f)
              {
                this.f = false;
                int[] arrayOfInt = this.t;
                if ((arrayOfInt[m] != -1) && (arrayOfInt[m] != 1) && (arrayOfInt[m] != -3) && (arrayOfInt[m] != 3)) {
                  paramCanvas.drawLine(this.i.left + f1, this.i.bottom - e, this.i.left + f1, this.i.bottom, this.p);
                }
              }
              else
              {
                paramCanvas.drawLine(this.i.left + f1, this.i.bottom - e, this.i.left + f1, this.i.bottom, this.p);
              }
            }
            int i2 = m;
            float f2 = f1 + localObject[(i2 - k)];
            f1 = f2;
            if (this.t[i2] > 0)
            {
              paramCanvas.drawLine(this.i.left + f2, this.i.bottom - e, this.i.left + f2, this.i.bottom, this.p);
              f1 = f2;
            }
          }
          m += 1;
        }
        paramCanvas.drawLine(this.i.left, this.i.bottom, this.i.left + f1, this.i.bottom, this.p);
        n += 1;
      }
      this.p.setColor(-65536);
      this.p.setColor(-1);
      this.n.draw(paramCanvas);
      if (super.f(0))
      {
        localObject = this.g;
        ((RectF)localObject).left = 0.0F;
        ((RectF)localObject).top = 0.0F;
        ((RectF)localObject).right = f3;
        ((RectF)localObject).bottom = f4;
        paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, s());
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 1;
  }
  
  public float c()
  {
    return this.q;
  }
  
  public float d()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RailSakuraTextItem
 * JD-Core Version:    0.7.0.1
 */