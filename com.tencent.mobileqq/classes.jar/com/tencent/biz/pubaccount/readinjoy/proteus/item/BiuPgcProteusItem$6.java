package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class BiuPgcProteusItem$6
  implements View.OnClickListener
{
  BiuPgcProteusItem$6(BiuPgcProteusItem paramBiuPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((SocializeFeedsInfo.PGCFeedsInfo)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (SocializeFeedsInfo.PGCPicInfo)((SocializeFeedsInfo.PGCFeedsInfo)localObject).a.get(0);
      BiuPgcProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemBiuPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), (int)((SocializeFeedsInfo.PGCPicInfo)localObject).a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuPgcProteusItem.6
 * JD-Core Version:    0.7.0.1
 */