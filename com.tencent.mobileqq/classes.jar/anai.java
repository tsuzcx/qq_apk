import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class anai
  extends amzv
{
  private static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static byte a(String paramString)
  {
    return amzv.a(2, paramString);
  }
  
  public static Object a()
  {
    return jdField_a_of_type_JavaLangObject;
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidetect.model_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  protected static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    if ((!a("qr_anchor.bin")) || (!a("qr_detection_model.txt")) || (!a("qr_detection_model.bin")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "modules is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return amzv.a(2, jdField_a_of_type_Boolean, paramString);
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MiniRecog.MiniScanDetectModelLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label245;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("qr_anchor.bin"))
      {
        paramHashMap.put("qr_anchor.bin", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("qr_detection_model.txt"))
        {
          paramHashMap.put("qr_detection_model.txt", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("qr_detection_model.bin"))
        {
          paramHashMap.put("qr_detection_model.bin", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("match_detect_so_md5"))
        {
          b("match_detect_so_md5", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("match_detect_so_md5_64")) {
          continue;
        }
        b("match_detect_so_md5_64", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label245:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static String b()
  {
    String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + "match_detect_so_md5", null);
    if (QLog.isColorLevel()) {
      if (str2 != null) {
        break label75;
      }
    }
    label75:
    for (String str1 = "null";; str1 = str2)
    {
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("getMatchDetectSoMd5=%s tag=%s", new Object[] { str1, "match_detect_so_md5" }));
      return str2;
    }
  }
  
  public static String b(String paramString)
  {
    return paramString;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
    if (TextUtils.isEmpty(paramString2)) {
      ((SharedPreferences.Editor)localObject).putString("mini_native_" + paramString1, "").apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "null";
        }
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("saveMatchDetectSoMd5=%s tag=%s", new Object[] { localObject, paramString1 }));
      }
      return;
      ((SharedPreferences.Editor)localObject).putString("mini_native_" + paramString1, paramString2).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anai
 * JD-Core Version:    0.7.0.1
 */