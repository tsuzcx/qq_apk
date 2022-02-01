import com.tencent.qphone.base.util.QLog;

public class apba
  extends apbj
{
  public long a;
  public apbc a;
  public apbd a;
  
  public apba()
  {
    this.jdField_a_of_type_Apbd = new apbd();
    this.jdField_a_of_type_Apbc = new apbc();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Apbd.a();
    this.jdField_a_of_type_Apbc.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Apbd + ", circleResult = " + this.jdField_a_of_type_Apbc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apba
 * JD-Core Version:    0.7.0.1
 */