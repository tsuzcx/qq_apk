package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController$init$1", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "onScrollViewItemExposureTriggered", "", "identifier", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerController$init$1
  extends DefaultPTSLiteEventListener
{
  RIJChannelBannerController$init$1(Context paramContext) {}
  
  public void onScrollViewItemExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("avatarStatus");
      paramView = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController);
      if (paramView != null)
      {
        paramPTSComposer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController;
        if (paramString == null) {
          break label50;
        }
      }
    }
    for (;;)
    {
      RIJChannelBannerController.b(paramPTSComposer, paramString, paramHashMap, paramView);
      return;
      paramHashMap = null;
      break;
      label50:
      paramString = "";
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    Object localObject = null;
    QLog.i("RIJChannelBannerController", 1, "[onTapEventTriggered], " + getLogString(paramString, paramHashMap));
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    int i;
    if (paramHashMap != null)
    {
      paramView = (String)paramHashMap.get("jumpUrl");
      if (!TextUtils.isEmpty((CharSequence)paramView)) {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      paramView = localObject;
      if (paramHashMap != null) {
        paramView = (String)paramHashMap.get("avatarStatus");
      }
      if (paramView == null) {
        break label214;
      }
      i = Integer.parseInt(paramView);
      label102:
      if (i == 2) {
        RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController, paramString, 0);
      }
      paramPTSComposer = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController);
      if (paramPTSComposer != null)
      {
        paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController);
        if (paramHashMap == null) {
          break label220;
        }
        paramHashMap = paramHashMap.getJsonData();
        if (paramHashMap == null) {
          break label220;
        }
        label152:
        paramPTSComposer.c(paramHashMap);
      }
      paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController);
      if (paramHashMap != null) {
        RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController, paramHashMap);
      }
      paramHashMap = RIJChannelBannerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController);
      if (paramHashMap != null)
      {
        paramPTSComposer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerController;
        if (paramString == null) {
          break label226;
        }
      }
    }
    for (;;)
    {
      RIJChannelBannerController.a(paramPTSComposer, paramString, paramView, paramHashMap);
      return;
      paramView = null;
      break;
      label214:
      i = 0;
      break label102;
      label220:
      paramHashMap = "";
      break label152;
      label226:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController.init.1
 * JD-Core Version:    0.7.0.1
 */