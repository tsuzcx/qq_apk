package com.android.dx.command.dexer;

import com.android.dx.cf.direct.ClassPathOpener.FileNameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Main$BestEffortMainDexListFilter
  implements ClassPathOpener.FileNameFilter
{
  Map<String, List<String>> map = new HashMap();
  
  public Main$BestEffortMainDexListFilter()
  {
    Iterator localIterator = Main.access$1000().iterator();
    while (localIterator.hasNext())
    {
      String str1 = Main.access$900((String)localIterator.next());
      String str2 = getSimpleName(str1);
      List localList = (List)this.map.get(str2);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(1);
        this.map.put(str2, localObject);
      }
      ((List)localObject).add(str1);
    }
  }
  
  private static String getSimpleName(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public boolean accept(String paramString)
  {
    if (paramString.endsWith(".class"))
    {
      paramString = Main.access$900(paramString);
      Object localObject = getSimpleName(paramString);
      localObject = (List)this.map.get(localObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.endsWith((String)((Iterator)localObject).next())) {
            return true;
          }
        }
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.BestEffortMainDexListFilter
 * JD-Core Version:    0.7.0.1
 */