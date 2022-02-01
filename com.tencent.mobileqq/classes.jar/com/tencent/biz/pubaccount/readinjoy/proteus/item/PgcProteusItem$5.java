package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.OnGalleryItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class PgcProteusItem$5
  implements ComponentContentGridImage.OnGalleryItemClickListener
{
  PgcProteusItem$5(PgcProteusItem paramPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, int paramInt) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((SocializeFeedsInfo.PGCFeedsInfo)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    localObject = (SocializeFeedsInfo.PGCPicInfo)((SocializeFeedsInfo.PGCFeedsInfo)localObject).a.get(paramInt);
    PgcProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), (int)((SocializeFeedsInfo.PGCPicInfo)localObject).a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().innerUniqueID, this.jdField_a_of_type_Int, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem.5
 * JD-Core Version:    0.7.0.1
 */