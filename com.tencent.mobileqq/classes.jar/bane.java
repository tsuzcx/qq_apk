import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class bane
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bane(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bane(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("http://")) || (this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("https://"));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    String str1;
    do
    {
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while (TextUtils.isEmpty(str1));
    try
    {
      String str2 = aber.b(str1, aber.b(2));
      if (QLog.isColorLevel()) {
        QLog.i("HttpMqqJumper", 2, "openMoreOptions uin:" + str1 + " uinCode:" + str2);
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      Object localObject2 = new ArrayList();
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      localObject1 = aber.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 25004, 10, (List)localObject2);
      localObject2 = ((String)localObject1).replaceAll(str1, str2);
      Bundle localBundle = aber.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("HttpMqqJumper", 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject1 + "  reportMsg: " + (String)localObject2);
      }
      aber.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, str1, str2, null, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 25004, (String)localObject2, localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HttpMqqJumper", 1, "openMoreOptions safetyReport error" + localThrowable.getMessage());
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("mqq://jubao.qq.com");
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("mqq://");
  }
  
  public bane a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    return this;
  }
  
  public bane a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    return this;
  }
  
  public bane a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject;
    label94:
    do
    {
      do
      {
        for (;;)
        {
          localObject = null;
          if (b())
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replace("mqq://", "https://");
            b();
          }
          while (localObject != null)
          {
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            return;
            if (!a()) {
              break label94;
            }
            localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
          }
        }
        if (!c()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    ((bhmr)localObject).a();
    ((bhmr)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bane
 * JD-Core Version:    0.7.0.1
 */