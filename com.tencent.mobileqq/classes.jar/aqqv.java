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

public class aqqv
  implements Manager
{
  QQAppInterface a;
  
  public aqqv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static aqqv a(QQAppInterface paramQQAppInterface)
  {
    return (aqqv)paramQQAppInterface.getManager(157);
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = bhnl.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(aljw paramaljw, Message paramMessage)
  {
    paramaljw.a(19, 2);
    paramaljw.a(19, paramMessage);
    bdll.a(this.a, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    long l = bhsi.c(this.a.c());
    return System.currentTimeMillis() - l < arfo.a().a();
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bhsi.b(this.a.c(), l);
  }
  
  public void a(aljw paramaljw)
  {
    paramaljw.a(19, 0);
    paramaljw.a(-1, null);
  }
  
  public void a(aljw paramaljw, Message paramMessage)
  {
    if (b())
    {
      b(paramaljw, paramMessage);
      return;
    }
    a(paramaljw);
  }
  
  public void a(aljw paramaljw, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramaljw, null, paramView);
    paramaljw.a(paramView);
    if (b())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(aljw paramaljw, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = arfo.a().a();
    String str2 = arfo.a().b();
    paramTipsBar.setTipsIcon(this.a.getApp().getResources().getDrawable(2130841297));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.a().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.a(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).a();
    }
    paramTipsBar.a().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new aqqw(this, paramaljw));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new aqqx(this, paramBaseActivity));
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
    boolean bool1 = arfo.a().a();
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
 * Qualified Name:     aqqv
 * JD-Core Version:    0.7.0.1
 */