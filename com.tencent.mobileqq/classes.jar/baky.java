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

public class baky
  implements Manager
{
  private alox jdField_a_of_type_Alox = new balb(this);
  private final amab jdField_a_of_type_Amab = new bala(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<baln> jdField_a_of_type_AndroidUtilSparseArray;
  private bkch jdField_a_of_type_Bkch = new bakz(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<balf> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, balk> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, bale> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, balj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<balh> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, balg> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public baky(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    a(2, new balm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new atas(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static baky a(QQAppInterface paramQQAppInterface)
  {
    return (baky)paramQQAppInterface.getManager(339);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, ball.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, balk> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbaln != null) {
        localbaln.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("banner_inter", 0L);
    aonp localaonp = (aonp)aogj.a().a(553);
    if (localaonp != null) {}
    for (long l1 = localaonp.jdField_a_of_type_Int;; l1 = 10L)
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
  
  private void b(bcrz parambcrz)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((balh)localIterator.next()).onUpdate(2, true, parambcrz);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new atbv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new ataq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    baln localbaln;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbaln != null) {
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
    return localbaln.a();
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
  
  public bale a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    bale localbale = (bale)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localbale;
    if (localbale == null)
    {
      paramString = new bale();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public balf a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (balf)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public balg a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (balg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends balj> T a(int paramInt)
  {
    balj localbalj2 = (balj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    balj localbalj1 = localbalj2;
    if (localbalj2 == null) {
      localbalj1 = null;
    }
    return localbalj1;
  }
  
  public <T extends balk> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (balk)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public bcrz a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    bcrz localbcrz = new bcrz();
    localbcrz.jdField_a_of_type_JavaLangString = paramString;
    localbcrz.b = Integer.valueOf(localObject[0]).intValue();
    localbcrz.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
    return localbcrz;
  }
  
  @Nullable
  public HashMap<String, balk> a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
    }
    return new HashMap();
  }
  
  @Nullable
  public HashMap<String, balk> a(int paramInt)
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
    ((bali)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((bali)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, balk parambalk)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramString, parambalk);
  }
  
  public void a(int paramInt, baln parambaln)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, parambaln);
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
      baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localbaln != null) {
        localbaln.a(paramContext, paramSessionInfo, paramInt);
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
    baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbaln == null) {
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
    if (localbaln.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
    {
      ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbaln.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(alpo.a(2131715375) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + alpo.a(2131715377));
    paramContext.setMessage(alpo.a(2131715386) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + alpo.a(2131715395));
    paramContext.setNegativeButton(alpo.a(2131715387), new balc(this));
    paramContext.show();
  }
  
  public void a(balg parambalg)
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
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(parambalg.b), "data.isGetFakeData=", Boolean.valueOf(parambalg.jdField_a_of_type_Boolean) });
          if (parambalg.jdField_a_of_type_Boolean)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(parambalg.f) });
            Iterator localIterator = parambalg.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (parambalg == null) {
          continue;
        }
      }
      catch (Exception parambalg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", parambalg.getMessage() });
        }
        return;
      }
      if ((parambalg.jdField_a_of_type_JavaUtilArrayList != null) && (parambalg.jdField_a_of_type_JavaUtilArrayList.size() >= 4) && (parambalg.f >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(parambalg.b), parambalg);
  }
  
  public void a(balh parambalh)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambalh);
    this.jdField_b_of_type_JavaUtilArrayList.add(parambalh);
  }
  
  public void a(balk parambalk, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(parambalk.d);
    if (localbaln != null) {
      localbaln.a(parambalk, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(bcrz parambcrz)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(parambcrz.jdField_a_of_type_JavaLangString, parambcrz.b + "_" + parambcrz.jdField_a_of_type_Int);
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
                  if (!bdee.g(localBaseActivity))
                  {
                    QQToast.a(localBaseActivity, 1, localBaseActivity.getString(2131695063), 0).a();
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
                  QQToast.a(localBaseActivity, 1, 2131721403, 0).b(localBaseActivity.getTitleBarHeight());
                  return;
                }
                paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
              } while (paramBaseActivity == null);
              paramBaseActivity = ball.a(true, paramBaseActivity.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
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
              QQToast.a(localBaseActivity, 1, 2131721403, 0).b(localBaseActivity.getTitleBarHeight());
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
          QQToast.a(localBaseActivity, 0, 2131693336, 0).a();
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, 8, paramBaseActivity);
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((WatchTogetherSession)localObject).j, ((WatchTogetherSession)localObject).h, null, paramBaseActivity, 1);
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
          QQToast.a(localBaseActivity, 1, 2131720202, 0).b(localBaseActivity.getTitleBarHeight());
          return;
          i = 0;
          break;
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
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
        QQToast.a(localBaseActivity, 1, 2131720202, 0).b(localBaseActivity.getTitleBarHeight());
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
    paramBaseActivity = ball.a(bool, paramBaseActivity.isTroopOwner((String)localObject), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
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
        paramBaseActivity = ball.a(bool, 9);
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
  
  public void a(String paramString, int paramInt1, int paramInt2, bcrz parambcrz)
  {
    a(parambcrz);
    b(parambcrz);
    a("video_tab", "exp_whitebar", 0, parambcrz.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    bkcj localbkcj = new bkcj();
    localbkcj.d = paramInt;
    localbkcj.jdField_e_of_type_Int = 1;
    localbkcj.g = paramString2;
    localbkcj.b = (paramString1 + "_" + l);
    localbkcj.jdField_a_of_type_Int = 1;
    localbkcj.jdField_a_of_type_Long = l;
    localbkcj.jdField_e_of_type_JavaLangString = "tianshu.156";
    localbkcj.f = "tianshu.156";
    bkci.a().a(localbkcj);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
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
        bkcg localbkcg = new bkcg();
        localbkcg.jdField_a_of_type_Int = 236;
        localbkcg.b = 1;
        localArrayList.add(localbkcg);
        bkci.a().a(localArrayList, this.jdField_a_of_type_Bkch);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void a(boolean paramBoolean, balk parambalk, int paramInt, String paramString)
  {
    ((bali)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(1, paramBoolean, new Object[] { parambalk, Integer.valueOf(paramInt), paramString });
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
    return ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
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
        QQToast.a(paramContext, 1, alpo.a(2131715392), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        QQToast.a(paramContext, 1, alpo.a(2131715385), 0).a();
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (lmm.b(paramContext)))
    {
      QQToast.a(paramContext, 1, alpo.a(2131715380), 1).a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q())
    {
      QQToast.a(paramContext, 1, alpo.a(2131715381), 1).a();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m())
    {
      QQToast.a(paramContext, 1, alpo.a(2131715399), 1).a();
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
          if ((paramString.equals(arrayOfString[2])) && (3 != ((balk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g) && (((balk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g != 0)) {
            switch (Integer.parseInt(arrayOfString[0]))
            {
            default: 
              localObject = alpo.a(2131715390) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + alpo.a(2131715402);
            }
          }
        }
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QQToast.a(paramContext, 1, (CharSequence)localObject, 0).a();
      return true;
      localObject = alpo.a(2131715397);
      continue;
      if ((paramString.equals(arrayOfString[2])) && (2 == ((balk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).h)) {}
      switch (Integer.parseInt(arrayOfString[0]))
      {
      default: 
        localObject = alpo.a(2131715383) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + alpo.a(2131715400);
        break;
      case 1: 
        localObject = alpo.a(2131715401);
        continue;
        if ((!paramString.equals(arrayOfString[2])) && (atbd.a(Integer.parseInt(arrayOfString[0]), arrayOfString[2], Integer.parseInt(arrayOfString[1])))) {}
        switch (Integer.parseInt(arrayOfString[0]))
        {
        default: 
          localObject = alpo.a(2131715383) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + alpo.a(2131715400);
          break;
        case 1: 
          localObject = alpo.a(2131715401);
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
    baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbaln == null) {
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
    if (localbaln.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
    {
      ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbaln.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(alpo.a(2131715391) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + alpo.a(2131715379));
    paramContext.setMessage(alpo.a(2131715376) + ((baln)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + alpo.a(2131715388));
    paramContext.setNegativeButton(alpo.a(2131715382), new bald(this));
    paramContext.show();
  }
  
  public void b(balh parambalh)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambalh);
  }
  
  public void b(balk parambalk, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((bali)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(0, true, new Object[] { parambalk, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      baln localbaln = (baln)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbaln != null) {
        localbaln.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baky
 * JD-Core Version:    0.7.0.1
 */