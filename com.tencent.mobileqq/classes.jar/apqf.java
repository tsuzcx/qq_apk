import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apqf
  implements View.OnClickListener
{
  public apqf(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    bkho localbkho = (bkho)bkif.a(BaseActivity.sTopActivity, null);
    localbkho.a(BaseActivity.sTopActivity.getString(2131690102));
    localbkho.a(2131690101, 3);
    localbkho.c(2131690103);
    localbkho.setOnDismissListener(new apqg(this, localbkho));
    localbkho.a(new apqh(this, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqf
 * JD-Core Version:    0.7.0.1
 */