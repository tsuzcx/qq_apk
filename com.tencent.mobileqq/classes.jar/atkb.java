import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class atkb
{
  private anrc jdField_a_of_type_Anrc = new atkd(this);
  private atfq jdField_a_of_type_Atfq = new atkc(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aucg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public atkb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
    }
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    }
    if (this.jdField_a_of_type_Anrc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
    }
  }
  
  public aucg a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = aucg.a(paramString1, paramString2, paramString3);
    return (aucg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
  
  public void a(aucg paramaucg)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramaucg == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramaucg.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaucg.a(), paramaucg);
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
  
  public void b(aucg paramaucg)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramaucg = paramaucg.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaucg);
    QLog.e("QFileMultiControlManager<QFile>", 1, "removeFileContolReq: controlKey[" + paramaucg + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkb
 * JD-Core Version:    0.7.0.1
 */