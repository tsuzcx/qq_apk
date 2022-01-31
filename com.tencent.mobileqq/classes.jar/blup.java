import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class blup
{
  public blus a(String paramString)
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
      paramString = new blus((String)localObject, str, paramString);
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
  
  public blus a(String paramString1, String paramString2, String paramString3, blur paramblur)
  {
    blus localblus = a(paramString1);
    if (localblus == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localblus.jdField_c_of_type_JavaLangString + " url=" + localblus.b + " name=" + localblus.jdField_a_of_type_JavaLangString);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localblus.jdField_a_of_type_JavaLangString;
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
          localObject = new baps();
          ((baps)localObject).jdField_a_of_type_Bapx = new bluq(this, paramString2, paramString3, localblus, paramString1, str, paramblur);
          ((baps)localObject).jdField_a_of_type_JavaLangString = localblus.b;
          ((baps)localObject).jdField_a_of_type_Int = 0;
          ((baps)localObject).jdField_c_of_type_JavaLangString = localFile.getPath();
          ((baps)localObject).jdField_c_of_type_Int = bdee.a(baqx.a().a());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((QQAppInterface)paramString1).getNetEngine(0).a((baqv)localObject);
              paramString1 = localblus;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localblus.b);
              return localblus;
            }
            paramString1 = localblus;
            if (bllv.a() == null) {
              continue;
            }
            bllv.a().getNetEngine(0).a((baqv)localObject);
            return localblus;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localblus;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localblus;
    return localblus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blup
 * JD-Core Version:    0.7.0.1
 */