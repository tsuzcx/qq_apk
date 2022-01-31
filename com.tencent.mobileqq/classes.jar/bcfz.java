import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import java.util.ArrayList;

class bcfz
  implements bhuk
{
  bcfz(bcfy parambcfy, bhuf parambhuf, boolean paramBoolean, bcea parambcea) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
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
      bdes.a("Grp_edu", "Grp_recite", "Blueword_Clk", 0, 0, new String[] { this.jdField_a_of_type_Bcea.f, paramView });
      return;
      SelectReciteParagraphFragment.a(paramView.getContext(), this.jdField_a_of_type_Bcea.f, this.jdField_a_of_type_Bcea.jdField_a_of_type_JavaLangString, new ArrayList(this.jdField_a_of_type_Bcea.jdField_a_of_type_JavaUtilList), this.jdField_a_of_type_Bcea.c);
      paramView = "2";
      continue;
      SearchReciteArticleFragment.a(paramView.getContext(), this.jdField_a_of_type_Bcea.f, "", this.jdField_a_of_type_Bcea.c);
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfz
 * JD-Core Version:    0.7.0.1
 */