import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BaseConstants.NetType;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class aude
  implements BaseConstants.NetType
{
  private static boolean jdField_a_of_type_Boolean;
  private static audf[] jdField_a_of_type_ArrayOfAudf = new audf[4];
  
  static
  {
    jdField_a_of_type_ArrayOfAudf[1] = new audf();
    jdField_a_of_type_ArrayOfAudf[2] = new audf();
    jdField_a_of_type_ArrayOfAudf[3] = new audf();
  }
  
  public static audf a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, false);
    return jdField_a_of_type_ArrayOfAudf[paramInt];
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface, 0).getString("PreDownloadCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "Params getSavedCfg: " + str + " for:" + paramQQAppInterface);
    }
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, audf paramaudf)
  {
    Object localObject = null;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface, 0).getString("PTTPreDownloadParams_" + paramInt, null);
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "Params getSavedParams: " + str + " for: PTTPreDownloadParams_" + paramInt + " for:" + paramQQAppInterface);
    }
    paramQQAppInterface = (QQAppInterface)localObject;
    if (str != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (str.length() > 0)
      {
        localObject = str.split("##");
        paramQQAppInterface = localObject[0];
        localObject = localObject[1];
      }
    }
    try
    {
      a(((String)localObject).substring(((String)localObject).indexOf(':') + 1), paramaudf);
      return paramQQAppInterface;
    }
    catch (Exception paramaudf) {}
    return paramQQAppInterface;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfAudf = new audf[4];
    jdField_a_of_type_ArrayOfAudf[1] = new audf();
    jdField_a_of_type_ArrayOfAudf[2] = new audf();
    jdField_a_of_type_ArrayOfAudf[3] = new audf();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, audf paramaudf, int paramInt)
  {
    Object localObject = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    ((StringBuilder)localObject).append("##");
    ((StringBuilder)localObject).append(paramInt).append(':');
    ((StringBuilder)localObject).append(paramaudf.jdField_a_of_type_Int);
    int i = 0;
    while (i <= 5)
    {
      ((StringBuilder)localObject).append('#').append(i).append('_').append(paramaudf.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramaudf = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface, 0);
    localObject = ((StringBuilder)localObject).toString();
    paramaudf.edit().putString("PTTPreDownloadParams_" + paramInt, (String)localObject).commit();
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "Params saveParams: " + (String)localObject + " for: PTTPreDownloadParams_" + paramInt + " for:" + paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 1;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = a(paramQQAppInterface);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + str, 0).edit().putString("PreDownloadCfg", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "Params saveCfg: " + paramString + " for:" + str);
    }
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      if (TextUtils.isEmpty(paramString)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        localEditor.putString("PTTPreDownloadParams_1", "");
        localEditor.putString("PTTPreDownloadParams_3", "");
        localEditor.putString("PTTPreDownloadParams_2", "");
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "Params ClearParams for:" + str);
        }
      }
      localEditor.commit();
      return;
      i = 0;
      continue;
      if (paramQQAppInterface.equals(paramString)) {
        i = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((jdField_a_of_type_Boolean) && (!paramBoolean)) || (paramQQAppInterface == null)) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    for (;;)
    {
      int i;
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("PTTPreDownloader", 2, "Params initCfg :" + paramQQAppInterface);
        }
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() == 0)) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length < 1)) {
          break;
        }
        i = paramQQAppInterface.length - 1;
        if (i < 0) {
          break;
        }
        String[] arrayOfString = paramQQAppInterface[i].split(":");
        if ((arrayOfString != null) && (arrayOfString.length >= 2))
        {
          int j = Integer.parseInt(arrayOfString[0]);
          if ((j >= 1) && (j < jdField_a_of_type_ArrayOfAudf.length))
          {
            audf localaudf = jdField_a_of_type_ArrayOfAudf[j];
            a(arrayOfString[1], localaudf);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      i -= 1;
    }
  }
  
  private static void a(String paramString, audf paramaudf)
  {
    paramString = paramString.split("#");
    if ((paramString == null) || (paramString.length < 2)) {}
    label88:
    for (;;)
    {
      return;
      paramaudf.jdField_a_of_type_Int = Integer.parseInt(paramString[0]);
      int i = 1;
      for (;;)
      {
        if (i >= paramString.length) {
          break label88;
        }
        String[] arrayOfString = paramString[i].split("_");
        if ((arrayOfString == null) || (arrayOfString.length < 2)) {
          break;
        }
        int j = Integer.parseInt(arrayOfString[0]);
        int k = Integer.parseInt(arrayOfString[1]);
        paramaudf.jdField_a_of_type_ArrayOfInt[j] = k;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aude
 * JD-Core Version:    0.7.0.1
 */