package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;

public class WSDramaCommonVideoHolder
  extends AbsWSDramaVideoHolder
{
  public WSDramaCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSDramaPageContract.View paramView)
  {
    super(paramViewGroup, 2131560001, paramInt, paramView);
  }
  
  public IWSItemView<WSDramaItemData> a(int paramInt)
  {
    return new WSDramaCommonVideoItemView(getContext(), this.itemView, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.WSDramaCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */