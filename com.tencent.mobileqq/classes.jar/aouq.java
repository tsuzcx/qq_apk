import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class aouq
{
  private int jdField_a_of_type_Int = -1;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static aouq a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    aouq localaouq = new aouq();
    int k = paramArrayOfaogf.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfaogf[i];
        try
        {
          localObject1 = new JSONObject(((aogf)localObject1).a);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localaouq.jdField_a_of_type_Int = j;
              }
            }
            else {
              aouo.a((JSONObject)localObject1, localaouq.jdField_a_of_type_JavaUtilMap);
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
    return localaouq;
  }
  
  public static void a(boolean paramBoolean, aouq paramaouq)
  {
    paramBoolean = true;
    if (paramaouq == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramaouq.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        TdsReaderGlobal.a(true, paramaouq.jdField_a_of_type_JavaUtilMap);
      }
    } while (paramaouq.jdField_a_of_type_Int == -1);
    if (paramaouq.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      TdsReaderGlobal.a(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouq
 * JD-Core Version:    0.7.0.1
 */