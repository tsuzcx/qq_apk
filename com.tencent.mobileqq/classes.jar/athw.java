import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class athw
  implements View.OnClickListener
{
  public athw(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.app, "dc00898", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, beaj.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131718623), false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athw
 * JD-Core Version:    0.7.0.1
 */