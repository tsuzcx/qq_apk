import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class anpu
{
  private anpt jdField_a_of_type_Anpt;
  private final QQMessageFacade.Message jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  
  public anpu(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message = paramMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anpt = new anpt();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_Anpt.a();
  }
  
  private Bitmap a()
  {
    return this.jdField_a_of_type_Anpt.a();
  }
  
  private String a()
  {
    return this.jdField_a_of_type_Anpt.b();
  }
  
  private void a()
  {
    Object localObject = anox.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
    this.jdField_a_of_type_Anpt.a((String)localObject);
    String str = a().getStringExtra("uinname");
    if (str != null)
    {
      localObject = str;
      if (!"".equals(str)) {}
    }
    else
    {
      localObject = a().getStringExtra("uin");
    }
    this.jdField_a_of_type_Anpt.c((String)localObject);
  }
  
  private String b()
  {
    return this.jdField_a_of_type_Anpt.c();
  }
  
  private void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message, true);
    this.jdField_a_of_type_Anpt.a(localIntent);
    a().putExtra("entrance", 6);
    a().putExtra("key_notification_click_action", true);
  }
  
  private String c()
  {
    return this.jdField_a_of_type_Anpt.d();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Anpt.b(null);
    }
  }
  
  @Nullable
  public anpt a()
  {
    b();
    a();
    int i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message.istroop;
    Object localObject = anpv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_Anpt);
    if (localObject != null)
    {
      this.jdField_a_of_type_Anpt = ((anpr)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
      if (this.jdField_a_of_type_Anpt != null) {}
    }
    else
    {
      return null;
    }
    i = ((anpr)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
    if (a() == null)
    {
      localObject = new Intent();
      this.jdField_a_of_type_Anpt.a((Intent)localObject);
    }
    a().putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", i);
    a().putExtra("param_notifyid", i);
    c();
    QLog.d("[NotificationRebuild] NotificationElementBuilder", 2, new Object[] { "[create] build: invoked. ", " notificationElement: ", this.jdField_a_of_type_Anpt });
    return this.jdField_a_of_type_Anpt;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject3 = null;
    if (this.jdField_a_of_type_Anpt == null) {
      return "notificationElement: null";
    }
    if (a() != null) {}
    for (Object localObject2 = a().getExtras();; localObject2 = null)
    {
      Object localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((Bundle)localObject2).containsKey("KEY_NOTIFY_ID_FROM_PROCESSOR"))
        {
          localObject1 = new Bundle((Bundle)localObject2);
          ((Bundle)localObject1).remove("KEY_NOTIFY_ID_FROM_PROCESSOR");
        }
      }
      if (a() != null) {}
      for (localObject2 = String.valueOf(a().getHeight());; localObject2 = "using default bitmap") {
        return "NotificationElementBuilder{contentIntentExtras=" + localObject1 + ", ticker='" + a() + '\'' + ", contentTitle='" + b() + '\'' + ", notificationContentText='" + c() + '\'' + ", notificationIconBitmapStr=" + (String)localObject2 + '}' + "\n";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpu
 * JD-Core Version:    0.7.0.1
 */