import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public class ayyk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ayyk(OCRResultActivity paramOCRResultActivity) {}
  
  public void onGlobalLayout()
  {
    int i = 0;
    if (OCRResultActivity.d(this.a) != 0) {
      return;
    }
    Object localObject = new Rect();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getRootView().getHeight();
    if (j - ((Rect)localObject).bottom > j * 0.15D) {
      try
      {
        localObject = this.a.jdField_a_of_type_AndroidWidgetEditText.getText();
        begx[] arrayOfbegx = (begx[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), begx.class);
        if ((arrayOfbegx != null) && (arrayOfbegx.length > 0))
        {
          j = arrayOfbegx.length;
          while (i < j)
          {
            ((Spannable)localObject).removeSpan(arrayOfbegx[i]);
            i += 1;
          }
        }
        apsw.a(this.a, this.a.d, false, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultActivity.a(this.a).ocrContent);
        return;
      }
    }
    if (OCRResultActivity.a(this.a) != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(new begp(this.a.jdField_a_of_type_AndroidWidgetEditText.getText(), 8, 16));
      this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    }
    apsw.a(this.a, this.a.d, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyk
 * JD-Core Version:    0.7.0.1
 */