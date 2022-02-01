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

public class bavx
  extends andt
{
  public bavx(PublicAcntSearchFragment paramPublicAcntSearchFragment) {}
  
  public void handleTabSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bays> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
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
      handleTabSearchError(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString1 = paramList.iterator();
    paramInt = 0;
    long l2 = -1L;
    long l1 = -1L;
    label307:
    int i;
    if (paramString1.hasNext())
    {
      paramString2 = (bays)paramString1.next();
      if (paramString2.a() == null) {
        break label1056;
      }
      long l3 = l1;
      if ((paramString2 instanceof baxq))
      {
        paramString3 = (baxq)paramString2;
        l3 = l1;
        if (l1 == -1L) {
          l3 = paramString3.a;
        }
        l2 = paramString3.a;
      }
      i = paramString2.a().size();
      l1 = l3;
      paramInt += i;
    }
    label1049:
    label1056:
    for (;;)
    {
      break label307;
      if (!paramBoolean1) {
        bbgk.a("sub_result", "load_result", new String[] { this.a.jdField_c_of_type_JavaLangString, bbgk.a(paramArrayOfLong), "", bbgk.a("dynamic_tab_search.1", paramArrayOfLong) });
      }
      if (paramInt == 0)
      {
        bbgk.a("sub_result", "no_result", new String[] { this.a.jdField_c_of_type_JavaLangString, bbgk.a(paramArrayOfLong), "", bbgk.a("dynamic_tab_search.1", paramArrayOfLong) });
        this.a.f = paramBoolean2;
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        if ((this.a.jdField_c_of_type_JavaUtilList == null) || (this.a.jdField_c_of_type_JavaUtilList.isEmpty())) {
          break label949;
        }
        paramString1 = batb.a(paramList, paramBoolean1);
        if ((paramBoolean1) || (l1 != PublicAcntSearchFragment.a(this.a)) || (paramString1 == null) || (paramString1.size() <= 0) || (paramBoolean3)) {
          break label865;
        }
        paramString2 = (bayr)this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1);
        if ((!(this.a.jdField_c_of_type_JavaUtilList.get(this.a.jdField_c_of_type_JavaUtilList.size() - 1) instanceof bazx)) || (!(paramString1.get(0) instanceof baya))) {
          paramString1.remove(0);
        }
        i = 0;
        paramInt = 0;
        label685:
        if (paramInt >= paramString1.size()) {
          break label1049;
        }
        if (!((bayr)paramString1.get(paramInt) instanceof baya)) {
          break label852;
        }
      }
      for (;;)
      {
        if ((paramString2 instanceof bayt))
        {
          paramString2 = (bayt)paramString2;
          i = paramString2.a();
          bbgn.a(paramString2, i + paramInt, i - 1);
        }
        for (;;)
        {
          int j = 0;
          for (;;)
          {
            if (j < paramInt)
            {
              paramString2 = (bayr)paramString1.get(j);
              if ((paramString2 instanceof bayt)) {
                bbgn.a((bayt)paramString2, i + paramInt, i + j);
              }
              j += 1;
              continue;
              if (!paramBoolean1) {
                break;
              }
              bbgk.a("sub_result", "exp_result", new String[] { this.a.jdField_c_of_type_JavaLangString, bbgk.a(paramArrayOfLong), "", bbgk.a("dynamic_tab_search.1", paramArrayOfLong) });
              break;
              label852:
              i = paramInt;
              paramInt += 1;
              break label685;
            }
          }
          label865:
          this.a.jdField_c_of_type_JavaUtilList.addAll(paramString1);
          for (;;)
          {
            paramInt = 0;
            while (paramInt < this.a.jdField_c_of_type_JavaUtilList.size())
            {
              if ((this.a.jdField_c_of_type_JavaUtilList.get(paramInt) instanceof bazc)) {
                ((bazc)this.a.jdField_c_of_type_JavaUtilList.get(paramInt)).u = 0;
              }
              paramInt += 1;
            }
            label949:
            paramString1 = batb.a(paramList, paramBoolean1);
            this.a.jdField_c_of_type_JavaUtilList = paramString1;
          }
          this.a.jdField_a_of_type_Baum.a(this.a.jdField_c_of_type_JavaUtilList);
          PublicAcntSearchFragment.a(this.a, l2);
          if ((this.a.jdField_c_of_type_JavaUtilList.size() != 0) || (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) || (!paramBoolean2)) {
            break;
          }
          ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.2(this));
          return;
          i = 0;
        }
        paramInt = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavx
 * JD-Core Version:    0.7.0.1
 */