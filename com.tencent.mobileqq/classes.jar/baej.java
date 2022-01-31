import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class baej
  implements View.OnClickListener
{
  baej(baei parambaei) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(baei.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    baei.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baej
 * JD-Core Version:    0.7.0.1
 */