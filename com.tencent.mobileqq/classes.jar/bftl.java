import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bftl
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bftm jdField_a_of_type_Bftm;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bftm jdField_b_of_type_Bftm;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bftl(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bftl(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bftl(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bftm = new bftm();
    this.jdField_b_of_type_Bftm = new bftm();
    bftm.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bftm.a(this.jdField_a_of_type_Bftm) * bftm.a(this.jdField_a_of_type_Bftm) + bftm.a(this.jdField_b_of_type_Bftm) * bftm.a(this.jdField_b_of_type_Bftm));
  }
  
  public final int a()
  {
    return bftm.a(this.jdField_a_of_type_Bftm);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bftm.a();
    this.jdField_b_of_type_Bftm.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bftm.a(paramFloat);
    this.jdField_b_of_type_Bftm.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bftm.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bftm.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bftm.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bftm.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bftm.a(this.jdField_a_of_type_Bftm);
      float f2 = bftm.a(this.jdField_b_of_type_Bftm);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bftm.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bftm.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bftm.a(this.jdField_a_of_type_Bftm, paramLong);
    bftm.a(this.jdField_b_of_type_Bftm, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bftm.a(this.jdField_a_of_type_Bftm, bftm.a(this.jdField_b_of_type_Bftm, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bftm.a(this.jdField_a_of_type_Bftm)) && (bftm.a(this.jdField_b_of_type_Bftm));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bftm.c(this.jdField_a_of_type_Bftm);
    int j = bftm.b(this.jdField_a_of_type_Bftm);
    int k = bftm.c(this.jdField_b_of_type_Bftm);
    int m = bftm.b(this.jdField_b_of_type_Bftm);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bftm.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bftm.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bftm.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bftm.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bftm.a(this.jdField_b_of_type_Bftm);
  }
  
  public final int b()
  {
    return bftm.a(this.jdField_b_of_type_Bftm);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bftm.a(this.jdField_a_of_type_Bftm);
      int i = bftm.d(this.jdField_a_of_type_Bftm);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bfmf.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bftm.a(this.jdField_a_of_type_Bftm)) {
            this.jdField_a_of_type_Bftm.b(f);
          }
          if (bftm.a(this.jdField_b_of_type_Bftm)) {
            break;
          }
          this.jdField_b_of_type_Bftm.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bftm.a(this.jdField_a_of_type_Bftm)) && (!this.jdField_a_of_type_Bftm.c()) && (!this.jdField_a_of_type_Bftm.b())) {
        this.jdField_a_of_type_Bftm.a();
      }
      if ((!bftm.a(this.jdField_b_of_type_Bftm)) && (!this.jdField_b_of_type_Bftm.c()) && (!this.jdField_b_of_type_Bftm.b()))
      {
        this.jdField_b_of_type_Bftm.a();
        continue;
        if ((!bftm.a(this.jdField_a_of_type_Bftm)) && (!this.jdField_a_of_type_Bftm.c()) && (!this.jdField_a_of_type_Bftm.a())) {
          this.jdField_a_of_type_Bftm.a();
        }
        if ((!bftm.a(this.jdField_b_of_type_Bftm)) && (!this.jdField_b_of_type_Bftm.c()) && (!this.jdField_b_of_type_Bftm.a())) {
          this.jdField_b_of_type_Bftm.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bftm.b(this.jdField_a_of_type_Bftm);
  }
  
  public final int d()
  {
    return bftm.c(this.jdField_a_of_type_Bftm);
  }
  
  public final int e()
  {
    return bftm.c(this.jdField_b_of_type_Bftm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bftl
 * JD-Core Version:    0.7.0.1
 */