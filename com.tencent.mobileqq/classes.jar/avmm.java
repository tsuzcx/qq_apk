import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avmm
  implements View.OnClickListener
{
  avmm(avmf paramavmf) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://buluo.qq.com/mobile/xxq_setting.html?_wv=1027&uin=" + this.a.a.app.c());
    paramView.putExtra("reqType", 1);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmm
 * JD-Core Version:    0.7.0.1
 */