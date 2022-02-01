import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class blnu
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final blnv jdField_a_of_type_Blnv;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final blnv jdField_b_of_type_Blnv;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public blnu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public blnu(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public blnu(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Blnv = new blnv();
    this.jdField_b_of_type_Blnv = new blnv();
    blnv.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(blnv.a(this.jdField_a_of_type_Blnv) * blnv.a(this.jdField_a_of_type_Blnv) + blnv.a(this.jdField_b_of_type_Blnv) * blnv.a(this.jdField_b_of_type_Blnv));
  }
  
  public final int a()
  {
    return blnv.a(this.jdField_a_of_type_Blnv);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blnv.a();
    this.jdField_b_of_type_Blnv.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Blnv.a(paramFloat);
    this.jdField_b_of_type_Blnv.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Blnv.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Blnv.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Blnv.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Blnv.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = blnv.a(this.jdField_a_of_type_Blnv);
      float f2 = blnv.a(this.jdField_b_of_type_Blnv);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Blnv.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Blnv.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    blnv.a(this.jdField_a_of_type_Blnv, paramLong);
    blnv.a(this.jdField_b_of_type_Blnv, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    blnv.a(this.jdField_a_of_type_Blnv, blnv.a(this.jdField_b_of_type_Blnv, paramBoolean));
  }
  
  public final boolean a()
  {
    return (blnv.a(this.jdField_a_of_type_Blnv)) && (blnv.a(this.jdField_b_of_type_Blnv));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = blnv.c(this.jdField_a_of_type_Blnv);
    int j = blnv.b(this.jdField_a_of_type_Blnv);
    int k = blnv.c(this.jdField_b_of_type_Blnv);
    int m = blnv.b(this.jdField_b_of_type_Blnv);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Blnv.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Blnv.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Blnv.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Blnv.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return blnv.a(this.jdField_b_of_type_Blnv);
  }
  
  public final int b()
  {
    return blnv.a(this.jdField_b_of_type_Blnv);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - blnv.a(this.jdField_a_of_type_Blnv);
      int i = blnv.d(this.jdField_a_of_type_Blnv);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = blgl.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!blnv.a(this.jdField_a_of_type_Blnv)) {
            this.jdField_a_of_type_Blnv.b(f);
          }
          if (blnv.a(this.jdField_b_of_type_Blnv)) {
            break;
          }
          this.jdField_b_of_type_Blnv.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!blnv.a(this.jdField_a_of_type_Blnv)) && (!this.jdField_a_of_type_Blnv.c()) && (!this.jdField_a_of_type_Blnv.b())) {
        this.jdField_a_of_type_Blnv.a();
      }
      if ((!blnv.a(this.jdField_b_of_type_Blnv)) && (!this.jdField_b_of_type_Blnv.c()) && (!this.jdField_b_of_type_Blnv.b()))
      {
        this.jdField_b_of_type_Blnv.a();
        continue;
        if ((!blnv.a(this.jdField_a_of_type_Blnv)) && (!this.jdField_a_of_type_Blnv.c()) && (!this.jdField_a_of_type_Blnv.a())) {
          this.jdField_a_of_type_Blnv.a();
        }
        if ((!blnv.a(this.jdField_b_of_type_Blnv)) && (!this.jdField_b_of_type_Blnv.c()) && (!this.jdField_b_of_type_Blnv.a())) {
          this.jdField_b_of_type_Blnv.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return blnv.b(this.jdField_a_of_type_Blnv);
  }
  
  public final int d()
  {
    return blnv.c(this.jdField_a_of_type_Blnv);
  }
  
  public final int e()
  {
    return blnv.c(this.jdField_b_of_type_Blnv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blnu
 * JD-Core Version:    0.7.0.1
 */