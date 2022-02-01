import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;

public class bgor
  implements Manager
{
  private HashMap<Long, bgos> a = new HashMap();
  
  public ArrayList<bgop> a(long paramLong)
  {
    bgos localbgos = (bgos)this.a.get(Long.valueOf(paramLong));
    if (localbgos != null)
    {
      localbgos.jdField_a_of_type_Long = System.currentTimeMillis();
      return localbgos.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  public void a()
  {
    if (this.a.size() > 20)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.a.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Long.valueOf(((bgos)((Iterator)localObject2).next()).jdField_a_of_type_Long));
      }
      Collections.sort((List)localObject1, Collections.reverseOrder());
      long l = ((Long)((ArrayList)localObject1).get(19)).longValue();
      localObject1 = this.a.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((bgos)((Map.Entry)localObject2).getValue()).jdField_a_of_type_Long < l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutMgr", 2, "eliminateAppInfoCache troopUin:" + ((Map.Entry)localObject2).getKey());
          }
          ((Iterator)localObject1).remove();
        }
      }
    }
  }
  
  public void a(long paramLong, ArrayList<bgop> paramArrayList)
  {
    bgos localbgos = (bgos)this.a.get(Long.valueOf(paramLong));
    if (localbgos != null)
    {
      localbgos.jdField_a_of_type_Long = System.currentTimeMillis();
      localbgos.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new bgos(System.currentTimeMillis(), paramArrayList, null));
  }
  
  public boolean a()
  {
    bgko localbgko = (bgko)aran.a().a(590);
    if (localbgko == null) {
      return false;
    }
    return localbgko.a();
  }
  
  public ArrayList<bgop> b(long paramLong)
  {
    bgos localbgos = (bgos)this.a.get(Long.valueOf(paramLong));
    if (localbgos != null)
    {
      localbgos.jdField_a_of_type_Long = System.currentTimeMillis();
      return localbgos.b;
    }
    return null;
  }
  
  public void b(long paramLong, ArrayList<bgop> paramArrayList)
  {
    bgos localbgos = (bgos)this.a.get(Long.valueOf(paramLong));
    if (localbgos != null)
    {
      localbgos.jdField_a_of_type_Long = System.currentTimeMillis();
      localbgos.b = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new bgos(System.currentTimeMillis(), null, paramArrayList));
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgor
 * JD-Core Version:    0.7.0.1
 */