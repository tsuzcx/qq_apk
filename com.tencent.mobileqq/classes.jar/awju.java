import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class awju
  extends akjc
{
  public awju(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(String paramString, int paramInt, List<awkw> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (paramString.equals(this.a.f))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new awkw();
      paramSuggestUrlItem.jdField_a_of_type_Int = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((awkw)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          awkw localawkw = new awkw();
          localawkw.jdField_a_of_type_JavaLangString = str;
          if (this.a.jdField_c_of_type_Int == 25)
          {
            localawkw.jdField_a_of_type_Int = 6;
            label148:
            localawkw.d = (paramInt + 1);
            paramList1.add(localawkw);
            if (paramInt == paramList.size() - 1) {
              break label217;
            }
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localawkw.jdField_a_of_type_Int = 3;
            break label148;
            label217:
            localStringBuilder.append(str);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramList1);
      UniteSearchActivity.e = this.a.getCurrentAccountUin() + System.currentTimeMillis();
      awso.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(awso.a(this.a.jdField_c_of_type_Int)).ver3(UniteSearchActivity.jdField_d_of_type_JavaLangString).ver6(UniteSearchActivity.jdField_c_of_type_JavaLangString).ver7("{experiment_id:" + awso.b + "}").session_id(UniteSearchActivity.e).ver4(localStringBuilder.toString()));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {}
    while (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<awoa> paramList, List<awof> paramList1)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2);
        if (!bool) {
          return;
        }
        if ((this.a.f == null) || (!this.a.f.equals(paramString1))) {
          continue;
        }
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = awiu.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
          continue;
        }
        if (paramList != null) {
          break label125;
        }
      }
      finally {}
      a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      continue;
      label125:
      if ((paramList.size() > 0) && ((((awoa)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(ajyc.a(2131715901))) || ((((awoa)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((awoa)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
        paramList.remove(0);
      }
      this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
      paramString2 = awiu.a(paramList1, paramBoolean1);
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
      UniteSearchActivity.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(List<awpn> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a(paramList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awju
 * JD-Core Version:    0.7.0.1
 */