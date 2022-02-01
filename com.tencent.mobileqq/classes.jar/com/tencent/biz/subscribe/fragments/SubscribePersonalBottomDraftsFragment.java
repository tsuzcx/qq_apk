package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.mobileqq.app.BaseActivity;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo e;
  private SubscribeDraftAdapter f;
  
  protected void a()
  {
    this.f = new SubscribeDraftAdapter(null);
    this.b.a(this.f);
    this.b.e();
    this.f.d();
    if (this.c != null) {
      this.f.b("share_key_subscribe_opus", new BlockMerger.ShareData(this.c));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.c = paramBottomData;
      paramString = this.f;
      if (paramString != null) {
        paramString.b("share_key_subscribe_opus", new BlockMerger.ShareData(this.c));
      }
    }
  }
  
  ExtraTypeInfo b()
  {
    ExtraTypeInfo localExtraTypeInfo1;
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null)) {
      localExtraTypeInfo1 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
    } else {
      localExtraTypeInfo1 = null;
    }
    ExtraTypeInfo localExtraTypeInfo2 = localExtraTypeInfo1;
    if (localExtraTypeInfo1 == null) {
      localExtraTypeInfo2 = new ExtraTypeInfo();
    }
    this.e = new ExtraTypeInfo(7005, localExtraTypeInfo2.sourceType);
    return this.e;
  }
  
  public void onResume()
  {
    super.onResume();
    SimpleEventBus.getInstance().dispatchEvent(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */