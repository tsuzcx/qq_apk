import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bghi
  implements View.OnClickListener
{
  bghi(bghh parambghh) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)bghh.a(this.a).get();
    if (localBaseActivity != null)
    {
      bgpk.a(bghh.b(this.a), bghh.c(this.a).a);
      Object localObject1 = bgtj.a();
      Object localObject2 = ((bgtj)localObject1).a("troop_list_homework");
      bgtk localbgtk = new bgtk();
      localbgtk.a = bghh.d(this.a).a;
      localbgtk.c = "aio";
      localObject1 = ((bgtj)localObject1).a((String)localObject2, localbgtk);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      bhju.a(bghh.c(this.a), bghh.e(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { bghh.f(this.a).a, "", "", bhju.a(bghh.d(this.a), bghh.g(this.a).a) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghi
 * JD-Core Version:    0.7.0.1
 */