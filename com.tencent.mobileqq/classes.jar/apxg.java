import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;

public class apxg
  implements View.OnClickListener
{
  public apxg(NoFileRelativeLayout paramNoFileRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    ayfx.a((Activity)this.a.getContext(), "s_qq_myfile_yindao", -1);
    if ((this.a.getContext() instanceof FMActivity)) {}
    while (!(this.a.getContext() instanceof FileAssistantActivity)) {
      return;
    }
    axqy.b(((FileAssistantActivity)this.a.getContext()).app, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */