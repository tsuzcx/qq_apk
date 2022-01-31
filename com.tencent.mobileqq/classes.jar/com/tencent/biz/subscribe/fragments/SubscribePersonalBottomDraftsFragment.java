package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import wlq;
import wpf;
import wpt;
import wpw;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private wlq jdField_a_of_type_Wlq;
  
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
    this.jdField_a_of_type_Wlq = new wlq(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Wlq);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    this.jdField_a_of_type_Wlq.b();
    if (this.jdField_a_of_type_Wpw != null) {
      this.jdField_a_of_type_Wlq.b("share_key_subscribe_opus", new wpf(this.jdField_a_of_type_Wpw));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, wpw paramwpw)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Wpw = paramwpw;
      if (this.jdField_a_of_type_Wlq != null) {
        this.jdField_a_of_type_Wlq.b("share_key_subscribe_opus", new wpf(this.jdField_a_of_type_Wpw));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    wpt.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */