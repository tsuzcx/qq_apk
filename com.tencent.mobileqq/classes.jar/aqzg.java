import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.1;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;

public class aqzg
  implements aydv, aypx<aqzk>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected alkl a;
  private Context jdField_a_of_type_AndroidContentContext;
  private aqyo jdField_a_of_type_Aqyo;
  private aydq jdField_a_of_type_Aydq;
  private aypy<aqzk> jdField_a_of_type_Aypy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  public List<Long> a;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private List<aydi> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private List<bbrl> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d = true;
  
  public aqzg(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt, aqyo paramaqyo)
  {
    this.jdField_a_of_type_Alkl = new aqzh(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Aqyo = paramaqyo;
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, List<Long> paramList, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch.");
        boolean bool = this.d;
        if (!bool) {
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.d("TroopFileSearchEngine<QFile>", 1, "doReqTroopFileSearch err marchWord is null--------------");
          continue;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      finally {}
      this.d = false;
      Object localObject = new cmd0x383.ApplyFileSearchReqBody();
      ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
      if (paramList != null) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).uint64_uin_list.set(paramList);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_sync_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_count.set(20);
      paramList = new cmd0x383.ReqBody();
      paramList.uint64_groupcode.set(paramLong);
      paramList.uint32_app_id.set(3);
      paramList.msg_file_search_req_body.set((MessageMicro)localObject);
      paramList.setHasFlag(true);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putString("reqKeyword", paramString1);
      ((alkk)paramQQAppInterface.a(22)).a("GroupFileAppSvr.GetFileSearch", paramList.toByteArray(), (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch troopUin = " + paramLong + ", marchWord = " + paramString1 + ", cookie = " + paramString2);
      }
    }
  }
  
  private void a(boolean paramBoolean, List<bbrl> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.3(this, paramBoolean, paramList));
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. keyWord[" + paramString + "]");
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        if (this.jdField_b_of_type_JavaUtilList == null)
        {
          this.jdField_a_of_type_Boolean = true;
          QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. friend set is null. wait");
          continue;
        }
        if (this.jdField_a_of_type_Aydq == null) {
          break label96;
        }
      }
      finally {}
      this.jdField_a_of_type_Aydq.cancel(true);
      this.jdField_a_of_type_Aydq = null;
      label96:
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.jdField_a_of_type_Aydq = new aydq(paramString, paramString, this.jdField_b_of_type_JavaUtilList, this);
      this.jdField_a_of_type_Aydq.a();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.d = true;
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
  }
  
  private void g()
  {
    ThreadManagerV2.executeOnSubThread(new TroopFileSearchEngine.2(this));
  }
  
  public List<aqzk> a(ayql paramayql)
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "init. get contact info.");
    }
    g();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, List<? extends aydj> paramList)
  {
    QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.5(this, paramInt, paramList));
  }
  
  public void a(ayql paramayql, aypy<aqzk> paramaypy)
  {
    if ((paramayql == null) || (paramayql.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramayql.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    if (this.jdField_a_of_type_Aypy == null) {
      this.jdField_a_of_type_Aypy = paramaypy;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileSearchEngine.1(this), 800L);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. keyword is not match keyWord[" + paramString + "] lastKeyWord[" + this.jdField_b_of_type_JavaLangString + "]");
      return;
    }
    if (!this.d)
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
      return;
    }
    QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish. keyWord[" + paramString + "] lastKeyWord[" + this.jdField_b_of_type_JavaLangString + "]");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return this.jdField_c_of_type_Boolean;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "cancel.");
    }
    f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Aydq != null) {
      this.jdField_a_of_type_Aydq.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzg
 * JD-Core Version:    0.7.0.1
 */