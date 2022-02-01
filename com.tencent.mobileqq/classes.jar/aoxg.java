import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aoxg
  implements View.OnClickListener
{
  public aoxg(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    bjnw localbjnw = (bjnw)bjon.a(BaseActivity.sTopActivity, null);
    localbjnw.a(BaseActivity.sTopActivity.getString(2131690129));
    localbjnw.a(2131690128, 3);
    localbjnw.c(2131690130);
    localbjnw.setOnDismissListener(new aoxh(this, localbjnw));
    localbjnw.a(new aoxi(this, localbjnw));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxg
 * JD-Core Version:    0.7.0.1
 */