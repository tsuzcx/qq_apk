import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bfhh
  implements View.OnClickListener
{
  bfhh(bfhg parambfhg) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)bfhg.a(this.a).get();
    if (localBaseActivity != null)
    {
      bfpj.a(bfhg.a(this.a), bfhg.a(this.a).a);
      Object localObject1 = bfti.a();
      Object localObject2 = ((bfti)localObject1).a("troop_list_homework");
      bftj localbftj = new bftj();
      localbftj.a = bfhg.b(this.a).a;
      localbftj.c = "aio";
      localObject1 = ((bfti)localObject1).a((String)localObject2, localbftj);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      bgjt.a(bfhg.b(this.a), bfhg.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { bfhg.d(this.a).a, "", "", bgjt.a(bfhg.c(this.a), bfhg.e(this.a).a) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhh
 * JD-Core Version:    0.7.0.1
 */