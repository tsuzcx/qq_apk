import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class andj
{
  private int jdField_a_of_type_Int = -1;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static andj a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    andj localandj = new andj();
    int k = paramArrayOfamph.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfamph[i];
        try
        {
          localObject1 = new JSONObject(((amph)localObject1).a);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localandj.jdField_a_of_type_Int = j;
              }
            }
            else {
              andh.a((JSONObject)localObject1, localandj.jdField_a_of_type_JavaUtilMap);
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
    return localandj;
  }
  
  public static void a(boolean paramBoolean, andj paramandj)
  {
    paramBoolean = true;
    if (paramandj == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramandj.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        TdsReaderGlobal.a(true, paramandj.jdField_a_of_type_JavaUtilMap);
      }
    } while (paramandj.jdField_a_of_type_Int == -1);
    if (paramandj.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      TdsReaderGlobal.a(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andj
 * JD-Core Version:    0.7.0.1
 */