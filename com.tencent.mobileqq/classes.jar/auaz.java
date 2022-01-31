import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.qphone.base.util.QLog;

public class auaz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public auaz(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).findViewById(2131366662).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.b.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.b.getRootView().getHeight();
    int k = j - ((Rect)localObject).bottom;
    StringBuilder localStringBuilder;
    if (k != OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew))
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, k);
      if (k <= j * 0.15D) {
        break label269;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(8);
      try
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        ayks[] arrayOfayks = (ayks[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), ayks.class);
        if ((arrayOfayks != null) && (arrayOfayks.length > 0))
        {
          int m = arrayOfayks.length;
          int i = 0;
          while (i < m)
          {
            ((Spannable)localObject).removeSpan(arrayOfayks[i]);
            i += 1;
          }
        }
        if (!QLog.isColorLevel()) {
          break label268;
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
        localException.printStackTrace();
      }
      localStringBuilder = new StringBuilder().append("OnGlobalLayoutListener showKeyboard:");
      if (k <= j * 0.15D) {
        break label331;
      }
    }
    label268:
    label269:
    label331:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("OCRResultFragmentNew", 2, bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(0);
      allt.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c, false, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaz
 * JD-Core Version:    0.7.0.1
 */