import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.1;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.2;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class azcb
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  private azce jdField_a_of_type_Azce = new azcc(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnlineStatusFriendsPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem;
  private ArrayList<WeakReference<azcd>> jdField_a_of_type_JavaUtilArrayList;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  
  public azcb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_Azce);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a();
    a(paramQQAppInterface);
  }
  
  private Pair<Boolean, List<Integer>> a(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!azch.a())
    {
      localArrayList.addAll(paramList);
      return new Pair(Boolean.valueOf(false), localArrayList);
    }
    List localList = ((arci)aqxe.a().a(652)).a.a(false);
    if (localList.size() <= 0)
    {
      localArrayList.addAll(paramList);
      return new Pair(Boolean.valueOf(false), localArrayList);
    }
    paramList = paramList.iterator();
    boolean bool = false;
    int i;
    if (paramList.hasNext())
    {
      Integer localInteger = (Integer)paramList.next();
      Iterator localIterator = localList.iterator();
      i = 0;
      label128:
      if (localIterator.hasNext())
      {
        azeo localazeo = (azeo)localIterator.next();
        if (localInteger.intValue() != localazeo.a) {
          break label208;
        }
        localArrayList.add(localInteger);
        i = 1;
      }
    }
    label208:
    for (;;)
    {
      break label128;
      if ((i == 0) && (!bool)) {
        bool = true;
      }
      for (;;)
      {
        break;
        return new Pair(Boolean.valueOf(bool), localArrayList);
      }
    }
  }
  
  private void a()
  {
    int j = 0;
    try
    {
      int i;
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label153;
        }
        i = 0;
      }
      for (;;)
      {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP mSmartSelectedList isEmpty=", Integer.valueOf(i) });
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label277;
        }
        Object localObject1 = SharePreferenceUtils.get(BaseApplication.getContext(), "smart_selected_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
        label153:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split("#");
          int k = localObject1.length;
          i = j;
          label116:
          if (i < k)
          {
            String str = localObject1[i];
            try
            {
              Integer localInteger = Integer.valueOf(str);
              this.jdField_a_of_type_JavaUtilList.add(localInteger);
              i += 1;
              break label116;
              i = this.jdField_a_of_type_JavaUtilList.size();
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP NumberFormatException selected=", str });
                }
              }
            }
          }
        }
      }
      localPair = a(this.jdField_a_of_type_JavaUtilList);
    }
    finally {}
    Pair localPair;
    if (((Boolean)localPair.first).booleanValue()) {
      b((List)localPair.second);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP mSmartSelectedList size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    label277:
  }
  
  /* Error */
  private void a(azcd paramazcd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	azcb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 220	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_2
    //   10: aload_2
    //   11: invokeinterface 107 1 0
    //   16: ifeq +56 -> 72
    //   19: aload_2
    //   20: invokeinterface 111 1 0
    //   25: checkcast 222	mqq/util/WeakReference
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 224	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   33: ifnull -23 -> 10
    //   36: aload_1
    //   37: aload_3
    //   38: invokevirtual 224	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   41: if_acmpne -31 -> 10
    //   44: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +22 -> 69
    //   50: ldc 138
    //   52: iconst_2
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: ldc 226
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_1
    //   65: aastore
    //   66: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 42	azcb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: new 222	mqq/util/WeakReference
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 229	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   84: invokevirtual 125	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: goto -19 -> 69
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	azcb
    //   0	96	1	paramazcd	azcd
    //   9	11	2	localIterator	Iterator
    //   28	10	3	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   2	10	91	finally
    //   10	69	91	finally
    //   72	88	91	finally
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManagerV2.excute(new OnlineStatusPermissionManager.1(this, paramQQAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (((WeakReference)localObject2).get() != null)
        {
          localObject2 = (azcd)((WeakReference)localObject2).get();
          ((azcd)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem, a());
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "notifyReceiveDataListener exist", localObject2 });
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  private void b(@NonNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem)
  {
    try
    {
      ThreadManagerV2.excute(new OnlineStatusPermissionManager.2(this, paramOnlineStatusFriendsPermissionItem), 16, null, true);
      return;
    }
    finally
    {
      paramOnlineStatusFriendsPermissionItem = finally;
      throw paramOnlineStatusFriendsPermissionItem;
    }
  }
  
  private boolean b(List<Integer> paramList)
  {
    boolean bool;
    if (paramList == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_a_of_type_JavaUtilList = paramList;
        bool = c(paramList);
      }
      finally {}
    }
  }
  
  private boolean c(List<Integer> paramList)
  {
    if (paramList.size() == 0)
    {
      SharePreferenceUtils.remove(BaseApplication.getContext(), "smart_selected_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuilder.append("#");
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "saveSmartSelectedListToSP ", localStringBuilder.toString() });
    }
    SharePreferenceUtils.set(BaseApplication.getContext(), "smart_selected_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localStringBuilder.toString());
    return true;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public OnlineStatusFriendsPermissionItem a(long paramLong, boolean paramBoolean, azcd paramazcd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +56 -> 61
    //   8: ldc 138
    //   10: iconst_2
    //   11: bipush 6
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc_w 284
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: lload_1
    //   25: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 291
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: aload_0
    //   38: getfield 22	azcb:jdField_a_of_type_Int	I
    //   41: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 293
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: iload_3
    //   54: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 52	azcb:jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem	Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;
    //   65: ifnull +14 -> 79
    //   68: aload_0
    //   69: getfield 52	azcb:jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem	Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: areturn
    //   79: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +24 -> 106
    //   85: ldc 138
    //   87: iconst_2
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc_w 295
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload 4
    //   102: aastore
    //   103: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload 4
    //   109: invokespecial 297	azcb:a	(Lazcd;)V
    //   112: iload_3
    //   113: ifeq +9 -> 122
    //   116: aload_0
    //   117: lload_1
    //   118: iconst_0
    //   119: invokevirtual 300	azcb:a	(JZ)V
    //   122: aconst_null
    //   123: astore 4
    //   125: goto -51 -> 74
    //   128: astore 4
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 4
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	azcb
    //   0	135	1	paramLong	long
    //   0	135	3	paramBoolean	boolean
    //   0	135	4	paramazcd	azcd
    // Exception table:
    //   from	to	target	type
    //   2	61	128	finally
    //   61	74	128	finally
    //   79	106	128	finally
    //   106	112	128	finally
    //   116	122	128	finally
  }
  
  public List<Integer> a()
  {
    try
    {
      localObject1 = a(this.jdField_a_of_type_JavaUtilList);
      if (((Boolean)((Pair)localObject1).first).booleanValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionManager", 2, "getSmartSelectedList isDataChange");
        }
        b((List)((Pair)localObject1).second);
      }
      localObject1 = (List)((Pair)localObject1).second;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusPermissionManager", 2, "getSmartSelectedList is error:", localThrowable);
        }
        ArrayList localArrayList = new ArrayList();
      }
    }
    finally {}
    return localObject1;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    azcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramBoolean, false);
  }
  
  public void a(@NonNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " saveOnlineStatusPermission item=", paramOnlineStatusFriendsPermissionItem });
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem = paramOnlineStatusFriendsPermissionItem;
      b(paramOnlineStatusFriendsPermissionItem);
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(SharePreferenceUtils.get(BaseApplication.getContext(), "smart_selected_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
  }
  
  public boolean a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, azcd paramazcd)
  {
    if (paramOnlineStatusPermissionItem == null) {}
    do
    {
      do
      {
        return false;
        paramazcd = a(40001L, false, paramazcd);
        if (paramazcd != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity is null");
      return false;
      if (paramazcd.allHasPermission != paramOnlineStatusPermissionItem.isAllHasPermission())
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.allHasPermission=", Boolean.valueOf(paramazcd.allHasPermission), " item.isAllHasPermission=", paramOnlineStatusPermissionItem.getPermissionUins() });
        }
        return true;
      }
      if (paramazcd.permissionUins.size() != paramOnlineStatusPermissionItem.getPermissionUins().size())
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(paramazcd.permissionUins.size()), " item.size=", Integer.valueOf(paramOnlineStatusPermissionItem.getPermissionUins().size()) });
        }
        return true;
      }
    } while (paramazcd.permissionUins.containsAll(paramOnlineStatusPermissionItem.getPermissionUins()));
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity not contains item all");
    }
    return true;
  }
  
  public boolean a(ArrayList<azbu> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    List localList = a();
    if (localList.size() != paramArrayList.size()) {
      return true;
    }
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        azbu localazbu = (azbu)paramArrayList.next();
        Iterator localIterator = localList.iterator();
        Integer localInteger;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localInteger = (Integer)localIterator.next();
        } while (localazbu.a != localInteger.intValue());
      }
      for (int i = 1; i == 0; i = 0)
      {
        return true;
        return false;
      }
    }
  }
  
  public boolean a(List<Integer> paramList)
  {
    boolean bool;
    if (paramList == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = b((List)a(paramList).second);
      }
      finally {}
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem = null;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azce);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcb
 * JD-Core Version:    0.7.0.1
 */