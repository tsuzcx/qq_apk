package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import alud;
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
import ybm;
import ybu;
import yei;
import yif;
import yiz;
import yjm;
import yjn;
import yjp;
import yjq;
import yjr;
import zaj;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private yei a;
  
  private void a(yiz paramyiz)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {}
    do
    {
      return;
      if ((paramyiz == null) || ((paramyiz.jdField_a_of_type_JavaUtilList != null) && (paramyiz.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (ybu.a(paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new yjp(this, paramyiz));
      }
    }
    for (;;)
    {
      zaj.b(paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(ybu.a() + "/certified_account_feeds_empty.png");
      if (ybu.a(paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alud.a(2131720493), 13, getResources().getColor(2131167079));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alud.a(2131713765), 13, getResources().getColor(2131167079));
        continue;
        if (ybu.a(paramyiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new yjq(this, paramyiz), new yjr(this, paramyiz));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(ybu.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alud.a(2131713765), 13, getResources().getColor(2131167079));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Yiz != null)
    {
      if (this.jdField_a_of_type_Yiz.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Yiz.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Yiz.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Yiz.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Yei != null) {
          this.jdField_a_of_type_Yei.setShareData("share_key_subscribe_user", new yif(this.jdField_a_of_type_Yiz.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Yiz);
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
    this.jdField_a_of_type_Yei = new yei(null);
    this.jdField_a_of_type_Yei.b(false);
    this.jdField_a_of_type_Yei.a(true);
    this.jdField_a_of_type_Yei.a(new yjm(this));
    this.jdField_a_of_type_Yei.setOnLoadDataDelegate(new yjn(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yei);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, yiz paramyiz)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Yiz = paramyiz;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yei != null) {
      this.jdField_a_of_type_Yei.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */