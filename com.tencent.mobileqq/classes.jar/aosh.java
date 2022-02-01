import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;

public class aosh
  extends aosi
{
  protected aosh(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 527;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = avdu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, c());
    this.jdField_a_of_type_Aosm.d((String)localObject);
    a();
    a(paramMessage, this.jdField_a_of_type_Aosm);
    localObject = avdu.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramMessage = avdu.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
    this.jdField_a_of_type_Aosm.c(paramMessage);
    return this.jdField_a_of_type_Aosm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosh
 * JD-Core Version:    0.7.0.1
 */