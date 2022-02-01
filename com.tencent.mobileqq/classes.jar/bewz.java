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

public class bewz
  extends beru
{
  public bewz(bern parambern, beyg parambeyg)
  {
    super(parambern, parambeyg);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while ((!f()) || (localbfau == null));
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  protected bfau a()
  {
    bfau localbfau = new bfau();
    bfbd localbfbd = new bfbd();
    localbfbd.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbd.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbfbd.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbfbd.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
    localbfbd.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbfbd.b = this.n;
    localbfbd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbfbd.jdField_a_of_type_Boolean = this.jdField_a_of_type_Beyg.l;
    localbfbd.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localbfau;
  }
  
  public final void a(bfau parambfau, bfbj parambfbj)
  {
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbl)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", parambfau.toString());
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambfau.jdField_c_of_type_Int);
        }
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          this.m = parambfau.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Bete.m = parambfau.jdField_d_of_type_JavaLangString;
          if (parambfau.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Bete.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Beyg.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = parambfau.jdField_a_of_type_Long;
          f();
          continue;
          d();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.jdField_k_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.jdField_q_of_type_Long + " errorCode:" + this.jdField_k_of_type_Int);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "1");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.j);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_time_cost", String.valueOf(l));
      bdmc.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "0");
    }
  }
  
  public final void aN_()
  {
    super.aN_();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    String str = this.jdField_a_of_type_Beyg.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Bete.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bhmi.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = 0;
      localazrh.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localazrh.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localazrh.e = this.jdField_a_of_type_Bete.m;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
      return;
      c(true);
    }
  }
  
  public final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "sendFileBDH");
    }
    this.jdField_b_of_type_Berr.a();
    Object localObject = new bexa(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bhml.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Beyg.i, (int)this.r, arrayOfByte, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Berr);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewz
 * JD-Core Version:    0.7.0.1
 */