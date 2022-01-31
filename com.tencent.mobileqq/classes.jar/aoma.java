import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class aoma
  implements DialogInterface.OnClickListener
{
  public aoma(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a = false;
    this.a.doOnBackPressed();
    axqy.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_quit", 0, 0, this.a.d, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoma
 * JD-Core Version:    0.7.0.1
 */