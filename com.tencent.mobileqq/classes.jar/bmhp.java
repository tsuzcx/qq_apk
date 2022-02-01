import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.TenCookie.1;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class bmhp
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = String.format("%s(\\w+)?=[%%\\w\\$\\(\\)\\[\\]\\*\\+\\.\\^\\|@#&-]*;", new Object[] { "qpay" });
  private Map<String, List<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private String jdField_b_of_type_JavaLangString = String.format("%s(\\w+)?=", new Object[] { "qpay" });
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private String c = "(?i)domain=[\\w\\.]+;";
  private String d = "(?i)expires=[\\w\\s:,]+;";
  private String e = "";
  
  public static bmhp a()
  {
    return bmhq.a;
  }
  
  private String a()
  {
    return "qb_tenpay_cookies_" + this.e;
  }
  
  private String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int j = 0;
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    if (paramString2.find())
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        int k = paramString2.start();
        if (paramString3 != null) {
          j = paramString3.length();
        }
        return paramString1.substring(j + k, paramString2.end() - i);
      }
    }
    return null;
  }
  
  private String a(String paramString, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer("");
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      String str1 = (String)paramList.get(i);
      String str3 = a(str1, this.d, "expires=", false);
      if (TextUtils.isEmpty(str3)) {}
      for (;;)
      {
        i -= 1;
        break;
        long l = new Date(str3).getTime();
        if (NetConnInfoCenter.getServerTimeMillis() > l)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TenCookie", 2, "cookie time out curTime = " + NetConnInfoCenter.getServerTimeMillis() + " expire = " + l + " cookie = " + str1);
          }
          try
          {
            paramList.remove(i);
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
        }
        else
        {
          String str2 = a(localIndexOutOfBoundsException, this.jdField_a_of_type_JavaLangString, null, false);
          if (str2 != null) {
            localStringBuffer.append(str2 + ";");
          }
        }
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localStringBuffer))) {
      QLog.i("TenCookie", 2, paramString + " -> " + localStringBuffer.toString());
    }
    return localStringBuffer.toString();
  }
  
  private List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.getString(i));
      i += 1;
    }
    return localArrayList;
  }
  
  private JSONArray a(List<String> paramList)
  {
    return new JSONArray(paramList);
  }
  
  private void a(Context paramContext)
  {
    ThreadManager.post(new TenCookie.1(this, paramContext), 2, null, true);
  }
  
  private void a(List<String> paramList, String paramString1, String paramString2)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((String)paramList.get(i)).contains(paramString2))
      {
        QLog.i("TenCookie", 2, "replace cookie " + paramString2);
        paramList.remove(i);
      }
      i -= 1;
    }
    paramList.add(paramString1);
  }
  
  public static String c(String paramString)
  {
    return MD5.toMD5(MD5.toMD5(new StringBuilder().append(paramString).append("_").append(DeviceInfoUtil.getIMEI()).toString()) + "q$WaQ3#k").substring(8, 24);
  }
  
  public String a(Context paramContext, String paramString1, String paramString2)
  {
    QLog.i("TenCookie", 2, "readTagCookie this = " + this);
    if ((TextUtils.isEmpty(paramString2)) || (paramContext == null)) {
      return null;
    }
    a(paramString1);
    if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {}
    String str1;
    try
    {
      paramContext = paramContext.getSharedPreferences(a(), 4);
      paramString1 = paramContext.getString("KEY_HOSTS", null);
      if (QLog.isColorLevel()) {
        QLog.i("TenCookie", 2, "initialize cookie from share " + paramString1);
      }
      boolean bool = TextUtils.isEmpty(paramString1);
      if (!bool) {
        try
        {
          paramString1 = new JSONArray(paramString1);
          int i = 0;
          while (i < paramString1.length())
          {
            str1 = (String)paramString1.get(i);
            String str2 = paramContext.getString(str1, null);
            if (!TextUtils.isEmpty(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.i("TenCookie", 2, "initialize sdomain = " + str1 + " : " + str2);
              }
              this.jdField_a_of_type_JavaUtilMap.put(str1, a(new JSONArray(str2)));
            }
            i += 1;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      QLog.i("TenCookie", 2, "readTagCookie insCookie size = " + this.jdField_a_of_type_JavaUtilMap.size());
      if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {
        return "";
      }
    }
    finally {}
    paramContext = new StringBuffer("");
    paramString1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (paramString1.hasNext())
    {
      str1 = (String)paramString1.next();
      if ((paramString2.equals(str1)) || (paramString2.contains(str1)))
      {
        QLog.i("TenCookie", 2, "domain matched, append : " + str1);
        str1 = a(paramString2, (List)this.jdField_a_of_type_JavaUtilMap.get(str1));
        if (!TextUtils.isEmpty(str1)) {
          paramContext.append(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TenCookie", 2, paramString2 + " => " + paramContext.toString());
    }
    return paramContext.toString();
  }
  
  public String a(String paramString)
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    paramString = String.valueOf(i);
    int j = localStringBuilder.length();
    int k = paramString.length();
    i = 0;
    while (i < 28 - j - k)
    {
      localStringBuilder.append("0");
      i += 1;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = null;
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString1)) {
      str = (String)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    }
    this.jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
    return str;
  }
  
  public String a(String paramString1, String paramString2, SharedPreferences paramSharedPreferences)
  {
    String str2 = c(paramString1);
    String str1 = paramSharedPreferences.getString(paramString2 + "_" + str2, "");
    if (QLog.isColorLevel()) {
      QLog.i("TenCookie", 2, "getEncryptUserValue,encryptValue:" + str1 + ",userKey:" + str2);
    }
    paramSharedPreferences = new Cryptor();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      try
      {
        paramString1 = str2.getBytes("ISO8859_1");
      }
      catch (UnsupportedEncodingException paramString1)
      {
        try
        {
          for (;;)
          {
            paramString2 = str1.getBytes("ISO8859_1");
            paramString1 = paramSharedPreferences.decrypt(paramString2, paramString1);
            if (paramString1 == null) {
              break;
            }
            try
            {
              paramString2 = new String(paramString1, "ISO8859_1");
              return paramString2;
            }
            catch (UnsupportedEncodingException paramString2)
            {
              return new String(paramString1);
            }
            paramString1 = paramString1;
            paramString1 = str2.getBytes();
          }
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            paramString2 = str1.getBytes();
          }
        }
      }
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, SharedPreferences paramSharedPreferences, String paramString3)
  {
    String str = c(paramString1);
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(str))) {
      try
      {
        paramString1 = str.getBytes("ISO8859_1");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        try
        {
          byte[] arrayOfByte = paramString3.getBytes("ISO8859_1");
          paramString3 = arrayOfByte;
          paramString3 = new Cryptor().encrypt(paramString3, paramString1);
          if (paramString3 == null) {}
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            try
            {
              paramString1 = new String(paramString3, "ISO8859_1");
              paramString3 = paramString1;
              if (!TextUtils.isEmpty(paramString1))
              {
                paramSharedPreferences.edit().putString(paramString2 + "_" + str, paramString1).apply();
                paramString3 = paramString1;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TenCookie", 2, "putEncryptUserValue,encryptValue:" + paramString3);
              }
              return paramString3;
              paramString1 = paramString1;
              paramString1 = str.getBytes();
              continue;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              paramString3 = paramString3.getBytes();
            }
            catch (UnsupportedEncodingException paramString1)
            {
              paramString1 = new String(paramString3);
              continue;
            }
            paramString3 = null;
          }
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext, String paramString, List<String> paramList)
  {
    if ((paramContext == null) || (paramList.size() <= 0)) {
      return;
    }
    a(paramString);
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        String str2 = (String)paramList.get(i);
        QLog.i("TenCookie", 2, "writeTagCookie cookie = " + str2 + " uin = " + this.e);
        String str3 = a(str2, this.jdField_b_of_type_JavaLangString, null, true);
        String str1;
        if (str3 != null)
        {
          str1 = a(str2, this.c, "domain=", false);
          if (TextUtils.isEmpty(str1))
          {
            QLog.i("TenCookie", 2, str1 + "writeTagCookie domain error, abort...");
            return;
          }
          QLog.i("TenCookie", 2, str1 + " <= " + str2);
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
            break label251;
          }
          paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(str1);
        }
        try
        {
          for (;;)
          {
            a(paramString, str2, str3);
            this.jdField_a_of_type_JavaUtilMap.put(str1, paramString);
            i -= 1;
            break;
            label251:
            paramString = new ArrayList();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    a(paramContext);
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if ((TextUtils.isEmpty(paramString)) || (this.e.equals(paramString))) {
        return false;
      }
      this.e = paramString;
      this.jdField_a_of_type_JavaUtilMap.clear();
      QLog.i("TenCookie", 2, "change user...");
      return true;
    }
    finally {}
  }
  
  public String b(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      return true;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhp
 * JD-Core Version:    0.7.0.1
 */