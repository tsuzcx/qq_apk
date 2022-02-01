import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aqni
  implements Manager
{
  QQAppInterface a;
  
  public aqni(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static aqni a(QQAppInterface paramQQAppInterface)
  {
    return (aqni)paramQQAppInterface.getManager(QQManagerFactory.NOTIFICATION_BANNER_MANAGER);
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = bhfb.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(aldh paramaldh, Message paramMessage)
  {
    paramaldh.a(21, 2);
    paramaldh.a(21, paramMessage);
    bdla.a(this.a, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    long l = bhhr.c(this.a.getCurrentUin());
    return System.currentTimeMillis() - l < arch.a().a();
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bhhr.b(this.a.getCurrentUin(), l);
  }
  
  public void a(aldh paramaldh)
  {
    paramaldh.a(21, 0);
    paramaldh.a(-1, null);
  }
  
  public void a(aldh paramaldh, Message paramMessage)
  {
    if (b())
    {
      b(paramaldh, paramMessage);
      return;
    }
    a(paramaldh);
  }
  
  public void a(aldh paramaldh, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramaldh, null, paramView);
    paramaldh.a(paramView);
    if (b())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(aldh paramaldh, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = arch.a().a();
    String str2 = arch.a().b();
    paramTipsBar.setTipsIcon(this.a.getApp().getResources().getDrawable(2130841339));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.a().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.a(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).a();
    }
    paramTipsBar.a().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new aqnj(this, paramaldh));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new aqnk(this, paramBaseActivity));
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
    boolean bool1 = arch.a().a();
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
 * Qualified Name:     aqni
 * JD-Core Version:    0.7.0.1
 */