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

public class axmt
  implements Manager
{
  private ajjh jdField_a_of_type_Ajjh = new axmw(this);
  private final ajuc jdField_a_of_type_Ajuc = new axmv(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<axni> jdField_a_of_type_AndroidUtilSparseArray;
  private bgqv jdField_a_of_type_Bgqv = new axmu(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<axna> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, axnf> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, axmz> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, axne> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, axnb> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<axnc> c;
  
  public axmt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    this.c = new ArrayList(50);
    a(2, new axnh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new aqpx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static axmt a(QQAppInterface paramQQAppInterface)
  {
    return (axmt)paramQQAppInterface.getManager(339);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, axng.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(int paramInt, axni paramaxni)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramaxni);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, axnf> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaxni != null) {
        localaxni.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("banner_inter", 0L);
    amgf localamgf = (amgf)alzw.a().a(553);
    if (localamgf != null) {}
    for (long l1 = localamgf.jdField_a_of_type_Int;; l1 = 10L)
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
  
  private void b(azrn paramazrn)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((axnc)localIterator.next()).onUpdate(2, true, paramazrn);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new aqqn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new aqpv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    axni localaxni;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaxni != null) {
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
    return localaxni.a();
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
  
  public axmz a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    axmz localaxmz = (axmz)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localaxmz;
    if (localaxmz == null)
    {
      paramString = new axmz();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public axna a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (axna)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public axnb a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (axnb)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends axne> T a(int paramInt)
  {
    axne localaxne2 = (axne)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    axne localaxne1 = localaxne2;
    if (localaxne2 == null) {
      localaxne1 = null;
    }
    return localaxne1;
  }
  
  public <T extends axnf> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (axnf)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public azrn a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    azrn localazrn = new azrn();
    localazrn.jdField_a_of_type_JavaLangString = paramString;
    localazrn.b = Integer.valueOf(localObject[0]).intValue();
    localazrn.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
    return localazrn;
  }
  
  @Nullable
  public HashMap<String, axnf> a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
    }
    return new HashMap();
  }
  
  @Nullable
  public HashMap<String, axnf> a(int paramInt)
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
    ((axnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((axnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, axnf paramaxnf)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramString, paramaxnf);
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
      axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localaxni != null) {
        localaxni.a(paramContext, paramSessionInfo, paramInt);
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
    axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localaxni == null) {
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
    if (localaxni.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
    {
      ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localaxni.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(ajjy.a(2131649203) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajjy.a(2131649205));
    paramContext.setMessage(ajjy.a(2131649214) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajjy.a(2131649223));
    paramContext.setNegativeButton(ajjy.a(2131649215), new axmx(this));
    paramContext.show();
  }
  
  public void a(axnb paramaxnb)
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
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(paramaxnb.b), "data.isGetFakeData=", Boolean.valueOf(paramaxnb.jdField_a_of_type_Boolean) });
          if (paramaxnb.jdField_a_of_type_Boolean)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(paramaxnb.f) });
            Iterator localIterator = paramaxnb.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (paramaxnb == null) {
          continue;
        }
      }
      catch (Exception paramaxnb)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", paramaxnb.getMessage() });
        }
        return;
      }
      if ((paramaxnb.jdField_a_of_type_JavaUtilArrayList != null) && (paramaxnb.jdField_a_of_type_JavaUtilArrayList.size() >= 4) && (paramaxnb.f >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramaxnb.b), paramaxnb);
  }
  
  public void a(axnc paramaxnc)
  {
    this.c.remove(paramaxnc);
    this.c.add(paramaxnc);
  }
  
  public void a(axnf paramaxnf, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramaxnf.d);
    if (localaxni != null) {
      localaxni.a(paramaxnf, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(azrn paramazrn)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(paramazrn.jdField_a_of_type_JavaLangString, paramazrn.b + "_" + paramazrn.jdField_a_of_type_Int);
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
    label565:
    label599:
    label762:
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
                  if (!badq.g(localBaseActivity))
                  {
                    bbmy.a(localBaseActivity, 1, localBaseActivity.getString(2131629228), 0).a();
                    return;
                  }
                  if (paramInt1 == 1)
                  {
                    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localBaseActivity, paramInt2, paramString, paramLong);
                    return;
                  }
                  if (paramInt1 != 2) {
                    break label599;
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
                  bbmy.a(localBaseActivity, 1, 2131654949, 0).b(localBaseActivity.getTitleBarHeight());
                  return;
                }
                paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
              } while (paramBaseActivity == null);
              paramBaseActivity = axng.a(true, paramBaseActivity.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 1);
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
              bbmy.a(localBaseActivity, 1, 2131654949, 0).b(localBaseActivity.getTitleBarHeight());
              return;
            }
            switch (((WatchTogetherSession)localObject).i)
            {
            default: 
              if (!a(localBaseActivity, 2, paramString, 1)) {
                break label565;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
          return;
          bbmy.a(localBaseActivity, 0, 2131627594, 0).a();
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, 1, paramBaseActivity);
          return;
          a("video_tab", "clk_videoark_suc", 0, paramString);
          axng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((WatchTogetherSession)localObject).j, ((WatchTogetherSession)localObject).h, null, paramBaseActivity, 1);
          return;
        } while (paramInt1 != 4);
        if (paramInt2 == 1)
        {
          i = 1;
          if (i == 0) {
            break label724;
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
            break label762;
          }
          bbmy.a(localBaseActivity, 1, 2131653775, 0).b(localBaseActivity.getTitleBarHeight());
          return;
          i = 0;
          break;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
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
        bbmy.a(localBaseActivity, 1, 2131653775, 0).b(localBaseActivity.getTitleBarHeight());
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
    label724:
    a("sing_tab", "clk_setsing_suc", 0, paramString);
    paramBaseActivity = axng.a(bool, paramBaseActivity.isTroopOwner((String)localObject), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 1);
    int i = 1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
      return;
      if (paramInt2 == 2)
      {
        paramBaseActivity = axng.a(bool, 4);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark_suc", 0, 1, paramString, "", "", "");
        paramInt2 = 4;
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
  
  public void a(String paramString, int paramInt1, int paramInt2, azrn paramazrn)
  {
    a(paramazrn);
    b(paramazrn);
    a("video_tab", "exp_whitebar", 0, paramazrn.jdField_a_of_type_JavaLangString);
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
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
        bgqu localbgqu = new bgqu();
        localbgqu.jdField_a_of_type_Int = 236;
        localbgqu.b = 1;
        localArrayList.add(localbgqu);
        bgqw.a().a(localArrayList, this.jdField_a_of_type_Bgqv);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void a(boolean paramBoolean, axnf paramaxnf, int paramInt, String paramString)
  {
    ((axnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(1, paramBoolean, new Object[] { paramaxnf, Integer.valueOf(paramInt), paramString });
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    TroopInfo localTroopInfo = null;
    if (paramInt2 == 1) {
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
    }
    switch (paramInt1)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
      do
      {
        return false;
        return ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(331)).a(paramInt2, paramString);
      } while ((paramInt2 != 1) || (localTroopInfo == null) || (!localTroopInfo.isWatchTogetherOpen()));
      return true;
    }
    return axng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
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
        bbmy.a(paramContext, 1, ajjy.a(2131649220), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        bbmy.a(paramContext, 1, ajjy.a(2131649213), 0).a();
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (kzy.b(paramContext)))
    {
      bbmy.a(paramContext, 1, ajjy.a(2131649208), 1).a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q())
    {
      bbmy.a(paramContext, 1, ajjy.a(2131649209), 1).a();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m())
    {
      bbmy.a(paramContext, 1, ajjy.a(2131649227), 1).a();
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
            break label543;
          }
          if ((paramString.equals(arrayOfString[2])) && (3 != ((axnf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g) && (((axnf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).g != 0)) {
            switch (Integer.parseInt(arrayOfString[0]))
            {
            default: 
              localObject = ajjy.a(2131649218) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + ajjy.a(2131649230);
            }
          }
        }
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bbmy.a(paramContext, 1, (CharSequence)localObject, 0).a();
      return true;
      localObject = ajjy.a(2131649225);
      continue;
      if ((paramString.equals(arrayOfString[2])) && (2 == ((axnf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).h)) {}
      switch (Integer.parseInt(arrayOfString[0]))
      {
      default: 
        localObject = ajjy.a(2131649211) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(arrayOfString[0]))).a() + ajjy.a(2131649228);
        break;
      case 1: 
        localObject = ajjy.a(2131649229);
        continue;
        return false;
        label543:
        localObject = "";
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
    axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localaxni == null) {
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
    if (localaxni.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
    {
      ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localaxni.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(ajjy.a(2131649219) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajjy.a(2131649207));
    paramContext.setMessage(ajjy.a(2131649204) + ((axni)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + ajjy.a(2131649216));
    paramContext.setNegativeButton(ajjy.a(2131649210), new axmy(this));
    paramContext.show();
  }
  
  public void b(axnc paramaxnc)
  {
    this.c.remove(paramaxnc);
  }
  
  public void b(axnf paramaxnf, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((axnd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).notifyUI(0, true, new Object[] { paramaxnf, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      axni localaxni = (axni)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaxni != null) {
        localaxni.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmt
 * JD-Core Version:    0.7.0.1
 */