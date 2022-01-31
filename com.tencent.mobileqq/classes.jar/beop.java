import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class beop
  implements View.OnClickListener
{
  public beop(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ProfileCardMoreInfoView", 4, "qqCircleWriteEntrance onClick");
    paramView = new Intent();
    paramView.putExtra("key_is_publish", true);
    paramView.putExtra("key_jump_from", "5");
    tqs.a(this.a.a, paramView);
    tyj.a("", 3, 2L, 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beop
 * JD-Core Version:    0.7.0.1
 */