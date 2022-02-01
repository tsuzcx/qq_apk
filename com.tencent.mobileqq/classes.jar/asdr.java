import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class asdr
{
  private anuc jdField_a_of_type_Anuc = new asds(this);
  private asdt jdField_a_of_type_Asdt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asdr(QQAppInterface paramQQAppInterface, asdt paramasdt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asdt = paramasdt;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anuc);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuc);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    ((anud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(180)).a(paramChatMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdr
 * JD-Core Version:    0.7.0.1
 */