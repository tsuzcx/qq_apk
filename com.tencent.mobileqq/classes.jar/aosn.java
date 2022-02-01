import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class aosn
{
  private aosm jdField_a_of_type_Aosm;
  private final QQMessageFacade.Message jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  
  public aosn(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message = paramMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aosm = new aosm();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_Aosm.a();
  }
  
  private Bitmap a()
  {
    return this.jdField_a_of_type_Aosm.a();
  }
  
  private String a()
  {
    return this.jdField_a_of_type_Aosm.b();
  }
  
  private void a()
  {
    Object localObject = aorq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
    this.jdField_a_of_type_Aosm.a((String)localObject);
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
    this.jdField_a_of_type_Aosm.c((String)localObject);
  }
  
  private String b()
  {
    return this.jdField_a_of_type_Aosm.c();
  }
  
  private void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message, true);
    this.jdField_a_of_type_Aosm.a(localIntent);
    a().putExtra("entrance", 6);
    a().putExtra("key_notification_click_action", true);
  }
  
  private String c()
  {
    return this.jdField_a_of_type_Aosm.d();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aosm.b(null);
    }
  }
  
  @Nullable
  public aosm a()
  {
    b();
    a();
    int i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message.istroop;
    Object localObject = aoso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_Aosm);
    if (localObject != null)
    {
      this.jdField_a_of_type_Aosm = ((aosk)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
      if (this.jdField_a_of_type_Aosm != null) {}
    }
    else
    {
      return null;
    }
    i = ((aosk)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
    if (a() == null)
    {
      localObject = new Intent();
      this.jdField_a_of_type_Aosm.a((Intent)localObject);
    }
    a().putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", i);
    a().putExtra("param_notifyid", i);
    c();
    QLog.d("[NotificationRebuild] NotificationElementBuilder", 2, new Object[] { "[create] build: invoked. ", " notificationElement: ", this.jdField_a_of_type_Aosm });
    return this.jdField_a_of_type_Aosm;
  }
  
  @NotNull
  public String toString()
  {
    if (this.jdField_a_of_type_Aosm == null) {
      return "notificationElement: null";
    }
    Bundle localBundle = null;
    if (a() != null) {
      localBundle = a().getExtras();
    }
    if (a() != null) {}
    for (String str = String.valueOf(a().getHeight());; str = "using default bitmap") {
      return "NotificationElementBuilder{contentIntentExtras=" + localBundle + ", ticker='" + a() + '\'' + ", contentTitle='" + b() + '\'' + ", notificationContentText='" + c() + '\'' + ", notificationIconBitmapStr=" + str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosn
 * JD-Core Version:    0.7.0.1
 */