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

public class apgi
  implements awiv, awuu<apgm>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected ajsy a;
  private Context jdField_a_of_type_AndroidContentContext;
  private apfq jdField_a_of_type_Apfq;
  private awiq jdField_a_of_type_Awiq;
  private awuv<apgm> jdField_a_of_type_Awuv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  public List<Long> a;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private List<awii> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private List<aztc> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d = true;
  
  public apgi(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt, apfq paramapfq)
  {
    this.jdField_a_of_type_Ajsy = new apgj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Apfq = paramapfq;
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
      ((ajsx)paramQQAppInterface.a(22)).a("GroupFileAppSvr.GetFileSearch", paramList.toByteArray(), (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch troopUin = " + paramLong + ", marchWord = " + paramString1 + ", cookie = " + paramString2);
      }
    }
  }
  
  private void a(boolean paramBoolean, List<aztc> paramList)
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
        if (this.jdField_a_of_type_Awiq == null) {
          break label96;
        }
      }
      finally {}
      this.jdField_a_of_type_Awiq.cancel(true);
      this.jdField_a_of_type_Awiq = null;
      label96:
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.jdField_a_of_type_Awiq = new awiq(paramString, paramString, this.jdField_b_of_type_JavaUtilList, this);
      this.jdField_a_of_type_Awiq.a();
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
  
  public List<apgm> a(awvi paramawvi)
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
  
  public void a(int paramInt, List<? extends awij> paramList)
  {
    QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.5(this, paramInt, paramList));
  }
  
  public void a(awvi paramawvi, awuv<apgm> paramawuv)
  {
    if ((paramawvi == null) || (paramawvi.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramawvi.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    if (this.jdField_a_of_type_Awuv == null) {
      this.jdField_a_of_type_Awuv = paramawuv;
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
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Awiq != null) {
      this.jdField_a_of_type_Awiq.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgi
 * JD-Core Version:    0.7.0.1
 */