package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import yes;
import yif;
import yiw;
import yiz;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private yes jdField_a_of_type_Yes;
  
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
    this.jdField_a_of_type_Yes = new yes(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yes);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
    this.jdField_a_of_type_Yes.a();
    if (this.jdField_a_of_type_Yiz != null) {
      this.jdField_a_of_type_Yes.setShareData("share_key_subscribe_opus", new yif(this.jdField_a_of_type_Yiz));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, yiz paramyiz)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Yiz = paramyiz;
      if (this.jdField_a_of_type_Yes != null) {
        this.jdField_a_of_type_Yes.setShareData("share_key_subscribe_opus", new yif(this.jdField_a_of_type_Yiz));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    yiw.a().a(new SubDraftChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */