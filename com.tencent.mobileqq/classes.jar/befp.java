import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class befp
  implements View.OnClickListener
{
  befp(befl parambefl) {}
  
  public void onClick(View paramView)
  {
    PadInfo localPadInfo = (PadInfo)((bedx)paramView.getTag()).a;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", nmj.a(localPadInfo.pad_url, "_bid=2517"));
    localBundle.putInt("key_team_work_edit_type", localPadInfo.type);
    localBundle.putString("key_team_work_title", localPadInfo.title);
    localBundle.putString("key_team_work_rul", localPadInfo.pad_url);
    localBundle.putInt("key_team_work_pad_list_type", localPadInfo.type_list);
    localBundle.putString("tdsourcetag", "s_qq_grpfile");
    TeamWorkDocEditBrowserActivity.a(this.a.a, localBundle, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befp
 * JD-Core Version:    0.7.0.1
 */