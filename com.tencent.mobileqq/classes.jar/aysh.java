import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import java.util.List;

public class aysh
  implements PopupWindow.OnDismissListener
{
  public aysh(OCRResultActivity paramOCRResultActivity) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((OCRResultActivity.c(this.a) != null) && (OCRResultActivity.c(this.a).size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130845604);
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysh
 * JD-Core Version:    0.7.0.1
 */