import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class arro
{
  private int jdField_a_of_type_Int = -1;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static arro a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    arro localarro = new arro();
    int k = paramArrayOfaraj.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfaraj[i];
        try
        {
          localObject1 = new JSONObject(((araj)localObject1).a);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localarro.jdField_a_of_type_Int = j;
              }
            }
            else {
              arrm.a((JSONObject)localObject1, localarro.jdField_a_of_type_JavaUtilMap);
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
    return localarro;
  }
  
  public static void a(boolean paramBoolean, arro paramarro)
  {
    paramBoolean = true;
    if (paramarro == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramarro.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        TdsReaderGlobal.a(true, paramarro.jdField_a_of_type_JavaUtilMap);
      }
    } while (paramarro.jdField_a_of_type_Int == -1);
    if (paramarro.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      TdsReaderGlobal.a(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arro
 * JD-Core Version:    0.7.0.1
 */