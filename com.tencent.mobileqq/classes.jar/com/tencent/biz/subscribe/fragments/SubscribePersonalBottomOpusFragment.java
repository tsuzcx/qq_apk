package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import aaaf;
import aacp;
import aagr;
import aahe;
import aahf;
import aahh;
import aahi;
import aahj;
import aaxb;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import anni;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import zxs;
import zzx;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private aacp a;
  protected ExtraTypeInfo a;
  
  private void a(aagr paramaagr)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {}
    do
    {
      return;
      if ((paramaagr == null) || ((paramaagr.jdField_a_of_type_JavaUtilList != null) && (paramaagr.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (aaaf.a(paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new aahh(this, paramaagr));
      }
    }
    for (;;)
    {
      aaxb.b(paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(aaaf.a() + "/certified_account_feeds_empty.png");
      if (aaaf.a(paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anni.a(2131718338), 13, getResources().getColor(2131167163));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anni.a(2131712144), 13, getResources().getColor(2131167163));
        continue;
        if (aaaf.a(paramaagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new aahi(this, paramaagr), new aahj(this, paramaagr));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(aaaf.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anni.a(2131712144), 13, getResources().getColor(2131167163));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aagr != null)
    {
      if (this.jdField_a_of_type_Aagr.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Aagr.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Aagr.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Aagr.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Aacp != null) {
          this.jdField_a_of_type_Aacp.setShareData("share_key_subscribe_user", new zxs(this.jdField_a_of_type_Aagr.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Aagr);
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
    this.jdField_a_of_type_Aacp = new aacp(null);
    this.jdField_a_of_type_Aacp.b(false);
    this.jdField_a_of_type_Aacp.a(true);
    this.jdField_a_of_type_Aacp.a(new aahe(this));
    this.jdField_a_of_type_Aacp.setOnLoadDataDelegate(new aahf(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aacp);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, aagr paramaagr)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Aagr = paramaagr;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aacp != null) {
      this.jdField_a_of_type_Aacp.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */