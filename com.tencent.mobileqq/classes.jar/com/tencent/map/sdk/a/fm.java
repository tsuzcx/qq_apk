package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class fm
  implements ds<List<LatLng>>
{
  private static List<LatLng> a(List<Double> paramList)
  {
    int i = 2;
    if (paramList.size() < 2) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LatLng(((Double)paramList.get(0)).doubleValue(), ((Double)paramList.get(1)).doubleValue()));
    while (i < paramList.size())
    {
      double d1 = ((LatLng)localArrayList.get(i / 2 - 1)).longitude;
      double d2 = ((Double)paramList.get(i + 1)).doubleValue() / 1000000.0D;
      localArrayList.add(new LatLng((float)(Math.round((((LatLng)localArrayList.get(i / 2 - 1)).latitude + ((Double)paramList.get(i)).doubleValue() / 1000000.0D) * 1000000.0D) / 1000000.0D), (float)(Math.round((d1 + d2) * 1000000.0D) / 1000000.0D)));
      i += 2;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.fm
 * JD-Core Version:    0.7.0.1
 */