import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bhuz
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bhva jdField_a_of_type_Bhva;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bhva jdField_b_of_type_Bhva;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bhuz(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bhuz(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bhuz(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bhva = new bhva();
    this.jdField_b_of_type_Bhva = new bhva();
    bhva.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bhva.a(this.jdField_a_of_type_Bhva) * bhva.a(this.jdField_a_of_type_Bhva) + bhva.a(this.jdField_b_of_type_Bhva) * bhva.a(this.jdField_b_of_type_Bhva));
  }
  
  public final int a()
  {
    return bhva.a(this.jdField_a_of_type_Bhva);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhva.a();
    this.jdField_b_of_type_Bhva.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bhva.a(paramFloat);
    this.jdField_b_of_type_Bhva.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bhva.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bhva.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bhva.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bhva.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bhva.a(this.jdField_a_of_type_Bhva);
      float f2 = bhva.a(this.jdField_b_of_type_Bhva);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bhva.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bhva.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bhva.a(this.jdField_a_of_type_Bhva, paramLong);
    bhva.a(this.jdField_b_of_type_Bhva, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bhva.a(this.jdField_a_of_type_Bhva, bhva.a(this.jdField_b_of_type_Bhva, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bhva.a(this.jdField_a_of_type_Bhva)) && (bhva.a(this.jdField_b_of_type_Bhva));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bhva.c(this.jdField_a_of_type_Bhva);
    int j = bhva.b(this.jdField_a_of_type_Bhva);
    int k = bhva.c(this.jdField_b_of_type_Bhva);
    int m = bhva.b(this.jdField_b_of_type_Bhva);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bhva.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bhva.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bhva.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bhva.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bhva.a(this.jdField_b_of_type_Bhva);
  }
  
  public final int b()
  {
    return bhva.a(this.jdField_b_of_type_Bhva);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bhva.a(this.jdField_a_of_type_Bhva);
      int i = bhva.d(this.jdField_a_of_type_Bhva);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bhnq.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bhva.a(this.jdField_a_of_type_Bhva)) {
            this.jdField_a_of_type_Bhva.b(f);
          }
          if (bhva.a(this.jdField_b_of_type_Bhva)) {
            break;
          }
          this.jdField_b_of_type_Bhva.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bhva.a(this.jdField_a_of_type_Bhva)) && (!this.jdField_a_of_type_Bhva.c()) && (!this.jdField_a_of_type_Bhva.b())) {
        this.jdField_a_of_type_Bhva.a();
      }
      if ((!bhva.a(this.jdField_b_of_type_Bhva)) && (!this.jdField_b_of_type_Bhva.c()) && (!this.jdField_b_of_type_Bhva.b()))
      {
        this.jdField_b_of_type_Bhva.a();
        continue;
        if ((!bhva.a(this.jdField_a_of_type_Bhva)) && (!this.jdField_a_of_type_Bhva.c()) && (!this.jdField_a_of_type_Bhva.a())) {
          this.jdField_a_of_type_Bhva.a();
        }
        if ((!bhva.a(this.jdField_b_of_type_Bhva)) && (!this.jdField_b_of_type_Bhva.c()) && (!this.jdField_b_of_type_Bhva.a())) {
          this.jdField_b_of_type_Bhva.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bhva.b(this.jdField_a_of_type_Bhva);
  }
  
  public final int d()
  {
    return bhva.c(this.jdField_a_of_type_Bhva);
  }
  
  public final int e()
  {
    return bhva.c(this.jdField_b_of_type_Bhva);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhuz
 * JD-Core Version:    0.7.0.1
 */