import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.1;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class aygp
  extends amar
{
  public aygp(PublicAcntSearchFragment paramPublicAcntSearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ayjk> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult， keyword=" + this.a.jdField_c_of_type_JavaLangString + ", isFirstReq=" + paramBoolean1 + " ,cookie = " + paramArrayOfByte + ",result=" + paramList.size());
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.1(this, paramBoolean2));
    if (!TextUtils.equals(paramString2, this.a.jdField_a_of_type_JavaLangString))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_c_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_a_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString1, this.a.jdField_c_of_type_JavaLangString))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. masks=" + paramArrayOfLong[0] + " reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_c_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult result is null");
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString1 = paramList.iterator();
    int i = 0;
    long l2 = -1L;
    long l1 = -1L;
    label307:
    int j;
    if (paramString1.hasNext())
    {
      paramString2 = (ayjk)paramString1.next();
      if (paramString2.a() == null) {
        break label1056;
      }
      long l3 = l1;
      if ((paramString2 instanceof ayii))
      {
        paramString3 = (ayii)paramString2;
        l3 = l1;
        if (l1 == -1L) {
          l3 = paramString3.a;
        }
        l2 = paramString3.a;
      }
      j = paramString2.a().size();
      l1 = l3;
      i += j;
    }
    label1049:
    label1056:
    for (;;)
    {
      break label307;
      if (!paramBoolean1) {
        ayrd.a("sub_result", "load_result", new String[] { this.a.jdField_c_of_type_JavaLangString, ayrd.a(paramArrayOfLong), "", ayrd.a("dynamic_tab_search.1", paramArrayOfLong) });
      }
      if (i == 0)
      {
        ayrd.a("sub_result", "no_result", new String[] { this.a.jdField_c_of_type_JavaLangString, ayrd.a(paramArrayOfLong), "", ayrd.a("dynamic_tab_search.1", paramArrayOfLong) });
        this.a.f = paramBoolean2;
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        if ((this.a.jdField_c_of_type_JavaUtilList == null) || (this.a.jdField_c_of_type_JavaUtilList.isEmpty())) {
          break label949;
        }
        paramString1 = aydw.a(paramList, paramBoolean1);
        if ((paramBoolean1) || (l1 != PublicAcntSearchFragment.a(this.a)) || (paramString1 == null) || (paramString1.size() <= 0) || (paramBoolean3)) {
          break label865;
        }
        paramString2 = (ayjj)this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1);
        if ((!(this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1) instanceof aykp)) || (!(paramString1.get(0) instanceof ayis))) {
          paramString1.remove(0);
        }
        j = 0;
        i = 0;
        label685:
        if (i >= paramString1.size()) {
          break label1049;
        }
        if (!((ayjj)paramString1.get(i) instanceof ayis)) {
          break label852;
        }
      }
      for (;;)
      {
        if ((paramString2 instanceof ayjl))
        {
          paramString2 = (ayjl)paramString2;
          j = paramString2.a();
          ayrg.a(paramString2, j + i, j - 1);
        }
        for (;;)
        {
          int k = 0;
          for (;;)
          {
            if (k < i)
            {
              paramString2 = (ayjj)paramString1.get(k);
              if ((paramString2 instanceof ayjl)) {
                ayrg.a((ayjl)paramString2, j + i, j + k);
              }
              k += 1;
              continue;
              if (!paramBoolean1) {
                break;
              }
              ayrd.a("sub_result", "exp_result", new String[] { this.a.jdField_c_of_type_JavaLangString, ayrd.a(paramArrayOfLong), "", ayrd.a("dynamic_tab_search.1", paramArrayOfLong) });
              break;
              label852:
              j = i;
              i += 1;
              break label685;
            }
          }
          label865:
          this.a.jdField_c_of_type_JavaUtilList.addAll(paramString1);
          for (;;)
          {
            i = 0;
            while (i < this.a.jdField_c_of_type_JavaUtilList.size())
            {
              if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof ayju)) {
                ((ayju)this.a.jdField_c_of_type_JavaUtilList.get(i)).r = 0;
              }
              i += 1;
            }
            label949:
            paramString1 = aydw.a(paramList, paramBoolean1);
            this.a.jdField_c_of_type_JavaUtilList = paramString1;
          }
          this.a.jdField_a_of_type_Ayfe.a(this.a.jdField_c_of_type_JavaUtilList);
          PublicAcntSearchFragment.a(this.a, l2);
          if ((this.a.jdField_c_of_type_JavaUtilList.size() != 0) || (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) || (!paramBoolean2)) {
            break;
          }
          ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.2(this));
          return;
          j = 0;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygp
 * JD-Core Version:    0.7.0.1
 */