import com.tencent.qphone.base.util.QLog;

public class aqga
{
  public int a;
  protected aqfk a;
  protected aqfz a;
  
  public aqga(aqfz paramaqfz, aqfk paramaqfk)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Aqfk = paramaqfk;
    this.jdField_a_of_type_Aqfz = paramaqfz;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onEnd");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onStart subinfo:" + paramInt);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " start handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onForceEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqga
 * JD-Core Version:    0.7.0.1
 */