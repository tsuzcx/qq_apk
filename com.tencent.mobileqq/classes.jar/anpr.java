import android.content.Intent;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class anpr
  implements anps
{
  protected final anpt a;
  protected final QQAppInterface a;
  
  protected anpr(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anpt = paramanpt;
  }
  
  public abstract int a(QQMessageFacade.Message paramMessage);
  
  protected final Intent a()
  {
    return this.jdField_a_of_type_Anpt.a();
  }
  
  protected final String a()
  {
    return this.jdField_a_of_type_Anpt.c();
  }
  
  protected final void a()
  {
    String str = this.jdField_a_of_type_Anpt.b() + this.jdField_a_of_type_Anpt.a();
    this.jdField_a_of_type_Anpt.b(str);
  }
  
  protected final void a(QQMessageFacade.Message paramMessage, anpt paramanpt)
  {
    String str;
    if (paramMessage.counter > 1)
    {
      str = paramanpt.c();
      if (paramMessage.counter <= 100) {
        break label68;
      }
    }
    label68:
    for (paramMessage = str + " (" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694143) + ")";; paramMessage = str + " (" + paramMessage.counter + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694085) + ")")
    {
      paramanpt.c(paramMessage);
      return;
    }
  }
  
  protected final String b()
  {
    return this.jdField_a_of_type_Anpt.d();
  }
  
  protected final String c()
  {
    return this.jdField_a_of_type_Anpt.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpr
 * JD-Core Version:    0.7.0.1
 */