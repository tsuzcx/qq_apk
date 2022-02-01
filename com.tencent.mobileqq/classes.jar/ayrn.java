import android.view.View;
import com.tencent.mobileqq.ocr.OCRPerformFragment;

public class ayrn
  implements bkzq
{
  public ayrn(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ayrt.a(OCRPerformFragment.a(this.a), String.valueOf(OCRPerformFragment.a(this.a)));
      if (ayrt.a)
      {
        paramView = "0X800B55F";
        ayrt.a(paramView, 0);
      }
    }
    else if (paramInt == 1)
    {
      if (!ayrt.a) {
        break label120;
      }
      ayrt.a(OCRPerformFragment.a(this.a), OCRPerformFragment.a(this.a));
      label66:
      if (!ayrt.a) {
        break label140;
      }
    }
    label140:
    for (paramView = "0X800B560";; paramView = "0X800AAEA")
    {
      ayrt.a(paramView, 0);
      if ((OCRPerformFragment.a(this.a) != null) && (OCRPerformFragment.a(this.a).isShowing())) {
        OCRPerformFragment.a(this.a).dismiss();
      }
      return;
      paramView = "0X800AAE9";
      break;
      label120:
      bbxq.a(OCRPerformFragment.a(this.a), OCRPerformFragment.a(this.a));
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrn
 * JD-Core Version:    0.7.0.1
 */