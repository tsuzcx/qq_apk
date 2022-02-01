import com.tencent.qphone.base.util.QLog;

public class aplf
  extends aplo
{
  public long a;
  public aplh a;
  public apli a;
  
  public aplf()
  {
    this.jdField_a_of_type_Apli = new apli();
    this.jdField_a_of_type_Aplh = new aplh();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Apli.a();
    this.jdField_a_of_type_Aplh.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Apli + ", circleResult = " + this.jdField_a_of_type_Aplh + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplf
 * JD-Core Version:    0.7.0.1
 */