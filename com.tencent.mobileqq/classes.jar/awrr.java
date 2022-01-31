import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class awrr
  implements awrd<awog, awwq>
{
  public void a(awog paramawog, awwq paramawwq)
  {
    paramawwq = (awyb)paramawwq;
    if ((paramawog instanceof awnq))
    {
      paramawog = (awnq)paramawog;
      if (TextUtils.isEmpty(paramawog.a)) {
        break label81;
      }
      paramawwq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramawwq.jdField_a_of_type_AndroidWidgetTextView.setText(paramawog.a);
    }
    for (;;)
    {
      paramawwq.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awrs(this, paramawog));
      if (TextUtils.isEmpty(paramawog.b)) {
        paramawwq.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramawwq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrr
 * JD-Core Version:    0.7.0.1
 */