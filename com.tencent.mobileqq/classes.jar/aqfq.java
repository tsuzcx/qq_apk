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

public class aqfq
  extends BroadcastReceiver
{
  public aqfq(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getAction();
    paramContext = null;
    for (;;)
    {
      Object localObject;
      try
      {
        String str1 = paramIntent.getStringExtra("process_name");
        localObject = str1;
        paramContext = str1;
        if (QLog.isDevelopLevel())
        {
          paramContext = str1;
          QLog.w("ColorNoteSmallScreenService", 1, "mReceiver action : " + str2 + ", process_name :" + str1);
          localObject = str1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "action: " + str2, localException);
        localObject = paramContext;
        continue;
        this.a.e = paramIntent.getBooleanExtra("param_not_in_colornote_list", true);
      }
      try
      {
        if (this.a.b == null) {
          break;
        }
        this.a.a().removeCallbacks(this.a.b);
        if (!str2.equals("action_update_cn_smallscreen_state")) {
          break label549;
        }
        i = paramIntent.getIntExtra("param_from", -1);
        if (!QLog.isDevelopLevel()) {
          break label690;
        }
        QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : " + i);
      }
      catch (Throwable paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorNoteSmallScreenService", 2, "mReceiver fail", paramContext);
        return;
      }
      if (i != 0)
      {
        this.a.a().removeCallbacks(this.a.b);
        this.a.a().postDelayed(this.a.b, 200L);
      }
      return;
      ColorNoteSmallScreenService.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("param_shoule_show_smallscreen", true);
      if (QLog.isDevelopLevel())
      {
        QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : FromType_BusinessLimit mShouldShow = " + ColorNoteSmallScreenService.jdField_a_of_type_Boolean);
        break label728;
        paramContext = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        if ((paramContext != null) && (paramContext.size() != 0))
        {
          this.a.jdField_a_of_type_Int = paramContext.size();
          this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(paramContext);
          if (aqda.a(paramContext)) {
            ColorNoteSmallScreenService.a(this.a).a();
          }
          if (QLog.isColorLevel())
          {
            aqda.a("ColorNoteSmallScreenService", "[onReceive->FromType_UpdateData]\n[visibleColorNotes]: " + this.a.jdField_a_of_type_Int + "\n" + aqda.b(paramContext));
            break label728;
            paramContext = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
            if ((!aqci.a()) && (((paramContext.size() == 1) && (aqda.b((ColorNote)paramContext.get(0)))) || (paramContext.size() == 0)))
            {
              this.a.f();
              break label728;
              boolean bool = paramIntent.getBooleanExtra("param_custom_night_mode", false);
              this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCustomNightMode(bool);
              aqda.a("ColorNoteSmallScreenService", "[onReceive->FromType_CustomNightMode]\n[setCustomNightMode]: " + bool);
              break label728;
              label549:
              if ("mqq.intent.action.QQ_BACKGROUND".equals(str2))
              {
                this.a.d = false;
                this.a.f = false;
                i = 1;
              }
              else if ("mqq.intent.action.QQ_FOREGROUND".equals(str2))
              {
                if ((localObject == null) || (!((String)localObject).contains("openSdk"))) {
                  break label733;
                }
              }
            }
          }
        }
      }
    }
    label690:
    label728:
    label733:
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
        i = 0;
        break;
      }
      this.a.d = true;
      this.a.f = false;
      i = 0;
      break;
      i = 1;
      break;
      switch (i)
      {
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfq
 * JD-Core Version:    0.7.0.1
 */