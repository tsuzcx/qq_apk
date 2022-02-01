import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class bcag
  extends aogk
{
  public bcag(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void handleAssociateResult(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleSuggestUrlResult keyword=" + paramString + " activity keyword=" + this.a.jdField_a_of_type_JavaLangString + " size=" + paramList1.size());
    }
    if (paramString.equals(this.a.jdField_a_of_type_JavaLangString))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new AssociateSearchWordsFragment.AssociateItem();
      paramSuggestUrlItem.jdField_a_of_type_Int = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = str;
          localAssociateItem.jdField_a_of_type_Int = 3;
          localAssociateItem.d = (paramInt + 1);
          paramList1.add(localAssociateItem);
          if (paramInt != paramList.size() - 1)
          {
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localStringBuilder.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramList1);
      bcjs.a(null, new ReportModelDC02528().module("subweb_search").action("exp_thinkword_list").obj1(bcnc.a(this.a.jdField_a_of_type_ArrayOfLong)).ver1(this.a.a()).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + bcjs.b + "}"));
    }
  }
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcag
 * JD-Core Version:    0.7.0.1
 */