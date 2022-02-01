package com.tencent.biz.subscribe.fragments;

import aadf;
import aagr;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import zwp;
import zxs;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private aadf jdField_a_of_type_Aadf;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  
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
    this.jdField_a_of_type_Aadf = new aadf(null);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aadf);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    this.jdField_a_of_type_Aadf.a();
    if (this.jdField_a_of_type_Aagr != null) {
      this.jdField_a_of_type_Aadf.setShareData("share_key_subscribe_opus", new zxs(this.jdField_a_of_type_Aagr));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, aagr paramaagr)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Aagr = paramaagr;
      if (this.jdField_a_of_type_Aadf != null) {
        this.jdField_a_of_type_Aadf.setShareData("share_key_subscribe_opus", new zxs(this.jdField_a_of_type_Aagr));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    zwp.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */