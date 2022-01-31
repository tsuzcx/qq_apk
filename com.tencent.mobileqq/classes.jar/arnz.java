import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.SupportSize;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.model.EmoticonManager.1;
import com.tencent.mobileqq.model.EmoticonManager.10;
import com.tencent.mobileqq.model.EmoticonManager.13;
import com.tencent.mobileqq.model.EmoticonManager.14;
import com.tencent.mobileqq.model.EmoticonManager.16;
import com.tencent.mobileqq.model.EmoticonManager.17;
import com.tencent.mobileqq.model.EmoticonManager.18;
import com.tencent.mobileqq.model.EmoticonManager.19;
import com.tencent.mobileqq.model.EmoticonManager.2;
import com.tencent.mobileqq.model.EmoticonManager.20;
import com.tencent.mobileqq.model.EmoticonManager.21;
import com.tencent.mobileqq.model.EmoticonManager.22;
import com.tencent.mobileqq.model.EmoticonManager.24;
import com.tencent.mobileqq.model.EmoticonManager.25;
import com.tencent.mobileqq.model.EmoticonManager.26;
import com.tencent.mobileqq.model.EmoticonManager.27;
import com.tencent.mobileqq.model.EmoticonManager.28;
import com.tencent.mobileqq.model.EmoticonManager.6;
import com.tencent.mobileqq.model.EmoticonManager.7;
import com.tencent.mobileqq.model.EmoticonManager.8;
import com.tencent.mobileqq.model.EmoticonManager.9;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.emosm.EmosmPb.STAIOFixRecommend;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SupportSize;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arnz
  implements Manager
{
  public static int a;
  public static HashMap<Double, Integer> a;
  public static int b;
  public double a;
  protected ajrp a;
  public SharedPreferences a;
  public Handler a;
  public SparseArray<EmosmPb.SubCmd0x5RspBQRecommend> a;
  public atmp a;
  public QQLruCache<String, EmoticonPackage> a;
  public QQAppInterface a;
  public List<String> a;
  public Map<String, Integer> a;
  public SharedPreferences b;
  public Handler b;
  public SparseArray<List<balx>> b;
  public QQLruCache<String, Emoticon> b;
  public List<String> b;
  public Map<String, CopyOnWriteArrayList<EmotionKeyword>> b;
  public Handler c;
  public QQLruCache<String, List<Emoticon>> c;
  public List<EmotionKeyword> c;
  public Map<String, Integer> c;
  public QQLruCache<String, List<Emoticon>> d;
  public List<RecentEmotion> d;
  public Map<String, Integer> d;
  public Map<String, CopyOnWriteArrayList<RecentEmotion>> e = new QQConcurrentHashMap(1021, 0, 80);
  private Map<String, EmoticonKeywords> f = new ConcurrentHashMap(40);
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_b_of_type_Int = 6;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public arnz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2013, 100, 580);
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2004, 400, 260);
    this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2005, 50, 260);
    this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2020, 50, 260);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Ajrp = new arod(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    jdField_a_of_type_JavaUtilHashMap.put(Double.valueOf(4.7D), Integer.valueOf(300));
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendExposeCountSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendFixExposeCountSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Looper localLooper = ThreadManager.getFileThreadLooper();
    if (localLooper != null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(localLooper);
    }
    if (localLooper != null) {
      this.jdField_c_of_type_AndroidOsHandler = new Handler(localLooper);
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajrp);
    this.jdField_b_of_type_JavaUtilMap = new EmoticonManager.1(this, 1002, 0, 80);
    ThreadManager.postImmediately(new EmoticonManager.2(this), null, true);
  }
  
  private double a()
  {
    if (this.jdField_a_of_type_Double != 0.0D) {
      return this.jdField_a_of_type_Double;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if ((localDisplayMetrics.xdpi != 0.0F) && (localDisplayMetrics.ydpi != 0.0F)) {}
    for (double d1 = Math.round(Math.sqrt(Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D) + Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D)) * 100.0D) / 100.0D;; d1 = 0.0D)
    {
      if ((d1 >= 4.6D) && (localDisplayMetrics.widthPixels >= 720) && (localDisplayMetrics.heightPixels >= 1280)) {}
      for (this.jdField_a_of_type_Double = 4.7D;; this.jdField_a_of_type_Double = -1.0D)
      {
        QLog.d("screenInch", 1, "screen inches-> screenInch: " + d1 + ", formatInch: " + this.jdField_a_of_type_Double + ", widthPixels: " + localDisplayMetrics.widthPixels + " ,heightPixels: " + localDisplayMetrics.heightPixels + " , xdpi: " + localDisplayMetrics.xdpi + " , ydpi: " + localDisplayMetrics.ydpi + ", densityDpi: " + localDisplayMetrics.densityDpi + " , density: " + localDisplayMetrics.density);
        return this.jdField_a_of_type_Double;
      }
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return j;
    }
    int i;
    if (paramBoolean) {
      if (this.jdField_d_of_type_JavaUtilMap.containsKey(paramString)) {
        i = ((Integer)this.jdField_d_of_type_JavaUtilMap.get(paramString)).intValue();
      }
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonManager", 2, "getRecommendExposeNum epId = " + paramString + ",isFix = " + paramBoolean + ", exposeNum = " + i);
      return i;
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0);
      continue;
      if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
        i = ((Integer)this.jdField_c_of_type_JavaUtilMap.get(paramString)).intValue();
      } else {
        i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0);
      }
    }
  }
  
  private SparseArray<balx> a(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label84;
      }
      return null;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
        break;
      }
      localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      continue;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
        break;
      }
      localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    label84:
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getFixRecommendTabList");
    }
    List localList = a(paramInt);
    Object localObject1 = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject1).st_fixinfo.get();
    SparseArray localSparseArray = new SparseArray();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramInt = i;
      if (paramInt < ((List)localObject1).size())
      {
        Object localObject2 = (EmosmPb.STAIOFixRecommend)((List)localObject1).get(paramInt);
        i = ((EmosmPb.STAIOFixRecommend)localObject2).u32_pos.get();
        localObject2 = ((EmosmPb.STAIOFixRecommend)localObject2).rpt_list.get();
        balx localbalx = a((List)localObject2, localList);
        if (localbalx != null) {
          localSparseArray.put(i - 1, localbalx);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          i();
          localObject2 = a((List)localObject2, localList);
          if (localObject2 != null) {
            localSparseArray.put(i - 1, localObject2);
          } else {
            QLog.e("EmoticonManager", 1, "getFixRecommendTabList : fix emotion error, index = " + i);
          }
        }
      }
    }
    return localSparseArray;
  }
  
  private balx a(EmosmPb.STRecommendTabInfo paramSTRecommendTabInfo, List<EmoticonPackage> paramList, boolean paramBoolean)
  {
    return a(paramSTRecommendTabInfo, paramList, paramBoolean, 0);
  }
  
  private balx a(EmosmPb.STRecommendTabInfo paramSTRecommendTabInfo, List<EmoticonPackage> paramList, boolean paramBoolean, int paramInt)
  {
    if (paramSTRecommendTabInfo == null) {
      return null;
    }
    String str = String.valueOf(paramSTRecommendTabInfo.u32_tab_id.get());
    if (paramInt == 0)
    {
      paramInt = a(str, paramBoolean);
      if (paramInt >= jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "getProEmoticonPkgs exposeNum > max ; epId = " + str + ",isFixEmoticon = " + paramBoolean + ", exposeNum = " + paramInt);
        }
        return null;
      }
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        if (((EmoticonPackage)paramList.get(paramInt)).epId.equals(str)) {
          return null;
        }
        paramInt += 1;
      }
    }
    balx localbalx = new balx();
    localbalx.jdField_a_of_type_JavaLangString = str;
    localbalx.jdField_c_of_type_JavaLangString = paramSTRecommendTabInfo.str_tab_name.get();
    localbalx.n = paramSTRecommendTabInfo.i32_tab_type.get();
    localbalx.o = paramSTRecommendTabInfo.i32_feetype.get();
    localbalx.jdField_b_of_type_JavaLangString = paramSTRecommendTabInfo.str_thumb_nail_url.get();
    localbalx.jdField_e_of_type_JavaLangString = paramSTRecommendTabInfo.str_title_color.get();
    localbalx.f = paramSTRecommendTabInfo.str_bg_color.get();
    localbalx.p = paramSTRecommendTabInfo.i32_price.get();
    localbalx.q = paramSTRecommendTabInfo.i32_recommend_mode.get();
    localbalx.r = paramSTRecommendTabInfo.int32_red_point_flag.get();
    localbalx.g = paramSTRecommendTabInfo.str_button_url.get();
    paramList = ajjy.a(2131638310);
    if (localbalx.o == 6)
    {
      paramSTRecommendTabInfo = ajjy.a(2131638257);
      localbalx.jdField_d_of_type_JavaLangString = paramSTRecommendTabInfo;
      localbalx.jdField_a_of_type_Boolean = paramBoolean;
      if (localbalx.n != balx.jdField_e_of_type_Int) {
        break label591;
      }
      localbalx.n = 4;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "recommendemos epid = " + localbalx.jdField_a_of_type_JavaLangString + ";pkgname = " + localbalx.jdField_c_of_type_JavaLangString + ";type = " + localbalx.n + ";feeType" + localbalx.o + ";imgurl = " + localbalx.jdField_b_of_type_JavaLangString + ";btndec = " + localbalx.jdField_d_of_type_JavaLangString + ";price = " + localbalx.p);
      }
      return localbalx;
      if (localbalx.o == 1)
      {
        paramSTRecommendTabInfo = ajjy.a(2131638299);
        break;
      }
      if (localbalx.o == 4)
      {
        paramSTRecommendTabInfo = "VIP";
        break;
      }
      if (localbalx.o == 5)
      {
        paramSTRecommendTabInfo = "SVIP";
        break;
      }
      paramSTRecommendTabInfo = paramList;
      if (localbalx.o != 2) {
        break;
      }
      if (localbalx.p == balx.i)
      {
        paramSTRecommendTabInfo = ajjy.a(2131638263);
        break;
      }
      if (localbalx.p == balx.j)
      {
        paramSTRecommendTabInfo = "￥1.00";
        break;
      }
      paramSTRecommendTabInfo = paramList;
      if (localbalx.p != balx.k) {
        break;
      }
      paramSTRecommendTabInfo = "￥6.00";
      break;
      label591:
      if (localbalx.n == balx.jdField_a_of_type_Int) {
        localbalx.n = 3;
      } else if ((localbalx.n == balx.jdField_c_of_type_Int) || (localbalx.n == balx.jdField_b_of_type_Int)) {
        localbalx.n = 0;
      } else if (localbalx.n == balx.jdField_d_of_type_Int) {
        localbalx.n = 5;
      }
    }
  }
  
  private balx a(List<EmosmPb.STRecommendTabInfo> paramList, List<EmoticonPackage> paramList1)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() < 1))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label66;
      }
      balx localbalx = a((EmosmPb.STRecommendTabInfo)paramList.get(i), paramList1, true);
      localObject = localbalx;
      if (localbalx != null) {
        break;
      }
      i += 1;
    }
    label66:
    return null;
  }
  
  private ArrayList<Emoticon> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_Atmp.a(Emoticon.class, false, "epId=?", new String[] { paramString }, null, null, null, null);
    QQLruCache localQQLruCache = this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache;
    if (localArrayList != null) {
      try
      {
        this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localArrayList);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
          continue;
          QLog.e("EmoticonManager", 1, "queryEmoticonsByPackageIdFromDB data is null , epId = " + paramString);
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, " queryEmoticonsByPackageIdFromDB subEmoticonsCache.size:" + this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ",epId:" + paramString);
    }
    return localArrayList;
  }
  
  private List<balx> a(int paramInt1, int paramInt2)
  {
    List localList2 = b(paramInt1, paramInt2);
    List localList1;
    if (localList2 != null)
    {
      localList1 = localList2;
      if (localList2.size() >= 1) {}
    }
    else
    {
      j();
      localList2 = b(paramInt1, paramInt2);
      if (localList2 != null)
      {
        localList1 = localList2;
        if (localList2.size() >= 1) {}
      }
      else
      {
        QLog.e("EmoticonManager", 1, "getNotFixRecommendList error data = null");
        localList1 = localList2;
      }
    }
    return localList1;
  }
  
  private CopyOnWriteArrayList<RecentEmotion> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.e.containsKey(paramString)) {
        return (CopyOnWriteArrayList)this.e.get(paramString);
      }
      localObject = this.jdField_a_of_type_Atmp.a(RecentEmotion.class, false, "keyword=?", new String[] { paramString }, null, null, null, null);
    } while (localObject == null);
    Object localObject = new CopyOnWriteArrayList((Collection)localObject);
    this.e.put(paramString, localObject);
    return localObject;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "writeRecommendInfoFromFileToCache businessType = " + paramInt);
    }
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      QLog.e("EmoticonManager", 1, "writeRecommendInfoFromFileToCache fileThreadHandler == null");
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EmoticonManager.26(this, paramInt));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (paramInt != -1) {
      switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
      {
      default: 
        paramInt = -1;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label110;
        }
        paramString2 = "";
      }
      label110:
      for (;;)
      {
        awqx.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
        return;
        paramInt = 1;
        break;
        paramInt = 2;
        break;
        paramInt = 3;
        break;
        paramInt = 4;
        break;
      }
      paramInt = 0;
    }
  }
  
  private void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, null, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool = "0".equals(paramString1);
      if (bool) {
        localHashMap.put("receiveSuccess", paramString1);
      }
    }
    for (;;)
    {
      localHashMap.put("type", String.valueOf(paramInt));
      awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "AIOEmoticonMonitor", bool, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("receiveError", paramString1);
      continue;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool = "0".equals(paramString2);
        if (bool) {
          localHashMap.put("sendSuccess", paramString2);
        } else {
          localHashMap.put("sendError", paramString2);
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool = "0".equals(paramString1);
      if (bool) {
        localHashMap.put("addScucess", paramString1);
      }
    }
    for (;;)
    {
      localHashMap.put("type", String.valueOf(paramInt));
      awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "EmoticonOperateMonitor", bool, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("addError", paramString1);
      continue;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool = "0".equals(paramString2);
        if (bool) {
          localHashMap.put("deleteSuccess", paramString2);
        } else {
          localHashMap.put("deleteError", paramString2);
        }
      }
      else if (!TextUtils.isEmpty(paramString3))
      {
        bool = "0".equals(paramString3);
        if (bool) {
          localHashMap.put("getScucess", paramString3);
        } else {
          localHashMap.put("getError", paramString3);
        }
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.jdField_a_of_type_Atmp.a(EmoticonTab.class, paramString);
    if (localEmoticonTab != null)
    {
      if (paramBoolean1) {
        localEmoticonTab.aioHave = true;
      }
      paramString = localEmoticonTab;
      if (paramBoolean2) {
        localEmoticonTab.kandianHave = true;
      }
    }
    for (paramString = localEmoticonTab;; paramString = localEmoticonTab)
    {
      a(paramString);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.setStatus(1000);
      localEmoticonTab.epId = paramString;
      localEmoticonTab.aioHave = paramBoolean1;
      localEmoticonTab.kandianHave = paramBoolean2;
    }
  }
  
  private boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (paramatmo.getStatus() == 1000)
    {
      this.jdField_a_of_type_Atmp.b(paramatmo);
      if (paramatmo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramatmo.getStatus() != 1001) && (paramatmo.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_Atmp.a(paramatmo);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isCustomFace());
  }
  
  private ArrayList<Emoticon> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_Atmp.a(Emoticon.class, false, "name=? and jobType= ?", new String[] { paramString, "0" }, null, null, null, null);
      if (localArrayList != null)
      {
        synchronized (this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache)
        {
          this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localArrayList);
          paramString = localArrayList.iterator();
          if (paramString.hasNext())
          {
            Emoticon localEmoticon = (Emoticon)paramString.next();
            this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
          }
        }
        return localArrayList;
      }
      QLog.e("EmoticonManager", 1, "queryEmoticonsByKeyWordFromDB data is null , keyWord = " + paramString);
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, " queryEmoticonsByKeyWordFromDB keywordEmoticonsCache.size:" + this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ",keyWord:" + paramString);
    return null;
  }
  
  private List<balx> b(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label88;
      }
      return null;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
        break;
      }
      localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
      continue;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
        break;
      }
      localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    }
    label88:
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getNotFixRecommendList");
    }
    ArrayList localArrayList = new ArrayList();
    List localList = a(paramInt2);
    Object localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      paramInt2 = 0;
    }
    int j;
    for (int i = 0;; i = j)
    {
      if ((paramInt2 >= ((List)localObject).size()) || (i >= jdField_b_of_type_Int - paramInt1)) {
        return localArrayList;
      }
      balx localbalx = a((EmosmPb.STRecommendTabInfo)((List)localObject).get(paramInt2), localList, false);
      j = i;
      if (localbalx != null)
      {
        localArrayList.add(localbalx);
        j = i + 1;
      }
      paramInt2 += 1;
    }
  }
  
  private CopyOnWriteArrayList<RecentEmotion> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.e.containsKey(paramString)) {
      return null;
    }
    return (CopyOnWriteArrayList)this.e.get(paramString);
  }
  
  private void b(int paramInt)
  {
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend = null;
    switch (paramInt)
    {
    default: 
      if (localSubCmd0x5RspBQRecommend != null) {
        break;
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
        break;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      break;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
        break;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveRecommendEpInfoToFile businessType = " + paramInt);
      }
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    this.jdField_b_of_type_AndroidOsHandler.post(new EmoticonManager.27(this, paramInt, localSubCmd0x5RspBQRecommend));
  }
  
  private void b(EmoticonKeywords paramEmoticonKeywords)
  {
    if (paramEmoticonKeywords == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB");
    }
    ThreadManager.post(new EmoticonManager.22(this, paramEmoticonKeywords), 5, null, true);
  }
  
  public static void b(String paramString, int paramInt)
  {
    a(null, paramString, paramInt);
  }
  
  private boolean b(int paramInt)
  {
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend;
    switch (paramInt)
    {
    default: 
      localSubCmd0x5RspBQRecommend = null;
    }
    for (;;)
    {
      if (localSubCmd0x5RspBQRecommend != null) {
        break label102;
      }
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective recommendRsp is null");
      k();
      return false;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
        break;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      continue;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
        break;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    label102:
    if (localSubCmd0x5RspBQRecommend.int32_red_point_flag.get() == 1) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective is not white num");
      }
      return false;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getLong("recommendRedpointStartTime", 0L);
    long l2 = localSubCmd0x5RspBQRecommend.int32_light_out_interval.get() * 1000;
    if (System.currentTimeMillis() - l1 > l2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective redpoint is overtime");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective show redpoint");
    }
    return true;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isSelfieFace());
  }
  
  private List<balx> c()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) >= 0) {}
    for (Object localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "getNotFixRecommendList");
      }
      ArrayList localArrayList = new ArrayList();
      List localList = a(1);
      localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          balx localbalx = a((EmosmPb.STRecommendTabInfo)((List)localObject).get(i), localList, false, 1);
          if (localbalx != null) {
            localArrayList.add(localbalx);
          }
          i += 1;
        }
      }
      return localArrayList;
    }
  }
  
  private CopyOnWriteArrayList<EmotionKeyword> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
        return (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      }
      localObject = this.jdField_a_of_type_Atmp.a(EmotionKeyword.class, false, "keyword=?", new String[] { paramString }, null, null, null, null);
    } while (localObject == null);
    Object localObject = new CopyOnWriteArrayList((Collection)localObject);
    this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject);
    return localObject;
  }
  
  private void c(Emoticon paramEmoticon)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramEmoticon.encryptKey))
    {
      localObject2 = (Emoticon)this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramEmoticon.getMapKey());
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (!TextUtils.isEmpty(((Emoticon)localObject2).encryptKey)) {}
      }
      else
      {
        ??? = (Emoticon)this.jdField_a_of_type_Atmp.a(Emoticon.class, "epId=? and eId=?", new String[] { paramEmoticon.epId, paramEmoticon.eId });
      }
      if ((??? != null) && (!TextUtils.isEmpty(((Emoticon)???).encryptKey))) {
        paramEmoticon.encryptKey = ((Emoticon)???).encryptKey;
      }
    }
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticon.getMapKey(), paramEmoticon);
    synchronized (this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      localObject2 = (List)this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramEmoticon.epId);
      if (localObject2 != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (paramEmoticon.eId.equals(localEmoticon.eId))
          {
            ((List)localObject2).remove(localEmoticon);
            ((List)localObject2).add(paramEmoticon);
          }
        }
        this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticon.epId, localObject2);
      }
      d(paramEmoticon);
      return;
    }
  }
  
  public static void c(String paramString, int paramInt)
  {
    a(paramString, null, null, paramInt);
  }
  
  private boolean c(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return false;
      localEmoticonPackage = a(paramString);
    } while (localEmoticonPackage == null);
    int i = ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    int j = localEmoticonPackage.mobileFeetype;
    if (j == 1) {
      return true;
    }
    if (j == 4)
    {
      if ((i == 1) || (i == 3)) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if (j == 5)
    {
      if (i == 3) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    QLog.d("EmoticonManager", 1, "isKeywordEmotionValid isActivity or other epId = " + paramString);
    return false;
  }
  
  private List<EmotionKeyword> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return null;
    }
    return new ArrayList((Collection)this.jdField_b_of_type_JavaUtilMap.get(paramString));
  }
  
  private void d(Emoticon paramEmoticon)
  {
    synchronized (this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      List localList = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramEmoticon.name);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (paramEmoticon.eId.equals(localEmoticon.eId))
          {
            localList.remove(localEmoticon);
            localList.add(paramEmoticon);
          }
        }
        this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticon.name, localList);
      }
      return;
    }
  }
  
  public static void d(String paramString, int paramInt)
  {
    a(null, paramString, null, paramInt);
  }
  
  private void e(Emoticon paramEmoticon)
  {
    List localList = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramEmoticon.name);
    if ((localList != null) && (localList.contains(paramEmoticon))) {
      synchronized (this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        localList.remove(paramEmoticon);
        this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticon.name, localList);
        return;
      }
    }
  }
  
  public static void e(String paramString, int paramInt)
  {
    a(null, null, paramString, paramInt);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "initTabs begins");
    }
    long l = System.currentTimeMillis();
    Object localObject = (ArrayList)this.jdField_a_of_type_Atmp.a(EmoticonTab.class, false, null, null, null, null, null, null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonTab localEmoticonTab = (EmoticonTab)((Iterator)localObject).next();
        if (localEmoticonTab != null)
        {
          if (localEmoticonTab.aioHave) {
            this.jdField_a_of_type_JavaUtilList.add(localEmoticonTab.epId);
          }
          if (localEmoticonTab.kandianHave) {
            this.jdField_b_of_type_JavaUtilList.add(localEmoticonTab.epId);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "initTabs ends, tabCache.size:" + this.jdField_a_of_type_JavaUtilList.size() + ", kanDianCache.size = " + this.jdField_b_of_type_JavaUtilList.size() + ",time:" + (System.currentTimeMillis() - l));
    }
    h();
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  private void h()
  {
    k();
    d();
  }
  
  private void i()
  {
    QLog.d("EmoticonManager", 1, "clearFixRecommendExposeNum");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendFixExposeCountSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().clear().apply();
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  private void j()
  {
    QLog.d("EmoticonManager", 1, "clearNotFixRecommendExposeNum");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendExposeCountSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().clear().apply();
    this.jdField_c_of_type_JavaUtilMap.clear();
  }
  
  private void k()
  {
    a(0);
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "pushNotFixRecommendExposeInfoToSP");
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.entrySet().iterator();
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!TextUtils.isEmpty(str))
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if (i > 0) {
          localEditor.putInt(str, i);
        }
      }
    }
    localEditor.apply();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "pushNotFixRecommendExposeInfoToSP");
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilMap.entrySet().iterator();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!TextUtils.isEmpty(str))
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if (i > 0) {
          localEditor.putInt(str, i);
        }
      }
    }
    localEditor.apply();
  }
  
  private void n()
  {
    b(0);
  }
  
  public int a(String paramString)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
    if ((localInteger == null) || (localInteger.intValue() == 0)) {
      return -1;
    }
    EmoticonPackage localEmoticonPackage = a(paramString);
    JSONObject localJSONObject2 = null;
    Object localObject = localJSONObject2;
    if (localEmoticonPackage != null)
    {
      localObject = localJSONObject2;
      if (TextUtils.isEmpty(localEmoticonPackage.supportSize)) {}
    }
    try
    {
      localObject = new JSONArray(localEmoticonPackage.supportSize);
      if (localObject == null) {
        return -1;
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        QLog.e("EmoticonManager", 1, localJSONException, new Object[0]);
        localJSONObject1 = localJSONObject2;
      }
      int i = 0;
      try
      {
        while (i < localJSONObject1.length())
        {
          localJSONObject2 = localJSONObject1.getJSONObject(i);
          int j = localJSONObject2.getInt("Width");
          int k = localJSONObject2.getInt("Height");
          if ((j == localInteger.intValue()) && (k == localInteger.intValue()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonManager", 2, "get support size from db, betterSize " + localInteger + ", epId: " + paramString);
            }
            i = localInteger.intValue();
            return i;
          }
          i += 1;
        }
        return -1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public long a(String paramString)
  {
    long l = 0L;
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    EmoticonKeywords localEmoticonKeywords;
    if (this.f.containsKey(paramString))
    {
      localEmoticonKeywords = (EmoticonKeywords)this.f.get(paramString);
      if (localEmoticonKeywords == null) {
        break label145;
      }
      l = localEmoticonKeywords.lastReqTime;
    }
    label145:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "getKeywordLastReqTime keyword = " + paramString + ", lastReqTime = " + l);
      }
      return l;
      localEmoticonKeywords = (EmoticonKeywords)this.jdField_a_of_type_Atmp.a(EmoticonKeywords.class, "keyword=?", new String[] { paramString });
      if (localEmoticonKeywords != null)
      {
        l = localEmoticonKeywords.lastReqTime;
        this.f.put(paramString, localEmoticonKeywords);
      }
    }
  }
  
  public anla a(MarkFaceMessage paramMarkFaceMessage)
  {
    if (paramMarkFaceMessage == null) {}
    Object localObject1;
    do
    {
      return null;
      localObject1 = anam.a(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    } while (localObject1 == null);
    String str = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Object localObject2 = a(str, (String)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((anla)localObject1).jdField_c_of_type_Int = 6;
      ((anla)localObject1).a = ((Emoticon)localObject2);
      ((anla)localObject1).jdField_c_of_type_Boolean = paramMarkFaceMessage.isAPNG;
      ((Emoticon)localObject2).encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (((Emoticon)localObject2).width == 0) {
        ((Emoticon)localObject2).width = i;
      }
      if (((Emoticon)localObject2).height == 0) {
        ((Emoticon)localObject2).height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        ((Emoticon)localObject2).jobType = 2;
        ((Emoticon)localObject2).magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      if (paramMarkFaceMessage.mediaType == 3) {
        ((Emoticon)localObject2).jobType = 4;
      }
      if ((((Emoticon)localObject2).parseSoundPrintString() == null) || (((Emoticon)localObject2).parseSoundPrintString().isEmpty()))
      {
        ((Emoticon)localObject2).voicePrintItems = paramMarkFaceMessage.voicePrintItems;
        ((Emoticon)localObject2).voicePrint = ((Emoticon)localObject2).toSoundPrintString();
      }
      if (TextUtils.isEmpty(((Emoticon)localObject2).backColor)) {
        ((Emoticon)localObject2).backColor = paramMarkFaceMessage.backColor;
      }
      if (TextUtils.isEmpty(((Emoticon)localObject2).volumeColor)) {
        ((Emoticon)localObject2).volumeColor = paramMarkFaceMessage.volumeColor;
      }
      ((anla)localObject1).j = paramMarkFaceMessage.cSubType;
      a(str, (Emoticon)localObject2, paramMarkFaceMessage.resvAttr);
      return localObject1;
    }
    localObject2 = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((anla)localObject2).jdField_c_of_type_Int = 6;
    ((anla)localObject2).jdField_c_of_type_Boolean = paramMarkFaceMessage.isAPNG;
    Emoticon localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    }
    for (;;)
    {
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.epId = str;
      localEmoticon.eId = ((String)localObject1);
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      localEmoticon.width = i;
      localEmoticon.height = j;
      localEmoticon.name = paramMarkFaceMessage.faceName;
      localEmoticon.volumeColor = paramMarkFaceMessage.volumeColor;
      localEmoticon.backColor = paramMarkFaceMessage.backColor;
      localEmoticon.voicePrintItems = paramMarkFaceMessage.voicePrintItems;
      localEmoticon.voicePrint = localEmoticon.toSoundPrintString();
      ((anla)localObject2).a = localEmoticon;
      ((anla)localObject2).j = paramMarkFaceMessage.cSubType;
      a(null, localEmoticon, paramMarkFaceMessage.resvAttr);
      return localObject2;
      if (paramMarkFaceMessage.mediaType == 2) {
        localEmoticon.jobType = 1;
      } else if (paramMarkFaceMessage.mediaType == 3) {
        localEmoticon.jobType = 4;
      }
    }
  }
  
  public Emoticon a(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "getRecentEmotionByKeyword, keyword = " + paramString);
      }
      localObject1 = a(paramString);
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      int i = 0;
      if (i >= ((List)localObject1).size()) {
        break;
      }
      localObject2 = (RecentEmotion)((List)localObject1).get(i);
      if (localObject2 == null) {}
      do
      {
        do
        {
          i += 1;
          break;
        } while (((RecentEmotion)localObject2).exposeNum >= 3);
        localObject2 = a(((RecentEmotion)localObject2).epId, ((RecentEmotion)localObject2).eId);
      } while ((localObject2 == null) || (!c(((Emoticon)localObject2).epId)));
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "getRecentEmotionByKeyword, keyword = " + paramString + ", emoticon = " + ((Emoticon)localObject2).getMapKey());
    return localObject2;
    return null;
  }
  
  public Emoticon a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "syncFindEmoticonById epId = " + paramString1 + ", eId = " + paramString2);
    }
    Object localObject;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("EmoticonManager", 1, "syncFindEmoticonById error epId = " + paramString1 + ",eId = " + paramString2);
      localObject = null;
    }
    Emoticon localEmoticon;
    do
    {
      do
      {
        return localObject;
        localEmoticon = (Emoticon)this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString1 + "_" + paramString2);
        localObject = localEmoticon;
      } while (localEmoticon != null);
      localEmoticon = (Emoticon)this.jdField_a_of_type_Atmp.a(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, paramString2 });
      if (localEmoticon != null)
      {
        this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
        return localEmoticon;
      }
      localObject = localEmoticon;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "can not findEmoticonById epId = " + paramString1 + ", eId = " + paramString2);
    return localEmoticon;
  }
  
  public EmoticonPackage a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public EmoticonPackage a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "syncFindEmoticonPackageById epId = " + paramString + ", type = " + paramInt);
    }
    EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    EmoticonPackage localEmoticonPackage1 = localEmoticonPackage2;
    if (localEmoticonPackage2 == null)
    {
      localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_Atmp.a(EmoticonPackage.class, paramString);
      if (localEmoticonPackage2 != null)
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localEmoticonPackage2);
        localEmoticonPackage1 = localEmoticonPackage2;
      }
    }
    else
    {
      if ((localEmoticonPackage1 != null) && (paramInt != -1)) {
        break label152;
      }
    }
    label152:
    label165:
    do
    {
      do
      {
        return localEmoticonPackage1;
        localEmoticonPackage1 = localEmoticonPackage2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonManager", 2, "can not find package:" + paramString);
        localEmoticonPackage1 = localEmoticonPackage2;
        break;
        if (paramInt != 0) {
          break label165;
        }
      } while (localEmoticonPackage1.aio);
      return null;
    } while ((paramInt != 1) || (localEmoticonPackage1.kandian));
    return null;
  }
  
  public EmoticonTab a(String paramString)
  {
    return (EmoticonTab)this.jdField_a_of_type_Atmp.a(EmoticonTab.class, paramString);
  }
  
  public VipIPSiteInfo a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = (VipIPSiteInfo)VipIPSiteInfo.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      return paramArrayOfByte;
    }
    QLog.e("EmoticonManager", 1, "getIPSiteInfoFromBytes, error data = " + paramArrayOfByte);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString1 + "_" + paramString2);
    if (localEmoticon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "can not find small emotion in cache, but pkg in cache: epId = " + paramString1 + ", eId = " + paramString2);
      }
      a(new EmoticonManager.6(this, paramString1, paramString2), 5);
      return "";
    }
    return localEmoticon.character;
  }
  
  public List<EmoticonPackage> a()
  {
    return a(0);
  }
  
  public List<EmoticonPackage> a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "syncGetTabEmoticonPackages begins, kanDianTabCache.size:" + this.jdField_b_of_type_JavaUtilList.size() + " tabCache.size:" + this.jdField_a_of_type_JavaUtilList.size() + ",pkgCache.size:" + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + " businessType = " + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (localObject != null)
      {
        localObject = a((String)localObject, paramInt);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          continue;
          localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            localObject = (String)localIterator.next();
            if (localObject != null)
            {
              localObject = a((String)localObject, paramInt);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "syncGetTabEmoticonPackages ends, list.size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List<String> a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        localArrayList = new ArrayList();
        String str;
        if (paramEmoticon.keywords != null)
        {
          paramEmoticon = new JSONArray(paramEmoticon.keywords);
          if (paramEmoticon.length() <= 0) {
            break label124;
          }
          i = 0;
          if (i >= paramEmoticon.length()) {
            break label124;
          }
          str = paramEmoticon.getString(i);
          if (TextUtils.isEmpty(str)) {
            break label126;
          }
        }
        else
        {
          paramEmoticon = new JSONArray();
          continue;
        }
        localArrayList.add(str);
      }
      catch (Exception paramEmoticon)
      {
        QLog.e("EmoticonManager", 2, "getKeywordsByEmoticon exception e = " + paramEmoticon.getMessage());
        return null;
      }
      label124:
      return localArrayList;
      label126:
      i += 1;
    }
  }
  
  public List<Emoticon> a(String paramString)
  {
    return a(paramString, false);
  }
  
  public List<Emoticon> a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList2 = (ArrayList)this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 == null) {
      localArrayList1 = a(paramString);
    }
    for (;;)
    {
      paramString = localArrayList1;
      if (localArrayList1 == null) {
        break;
      }
      paramString = localArrayList1;
      if (!paramBoolean) {
        break;
      }
      return (List)localArrayList1.clone();
      localArrayList1 = localArrayList2;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonManager", 2, "syncGetSubEmoticonsByPackageId from cache subEmoticonsCache.size:" + this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ",epId:" + paramString);
        localArrayList1 = localArrayList2;
      }
    }
  }
  
  public List<balx> a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getProEmoticonPkgs isFromCache = " + paramBoolean1 + " businessType = " + paramInt + " kanDianBiu = " + paramBoolean2);
    }
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
      localObject2 = null;
      localObject1 = null;
      if (paramBoolean1)
      {
        localObject2 = localObject1;
        if (paramBoolean2)
        {
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
          }
        }
      }
      break;
    case 0: 
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (balx)((Iterator)localObject1).next();
        if (((balx)localObject3).n == 6)
        {
          ((List)localObject2).add(localObject3);
          continue;
          j = 1;
          if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
            break label800;
          }
        }
      }
    }
    label655:
    label669:
    label800:
    for (Object localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(0) >= 0)
      {
        localObject3 = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
        i = 0;
        j = 1;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = 1;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
          break label794;
        }
      }
      for (localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(1) >= 0)
        {
          localObject3 = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
          i = 1;
          j = 0;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          return localObject2;
          localObject1 = new ArrayList();
          if (localObject2 != null) {
            if (paramInt == 1)
            {
              localObject1 = c();
              label352:
              if (j == 0) {
                break label767;
              }
              this.jdField_b_of_type_AndroidUtilSparseArray.put(0, localObject1);
            }
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (!paramBoolean2) {
              break;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              break;
            }
            localObject2 = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (balx)((Iterator)localObject1).next();
              if (((balx)localObject3).n == 6) {
                ((List)localObject2).add(localObject3);
              }
            }
            int m = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject2).int32_show_num.get();
            if (m > 0) {
              jdField_b_of_type_Int = m;
            }
            int k = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject2).int32_exposure_num.get();
            if (k > 0) {
              jdField_a_of_type_Int = k;
            }
            localObject2 = a(paramInt);
            if (localObject2 != null)
            {
              k = ((SparseArray)localObject2).size();
              if (QLog.isColorLevel()) {
                QLog.d("EmoticonManager", 2, "getProEmoticonPkgs showNum = " + m + ",fixRecommendSize = " + k);
              }
              localObject1 = a(k, paramInt);
              if ((localObject2 == null) || (k <= 0) || (localObject1 == null)) {
                break label669;
              }
              paramInt = 0;
              label577:
              if (paramInt >= k) {
                break label669;
              }
              localObject3 = (balx)((SparseArray)localObject2).valueAt(paramInt);
              int n = ((SparseArray)localObject2).keyAt(paramInt);
              m = n;
              if (n < 0) {
                m = 0;
              }
              if (m <= ((List)localObject1).size()) {
                break label655;
              }
              ((List)localObject1).add(((List)localObject1).size(), localObject3);
            }
            for (;;)
            {
              paramInt += 1;
              break label577;
              k = 0;
              break;
              ((List)localObject1).add(m, localObject3);
            }
            paramInt = 0;
            if (localObject1 != null) {
              paramInt = ((List)localObject1).size();
            }
            QLog.d("EmoticonManager", 2, "getProEmoticonPkgs data size = " + paramInt);
            break label352;
            QLog.d("EmoticonManager", 1, "getProEmoticonPkgs recommendRsp == NULL");
            if (paramInt == 0)
            {
              k();
              break label352;
            }
            if (paramInt == 1)
            {
              localObject2 = (ajhm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
              if (localObject2 != null) {
                ((ajhm)localObject2).c();
              }
            }
            break label352;
            label767:
            if (i != 0) {
              this.jdField_b_of_type_AndroidUtilSparseArray.put(1, localObject1);
            }
          }
          return localObject2;
        }
        localObject1 = null;
        break;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache begins");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache ends");
    }
  }
  
  public void a(int paramInt, arok<List<EmoticonPackage>> paramarok)
  {
    new QueryTask(new aroa(this), paramarok).a(Integer.valueOf(paramInt));
  }
  
  public void a(aelm paramaelm)
  {
    if ((!(paramaelm instanceof aemg)) || (((aemg)paramaelm).a == null)) {}
    Emoticon localEmoticon;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        paramaelm = ((aemg)paramaelm).a;
        localObject = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramaelm.name);
        if (localObject == null)
        {
          paramaelm.increaseExposeNum();
          this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramaelm.getMapKey(), paramaelm);
          this.jdField_a_of_type_Atmp.a(paramaelm);
          return;
        }
        localObject = ((List)localObject).iterator();
      }
      localEmoticon = (Emoticon)((Iterator)localObject).next();
    } while ((localEmoticon == null) || (!paramaelm.getMapKey().equals(localEmoticon.getMapKey())));
    localEmoticon.increaseExposeNum();
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
    this.jdField_a_of_type_Atmp.a(localEmoticon);
  }
  
  public void a(balx parambalx)
  {
    if ((parambalx == null) || (TextUtils.isEmpty(parambalx.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      int i = a(parambalx.jdField_a_of_type_JavaLangString, parambalx.jdField_a_of_type_Boolean);
      if (parambalx.jdField_a_of_type_Boolean) {
        this.jdField_d_of_type_JavaUtilMap.put(parambalx.jdField_a_of_type_JavaLangString, Integer.valueOf(i + 1));
      }
      while (QLog.isColorLevel())
      {
        QLog.d("EmoticonManager", 2, "recordRecommendEpExpose epid = " + parambalx.jdField_a_of_type_JavaLangString + ";exposeNum = " + (i + 1));
        return;
        this.jdField_c_of_type_JavaUtilMap.put(parambalx.jdField_a_of_type_JavaLangString, Integer.valueOf(i + 1));
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (((paramChatMessage instanceof MessageForMarketFace)) && (((MessageForMarketFace)paramChatMessage).isNewSoundType())) {
      a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage, new aroe(this, paramBoolean, paramSessionInfo));
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    a(new EmoticonManager.9(this, paramEmoticon), 8);
  }
  
  public void a(EmoticonKeywords paramEmoticonKeywords)
  {
    if (paramEmoticonKeywords == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "updateKeywordReqTime, emoticonKeywords = " + paramEmoticonKeywords);
    }
    String str = paramEmoticonKeywords.keyword.toLowerCase();
    EmoticonKeywords localEmoticonKeywords = (EmoticonKeywords)this.f.get(str);
    if (localEmoticonKeywords != null)
    {
      localEmoticonKeywords.lastReqTime = paramEmoticonKeywords.lastReqTime;
      b(localEmoticonKeywords);
      return;
    }
    this.f.put(str, paramEmoticonKeywords);
    b(paramEmoticonKeywords);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticonPackage.epId, paramEmoticonPackage);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveEmoticonPackages, pkgCache.size:" + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ",epId:" + paramEmoticonPackage.epId + ",status:" + paramEmoticonPackage.getStatus());
      }
      a(new EmoticonManager.8(this, paramEmoticonPackage), 8);
    }
  }
  
  public void a(EmotionKeyword paramEmotionKeyword)
  {
    if (paramEmotionKeyword == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramEmotionKeyword.keyword;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "addEmotionKeywordToCache emotionKeyword = " + paramEmotionKeyword);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = c((String)localObject);
    if (localCopyOnWriteArrayList != null)
    {
      Iterator localIterator = localCopyOnWriteArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (EmotionKeyword)localIterator.next();
      } while (!paramEmotionKeyword.equals(localObject));
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((EmotionKeyword)localObject).replace(paramEmotionKeyword);
        paramEmotionKeyword = (EmotionKeyword)localObject;
      }
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilList.remove(paramEmotionKeyword);
        this.jdField_c_of_type_JavaUtilList.add(paramEmotionKeyword);
        return;
        localCopyOnWriteArrayList.add(paramEmotionKeyword);
        continue;
        localCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localCopyOnWriteArrayList.add(paramEmotionKeyword);
        this.jdField_b_of_type_JavaUtilMap.put(localObject, localCopyOnWriteArrayList);
      }
      localObject = null;
    }
  }
  
  public void a(EmotionKeyword paramEmotionKeyword, boolean paramBoolean)
  {
    if ((paramEmotionKeyword == null) || (TextUtils.isEmpty(paramEmotionKeyword.keyword)) || (TextUtils.isEmpty(paramEmotionKeyword.epId)) || (TextUtils.isEmpty(paramEmotionKeyword.eId))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "addRecentEmotionExposeNum emotion keyword = " + paramEmotionKeyword);
      }
      localObject = b(paramEmotionKeyword.keyword);
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    label88:
    RecentEmotion localRecentEmotion;
    while (((Iterator)localObject).hasNext())
    {
      localRecentEmotion = (RecentEmotion)((Iterator)localObject).next();
      if ((paramEmotionKeyword.keyword.equals(localRecentEmotion.keyword)) && (paramEmotionKeyword.epId.equals(localRecentEmotion.epId)) && (paramEmotionKeyword.eId.equals(localRecentEmotion.eId))) {
        if (!paramBoolean) {
          break label190;
        }
      }
    }
    label190:
    for (localRecentEmotion.exposeNum = 0;; localRecentEmotion.exposeNum += 1)
    {
      this.jdField_d_of_type_JavaUtilList.remove(localRecentEmotion);
      this.jdField_d_of_type_JavaUtilList.add(0, localRecentEmotion);
      break label88;
      break;
    }
  }
  
  public void a(MarkFaceMessage paramMarkFaceMessage, arok<anla> paramarok)
  {
    new QueryTask(new arob(this, paramMarkFaceMessage), paramarok).a(paramMarkFaceMessage);
  }
  
  public void a(RecentEmotion paramRecentEmotion)
  {
    ThreadManager.post(new EmoticonManager.19(this, paramRecentEmotion), 5, null, true);
  }
  
  public void a(EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new EmoticonManager.25(this, paramSubCmd0x5RspBQRecommend, paramInt));
  }
  
  public void a(String arg1)
  {
    Object localObject1 = a(???);
    if (localObject1 == null) {
      return;
    }
    synchronized (this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject1).next();
        List localList = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(localEmoticon.name);
        if ((localList != null) && (!localList.contains(localEmoticon)))
        {
          localList.add(localEmoticon);
          this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.name, localList);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, arok<EmoticonPackage> paramarok)
  {
    new QueryTask(new arog(this), paramarok).a(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "saveEmoticonPkgUpdateStatus epId = " + paramString1 + " businessType = " + paramInt3);
    }
    EmoticonPackage localEmoticonPackage = c(paramString1, paramInt3);
    if (localEmoticonPackage != null)
    {
      paramInt3 = localEmoticonPackage.latestVersion;
      localEmoticonPackage.updateFlag = paramInt2;
      localEmoticonPackage.updateTip = paramString2;
      localEmoticonPackage.latestVersion = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "epId=" + paramString1 + " localVersion=" + localEmoticonPackage.localVersion + " version=" + paramInt1 + " updateFlag: " + paramInt2 + " latestVersion= " + paramInt3);
      }
      if ((anjd.a(paramInt2)) && (paramInt3 < paramInt1))
      {
        localEmoticonPackage.hasReadUpdatePage = false;
        a(localEmoticonPackage);
      }
    }
  }
  
  public void a(String paramString, arok<EmoticonPackage> paramarok)
  {
    a(paramString, 0, paramarok);
  }
  
  public void a(String paramString, Emoticon paramEmoticon, List<EmosmPb.SupportSize> paramList)
  {
    if ((paramList == null) || (paramEmoticon == null)) {
      return;
    }
    Integer localInteger;
    do
    {
      do
      {
        do
        {
          localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
        } while ((localInteger == null) || (localInteger.intValue() == 0));
        if (a(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "get support size from cloud: local exists, better size" + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId);
          }
          a(paramString, paramEmoticon, null);
          return;
        }
        paramList = paramList.iterator();
      } while (!paramList.hasNext());
      EmosmPb.SupportSize localSupportSize = (EmosmPb.SupportSize)paramList.next();
      int i = localSupportSize.u32_Width.get();
      int j = localSupportSize.u32_height.get();
      if ((i != localInteger.intValue()) || (j != localInteger.intValue())) {
        break;
      }
      paramEmoticon.extensionWidth = localInteger.intValue();
      paramEmoticon.extensionHeight = localInteger.intValue();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "get support size from cloud: , better size" + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId);
  }
  
  public void a(String paramString, Emoticon paramEmoticon, byte[] paramArrayOfByte)
  {
    int k = 0;
    int j = 0;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
    if ((localInteger == null) || (localInteger.intValue() == 0)) {}
    int i;
    do
    {
      return;
      if ((paramString == null) || (paramEmoticon.extensionHeight != 0) || (paramEmoticon.extensionWidth != 0)) {
        break;
      }
      i = a(paramString);
    } while (i == -1);
    paramEmoticon.extensionHeight = i;
    paramEmoticon.extensionWidth = i;
    return;
    MarketFaceExtPb.ResvAttr localResvAttr;
    if (paramArrayOfByte != null) {
      localResvAttr = new MarketFaceExtPb.ResvAttr();
    }
    for (;;)
    {
      try
      {
        localResvAttr.mergeFrom(paramArrayOfByte);
        if (!localResvAttr.uint32_emoji_type.has()) {
          break label583;
        }
        if (localResvAttr.uint32_emoji_type.get() == 2)
        {
          i = 1;
          if (i == 0) {
            break label323;
          }
          if ((localResvAttr.rpt_apng_support_size == null) || (paramEmoticon.extensionWidth != 0) || (paramEmoticon.extensionHeight != 0)) {
            break;
          }
          i = j;
          if (i >= localResvAttr.rpt_apng_support_size.size()) {
            break;
          }
          paramArrayOfByte = (MarketFaceExtPb.SupportSize)localResvAttr.rpt_apng_support_size.get(i);
          j = paramArrayOfByte.uint32_width.get();
          k = paramArrayOfByte.uint32_height.get();
          if ((j != localInteger.intValue()) || (k != localInteger.intValue())) {
            continue;
          }
          paramEmoticon.extensionWidth = localInteger.intValue();
          paramEmoticon.extensionHeight = localInteger.intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmoticonManager", 2, "get apng support size from resvAttr, betterSize: " + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        i = 0;
        continue;
        i += 1;
        continue;
      }
      label323:
      if ((localResvAttr.rpt_support_size == null) || (paramEmoticon.extensionHeight != 0) || (paramEmoticon.extensionWidth != 0)) {
        break;
      }
      i = k;
      for (;;)
      {
        if (i >= localResvAttr.rpt_support_size.size()) {
          break label497;
        }
        paramArrayOfByte = (MarketFaceExtPb.SupportSize)localResvAttr.rpt_support_size.get(i);
        j = paramArrayOfByte.uint32_width.get();
        k = paramArrayOfByte.uint32_height.get();
        if ((j == localInteger.intValue()) && (k == localInteger.intValue()))
        {
          paramEmoticon.extensionWidth = localInteger.intValue();
          paramEmoticon.extensionHeight = localInteger.intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmoticonManager", 2, "get support size from resvAttr, betterSize: " + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId);
          return;
        }
        i += 1;
      }
      label497:
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonManager", 2, "get support size " + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId + ", height: " + paramEmoticon.extensionHeight + ", width: " + paramEmoticon.extensionWidth);
      return;
      label583:
      i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, arok<Emoticon> paramarok)
  {
    new QueryTask(new arof(this), paramarok).a(new Pair(paramString1, paramString2));
  }
  
  public void a(String paramString, List<Emoticon> paramList)
  {
    ArrayList localArrayList = (ArrayList)a(paramString);
    atmr localatmr = this.jdField_a_of_type_Atmp.a();
    try
    {
      localatmr.a();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.remove(localEmoticon.getMapKey());
          localEmoticon.setStatus(1001);
          this.jdField_a_of_type_Atmp.b(localEmoticon);
          e(localEmoticon);
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
      localArrayList.clear();
      this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localArrayList);
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_c_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, paramList);
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (Emoticon)paramString.next();
          paramList.setStatus(1000);
          a(paramList);
          this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramList.getMapKey(), paramList);
        }
      }
    }
    finally
    {
      localatmr.b();
    }
    localatmr.b();
  }
  
  public void a(List<EmoticonPackage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
        if (localEmoticonPackage != null)
        {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticonPackage.epId, localEmoticonPackage);
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "saveEmoticonPackages, pkgCache.size:" + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ",epId:" + localEmoticonPackage.epId);
          }
        }
      }
      ThreadManager.post(new EmoticonManager.7(this, paramList), 5, null, true);
    }
  }
  
  public void a(List<String> paramList, int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_JavaUtilList.clear();
      i = paramList.size();
      paramInt = 0;
    }
    while (paramInt < i)
    {
      String str = (String)paramList.get(paramInt);
      if (!this.jdField_a_of_type_JavaUtilList.contains(str)) {
        this.jdField_a_of_type_JavaUtilList.add(str);
      }
      paramInt += 1;
      continue;
      this.jdField_b_of_type_JavaUtilList.clear();
      i = paramList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        str = (String)paramList.get(paramInt);
        if (!this.jdField_b_of_type_JavaUtilList.contains(str)) {
          this.jdField_b_of_type_JavaUtilList.add(str);
        }
        paramInt += 1;
      }
    }
    ThreadManager.post(new EmoticonManager.17(this), 5, null, true);
  }
  
  public boolean a()
  {
    int i = badq.a(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "isWifiOrG3OrG4 netType = " + i);
    }
    return (i == 1) || (i == 3) || (i == 4) || (i == 6);
  }
  
  public boolean a(int paramInt)
  {
    if (!b(paramInt)) {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint red isRedEffective");
      }
    }
    do
    {
      return false;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getBoolean("isClickRecommendRedpoint", false)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint is click");
    return false;
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        break label187;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonManager", 2, "isShowRecommendTabRedPoint recommendRsp == null, businessType = " + paramInt);
      return false;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) >= 0)
      {
        localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        continue;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) >= 0) {
          localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        }
      }
    }
    label187:
    localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      paramInt = 0;
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)((Iterator)localObject).next();
        String str = String.valueOf(localSTRecommendTabInfo.u32_tab_id.get());
        if (!TextUtils.isEmpty(str))
        {
          if ((localSTRecommendTabInfo.int32_red_point_flag.get() == 1) && ((!this.jdField_c_of_type_JavaUtilMap.containsKey(str)) || (((Integer)this.jdField_c_of_type_JavaUtilMap.get(str)).intValue() < jdField_a_of_type_Int)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint showRedpoint");
            }
            return true;
          }
          paramInt += 1;
          if (paramInt < 2) {}
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint not show");
        return false;
      }
    }
  }
  
  public boolean a(EmoticonPackage paramEmoticonPackage)
  {
    paramEmoticonPackage.setStatus(1001);
    this.jdField_a_of_type_Atmp.b(paramEmoticonPackage);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.remove(paramEmoticonPackage.epId);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "isKeywordsInHotWordList keyword: " + azzz.a(paramString));
    }
    return (!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null);
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2)
  {
    QLog.i("EmoticonManager", 1, "handleFetchEmoticonPackagesResp isSuccess = " + paramBoolean + " businessType = " + paramInt2);
    bool2 = false;
    bool3 = false;
    bool1 = bool3;
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 2)
    {
      bool1 = bool3;
      if (paramBoolean)
      {
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(paramEmoticonResp.data);
        ((List)localObject2).addAll(paramEmoticonResp.magicData);
        ((List)localObject2).addAll(paramEmoticonResp.smallEmoticonData);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder("handleFetchEmoticonPackagesResp, big emoticon list=");
          ((StringBuilder)localObject1).append(paramEmoticonResp.data).append("magic emoticon list=").append(paramEmoticonResp.magicData).append("small emoticon list=").append(paramEmoticonResp.smallEmoticonData).append("emoticon tab order list=").append(paramEmoticonResp.tabOrderList).append("roaming emoji size:").append(((List)localObject2).size());
          QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = (anfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      }
    }
    try
    {
      localArrayList2 = new ArrayList();
      i = 0;
      paramBoolean = false;
      bool1 = bool2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ArrayList localArrayList2;
        int i;
        paramBoolean = false;
        bool1 = false;
        continue;
        continue;
        paramInt1 = 0;
      }
    }
    bool2 = bool1;
    try
    {
      if (i >= ((List)localObject2).size()) {
        break label1026;
      }
      bool2 = bool1;
      localObject3 = (EmoticonPackage)((List)localObject2).get(i);
      bool2 = bool1;
      localObject4 = a(((EmoticonPackage)localObject3).epId, -1);
      if (localObject4 != null) {
        break label1292;
      }
      paramInt1 = 1;
      j = paramInt1;
      if (localObject4 != null)
      {
        bool2 = bool1;
        if (((EmoticonPackage)localObject4).jobType != 5)
        {
          j = paramInt1;
          bool2 = bool1;
          if (((EmoticonPackage)localObject4).jobType != 3) {}
        }
        else
        {
          bool2 = bool1;
          List localList = a(((EmoticonPackage)localObject4).epId, false);
          if (localList == null) {
            break label1277;
          }
          j = paramInt1;
          bool2 = bool1;
          if (localList.size() != 0) {}
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        ArrayList localArrayList1;
        bool1 = bool2;
        continue;
        bool1 = bool3;
        continue;
        int j = 1;
      }
      i += 1;
    }
    bool3 = bool1;
    if (localObject4 != null)
    {
      bool2 = bool1;
      if (((EmoticonPackage)localObject4).valid == ((EmoticonPackage)localObject3).valid)
      {
        bool2 = bool1;
        if (((EmoticonPackage)localObject4).wordingId == ((EmoticonPackage)localObject3).wordingId)
        {
          bool2 = bool1;
          if (((EmoticonPackage)localObject4).expiretime == ((EmoticonPackage)localObject3).expiretime)
          {
            bool2 = bool1;
            if (((EmoticonPackage)localObject4).jobType == ((EmoticonPackage)localObject3).jobType)
            {
              bool2 = bool1;
              if (!((EmoticonPackage)localObject3).aio)
              {
                bool2 = bool1;
                bool3 = bool1;
                if (!((EmoticonPackage)localObject3).kandian) {
                  break label1270;
                }
              }
            }
          }
        }
      }
      bool2 = bool1;
      bool3 = bool1;
      if (!TextUtils.isEmpty(((EmoticonPackage)localObject4).name))
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("EmoticonManager", 2, "handleFetchEmoticonPackagesResp : updateLocalep epDb = " + localObject4 + ";ep = " + localObject3);
        }
        bool2 = bool1;
        ((EmoticonPackage)localObject4).expiretime = ((EmoticonPackage)localObject3).expiretime;
        bool2 = bool1;
        ((EmoticonPackage)localObject4).valid = ((EmoticonPackage)localObject3).valid;
        bool2 = bool1;
        ((EmoticonPackage)localObject4).wordingId = ((EmoticonPackage)localObject3).wordingId;
        bool2 = bool1;
        ((EmoticonPackage)localObject4).jobType = ((EmoticonPackage)localObject3).jobType;
        bool2 = bool1;
        if (((EmoticonPackage)localObject3).aio)
        {
          bool2 = bool1;
          ((EmoticonPackage)localObject4).aio = true;
        }
        bool2 = bool1;
        if (((EmoticonPackage)localObject3).kandian)
        {
          bool2 = bool1;
          ((EmoticonPackage)localObject4).kandian = true;
        }
        bool2 = bool1;
        localArrayList2.add(localObject4);
        bool3 = true;
        bool2 = true;
        paramInt1 = ((EmoticonPackage)localObject3).jobType;
        if (paramInt1 == 3)
        {
          paramBoolean = true;
          bool1 = true;
          if (j == 0) {
            break label1283;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonManager", 2, "handleFetchEmoticonPackagesResp : emoPackage does not exists: " + ((EmoticonPackage)localObject3).epId);
            }
            a((EmoticonPackage)localObject3);
            if (4 == ((EmoticonPackage)localObject3).jobType) {
              ((anfj)localObject1).a(((EmoticonPackage)localObject3).epId, anfj.jdField_c_of_type_Int, null, true, paramInt2);
            }
            while ((((EmoticonPackage)localObject3).jobType == 0) || (4 == ((EmoticonPackage)localObject3).jobType))
            {
              ((anfj)localObject1).a((EmoticonPackage)localObject3);
              break label1283;
              ((anfj)localObject1).a(((EmoticonPackage)localObject3).epId, anfj.jdField_c_of_type_Int, null, false, paramInt2);
            }
            QLog.e("EmoticonManager", 1, "handleFetchEmoticonPackagesResp", localException1);
          }
          catch (Exception localException1) {}
          bool2 = bool1;
          while ((((List)localObject2).size() > 0) && (paramEmoticonResp.tabOrderList.size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.e("EmoticonManager", 2, "handleFetchEmoticonPackagesResp, svr data wrong, no order list, but allEpList.size()=" + ((List)localObject2).size());
            }
            localArrayList1 = new ArrayList();
            paramInt1 = paramEmoticonResp.data.size() - 1;
            for (;;)
            {
              if (paramInt1 >= 0)
              {
                localObject2 = (EmoticonPackage)paramEmoticonResp.data.get(paramInt1);
                if (localObject2 != null) {
                  localArrayList1.add(((EmoticonPackage)localObject2).epId);
                }
                paramInt1 -= 1;
                continue;
                localObject4 = anam.b(2, ((EmoticonPackage)localObject3).epId);
                localObject3 = new File(anam.a(2, ((EmoticonPackage)localObject3).epId));
                if (((File)localObject3).exists()) {
                  break label1283;
                }
                localObject3 = new batm((String)localObject4, (File)localObject3);
                ((bato)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1).a((batm)localObject3, null, null);
                break label1283;
                label1026:
                bool2 = bool1;
                a(localArrayList2);
                bool2 = bool1;
                break;
              }
            }
            paramInt1 = paramEmoticonResp.magicData.size() - 1;
            while (paramInt1 >= 0)
            {
              localObject2 = (EmoticonPackage)paramEmoticonResp.magicData.get(paramInt1);
              if (localObject2 != null) {
                localArrayList1.add(((EmoticonPackage)localObject2).epId);
              }
              paramInt1 -= 1;
            }
            paramInt1 = paramEmoticonResp.smallEmoticonData.size() - 1;
            while (paramInt1 >= 0)
            {
              localObject2 = (EmoticonPackage)paramEmoticonResp.smallEmoticonData.get(paramInt1);
              if (localObject2 != null) {
                localArrayList1.add(((EmoticonPackage)localObject2).epId);
              }
              paramInt1 -= 1;
            }
          }
          for (paramEmoticonResp = localArrayList1;; paramEmoticonResp = paramEmoticonResp.tabOrderList)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonManager", 2, "handleFetchEmoticonPackagesResp, save order, orderList=" + paramEmoticonResp + ",dataChanged: " + bool2);
            }
            a(paramEmoticonResp, paramInt2);
            bool1 = paramBoolean;
            if (bool2)
            {
              baig.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis());
              bool1 = paramBoolean;
            }
            return bool1;
          }
        }
      }
    }
  }
  
  public byte[] a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo == null)
    {
      QLog.e("EmoticonManager", 1, "parseIPSiteInfoToBytes, error vipSiteInfo == null");
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramVipIPSiteInfo.writeToParcel(localParcel, 0);
    paramVipIPSiteInfo = localParcel.marshall();
    localParcel.recycle();
    return paramVipIPSiteInfo;
  }
  
  public int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 0;
  }
  
  public EmoticonPackage b(String paramString)
  {
    return c(paramString, 0);
  }
  
  public EmoticonPackage b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "syncFindEmoticonPackageInCache epId = " + paramString + ", type = " + paramInt);
    }
    paramString = (EmoticonPackage)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    if ((paramString == null) || (paramInt == -1)) {}
    do
    {
      do
      {
        return paramString;
        if (paramInt != 0) {
          break;
        }
      } while (paramString.aio);
      return null;
    } while ((paramInt != 1) || (paramString.kandian));
    return null;
  }
  
  public List<Emoticon> b()
  {
    return this.jdField_a_of_type_Atmp.a(Emoticon.class, false, "jobType= ?", new String[] { "0" }, null, null, null, null);
  }
  
  public List<anht> b(int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject3 = a(paramInt);
    Object localObject2 = new ArrayList();
    if (localObject3 != null)
    {
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject4 = (EmoticonPackage)((List)localObject3).get(paramInt);
        if ((3 == ((EmoticonPackage)localObject4).jobType) || (5 == ((EmoticonPackage)localObject4).jobType)) {
          ((List)localObject2).add(localObject4);
        }
        paramInt += 1;
      }
    }
    Object localObject4 = new ArrayList();
    localObject3 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    paramInt = 0;
    if (((Iterator)localObject2).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject2).next();
      Object localObject5 = a(localEmoticonPackage.epId, false);
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject5).next();
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "try to get pack data, id:" + localEmoticonPackage.epId + ",valid:" + localEmoticonPackage.valid + ",status:" + localEmoticonPackage.status);
          }
          if (localEmoticonPackage.jobType == 3)
          {
            localEmoticon.jobType = 2;
            label263:
            if (!TextUtils.isEmpty(localEmoticonPackage.name)) {
              localEmoticon.name = localEmoticonPackage.name;
            }
            localEmoticon.value = localEmoticonPackage.valid;
            anla localanla = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localanla.jdField_c_of_type_Int = 9;
            localanla.a = localEmoticon;
            ((List)localObject1).add(localanla);
            if ((!localEmoticonPackage.valid) || (localEmoticonPackage.status != 2)) {
              break label387;
            }
            ((List)localObject4).add(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            paramInt += 1;
            break;
            if (localEmoticonPackage.jobType != 5) {
              break label263;
            }
            localEmoticon.jobType = 4;
            break label263;
            label387:
            ((List)localObject3).add(Integer.valueOf(paramInt));
          }
        }
      }
      for (;;)
      {
        break;
        QLog.e("EmoticonManager", 1, "getMagicEmoticonInfoList, emoticons is null, epId = " + localEmoticonPackage.epId);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "comp size:" + ((List)localObject4).size() + ",inComp size:" + ((List)localObject3).size());
    }
    if ((((List)localObject4).size() > 0) && (((List)localObject3).size() > 0) && (((Integer)((List)localObject4).get(((List)localObject4).size() - 1)).intValue() > ((Integer)((List)localObject3).get(0)).intValue()))
    {
      localObject2 = new ArrayList();
      paramInt = 0;
      while (paramInt < ((List)localObject4).size())
      {
        ((List)localObject2).add(((List)localObject1).get(((Integer)((List)localObject4).get(paramInt)).intValue()));
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        ((List)localObject2).add(((List)localObject1).get(((Integer)((List)localObject3).get(paramInt)).intValue()));
        paramInt += 1;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "final size:" + ((List)localObject1).size() + ",inComp size:" + ((List)localObject3).size());
      }
      return localObject1;
    }
  }
  
  public List<Emoticon> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "findKeywordEmotion");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramString);
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("findKeywordEmotion, find from local:");
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        EmotionKeyword localEmotionKeyword = (EmotionKeyword)paramString.next();
        if ((localEmotionKeyword != null) && (localEmotionKeyword.exposeNum < 3))
        {
          Emoticon localEmoticon = a(localEmotionKeyword.epId, localEmotionKeyword.eId);
          if (localEmoticon == null) {
            QLog.e("EmoticonManager", 1, "findKeywordEmotion emoticon = null, epId = " + localEmotionKeyword.epId + ",eId = " + localEmotionKeyword.eId);
          }
          if ((localEmoticon != null) && (!localArrayList.contains(localEmoticon)) && (c(localEmoticon.epId)))
          {
            localArrayList.add(localEmoticon);
            ((StringBuilder)localObject).append(localEmoticon.eId).append(",");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public List<Emoticon> b(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList2 = (ArrayList)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 == null) {
      localArrayList1 = b(paramString);
    }
    for (;;)
    {
      paramString = localArrayList1;
      if (!paramBoolean) {
        break;
      }
      paramString = localArrayList1;
      if (localArrayList1 == null) {
        break;
      }
      paramString = localArrayList1;
      if (localArrayList1.isEmpty()) {
        break;
      }
      return (List)localArrayList1.clone();
      localArrayList1 = localArrayList2;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonManager", 2, "syncGetEmoticonsByKeyword from cache arrEmoticon.size:" + localArrayList2.size() + ",keyWord: " + azzz.a(paramString));
        localArrayList1 = localArrayList2;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveRecentEmotionToDB start");
    }
    if (this.jdField_d_of_type_JavaUtilList.size() < 1) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList(this.jdField_d_of_type_JavaUtilList);
      this.jdField_d_of_type_JavaUtilList.clear();
    } while ((localArrayList.size() <= 0) || (this.jdField_c_of_type_AndroidOsHandler == null));
    this.jdField_c_of_type_AndroidOsHandler.post(new EmoticonManager.20(this, localArrayList));
  }
  
  public void b(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {}
    Emoticon localEmoticon;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        localObject = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramEmoticon.name);
        if (localObject == null)
        {
          paramEmoticon.increaseExposeNum();
          this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramEmoticon.getMapKey(), paramEmoticon);
          this.jdField_a_of_type_Atmp.a(paramEmoticon);
          return;
        }
        localObject = ((List)localObject).iterator();
      }
      localEmoticon = (Emoticon)((Iterator)localObject).next();
    } while ((localEmoticon == null) || (!paramEmoticon.getMapKey().equals(localEmoticon.getMapKey())));
    localEmoticon.increaseClickNum();
    this.jdField_b_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.getMapKey(), localEmoticon);
    this.jdField_c_of_type_AndroidOsHandler.post(new EmoticonManager.28(this, localEmoticon));
  }
  
  public void b(EmotionKeyword paramEmotionKeyword, boolean paramBoolean)
  {
    if ((paramEmotionKeyword == null) || (TextUtils.isEmpty(paramEmotionKeyword.keyword))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "addEmotionKeywordExpose emotion keyword = " + paramEmotionKeyword + ",isReset = " + paramBoolean);
      }
      localObject = d(paramEmotionKeyword.keyword);
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    label78:
    EmotionKeyword localEmotionKeyword;
    while (((Iterator)localObject).hasNext())
    {
      localEmotionKeyword = (EmotionKeyword)((Iterator)localObject).next();
      if (paramEmotionKeyword.equals(localEmotionKeyword)) {
        if (!paramBoolean) {
          break label143;
        }
      }
    }
    label143:
    for (localEmotionKeyword.exposeNum = 0;; localEmotionKeyword.exposeNum += 1)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramEmotionKeyword);
      this.jdField_c_of_type_JavaUtilList.add(localEmotionKeyword);
      break label78;
      break;
    }
  }
  
  public void b(String arg1)
  {
    Object localObject1 = a(???);
    if (localObject1 == null) {
      return;
    }
    synchronized (this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject1).next();
        List localList = (List)this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.get(localEmoticon.name);
        if ((localList != null) && (localList.contains(localEmoticon)))
        {
          localList.remove(localEmoticon);
          this.jdField_d_of_type_ComTencentCommonsdkCacheQQLruCache.put(localEmoticon.name, localList);
        }
      }
    }
  }
  
  public void b(String paramString, int paramInt, arok<EmoticonPackage> paramarok)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "asyncFindTabEmoticonPackageById epId = " + paramString + " businessType = " + paramInt);
    }
    new QueryTask(new aroc(this), paramarok).a(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "saveEmoticonPackageKeywordJson epId = " + paramString1 + " businessType = " + paramInt3);
    }
    paramString2 = c(paramString1, paramInt3);
    if (paramString2 == null) {
      return;
    }
    paramString2.jsonVersion = paramInt1;
    a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, paramInt1 + "==========KeywordJsonUpdate============" + paramString1);
    }
    ((anfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramString2.epId, anfj.jdField_d_of_type_Int, paramInt3);
  }
  
  public void b(String paramString, arok<EmoticonPackage> paramarok)
  {
    b(paramString, 0, paramarok);
  }
  
  public void b(List<Emoticon> paramList)
  {
    if (paramList == null) {
      return;
    }
    a(new EmoticonManager.10(this, paramList), 8);
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public EmoticonPackage c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "syncFindTabEmoticonPackageById epId = " + paramString + " businessType = " + paramInt);
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        switch (paramInt)
        {
        }
      } while (!this.jdField_a_of_type_JavaUtilList.contains(paramString));
      return a(paramString, paramInt);
    } while (!this.jdField_b_of_type_JavaUtilList.contains(paramString));
    return a(paramString, paramInt);
  }
  
  public List<String> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLocalExposeNumFullKeyword : ids,");
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (EmotionKeyword)paramString.next();
        if ((localObject != null) && (((EmotionKeyword)localObject).exposeNum >= 3))
        {
          localObject = ((EmotionKeyword)localObject).eId;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!localArrayList.contains(localObject)))
          {
            localArrayList.add(localObject);
            localStringBuilder.append(",eId=").append((String)localObject);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_JavaUtilList.size() < 1) {}
    List localList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveEmotionKeywordToDB");
      }
      localList = this.jdField_c_of_type_JavaUtilList;
    } while ((localList.size() <= 0) || (this.jdField_c_of_type_AndroidOsHandler == null));
    this.jdField_c_of_type_AndroidOsHandler.post(new EmoticonManager.21(this, localList));
  }
  
  /* Error */
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 342	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 344
    //   17: iconst_2
    //   18: new 148	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 1813
    //   28: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 1369	arnz:c	(Ljava/lang/String;)Ljava/util/concurrent/CopyOnWriteArrayList;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull -41 -> 7
    //   51: new 148	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 1815
    //   63: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: new 584	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 795	java/util/ArrayList:<init>	()V
    //   74: astore_2
    //   75: aload_1
    //   76: invokeinterface 868 1 0
    //   81: astore 4
    //   83: aload 4
    //   85: invokeinterface 594 1 0
    //   90: ifeq +60 -> 150
    //   93: aload 4
    //   95: invokeinterface 598 1 0
    //   100: checkcast 853	com/tencent/mobileqq/data/EmotionKeyword
    //   103: astore 5
    //   105: aload 5
    //   107: ifnull -24 -> 83
    //   110: aload 5
    //   112: getfield 1750	com/tencent/mobileqq/data/EmotionKeyword:exposeNum	I
    //   115: iconst_3
    //   116: if_icmplt -33 -> 83
    //   119: aload_0
    //   120: getfield 77	arnz:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   123: aload 5
    //   125: invokeinterface 871 2 0
    //   130: pop
    //   131: aload_2
    //   132: aload 5
    //   134: invokeinterface 801 2 0
    //   139: pop
    //   140: aload_3
    //   141: aload 5
    //   143: invokevirtual 1008	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: goto -64 -> 83
    //   150: invokestatic 342	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +14 -> 167
    //   156: ldc_w 344
    //   159: iconst_2
    //   160: aload_3
    //   161: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_2
    //   168: invokeinterface 388 1 0
    //   173: ifle -166 -> 7
    //   176: aload_1
    //   177: aload_2
    //   178: invokeinterface 1818 2 0
    //   183: pop
    //   184: aload_0
    //   185: getfield 125	arnz:jdField_a_of_type_Atmp	Latmp;
    //   188: invokevirtual 1534	atmp:a	()Latmr;
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 1538	atmr:a	()V
    //   196: aload_2
    //   197: invokeinterface 868 1 0
    //   202: astore_2
    //   203: aload_2
    //   204: invokeinterface 594 1 0
    //   209: ifeq +111 -> 320
    //   212: aload_2
    //   213: invokeinterface 598 1 0
    //   218: checkcast 853	com/tencent/mobileqq/data/EmotionKeyword
    //   221: astore_3
    //   222: aload_3
    //   223: ifnull -20 -> 203
    //   226: aload_0
    //   227: getfield 125	arnz:jdField_a_of_type_Atmp	Latmp;
    //   230: ldc_w 853
    //   233: ldc_w 1820
    //   236: iconst_3
    //   237: anewarray 429	java/lang/String
    //   240: dup
    //   241: iconst_0
    //   242: aload_3
    //   243: getfield 1377	com/tencent/mobileqq/data/EmotionKeyword:epId	Ljava/lang/String;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_3
    //   250: getfield 1378	com/tencent/mobileqq/data/EmotionKeyword:eId	Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_2
    //   256: aload_3
    //   257: getfield 1365	com/tencent/mobileqq/data/EmotionKeyword:keyword	Ljava/lang/String;
    //   260: aastore
    //   261: invokevirtual 867	atmp:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Latmo;
    //   264: checkcast 853	com/tencent/mobileqq/data/EmotionKeyword
    //   267: astore_3
    //   268: aload_3
    //   269: ifnull -66 -> 203
    //   272: aload_0
    //   273: getfield 125	arnz:jdField_a_of_type_Atmp	Latmp;
    //   276: aload_3
    //   277: invokevirtual 1543	atmp:b	(Latmo;)Z
    //   280: pop
    //   281: goto -78 -> 203
    //   284: astore_2
    //   285: ldc_w 344
    //   288: iconst_1
    //   289: new 148	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 1822
    //   299: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_2
    //   303: invokevirtual 1236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_1
    //   316: invokevirtual 1548	atmr:b	()V
    //   319: return
    //   320: aload_1
    //   321: invokevirtual 1550	atmr:c	()V
    //   324: aload_1
    //   325: invokevirtual 1548	atmr:b	()V
    //   328: return
    //   329: astore_2
    //   330: aload_1
    //   331: invokevirtual 1548	atmr:b	()V
    //   334: aload_2
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	arnz
    //   0	336	1	paramString	String
    //   74	139	2	localObject1	Object
    //   284	19	2	localException	Exception
    //   329	6	2	localObject2	Object
    //   58	219	3	localObject3	Object
    //   81	13	4	localIterator	Iterator
    //   103	39	5	localEmotionKeyword	EmotionKeyword
    // Exception table:
    //   from	to	target	type
    //   192	203	284	java/lang/Exception
    //   203	222	284	java/lang/Exception
    //   226	268	284	java/lang/Exception
    //   272	281	284	java/lang/Exception
    //   320	324	284	java/lang/Exception
    //   192	203	329	finally
    //   203	222	329	finally
    //   226	268	329	finally
    //   272	281	329	finally
    //   285	315	329	finally
    //   320	324	329	finally
  }
  
  public void d()
  {
    int i = ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "parseCloudKeywordsJson user vip type = " + i);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.post(new EmoticonManager.24(this, i));
    }
  }
  
  public void e()
  {
    i();
    j();
  }
  
  public void f()
  {
    l();
    m();
  }
  
  public void f(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "syncPcTabEmoticonPackage epId = " + paramString + " businessType = " + paramInt);
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        }
      } while (this.jdField_a_of_type_JavaUtilList.contains(paramString));
      this.jdField_a_of_type_JavaUtilList.add(0, paramString);
      ThreadManager.post(new EmoticonManager.14(this, paramString), 5, null, true);
      return;
    } while (this.jdField_b_of_type_JavaUtilList.contains(paramString));
    this.jdField_b_of_type_JavaUtilList.add(0, paramString);
    ThreadManager.post(new EmoticonManager.13(this, paramString), 5, null, true);
  }
  
  public void g(String paramString, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      bool2 = true;
    }
    for (;;)
    {
      ThreadManager.post(new EmoticonManager.16(this, paramString, bool2, bool1), 5, null, true);
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramString);
      bool2 = false;
      bool1 = true;
    }
  }
  
  public void h(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonManager", 2, "addTabEmoticonPackage, emoticonTabId = " + paramString + " businessType = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      this.jdField_a_of_type_JavaUtilList.add(0, paramString);
      ajhm localajhm = (ajhm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
      if (localajhm != null) {
        localajhm.a(this.jdField_a_of_type_JavaUtilList, true, 0);
      }
      break;
    }
    for (;;)
    {
      a(new EmoticonManager.18(this, paramString), 5);
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramString);
      this.jdField_b_of_type_JavaUtilList.add(0, paramString);
    }
  }
  
  public void i(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    label32:
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend;
    switch (paramInt)
    {
    default: 
      localSubCmd0x5RspBQRecommend = null;
    }
    while (localSubCmd0x5RspBQRecommend != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "setRecommendEpRedFlag epid = " + paramString);
      }
      List localList = localSubCmd0x5RspBQRecommend.st_new_tab_info.get();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)localIterator.next();
          if (paramString.equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get()))) {
            localSTRecommendTabInfo.int32_red_point_flag.set(0);
          }
        }
      }
      localSubCmd0x5RspBQRecommend.st_new_tab_info.set(localList);
      return;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(0) < 0) {
        break label32;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      continue;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(1) < 0) {
        break label32;
      }
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnz
 * JD-Core Version:    0.7.0.1
 */