import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.qphone.base.util.QLog;

public class auax
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public auax(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public void onGlobalLayout()
  {
    int i = 0;
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).findViewById(2131366662).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.b.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.b.getRootView().getHeight();
    int k = this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.b.getRootView().getWidth();
    int m = ((Rect)localObject).bottom - this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getBottom();
    if (j - ((Rect)localObject).bottom > j * 0.15D)
    {
      localObject = new RelativeLayout.LayoutParams(k, m);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getBottom(), 0, this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewViewGroup.getHeight());
      ((RelativeLayout.LayoutParams)localObject).alignWithParent = true;
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewView.findViewById(2131364722).setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      try
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        aykq[] arrayOfaykq = (aykq[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), aykq.class);
        if ((arrayOfaykq != null) && (arrayOfaykq.length > 0))
        {
          k = arrayOfaykq.length;
          while (i < k)
          {
            ((Spannable)localObject).removeSpan(arrayOfaykq[i]);
            i += 1;
          }
        }
        localLayoutParams = new RelativeLayout.LayoutParams(k, m);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
        localException.printStackTrace();
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        if (QLog.isColorLevel()) {
          QLog.i("OCRResultFragmentNew", 2, "current text index:" + j);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(j);
        return;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    localLayoutParams.setMargins(0, this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getBottom(), 0, this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewViewGroup.getHeight());
    localLayoutParams.alignWithParent = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewView.findViewById(2131364722).setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    allu.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auax
 * JD-Core Version:    0.7.0.1
 */