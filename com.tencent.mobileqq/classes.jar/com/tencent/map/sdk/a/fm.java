package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class fm
  implements ds<List<LatLng>>
{
  private static List<LatLng> a(List<Double> paramList)
  {
    int j = paramList.size();
    int i = 2;
    if (j < 2) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LatLng(((Double)paramList.get(0)).doubleValue(), ((Double)paramList.get(1)).doubleValue()));
    while (i < paramList.size())
    {
      j = i / 2 - 1;
      double d1 = ((LatLng)localArrayList.get(j)).longitude;
      double d2 = ((Double)paramList.get(i + 1)).doubleValue() / 1000000.0D;
      double d3 = Math.round((((LatLng)localArrayList.get(j)).latitude + ((Double)paramList.get(i)).doubleValue() / 1000000.0D) * 1000000.0D);
      Double.isNaN(d3);
      d3 = (float)(d3 / 1000000.0D);
      d1 = Math.round((d1 + d2) * 1000000.0D);
      Double.isNaN(d1);
      localArrayList.add(new LatLng(d3, (float)(d1 / 1000000.0D)));
      i += 2;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fm
 * JD-Core Version:    0.7.0.1
 */