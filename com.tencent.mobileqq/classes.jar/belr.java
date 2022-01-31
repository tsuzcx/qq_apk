import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class belr
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bels jdField_a_of_type_Bels;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bels jdField_b_of_type_Bels;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public belr(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public belr(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public belr(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bels = new bels();
    this.jdField_b_of_type_Bels = new bels();
    bels.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bels.a(this.jdField_a_of_type_Bels) * bels.a(this.jdField_a_of_type_Bels) + bels.a(this.jdField_b_of_type_Bels) * bels.a(this.jdField_b_of_type_Bels));
  }
  
  public final int a()
  {
    return bels.a(this.jdField_a_of_type_Bels);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bels.a();
    this.jdField_b_of_type_Bels.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bels.a(paramFloat);
    this.jdField_b_of_type_Bels.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bels.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bels.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bels.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bels.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bels.a(this.jdField_a_of_type_Bels);
      float f2 = bels.a(this.jdField_b_of_type_Bels);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bels.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bels.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bels.a(this.jdField_a_of_type_Bels, paramLong);
    bels.a(this.jdField_b_of_type_Bels, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bels.a(this.jdField_a_of_type_Bels, bels.a(this.jdField_b_of_type_Bels, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bels.a(this.jdField_a_of_type_Bels)) && (bels.a(this.jdField_b_of_type_Bels));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bels.c(this.jdField_a_of_type_Bels);
    int j = bels.b(this.jdField_a_of_type_Bels);
    int k = bels.c(this.jdField_b_of_type_Bels);
    int m = bels.b(this.jdField_b_of_type_Bels);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bels.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bels.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bels.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bels.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bels.a(this.jdField_b_of_type_Bels);
  }
  
  public final int b()
  {
    return bels.a(this.jdField_b_of_type_Bels);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bels.a(this.jdField_a_of_type_Bels);
      int i = bels.d(this.jdField_a_of_type_Bels);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = beel.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bels.a(this.jdField_a_of_type_Bels)) {
            this.jdField_a_of_type_Bels.b(f);
          }
          if (bels.a(this.jdField_b_of_type_Bels)) {
            break;
          }
          this.jdField_b_of_type_Bels.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bels.a(this.jdField_a_of_type_Bels)) && (!this.jdField_a_of_type_Bels.c()) && (!this.jdField_a_of_type_Bels.b())) {
        this.jdField_a_of_type_Bels.a();
      }
      if ((!bels.a(this.jdField_b_of_type_Bels)) && (!this.jdField_b_of_type_Bels.c()) && (!this.jdField_b_of_type_Bels.b()))
      {
        this.jdField_b_of_type_Bels.a();
        continue;
        if ((!bels.a(this.jdField_a_of_type_Bels)) && (!this.jdField_a_of_type_Bels.c()) && (!this.jdField_a_of_type_Bels.a())) {
          this.jdField_a_of_type_Bels.a();
        }
        if ((!bels.a(this.jdField_b_of_type_Bels)) && (!this.jdField_b_of_type_Bels.c()) && (!this.jdField_b_of_type_Bels.a())) {
          this.jdField_b_of_type_Bels.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bels.b(this.jdField_a_of_type_Bels);
  }
  
  public final int d()
  {
    return bels.c(this.jdField_a_of_type_Bels);
  }
  
  public final int e()
  {
    return bels.c(this.jdField_b_of_type_Bels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     belr
 * JD-Core Version:    0.7.0.1
 */