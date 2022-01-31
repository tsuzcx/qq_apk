import android.graphics.Point;

public final class amrl
{
  public float a;
  public final int a;
  public final long a;
  public final Point a;
  public float b;
  
  public amrl(long paramLong, Point paramPoint, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint.x - this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint.y - this.b;
  }
  
  public String toString()
  {
    return "TouchPoint{mTime=" + this.jdField_a_of_type_Long + ", mPoint=" + this.jdField_a_of_type_AndroidGraphicsPoint + ", mDistanceOfError=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amrl
 * JD-Core Version:    0.7.0.1
 */