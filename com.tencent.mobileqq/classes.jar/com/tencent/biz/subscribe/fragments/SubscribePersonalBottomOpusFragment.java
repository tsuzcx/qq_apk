package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import amtj;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import yzn;
import zba;
import zbi;
import zds;
import zhq;
import zid;
import zie;
import zig;
import zih;
import zii;
import zxp;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private zds a;
  
  private void a(zhq paramzhq)
  {
    if (getActivity() == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null);
      if ((paramzhq == null) || ((paramzhq.jdField_a_of_type_JavaUtilList != null) && (paramzhq.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (zbi.a(paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new zig(this, paramzhq));
      }
    }
    for (;;)
    {
      zxp.b(paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(zbi.a() + "/certified_account_feeds_empty.png");
      if (zbi.a(paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(amtj.a(2131718722), 13, getResources().getColor(2131167204));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(amtj.a(2131712485), 13, getResources().getColor(2131167204));
        continue;
        if (zbi.a(paramzhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new zih(this, paramzhq), new zii(this, paramzhq));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(zbi.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(amtj.a(2131712485), 13, getResources().getColor(2131167204));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Zhq != null)
    {
      if (this.jdField_a_of_type_Zhq.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Zhq.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Zhq.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Zhq.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Zds != null) {
          this.jdField_a_of_type_Zds.b("share_key_subscribe_user", new yzn(this.jdField_a_of_type_Zhq.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Zhq);
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
    this.jdField_a_of_type_Zds = new zds(null);
    this.jdField_a_of_type_Zds.c(false);
    this.jdField_a_of_type_Zds.b(true);
    this.jdField_a_of_type_Zds.a(new zid(this));
    this.jdField_a_of_type_Zds.a(new zie(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zds);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, zhq paramzhq)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Zhq = paramzhq;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zds != null) {
      this.jdField_a_of_type_Zds.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */