package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.PrefetchListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public final class RIJDataManager$Builder
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  PrefetchListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokPrefetchListener;
  RIJDislikeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager;
  RIJPreloadImage jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokImageRIJPreloadImage;
  VideoHandler.PlayableItem jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem;
  DynamicItemViewHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper;
  VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  VideoRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  VideoShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  ExposureSupplementUtil jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil;
  ArrayList<BaseReportData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Map<Long, BaseReportData> jdField_a_of_type_JavaUtilMap = null;
  Set<Long> jdField_a_of_type_JavaUtilSet = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public Builder a(PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokPrefetchListener = paramPrefetchListener;
    return this;
  }
  
  public Builder a(RIJDislikeManager paramRIJDislikeManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager = paramRIJDislikeManager;
    return this;
  }
  
  public Builder a(RIJPreloadImage paramRIJPreloadImage)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokImageRIJPreloadImage = paramRIJPreloadImage;
    return this;
  }
  
  public Builder a(VideoHandler.PlayableItem paramPlayableItem)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem = paramPlayableItem;
    return this;
  }
  
  public Builder a(DynamicItemViewHelper paramDynamicItemViewHelper)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper = paramDynamicItemViewHelper;
    return this;
  }
  
  public Builder a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
    return this;
  }
  
  public Builder a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    return this;
  }
  
  public Builder a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
    return this;
  }
  
  public Builder a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager = paramVideoRecommendManager;
    return this;
  }
  
  public Builder a(VideoShareHelper paramVideoShareHelper)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper = paramVideoShareHelper;
    return this;
  }
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    return this;
  }
  
  public Builder a(ExposureSupplementUtil paramExposureSupplementUtil)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil = paramExposureSupplementUtil;
    return this;
  }
  
  public Builder a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public PrefetchListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokPrefetchListener;
  }
  
  public RIJDislikeManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager;
  }
  
  public RIJPreloadImage a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokImageRIJPreloadImage;
  }
  
  public VideoHandler.PlayableItem a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem;
  }
  
  public DynamicItemViewHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper;
  }
  
  public VideoAutoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  }
  
  public VideoShareHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper;
  }
  
  public ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public ExposureSupplementUtil a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementUtil;
  }
  
  public ArrayList<BaseReportData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public Map<Long, BaseReportData> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public Set<Long> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public DynamicItemViewHelper b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder
 * JD-Core Version:    0.7.0.1
 */