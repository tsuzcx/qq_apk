package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJSocialBottomUtils$Companion$refreshBottomView$1
  implements Runnable
{
  RIJSocialBottomUtils$Companion$refreshBottomView$1(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public final void run()
  {
    ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = RIJSocialBottomUtils.a();
    if (localReadInJoyFastWebBottomSocialViewNew != null) {
      localReadInJoyFastWebBottomSocialViewNew.setData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.Companion.refreshBottomView.1
 * JD-Core Version:    0.7.0.1
 */