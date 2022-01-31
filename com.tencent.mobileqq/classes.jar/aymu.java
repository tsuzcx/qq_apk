import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class aymu
  implements aymg<ayjj, ayrt>
{
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    paramayrt = (ayte)paramayrt;
    if ((paramayjj instanceof ayit))
    {
      paramayjj = (ayit)paramayjj;
      if (TextUtils.isEmpty(paramayjj.a)) {
        break label81;
      }
      paramayrt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramayrt.jdField_a_of_type_AndroidWidgetTextView.setText(paramayjj.a);
    }
    for (;;)
    {
      paramayrt.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aymv(this, paramayjj));
      if (TextUtils.isEmpty(paramayjj.b)) {
        paramayrt.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramayrt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymu
 * JD-Core Version:    0.7.0.1
 */