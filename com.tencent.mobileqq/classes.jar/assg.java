import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.multicard.MultiCardManager.1;
import com.tencent.mobileqq.multicard.MultiCardManager.2;
import com.tencent.mobileqq.multicard.MultiCardManager.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class assg
  implements Manager
{
  private long jdField_a_of_type_Long;
  private LruCache<Long, IntimateInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(200);
  private aqkh jdField_a_of_type_Aqkh;
  private assk jdField_a_of_type_Assk;
  private assl jdField_a_of_type_Assl;
  private assm jdField_a_of_type_Assm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, WeakReference<assj>> jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private boolean jdField_a_of_type_Boolean = true;
  private HashMap<Long, WeakReference<assh>> b = new HashMap(20);
  private HashMap<Long, Boolean> c = new HashMap(200);
  private HashMap<Long, WeakReference<assi>> d = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> e = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> f = new HashMap(5);
  
  public assg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqkh = ((aqkh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323));
  }
  
  /* Error */
  private ArrayList<Long> a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	assg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 82
    //   9: iconst_0
    //   10: invokevirtual 88	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: new 90	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: getfield 58	assg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   27: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 100
    //   32: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_1
    //   36: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: ldc 108
    //   44: invokeinterface 114 3 0
    //   49: astore 5
    //   51: aload 5
    //   53: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +125 -> 181
    //   59: new 122	org/json/JSONArray
    //   62: dup
    //   63: aload 5
    //   65: invokespecial 125	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   68: astore 7
    //   70: new 127	java/util/ArrayList
    //   73: dup
    //   74: aload 7
    //   76: invokevirtual 131	org/json/JSONArray:length	()I
    //   79: invokespecial 132	java/util/ArrayList:<init>	(I)V
    //   82: astore 5
    //   84: aload 7
    //   86: invokevirtual 131	org/json/JSONArray:length	()I
    //   89: istore 4
    //   91: iconst_0
    //   92: istore_3
    //   93: aload 5
    //   95: astore 6
    //   97: iload_3
    //   98: iload 4
    //   100: if_icmpge +73 -> 173
    //   103: aload 5
    //   105: aload 7
    //   107: iload_3
    //   108: invokevirtual 136	org/json/JSONArray:optLong	(I)J
    //   111: invokestatic 142	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokevirtual 146	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_3
    //   119: iconst_1
    //   120: iadd
    //   121: istore_3
    //   122: goto -29 -> 93
    //   125: astore 7
    //   127: aconst_null
    //   128: astore 5
    //   130: aload 5
    //   132: astore 6
    //   134: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +36 -> 173
    //   140: ldc 154
    //   142: iconst_2
    //   143: new 90	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   150: ldc 156
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 7
    //   157: invokevirtual 157	org/json/JSONException:toString	()Ljava/lang/String;
    //   160: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload 5
    //   171: astore 6
    //   173: aload 6
    //   175: areturn
    //   176: astore 7
    //   178: goto -48 -> 130
    //   181: aconst_null
    //   182: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	assg
    //   0	183	1	paramLong	long
    //   92	30	3	i	int
    //   89	12	4	j	int
    //   49	121	5	localObject1	Object
    //   95	79	6	localObject2	Object
    //   68	38	7	localJSONArray	JSONArray
    //   125	31	7	localJSONException1	org.json.JSONException
    //   176	1	7	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   59	84	125	org/json/JSONException
    //   84	91	176	org/json/JSONException
    //   103	118	176	org/json/JSONException
  }
  
  private void a(long paramLong, assj paramassj)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.3(this, paramLong, paramassj));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, assh paramassh)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.2(this, paramLong, paramArrayList, paramassh));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, assi paramassi)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.1(this, paramArrayList, paramLong, paramassi));
  }
  
  public IntimateInfo a(long paramLong1, long paramLong2)
  {
    IntimateInfo localIntimateInfo2 = (IntimateInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(Long.valueOf(paramLong2));
    IntimateInfo localIntimateInfo1 = localIntimateInfo2;
    if (localIntimateInfo2 == null)
    {
      String str = IntimateInfo.convertUinKeyForGroupCard(paramLong1 + "", paramLong2 + "");
      localIntimateInfo2 = this.jdField_a_of_type_Aqkh.a(str);
      localIntimateInfo1 = localIntimateInfo2;
      if (localIntimateInfo2 != null)
      {
        localIntimateInfo2.friendUin = IntimateInfo.getUinFromGroupCardKey(str);
        localIntimateInfo1 = localIntimateInfo2;
      }
    }
    return localIntimateInfo1;
  }
  
  public HashMap<Long, IntimateInfo> a(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getIntimateInfoListCache, uinList: ");
      if (paramArrayList == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject1 = paramArrayList.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1 + " " + paramLong);
      if (paramArrayList == null) {
        break label140;
      }
      localObject1 = new HashMap(paramArrayList.size() * 2);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Long)paramArrayList.next();
        IntimateInfo localIntimateInfo = a(paramLong, ((Long)localObject2).longValue());
        if (localIntimateInfo != null) {
          ((HashMap)localObject1).put(localObject2, localIntimateInfo);
        }
      }
    }
    return localObject1;
    label140:
    return null;
  }
  
  public void a()
  {
    try
    {
      b(this.jdField_a_of_type_Long);
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "enter " + paramLong);
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Assk == null) {
      this.jdField_a_of_type_Assk = new assk(this, null);
    }
    if (this.jdField_a_of_type_Assl == null) {
      this.jdField_a_of_type_Assl = new assl(this, null);
    }
    if (this.jdField_a_of_type_Assm == null) {
      this.jdField_a_of_type_Assm = new assm(this, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Assk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Assl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Assm);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("group_intimate_recommend_uin_list", 0);
    if (paramArrayList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      ((SharedPreferences)localObject).edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_" + paramLong, localJSONArray.toString()).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("updateGroupRecommendUinListDiskCache, uin: ").append(paramLong).append(" ");
        if (paramArrayList == null) {
          break label220;
        }
      }
    }
    label220:
    for (paramArrayList = paramArrayList.toString();; paramArrayList = "null")
    {
      QLog.d("intimate_relationship", 2, paramArrayList);
      return;
      ((SharedPreferences)localObject).edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_" + paramLong).commit();
      break;
    }
  }
  
  public void a(Context arg1, long paramLong, assj paramassj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, String.format("getGroupRecommendUinLists, uin: %d", new Object[] { Long.valueOf(paramLong) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramassj != null))
    {
      if (!bbev.d(???)) {
        a(paramLong, paramassj);
      }
    }
    else {
      return;
    }
    synchronized (this.f)
    {
      ArrayList localArrayList = (ArrayList)this.f.get(Long.valueOf(paramLong));
      if (localArrayList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardManager", 2, "getGroupRecommendUinLists return cache " + paramLong);
        }
        paramassj.a(paramLong, localArrayList);
        return;
      }
    }
    paramassj = new WeakReference(paramassj);
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramassj);
      ((aqkf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153)).a(paramLong, 10000L);
      return;
    }
  }
  
  public void a(Context paramContext, long paramLong, ArrayList<Long> arg4, assh paramassh)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder().append("getGroupIntimateInfoList, uinList: ").append(paramLong).append(" ");
      if (??? == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject1 = ???.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramassh != null) && (??? != null))
      {
        if (bbev.d(paramContext)) {
          break;
        }
        a(paramLong, ???, paramassh);
      }
      return;
    }
    localObject1 = new ArrayList(???.size());
    paramContext = new ArrayList(???.size());
    Iterator localIterator = ???.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((IntimateInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(localLong) != null) {
        ((ArrayList)localObject1).add(localLong);
      } else {
        for (;;)
        {
          synchronized (this.c)
          {
            if (!this.c.containsKey(localLong))
            {
              paramContext.add(localLong);
              this.c.put(localLong, Boolean.TRUE);
            }
          }
          ((ArrayList)localObject1).add(localLong);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, "getGroupIntimateInfoList  alreadyRequest: " + ((ArrayList)localObject1).toString() + " notRequest:" + paramContext.toString());
    }
    if (paramContext.isEmpty())
    {
      a(paramLong, ???, paramassh);
      return;
    }
    a(paramLong, ???, paramassh);
    paramassh = new WeakReference(paramassh);
    synchronized (this.b)
    {
      this.b.put(Long.valueOf(paramLong), paramassh);
      ??? = new HashMap(5);
      ???.put("alreadyRequest", localObject1);
      ???.put("notRequest", paramContext);
      paramassh = new ArrayList(1);
      paramassh.add(Long.valueOf(paramLong));
      ???.put("groupUin", paramassh);
      ((aqkf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(153)).a(paramLong, paramContext, ???);
      return;
    }
  }
  
  public void a(Context arg1, long paramLong, ArrayList<Long> paramArrayList, assi paramassi)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getGroupMemberNick, uinList: ").append(paramLong).append(" ");
      if (paramArrayList == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject1 = paramArrayList.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramassi != null) && (paramArrayList != null))
      {
        if (bbev.d(???)) {
          break;
        }
        a(paramLong, paramArrayList, paramassi);
      }
      return;
    }
    synchronized (this.e)
    {
      if (!this.e.containsKey(Long.valueOf(paramLong))) {
        break label317;
      }
      localObject1 = (ArrayList)this.e.get(Long.valueOf(paramLong));
      if (localObject1 == null) {
        break label350;
      }
      localObject1 = (ArrayList)((ArrayList)localObject1).clone();
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        if (!((ArrayList)localObject1).contains(localLong)) {
          ((ArrayList)localObject1).add(localLong);
        }
      }
    }
    this.e.put(Long.valueOf(paramLong), localObject1);
    for (;;)
    {
      a(paramLong, paramArrayList, paramassi);
      if (i != 0) {
        break;
      }
      paramArrayList = new WeakReference(paramassi);
      synchronized (this.d)
      {
        this.d.put(Long.valueOf(paramLong), paramArrayList);
        ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(false, paramLong + "", "0", 9);
        return;
        label317:
        this.e.put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
        i = 0;
      }
      label350:
      int i = 1;
    }
  }
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo != null) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "saveGroupCardIntimateInfo " + paramString + " " + paramIntimateInfo.toString());
      }
    }
    try
    {
      long l = Long.parseLong(paramIntimateInfo.friendUin);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidUtilLruCache.put(Long.valueOf(l), paramIntimateInfo);
      }
      paramString = IntimateInfo.convertUinKeyForGroupCard(paramString, paramIntimateInfo.friendUin);
      paramIntimateInfo.friendUin = paramString;
      paramIntimateInfo.lastAnimAfterFriendDays = paramIntimateInfo.beFriendDays;
      paramIntimateInfo.lastAnimAfterScore = paramIntimateInfo.currentScore;
      this.jdField_a_of_type_Aqkh.a(paramString, paramIntimateInfo);
      paramIntimateInfo.friendUin = (l + "");
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("intimate_relationship", 2, "saveGroupCardIntimateInfo " + paramString.toString());
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "exit " + paramLong);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Assk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Assk);
      this.jdField_a_of_type_Assk = null;
    }
    if (this.jdField_a_of_type_Assl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Assl);
      this.jdField_a_of_type_Assl = null;
    }
    if (this.jdField_a_of_type_Assm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Assm);
      this.jdField_a_of_type_Assm = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.b != null) {}
      synchronized (this.b)
      {
        this.b.clear();
        if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
          this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
        }
        if (this.f != null) {}
        synchronized (this.f)
        {
          this.f.clear();
          if (this.d != null) {}
          synchronized (this.d)
          {
            this.d.clear();
            if (this.e != null) {}
            synchronized (this.e)
            {
              this.e.clear();
              if (this.c == null) {}
            }
          }
        }
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
      localObject5 = finally;
      throw localObject5;
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assg
 * JD-Core Version:    0.7.0.1
 */