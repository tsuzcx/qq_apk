import android.view.View;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class amow
  implements ampb
{
  public amow(QQDailyArkView paramQQDailyArkView) {}
  
  public void a()
  {
    if (QQDailyArkView.a(this.a) == null) {}
    View localView;
    do
    {
      return;
      QQDailyArkView.b(this.a);
      QQDailyArkView.a(this.a).setVisibility(0);
      localView = QQDailyArkView.a(this.a).findViewById(2131369767);
      QQDailyArkView.a(this.a, QQDailyArkView.a(this.a), 0);
      this.a.requestLayout();
    } while (localView == null);
    localView.setVisibility(0);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, ArkViewModel paramArkViewModel)
  {
    if (QQDailyArkView.a(this.a) == null) {
      return;
    }
    if ((paramArkViewModel != null) && (paramArkViewModel.GetAppScriptType() == 2) && (!ArkAppCenter.d()))
    {
      QLog.i("QQDailyArkView", 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      a();
      return;
    }
    paramString = QQDailyArkView.a(this.a);
    if (paramBoolean) {
      paramString.setOnClickListener(new amox(this, paramArkViewModel));
    }
    for (;;)
    {
      QQDailyArkView.b(this.a);
      paramString.setVisibility(0);
      paramArkViewModel = paramString.findViewById(2131369767);
      QQDailyArkView.a(this.a, paramString, 0);
      this.a.requestLayout();
      if (paramArkViewModel == null) {
        break;
      }
      paramArkViewModel.setVisibility(4);
      return;
      paramString.setOnClickListener(null);
    }
  }
  
  public void b()
  {
    if (QQDailyArkView.a(this.a) == null) {
      return;
    }
    QQDailyArkView.a(this.a).setVisibility(8);
    QQDailyArkView.a(this.a, QQDailyArkView.a(this.a), 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amow
 * JD-Core Version:    0.7.0.1
 */