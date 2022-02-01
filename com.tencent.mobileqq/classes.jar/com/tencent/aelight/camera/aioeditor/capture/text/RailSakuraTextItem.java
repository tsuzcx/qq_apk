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
  public static final float a;
  public static final float b;
  public static final int b;
  public static final int c;
  public static final int d;
  private static int e;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private RectF b;
  private float c;
  private float d;
  private int f;
  
  static
  {
    jdField_a_of_type_Float = ScreenUtil.dip2px(22.0F);
    jdField_b_of_type_Float = ScreenUtil.dip2px(3.0F);
    e = 0;
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = AIOUtils.b(27.0F, localResources);
    jdField_d_of_type_Int = AIOUtils.b(6.0F, localResources);
    int i = DisplayUtil.a();
    jdField_c_of_type_Int = localResources.getDisplayMetrics().widthPixels - TextLayer.a - i * 2;
  }
  
  public RailSakuraTextItem(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
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
    paramTypeface = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    e = (int)Math.abs(paramTypeface.bottom - paramTypeface.top);
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
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaLangString.length()];
    char[] arrayOfChar = new char[this.jdField_a_of_type_JavaLangString.length()];
    String str = this.jdField_a_of_type_JavaLangString;
    int i = str.length();
    int n = 0;
    str.getChars(0, i, arrayOfChar, 0);
    int k = 0;
    for (int m = -1; k < this.jdField_a_of_type_JavaLangString.length(); m = i)
    {
      char c2 = arrayOfChar[k];
      if (k <= 0)
      {
        i = -1;
      }
      else
      {
        j = k - 1;
        for (;;)
        {
          i = m;
          if (j < 0) {
            break label119;
          }
          if (arrayOfChar[j] != '\n') {
            break;
          }
          j -= 1;
        }
        i = j;
      }
      label119:
      char c1;
      if (i == -1) {
        c1 = '\000';
      } else {
        c1 = arrayOfChar[i];
      }
      if (c(c2))
      {
        this.jdField_a_of_type_ArrayOfInt[k] = 2;
      }
      else if (a(c2))
      {
        this.jdField_a_of_type_ArrayOfInt[k] = 3;
        if ((c1 != 0) && (a(c1))) {
          this.jdField_a_of_type_ArrayOfInt[i] = -3;
        }
      }
      else if (b(c2))
      {
        this.jdField_a_of_type_ArrayOfInt[k] = 4;
      }
      else if (d(c2))
      {
        this.jdField_a_of_type_ArrayOfInt[k] = 5;
      }
      else
      {
        this.jdField_a_of_type_ArrayOfInt[k] = 1;
        if (c1 != 0) {
          if (c(c1)) {
            this.jdField_a_of_type_ArrayOfInt[i] = -2;
          } else if (a(c1)) {
            this.jdField_a_of_type_ArrayOfInt[i] = -3;
          } else if (b(c1)) {
            this.jdField_a_of_type_ArrayOfInt[i] = -4;
          } else {
            this.jdField_a_of_type_ArrayOfInt[i] = -1;
          }
        }
      }
      k += 1;
    }
    this.f = 0;
    arrayOfChar = this.jdField_a_of_type_JavaLangString.toCharArray();
    int j = arrayOfChar.length;
    i = n;
    while ((i < j) && (d(arrayOfChar[i])))
    {
      this.f += 1;
      i += 1;
    }
  }
  
  private static final boolean d(char paramChar)
  {
    return paramChar == '\n';
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
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
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.jdField_a_of_type_AndroidTextTextPaint, jdField_c_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, jdField_a_of_type_Float, false);
    float f1 = 0.0F;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount())
    {
      f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_c_of_type_Float = f1;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    d();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      float f3 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f4 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      int k = 0;
      int m;
      Object localObject;
      for (int i = 0; k < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount(); i = m)
      {
        this.jdField_b_of_type_AndroidTextStaticLayout.getLineBounds(k, this.jdField_a_of_type_AndroidGraphicsRect);
        m = this.jdField_b_of_type_AndroidTextStaticLayout.getLineVisibleEnd(k);
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        ((Rect)localObject).bottom = (((Rect)localObject).top + e);
        localObject = new float[m - i];
        this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(this.jdField_a_of_type_JavaLangString, i, m, (float[])localObject);
        int j = i;
        float f1 = 0.0F;
        while (j < m)
        {
          if (String.valueOf(this.jdField_a_of_type_JavaLangString.charAt(j)).equals("\n"))
          {
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            if ((j != this.f) && (!this.jdField_a_of_type_Boolean)) {}
            for (;;)
            {
              break;
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_Boolean = false;
                int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
                if ((arrayOfInt[j] != -1) && (arrayOfInt[j] != 1) && (arrayOfInt[j] != -3) && (arrayOfInt[j] != 3)) {
                  paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
                }
              }
              else
              {
                paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
              }
            }
            int n = j;
            float f2 = f1 + localObject[(n - i)];
            f1 = f2;
            if (this.jdField_a_of_type_ArrayOfInt[n] > 0)
            {
              paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f2, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
              f1 = f2;
            }
          }
          j += 1;
        }
        paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
        k += 1;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-65536);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
        ((RectF)localObject).left = 0.0F;
        ((RectF)localObject).top = 0.0F;
        ((RectF)localObject).right = f3;
        ((RectF)localObject).bottom = f4;
        paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, a());
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_d_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RailSakuraTextItem
 * JD-Core Version:    0.7.0.1
 */