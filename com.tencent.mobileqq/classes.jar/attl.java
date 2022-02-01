import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class attl
{
  private anua jdField_a_of_type_Anua = new attn(this);
  private atpa jdField_a_of_type_Atpa = new attm(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aulp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public attl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Atpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
    }
    if (this.jdField_a_of_type_Anua != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Atpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
    if (this.jdField_a_of_type_Anua != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    }
  }
  
  public aulp a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = aulp.a(paramString1, paramString2, paramString3);
    return (aulp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("QFileMultiControlManager<QFile>", 1, "initFileControlManager");
    this.jdField_a_of_type_Boolean = true;
    c();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public void a(aulp paramaulp)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramaulp == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramaulp.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaulp.a(), paramaulp);
    QLog.e("QFileMultiControlManager<QFile>", 1, "addFileControlReq: controlKey[" + str + "]");
  }
  
  public void b()
  {
    QLog.i("QFileMultiControlManager<QFile>", 1, "clearFileControlManager");
    this.jdField_a_of_type_Boolean = false;
    d();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public void b(aulp paramaulp)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramaulp = paramaulp.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaulp);
    QLog.e("QFileMultiControlManager<QFile>", 1, "removeFileContolReq: controlKey[" + paramaulp + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attl
 * JD-Core Version:    0.7.0.1
 */