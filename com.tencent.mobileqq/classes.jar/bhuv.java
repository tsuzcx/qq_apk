import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bhuv
{
  final Map<bhvd, List<bhuw>> a;
  final Map<bhuw, bhvd> b;
  
  bhuv(Map<bhuw, bhvd> paramMap)
  {
    this.b = paramMap;
    this.a = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bhvd localbhvd = (bhvd)localEntry.getValue();
      List localList = (List)this.a.get(localbhvd);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.a.put(localbhvd, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhuv
 * JD-Core Version:    0.7.0.1
 */