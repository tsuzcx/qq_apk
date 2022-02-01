import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.3;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqoz
{
  private aqpf a;
  
  private static String a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    return paramString1.replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramString2).replace("$APPID$", paramString3);
  }
  
  private static void a(BaseChatPie paramBaseChatPie, aqon paramaqon)
  {
    if (String.valueOf(101761547).equals(paramaqon.jdField_a_of_type_JavaLangString)) {
      awml.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), 2, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    do
    {
      do
      {
        return;
        if (String.valueOf(101817424).equals(paramaqon.jdField_a_of_type_JavaLangString))
        {
          a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
      } while ((!String.valueOf(101872203).equals(paramaqon.jdField_a_of_type_JavaLangString)) || (nhv.a(paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      paramaqon = (mxc)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    } while (paramaqon == null);
    paramaqon.a(paramBaseChatPie.a(), 2, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (bejx)paramQQAppInterface.getManager(339);
    boolean bool = paramQQAppInterface.a(4, -1, paramString);
    Bundle localBundle = bekk.a(bool, 3);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramString, 2, 4, 3, localBundle);
      return;
    }
    paramQQAppInterface.a(paramContext, paramString, 2, 4, 3, localBundle);
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    a();
    List localList = aqpc.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.a = new aqpf(paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localList, new aqpa(this, paramBaseChatPie), paramBaseChatPie instanceof aimd);
    this.a.a();
    bdll.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B32B", "0X800B32B", aqpc.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    return true;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, aqon paramaqon)
  {
    byte[] arrayOfByte;
    int j;
    int i;
    if (paramaqon.jdField_a_of_type_Boolean)
    {
      arrayOfByte = null;
      if (!(paramBaseChatPie instanceof aimd)) {
        break label188;
      }
      j = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (1044 == j)
      {
        i = 163;
        arrayOfByte = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarJumpController", 2, "sendArk() curType = " + i + " sig = " + arrayOfByte);
      }
      MiniAppCmdUtil.getInstance().createUpdatableMsg(paramaqon.jdField_a_of_type_JavaLangString, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, arrayOfByte, new aqpb(this, paramBaseChatPie));
      return true;
      i = j;
      if (1045 == j)
      {
        i = 166;
        arrayOfByte = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        continue;
        return false;
        label188:
        i = 0;
      }
    }
  }
  
  private static void b(BaseChatPie paramBaseChatPie, aqon paramaqon)
  {
    if ((!TextUtils.isEmpty(paramaqon.jdField_d_of_type_JavaLangString)) && (paramaqon.jdField_d_of_type_JavaLangString.startsWith("mqqapi")))
    {
      paramaqon.jdField_d_of_type_JavaLangString = a(paramaqon.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramaqon.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(paramBaseChatPie.a(), JumpActivity.class);
      localIntent.setData(Uri.parse(paramaqon.jdField_d_of_type_JavaLangString));
      paramBaseChatPie.a().startActivity(localIntent);
    }
  }
  
  private static void c(BaseChatPie paramBaseChatPie, aqon paramaqon)
  {
    if ((!TextUtils.isEmpty(paramaqon.jdField_d_of_type_JavaLangString)) && ((paramaqon.jdField_d_of_type_JavaLangString.startsWith("http")) || (paramaqon.jdField_d_of_type_JavaLangString.startsWith("https"))))
    {
      Intent localIntent = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", a(paramaqon.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramaqon.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseChatPie.a().startActivity(localIntent);
    }
  }
  
  private static void d(BaseChatPie paramBaseChatPie, aqon paramaqon)
  {
    if ((!TextUtils.isEmpty(paramaqon.jdField_d_of_type_JavaLangString)) && (MiniAppLauncher.isMiniAppUrl(paramaqon.jdField_d_of_type_JavaLangString))) {
      if (!(paramBaseChatPie instanceof aimd)) {
        break label102;
      }
    }
    label102:
    for (int i = 4017;; i = 4016)
    {
      EntryModel localEntryModel = new EntryModel(0, Long.valueOf(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), bhlg.i(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), false);
      MiniAppLauncher.startMiniApp(paramBaseChatPie.a(), a(paramaqon.jdField_d_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramaqon.jdField_a_of_type_JavaLangString), i, localEntryModel, null);
      return;
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.b();
      this.a = null;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    paramBaseChatPie.a().runOnUiThread(new C2CShortcutBarJumpController.3(this, paramBaseChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie, aqon paramaqon, boolean paramBoolean)
  {
    if ((paramaqon == null) || (paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.a() == null) || (paramBaseChatPie.a() == null))
    {
      QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() param is null just return ");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarJumpController", 2, new Object[] { "isClickManager", Boolean.valueOf(paramBoolean), " { info = ", paramaqon.toString() });
    }
    if (paramBoolean)
    {
      a(paramBaseChatPie);
      return;
    }
    switch (paramaqon.jdField_d_of_type_Int)
    {
    default: 
      QLog.d("C2CShortcutBarJumpController", 1, new Object[] { "handlerJumpAction() unknown type: ", Long.valueOf(paramaqon.jdField_a_of_type_Long) });
      return;
    case 1: 
      b(paramBaseChatPie, paramaqon);
      return;
    case 2: 
      c(paramBaseChatPie, paramaqon);
      return;
    case 3: 
      d(paramBaseChatPie, paramaqon);
      return;
    case 4: 
      a(paramBaseChatPie, paramaqon);
      return;
    }
    a(paramBaseChatPie, paramaqon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoz
 * JD-Core Version:    0.7.0.1
 */