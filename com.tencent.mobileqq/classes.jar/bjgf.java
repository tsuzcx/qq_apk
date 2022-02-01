import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

class bjgf
  extends ClickableSpan
{
  bjgf(bjgd parambjgd) {}
  
  public void onClick(View paramView)
  {
    paramView = StorageUtil.getPreference().getString("mini_shortcut_help_url", "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15");
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    localIntent.setFlags(134217728);
    localIntent.putExtra("url", paramView);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    bjgd.a(this.a).startActivityForResult(localIntent, 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgf
 * JD-Core Version:    0.7.0.1
 */