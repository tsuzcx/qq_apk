import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class astf
{
  private aogm jdField_a_of_type_Aogm = new astg(this);
  private asth jdField_a_of_type_Asth;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public astf(QQAppInterface paramQQAppInterface, asth paramasth)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asth = paramasth;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Aogm);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogm);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    ((aogn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(180)).a(paramChatMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astf
 * JD-Core Version:    0.7.0.1
 */