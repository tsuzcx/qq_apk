package com.tencent.biz.subscribe.fragments;

import aaak;
import aabn;
import aahg;
import aaks;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private aahg jdField_a_of_type_Aahg;
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
    this.jdField_a_of_type_Aahg = new aahg(null);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aahg);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    this.jdField_a_of_type_Aahg.a();
    if (this.jdField_a_of_type_Aaks != null) {
      this.jdField_a_of_type_Aahg.setShareData("share_key_subscribe_opus", new aabn(this.jdField_a_of_type_Aaks));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, aaks paramaaks)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Aaks = paramaaks;
      if (this.jdField_a_of_type_Aahg != null) {
        this.jdField_a_of_type_Aahg.setShareData("share_key_subscribe_opus", new aabn(this.jdField_a_of_type_Aaks));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    aaak.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */