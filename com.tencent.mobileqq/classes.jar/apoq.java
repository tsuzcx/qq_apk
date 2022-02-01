import com.tencent.qphone.base.util.QLog;

public class apoq
  extends apoz
{
  public long a;
  public apos a;
  public apot a;
  
  public apoq()
  {
    this.jdField_a_of_type_Apot = new apot();
    this.jdField_a_of_type_Apos = new apos();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Apot.a();
    this.jdField_a_of_type_Apos.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Apot + ", circleResult = " + this.jdField_a_of_type_Apos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoq
 * JD-Core Version:    0.7.0.1
 */