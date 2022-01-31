import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bhzg
{
  public static int a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final bhzh jdField_a_of_type_Bhzh;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final bhzh jdField_b_of_type_Bhzh;
  
  static
  {
    jdField_a_of_type_Int = 400;
  }
  
  public bhzg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bhzg(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public bhzg(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bhzh = new bhzh();
    this.jdField_b_of_type_Bhzh = new bhzh();
    bhzh.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(bhzh.a(this.jdField_a_of_type_Bhzh) * bhzh.a(this.jdField_a_of_type_Bhzh) + bhzh.a(this.jdField_b_of_type_Bhzh) * bhzh.a(this.jdField_b_of_type_Bhzh));
  }
  
  public final int a()
  {
    return bhzh.a(this.jdField_a_of_type_Bhzh);
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhzh.a();
    this.jdField_b_of_type_Bhzh.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Bhzh.a(paramFloat);
    this.jdField_b_of_type_Bhzh.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Bhzh.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Bhzh.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bhzh.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Bhzh.a(paramInt2, paramInt4, paramInt5);
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
      float f1 = bhzh.a(this.jdField_a_of_type_Bhzh);
      float f2 = bhzh.a(this.jdField_b_of_type_Bhzh);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt11;
      this.jdField_a_of_type_Bhzh.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Bhzh.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    bhzh.a(this.jdField_a_of_type_Bhzh, paramLong);
    bhzh.a(this.jdField_b_of_type_Bhzh, paramLong);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void a(boolean paramBoolean)
  {
    bhzh.a(this.jdField_a_of_type_Bhzh, bhzh.a(this.jdField_b_of_type_Bhzh, paramBoolean));
  }
  
  public final boolean a()
  {
    return (bhzh.a(this.jdField_a_of_type_Bhzh)) && (bhzh.a(this.jdField_b_of_type_Bhzh));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = bhzh.c(this.jdField_a_of_type_Bhzh);
    int j = bhzh.b(this.jdField_a_of_type_Bhzh);
    int k = bhzh.c(this.jdField_b_of_type_Bhzh);
    int m = bhzh.b(this.jdField_b_of_type_Bhzh);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bhzh.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Bhzh.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_b_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Bhzh.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Bhzh.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public float b()
  {
    return bhzh.a(this.jdField_b_of_type_Bhzh);
  }
  
  public final int b()
  {
    return bhzh.a(this.jdField_b_of_type_Bhzh);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - bhzh.a(this.jdField_a_of_type_Bhzh);
      int i = bhzh.d(this.jdField_a_of_type_Bhzh);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = bhrx.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!bhzh.a(this.jdField_a_of_type_Bhzh)) {
            this.jdField_a_of_type_Bhzh.b(f);
          }
          if (bhzh.a(this.jdField_b_of_type_Bhzh)) {
            break;
          }
          this.jdField_b_of_type_Bhzh.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!bhzh.a(this.jdField_a_of_type_Bhzh)) && (!this.jdField_a_of_type_Bhzh.c()) && (!this.jdField_a_of_type_Bhzh.b())) {
        this.jdField_a_of_type_Bhzh.a();
      }
      if ((!bhzh.a(this.jdField_b_of_type_Bhzh)) && (!this.jdField_b_of_type_Bhzh.c()) && (!this.jdField_b_of_type_Bhzh.b()))
      {
        this.jdField_b_of_type_Bhzh.a();
        continue;
        if ((!bhzh.a(this.jdField_a_of_type_Bhzh)) && (!this.jdField_a_of_type_Bhzh.c()) && (!this.jdField_a_of_type_Bhzh.a())) {
          this.jdField_a_of_type_Bhzh.a();
        }
        if ((!bhzh.a(this.jdField_b_of_type_Bhzh)) && (!this.jdField_b_of_type_Bhzh.c()) && (!this.jdField_b_of_type_Bhzh.a())) {
          this.jdField_b_of_type_Bhzh.a();
        }
      }
    }
  }
  
  public final int c()
  {
    return bhzh.b(this.jdField_a_of_type_Bhzh);
  }
  
  public final int d()
  {
    return bhzh.c(this.jdField_a_of_type_Bhzh);
  }
  
  public final int e()
  {
    return bhzh.c(this.jdField_b_of_type_Bhzh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhzg
 * JD-Core Version:    0.7.0.1
 */