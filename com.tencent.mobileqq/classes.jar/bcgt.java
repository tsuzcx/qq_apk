import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class bcgt
  implements View.OnClickListener
{
  bcgt(bcgs parambcgs) {}
  
  public void onClick(View paramView)
  {
    paramView = (BaseActivity)bcgs.a(this.a).get();
    if (paramView != null)
    {
      bckt.a(bcgs.a(this.a), bcgs.a(this.a).a);
      Object localObject1 = bcos.a();
      Object localObject2 = ((bcos)localObject1).a("troop_list_homework");
      bcot localbcot = new bcot();
      localbcot.a = bcgs.b(this.a).a;
      localbcot.c = "aio";
      localObject1 = ((bcos)localObject1).a((String)localObject2, localbcot);
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      bdes.a(bcgs.b(this.a), bcgs.c(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { bcgs.d(this.a).a, "", "", bdes.a(bcgs.c(this.a), bcgs.e(this.a).a) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgt
 * JD-Core Version:    0.7.0.1
 */