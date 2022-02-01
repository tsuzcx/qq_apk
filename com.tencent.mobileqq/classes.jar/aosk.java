import android.content.Intent;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class aosk
  implements aosl
{
  protected final aosm a;
  protected final QQAppInterface a;
  
  protected aosk(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aosm = paramaosm;
  }
  
  public abstract int a(QQMessageFacade.Message paramMessage);
  
  protected final Intent a()
  {
    return this.jdField_a_of_type_Aosm.a();
  }
  
  protected final String a()
  {
    return this.jdField_a_of_type_Aosm.c();
  }
  
  protected final void a()
  {
    String str = this.jdField_a_of_type_Aosm.b() + this.jdField_a_of_type_Aosm.a();
    this.jdField_a_of_type_Aosm.b(str);
  }
  
  protected final void a(QQMessageFacade.Message paramMessage, aosm paramaosm)
  {
    String str;
    if (paramMessage.counter > 1)
    {
      str = paramaosm.c();
      if (paramMessage.counter <= 100) {
        break label68;
      }
    }
    label68:
    for (paramMessage = str + " (" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694340) + ")";; paramMessage = str + " (" + paramMessage.counter + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694276) + ")")
    {
      paramaosm.c(paramMessage);
      return;
    }
  }
  
  protected final String b()
  {
    return this.jdField_a_of_type_Aosm.d();
  }
  
  protected final String c()
  {
    return this.jdField_a_of_type_Aosm.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */