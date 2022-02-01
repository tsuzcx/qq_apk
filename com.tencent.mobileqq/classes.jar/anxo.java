import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.LebaUtil.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;
import tencent.im.PluginConfig.PluginConfig.GetResourceReqInfo;

public class anxo
{
  public static boolean a;
  
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int a(anxm paramanxm)
  {
    if (paramanxm == null) {
      return 0;
    }
    return paramanxm.jdField_a_of_type_Int * 1000 + paramanxm.b;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = ajzy.a().a(paramQQAppInterface).size();
    int i = j;
    if (Leba.d()) {
      i = j + 1;
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getPreferences().getLong("sp_key_leba_plugin_user_sort_time" + paramInt, 0L);
  }
  
  public static URLDrawable a(Context paramContext, String paramString)
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130845317);
    if (paramContext == null)
    {
      QLog.e("LebaUtil", 1, "apngUrl is empty");
      return URLDrawable.getDrawable("", localDrawable, localDrawable);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("LebaUtil", 1, "apngUrl is empty");
      return URLDrawable.getDrawable("", localDrawable, localDrawable);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_cache", false);
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    paramContext = new File(paramContext.getFilesDir() + "leba/apng/", (String)localObject);
    File localFile = paramContext.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return VasApngUtil.getApngDrawable(paramContext.getAbsolutePath(), paramString, localDrawable, new int[] { 39 }, (String)localObject, localBundle);
  }
  
  public static List<anxm> a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "getGroupInfo");
    }
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_group_info", "");
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      anxm localanxm;
      int j;
      try
      {
        paramQQAppInterface = new JSONArray(paramQQAppInterface);
        i = 0;
        if (i < paramQQAppInterface.length())
        {
          localJSONObject = paramQQAppInterface.getJSONObject(i);
          JSONArray localJSONArray = localJSONObject.names();
          if (localJSONArray == null) {
            break label253;
          }
          localanxm = new anxm();
          j = 0;
          if (j >= localJSONArray.length()) {
            break label212;
          }
          String str = localJSONArray.getString(j);
          try
          {
            if ("uiResId".equals(str)) {
              localanxm.jdField_a_of_type_Long = localJSONObject.getLong(str);
            } else if ("groudId".equals(str)) {
              localanxm.jdField_a_of_type_Int = localJSONObject.getInt(str);
            }
          }
          catch (Exception localException)
          {
            a = true;
            QLog.e("LebaUtil", 1, "getGroupInfo", localException);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        a = true;
        QLog.e("LebaUtil", 1, "getGroupInfo", paramQQAppInterface);
      }
      if ("index".equals(localException))
      {
        localanxm.b = localJSONObject.getInt(localException);
        break label260;
        label212:
        localArrayList.add(localanxm);
        if (QLog.isColorLevel()) {
          QLog.i("LebaHelper", 2, "" + localanxm);
        }
        label253:
        i += 1;
        continue;
      }
      label260:
      j += 1;
    }
  }
  
  public static List<Integer> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    localArrayList = new ArrayList();
    QQAppInterface localQQAppInterface = null;
    try
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_plugin_user_sort_list" + paramInt, "");
      localQQAppInterface = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        localQQAppInterface = paramQQAppInterface;
        JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
        paramInt = 0;
        for (;;)
        {
          localQQAppInterface = paramQQAppInterface;
          if (paramInt >= localJSONArray.length()) {
            break;
          }
          localQQAppInterface = paramQQAppInterface;
          localArrayList.add(Integer.valueOf(localJSONArray.getInt(paramInt)));
          paramInt += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      a = true;
      QLog.i("leba_sort", 1, "getSortInfo " + localQQAppInterface, paramQQAppInterface);
    }
  }
  
  public static Map<Long, anxm> a(List<anxm> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anxm localanxm = (anxm)paramList.next();
      if (localanxm != null) {
        localHashMap.put(Long.valueOf(localanxm.jdField_a_of_type_Long), localanxm);
      }
    }
    return localHashMap;
  }
  
  public static PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    if (bdvn.a()) {}
    for (int i = 4026;; i = 4000)
    {
      QLog.i("LebaHelper", 1, "getLebaPluginListReq pluginType = " + i);
      paramList = new PluginConfig.GetResourceReq();
      paramList.plugin_type.set(i);
      paramList.plugin_layout_seq.set(paramInt);
      paramList.reqinfo_list.set(localArrayList);
      return paramList;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ((bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("150000");
    if ((paramQQAppInterface.getLebaHelper() != null) && (paramQQAppInterface.getLebaHelper().a())) {}
    for (int i = 1; i != 0; i = 0)
    {
      PublicFragmentActivity.a(paramContext, LebaTableMgrFragment.class);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, LebaListMgrActivity.class));
  }
  
  public static void a(SharedPreferences paramSharedPreferences, List<Integer> paramList, Long paramLong, int paramInt)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Integer localInteger = (Integer)paramList.next();
          if (localInteger != null) {
            localJSONArray.put(localInteger);
          }
        }
        paramSharedPreferences.putString("sp_key_leba_plugin_user_sort_list" + paramInt, localJSONArray.toString());
      }
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.i("leba_sort", 1, "saveSortInfo", paramSharedPreferences);
      return;
    }
    if (paramLong != null) {
      paramSharedPreferences.putLong("sp_key_leba_plugin_user_sort_time" + paramInt, paramLong.longValue());
    }
    paramSharedPreferences.commit();
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    if ((paramImageView2 == null) || (paramImageView1 == null) || (paramTextView2 == null) || (paramTextView1 == null))
    {
      QLog.e("LebaUtil", 1, "removeLebaIconAnim, but leba view is null");
      return;
    }
    Runnable localRunnable = (Runnable)paramImageView1.getTag();
    if (localRunnable == null)
    {
      QLog.e("LebaUtil", 1, "removeLebaIconAnim, but no anim is start");
      return;
    }
    ThreadManager.getUIHandler().removeCallbacks(localRunnable);
    paramImageView2.clearAnimation();
    paramImageView1.clearAnimation();
    paramImageView1.setTag(null);
    paramImageView1.setVisibility(8);
    paramImageView2.setVisibility(0);
    paramTextView2.setVisibility(8);
    paramTextView3.setVisibility(8);
    paramTextView1.setVisibility(0);
    ApngImage.pauseByTag(39);
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((paramImageView2 == null) || (paramImageView1 == null))
    {
      QLog.e("LebaUtil", 1, "startLebaIconAnim but image view is null");
      return;
    }
    if (paramImageView1.getTag() != null)
    {
      QLog.e("LebaUtil", 1, "icon anim is started");
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    Context localContext = paramImageView2.getContext();
    Animation localAnimation1 = AnimationUtils.loadAnimation(localContext, 2130772072);
    Animation localAnimation2 = AnimationUtils.loadAnimation(localContext, 2130772073);
    Animation localAnimation3 = AnimationUtils.loadAnimation(localContext, 2130772074);
    Animation localAnimation4 = AnimationUtils.loadAnimation(localContext, 2130772075);
    paramTextView4 = new anxp(localAnimation1, paramImageView1, localContext, paramString, paramTextView2, paramBoolean, paramTextView3, localAnimation2, paramImageView2, paramTextView4, paramTextView1);
    localAnimation1.setAnimationListener(paramTextView4);
    localAnimation2.setAnimationListener(paramTextView4);
    paramTextView4 = ThreadManager.getUIHandler();
    if (localAtomicBoolean.get()) {}
    for (long l = paramLong1;; l = paramLong2)
    {
      paramImageView2 = new LebaUtil.2(localAtomicBoolean, paramImageView1, paramImageView2, localAnimation2, localAnimation3, localAnimation1, localAnimation4, paramBoolean, paramTextView1, paramTextView2, paramTextView3, paramLong2, paramLong1, paramTextView4);
      paramTextView4.postDelayed(paramImageView2, l);
      paramImageView1.setTag(paramImageView2);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("sp_key_leba_upgrade_info", "4875");
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, String.format("update version, buildNum[%s]", new Object[] { "4875" }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "saveLebaGroupSeq，seq=" + paramInt);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_group_seq", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    QLog.i("LebaHelper", 1, "saveLebaInfo,layoutType = " + paramInt1 + ",pluginType" + paramInt2);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_layout_type", paramInt1);
    paramQQAppInterface.putInt("sp_key_leba_plugin_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<anxm> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "saveGroupInfo");
    }
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          anxm localanxm = (anxm)paramList.next();
          if (localanxm == null) {
            continue;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", localanxm.jdField_a_of_type_Long);
            localJSONObject.put("groudId", localanxm.jdField_a_of_type_Int);
            localJSONObject.put("index", localanxm.b);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaHelper", 2, "" + localanxm);
            }
          }
          catch (JSONException paramList)
          {
            QLog.e("LebaHelper", 1, "saveGroupInfo, exp=", paramList);
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putString("sp_key_leba_group_info", localJSONArray.toString());
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.i("LebaHelper", 2, "saveGroupInfo, result=" + true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putBoolean("sp_key_leba_need_req_has_closed_flag", paramBoolean);
      paramQQAppInterface.apply();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_study", 1, "setNeedReqHasClosedFlag", paramQQAppInterface);
    }
  }
  
  public static void a(List<arpq> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static void a(List<arpq> paramList1, List<arpq> paramList2)
  {
    Collections.sort(paramList2, new anxq());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      arpq localarpq1 = (arpq)paramList2.next();
      arpq localarpq2;
      if (a(localarpq1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) != j)
      {
        localarpq2 = new arpq();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((arpq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label101:
            localarpq2.jdField_a_of_type_JavaLangString = "empty_normal";
            label109:
            paramList1.add(localarpq2);
            j = a(localarpq1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority);
            localarpq1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localarpq1);
        break;
        ((arpq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label101;
        localarpq2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label109;
        i += 1;
        localarpq1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((arpq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((arpq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 4026;
  }
  
  public static boolean a(arpq paramarpq)
  {
    if ((paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType == 1) && (!TextUtils.isEmpty(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
      return "qzone_feedlist".equals(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      boolean bool = paramQQAppInterface.getPreferences().getBoolean("sp_key_leba_need_req_has_closed_flag", false);
      return bool;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_sort", 1, "checkNeedReqHasClosedFlag", paramQQAppInterface);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (7720L == paramLong)
      {
        int i = bhhr.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
        aslo localaslo = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        boolean bool = asrt.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("LebaUtil", 2, "filterPlugin kuolie showEntry = " + bool);
        }
        if ((i == 1) && (localaslo.d()) && (bool)) {}
        for (bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((aqvd)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.i < 1));
    return false;
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    if (paramLong == 100000L) {
      return (!paramBoolean) && (paramQQAppInterface.getLebaHelper() != null) && (paramQQAppInterface.getLebaHelper().a());
    }
    boolean bool;
    if (paramBoolean)
    {
      paramQQAppInterface = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.showInSimpleMode != 0))) {
        break label144;
      }
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "needShowRedDot, id=" + paramLong + ", isSimpleMode=" + paramBoolean + ", needShow=" + bool);
      }
      return bool;
      if (!ajzy.a().a(paramQQAppInterface, paramLong)) {
        bool = false;
      } else {
        label144:
        bool = true;
      }
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.getPreferences().getInt("sp_key_leba_group_seq", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LebaHelper", 2, "getLebaGroup, seq=" + j);
    return j;
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, AtomicBoolean paramAtomicBoolean)
  {
    if ((paramTextView1 == null) || (paramTextView2 == null))
    {
      QLog.e("LebaUtil", 1, "startTextAnim, but text view is null");
      return;
    }
    Context localContext = paramTextView2.getContext();
    Animation localAnimation1 = AnimationUtils.loadAnimation(localContext, 2130772072);
    Animation localAnimation2 = AnimationUtils.loadAnimation(localContext, 2130772073);
    if (paramAtomicBoolean.get())
    {
      paramAtomicBoolean = AnimationUtils.loadAnimation(localContext, 2130772072);
      paramTextView2.setVisibility(0);
      paramTextView3.setVisibility(0);
      paramTextView1.startAnimation(localAnimation2);
      paramTextView2.startAnimation(localAnimation1);
      paramTextView3.startAnimation(paramAtomicBoolean);
      return;
    }
    paramAtomicBoolean = AnimationUtils.loadAnimation(localContext, 2130772073);
    paramTextView1.setVisibility(0);
    paramTextView1.startAnimation(localAnimation1);
    paramTextView2.startAnimation(localAnimation2);
    paramTextView3.startAnimation(paramAtomicBoolean);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("sp_key_leba_net_has_closed_flag", paramInt);
      paramQQAppInterface.apply();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_study", 1, "setNetHasClosedFlag", paramQQAppInterface);
    }
  }
  
  public static void b(List<arpq> paramList, List<Integer> paramList1)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
        Collections.sort(paramList, new anxq());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
      localStringBuilder.append(" us=").append(paramList1);
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new anxq());
      Iterator localIterator = paramList.iterator();
      arpq localarpq;
      while (localIterator.hasNext())
      {
        localarpq = (arpq)localIterator.next();
        for (;;)
        {
          try
          {
            j = paramList1.indexOf(Integer.valueOf((int)localarpq.jdField_a_of_type_Long));
            if (j < 0) {
              continue;
            }
            localarpq.b = j;
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
            continue;
            localStringBuilder.append(",fix ").append(localarpq.jdField_a_of_type_Long);
          }
          if (localarpq.c()) {
            continue;
          }
          localArrayList.add(localarpq);
          break;
          localarpq.b = 2147483647;
        }
      }
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      Collections.sort(localArrayList, new anxr());
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        k = j;
        if (!((arpq)paramList.get(i)).c())
        {
          k = j;
          if (j < localArrayList.size())
          {
            paramList.set(i, localArrayList.get(j));
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (bdvn.a()) {}
    for (int i = 4026; i != d(paramQQAppInterface); i = 4000) {
      return true;
    }
    return false;
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    try
    {
      int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_net_has_closed_flag", 0);
      return i;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_study", 1, "getNetReqHasClosedFlag", paramQQAppInterface);
    }
    return 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_upgrade_info", "");
    if (!"4875".equals(paramQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramQQAppInterface, "4875" }));
      }
      return bool;
    }
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_plugin_type", 0);
    QLog.i("LebaHelper", 1, "getLebaPluginType =" + i);
    return i;
  }
  
  public static int e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_layout_type", 0);
    QLog.d("LebaHelper", 1, "getLebaLayoutType =" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxo
 * JD-Core Version:    0.7.0.1
 */