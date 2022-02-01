import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aupc
  implements View.OnClickListener
{
  public aupc(NoFileRelativeLayout paramNoFileRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    becb.a((Activity)this.a.getContext(), "s_qq_myfile_yindao", -1);
    if ((this.a.getContext() instanceof FMActivity)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.getContext() instanceof FileAssistantActivity)) {
        bdll.b(((FileAssistantActivity)this.a.getContext()).app, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupc
 * JD-Core Version:    0.7.0.1
 */