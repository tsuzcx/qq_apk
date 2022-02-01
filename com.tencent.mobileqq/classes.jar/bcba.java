import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

public class bcba
  extends aokf
{
  public bcba(UniteSearchActivity paramUniteSearchActivity) {}
  
  private void a(bcgx parambcgx)
  {
    if (parambcgx == null) {
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
      String str = bckq.a(i, parambcgx.c(), parambcgx.g, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, extraData:" + str);
      }
      parambcgx.b(str);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private void a(List<bcfq> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (bcfq)localIterator1.next();
        if ((paramList != null) && (paramList.a() != null) && (paramList.a().equals(abac.c)))
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            Iterator localIterator2 = paramList.iterator();
            label76:
            QQAppInterface localQQAppInterface;
            while (localIterator2.hasNext())
            {
              paramList = (bcfr)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof bcga)))
              {
                paramList = (bcga)paramList;
                localQQAppInterface = this.a.app;
                if (paramList.b() == null) {
                  break label159;
                }
              }
            }
            label159:
            for (paramList = paramList.b();; paramList = "")
            {
              bdll.b(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              break label76;
              break;
            }
          }
        }
      }
    }
  }
  
  private void b(bcgx parambcgx)
  {
    if (parambcgx == null) {
      return;
    }
    int i = parambcgx.g();
    if (parambcgx.c())
    {
      bcjy.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D2C", i, 0, parambcgx.g);
      return;
    }
    bcjy.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D40", i, 0, parambcgx.g);
  }
  
  private void b(List<bcfq> paramList)
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
      Object localObject1 = (bcfq)paramList.next();
      if ((((bcfq)localObject1).a() == null) || (((bcfq)localObject1).a().size() == 0)) {
        break;
      }
      Object localObject2 = ((bcfq)localObject1).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bcfr localbcfr = (bcfr)((Iterator)localObject2).next();
        if ((localbcfr instanceof bcfs)) {
          ((bcfs)localbcfr).b(this.a.jdField_a_of_type_Int);
        }
      }
      if (!(localObject1 instanceof bcfk)) {
        break;
      }
      localObject1 = ((bcfq)localObject1).a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bcfr)((Iterator)localObject1).next();
        if ((localObject2 instanceof bcgx))
        {
          int i = ((bcgx)localObject2).f();
          if (!bcku.a().a(i))
          {
            ((Iterator)localObject1).remove();
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, remove rich node:" + i);
            }
          }
          a((bcgx)localObject2);
          b((bcgx)localObject2);
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
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(bcjy.a(this.a.jdField_c_of_type_Int)).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + bcjy.b + "}"));
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
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfl> paramList, List<bcfq> paramList1, int paramInt)
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
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, keyword = " + paramString1 + ", isFirstReq = " + paramBoolean1 + ", reqTime = " + paramString2 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", tabList = " + paramList + ", result = " + paramList1 + " subId =" + paramInt);
        }
        b(paramList1);
        if (!paramBoolean1)
        {
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
          paramString2 = bbzx.a(paramList1, paramBoolean1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label265;
        }
      }
      finally {}
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult isEnd=" + paramBoolean2 + " key=" + paramString1);
      label265:
      if (paramList == null)
      {
        a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      }
      else
      {
        if ((paramList.size() > 0) && ((((bcfl)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(anzj.a(2131714683))) || ((((bcfl)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((bcfl)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = bbzx.a(paramList1, paramBoolean1);
        a(paramList1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2, paramInt);
        UniteSearchActivity.d = true;
      }
    }
  }
  
  public void a(List<bcgy> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refreshDataModels(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcba
 * JD-Core Version:    0.7.0.1
 */