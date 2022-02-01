import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler;
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

public class bckw
  implements bclw<bcff>
{
  private static final Comparator<bcff> jdField_a_of_type_JavaUtilComparator = new bckx();
  public static boolean a;
  private static final Comparator<bcff> jdField_b_of_type_JavaUtilComparator = new bcky();
  private static final Comparator<RecentUser> jdField_c_of_type_JavaUtilComparator = new bckz();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private bcld jdField_a_of_type_Bcld;
  private bclx<bcff> jdField_a_of_type_Bclx;
  protected QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<bcff> jdField_a_of_type_JavaUtilList;
  private Map<String, ArrayList<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilMap;
  private Queue<bclb> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private bclc[] jdField_a_of_type_ArrayOfBclc = { new bclc(1, "friend"), new bclc(768, "phone_contact"), new bclc(4, "discussion_member"), new bclc(8, "discussion"), new bclc(16, "troop"), new bclc(32, "recent_user"), new bclc(64, "tool"), new bclc(2048, "circle_buddy"), new bclc(131072, "global_troop_member"), new bclc(8388608, "qcircle_friends") };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List<ArrayList<DiscussionMemberInfo>> jdField_b_of_type_JavaUtilList;
  private Queue<bclb> jdField_b_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private List<WeakReference<bcla>> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private long d = -1L;
  private long e = -1L;
  private long f = -1L;
  private long g = -1L;
  
  public bckw(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
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
      if (bcnc.a(paramInt1)) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      this.jdField_b_of_type_JavaLangString = "people";
      continue;
      this.jdField_b_of_type_JavaLangString = "msg";
    }
  }
  
  public bckw(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
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
    case 131072: 
      return 8;
    }
    return 9;
  }
  
  public static int a(bcff parambcff)
  {
    int i = -1;
    if ((parambcff instanceof bcdu)) {
      i = 0;
    }
    do
    {
      return i;
      if ((parambcff instanceof bceb)) {
        return 1;
      }
      if ((parambcff instanceof bcdt)) {
        return 2;
      }
      if ((parambcff instanceof bcdr)) {
        return 3;
      }
      if ((parambcff instanceof bcee)) {
        return 4;
      }
    } while (!(parambcff instanceof bcec));
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
  
  private List<bcff> a(bcla parambcla)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBclc.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Long = -1L;
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
          if (parambcla.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          bcff localbcff = (bcff)localList.get(i);
          long l1 = System.nanoTime();
          try
          {
            localbcff.b(str);
            long l2 = System.nanoTime();
            int j = a(localbcff);
            if (j != -1)
            {
              bclc localbclc = this.jdField_a_of_type_ArrayOfBclc[j];
              localbclc.jdField_b_of_type_Long = (l2 - l1 + localbclc.jdField_b_of_type_Long);
            }
            if (localbcff.b() != -9223372036854775808L) {
              localArrayList.add(localbcff);
            }
            i += 1;
          }
          finally {}
        }
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfBclc.length)
        {
          this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Long /= 1000000L;
          i += 1;
        }
        a(str, localArrayList, false);
        return localArrayList;
      }
    }
  }
  
  private List<bcff> a(String paramString, boolean paramBoolean)
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
            bclb localbclb = (bclb)localIterator.next();
            if ((!paramString.startsWith(localbclb.jdField_a_of_type_JavaLangString)) || (localbclb.jdField_a_of_type_JavaLangString.length() <= i)) {
              break label252;
            }
            i = localbclb.jdField_a_of_type_JavaLangString.length();
            localObject = localbclb;
            break label255;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilQueue;
          continue;
        }
        if ((localObject != null) && (((bclb)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + ((bclb)localObject).jdField_a_of_type_JavaLangString + " , cache size = " + ((bclb)localObject).jdField_a_of_type_JavaUtilList.size());
          }
          paramString = ((bclb)localObject).jdField_a_of_type_JavaUtilList;
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
  
  private void a(String paramString, List<bcff> paramList, boolean paramBoolean)
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
      localQueue.add(new bclb(this, paramString, paramList));
      return;
      label124:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        bclb localbclb = (bclb)localIterator.next();
        if (localbclb.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localbclb);
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
        i = parambcff2.c().toString().compareTo(parambcff1.c().toString());
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
          j = parambcff2.d().toString().compareTo(parambcff1.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<bcff> b(bcla parambcla)
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
    label505:
    label511:
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
          break label1414;
        }
        if (parambcla.a())
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
        if (bcmz.c())
        {
          ??? = (aoyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a(2);
          localObject4 = ((aoyg)???).a(str);
          if (parambcla.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          l2 = System.currentTimeMillis() - l1;
          n = a(131072);
          this.jdField_a_of_type_ArrayOfBclc[n].jdField_b_of_type_Long = (1000000L * l2);
          this.f = l2;
          this.e = ((aoyg)???).b();
          if (localObject4 != null)
          {
            j = ((List)localObject4).size();
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + l2 + "; size : " + j + "; keyWord: " + str);
            }
            ??? = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (((0x10000 & this.jdField_a_of_type_Int) == 0) && ((0x20000 & this.jdField_a_of_type_Int) == 0)) {
              break label505;
            }
          }
          for (k = 1;; k = 0)
          {
            i = m;
            if (localObject4 == null) {
              break label1245;
            }
            i = m;
            if (((List)localObject4).size() <= 0) {
              break label1245;
            }
            localObject3 = new ArrayList();
            i = 0;
            if (i >= ((List)localObject4).size()) {
              break label597;
            }
            if (!parambcla.a()) {
              break label511;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
            j = 0;
            break;
          }
          localObject5 = (TroopIndex)((List)localObject4).get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(String.valueOf(((TroopIndex)localObject5).mTroopUin)) != 3)
          {
            if (k == 0) {
              break label565;
            }
            ((List)localObject3).add(localObject5);
          }
          for (;;)
          {
            i += 1;
            break;
            label565:
            if (((TroopManager)???).c(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
              ((List)localObject3).add(localObject5);
            }
          }
          label597:
          i = m;
          if (((List)localObject3).size() > 0)
          {
            if (((0x20000 & this.jdField_a_of_type_Int) == 0) && ((0x400000 & this.jdField_a_of_type_Int) == 0)) {
              break label1443;
            }
            localObject4 = new ArrayList();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            i = 0;
            if (i < ((List)localObject3).size())
            {
              if (parambcla.a())
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
                  ((List)localObject4).add(new bcdy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
                } else {
                  ((List)localObject4).add(new bcea(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
                }
              }
            }
            ((List)localObject1).addAll((Collection)localObject4);
          }
        }
      }
    }
    label1414:
    label1443:
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
          if (parambcla.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          localObject6 = (TroopIndex)((List)localObject3).get(k);
          bcdx localbcdx = new bcdx(((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberNick);
          ArrayList localArrayList;
          if (!((HashMap)localObject5).containsKey(((TroopIndex)localObject6).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localbcdx);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
          for (;;)
          {
            k += 1;
            break;
            localArrayList = (ArrayList)((HashMap)localObject5).get(((TroopIndex)localObject6).mTroopUin);
            localArrayList.add(localbcdx);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
        }
        localObject3 = ((HashMap)localObject5).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject6 = (String)((Iterator)localObject3).next();
          if (!((TroopManager)???).c(String.valueOf(localObject6)).isNewTroop()) {
            ((List)localObject4).add(new bcdv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          } else {
            ((List)localObject4).add(new bcdz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          }
        }
        ((List)localObject1).addAll((Collection)localObject4);
        i += ((List)localObject4).size();
      }
      for (;;)
      {
        for (;;)
        {
          label1245:
          l2 = System.currentTimeMillis() - l1 - l2;
          this.jdField_a_of_type_ArrayOfBclc[n].jdField_b_of_type_Int = i;
          this.jdField_a_of_type_ArrayOfBclc[n].jdField_a_of_type_Long = l2;
          this.g = (System.currentTimeMillis() - l1);
          this.d = j;
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + l2 + "; size : " + i + "; keyWord: " + str);
          }
          break;
          synchronized ((bcff)((List)localObject1).get(i))
          {
            ((bcff)???).b(str);
            if (((bcff)???).b() != -9223372036854775808L) {
              ((List)localObject3).add(???);
            }
            i += 1;
          }
        }
        if (((List)localObject3).size() < 100) {
          a(str, (List)localObject3, true);
        }
        return localObject3;
        return null;
      }
    }
  }
  
  private List<bcff> b(bcmk parambcmk)
  {
    Object localObject2 = new bcla(this, false);
    boolean bool;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localObject2));
        this.jdField_a_of_type_JavaLangString = parambcmk.jdField_a_of_type_JavaLangString;
        if (parambcmk.jdField_a_of_type_AndroidOsBundle != null)
        {
          bool = parambcmk.jdField_a_of_type_AndroidOsBundle.getBoolean("searchRequestFromHome", false);
          ??? = this.jdField_a_of_type_JavaLangString;
          if (!((bcla)localObject2).a()) {
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
    Object localObject4 = a((bcla)localObject2);
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
        l2 = bbzc.r;
        l3 = bbzc.v;
        l4 = bbzc.V;
        localIterator = ((List)localObject4).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          bcff localbcff = (bcff)localIterator.next();
          if (((bcla)localObject2).a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
            }
            return null;
            i = 0;
            break;
          }
          if (((localbcff instanceof bcdr)) || ((localbcff instanceof bcee))) {
            this.jdField_c_of_type_Int += 1;
          }
          if (localbcff.b() > l2 + l3 + l4) {
            localHashSet.add(localbcff.a());
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
      if (((bcla)localObject2).a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
        }
        return null;
      }
      if ((parambcmk.jdField_a_of_type_AndroidOsBundle != null) && (parambcmk.jdField_a_of_type_AndroidOsBundle.containsKey("searchTroopMember"))) {}
      for (bool = parambcmk.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");; bool = true)
      {
        if (i != 0) {
          if (!bool) {}
        }
        for (parambcmk = b((bcla)localObject2); ((bcla)localObject2).a(); parambcmk = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
          parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", true);
        }
        if (localObject4 != null) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
        if (parambcmk != null) {
          ((List)localObject3).addAll(parambcmk);
        }
        localObject4 = new ArrayList();
        if (a((List)localObject3, (List)localObject4, (bcla)localObject2, (String)???)) {
          return null;
        }
        parambcmk = new ArrayList();
        localObject2 = ((List)localObject4).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bcff)((Iterator)localObject2).next();
          if ((localObject3 instanceof bcdv))
          {
            j = i + 1;
            i = j;
            if (j > 200) {
              break label715;
            }
            parambcmk.add(localObject3);
            i = j;
          }
          label715:
          for (;;)
          {
            break;
            parambcmk.add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() troopCount:" + i);
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + parambcmk.size() + " ; keyword = " + (String)???);
          if (jdField_a_of_type_Boolean)
          {
            i = 0;
            while (i < this.jdField_a_of_type_ArrayOfBclc.length)
            {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int + " ; keyword = " + (String)???);
              i += 1;
            }
          }
        }
        this.jdField_a_of_type_Long = (l2 - l1);
        this.jdField_b_of_type_Long = parambcmk.size();
        ??? = new HashMap();
        ((HashMap)???).put("result_size", String.valueOf(parambcmk.size()));
        i = 0;
        if (i < 5)
        {
          if (i < parambcmk.size()) {
            ((HashMap)???).put("result_top_" + i, String.valueOf(((bcff)parambcmk.get(i)).b()));
          }
          for (;;)
          {
            i += 1;
            break;
            ((HashMap)???).put("result_top_" + i, "0");
          }
        }
        this.jdField_b_of_type_Boolean = false;
        localObject2 = parambcmk.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bcff)((Iterator)localObject2).next();
          ((bcff)localObject3).a = ((HashMap)???);
          if ("9970".equals(((bcff)localObject3).b())) {
            this.jdField_b_of_type_Boolean = true;
          }
        }
        return parambcmk;
      }
    }
  }
  
  private List<bcff> c(bcmk parambcmk)
  {
    bcla localbcla = new bcla(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localbcla));
      this.jdField_a_of_type_JavaLangString = parambcmk.jdField_a_of_type_JavaLangString;
      return b(localbcla);
    }
  }
  
  private void f()
  {
    int k = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().getRecentList(true, true, false);
    Object localObject1 = awtz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    label201:
    label206:
    label209:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap == null)
        {
          Object localObject1 = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject1 == null) {
            break label201;
          }
          localObject4 = ((antp)localObject1).a();
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
              break label206;
            }
          }
          else
          {
            localObject1 = ((antp)localObject1).a(arrayOfString);
            localObject4 = new ArrayList(arrayOfString.length);
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label209;
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
      break label206;
      Object localObject3 = null;
      continue;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Comparator<bcff> a()
  {
    return null;
  }
  
  protected List<bcff> a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBclc.length)
    {
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = 0L;
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().getRecentList(false);
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
              localObject5 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if ((localObject5 != null) && (!((anvk)localObject5).b(((RecentUser)localObject4).uin))) {
                ((List)localObject1).add(new bcec(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (RecentUser)localObject4, a(((RecentUser)localObject4).uin)));
              }
              break;
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(32);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject6;
    Object localObject7;
    label444:
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject4 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject4 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((anvk)localObject4).c();
        if (localObject1 != null)
        {
          localObject5 = ((List)localObject1).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Groups)((Iterator)localObject5).next();
            localObject1 = ((anvk)localObject4).a(String.valueOf(((Groups)localObject6).group_id));
            if (localObject1 != null)
            {
              localObject7 = ((List)localObject1).iterator();
              QQAppInterface localQQAppInterface;
              while (((Iterator)localObject7).hasNext())
              {
                localFriends = (Friends)((Iterator)localObject7).next();
                if (bjxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, this.jdField_b_of_type_Int))
                {
                  localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  i = this.jdField_b_of_type_Int;
                  if (localFriends.gathtertype != 1) {
                    break label554;
                  }
                }
              }
              label554:
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131719792);; localObject1 = ((Groups)localObject6).group_name)
              {
                ((List)localObject2).add(new bcdu(localQQAppInterface, i, localFriends, (String)localObject1, a(localFriends.uin)));
                break label444;
                break;
              }
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((0x800000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = QCircleDoubleFollowUserHepler.getInstance().getFollowUserList();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Friends)((Iterator)localObject2).next();
          ((List)localObject1).add(new bcdu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (Friends)localObject4, BaseApplicationImpl.sApplication.getResources().getString(2131697780), a(((Friends)localObject4).uin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(8388608);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((awyz)localObject2).e();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = (List)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((awyz)localObject2).e();
        if ((localObject2 != null) && (((List)localObject2).size() > 1))
        {
          localObject2 = (List)((List)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((awyz)localObject2).g();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((awyz)localObject2).f();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
              localFriends = ((anvk)localObject2).b(((DiscussionMemberInfo)localObject6).memberUin);
              if ((localFriends == null) || (!localFriends.isFriend()))
              {
                ((Set)localObject5).add(localObject7);
                ((List)localObject1).add(new bcdt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject6));
              }
            }
          }
          i += 1;
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(4);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
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
          ((List)localObject2).add(new bcdr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject5, (List)localObject1, a(((DiscussionInfo)localObject5).uin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = new ArrayList();
      awtz.a().h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = ((TroopManager)localObject2).b();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject2).next();
          ((List)localObject1).add(new bcee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, a(((TroopInfo)localObject4).troopuin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(16);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9993L), 6000, a(String.valueOf(9993L))));
      ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9973L), 9002, a(String.valueOf(9973L))));
      if ((bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!bmhv.n()))
      {
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.KANDIAN_MERGE_UIN), 7220, a(String.valueOf(AppConstants.KANDIAN_MERGE_UIN))));
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9970L), 7120, a(String.valueOf(9970L))));
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230, a(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN))));
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9980L), 9000, a(String.valueOf(9980L))));
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9994L), 5000, a(String.valueOf(9994L))));
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9992L), 7000, a(String.valueOf(9992L))));
        localObject2 = (aipw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        if ((localObject2 == null) || (!((aipw)localObject2).b())) {
          break label2964;
        }
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9960L), 9003, a(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      for (;;)
      {
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN), 4000, a(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN))));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().getRecentList(true);
        if (localObject2 == null) {
          break label2982;
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
              ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), a(((RecentUser)localObject4).uin)));
            }
            break;
          }
        }
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9975L), 7210, a(String.valueOf(9975L))));
        if (bmhv.n()) {
          break;
        }
        ((List)localObject1).add(new bced(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, AppConstants.NEW_KANDIAN_UIN, 1008, a(String.valueOf(AppConstants.NEW_KANDIAN_UIN))));
        break;
        label2964:
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
        }
      }
      label2982:
      ((List)localObject3).addAll((Collection)localObject1);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = new ArrayList();
      localObject1 = a();
      if (localObject1 == null) {
        break label3661;
      }
    }
    label3245:
    label3391:
    label3661:
    for (Object localObject1 = (List)((Map)localObject1).get(this.jdField_c_of_type_JavaLangString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject4 = (DiscussionMemberInfo)((List)localObject1).get(i);
          ((List)localObject2).add(new bcdt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject4));
          i += 1;
        }
        ((List)localObject3).addAll((Collection)localObject2);
      }
      if (((paramInt & 0x2000) != 0) || ((0x40000 & paramInt) != 0) || ((0x100000 & paramInt) != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((EntityManager)localObject1).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_c_of_type_JavaLangString }, null, null, null, null);
        localObject5 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
        if (localObject5 == null)
        {
          localObject1 = "";
          if (localObject2 == null) {
            break label3391;
          }
          localObject6 = ((List)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject2 = (TroopMemberInfo)((Iterator)localObject6).next();
          } while ((!bhbx.d(((TroopMemberInfo)localObject2).memberuin)) || (((0x40000 & paramInt) != 0) && (localObject5 != null) && (!((TroopInfo)localObject5).isTroopAdmin(((TroopMemberInfo)localObject2).memberuin)) && (!((TroopInfo)localObject5).isTroopOwner(((TroopMemberInfo)localObject2).memberuin))));
          if ((0x100000 & paramInt) == 0) {
            break label3369;
          }
        }
        for (localObject2 = new bcgt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2, (String)localObject1);; localObject2 = new bcef(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2))
        {
          ((List)localObject4).add(localObject2);
          break label3245;
          localObject1 = ((TroopInfo)localObject5).troopcode;
          break;
        }
        ((List)localObject3).addAll((Collection)localObject4);
      }
      if ((0x80000 & paramInt) != 0)
      {
        l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((PhoneContactManagerImp)localObject2).b();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new bceb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject1);
        l2 = System.currentTimeMillis();
        paramInt = a(768);
        this.jdField_a_of_type_ArrayOfBclc[paramInt].jdField_a_of_type_Long = (l2 - l1);
        this.jdField_a_of_type_ArrayOfBclc[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
      }
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bcff)((Iterator)localObject2).next();
          if (!this.jdField_a_of_type_JavaUtilSet.contains(((bcff)localObject3).b())) {
            ((List)localObject1).add(localObject3);
          }
        }
        return localObject1;
      }
      return localObject3;
    }
  }
  
  public List<bcff> a(bcmk parambcmk)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (parambcmk.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool1 = parambcmk.jdField_a_of_type_AndroidOsBundle.getBoolean("searchCreateDiscussion", false);
      bool2 = parambcmk.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember", false);
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
          if (this.jdField_a_of_type_Bcld != null) {
            return this.jdField_a_of_type_Bcld.a(parambcmk);
          }
        }
        else
        {
          if (bool2) {
            return c(parambcmk);
          }
          return b(parambcmk);
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
      this.jdField_a_of_type_Bcld = new bcld(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bcld.a();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (jdField_a_of_type_Boolean)
      {
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfBclc.length)
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int);
          i += 1;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBclc.length)
    {
      localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_Long));
      localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int));
      i += 1;
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.jdField_a_of_type_JavaUtilList.size(), localHashMap, "", false);
  }
  
  public void a(bcmk parambcmk, bclx<bcff> parambclx)
  {
    this.jdField_a_of_type_Bclx = parambclx;
    ThreadManager.postImmediately(new ContactSearchEngine.4(this, parambcmk), null, true);
  }
  
  public boolean a(List<bcff> paramList1, List<bcff> paramList2, bcla arg3, String paramString)
  {
    bcla localbcla = ???;
    if (??? == null) {
      localbcla = new bcla(this, false);
    }
    bcff localbcff1;
    for (;;)
    {
      bcff localbcff2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localbcla));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localbcff1 = (bcff)paramList1.next();
        localbcff2 = (bcff)???.get(localbcff1.a());
        if (localbcla.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
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
      if (localbcla.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localbcff1 = (bcff)localbcff1.clone();
      if (localbcff1 != null) {
        paramList1.add(localbcff1);
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
        bcla localbcla = (bcla)localWeakReference.get();
        if (localbcla != null)
        {
          localbcla.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_c_of_type_JavaUtilList = localObject2;
    if (this.jdField_a_of_type_Bcld != null) {
      this.jdField_a_of_type_Bcld.b();
    }
    this.jdField_a_of_type_Bclx = null;
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
        while (i < this.jdField_a_of_type_ArrayOfBclc.length)
        {
          localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Long));
          localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfBclc[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfBclc[i].jdField_b_of_type_Int));
          i += 1;
        }
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.f));
      localHashMap.put("size_global_troop_member", String.valueOf(this.d));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.g));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.e));
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "", false);
      if (this.jdField_b_of_type_Boolean)
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.g + " ; troopMemberQueryTime = " + this.f + " ; troopMemberTotalSize = " + this.e + " ; troopMemberResultSize = " + this.d);
      }
    }
    if (this.jdField_c_of_type_Int > 0) {
      new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.jdField_c_of_type_Int) }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckw
 * JD-Core Version:    0.7.0.1
 */