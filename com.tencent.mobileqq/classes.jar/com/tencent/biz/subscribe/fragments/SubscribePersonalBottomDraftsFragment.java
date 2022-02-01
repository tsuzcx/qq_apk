package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private SubscribeDraftAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter;
  
  ExtraTypeInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (getActivity() != null)
    {
      localObject1 = localObject2;
      if (getActivity().getIntent() != null) {
        localObject1 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7005, ((ExtraTypeInfo)localObject2).sourceType);
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter = new SubscribeDraftAdapter(null);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter.b();
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter.b("share_key_subscribe_opus", new BlockMerger.ShareData(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData = paramBottomData;
      if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter.b("share_key_subscribe_opus", new BlockMerger.ShareData(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SimpleEventBus.getInstance().dispatchEvent(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */