package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>>
  implements AnimationHandler.AnimationFrameCallback
{
  public static final DynamicAnimation.ViewProperty a;
  public static final DynamicAnimation.ViewProperty b;
  public static final DynamicAnimation.ViewProperty c;
  public static final DynamicAnimation.ViewProperty d;
  public static final DynamicAnimation.ViewProperty e;
  public static final DynamicAnimation.ViewProperty f = new DynamicAnimation.6("rotation");
  public static final DynamicAnimation.ViewProperty g = new DynamicAnimation.7("rotationX");
  public static final DynamicAnimation.ViewProperty h = new DynamicAnimation.8("rotationY");
  public static final DynamicAnimation.ViewProperty i = new DynamicAnimation.9("x");
  public static final DynamicAnimation.ViewProperty j = new DynamicAnimation.10("y");
  public static final DynamicAnimation.ViewProperty k = new DynamicAnimation.11("z");
  public static final DynamicAnimation.ViewProperty l = new DynamicAnimation.12("alpha");
  public static final DynamicAnimation.ViewProperty m = new DynamicAnimation.13("scrollX");
  public static final DynamicAnimation.ViewProperty n = new DynamicAnimation.14("scrollY");
  float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long = 0L;
  final FloatPropertyCompat jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat;
  final Object jdField_a_of_type_JavaLangObject;
  private final ArrayList<DynamicAnimation.OnAnimationEndListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 3.4028235E+38F;
  private final ArrayList<DynamicAnimation.OnAnimationUpdateListener> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  float c;
  float d;
  private float e;
  
  static
  {
    jdField_a_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty = new DynamicAnimation.1("translationX");
    jdField_b_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty = new DynamicAnimation.2("translationY");
    jdField_c_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty = new DynamicAnimation.3("translationZ");
    jdField_d_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty = new DynamicAnimation.4("scaleX");
    jdField_e_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty = new DynamicAnimation.5("scaleY");
  }
  
  <K> DynamicAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat)
  {
    this.jdField_c_of_type_Float = 3.4028235E+38F;
    this.jdField_d_of_type_Float = (-this.jdField_c_of_type_Float);
    this.jdField_a_of_type_JavaLangObject = paramK;
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat = paramFloatPropertyCompat;
    if ((this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == f) || (this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == g) || (this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == h))
    {
      this.jdField_e_of_type_Float = 0.1F;
      return;
    }
    if (this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == l)
    {
      this.jdField_e_of_type_Float = 0.0039063F;
      return;
    }
    if ((this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == jdField_d_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty) || (this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat == jdField_e_of_type_AndroidxDynamicanimationAnimationDynamicAnimation$ViewProperty))
    {
      this.jdField_e_of_type_Float = 0.0039063F;
      return;
    }
    this.jdField_e_of_type_Float = 1.0F;
  }
  
  private static <T> void a(ArrayList<T> paramArrayList)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (paramArrayList.get(i1) == null) {
        paramArrayList.remove(i1);
      }
      i1 -= 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    AnimationHandler.a().a(this);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i1) != null) {
        ((DynamicAnimation.OnAnimationEndListener)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).a(this, paramBoolean, this.jdField_b_of_type_Float, this.jdField_a_of_type_Float);
      }
      i1 += 1;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private float b()
  {
    return this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat.a(this.jdField_a_of_type_JavaLangObject);
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Float = b();
      }
      if ((this.jdField_b_of_type_Float > this.jdField_c_of_type_Float) || (this.jdField_b_of_type_Float < this.jdField_d_of_type_Float)) {
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
      }
      AnimationHandler.a().a(this, 0L);
    }
  }
  
  float a()
  {
    return this.jdField_e_of_type_Float * 0.75F;
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }
    if (!this.jdField_b_of_type_Boolean) {
      b();
    }
  }
  
  void a(float paramFloat)
  {
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat.a(this.jdField_a_of_type_JavaLangObject, paramFloat);
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.get(i1) != null) {
        ((DynamicAnimation.OnAnimationUpdateListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(this, this.jdField_b_of_type_Float, this.jdField_a_of_type_Float);
      }
      i1 += 1;
    }
    a(this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  abstract boolean a(float paramFloat1, float paramFloat2);
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = paramLong;
      a(this.jdField_b_of_type_Float);
      return false;
    }
    long l1 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = paramLong;
    boolean bool = b(paramLong - l1);
    this.jdField_b_of_type_Float = Math.min(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    this.jdField_b_of_type_Float = Math.max(this.jdField_b_of_type_Float, this.jdField_d_of_type_Float);
    a(this.jdField_b_of_type_Float);
    if (bool) {
      a(false);
    }
    return bool;
  }
  
  abstract boolean b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation
 * JD-Core Version:    0.7.0.1
 */