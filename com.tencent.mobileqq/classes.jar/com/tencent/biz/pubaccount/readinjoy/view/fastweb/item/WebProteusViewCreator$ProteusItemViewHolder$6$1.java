package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils;

class WebProteusViewCreator$ProteusItemViewHolder$6$1
  implements RIJUserLevelModule.UserLevelCallBack
{
  WebProteusViewCreator$ProteusItemViewHolder$6$1(WebProteusViewCreator.ProteusItemViewHolder.6 param6, ProteusItemData paramProteusItemData) {}
  
  public void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.a)) {
      RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE, 0, 0, 0), 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.6.1
 * JD-Core Version:    0.7.0.1
 */