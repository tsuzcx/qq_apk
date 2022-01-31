package c.t.m.g;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ey
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public fd c;
  
  ey() {}
  
  public ey(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new fd(paramJSONObject.optJSONObject("subnation"));
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
              fc localfc = new fc(paramJSONObject.getJSONObject(i));
              this.b.add(localfc);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = fd.a;
              new StringBuilder("DetailsData: unknown json ").append(paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject) {}
      }
    }
  }
  
  private static fd a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    fd localfd;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localfd = fd.a(fd.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localfd.b = ((JSONObject)localObject1).optString("n");
        localfd.e = ((JSONObject)localObject1).optString("p");
        localfd.f = ((JSONObject)localObject1).optString("c");
        localfd.g = ((JSONObject)localObject1).optString("d");
        localfd.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localfd.m.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localfd.m.putParcelable("addrdesp.landmark", new ex((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localfd.m.putParcelable("addrdesp.second_landmark", new ex((JSONObject)localObject1));
        }
      }
      localObject1 = localfd;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new ex(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((ex)localObject2).b)) {
        localfd.j = ((ex)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((ex)localObject2).b)) {
          localfd.k = ((ex)localObject2).a;
        }
      }
    }
    localfd.m.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localfd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ey
 * JD-Core Version:    0.7.0.1
 */