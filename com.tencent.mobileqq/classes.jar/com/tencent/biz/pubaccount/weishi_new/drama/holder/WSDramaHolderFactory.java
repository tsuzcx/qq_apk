package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSDramaHolderFactory
{
  public static BaseViewHolder<WSDramaItemData> a(ViewGroup paramViewGroup, int paramInt, WSDramaPageContract.View paramView)
  {
    return new WSDramaCommonVideoHolder(paramViewGroup, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.WSDramaHolderFactory
 * JD-Core Version:    0.7.0.1
 */