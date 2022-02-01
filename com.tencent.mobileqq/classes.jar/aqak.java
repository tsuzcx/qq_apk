import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqak
  implements View.OnClickListener
{
  public aqak(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    bkzi localbkzi = (bkzi)bkzz.a(BaseActivity.sTopActivity, null);
    localbkzi.a(BaseActivity.sTopActivity.getString(2131690167));
    localbkzi.a(2131690166, 3);
    localbkzi.c(2131690168);
    localbkzi.setOnDismissListener(new aqal(this, localbkzi));
    localbkzi.a(new aqam(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqak
 * JD-Core Version:    0.7.0.1
 */