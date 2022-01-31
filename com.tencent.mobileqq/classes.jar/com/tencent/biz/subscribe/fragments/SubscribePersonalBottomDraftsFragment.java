package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import yaj;
import ydw;
import yej;
import yem;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private yaj jdField_a_of_type_Yaj;
  
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
    this.jdField_a_of_type_Yaj = new yaj(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yaj);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.e();
    this.jdField_a_of_type_Yaj.b();
    if (this.jdField_a_of_type_Yem != null) {
      this.jdField_a_of_type_Yaj.b("share_key_subscribe_opus", new ydw(this.jdField_a_of_type_Yem));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, yem paramyem)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Yem = paramyem;
      if (this.jdField_a_of_type_Yaj != null) {
        this.jdField_a_of_type_Yaj.b("share_key_subscribe_opus", new ydw(this.jdField_a_of_type_Yem));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    yej.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */