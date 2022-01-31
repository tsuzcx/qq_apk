import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

public class avkc
  extends ajup
{
  public avkc(UniteSearchActivity paramUniteSearchActivity) {}
  
  private void a(avpt paramavpt)
  {
    if (paramavpt == null) {
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
      String str = avtn.a(i, paramavpt.c(), paramavpt.g, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, extraData:" + str);
      }
      paramavpt.b(str);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private void a(List<avom> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (avom)localIterator1.next();
        if ((paramList != null) && (paramList.a() != null) && (paramList.a().equals(wwt.c)))
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            Iterator localIterator2 = paramList.iterator();
            label76:
            QQAppInterface localQQAppInterface;
            while (localIterator2.hasNext())
            {
              paramList = (avon)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof avow)))
              {
                paramList = (avow)paramList;
                localQQAppInterface = this.a.app;
                if (paramList.b() == null) {
                  break label159;
                }
              }
            }
            label159:
            for (paramList = paramList.b();; paramList = "")
            {
              awqx.b(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              break label76;
              break;
            }
          }
        }
      }
    }
  }
  
  private void b(avpt paramavpt)
  {
    if (paramavpt == null) {
      return;
    }
    int i = paramavpt.g();
    if (paramavpt.c())
    {
      avsv.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D2C", i, 0, paramavpt.g);
      return;
    }
    avsv.a(this.a.app, this.a.jdField_a_of_type_Int, this.a.jdField_c_of_type_Int, "0X8009D40", i, 0, paramavpt.g);
  }
  
  private void b(List<avom> paramList)
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
      Object localObject1 = (avom)paramList.next();
      if ((((avom)localObject1).a() == null) || (((avom)localObject1).a().size() == 0)) {
        break;
      }
      Object localObject2 = ((avom)localObject1).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        avon localavon = (avon)((Iterator)localObject2).next();
        if ((localavon instanceof avoo)) {
          ((avoo)localavon).b(this.a.jdField_a_of_type_Int);
        }
      }
      if (!(localObject1 instanceof avog)) {
        break;
      }
      localObject1 = ((avom)localObject1).a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (avon)((Iterator)localObject1).next();
        if ((localObject2 instanceof avpt))
        {
          int i = ((avpt)localObject2).f();
          if (!avtr.a().a(i))
          {
            ((Iterator)localObject1).remove();
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, remove rich node:" + i);
            }
          }
          a((avpt)localObject2);
          b((avpt)localObject2);
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(String paramString, int paramInt, List<avld> paramList, List<UnifySearchAssociationWord.SuggestUrlItem> paramList1, UnifySearchAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (paramString.equals(this.a.f))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new avld();
      paramSuggestUrlItem.jdField_a_of_type_Int = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((avld)paramList.get(paramInt)).jdField_a_of_type_JavaLangString;
          avld localavld = new avld();
          localavld.jdField_a_of_type_JavaLangString = str;
          localavld.jdField_a_of_type_Int = 3;
          localavld.d = (paramInt + 1);
          paramList1.add(localavld);
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
      avsv.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.a.a()).ver2(avsv.a(this.a.jdField_c_of_type_Int)).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + avsv.b + "}"));
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
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<avoh> paramList, List<avom> paramList1)
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
          paramString2 = avjb.a(paramList1, paramBoolean1);
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
        if ((paramList.size() > 0) && ((((avoh)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(ajjy.a(2131650111))) || ((((avoh)paramList.get(0)).jdField_a_of_type_JavaUtilList != null) && (((avoh)paramList.get(0)).jdField_a_of_type_JavaUtilList.size() == 0)))) {
          paramList.remove(0);
        }
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramArrayOfByte);
        paramString2 = avjb.a(paramList1, paramBoolean1);
        a(paramList1);
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
        UniteSearchActivity.d = true;
      }
    }
  }
  
  public void a(List<avpu> paramList, int paramInt)
  {
    if (paramInt != this.a.c()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkc
 * JD-Core Version:    0.7.0.1
 */