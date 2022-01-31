import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ayrd
  implements ayqp<ayns, aywc>
{
  public void a(ayns paramayns, aywc paramaywc)
  {
    paramaywc = (ayxn)paramaywc;
    if ((paramayns instanceof aync))
    {
      paramayns = (aync)paramayns;
      if (TextUtils.isEmpty(paramayns.a)) {
        break label81;
      }
      paramaywc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramaywc.jdField_a_of_type_AndroidWidgetTextView.setText(paramayns.a);
    }
    for (;;)
    {
      paramaywc.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ayre(this, paramayns));
      if (TextUtils.isEmpty(paramayns.b)) {
        paramaywc.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramaywc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrd
 * JD-Core Version:    0.7.0.1
 */