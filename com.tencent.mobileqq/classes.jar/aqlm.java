import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.3;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqlm
{
  private aqls a;
  
  private static String a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    return paramString1.replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramString2).replace("$APPID$", paramString3);
  }
  
  private static void a(BaseChatPie paramBaseChatPie, aqla paramaqla)
  {
    if (String.valueOf(101761547).equals(paramaqla.jdField_a_of_type_JavaLangString)) {
      awfq.b(paramBaseChatPie.app, paramBaseChatPie.getActivity(), 2, paramBaseChatPie.sessionInfo.curFriendUin, 0);
    }
    do
    {
      do
      {
        return;
        if (String.valueOf(101817424).equals(paramaqla.jdField_a_of_type_JavaLangString))
        {
          a(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramBaseChatPie.sessionInfo.curFriendUin);
          return;
        }
      } while ((!String.valueOf(101872203).equals(paramaqla.jdField_a_of_type_JavaLangString)) || (nqi.a(paramBaseChatPie.getActivity(), paramBaseChatPie.sessionInfo.curFriendUin)));
      paramaqla = (ncz)paramBaseChatPie.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    } while (paramaqla == null);
    paramaqla.a(paramBaseChatPie.getActivity(), 2, paramBaseChatPie.sessionInfo.curFriendUin, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (bejv)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = paramQQAppInterface.a(4, -1, paramString);
    Bundle localBundle = beki.a(bool, 3);
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
    List localList = aqlp.a(paramBaseChatPie.app).a(paramBaseChatPie.sessionInfo.curFriendUin);
    this.a = new aqls(paramBaseChatPie.getActivity(), paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin, localList, new aqln(this, paramBaseChatPie), paramBaseChatPie instanceof aici);
    this.a.a();
    bdla.b(paramBaseChatPie.app, "dc00898", "", "", "0X800B32B", "0X800B32B", aqlp.a(paramBaseChatPie.app).a(paramBaseChatPie.sessionInfo.curFriendUin), 0, "", "", "", "");
    return true;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, aqla paramaqla)
  {
    byte[] arrayOfByte;
    int j;
    int i;
    if (paramaqla.jdField_a_of_type_Boolean)
    {
      arrayOfByte = null;
      if (!(paramBaseChatPie instanceof aici)) {
        break label188;
      }
      j = paramBaseChatPie.sessionInfo.curType;
      if (1044 == j)
      {
        i = 163;
        arrayOfByte = paramBaseChatPie.app.getMsgCache().a(paramBaseChatPie.sessionInfo.curFriendUin, paramBaseChatPie.app.getCurrentAccountUin(), true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarJumpController", 2, "sendArk() curType = " + i + " sig = " + arrayOfByte);
      }
      MiniAppCmdUtil.getInstance().createUpdatableMsg(paramaqla.jdField_a_of_type_JavaLangString, "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, paramBaseChatPie.sessionInfo.curFriendUin, i, arrayOfByte, new aqlo(this, paramBaseChatPie));
      return true;
      i = j;
      if (1045 == j)
      {
        i = 166;
        arrayOfByte = paramBaseChatPie.app.getMsgCache().a(paramBaseChatPie.sessionInfo.curFriendUin, paramBaseChatPie.app.getCurrentAccountUin(), false);
        continue;
        return false;
        label188:
        i = 0;
      }
    }
  }
  
  private static void b(BaseChatPie paramBaseChatPie, aqla paramaqla)
  {
    if ((!TextUtils.isEmpty(paramaqla.jdField_d_of_type_JavaLangString)) && (paramaqla.jdField_d_of_type_JavaLangString.startsWith("mqqapi")))
    {
      paramaqla.jdField_d_of_type_JavaLangString = a(paramaqla.jdField_d_of_type_JavaLangString, paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin, paramaqla.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(paramBaseChatPie.getActivity(), JumpActivity.class);
      localIntent.setData(Uri.parse(paramaqla.jdField_d_of_type_JavaLangString));
      paramBaseChatPie.getActivity().startActivity(localIntent);
    }
  }
  
  private static void c(BaseChatPie paramBaseChatPie, aqla paramaqla)
  {
    if ((!TextUtils.isEmpty(paramaqla.jdField_d_of_type_JavaLangString)) && ((paramaqla.jdField_d_of_type_JavaLangString.startsWith("http")) || (paramaqla.jdField_d_of_type_JavaLangString.startsWith("https"))))
    {
      Intent localIntent = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", a(paramaqla.jdField_d_of_type_JavaLangString, paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin, paramaqla.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseChatPie.getActivity().startActivity(localIntent);
    }
  }
  
  private static void d(BaseChatPie paramBaseChatPie, aqla paramaqla)
  {
    if ((!TextUtils.isEmpty(paramaqla.jdField_d_of_type_JavaLangString)) && (MiniAppLauncher.isMiniAppUrl(paramaqla.jdField_d_of_type_JavaLangString))) {
      if (!(paramBaseChatPie instanceof aici)) {
        break label102;
      }
    }
    label102:
    for (int i = 4017;; i = 4016)
    {
      EntryModel localEntryModel = new EntryModel(0, Long.valueOf(paramBaseChatPie.sessionInfo.curFriendUin).longValue(), ContactUtils.getFriendNickName(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin), false);
      MiniAppLauncher.startMiniApp(paramBaseChatPie.getActivity(), a(paramaqla.jdField_d_of_type_JavaLangString, paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin, paramaqla.jdField_a_of_type_JavaLangString), i, localEntryModel, null);
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
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getActivity() == null)) {
      return;
    }
    paramBaseChatPie.getActivity().runOnUiThread(new C2CShortcutBarJumpController.3(this, paramBaseChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie, aqla paramaqla, boolean paramBoolean)
  {
    if ((paramaqla == null) || (paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.getActivity() == null) || (paramBaseChatPie.getActivity() == null))
    {
      QLog.d("C2CShortcutBarJumpController", 1, "handlerJumpAction() param is null just return ");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarJumpController", 2, new Object[] { "isClickManager", Boolean.valueOf(paramBoolean), " { info = ", paramaqla.toString() });
    }
    if (paramBoolean)
    {
      a(paramBaseChatPie);
      return;
    }
    switch (paramaqla.jdField_d_of_type_Int)
    {
    default: 
      QLog.d("C2CShortcutBarJumpController", 1, new Object[] { "handlerJumpAction() unknown type: ", Long.valueOf(paramaqla.jdField_a_of_type_Long) });
      return;
    case 1: 
      b(paramBaseChatPie, paramaqla);
      return;
    case 2: 
      c(paramBaseChatPie, paramaqla);
      return;
    case 3: 
      d(paramBaseChatPie, paramaqla);
      return;
    case 4: 
      a(paramBaseChatPie, paramaqla);
      return;
    }
    a(paramBaseChatPie, paramaqla);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlm
 * JD-Core Version:    0.7.0.1
 */