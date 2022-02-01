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

public class axfw
  extends Observable
  implements Manager
{
  protected LruCache<String, String> a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<Long, TroopAppInfo> a;
  public boolean a;
  protected ConcurrentHashMap<String, ArrayList<Long>> b;
  private boolean b;
  protected ConcurrentHashMap<Long, bfrm> c;
  private boolean c;
  protected ConcurrentHashMap<String, bfoy> d;
  
  /* Error */
  public axfw(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 26	java/util/concurrent/ConcurrentHashMap
    //   8: dup
    //   9: invokespecial 27	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   12: putfield 29	axfw:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 31	axfw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: aload_0
    //   21: getfield 33	axfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: ifnonnull +25 -> 49
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 33	axfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ifnonnull +14 -> 47
    //   36: aload_0
    //   37: new 26	java/util/concurrent/ConcurrentHashMap
    //   40: dup
    //   41: invokespecial 27	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   44: putfield 33	axfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 35	axfw:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: ifnonnull +25 -> 78
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 35	axfw:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnonnull +14 -> 76
    //   65: aload_0
    //   66: new 26	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: invokespecial 27	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   73: putfield 35	axfw:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 37	axfw:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   82: ifnonnull +27 -> 109
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 37	axfw:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   91: ifnonnull +16 -> 107
    //   94: aload_0
    //   95: new 39	android/support/v4/util/LruCache
    //   98: dup
    //   99: bipush 10
    //   101: invokespecial 42	android/support/v4/util/LruCache:<init>	(I)V
    //   104: putfield 37	axfw:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	axfw
    //   0	125	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   29	47	110	finally
    //   47	49	110	finally
    //   111	113	110	finally
    //   58	76	115	finally
    //   76	78	115	finally
    //   116	118	115	finally
    //   87	107	120	finally
    //   107	109	120	finally
    //   121	123	120	finally
  }
  
  public bfoy a(String paramString)
  {
    return (bfoy)this.d.get(paramString);
  }
  
  public bfoy a(String paramString, bfoy parambfoy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + parambfoy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramString) + " " + parambfoy.a() + " " + parambfoy.a());
    }
    bfoy localbfoy2 = (bfoy)this.d.get(paramString);
    bfoy localbfoy1 = localbfoy2;
    if (parambfoy != null)
    {
      if (parambfoy.a()) {
        break label105;
      }
      localbfoy1 = localbfoy2;
    }
    label105:
    do
    {
      do
      {
        return localbfoy1;
        if (localbfoy2 != null) {
          break;
        }
        parambfoy = new bfoy(parambfoy);
        this.d.put(paramString, parambfoy);
        localbfoy1 = parambfoy;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return parambfoy;
      localbfoy2.a(parambfoy);
      localbfoy1 = localbfoy2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localbfoy2;
  }
  
  public bfrm a(Long paramLong, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    bfrm localbfrm2 = (bfrm)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    bfrm localbfrm1 = localbfrm2;
    if (localbfrm2 == null)
    {
      localbfrm1 = localbfrm2;
      if (paramBoolean)
      {
        localbfrm1 = new bfrm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, localbfrm1);
      }
    }
    return localbfrm1;
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
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
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
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, bhkv.encodeToString(paramArrayOfByte, 2));
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
      paramString = bhkv.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public bfoy b(String paramString)
  {
    return (bfoy)this.d.remove(paramString);
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
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        bfrm localbfrm = (bfrm)localIterator.next();
        if (localbfrm != null) {
          localbfrm.deleteObservers();
        }
      }
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfw
 * JD-Core Version:    0.7.0.1
 */