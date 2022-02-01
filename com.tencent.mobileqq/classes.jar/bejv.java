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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import mqq.manager.Manager;

public class bejv
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<belg> jdField_a_of_type_AndroidUtilSparseArray;
  private anvi jdField_a_of_type_Anvi = new bejy(this);
  private final aofu jdField_a_of_type_Aofu = new bejx(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianShuGetAdvCallback jdField_a_of_type_CooperationVipTianshuTianShuGetAdvCallback = new bejw(this);
  ArrayList<bekc> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, bekh> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, bekb> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, bekg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<beke> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, bekd> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bejv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    a(2, new bekj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new avwx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static bejv a(QQAppInterface paramQQAppInterface)
  {
    return (bejv)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
  }
  
  private String a(String paramString)
  {
    if (Integer.parseInt(paramString) == 1) {
      return anvx.a(2131714393);
    }
    return anvx.a(2131714386) + ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(paramString))).a() + anvx.a(2131714398);
  }
  
  private String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString2) != null)
    {
      if ((paramString1.equals(paramArrayOfString[2])) && (3 != ((bekh)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).h) && (((bekh)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).h != 0)) {
        return a(paramArrayOfString[0]);
      }
      if ((paramString1.equals(paramArrayOfString[2])) && (2 == ((bekh)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).i)) {
        return a(paramArrayOfString[0]);
      }
      if ((!paramString1.equals(paramArrayOfString[2])) && (avxi.a(Integer.parseInt(paramArrayOfString[0]), paramArrayOfString[2], Integer.parseInt(paramArrayOfString[1])))) {
        return a(paramArrayOfString[0]);
      }
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, beki.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, bekh> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbelg != null) {
        localbelg.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean a(int paramInt, Bundle paramBundle)
  {
    QLog.d("TogetherControlManager", 1, new Object[] { "checkParamsIsValid from=", Integer.valueOf(paramInt) });
    if (paramInt == 10) {}
    String str1;
    String str2;
    do
    {
      return true;
      paramInt = paramBundle.getInt("category_id", 0);
      str1 = paramBundle.getString("video_id", "");
      str2 = paramBundle.getString("title_name", "");
      paramBundle = paramBundle.getString("room_cover", "");
    } while ((paramInt != 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramBundle)));
    QLog.d("TogetherControlManager", 1, new Object[] { "onArkTogetherClick return invalid params videoId=", str1, " categoryId=", Integer.valueOf(paramInt), " titleName:", str2, " roomCover:", paramBundle });
    return false;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String[] arrayOfString = ((String)localObject).split("_");
      localObject = (bekh)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((arrayOfString.length > 0) && (localObject != null) && (!paramString.equals(arrayOfString[2])) && (2 == ((bekh)localObject).i) && (paramInt == Integer.parseInt(arrayOfString[0]))) {
        return true;
      }
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
    if ((paramString == null) || (paramString.h == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " session=", paramString });
      }
      return false;
    }
    if ((paramString.d != paramLong) && (paramLong != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " session.identifyId=" + paramString.d + " msg.identify=" + paramLong });
      }
      a(paramInt3, paramBaseActivity);
      return false;
    }
    return true;
  }
  
  private void b(bgsx parambgsx)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((beke)localIterator.next()).onUpdate(2, true, parambgsx);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new avya(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new avwv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    belg localbelg;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbelg != null) {
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
    return localbelg.a();
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
  
  public bekb a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    bekb localbekb = (bekb)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localbekb;
    if (localbekb == null)
    {
      paramString = new bekb();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public bekc a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (bekc)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public bekd a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (bekd)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends bekg> T a(int paramInt)
  {
    bekg localbekg2 = (bekg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    bekg localbekg1 = localbekg2;
    if (localbekg2 == null) {
      localbekg1 = null;
    }
    return localbekg1;
  }
  
  public <T extends bekh> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (bekh)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public bgsx a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    bgsx localbgsx = new bgsx();
    localbgsx.jdField_a_of_type_JavaLangString = paramString;
    localbgsx.b = Integer.valueOf(localObject[0]).intValue();
    localbgsx.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
    return localbgsx;
  }
  
  public String a(int paramInt)
  {
    belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbelg == null) {
      return "";
    }
    return localbelg.a();
  }
  
  @Nullable
  public HashMap<String, bekh> a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
    }
    return new HashMap();
  }
  
  @Nullable
  public HashMap<String, bekh> a(int paramInt)
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
    ((bekf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((bekf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, bekh parambekh)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "_" + paramInt2 + "_" + paramString, parambekh);
  }
  
  public void a(int paramInt, belg parambelg)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, parambelg);
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
      belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localbelg != null) {
        localbelg.a(paramContext, paramSessionInfo, paramInt);
      }
      k += 1;
      continue;
      if (paramSessionInfo.curType != 1)
      {
        k = m;
        if (paramSessionInfo.curType != 0) {
          break;
        }
      }
      else
      {
        int i;
        label108:
        int j;
        if (paramSessionInfo.curType == 1)
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
          boolean bool = a(k, i, paramSessionInfo.curFriendUin);
          QLog.d("TogetherControlManager", 1, "TogetherWatch  isOpen=" + bool + " service=" + k);
          if (bool)
          {
            a(k, i, paramSessionInfo.curFriendUin, 1000);
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
    belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbelg == null) {
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
    if (localbelg.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
    {
      ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbelg.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(anvx.a(2131714371) + ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anvx.a(2131714373));
    paramContext.setMessage(anvx.a(2131714382) + ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anvx.a(2131714391));
    paramContext.setNegativeButton(anvx.a(2131714383), new bejz(this));
    paramContext.show();
  }
  
  public void a(bekd parambekd)
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
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(parambekd.b), "data.isGetFakeData=", Boolean.valueOf(parambekd.jdField_a_of_type_Boolean) });
          if (parambekd.jdField_a_of_type_Boolean)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(parambekd.f) });
            Iterator localIterator = parambekd.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (parambekd == null) {
          continue;
        }
      }
      catch (Exception parambekd)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", parambekd.getMessage() });
        }
        return;
      }
      if ((parambekd.jdField_a_of_type_JavaUtilArrayList != null) && (parambekd.jdField_a_of_type_JavaUtilArrayList.size() >= 5) && (parambekd.f >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(parambekd.b), parambekd);
  }
  
  public void a(beke parambeke)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambeke);
    this.jdField_b_of_type_JavaUtilArrayList.add(parambeke);
  }
  
  public void a(bekh parambekh, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(parambekh.e);
    if (localbelg != null) {
      localbelg.a(parambekh, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(bgsx parambgsx)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(parambgsx.jdField_a_of_type_JavaLangString, parambgsx.b + "_" + parambgsx.jdField_a_of_type_Int);
    localEditor.apply();
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, Bundle paramBundle)
  {
    if (paramInt3 == 10) {
      a("video_tab", "clk_join_bar", 0, paramString);
    }
    BaseActivity localBaseActivity;
    if (paramBaseActivity == null)
    {
      paramBaseActivity = BaseActivity.sTopActivity;
      localBaseActivity = paramBaseActivity;
      if (paramBaseActivity != null) {
        break label48;
      }
      QLog.d("TogetherControlManager", 1, "joinTogetherAndEnter return null activity");
    }
    label48:
    label377:
    int i;
    label410:
    label423:
    label441:
    boolean bool;
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
                  awfq.a(localBaseActivity, paramInt2, paramString, 1, true, paramBundle.getString("song_id", ""));
                  return;
                }
                if (paramInt1 != 2) {
                  break label410;
                }
                if (paramInt2 != 2) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " sessionType is error" });
              return;
              a("video_tab", "clk_videoark", 0, paramString);
            } while ((a(localBaseActivity, paramInt1, paramInt2, paramString, paramInt3, paramBundle)) || (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131720057)));
            paramBundle = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
            paramBaseActivity = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
          } while ((paramBundle == null) || (paramBaseActivity == null));
          paramBundle = beki.a(true, paramBundle.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramBundle.isAdmin(), paramBundle.troopowneruin, paramString, paramInt3);
          switch (paramBaseActivity.j)
          {
          default: 
            if (!a(localBaseActivity, 2, paramString, paramInt3)) {
              break label377;
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
        return;
        QQToast.a(localBaseActivity, 0, 2131692995, 0).a();
        return;
        a("video_tab", "clk_videoark_suc", 0, paramString);
        b(localBaseActivity, paramString, 1, 2, paramInt3, paramBundle);
        return;
        a("video_tab", "clk_videoark_suc", 0, paramString);
        beki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity.k, paramBaseActivity.h, null, paramBundle, 1);
        return;
      } while (paramInt1 != 4);
      if (paramInt2 != 1) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label565;
      }
      a("sing_tab", "clk_singark", 0, paramString);
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131718907)) {
        break label597;
      }
      i = -1;
      paramBaseActivity = new Bundle();
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool = a(paramInt1, paramInt2, paramString);
      if (paramInt2 != 1) {
        break label599;
      }
      paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    } while (paramBaseActivity == null);
    paramBaseActivity = beki.a(bool, paramBaseActivity.isTroopOwner(paramBundle), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, paramInt3);
    paramInt1 = paramInt2;
    paramInt2 = paramInt3;
    for (;;)
    {
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
      return;
      i = 0;
      break label423;
      label565:
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
      break label441;
      label597:
      break;
      label599:
      if (paramInt2 == 2)
      {
        paramInt2 = 9;
        paramBaseActivity = beki.a(bool, 9);
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
  
  public void a(String paramString, int paramInt1, int paramInt2, bgsx parambgsx)
  {
    a(parambgsx);
    b(parambgsx);
    a("video_tab", "exp_whitebar", 0, parambgsx.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mItemId = paramString2;
    localTianShuReportData.mTraceId = (paramString1 + "_" + l);
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mAppId = "tianshu.156";
    localTianShuReportData.mPageId = "tianshu.156";
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString3);
    if (localTroopInfo == null) {
      return;
    }
    int i = 2;
    if (localTroopInfo.isAdmin()) {
      i = 1;
    }
    if (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
      i = 0;
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
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
        return;
        ArrayList localArrayList = new ArrayList();
        TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
        localTianShuAdPosItemData.mPosId = 236;
        localTianShuAdPosItemData.mNeedCnt = 1;
        localArrayList.add(localTianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(localArrayList, this.jdField_a_of_type_CooperationVipTianshuTianShuGetAdvCallback);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void a(boolean paramBoolean, bekh parambekh, int paramInt, String paramString)
  {
    ((bekf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(1, paramBoolean, new Object[] { parambekh, Integer.valueOf(paramInt), paramString });
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
          return ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(paramInt2, paramString);
        } while (paramInt2 != 1);
        paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
      } while ((paramString == null) || (!paramString.isWatchTogetherOpen()));
      return true;
    }
    return beki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt2 < 3) {}
      for (paramInt2 = 1; ((ListenTogetherManager)localObject).a(paramInt2, paramString); paramInt2 = 2)
      {
        QQToast.a(paramContext, 1, anvx.a(2131714388), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        QQToast.a(paramContext, 1, anvx.a(2131714381), 0).a();
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) || (lka.b(paramContext)))
    {
      QQToast.a(paramContext, 1, anvx.a(2131714376), 1).a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying())
    {
      QQToast.a(paramContext, 1, anvx.a(2131714377), 1).a();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallIdle())
    {
      QQToast.a(paramContext, 1, anvx.a(2131714395), 1).a();
      return true;
    }
    Object localObject = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localObject != null) && (((ncz)localObject).a()))
    {
      QQToast.a(paramContext, 0, 2131690433, 1).a();
      return true;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      String[] arrayOfString = str.split("_");
      if ((arrayOfString.length > 0) && (paramInt1 != Integer.parseInt(arrayOfString[0])))
      {
        str = a(paramString, str, arrayOfString);
        if (!TextUtils.isEmpty(str))
        {
          QQToast.a(paramContext, 1, str, 0).a();
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    if (!NetworkUtil.isNetworkAvailable(paramBaseActivity))
    {
      QQToast.a(paramBaseActivity, 1, paramBaseActivity.getString(2131694461), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, Bundle paramBundle)
  {
    boolean bool = a(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "reopenTogetherBusinessWhenClose serviceType=", Integer.valueOf(paramInt1), " isOpen=" + bool });
    }
    if (bool) {}
    while (!a(paramInt3, paramBundle)) {
      return false;
    }
    if (a(paramBaseActivity, paramInt1, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose checkIsOtherBusinessOpen");
      }
      return true;
    }
    if (a(paramInt1, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose isSameServiceAndJoinStatus");
      }
      QQToast.a(paramBaseActivity, 1, a(String.valueOf(paramInt1)), 0).b(paramBaseActivity.getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of business not open, from=", Integer.valueOf(paramInt3) });
    }
    ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).a(paramBaseActivity, paramString, paramInt2, paramInt3, paramBundle);
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
    belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localbelg == null) {
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
    if (localbelg.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
    {
      ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
      return;
    }
    paramString = localbelg.a();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(anvx.a(2131714387) + ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anvx.a(2131714375));
    paramContext.setMessage(anvx.a(2131714372) + ((belg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a() + anvx.a(2131714384));
    paramContext.setNegativeButton(anvx.a(2131714378), new beka(this));
    paramContext.show();
  }
  
  public void b(beke parambeke)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(parambeke);
  }
  
  public void b(bekh parambekh, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((bekf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(0, true, new Object[] { parambekh, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      belg localbelg = (belg)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbelg != null) {
        localbelg.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejv
 * JD-Core Version:    0.7.0.1
 */