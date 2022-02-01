import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class bphi
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 6;
  private float c;
  
  public int a(float paramFloat)
  {
    int k = 0;
    int j = k;
    float f2;
    int i;
    float f3;
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
    {
      float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
      float f1 = 0.0F;
      f2 = 0.0F;
      i = 0;
      for (;;)
      {
        f3 = f1;
        if (i >= this.jdField_b_of_type_Int) {
          break;
        }
        f1 = i * f4 + f4 + this.jdField_a_of_type_AndroidGraphicsRectF.top;
        f3 = f1;
        if (paramFloat <= f1) {
          break;
        }
        i += 1;
        f2 = f1;
      }
      if (i != this.jdField_b_of_type_Int) {
        break label111;
      }
      j = this.jdField_b_of_type_Int - 1;
    }
    label111:
    do
    {
      return j;
      j = k;
    } while (i == 0);
    if (paramFloat - f2 > f3 - paramFloat) {
      return i;
    }
    return i - 1;
  }
  
  public RectF a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_Int)) {}
    while (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()) {
      return null;
    }
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
    float f3 = paramInt;
    f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top + (f2 + f3 * f2);
    return new RectF(f1 - this.c, f2 - this.c, f1 + this.c, f2 + this.c);
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCanvas == null) {
      return;
    }
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f3 = this.jdField_b_of_type_Float;
    float f4 = this.jdField_a_of_type_Float;
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
    f2 = (f2 - f3 - f4) / 2.0F;
    f2 = this.jdField_a_of_type_Float + f2;
    int i = 0;
    label67:
    if (i < this.jdField_b_of_type_Int)
    {
      f3 = i * f1 + f1 + this.jdField_a_of_type_AndroidGraphicsRectF.top;
      if ((i != this.jdField_b_of_type_Int - 1) || (i != paramInt2)) {
        break label121;
      }
    }
    for (;;)
    {
      i += 1;
      break label67;
      break;
      label121:
      int j;
      if (i == this.jdField_b_of_type_Int - 1)
      {
        j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt1);
        paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
      }
      else if (i == paramInt2)
      {
        j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt3);
        paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
      }
      else
      {
        j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt4);
        paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
      }
    }
  }
  
  public void a(RectF paramRectF)
  {
    if (paramRectF != null) {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat2;
    this.jdField_b_of_type_Float = paramFloat3;
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.c = paramFloat1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphi
 * JD-Core Version:    0.7.0.1
 */