import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqly
{
  static int b;
  public int a;
  public String a;
  public int[] a;
  public String b;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public aqly()
  {
    this.jdField_b_of_type_JavaLangString = "diy_chartlet";
  }
  
  public static HashMap<String, aqly> a(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Iterator localIterator = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (paramJSONObject.has("chartlet_animation"))
    {
      localObject2 = paramJSONObject.optJSONObject("chartlet_animation");
      if (((JSONObject)localObject2).has("animation_set"))
      {
        localObject2 = ((JSONObject)localObject2).optJSONArray("animation_set");
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localArrayList.add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
      }
    }
    if (paramJSONObject.has("diy_animation")) {
      localArrayList.add(paramJSONObject.optJSONObject("diy_animation").optString("diy"));
    }
    if (paramJSONObject.has("animation_sets"))
    {
      localObject2 = paramJSONObject.optJSONObject("animation_sets");
      paramJSONObject = localIterator;
      if (0 == 0) {
        paramJSONObject = new HashMap(4);
      }
      localIterator = localArrayList.iterator();
      label226:
      for (;;)
      {
        localObject1 = paramJSONObject;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((JSONObject)localObject2).optJSONObject((String)localIterator.next());
        if (localObject1 != null)
        {
          if (((JSONObject)localObject1).has("text_size")) {}
          for (localObject1 = aqma.a((JSONObject)localObject1);; localObject1 = aqlz.a((JSONObject)localObject1))
          {
            if (localObject1 == null) {
              break label226;
            }
            ((aqly)localObject1).jdField_a_of_type_Int = paramInt;
            paramJSONObject.put(((aqly)localObject1).jdField_a_of_type_JavaLangString, localObject1);
            break;
          }
        }
      }
    }
    if ((localObject1 != null) && (((HashMap)localObject1).size() > 0)) {
      aqkr.a().a.put(Integer.valueOf(paramInt), localObject1);
    }
    return localObject1;
  }
  
  private static float b(Paint paramPaint, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null)) {
      return 0.0F;
    }
    return paramPaint.measureText(paramString);
  }
  
  public void a(aqmm paramaqmm, Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqly
 * JD-Core Version:    0.7.0.1
 */