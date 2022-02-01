import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class azux
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  List<azut> jdField_a_of_type_JavaUtilList = null;
  List<String> b = null;
  
  public azux(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  public azut a(String paramString)
  {
    if (bgsp.a(paramString)) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    azut localazut;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localazut = (azut)localIterator.next();
    } while ((localazut.f == null) || (!localazut.f.equalsIgnoreCase(paramString)));
    for (paramString = localazut;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    String str = azuv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.i("QAssistantManager", 2, "loadConfigFromLoacl config is " + str);
    a(str);
  }
  
  public void a(String paramString)
  {
    if (bgsp.a(paramString)) {
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
      paramString = azuv.a(paramString, this.b);
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
    if ((bgsp.a(paramString)) || (this.b == null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azux
 * JD-Core Version:    0.7.0.1
 */