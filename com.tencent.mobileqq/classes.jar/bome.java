import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

public class bome
  extends bokp
{
  private static final double jdField_a_of_type_Double = Math.abs(Math.tan(Math.toRadians(10.0D)));
  private float jdField_a_of_type_Float;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private float b;
  
  public bome(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_Float = (ScreenUtil.dip2px(4.0F) + paramInt2);
    this.b = paramInt3;
  }
  
  private float a(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    return f;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 - paramFloat2 >= 0.15F * paramFloat3;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2) {}
  
  public void a(Canvas paramCanvas, ArrayList<bomh> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramCanvas == null) || (paramArrayList == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    RectF localRectF1 = ((bomh)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsRectF;
    RectF localRectF2 = ((bomh)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_AndroidGraphicsRectF;
    float f3 = localRectF1.width() / ((bomh)paramArrayList.get(0)).jdField_a_of_type_JavaLangString.length();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localRectF2.right + paramInt1 + this.jdField_a_of_type_Float, localRectF2.bottom + paramInt2 + this.b);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF2.left + paramInt1 - this.jdField_a_of_type_Float, localRectF2.bottom + paramInt2 + this.b);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF1.left + paramInt1 - this.jdField_a_of_type_Float, localRectF1.top + paramInt2 - this.b);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF1.right + paramInt1 + this.jdField_a_of_type_Float, localRectF1.top + paramInt2 - this.b);
    double d1;
    double d2;
    if (paramArrayList.size() == 1)
    {
      d1 = jdField_a_of_type_Double;
      d2 = ((bomh)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsRectF.height();
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo((float)(localRectF2.right - d2 * d1 + paramInt1) + this.jdField_a_of_type_Float, localRectF2.bottom + paramInt2 + this.b);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    float f2 = -1.0F;
    float f1 = -1.0F;
    int i = 0;
    label302:
    if (i < paramArrayList.size())
    {
      localRectF1 = ((bomh)paramArrayList.get(i)).jdField_a_of_type_AndroidGraphicsRectF;
      if ((f2 != -1.0F) && (f1 != -1.0F)) {
        break label504;
      }
      localRectF2 = ((bomh)paramArrayList.get(i + 1)).jdField_a_of_type_AndroidGraphicsRectF;
      if (!a(localRectF1.width(), localRectF2.width(), f3)) {
        break label464;
      }
      f2 = localRectF1.height() + localRectF2.height() * 0.1F;
      f1 = localRectF1.top + f2;
      d1 = localRectF1.right;
      d2 = jdField_a_of_type_Double;
      f2 = a((float)(d1 - f2 * d2 + this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1 + f2, paramInt2 + f1);
      i += 1;
      break label302;
      break;
      label464:
      f2 = a((float)(localRectF1.right - jdField_a_of_type_Double * localRectF1.height() + this.jdField_a_of_type_Float));
      f1 = localRectF2.top;
    }
    label504:
    float f4;
    if (paramArrayList.size() == i + 1)
    {
      if (f1 == localRectF1.top)
      {
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF1.right + paramInt1 + this.jdField_a_of_type_Float, localRectF1.top + paramInt2);
        f2 = a((float)(localRectF1.right - jdField_a_of_type_Double * localRectF1.height()));
      }
      for (f1 = localRectF1.bottom + this.b;; f1 = localRectF1.bottom + this.b)
      {
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1 + f2, paramInt2 + f1);
        break;
        f2 = a(f2 - 0.75F * f3 + this.jdField_a_of_type_Float);
        f4 = localRectF1.height();
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1 + f2, f1 + f4 * 0.1F + paramInt2);
        f2 = a((float)(f2 - localRectF1.height() * 0.9F * jdField_a_of_type_Double));
      }
    }
    localRectF2 = ((bomh)paramArrayList.get(i + 1)).jdField_a_of_type_AndroidGraphicsRectF;
    if (f1 == localRectF1.top)
    {
      f2 = localRectF1.right;
      f4 = this.jdField_a_of_type_Float;
      f1 = localRectF1.top;
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f4 + f2 + paramInt1, paramInt2 + f1);
      label769:
      if (!a(localRectF1.width(), localRectF2.width(), f3)) {
        break label929;
      }
      f2 = localRectF1.bottom;
      f2 = 0.1F * localRectF2.height() + (f2 - f1);
      f1 = localRectF1.top + f2;
      d1 = localRectF1.right;
      d2 = jdField_a_of_type_Double;
      f2 = a((float)(d1 - f2 * d2) + this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1 + f2, paramInt2 + f1);
      break;
      f2 = a(f2 - 0.75F * f3 + this.jdField_a_of_type_Float);
      f1 = localRectF1.height() * 0.1F + f1;
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2 + paramInt1, paramInt2 + f1);
      break label769;
      label929:
      f2 = a((float)(localRectF1.right - jdField_a_of_type_Double * localRectF1.height()) + this.jdField_a_of_type_Float);
      f1 = localRectF2.top;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bome
 * JD-Core Version:    0.7.0.1
 */