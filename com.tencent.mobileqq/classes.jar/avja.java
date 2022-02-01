import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class avja
  implements agin
{
  private blgp jdField_a_of_type_Blgp = new avjb(this);
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public boolean a;
  
  public avja(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static avja a(BaseChatPie paramBaseChatPie)
  {
    return (avja)paramBaseChatPie.getHelper(6);
  }
  
  private void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.b(this.jdField_a_of_type_Blgp);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 4) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
    }
    do
    {
      return;
      if (paramInt == 14)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
        return;
      }
    } while (paramInt != 6);
    bkyy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
  }
  
  public void a(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.a(this.jdField_a_of_type_Blgp);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 14, 6 };
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 30) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avja
 * JD-Core Version:    0.7.0.1
 */