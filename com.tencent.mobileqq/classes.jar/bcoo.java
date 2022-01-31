import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class bcoo
  extends Drawable
{
  private int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  String jdField_a_of_type_JavaLangString = "0%";
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = true;
  private int c;
  
  public bcoo(Bitmap paramBitmap, int paramInt)
  {
    this(paramBitmap, paramInt, true);
  }
  
  public bcoo(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Int - i, this.jdField_b_of_type_Int - j);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(5.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.c < 10) {
        break label183;
      }
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (float)(this.jdField_a_of_type_Int - i * 0.6D), (float)(this.jdField_b_of_type_Int + j * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      invalidateSelf();
      return;
      label183:
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (float)(this.jdField_a_of_type_Int - i * 0.375D), (float)(this.jdField_b_of_type_Int + j * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    int i = 99;
    int j = paramInt / 85;
    if (j > 99) {}
    for (;;)
    {
      this.c = i;
      this.jdField_a_of_type_JavaLangString = (this.c + "%");
      return super.onLevelChange(paramInt);
      i = j;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(Rect paramRect)
  {
    this.jdField_a_of_type_Int = paramRect.centerX();
    this.jdField_b_of_type_Int = paramRect.centerY();
    this.jdField_a_of_type_Boolean = false;
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcoo
 * JD-Core Version:    0.7.0.1
 */