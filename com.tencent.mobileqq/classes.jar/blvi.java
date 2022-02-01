import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class blvi
  implements INetEngine.INetEngineListener
{
  private blvb jdField_a_of_type_Blvb;
  private blvj jdField_a_of_type_Blvj;
  private String jdField_a_of_type_JavaLangString;
  
  public blvi(blvb paramblvb, String paramString, blvj paramblvj)
  {
    this.jdField_a_of_type_Blvb = paramblvb;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Blvj = paramblvj;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(blvh.a(), 2, "onResp url: " + this.jdField_a_of_type_Blvb.d + " resultcode: " + paramNetResp.mHttpCode);
    }
    if ((this.jdField_a_of_type_Blvb instanceof blve)) {
      bloz.a((blve)this.jdField_a_of_type_Blvb);
    }
    for (this.jdField_a_of_type_Blvb.jdField_e_of_type_Boolean = true;; this.jdField_a_of_type_Blvb.jdField_e_of_type_Boolean = bluy.a(this.jdField_a_of_type_Blvb))
    {
      this.jdField_a_of_type_Blvb.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Blvj != null) {
        this.jdField_a_of_type_Blvj.onDownloadFinish(this.jdField_a_of_type_Blvb, this.jdField_a_of_type_Blvb.jdField_e_of_type_Boolean);
      }
      if (paramNetResp.mErrCode == 0) {
        break;
      }
      bmbc.a().a(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, 0L, this.jdField_a_of_type_Blvb.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((paramNetResp.mErrCode == 0) && (!this.jdField_a_of_type_Blvb.jdField_e_of_type_Boolean))
    {
      bmbc.a().a(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString, 1111, paramNetResp.reqCost, 0L, this.jdField_a_of_type_Blvb.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Blvb.jdField_f_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bmbc.a().a(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString, paramNetResp.mErrCode, paramNetResp.reqCost, l1, this.jdField_a_of_type_Blvb.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Blvb.b = paramLong2;
    this.jdField_a_of_type_Blvb.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Blvj != null) {
      this.jdField_a_of_type_Blvj.onProgressUpdate(this.jdField_a_of_type_Blvb, this.jdField_a_of_type_Blvb.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvi
 * JD-Core Version:    0.7.0.1
 */