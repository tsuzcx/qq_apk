import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class ausu
{
  HashMap<String, ausw> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  nko jdField_a_of_type_Nko;
  
  public void a(ausw paramausw, String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramausw);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, ausv paramausv)
  {
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed, exception: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    paramString1 = (ausw)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, paramausv);
    }
    while (paramausv == null) {
      return;
    }
    paramausv.a();
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    List localList = Arrays.asList((paramString + "/#").split("/"));
    if (localList.size() < 6) {
      return false;
    }
    String str1 = (String)localList.get(2);
    String str2 = (String)localList.get(3);
    String str3 = (String)localList.get(4);
    for (;;)
    {
      try
      {
        long l = Long.parseLong(str3);
        localList = localList.subList(5, localList.size() - 1);
        if (QLog.isDevelopLevel()) {
          QLog.d("JB", 4, "calling " + str1 + "." + str2);
        }
        paramString = new ausv(paramWebView, l, paramString);
        paramWebView = paramWebView.getUrl();
        if (this.jdField_a_of_type_Nko == null) {
          this.jdField_a_of_type_Nko = nko.a();
        }
        if (this.jdField_a_of_type_Nko.a(paramWebView, str1 + "." + str2))
        {
          a(str1, str2, localList, paramString);
          return true;
        }
      }
      catch (Exception paramWebView)
      {
        return false;
      }
      QLog.e("JsBridge", 1, "JS API no auth url = " + npn.b(paramWebView, new String[0]) + " objectName = " + str1 + " methodName = " + str2);
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausu
 * JD-Core Version:    0.7.0.1
 */