import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqdy
  implements View.OnClickListener
{
  public aqdy(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    blir localblir = (blir)blji.a(BaseActivity.sTopActivity, null);
    localblir.a(BaseActivity.sTopActivity.getString(2131690113));
    localblir.a(2131690112, 3);
    localblir.c(2131690111);
    localblir.setOnDismissListener(new aqdz(this, localblir));
    localblir.a(new aqea(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdy
 * JD-Core Version:    0.7.0.1
 */