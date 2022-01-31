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

public class amgf
  implements Manager
{
  QQAppInterface a;
  
  public amgf(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static amgf a(QQAppInterface paramQQAppInterface)
  {
    return (amgf)paramQQAppInterface.getManager(157);
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = bbfa.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(ahkd paramahkd, Message paramMessage)
  {
    paramahkd.a(18, 2);
    paramahkd.a(18, paramMessage);
    axqy.a(this.a, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    long l = bbkb.c(this.a.c());
    return System.currentTimeMillis() - l < amtk.a().a();
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bbkb.b(this.a.c(), l);
  }
  
  public void a(ahkd paramahkd)
  {
    paramahkd.a(18, 0);
    paramahkd.a(-1, null);
  }
  
  public void a(ahkd paramahkd, Message paramMessage)
  {
    if (b())
    {
      b(paramahkd, paramMessage);
      return;
    }
    a(paramahkd);
  }
  
  public void a(ahkd paramahkd, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramahkd, null, paramView);
    paramahkd.a(paramView);
    if (b())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(ahkd paramahkd, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = amtk.a().a();
    String str2 = amtk.a().b();
    paramTipsBar.setTipsIcon(this.a.getApp().getResources().getDrawable(2130840918));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.a().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.a(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).a();
    }
    paramTipsBar.a().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new amgg(this, paramahkd));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new amgh(this, paramBaseActivity));
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
    boolean bool1 = amtk.a().a();
    boolean bool2 = a();
    boolean bool3 = c();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "bannerVisible: invoked. ", " confVisible: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(bool2), " limitedByDuration: ", Boolean.valueOf(bool3) });
    }
    return (bool1) && (!bool2) && (!bool3);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgf
 * JD-Core Version:    0.7.0.1
 */