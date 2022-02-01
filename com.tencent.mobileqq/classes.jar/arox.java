import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class arox
{
  private int jdField_a_of_type_Int = -1;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static arox a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    arox localarox = new arox();
    int k = paramArrayOfaqxa.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfaqxa[i];
        try
        {
          localObject1 = new JSONObject(((aqxa)localObject1).a);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localarox.jdField_a_of_type_Int = j;
              }
            }
            else {
              arov.a((JSONObject)localObject1, localarox.jdField_a_of_type_JavaUtilMap);
            }
          }
          else {
            i += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error", localJSONException);
            Object localObject2 = null;
            continue;
            int j = 0;
          }
        }
      }
    }
    return localarox;
  }
  
  public static void a(boolean paramBoolean, arox paramarox)
  {
    paramBoolean = true;
    if (paramarox == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramarox.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        TdsReaderGlobal.a(true, paramarox.jdField_a_of_type_JavaUtilMap);
      }
    } while (paramarox.jdField_a_of_type_Int == -1);
    if (paramarox.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      TdsReaderGlobal.a(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arox
 * JD-Core Version:    0.7.0.1
 */