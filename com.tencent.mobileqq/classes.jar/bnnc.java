import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class bnnc
  implements View.OnClickListener
{
  bnnc(bnnb parambnnb, bnnd parambnnd, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bnnb.a(this.jdField_a_of_type_Bnnb) != this.jdField_a_of_type_Bnnd.getLayoutPosition()) {
      bnqm.a().i(this.jdField_a_of_type_JavaLangString);
    }
    if ((bnnb.a(this.jdField_a_of_type_Bnnb) == -1) && (TextUtils.isEmpty(bnnb.a(this.jdField_a_of_type_Bnnb).a())))
    {
      bnnb.a(this.jdField_a_of_type_Bnnb).a(this.jdField_a_of_type_JavaLangString, ((bnmo)bnmn.a.get(0)).jdField_a_of_type_JavaLangString, ((bnmo)bnmn.a.get(0)).b);
      bnnb.a(this.jdField_a_of_type_Bnnb).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnnb.a();
      bnnb.a(this.jdField_a_of_type_Bnnb, this.jdField_a_of_type_Bnnd.getLayoutPosition());
      ((bnmm)bnnb.a(this.jdField_a_of_type_Bnnb).get(bnnb.a(this.jdField_a_of_type_Bnnb) - 1)).a(true);
      this.jdField_a_of_type_Bnnd.a(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bnnb.a(this.jdField_a_of_type_Bnnb).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnc
 * JD-Core Version:    0.7.0.1
 */