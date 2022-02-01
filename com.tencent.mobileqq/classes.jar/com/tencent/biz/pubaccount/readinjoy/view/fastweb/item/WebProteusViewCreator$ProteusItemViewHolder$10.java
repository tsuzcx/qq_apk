package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebVideoItemUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class WebProteusViewCreator$ProteusItemViewHolder$10
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$10(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    paramViewBase = paramProteusItemData.c;
    if ((paramViewBase != null) && ((paramContext instanceof FastWebActivity))) {
      FastWebVideoItemUtils.a(paramViewBase, (FastWebActivity)paramContext, paramProteusItemData.b, paramProteusItemData.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.10
 * JD-Core Version:    0.7.0.1
 */