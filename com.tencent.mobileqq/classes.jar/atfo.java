import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atfo
  implements View.OnClickListener
{
  public atfo(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.f).putExtra("mgid", (byte)this.a.l);
    localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.a.startActivityForResult(localIntent, 100);
    bdll.b(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfo
 * JD-Core Version:    0.7.0.1
 */