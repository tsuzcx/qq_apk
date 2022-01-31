import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class asmq
  implements afal
{
  private final BaseChatPie a;
  public boolean a;
  
  public asmq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static asmq a(BaseChatPie paramBaseChatPie)
  {
    return (asmq)paramBaseChatPie.a(6);
  }
  
  private void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.setTextMenuListener(null);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
    do
    {
      return;
      if (paramInt == 11)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
    } while (paramInt != 4);
    bhpd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(XEditTextEx paramXEditTextEx)
  {
    asmr localasmr = new asmr(this);
    try
    {
      paramXEditTextEx.setTextMenuListener(localasmr);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
  
  public int[] a()
  {
    return new int[] { 2, 11, 4 };
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 30) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmq
 * JD-Core Version:    0.7.0.1
 */