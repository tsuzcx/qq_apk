import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aysc
  implements View.OnClickListener
{
  public aysc(OCRResultActivity paramOCRResultActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysc
 * JD-Core Version:    0.7.0.1
 */