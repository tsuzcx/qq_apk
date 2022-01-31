import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bjnh
{
  final Map<bjnp, List<bjni>> a;
  final Map<bjni, bjnp> b;
  
  bjnh(Map<bjni, bjnp> paramMap)
  {
    this.b = paramMap;
    this.a = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bjnp localbjnp = (bjnp)localEntry.getValue();
      List localList = (List)this.a.get(localbjnp);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.a.put(localbjnp, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnh
 * JD-Core Version:    0.7.0.1
 */