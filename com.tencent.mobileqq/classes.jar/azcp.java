import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class azcp
  implements View.OnClickListener
{
  azcp(azco paramazco) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)azco.a(this.a).get();
    if (paramView != null)
    {
      azgh.a(azco.a(this.a), azco.a(this.a).a);
      Object localObject1 = azkf.a();
      Object localObject2 = ((azkf)localObject1).a("troop_list_homework");
      azkg localazkg = new azkg();
      localazkg.a = azco.b(this.a).a;
      localazkg.c = "aio";
      localObject1 = ((azkf)localObject1).a((String)localObject2, localazkg);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      azzx.a(azco.b(this.a), azco.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { azco.d(this.a).a, "", "", azzx.a(azco.c(this.a), azco.e(this.a).a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcp
 * JD-Core Version:    0.7.0.1
 */