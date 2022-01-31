package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ek
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public eo c;
  
  ek() {}
  
  public ek(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new eo(paramJSONObject.optJSONObject("subnation"));
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
              en localen = new en(paramJSONObject.getJSONObject(i));
              this.b.add(localen);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = eo.a;
              ev.b("DetailsData", "DetailsData: unknown json " + paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          ev.a("DetailsData", "json error", paramJSONObject);
        }
      }
    }
  }
  
  private static eo a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    eo localeo;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localeo = eo.a(eo.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localeo.b = ((JSONObject)localObject1).optString("n");
        localeo.e = ((JSONObject)localObject1).optString("p");
        localeo.f = ((JSONObject)localObject1).optString("c");
        localeo.g = ((JSONObject)localObject1).optString("d");
        localeo.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localeo.l.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localeo.l.putParcelable("addrdesp.landmark", new ej((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localeo.l.putParcelable("addrdesp.second_landmark", new ej((JSONObject)localObject1));
        }
      }
      localObject1 = localeo;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new ej(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((ej)localObject2).b)) {
        localeo.j = ((ej)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((ej)localObject2).b)) {
          localeo.k = ((ej)localObject2).a;
        }
      }
    }
    localeo.l.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localeo;
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
 * Qualified Name:     c.t.m.g.ek
 * JD-Core Version:    0.7.0.1
 */