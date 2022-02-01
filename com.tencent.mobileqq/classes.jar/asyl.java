import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asyl
  implements View.OnClickListener
{
  public asyl(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.a.app, "dc00898", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, beaz.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131719264), false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyl
 * JD-Core Version:    0.7.0.1
 */