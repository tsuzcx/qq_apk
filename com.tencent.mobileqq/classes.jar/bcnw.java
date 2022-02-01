import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.studymode.KidModeUtils.1;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class bcnw
{
  public static void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramFragmentActivity == null)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    new bhig(paramFragmentActivity).a(str, paramFragmentActivity.getTitleBarHeight(), 0, paramInt);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.d("KidModeUtils", 1, new Object[] { "call judge from=", paramString });
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeUtils", 2, "judgeAndShowUpgradeKidMode App=null");
      return;
    }
    if (!bcoo.a())
    {
      QLog.d("KidModeUtils", 2, "judgeAndShowUpgradeKidMode Switch=OFF");
      c(paramQQAppInterface);
      return;
    }
    if (a(paramQQAppInterface))
    {
      QLog.d("KidModeUtils", 2, "hasShowUpgradeTipsAtVersion=true");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new KidModeUtils.1(paramQQAppInterface));
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((Boolean)bfyz.a(BaseApplicationImpl.getContext(), "", "study_mode_upgrade_dialog_has_show1", Boolean.valueOf(false))).booleanValue();
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (BaseActivity.sTopActivity == null)
    {
      QLog.d("KidModeUtils", 2, "showKidModeUpgradeDialog sTopActivity is null");
      return;
    }
    QQCustomDialog localQQCustomDialog = bfur.a(BaseActivity.sTopActivity, 230, 2131559016, null, BaseApplicationImpl.sApplication.getString(2131718629), BaseApplicationImpl.sApplication.getString(2131718628), null, null, new bcnx());
    if (!localQQCustomDialog.isShowing()) {
      localQQCustomDialog.show();
    }
    c(paramQQAppInterface);
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.d("KidModeUtils", 1, new Object[] { "call judge from=", paramString });
    if (!bcoo.a())
    {
      QLog.d("KidModeUtils", 2, "manualSwitchMark Switch=OFF");
      return;
    }
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeUtils", 2, "manualSwitchMark App=null");
      return;
    }
    if (a(paramQQAppInterface))
    {
      QLog.d("KidModeUtils", 2, "hasShowUpgradeTipsAtVersion=true");
      return;
    }
    c(paramQQAppInterface);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    bfyz.a(BaseApplicationImpl.getContext(), "", true, "study_mode_upgrade_dialog_has_show1", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnw
 * JD-Core Version:    0.7.0.1
 */