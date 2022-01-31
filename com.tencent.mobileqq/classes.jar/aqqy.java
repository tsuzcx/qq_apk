import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aqqy
{
  private alkl jdField_a_of_type_Alkl = new aqra(this);
  private aqnl jdField_a_of_type_Aqnl = new aqqz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, arlo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public aqqy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
    }
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public arlo a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = arlo.a(paramString1, paramString2, paramString3);
    return (arlo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
  
  public void a(arlo paramarlo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramarlo == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramarlo.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramarlo.a(), paramarlo);
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
  
  public void b(arlo paramarlo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramarlo = paramarlo.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramarlo);
    QLog.e("QFileMultiControlManager<QFile>", 1, "removeFileContolReq: controlKey[" + paramarlo + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqy
 * JD-Core Version:    0.7.0.1
 */