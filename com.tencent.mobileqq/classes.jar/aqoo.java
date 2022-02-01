import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqoo
{
  private int a;
  public List<String> a;
  public List<String> b = new ArrayList();
  
  public aqoo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static aqoo a(aqlg[] paramArrayOfaqlg)
  {
    aqoo localaqoo = new aqoo();
    int k;
    int i;
    try
    {
      k = paramArrayOfaqlg.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaqlg)
    {
      boolean bool;
      QLog.d("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaqlg);
    }
    Object localObject1 = ((aqlg)localObject1).a;
    bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool) {}
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject2).has("setting_change_style")) {
          localaqoo.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("setting_change_style", 0);
        }
        ArrayList localArrayList;
        Object localObject3;
        if (((JSONObject)localObject2).has("setting_orders"))
        {
          localArrayList = new ArrayList();
          localObject3 = ((JSONObject)localObject2).optJSONArray("setting_orders");
          if (localObject3 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject3).length())
            {
              String str = ((JSONArray)localObject3).getString(j);
              if (localArrayList.contains(str)) {
                break label342;
              }
              localArrayList.add(str);
              break label342;
            }
          }
          localaqoo.jdField_a_of_type_JavaUtilList.clear();
          localaqoo.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
        if (((JSONObject)localObject2).has("face_orders"))
        {
          localArrayList = new ArrayList();
          localObject2 = ((JSONObject)localObject2).optJSONArray("face_orders");
          if (localObject2 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).getString(j);
              if (localArrayList.contains(localObject3)) {
                break label349;
              }
              localArrayList.add(localObject3);
              break label349;
            }
          }
          localaqoo.b.clear();
          localaqoo.b.addAll(localArrayList);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean: " + (String)localObject1);
        break label335;
        return localaqoo;
      }
      for (;;)
      {
        if (i >= k) {
          break label340;
        }
        localObject1 = paramArrayOfaqlg[i];
        if (localObject1 != null) {
          break;
        }
        label335:
        i += 1;
      }
      label340:
      continue;
      label342:
      j += 1;
      continue;
      label349:
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "EmoticonTabSortConfBean{mChangeNewSettingStyle=" + this.jdField_a_of_type_Int + ", mSettingOrder=" + this.jdField_a_of_type_JavaUtilList + ", mEntryOrder=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoo
 * JD-Core Version:    0.7.0.1
 */