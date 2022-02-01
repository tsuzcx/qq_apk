import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;

public class bfdi
  implements bkhw
{
  public bfdi(SearchReciteArticleFragment paramSearchReciteArticleFragment, bkho parambkho, bfdm parambfdm, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    int i = paramInt;
    if (this.jdField_a_of_type_Bfdm.jdField_a_of_type_Int == 2) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      SelectReciteParagraphFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfdm.c, SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment));
      bgjt.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "0", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Bfdm.jdField_a_of_type_Int) });
      return;
    }
    bgjt.a("Grp_edu", "Grp_recite", "Search_Content_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, "1", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Bfdm.jdField_a_of_type_Int) });
    bgjt.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bfdm.jdField_a_of_type_Int) });
    try
    {
      SearchReciteArticleFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment, bfeo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfdm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfdm.c, null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdi
 * JD-Core Version:    0.7.0.1
 */