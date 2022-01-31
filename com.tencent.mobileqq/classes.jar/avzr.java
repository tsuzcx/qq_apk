import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class avzr
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 250L;
  private float c;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public float a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if (l >= this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_Boolean = true;
      this.c = this.jdField_b_of_type_Float;
      return false;
    }
    float f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation((float)l / (float)this.jdField_b_of_type_Long);
    this.c = a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f);
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzr
 * JD-Core Version:    0.7.0.1
 */