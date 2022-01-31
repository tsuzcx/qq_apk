import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class anqc
  implements View.OnClickListener
{
  public anqc(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bhuf)bhus.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131690268));
    paramView.a(2131690267, 3);
    paramView.c(2131690266);
    paramView.setOnDismissListener(new anqd(this, paramView));
    paramView.a(new anqe(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqc
 * JD-Core Version:    0.7.0.1
 */