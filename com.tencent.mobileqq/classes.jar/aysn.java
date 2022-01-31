import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aysn
  implements ITransactionCallback
{
  public int a;
  public awbg a;
  public Transaction a;
  
  aysn(aysi paramaysi) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.jdField_a_of_type_Awbg);
    }
    this.jdField_a_of_type_Aysi.f(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.jdField_a_of_type_Awbg);
    }
    paramArrayOfByte = this.jdField_a_of_type_Aysi.jdField_a_of_type_Ayqo;
    paramArrayOfByte.e += this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.totalLength;
    if (this.jdField_a_of_type_Aysi.jdField_a_of_type_Awbg != null) {
      this.jdField_a_of_type_Aysi.i();
    }
    this.jdField_a_of_type_Aysi.f(this.jdField_a_of_type_Awbg);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysn
 * JD-Core Version:    0.7.0.1
 */