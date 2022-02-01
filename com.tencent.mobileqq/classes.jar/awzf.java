import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class awzf
  extends Observable
  implements Manager
{
  protected LruCache<String, String> a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<Long, TroopAppInfo> a;
  public boolean a;
  protected ConcurrentHashMap<String, ArrayList<Long>> b;
  private boolean b;
  protected ConcurrentHashMap<String, bact> c;
  private boolean c;
  protected ConcurrentHashMap<Long, bfhz> d;
  protected ConcurrentHashMap<String, bffl> e;
  
  /* Error */
  public awzf(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 28	java/util/concurrent/ConcurrentHashMap
    //   8: dup
    //   9: invokespecial 29	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   12: putfield 31	awzf:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 33	awzf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: aload_0
    //   21: getfield 35	awzf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: ifnonnull +25 -> 49
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 35	awzf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ifnonnull +14 -> 47
    //   36: aload_0
    //   37: new 28	java/util/concurrent/ConcurrentHashMap
    //   40: dup
    //   41: invokespecial 29	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   44: putfield 35	awzf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 37	awzf:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: ifnonnull +25 -> 78
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 37	awzf:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnonnull +14 -> 76
    //   65: aload_0
    //   66: new 28	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: invokespecial 29	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   73: putfield 37	awzf:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 39	awzf:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   82: ifnonnull +27 -> 109
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 39	awzf:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   91: ifnonnull +16 -> 107
    //   94: aload_0
    //   95: new 41	android/support/v4/util/LruCache
    //   98: dup
    //   99: bipush 10
    //   101: invokespecial 44	android/support/v4/util/LruCache:<init>	(I)V
    //   104: putfield 39	awzf:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 46	awzf:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: ifnonnull +25 -> 138
    //   116: aload_0
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 46	awzf:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: ifnonnull +14 -> 136
    //   125: aload_0
    //   126: new 28	java/util/concurrent/ConcurrentHashMap
    //   129: dup
    //   130: invokespecial 29	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   133: putfield 46	awzf:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   136: aload_0
    //   137: monitorexit
    //   138: invokestatic 50	arvq:a	()V
    //   141: return
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	awzf
    //   0	162	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   29	47	142	finally
    //   47	49	142	finally
    //   143	145	142	finally
    //   58	76	147	finally
    //   76	78	147	finally
    //   148	150	147	finally
    //   87	107	152	finally
    //   107	109	152	finally
    //   153	155	152	finally
    //   118	136	157	finally
    //   136	138	157	finally
    //   158	160	157	finally
  }
  
  public bact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (bact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bffl a(String paramString)
  {
    return (bffl)this.e.get(paramString);
  }
  
  public bffl a(String paramString, bffl parambffl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + parambffl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramString) + " " + parambffl.a() + " " + parambffl.a());
    }
    bffl localbffl2 = (bffl)this.e.get(paramString);
    bffl localbffl1 = localbffl2;
    if (parambffl != null)
    {
      if (parambffl.a()) {
        break label105;
      }
      localbffl1 = localbffl2;
    }
    label105:
    do
    {
      do
      {
        return localbffl1;
        if (localbffl2 != null) {
          break;
        }
        parambffl = new bffl(parambffl);
        this.e.put(paramString, parambffl);
        localbffl1 = parambffl;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return parambffl;
      localbffl2.a(parambffl);
      localbffl1 = localbffl2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localbffl2;
  }
  
  public bfhz a(Long paramLong, boolean paramBoolean)
  {
    if (this.d == null) {
      this.d = new ConcurrentHashMap();
    }
    bfhz localbfhz2 = (bfhz)this.d.get(paramLong);
    bfhz localbfhz1 = localbfhz2;
    if (localbfhz2 == null)
    {
      localbfhz1 = localbfhz2;
      if (paramBoolean)
      {
        localbfhz1 = new bfhz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.d.put(paramLong, localbfhz1);
      }
    }
    return localbfhz1;
  }
  
  public ArrayList<Long> a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList<TroopAppInfo> a(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.apply();
  }
  
  public void a(Long paramLong)
  {
    if (this.d == null) {
      return;
    }
    this.d.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString, bact parambact)
  {
    if ((parambact != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambact);
    }
  }
  
  public void a(String paramString, ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayList);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, bhcu.encodeToString(paramArrayOfByte, 2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public byte[] a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = bhcu.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public bffl b(String paramString)
  {
    return (bffl)this.e.remove(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        bfhz localbfhz = (bfhz)localIterator.next();
        if (localbfhz != null) {
          localbfhz.deleteObservers();
        }
      }
      this.d.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzf
 * JD-Core Version:    0.7.0.1
 */