import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class bhnv
{
  public bhny a(String paramString)
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
      paramString = new bhny((String)localObject, str, paramString);
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
  
  public bhny a(String paramString1, String paramString2, String paramString3, bhnx parambhnx)
  {
    bhny localbhny = a(paramString1);
    if (localbhny == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localbhny.jdField_c_of_type_JavaLangString + " url=" + localbhny.b + " name=" + localbhny.jdField_a_of_type_JavaLangString);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localbhny.jdField_a_of_type_JavaLangString;
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
          localObject = new axro();
          ((axro)localObject).jdField_a_of_type_Axrt = new bhnw(this, paramString2, paramString3, localbhny, paramString1, str, parambhnx);
          ((axro)localObject).jdField_a_of_type_JavaLangString = localbhny.b;
          ((axro)localObject).jdField_a_of_type_Int = 0;
          ((axro)localObject).jdField_c_of_type_JavaLangString = localFile.getPath();
          ((axro)localObject).jdField_c_of_type_Int = badq.a(axsr.a().a());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((QQAppInterface)paramString1).getNetEngine(0).a((axsp)localObject);
              paramString1 = localbhny;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localbhny.b);
              return localbhny;
            }
            paramString1 = localbhny;
            if (bhfc.a() == null) {
              continue;
            }
            bhfc.a().getNetEngine(0).a((axsp)localObject);
            return localbhny;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localbhny;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localbhny;
    return localbhny;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhnv
 * JD-Core Version:    0.7.0.1
 */