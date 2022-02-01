package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSStyleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController;", "", "channelId", "", "context", "Landroid/content/Context;", "channelBannerView", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "(ILandroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;)V", "channelBannerInfo", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "getChannelBannerView", "()Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "setChannelBannerView", "(Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;)V", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsUpdateDataListener", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "ptsliteEventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "rijChannelBannerReport", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport;", "clickBannerCard", "", "clickBannerItem", "uin", "", "avatarStatus", "destroy", "exposeBannerCard", "exposeBannerItem", "exposeChannelBanner", "init", "rijChannelBannerView", "loadChannelBannerView", "refreshChannelBannerView", "reportData", "requestChannelBannerData", "setChannelBannerVisible", "visible", "", "updateAvatarStatus", "identifier", "newAvatarStatus", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerController
{
  public static final RIJChannelBannerController.Companion a;
  private final int jdField_a_of_type_Int;
  private RIJChannelBannerModule.ChannelBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo;
  private final RIJChannelBannerReport jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport = new RIJChannelBannerReport();
  @Nullable
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private final PTSComposer.IPTSUpdateDataListener jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = (PTSComposer.IPTSUpdateDataListener)new RIJChannelBannerController.ptsUpdateDataListener.1(this);
  private PTSComposer jdField_a_of_type_ComTencentPtsCorePTSComposer;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController$Companion = new RIJChannelBannerController.Companion(null);
  }
  
  public RIJChannelBannerController(int paramInt, @NotNull Context paramContext, @Nullable RIJChannelBannerView paramRIJChannelBannerView)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt, paramContext, paramRIJChannelBannerView);
  }
  
  private final void a(int paramInt, Context paramContext, RIJChannelBannerView paramRIJChannelBannerView)
  {
    if (!RIJChannelBannerUtil.a.a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = paramRIJChannelBannerView;
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = ((IPTSLiteEventListener)new RIJChannelBannerController.init.1(this, paramContext));
    paramContext = ReadInJoyUtils.a();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramContext = (ReadInJoyLogicManager)((QQAppInterface)paramContext).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (paramContext != null)
    {
      paramContext = paramContext.a();
      if (paramContext != null)
      {
        paramContext = paramContext.a();
        if (paramContext != null)
        {
          paramContext = paramContext.a(paramInt);
          label92:
          if (paramContext == null) {
            break label132;
          }
          if (((Collection)paramContext).isEmpty()) {
            break label134;
          }
        }
      }
    }
    label132:
    label134:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo = ((RIJChannelBannerModule.ChannelBannerInfo)paramContext.get(0));
      }
      return;
      paramContext = null;
      break label92;
      break;
    }
  }
  
  private final void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("RIJChannelBannerController", 1, "[updateAvatarStatus] identifier is empty.");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localObject != null) {
      localObject = ((PTSComposer)localObject).getJsonData();
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject1 = new JSONObject((String)localObject);
        localJSONArray = localJSONObject1.optJSONArray("subscribers");
        if (localJSONArray == null) {
          break label207;
        }
        i = localJSONArray.length();
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        JSONObject localJSONObject2;
        CharSequence localCharSequence;
        QLog.e("RIJChannelBannerController", 1, "[updateAvatarStatus] failed, e = " + paramString);
        return;
      }
      if (j < i)
      {
        localJSONObject2 = localJSONArray.optJSONObject(j);
        localCharSequence = (CharSequence)paramString;
        if (localJSONObject2 != null)
        {
          localObject = localJSONObject2.getString("uin");
          if (!TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
            break label218;
          }
          localJSONObject2.put("avatar_status", paramInt);
          QLog.i("RIJChannelBannerController", 1, "[updateAvatarStatus] succeed, identifier = " + paramString);
        }
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
        if (paramString == null) {
          break;
        }
        paramString.setData(localJSONObject1.toString());
        return;
        localObject = null;
        continue;
        label207:
        i = 0;
        break label227;
      }
      localObject = null;
      continue;
      label218:
      j += 1;
      continue;
      label227:
      int j = 0;
    }
  }
  
  private final void a(String paramString1, String paramString2, RIJChannelBannerModule.ChannelBannerInfo paramChannelBannerInfo)
  {
    RIJChannelBannerReport.R5Builder localR5Builder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo);
    localR5Builder.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramChannelBannerInfo = "1";
      localR5Builder.a("is_live", paramChannelBannerInfo);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label109;
      }
    }
    label109:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localR5Builder.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.c()).put(paramString1, localR5Builder);
      return;
      paramChannelBannerInfo = "0";
      break;
    }
  }
  
  private final void b(RIJChannelBannerModule.ChannelBannerInfo paramChannelBannerInfo)
  {
    QLog.i("RIJChannelBannerController", 1, "[exposeBannerCard] channelBannerInfo = " + paramChannelBannerInfo);
    if (!TextUtils.isEmpty((CharSequence)paramChannelBannerInfo.a())) {
      ((Map)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a()).put(paramChannelBannerInfo.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo));
    }
  }
  
  private final void b(String paramString1, String paramString2, RIJChannelBannerModule.ChannelBannerInfo paramChannelBannerInfo)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] uin = " + paramString1 + ", avatarStatus = " + paramString2);
    RIJChannelBannerReport.R5Builder localR5Builder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo);
    localR5Builder.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramChannelBannerInfo = "1";
      localR5Builder.a("is_live", paramChannelBannerInfo);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label145;
      }
    }
    label145:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localR5Builder.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.d()).put(paramString1, localR5Builder);
      return;
      paramChannelBannerInfo = "0";
      break;
    }
  }
  
  private final void c(RIJChannelBannerModule.ChannelBannerInfo paramChannelBannerInfo)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] channelBannerInfo = " + paramChannelBannerInfo);
    if (!TextUtils.isEmpty((CharSequence)paramChannelBannerInfo.a())) {
      ((Map)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.b()).put(paramChannelBannerInfo.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo));
    }
  }
  
  @Nullable
  public final RIJChannelBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  }
  
  public final void a()
  {
    QLog.i("RIJChannelBannerController", 1, "[RIJChannelBannerController] destroy.");
    PTSComposer localPTSComposer = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localPTSComposer != null) {
      localPTSComposer.destroy();
    }
  }
  
  public final void a(@NotNull RIJChannelBannerModule.ChannelBannerInfo paramChannelBannerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramChannelBannerInfo, "channelBannerInfo");
    if (!RIJChannelBannerUtil.a.a(this.jdField_a_of_type_Int)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramChannelBannerInfo.b();
      String str = PTSStyleManager.a().a("default_feeds", (String)localObject);
      QLog.i("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName = " + (String)localObject);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty((CharSequence)str)))
      {
        QLog.e("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName or frameTreeJson is empty.");
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo = paramChannelBannerInfo;
      b(paramChannelBannerInfo);
      PTSComposer localPTSComposer = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
      if (localPTSComposer != null) {
        localPTSComposer.destroy();
      }
      paramChannelBannerInfo = PTSComposer.buildComposer((String)localObject, str, paramChannelBannerInfo.c(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    } while (localObject == null);
    ((RIJChannelBannerView)localObject).post((Runnable)new RIJChannelBannerController.refreshChannelBannerView.1(this, paramChannelBannerInfo));
  }
  
  public final void a(boolean paramBoolean)
  {
    QLog.i("RIJChannelBannerController", 1, "[setChannelBannerViewVisibility], visible = " + paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    if (localObject != null)
    {
      localObject = ((RIJChannelBannerView)localObject).a();
      if (localObject != null) {
        if (!paramBoolean) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 0;; i = 8)
    {
      ((PTSItemView)localObject).setVisibility(i);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo = ((RIJChannelBannerModule.ChannelBannerInfo)null);
      }
      return;
    }
  }
  
  public final void b()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicEngine)localObject).a();
        if (localObject != null) {
          ((RIJChannelBannerModule)localObject).a(this.jdField_a_of_type_Int, 1);
        }
      }
    }
  }
  
  public final void c()
  {
    RIJChannelBannerModule.ChannelBannerInfo localChannelBannerInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo;
    if (localChannelBannerInfo != null) {
      a(localChannelBannerInfo);
    }
  }
  
  public final void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerReport.a();
  }
  
  public final void e()
  {
    RIJChannelBannerModule.ChannelBannerInfo localChannelBannerInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$ChannelBannerInfo;
    if (localChannelBannerInfo != null) {
      b(localChannelBannerInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController
 * JD-Core Version:    0.7.0.1
 */