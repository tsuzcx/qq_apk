import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class athv
  implements View.OnClickListener
{
  public athv(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.app, "dc00898", "", "", "0X8009065", "0X8009065", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, beaj.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131718622), true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athv
 * JD-Core Version:    0.7.0.1
 */