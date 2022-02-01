import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bbqg
  implements bbps<bbmw, bbvf>
{
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    parambbvf = (bbwq)parambbvf;
    if ((parambbmw instanceof bbmg))
    {
      parambbmw = (bbmg)parambbmw;
      if (TextUtils.isEmpty(parambbmw.a)) {
        break label81;
      }
      parambbvf.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambbvf.jdField_a_of_type_AndroidWidgetTextView.setText(parambbmw.a);
    }
    for (;;)
    {
      parambbvf.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbqh(this, parambbmw));
      if (TextUtils.isEmpty(parambbmw.b)) {
        parambbvf.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      parambbvf.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqg
 * JD-Core Version:    0.7.0.1
 */