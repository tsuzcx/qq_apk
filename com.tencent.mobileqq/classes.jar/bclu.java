import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.2;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.3;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.4;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.5;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.AppClick;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.ReqBody;

public class bclu
  implements Manager
{
  protected final int a;
  amdu jdField_a_of_type_Amdu;
  @NonNull
  SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(10);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString;
  ThreadLocal<SimpleDateFormat> jdField_a_of_type_JavaLangThreadLocal = new bclv(this);
  protected Map<String, JSONObject> a;
  protected boolean a;
  protected final int b;
  protected SparseArray<bclr> b;
  String b;
  protected String c;
  
  public bclu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amdu = ((amdu)paramQQAppInterface.a(20));
    a();
    paramQQAppInterface = new int[2];
    QQAppInterface tmp99_98 = paramQQAppInterface;
    tmp99_98[0] = 0;
    QQAppInterface tmp103_99 = tmp99_98;
    tmp103_99[1] = 32;
    tmp103_99;
    int j = paramQQAppInterface.length;
    int i = 0;
    while (i < j)
    {
      int k = paramQQAppInterface[i];
      bclr localbclr = new bclr();
      localbclr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("appinfo_date_" + k, "");
      localbclr.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("KEY_APP_LIST_TIME_STAMP_" + k, 0);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(k, localbclr);
      i += 1;
    }
    f();
    d();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("appid_click_date", null);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("appinfo_all_app_string", alud.a(2131715582));
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("appid_click_num", null);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          int j = localJSONObject.optInt("appId");
          int k = localJSONObject.optInt("num");
          this.jdField_a_of_type_AndroidUtilSparseArray.put(j, Integer.valueOf(k));
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.jdField_a_of_type_JavaLangString = ((SimpleDateFormat)this.jdField_a_of_type_JavaLangThreadLocal.get()).format(localCalendar.getTime());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("appid_click_date", this.jdField_a_of_type_JavaLangString).commit();
  }
  
  private void f()
  {
    if (AppSetting.a("6.0") < 0) {
      return;
    }
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = localawgf.a(TroopAIOAppInfo.class);
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      localObject1 = ((List)localObject1).listIterator();
      if (((ListIterator)localObject1).hasNext())
      {
        localObject3 = (TroopAIOAppInfo)((ListIterator)localObject1).next();
        bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(((TroopAIOAppInfo)localObject3).groupType);
        xqq.a(localbclr);
        localbclr.a(((TroopAIOAppInfo)localObject3).appid, (TroopAIOAppInfo)localObject3);
      }
    }
    localawgf.a();
  }
  
  public int a(int paramInt)
  {
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr != null) {
        break;
      }
      return 0;
    }
    return localbclr.jdField_b_of_type_Int;
  }
  
  public TroopAIOAppInfo a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt2, null);
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localObject1 != null) {
        break;
      }
      return null;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject1 = (TroopAIOAppInfo)((bclr)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (localObject1 != null)
        {
          localObject1 = new TroopAIOAppInfo((TroopAIOAppInfo)localObject1);
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<TroopAIOAppInfo> a(boolean paramBoolean, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 32)) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (AppSetting.a("6.0") >= 0) {
        break;
      }
      return Collections.emptyList();
    }
    if (paramBoolean)
    {
      paramBoolean = b(paramInt);
      this.jdField_a_of_type_Amdu.a(1, paramInt, null, paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      xqq.a(localObject2);
      localObject2 = ((bclr)localObject2).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject2).next();
        if (localTroopAIOAppInfo.isValidTroopApp()) {
          localArrayList.add(localTroopAIOAppInfo);
        }
      }
    }
    return localList;
  }
  
  public JSONObject a(String paramString)
  {
    xqq.a(paramString);
    if (paramString == null) {
      return null;
    }
    return (JSONObject)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    bclx[] arrayOfbclx = bclx.jdField_a_of_type_ArrayOfBclx;
    int j = arrayOfbclx.length;
    int i = 0;
    while (i < j)
    {
      bclx localbclx = arrayOfbclx[i];
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("KEY_APP_CONFIG_PREFIX-" + localbclx.jdField_a_of_type_JavaLangString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = localbclx.a((String)localObject);
        this.jdField_a_of_type_JavaUtilMap.put(localbclx.jdField_a_of_type_JavaLangString, localObject);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = Calendar.getInstance();
    localObject = ((SimpleDateFormat)this.jdField_a_of_type_JavaLangThreadLocal.get()).format(((Calendar)localObject).getTime());
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt, null);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr != null) {
        localbclr.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("appinfo_date_" + paramInt, (String)localObject).commit();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt2);
    boolean bool;
    if (localbclr != null)
    {
      bool = true;
      xqq.a(bool);
      if (localbclr != null) {
        break label35;
      }
    }
    label35:
    do
    {
      return;
      bool = false;
      break;
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localbclr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
      if (localTroopAIOAppInfo != null)
      {
        xqq.a(localbclr.a(localTroopAIOAppInfo));
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " removed" });
        }
        ThreadManager.post(new TroopAppMgr.4(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), localTroopAIOAppInfo), 8, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " remove fail, not contains app" });
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        int i = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, Integer.valueOf(0))).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Integer.valueOf(i + 1));
        b();
        ??? = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("add_page").d("Clk_app").a(new String[] { paramString }).a(new String[] { String.valueOf(paramInt) });
        if (paramBoolean)
        {
          paramString = "0";
          ((azqx)???).a(new String[] { paramString }).a();
          return;
        }
      }
      paramString = "1";
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    this.jdField_b_of_type_JavaLangString = paramString;
    localEditor.putString("appinfo_all_app_string", paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, List<TroopAIOAppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, paramString2 + " end");
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          QLog.d(paramString1, 2, ((TroopAIOAppInfo)paramList.next()).toString());
        }
      }
      QLog.d(paramString1, 2, "arg is null");
      QLog.d(paramString1, 2, paramString2 + " end");
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    xqq.a(paramString);
    xqq.a(paramJSONObject);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str, paramJSONObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("KEY_APP_CONFIG_PREFIX-" + str, paramJSONObject.toString()).apply();
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(0, null);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr == null) {
        break;
      }
      Iterator localIterator = paramArrayList.iterator();
      Integer localInteger;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localInteger = (Integer)localIterator.next();
      } while (localbclr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localInteger));
      QLog.w(".troop.troop_app", 1, "TroopAppMgr:sortTroopAppList error, there is no appid in hashtable");
      return;
    }
    this.jdField_a_of_type_Amdu.a(a(0), paramArrayList);
  }
  
  public void a(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr == null) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = paramArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label104;
        }
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        localbclr.a(localTroopAIOAppInfo.appid, localTroopAIOAppInfo);
      }
    }
    label104:
    ThreadManager.post(new TroopAppMgr.2(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), paramInt, paramArrayList), 8, null, false);
  }
  
  public void a(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {}
    do
    {
      return;
      if (paramArrayList1.containsAll(paramArrayList2))
      {
        this.jdField_a_of_type_Amdu.a(a(0), paramArrayList1, paramArrayList2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppMgr.addTroopApp.troop.troop_app", 2, "appids to add are not contained in Appids list!");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bclx[] arrayOfbclx = bclx.jdField_a_of_type_ArrayOfBclx;
    int j = arrayOfbclx.length;
    int i = 0;
    while (i < j)
    {
      bclx localbclx = arrayOfbclx[i];
      JSONObject localJSONObject = localbclx.a(paramJSONObject.optJSONObject(localbclx.jdField_a_of_type_JavaLangString));
      if (localJSONObject != null) {
        a(localbclx.jdField_a_of_type_JavaLangString, localJSONObject);
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(0, null);
        if (localbclr != null) {
          bool = true;
        }
        xqq.a(bool);
        if (localbclr == null) {
          return;
        }
        if (paramBoolean) {
          localbclr.jdField_a_of_type_Int |= 0x2;
        } else {
          localObject.jdField_a_of_type_Int &= 0xFFFFFFFD;
        }
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt, null);
        boolean bool;
        if (localbclr != null)
        {
          bool = true;
          xqq.a(bool);
          if (localbclr != null) {}
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramBoolean) {
          localbclr.jdField_a_of_type_Int |= 0x1;
        } else {
          localObject.jdField_a_of_type_Int &= 0xFFFFFFFE;
        }
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.c = paramString;
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	bclu:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   8: iload_1
    //   9: aconst_null
    //   10: invokevirtual 283	android/util/SparseArray:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 71	bclr
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +20 -> 40
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 279	xqq:a	(Z)V
    //   29: aload 4
    //   31: ifnonnull +14 -> 45
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -17 -> 25
    //   45: aload 4
    //   47: getfield 478	bclr:jdField_a_of_type_Int	I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_1
    //   53: iand
    //   54: ifeq +8 -> 62
    //   57: iconst_1
    //   58: istore_2
    //   59: goto -23 -> 36
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -5 -> 59
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bclu
    //   0	74	1	paramInt	int
    //   24	40	2	bool1	boolean
    //   1	34	3	bool2	boolean
    //   16	30	4	localbclr	bclr
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	67	finally
    //   25	29	67	finally
    //   45	51	67	finally
  }
  
  public boolean a(awgf paramawgf, awge paramawge)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramawgf.a())
    {
      if (paramawge.getStatus() != 1000) {
        break label45;
      }
      paramawgf.b(paramawge);
      bool1 = bool2;
      if (paramawge.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label45:
    do
    {
      return bool1;
      if (paramawge.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramawge.getStatus() != 1002);
    return paramawgf.a(paramawge);
  }
  
  public boolean a(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    boolean bool2 = false;
    int i = paramTroopAIOAppInfo.appid;
    Object localObject = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramTroopAIOAppInfo.groupType);
    boolean bool1;
    if (localObject != null)
    {
      bool1 = true;
      xqq.a(bool1);
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    do
    {
      return true;
      bool1 = false;
      break;
      localObject = (TroopAIOAppInfo)((bclr)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    } while (localObject == null);
    xqq.a(paramTroopAIOAppInfo.hashVal);
    xqq.a(((TroopAIOAppInfo)localObject).hashVal);
    if ((TextUtils.equals(paramTroopAIOAppInfo.hashVal, ((TroopAIOAppInfo)localObject).hashVal)) && (((TroopAIOAppInfo)localObject).isValidTroopApp()) && (paramTroopAIOAppInfo.identifyMask == ((TroopAIOAppInfo)localObject).identifyMask))
    {
      bool1 = bool2;
      if (paramTroopAIOAppInfo.redPoint == ((TroopAIOAppInfo)localObject).redPoint) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(this.c)) && (this.c.equals(paramString)))
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(List<Integer> paramList, int paramInt)
  {
    boolean bool2 = true;
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt, null);
    if (paramList != null)
    {
      bool1 = true;
      xqq.a(bool1);
      if (localbclr == null) {
        break label54;
      }
    }
    label54:
    for (boolean bool1 = true;; bool1 = false)
    {
      xqq.a(bool1);
      if ((localbclr != null) && (paramList != null)) {
        break label59;
      }
      return false;
      bool1 = false;
      break;
    }
    label59:
    new ArrayList();
    Object localObject;
    if (paramList.size() != localbclr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size())
    {
      bool1 = bool2;
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (bool1) {
        break label175;
      }
    }
    label175:
    for (;;)
    {
      try
      {
        bool2 = localbclr.a(paramList);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d(".troop.troop_app", 2, "makeAppidsInOrder() app order changed!");
            bool1 = bool2;
          }
        }
        if (bool1)
        {
          localbclr.a(paramList, paramInt);
          b(localbclr.a(), paramInt);
        }
        return bool1;
      }
      finally {}
      bool1 = false;
      break;
    }
  }
  
  protected void b()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        int k = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).intValue();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appId", j);
          localJSONObject.put("num", k);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(".troop.troop_app", 2, "saveAppIdNums exception");
            }
          }
        }
      }
    }
    if ((localJSONArray.length() != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("appid_click_num", localJSONArray.toString()).commit();
    }
  }
  
  public void b(int paramInt)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[2];
    int[] tmp28_26 = arrayOfInt;
    tmp28_26[0] = 0;
    int[] tmp32_28 = tmp28_26;
    tmp32_28[1] = 32;
    tmp32_28;
    if (localawgf != null) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int j = arrayOfInt.length;
        i = 0;
        bool = false;
        if (i < j)
        {
          int k = arrayOfInt[i];
          Object localObject3 = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(k);
          xqq.a(localObject3);
          localObject3 = (TroopAIOAppInfo)((bclr)localObject3).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          if (localObject3 != null)
          {
            localArrayList.add(localObject3);
            ((TroopAIOAppInfo)localObject3).redPoint = false;
            bool = true;
            break label223;
          }
        }
        else
        {
          if (bool) {
            ThreadManager.post(new TroopAppMgr.5(this, localArrayList, localawgf), 8, null, false);
          }
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "appid" + paramInt + "clearLocalTroopAppRedPoint," + bool);
          }
          return;
        }
      }
      break label223;
      boolean bool = false;
      continue;
      label223:
      i += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr != null) {
        break;
      }
      return;
    }
    localbclr.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("KEY_APP_LIST_TIME_STAMP_" + paramInt2, paramInt1).commit();
  }
  
  public void b(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    ThreadManager.post(new TroopAppMgr.3(this, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), paramInt), 8, null, false);
  }
  
  /* Error */
  public boolean b(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	bclu:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   8: iload_1
    //   9: aconst_null
    //   10: invokevirtual 283	android/util/SparseArray:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 71	bclr
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +20 -> 40
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 279	xqq:a	(Z)V
    //   29: aload 4
    //   31: ifnonnull +14 -> 45
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -17 -> 25
    //   45: aload 4
    //   47: getfield 478	bclr:jdField_a_of_type_Int	I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_2
    //   53: iand
    //   54: ifeq +8 -> 62
    //   57: iconst_1
    //   58: istore_2
    //   59: goto -23 -> 36
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -5 -> 59
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bclu
    //   0	74	1	paramInt	int
    //   24	40	2	bool1	boolean
    //   1	34	3	bool2	boolean
    //   16	30	4	localbclr	bclr
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	67	finally
    //   25	29	67	finally
    //   45	51	67	finally
  }
  
  public boolean b(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int i = paramTroopAIOAppInfo.appid;
    bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramTroopAIOAppInfo.groupType);
    if (localbclr != null) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (localbclr != null) {
        break;
      }
      return false;
    }
    if ((TroopAIOAppInfo)localbclr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i)) != null) {
      return true;
    }
    localbclr.a(paramTroopAIOAppInfo.appid, paramTroopAIOAppInfo);
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      QLog.d(".troop.troop_app", 2, "clickReport appidNums size == 0");
    }
    do
    {
      return;
      localObject1 = Calendar.getInstance();
    } while (((SimpleDateFormat)this.jdField_a_of_type_JavaLangThreadLocal.get()).format(((Calendar)localObject1).getTime()).equals(this.jdField_a_of_type_JavaLangString));
    oidb_0xa1e.ReqBody localReqBody = new oidb_0xa1e.ReqBody();
    localReqBody.platform.set(2);
    localReqBody.position.set(1);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        int k = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).intValue();
        oidb_0xa1e.AppClick localAppClick = new oidb_0xa1e.AppClick();
        localAppClick.appid.set(j);
        localAppClick.click_num.set(k);
        localArrayList.add(localAppClick);
        i += 1;
      }
      localReqBody.rpt_app_click.set(localArrayList);
      mzy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bclw(this), localReqBody.toByteArray(), "OidbSvc.0xa1e", 2590, 0);
      return;
    }
    finally {}
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (a(paramInt1, paramInt2) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_Amdu.a(localArrayList, 0);
  }
  
  public void onDestroy()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 32;
    tmp11_7;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        a(false, k);
        bclr localbclr = (bclr)this.jdField_b_of_type_AndroidUtilSparseArray.get(k);
        xqq.a(localbclr);
        localbclr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        localbclr.a();
        localbclr.jdField_b_of_type_Int = 0;
        i += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclu
 * JD-Core Version:    0.7.0.1
 */