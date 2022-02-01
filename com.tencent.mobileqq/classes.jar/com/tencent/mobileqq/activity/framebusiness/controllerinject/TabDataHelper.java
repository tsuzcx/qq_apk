package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.TabData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.UserDynamicTab.ModelRule;
import com.tencent.mobileqq.pb.UserDynamicTab.ModelTabId;
import com.tencent.mobileqq.pb.UserDynamicTab.TabData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TabDataHelper
{
  public static final String KEY_TAB_FIRST_NEW_WORLD_RIJ = "KeyTabFirstNewWorldRIJ";
  public static final String KEY_TAB_FIRST_SHOW = "KeyTabFirstShow";
  public static final String KEY_TAB_FIX_NEW_WORLD_RIJ = "KeyTabFixNewWorldRIJ";
  public static final String KEY_TAB_FULL_ADAPT = "KeyTabFullAdapt";
  public static final String KEY_TAB_LOCAL_SWITCH = "KeyTabLocalSwitch";
  public static final String KEY_TAB_RULE = "KeyTabRule";
  public static final String KEY_TAB_SEQUENCE = "KeyTabSequence";
  public static final String KEY_TAB_SWITCH = "KeyTabSwitch";
  public static final String K_TAB_DATA_HELPER_SP = "TabDataHelper_Shared_Prefs";
  public static final String[] TAB_CONFIG_ARRAY = { "CONVERSATION", "GUILD", "NEW_WORLD", "CONTACT", "RIJ", "LEBA" };
  public static final String[] TAB_CONFIG_ARRAY_TEEN = { "CONVERSATION", "CONTACT", "LEBA" };
  public static final String TAB_CONTACT = "CONTACT";
  public static final String TAB_CONVERSATION = "CONVERSATION";
  public static final String TAB_GUILD = "GUILD";
  public static final String TAB_LEBA = "LEBA";
  public static final String TAB_NEW_WORLD = "NEW_WORLD";
  public static final String TAB_RIJ = "RIJ";
  public static final String TAB_SPLIT_KED_CODE = "_";
  public static final String TAB_SPLIT_TAB_CODE = " ";
  public static final String TAG = "TabDataHelper";
  public static final String VALUE_SETTING_BOTTOM_TAB = "0X800BE84";
  public static final String VALUE_SETTING_GUIDE_CLICK = "0X800BE05";
  public static final String VALUE_SETTING_GUIDE_REPORT = "0X800BE04";
  public static final String VALUE_SETTING_NEW_WORLD_CLICK = "0X800BE8A";
  public static final String VALUE_SETTING_NEW_WORLD_REPORT = "0X800BE89";
  public static final String VALUE_SETTING_NONE_CLICK = "0X800BE86";
  public static final String VALUE_SETTING_NONE_REPORT = "0X800BE85";
  public static final String VALUE_SETTING_RIJ_CLICK = "0X800BE88";
  public static final String VALUE_SETTING_RIJ_REPORT = "0X800BE87";
  public static final int VALUE_SWITCH_CLOSE = 3;
  public static final int VALUE_SWITCH_HIDE = 1;
  public static final int VALUE_SWITCH_OPEN = 2;
  public static final int VALUE_SWITCH_UNSPECIFIED = 4;
  
  public static void addTabName(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append(" ");
    }
    paramStringBuilder.append(paramString);
  }
  
  public static void cleanTabFirstShow(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
    paramContext.putString(getTabFirstShowKeyName(paramString), "");
    paramContext.commit();
    paramContext = new StringBuilder();
    paramContext.append("cleanTabFirstShow new uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    QLog.d("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void clearTabLocalSwitch(Context paramContext, String paramString, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashMap.put((String)paramList.next(), Integer.valueOf(4));
    }
    updateTabLocalSwitch(paramContext, paramString, localHashMap);
  }
  
  public static int getModelType()
  {
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      return 3;
    }
    if (QQTheme.isNowSimpleUI()) {
      return 2;
    }
    return 1;
  }
  
  public static String[] getPreviewTabListForSetting(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = transferConfigStringToArray(getTabRuleList(paramContext, paramString1, getModelType()));
      if ((paramContext != null) && (paramContext.length != 0))
      {
        paramString1 = new ArrayList();
        paramArrayOfString = (ArrayList)Arrays.asList(paramArrayOfString);
        paramArrayOfString.add(paramString2);
        int i = 0;
        while (i < paramContext.length)
        {
          paramString2 = paramContext[i];
          int j = 0;
          while (j < paramArrayOfString.size())
          {
            String str = (String)paramArrayOfString.get(j);
            if ((!TextUtils.isEmpty(str)) && (str.equals(paramString2)))
            {
              paramString1.add(str);
              break;
            }
            j += 1;
          }
          i += 1;
        }
        paramContext = (String[])paramString1.toArray(new String[paramString1.size()]);
        paramString1 = new StringBuilder();
        paramString1.append("getPreviewTabListForSetting targetArray: ");
        paramString1.append(paramContext.toString());
        QLog.d("TabDataHelper", 1, paramString1.toString());
        return paramContext;
      }
      QLog.e("TabDataHelper", 1, "getPreviewTabListForSetting wrong: configArray is empty");
      return paramArrayOfString;
    }
    QLog.e("TabDataHelper", 1, "getPreviewTabListForSetting wrong: showingList is empty");
    return paramArrayOfString;
  }
  
  public static long getSequence(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).getLong(getTabSequenceKeyName(paramString), 0L);
  }
  
  public static String getTabFirstNewWorldAndRIJ(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabFirstNewWorldRIJ_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean getTabFirstNewWorldWithRIJOn(Context paramContext, String paramString)
  {
    boolean bool = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).getBoolean(getTabFirstNewWorldAndRIJ(paramString), false);
    paramContext = new StringBuilder();
    paramContext.append("getTabFirstNewWorldWithRIJOn  uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", shouldShowDialog=");
    paramContext.append(bool);
    QLog.d("TabDataHelper", 1, paramContext.toString());
    return bool;
  }
  
  public static String getTabFirstShow(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).getString(getTabFirstShowKeyName(paramString), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTabFirstShow uin=");
    localStringBuilder.append(StringUtil.getSimpleUinForPrint(paramString));
    localStringBuilder.append(", firstShowTab=");
    localStringBuilder.append(paramContext);
    QLog.d("TabDataHelper", 1, localStringBuilder.toString());
    return paramContext;
  }
  
  public static String getTabFirstShowKeyName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabFirstShow_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getTabFixNewWorldAndRIJ(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabFixNewWorldRIJ_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean getTabFixNewWorldWithRIJOn(Context paramContext, String paramString)
  {
    boolean bool = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).getBoolean(getTabFixNewWorldAndRIJ(paramString), false);
    paramContext = new StringBuilder();
    paramContext.append("getTabFixNewWorldWithRIJOn  uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", shouldShowDialog=");
    paramContext.append(bool);
    QLog.d("TabDataHelper", 1, paramContext.toString());
    return bool;
  }
  
  public static String getTabFullAdaptName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabFullAdapt_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static int getTabId(String paramString)
  {
    if ("NEW_WORLD".equals(paramString)) {
      return 1;
    }
    if ("GUILD".equals(paramString)) {
      return 2;
    }
    if ("RIJ".equals(paramString)) {
      return 3;
    }
    return 0;
  }
  
  public static Map<String, Boolean> getTabLocalSwitch(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4);
    HashMap localHashMap = new HashMap();
    putSingleTabLocalSwitch(paramContext, paramString, "GUILD", localHashMap);
    putSingleTabLocalSwitch(paramContext, paramString, "NEW_WORLD", localHashMap);
    putSingleTabLocalSwitch(paramContext, paramString, "RIJ", localHashMap);
    return localHashMap;
  }
  
  public static String getTabLocalSwitchKeyName(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabLocalSwitch");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String getTabName(Integer paramInteger)
  {
    if (paramInteger == null) {
      return "";
    }
    if (1 == paramInteger.intValue()) {
      return "NEW_WORLD";
    }
    if (2 == paramInteger.intValue()) {
      return "GUILD";
    }
    if (3 == paramInteger.intValue()) {
      return "RIJ";
    }
    return "";
  }
  
  public static String getTabRuleKeyName(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabRule");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getTabRuleList(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).getString(getTabRuleKeyName(paramString, paramInt), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTabDataList uin=");
    localStringBuilder.append(StringUtil.getSimpleUinForPrint(paramString));
    localStringBuilder.append(", tabDataList=");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", model=");
    localStringBuilder.append(paramInt);
    QLog.d("TabDataHelper", 1, localStringBuilder.toString());
    return paramContext;
  }
  
  public static String getTabSequenceKeyName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabSequence");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static int getTabSwitch(int paramInt, List<UserDynamicTab.TabData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserDynamicTab.TabData localTabData = (UserDynamicTab.TabData)paramList.next();
      if (paramInt == localTabData.tab_id.get())
      {
        paramInt = localTabData.tab_status.get();
        if (paramInt == 1) {
          return 2;
        }
        if (paramInt == 2) {
          return 3;
        }
      }
    }
    return 1;
  }
  
  public static Map<String, Integer> getTabSwitch(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4);
    int i = localSharedPreferences.getInt(getTabSwitchKeyName(paramString, "GUILD"), -1);
    int j = localSharedPreferences.getInt(getTabSwitchKeyName(paramString, "NEW_WORLD"), -1);
    int k = localSharedPreferences.getInt(getTabSwitchKeyName(paramString, "RIJ"), -1);
    paramContext = new StringBuilder("getTabSwitch uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(",guidValue=");
    paramContext.append(i);
    paramContext.append(",newWoldValue=");
    paramContext.append(j);
    paramContext.append(",rijValue=");
    paramContext.append(k);
    if ((i != -1) && (j != -1) && (k != -1))
    {
      int m = localSharedPreferences.getInt(getTabLocalSwitchKeyName(paramString, "GUILD"), 4);
      int n = localSharedPreferences.getInt(getTabLocalSwitchKeyName(paramString, "NEW_WORLD"), 4);
      int i1 = localSharedPreferences.getInt(getTabLocalSwitchKeyName(paramString, "RIJ"), 4);
      paramContext.append(",guidLocalValue=");
      paramContext.append(m);
      paramContext.append(",newWoldLocalValue=");
      paramContext.append(n);
      paramContext.append(",rijLocalValue=");
      paramContext.append(i1);
      paramString = new HashMap();
      paramString.put("GUILD", Integer.valueOf(mixSwitch(i, m)));
      paramString.put("NEW_WORLD", Integer.valueOf(mixSwitch(j, n)));
      paramString.put("RIJ", Integer.valueOf(mixSwitch(k, i1)));
      QLog.i("TabDataHelper", 1, paramContext.toString());
      return paramString;
    }
    QLog.i("TabDataHelper", 1, paramContext.toString());
    return null;
  }
  
  public static String getTabSwitchKeyName(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyTabSwitch");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static boolean isExtendTabShow(Context paramContext, String paramString1, String paramString2)
  {
    List localList = Arrays.asList(transferConfigStringToArray(getTabRuleList(paramContext, paramString1, getModelType())));
    paramString1 = getTabSwitch(paramContext, paramString1);
    Integer localInteger = Integer.valueOf(1);
    paramContext = paramString1;
    if (paramString1 == null)
    {
      paramContext = new HashMap();
      paramContext.put("GUILD", localInteger);
      paramContext.put("NEW_WORLD", localInteger);
      paramContext.put("RIJ", localInteger);
    }
    boolean bool;
    if ((paramContext.keySet().contains(paramString2)) && (((Integer)paramContext.get(paramString2)).intValue() == 2) && (localList.contains(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext = new StringBuilder();
    paramContext.append("isExtendTabShow businessType: ");
    paramContext.append(paramString2);
    paramContext.append(" show: ");
    paramContext.append(bool);
    QLog.d("TabDataHelper", 1, paramContext.toString());
    return bool;
  }
  
  public static boolean isOnceFetchFromServer(Context paramContext, String paramString)
  {
    return getSequence(paramContext, paramString) != 0L;
  }
  
  public static int mixSwitch(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) || (paramInt1 == 3))
    {
      if (paramInt2 == 2) {
        return paramInt2;
      }
      if (paramInt2 == 3) {
        return paramInt2;
      }
    }
    return paramInt1;
    return paramInt2;
  }
  
  public static void putSingleTabLocalSwitch(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, Map<String, Boolean> paramMap)
  {
    int i = paramSharedPreferences.getInt(getTabLocalSwitchKeyName(paramString1, paramString2), 4);
    if ((i == 2) || (i == 3))
    {
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramMap.put(paramString2, Boolean.valueOf(bool));
    }
  }
  
  public static String[] transferConfigStringToArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TabDataHelper", 1, "transferConfigStringToArray wrong: configStr is empty");
      if (getModelType() == 3) {
        return TAB_CONFIG_ARRAY_TEEN;
      }
      return TAB_CONFIG_ARRAY;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject = TAB_CONFIG_ARRAY;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if ((!"CONVERSATION".equals(localObject)) && (!"CONTACT".equals(localObject)) && (!"LEBA".equals(localObject)))
      {
        if (paramString.contains((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
      else {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static void updateRIJAndQCircleMutual(AppInterface paramAppInterface, String paramString, Context paramContext)
  {
    if ((isExtendTabShow(paramContext, paramString, "RIJ")) && (isExtendTabShow(paramContext, paramString, "NEW_WORLD")))
    {
      String str = getTabFirstShow(paramContext, paramString);
      if ((!TextUtils.isEmpty(str)) && (str.contains("NEW_WORLD")))
      {
        QLog.d("TabDataHelper", 1, "updateRIJAndQCircleMutual firstShow");
        updateTabFirstNewWorldWithRIJOn(paramContext, paramString, true);
      }
      else
      {
        QLog.d("TabDataHelper", 1, "updateRIJAndQCircleMutual fixShow");
        updateTabFixNewWorldWithRIJOn(paramContext, paramString, true);
      }
      paramString = new HashMap();
      paramString.put("RIJ", Integer.valueOf(3));
      updateTabLocalSwitch(BaseApplication.getContext(), paramAppInterface.getCurrentAccountUin(), paramString);
      ThreadManager.excute(new TabDataHelper.1(paramAppInterface), 160, null, true);
    }
  }
  
  public static void updateSequence(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
    paramContext.putLong(getTabSequenceKeyName(paramString), paramLong);
    paramString = new StringBuilder();
    paramString.append("updateSequence sequence=");
    paramString.append(paramLong);
    QLog.i("TabDataHelper", 1, paramString.toString());
    paramContext.commit();
  }
  
  public static void updateTabFirstNewWorldWithRIJOn(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
    paramContext.putBoolean(getTabFirstNewWorldAndRIJ(paramString), paramBoolean);
    paramContext.commit();
    paramContext = new StringBuilder();
    paramContext.append("updateTabFirstNewWorldWithRIJOn new uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", isShowDialog=");
    paramContext.append(paramBoolean);
    QLog.d("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void updateTabFixNewWorldWithRIJOn(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
    paramContext.putBoolean(getTabFixNewWorldAndRIJ(paramString), paramBoolean);
    paramContext.commit();
    paramContext = new StringBuilder();
    paramContext.append("updateTabFixNewWorldWithRIJOn new uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", isShowDialog=");
    paramContext.append(paramBoolean);
    QLog.d("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void updateTabLocalSwitch(Context paramContext, String paramString, HashMap<String, Integer> paramHashMap)
  {
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder("updateTabLocalSwitch uin=");
      localStringBuilder.append(StringUtil.getSimpleUinForPrint(paramString));
      paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Integer)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (localObject != null))
        {
          localStringBuilder.append(",tabName=");
          localStringBuilder.append(str);
          localStringBuilder.append(",switchValue=");
          localStringBuilder.append(localObject);
          paramContext.putInt(getTabLocalSwitchKeyName(paramString, str), ((Integer)localObject).intValue());
        }
      }
      QLog.i("TabDataHelper", 1, localStringBuilder.toString());
      paramContext.commit();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("updateTabLocalSwitch uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(",switchMap isEmpty");
    QLog.i("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void updateTabRuleList(Context paramContext, String paramString, List<UserDynamicTab.ModelRule> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder("updateTabRuleList uin=");
      localStringBuilder1.append(StringUtil.getSimpleUinForPrint(paramString));
      paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (UserDynamicTab.ModelRule)paramList.next();
        int i = ((UserDynamicTab.ModelRule)localObject1).model_type.get();
        localStringBuilder1.append(",mode=");
        localStringBuilder1.append(i);
        Object localObject2 = ((UserDynamicTab.ModelRule)localObject1).tab_id.get();
        StringBuilder localStringBuilder2 = new StringBuilder();
        if (((UserDynamicTab.ModelRule)localObject1).tab_id.isEmpty())
        {
          localStringBuilder1.append(",tab_id=empty");
        }
        else
        {
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = getTabName(Integer.valueOf(((UserDynamicTab.ModelTabId)((Iterator)localObject1).next()).tab_id.get()));
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              addTabName(localStringBuilder2, (String)localObject2);
            }
          }
          localObject1 = localStringBuilder2.toString();
          localStringBuilder1.append(",tabDataList=");
          localStringBuilder1.append(localStringBuilder2.toString());
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramContext.putString(getTabRuleKeyName(paramString, i), (String)localObject1);
          }
        }
      }
      QLog.i("TabDataHelper", 1, localStringBuilder1.toString());
      paramContext.commit();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("updateTabRuleList uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", modelRules isEmpty");
    QLog.i("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void updateTabSwitchByPush(Context paramContext, String paramString, TabData paramTabData)
  {
    if (paramTabData == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("updateTabSwitchBuPush uin=");
      paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
      paramContext.append(", tabDataList  == null");
      QLog.i("TabDataHelper", 1, paramContext.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("updateTabSwitchBuPush uin=");
    localStringBuilder.append(StringUtil.getSimpleUinForPrint(paramString));
    localStringBuilder.append(",id=");
    localStringBuilder.append(paramTabData.a);
    localStringBuilder.append(",status=");
    localStringBuilder.append(paramTabData.b);
    localStringBuilder.append(",firstShow=");
    localStringBuilder.append(paramTabData.c);
    String str = getTabName(Integer.valueOf(paramTabData.a));
    paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4);
    SharedPreferences.Editor localEditor = paramContext.edit();
    int i;
    if (paramTabData.b == 1) {
      i = 2;
    } else if (paramTabData.b == 2) {
      i = 3;
    } else {
      i = 1;
    }
    localEditor.putInt(getTabSwitchKeyName(paramString, str), i);
    if (paramTabData.c)
    {
      paramTabData = paramContext.getString(getTabFirstShowKeyName(paramString), "");
      localStringBuilder.append(",oldFirstShow=");
      localStringBuilder.append(paramTabData);
      paramContext = str;
      if (paramTabData != null) {
        if (paramTabData.isEmpty())
        {
          paramContext = str;
        }
        else if (paramTabData.contains(str))
        {
          paramContext = paramTabData;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append(paramTabData);
          paramContext.append(" ");
          paramContext.append(str);
          paramContext = paramContext.toString();
        }
      }
      localStringBuilder.append(",newFirstShow=");
      localStringBuilder.append(paramContext);
      localEditor.putString(getTabFirstShowKeyName(paramString), paramContext);
    }
    QLog.i("TabDataHelper", 1, localStringBuilder.toString());
    localEditor.commit();
  }
  
  public static void updateTabSwitchFull(Context paramContext, String paramString, List<UserDynamicTab.TabData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder("updateTabSwitchFull uin=");
      localStringBuilder2.append(StringUtil.getSimpleUinForPrint(paramString));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        UserDynamicTab.TabData localTabData = (UserDynamicTab.TabData)localIterator.next();
        localStringBuilder2.append(",id=");
        localStringBuilder2.append(localTabData.tab_id.get());
        localStringBuilder2.append(",status=");
        localStringBuilder2.append(localTabData.tab_status.get());
        localStringBuilder2.append(",firstShow=");
        localStringBuilder2.append(localTabData.first_show.get());
        if (localTabData.first_show.get()) {
          addTabName(localStringBuilder1, getTabName(Integer.valueOf(localTabData.tab_id.get())));
        }
      }
      paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
      paramContext.putInt(getTabSwitchKeyName(paramString, "GUILD"), getTabSwitch(2, paramList));
      paramContext.putInt(getTabSwitchKeyName(paramString, "NEW_WORLD"), getTabSwitch(1, paramList));
      paramContext.putInt(getTabSwitchKeyName(paramString, "RIJ"), getTabSwitch(3, paramList));
      if (localStringBuilder1.length() > 0) {
        paramContext.putString(getTabFirstShowKeyName(paramString), localStringBuilder1.toString());
      }
      QLog.i("TabDataHelper", 1, localStringBuilder2.toString());
      paramContext.commit();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("updateTabSwitchFull uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", tabDataList isEmpty");
    QLog.i("TabDataHelper", 1, paramContext.toString());
  }
  
  public static void updateTabSwitchIncremental(Context paramContext, String paramString, HashMap<String, Integer> paramHashMap)
  {
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder("updateTabSwitchIncremental uin=");
      localStringBuilder.append(StringUtil.getSimpleUinForPrint(paramString));
      paramContext = paramContext.getSharedPreferences("TabDataHelper_Shared_Prefs", 4).edit();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Integer)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (localObject != null))
        {
          localStringBuilder.append(",tabName=");
          localStringBuilder.append(str);
          localStringBuilder.append(",switchValue=");
          localStringBuilder.append(localObject);
          paramContext.putInt(getTabSwitchKeyName(paramString, str), ((Integer)localObject).intValue());
        }
      }
      QLog.i("TabDataHelper", 1, localStringBuilder.toString());
      paramContext.commit();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("updateTabSwitchIncremental uin=");
    paramContext.append(StringUtil.getSimpleUinForPrint(paramString));
    paramContext.append(", tabSwitchMap isEmpty");
    QLog.i("TabDataHelper", 1, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper
 * JD-Core Version:    0.7.0.1
 */