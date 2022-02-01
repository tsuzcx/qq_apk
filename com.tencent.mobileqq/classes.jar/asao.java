import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.qphone.base.util.QLog;

public class asao
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public asao(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_b_of_type_Boolean) {}
    Rect localRect;
    int j;
    boolean bool;
    do
    {
      return;
      localRect = new Rect();
      this.a.jdField_b_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
      int i = localRect.bottom - localRect.top;
      j = this.a.jdField_b_of_type_AndroidViewView.getHeight();
      if (i / j >= 0.8D) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "visible" + bool + " isVisiableForLast=" + this.a.jdField_a_of_type_Boolean + " displayHight=" + i + " hight=" + j);
      }
    } while (bool == this.a.jdField_a_of_type_Boolean);
    if (bool)
    {
      EmotionSearchPanel.jdField_a_of_type_Int = j - localRect.bottom;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "keyboardHeight=" + EmotionSearchPanel.jdField_a_of_type_Int);
      }
      EmotionSearchPanel.c(this.a, EmotionSearchPanel.jdField_a_of_type_Int);
      this.a.a(2);
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(0.71F);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
      break;
      if (this.a.c == 2) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.t(12);
      }
      this.a.b();
      if (!bgsp.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
        arze.a("0X800AE25", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asao
 * JD-Core Version:    0.7.0.1
 */