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

public class amvb
{
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int a(amuz paramamuz)
  {
    if (paramamuz == null) {
      return 0;
    }
    return paramamuz.jdField_a_of_type_Int * 1000 + paramamuz.b;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = ajek.a().a(paramQQAppInterface).size();
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
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130845232);
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
  
  /* Error */
  public static List<amuz> a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 172
    //   8: iconst_2
    //   9: ldc 174
    //   11: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 179	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 180	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   26: ldc 182
    //   28: ldc 101
    //   30: invokeinterface 186 3 0
    //   35: astore_0
    //   36: new 188	org/json/JSONArray
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 191	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: aload_0
    //   49: invokevirtual 194	org/json/JSONArray:length	()I
    //   52: if_icmpge +126 -> 178
    //   55: aload_0
    //   56: iload_1
    //   57: invokevirtual 198	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   60: astore 4
    //   62: aload 4
    //   64: invokevirtual 204	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +150 -> 221
    //   74: new 10	amuz
    //   77: dup
    //   78: invokespecial 205	amuz:<init>	()V
    //   81: astore 6
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: aload 5
    //   88: invokevirtual 194	org/json/JSONArray:length	()I
    //   91: if_icmpge +89 -> 180
    //   94: aload 5
    //   96: iload_2
    //   97: invokevirtual 208	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   100: astore 7
    //   102: ldc 210
    //   104: aload 7
    //   106: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifeq +18 -> 127
    //   112: aload 6
    //   114: aload 4
    //   116: aload 7
    //   118: invokevirtual 217	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   121: putfield 220	amuz:jdField_a_of_type_Long	J
    //   124: goto +104 -> 228
    //   127: ldc 222
    //   129: aload 7
    //   131: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +18 -> 152
    //   137: aload 6
    //   139: aload 4
    //   141: aload 7
    //   143: invokevirtual 226	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   146: putfield 13	amuz:jdField_a_of_type_Int	I
    //   149: goto +79 -> 228
    //   152: ldc 228
    //   154: aload 7
    //   156: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +69 -> 228
    //   162: aload 6
    //   164: aload 4
    //   166: aload 7
    //   168: invokevirtual 226	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: putfield 16	amuz:b	I
    //   174: goto +54 -> 228
    //   177: astore_0
    //   178: aload_3
    //   179: areturn
    //   180: aload_3
    //   181: aload 6
    //   183: invokeinterface 231 2 0
    //   188: pop
    //   189: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +29 -> 221
    //   195: ldc 172
    //   197: iconst_2
    //   198: new 46	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   205: ldc 101
    //   207: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 6
    //   212: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -178 -> 47
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto -147 -> 85
    //   235: astore 7
    //   237: goto -9 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramQQAppInterface	QQAppInterface
    //   46	179	1	i	int
    //   84	148	2	j	int
    //   21	160	3	localArrayList	ArrayList
    //   60	105	4	localJSONObject	JSONObject
    //   67	28	5	localJSONArray	JSONArray
    //   81	130	6	localamuz	amuz
    //   100	67	7	str	String
    //   235	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	45	177	org/json/JSONException
    //   47	69	177	org/json/JSONException
    //   74	83	177	org/json/JSONException
    //   85	102	177	org/json/JSONException
    //   102	124	177	org/json/JSONException
    //   127	149	177	org/json/JSONException
    //   152	174	177	org/json/JSONException
    //   180	221	177	org/json/JSONException
    //   102	124	235	java/lang/Exception
    //   127	149	235	java/lang/Exception
    //   152	174	235	java/lang/Exception
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
      QLog.i("leba_sort", 1, "getSortInfo " + localQQAppInterface, paramQQAppInterface);
    }
  }
  
  public static Map<Long, amuz> a(List<amuz> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      amuz localamuz = (amuz)paramList.next();
      if (localamuz != null) {
        localHashMap.put(Long.valueOf(localamuz.jdField_a_of_type_Long), localamuz);
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
    if (bcoo.a()) {}
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
    ((azvi)paramQQAppInterface.getManager(36)).b("150000");
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
    paramTextView4 = new amvc(localAnimation1, paramImageView1, localContext, paramString, paramTextView2, paramBoolean, paramTextView3, localAnimation2, paramImageView2, paramTextView4, paramTextView1);
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
    paramQQAppInterface.putString("sp_key_leba_upgrade_info", "4810");
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, String.format("update version, buildNum[%s]", new Object[] { "4810" }));
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
  
  public static void a(QQAppInterface paramQQAppInterface, List<amuz> paramList)
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
          amuz localamuz = (amuz)paramList.next();
          if (localamuz == null) {
            continue;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", localamuz.jdField_a_of_type_Long);
            localJSONObject.put("groudId", localamuz.jdField_a_of_type_Int);
            localJSONObject.put("index", localamuz.b);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaHelper", 2, "" + localamuz);
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
  
  public static void a(List<aqmf> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static void a(List<aqmf> paramList1, List<aqmf> paramList2)
  {
    Collections.sort(paramList2, new amvd());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      aqmf localaqmf1 = (aqmf)paramList2.next();
      aqmf localaqmf2;
      if (a(localaqmf1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) != j)
      {
        localaqmf2 = new aqmf();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((aqmf)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label101:
            localaqmf2.jdField_a_of_type_JavaLangString = "empty_normal";
            label109:
            paramList1.add(localaqmf2);
            j = a(localaqmf1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority);
            localaqmf1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localaqmf1);
        break;
        ((aqmf)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label101;
        localaqmf2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label109;
        i += 1;
        localaqmf1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((aqmf)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((aqmf)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 4026;
  }
  
  public static boolean a(aqmf paramaqmf)
  {
    if ((paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType == 1) && (!TextUtils.isEmpty(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
      return "qzone_feedlist".equals(paramaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
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
        int i = bfyz.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
        arhi localarhi = (arhi)paramQQAppInterface.getManager(264);
        boolean bool = arnn.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("LebaUtil", 2, "filterPlugin kuolie showEntry = " + bool);
        }
        if ((i == 1) && (localarhi.d()) && (bool)) {}
        for (bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((apsa)paramQQAppInterface.getManager(269)).a();
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
      if (!ajek.a().a(paramQQAppInterface, paramLong)) {
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
  
  public static void b(List<aqmf> paramList, List<Integer> paramList1)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
        Collections.sort(paramList, new amvd());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
      localStringBuilder.append(" us=").append(paramList1);
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new amvd());
      Iterator localIterator = paramList.iterator();
      aqmf localaqmf;
      while (localIterator.hasNext())
      {
        localaqmf = (aqmf)localIterator.next();
        for (;;)
        {
          try
          {
            j = paramList1.indexOf(Integer.valueOf((int)localaqmf.jdField_a_of_type_Long));
            if (j < 0) {
              continue;
            }
            localaqmf.b = j;
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
            continue;
            localStringBuilder.append(",fix ").append(localaqmf.jdField_a_of_type_Long);
          }
          if (localaqmf.c()) {
            continue;
          }
          localArrayList.add(localaqmf);
          break;
          localaqmf.b = 2147483647;
        }
      }
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      Collections.sort(localArrayList, new amve());
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        k = j;
        if (!((aqmf)paramList.get(i)).c())
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
    if (bcoo.a()) {}
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
    if (!"4810".equals(paramQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramQQAppInterface, "4810" }));
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
 * Qualified Name:     amvb
 * JD-Core Version:    0.7.0.1
 */