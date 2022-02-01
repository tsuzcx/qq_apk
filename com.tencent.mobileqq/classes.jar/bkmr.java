import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bkmr
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bkms jdField_a_of_type_Bkms;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bkms jdField_b_of_type_Bkms;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bkmr(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bkmr(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bkmr(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bkms = new bkms();
    this.jdField_b_of_type_Bkms = new bkms();
    bkms.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bkms.a(this.jdField_a_of_type_Bkms) * bkms.a(this.jdField_a_of_type_Bkms) + bkms.a(this.jdField_b_of_type_Bkms) * bkms.a(this.jdField_b_of_type_Bkms));
  }
  
  public final int a()
  {
    return bkms.a(this.jdField_a_of_type_Bkms);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkms.a();
    this.jdField_b_of_type_Bkms.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bkms.a(paramFloat);
    this.jdField_b_of_type_Bkms.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bkms.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bkms.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bkms.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bkms.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, 1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = bkms.a(this.jdField_a_of_type_Bkms);
      float f2 = bkms.a(this.jdField_b_of_type_Bkms);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bkms.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bkms.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bkms.a(this.jdField_a_of_type_Bkms, paramLong);
    bkms.a(this.jdField_b_of_type_Bkms, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bkms.a(this.jdField_a_of_type_Bkms, bkms.a(this.jdField_b_of_type_Bkms, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bkms.a(this.jdField_a_of_type_Bkms)) && (bkms.a(this.jdField_b_of_type_Bkms));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bkms.c(this.jdField_a_of_type_Bkms);
    int j = bkms.b(this.jdField_a_of_type_Bkms);
    int k = bkms.c(this.jdField_b_of_type_Bkms);
    int m = bkms.b(this.jdField_b_of_type_Bkms);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bkms.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bkms.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bkms.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bkms.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bkms.a(this.jdField_b_of_type_Bkms);
  }
  
  public final int b()
  {
    return bkms.a(this.jdField_b_of_type_Bkms);
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - bkms.a(this.jdField_a_of_type_Bkms);
      int i = bkms.d(this.jdField_a_of_type_Bkms);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bkfh.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bkms.a(this.jdField_a_of_type_Bkms)) {
            this.jdField_a_of_type_Bkms.b(f);
          }
          if (bkms.a(this.jdField_b_of_type_Bkms)) {
            break;
          }
          this.jdField_b_of_type_Bkms.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bkms.a(this.jdField_a_of_type_Bkms)) && (!this.jdField_a_of_type_Bkms.c()) && (!this.jdField_a_of_type_Bkms.b())) {
        this.jdField_a_of_type_Bkms.a();
      }
      if ((!bkms.a(this.jdField_b_of_type_Bkms)) && (!this.jdField_b_of_type_Bkms.c()) && (!this.jdField_b_of_type_Bkms.b()))
      {
        this.jdField_b_of_type_Bkms.a();
        continue;
        if ((!bkms.a(this.jdField_a_of_type_Bkms)) && (!this.jdField_a_of_type_Bkms.c()) && (!this.jdField_a_of_type_Bkms.a())) {
          this.jdField_a_of_type_Bkms.a();
        }
        if ((!bkms.a(this.jdField_b_of_type_Bkms)) && (!this.jdField_b_of_type_Bkms.c()) && (!this.jdField_b_of_type_Bkms.a())) {
          this.jdField_b_of_type_Bkms.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bkms.b(this.jdField_a_of_type_Bkms);
  }
  
  public final int d()
  {
    return bkms.c(this.jdField_a_of_type_Bkms);
  }
  
  public final int e()
  {
    return bkms.c(this.jdField_b_of_type_Bkms);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkmr
 * JD-Core Version:    0.7.0.1
 */