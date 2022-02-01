import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;

public final class anoy
  extends anpq
{
  protected anoy(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    Intent localIntent = this.jdField_a_of_type_Anpt.a();
    localIntent.putExtra("need_report", true);
    localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
    localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
    localIntent.putExtra("KEY_FROM", "notifcation");
    if (awha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) {
      localIntent.putExtra("key_reactive_push_tip", true);
    }
    this.jdField_a_of_type_Anpt.a(localIntent);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
      this.jdField_a_of_type_Anpt.a((Bitmap)localObject1);
    }
    Object localObject1 = a() + ": ";
    this.jdField_a_of_type_Anpt.b((String)localObject1);
    localObject1 = c();
    Object localObject2 = bjnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject2 != null)
    {
      localObject2 = ((bjnm)localObject2).a(a(), paramMessage);
      this.jdField_a_of_type_Anpt.c((String)localObject2);
    }
    localObject1 = apka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject1, paramMessage);
    this.jdField_a_of_type_Anpt.d((String)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() <= 1) {}
    for (;;)
    {
      if (i != 0) {
        a(paramMessage);
      }
      return b(paramMessage);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoy
 * JD-Core Version:    0.7.0.1
 */