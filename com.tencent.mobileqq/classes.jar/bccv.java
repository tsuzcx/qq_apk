import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class bccv
  implements View.OnClickListener
{
  bccv(bccu parambccu) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(bccu.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    bccu.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccv
 * JD-Core Version:    0.7.0.1
 */