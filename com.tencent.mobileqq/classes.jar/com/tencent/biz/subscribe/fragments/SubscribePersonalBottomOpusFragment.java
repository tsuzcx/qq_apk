package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import ajjy;
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
import vvr;
import vvz;
import vya;
import wbv;
import wcm;
import wcy;
import wcz;
import wdb;
import wdc;
import wdd;
import wye;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private vya a;
  
  private void a(wcm paramwcm)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {}
    do
    {
      return;
      if ((paramwcm == null) || ((paramwcm.jdField_a_of_type_JavaUtilList != null) && (paramwcm.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (vvz.a(paramwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new wdb(this, paramwcm));
      }
    }
    for (;;)
    {
      wye.b(paramwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(vvz.a() + "/certified_account_feeds_empty.png");
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(ajjy.a(2131654048), 13, getResources().getColor(2131101430));
      continue;
      if (vvz.a(paramwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new wdc(this, paramwcm), new wdd(this, paramwcm));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(vvz.a() + "/certified_account_feeds_empty.png");
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(ajjy.a(2131647582), 13, getResources().getColor(2131101430));
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Wcm != null)
    {
      if (this.jdField_a_of_type_Wcm.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Wcm.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wcm.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Wcm.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Vya != null) {
          this.jdField_a_of_type_Vya.b("share_key_subscribe_user", new wbv(this.jdField_a_of_type_Wcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Wcm);
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
    this.jdField_a_of_type_Vya = new vya(null);
    this.jdField_a_of_type_Vya.b(false);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vya);
    this.jdField_a_of_type_Vya.a(true);
    this.jdField_a_of_type_Vya.a(new wcy(this));
    this.jdField_a_of_type_Vya.a(new wcz(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, wcm paramwcm)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Wcm = paramwcm;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vya != null) {
      this.jdField_a_of_type_Vya.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */