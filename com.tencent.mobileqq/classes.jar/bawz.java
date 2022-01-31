import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class bawz
  extends bark
{
  public bawz(bard parambard, bayk parambayk)
  {
    super(parambard, parambayk);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while ((!f()) || (localbbax == null));
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  protected bbax a()
  {
    bbax localbbax = new bbax();
    bbbg localbbbg = new bbbg();
    localbbbg.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbbbg.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbbbg.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbbbg.jdField_c_of_type_Int = this.p;
    localbbbg.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbbbg.b = this.l;
    localbbbg.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbbbg.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bayk.k;
    localbbbg.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbbg);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localbbax;
  }
  
  public final void a(bbax parambbax, bbbm parambbbm)
  {
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbo)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", parambbax.toString());
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambbax.jdField_c_of_type_Int);
        }
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          this.m = parambbax.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Bass.m = parambbax.jdField_d_of_type_JavaLangString;
          if (parambbax.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Bass.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Bayk.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = parambbax.jdField_a_of_type_Long;
          f();
          continue;
          d();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.k;
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.jdField_q_of_type_Long + " errorCode:" + this.jdField_j_of_type_Int);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "1");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_time_cost", String.valueOf(l));
      azri.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "0");
    }
  }
  
  public final void aP_()
  {
    super.aP_();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    String str = this.jdField_a_of_type_Bayk.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Bass.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bdhb.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      awki localawki = new awki();
      localawki.jdField_a_of_type_Int = 0;
      localawki.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localawki.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localawki.e = this.jdField_a_of_type_Bass.m;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bbax != null)
      {
        bbcd.b(this.jdField_a_of_type_Bbax);
        this.jdField_a_of_type_Bbax = null;
      }
      return;
      d(true);
    }
  }
  
  public final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "sendFileBDH");
    }
    this.b.a();
    Object localObject = new baxa(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bdhe.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Bayk.i, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawz
 * JD-Core Version:    0.7.0.1
 */