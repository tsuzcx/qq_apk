package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class NewGdtAdWSVerticalCommonVideoHolder
  extends GdtAdWSVerticalCommonVideoHolder
{
  public NewGdtAdWSVerticalCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  public IWSItemView<WSVerticalItemData> a(int paramInt)
  {
    return new NewGdtAdWSVerticalVideoItemView(getContext(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.NewGdtAdWSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */