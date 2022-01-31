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

public class ayup
  extends aype
{
  public ayup(ayox paramayox, aywa paramaywa)
  {
    super(paramayox, paramaywa);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Aypb.a();
    ayyn localayyn = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while ((!f()) || (localayyn == null));
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
  
  protected ayyn a()
  {
    ayyn localayyn = new ayyn();
    ayyw localayyw = new ayyw();
    localayyw.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyw.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyw.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyw.jdField_c_of_type_Int = this.p;
    localayyw.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localayyw.b = this.l;
    localayyw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localayyw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aywa.k;
    localayyw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyn.jdField_a_of_type_Ayzu = this;
    localayyn.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localayyn.jdField_a_of_type_JavaUtilList.add(localayyw);
    localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localayyn;
  }
  
  public final void a(ayyn paramayyn, ayzc paramayzc)
  {
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayze)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", paramayyn.toString());
        }
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramayyn.jdField_c_of_type_Int);
        }
        if (paramayyn.jdField_c_of_type_Int == 0)
        {
          this.m = paramayyn.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Ayqm.m = paramayyn.jdField_d_of_type_JavaLangString;
          if (paramayyn.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Ayqm.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Aywa.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = paramayyn.jdField_a_of_type_Long;
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
      axrl.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "0");
    }
  }
  
  public final void aR_()
  {
    super.aR_();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    String str = this.jdField_a_of_type_Aywa.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bbdj.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      auop localauop = new auop();
      localauop.jdField_a_of_type_Int = 0;
      localauop.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localauop.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localauop.e = this.jdField_a_of_type_Ayqm.m;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b(localauop);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Ayyn != null)
      {
        ayzt.b(this.jdField_a_of_type_Ayyn);
        this.jdField_a_of_type_Ayyn = null;
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
    Object localObject = new ayuq(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bbdm.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Aywa.i, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayup
 * JD-Core Version:    0.7.0.1
 */