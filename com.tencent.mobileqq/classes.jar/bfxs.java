import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bfxs
  implements View.OnClickListener
{
  bfxs(bfxr parambfxr) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)bfxr.a(this.a).get();
    if (localBaseActivity != null)
    {
      bghd.a(bfxr.b(this.a), bfxr.c(this.a).curFriendUin);
      Object localObject1 = bgld.a();
      Object localObject2 = ((bgld)localObject1).a("troop_list_homework");
      bgle localbgle = new bgle();
      localbgle.a = bfxr.d(this.a).curFriendUin;
      localbgle.c = "aio";
      localObject1 = ((bgld)localObject1).a((String)localObject2, localbgle);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      bhbu.a(bfxr.c(this.a), bfxr.e(this.a).curFriendUin, "homework", "AioSee_Clk", 0, 0, new String[] { bfxr.f(this.a).curFriendUin, "", "", bhbu.a(bfxr.d(this.a), bfxr.g(this.a).curFriendUin) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxs
 * JD-Core Version:    0.7.0.1
 */