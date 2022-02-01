import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class apke
  implements Manager
{
  QQAppInterface a;
  
  public apke(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static apke a(QQAppInterface paramQQAppInterface)
  {
    return (apke)paramQQAppInterface.getManager(157);
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = bfwj.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(akho paramakho, Message paramMessage)
  {
    paramakho.a(21, 2);
    paramakho.a(21, paramMessage);
    bcef.a(this.a, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    long l = bfyz.c(this.a.getCurrentUin());
    return System.currentTimeMillis() - l < apze.a().a();
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bfyz.b(this.a.getCurrentUin(), l);
  }
  
  public void a(akho paramakho)
  {
    paramakho.a(21, 0);
    paramakho.a(-1, null);
  }
  
  public void a(akho paramakho, Message paramMessage)
  {
    if (b())
    {
      b(paramakho, paramMessage);
      return;
    }
    a(paramakho);
  }
  
  public void a(akho paramakho, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramakho, null, paramView);
    paramakho.a(paramView);
    if (b())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(akho paramakho, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = apze.a().a();
    String str2 = apze.a().b();
    paramTipsBar.setTipsIcon(this.a.getApp().getResources().getDrawable(2130841333));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.a().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.a(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).a();
    }
    paramTipsBar.a().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new apkf(this, paramakho));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new apkg(this, paramBaseActivity));
    }
    paramTipsBar.setVisibility(8);
  }
  
  public boolean a()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool1 = apze.a().a();
    boolean bool2 = a();
    boolean bool3 = c();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "bannerVisible: invoked. ", " confVisible: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(bool2), " limitedByDuration: ", Boolean.valueOf(bool3) });
    }
    return (bool1) && (!bool2) && (!bool3);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apke
 * JD-Core Version:    0.7.0.1
 */