package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.SubscribePersonalBottomBlock;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.extendsblock.SingleViewBlock;

class SubscribePersonalDetailFragment$1
  extends SingleViewBlock
{
  SubscribePersonalDetailFragment$1(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo)
  {
    if ((paramLoadInfo.c()) || (paramLoadInfo.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).b() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        SimpleEventBus.getInstance().dispatchEvent(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramLoadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */