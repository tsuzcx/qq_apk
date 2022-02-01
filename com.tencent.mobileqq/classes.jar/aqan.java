import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqan
  implements View.OnClickListener
{
  public aqan(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    bkzi localbkzi = (bkzi)bkzz.a(BaseActivity.sTopActivity, null);
    localbkzi.a(BaseActivity.sTopActivity.getString(2131690170));
    localbkzi.a(2131690169, 3);
    localbkzi.c(2131690168);
    localbkzi.setOnDismissListener(new aqao(this, localbkzi));
    localbkzi.a(new aqap(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqan
 * JD-Core Version:    0.7.0.1
 */