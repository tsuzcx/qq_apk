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

public class basq
  extends banb
{
  public basq(bamu parambamu, baub parambaub)
  {
    super(parambamu, parambaub);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Bamy.a();
    bawo localbawo = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while ((!f()) || (localbawo == null));
    this.jdField_a_of_type_Bawo = localbawo;
    baxu.a(localbawo);
  }
  
  protected bawo a()
  {
    bawo localbawo = new bawo();
    bawx localbawx = new bawx();
    localbawx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbawx.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbawx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbawx.jdField_c_of_type_Int = this.p;
    localbawx.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbawx.b = this.l;
    localbawx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbawx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Baub.k;
    localbawx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawo.jdField_a_of_type_Baxv = this;
    localbawo.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localbawo.jdField_a_of_type_JavaUtilList.add(localbawx);
    localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localbawo;
  }
  
  public final void a(bawo parambawo, baxd parambaxd)
  {
    if (parambaxd != null)
    {
      int i = 0;
      if (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        parambawo = (baxf)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", parambawo.toString());
        }
        a(this.jdField_a_of_type_Bamy, parambawo);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambawo.jdField_c_of_type_Int);
        }
        if (parambawo.jdField_c_of_type_Int == 0)
        {
          this.m = parambawo.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Baoj.m = parambawo.jdField_d_of_type_JavaLangString;
          if (parambawo.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Baoj.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Baub.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = parambawo.jdField_a_of_type_Long;
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
      azmz.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "0");
    }
  }
  
  public final void aS_()
  {
    super.aS_();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    String str = this.jdField_a_of_type_Baub.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Baoj.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bdcs.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      awfz localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = 0;
      localawfz.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localawfz.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localawfz.e = this.jdField_a_of_type_Baoj.m;
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bawo != null)
      {
        baxu.b(this.jdField_a_of_type_Bawo);
        this.jdField_a_of_type_Bawo = null;
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
    Object localObject = new basr(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bdcv.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Baub.i, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Baub.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basq
 * JD-Core Version:    0.7.0.1
 */