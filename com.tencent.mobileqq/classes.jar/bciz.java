import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bciz
  implements bcil<bcfp, bcny>
{
  public void a(bcfp parambcfp, bcny parambcny)
  {
    parambcny = (bcpj)parambcny;
    if ((parambcfp instanceof bcez))
    {
      parambcfp = (bcez)parambcfp;
      if (TextUtils.isEmpty(parambcfp.a)) {
        break label81;
      }
      parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setText(parambcfp.a);
    }
    for (;;)
    {
      parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcja(this, parambcfp));
      if (TextUtils.isEmpty(parambcfp.b)) {
        parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciz
 * JD-Core Version:    0.7.0.1
 */