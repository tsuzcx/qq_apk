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
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
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

public class bejx
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<bekm> jdField_a_of_type_AndroidUtilSparseArray;
  private anyu jdField_a_of_type_Anyu = new beka(this);
  private final aojs jdField_a_of_type_Aojs = new bejz(this);
  private bnwp jdField_a_of_type_Bnwp = new bejy(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<beke> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, bekj> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, bekd> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, beki> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<bekg> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, bekf> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bejx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    a(2, new bekl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new awec(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static bejx a(QQAppInterface paramQQAppInterface)
  {
    return (bejx)paramQQAppInterface.getManager(339);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, bekk.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, bekj> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbekm != null) {
        localbekm.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("banner_inter", 0L);
    arjm localarjm = (arjm)aran.a().a(553);
    if (localarjm != null) {}
    for (long l1 = localarjm.jdField_a_of_type_Int;; l1 = 10L)
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
  
  private boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3)
  {
    boolean bool = a(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " isOpen=" + bool });
    }
    if (!bool)
    {
      a(paramInt3, paramBaseActivity);
      return false;
    }
    paramString = a(paramInt1, paramInt2, paramString);
    if ((paramString == null) || (paramString.g == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " session=", paramString });
      }
      return false;
    }
    if (paramString.jdField_d_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " session.identifyId=" + paramString.jdField_d_of_type_Long + " msg.identify=" + paramLong });
      }
      a(paramInt3, paramBaseActivity);
      return false;
    }
    return true;
  }
  
  private void b(bhau parambhau)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bekg)localIterator.next()).onUpdate(2, true, parambhau);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new awff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new awea(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    bekm localbekm;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbekm != null) {
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
    return localbekm.a();
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
  
  public bekd a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    bekd localbekd = (bekd)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localbekd;
    if (localbekd == null)
    {
      paramString = new bekd();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public beke a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (beke)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public bekf a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (bekf)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends beki> T a(int paramInt)
  {
    beki localbeki2 = (beki)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    beki localbeki1 = localbeki2;
    if (localbeki2 == null) {
      localbeki1 = null;
    }
    return localbeki1;
  }
  
  public <T extends bekj> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (bekj)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public bhau a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    bhau localbhau = new bhau();
    localbhau.jdField_a_of_type_JavaLangString = paramString;
    localbhau.b = Integer.valueOf(localObject[0]).intValue();
    localbhau.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
    return localbhau;
  }
  
  @Nullable
  public HashMap<String, bekj> a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
    }
    return new HashMap();
  }
  
  @Nullable
  public HashMap<String, bekj> a(int paramInt)
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
    ((bekh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((bekh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, bekj parambekj)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramString, parambekj);
  }
  
  public void a(int paramInt, bekm parambekm)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, parambekm);
  }
  
  public void a(int paramInt, BaseActivity paramBaseActivity)
  {
    QQToast.a(paramBaseActivity, 1, paramInt, 0).b(paramBaseActivity.getTitleBarHeight());
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
      bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localbekm != null) {
        localbekm.a(paramContext, paramSessionInfo, paramInt);
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
    bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbekm == null) {
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
    if (localbekm.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
    {
      ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbekm.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(anzj.a(2131713792) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anzj.a(2131713794));
    paramContext.setMessage(anzj.a(2131713803) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anzj.a(2131713812));
    paramContext.setNegativeButton(anzj.a(2131713804), new bekb(this));
    paramContext.show();
  }
  
  public void a(bekf parambekf)
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
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(parambekf.b), "data.isGetFakeData=", Boolean.valueOf(parambekf.jdField_a_of_type_Boolean) });
          if (parambekf.jdField_a_of_type_Boolean)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(parambekf.f) });
            Iterator localIterator = parambekf.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (parambekf == null) {
          continue;
        }
      }
      catch (Exception parambekf)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", parambekf.getMessage() });
        }
        return;
      }
      if ((parambekf.jdField_a_of_type_JavaUtilArrayList != null) && (parambekf.jdField_a_of_type_JavaUtilArrayList.size() >= 4) && (parambekf.f >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(parambekf.b), parambekf);
  }
  
  public void a(bekg parambekg)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambekg);
    this.jdField_b_of_type_JavaUtilArrayList.add(parambekg);
  }
  
  public void a(bekj parambekj, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(parambekj.jdField_d_of_type_Int);
    if (localbekm != null) {
      localbekm.a(parambekj, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(bhau parambhau)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(parambhau.jdField_a_of_type_JavaLangString, parambhau.b + "_" + parambhau.jdField_a_of_type_Int);
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
    Object localObject;
    label332:
    label365:
    label378:
    boolean bool;
    label396:
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
                } while (!a(localBaseActivity));
                if (paramInt1 == 1)
                {
                  ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localBaseActivity, paramInt2, paramString, paramLong);
                  return;
                }
                if (paramInt1 != 2) {
                  break label365;
                }
                if (paramInt2 != 2) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " sessionType is error" });
              return;
              a("video_tab", "clk_videoark", 0, paramString);
            } while (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131719286));
            localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
          } while (localObject == null);
          paramBaseActivity = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
          localObject = bekk.a(true, ((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, paramString, 8);
          switch (paramBaseActivity.i)
          {
          default: 
            if (!a(localBaseActivity, 2, paramString, 8)) {
              break label332;
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
        return;
        QQToast.a(localBaseActivity, 0, 2131692838, 0).a();
        return;
        a("video_tab", "clk_videoark_suc", 0, paramString);
        b(localBaseActivity, paramString, 1, 2, 8, (Bundle)localObject);
        return;
        a("video_tab", "clk_videoark_suc", 0, paramString);
        bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity.j, paramBaseActivity.h, null, (Bundle)localObject, 1);
        return;
      } while (paramInt1 != 4);
      if (paramInt2 != 1) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label523;
      }
      a("sing_tab", "clk_singark", 0, paramString);
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131718280)) {
        break label559;
      }
      i = -1;
      paramBaseActivity = new Bundle();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool = a(paramInt1, paramInt2, paramString);
      if (paramInt2 != 1) {
        break label561;
      }
      paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
    } while (paramBaseActivity == null);
    paramBaseActivity = bekk.a(bool, paramBaseActivity.isTroopOwner((String)localObject), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
    int i = 8;
    paramInt1 = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
      return;
      i = 0;
      break label378;
      label523:
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
      break label396;
      label559:
      break;
      label561:
      if (paramInt2 == 2)
      {
        paramInt2 = 9;
        paramBaseActivity = bekk.a(bool, 9);
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
  
  public void a(String paramString, int paramInt1, int paramInt2, bhau parambhau)
  {
    a(parambhau);
    b(parambhau);
    a("video_tab", "exp_whitebar", 0, parambhau.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    bnwr localbnwr = new bnwr();
    localbnwr.jdField_d_of_type_Int = paramInt;
    localbnwr.jdField_e_of_type_Int = 1;
    localbnwr.g = paramString2;
    localbnwr.b = (paramString1 + "_" + l);
    localbnwr.jdField_a_of_type_Int = 1;
    localbnwr.jdField_a_of_type_Long = l;
    localbnwr.jdField_e_of_type_JavaLangString = "tianshu.156";
    localbnwr.f = "tianshu.156";
    bnwq.a().a(localbnwr);
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
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
        bnwo localbnwo = new bnwo();
        localbnwo.jdField_a_of_type_Int = 236;
        localbnwo.b = 1;
        localArrayList.add(localbnwo);
        bnwq.a().a(localArrayList, this.jdField_a_of_type_Bnwp);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void a(boolean paramBoolean, bekj parambekj, int paramInt, String paramString)
  {
    ((bekh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(1, paramBoolean, new Object[] { parambekj, Integer.valueOf(paramInt), paramString });
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
    return bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt2 < 3) {}
      for (paramInt2 = 1; ((ListenTogetherManager)localObject).a(paramInt2, paramString); paramInt2 = 2)
      {
        QQToast.a(paramContext, 1, anzj.a(2131713809), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        QQToast.a(paramContext, 1, anzj.a(2131713802), 0).a();
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (lju.b(paramContext)))
    {
      QQToast.a(paramContext, 1, anzj.a(2131713797), 1).a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w())
    {
      QQToast.a(paramContext, 1, anzj.a(2131713798), 1).a();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.s())
    {
      QQToast.a(paramContext, 1, anzj.a(2131713816), 1).a();
      return true;
    }
    Object localObject = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if ((localObject != null) && (((mxc)localObject).a()))
    {
      QQToast.a(paramContext, 0, 2131690337, 1).a();
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
            break label715;
          }
          if ((paramString.equals(arrayOfString[2])) && (3 != ((bekj)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g) && (((bekj)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g != 0)) {
            switch (Integer.parseInt(arrayOfString[0]))
            {
            default: 
              localObject = anzj.a(2131713807) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + anzj.a(2131713819);
            }
          }
        }
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QQToast.a(paramContext, 1, (CharSequence)localObject, 0).a();
      return true;
      localObject = anzj.a(2131713814);
      continue;
      if ((paramString.equals(arrayOfString[2])) && (2 == ((bekj)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).h)) {}
      switch (Integer.parseInt(arrayOfString[0]))
      {
      default: 
        localObject = anzj.a(2131713800) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + anzj.a(2131713817);
        break;
      case 1: 
        localObject = anzj.a(2131713818);
        continue;
        if ((!paramString.equals(arrayOfString[2])) && (awen.a(Integer.parseInt(arrayOfString[0]), arrayOfString[2], Integer.parseInt(arrayOfString[1])))) {}
        switch (Integer.parseInt(arrayOfString[0]))
        {
        default: 
          localObject = anzj.a(2131713800) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + anzj.a(2131713817);
          break;
        case 1: 
          localObject = anzj.a(2131713818);
          continue;
          return false;
          label715:
          localObject = "";
        }
        break;
      }
    }
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    if (!bhnv.g(paramBaseActivity))
    {
      QQToast.a(paramBaseActivity, 1, paramBaseActivity.getString(2131694160), 0).a();
      return false;
    }
    return true;
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
    bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbekm == null) {
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
    if (localbekm.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
    {
      ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbekm.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(anzj.a(2131713808) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anzj.a(2131713796));
    paramContext.setMessage(anzj.a(2131713793) + ((bekm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anzj.a(2131713805));
    paramContext.setNegativeButton(anzj.a(2131713799), new bekc(this));
    paramContext.show();
  }
  
  public void b(bekg parambekg)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambekg);
  }
  
  public void b(bekj parambekj, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((bekh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(0, true, new Object[] { parambekj, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      bekm localbekm = (bekm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbekm != null) {
        localbekm.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejx
 * JD-Core Version:    0.7.0.1
 */