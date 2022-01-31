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

public class ayur
  extends aypg
{
  public ayur(ayoz paramayoz, aywc paramaywc)
  {
    super(paramayoz, paramaywc);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while ((!f()) || (localayyp == null));
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  protected ayyp a()
  {
    ayyp localayyp = new ayyp();
    ayyy localayyy = new ayyy();
    localayyy.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyy.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyy.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyy.jdField_c_of_type_Int = this.p;
    localayyy.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localayyy.b = this.l;
    localayyy.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localayyy.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aywc.k;
    localayyy.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayyp.jdField_a_of_type_Ayzw = this;
    localayyp.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localayyp.jdField_a_of_type_JavaUtilList.add(localayyy);
    localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localayyp;
  }
  
  public final void a(ayyp paramayyp, ayze paramayze)
  {
    if (paramayze != null)
    {
      int i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzg)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", paramayyp.toString());
        }
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramayyp.jdField_c_of_type_Int);
        }
        if (paramayyp.jdField_c_of_type_Int == 0)
        {
          this.m = paramayyp.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Ayqo.m = paramayyp.jdField_d_of_type_JavaLangString;
          if (paramayyp.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Ayqo.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Aywc.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = paramayyp.jdField_a_of_type_Long;
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
      axrn.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
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
    String str = this.jdField_a_of_type_Aywc.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bbdx.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null)
    {
      auor localauor = new auor();
      localauor.jdField_a_of_type_Int = 0;
      localauor.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localauor.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localauor.e = this.jdField_a_of_type_Ayqo.m;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.b(localauor);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Ayyp != null)
      {
        ayzv.b(this.jdField_a_of_type_Ayyp);
        this.jdField_a_of_type_Ayyp = null;
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
    Object localObject = new ayus(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bbea.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Aywc.i, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywc.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayur
 * JD-Core Version:    0.7.0.1
 */