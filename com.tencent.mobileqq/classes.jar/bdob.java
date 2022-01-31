import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import java.lang.reflect.Field;

public class bdob<T>
  extends Animation
{
  static final bdoi jdField_a_of_type_Bdoi = new bdoc();
  static final bdoi b;
  static final bdoi c;
  static final bdoi d;
  static final bdoi e = new bdog();
  private long jdField_a_of_type_Long;
  protected bdoh<T> a;
  protected T a;
  protected boolean a;
  private Pair[] jdField_a_of_type_ArrayOfAndroidUtilPair;
  protected T b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected bdoi<T> f;
  
  static
  {
    jdField_b_of_type_Bdoi = new bdod();
    jdField_c_of_type_Bdoi = new bdoe();
    jdField_d_of_type_Bdoi = new bdof();
  }
  
  public bdob(T paramT1, T paramT2, bdoh<T> parambdoh)
  {
    this(paramT1, paramT2, parambdoh, false, false, null);
  }
  
  public bdob(T paramT1, T paramT2, bdoh<T> parambdoh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramT1, paramT2, parambdoh, paramBoolean1, paramBoolean2, null);
  }
  
  public bdob(T paramT1, T paramT2, bdoh<T> parambdoh, boolean paramBoolean1, boolean paramBoolean2, bdoi<T> parambdoi)
  {
    Class localClass = paramT1.getClass();
    if (parambdoi != null) {
      this.f = parambdoi;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = paramT1;
      this.jdField_b_of_type_JavaLangObject = paramT2;
      a(parambdoh);
      this.jdField_a_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      if (localClass == Integer.class)
      {
        this.f = jdField_a_of_type_Bdoi;
      }
      else if (Float.class == localClass)
      {
        this.f = jdField_b_of_type_Bdoi;
      }
      else if (Rect.class == localClass)
      {
        this.f = jdField_c_of_type_Bdoi;
      }
      else if (Point.class == localClass)
      {
        this.f = jdField_d_of_type_Bdoi;
      }
      else
      {
        if (PointF.class != localClass) {
          break;
        }
        this.f = e;
      }
    }
    throw new IllegalArgumentException("Can't support type " + paramT1.getClass().getSimpleName());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(bdoh<T> parambdoh)
  {
    this.jdField_a_of_type_Bdoh = parambdoh;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_Bdoh != null) {
      this.jdField_a_of_type_Bdoh.a(this, paramFloat, this.f.a(paramFloat, this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_JavaLangObject), paramTransformation);
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void cancel()
  {
    int i = 0;
    this.jdField_c_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 8) {
      super.cancel();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ArrayOfAndroidUtilPair == null) {
        this.jdField_a_of_type_ArrayOfAndroidUtilPair = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
      }
      try
      {
        Object localObject1 = getClass().getDeclaredField("mListener");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        if ((localObject1 instanceof Animation.AnimationListener)) {
          ((Animation.AnimationListener)localObject1).onAnimationEnd(this);
        }
        localObject1 = getClass().getDeclaredField("mStartTime");
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).setLong(this, -9223372036854775808L);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidUtilPair;
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          Field localField = getClass().getDeclaredField((String)localObject2.first);
          localField.setAccessible(true);
          localField.setBoolean(this, ((Boolean)localObject2.second).booleanValue());
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Long == 0L) {
        a(paramLong - getStartTime());
      }
      setStartTime(paramLong - this.jdField_a_of_type_Long);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.jdField_c_of_type_Boolean = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdob
 * JD-Core Version:    0.7.0.1
 */