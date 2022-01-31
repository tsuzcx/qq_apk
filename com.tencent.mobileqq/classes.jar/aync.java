import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import mqq.manager.Manager;

public class aync
  implements Manager
{
  private ajxj jdField_a_of_type_Ajxj = new aynf(this);
  private final akil jdField_a_of_type_Akil = new ayne(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<aynr> jdField_a_of_type_AndroidUtilSparseArray;
  private bial jdField_a_of_type_Bial = new aynd(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<aynj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, ayno> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, ayni> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, aynn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<aynl> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, aynk> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public aync(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    a(2, new aynq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new arke(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static aync a(QQAppInterface paramQQAppInterface)
  {
    return (aync)paramQQAppInterface.getManager(339);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, aynp.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, ayno> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaynr != null) {
        localaynr.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("banner_inter", 0L);
    amwi localamwi = (amwi)ampl.a().a(553);
    if (localamwi != null) {}
    for (long l1 = localamwi.jdField_a_of_type_Int;; l1 = 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "canRequestBanner cur:", Long.valueOf(l2), " last:", Long.valueOf(l3), " interval:", Long.valueOf(60000L * l1) });
      }
      if (l2 - l3 < l1 * 60000L) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void b(batf parambatf)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aynl)localIterator.next()).onUpdate(2, true, parambatf);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new arlh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new arkc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    aynr localaynr;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaynr != null) {
        break label64;
      }
    }
    label64:
    while (!a(j, paramInt, paramString))
    {
      i += 1;
      break label18;
      break;
    }
    return localaynr.a();
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = paramInt1 + "_" + paramInt2 + "_" + paramLong;
    localObject = (Long)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public ayni a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    ayni localayni = (ayni)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localayni;
    if (localayni == null)
    {
      paramString = new ayni();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public aynj a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aynj)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public aynk a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (aynk)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends aynn> T a(int paramInt)
  {
    aynn localaynn2 = (aynn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    aynn localaynn1 = localaynn2;
    if (localaynn2 == null) {
      localaynn1 = null;
    }
    return localaynn1;
  }
  
  public <T extends ayno> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (ayno)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public batf a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    batf localbatf = new batf();
    localbatf.jdField_a_of_type_JavaLangString = paramString;
    localbatf.b = Integer.valueOf(localObject[0]).intValue();
    localbatf.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
    return localbatf;
  }
  
  @Nullable
  public HashMap<String, ayno> a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
    }
    return new HashMap();
  }
  
  @Nullable
  public HashMap<String, ayno> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.contains(paramInt + "")) {
          localHashMap.put(str, this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  public void a()
  {
    ((aynm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((aynm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ayno paramayno)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramString, paramayno);
  }
  
  public void a(int paramInt, aynr paramaynr)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramaynr);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    int m = 0;
    int k;
    switch (paramInt)
    {
    default: 
      k = m;
    }
    while (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localaynr != null) {
        localaynr.a(paramContext, paramSessionInfo, paramInt);
      }
      k += 1;
      continue;
      if (paramSessionInfo.jdField_a_of_type_Int != 1)
      {
        k = m;
        if (paramSessionInfo.jdField_a_of_type_Int != 0) {
          break;
        }
      }
      else
      {
        int i;
        label108:
        int j;
        if (paramSessionInfo.jdField_a_of_type_Int == 1)
        {
          i = 1;
          j = 0;
        }
        for (;;)
        {
          k = m;
          if (j >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
            break;
          }
          k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j);
          boolean bool = a(k, i, paramSessionInfo.jdField_a_of_type_JavaLangString);
          QLog.d("TogetherControlManager", 1, "TogetherWatch  isOpen=" + bool + " service=" + k);
          if (bool)
          {
            a(k, i, paramSessionInfo.jdField_a_of_type_JavaLangString, 1000);
            k = m;
            break;
            i = 2;
            break label108;
          }
          j += 1;
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable Bundle paramBundle)
  {
    aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localaynr == null) {
      throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + paramInt2);
    }
    if (paramInt2 == 2)
    {
      if (paramInt3 != 0) {
        break label129;
      }
      a("video_tab", "clk_panelvideo", 0, paramString);
    }
    while (a(paramContext, paramInt2, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
      }
      return;
      label129:
      if (paramInt3 == 2) {
        a("video_tab", "clk_setvideo", 0, paramString);
      }
    }
    a(paramInt2, paramInt1, paramString);
    if (localaynr.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
    {
      ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localaynr.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(ajya.a(2131715003) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajya.a(2131715005));
    paramContext.setMessage(ajya.a(2131715014) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajya.a(2131715023));
    paramContext.setNegativeButton(ajya.a(2131715015), new ayng(this));
    paramContext.show();
  }
  
  public void a(aynk paramaynk)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
    }
    do
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(paramaynk.b), "data.isGetFakeData=", Boolean.valueOf(paramaynk.jdField_a_of_type_Boolean) });
          if (paramaynk.jdField_a_of_type_Boolean)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(paramaynk.f) });
            Iterator localIterator = paramaynk.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (paramaynk == null) {
          continue;
        }
      }
      catch (Exception paramaynk)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", paramaynk.getMessage() });
        }
        return;
      }
      if ((paramaynk.jdField_a_of_type_JavaUtilArrayList != null) && (paramaynk.jdField_a_of_type_JavaUtilArrayList.size() >= 4) && (paramaynk.f >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramaynk.b), paramaynk);
  }
  
  public void a(aynl paramaynl)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramaynl);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramaynl);
  }
  
  public void a(ayno paramayno, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramayno.d);
    if (localaynr != null) {
      localaynr.a(paramayno, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(batf parambatf)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(parambatf.jdField_a_of_type_JavaLangString, parambatf.b + "_" + parambatf.jdField_a_of_type_Int);
    localEditor.apply();
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    BaseActivity localBaseActivity;
    if (paramBaseActivity == null)
    {
      paramBaseActivity = BaseActivity.sTopActivity;
      localBaseActivity = paramBaseActivity;
      if (paramBaseActivity != null) {
        break label28;
      }
      QLog.d("TogetherControlManager", 1, "joinTogetherAndEnter return null activity");
    }
    label28:
    boolean bool;
    Object localObject;
    label567:
    label601:
    label764:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localBaseActivity = paramBaseActivity;
                  if (!bbfj.g(localBaseActivity))
                  {
                    bcql.a(localBaseActivity, 1, localBaseActivity.getString(2131694906), 0).a();
                    return;
                  }
                  if (paramInt1 == 1)
                  {
                    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localBaseActivity, paramInt2, paramString, paramLong);
                    return;
                  }
                  if (paramInt1 != 2) {
                    break label601;
                  }
                  if (paramInt2 != 2) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " sessionType is error" });
                return;
                a("video_tab", "clk_videoark", 0, paramString);
                bool = a(paramInt1, paramInt2, paramString);
                if (QLog.isColorLevel()) {
                  QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " isOpen=" + bool });
                }
                if (!bool)
                {
                  bcql.a(localBaseActivity, 1, 2131720858, 0).b(localBaseActivity.getTitleBarHeight());
                  return;
                }
                paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
              } while (paramBaseActivity == null);
              paramBaseActivity = aynp.a(true, paramBaseActivity.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
              localObject = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
              if ((localObject != null) && (((WatchTogetherSession)localObject).g != 3)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " session=", localObject });
            return;
            if (((WatchTogetherSession)localObject).d != paramLong)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " session.identifyId=" + ((WatchTogetherSession)localObject).d + " msg.identify=" + paramLong });
              }
              bcql.a(localBaseActivity, 1, 2131720858, 0).b(localBaseActivity.getTitleBarHeight());
              return;
            }
            switch (((WatchTogetherSession)localObject).i)
            {
            default: 
              if (!a(localBaseActivity, 2, paramString, 8)) {
                break label567;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
          return;
          bcql.a(localBaseActivity, 0, 2131693235, 0).a();
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, 8, paramBaseActivity);
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          aynp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((WatchTogetherSession)localObject).j, ((WatchTogetherSession)localObject).h, null, paramBaseActivity, 1);
          return;
        } while (paramInt1 != 4);
        if (paramInt2 == 1)
        {
          i = 1;
          if (i == 0) {
            break label726;
          }
          a("sing_tab", "clk_singark", 0, paramString);
        }
        for (;;)
        {
          bool = a(paramInt1, paramInt2, paramString);
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " isOpen=" + bool });
          }
          if (bool) {
            break label764;
          }
          bcql.a(localBaseActivity, 1, 2131719670, 0).b(localBaseActivity.getTitleBarHeight());
          return;
          i = 0;
          break;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
        }
        paramBaseActivity = (SingTogetherSession)a(paramInt1, paramInt2, paramString);
        if ((paramBaseActivity != null) && (paramBaseActivity.g != 3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " session=", paramBaseActivity });
      return;
      if (paramBaseActivity.d != paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " session.identifyId=" + paramBaseActivity.d + " msg.identify=" + paramLong });
        }
        bcql.a(localBaseActivity, 1, 2131719670, 0).b(localBaseActivity.getTitleBarHeight());
        return;
      }
      i = -1;
      paramBaseActivity = new Bundle();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramInt2 != 1) {
        break;
      }
      paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
    } while (paramBaseActivity == null);
    label726:
    paramBaseActivity = aynp.a(bool, paramBaseActivity.isTroopOwner((String)localObject), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
    int i = 8;
    paramInt1 = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
      return;
      if (paramInt2 == 2)
      {
        paramInt2 = 9;
        paramBaseActivity = aynp.a(bool, 9);
        paramInt1 = 2;
      }
      else
      {
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, batf parambatf)
  {
    a(parambatf);
    b(parambatf);
    a("video_tab", "exp_whitebar", 0, parambatf.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    bian localbian = new bian();
    localbian.d = paramInt;
    localbian.jdField_e_of_type_Int = 1;
    localbian.g = paramString2;
    localbian.b = (paramString1 + "_" + l);
    localbian.jdField_a_of_type_Int = 1;
    localbian.jdField_a_of_type_Long = l;
    localbian.jdField_e_of_type_JavaLangString = "tianshu.156";
    localbian.f = "tianshu.156";
    biam.a().a(localbian);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString3);
    if (localTroopInfo == null) {
      return;
    }
    int i = 2;
    if (localTroopInfo.isAdmin()) {
      i = 1;
    }
    if (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
      i = 0;
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "requestEntryBanner size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
      }
    }
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if ((!paramBoolean) || (a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherControlManager", 1, "fromAIO in time interval");
        return;
        ArrayList localArrayList = new ArrayList();
        biak localbiak = new biak();
        localbiak.jdField_a_of_type_Int = 236;
        localbiak.b = 1;
        localArrayList.add(localbiak);
        biam.a().a(localArrayList, this.jdField_a_of_type_Bial);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void a(boolean paramBoolean, ayno paramayno, int paramInt, String paramString)
  {
    ((aynm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(1, paramBoolean, new Object[] { paramayno, Integer.valueOf(paramInt), paramString });
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return false;
          return ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(331)).a(paramInt2, paramString);
        } while (paramInt2 != 1);
        paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
      } while ((paramString == null) || (!paramString.isWatchTogetherOpen()));
      return true;
    }
    return aynp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt2 < 3) {}
      for (paramInt2 = 1; ((ListenTogetherManager)localObject).a(paramInt2, paramString); paramInt2 = 2)
      {
        bcql.a(paramContext, 1, ajya.a(2131715020), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        bcql.a(paramContext, 1, ajya.a(2131715013), 0).a();
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (lkj.b(paramContext)))
    {
      bcql.a(paramContext, 1, ajya.a(2131715008), 1).a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q())
    {
      bcql.a(paramContext, 1, ajya.a(2131715009), 1).a();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m())
    {
      bcql.a(paramContext, 1, ajya.a(2131715027), 1).a();
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String[] arrayOfString;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        arrayOfString = ((String)localObject).split("_");
        if ((arrayOfString.length > 0) && (paramInt1 != Integer.parseInt(arrayOfString[0])))
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject) == null) {
            break label671;
          }
          if ((paramString.equals(arrayOfString[2])) && (3 != ((ayno)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g) && (((ayno)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g != 0)) {
            switch (Integer.parseInt(arrayOfString[0]))
            {
            default: 
              localObject = ajya.a(2131715018) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + ajya.a(2131715030);
            }
          }
        }
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bcql.a(paramContext, 1, (CharSequence)localObject, 0).a();
      return true;
      localObject = ajya.a(2131715025);
      continue;
      if ((paramString.equals(arrayOfString[2])) && (2 == ((ayno)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).h)) {}
      switch (Integer.parseInt(arrayOfString[0]))
      {
      default: 
        localObject = ajya.a(2131715011) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + ajya.a(2131715028);
        break;
      case 1: 
        localObject = ajya.a(2131715029);
        continue;
        if ((!paramString.equals(arrayOfString[2])) && (arkp.a(Integer.parseInt(arrayOfString[0]), arrayOfString[2], Integer.parseInt(arrayOfString[1])))) {}
        switch (Integer.parseInt(arrayOfString[0]))
        {
        default: 
          localObject = ajya.a(2131715011) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + ajya.a(2131715028);
          break;
        case 1: 
          localObject = ajya.a(2131715029);
          continue;
          return false;
          label671:
          localObject = "";
        }
        break;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3);
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable Bundle paramBundle)
  {
    aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localaynr == null) {
      throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + paramInt2);
    }
    if (paramInt2 == 2)
    {
      if (paramInt3 != 0) {
        break label129;
      }
      a("video_tab", "clk_panelvideo", 0, paramString);
    }
    while (a(paramContext, paramInt2, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
      }
      return;
      label129:
      if (paramInt3 == 2) {
        a("video_tab", "clk_setvideo", 0, paramString);
      }
    }
    a(paramInt2, paramInt1, paramString);
    if (localaynr.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
    {
      ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localaynr.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(ajya.a(2131715019) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajya.a(2131715007));
    paramContext.setMessage(ajya.a(2131715004) + ((aynr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajya.a(2131715016));
    paramContext.setNegativeButton(ajya.a(2131715010), new aynh(this));
    paramContext.show();
  }
  
  public void b(aynl paramaynl)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramaynl);
  }
  
  public void b(ayno paramayno, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((aynm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(0, true, new Object[] { paramayno, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      aynr localaynr = (aynr)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaynr != null) {
        localaynr.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aync
 * JD-Core Version:    0.7.0.1
 */