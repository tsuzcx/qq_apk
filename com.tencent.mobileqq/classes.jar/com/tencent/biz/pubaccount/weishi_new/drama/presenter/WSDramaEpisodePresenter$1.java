package com.tencent.biz.pubaccount.weishi_new.drama.presenter;

import UserGrowth.stDramaInfo;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import java.util.List;

class WSDramaEpisodePresenter$1
  implements IFetchDataRspListener<WSEpisodeItemData>
{
  WSDramaEpisodePresenter$1(WSDramaEpisodePresenter paramWSDramaEpisodePresenter, WSDramaEpisodeContract.View paramView) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSDramaEpisodeContract$View.a(paramInt, paramString);
  }
  
  public void a(List<WSEpisodeItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    paramObject = (stDramaInfo)paramObject;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSDramaEpisodeContract$View.a(paramList, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaEpisodePresenter.1
 * JD-Core Version:    0.7.0.1
 */