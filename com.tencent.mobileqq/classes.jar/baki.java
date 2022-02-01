import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class baki
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  List<bakd> jdField_a_of_type_JavaUtilList = null;
  List<bakd> b = null;
  List<String> c = null;
  
  public baki(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    this.b = bake.a();
  }
  
  public bakd a(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      return null;
    }
    if ("mqq.jump.qq".equals(paramString2))
    {
      paramString2 = this.b;
      label23:
      if ((paramString2 == null) || (paramString2.size() == 0)) {
        break label90;
      }
      Iterator localIterator = paramString2.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramString2 = (bakd)localIterator.next();
      } while ((paramString2.f == null) || (!paramString2.f.equalsIgnoreCase(paramString1)));
    }
    for (paramString1 = paramString2;; paramString1 = null)
    {
      return paramString1;
      paramString2 = this.jdField_a_of_type_JavaUtilList;
      break label23;
      label90:
      break;
    }
  }
  
  public void a()
  {
    String str = bakg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.i("QAssistantManager", 2, "loadConfigFromLoacl config is " + str);
    a(str);
  }
  
  public void a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      label26:
      if (this.c != null) {
        break label81;
      }
      this.c = new ArrayList();
    }
    for (;;)
    {
      paramString = bakg.a(paramString, this.c);
      if (paramString == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramString);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break label26;
      label81:
      this.c.clear();
    }
  }
  
  public boolean a(String paramString)
  {
    if ("mqq.jump.qq".equals(paramString)) {
      return true;
    }
    if ((StringUtil.isEmpty(paramString)) || (this.c == null)) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
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
 * Qualified Name:     baki
 * JD-Core Version:    0.7.0.1
 */