package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.viola.core.ViolaInstance;
import java.util.List;

class BridgeModule$1
  implements VideoPreDownloadMgr.PreDownloadController
{
  BridgeModule$1(BridgeModule paramBridgeModule, List paramList) {}
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return NetworkUtil.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.1
 * JD-Core Version:    0.7.0.1
 */