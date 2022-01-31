import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baqk
  implements ITransactionCallback
{
  public int a;
  public axtf a;
  public Transaction a;
  
  baqk(baqf parambaqf) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.jdField_a_of_type_Axtf);
    }
    this.jdField_a_of_type_Baqf.f(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.jdField_a_of_type_Axtf);
    }
    paramArrayOfByte = this.jdField_a_of_type_Baqf.jdField_a_of_type_Baoj;
    paramArrayOfByte.e += this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.totalLength;
    if (this.jdField_a_of_type_Baqf.jdField_a_of_type_Axtf != null) {
      this.jdField_a_of_type_Baqf.i();
    }
    this.jdField_a_of_type_Baqf.f(this.jdField_a_of_type_Axtf);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqk
 * JD-Core Version:    0.7.0.1
 */