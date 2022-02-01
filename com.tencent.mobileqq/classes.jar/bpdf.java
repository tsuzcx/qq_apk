import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;

public class bpdf
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private bpdg jdField_a_of_type_Bpdg;
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
  
  public bpdf()
  {
    this.jdField_m_of_type_Float = 2.147484E+009F;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    this.jdField_a_of_type_Bpdg.jdField_m_of_type_Boolean = true;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 3))
    {
      this.jdField_f_of_type_Int = 2;
      this.k = this.jdField_a_of_type_Bpdg.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bpdg.r;
      this.i = this.jdField_a_of_type_Bpdg.s;
      this.jdField_j_of_type_Float = this.jdField_a_of_type_Bpdg.t;
      this.jdField_c_of_type_Float = bpdh.a(paramMotionEvent);
      this.jdField_d_of_type_Float = bpdh.b(paramMotionEvent);
      paramMotionEvent = bpdh.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.jdField_f_of_type_Float = paramMotionEvent[1];
    }
  }
  
  private boolean a(bpdg parambpdg, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!parambpdg.d) {
      return false;
    }
    float f3 = bpdd.a() / 2.0F;
    if ((parambpdg.g) && (parambpdg.h)) {
      return (paramFloat1 >= parambpdg.jdField_l_of_type_Float + parambpdg.jdField_j_of_type_Float - f3 - 10.0F) && (paramFloat1 <= parambpdg.jdField_l_of_type_Float + parambpdg.jdField_j_of_type_Float + f3 + 10.0F) && (paramFloat2 >= parambpdg.jdField_m_of_type_Float + parambpdg.k - f3 - 10.0F) && (paramFloat2 <= parambpdg.jdField_m_of_type_Float + parambpdg.k + f3 + 10.0F);
    }
    paramFloat1 = a(parambpdg);
    float f1 = parambpdg.u;
    paramFloat2 = parambpdg.v;
    f1 += parambpdg.jdField_j_of_type_Int / paramFloat1 * 2.0F;
    float f2 = parambpdg.jdField_j_of_type_Int / paramFloat1 * 2.0F + paramFloat2;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambpdg.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambpdg.q;
      }
      paramFloat2 = paramFloat1;
      if (parambpdg.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambpdg.q;
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
    this.jdField_a_of_type_Bpdg.jdField_m_of_type_Boolean = false;
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
    this.i = this.jdField_a_of_type_Bpdg.s;
    this.jdField_j_of_type_Float = this.jdField_a_of_type_Bpdg.t;
    this.jdField_a_of_type_Bpdg.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bpdg.jdField_m_of_type_Boolean = false;
    if ((b(this.jdField_a_of_type_Bpdg, f2, f1)) && (paramBoolean))
    {
      this.jdField_f_of_type_Int = 3;
      this.k = this.jdField_a_of_type_Bpdg.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bpdg.r;
      f2 = f2 - this.jdField_a_of_type_Bpdg.a.x - this.jdField_a_of_type_Bpdg.s;
      f1 = f1 - this.jdField_a_of_type_Bpdg.a.y - this.jdField_a_of_type_Bpdg.t;
      this.jdField_c_of_type_Float = bpdh.a(f2, f1);
      this.jdField_d_of_type_Float = bpdh.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Bpdg.a.x;
      this.jdField_f_of_type_Float = this.jdField_a_of_type_Bpdg.a.y;
    }
    do
    {
      do
      {
        return;
      } while (!c(this.jdField_a_of_type_Bpdg, f2, f1));
      if ((this.jdField_a_of_type_Bpdg.g) && (!this.jdField_a_of_type_Bpdg.h))
      {
        this.jdField_a_of_type_Bpdg.h = true;
        a(this.jdField_a_of_type_Bpdg, true);
      }
    } while ((!this.jdField_a_of_type_Bpdg.g) || (!this.jdField_a_of_type_Bpdg.h));
    this.jdField_f_of_type_Int = 4;
    this.g = this.jdField_a_of_type_Bpdg.jdField_j_of_type_Float;
    this.h = this.jdField_a_of_type_Bpdg.k;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bpdg.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bpdg.jdField_m_of_type_Boolean = false;
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
          this.jdField_a_of_type_Bpdg.jdField_l_of_type_Boolean = true;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_f_of_type_Int == 1))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
              this.i = this.jdField_a_of_type_Bpdg.s;
              this.jdField_j_of_type_Float = this.jdField_a_of_type_Bpdg.t;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.jdField_a_of_type_Float;
            f3 = paramMotionEvent.getY(0);
            f4 = this.jdField_b_of_type_Float;
            this.jdField_a_of_type_Bpdg.s = (f1 - f2 + this.i);
            this.jdField_a_of_type_Bpdg.t = (f3 - f4 + this.jdField_j_of_type_Float);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_f_of_type_Int != 2)) {
            break label402;
          }
          f4 = bpdh.a(paramMotionEvent);
          f1 = bpdh.b(paramMotionEvent);
          paramMotionEvent = bpdh.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.jdField_a_of_type_Bpdg;
          float f5 = this.k;
          paramMotionEvent.q = (f4 / this.jdField_c_of_type_Float * f5);
          paramMotionEvent = this.jdField_a_of_type_Bpdg;
          f4 = this.jdField_l_of_type_Float;
          paramMotionEvent.r = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
          this.jdField_a_of_type_Bpdg.s = (this.i + (f2 - this.jdField_e_of_type_Float));
          this.jdField_a_of_type_Bpdg.t = (this.jdField_j_of_type_Float + (f3 - this.jdField_f_of_type_Float));
          if (!this.jdField_a_of_type_Bpdg.i) {
            break;
          }
          if (this.jdField_a_of_type_Bpdg.q > this.jdField_m_of_type_Float) {
            this.jdField_a_of_type_Bpdg.q = this.jdField_m_of_type_Float;
          }
          if (this.jdField_a_of_type_Bpdg.q < this.n) {
            this.jdField_a_of_type_Bpdg.q = this.n;
          }
        } while (this.jdField_a_of_type_Bpdg.r >= 0.0F);
        this.jdField_a_of_type_Bpdg.r += 360.0F;
        return;
        this.jdField_a_of_type_Bpdg.q = this.k;
        this.jdField_a_of_type_Bpdg.r = this.jdField_l_of_type_Float;
        return;
        if ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 3) || (!paramBoolean)) {
          break label654;
        }
        f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Bpdg.a.x - this.jdField_a_of_type_Bpdg.s;
        f3 = paramMotionEvent.getY() - this.jdField_a_of_type_Bpdg.a.y - this.jdField_a_of_type_Bpdg.t;
        f1 = bpdh.a(f2, f3);
        f2 = bpdh.b(f2, f3);
        paramMotionEvent = this.jdField_a_of_type_Bpdg;
        f3 = this.k;
        paramMotionEvent.q = (f1 / this.jdField_c_of_type_Float * f3);
        paramMotionEvent = this.jdField_a_of_type_Bpdg;
        f1 = this.jdField_l_of_type_Float;
        paramMotionEvent.r = ((f2 - this.jdField_d_of_type_Float + f1) % 360.0F);
        if (!this.jdField_a_of_type_Bpdg.i) {
          break;
        }
        if (this.jdField_a_of_type_Bpdg.q > this.jdField_m_of_type_Float) {
          this.jdField_a_of_type_Bpdg.q = this.jdField_m_of_type_Float;
        }
        if (this.jdField_a_of_type_Bpdg.q < this.n) {
          this.jdField_a_of_type_Bpdg.q = this.n;
        }
      } while (this.jdField_a_of_type_Bpdg.r >= 0.0F);
      this.jdField_a_of_type_Bpdg.r += 360.0F;
      return;
      this.jdField_a_of_type_Bpdg.q = this.k;
      this.jdField_a_of_type_Bpdg.r = this.jdField_l_of_type_Float;
      return;
    } while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 4));
    label654:
    float f1 = paramMotionEvent.getX(0);
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getY(0);
    float f4 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Bpdg.jdField_j_of_type_Float = (f1 - f2 + this.g);
    this.jdField_a_of_type_Bpdg.k = (f3 - f4 + this.h);
  }
  
  public float a(bpdg parambpdg)
  {
    float f1 = 1.0F;
    if (parambpdg != null) {
      f1 = parambpdg.q * parambpdg.w;
    }
    return f1;
  }
  
  public int a(bowi parambowi, float paramFloat1, float paramFloat2)
  {
    if (parambowi == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambowi).mapPoints(arrayOfFloat);
    float f1 = parambowi.u;
    float f2 = parambowi.v;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambowi.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambowi.q;
      }
      paramFloat2 = paramFloat1;
      if (parambowi.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambowi.q;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      return parambowi.a.a(f1, paramFloat1, arrayOfFloat[0], arrayOfFloat[1]);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public Matrix a(bpdg parambpdg)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambpdg == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambpdg.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(parambpdg), a(parambpdg));
    if (parambpdg.a != null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambpdg.a.x, parambpdg.a.y);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambpdg.s, parambpdg.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bpdg = null;
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
    if (this.jdField_a_of_type_Bpdg == null) {
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
  
  public void a(bpdg parambpdg)
  {
    a();
    this.jdField_a_of_type_Bpdg = parambpdg;
  }
  
  public void a(bpdg parambpdg, boolean paramBoolean)
  {
    float f4 = parambpdg.u;
    float f3 = parambpdg.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambpdg.jdField_j_of_type_Int * 2;
      f2 = f3 + parambpdg.jdField_j_of_type_Int * 2;
    }
    f4 = f2;
    float f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambpdg.q * f1 < 200.0F) {
        f3 = 200.0F / parambpdg.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambpdg.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambpdg.q;
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
    a(parambpdg).mapPoints(arrayOfFloat);
    parambpdg.jdField_l_of_type_Float = arrayOfFloat[0];
    parambpdg.jdField_m_of_type_Float = arrayOfFloat[1];
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(bpdg parambpdg, float paramFloat1, float paramFloat2)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambpdg).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambpdg);
      f2 = parambpdg.u;
      float f3 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambpdg.v;
      float f1 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bpdd.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean a(bpdg parambpdg, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parambpdg == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambpdg).mapPoints(arrayOfFloat);
    float f5 = a(parambpdg);
    float f4 = parambpdg.u;
    float f3 = parambpdg.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambpdg.jdField_j_of_type_Int / f5 * 2.0F;
      f2 = f3 + parambpdg.jdField_j_of_type_Int / f5 * 2.0F;
    }
    f4 = f2;
    f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambpdg.q * f1 < 200.0F) {
        f3 = 200.0F / parambpdg.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambpdg.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambpdg.q;
        f5 = f3;
      }
    }
    f1 = f5 / 2.0F;
    f2 = f4 / 2.0F;
    f3 = -f1;
    f4 = -f2;
    f5 = bpdd.a() / a(parambpdg) / 2.0F;
    float f6 = parambpdg.jdField_j_of_type_Float / a(parambpdg);
    f6 = parambpdg.k / a(parambpdg);
    parambpdg.e = false;
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= f1) && (arrayOfFloat[1] >= f4) && (arrayOfFloat[1] <= f2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((parambpdg.d) && (arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F))
    {
      parambpdg.e = true;
      return true;
    }
    if (a(parambpdg, paramFloat1, paramFloat2, arrayOfFloat[0], arrayOfFloat[1], paramBoolean))
    {
      parambpdg.e = true;
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f3 - f5) && (arrayOfFloat[0] <= f1 + f5) && (arrayOfFloat[1] >= f4 - f5) && (arrayOfFloat[1] <= f2 + f5);
  }
  
  public boolean a(bpdg parambpdg, float paramFloat, boolean paramBoolean)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambpdg.u;
        float f1 = parambpdg.v / 2.0F;
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
        parambpdg = a(parambpdg);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambpdg;
        parambpdg.mapPoints(arrayOfFloat1);
        parambpdg.mapPoints(arrayOfFloat2);
        parambpdg.mapPoints(arrayOfFloat3);
        parambpdg.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambpdg = new StringBuilder();
          parambpdg.append("isCloseToXLine x=").append(paramFloat).append(" leftReach=").append(paramBoolean).append("\n");
          parambpdg.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambpdg.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambpdg.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambpdg.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambpdg.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[0] > paramFloat) && (arrayOfFloat2[0] > paramFloat) && (arrayOfFloat3[0] > paramFloat) && (arrayOfFloat4[0] > paramFloat));
      return true;
    } while ((arrayOfFloat1[0] < paramFloat) && (arrayOfFloat2[0] < paramFloat) && (arrayOfFloat3[0] < paramFloat) && (arrayOfFloat4[0] < paramFloat));
    return true;
  }
  
  public Matrix b(bpdg parambpdg)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambpdg == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambpdg.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambpdg.a.x, parambpdg.a.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambpdg.s, parambpdg.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.n = paramFloat;
    }
  }
  
  public boolean b(bpdg parambpdg, float paramFloat1, float paramFloat2)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambpdg).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambpdg);
      f2 = parambpdg.u;
      float f3 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambpdg.v;
      float f1 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bpdd.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean b(bpdg parambpdg, float paramFloat, boolean paramBoolean)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambpdg.u;
        float f1 = parambpdg.v / 2.0F;
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
        parambpdg = a(parambpdg);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambpdg;
        parambpdg.mapPoints(arrayOfFloat1);
        parambpdg.mapPoints(arrayOfFloat2);
        parambpdg.mapPoints(arrayOfFloat3);
        parambpdg.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambpdg = new StringBuilder();
          parambpdg.append("isCloseToYLine y=").append(paramFloat).append(" topReach=").append(paramBoolean).append("\n");
          parambpdg.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambpdg.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambpdg.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambpdg.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambpdg.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[1] > paramFloat) && (arrayOfFloat2[1] > paramFloat) && (arrayOfFloat3[1] > paramFloat) && (arrayOfFloat4[1] > paramFloat));
      return true;
    } while ((arrayOfFloat1[1] < paramFloat) && (arrayOfFloat2[1] < paramFloat) && (arrayOfFloat3[1] < paramFloat) && (arrayOfFloat4[1] < paramFloat));
    return true;
  }
  
  public Matrix c(bpdg parambpdg)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (parambpdg == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(parambpdg);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public boolean c(bpdg parambpdg, float paramFloat1, float paramFloat2)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      if ((!parambpdg.g) || (!parambpdg.h)) {
        break;
      }
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      paramFloat1 = bpdd.a() / 2.0F;
    } while ((arrayOfFloat[0] < parambpdg.jdField_l_of_type_Float + parambpdg.jdField_j_of_type_Float - paramFloat1 - 10.0F) || (arrayOfFloat[0] > parambpdg.jdField_l_of_type_Float + parambpdg.jdField_j_of_type_Float + paramFloat1 + 10.0F) || (arrayOfFloat[1] < parambpdg.jdField_m_of_type_Float + parambpdg.k - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + (parambpdg.jdField_m_of_type_Float + parambpdg.k) + 10.0F));
    return true;
    return d(parambpdg, paramFloat1, paramFloat2);
  }
  
  public boolean d(bpdg parambpdg, float paramFloat1, float paramFloat2)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambpdg).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambpdg);
      f2 = parambpdg.u;
      float f3 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambpdg.v;
      float f1 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bpdd.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean e(bpdg parambpdg, float paramFloat1, float paramFloat2)
  {
    if (parambpdg == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambpdg).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambpdg);
      f2 = parambpdg.u;
      float f3 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambpdg.v;
      float f1 = parambpdg.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bpdd.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdf
 * JD-Core Version:    0.7.0.1
 */