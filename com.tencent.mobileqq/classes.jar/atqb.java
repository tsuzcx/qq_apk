import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class atqb
  implements Manager
{
  private static final int jdField_a_of_type_Int;
  private static final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_b_of_type_JavaUtilList;
  private static final String[][] jdField_b_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_c_of_type_JavaUtilList;
  private static final String[][] jdField_c_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_d_of_type_JavaUtilList;
  private static final String[][] jdField_d_of_type_Array2dOfJavaLangString;
  private static final List<String> e;
  private static final List<String> f;
  private static final List<String> g;
  private static final List<String> h;
  private static final List<String> i;
  private static final List<String> j;
  private static final List<String> k;
  private static final List<String> l;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  
  static
  {
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicCount");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicCount");
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerThumbPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerBigPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadBigPicCount");
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    e = new ArrayList();
    e.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
    e.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
    f = new ArrayList();
    f.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
    g = new ArrayList();
    g.add("PicStatisticsManagerMissPriorityHandlingWifi");
    g.add("PicStatisticsManagerMissPriorityAIOWifi");
    g.add("PicStatisticsManagerMissPriorityC2CWifi");
    g.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    g.add("PicStatisticsManagerMissPriorityGroupWifi");
    g.add("PicStatisticsManagerMissPriorityWaitingWifi");
    g.add("PicStatisticsManagerMissPriorityUnknownWifi");
    h = new ArrayList();
    h.add("PicStatisticsManagerMissPriorityHandlingXG");
    h.add("PicStatisticsManagerMissPriorityAIOXG");
    h.add("PicStatisticsManagerMissPriorityC2CXG");
    h.add("PicStatisticsManagerMissPriorityDiscussionXG");
    h.add("PicStatisticsManagerMissPriorityGroupXG");
    h.add("PicStatisticsManagerMissPriorityWaitingXG");
    h.add("PicStatisticsManagerMissPriorityUnknownXG");
    String[] arrayOfString1 = { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" };
    String[] arrayOfString2 = { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" };
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { arrayOfString1, { "4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount" }, arrayOfString2 };
    jdField_b_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, { "4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount" }, { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" } };
    jdField_c_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, { "4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount" }, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    jdField_d_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    jdField_a_of_type_Int = jdField_a_of_type_Array2dOfJavaLangString[0].length;
    i = new ArrayList();
    j = new ArrayList();
    k = new ArrayList();
    int m = 0;
    while (m < jdField_a_of_type_Int)
    {
      i.add(jdField_a_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_b_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_c_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_d_of_type_Array2dOfJavaLangString[0][m]);
      j.add(jdField_a_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_b_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_c_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_d_of_type_Array2dOfJavaLangString[1][m]);
      k.add(jdField_a_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_b_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_c_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_d_of_type_Array2dOfJavaLangString[2][m]);
      m += 1;
    }
    j.add("4G_C2C_FLOAT_HIT_COUNT");
    k.add("XG_C2C_FLOAT_HIT_COUNT");
    l = new ArrayList();
    l.add("PicStatisticsManagerPreDownloadThumbPicCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  @TargetApi(9)
  public atqb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownWifi";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingWifi";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOWifi";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CWifi";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionWifi";
    }
    return "PicStatisticsManagerMissPriorityGroupWifi";
  }
  
  private HashMap<String, String> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      long l1;
      if (l2 >= 0L)
      {
        l1 = l2;
        if (l2 <= 10000L) {}
      }
      else
      {
        l1 = 0L;
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  @TargetApi(9)
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString, boolean paramBoolean)
  {
    long l1;
    String str1;
    String str2;
    if (paramInt1 == 0) {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountWifi", l1 + 1L);
        paramInt1 = 0;
        str1 = "WIFI";
        if (paramInt2 != 3) {
          break label376;
        }
        paramInt2 = 0;
        str2 = "C2C";
        label60:
        if (QLog.isColorLevel()) {
          QLog.d("PicStatisticsManager", 2, "addCount(): networkType=" + str1 + " uin=" + str2);
        }
        paramArrayOfString = paramArrayOfString[paramInt1][paramInt2];
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramArrayOfString, 0L) + 1L;
        if (Build.VERSION.SDK_INT < 9) {
          break label437;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).apply();
      }
    }
    label376:
    do
    {
      return;
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountWifi", l1 + 1L);
      paramInt1 = 0;
      str1 = "WIFI";
      break;
      if (paramInt1 == 0)
      {
        if (paramBoolean)
        {
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCount4G", l1 + 1L);
          paramInt1 = 1;
          str1 = "4G";
          break;
        }
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l1 + 1L);
        paramInt1 = 1;
        str1 = "4G";
        break;
      }
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountXG", l1 + 1L);
        paramInt1 = 2;
        str1 = "XG";
        break;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l1 + 1L);
      paramInt1 = 2;
      str1 = "XG";
      break;
      if (paramInt2 == 2)
      {
        paramInt2 = 1;
        str2 = "Discussion";
        break label60;
      }
      if (paramInt2 == 0)
      {
        paramInt2 = 2;
        str2 = "Group";
        break label60;
      }
      if (paramInt2 == 1)
      {
        paramInt2 = 3;
        str2 = "Digital Group";
        break label60;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PicStatisticsManager", 2, "addCount(): Error! Unknown uin type");
    return;
    label437:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).commit();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownXG";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingXG";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOXG";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CXG";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionXG";
    }
    return "PicStatisticsManagerMissPriorityGroupXG";
  }
  
  @TargetApi(9)
  private void b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = k.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = l.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicStatisticsManager", 2, "dataReport(): Not need to data report!");
        }
        return;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
    }
    String str;
    label115:
    long l1;
    long l2;
    HashMap localHashMap1;
    label170:
    HashMap localHashMap2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L) {
        break label280;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerSendPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerForwardPicCount", 0L);
      localHashMap1 = a(jdField_a_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label693;
      }
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
      awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
      localHashMap2 = a(jdField_b_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label708;
      }
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "FALSE");
    }
    for (;;)
    {
      awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDownloadPic", false, 0L, 0L, localHashMap2, "");
      b();
      return;
      str = null;
      break;
      label280:
      awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, a(l), "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l5 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      long l6 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
      if (l1 + l4 > 0L) {
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, a(i), "");
      }
      if (l3 + l6 > 0L) {
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, a(j), "");
      }
      if (l2 + l5 > 0L) {
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, a(k), "");
      }
      if (l4 + l5 > 0L)
      {
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, a(jdField_c_of_type_JavaUtilList), "");
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, a(jdField_d_of_type_JavaUtilList), "");
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, a(e), "");
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, a(f), "");
      }
      if (l4 > 0L) {
        awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, a(g), "");
      }
      if (l5 <= 0L) {
        break label115;
      }
      awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, a(h), "");
      break label115;
      label693:
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
      break label170;
      label708:
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "TRUE");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    HashMap localHashMap;
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; str = null)
    {
      localHashMap = new HashMap();
      localHashMap.put("PredownloadMissReason", String.valueOf(paramInt2));
      if (paramInt1 != 0) {
        break;
      }
      awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, localHashMap, "");
      return;
    }
    awrn.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, localHashMap, "");
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): networkType=" + paramInt1 + " uin=" + paramInt2 + " preDownloadState=" + paramInt3);
    }
    if (paramInt3 == 1)
    {
      long l1;
      long l2;
      if (paramInt1 == 2)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l2 + 1L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("XG_C2C_FLOAT_HIT_COUNT", l1 + 1L);
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        }
      }
      else
      {
        do
        {
          return;
          if (paramInt1 == 1)
          {
            l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L);
            l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l2 + 1L);
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("4G_C2C_FLOAT_HIT_COUNT", l1 + 1L);
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    a(paramInt1, paramInt2, jdField_b_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void a(int paramInt, long paramLong)
  {
    String str3;
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addPicData(): Unknown picture type!");
      }
      return;
    case 13057: 
      str3 = "SendPic";
      str2 = "PicStatisticsManagerSendPicTotalSize";
      str1 = "PicStatisticsManagerSendPicCount";
    }
    long l1;
    long l2;
    for (;;)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + paramLong;
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str1, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.i("PicStatisticsManager", 2, "addPictureData(): type=" + str3 + " Adding Size=" + paramLong + " Total Size=" + l1 + " Count=" + l2);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).apply();
      return;
      str3 = "ForwardPic";
      str2 = "PicStatisticsManagerForwardPicTotalSize";
      str1 = "PicStatisticsManagerForwardPicCount";
      continue;
      str3 = "DownloadThumbPic";
      str2 = "PicStatisticsManagerThumbPicTotalSize";
      str1 = "PicStatisticsManagerDownloadThumbPicCount";
      continue;
      str3 = "DownloadBigPic";
      str2 = "PicStatisticsManagerBigPicTotalSize";
      str1 = "PicStatisticsManagerDownloadBigPicCount";
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).commit();
  }
  
  @TargetApi(9)
  public void a(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d("PicStatisticsManager", 2, "addPreDownloadThumbPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + paramMessageForPic.md5);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramMessageForPic.md5);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
        if (Build.VERSION.SDK_INT >= 9)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).apply();
          if (QLog.isColorLevel()) {
            QLog.i("PicStatisticsManager", 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + l1);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).commit();
        }
      }
      finally {}
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDowonloadBigPicCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_a_of_type_Array2dOfJavaLangString, true);
  }
  
  @TargetApi(9)
  public void b(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addDownloadBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int m;
    int n;
    String str1;
    if (atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      m = 1;
      n = auxm.a(l1, l2);
      if (n != 0) {
        break label299;
      }
      if (m == 0) {
        break label292;
      }
      str1 = "PicStatisticsManagerPicDownloadSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (bfcq.a(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
      return;
      m = 0;
      break;
      label292:
      str1 = "PicStatisticsManagerPicDownloadSizeLongGroup";
      continue;
      label299:
      if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (m != 0) {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
      }
    }
    label386:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicMissCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_c_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void c(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addPreviewBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int m;
    int n;
    String str1;
    if (atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      m = 1;
      n = auxm.a(l1, l2);
      if (n != 0) {
        break label299;
      }
      if (m == 0) {
        break label292;
      }
      str1 = "PicStatisticsManagerPicPreviewSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (bfcq.a(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
      return;
      m = 0;
      break;
      label292:
      str1 = "PicStatisticsManagerPicPreviewSizeLongGroup";
      continue;
      label299:
      if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (m != 0) {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
      }
    }
    label386:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadNotSupportCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_d_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void e(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    long l1;
    for (String str = a(paramInt2);; str = b(paramInt2))
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPredownloadMissPriority(): " + str + ", Count=" + l1);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqb
 * JD-Core Version:    0.7.0.1
 */