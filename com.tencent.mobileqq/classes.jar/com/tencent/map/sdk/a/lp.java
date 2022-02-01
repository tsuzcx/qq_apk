package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class lp
  implements ky
{
  private static AtomicInteger b = new AtomicInteger(1);
  public pn a;
  private Map<String, lo> c;
  
  public final void a(String paramString)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.a != null))
    {
      Iterator localIterator = paramString.a.iterator();
      while (localIterator.hasNext())
      {
        Marker localMarker = (Marker)localIterator.next();
        if (localMarker != null) {
          localMarker.remove();
        }
      }
      paramString.a.clear();
    }
    this.a.s();
  }
  
  public final void a(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    if (paramString != null) {
      paramString.a(paramMarker);
    }
    this.a.s();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    if ((paramString1 != null) && (paramString1.b != null))
    {
      paramString2 = paramString1.b.b(paramString2);
      if (paramString2 != null) {
        paramString1.a(paramString2);
      }
    }
    this.a.s();
  }
  
  public final void a(String paramString, List<Marker> paramList)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.a != null) && (paramList != null)) {
      paramString.a.addAll(paramList);
    }
    this.a.s();
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.b != null)) {
      paramString.b.b = paramBoolean;
    }
    this.a.s();
  }
  
  public final boolean a(String paramString1, String paramString2, MarkerOptions paramMarkerOptions)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!nl.a(paramString2)) {
        if (paramMarkerOptions == null)
        {
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (paramString1.a != null)
          {
            paramString1 = paramString1.a.iterator();
            Marker localMarker;
            do
            {
              bool1 = bool2;
              if (!paramString1.hasNext()) {
                break;
              }
              localMarker = (Marker)paramString1.next();
            } while ((localMarker == null) || (!localMarker.getId().equals(paramString2)));
            localMarker.setMarkerOptions(paramMarkerOptions);
            bool1 = true;
          }
        }
      }
    }
    this.a.s();
    return bool1;
  }
  
  public final List<Marker> b(String paramString)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramString.a != null)) {
      return paramString.a;
    }
    return null;
  }
  
  public final boolean b(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (paramMarker != null)
      {
        bool1 = bool2;
        if (paramString.a != null)
        {
          Iterator localIterator = paramString.a.iterator();
          Marker localMarker;
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            localMarker = (Marker)localIterator.next();
          } while ((localMarker == null) || (localMarker != paramMarker));
          paramString.a.remove(paramMarker);
          paramMarker.remove();
        }
      }
      else
      {
        bool1 = true;
      }
    }
    this.a.s();
    return bool1;
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (nl.a(paramString2)) {}
      for (;;)
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (paramString1.a == null) {
          break;
        }
        int j = paramString1.a.size();
        int i = 0;
        while (i < j)
        {
          if ((paramString1.a.get(i) != null) && (((Marker)paramString1.a.get(i)).getId().equals(paramString2))) {
            break label116;
          }
          i += 1;
        }
        i = -1;
        label116:
        bool1 = bool2;
        if (i == -1) {
          break;
        }
        ((Marker)paramString1.a.remove(i)).remove();
      }
    }
    this.a.s();
    return bool1;
  }
  
  public final Marker c(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    if ((paramString1 != null) && (!nl.a(paramString2)) && (paramString1.a != null))
    {
      int j = paramString1.a.size();
      int i = 0;
      while (i < j)
      {
        if ((paramString1.a.get(i) != null) && (((Marker)paramString1.a.get(i)).getId().equals(paramString2))) {
          break label99;
        }
        i += 1;
      }
      i = -1;
      label99:
      if (i != -1) {
        return (Marker)paramString1.a.get(i);
      }
    }
    return null;
  }
  
  public final List<String> c(String paramString)
  {
    Object localObject = (lo)this.c.get(paramString);
    if ((localObject != null) && (((lo)localObject).a != null))
    {
      paramString = new ArrayList(((lo)localObject).a.size());
      localObject = ((lo)localObject).a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Marker localMarker = (Marker)((Iterator)localObject).next();
        if (localMarker != null) {
          paramString.add(localMarker.getId());
        }
      }
      return paramString;
    }
    return null;
  }
  
  public final boolean c(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    if ((paramString != null) && (paramMarker != null) && (paramString.a != null)) {
      return paramString.a.contains(paramMarker);
    }
    return false;
  }
  
  public final void d(String paramString)
  {
    this.c.get(paramString);
    this.a.s();
  }
  
  public final boolean d(String paramString, Marker paramMarker)
  {
    paramString = (lo)this.c.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramMarker != null)
      {
        bool1 = bool2;
        if (paramString.a != null)
        {
          paramString = paramString.a.iterator();
          Marker localMarker;
          do
          {
            bool1 = bool2;
            if (!paramString.hasNext()) {
              break;
            }
            localMarker = (Marker)paramString.next();
          } while ((localMarker == null) || (localMarker != paramMarker));
          bool1 = true;
        }
      }
    }
    this.a.s();
    return bool1;
  }
  
  public final boolean d(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!nl.a(paramString2))
      {
        bool1 = bool2;
        if (paramString1.a != null)
        {
          paramString1 = paramString1.a.iterator();
          Marker localMarker;
          do
          {
            bool1 = bool2;
            if (!paramString1.hasNext()) {
              break;
            }
            localMarker = (Marker)paramString1.next();
          } while ((localMarker == null) || (!localMarker.getId().equals(paramString2)));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean e(String paramString1, String paramString2)
  {
    paramString1 = (lo)this.c.get(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!nl.a(paramString2))
      {
        bool1 = bool2;
        if (paramString1.a != null)
        {
          paramString1 = paramString1.a.iterator();
          Marker localMarker;
          do
          {
            bool1 = bool2;
            if (!paramString1.hasNext()) {
              break;
            }
            localMarker = (Marker)paramString1.next();
          } while ((localMarker == null) || (!localMarker.getId().equals(paramString2)));
          bool1 = true;
        }
      }
    }
    this.a.s();
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lp
 * JD-Core Version:    0.7.0.1
 */