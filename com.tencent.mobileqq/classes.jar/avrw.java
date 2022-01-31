import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class avrw
  implements avri<avol, avwv>
{
  public void a(avol paramavol, avwv paramavwv)
  {
    paramavwv = (avyg)paramavwv;
    if ((paramavol instanceof avnv))
    {
      paramavol = (avnv)paramavol;
      if (TextUtils.isEmpty(paramavol.a)) {
        break label81;
      }
      paramavwv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramavwv.jdField_a_of_type_AndroidWidgetTextView.setText(paramavol.a);
    }
    for (;;)
    {
      paramavwv.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avrx(this, paramavol));
      if (TextUtils.isEmpty(paramavol.b)) {
        paramavwv.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramavwv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrw
 * JD-Core Version:    0.7.0.1
 */