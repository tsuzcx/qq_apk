import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class bjin
{
  public bjiq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
      }
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("pendantMD5")) {
          break label142;
        }
        paramString = ((JSONObject)localObject).getString("pendantMD5");
        if (!((JSONObject)localObject).has("pendantUrl")) {
          break label136;
        }
        str = ((JSONObject)localObject).getString("pendantUrl");
        if (!((JSONObject)localObject).has("pendantName")) {
          break label130;
        }
        localObject = ((JSONObject)localObject).getString("pendantName");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new bjiq((String)localObject, str, paramString);
      return paramString;
      label130:
      Object localObject = "";
      continue;
      label136:
      String str = "";
      continue;
      label142:
      paramString = "";
    }
  }
  
  public bjiq a(String paramString1, String paramString2, String paramString3, bjip parambjip)
  {
    bjiq localbjiq = a(paramString1);
    if (localbjiq == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localbjiq.jdField_c_of_type_JavaLangString + " url=" + localbjiq.b + " name=" + localbjiq.jdField_a_of_type_JavaLangString);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localbjiq.jdField_a_of_type_JavaLangString;
          File localFile = new File(paramString2, paramString3);
          if (localFile.exists())
          {
            localFile.delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
            }
          }
          localObject = new File(str);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
            }
          }
          localObject = new ayrv();
          ((ayrv)localObject).jdField_a_of_type_Aysa = new bjio(this, paramString2, paramString3, localbjiq, paramString1, str, parambjip);
          ((ayrv)localObject).jdField_a_of_type_JavaLangString = localbjiq.b;
          ((ayrv)localObject).jdField_a_of_type_Int = 0;
          ((ayrv)localObject).jdField_c_of_type_JavaLangString = localFile.getPath();
          ((ayrv)localObject).jdField_c_of_type_Int = bbev.a(aysy.a().a());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((QQAppInterface)paramString1).getNetEngine(0).a((aysw)localObject);
              paramString1 = localbjiq;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localbjiq.b);
              return localbjiq;
            }
            paramString1 = localbjiq;
            if (bizu.a() == null) {
              continue;
            }
            bizu.a().getNetEngine(0).a((aysw)localObject);
            return localbjiq;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localbjiq;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localbjiq;
    return localbjiq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjin
 * JD-Core Version:    0.7.0.1
 */