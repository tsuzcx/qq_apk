import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class aomd
  implements View.OnClickListener
{
  public aomd(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.f).putExtra("mgid", (byte)this.a.l);
    paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.a.startActivityForResult(paramView, 100);
    axqy.b(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aomd
 * JD-Core Version:    0.7.0.1
 */