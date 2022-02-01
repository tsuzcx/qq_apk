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

public class bfoq
  implements Manager
{
  private HashMap<Long, bfor> a = new HashMap();
  
  public ArrayList<bfoo> a(long paramLong)
  {
    bfor localbfor = (bfor)this.a.get(Long.valueOf(paramLong));
    if (localbfor != null)
    {
      localbfor.jdField_a_of_type_Long = System.currentTimeMillis();
      return localbfor.jdField_a_of_type_JavaUtilArrayList;
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
        ((ArrayList)localObject1).add(Long.valueOf(((bfor)((Iterator)localObject2).next()).jdField_a_of_type_Long));
      }
      Collections.sort((List)localObject1, Collections.reverseOrder());
      long l = ((Long)((ArrayList)localObject1).get(19)).longValue();
      localObject1 = this.a.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((bfor)((Map.Entry)localObject2).getValue()).jdField_a_of_type_Long < l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutMgr", 2, "eliminateAppInfoCache troopUin:" + ((Map.Entry)localObject2).getKey());
          }
          ((Iterator)localObject1).remove();
        }
      }
    }
  }
  
  public void a(long paramLong, ArrayList<bfoo> paramArrayList)
  {
    bfor localbfor = (bfor)this.a.get(Long.valueOf(paramLong));
    if (localbfor != null)
    {
      localbfor.jdField_a_of_type_Long = System.currentTimeMillis();
      localbfor.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new bfor(System.currentTimeMillis(), paramArrayList, null));
  }
  
  public boolean a()
  {
    bfkn localbfkn = (bfkn)aqlk.a().a(590);
    if (localbfkn == null) {
      return false;
    }
    return localbfkn.a();
  }
  
  public ArrayList<bfoo> b(long paramLong)
  {
    bfor localbfor = (bfor)this.a.get(Long.valueOf(paramLong));
    if (localbfor != null)
    {
      localbfor.jdField_a_of_type_Long = System.currentTimeMillis();
      return localbfor.b;
    }
    return null;
  }
  
  public void b(long paramLong, ArrayList<bfoo> paramArrayList)
  {
    bfor localbfor = (bfor)this.a.get(Long.valueOf(paramLong));
    if (localbfor != null)
    {
      localbfor.jdField_a_of_type_Long = System.currentTimeMillis();
      localbfor.b = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new bfor(System.currentTimeMillis(), null, paramArrayList));
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoq
 * JD-Core Version:    0.7.0.1
 */