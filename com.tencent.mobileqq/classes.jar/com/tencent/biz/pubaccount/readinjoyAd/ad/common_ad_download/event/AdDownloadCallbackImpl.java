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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallbackImpl;", "Lcom/tencent/open/downloadnew/DownloadListener;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "callback", "Landroid/webkit/ValueCallback;", "", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;Landroid/webkit/ValueCallback;)V", "getCallback", "()Landroid/webkit/ValueCallback;", "getData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "installSucceed", "", "appid", "", "packageName", "onDownloadCancel", "info", "Lcom/tencent/open/downloadnew/DownloadInfo;", "onDownloadError", "errorCode", "errorMsg", "state", "onDownloadFinish", "onDownloadPause", "onDownloadUpdate", "infos", "", "onDownloadWait", "onQueryCallback", "wadlResults", "Ljava/util/ArrayList;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "onQueryCallbackVia", "onWadlTaskStatusChanged", "wadlResult", "packageReplaced", "uninstallSucceed", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdDownloadCallbackImpl
  implements WadlProxyServiceCallBackInterface, DownloadListener
{
  @NotNull
  private final ValueCallback<Integer> a;
  @NotNull
  private final ADVideoAppDownloadData b;
  
  public void a(@Nullable WadlResult paramWadlResult)
  {
    Object localObject3 = null;
    if (paramWadlResult != null)
    {
      localObject1 = paramWadlResult.a;
      if (localObject1 != null)
      {
        localObject1 = ((WadlParams)localObject1).m;
        break label26;
      }
    }
    Object localObject1 = null;
    label26:
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = this.b;
      if (localObject2 != null) {
        localObject2 = ((ADVideoAppDownloadData)localObject2).d;
      } else {
        localObject2 = null;
      }
      if ((Intrinsics.areEqual(localObject1, localObject2) ^ true)) {
        return;
      }
      localObject1 = localObject3;
      if (paramWadlResult != null) {
        localObject1 = Integer.valueOf(paramWadlResult.d);
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 4))
      {
        this.a.onReceiveValue(Integer.valueOf(3));
        return;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 6))
      {
        this.a.onReceiveValue(Integer.valueOf(5));
        return;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 5))
      {
        this.a.onReceiveValue(Integer.valueOf(4));
        return;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 9))
      {
        this.a.onReceiveValue(Integer.valueOf(1));
        return;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 10))
      {
        this.a.onReceiveValue(Integer.valueOf(1));
        return;
      }
      if (localObject1 == null) {
        return;
      }
      if (((Integer)localObject1).intValue() == 7) {
        this.a.onReceiveValue(Integer.valueOf(6));
      }
    }
  }
  
  public void a(@Nullable ArrayList<WadlResult> paramArrayList)
  {
    Object localObject2 = null;
    Object localObject4;
    Object localObject3;
    Object localObject1;
    if (paramArrayList != null)
    {
      localObject4 = ((Iterable)paramArrayList).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = ((Iterator)localObject4).next();
        paramArrayList = ((WadlResult)localObject3).a;
        if (paramArrayList != null) {
          paramArrayList = paramArrayList.k;
        } else {
          paramArrayList = null;
        }
        localObject1 = this.b;
        if (localObject1 != null) {
          localObject1 = ((ADVideoAppDownloadData)localObject1).c;
        } else {
          localObject1 = null;
        }
        if (Intrinsics.areEqual(paramArrayList, localObject1))
        {
          paramArrayList = (ArrayList<WadlResult>)localObject3;
          break label101;
        }
      }
      paramArrayList = null;
      label101:
      paramArrayList = (WadlResult)paramArrayList;
    }
    else
    {
      paramArrayList = null;
    }
    if (paramArrayList != null)
    {
      localObject1 = paramArrayList.a.m;
      int i = RIJAdDownloadStateUtil.a.a(paramArrayList);
      int j = paramArrayList.k;
      localObject3 = new AdDownloadInfo();
      ((AdDownloadInfo)localObject3).a((String)localObject1);
      localObject4 = paramArrayList.a;
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((WadlParams)localObject4).e;
      }
      ((AdDownloadInfo)localObject3).c((String)localObject1);
      ((AdDownloadInfo)localObject3).a(i);
      ((AdDownloadInfo)localObject3).b(j);
      ((AdDownloadInfo)localObject3).d(paramArrayList.g);
      RIJAdDownloadExKt.a((AdDownloadInfo)localObject3);
      this.a.onReceiveValue(Integer.valueOf(((AdDownloadInfo)localObject3).b()));
      return;
    }
    this.a.onReceiveValue(Integer.valueOf(0));
  }
  
  public void b(@Nullable ArrayList<WadlResult> paramArrayList) {}
  
  public void installSucceed(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a.onReceiveValue(Integer.valueOf(1));
  }
  
  public void onDownloadCancel(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.a.onReceiveValue(Integer.valueOf(7));
  }
  
  public void onDownloadError(@Nullable DownloadInfo paramDownloadInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    this.a.onReceiveValue(Integer.valueOf(6));
  }
  
  public void onDownloadFinish(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.a.onReceiveValue(Integer.valueOf(5));
  }
  
  public void onDownloadPause(@Nullable DownloadInfo paramDownloadInfo)
  {
    this.a.onReceiveValue(Integer.valueOf(4));
  }
  
  public void onDownloadUpdate(@Nullable List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      Object localObject;
      String str;
      do
      {
        boolean bool = localIterator.hasNext();
        paramList = null;
        if (!bool) {
          break;
        }
        localObject = localIterator.next();
        str = ((DownloadInfo)localObject).d;
        ADVideoAppDownloadData localADVideoAppDownloadData = this.b;
        if (localADVideoAppDownloadData != null) {
          paramList = localADVideoAppDownloadData.c;
        }
      } while (!Intrinsics.areEqual(str, paramList));
      paramList = localObject;
      break label79;
      paramList = null;
      label79:
      if ((DownloadInfo)paramList != null) {
        this.a.onReceiveValue(Integer.valueOf(3));
      }
    }
  }
  
  public void onDownloadWait(@Nullable DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public void uninstallSucceed(@Nullable String paramString1, @Nullable String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallbackImpl
 * JD-Core Version:    0.7.0.1
 */