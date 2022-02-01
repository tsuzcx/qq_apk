package com.tencent.map.sdk.a;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.RoutePlanningObject.Step;
import com.tencent.lbssearch.object.result.TransitResultObject.LatLngBounds;
import com.tencent.lbssearch.object.result.TransitResultObject.Segment;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class fk
{
  public static <T> T a(String paramString, Class<T> paramClass)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramClass == null) {
        return null;
      }
      Object localObject2 = new do();
      ((do)localObject2).a(LatLng.class, new fl());
      ((do)localObject2).a(new fk.1().b, new fm());
      ((do)localObject2).a(RoutePlanningObject.Step.class, new fo());
      ((do)localObject2).a(TransitResultObject.Segment.class, new fq());
      ((do)localObject2).a(TransitResultObject.LatLngBounds.class, new fp());
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((do)localObject2).e);
      Collections.reverse(localArrayList);
      localArrayList.addAll(((do)localObject2).f);
      Object localObject1 = ((do)localObject2).h;
      int i = ((do)localObject2).i;
      int j = ((do)localObject2).j;
      if ((localObject1 != null) && (!"".equals(((String)localObject1).trim())))
      {
        localObject1 = new di((String)localObject1);
      }
      else
      {
        if ((i == 2) || (j == 2)) {
          break label271;
        }
        localObject1 = new di(i, j);
      }
      localArrayList.add(ed.a(fd.a(java.util.Date.class), localObject1));
      localArrayList.add(ed.a(fd.a(Timestamp.class), localObject1));
      localArrayList.add(ed.a(fd.a(java.sql.Date.class), localObject1));
      label271:
      localObject1 = new dn(((do)localObject2).a, ((do)localObject2).c, ((do)localObject2).d, ((do)localObject2).g, ((do)localObject2).k, ((do)localObject2).o, ((do)localObject2).m, ((do)localObject2).n, ((do)localObject2).l, ((do)localObject2).b, localArrayList);
      if (paramString == null) {
        paramString = null;
      }
      try
      {
        localObject2 = new fe(new StringReader(paramString));
        localObject1 = ((dn)localObject1).a((fe)localObject2, paramClass);
        paramString = (String)localObject1;
        if (localObject1 != null) {
          try
          {
            if (((fe)localObject2).f() == ff.j) {
              paramString = (String)localObject1;
            } else {
              throw new du("JSON document was not fully consumed.");
            }
          }
          catch (IOException paramString)
          {
            throw new du(paramString);
          }
          catch (fh paramString)
          {
            throw new eb(paramString);
          }
        }
        paramString = eo.a(paramClass).cast(paramString);
        return paramString;
      }
      catch (eb paramString)
      {
        paramString.printStackTrace();
        or.b(paramString.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fk
 * JD-Core Version:    0.7.0.1
 */