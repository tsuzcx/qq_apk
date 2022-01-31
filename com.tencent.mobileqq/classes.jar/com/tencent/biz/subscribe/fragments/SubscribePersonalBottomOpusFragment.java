package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import alpo;
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
import xxd;
import xxl;
import xzz;
import ydw;
import yem;
import yez;
import yfa;
import yfc;
import yfd;
import yfe;
import yvu;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private xzz a;
  
  private void a(yem paramyem)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {}
    do
    {
      return;
      if ((paramyem == null) || ((paramyem.jdField_a_of_type_JavaUtilList != null) && (paramyem.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (xxl.a(paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new yfc(this, paramyem));
      }
    }
    for (;;)
    {
      yvu.b(paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(xxl.a() + "/certified_account_feeds_empty.png");
      if (xxl.a(paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alpo.a(2131720481), 13, getResources().getColor(2131167077));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alpo.a(2131713753), 13, getResources().getColor(2131167077));
        continue;
        if (xxl.a(paramyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new yfd(this, paramyem), new yfe(this, paramyem));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(xxl.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(alpo.a(2131713753), 13, getResources().getColor(2131167077));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Yem != null)
    {
      if (this.jdField_a_of_type_Yem.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Yem.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Yem.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Yem.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Xzz != null) {
          this.jdField_a_of_type_Xzz.b("share_key_subscribe_user", new ydw(this.jdField_a_of_type_Yem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Yem);
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
    this.jdField_a_of_type_Xzz = new xzz(null);
    this.jdField_a_of_type_Xzz.b(false);
    this.jdField_a_of_type_Xzz.a(true);
    this.jdField_a_of_type_Xzz.a(new yez(this));
    this.jdField_a_of_type_Xzz.a(new yfa(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Xzz);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.e();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, yem paramyem)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Yem = paramyem;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xzz != null) {
      this.jdField_a_of_type_Xzz.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */