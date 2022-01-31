import com.tencent.qphone.base.util.QLog;

public class ancj
  extends ancs
{
  public long a;
  public ancl a;
  public ancm a;
  
  public ancj()
  {
    this.jdField_a_of_type_Ancm = new ancm();
    this.jdField_a_of_type_Ancl = new ancl();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Ancm.a();
    this.jdField_a_of_type_Ancl.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Ancm + ", circleResult = " + this.jdField_a_of_type_Ancl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancj
 * JD-Core Version:    0.7.0.1
 */