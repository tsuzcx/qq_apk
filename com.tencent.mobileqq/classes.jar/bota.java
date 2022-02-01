import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;

public class bota
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public bota(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    while ((localRect.width() + paramInt3 > paramInt1 * 0.8F) || (localRect.height() + paramInt3 > paramInt2 * 0.8F))
    {
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  private void c()
  {
    Typeface localTypeface = bors.a().a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    c();
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_AndroidTextTextPaint.getTextSize());
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
    int i = this.jdField_a_of_type_JavaLangString.indexOf("\r\n");
    float f2;
    if (i < 0)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (this.c - f1) / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (this.c - f1) / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
      return;
      String str1 = this.jdField_a_of_type_JavaLangString.substring(0, i);
      String str2 = this.jdField_a_of_type_JavaLangString.substring("\r\n".length() + i);
      a(str1, this.jdField_b_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, this.c / 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str1, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str1)) / 2.0F, this.c * 0.25F - f1 / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str1, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1)) / 2.0F, this.c * 0.25F - f1 / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str2, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str2)) / 2.0F, this.c * 0.65F - f1 / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str2, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str2)) / 2.0F, this.c * 0.65F - f1 / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.trim();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void d(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bota
 * JD-Core Version:    0.7.0.1
 */