import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import java.util.List;

class apqt
  implements TextWatcher
{
  apqt(apqq paramapqq) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.a.a.a;
    List localList = this.a.a.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (localList != null) && (EmoticonPanelController.jdField_b_of_type_Int >= 0) && (EmoticonPanelController.jdField_b_of_type_Int < localList.size()))
    {
      localObject = ((EmotionPanelViewPagerAdapter)localObject).a(EmoticonPanelController.jdField_b_of_type_Int);
      if (localObject != null) {
        if (TextUtils.isEmpty(paramEditable)) {
          break label78;
        }
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      ((ImageButton)localObject).setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqt
 * JD-Core Version:    0.7.0.1
 */