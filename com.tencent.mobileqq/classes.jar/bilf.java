import android.view.View;
import android.widget.EditText;
import com.tencent.widget.XPanelContainer;
import dov.com.qq.im.capture.text.DynamicTextItem;

class bilf
  implements bhmh
{
  bilf(bila parambila) {}
  
  public void a(View paramView, DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if ((paramDynamicTextItem != null) && (paramInt > -1))
    {
      paramView = paramDynamicTextItem.a(paramInt);
      if (paramView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.length());
        if (!paramView.equals(bhlz.a(paramDynamicTextItem.c(), paramInt))) {
          break label139;
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(bila.a(this.a));
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
        if (this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
          this.a.jdField_a_of_type_AndroidWidgetEditText.selectAll();
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(34);
        }
        return;
        label139:
        this.a.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
      }
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilf
 * JD-Core Version:    0.7.0.1
 */