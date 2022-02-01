package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.gamecenter.wadl.biz.entity.WadlResult;>;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallbackImpl;", "Lcom/tencent/open/downloadnew/DownloadListener;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "callback", "Landroid/webkit/ValueCallback;", "", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;Landroid/webkit/ValueCallback;)V", "getCallback", "()Landroid/webkit/ValueCallback;", "getData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "installSucceed", "", "appid", "", "packageName", "onDownloadCancel", "info", "Lcom/tencent/open/downloadnew/DownloadInfo;", "onDownloadError", "errorCode", "errorMsg", "state", "onDownloadFinish", "onDownloadPause", "onDownloadUpdate", "infos", "", "onDownloadWait", "onQueryCallback", "wadlResults", "Ljava/util/ArrayList;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "onQueryCallbackVia", "onReceiveYYBInstall", "url", "sourceId", "onWadlTaskStatusChanged", "wadlResult", "packageReplaced", "uninstallSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdDownloadCallbackImpl
  implements WadlProxyServiceCallBackInterface, DownloadListener
{
  @NotNull
  private final ValueCallback<Integer> jdField_a_of_type_AndroidWebkitValueCallback;
  @NotNull
  private final ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  
  public void installSucceed(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(1));
  }
  
  public void onDownloadCancel(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(7));
  }
  
  public void onDownloadError(@Nullable DownloadInfo paramDownloadInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(6));
  }
  
  public void onDownloadFinish(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(5));
  }
  
  public void onDownloadPause(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(4));
  }
  
  public void onDownloadUpdate(@Nullable List<DownloadInfo> paramList)
  {
    Object localObject;
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (!localIterator.hasNext()) {
        break label90;
      }
      localObject = localIterator.next();
      String str = ((DownloadInfo)localObject).d;
      paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (paramList == null) {
        break label85;
      }
      paramList = paramList.c;
      label53:
      if (!Intrinsics.areEqual(str, paramList)) {
        break label88;
      }
    }
    label85:
    label88:
    label90:
    for (paramList = localObject;; paramList = null)
    {
      if ((DownloadInfo)paramList != null) {
        this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(3));
      }
      return;
      paramList = null;
      break label53;
      break;
    }
  }
  
  public void onDownloadWait(@Nullable DownloadInfo paramDownloadInfo) {}
  
  public void onQueryCallback(@Nullable ArrayList<WadlResult> paramArrayList)
  {
    Object localObject2 = null;
    Object localObject4;
    Object localObject3;
    label55:
    Object localObject1;
    if (paramArrayList != null)
    {
      localObject4 = ((Iterable)paramArrayList).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = ((Iterator)localObject4).next();
        paramArrayList = ((WadlResult)localObject3).a;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.e;
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
          if (localObject1 == null) {
            break label210;
          }
          localObject1 = ((ADVideoAppDownloadData)localObject1).c;
          label73:
          if (!Intrinsics.areEqual(paramArrayList, localObject1)) {
            break label214;
          }
          paramArrayList = (ArrayList<WadlResult>)localObject3;
        }
      }
    }
    label85:
    for (paramArrayList = (WadlResult)paramArrayList;; paramArrayList = null)
    {
      if (paramArrayList == null) {
        break label226;
      }
      localObject1 = paramArrayList.a.f;
      int i = RIJAdDownloadStateUtil.a.a(paramArrayList);
      int j = paramArrayList.d;
      localObject3 = new AdDownloadInfo();
      ((AdDownloadInfo)localObject3).a((String)localObject1);
      localObject4 = paramArrayList.a;
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((WadlParams)localObject4).a;
      }
      ((AdDownloadInfo)localObject3).c((String)localObject1);
      ((AdDownloadInfo)localObject3).a(i);
      ((AdDownloadInfo)localObject3).b(j);
      ((AdDownloadInfo)localObject3).d(paramArrayList.jdField_b_of_type_JavaLangString);
      RIJAdDownloadExKt.a((AdDownloadInfo)localObject3);
      this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(((AdDownloadInfo)localObject3).a()));
      return;
      paramArrayList = null;
      break label55;
      localObject1 = null;
      break label73;
      label214:
      break;
      paramArrayList = null;
      break label85;
    }
    label210:
    label226:
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
  }
  
  public void onQueryCallbackVia(@Nullable ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(@Nullable WadlResult paramWadlResult)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (paramWadlResult != null)
    {
      localObject1 = paramWadlResult.a;
      if (localObject1 != null)
      {
        localObject1 = ((WadlParams)localObject1).f;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
          if (localObject2 == null) {
            break label61;
          }
          localObject2 = ((ADVideoAppDownloadData)localObject2).d;
          label45:
          if (!(Intrinsics.areEqual(localObject1, localObject2) ^ true)) {
            break label66;
          }
        }
      }
    }
    label61:
    label66:
    label85:
    label89:
    label93:
    label101:
    do
    {
      return;
      break label101;
      localObject1 = null;
      break;
      localObject2 = null;
      break label45;
      localObject1 = localObject3;
      if (paramWadlResult != null) {
        localObject1 = Integer.valueOf(paramWadlResult.jdField_b_of_type_Int);
      }
      if (localObject1 == null)
      {
        if (localObject1 != null) {
          break label151;
        }
        if (localObject1 != null) {
          break label174;
        }
        if (localObject1 != null) {
          break label196;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          if ((localObject1 == null) || (((Integer)localObject1).intValue() != 7)) {
            break;
          }
          this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(6));
          return;
          if (((Integer)localObject1).intValue() != 4) {
            break label85;
          }
          this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(3));
          return;
          if (((Integer)localObject1).intValue() != 6) {
            break label89;
          }
          this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(5));
          return;
          if (((Integer)localObject1).intValue() != 5) {
            break label93;
          }
          this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(4));
          return;
          if (((Integer)localObject1).intValue() == 9)
          {
            this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(1));
            return;
          }
        }
      }
    } while (((Integer)localObject1).intValue() != 10);
    label151:
    label174:
    label196:
    this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(1));
  }
  
  public void packageReplaced(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public void uninstallSucceed(@Nullable String paramString1, @Nullable String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallbackImpl
 * JD-Core Version:    0.7.0.1
 */