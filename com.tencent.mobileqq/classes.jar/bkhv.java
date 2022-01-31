import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;

public class bkhv
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private bkhw jdField_a_of_type_Bkhw;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 1;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 3;
  private float jdField_e_of_type_Float;
  private final int jdField_e_of_type_Int = 4;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  
  public bkhv()
  {
    this.jdField_m_of_type_Float = 2.147484E+009F;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    this.jdField_a_of_type_Bkhw.jdField_m_of_type_Boolean = true;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 3))
    {
      this.jdField_f_of_type_Int = 2;
      this.k = this.jdField_a_of_type_Bkhw.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bkhw.r;
      this.i = this.jdField_a_of_type_Bkhw.s;
      this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkhw.t;
      this.jdField_c_of_type_Float = bkhx.a(paramMotionEvent);
      this.jdField_d_of_type_Float = bkhx.b(paramMotionEvent);
      paramMotionEvent = bkhx.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.jdField_f_of_type_Float = paramMotionEvent[1];
    }
  }
  
  private boolean a(bkhw parambkhw, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!parambkhw.d) {
      return false;
    }
    float f3 = bkht.a() / 2.0F;
    if ((parambkhw.g) && (parambkhw.h)) {
      return (paramFloat1 >= parambkhw.jdField_l_of_type_Float + parambkhw.jdField_j_of_type_Float - f3 - 10.0F) && (paramFloat1 <= parambkhw.jdField_l_of_type_Float + parambkhw.jdField_j_of_type_Float + f3 + 10.0F) && (paramFloat2 >= parambkhw.jdField_m_of_type_Float + parambkhw.k - f3 - 10.0F) && (paramFloat2 <= parambkhw.jdField_m_of_type_Float + parambkhw.k + f3 + 10.0F);
    }
    paramFloat1 = a(parambkhw);
    float f1 = parambkhw.u;
    paramFloat2 = parambkhw.v;
    f1 += parambkhw.jdField_j_of_type_Int / paramFloat1 * 2.0F;
    float f2 = parambkhw.jdField_j_of_type_Int / paramFloat1 * 2.0F + paramFloat2;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambkhw.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambkhw.q;
      }
      paramFloat2 = paramFloat1;
      if (parambkhw.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambkhw.q;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = -f1 / 2.0F;
      paramFloat1 /= 2.0F;
      return (paramFloat3 >= paramFloat2 - f3 - 10.0F) && (paramFloat3 <= paramFloat2 + f3 + 10.0F) && (paramFloat4 >= paramFloat1 - f3 - 10.0F) && (paramFloat4 <= paramFloat1 + f3 + 10.0F);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bkhw.jdField_m_of_type_Boolean = false;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
    }
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.jdField_a_of_type_Float = f2;
    this.jdField_b_of_type_Float = f1;
    this.i = this.jdField_a_of_type_Bkhw.s;
    this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkhw.t;
    this.jdField_a_of_type_Bkhw.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bkhw.jdField_m_of_type_Boolean = false;
    if ((b(this.jdField_a_of_type_Bkhw, f2, f1)) && (paramBoolean))
    {
      this.jdField_f_of_type_Int = 3;
      this.k = this.jdField_a_of_type_Bkhw.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bkhw.r;
      f2 = f2 - this.jdField_a_of_type_Bkhw.b.x - this.jdField_a_of_type_Bkhw.s;
      f1 = f1 - this.jdField_a_of_type_Bkhw.b.y - this.jdField_a_of_type_Bkhw.t;
      this.jdField_c_of_type_Float = bkhx.a(f2, f1);
      this.jdField_d_of_type_Float = bkhx.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Bkhw.b.x;
      this.jdField_f_of_type_Float = this.jdField_a_of_type_Bkhw.b.y;
    }
    do
    {
      do
      {
        return;
      } while (!c(this.jdField_a_of_type_Bkhw, f2, f1));
      if ((this.jdField_a_of_type_Bkhw.g) && (!this.jdField_a_of_type_Bkhw.h))
      {
        this.jdField_a_of_type_Bkhw.h = true;
        a(this.jdField_a_of_type_Bkhw, true);
      }
    } while ((!this.jdField_a_of_type_Bkhw.g) || (!this.jdField_a_of_type_Bkhw.h));
    this.jdField_f_of_type_Int = 4;
    this.g = this.jdField_a_of_type_Bkhw.jdField_j_of_type_Float;
    this.h = this.jdField_a_of_type_Bkhw.k;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bkhw.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bkhw.jdField_m_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    a();
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramMotionEvent, paramBoolean);
    }
    label402:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Bkhw.jdField_l_of_type_Boolean = true;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_f_of_type_Int == 1))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
              this.i = this.jdField_a_of_type_Bkhw.s;
              this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkhw.t;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.jdField_a_of_type_Float;
            f3 = paramMotionEvent.getY(0);
            f4 = this.jdField_b_of_type_Float;
            this.jdField_a_of_type_Bkhw.s = (f1 - f2 + this.i);
            this.jdField_a_of_type_Bkhw.t = (f3 - f4 + this.jdField_j_of_type_Float);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_f_of_type_Int != 2)) {
            break label402;
          }
          f4 = bkhx.a(paramMotionEvent);
          f1 = bkhx.b(paramMotionEvent);
          paramMotionEvent = bkhx.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.jdField_a_of_type_Bkhw;
          float f5 = this.k;
          paramMotionEvent.q = (f4 / this.jdField_c_of_type_Float * f5);
          paramMotionEvent = this.jdField_a_of_type_Bkhw;
          f4 = this.jdField_l_of_type_Float;
          paramMotionEvent.r = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
          this.jdField_a_of_type_Bkhw.s = (this.i + (f2 - this.jdField_e_of_type_Float));
          this.jdField_a_of_type_Bkhw.t = (this.jdField_j_of_type_Float + (f3 - this.jdField_f_of_type_Float));
          if (!this.jdField_a_of_type_Bkhw.i) {
            break;
          }
          if (this.jdField_a_of_type_Bkhw.q > this.jdField_m_of_type_Float) {
            this.jdField_a_of_type_Bkhw.q = this.jdField_m_of_type_Float;
          }
          if (this.jdField_a_of_type_Bkhw.q < this.n) {
            this.jdField_a_of_type_Bkhw.q = this.n;
          }
        } while (this.jdField_a_of_type_Bkhw.r >= 0.0F);
        this.jdField_a_of_type_Bkhw.r += 360.0F;
        return;
        this.jdField_a_of_type_Bkhw.q = this.k;
        this.jdField_a_of_type_Bkhw.r = this.jdField_l_of_type_Float;
        return;
        if ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 3) || (!paramBoolean)) {
          break label654;
        }
        f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Bkhw.b.x - this.jdField_a_of_type_Bkhw.s;
        f3 = paramMotionEvent.getY() - this.jdField_a_of_type_Bkhw.b.y - this.jdField_a_of_type_Bkhw.t;
        f1 = bkhx.a(f2, f3);
        f2 = bkhx.b(f2, f3);
        paramMotionEvent = this.jdField_a_of_type_Bkhw;
        f3 = this.k;
        paramMotionEvent.q = (f1 / this.jdField_c_of_type_Float * f3);
        paramMotionEvent = this.jdField_a_of_type_Bkhw;
        f1 = this.jdField_l_of_type_Float;
        paramMotionEvent.r = ((f2 - this.jdField_d_of_type_Float + f1) % 360.0F);
        if (!this.jdField_a_of_type_Bkhw.i) {
          break;
        }
        if (this.jdField_a_of_type_Bkhw.q > this.jdField_m_of_type_Float) {
          this.jdField_a_of_type_Bkhw.q = this.jdField_m_of_type_Float;
        }
        if (this.jdField_a_of_type_Bkhw.q < this.n) {
          this.jdField_a_of_type_Bkhw.q = this.n;
        }
      } while (this.jdField_a_of_type_Bkhw.r >= 0.0F);
      this.jdField_a_of_type_Bkhw.r += 360.0F;
      return;
      this.jdField_a_of_type_Bkhw.q = this.k;
      this.jdField_a_of_type_Bkhw.r = this.jdField_l_of_type_Float;
      return;
    } while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 4));
    label654:
    float f1 = paramMotionEvent.getX(0);
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getY(0);
    float f4 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Bkhw.jdField_j_of_type_Float = (f1 - f2 + this.g);
    this.jdField_a_of_type_Bkhw.k = (f3 - f4 + this.h);
  }
  
  public float a(bkhw parambkhw)
  {
    float f1 = 1.0F;
    if (parambkhw != null) {
      f1 = parambkhw.q * parambkhw.w;
    }
    return f1;
  }
  
  public int a(bkam parambkam, float paramFloat1, float paramFloat2)
  {
    if (parambkam == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambkam).mapPoints(arrayOfFloat);
    float f1 = parambkam.u;
    float f2 = parambkam.v;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambkam.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambkam.q;
      }
      paramFloat2 = paramFloat1;
      if (parambkam.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambkam.q;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      return parambkam.a.a(f1, paramFloat1, arrayOfFloat[0], arrayOfFloat[1]);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public Matrix a(bkhw parambkhw)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambkhw == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambkhw.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(parambkhw), a(parambkhw));
    if (parambkhw.b != null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkhw.b.x, parambkhw.b.y);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkhw.s, parambkhw.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public bkhw a()
  {
    return this.jdField_a_of_type_Bkhw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkhw = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = 0.0F;
    this.i = 0.0F;
    this.jdField_j_of_type_Float = 0.0F;
    this.k = 0.0F;
    this.jdField_l_of_type_Float = 0.0F;
    this.g = 0.0F;
    this.h = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.jdField_m_of_type_Float = paramFloat;
    }
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bkhw == null) {
      return;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      b(paramMotionEvent, paramBoolean);
      return;
    case 5: 
      a(paramMotionEvent);
      return;
    case 2: 
      c(paramMotionEvent, paramBoolean);
      return;
    case 6: 
      b(paramMotionEvent);
      return;
    }
    c(paramMotionEvent);
  }
  
  public void a(bkhw parambkhw)
  {
    a();
    this.jdField_a_of_type_Bkhw = parambkhw;
  }
  
  public void a(bkhw parambkhw, boolean paramBoolean)
  {
    float f4 = parambkhw.u;
    float f3 = parambkhw.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambkhw.jdField_j_of_type_Int * 2;
      f2 = f3 + parambkhw.jdField_j_of_type_Int * 2;
    }
    f4 = f2;
    float f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambkhw.q * f1 < 200.0F) {
        f3 = 200.0F / parambkhw.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambkhw.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambkhw.q;
        f5 = f3;
      }
    }
    f2 = f5 / 2.0F;
    f1 = f4 / 2.0F;
    f2 = -f2;
    f3 = -f1;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = f2;
    arrayOfFloat[1] = f1;
    a(parambkhw).mapPoints(arrayOfFloat);
    parambkhw.jdField_l_of_type_Float = arrayOfFloat[0];
    parambkhw.jdField_m_of_type_Float = arrayOfFloat[1];
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(bkhw parambkhw, float paramFloat1, float paramFloat2)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkhw).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkhw);
      f2 = parambkhw.u;
      float f3 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkhw.v;
      float f1 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkht.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean a(bkhw parambkhw, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parambkhw == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambkhw).mapPoints(arrayOfFloat);
    float f5 = a(parambkhw);
    float f4 = parambkhw.u;
    float f3 = parambkhw.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambkhw.jdField_j_of_type_Int / f5 * 2.0F;
      f2 = f3 + parambkhw.jdField_j_of_type_Int / f5 * 2.0F;
    }
    f4 = f2;
    f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambkhw.q * f1 < 200.0F) {
        f3 = 200.0F / parambkhw.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambkhw.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambkhw.q;
        f5 = f3;
      }
    }
    f1 = f5 / 2.0F;
    f2 = f4 / 2.0F;
    f3 = -f1;
    f4 = -f2;
    f5 = bkht.a() / a(parambkhw) / 2.0F;
    float f6 = parambkhw.jdField_j_of_type_Float / a(parambkhw);
    f6 = parambkhw.k / a(parambkhw);
    parambkhw.e = false;
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= f1) && (arrayOfFloat[1] >= f4) && (arrayOfFloat[1] <= f2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((parambkhw.d) && (arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F))
    {
      parambkhw.e = true;
      return true;
    }
    if (a(parambkhw, paramFloat1, paramFloat2, arrayOfFloat[0], arrayOfFloat[1], paramBoolean))
    {
      parambkhw.e = true;
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f3 - f5) && (arrayOfFloat[0] <= f1 + f5) && (arrayOfFloat[1] >= f4 - f5) && (arrayOfFloat[1] <= f2 + f5);
  }
  
  public boolean a(bkhw parambkhw, float paramFloat, boolean paramBoolean)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambkhw.u;
        float f1 = parambkhw.v / 2.0F;
        f2 /= 2.0F;
        arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = (-f2);
        arrayOfFloat1[1] = (-f1);
        arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = f2;
        arrayOfFloat2[1] = (-f1);
        arrayOfFloat3 = new float[2];
        arrayOfFloat3[0] = (-f2);
        arrayOfFloat3[1] = f1;
        arrayOfFloat4 = new float[2];
        arrayOfFloat4[0] = f2;
        arrayOfFloat4[1] = f1;
        parambkhw = a(parambkhw);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambkhw;
        parambkhw.mapPoints(arrayOfFloat1);
        parambkhw.mapPoints(arrayOfFloat2);
        parambkhw.mapPoints(arrayOfFloat3);
        parambkhw.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambkhw = new StringBuilder();
          parambkhw.append("isCloseToXLine x=").append(paramFloat).append(" leftReach=").append(paramBoolean).append("\n");
          parambkhw.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambkhw.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambkhw.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambkhw.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambkhw.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[0] > paramFloat) && (arrayOfFloat2[0] > paramFloat) && (arrayOfFloat3[0] > paramFloat) && (arrayOfFloat4[0] > paramFloat));
      return true;
    } while ((arrayOfFloat1[0] < paramFloat) && (arrayOfFloat2[0] < paramFloat) && (arrayOfFloat3[0] < paramFloat) && (arrayOfFloat4[0] < paramFloat));
    return true;
  }
  
  public Matrix b(bkhw parambkhw)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambkhw == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambkhw.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkhw.b.x, parambkhw.b.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkhw.s, parambkhw.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.n = paramFloat;
    }
  }
  
  public void b(bkhw parambkhw)
  {
    if ((parambkhw == null) || (parambkhw.a == null)) {
      return;
    }
    Matrix localMatrix = c(parambkhw);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat3 = new float[2];
    float[] arrayOfFloat4 = new float[2];
    float f4 = 0.0F;
    arrayOfFloat1[0] = bkar.jdField_a_of_type_Int;
    arrayOfFloat1[1] = bkar.jdField_c_of_type_Int;
    arrayOfFloat2[0] = bkar.jdField_a_of_type_Int;
    arrayOfFloat2[1] = bkar.jdField_d_of_type_Int;
    arrayOfFloat3[0] = bkar.jdField_b_of_type_Int;
    arrayOfFloat3[1] = bkar.jdField_c_of_type_Int;
    arrayOfFloat4[0] = bkar.jdField_b_of_type_Int;
    arrayOfFloat4[1] = bkar.jdField_d_of_type_Int;
    localMatrix.mapPoints(arrayOfFloat1);
    localMatrix.mapPoints(arrayOfFloat2);
    localMatrix.mapPoints(arrayOfFloat3);
    localMatrix.mapPoints(arrayOfFloat4);
    int i1;
    int i2;
    label164:
    int i3;
    label179:
    int i4;
    if (arrayOfFloat2[0] == arrayOfFloat1[0])
    {
      i1 = 1;
      if (arrayOfFloat4[0] != arrayOfFloat3[0]) {
        break label635;
      }
      i2 = 1;
      if (arrayOfFloat1[0] != arrayOfFloat3[0]) {
        break label641;
      }
      i3 = 1;
      if (arrayOfFloat2[0] != arrayOfFloat4[0]) {
        break label647;
      }
      i4 = 1;
      label194:
      if ((i1 != 0) && (arrayOfFloat2[0] <= parambkhw.jdField_m_of_type_Int - parambkhw.u / 2.0F) && (arrayOfFloat2[0] >= parambkhw.jdField_l_of_type_Int - parambkhw.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
      }
      if ((i2 != 0) && (arrayOfFloat3[0] <= parambkhw.jdField_m_of_type_Int - parambkhw.u / 2.0F) && (arrayOfFloat3[0] >= parambkhw.jdField_l_of_type_Int - parambkhw.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
      }
      if ((i3 != 0) && (arrayOfFloat1[0] <= parambkhw.jdField_m_of_type_Int - parambkhw.u / 2.0F) && (arrayOfFloat1[0] >= parambkhw.jdField_l_of_type_Int - parambkhw.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, TOP");
      }
      if ((i4 != 0) && (arrayOfFloat2[0] <= parambkhw.jdField_m_of_type_Int - parambkhw.u / 2.0F) && (arrayOfFloat2[0] >= parambkhw.jdField_l_of_type_Int - parambkhw.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, BOTTOM");
      }
      if (i1 != 0) {
        break label894;
      }
    }
    label635:
    label894:
    for (float f1 = (arrayOfFloat2[1] - arrayOfFloat1[1]) / (arrayOfFloat2[0] - arrayOfFloat1[0]);; f1 = 0.0F)
    {
      if (i2 == 0) {}
      for (float f2 = (arrayOfFloat4[1] - arrayOfFloat3[1]) / (arrayOfFloat4[0] - arrayOfFloat3[0]);; f2 = 0.0F)
      {
        if (i3 == 0) {}
        for (float f3 = (arrayOfFloat1[1] - arrayOfFloat3[1]) / (arrayOfFloat1[0] - arrayOfFloat3[0]);; f3 = 0.0F)
        {
          if (i4 == 0) {
            f4 = (arrayOfFloat2[1] - arrayOfFloat4[1]) / (arrayOfFloat2[0] - arrayOfFloat4[0]);
          }
          int i5 = 0;
          for (;;)
          {
            if (i5 >= parambkhw.u) {
              break label881;
            }
            float f5 = parambkhw.a[(i5 * 2)];
            float f6 = parambkhw.a[(i5 * 2 + 1)];
            int i6;
            if (i1 == 0)
            {
              i6 = (int)((i5 - parambkhw.u / 2.0F - arrayOfFloat1[0]) * f1 + arrayOfFloat1[1]);
              if ((i6 >= f5 - parambkhw.v / 2.0F) && (i6 <= f6 - parambkhw.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
                return;
                i1 = 0;
                break;
                i2 = 0;
                break label164;
                i3 = 0;
                break label179;
                i4 = 0;
                break label194;
              }
            }
            if (i2 == 0)
            {
              i6 = (int)((i5 - parambkhw.u / 2.0F - arrayOfFloat3[0]) * f2 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambkhw.v / 2.0F) && (i6 <= f6 - parambkhw.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
                return;
              }
            }
            if (i3 == 0)
            {
              i6 = (int)((i5 - parambkhw.u / 2.0F - arrayOfFloat3[0]) * f3 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambkhw.v / 2.0F) && (i6 <= f6 - parambkhw.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, TOP");
                return;
              }
            }
            if (i4 == 0)
            {
              i6 = (int)((i5 - parambkhw.u / 2.0F - arrayOfFloat4[0]) * f4 + arrayOfFloat4[1]);
              if ((i6 >= f5 - parambkhw.v / 2.0F) && (i6 <= f6 - parambkhw.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, BOTTOM");
                return;
              }
            }
            i5 += 1;
          }
          break;
        }
      }
    }
  }
  
  public boolean b(bkhw parambkhw, float paramFloat1, float paramFloat2)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkhw).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkhw);
      f2 = parambkhw.u;
      float f3 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkhw.v;
      float f1 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkht.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean b(bkhw parambkhw, float paramFloat, boolean paramBoolean)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambkhw.u;
        float f1 = parambkhw.v / 2.0F;
        f2 /= 2.0F;
        arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = (-f2);
        arrayOfFloat1[1] = (-f1);
        arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = f2;
        arrayOfFloat2[1] = (-f1);
        arrayOfFloat3 = new float[2];
        arrayOfFloat3[0] = (-f2);
        arrayOfFloat3[1] = f1;
        arrayOfFloat4 = new float[2];
        arrayOfFloat4[0] = f2;
        arrayOfFloat4[1] = f1;
        parambkhw = a(parambkhw);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambkhw;
        parambkhw.mapPoints(arrayOfFloat1);
        parambkhw.mapPoints(arrayOfFloat2);
        parambkhw.mapPoints(arrayOfFloat3);
        parambkhw.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambkhw = new StringBuilder();
          parambkhw.append("isCloseToYLine y=").append(paramFloat).append(" topReach=").append(paramBoolean).append("\n");
          parambkhw.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambkhw.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambkhw.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambkhw.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambkhw.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[1] > paramFloat) && (arrayOfFloat2[1] > paramFloat) && (arrayOfFloat3[1] > paramFloat) && (arrayOfFloat4[1] > paramFloat));
      return true;
    } while ((arrayOfFloat1[1] < paramFloat) && (arrayOfFloat2[1] < paramFloat) && (arrayOfFloat3[1] < paramFloat) && (arrayOfFloat4[1] < paramFloat));
    return true;
  }
  
  public Matrix c(bkhw parambkhw)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (parambkhw == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(parambkhw);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public boolean c(bkhw parambkhw, float paramFloat1, float paramFloat2)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      if ((!parambkhw.g) || (!parambkhw.h)) {
        break;
      }
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      paramFloat1 = bkht.a() / 2.0F;
    } while ((arrayOfFloat[0] < parambkhw.jdField_l_of_type_Float + parambkhw.jdField_j_of_type_Float - paramFloat1 - 10.0F) || (arrayOfFloat[0] > parambkhw.jdField_l_of_type_Float + parambkhw.jdField_j_of_type_Float + paramFloat1 + 10.0F) || (arrayOfFloat[1] < parambkhw.jdField_m_of_type_Float + parambkhw.k - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + (parambkhw.jdField_m_of_type_Float + parambkhw.k) + 10.0F));
    return true;
    return d(parambkhw, paramFloat1, paramFloat2);
  }
  
  public boolean d(bkhw parambkhw, float paramFloat1, float paramFloat2)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkhw).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkhw);
      f2 = parambkhw.u;
      float f3 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkhw.v;
      float f1 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkht.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean e(bkhw parambkhw, float paramFloat1, float paramFloat2)
  {
    if (parambkhw == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkhw).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkhw);
      f2 = parambkhw.u;
      float f3 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkhw.v;
      float f1 = parambkhw.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkht.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhv
 * JD-Core Version:    0.7.0.1
 */