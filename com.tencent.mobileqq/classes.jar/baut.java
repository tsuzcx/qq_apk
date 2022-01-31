import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baut
  implements ITransactionCallback
{
  public int a;
  public axxo a;
  public Transaction a;
  
  baut(bauo parambauo) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.jdField_a_of_type_Axxo);
    }
    this.jdField_a_of_type_Bauo.f(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.jdField_a_of_type_Axxo);
    }
    paramArrayOfByte = this.jdField_a_of_type_Bauo.jdField_a_of_type_Bass;
    paramArrayOfByte.e += this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.totalLength;
    if (this.jdField_a_of_type_Bauo.jdField_a_of_type_Axxo != null) {
      this.jdField_a_of_type_Bauo.i();
    }
    this.jdField_a_of_type_Bauo.f(this.jdField_a_of_type_Axxo);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baut
 * JD-Core Version:    0.7.0.1
 */