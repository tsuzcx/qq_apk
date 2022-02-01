package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder$13
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$13(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    if (WebProteusViewCreator.ProteusItemViewHolder.a(this.a, localJSONObject))
    {
      WebProteusViewCreator.ProteusItemViewHolder.a(this.a, paramViewBase, paramContext, paramProteusItemData);
      return;
    }
    WebProteusViewCreator.ProteusItemViewHolder.b(this.a, paramViewBase, paramContext, paramProteusItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.13
 * JD-Core Version:    0.7.0.1
 */