import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asyk
  implements View.OnClickListener
{
  public asyk(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.a.app, "dc00898", "", "", "0X8009065", "0X8009065", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, beaz.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131719263), true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyk
 * JD-Core Version:    0.7.0.1
 */