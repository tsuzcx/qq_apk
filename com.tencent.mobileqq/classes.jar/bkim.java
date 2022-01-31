import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;

public class bkim
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private bkin jdField_a_of_type_Bkin;
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
  
  public bkim()
  {
    this.jdField_m_of_type_Float = 2.147484E+009F;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    this.jdField_a_of_type_Bkin.jdField_m_of_type_Boolean = true;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 3))
    {
      this.jdField_f_of_type_Int = 2;
      this.k = this.jdField_a_of_type_Bkin.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bkin.r;
      this.i = this.jdField_a_of_type_Bkin.s;
      this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkin.t;
      this.jdField_c_of_type_Float = bkio.a(paramMotionEvent);
      this.jdField_d_of_type_Float = bkio.b(paramMotionEvent);
      paramMotionEvent = bkio.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.jdField_f_of_type_Float = paramMotionEvent[1];
    }
  }
  
  private boolean a(bkin parambkin, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!parambkin.d) {
      return false;
    }
    float f3 = bkik.a() / 2.0F;
    if ((parambkin.g) && (parambkin.h)) {
      return (paramFloat1 >= parambkin.jdField_l_of_type_Float + parambkin.jdField_j_of_type_Float - f3 - 10.0F) && (paramFloat1 <= parambkin.jdField_l_of_type_Float + parambkin.jdField_j_of_type_Float + f3 + 10.0F) && (paramFloat2 >= parambkin.jdField_m_of_type_Float + parambkin.k - f3 - 10.0F) && (paramFloat2 <= parambkin.jdField_m_of_type_Float + parambkin.k + f3 + 10.0F);
    }
    paramFloat1 = a(parambkin);
    float f1 = parambkin.u;
    paramFloat2 = parambkin.v;
    f1 += parambkin.jdField_j_of_type_Int / paramFloat1 * 2.0F;
    float f2 = parambkin.jdField_j_of_type_Int / paramFloat1 * 2.0F + paramFloat2;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambkin.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambkin.q;
      }
      paramFloat2 = paramFloat1;
      if (parambkin.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambkin.q;
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
    this.jdField_a_of_type_Bkin.jdField_m_of_type_Boolean = false;
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
    this.i = this.jdField_a_of_type_Bkin.s;
    this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkin.t;
    this.jdField_a_of_type_Bkin.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bkin.jdField_m_of_type_Boolean = false;
    if ((b(this.jdField_a_of_type_Bkin, f2, f1)) && (paramBoolean))
    {
      this.jdField_f_of_type_Int = 3;
      this.k = this.jdField_a_of_type_Bkin.q;
      this.jdField_l_of_type_Float = this.jdField_a_of_type_Bkin.r;
      f2 = f2 - this.jdField_a_of_type_Bkin.b.x - this.jdField_a_of_type_Bkin.s;
      f1 = f1 - this.jdField_a_of_type_Bkin.b.y - this.jdField_a_of_type_Bkin.t;
      this.jdField_c_of_type_Float = bkio.a(f2, f1);
      this.jdField_d_of_type_Float = bkio.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Bkin.b.x;
      this.jdField_f_of_type_Float = this.jdField_a_of_type_Bkin.b.y;
    }
    do
    {
      do
      {
        return;
      } while (!c(this.jdField_a_of_type_Bkin, f2, f1));
      if ((this.jdField_a_of_type_Bkin.g) && (!this.jdField_a_of_type_Bkin.h))
      {
        this.jdField_a_of_type_Bkin.h = true;
        a(this.jdField_a_of_type_Bkin, true);
      }
    } while ((!this.jdField_a_of_type_Bkin.g) || (!this.jdField_a_of_type_Bkin.h));
    this.jdField_f_of_type_Int = 4;
    this.g = this.jdField_a_of_type_Bkin.jdField_j_of_type_Float;
    this.h = this.jdField_a_of_type_Bkin.k;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bkin.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Bkin.jdField_m_of_type_Boolean = false;
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
          this.jdField_a_of_type_Bkin.jdField_l_of_type_Boolean = true;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_f_of_type_Int == 1))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
              this.i = this.jdField_a_of_type_Bkin.s;
              this.jdField_j_of_type_Float = this.jdField_a_of_type_Bkin.t;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.jdField_a_of_type_Float;
            f3 = paramMotionEvent.getY(0);
            f4 = this.jdField_b_of_type_Float;
            this.jdField_a_of_type_Bkin.s = (f1 - f2 + this.i);
            this.jdField_a_of_type_Bkin.t = (f3 - f4 + this.jdField_j_of_type_Float);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_f_of_type_Int != 2)) {
            break label402;
          }
          f4 = bkio.a(paramMotionEvent);
          f1 = bkio.b(paramMotionEvent);
          paramMotionEvent = bkio.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.jdField_a_of_type_Bkin;
          float f5 = this.k;
          paramMotionEvent.q = (f4 / this.jdField_c_of_type_Float * f5);
          paramMotionEvent = this.jdField_a_of_type_Bkin;
          f4 = this.jdField_l_of_type_Float;
          paramMotionEvent.r = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
          this.jdField_a_of_type_Bkin.s = (this.i + (f2 - this.jdField_e_of_type_Float));
          this.jdField_a_of_type_Bkin.t = (this.jdField_j_of_type_Float + (f3 - this.jdField_f_of_type_Float));
          if (!this.jdField_a_of_type_Bkin.i) {
            break;
          }
          if (this.jdField_a_of_type_Bkin.q > this.jdField_m_of_type_Float) {
            this.jdField_a_of_type_Bkin.q = this.jdField_m_of_type_Float;
          }
          if (this.jdField_a_of_type_Bkin.q < this.n) {
            this.jdField_a_of_type_Bkin.q = this.n;
          }
        } while (this.jdField_a_of_type_Bkin.r >= 0.0F);
        this.jdField_a_of_type_Bkin.r += 360.0F;
        return;
        this.jdField_a_of_type_Bkin.q = this.k;
        this.jdField_a_of_type_Bkin.r = this.jdField_l_of_type_Float;
        return;
        if ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 3) || (!paramBoolean)) {
          break label654;
        }
        f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Bkin.b.x - this.jdField_a_of_type_Bkin.s;
        f3 = paramMotionEvent.getY() - this.jdField_a_of_type_Bkin.b.y - this.jdField_a_of_type_Bkin.t;
        f1 = bkio.a(f2, f3);
        f2 = bkio.b(f2, f3);
        paramMotionEvent = this.jdField_a_of_type_Bkin;
        f3 = this.k;
        paramMotionEvent.q = (f1 / this.jdField_c_of_type_Float * f3);
        paramMotionEvent = this.jdField_a_of_type_Bkin;
        f1 = this.jdField_l_of_type_Float;
        paramMotionEvent.r = ((f2 - this.jdField_d_of_type_Float + f1) % 360.0F);
        if (!this.jdField_a_of_type_Bkin.i) {
          break;
        }
        if (this.jdField_a_of_type_Bkin.q > this.jdField_m_of_type_Float) {
          this.jdField_a_of_type_Bkin.q = this.jdField_m_of_type_Float;
        }
        if (this.jdField_a_of_type_Bkin.q < this.n) {
          this.jdField_a_of_type_Bkin.q = this.n;
        }
      } while (this.jdField_a_of_type_Bkin.r >= 0.0F);
      this.jdField_a_of_type_Bkin.r += 360.0F;
      return;
      this.jdField_a_of_type_Bkin.q = this.k;
      this.jdField_a_of_type_Bkin.r = this.jdField_l_of_type_Float;
      return;
    } while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_f_of_type_Int != 4));
    label654:
    float f1 = paramMotionEvent.getX(0);
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getY(0);
    float f4 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Bkin.jdField_j_of_type_Float = (f1 - f2 + this.g);
    this.jdField_a_of_type_Bkin.k = (f3 - f4 + this.h);
  }
  
  public float a(bkin parambkin)
  {
    float f1 = 1.0F;
    if (parambkin != null) {
      f1 = parambkin.q * parambkin.w;
    }
    return f1;
  }
  
  public int a(bkbd parambkbd, float paramFloat1, float paramFloat2)
  {
    if (parambkbd == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambkbd).mapPoints(arrayOfFloat);
    float f1 = parambkbd.u;
    float f2 = parambkbd.v;
    paramFloat2 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = f1;
      if (parambkbd.q * f1 < 200.0F) {
        paramFloat1 = 200.0F / parambkbd.q;
      }
      paramFloat2 = paramFloat1;
      if (parambkbd.q * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parambkbd.q;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      return parambkbd.a.a(f1, paramFloat1, arrayOfFloat[0], arrayOfFloat[1]);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public Matrix a(bkin parambkin)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambkin == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambkin.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(parambkin), a(parambkin));
    if (parambkin.b != null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkin.b.x, parambkin.b.y);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkin.s, parambkin.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public bkin a()
  {
    return this.jdField_a_of_type_Bkin;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkin = null;
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
    if (this.jdField_a_of_type_Bkin == null) {
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
  
  public void a(bkin parambkin)
  {
    a();
    this.jdField_a_of_type_Bkin = parambkin;
  }
  
  public void a(bkin parambkin, boolean paramBoolean)
  {
    float f4 = parambkin.u;
    float f3 = parambkin.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambkin.jdField_j_of_type_Int * 2;
      f2 = f3 + parambkin.jdField_j_of_type_Int * 2;
    }
    f4 = f2;
    float f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambkin.q * f1 < 200.0F) {
        f3 = 200.0F / parambkin.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambkin.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambkin.q;
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
    a(parambkin).mapPoints(arrayOfFloat);
    parambkin.jdField_l_of_type_Float = arrayOfFloat[0];
    parambkin.jdField_m_of_type_Float = arrayOfFloat[1];
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(bkin parambkin, float paramFloat1, float paramFloat2)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkin).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkin);
      f2 = parambkin.u;
      float f3 = parambkin.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkin.v;
      float f1 = parambkin.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkik.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean a(bkin parambkin, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parambkin == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parambkin).mapPoints(arrayOfFloat);
    float f5 = a(parambkin);
    float f4 = parambkin.u;
    float f3 = parambkin.v;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parambkin.jdField_j_of_type_Int / f5 * 2.0F;
      f2 = f3 + parambkin.jdField_j_of_type_Int / f5 * 2.0F;
    }
    f4 = f2;
    f5 = f1;
    if (this.jdField_c_of_type_Boolean)
    {
      f3 = f1;
      if (parambkin.q * f1 < 200.0F) {
        f3 = 200.0F / parambkin.q;
      }
      f4 = f2;
      f5 = f3;
      if (parambkin.q * f2 < 200.0F)
      {
        f4 = 200.0F / parambkin.q;
        f5 = f3;
      }
    }
    f1 = f5 / 2.0F;
    f2 = f4 / 2.0F;
    f3 = -f1;
    f4 = -f2;
    f5 = bkik.a() / a(parambkin) / 2.0F;
    float f6 = parambkin.jdField_j_of_type_Float / a(parambkin);
    f6 = parambkin.k / a(parambkin);
    parambkin.e = false;
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= f1) && (arrayOfFloat[1] >= f4) && (arrayOfFloat[1] <= f2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((parambkin.d) && (arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F))
    {
      parambkin.e = true;
      return true;
    }
    if (a(parambkin, paramFloat1, paramFloat2, arrayOfFloat[0], arrayOfFloat[1], paramBoolean))
    {
      parambkin.e = true;
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f3 - f5) && (arrayOfFloat[0] <= f1 + f5) && (arrayOfFloat[1] >= f4 - f5) && (arrayOfFloat[1] <= f2 + f5);
  }
  
  public boolean a(bkin parambkin, float paramFloat, boolean paramBoolean)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambkin.u;
        float f1 = parambkin.v / 2.0F;
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
        parambkin = a(parambkin);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambkin;
        parambkin.mapPoints(arrayOfFloat1);
        parambkin.mapPoints(arrayOfFloat2);
        parambkin.mapPoints(arrayOfFloat3);
        parambkin.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambkin = new StringBuilder();
          parambkin.append("isCloseToXLine x=").append(paramFloat).append(" leftReach=").append(paramBoolean).append("\n");
          parambkin.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambkin.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambkin.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambkin.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambkin.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[0] > paramFloat) && (arrayOfFloat2[0] > paramFloat) && (arrayOfFloat3[0] > paramFloat) && (arrayOfFloat4[0] > paramFloat));
      return true;
    } while ((arrayOfFloat1[0] < paramFloat) && (arrayOfFloat2[0] < paramFloat) && (arrayOfFloat3[0] < paramFloat) && (arrayOfFloat4[0] < paramFloat));
    return true;
  }
  
  public Matrix b(bkin parambkin)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (parambkin == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(parambkin.r);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkin.b.x, parambkin.b.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(parambkin.s, parambkin.t);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.n = paramFloat;
    }
  }
  
  public void b(bkin parambkin)
  {
    if ((parambkin == null) || (parambkin.a == null)) {
      return;
    }
    Matrix localMatrix = c(parambkin);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat3 = new float[2];
    float[] arrayOfFloat4 = new float[2];
    float f4 = 0.0F;
    arrayOfFloat1[0] = bkbi.jdField_a_of_type_Int;
    arrayOfFloat1[1] = bkbi.jdField_c_of_type_Int;
    arrayOfFloat2[0] = bkbi.jdField_a_of_type_Int;
    arrayOfFloat2[1] = bkbi.jdField_d_of_type_Int;
    arrayOfFloat3[0] = bkbi.jdField_b_of_type_Int;
    arrayOfFloat3[1] = bkbi.jdField_c_of_type_Int;
    arrayOfFloat4[0] = bkbi.jdField_b_of_type_Int;
    arrayOfFloat4[1] = bkbi.jdField_d_of_type_Int;
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
      if ((i1 != 0) && (arrayOfFloat2[0] <= parambkin.jdField_m_of_type_Int - parambkin.u / 2.0F) && (arrayOfFloat2[0] >= parambkin.jdField_l_of_type_Int - parambkin.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
      }
      if ((i2 != 0) && (arrayOfFloat3[0] <= parambkin.jdField_m_of_type_Int - parambkin.u / 2.0F) && (arrayOfFloat3[0] >= parambkin.jdField_l_of_type_Int - parambkin.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
      }
      if ((i3 != 0) && (arrayOfFloat1[0] <= parambkin.jdField_m_of_type_Int - parambkin.u / 2.0F) && (arrayOfFloat1[0] >= parambkin.jdField_l_of_type_Int - parambkin.u / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, TOP");
      }
      if ((i4 != 0) && (arrayOfFloat2[0] <= parambkin.jdField_m_of_type_Int - parambkin.u / 2.0F) && (arrayOfFloat2[0] >= parambkin.jdField_l_of_type_Int - parambkin.u / 2.0F)) {
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
            if (i5 >= parambkin.u) {
              break label881;
            }
            float f5 = parambkin.a[(i5 * 2)];
            float f6 = parambkin.a[(i5 * 2 + 1)];
            int i6;
            if (i1 == 0)
            {
              i6 = (int)((i5 - parambkin.u / 2.0F - arrayOfFloat1[0]) * f1 + arrayOfFloat1[1]);
              if ((i6 >= f5 - parambkin.v / 2.0F) && (i6 <= f6 - parambkin.v / 2.0F))
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
              i6 = (int)((i5 - parambkin.u / 2.0F - arrayOfFloat3[0]) * f2 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambkin.v / 2.0F) && (i6 <= f6 - parambkin.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
                return;
              }
            }
            if (i3 == 0)
            {
              i6 = (int)((i5 - parambkin.u / 2.0F - arrayOfFloat3[0]) * f3 + arrayOfFloat3[1]);
              if ((i6 >= f5 - parambkin.v / 2.0F) && (i6 <= f6 - parambkin.v / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, TOP");
                return;
              }
            }
            if (i4 == 0)
            {
              i6 = (int)((i5 - parambkin.u / 2.0F - arrayOfFloat4[0]) * f4 + arrayOfFloat4[1]);
              if ((i6 >= f5 - parambkin.v / 2.0F) && (i6 <= f6 - parambkin.v / 2.0F))
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
  
  public boolean b(bkin parambkin, float paramFloat1, float paramFloat2)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkin).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkin);
      f2 = parambkin.u;
      float f3 = parambkin.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkin.v;
      float f1 = parambkin.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkik.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean b(bkin parambkin, float paramFloat, boolean paramBoolean)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parambkin.u;
        float f1 = parambkin.v / 2.0F;
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
        parambkin = a(parambkin);
        this.jdField_a_of_type_AndroidGraphicsMatrix = parambkin;
        parambkin.mapPoints(arrayOfFloat1);
        parambkin.mapPoints(arrayOfFloat2);
        parambkin.mapPoints(arrayOfFloat3);
        parambkin.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parambkin = new StringBuilder();
          parambkin.append("isCloseToYLine y=").append(paramFloat).append(" topReach=").append(paramBoolean).append("\n");
          parambkin.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parambkin.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parambkin.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parambkin.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parambkin.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[1] > paramFloat) && (arrayOfFloat2[1] > paramFloat) && (arrayOfFloat3[1] > paramFloat) && (arrayOfFloat4[1] > paramFloat));
      return true;
    } while ((arrayOfFloat1[1] < paramFloat) && (arrayOfFloat2[1] < paramFloat) && (arrayOfFloat3[1] < paramFloat) && (arrayOfFloat4[1] < paramFloat));
    return true;
  }
  
  public Matrix c(bkin parambkin)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (parambkin == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(parambkin);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public boolean c(bkin parambkin, float paramFloat1, float paramFloat2)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      if ((!parambkin.g) || (!parambkin.h)) {
        break;
      }
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      paramFloat1 = bkik.a() / 2.0F;
    } while ((arrayOfFloat[0] < parambkin.jdField_l_of_type_Float + parambkin.jdField_j_of_type_Float - paramFloat1 - 10.0F) || (arrayOfFloat[0] > parambkin.jdField_l_of_type_Float + parambkin.jdField_j_of_type_Float + paramFloat1 + 10.0F) || (arrayOfFloat[1] < parambkin.jdField_m_of_type_Float + parambkin.k - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + (parambkin.jdField_m_of_type_Float + parambkin.k) + 10.0F));
    return true;
    return d(parambkin, paramFloat1, paramFloat2);
  }
  
  public boolean d(bkin parambkin, float paramFloat1, float paramFloat2)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkin).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkin);
      f2 = parambkin.u;
      float f3 = parambkin.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkin.v;
      float f1 = parambkin.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkik.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean e(bkin parambkin, float paramFloat1, float paramFloat2)
  {
    if (parambkin == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parambkin).mapPoints(arrayOfFloat);
      paramFloat1 = a(parambkin);
      f2 = parambkin.u;
      float f3 = parambkin.jdField_j_of_type_Int / paramFloat1;
      paramFloat2 = parambkin.v;
      float f1 = parambkin.jdField_j_of_type_Int / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = bkik.a() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkim
 * JD-Core Version:    0.7.0.1
 */