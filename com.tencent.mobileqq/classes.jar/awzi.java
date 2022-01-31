import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class awzi
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  List<awze> jdField_a_of_type_JavaUtilList = null;
  List<String> b = null;
  
  public awzi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  public awze a(String paramString)
  {
    if (bdnn.a(paramString)) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    awze localawze;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localawze = (awze)localIterator.next();
    } while ((localawze.f == null) || (!localawze.f.equalsIgnoreCase(paramString)));
    for (paramString = localawze;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    String str = awzg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.i("QAssistantManager", 2, "loadConfigFromLoacl config is " + str);
    a(str);
  }
  
  public void a(String paramString)
  {
    if (bdnn.a(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      label26:
      if (this.b != null) {
        break label81;
      }
      this.b = new ArrayList();
    }
    for (;;)
    {
      paramString = awzg.a(paramString, this.b);
      if (paramString == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramString);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break label26;
      label81:
      this.b.clear();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((bdnn.a(paramString)) || (this.b == null)) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awzi
 * JD-Core Version:    0.7.0.1
 */