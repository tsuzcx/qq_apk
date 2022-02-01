package com.tencent.biz.pubaccount.readinjoy.video;

import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsDiversionHandler;", "", "()V", "columnBarPriority", "", "gameAdPriority", "goodsSoftAdPriority", "normalSoftAdPriority", "shuntBarPriority", "strongShuntBarPriority", "topbarPriority", "ugBarPriority", "clearFooterDiversion", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "clearHeaderDiversion", "handleDiversionPriority", "holder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "isSoftAdWhiteList", "", "sourceId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsDiversionHandler
{
  private static final int a;
  public static final VideoFeedsDiversionHandler a;
  private static final int b;
  private static final int c;
  private static final int d;
  private static final int e;
  private static final int f;
  private static final int g;
  private static final int h;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsDiversionHandler = new VideoFeedsDiversionHandler();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(362);
    jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("up_kol_goods_soft_ad", 0);
    b = localAladdinConfig.getIntegerFromString("up_kd_shunt_bar", 1);
    c = localAladdinConfig.getIntegerFromString("up_topbar", 2);
    d = localAladdinConfig.getIntegerFromString("up_not_kol_soft_ad", 3);
    e = localAladdinConfig.getIntegerFromString("up_game_ad", 4);
    f = localAladdinConfig.getIntegerFromString("ug_bar", 5);
    g = localAladdinConfig.getIntegerFromString("bigBubble", 0);
    h = localAladdinConfig.getIntegerFromString("column_bar", 1);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsDiversionHandler", 2, "config=" + localAladdinConfig + ' ');
    }
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = Aladdin.getConfig(407).getString("soft_ad_source_id_list", "3,7,8,9");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "config.getString(\"soft_a…ource_id_list\",\"3,7,8,9\")");
    localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "," }, false, 0, 6, null);
    try
    {
      localObject = ((List)localObject).iterator();
      int i;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = Integer.parseInt((String)((Iterator)localObject).next());
      } while (i != paramInt);
      boolean bool1 = true;
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private final void b(VideoInfo paramVideoInfo)
  {
    Object localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject != null) {
      ((AdvertisementInfo)localObject).mAdvertisementSoftInfo = ((AdvertisementSoftInfo)null);
    }
    localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject != null) {
      ((AdvertisementInfo)localObject).gameAdComData = ((VideoInfo.GameAdComData)null);
    }
    paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)null);
    paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)null);
    localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    if ((localObject != null) && (((VideoInfo.ECommerceEntranceInfo)localObject).h == 0)) {
      paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)null);
    }
    paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = ((VideoInfo.UGDownloadInfo)null);
    paramVideoInfo.b = ((VideoInfo.UGDownloadInfo)null);
  }
  
  private final void c(VideoInfo paramVideoInfo)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    if ((localECommerceEntranceInfo != null) && (localECommerceEntranceInfo.h == 1)) {
      paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)null);
    }
    paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)null);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (!ReadInJoyHelper.d()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) {
        break label362;
      }
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c)) {
        break label355;
      }
      i = jdField_a_of_type_Int;
      label59:
      localSparseArray.put(i, new VideoFeedsDiversionHandler.handleDiversionPriority.2(paramVideoInfo));
    }
    for (;;)
    {
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.h == 0)) {
        localSparseArray.put(b, new VideoFeedsDiversionHandler.handleDiversionPriority.4(paramVideoInfo));
      }
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo != null) || (paramVideoInfo.b != null)) {
        localSparseArray.put(f, new VideoFeedsDiversionHandler.handleDiversionPriority.5(paramVideoInfo));
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsDiversionHandler", 2, "handleHeaderDiversionPriority: videoInfo.title=" + paramVideoInfo.c + ", array=" + localSparseArray);
      }
      if (localSparseArray.size() > 0)
      {
        Object localObject = (Function0)localSparseArray.get(localSparseArray.keyAt(0));
        if (localObject != null) {
          localObject = (Unit)((Function0)localObject).invoke();
        }
      }
      localSparseArray.clear();
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.h == 1)) {
        localSparseArray.put(g, new VideoFeedsDiversionHandler.handleDiversionPriority.6(paramVideoInfo));
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) {
        localSparseArray.put(h, new VideoFeedsDiversionHandler.handleDiversionPriority.7(paramVideoInfo));
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsDiversionHandler", 2, "handleBottomDiversionPriority: videoInfo.title=" + paramVideoInfo.c + ", array=" + localSparseArray);
      }
      if (localSparseArray.size() <= 0) {
        break;
      }
      paramVideoInfo = (Function0)localSparseArray.get(localSparseArray.keyAt(0));
      if (paramVideoInfo == null) {
        break;
      }
      paramVideoInfo = (Unit)paramVideoInfo.invoke();
      return;
      label355:
      i = d;
      break label59;
      label362:
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null) {
        localSparseArray.put(e, new VideoFeedsDiversionHandler.handleDiversionPriority.3(paramVideoInfo));
      }
    }
  }
  
  public final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.a;
    if (paramBaseVideoItemHolder != null)
    {
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.a;
      if (paramBaseVideoItemHolder != null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsDiversionHandler.a(paramBaseVideoItemHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDiversionHandler
 * JD-Core Version:    0.7.0.1
 */