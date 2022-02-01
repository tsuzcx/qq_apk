import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class beqq
  implements View.OnClickListener
{
  beqq(beqp parambeqp) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)beqp.a(this.a).get();
    if (localBaseActivity != null)
    {
      beyy.a(beqp.b(this.a), beqp.c(this.a).curFriendUin);
      Object localObject1 = bfcx.a();
      Object localObject2 = ((bfcx)localObject1).a("troop_list_homework");
      bfcy localbfcy = new bfcy();
      localbfcy.a = beqp.d(this.a).curFriendUin;
      localbfcy.c = "aio";
      localObject1 = ((bfcx)localObject1).a((String)localObject2, localbfcy);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      bftc.a(beqp.c(this.a), beqp.e(this.a).curFriendUin, "homework", "AioSee_Clk", 0, 0, new String[] { beqp.f(this.a).curFriendUin, "", "", bftc.a(beqp.d(this.a), beqp.g(this.a).curFriendUin) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqq
 * JD-Core Version:    0.7.0.1
 */