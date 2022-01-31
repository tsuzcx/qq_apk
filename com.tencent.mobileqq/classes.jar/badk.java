import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class badk
  implements View.OnClickListener
{
  badk(badj parambadj) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)badj.a(this.a).get();
    if (paramView != null)
    {
      bahk.a(badj.a(this.a), badj.a(this.a).a);
      Object localObject1 = bali.a();
      Object localObject2 = ((bali)localObject1).a("troop_list_homework");
      balj localbalj = new balj();
      localbalj.a = badj.b(this.a).a;
      localbalj.c = "aio";
      localObject1 = ((bali)localObject1).a((String)localObject2, localbalj);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      bbbb.a(badj.b(this.a), badj.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { badj.d(this.a).a, "", "", bbbb.a(badj.c(this.a), badj.e(this.a).a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badk
 * JD-Core Version:    0.7.0.1
 */