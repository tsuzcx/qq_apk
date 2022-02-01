import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class bhxu
  extends Drawable
{
  private float jdField_a_of_type_Float;
  private ColorMatrixColorFilter jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private Paint c;
  
  public bhxu()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.argb(200, 0, 0, 0));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(0);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidateSelf();
  }
  
  public void a(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidateSelf();
  }
  
  public void a(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter = paramColorMatrixColorFilter;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColorFilter(paramColorMatrixColorFilter);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if (this.jdField_a_of_type_Float > Math.min(i, j)) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j / 2.0F + this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (j / 2.0F - this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (i / 2.0F - this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i / 2.0F + this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, j / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i, j / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRectF.right, j / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, -180.0F, true);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRectF.left, j / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(0.0F, j / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(0.0F, j);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(i, j);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(i, j / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRectF.right, j / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 180.0F, true);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRectF.left, j / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.c.getColor() != 0) {
        paramCanvas.drawCircle(i / 2.0F, j / 2.0F, this.jdField_a_of_type_Float, this.c);
      }
    } while (this.jdField_a_of_type_AndroidGraphicsColorMatrixColorFilter == null);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxu
 * JD-Core Version:    0.7.0.1
 */