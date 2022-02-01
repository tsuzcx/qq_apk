import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apqi
  implements View.OnClickListener
{
  public apqi(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    bkho localbkho = (bkho)bkif.a(BaseActivity.sTopActivity, null);
    localbkho.a(BaseActivity.sTopActivity.getString(2131690105));
    localbkho.a(2131690104, 3);
    localbkho.c(2131690103);
    localbkho.setOnDismissListener(new apqj(this, localbkho));
    localbkho.a(new apqk(this, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqi
 * JD-Core Version:    0.7.0.1
 */