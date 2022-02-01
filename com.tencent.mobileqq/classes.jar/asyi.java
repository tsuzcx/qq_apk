import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asyi
  implements View.OnClickListener
{
  public asyi(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, new Intent());
    this.a.finish();
    this.a.overridePendingTransition(2130771977, 2130771978);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyi
 * JD-Core Version:    0.7.0.1
 */