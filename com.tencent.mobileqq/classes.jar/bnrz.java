import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class bnrz
  implements View.OnClickListener
{
  bnrz(bnry parambnry, bnsa parambnsa, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bnry.a(this.jdField_a_of_type_Bnry) != this.jdField_a_of_type_Bnsa.getLayoutPosition()) {
      bnyh.a().h(this.jdField_a_of_type_JavaLangString);
    }
    if ((bnry.a(this.jdField_a_of_type_Bnry) == -1) && (TextUtils.isEmpty(bnry.a(this.jdField_a_of_type_Bnry).a())))
    {
      bnry.a(this.jdField_a_of_type_Bnry).a(this.jdField_a_of_type_JavaLangString, ((bnrl)bnrk.a.get(0)).jdField_a_of_type_JavaLangString, ((bnrl)bnrk.a.get(0)).b);
      bnry.a(this.jdField_a_of_type_Bnry).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnry.a();
      bnry.a(this.jdField_a_of_type_Bnry, this.jdField_a_of_type_Bnsa.getLayoutPosition());
      ((bnrj)bnry.a(this.jdField_a_of_type_Bnry).get(bnry.a(this.jdField_a_of_type_Bnry) - 1)).a(true);
      this.jdField_a_of_type_Bnsa.a(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bnry.a(this.jdField_a_of_type_Bnry).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrz
 * JD-Core Version:    0.7.0.1
 */