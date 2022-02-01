import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bjse
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bjsf jdField_a_of_type_Bjsf;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bjsf jdField_b_of_type_Bjsf;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bjse(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bjse(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bjse(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bjsf = new bjsf();
    this.jdField_b_of_type_Bjsf = new bjsf();
    bjsf.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bjsf.a(this.jdField_a_of_type_Bjsf) * bjsf.a(this.jdField_a_of_type_Bjsf) + bjsf.a(this.jdField_b_of_type_Bjsf) * bjsf.a(this.jdField_b_of_type_Bjsf));
  }
  
  public final int a()
  {
    return bjsf.a(this.jdField_a_of_type_Bjsf);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjsf.a();
    this.jdField_b_of_type_Bjsf.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bjsf.a(paramFloat);
    this.jdField_b_of_type_Bjsf.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bjsf.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bjsf.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bjsf.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bjsf.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bjsf.a(this.jdField_a_of_type_Bjsf);
      float f2 = bjsf.a(this.jdField_b_of_type_Bjsf);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bjsf.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bjsf.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bjsf.a(this.jdField_a_of_type_Bjsf, paramLong);
    bjsf.a(this.jdField_b_of_type_Bjsf, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bjsf.a(this.jdField_a_of_type_Bjsf, bjsf.a(this.jdField_b_of_type_Bjsf, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bjsf.a(this.jdField_a_of_type_Bjsf)) && (bjsf.a(this.jdField_b_of_type_Bjsf));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bjsf.c(this.jdField_a_of_type_Bjsf);
    int j = bjsf.b(this.jdField_a_of_type_Bjsf);
    int k = bjsf.c(this.jdField_b_of_type_Bjsf);
    int m = bjsf.b(this.jdField_b_of_type_Bjsf);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bjsf.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bjsf.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bjsf.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bjsf.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bjsf.a(this.jdField_b_of_type_Bjsf);
  }
  
  public final int b()
  {
    return bjsf.a(this.jdField_b_of_type_Bjsf);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bjsf.a(this.jdField_a_of_type_Bjsf);
      int i = bjsf.d(this.jdField_a_of_type_Bjsf);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bjmb.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bjsf.a(this.jdField_a_of_type_Bjsf)) {
            this.jdField_a_of_type_Bjsf.b(f);
          }
          if (bjsf.a(this.jdField_b_of_type_Bjsf)) {
            break;
          }
          this.jdField_b_of_type_Bjsf.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bjsf.a(this.jdField_a_of_type_Bjsf)) && (!this.jdField_a_of_type_Bjsf.c()) && (!this.jdField_a_of_type_Bjsf.b())) {
        this.jdField_a_of_type_Bjsf.a();
      }
      if ((!bjsf.a(this.jdField_b_of_type_Bjsf)) && (!this.jdField_b_of_type_Bjsf.c()) && (!this.jdField_b_of_type_Bjsf.b()))
      {
        this.jdField_b_of_type_Bjsf.a();
        continue;
        if ((!bjsf.a(this.jdField_a_of_type_Bjsf)) && (!this.jdField_a_of_type_Bjsf.c()) && (!this.jdField_a_of_type_Bjsf.a())) {
          this.jdField_a_of_type_Bjsf.a();
        }
        if ((!bjsf.a(this.jdField_b_of_type_Bjsf)) && (!this.jdField_b_of_type_Bjsf.c()) && (!this.jdField_b_of_type_Bjsf.a())) {
          this.jdField_b_of_type_Bjsf.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bjsf.b(this.jdField_a_of_type_Bjsf);
  }
  
  public final int d()
  {
    return bjsf.c(this.jdField_a_of_type_Bjsf);
  }
  
  public final int e()
  {
    return bjsf.c(this.jdField_b_of_type_Bjsf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjse
 * JD-Core Version:    0.7.0.1
 */