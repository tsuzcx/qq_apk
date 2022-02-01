import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;

public class bftn
  implements bkzq
{
  public bftn(SearchReciteArticleFragment paramSearchReciteArticleFragment, bkzi parambkzi, bftr parambftr, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    int i = paramInt;
    if (this.jdField_a_of_type_Bftr.jdField_a_of_type_Int == 2) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      SelectReciteParagraphFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bftr.c, SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment));
      bhbu.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Bftr.jdField_a_of_type_Int) });
      return;
    }
    bhbu.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "1", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Bftr.jdField_a_of_type_Int) });
    bhbu.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bftr.jdField_a_of_type_Int) });
    try
    {
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment, bfut.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bftr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bftr.c, null));
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftn
 * JD-Core Version:    0.7.0.1
 */