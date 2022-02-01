import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

public class bpzl
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bpzg jdField_a_of_type_Bpzg;
  private bpzm jdField_a_of_type_Bpzm;
  private final float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private final float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.jdField_a_of_type_Float * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.jdField_b_of_type_Float);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramFloat - this.jdField_a_of_type_Float, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {}
    for (this.k = (this.jdField_a_of_type_Float + paramFloat1);; this.k = this.jdField_a_of_type_Float)
    {
      if (paramFloat2 >= 0.0F) {
        this.j = Math.min(this.jdField_a_of_type_Float + paramFloat2, this.d - this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int m = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    paramCanvas.drawRect(this.e, 0.0F, this.f, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.e, this.jdField_b_of_type_Float - this.jdField_b_of_type_Int, this.f, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(m);
    b(this.e, paramCanvas);
    a(this.f, paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Int = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.i = paramMotionEvent.getX();
      return;
    }
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = f1 - this.i;
      if (this.jdField_a_of_type_Int != 0) {
        break label186;
      }
      f3 = Math.max(this.f - this.h, this.k);
      if (f1 < f3)
      {
        this.e = f3;
        return;
      }
      if ((f2 >= 0.0F) || (f2 + this.e > this.jdField_a_of_type_Float)) {
        break label148;
      }
      this.e = f3;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpzg.invalidate();
      if (this.jdField_a_of_type_Bpzm == null) {
        break;
      }
      this.jdField_a_of_type_Bpzm.a(this.e, this.f);
      return;
      label148:
      if (this.f - f1 < this.g)
      {
        this.e = (this.f - this.g);
      }
      else
      {
        this.e = f1;
        continue;
        label186:
        if (this.jdField_a_of_type_Int == 1)
        {
          f3 = Math.min(this.e + this.h, this.j);
          if (f1 > f3)
          {
            this.f = f3;
            return;
          }
          if ((f2 > 0.0F) && (f2 + this.f >= this.h)) {
            this.f = f3;
          } else if (f1 - this.e < this.g) {
            this.f = (this.e + this.g);
          } else {
            this.f = f1;
          }
        }
      }
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.e - this.jdField_c_of_type_Float);
    boolean bool2 = a(paramFloat1, paramFloat2, this.f + this.jdField_c_of_type_Float);
    if (bool1)
    {
      this.jdField_a_of_type_Int = 0;
      return true;
    }
    if (bool2)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpzl
 * JD-Core Version:    0.7.0.1
 */