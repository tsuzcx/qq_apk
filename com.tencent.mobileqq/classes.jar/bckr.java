import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
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

public class bckr
  implements bclw<bcff>
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator<bcff> jdField_a_of_type_JavaUtilComparator = new bcks();
  private static Queue<bcku> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private int jdField_a_of_type_Int;
  private bclx<bcff> jdField_a_of_type_Bclx;
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private List<bcff> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private bckv[] jdField_a_of_type_ArrayOfBckv = { new bckv(1, "friend"), new bckv(768, "phone_contact"), new bckv(8, "discussion"), new bckv(16, "troop") };
  private int jdField_b_of_type_Int;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  private List<WeakReference<bckt>> jdField_b_of_type_JavaUtilList = new ArrayList();
  private String c;
  
  public bckr(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.c = paramString;
    this.jdField_b_of_type_JavaLangString = "people";
  }
  
  public bckr(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
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
  
  private List<bcff> a(bckt parambckt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBckv.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Long = -1L;
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
        if (parambckt.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      finally {}
      synchronized ((bcff)localArrayList2.get(i))
      {
        bcna localbcna = ((bcff)???).a(str);
        if ((localbcna != null) && (localbcna.a)) {
          localArrayList1.add(???);
        }
        i += 1;
      }
    }
    a(str, localArrayList1, false);
    return localArrayList1;
  }
  
  private List<bcff> a(String paramString, boolean paramBoolean)
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
          bcku localbcku = (bcku)localIterator.next();
          if ((!paramString.contains(localbcku.jdField_a_of_type_JavaLangString)) || (localbcku.jdField_a_of_type_JavaLangString.length() <= i)) {
            break label238;
          }
          i = localbcku.jdField_a_of_type_JavaLangString.length();
          localObject1 = localbcku;
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
  
  private void a(String paramString, List<bcff> paramList, boolean paramBoolean)
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
      localQueue.add(new bcku(this, paramString, paramList));
      return;
      label118:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        bcku localbcku = (bcku)localIterator.next();
        if (localbcku.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localbcku);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private static int b(bcff parambcff1, bcff parambcff2)
  {
    int j = 0;
    int i = j;
    if (parambcff2.c() != null)
    {
      i = j;
      if (parambcff1.c() != null) {
        i = parambcff1.c().toString().compareTo(parambcff2.c().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (parambcff2.d() != null)
      {
        j = i;
        if (parambcff1.d() != null) {
          j = parambcff1.d().toString().compareTo(parambcff2.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<bcff> b(bcmk parambcmk)
  {
    bckt localbckt = new bckt(this, false);
    boolean bool;
    do
    {
      ArrayList localArrayList;
      do
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localbckt));
          this.jdField_a_of_type_JavaLangString = parambcmk.jdField_a_of_type_JavaLangString;
          parambcmk = this.jdField_a_of_type_JavaLangString;
          if (localbckt.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + parambcmk);
            }
            return null;
          }
        }
        localArrayList = new ArrayList();
        ??? = a(localbckt);
        if (!localbckt.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + parambcmk);
      return null;
      if (??? != null) {
        localArrayList.addAll((Collection)???);
      }
      ??? = new ArrayList();
      bool = a(localArrayList, (List)???, localbckt, parambcmk);
      parambcmk = (bcmk)???;
      if (((List)???).size() > 40) {
        parambcmk = ((List)???).subList(0, 40);
      }
    } while (bool);
    return parambcmk;
  }
  
  protected List<bcff> a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBckv.length)
    {
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    label169:
    label254:
    long l2;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject4 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject4 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((anvk)localObject4).c();
        if (localObject1 != null)
        {
          Iterator localIterator1 = ((List)localObject1).iterator();
          while (localIterator1.hasNext())
          {
            Groups localGroups = (Groups)localIterator1.next();
            localObject1 = ((anvk)localObject4).a(String.valueOf(localGroups.group_id));
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
                  break label254;
                }
              }
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131719792);; localObject1 = localGroups.group_name)
              {
                ((List)localObject3).add(new bcdu(localQQAppInterface, i, localFriends, (String)localObject1, 0L));
                break label169;
                break;
              }
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject3 != null)
      {
        localObject3 = ((awyz)localObject3).e();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject3 != null)
      {
        localObject3 = ((awyz)localObject3).e();
        if ((localObject3 != null) && (((List)localObject3).size() > 1))
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new bcdr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBckv[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = new ArrayList();
      localObject3 = ((TroopManager)localObject3).b();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new bcee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = a(16);
      this.jdField_a_of_type_ArrayOfBckv[paramInt].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBckv[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bcff)((Iterator)localObject2).next();
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((bcff)localObject3).b())) {
          ((List)localObject1).add(localObject3);
        }
      }
      return localObject1;
    }
    return localObject2;
  }
  
  public List<bcff> a(bcmk parambcmk)
  {
    return b(parambcmk);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 73	bckr:jdField_a_of_type_Int	I
    //   5: invokevirtual 415	bckr:a	(I)Ljava/util/List;
    //   8: astore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +35 -> 47
    //   15: aload_1
    //   16: invokeinterface 161 1 0
    //   21: ifle +26 -> 47
    //   24: aload_0
    //   25: getfield 50	bckr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: invokeinterface 418 1 0
    //   33: aload_0
    //   34: getfield 50	bckr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: aload_1
    //   38: invokeinterface 157 2 0
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 50	bckr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   51: invokeinterface 418 1 0
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	bckr
    //   8	30	1	localList	List
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	44	59	finally
    //   44	46	59	finally
    //   47	56	59	finally
    //   60	62	59	finally
  }
  
  public void a(bcmk parambcmk, bclx<bcff> parambclx)
  {
    this.jdField_a_of_type_Bclx = parambclx;
    ThreadManager.postImmediately(new ApproximateSearchEngine.2(this, parambcmk), null, true);
  }
  
  public boolean a(List<bcff> paramList1, List<bcff> paramList2, bckt arg3, String paramString)
  {
    bckt localbckt = ???;
    if (??? == null) {
      localbckt = new bckt(this, false);
    }
    bcff localbcff1;
    for (;;)
    {
      bcff localbcff2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localbckt));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localbcff1 = (bcff)paramList1.next();
        localbcff2 = (bcff)???.get(localbcff1.a());
        if (localbckt.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localbcff2 == null) || (localbcff2.b() < localbcff1.b())) {
        ???.put(localbcff1.a(), localbcff1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localbcff1 = (bcff)???.next();
      if (localbckt.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localbcff1 = (bcff)localbcff1.clone();
      if (localbcff1 != null) {
        paramList1.add(localbcff1);
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
        bckt localbckt = (bckt)localWeakReference.get();
        if (localbckt != null)
        {
          localbckt.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_b_of_type_JavaUtilList = localObject2;
    this.jdField_a_of_type_Bclx = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    jdField_a_of_type_JavaUtilQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckr
 * JD-Core Version:    0.7.0.1
 */