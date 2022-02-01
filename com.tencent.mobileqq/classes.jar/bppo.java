import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;

public class bppo
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private bppp jdField_a_of_type_Bppp;
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
  
  public bppo()
  {
    this.jdField_m_of_type_Float = 2.147484E+009F;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    this.jdField_a_of_type_Bppp.jdField_m_of_type_Boolean = true;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 3))
    {
      this.jdField_f_of_type_Int = 2;
      this.k = this.jdField_a_of_type_Bppp.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bppp.r;
      this.i = this.jdField_a_of_type_Bppp.s;
      this.jdField_j_of_type_Float = this.jdField_a_of_type_Bppp.t;
      this.jdField_c_of_type_Float = bppq.a(paramMotionEvent);
      this.jdField_d_of_type_Float = bppq.b(paramMotionEvent);
      paramMotionEvent = bppq.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.jdField_f_of_type_Float = paramMotionEvent[1];
    }
  }
  
  private boolean a(bppp parambppp, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!parambppp.d) {
      return false;
    }
    float f3 = bppm.a() / 2.0F;
    if ((parambppp.g) && (parambppp.h)) {
      return (paramFloat1 >= parambppp.jdField_l_of_type_Float + parambppp.jdField_j_of_type_Float - f3 - 10.0F) && (paramFloat1 <= parambppp.jdField_l_of_type_Float + parambppp.jdField_j_of_type_Float + f3 + 10.0F) && (paramFloat2 >= parambppp.jdField_m_of_type_Float + parambppp.k - f3 - 10.0F) && (paramFloat2 <= parambppp.jdField_m_of_type_Float + parambppp.k + f3 + 10.0F);
    }
    paramFloat1 = a(parambppp);
    float f1 = parambppp.u;
    paramFloat2 = parambppp.v;
    f1 += parambppp.jdField_j_of_type_Int / paramFloat1 * 2.0F;
    float f2 = parambppp.jdField_j_of_type_Int / paramFloat1 * 2.0F + paramFloat2;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambppp.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambppp.q;
      }
      paramFloat2 = paramFloat1;
      if (parambppp.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambppp.q;
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
    this.jdField_a_of_type_Bppp.jdField_m_of_type_Boolean = false;
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
    this.i = this.jdField_a_of_type_Bppp.s;
    this.jdField_j_of_type_Float = this.jdField_a_of_type_Bppp.t;
    this.jdField_a_of_type_Bppp.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bppp.jdField_m_of_type_Boolean = false;
    if ((b(this.jdField_a_of_type_Bppp, f2, f1)) && (paramBoolean))
    {
      this.jdField_f_of_type_Int = 3;
      this.k = this.jdField_a_of_type_Bppp.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bppp.r;
      f2 = f2 - this.jdField_a_of_type_Bppp.b.x - this.jdField_a_of_type_Bppp.s;
      f1 = f1 - this.jdField_a_of_type_Bppp.b.y - this.jdField_a_of_type_Bppp.t;
      this.jdField_c_of_type_Float = bppq.a(f2, f1);
      this.jdField_d_of_type_Float = bppq.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Bppp.b.x;
      this.jdField_f_of_type_Float = this.jdField_a_of_type_Bppp.b.y;
    }
    do
    {
      do
      {
        return;
      } while (!c(this.jdField_a_of_type_Bppp, f2, f1));
      if ((this.jdField_a_of_type_Bppp.g) && (!this.jdField_a_of_type_Bppp.h))
      {
        this.jdField_a_of_type_Bppp.h = true;
        a(this.jdField_a_of_type_Bppp, true);
      }
    } while ((!this.jdField_a_of_type_Bppp.g) || (!this.jdField_a_of_type_Bppp.h));
    this.jdField_f_of_type_Int = 4;
    this.g = this.jdField_a_of_type_Bppp.jdField_j_of_type_Float;
    this.h = this.jdField_a_of_type_Bppp.k;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bppp.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bppp.jdField_m_of_type_Boolean = false;
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
          this.jdField_a_of_type_Bppp.jdField_l_of_type_Boolean = true;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_f_of_type_Int == 1))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
              this.i = this.jdField_a_of_type_Bppp.s;
              this.jdField_j_of_type_Float = this.jdField_a_of_type_Bppp.t;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.jdField_a_of_type_Float;
            f3 = paramMotionEvent.getY(0);
            f4 = this.jdField_b_of_type_Float;
            this.jdField_a_of_type_Bppp.s = (f1 - f2 + this.i);
            this.jdField_a_of_type_Bppp.t = (f3 - f4 + this.jdField_j_of_type_Float);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_f_of_type_Int != 2)) {
            break label402;
          }
          f4 = bppq.a(paramMotionEvent);
          f1 = bppq.b(paramMotionEvent);
          paramMotionEvent = bppq.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.jdField_a_of_type_Bppp;
          float f5 = this.k;
          paramMotionEvent.q = (f4 / this.jdField_c_of_type_Float * f5);
          paramMotionEvent = this.jdField_a_of_type_Bppp;
          f4 = this.jdField_l_of_type_Float;
          paramMotionEvent.r = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
          this.jdField_a_of_type_Bppp.s = (this.i + (f2 - this.jdField_e_of_type_Float));
          this.jdField_a_of_type_Bppp.t = (this.jdField_j_of_type_Float + (f3 - this.jdField_f_of_type_Float));
          if (!this.jdField_a_of_type_Bppp.i) {
            break;
          }
          if (this.jdField_a_of_type_Bppp.q > this.jdField_m_of_type_Float) {
            this.jdField_a_of_type_Bppp.q = this.jdField_m_of_type_Float;
          }
          if (this.jdField_a_of_type_Bppp.q < this.n) {
            this.jdField_a_of_type_Bppp.q = this.n;
          }
        } while (this.jdField_a_of_type_Bppp.r >= 0.0F);
        this.jdField_a_of_type_Bppp.r += 360.0F;
        return;
        this.jdField_a_of_type_Bppp.q = this.k;
        this.jdField_a_of_type_Bppp.r = this.jdField_l_of_type_Float;
        return;
        if ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 3) || (!paramBoolean)) {
          break label654;
        }
        f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Bppp.b.x - this.jdField_a_of_type_Bppp.s;
        f3 = paramMotionEvent.getY() - this.jdField_a_of_type_Bppp.b.y - this.jdField_a_of_type_Bppp.t;
        f1 = bppq.a(f2, f3);
        f2 = bppq.b(f2, f3);
        paramMotionEvent = this.jdField_a_of_type_Bppp;
        f3 = this.k;
        paramMotionEvent.q = (f1 / this.jdField_c_of_type_Float * f3);
        paramMotionEvent = this.jdField_a_of_type_Bppp;
        f1 = this.jdField_l_of_type_Float;
        paramMotionEvent.r = ((f2 - this.jdField_d_of_type_Float + f1) % 360.0F);
        if (!this.jdField_a_of_type_Bppp.i) {
          break;
        }
        if (this.jdField_a_of_type_Bppp.q > this.jdField_m_of_type_Float) {
          this.jdField_a_of_type_Bppp.q = this.jdField_m_of_type_Float;
        }
        if (this.jdField_a_of_type_Bppp.q < this.n) {
          this.jdField_a_of_type_Bppp.q = this.n;
        }
      } while (this.jdField_a_of_type_Bppp.r >= 0.0F);
      this.jdField_a_of_type_Bppp.r += 360.0F;
      return;
      this.jdField_a_of_type_Bppp.q = this.k;
      this.jdField_a_of_type_Bppp.r = this.jdField_l_of_type_Float;
      return;
    } while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 4));
    label654:
    float f1 = paramMotionEvent.getX(0);
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getY(0);
    float f4 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Bppp.jdField_j_of_type_Float = (f1 - f2 + this.g);
    this.jdField_a_of_type_Bppp.k = (f3 - f4 + this.h);
  }
  
  public float a(bppp parambppp)
  {
    float f1 = 1.0F;
    if (parambppp != null) {
      f1 = parambppp.q * parambppp.w;
    }
    return f1;
  }
  
  public int a(bpif parambpif, float paramFloat1, float paramFloat2)
  {
    if (parambpif == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambpif).mapPoints(arrayOfFloat);
    float f1 = parambpif.u;
    float f2 = parambpif.v;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambpif.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambpif.q;
      }
      paramFloat2 = paramFloat1;
      if (parambpif.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambpif.q;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      return parambpif.a.a(f1, paramFloat1, arrayOfFloat[0], arrayOfFloat[1]);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public Matrix a(bppp parambppp)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambppp == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambppp.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(parambppp), a(parambppp));
    if (parambppp.b != null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambppp.b.x, parambppp.b.y);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambppp.s, parambppp.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public bppp a()
  {
    return this.jdField_a_of_type_Bppp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bppp = null;
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
    if (this.jdField_a_of_type_Bppp == null) {
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
  
  public void a(bppp parambppp)
  {
    a();
    this.jdField_a_of_type_Bppp = parambppp;
  }
  
  public void a(bppp parambppp, boolean paramBoolean)
  {
    float f4 = parambppp.u;
    float f3 = parambppp.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambppp.jdField_j_of_type_Int * 2;
      f2 = f3 + parambppp.jdField_j_of_type_Int * 2;
    }
    f4 = f2;
    float f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambppp.q * f1 < 200.0F) {
        f3 = 200.0F / parambppp.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambppp.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambppp.q;
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
    a(parambppp).mapPoints(arrayOfFloat);
    parambppp.jdField_l_of_type_Float = arrayOfFloat[0];
    parambppp.jdField_m_of_type_Float = arrayOfFloat[1];
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(bppp parambppp, float paramFloat1, float paramFloat2)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambppp).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambppp);
      f2 = parambppp.u;
      float f3 = parambppp.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambppp.v;
      float f1 = parambppp.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bppm.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean a(bppp parambppp, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parambppp == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambppp).mapPoints(arrayOfFloat);
    float f5 = a(parambppp);
    float f4 = parambppp.u;
    float f3 = parambppp.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambppp.jdField_j_of_type_Int / f5 * 2.0F;
      f2 = f3 + parambppp.jdField_j_of_type_Int / f5 * 2.0F;
    }
    f4 = f2;
    f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambppp.q * f1 < 200.0F) {
        f3 = 200.0F / parambppp.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambppp.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambppp.q;
        f5 = f3;
      }
    }
    f1 = f5 / 2.0F;
    f2 = f4 / 2.0F;
    f3 = -f1;
    f4 = -f2;
    f5 = bppm.a() / a(parambppp) / 2.0F;
    float f6 = parambppp.jdField_j_of_type_Float / a(parambppp);
    f6 = parambppp.k / a(parambppp);
    parambppp.e = false;
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= f1) && (arrayOfFloat[1] >= f4) && (arrayOfFloat[1] <= f2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((parambppp.d) && (arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F))
    {
      parambppp.e = true;
      return true;
    }
    if (a(parambppp, paramFloat1, paramFloat2, arrayOfFloat[0], arrayOfFloat[1], paramBoolean))
    {
      parambppp.e = true;
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f3 - f5) && (arrayOfFloat[0] <= f1 + f5) && (arrayOfFloat[1] >= f4 - f5) && (arrayOfFloat[1] <= f2 + f5);
  }
  
  public boolean a(bppp parambppp, float paramFloat, boolean paramBoolean)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambppp.u;
        float f1 = parambppp.v / 2.0F;
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
        parambppp = a(parambppp);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambppp;
        parambppp.mapPoints(arrayOfFloat1);
        parambppp.mapPoints(arrayOfFloat2);
        parambppp.mapPoints(arrayOfFloat3);
        parambppp.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambppp = new StringBuilder();
          parambppp.append("isCloseToXLine x=").append(paramFloat).append(" leftReach=").append(paramBoolean).append("\n");
          parambppp.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambppp.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambppp.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambppp.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambppp.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[0] > paramFloat) && (arrayOfFloat2[0] > paramFloat) && (arrayOfFloat3[0] > paramFloat) && (arrayOfFloat4[0] > paramFloat));
      return true;
    } while ((arrayOfFloat1[0] < paramFloat) && (arrayOfFloat2[0] < paramFloat) && (arrayOfFloat3[0] < paramFloat) && (arrayOfFloat4[0] < paramFloat));
    return true;
  }
  
  public Matrix b(bppp parambppp)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambppp == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambppp.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambppp.b.x, parambppp.b.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambppp.s, parambppp.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.n = paramFloat;
    }
  }
  
  public void b(bppp parambppp)
  {
    if ((parambppp == null) || (parambppp.a == null)) {
      return;
    }
    Matrix localMatrix = c(parambppp);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat3 = new float[2];
    float[] arrayOfFloat4 = new float[2];
    float f4 = 0.0F;
    arrayOfFloat1[0] = bpik.jdField_a_of_type_Int;
    arrayOfFloat1[1] = bpik.jdField_c_of_type_Int;
    arrayOfFloat2[0] = bpik.jdField_a_of_type_Int;
    arrayOfFloat2[1] = bpik.jdField_d_of_type_Int;
    arrayOfFloat3[0] = bpik.jdField_b_of_type_Int;
    arrayOfFloat3[1] = bpik.jdField_c_of_type_Int;
    arrayOfFloat4[0] = bpik.jdField_b_of_type_Int;
    arrayOfFloat4[1] = bpik.jdField_d_of_type_Int;
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
      if ((i1 != 0) && (arrayOfFloat2[0] <= parambppp.jdField_m_of_type_Int - parambppp.u / 2.0F) && (arrayOfFloat2[0] >= parambppp.jdField_l_of_type_Int - parambppp.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
      }
      if ((i2 != 0) && (arrayOfFloat3[0] <= parambppp.jdField_m_of_type_Int - parambppp.u / 2.0F) && (arrayOfFloat3[0] >= parambppp.jdField_l_of_type_Int - parambppp.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
      }
      if ((i3 != 0) && (arrayOfFloat1[0] <= parambppp.jdField_m_of_type_Int - parambppp.u / 2.0F) && (arrayOfFloat1[0] >= parambppp.jdField_l_of_type_Int - parambppp.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, TOP");
      }
      if ((i4 != 0) && (arrayOfFloat2[0] <= parambppp.jdField_m_of_type_Int - parambppp.u / 2.0F) && (arrayOfFloat2[0] >= parambppp.jdField_l_of_type_Int - parambppp.u / 2.0F)) {
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
            if (i5 >= parambppp.u) {
              break label881;
            }
            float f5 = parambppp.a[(i5 * 2)];
            float f6 = parambppp.a[(i5 * 2 + 1)];
            int i6;
            if (i1 == 0)
            {
              i6 = (int)((i5 - parambppp.u / 2.0F - arrayOfFloat1[0]) * f1 + arrayOfFloat1[1]);
              if ((i6 >= f5 - parambppp.v / 2.0F) && (i6 <= f6 - parambppp.v / 2.0F))
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
              i6 = (int)((i5 - parambppp.u / 2.0F - arrayOfFloat3[0]) * f2 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambppp.v / 2.0F) && (i6 <= f6 - parambppp.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
                return;
              }
            }
            if (i3 == 0)
            {
              i6 = (int)((i5 - parambppp.u / 2.0F - arrayOfFloat3[0]) * f3 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambppp.v / 2.0F) && (i6 <= f6 - parambppp.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, TOP");
                return;
              }
            }
            if (i4 == 0)
            {
              i6 = (int)((i5 - parambppp.u / 2.0F - arrayOfFloat4[0]) * f4 + arrayOfFloat4[1]);
              if ((i6 >= f5 - parambppp.v / 2.0F) && (i6 <= f6 - parambppp.v / 2.0F))
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
  
  public boolean b(bppp parambppp, float paramFloat1, float paramFloat2)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambppp).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambppp);
      f2 = parambppp.u;
      float f3 = parambppp.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambppp.v;
      float f1 = parambppp.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bppm.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean b(bppp parambppp, float paramFloat, boolean paramBoolean)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambppp.u;
        float f1 = parambppp.v / 2.0F;
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
        parambppp = a(parambppp);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambppp;
        parambppp.mapPoints(arrayOfFloat1);
        parambppp.mapPoints(arrayOfFloat2);
        parambppp.mapPoints(arrayOfFloat3);
        parambppp.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambppp = new StringBuilder();
          parambppp.append("isCloseToYLine y=").append(paramFloat).append(" topReach=").append(paramBoolean).append("\n");
          parambppp.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambppp.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambppp.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambppp.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambppp.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[1] > paramFloat) && (arrayOfFloat2[1] > paramFloat) && (arrayOfFloat3[1] > paramFloat) && (arrayOfFloat4[1] > paramFloat));
      return true;
    } while ((arrayOfFloat1[1] < paramFloat) && (arrayOfFloat2[1] < paramFloat) && (arrayOfFloat3[1] < paramFloat) && (arrayOfFloat4[1] < paramFloat));
    return true;
  }
  
  public Matrix c(bppp parambppp)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (parambppp == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(parambppp);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public boolean c(bppp parambppp, float paramFloat1, float paramFloat2)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      if ((!parambppp.g) || (!parambppp.h)) {
        break;
      }
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      paramFloat1 = bppm.a() / 2.0F;
    } while ((arrayOfFloat[0] < parambppp.jdField_l_of_type_Float + parambppp.jdField_j_of_type_Float - paramFloat1 - 10.0F) || (arrayOfFloat[0] > parambppp.jdField_l_of_type_Float + parambppp.jdField_j_of_type_Float + paramFloat1 + 10.0F) || (arrayOfFloat[1] < parambppp.jdField_m_of_type_Float + parambppp.k - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + (parambppp.jdField_m_of_type_Float + parambppp.k) + 10.0F));
    return true;
    return d(parambppp, paramFloat1, paramFloat2);
  }
  
  public boolean d(bppp parambppp, float paramFloat1, float paramFloat2)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambppp).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambppp);
      f2 = parambppp.u;
      float f3 = parambppp.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambppp.v;
      float f1 = parambppp.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bppm.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean e(bppp parambppp, float paramFloat1, float paramFloat2)
  {
    if (parambppp == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambppp).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambppp);
      f2 = parambppp.u;
      float f3 = parambppp.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambppp.v;
      float f1 = parambppp.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bppm.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppo
 * JD-Core Version:    0.7.0.1
 */