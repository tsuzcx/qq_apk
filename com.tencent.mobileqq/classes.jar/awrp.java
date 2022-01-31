import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class awrp
  implements awrb<awoe, awwo>
{
  public void a(awoe paramawoe, awwo paramawwo)
  {
    paramawwo = (awxz)paramawwo;
    if ((paramawoe instanceof awno))
    {
      paramawoe = (awno)paramawoe;
      if (TextUtils.isEmpty(paramawoe.a)) {
        break label81;
      }
      paramawwo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramawwo.jdField_a_of_type_AndroidWidgetTextView.setText(paramawoe.a);
    }
    for (;;)
    {
      paramawwo.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awrq(this, paramawoe));
      if (TextUtils.isEmpty(paramawoe.b)) {
        paramawwo.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramawwo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrp
 * JD-Core Version:    0.7.0.1
 */