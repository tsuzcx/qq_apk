package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/RIJXTabConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "account", "", "defaultEnterTabId", "", "getDefaultEnterTabId", "()I", "setDefaultEnterTabId", "(I)V", "enableXTab", "", "redDotExpireTimeInMin", "tabsList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "getTabsList", "()Ljava/util/List;", "setTabsList", "(Ljava/util/List;)V", "generateTabInfo", "tabJsonObject", "Lorg/json/JSONObject;", "getRedDotExpireTimeInMin", "isXTabMode", "loadTabsInfoFromJson", "", "json", "onReceiveConfig", "id", "version", "content", "onWipeConfig", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandler
  extends SimpleConfigHandler
{
  public static final RIJXTabConfigHandler.Companion a;
  private static RIJXTabConfigHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigHandlersRIJXTabConfigHandler;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigHandlersRIJXTabConfigHandler$Companion = new RIJXTabConfigHandler.Companion(null);
  }
  
  private RIJXTabConfigHandler()
  {
    Object localObject1 = ReadInJoyHelper.a();
    int i;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = (String)ReadInJoyHelper.a("x_tab_mode_tabs_info_json", "");
      Object localObject2 = ReadInJoyHelper.a("x_tab_mode_default_tab_id", Integer.valueOf(-1));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ReadInJoyHelper.getReadI…ue(SP_DEFAULT_TAB_ID, -1)");
      this.jdField_a_of_type_Int = ((Number)localObject2).intValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "tabsJson");
      a((String)localObject1);
      QLog.d("RIJXTabConfigHandler", 1, "parseFromSp: tabJson:" + (String)localObject1 + ", defaultId:" + this.jdField_a_of_type_Int);
      if (!TextUtils.equals((CharSequence)"1", (CharSequence)ReadInJoyHelper.a("x_tab_switch_key", "0"))) {
        break label255;
      }
      if (((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty()) {
        break label250;
      }
      i = 1;
      label158:
      if (i == 0) {
        break label255;
      }
    }
    label250:
    label255:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == -1)) {
        this.jdField_a_of_type_Int = ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(0)).mChannelCoverId;
      }
      localObject1 = ReadInJoyHelper.a("x_tab_red_dot_expire_time_in_min", Integer.valueOf(360));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyHelper.getReadI…AULT_EXPIRED_TIME_IN_MIN)");
      this.b = ((Number)localObject1).intValue();
      QLog.d("RIJXTabConfigHandler", 1, toString());
      return;
      localObject1 = "0";
      break;
      i = 0;
      break label158;
    }
  }
  
  private final TabChannelCoverInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      String str2 = paramJSONObject.optString("name");
      int i = paramJSONObject.optInt("id", -1);
      String str1 = URLDecoder.decode(paramJSONObject.optString("url", ""), "UTF-8");
      int j = paramJSONObject.optInt("immersive", 0);
      if ((TextUtils.isEmpty((CharSequence)str2)) || (i == -1)) {
        return null;
      }
      paramJSONObject = new TabChannelCoverInfo(i, str2);
      paramJSONObject.mChannelJumpUrl = str1;
      if (j == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramJSONObject.isImmersive = bool;
        paramJSONObject.isXTabMode = true;
        return paramJSONObject;
      }
    }
    return null;
  }
  
  private final void a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("tabs_info");
        if (paramString == null) {
          continue;
        }
        int i = 0;
        int j = paramString.length();
        while (i < j)
        {
          TabChannelCoverInfo localTabChannelCoverInfo = a(paramString.getJSONObject(i));
          if (localTabChannelCoverInfo != null) {
            this.jdField_a_of_type_JavaUtilList.add(localTabChannelCoverInfo);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("RIJXTabConfigHandler", 1, "load json error, " + paramString);
      }
    }
  }
  
  @JvmStatic
  @NotNull
  public static final RIJXTabConfigHandler b()
  {
    try
    {
      RIJXTabConfigHandler localRIJXTabConfigHandler = jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigHandlersRIJXTabConfigHandler$Companion.a();
      return localRIJXTabConfigHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final List<TabChannelCoverInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final boolean a()
  {
    boolean bool = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("RIJXTabConfigHandler", 2, "isXTabMode,enableXTab=" + this.jdField_a_of_type_Boolean + ",isStudyMode=" + bool);
    }
    return (this.jdField_a_of_type_Boolean) && (!bool);
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    for (;;)
    {
      String str;
      try
      {
        paramString = AladdinParseUtils.a(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
        Iterator localIterator = paramString.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label299;
        }
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        if (str == null) {
          continue;
        }
        switch (str.hashCode())
        {
        case -1793038129: 
          if (!str.equals("tabs_info")) {
            continue;
          }
          ReadInJoyHelper.a("x_tab_mode_tabs_info_json", ((Map.Entry)localObject).getValue());
          break;
        case 41313622: 
          if (!str.equals("red_dot_expire_min")) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        onWipeConfig(paramInt1);
        QLog.e("RIJXTabConfigHandler", 2, "[RIJ4TabConfigHandler]: parse config Error: " + paramString);
        return true;
      }
      Object localObject = ((Map.Entry)localObject).getValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "entry.value");
      ReadInJoyHelper.a("x_tab_red_dot_expire_time_in_min", Integer.valueOf(Integer.parseInt((String)localObject)));
      continue;
      if (str.equals("use_4_tab_mode"))
      {
        ReadInJoyHelper.a("x_tab_switch_key", ((Map.Entry)localObject).getValue());
        continue;
        if (str.equals("default_tab"))
        {
          localObject = ((Map.Entry)localObject).getValue();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "entry.value");
          ReadInJoyHelper.a("x_tab_mode_default_tab_id", Integer.valueOf(Integer.parseInt((String)localObject)));
          continue;
          label299:
          QLog.d("RIJXTabConfigHandler", 1, "receive servlet config: " + paramString);
          return true;
        }
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.a("x_tab_switch_key", "");
    ReadInJoyHelper.a("x_tab_mode_default_tab_id", "");
    ReadInJoyHelper.a("x_tab_mode_tabs_info_json", "");
    ReadInJoyHelper.a("x_tab_red_dot_expire_time_in_min", "");
  }
  
  @NotNull
  public String toString()
  {
    return "enable: " + this.jdField_a_of_type_Boolean + ", tabInfo: " + this.jdField_a_of_type_JavaUtilList + ", defaultEnterTabId: " + this.jdField_a_of_type_Int + ", redDotExpireTimeInMin: " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler
 * JD-Core Version:    0.7.0.1
 */