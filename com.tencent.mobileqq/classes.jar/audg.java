import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class audg
  implements afrc
{
  private bjve jdField_a_of_type_Bjve = new audh(this);
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public boolean a;
  
  public audg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static audg a(BaseChatPie paramBaseChatPie)
  {
    return (audg)paramBaseChatPie.getHelper(6);
  }
  
  private void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.b(this.jdField_a_of_type_Bjve);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
    }
    do
    {
      return;
      if (paramInt == 13)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
        return;
      }
    } while (paramInt != 5);
    bjnm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
  }
  
  public void a(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.a(this.jdField_a_of_type_Bjve);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 13, 5 };
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 30) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audg
 * JD-Core Version:    0.7.0.1
 */