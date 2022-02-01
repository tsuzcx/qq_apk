import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;

public class anpo
  extends anpp
{
  protected anpo(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 527;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = atyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, c());
    this.jdField_a_of_type_Anpt.d((String)localObject);
    a();
    a(paramMessage, this.jdField_a_of_type_Anpt);
    localObject = atyf.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramMessage = atyf.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Anpt.a((Bitmap)localObject);
    this.jdField_a_of_type_Anpt.c(paramMessage);
    return this.jdField_a_of_type_Anpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpo
 * JD-Core Version:    0.7.0.1
 */