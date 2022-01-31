package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import vyk;
import wbv;
import wcj;
import wcm;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private vyk jdField_a_of_type_Vyk;
  
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
    this.jdField_a_of_type_Vyk = new vyk(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vyk);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    this.jdField_a_of_type_Vyk.b();
    if (this.jdField_a_of_type_Wcm != null) {
      this.jdField_a_of_type_Vyk.b("share_key_subscribe_opus", new wbv(this.jdField_a_of_type_Wcm));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, wcm paramwcm)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Wcm = paramwcm;
      if (this.jdField_a_of_type_Vyk != null) {
        this.jdField_a_of_type_Vyk.b("share_key_subscribe_opus", new wbv(this.jdField_a_of_type_Wcm));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    wcj.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */