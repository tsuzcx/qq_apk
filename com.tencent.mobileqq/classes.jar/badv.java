import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class badv
  implements View.OnClickListener
{
  badv(badu parambadu) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(badu.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    badu.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badv
 * JD-Core Version:    0.7.0.1
 */