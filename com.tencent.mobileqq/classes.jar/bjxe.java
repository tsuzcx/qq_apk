import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bjxe
  implements View.OnClickListener
{
  bjxe(bjxb parambjxb) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Bkjl.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Bkjl.jdField_a_of_type_JavaLangString;
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        bjxn localbjxn = this.a.jdField_a_of_type_Bjxn;
        if (this.a.jdField_a_of_type_Bjxn.a())
        {
          paramView = "2";
          localbjxn.a("use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bjxn.a(0);
      return;
      paramView = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxe
 * JD-Core Version:    0.7.0.1
 */