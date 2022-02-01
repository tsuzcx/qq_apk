import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;

public class asnc
{
  public static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, EditText paramEditText, asmr paramasmr)
  {
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity.getBaseContext(), 2131559123, null);
    paramEditText.setCallBack(paramasmr);
    paramEditText.c = true;
    paramEditText.f = true;
    paramEditText.jdField_a_of_type_Boolean = false;
    paramEditText.b = true;
    paramEditText.e = true;
    paramEditText.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new asnd());
    paramEditText.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOverScrollMode(2);
    return paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnc
 * JD-Core Version:    0.7.0.1
 */