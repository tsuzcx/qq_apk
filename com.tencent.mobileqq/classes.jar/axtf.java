import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.1;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.3;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class axtf
  implements Manager
{
  public QQAppInterface a;
  public EntityManager a;
  public Object a;
  public Map<String, RecentInviteUser> a;
  protected Object b = new Object();
  
  public axtf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.post(new WerewolvesDataManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  public List<RecentInviteUser> a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = this.jdField_a_of_type_JavaUtilMap.values();
      ??? = ((Collection)localObject3).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject3).uinType == 0) {
          localArrayList.add(localObject3);
        }
      }
    }
    synchronized (this.b)
    {
      Collections.sort(localList);
      return localList;
    }
  }
  
  public void a(RecentInviteUser paramRecentInviteUser)
  {
    ThreadManager.post(new WerewolvesDataManager.3(this, paramRecentInviteUser), 5, null, false);
  }
  
  public void a(String arg1, int paramInt, String paramString2)
  {
    String str = RecentInviteUser.getKey(paramInt, ???);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ??? = (RecentInviteUser)this.jdField_a_of_type_JavaUtilMap.get(str);
      ??? = ???;
      if (??? == null)
      {
        ??? = new RecentInviteUser();
        ((RecentInviteUser)???).uniKey = str;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, ???);
        ((RecentInviteUser)???).uin = ???;
        ((RecentInviteUser)???).uinType = paramInt;
        ((RecentInviteUser)???).lastInviteId = paramString2;
      }
    }
    synchronized (this.b)
    {
      ((RecentInviteUser)???).lastInviteTime = System.currentTimeMillis();
      a((RecentInviteUser)???);
      return;
      ??? = finally;
      throw ???;
      ??? = finally;
      throw ???;
    }
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, axtg paramaxtg)
  {
    ThreadManager.post(new WerewolvesDataManager.2(this, paramString1, paramString2, paramArrayList, paramaxtg), 8, null, true);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString1 = (RecentInviteUser)this.jdField_a_of_type_JavaUtilMap.get(RecentInviteUser.getKey(paramInt, paramString1));
      if (paramString1 != null)
      {
        boolean bool = TextUtils.equals(paramString1.lastInviteId, paramString2);
        return bool;
      }
      return false;
    }
  }
  
  public List<RecentInviteUser> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilMap.values();
      ??? = ((Collection)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject2).uinType == 1) {
          localArrayList.add(localObject2);
        }
      }
    }
    Collections.sort(localList);
    return localList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtf
 * JD-Core Version:    0.7.0.1
 */