package com.tencent.comic.hippy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.ComicCancelRedPointPopIntercetorParams;
import com.tencent.comic.data.ComicTechReportParams;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.comic.data.VipComicHippyBounceRateHelper;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.comic.ui.ComicCancelRedPointPopDialog;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VipComicHippyFragment
  extends CommonHippyFragment
{
  private static final String TAG = "VipComicHippyFragment";
  private boolean backEventInterceptChecked = false;
  private boolean backEventIntercepted = false;
  private boolean hasRedDot = false;
  private Context mDialogContext = null;
  private long mLastTouchUpTime = 0L;
  private boolean reportedBounceRate = false;
  
  private boolean checkHasRedDot()
  {
    try
    {
      boolean bool = TextUtils.equals("1", (String)((SerializableMap)getParameters().getSerializable("js_param_map")).getMap().get("hasRedDot"));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label31:
      break label31;
    }
    return false;
  }
  
  private boolean interceptedBackEvent()
  {
    if (!isComicMainPage()) {
      return false;
    }
    if (this.backEventInterceptChecked) {
      return false;
    }
    this.backEventInterceptChecked = true;
    Object localObject = this.mHippyQQEngine;
    if (localObject == null) {
      return false;
    }
    localObject = ((HippyQQEngine)localObject).getHippyEngine();
    if (localObject == null) {
      return false;
    }
    ComicCancelRedPointPopIntercetorParams localComicCancelRedPointPopIntercetorParams = new ComicCancelRedPointPopIntercetorParams();
    localComicCancelRedPointPopIntercetorParams.a = this.hasRedDot;
    localComicCancelRedPointPopIntercetorParams.b = VipComicHippyBounceRateHelper.a(localObject.hashCode(), 12);
    localComicCancelRedPointPopIntercetorParams.c = VipComicHippyBounceRateHelper.a(localObject.hashCode(), 13);
    localComicCancelRedPointPopIntercetorParams.d = this.mLastTouchUpTime;
    if (ComicHippyBackEventInterceptorProxy.INSTANCE.canShowCancelRedPoinDialog(localComicCancelRedPointPopIntercetorParams))
    {
      showBackPopDialog();
      return true;
    }
    return false;
  }
  
  private boolean isComicMainPage()
  {
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    return (localHippyQQPreloadEngine != null) && (TextUtils.isEmpty(localHippyQQPreloadEngine.getPageUrl()));
  }
  
  private void reportBounceRate()
  {
    if (!isComicMainPage()) {
      return;
    }
    if (this.reportedBounceRate) {
      return;
    }
    int j = 1;
    this.reportedBounceRate = true;
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    if (localHippyQQPreloadEngine == null) {
      return;
    }
    Object localObject1 = localHippyQQPreloadEngine.getHippyEngine();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = getPerformanceData();
    if (((HashMap)localObject2).containsKey("openPageStart")) {
      VipComicHippyBounceRateHelper.a(localObject1.hashCode(), 1, ((Long)((HashMap)localObject2).get("openPageStart")).longValue());
    }
    if (((HashMap)localObject2).containsKey("loadModuleStart")) {
      VipComicHippyBounceRateHelper.a(localObject1.hashCode(), 2, ((Long)((HashMap)localObject2).get("loadModuleStart")).longValue());
    }
    long l3 = VipComicHippyBounceRateHelper.a(localObject1.hashCode(), 1);
    int i = 0;
    while (i < VipComicHippyBounceRateHelper.a.size())
    {
      int k = ((Integer)VipComicHippyBounceRateHelper.a.get(i)).intValue();
      if (VipComicHippyBounceRateHelper.b(localObject1.hashCode(), k))
      {
        l1 = VipComicHippyBounceRateHelper.a(localObject1.hashCode(), k);
        i = k;
        break label196;
      }
      i += 1;
    }
    long l1 = l3;
    i = j;
    label196:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportHippyBounceRate:");
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("clickTime:");
      ((StringBuilder)localObject1).append(l3);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("finalStatus:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("finalStatusTime:");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("hasRedDot:");
      ((StringBuilder)localObject1).append(this.hasRedDot);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("moduleVersion:");
      ((StringBuilder)localObject1).append(localHippyQQPreloadEngine.getModuleVersion());
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("moduleName:");
      ((StringBuilder)localObject1).append(localHippyQQPreloadEngine.getModuleName());
      ((StringBuilder)localObject1).append("\n");
      QLog.d("VipComicHippyFragment", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ComicTechReportParams();
    ((ComicTechReportParams)localObject1).a = "qqcomic_web";
    ((ComicTechReportParams)localObject1).b = "page_break";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localHippyQQPreloadEngine.getModuleName());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(localHippyQQPreloadEngine.getModuleVersion());
    ((ComicTechReportParams)localObject1).c = ((StringBuilder)localObject2).toString();
    ((ComicTechReportParams)localObject1).k = 2L;
    long l2;
    if (this.hasRedDot) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    ((ComicTechReportParams)localObject1).l = l2;
    ((ComicTechReportParams)localObject1).m = i;
    ((ComicTechReportParams)localObject1).n = (l1 - l3);
    ((ComicTechReportParams)localObject1).o = (System.currentTimeMillis() - l3);
    ((ComicTechReportParams)localObject1).t = HttpUtil.getNetWorkTypeContain5G();
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportTechReport2021(((ComicTechReportParams)localObject1).toString());
  }
  
  private void reportDialogDismiss(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      VipComicDC01327ReportData localVipComicDC01327ReportData = new VipComicDC01327ReportData().a("2000").b("2").c("201124");
      ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(localVipComicDC01327ReportData);
    }
  }
  
  private void showBackPopDialog()
  {
    List localList = ComicHippyBackEventInterceptorProxy.INSTANCE.getValidCancelRedPointDialogData();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      this.backEventIntercepted = true;
      ComicCancelRedPointPopDialog localComicCancelRedPointPopDialog = new ComicCancelRedPointPopDialog(this.mDialogContext, getActivity(), 1996947456);
      localComicCancelRedPointPopDialog.a(localList);
      localComicCancelRedPointPopDialog.setOnDismissListener(new VipComicHippyFragment.1(this, localComicCancelRedPointPopDialog));
      ComicHippyBackEventInterceptorProxy.INSTANCE.recordDialogShowTime();
      localComicCancelRedPointPopDialog.show();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.mLastTouchUpTime = System.currentTimeMillis();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    reportBounceRate();
    if (this.backEventIntercepted) {
      return false;
    }
    if (interceptedBackEvent()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.reportedBounceRate = false;
    this.hasRedDot = checkHasRedDot();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mDialogContext = paramViewGroup.getContext();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    reportBounceRate();
    Object localObject = this.mHippyQQEngine;
    if (localObject != null)
    {
      localObject = ((HippyQQEngine)localObject).getHippyEngine();
      if (localObject != null) {
        VipComicHippyBounceRateHelper.a(localObject.hashCode());
      }
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.VipComicHippyFragment
 * JD-Core Version:    0.7.0.1
 */