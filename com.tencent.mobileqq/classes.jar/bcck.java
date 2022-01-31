import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class bcck
  implements View.OnClickListener
{
  bcck(bccj parambccj) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)bccj.a(this.a).get();
    if (paramView != null)
    {
      bcgk.a(bccj.a(this.a), bccj.a(this.a).a);
      Object localObject1 = bckj.a();
      Object localObject2 = ((bckj)localObject1).a("troop_list_homework");
      bckk localbckk = new bckk();
      localbckk.a = bccj.b(this.a).a;
      localbckk.c = "aio";
      localObject1 = ((bckj)localObject1).a((String)localObject2, localbckk);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      bdaj.a(bccj.b(this.a), bccj.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { bccj.d(this.a).a, "", "", bdaj.a(bccj.c(this.a), bccj.e(this.a).a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcck
 * JD-Core Version:    0.7.0.1
 */