import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import java.util.List;

public class ayyo
  implements PopupWindow.OnDismissListener
{
  public ayyo(OCRResultActivity paramOCRResultActivity) {}
  
  public void onDismiss()
  {
    this.a.b = null;
    if ((OCRResultActivity.b(this.a) != null) && (OCRResultActivity.b(this.a).size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130845640);
      this.a.a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyo
 * JD-Core Version:    0.7.0.1
 */