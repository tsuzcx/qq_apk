import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import java.util.List;

public class anhz
  implements TextWatcher
{
  public anhz(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ImageButton localImageButton;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) && (this.a.jdField_a_of_type_JavaUtilList != null) && (EmoticonMainPanel.c >= 0) && (EmoticonMainPanel.c < this.a.jdField_a_of_type_JavaUtilList.size()))
    {
      localImageButton = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(EmoticonMainPanel.c);
      if (localImageButton != null) {
        if (TextUtils.isEmpty(paramEditable)) {
          break label77;
        }
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhz
 * JD-Core Version:    0.7.0.1
 */