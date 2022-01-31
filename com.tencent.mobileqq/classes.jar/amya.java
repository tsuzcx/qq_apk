import com.tencent.qphone.base.util.QLog;

public class amya
  extends amyj
{
  public long a;
  public amyc a;
  public amyd a;
  
  public amya()
  {
    this.jdField_a_of_type_Amyd = new amyd();
    this.jdField_a_of_type_Amyc = new amyc();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Amyd.a();
    this.jdField_a_of_type_Amyc.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Amyd + ", circleResult = " + this.jdField_a_of_type_Amyc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amya
 * JD-Core Version:    0.7.0.1
 */