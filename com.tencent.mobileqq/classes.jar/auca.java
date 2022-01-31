import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;

public class auca
  implements View.OnClickListener
{
  public auca(ScanOcrActivity paramScanOcrActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ScanOcrActivity.a(this.a) == 1) && ((ScanOcrActivity.b(this.a) == 0) || (ScanOcrActivity.b(this.a) == 4)))
    {
      ScanOcrActivity.a(this.a).a();
      ScanOcrActivity.a(this.a, false);
      ScanOcrActivity.b(this.a);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auca
 * JD-Core Version:    0.7.0.1
 */