import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bbcb
  implements bbbn<bayr, bbha>
{
  public void a(bayr parambayr, bbha parambbha)
  {
    parambbha = (bbil)parambbha;
    if ((parambayr instanceof bayb))
    {
      parambayr = (bayb)parambayr;
      if (TextUtils.isEmpty(parambayr.a)) {
        break label81;
      }
      parambbha.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambbha.jdField_a_of_type_AndroidWidgetTextView.setText(parambayr.a);
    }
    for (;;)
    {
      parambbha.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbcc(this, parambayr));
      if (TextUtils.isEmpty(parambayr.b)) {
        parambbha.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      parambbha.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcb
 * JD-Core Version:    0.7.0.1
 */