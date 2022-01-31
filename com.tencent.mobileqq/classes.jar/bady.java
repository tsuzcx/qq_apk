import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class bady
  implements View.OnClickListener
{
  bady(badx parambadx) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)badx.a(this.a).get();
    if (paramView != null)
    {
      bahy.a(badx.a(this.a), badx.a(this.a).a);
      Object localObject1 = balw.a();
      Object localObject2 = ((balw)localObject1).a("troop_list_homework");
      balx localbalx = new balx();
      localbalx.a = badx.b(this.a).a;
      localbalx.c = "aio";
      localObject1 = ((balw)localObject1).a((String)localObject2, localbalx);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      bbbp.a(badx.b(this.a), badx.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { badx.d(this.a).a, "", "", bbbp.a(badx.c(this.a), badx.e(this.a).a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bady
 * JD-Core Version:    0.7.0.1
 */