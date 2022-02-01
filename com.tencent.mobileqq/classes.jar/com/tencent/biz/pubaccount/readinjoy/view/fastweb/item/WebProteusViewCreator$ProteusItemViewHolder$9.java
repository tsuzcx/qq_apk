package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class WebProteusViewCreator$ProteusItemViewHolder$9
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$9(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    FastWebDislikeUtils.b(paramContext, paramProteusItemData.b, paramProteusItemData.a);
    RIJFeedsDynamicInsertController.a.a(paramProteusItemData.b.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE, 0, 0, 0), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.9
 * JD-Core Version:    0.7.0.1
 */