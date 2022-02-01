import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bckx
  implements bcmc<bcfn>
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator<bcfn> jdField_a_of_type_JavaUtilComparator = new bcky();
  private static Queue<bcla> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private int jdField_a_of_type_Int;
  private bcmd<bcfn> jdField_a_of_type_Bcmd;
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private List<bcfn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private bclb[] jdField_a_of_type_ArrayOfBclb = { new bclb(1, "friend"), new bclb(768, "phone_contact"), new bclb(8, "discussion"), new bclb(16, "troop") };
  private int jdField_b_of_type_Int;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  private List<WeakReference<bckz>> jdField_b_of_type_JavaUtilList = new ArrayList();
  private String c;
  
  public bckx(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.c = paramString;
    this.jdField_b_of_type_JavaLangString = "people";
  }
  
  public bckx(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramQQAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 768: 
      return 1;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  private List<bcfn> a(bckz parambckz)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBclb.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Long = -1L;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    ??? = a(str, false);
    ArrayList localArrayList1 = new ArrayList();
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
      }
      localArrayList1.addAll((Collection)???);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return null;
        }
        localArrayList2.addAll(this.jdField_a_of_type_JavaUtilList);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        if (parambckz.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      finally {}
      synchronized ((bcfn)localArrayList2.get(i))
      {
        bcng localbcng = ((bcfn)???).a(str);
        if ((localbcng != null) && (localbcng.a)) {
          localArrayList1.add(???);
        }
        i += 1;
      }
    }
    a(str, localArrayList1, false);
    return localArrayList1;
  }
  
  private List<bcfn> a(String paramString, boolean paramBoolean)
  {
    label238:
    label241:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
        Object localObject1 = null;
        if (localIterator.hasNext())
        {
          bcla localbcla = (bcla)localIterator.next();
          if ((!paramString.contains(localbcla.jdField_a_of_type_JavaLangString)) || (localbcla.jdField_a_of_type_JavaLangString.length() <= i)) {
            break label238;
          }
          i = localbcla.jdField_a_of_type_JavaLangString.length();
          localObject1 = localbcla;
          break label241;
        }
        if ((localObject1 != null) && (localObject1.jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + localObject1.jdField_a_of_type_JavaLangString + " , cache size = " + localObject1.jdField_a_of_type_JavaUtilList.size());
          }
          paramString = localObject1.jdField_a_of_type_JavaUtilList;
          return paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApproximateSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  private void a(String paramString, List<bcfn> paramList, boolean paramBoolean)
  {
    Queue localQueue;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
        return;
      }
      localQueue = jdField_a_of_type_JavaUtilQueue;
      if (localQueue.size() > 2) {
        localQueue.poll();
      }
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label118;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new bcla(this, paramString, paramList));
      return;
      label118:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        bcla localbcla = (bcla)localIterator.next();
        if (localbcla.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localbcla);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private static int b(bcfn parambcfn1, bcfn parambcfn2)
  {
    int j = 0;
    int i = j;
    if (parambcfn2.c() != null)
    {
      i = j;
      if (parambcfn1.c() != null) {
        i = parambcfn1.c().toString().compareTo(parambcfn2.c().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (parambcfn2.d() != null)
      {
        j = i;
        if (parambcfn1.d() != null) {
          j = parambcfn1.d().toString().compareTo(parambcfn2.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<bcfn> b(bcmq parambcmq)
  {
    bckz localbckz = new bckz(this, false);
    boolean bool;
    do
    {
      ArrayList localArrayList;
      do
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localbckz));
          this.jdField_a_of_type_JavaLangString = parambcmq.jdField_a_of_type_JavaLangString;
          parambcmq = this.jdField_a_of_type_JavaLangString;
          if (localbckz.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + parambcmq);
            }
            return null;
          }
        }
        localArrayList = new ArrayList();
        ??? = a(localbckz);
        if (!localbckz.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + parambcmq);
      return null;
      if (??? != null) {
        localArrayList.addAll((Collection)???);
      }
      ??? = new ArrayList();
      bool = a(localArrayList, (List)???, localbckz, parambcmq);
      parambcmq = (bcmq)???;
      if (((List)???).size() > 40) {
        parambcmq = ((List)???).subList(0, 40);
      }
    } while (bool);
    return parambcmq;
  }
  
  protected List<bcfn> a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBclb.length)
    {
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    label168:
    label253:
    long l2;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject4 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject4 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((anyw)localObject4).c();
        if (localObject1 != null)
        {
          Iterator localIterator1 = ((List)localObject1).iterator();
          while (localIterator1.hasNext())
          {
            Groups localGroups = (Groups)localIterator1.next();
            localObject1 = ((anyw)localObject4).a(String.valueOf(localGroups.group_id));
            if (localObject1 != null)
            {
              Iterator localIterator2 = ((List)localObject1).iterator();
              Friends localFriends;
              QQAppInterface localQQAppInterface;
              if (localIterator2.hasNext())
              {
                localFriends = (Friends)localIterator2.next();
                localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                i = this.jdField_b_of_type_Int;
                if (localFriends.gathtertype != 1) {
                  break label253;
                }
              }
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131719084);; localObject1 = localGroups.group_name)
              {
                ((List)localObject3).add(new bcec(localQQAppInterface, i, localFriends, (String)localObject1, 0L));
                break label168;
                break;
              }
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject3 != null)
      {
        localObject3 = ((axfr)localObject3).e();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new bcej(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject3 != null)
      {
        localObject3 = ((axfr)localObject3).e();
        if ((localObject3 != null) && (((List)localObject3).size() > 1))
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new bcej(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new bcdz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclb[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = new ArrayList();
      localObject3 = ((TroopManager)localObject3).b();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new bcem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = a(16);
      this.jdField_a_of_type_ArrayOfBclb[paramInt].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclb[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bcfn)((Iterator)localObject2).next();
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((bcfn)localObject3).b())) {
          ((List)localObject1).add(localObject3);
        }
      }
      return localObject1;
    }
    return localObject2;
  }
  
  public List<bcfn> a(bcmq parambcmq)
  {
    return b(parambcmq);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 73	bckx:jdField_a_of_type_Int	I
    //   5: invokevirtual 401	bckx:a	(I)Ljava/util/List;
    //   8: astore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +35 -> 47
    //   15: aload_1
    //   16: invokeinterface 161 1 0
    //   21: ifle +26 -> 47
    //   24: aload_0
    //   25: getfield 50	bckx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: invokeinterface 404 1 0
    //   33: aload_0
    //   34: getfield 50	bckx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: aload_1
    //   38: invokeinterface 157 2 0
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 50	bckx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   51: invokeinterface 404 1 0
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	bckx
    //   8	30	1	localList	List
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	44	59	finally
    //   44	46	59	finally
    //   47	56	59	finally
    //   60	62	59	finally
  }
  
  public void a(bcmq parambcmq, bcmd<bcfn> parambcmd)
  {
    this.jdField_a_of_type_Bcmd = parambcmd;
    ThreadManager.postImmediately(new ApproximateSearchEngine.2(this, parambcmq), null, true);
  }
  
  public boolean a(List<bcfn> paramList1, List<bcfn> paramList2, bckz arg3, String paramString)
  {
    bckz localbckz = ???;
    if (??? == null) {
      localbckz = new bckz(this, false);
    }
    bcfn localbcfn1;
    for (;;)
    {
      bcfn localbcfn2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localbckz));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localbcfn1 = (bcfn)paramList1.next();
        localbcfn2 = (bcfn)???.get(localbcfn1.a());
        if (localbckz.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localbcfn2 == null) || (localbcfn2.b() < localbcfn1.b())) {
        ???.put(localbcfn1.a(), localbcfn1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localbcfn1 = (bcfn)???.next();
      if (localbckz.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localbcfn1 = (bcfn)localbcfn1.clone();
      if (localbcfn1 != null) {
        paramList1.add(localbcfn1);
      }
    }
    Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
    paramList2.addAll(paramList1);
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        bckz localbckz = (bckz)localWeakReference.get();
        if (localbckz != null)
        {
          localbckz.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_b_of_type_JavaUtilList = localObject2;
    this.jdField_a_of_type_Bcmd = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    jdField_a_of_type_JavaUtilQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckx
 * JD-Core Version:    0.7.0.1
 */