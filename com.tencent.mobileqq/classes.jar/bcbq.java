import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import java.util.ArrayList;

class bcbq
  implements bhqd
{
  bcbq(bcbp parambcbp, bhpy parambhpy, boolean paramBoolean, bbzr parambbzr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      paramView = "";
    }
    for (;;)
    {
      bdaj.a("Grp_edu", "Grp_recite", "Blueword_Clk", 0, 0, new String[] { this.jdField_a_of_type_Bbzr.f, paramView });
      return;
      SelectReciteParagraphFragment.a(paramView.getContext(), this.jdField_a_of_type_Bbzr.f, this.jdField_a_of_type_Bbzr.jdField_a_of_type_JavaLangString, new ArrayList(this.jdField_a_of_type_Bbzr.jdField_a_of_type_JavaUtilList), this.jdField_a_of_type_Bbzr.c);
      paramView = "2";
      continue;
      SearchReciteArticleFragment.a(paramView.getContext(), this.jdField_a_of_type_Bbzr.f, "", this.jdField_a_of_type_Bbzr.c);
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbq
 * JD-Core Version:    0.7.0.1
 */