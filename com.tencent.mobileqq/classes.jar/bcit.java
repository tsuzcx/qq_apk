import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bcit
  implements bcif<bcfh, bcns>
{
  public void a(bcfh parambcfh, bcns parambcns)
  {
    parambcns = (bcpd)parambcns;
    if ((parambcfh instanceof bcer))
    {
      parambcfh = (bcer)parambcfh;
      if (TextUtils.isEmpty(parambcfh.a)) {
        break label81;
      }
      parambcns.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambcns.jdField_a_of_type_AndroidWidgetTextView.setText(parambcfh.a);
    }
    for (;;)
    {
      parambcns.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bciu(this, parambcfh));
      if (TextUtils.isEmpty(parambcfh.b)) {
        parambcns.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      parambcns.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcit
 * JD-Core Version:    0.7.0.1
 */