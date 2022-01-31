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

public class axui
  extends axox
{
  public axui(axos paramaxos, axvt paramaxvt)
  {
    super(paramaxos, paramaxvt);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while ((!f()) || (localaxyg == null));
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  protected axyg a()
  {
    axyg localaxyg = new axyg();
    axyp localaxyp = new axyp();
    localaxyp.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localaxyp.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localaxyp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyp.jdField_c_of_type_Int = this.p;
    localaxyp.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localaxyp.b = this.jdField_l_of_type_Boolean;
    localaxyp.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localaxyp.jdField_a_of_type_Boolean = this.jdField_a_of_type_Axvt.k;
    localaxyp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyp);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localaxyg;
  }
  
  public final void a(axyg paramaxyg, axyv paramaxyv)
  {
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axyx)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", paramaxyg.toString());
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramaxyg.jdField_c_of_type_Int);
        }
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          this.jdField_l_of_type_JavaLangString = paramaxyg.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Axqf.m = paramaxyg.jdField_d_of_type_JavaLangString;
          if (paramaxyg.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Axqf.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Axvt.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = paramaxyg.jdField_a_of_type_Long;
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
      QLog.d("ShareToWXUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.jdField_q_of_type_Long + " errorCode:" + this.j);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "1");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.i);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_time_cost", String.valueOf(l));
      awrn.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "0");
    }
  }
  
  public final void aU_()
  {
    super.aU_();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    String str = this.jdField_a_of_type_Axvt.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Axqf.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bace.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      atqr localatqr = new atqr();
      localatqr.jdField_a_of_type_Int = 0;
      localatqr.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localatqr.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localatqr.e = this.jdField_a_of_type_Axqf.m;
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Axyg != null)
      {
        axzm.b(this.jdField_a_of_type_Axyg);
        this.jdField_a_of_type_Axyg = null;
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
    Object localObject = new axuj(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bach.a(this.jdField_l_of_type_JavaLangString);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Axvt.i, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Axvt.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axui
 * JD-Core Version:    0.7.0.1
 */