import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bled
{
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<blei> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public bled(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qp_sfu_config", 0);
  }
  
  private int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label84;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label84:
    return 0;
  }
  
  private String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getDir("qqprotect", 0).toString() + File.separator + "SFU/" + "qp_sfu_config.dat";
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("1"))) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getParent();
    }
    for (;;)
    {
      paramString1 = str;
      if (!str.endsWith(File.separator))
      {
        paramString1 = str;
        if (!paramString2.startsWith(File.separator)) {
          paramString1 = str + File.separator;
        }
      }
      paramString1 = paramString1 + paramString2;
      if (!paramString2.endsWith(File.separator)) {
        break;
      }
      return paramString1 + paramString3;
      if (paramString1.equals("2")) {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getExternalFilesDir(null).getParent();
      }
    }
    return paramString1 + File.separator + paramString3;
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (!paramString.equals("android"))) {
      bool1 = false;
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
              return false;
            }
            l = Build.VERSION.SDK_INT;
            if (paramLong1 != 0L) {
              break;
            }
            bool1 = bool2;
          } while (paramLong2 == 0L);
          if ((paramLong1 != 0L) || (paramLong2 <= 0L)) {
            break;
          }
          bool1 = bool2;
        } while (l <= paramLong2);
        return false;
        if ((paramLong1 <= 0L) || (paramLong2 != 0L)) {
          break;
        }
        bool1 = bool2;
      } while (l >= paramLong1);
      return false;
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label147;
      }
      if (l < paramLong1) {
        break;
      }
      bool1 = bool2;
    } while (l <= paramLong2);
    return false;
    label147:
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          paramString1 = paramString1.replace(" ", "");
          paramString2 = paramString2.replace(" ", "");
          boolean bool3 = paramString1.equals("*");
          boolean bool4 = paramString2.equals("*");
          String str;
          if (bool3)
          {
            bool1 = bool2;
            if (bool4) {}
          }
          else
          {
            str = bhlo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            if ((bool3) && (!bool4)) {
              bool1 = bool2;
            }
          }
          try
          {
            if (a(str, paramString2) > 0) {
              return false;
            }
          }
          catch (Exception paramString1)
          {
            int i;
            paramString1.printStackTrace();
          }
        }
        if ((bool3) || (!bool4)) {
          break;
        }
        bool1 = bool2;
      } while (a(str, paramString1) >= 0);
      return false;
      if ((bool3) || (bool4)) {
        break label182;
      }
      if (a(str, paramString2) > 0) {
        break;
      }
      i = a(str, paramString1);
      bool1 = bool2;
    } while (i >= 0);
    return false;
    label182:
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.getLong("version");
      this.jdField_a_of_type_Boolean = paramString.getBoolean("forceupdate");
      paramString = paramString.getJSONArray("sections");
      int i = 0;
      while (i < paramString.length())
      {
        blei localblei = new blei();
        Object localObject = paramString.getJSONObject(i);
        localblei.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("sid");
        localblei.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("bid");
        localblei.jdField_c_of_type_Long = ((JSONObject)localObject).getLong("size");
        localblei.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("name");
        localblei.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("md5");
        localblei.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("url");
        localblei.jdField_d_of_type_Long = ((JSONObject)localObject).getLong("osminver");
        localblei.jdField_e_of_type_Long = ((JSONObject)localObject).getLong("osmaxver");
        localblei.f = ((JSONObject)localObject).getString("cpuabi");
        localblei.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("qqminver");
        localblei.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).getString("qqmaxver");
        localblei.g = ((JSONObject)localObject).getString("os");
        localblei.jdField_b_of_type_Boolean = a(localblei.g, localblei.jdField_d_of_type_Long, localblei.jdField_e_of_type_Long);
        localblei.jdField_c_of_type_Boolean = c(localblei.f);
        localblei.jdField_a_of_type_Boolean = a(localblei.jdField_d_of_type_JavaLangString, localblei.jdField_e_of_type_JavaLangString);
        if (((JSONObject)localObject).has("flag")) {
          localblei.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("flag");
        }
        localObject = ((JSONObject)localObject).getJSONArray("files");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          bleh localbleh = new bleh();
          localbleh.jdField_a_of_type_Long = localJSONObject.getLong("size");
          localbleh.jdField_d_of_type_JavaLangString = localJSONObject.getString("root");
          localbleh.jdField_e_of_type_JavaLangString = localJSONObject.getString("path");
          localbleh.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
          localbleh.f = a(localbleh.jdField_d_of_type_JavaLangString, localbleh.jdField_e_of_type_JavaLangString, localbleh.jdField_a_of_type_JavaLangString);
          localbleh.jdField_b_of_type_JavaLangString = localJSONObject.getString("md5");
          localbleh.jdField_b_of_type_Long = localJSONObject.getLong("rptid");
          if (localJSONObject.has("extra")) {
            localbleh.i = localJSONObject.getString("extra");
          }
          localblei.jdField_a_of_type_JavaUtilList.add(localbleh);
          j += 1;
        }
        localArrayList.add(localblei);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = localArrayList;
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] parsing config error");
      }
    }
    return false;
  }
  
  private boolean c(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      Object localObject = paramString.replace(" ", "");
      if (((String)localObject).equals("*")) {
        return true;
      }
      paramString = Build.CPU_ABI;
      localObject = ((String)localObject).split(",");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.contains(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public List<blei> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<blei> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_update_bids", "");
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_update_sections", "");
    if ((((String)localObject).indexOf(String.format("#%d#", new Object[] { Long.valueOf(paramLong) })) != -1) && (a(a())) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (blei)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((blei)localObject).jdField_b_of_type_Long == paramLong) {
          if (str.indexOf(String.format("#%d#", new Object[] { Long.valueOf(((blei)localObject).jdField_a_of_type_Long) })) != -1) {
            break label167;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label167:
          int j = 0;
          bleh localbleh;
          while (j < ((blei)localObject).jdField_a_of_type_JavaUtilList.size())
          {
            localbleh = (bleh)((blei)localObject).jdField_a_of_type_JavaUtilList.get(j);
            localbleh.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localbleh.f, "");
            j += 1;
          }
          j = 0;
          while (j < ((blei)localObject).jdField_c_of_type_JavaUtilList.size())
          {
            localbleh = (bleh)((blei)localObject).jdField_c_of_type_JavaUtilList.get(j);
            localbleh.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localbleh.f, "");
            j += 1;
          }
          j = 0;
          while (j < ((blei)localObject).jdField_b_of_type_JavaUtilList.size())
          {
            localbleh = (bleh)((blei)localObject).jdField_b_of_type_JavaUtilList.get(j);
            localbleh.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localbleh.f, "");
            j += 1;
          }
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    byte[] arrayOfByte = blej.a(new File(paramString), null);
    if (arrayOfByte != null) {
      bool = b(new String(arrayOfByte));
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bled
 * JD-Core Version:    0.7.0.1
 */