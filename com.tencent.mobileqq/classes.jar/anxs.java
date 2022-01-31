import android.view.View;
import android.widget.EditText;
import com.tencent.widget.XPanelContainer;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

public class anxs
  implements EditTextPreView.OnClickListener
{
  public anxs(EditTextDialog paramEditTextDialog) {}
  
  public void a(View paramView, DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if ((paramDynamicTextItem != null) && (paramInt > -1))
    {
      paramView = paramDynamicTextItem.a(paramInt);
      if (paramView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramView.length());
        if (!paramView.equals(DynamicTextBuilder.a(paramDynamicTextItem.c(), paramInt))) {
          break label132;
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(EditTextDialog.a(this.a));
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
        if (this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
          this.a.jdField_a_of_type_AndroidWidgetEditText.selectAll();
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        }
        return;
        label132:
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
      }
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxs
 * JD-Core Version:    0.7.0.1
 */