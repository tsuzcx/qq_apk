import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class aqjk
  implements View.OnClickListener
{
  public aqjk(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.f).putExtra("mgid", (byte)this.a.l);
    paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.a.startActivityForResult(paramView, 100);
    azqs.b(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjk
 * JD-Core Version:    0.7.0.1
 */