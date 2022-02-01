package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import aanb;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import anvx;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import zos;
import zqf;
import zqn;
import zsx;
import zwv;
import zxi;
import zxj;
import zxl;
import zxm;
import zxn;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private zsx a;
  
  private void a(zwv paramzwv)
  {
    if (getActivity() == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null);
      if ((paramzwv == null) || ((paramzwv.jdField_a_of_type_JavaUtilList != null) && (paramzwv.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (zqn.a(paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new zxl(this, paramzwv));
      }
    }
    for (;;)
    {
      aanb.b(paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(zqn.a() + "/certified_account_feeds_empty.png");
      if (zqn.a(paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anvx.a(2131719111), 13, getResources().getColor(2131167218));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anvx.a(2131712832), 13, getResources().getColor(2131167218));
        continue;
        if (zqn.a(paramzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new zxm(this, paramzwv), new zxn(this, paramzwv));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(zqn.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anvx.a(2131712832), 13, getResources().getColor(2131167218));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Zwv != null)
    {
      if (this.jdField_a_of_type_Zwv.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Zwv.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Zwv.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Zwv.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Zsx != null) {
          this.jdField_a_of_type_Zsx.b("share_key_subscribe_user", new zos(this.jdField_a_of_type_Zwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Zwv);
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
    this.jdField_a_of_type_Zsx = new zsx(null);
    this.jdField_a_of_type_Zsx.c(false);
    this.jdField_a_of_type_Zsx.b(true);
    this.jdField_a_of_type_Zsx.a(new zxi(this));
    this.jdField_a_of_type_Zsx.a(new zxj(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zsx);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, zwv paramzwv)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Zwv = paramzwv;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zsx != null) {
      this.jdField_a_of_type_Zsx.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */