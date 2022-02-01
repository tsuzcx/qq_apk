import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bevb
  implements ITransactionCallback
{
  public int a;
  public bboi a;
  public Transaction a;
  
  bevb(beuw parambeuw) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.jdField_a_of_type_Bboi);
    }
    this.jdField_a_of_type_Beuw.f(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.jdField_a_of_type_Bboi);
    }
    paramArrayOfByte = this.jdField_a_of_type_Beuw.jdField_a_of_type_Bete;
    paramArrayOfByte.e += this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.totalLength;
    if (this.jdField_a_of_type_Beuw.jdField_a_of_type_Bboi != null) {
      this.jdField_a_of_type_Beuw.j();
    }
    this.jdField_a_of_type_Beuw.f(this.jdField_a_of_type_Bboi);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevb
 * JD-Core Version:    0.7.0.1
 */