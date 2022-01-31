package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import ajyc;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import wio;
import wiw;
import wlj;
import wpi;
import wpz;
import wqm;
import wqn;
import wqp;
import wqq;
import wqr;
import xhe;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private wlj a;
  
  private void a(wpz paramwpz)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {}
    do
    {
      return;
      if ((paramwpz == null) || ((paramwpz.jdField_a_of_type_JavaUtilList != null) && (paramwpz.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (wiw.a(paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new wqp(this, paramwpz));
      }
    }
    for (;;)
    {
      xhe.b(paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(wiw.a() + "/certified_account_feeds_empty.png");
      if (wiw.a(paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(ajyc.a(2131719935), 13, getResources().getColor(2131167026));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(ajyc.a(2131713370), 13, getResources().getColor(2131167026));
        continue;
        if (wiw.a(paramwpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new wqq(this, paramwpz), new wqr(this, paramwpz));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(wiw.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(ajyc.a(2131713370), 13, getResources().getColor(2131167026));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Wpz != null)
    {
      if (this.jdField_a_of_type_Wpz.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Wpz.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wpz.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Wpz.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Wlj != null) {
          this.jdField_a_of_type_Wlj.b("share_key_subscribe_user", new wpi(this.jdField_a_of_type_Wpz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Wpz);
    }
  }
  
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
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7002, ((ExtraTypeInfo)localObject2).sourceType);
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Wlj = new wlj(null);
    this.jdField_a_of_type_Wlj.b(false);
    this.jdField_a_of_type_Wlj.a(true);
    this.jdField_a_of_type_Wlj.a(new wqm(this));
    this.jdField_a_of_type_Wlj.a(new wqn(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Wlj);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, wpz paramwpz)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Wpz = paramwpz;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wlj != null) {
      this.jdField_a_of_type_Wlj.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */