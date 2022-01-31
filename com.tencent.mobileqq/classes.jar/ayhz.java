import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class ayhz
  implements View.OnClickListener
{
  public ayhz(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    ayfv.a(this.a.app, "0X800993E", String.valueOf(this.a.a));
    paramView = (PadInfo)((ayhr)paramView.getTag()).a;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", mze.a(paramView.pad_url, "_bid=2517"));
    localBundle.putInt("key_team_work_edit_type", paramView.type);
    localBundle.putString("key_team_work_title", paramView.title);
    localBundle.putString("key_team_work_rul", paramView.pad_url);
    localBundle.putInt("key_team_work_pad_list_type", paramView.type_list);
    localBundle.putString("tdsourcetag", "s_qq_grpfile");
    TeamWorkDocEditBrowserActivity.a(this.a, localBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhz
 * JD-Core Version:    0.7.0.1
 */