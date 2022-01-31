import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class anlq
  implements View.OnClickListener
{
  public anlq(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bhpy)bhql.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131690265));
    paramView.a(2131690264, 3);
    paramView.c(2131690266);
    paramView.setOnDismissListener(new anlr(this, paramView));
    paramView.a(new anls(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlq
 * JD-Core Version:    0.7.0.1
 */