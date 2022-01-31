import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bfuc
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bfud jdField_a_of_type_Bfud;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bfud jdField_b_of_type_Bfud;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bfuc(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bfuc(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bfuc(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bfud = new bfud();
    this.jdField_b_of_type_Bfud = new bfud();
    bfud.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bfud.a(this.jdField_a_of_type_Bfud) * bfud.a(this.jdField_a_of_type_Bfud) + bfud.a(this.jdField_b_of_type_Bfud) * bfud.a(this.jdField_b_of_type_Bfud));
  }
  
  public final int a()
  {
    return bfud.a(this.jdField_a_of_type_Bfud);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfud.a();
    this.jdField_b_of_type_Bfud.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bfud.a(paramFloat);
    this.jdField_b_of_type_Bfud.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bfud.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bfud.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bfud.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bfud.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bfud.a(this.jdField_a_of_type_Bfud);
      float f2 = bfud.a(this.jdField_b_of_type_Bfud);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bfud.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bfud.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bfud.a(this.jdField_a_of_type_Bfud, paramLong);
    bfud.a(this.jdField_b_of_type_Bfud, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bfud.a(this.jdField_a_of_type_Bfud, bfud.a(this.jdField_b_of_type_Bfud, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bfud.a(this.jdField_a_of_type_Bfud)) && (bfud.a(this.jdField_b_of_type_Bfud));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bfud.c(this.jdField_a_of_type_Bfud);
    int j = bfud.b(this.jdField_a_of_type_Bfud);
    int k = bfud.c(this.jdField_b_of_type_Bfud);
    int m = bfud.b(this.jdField_b_of_type_Bfud);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bfud.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bfud.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bfud.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bfud.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bfud.a(this.jdField_b_of_type_Bfud);
  }
  
  public final int b()
  {
    return bfud.a(this.jdField_b_of_type_Bfud);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bfud.a(this.jdField_a_of_type_Bfud);
      int i = bfud.d(this.jdField_a_of_type_Bfud);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bfmw.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bfud.a(this.jdField_a_of_type_Bfud)) {
            this.jdField_a_of_type_Bfud.b(f);
          }
          if (bfud.a(this.jdField_b_of_type_Bfud)) {
            break;
          }
          this.jdField_b_of_type_Bfud.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bfud.a(this.jdField_a_of_type_Bfud)) && (!this.jdField_a_of_type_Bfud.c()) && (!this.jdField_a_of_type_Bfud.b())) {
        this.jdField_a_of_type_Bfud.a();
      }
      if ((!bfud.a(this.jdField_b_of_type_Bfud)) && (!this.jdField_b_of_type_Bfud.c()) && (!this.jdField_b_of_type_Bfud.b()))
      {
        this.jdField_b_of_type_Bfud.a();
        continue;
        if ((!bfud.a(this.jdField_a_of_type_Bfud)) && (!this.jdField_a_of_type_Bfud.c()) && (!this.jdField_a_of_type_Bfud.a())) {
          this.jdField_a_of_type_Bfud.a();
        }
        if ((!bfud.a(this.jdField_b_of_type_Bfud)) && (!this.jdField_b_of_type_Bfud.c()) && (!this.jdField_b_of_type_Bfud.a())) {
          this.jdField_b_of_type_Bfud.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bfud.b(this.jdField_a_of_type_Bfud);
  }
  
  public final int d()
  {
    return bfud.c(this.jdField_a_of_type_Bfud);
  }
  
  public final int e()
  {
    return bfud.c(this.jdField_b_of_type_Bfud);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfuc
 * JD-Core Version:    0.7.0.1
 */