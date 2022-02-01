import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class atvr
{
  private String jdField_a_of_type_JavaLangString;
  private Iterator<String> jdField_a_of_type_JavaUtilIterator;
  private List<String> jdField_a_of_type_JavaUtilList;
  private ProxyIpManager.ProxyIp jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp;
  private boolean jdField_a_of_type_Boolean;
  private Iterator<ProxyIpManager.ProxyIp> jdField_b_of_type_JavaUtilIterator;
  private List<ProxyIpManager.ProxyIp> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public atvr(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = paramString.indexOf("://");
    int j;
    if (i == -1)
    {
      i = 0;
      j = paramString.substring(i).indexOf("/") + i;
      if ((-1 != j) || (-1 != j)) {
        break label116;
      }
      paramString = null;
    }
    for (;;)
    {
      if ((localObject != null) && (paramString != null))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      a(paramQQAppInterface);
      return;
      i += 3;
      break;
      label116:
      int k = paramString.indexOf("&bHost=");
      if (-1 == k) {
        localObject = str;
      }
      for (;;)
      {
        if (localObject != null) {
          break label238;
        }
        localObject = paramString.substring(i, j);
        paramString = paramString.substring(j);
        break;
        int m = paramString.indexOf("&bPort=", k);
        localObject = str;
        if (-1 != m)
        {
          localObject = paramString.substring("&bHost=".length() + k, m);
          str = paramString.substring(m + "&bPort=".length());
          localObject = (String)localObject + ":" + str;
        }
      }
      label238:
      paramString = paramString.substring(j, k);
    }
  }
  
  public atvr(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilList = ((ProxyIpManager)paramQQAppInterface.getManager(3)).getProxyIp(5);
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    a();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str2 = null;
    for (;;)
    {
      try
      {
        int i = paramString.indexOf("://");
        if (i == -1)
        {
          i = 0;
          String str1 = paramString.substring(i);
          if (TextUtils.isEmpty(str1)) {
            break;
          }
          int k = str1.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str1.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 == k)
          {
            str1 = str2;
            if (str2 == null) {
              str1 = paramString.substring(i, j + i);
            }
            if (str1 == null) {
              break;
            }
            i = str1.indexOf(":");
            paramString = str1;
            if (i >= 0) {
              paramString = str1.substring(0, i);
            }
            return b(paramString);
          }
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m) {
            continue;
          }
          str1 = paramString.substring("&bHost=".length() + k, m);
          str2 = paramString.substring("&bPort=".length() + m);
          str2 = str1 + ":" + str2;
          continue;
        }
        i += 3;
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramString.length() >= 7) && (paramString.length() <= 15))
      {
        paramString = paramString.split("\\.");
        if ((paramString != null) && (paramString.length == 4))
        {
          i = 0;
          if (i >= 4) {}
        }
      }
      try
      {
        int j = Integer.parseInt(paramString[i]);
        if ((j >= 0) && (j <= 255)) {
          i += 1;
        }
      }
      catch (Exception paramString) {}
    }
    return true;
    return false;
  }
  
  public String a()
  {
    Object localObject1 = null;
    Object localObject2;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
        localObject2 = localObject1;
      }
      return localObject2;
    }
    if (!this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
      {
        this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
    }
    else
    {
      label94:
      localObject2 = (String)this.jdField_a_of_type_JavaUtilIterator.next();
      QLog.e("HttpUrlProcessor", 4, "waterLog- getNextUrl: host[" + (String)localObject2 + "]");
      if (!this.jdField_a_of_type_Boolean) {
        break label418;
      }
      int i = ((String)localObject2).indexOf(":");
      if (i <= 0) {
        break label330;
      }
      localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      localObject2 = localObject1;
      localObject1 = str;
      label176:
      if (!this.jdField_b_of_type_Boolean) {
        break label349;
      }
      localObject1 = "https://" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.ip + ":" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.port + this.jdField_a_of_type_JavaLangString + "&bHost=" + (String)localObject2 + "&bPort=" + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: url:" + (String)localObject1);
      return localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        break label94;
      }
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
      return null;
      label330:
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = "443";
        break label176;
      }
      localObject1 = "80";
      break label176;
      label349:
      localObject1 = "http://" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.ip + ":" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.port + this.jdField_a_of_type_JavaLangString + "&bHost=" + (String)localObject2 + "&bPort=" + (String)localObject1;
      continue;
      label418:
      if (this.jdField_b_of_type_Boolean) {
        localObject1 = "https://" + (String)localObject2 + this.jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = "http://" + (String)localObject2 + this.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    if (this.jdField_b_of_type_JavaUtilIterator.hasNext()) {
      this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvr
 * JD-Core Version:    0.7.0.1
 */