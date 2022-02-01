import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asqb
  implements TextView.OnEditorActionListener
{
  public asqb(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 3)
    {
      if (!bhsr.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
      {
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE28", "0X800AE28", 0, 0, "2", "", this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), "");
        EmotionSearchPanel.a(this.a, true);
        ((asnw)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).z();
      }
      bool = true;
      EmotionSearchPanel.a(this.a);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqb
 * JD-Core Version:    0.7.0.1
 */