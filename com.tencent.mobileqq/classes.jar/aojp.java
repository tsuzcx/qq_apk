import com.tencent.qphone.base.util.QLog;

public class aojp
{
  public int a;
  protected aojc a;
  protected aojo a;
  
  public aojp(aojo paramaojo, aojc paramaojc)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Aojc = paramaojc;
    this.jdField_a_of_type_Aojo = paramaojo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojp
 * JD-Core Version:    0.7.0.1
 */