package c.t.m.g;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class fb
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public fg c;
  
  fb() {}
  
  public fb(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new fg(paramJSONObject.optJSONObject("subnation"));
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
              ff localff = new ff(paramJSONObject.getJSONObject(i));
              this.b.add(localff);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = fg.a;
              new StringBuilder("DetailsData: unknown json ").append(paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject) {}
      }
    }
  }
  
  private static fg a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    fg localfg;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localfg = fg.a(fg.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localfg.b = ((JSONObject)localObject1).optString("n");
        localfg.e = ((JSONObject)localObject1).optString("p");
        localfg.f = ((JSONObject)localObject1).optString("c");
        localfg.g = ((JSONObject)localObject1).optString("d");
        localfg.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localfg.m.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localfg.m.putParcelable("addrdesp.landmark", new fa((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localfg.m.putParcelable("addrdesp.second_landmark", new fa((JSONObject)localObject1));
        }
      }
      localObject1 = localfg;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new fa(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((fa)localObject2).b)) {
        localfg.j = ((fa)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((fa)localObject2).b)) {
          localfg.k = ((fa)localObject2).a;
        }
      }
    }
    localfg.m.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localfg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.fb
 * JD-Core Version:    0.7.0.1
 */