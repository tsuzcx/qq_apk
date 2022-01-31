import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class auqc
{
  final SparseIntArray a = new SparseIntArray();
  final SparseIntArray b = new SparseIntArray();
  final SparseIntArray c = new SparseIntArray();
  final SparseIntArray d = new SparseIntArray();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("c2c"))
      {
        paramString = paramString.optJSONObject("c2c");
        if (paramString != null)
        {
          if (paramString.has("defaultTheme")) {
            a(paramString.optJSONObject("defaultTheme"), this.a);
          }
          if (paramString.has("conciseTheme")) {
            a(paramString.optJSONObject("conciseTheme"), this.b);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("AIOPlusPanelAppInfoOrderConfigProcessor", 1, paramString, new Object[0]);
    }
  }
  
  private void a(JSONObject paramJSONObject, SparseIntArray paramSparseIntArray)
  {
    if (paramJSONObject != null) {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = paramJSONObject.optInt(str);
          paramSparseIntArray.put(Integer.valueOf(str).intValue(), i);
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("AIOPlusPanelAppInfoOrderConfigProcessor", 1, paramJSONObject, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auqc
 * JD-Core Version:    0.7.0.1
 */