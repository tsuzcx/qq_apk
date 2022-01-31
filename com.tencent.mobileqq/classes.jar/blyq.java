import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class blyq
{
  final Map<blyy, List<blyr>> a;
  final Map<blyr, blyy> b;
  
  blyq(Map<blyr, blyy> paramMap)
  {
    this.b = paramMap;
    this.a = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      blyy localblyy = (blyy)localEntry.getValue();
      List localList = (List)this.a.get(localblyy);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.a.put(localblyy, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyq
 * JD-Core Version:    0.7.0.1
 */