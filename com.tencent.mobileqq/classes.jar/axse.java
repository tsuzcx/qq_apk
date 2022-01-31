import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class axse
  implements ITransactionCallback
{
  public int a;
  public avbl a;
  public Transaction a;
  
  axse(axrz paramaxrz) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.jdField_a_of_type_Avbl);
    }
    this.jdField_a_of_type_Axrz.f(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.jdField_a_of_type_Avbl);
    }
    paramArrayOfByte = this.jdField_a_of_type_Axrz.jdField_a_of_type_Axqf;
    paramArrayOfByte.e += this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.totalLength;
    if (this.jdField_a_of_type_Axrz.jdField_a_of_type_Avbl != null) {
      this.jdField_a_of_type_Axrz.i();
    }
    this.jdField_a_of_type_Axrz.f(this.jdField_a_of_type_Avbl);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axse
 * JD-Core Version:    0.7.0.1
 */