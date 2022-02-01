package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class WebProteusViewCreator$ProteusItemViewHolder$4
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$4(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      ((AuthorData)paramProteusItemData).b(false);
      if (WebProteusViewCreator.a(this.a.a) != null) {
        WebProteusViewCreator.a(this.a.a).notifyDataSetChanged();
      }
      if ((((AuthorData)paramProteusItemData).a) && (paramProteusItemData.b != null)) {
        RIJFeedsDynamicInsertController.a.a(paramProteusItemData.b.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW, 0, 0, 0), 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.4
 * JD-Core Version:    0.7.0.1
 */