import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager.2;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bada
  implements Manager
{
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  private amdg jdField_a_of_type_Amdg = new badb(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SubAccountProtocManager.2(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public bada(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amdg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountProtocManager", 2, "SubAccountProtocManager: manager init");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
    }
    this.jdField_c_of_type_Boolean = true;
    ((amde)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    this.jdField_b_of_type_Boolean = true;
    ((amde)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    ((amde)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(paramString1, paramString2, paramString3);
  }
  
  public boolean a()
  {
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      boolean bool = this.d;
      return bool;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amdg);
    if (ThreadManager.getSubThreadHandler() != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bada
 * JD-Core Version:    0.7.0.1
 */