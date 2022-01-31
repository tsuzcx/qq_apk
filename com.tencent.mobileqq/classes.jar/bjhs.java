import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
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

public class bjhs
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  protected float a;
  protected RectF a;
  protected TextPaint a;
  protected float b;
  private int e = 2147483647;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = actn.a(22.0F, localResources);
    d = actn.a(14.0F, localResources);
    jdField_c_of_type_Int = Math.min(localResources.getDisplayMetrics().widthPixels - bkaj.jdField_a_of_type_Int, actn.a(270.0F, localResources));
  }
  
  public bjhs()
  {
    this(0, bjgr.a(0));
  }
  
  public bjhs(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    this.jdField_a_of_type_Int = jdField_b_of_type_Int;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int i = paramInt3 + 10;
    c(i);
    a(paramInt1, paramString);
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() < paramInt2) {
      return i;
    }
    c(paramInt3);
    a(paramInt1, paramString);
    return paramInt3;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    float f = 0.0F;
    int i = 0;
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_AndroidTextStaticLayout = bjig.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, jdField_c_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.e);
    str = paramString;
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() > this.e)
    {
      paramInt = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(this.e - 1);
      str = paramString;
      if (paramInt < paramString.length()) {
        str = paramString.subSequence(0, paramInt) + "";
      }
      this.jdField_b_of_type_AndroidTextStaticLayout = bjig.a(str, 0, str.length(), this.jdField_a_of_type_AndroidTextTextPaint, jdField_c_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.e);
    }
    paramInt = i;
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(str);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
      return;
    }
    while (paramInt < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount())
    {
      f = Math.max(f, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_a_of_type_Float = f;
    this.jdField_b_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
  }
  
  public void a(Canvas paramCanvas)
  {
    float f1;
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F);
        String str2 = super.b(0);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "　　";
        }
        paramCanvas.drawText(str1, 0.0F, f1, this.jdField_a_of_type_AndroidTextTextPaint);
        if (super.b(0))
        {
          int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1);
          int j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (-i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = (-j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j / 2.0F);
          paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.b(0))
    {
      f1 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f2;
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramInt3 -= 10;
    if (paramInt3 > d)
    {
      c(paramInt3);
      a(paramInt1, paramString);
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() >= paramInt2) {}
    }
    for (paramInt3 = 0;; paramInt3 = 1)
    {
      if (paramInt3 == 0)
      {
        return false;
        paramInt3 -= 10;
        break;
      }
      double d1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() / this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
      this.e = ((int)(paramInt2 / d1));
      a(paramInt1, paramString);
      return true;
    }
  }
  
  public boolean a(String paramString)
  {
    int i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(i - 1);
    return paramString.length() > i + 1;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getColor();
  }
  
  public int f()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout == null) {
      return 0;
    }
    return this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhs
 * JD-Core Version:    0.7.0.1
 */