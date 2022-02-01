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

public class bdyg
  extends bdtc
{
  public bdyg(bdsv parambdsv, bdzn parambdzn)
  {
    super(parambdsv, parambdzn);
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while ((!f()) || (localbebv == null));
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected bebv a()
  {
    bebv localbebv = new bebv();
    bece localbece = new bece();
    localbece.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbece.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbece.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbece.jdField_c_of_type_Int = this.p;
    localbece.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbece.b = this.n;
    localbece.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbece.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bdzn.k;
    localbece.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "share_pic_to_wx";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    return localbebv;
  }
  
  public final void a(bebv parambebv, beck parambeck)
  {
    if (parambeck != null)
    {
      int i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becm)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("onBusiProtoResp", parambebv.toString());
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambebv.jdField_c_of_type_Int);
        }
        if (parambebv.jdField_c_of_type_Int == 0)
        {
          this.m = parambebv.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Bduk.m = parambebv.jdField_d_of_type_JavaLangString;
          if (parambebv.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Bduk.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Bdzn.i);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.r = parambebv.jdField_a_of_type_Long;
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
      bctj.a(BaseApplication.getContext()).a(null, "actPicShareToWXUpload", paramBoolean, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, null);
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
    String str = this.jdField_a_of_type_Bdzn.i;
    long l = new File(str).length();
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    str = bgmg.b(str);
    if (!TextUtils.isEmpty(str)) {
      this.e = str;
    }
    g();
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = 0;
      localayyu.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localayyu.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localayyu.e = this.jdField_a_of_type_Bduk.m;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bebv != null)
      {
        bedb.b(this.jdField_a_of_type_Bebv);
        this.jdField_a_of_type_Bebv = null;
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
    this.jdField_b_of_type_Bdsz.a();
    Object localObject = new bdyh(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = bgmj.a(this.m);
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 73, this.jdField_a_of_type_Bdzn.i, (int)this.r, arrayOfByte, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Bdsz);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyg
 * JD-Core Version:    0.7.0.1
 */