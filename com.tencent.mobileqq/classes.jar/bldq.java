import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bldq
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bldr jdField_a_of_type_Bldr;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bldr jdField_b_of_type_Bldr;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bldq(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bldq(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bldq(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bldr = new bldr();
    this.jdField_b_of_type_Bldr = new bldr();
    bldr.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bldr.a(this.jdField_a_of_type_Bldr) * bldr.a(this.jdField_a_of_type_Bldr) + bldr.a(this.jdField_b_of_type_Bldr) * bldr.a(this.jdField_b_of_type_Bldr));
  }
  
  public final int a()
  {
    return bldr.a(this.jdField_a_of_type_Bldr);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bldr.a();
    this.jdField_b_of_type_Bldr.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bldr.a(paramFloat);
    this.jdField_b_of_type_Bldr.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bldr.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bldr.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bldr.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bldr.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bldr.a(this.jdField_a_of_type_Bldr);
      float f2 = bldr.a(this.jdField_b_of_type_Bldr);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bldr.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bldr.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bldr.a(this.jdField_a_of_type_Bldr, paramLong);
    bldr.a(this.jdField_b_of_type_Bldr, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bldr.a(this.jdField_a_of_type_Bldr, bldr.a(this.jdField_b_of_type_Bldr, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bldr.a(this.jdField_a_of_type_Bldr)) && (bldr.a(this.jdField_b_of_type_Bldr));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bldr.c(this.jdField_a_of_type_Bldr);
    int j = bldr.b(this.jdField_a_of_type_Bldr);
    int k = bldr.c(this.jdField_b_of_type_Bldr);
    int m = bldr.b(this.jdField_b_of_type_Bldr);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bldr.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bldr.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bldr.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bldr.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bldr.a(this.jdField_b_of_type_Bldr);
  }
  
  public final int b()
  {
    return bldr.a(this.jdField_b_of_type_Bldr);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bldr.a(this.jdField_a_of_type_Bldr);
      int i = bldr.d(this.jdField_a_of_type_Bldr);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bkxo.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bldr.a(this.jdField_a_of_type_Bldr)) {
            this.jdField_a_of_type_Bldr.b(f);
          }
          if (bldr.a(this.jdField_b_of_type_Bldr)) {
            break;
          }
          this.jdField_b_of_type_Bldr.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bldr.a(this.jdField_a_of_type_Bldr)) && (!this.jdField_a_of_type_Bldr.c()) && (!this.jdField_a_of_type_Bldr.b())) {
        this.jdField_a_of_type_Bldr.a();
      }
      if ((!bldr.a(this.jdField_b_of_type_Bldr)) && (!this.jdField_b_of_type_Bldr.c()) && (!this.jdField_b_of_type_Bldr.b()))
      {
        this.jdField_b_of_type_Bldr.a();
        continue;
        if ((!bldr.a(this.jdField_a_of_type_Bldr)) && (!this.jdField_a_of_type_Bldr.c()) && (!this.jdField_a_of_type_Bldr.a())) {
          this.jdField_a_of_type_Bldr.a();
        }
        if ((!bldr.a(this.jdField_b_of_type_Bldr)) && (!this.jdField_b_of_type_Bldr.c()) && (!this.jdField_b_of_type_Bldr.a())) {
          this.jdField_b_of_type_Bldr.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bldr.b(this.jdField_a_of_type_Bldr);
  }
  
  public final int d()
  {
    return bldr.c(this.jdField_a_of_type_Bldr);
  }
  
  public final int e()
  {
    return bldr.c(this.jdField_b_of_type_Bldr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bldq
 * JD-Core Version:    0.7.0.1
 */