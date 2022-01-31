import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class awtu
  implements awuu<awoe>
{
  private static final Comparator<awoe> jdField_a_of_type_JavaUtilComparator = new awtv();
  public static boolean a;
  private static final Comparator<awoe> jdField_b_of_type_JavaUtilComparator = new awtw();
  private static final Comparator<RecentUser> jdField_c_of_type_JavaUtilComparator = new awtx();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private awub jdField_a_of_type_Awub;
  private awuv<awoe> jdField_a_of_type_Awuv;
  protected QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<awoe> jdField_a_of_type_JavaUtilList;
  private Map<String, ArrayList<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilMap;
  private Queue<awtz> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private awua[] jdField_a_of_type_ArrayOfAwua = { new awua(1, "friend"), new awua(768, "phone_contact"), new awua(4, "discussion_member"), new awua(8, "discussion"), new awua(16, "troop"), new awua(32, "recent_user"), new awua(64, "tool"), new awua(2048, "circle_buddy"), new awua(131072, "global_troop_member") };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List<ArrayList<DiscussionMemberInfo>> jdField_b_of_type_JavaUtilList;
  private Queue<awtz> jdField_b_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private List<WeakReference<awty>> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private long d = -1L;
  private long e = -1L;
  private long f = -1L;
  private long g = -1L;
  
  public awtu(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_c_of_type_JavaLangString = paramString;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (awwa.a(paramInt1)) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      this.jdField_b_of_type_JavaLangString = "people";
      continue;
      this.jdField_b_of_type_JavaLangString = "msg";
    }
  }
  
  public awtu(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
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
    case 4: 
      return 2;
    case 8: 
      return 3;
    case 16: 
      return 4;
    case 32: 
      return 5;
    case 2048: 
      return 7;
    }
    return 8;
  }
  
  public static int a(awoe paramawoe)
  {
    int i = -1;
    if ((paramawoe instanceof awmt)) {
      i = 0;
    }
    do
    {
      return i;
      if ((paramawoe instanceof awna)) {
        return 1;
      }
      if ((paramawoe instanceof awms)) {
        return 2;
      }
      if ((paramawoe instanceof awmq)) {
        return 3;
      }
      if ((paramawoe instanceof awnd)) {
        return 4;
      }
    } while (!(paramawoe instanceof awnb));
    return 5;
  }
  
  private int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private List<ArrayList<DiscussionMemberInfo>> a()
  {
    g();
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  private List<awoe> a(awty paramawty)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAwua.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Long = -1L;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    List localList = a(str, false);
    if (localList != null)
    {
      if (!QLog.isColorLevel()) {
        break label343;
      }
      QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
    }
    label343:
    for (;;)
    {
      if (localList == null)
      {
        return null;
        localList = this.jdField_a_of_type_JavaUtilList;
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          if (paramawty.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          awoe localawoe = (awoe)localList.get(i);
          long l1 = System.nanoTime();
          try
          {
            localawoe.b(str);
            long l2 = System.nanoTime();
            int j = a(localawoe);
            if (j != -1)
            {
              awua localawua = this.jdField_a_of_type_ArrayOfAwua[j];
              localawua.jdField_b_of_type_Long = (l2 - l1 + localawua.jdField_b_of_type_Long);
            }
            if (localawoe.b() != -9223372036854775808L) {
              localArrayList.add(localawoe);
            }
            i += 1;
          }
          finally {}
        }
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAwua.length)
        {
          this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Long /= 1000000L;
          i += 1;
        }
        a(str, localArrayList, false);
        return localArrayList;
      }
    }
  }
  
  private List<awoe> a(String paramString, boolean paramBoolean)
  {
    label252:
    label255:
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Object localObject;
        if (paramBoolean)
        {
          localObject = this.jdField_b_of_type_JavaUtilQueue;
          Iterator localIterator = ((Queue)localObject).iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            awtz localawtz = (awtz)localIterator.next();
            if ((!paramString.startsWith(localawtz.jdField_a_of_type_JavaLangString)) || (localawtz.jdField_a_of_type_JavaLangString.length() <= i)) {
              break label252;
            }
            i = localawtz.jdField_a_of_type_JavaLangString.length();
            localObject = localawtz;
            break label255;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilQueue;
          continue;
        }
        if ((localObject != null) && (((awtz)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + ((awtz)localObject).jdField_a_of_type_JavaLangString + " , cache size = " + ((awtz)localObject).jdField_a_of_type_JavaUtilList.size());
          }
          paramString = ((awtz)localObject).jdField_a_of_type_JavaUtilList;
          return paramString;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  private Map<String, ArrayList<DiscussionMemberInfo>> a()
  {
    g();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  private void a(String paramString, List<awoe> paramList, boolean paramBoolean)
  {
    Queue localQueue;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
          return;
        }
        if (paramBoolean)
        {
          localQueue = this.jdField_b_of_type_JavaUtilQueue;
          if (localQueue.size() <= 2) {
            break;
          }
          localQueue.poll();
          continue;
        }
        localQueue = this.jdField_a_of_type_JavaUtilQueue;
      }
      finally {}
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label124;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new awtz(this, paramString, paramList));
      return;
      label124:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        awtz localawtz = (awtz)localIterator.next();
        if (localawtz.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localawtz);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private static int b(awoe paramawoe1, awoe paramawoe2)
  {
    int j = 0;
    int i = j;
    if (paramawoe2.c() != null)
    {
      i = j;
      if (paramawoe1.c() != null) {
        i = paramawoe2.c().toString().compareTo(paramawoe1.c().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramawoe2.d() != null)
      {
        j = i;
        if (paramawoe1.d() != null) {
          j = paramawoe2.d().toString().compareTo(paramawoe1.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<awoe> b(awty paramawty)
  {
    String str;
    Object localObject1;
    Object localObject3;
    long l1;
    Object localObject4;
    long l2;
    int n;
    int j;
    int k;
    label498:
    label504:
    Object localObject5;
    if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x20000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0) || ((0x400000 & this.jdField_a_of_type_Int) != 0))
    {
      str = this.jdField_a_of_type_JavaLangString;
      localObject1 = a(str, true);
      if ((localObject1 != null) && (((List)localObject1).size() < 100))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchTroopMember use cache, keyword = " + str);
        }
        localObject3 = new ArrayList();
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label1407;
        }
        if (paramawty.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      else
      {
        localObject1 = new ArrayList();
        l1 = System.currentTimeMillis();
        int m = 0;
        ??? = (aktm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2);
        localObject4 = ((aktm)???).a(str);
        if (paramawty.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
        l2 = System.currentTimeMillis() - l1;
        n = a(131072);
        this.jdField_a_of_type_ArrayOfAwua[n].jdField_b_of_type_Long = (1000000L * l2);
        this.f = l2;
        this.e = ((aktm)???).b();
        if (localObject4 != null)
        {
          j = ((List)localObject4).size();
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + l2 + "; size : " + j + "; keyWord: " + str);
          }
          ??? = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((0x10000 & this.jdField_a_of_type_Int) == 0) && ((0x20000 & this.jdField_a_of_type_Int) == 0)) {
            break label498;
          }
        }
        for (k = 1;; k = 0)
        {
          i = m;
          if (localObject4 == null) {
            break label1238;
          }
          i = m;
          if (((List)localObject4).size() <= 0) {
            break label1238;
          }
          localObject3 = new ArrayList();
          i = 0;
          if (i >= ((List)localObject4).size()) {
            break label590;
          }
          if (!paramawty.a()) {
            break label504;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
          j = 0;
          break;
        }
        localObject5 = (TroopIndex)((List)localObject4).get(i);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(((TroopIndex)localObject5).mTroopUin)) != 3)
        {
          if (k == 0) {
            break label558;
          }
          ((List)localObject3).add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break;
          label558:
          if (((TroopManager)???).c(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
            ((List)localObject3).add(localObject5);
          }
        }
        label590:
        i = m;
        if (((List)localObject3).size() > 0)
        {
          if (((0x20000 & this.jdField_a_of_type_Int) == 0) && ((0x400000 & this.jdField_a_of_type_Int) == 0)) {
            break label1436;
          }
          localObject4 = new ArrayList();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          i = 0;
          if (i < ((List)localObject3).size())
          {
            if (paramawty.a())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
              }
              return null;
            }
            localObject5 = (TroopIndex)((List)localObject3).get(i);
            if ("50000000".equals(((TroopIndex)localObject5).mMemberUin)) {}
            for (;;)
            {
              i += 1;
              break;
              if (!((TroopManager)???).c(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
                ((List)localObject4).add(new awmx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
              } else {
                ((List)localObject4).add(new awmz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
              }
            }
          }
          ((List)localObject1).addAll((Collection)localObject4);
        }
      }
    }
    label1436:
    for (int i = ((List)localObject4).size() + 0;; i = 0)
    {
      if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0))
      {
        localObject4 = new ArrayList();
        localObject5 = new HashMap();
        k = 0;
        Object localObject6;
        if (k < ((List)localObject3).size())
        {
          if (paramawty.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          localObject6 = (TroopIndex)((List)localObject3).get(k);
          awmw localawmw = new awmw(((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberNick);
          ArrayList localArrayList;
          if (!((HashMap)localObject5).containsKey(((TroopIndex)localObject6).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localawmw);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
          for (;;)
          {
            k += 1;
            break;
            localArrayList = (ArrayList)((HashMap)localObject5).get(((TroopIndex)localObject6).mTroopUin);
            localArrayList.add(localawmw);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
        }
        localObject3 = ((HashMap)localObject5).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject6 = (String)((Iterator)localObject3).next();
          if (!((TroopManager)???).c(String.valueOf(localObject6)).isNewTroop()) {
            ((List)localObject4).add(new awmu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          } else {
            ((List)localObject4).add(new awmy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          }
        }
        ((List)localObject1).addAll((Collection)localObject4);
        i += ((List)localObject4).size();
      }
      for (;;)
      {
        for (;;)
        {
          label1238:
          l2 = System.currentTimeMillis() - l1 - l2;
          this.jdField_a_of_type_ArrayOfAwua[n].jdField_b_of_type_Int = i;
          this.jdField_a_of_type_ArrayOfAwua[n].jdField_a_of_type_Long = l2;
          this.g = (System.currentTimeMillis() - l1);
          this.d = j;
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + l2 + "; size : " + i + "; keyWord: " + str);
          }
          break;
          synchronized ((awoe)((List)localObject1).get(i))
          {
            ((awoe)???).b(str);
            if (((awoe)???).b() != -9223372036854775808L) {
              ((List)localObject3).add(???);
            }
            i += 1;
          }
        }
        label1407:
        if (((List)localObject3).size() < 100) {
          a(str, (List)localObject3, true);
        }
        return localObject3;
        return null;
      }
    }
  }
  
  private List<awoe> b(awvi paramawvi)
  {
    Object localObject2 = new awty(this, false);
    boolean bool;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localObject2));
        this.jdField_a_of_type_JavaLangString = paramawvi.jdField_a_of_type_JavaLangString;
        if (paramawvi.jdField_a_of_type_AndroidOsBundle != null)
        {
          bool = paramawvi.jdField_a_of_type_AndroidOsBundle.getBoolean("searchRequestFromHome", false);
          ??? = this.jdField_a_of_type_JavaLangString;
          if (!((awty)localObject2).a()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
        }
      }
      bool = false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject3 = new ArrayList();
    Object localObject4 = a((awty)localObject2);
    this.jdField_c_of_type_Int = 0;
    int i;
    HashSet localHashSet;
    long l2;
    long l3;
    long l4;
    Iterator localIterator;
    int j;
    if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x20000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0) || ((0x400000 & this.jdField_a_of_type_Int) != 0))
    {
      i = 1;
      if ((localObject4 != null) && (i != 0) && (bool))
      {
        localHashSet = new HashSet();
        l2 = awii.r;
        l3 = awii.v;
        l4 = awii.V;
        localIterator = ((List)localObject4).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          awoe localawoe = (awoe)localIterator.next();
          if (((awty)localObject2).a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
            }
            return null;
            i = 0;
            break;
          }
          if (((localawoe instanceof awmq)) || ((localawoe instanceof awnd))) {
            this.jdField_c_of_type_Int += 1;
          }
          if (localawoe.b() > l2 + l3 + l4) {
            localHashSet.add(localawoe.a());
          }
          if (localHashSet.size() > 5)
          {
            j = 0;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("ContactSearchEngine", 2, "searchContact no need to search troop member, keyword = " + (String)???);
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((awty)localObject2).a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
        }
        return null;
      }
      if ((paramawvi.jdField_a_of_type_AndroidOsBundle != null) && (paramawvi.jdField_a_of_type_AndroidOsBundle.containsKey("searchTroopMember"))) {}
      for (bool = paramawvi.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");; bool = true)
      {
        if (i != 0) {
          if (!bool) {}
        }
        for (paramawvi = b((awty)localObject2); ((awty)localObject2).a(); paramawvi = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
          paramawvi.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", true);
        }
        if (localObject4 != null) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
        if (paramawvi != null) {
          ((List)localObject3).addAll(paramawvi);
        }
        localObject4 = new ArrayList();
        if (a((List)localObject3, (List)localObject4, (awty)localObject2, (String)???)) {
          return null;
        }
        paramawvi = new ArrayList();
        localObject2 = ((List)localObject4).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (awoe)((Iterator)localObject2).next();
          if ((localObject3 instanceof awmu))
          {
            j = i + 1;
            i = j;
            if (j > 200) {
              break label715;
            }
            paramawvi.add(localObject3);
            i = j;
          }
          label715:
          for (;;)
          {
            break;
            paramawvi.add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() troopCount:" + i);
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + paramawvi.size() + " ; keyword = " + (String)???);
          if (jdField_a_of_type_Boolean)
          {
            i = 0;
            while (i < this.jdField_a_of_type_ArrayOfAwua.length)
            {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int + " ; keyword = " + (String)???);
              i += 1;
            }
          }
        }
        this.jdField_a_of_type_Long = (l2 - l1);
        this.jdField_b_of_type_Long = paramawvi.size();
        ??? = new HashMap();
        ((HashMap)???).put("result_size", String.valueOf(paramawvi.size()));
        i = 0;
        if (i < 5)
        {
          if (i < paramawvi.size()) {
            ((HashMap)???).put("result_top_" + i, String.valueOf(((awoe)paramawvi.get(i)).b()));
          }
          for (;;)
          {
            i += 1;
            break;
            ((HashMap)???).put("result_top_" + i, "0");
          }
        }
        this.jdField_b_of_type_Boolean = false;
        localObject2 = paramawvi.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (awoe)((Iterator)localObject2).next();
          ((awoe)localObject3).a = ((HashMap)???);
          if ("9970".equals(((awoe)localObject3).b())) {
            this.jdField_b_of_type_Boolean = true;
          }
        }
        return paramawvi;
      }
    }
  }
  
  private List<awoe> c(awvi paramawvi)
  {
    awty localawty = new awty(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localawty));
      this.jdField_a_of_type_JavaLangString = paramawvi.jdField_a_of_type_JavaLangString;
      return b(localawty);
    }
  }
  
  private void f()
  {
    int k = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true, true, false);
    Object localObject1 = asfd.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject2 != null)
    {
      j = ((List)localObject2).size();
      if (localObject1 == null) {
        break label156;
      }
    }
    ArrayList localArrayList;
    label156:
    for (int i = ((List)localObject1).size();; i = 0)
    {
      localArrayList = new ArrayList(j + i);
      localArrayList.addAll((Collection)localObject2);
      j = 0;
      while (j < i)
      {
        localObject2 = new RecentUser();
        ((RecentUser)localObject2).uin = ((TroopAssistantData)((List)localObject1).get(j)).troopUin;
        ((RecentUser)localObject2).lastmsgtime = ((TroopAssistantData)((List)localObject1).get(j)).lastmsgtime;
        localArrayList.add(localObject2);
        j += 1;
      }
      j = 0;
      break;
    }
    Collections.sort(localArrayList, jdField_c_of_type_JavaUtilComparator);
    int j = localArrayList.size();
    i = k;
    while ((i < j) && (i < 999))
    {
      localObject1 = (RecentUser)localArrayList.get(i);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RecentUser)localObject1).uin, Integer.valueOf(999 - i));
      i += 1;
    }
  }
  
  private void g()
  {
    Object localObject4 = null;
    label200:
    label205:
    label208:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap == null)
        {
          Object localObject1 = (ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject1 == null) {
            break label200;
          }
          localObject4 = ((ajvi)localObject1).a();
          String[] arrayOfString = new String[((List)localObject4).size()];
          localObject4 = ((List)localObject4).iterator();
          int i = 0;
          if (((Iterator)localObject4).hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
            if ((localDiscussionInfo != null) && (localDiscussionInfo.uin != null) && (localDiscussionInfo.uin.length() > 0))
            {
              arrayOfString[i] = localDiscussionInfo.uin;
              i += 1;
              break label205;
            }
          }
          else
          {
            localObject1 = ((ajvi)localObject1).a(arrayOfString);
            localObject4 = new ArrayList(arrayOfString.length);
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label208;
            }
            ((List)localObject4).add((ArrayList)((Map)localObject1).get(arrayOfString[i]));
            i += 1;
            continue;
            this.jdField_a_of_type_JavaUtilMap = ((Map)localObject1);
            this.jdField_b_of_type_JavaUtilList = ((List)localObject4);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      break label205;
      Object localObject3 = null;
      continue;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Comparator<awoe> a()
  {
    return null;
  }
  
  protected List<awoe> a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAwua.length)
    {
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    f();
    Object localObject3 = new ArrayList();
    long l1;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((RecentUser)localObject4).uin)) && (!"50000000".equals(((RecentUser)localObject4).uin))) {
            switch (((RecentUser)localObject4).getType())
            {
            case 1001: 
            case 1002: 
            case 1003: 
            default: 
              break;
            case 1000: 
            case 1004: 
            case 1005: 
            case 1006: 
              localObject5 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if ((localObject5 != null) && (!((ajxl)localObject5).b(((RecentUser)localObject4).uin))) {
                ((List)localObject1).add(new awnb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (RecentUser)localObject4, a(((RecentUser)localObject4).uin)));
              }
              break;
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(32);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject6;
    Object localObject7;
    label442:
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject4 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject4 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((ajxl)localObject4).c();
        if (localObject1 != null)
        {
          localObject5 = ((List)localObject1).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Groups)((Iterator)localObject5).next();
            localObject1 = ((ajxl)localObject4).a(String.valueOf(((Groups)localObject6).group_id));
            if (localObject1 != null)
            {
              localObject7 = ((List)localObject1).iterator();
              QQAppInterface localQQAppInterface;
              while (((Iterator)localObject7).hasNext())
              {
                localFriends = (Friends)((Iterator)localObject7).next();
                if (bduf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, this.jdField_b_of_type_Int))
                {
                  localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  i = this.jdField_b_of_type_Int;
                  if (localFriends.gathtertype != 1) {
                    break label552;
                  }
                }
              }
              label552:
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131720649);; localObject1 = ((Groups)localObject6).group_name)
              {
                ((List)localObject2).add(new awmt(localQQAppInterface, i, localFriends, (String)localObject1, a(localFriends.uin)));
                break label442;
                break;
              }
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((askn)localObject2).e();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = (List)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new awna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((askn)localObject2).e();
        if ((localObject2 != null) && (((List)localObject2).size() > 1))
        {
          localObject2 = (List)((List)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new awna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((askn)localObject2).g();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new awna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject2 != null)
      {
        localObject2 = ((askn)localObject2).f();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new awna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject2 != null)
      {
        localObject4 = a();
        localObject5 = new HashSet();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject4).size())
        {
          int j = 0;
          if (j < ((ArrayList)((List)localObject4).get(i)).size())
          {
            localObject6 = (DiscussionMemberInfo)((ArrayList)((List)localObject4).get(i)).get(j);
            localObject7 = ((DiscussionMemberInfo)localObject6).memberUin + ((DiscussionMemberInfo)localObject6).inteRemark + ((DiscussionMemberInfo)localObject6).memberName;
            if (((Set)localObject5).contains(localObject7)) {}
            for (;;)
            {
              j += 1;
              break;
              localFriends = ((ajxl)localObject2).b(((DiscussionMemberInfo)localObject6).memberUin);
              if ((localFriends == null) || (!localFriends.isFriend()))
              {
                ((Set)localObject5).add(localObject7);
                ((List)localObject1).add(new awms(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject6));
              }
            }
          }
          i += 1;
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(4);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = ((ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
      if (localObject1 != null)
      {
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
          localObject1 = null;
          localObject6 = a();
          if (localObject6 != null) {
            localObject1 = (List)((Map)localObject6).get(((DiscussionInfo)localObject5).uin);
          }
          ((List)localObject2).add(new awmq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject5, (List)localObject1, a(((DiscussionInfo)localObject5).uin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = new ArrayList();
      asfd.a().h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = ((TroopManager)localObject2).a();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject2).next();
          ((List)localObject1).add(new awnd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, a(((TroopInfo)localObject4).troopuin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(16);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9993L), 6000, a(String.valueOf(9993L))));
      ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9973L), 9002, a(String.valueOf(9973L))));
      if ((bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!bhvy.k()))
      {
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(ajsd.aA), 7220, a(String.valueOf(ajsd.aA))));
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9970L), 7120, a(String.valueOf(9970L))));
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ajsd.aB, 7230, a(String.valueOf(ajsd.aB))));
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9980L), 9000, a(String.valueOf(9980L))));
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9994L), 5000, a(String.valueOf(9994L))));
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9992L), 7000, a(String.valueOf(9992L))));
        localObject2 = (afax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138);
        if ((localObject2 == null) || (!((afax)localObject2).b())) {
          break label2788;
        }
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9960L), 9003, a(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      for (;;)
      {
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(ajsd.D), 4000, a(String.valueOf(ajsd.D))));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
        if (localObject2 == null) {
          break label2806;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          switch (((RecentUser)localObject4).getType())
          {
          default: 
            break;
          case 1001: 
          case 5000: 
          case 7000: 
          case 7120: 
          case 7230: 
          case 9000: 
          case 10002: 
          case 10004: 
            if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), a(((RecentUser)localObject4).uin)));
            }
            break;
          }
        }
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9975L), 7210, a(String.valueOf(9975L))));
        if (bhvy.k()) {
          break;
        }
        ((List)localObject1).add(new awnc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ajsd.az, 1008, a(String.valueOf(ajsd.az))));
        break;
        label2788:
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
        }
      }
      label2806:
      ((List)localObject3).addAll((Collection)localObject1);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = new ArrayList();
      localObject1 = a();
      if (localObject1 == null) {
        break label3483;
      }
    }
    label3214:
    label3483:
    for (Object localObject1 = (List)((Map)localObject1).get(this.jdField_c_of_type_JavaLangString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject4 = (DiscussionMemberInfo)((List)localObject1).get(i);
          ((List)localObject2).add(new awms(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject4));
          i += 1;
        }
        ((List)localObject3).addAll((Collection)localObject2);
      }
      if (((paramInt & 0x2000) != 0) || ((0x40000 & paramInt) != 0) || ((0x100000 & paramInt) != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((aukp)localObject1).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_c_of_type_JavaLangString }, null, null, null, null);
        localObject5 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_c_of_type_JavaLangString);
        if (localObject5 == null)
        {
          localObject1 = "";
          if (localObject2 == null) {
            break label3214;
          }
          localObject6 = ((List)localObject2).iterator();
          label3068:
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject2 = (TroopMemberInfo)((Iterator)localObject6).next();
          } while ((!bbbr.d(((TroopMemberInfo)localObject2).memberuin)) || (((0x40000 & paramInt) != 0) && (localObject5 != null) && (!((TroopInfo)localObject5).isTroopAdmin(((TroopMemberInfo)localObject2).memberuin)) && (!((TroopInfo)localObject5).isTroopOwner(((TroopMemberInfo)localObject2).memberuin))));
          if ((0x100000 & paramInt) == 0) {
            break label3192;
          }
        }
        label3192:
        for (localObject2 = new awps(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2, (String)localObject1);; localObject2 = new awne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2))
        {
          ((List)localObject4).add(localObject2);
          break label3068;
          localObject1 = ((TroopInfo)localObject5).troopcode;
          break;
        }
        ((List)localObject3).addAll((Collection)localObject4);
      }
      if ((0x80000 & paramInt) != 0)
      {
        l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localObject2 != null)
        {
          localObject2 = ((PhoneContactManagerImp)localObject2).b();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new awna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject1);
        l2 = System.currentTimeMillis();
        paramInt = a(768);
        this.jdField_a_of_type_ArrayOfAwua[paramInt].jdField_a_of_type_Long = (l2 - l1);
        this.jdField_a_of_type_ArrayOfAwua[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
      }
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (awoe)((Iterator)localObject2).next();
          if (!this.jdField_a_of_type_JavaUtilSet.contains(((awoe)localObject3).b())) {
            ((List)localObject1).add(localObject3);
          }
        }
        return localObject1;
      }
      return localObject3;
    }
  }
  
  public List<awoe> a(awvi paramawvi)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (paramawvi.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool1 = paramawvi.jdField_a_of_type_AndroidOsBundle.getBoolean("searchCreateDiscussion", false);
      bool2 = paramawvi.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember", false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 64)
      {
        bool1 = false;
        bool2 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          if (this.jdField_a_of_type_Awub != null) {
            return this.jdField_a_of_type_Awub.a(paramawvi);
          }
        }
        else
        {
          if (bool2) {
            return c(paramawvi);
          }
          return b(paramawvi);
        }
        return new ArrayList();
      }
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Awub = new awub(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Awub.a();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (jdField_a_of_type_Boolean)
      {
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAwua.length)
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int);
          i += 1;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAwua.length)
    {
      localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_Long));
      localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int));
      i += 1;
    }
    axrn.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.jdField_a_of_type_JavaUtilList.size(), localHashMap, "", false);
  }
  
  public void a(awvi paramawvi, awuv<awoe> paramawuv)
  {
    this.jdField_a_of_type_Awuv = paramawuv;
    ThreadManager.postImmediately(new ContactSearchEngine.4(this, paramawvi), null, true);
  }
  
  public boolean a(List<awoe> paramList1, List<awoe> paramList2, awty arg3, String paramString)
  {
    awty localawty = ???;
    if (??? == null) {
      localawty = new awty(this, false);
    }
    awoe localawoe1;
    for (;;)
    {
      awoe localawoe2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localawty));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localawoe1 = (awoe)paramList1.next();
        localawoe2 = (awoe)???.get(localawoe1.a());
        if (localawty.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localawoe2 == null) || (localawoe2.b() < localawoe1.b())) {
        ???.put(localawoe1.a(), localawoe1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localawoe1 = (awoe)???.next();
      if (localawty.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localawoe1 = (awoe)localawoe1.clone();
      if (localawoe1 != null) {
        paramList1.add(localawoe1);
      }
    }
    try
    {
      Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
      label298:
      int i = Math.min(paramList1.size(), 30);
      ??? = paramList1.subList(0, i);
      paramString = a();
      if (paramString == null) {
        Collections.sort(???, jdField_b_of_type_JavaUtilComparator);
      }
      paramList2.addAll(???);
      paramList2.addAll(paramList1.subList(i, paramList1.size()));
      if (paramString != null) {
        Collections.sort(paramList2, paramString);
      }
      return false;
    }
    catch (Throwable ???)
    {
      break label298;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        awty localawty = (awty)localWeakReference.get();
        if (localawty != null)
        {
          localawty.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_c_of_type_JavaUtilList = localObject2;
    if (this.jdField_a_of_type_Awub != null) {
      this.jdField_a_of_type_Awub.b();
    }
    this.jdField_a_of_type_Awuv = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_Long != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
      {
        localHashMap.put("keyword", str);
        localHashMap.put("totalSize", String.valueOf(this.jdField_c_of_type_Long));
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAwua.length)
        {
          localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Long));
          localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfAwua[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfAwua[i].jdField_b_of_type_Int));
          i += 1;
        }
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.f));
      localHashMap.put("size_global_troop_member", String.valueOf(this.d));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.g));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.e));
      axrn.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "", false);
      if (this.jdField_b_of_type_Boolean)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.g + " ; troopMemberQueryTime = " + this.f + " ; troopMemberTotalSize = " + this.e + " ; troopMemberResultSize = " + this.d);
      }
    }
    if (this.jdField_c_of_type_Int > 0) {
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.jdField_c_of_type_Int) }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtu
 * JD-Core Version:    0.7.0.1
 */