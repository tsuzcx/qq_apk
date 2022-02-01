package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class NewGdtAdWSVerticalCommonVideoHolder
  extends GdtAdWSVerticalCommonVideoHolder
{
  public IWSItemView<WSVerticalItemData> a(int paramInt)
  {
    return new NewGdtAdWSVerticalVideoItemView(a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.NewGdtAdWSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */