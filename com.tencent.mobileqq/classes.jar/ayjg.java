import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

public class ayjg
  extends amfd
{
  public ayjg(UniteSearchActivity paramUniteSearchActivity) {}
  
  private void a(aypa paramaypa)
  {
    if (paramaypa == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, source:" + this.a.jdField_a_of_type_Int + " from:" + this.a.jdField_c_of_type_Int);
    }
    int j = this.a.jdField_a_of_type_Int;
    int i = j;
    if (this.a.jdField_a_of_type_Int == 0) {
      switch (this.a.jdField_c_of_type_Int)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
      String str = aysu.a(i, paramaypa.c(), paramaypa.g, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, extraData:" + str);
      }
      paramaypa.b(str);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private void a(List<aynt> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (aynt)localIterator1.next();
        if ((paramList != null) && (paramList.a() != null) && (paramList.a().equals(yyw.c)))
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            Iterator localIterator2 = paramList.iterator();
            label76:
            QQAppInterface localQQAppInterface;
            while (localIterator2.hasNext())
            {
              paramList = (aynu)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof ayod)))
              {
                paramList = (ayod)paramList;
                localQQAppInterface = this.a.app;
                if (paramList.b() == null) {
                  break label159;
                }
              }
            }
            label159:
            for (paramList = paramList.b();; paramList = "")
            {
              azqs.b(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              break label76;
              break;
            }
          }
        }
      }
    }
  }
  
  private void b(aypa paramaypa)
  {
    if (paramaypa == null) {
      return;
    }
    int i = paramaypa.g();
    if (paramaypa.c())
    {
      aysc.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D2C", i, 0, paramaypa.g);
      return;
    }
    aysc.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D40", i, 0, paramaypa.g);
  }
  
  private void b(List<aynt> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject1 = (aynt)paramList.next();
      if ((((aynt)localObject1).a() == null) || (((aynt)localObject1).a().size() == 0)) {
        break;
      }
      Object localObject2 = ((aynt)localObject1).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aynu localaynu = (aynu)((Iterator)localObject2).next();
        if ((localaynu instanceof aynv)) {
          ((aynv)localaynu).b(this.a.jdField_a_of_type_Int);
        }
      }
      if (!(localObject1 instanceof aynn)) {
        break;
      }
      localObject1 = ((aynt)localObject1).a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aynu)((Iterator)localObject1).next();
        if ((localObject2 instanceof aypa))
        {
          int i = ((aypa)localObject2).f();
          if (!aysy.a().a(i))
          {
            ((Iterator)localObject1).remove();
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, remove rich node:" + i);
            }
          }
          a((aypa)localObject2);
          b((aypa)localObject2);
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<UnifySearchAssociationWord.SuggestUrlItem> paramList1, UnifySearchAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (paramString.equals(this.a.f))
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
      aysc.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(aysc.a(this.a.jdField_c_of_type_Int)).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + aysc.b + "}"));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b.equals(paramString2)) {}
    while (!this.a.f.equals(paramString1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramInt, paramString3);
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchError resultCode=" + paramInt + " key=" + paramString1);
    }
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ayno> paramList, List<aynt> paramList1)
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
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, keyword = " + paramString1 + ", isFirstReq = " + paramBoolean1 + ", reqTime = " + paramString2 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", tabList = " + paramList + ", result = " + paramList1);
        }
        b(paramList1);
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = ayif.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label252;
        }
      }
      finally {}
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult isEnd=" + paramBoolean2 + " key=" + paramString1);
      label252:
      if (paramList == null)
      {
        a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      }
      else
      {
        if ((paramList.size() > 0) && ((((ayno)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(alud.a(2131716297))) || ((((ayno)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((ayno)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = ayif.a(paramList1, paramBoolean1);
        a(paramList1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
        UniteSearchActivity.d = true;
      }
    }
  }
  
  public void a(List<aypb> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjg
 * JD-Core Version:    0.7.0.1
 */