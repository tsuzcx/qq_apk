package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class eg
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public ek c;
  
  eg() {}
  
  public eg(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new ek(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              ej localej = new ej(paramJSONObject.getJSONObject(i));
              this.b.add(localej);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = ek.a;
              f.a.b("DetailsData", "DetailsData: unknown json " + paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          f.a.a("DetailsData", "json error", paramJSONObject);
        }
      }
    }
  }
  
  private static ek a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    ek localek;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localek = ek.a(ek.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localek.b = ((JSONObject)localObject1).optString("n");
        localek.e = ((JSONObject)localObject1).optString("p");
        localek.f = ((JSONObject)localObject1).optString("c");
        localek.g = ((JSONObject)localObject1).optString("d");
        localek.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localek.l.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localek.l.putParcelable("addrdesp.landmark", new ef((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localek.l.putParcelable("addrdesp.second_landmark", new ef((JSONObject)localObject1));
        }
      }
      localObject1 = localek;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new ef(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((ef)localObject2).b)) {
        localek.j = ((ef)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((ef)localObject2).b)) {
          localek.k = ((ef)localObject2).a;
        }
      }
    }
    localek.l.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localek;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.eg
 * JD-Core Version:    0.7.0.1
 */