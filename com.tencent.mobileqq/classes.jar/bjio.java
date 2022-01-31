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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class bjio
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
    jdField_a_of_type_Float = axlk.a(22.0F);
    jdField_b_of_type_Float = axlk.a(3.0F);
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = actj.a(27.0F, localResources);
    jdField_d_of_type_Int = actj.a(6.0F, localResources);
    int i = bkik.a();
    jdField_c_of_type_Int = localResources.getDisplayMetrics().widthPixels - vla.a - i * 2;
  }
  
  public bjio(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
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
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
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
    int n = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaLangString.length()];
    char[] arrayOfChar = new char[this.jdField_a_of_type_JavaLangString.length()];
    this.jdField_a_of_type_JavaLangString.getChars(0, this.jdField_a_of_type_JavaLangString.length(), arrayOfChar, 0);
    int k = 0;
    int m = -1;
    if (k < this.jdField_a_of_type_JavaLangString.length())
    {
      char c2 = arrayOfChar[k];
      label76:
      char c1;
      if (k <= 0)
      {
        i = -1;
        if (i != -1) {
          break label149;
        }
        c1 = '\000';
        label83:
        if (!c(c2)) {
          break label157;
        }
        this.jdField_a_of_type_ArrayOfInt[k] = 2;
      }
      for (;;)
      {
        k += 1;
        m = i;
        break;
        j = k - 1;
        for (;;)
        {
          i = m;
          if (j < 0) {
            break;
          }
          if (arrayOfChar[j] != '\n') {
            break label143;
          }
          j -= 1;
        }
        label143:
        i = j;
        break label76;
        label149:
        c1 = arrayOfChar[i];
        break label83;
        label157:
        if (a(c2))
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
      }
    }
    this.f = 0;
    arrayOfChar = this.jdField_a_of_type_JavaLangString.toCharArray();
    int j = arrayOfChar.length;
    int i = n;
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
    int i = 0;
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.jdField_a_of_type_AndroidTextTextPaint, jdField_c_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, jdField_a_of_type_Float, false);
    float f1 = 0.0F;
    paramInt = i;
    while (paramInt < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount())
    {
      f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_c_of_type_Float = f1;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    d();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      float f2 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f3 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      int j = 0;
      int m;
      for (int i = 0; j < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount(); i = m)
      {
        this.jdField_b_of_type_AndroidTextStaticLayout.getLineBounds(j, this.jdField_a_of_type_AndroidGraphicsRect);
        m = this.jdField_b_of_type_AndroidTextStaticLayout.getLineVisibleEnd(j);
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + e);
        float f1 = 0.0F;
        float[] arrayOfFloat = new float[m - i];
        this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(this.jdField_a_of_type_JavaLangString, i, m, arrayOfFloat);
        int k = i;
        while (k < m) {
          if (String.valueOf(this.jdField_a_of_type_JavaLangString.charAt(k)).equals("\n"))
          {
            this.jdField_a_of_type_Boolean = true;
            k += 1;
          }
          else
          {
            if ((k == this.f) || (this.jdField_a_of_type_Boolean))
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label368;
              }
              this.jdField_a_of_type_Boolean = false;
              if ((this.jdField_a_of_type_ArrayOfInt[k] != -1) && (this.jdField_a_of_type_ArrayOfInt[k] != 1) && (this.jdField_a_of_type_ArrayOfInt[k] != -3) && (this.jdField_a_of_type_ArrayOfInt[k] != 3)) {
                break label317;
              }
            }
            for (;;)
            {
              f1 += arrayOfFloat[(k - i)];
              if (this.jdField_a_of_type_ArrayOfInt[k] > 0) {
                paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
              }
              break;
              label317:
              paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
              continue;
              label368:
              paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
            }
          }
        }
        paramCanvas.drawLine(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left + f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidTextTextPaint);
        j += 1;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-65536);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = f2;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f3;
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjio
 * JD-Core Version:    0.7.0.1
 */