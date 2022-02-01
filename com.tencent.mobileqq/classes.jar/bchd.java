import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.mostused.MostUsedSearch;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bchd
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator<bchg> jdField_a_of_type_JavaUtilComparator = new bche();
  private static final Comparator<MostUsedSearch> b = new bchf();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<MostUsedSearch> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  
  bchd(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int j = paramString2.indexOf(paramString1);
    int k = paramString1.length();
    int m = paramString2.length();
    int i = 0;
    if (j == 0)
    {
      if (k == m) {
        i = 2;
      }
    }
    else {
      return i;
    }
    return 1;
  }
  
  private String a()
  {
    Object localObject1 = new ByteArrayOutputStream();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      new ObjectOutputStream((OutputStream)localObject1).writeObject(this.jdField_a_of_type_JavaUtilArrayList);
      localObject1 = new String(Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 0));
      return localObject1;
    }
    catch (IOException localIOException)
    {
      QLog.e("MostUsedCahce", 2, " toSerialsString IOException: " + localIOException.toString());
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("MostUsedCahce", 2, " toSerialsString IllegalArgumentException : " + localIllegalArgumentException.toString());
      return null;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static ArrayList<bchg> a(ArrayList<bchg> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    QLog.d("MostUsedCahcesortAndDuplicate", 2, "sortAndDuplicate begin: size: " + paramArrayList.size());
    Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bchg localbchg = (bchg)paramArrayList.next();
      int i = localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType * 100 + localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType;
      HashMap localHashMap;
      if (((HashMap)localObject).containsKey(Integer.valueOf(i)))
      {
        localHashMap = (HashMap)((HashMap)localObject).get(Integer.valueOf(i));
        if (localHashMap.containsKey(localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) {
          QLog.d("MostUsedCahce", 2, "more high level exsit " + localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify);
        } else {
          localHashMap.put(localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify, localbchg);
        }
      }
      else
      {
        localHashMap = new HashMap();
        localHashMap.put(localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify, localbchg);
        ((HashMap)localObject).put(Integer.valueOf(i), localHashMap);
      }
    }
    if ((((HashMap)localObject).values() != null) && (((HashMap)localObject).values().size() > 0))
    {
      paramArrayList = ((HashMap)localObject).values().iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (HashMap)paramArrayList.next();
        if ((localObject != null) && (((HashMap)localObject).values() != null) && (((HashMap)localObject).values().size() > 0))
        {
          localObject = ((HashMap)localObject).values().iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add((bchg)((Iterator)localObject).next());
          }
        }
      }
    }
    Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
    QLog.d("MostUsedCahcesortAndDuplicate", 2, "sortAndDuplicate sorted: size: " + localArrayList.size());
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      paramString = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0)));
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramString.readObject());
      long l = NetConnInfoCenter.getServerTimeMillis();
      a(this.jdField_a_of_type_JavaUtilArrayList, 1000, l - 604800000L);
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("MostUsedCahce", 2, " fromSerialsString IOException : " + paramString.toString());
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      QLog.e("MostUsedCahce", 2, " fromSerialsString ClassNotFoundException : " + paramString.toString());
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.e("MostUsedCahce", 2, " fromSerialsString IllegalArgumentException : " + paramString.toString());
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static void a(ArrayList<MostUsedSearch> paramArrayList, int paramInt, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label105:
    for (;;)
    {
      return;
      Collections.sort(paramArrayList, b);
      int i = paramArrayList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        MostUsedSearch localMostUsedSearch = (MostUsedSearch)paramArrayList.get(i);
        if ((localMostUsedSearch != null) && (localMostUsedSearch.latestUsedTime >= paramLong) && (i < paramInt)) {
          break;
        }
        paramArrayList.remove(i);
        QLog.d("MostUsedCahce", 2, "list  remove " + i);
        i -= 1;
      }
    }
  }
  
  public ArrayList<bchg> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface = new ArrayList();
    if (TextUtils.isEmpty(paramString.trim())) {
      return paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label243;
        }
        MostUsedSearch localMostUsedSearch = (MostUsedSearch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int k = a(paramString, localMostUsedSearch.orgKey);
        if (k != 0)
        {
          j = 0;
          if (j < localMostUsedSearch.items.size())
          {
            MostUsedSearchItem localMostUsedSearchItem = (MostUsedSearchItem)localMostUsedSearch.items.get(j);
            long l = NetConnInfoCenter.getServerTimeMillis();
            if (localMostUsedSearchItem.timeStamp >= l - 604800000L)
            {
              bchg localbchg = new bchg(this);
              localbchg.jdField_a_of_type_Boolean = false;
              localbchg.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem = new MostUsedSearchItem(localMostUsedSearchItem);
              localbchg.jdField_a_of_type_Int = k;
              paramQQAppInterface.add(localbchg);
            }
            else
            {
              QLog.d("MostUsedCahce", 2, "key:" + paramString + "temp timeStamp over time " + localMostUsedSearchItem.timeStamp);
            }
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      i += 1;
      continue;
      label243:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null)
      {
        QLog.e("MostUsedCahce", 2, "sorted size  is NULL ");
        return paramQQAppInterface;
      }
      QLog.i("MostUsedCahce", 2, "Result size  is " + paramQQAppInterface.size());
      return paramQQAppInterface;
      j += 1;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	bchd:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 75 1 0
    //   9: aload_0
    //   10: getfield 39	bchd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: getfield 39	bchd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   20: invokevirtual 232	java/util/ArrayList:clear	()V
    //   23: aload_0
    //   24: getfield 44	bchd:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   27: invokeinterface 100 1 0
    //   32: getstatic 22	bchd:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 271	bchd:jdField_a_of_type_Boolean	Z
    //   43: aload_1
    //   44: monitorexit
    //   45: ldc 102
    //   47: iconst_2
    //   48: ldc_w 322
    //   51: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 44	bchd:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 100 1 0
    //   65: aload_1
    //   66: athrow
    //   67: astore_2
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	bchd
    //   55	14	1	localObject2	Object
    //   67	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	55	finally
    //   38	45	67	finally
    //   68	70	67	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    SharedPreferences.Editor localEditor;
    String str;
    do
    {
      return;
      localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
      str = "MostUsed" + this.jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_Boolean) {
        b(paramQQAppInterface);
      }
      paramQQAppInterface = a();
    } while (TextUtils.isEmpty(paramQQAppInterface));
    localEditor.putString(str, paramQQAppInterface);
    localEditor.apply();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MostUsedSearchItem paramMostUsedSearchItem)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramQQAppInterface);
    }
    if ((paramMostUsedSearchItem == null) || (TextUtils.isEmpty(paramMostUsedSearchItem.searchKey))) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label328;
        }
        paramQQAppInterface = (MostUsedSearch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramMostUsedSearchItem.searchKey.equals(paramQQAppInterface.orgKey))
        {
          int j = 0;
          long l2 = 0L;
          i = 0;
          if (i < paramQQAppInterface.items.size())
          {
            MostUsedSearchItem localMostUsedSearchItem = (MostUsedSearchItem)paramQQAppInterface.items.get(i);
            long l1;
            if (l2 == 0L)
            {
              l1 = localMostUsedSearchItem.timeStamp;
              if (MostUsedSearchItem.isSameIdentityItem(localMostUsedSearchItem, paramMostUsedSearchItem))
              {
                localMostUsedSearchItem.timeStamp = paramMostUsedSearchItem.timeStamp;
                i = 0;
                if (i == 0) {
                  break label333;
                }
                if (paramQQAppInterface.items.size() > 2) {
                  paramQQAppInterface.items.remove(j);
                }
                paramQQAppInterface.items.add(paramMostUsedSearchItem);
                paramQQAppInterface.latestUsedTime = paramMostUsedSearchItem.timeStamp;
                break label333;
                if (i == 0)
                {
                  paramQQAppInterface = new MostUsedSearch();
                  paramQQAppInterface.orgKey = paramMostUsedSearchItem.searchKey;
                  paramQQAppInterface.items.add(paramMostUsedSearchItem);
                  paramQQAppInterface.latestUsedTime = paramMostUsedSearchItem.timeStamp;
                  this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
                }
                l1 = NetConnInfoCenter.getServerTimeMillis();
                a(this.jdField_a_of_type_JavaUtilArrayList, 1000, l1 - 604800000L);
                return true;
              }
            }
            else
            {
              l1 = l2;
              if (l2 <= localMostUsedSearchItem.timeStamp) {
                continue;
              }
              l1 = localMostUsedSearchItem.timeStamp;
              j = i;
              continue;
            }
            i += 1;
            l2 = l1;
            continue;
          }
        }
        else
        {
          i += 1;
          continue;
        }
        i = 1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      continue;
      label328:
      i = 0;
      continue;
      label333:
      i = 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("MostUsedCahce", 2, "mCacheName  null");
        return;
      }
    }
    QLog.d("MostUsedCahce", 2, "list  init");
    paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp().getBaseContext()).getString("MostUsed" + this.jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), "");
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      a(paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchd
 * JD-Core Version:    0.7.0.1
 */