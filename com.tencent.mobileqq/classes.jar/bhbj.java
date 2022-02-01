import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bhbj
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private int b;
  private int c;
  
  public bhbj(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      this.b = paramInt2;
      this.c = paramInt3;
      this.jdField_a_of_type_AndroidGraphicsPath = bhbg.a(this.b, this.c);
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.right - localRect.left;
    int j = localRect.bottom - localRect.top;
    if ((i != this.b) && (j != this.c))
    {
      this.b = i;
      this.c = j;
      this.jdField_a_of_type_AndroidGraphicsPath = bhbg.a(this.b, this.c);
    }
    paramCanvas.save();
    paramCanvas.translate(localRect.left, localRect.top);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    switch (this.jdField_a_of_type_Int >>> 24)
    {
    default: 
      return -3;
    case 255: 
      return -1;
    }
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbj
 * JD-Core Version:    0.7.0.1
 */