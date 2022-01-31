import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class amkb
  extends BroadcastReceiver
{
  public amkb(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    paramContext = paramIntent.getAction();
    String str = paramIntent.getStringExtra("process_name");
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "mReceiver action : " + paramContext + ", process_name :" + str);
    }
    for (;;)
    {
      try
      {
        if (this.a.b == null) {
          break label541;
        }
        this.a.a().removeCallbacks(this.a.b);
        if (!paramContext.equals("action_update_cn_smallscreen_state")) {
          break label405;
        }
        i = paramIntent.getIntExtra("param_from", -1);
        if (!QLog.isDevelopLevel()) {
          break label546;
        }
        QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : " + i);
      }
      catch (Throwable paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label589;
        }
      }
      if (i == 0) {
        break label589;
      }
      this.a.a().removeCallbacks(this.a.b);
      this.a.a().postDelayed(this.a.b, 200L);
      return;
      this.a.e = paramIntent.getBooleanExtra("param_not_in_colornote_list", true);
      break label584;
      QLog.d("ColorNoteSmallScreenService", 2, "mReceiver fail", paramContext);
      return;
      ColorNoteSmallScreenService.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("param_shoule_show_smallscreen", true);
      if (!QLog.isDevelopLevel()) {
        break label584;
      }
      QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : FromType_BusinessLimit mShouldShow = " + ColorNoteSmallScreenService.jdField_a_of_type_Boolean);
      break label584;
      paramContext = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      this.a.jdField_a_of_type_Int = paramContext.size();
      this.a.jdField_a_of_type_Amjl.a(paramContext);
      this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(paramContext);
      break label584;
      paramContext = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      if ((amgt.a()) || (((paramContext.size() != 1) || (!amhh.b((ColorNote)paramContext.get(0)))) && (paramContext.size() != 0))) {
        break label584;
      }
      this.a.f();
      break label584;
      boolean bool = paramIntent.getBooleanExtra("param_custom_night_mode", false);
      this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCustomNightMode(bool);
      break label584;
      label405:
      if (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
        break;
      }
      this.a.d = false;
      this.a.f = false;
      i = 1;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
      if ((str == null) || (!str.contains("openSdk"))) {
        break label590;
      }
    }
    label541:
    label546:
    label584:
    label589:
    label590:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.a.d = true;
        this.a.f = false;
        i = 1;
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a() > 0)
      {
        this.a.f = true;
        i = j;
        break;
      }
      this.a.d = true;
      this.a.f = false;
      i = j;
      break;
      i = 1;
      break;
      switch (i)
      {
      }
      i = 1;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkb
 * JD-Core Version:    0.7.0.1
 */