import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axlh
  implements View.OnClickListener
{
  public axlh(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onClick(View paramView)
  {
    axlj.a("0X800AADF", 0);
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlh
 * JD-Core Version:    0.7.0.1
 */