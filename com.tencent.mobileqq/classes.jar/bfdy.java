import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class bfdy
{
  private static Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public bfdy(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private bhhk a()
  {
    return ((bhhh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("code");
    String str = nku.b(this.jdField_a_of_type_JavaLangString);
    boolean bool2;
    if (!TextUtils.isEmpty(str)) {
      if (i == 4)
      {
        str = str + this.jdField_a_of_type_JavaLangString + ".7z";
        bool2 = false;
      }
    }
    for (;;)
    {
      bfeb localbfeb = new bfeb(this, str, bool2, bool1);
      if (!TextUtils.isEmpty(str)) {
        ThreadManager.post(new SoLibraryChecker.4(this, paramJSONObject, str, localbfeb), 8, null, false);
      }
      return;
      if ((i == 3) || (i == 2))
      {
        str = str + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = true;
        bool1 = false;
      }
      else
      {
        QLog.e("SoLibraryLoader", 1, "do not know what format, use default zip name!");
        str = str + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = false;
        bool1 = false;
        continue;
        bool1 = false;
        bool2 = false;
        str = null;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString);
    return (paramContext != null) && (paramContext.exists());
  }
  
  private boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    for (;;)
    {
      String str2;
      File localFile;
      String str1;
      Object localObject;
      try
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        boolean bool = TextUtils.isEmpty(str2);
        if (bool)
        {
          paramBoolean2 = false;
          return paramBoolean2;
        }
        if (TextUtils.isEmpty(nku.b(str2)))
        {
          paramBoolean2 = false;
          continue;
        }
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          if (!QLog.isColorLevel()) {
            break label583;
          }
          QLog.i("SoLibraryLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
          break label583;
        }
        long l = System.currentTimeMillis();
        str1 = localFile.getParent() + File.separator + str2;
        localObject = BidDownloader.a(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("SoLibraryLoader", 2, "fileFormat: " + (String)localObject + ", path: " + paramString);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label368;
        }
        if (((String)localObject).equals("zip"))
        {
          i = nmk.a(paramString, str1);
          if (QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "now delete original download offline zip, path: " + paramString);
          }
          nmj.b(paramString);
          if (i <= 0) {
            break label429;
          }
          nko.a(str2, 13, 0L, i, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label578;
          }
          QLog.i("SoLibraryLoader", 2, "unZipFolder fail!");
          paramBoolean1 = false;
          nmj.a(str1);
          paramBoolean2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("SoLibraryLoader", 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + paramBoolean1);
          paramBoolean2 = paramBoolean1;
          continue;
        }
        if (!((String)localObject).equals("7z")) {
          continue;
        }
      }
      finally {}
      i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
      continue;
      label368:
      QLog.w("SoLibraryLoader", 1, "can not recognize download compress file format, " + paramString);
      if (paramBoolean1)
      {
        i = nmk.a(paramString, str1);
      }
      else if (paramBoolean2)
      {
        i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
        continue;
        label429:
        paramString = str1 + File.separator + str2 + ".zip";
        localObject = new File(paramString);
        str2 = localFile.getParent() + File.separator + str2 + ".zip";
        if (QLog.isColorLevel()) {
          QLog.i("SoLibraryLoader", 2, "now move zip file to location: " + str2);
        }
        if (((File)localObject).exists())
        {
          paramBoolean2 = ((File)localObject).renameTo(new File(str2));
          paramBoolean1 = paramBoolean2;
          if (!paramBoolean2) {
            paramBoolean1 = bgmg.b(paramString, str2);
          }
        }
        else
        {
          label578:
          paramBoolean1 = false;
          continue;
          label583:
          paramBoolean2 = false;
        }
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    nko.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      nko.a = bool;
      String str = nko.a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SoLibraryLoader", 2, "checkSoUpdate version = " + str);
      }
      if ((!new File(nku.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString + "/" + this.b).exists()) && (!TextUtils.isEmpty(str)) && (!"0".equals(str))) {
        bgmg.a(nku.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString);
      }
      if (localQQAppInterface != null) {
        break;
      }
      return;
    }
    nko.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface, new bfdz(this), false);
  }
  
  private void c()
  {
    String str = "https://" + this.b + "?_bid=" + this.jdField_a_of_type_JavaLangString;
    long l = System.currentTimeMillis();
    if ((!nko.a(BaseApplicationImpl.getContext(), str, new bfea(this, l))) && (QLog.isColorLevel())) {
      QLog.i("SoLibraryLoader", 2, "so file = " + this.b + " transToLocalUrl: return false");
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
    }
    if ((!a(this.jdField_a_of_type_AndroidContentContext, this.b)) || (!((Boolean)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).booleanValue()))
    {
      b();
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdy
 * JD-Core Version:    0.7.0.1
 */