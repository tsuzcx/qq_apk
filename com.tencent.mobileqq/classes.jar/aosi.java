import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class aosi
  extends aosk
{
  protected aosi(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  private void b()
  {
    Intent localIntent = this.jdField_a_of_type_Aosm.a();
    String str3 = this.jdField_a_of_type_Aosm.b();
    String str2 = this.jdField_a_of_type_Aosm.c();
    String str1 = this.jdField_a_of_type_Aosm.d();
    Bitmap localBitmap = this.jdField_a_of_type_Aosm.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a(true);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b(true);
    localStringBuffer.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694337), new Object[] { Integer.valueOf(j) }));
    if (i > 1000)
    {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694338));
      if (j <= 1) {
        break label275;
      }
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.b);
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694350);
      str1 = localStringBuffer.toString();
      localBitmap = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Aosm.a(localBitmap);
      this.jdField_a_of_type_Aosm.a(localIntent);
      this.jdField_a_of_type_Aosm.c(str2);
      this.jdField_a_of_type_Aosm.d(str1);
      this.jdField_a_of_type_Aosm.b(str3);
      return;
      localStringBuffer.append(i).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694276));
      break;
      label275:
      QLog.d("[NotificationRebuild] [NotificationProcessor] AbstractBuildLastDefaultNotificationProcessor", 1, new Object[] { "[notification] buildNotificationElement: invoked. 非独立会话数<=1，保持旧的跳转、图标、wording 已经从上面switch-case中获取 ", " conversationSizeNotSeparate: ", Integer.valueOf(j) });
    }
  }
  
  protected final int b(QQMessageFacade.Message paramMessage)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    if (bkyy.a(i, paramMessage))
    {
      if (bool) {
        return bkyy.a().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
  
  @NotNull
  protected final aosm b(QQMessageFacade.Message paramMessage)
  {
    a();
    a(paramMessage, this.jdField_a_of_type_Aosm);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() > 1) {
      i = 1;
    }
    while (i != 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a(true) == 0)
      {
        return null;
        i = 0;
      }
      else
      {
        b();
      }
    }
    return this.jdField_a_of_type_Aosm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosi
 * JD-Core Version:    0.7.0.1
 */