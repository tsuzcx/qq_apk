import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class cf
  implements View.OnClickListener
{
  public cf(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    actj.n = true;
    axrm.a(this.a.app.getApplication().getApplicationContext(), this.a.app.getCurrentAccountUin(), "dl_ckadv");
    paramView = new Intent(this.a, LiteAdvanceActivity.class);
    paramView.putExtra("targetUin", this.a.b);
    this.a.startActivityForResult(paramView, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */