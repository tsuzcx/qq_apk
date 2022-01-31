import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aoya
{
  private ajsy jdField_a_of_type_Ajsy = new aoyc(this);
  private aoun jdField_a_of_type_Aoun = new aoyb(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, apsm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public aoya(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aoun != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
    }
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aoun != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
    }
    if (this.jdField_a_of_type_Ajsy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    }
  }
  
  public apsm a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = apsm.a(paramString1, paramString2, paramString3);
    return (apsm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
  
  public void a(apsm paramapsm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramapsm == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramapsm.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramapsm.a(), paramapsm);
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
  
  public void b(apsm paramapsm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramapsm = paramapsm.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramapsm);
    QLog.e("QFileMultiControlManager<QFile>", 1, "removeFileContolReq: controlKey[" + paramapsm + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoya
 * JD-Core Version:    0.7.0.1
 */