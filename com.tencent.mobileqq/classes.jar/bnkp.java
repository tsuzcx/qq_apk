import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bnkp
  implements INetEngine.INetEngineListener
{
  private bnke jdField_a_of_type_Bnke;
  private bnkq jdField_a_of_type_Bnkq;
  private String jdField_a_of_type_JavaLangString;
  
  public bnkp(bnke parambnke, String paramString, bnkq parambnkq)
  {
    this.jdField_a_of_type_Bnke = parambnke;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bnkq = parambnkq;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(bnko.a(), 2, "onResp url: " + this.jdField_a_of_type_Bnke.d + " resultcode: " + paramNetResp.mHttpCode);
    }
    if ((this.jdField_a_of_type_Bnke instanceof bnkh)) {
      bnck.a((bnkh)this.jdField_a_of_type_Bnke);
    }
    for (this.jdField_a_of_type_Bnke.jdField_e_of_type_Boolean = true;; this.jdField_a_of_type_Bnke.jdField_e_of_type_Boolean = bnkb.a(this.jdField_a_of_type_Bnke))
    {
      this.jdField_a_of_type_Bnke.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bnkq != null) {
        this.jdField_a_of_type_Bnkq.onDownloadFinish(this.jdField_a_of_type_Bnke, this.jdField_a_of_type_Bnke.jdField_e_of_type_Boolean);
      }
      if (paramNetResp.mErrCode == 0) {
        break;
      }
      bnqm.a().a(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, 0L, this.jdField_a_of_type_Bnke.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((paramNetResp.mErrCode == 0) && (!this.jdField_a_of_type_Bnke.jdField_e_of_type_Boolean))
    {
      bnqm.a().a(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString, 1111, paramNetResp.reqCost, 0L, this.jdField_a_of_type_Bnke.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bnke.jdField_f_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bnqm.a().a(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, l1, this.jdField_a_of_type_Bnke.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bnke.b = paramLong2;
    this.jdField_a_of_type_Bnke.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Bnkq != null) {
      this.jdField_a_of_type_Bnkq.onProgressUpdate(this.jdField_a_of_type_Bnke, this.jdField_a_of_type_Bnke.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkp
 * JD-Core Version:    0.7.0.1
 */