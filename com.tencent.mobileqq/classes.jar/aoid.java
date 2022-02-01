import com.tencent.qphone.base.util.QLog;

public class aoid
  extends aoim
{
  public long a;
  public aoif a;
  public aoig a;
  
  public aoid()
  {
    this.jdField_a_of_type_Aoig = new aoig();
    this.jdField_a_of_type_Aoif = new aoif();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Aoig.a();
    this.jdField_a_of_type_Aoif.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Aoig + ", circleResult = " + this.jdField_a_of_type_Aoif + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoid
 * JD-Core Version:    0.7.0.1
 */