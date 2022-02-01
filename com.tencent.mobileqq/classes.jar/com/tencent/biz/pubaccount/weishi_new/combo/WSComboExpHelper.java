package com.tencent.biz.pubaccount.weishi_new.combo;

import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherUtil;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushUtil;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboExpHelper;", "", "()V", "TAG", "", "getBottomBarInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "getBottomSelectedBarId", "getComboPolicyValue", "key", "default", "isBottomSelectedBarIdImmersion", "", "isBottomSelectedBarIdWaterfall", "isComboFeatureOpen", "isForceSelectWaterfall", "selectedBarId", "isValidSelectedBarId", "bottomBarId", "parseBarInfoJson", "position", "", "barInfoJson", "Lorg/json/JSONObject;", "parseBarInfoStr", "barInfoStr", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboExpHelper
{
  public static final WSComboExpHelper a = new WSComboExpHelper();
  
  private final WSBottomBarInfo a(int paramInt, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = paramJSONObject.optString("id");
    int i = paramJSONObject.optInt("type");
    String str2 = paramJSONObject.optString("title");
    String str1 = paramJSONObject.optString("image");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "barId");
    Intrinsics.checkExpressionValueIsNotNull(str2, "barName");
    paramString = new WSBottomBarInfo(paramInt, (String)localObject, paramString, i, str2);
    Intrinsics.checkExpressionValueIsNotNull(str1, "barIconUrl");
    paramString.a(str1);
    if (Intrinsics.areEqual(localObject, "publish"))
    {
      localObject = WSPublisherUtil.a;
      paramJSONObject = paramJSONObject.optString("schema");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "optString(WSExpConstant.ParamKey.SCHEMA)");
      ((WSPublisherUtil)localObject).a(paramJSONObject);
    }
    return paramString;
  }
  
  private final List<WSBottomBarInfo> a(String paramString1, String paramString2)
  {
    List localList = (List)new ArrayList();
    if (StringsKt.isBlank((CharSequence)paramString1)) {
      return localList;
    }
    Object localObject = (JSONArray)null;
    try
    {
      paramString1 = new JSONArray(paramString1);
    }
    catch (Exception paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSComboExpHelper.kt][parseBarInfoStr] e:");
      localStringBuilder.append(paramString1.getLocalizedMessage());
      WSLog.d("WSComboExpHelperLog", localStringBuilder.toString());
      paramString1 = (String)localObject;
    }
    if (paramString1 != null)
    {
      int i = 0;
      int j = paramString1.length();
      while (i < j)
      {
        localObject = paramString1.optJSONObject(i);
        if (localObject != null) {
          localList.add(a.a(i, (JSONObject)localObject, paramString2));
        }
        i += 1;
      }
    }
    return localList;
  }
  
  private final boolean a(String paramString)
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.g();
    boolean bool3 = WSPushUtil.c(localWSRedDotPushMsg);
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      bool1 = bool2;
      if ((Intrinsics.areEqual(paramString, "waterfall_tab") ^ true))
      {
        bool1 = bool2;
        if ((Intrinsics.areEqual(paramString, "monofeed_tab") ^ true)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((!WSPushUtil.a(localWSRedDotPushMsg)) && (!WSPushUtil.b(localWSRedDotPushMsg)))
    {
      paramString = WSPublicAccReport.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "WSPublicAccReport.getInstance()");
      if (!Intrinsics.areEqual(paramString.getEnterPublicAccFrom(), "from_open_home_then_video")) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private final String b(String paramString)
  {
    return b(paramString, "");
  }
  
  private final String b(String paramString1, String paramString2)
  {
    Object localObject = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSExpABTestManager.getInstance()");
    localObject = ((WSExpABTestManager)localObject).z();
    if (localObject != null)
    {
      paramString1 = (String)((Map)localObject).get(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
      return paramString2;
    }
    return paramString2;
  }
  
  private final boolean c(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 194805079: 
      if (!paramString.equals("monofeed_tab")) {
        break label98;
      }
      break;
    case -710258968: 
      if (!paramString.equals("waterfall_tab")) {
        break label98;
      }
      break;
    case -872770723: 
    case -1059699070: 
      if ((!paramString.equals("message_tab")) || ((goto 96) && (!paramString.equals("my_tab")))) {
        break label98;
      }
    }
    return true;
    label98:
    return false;
  }
  
  public final boolean a()
  {
    return Intrinsics.areEqual("1", b("switch"));
  }
  
  @NotNull
  public final String b()
  {
    Object localObject = "waterfall_tab";
    String str = b("selected_bar", "waterfall_tab");
    if (c(str))
    {
      if (a(str)) {
        return "waterfall_tab";
      }
      localObject = str;
    }
    return localObject;
  }
  
  @NotNull
  public final List<WSBottomBarInfo> c()
  {
    String str = b();
    return a(b("bar_infos"), str);
  }
  
  public final boolean d()
  {
    return Intrinsics.areEqual(b(), "monofeed_tab");
  }
  
  public final boolean e()
  {
    return Intrinsics.areEqual(b(), "waterfall_tab");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper
 * JD-Core Version:    0.7.0.1
 */