package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import aabn;
import aaec;
import aaek;
import aagu;
import aaks;
import aalf;
import aalg;
import aali;
import aalj;
import aalk;
import abbe;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import anzj;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private aagu a;
  protected ExtraTypeInfo a;
  
  private void a(aaks paramaaks)
  {
    if (getActivity() == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null);
      if ((paramaaks == null) || ((paramaaks.jdField_a_of_type_JavaUtilList != null) && (paramaaks.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (aaek.a(paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new aali(this, paramaaks));
      }
    }
    for (;;)
    {
      abbe.b(paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(aaek.a() + "/certified_account_feeds_empty.png");
      if (aaek.a(paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anzj.a(2131718474), 13, getResources().getColor(2131167175));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anzj.a(2131712253), 13, getResources().getColor(2131167175));
        continue;
        if (aaek.a(paramaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new aalj(this, paramaaks), new aalk(this, paramaaks));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(aaek.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(anzj.a(2131712253), 13, getResources().getColor(2131167175));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aaks != null)
    {
      if (this.jdField_a_of_type_Aaks.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_Aaks.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Aaks.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_Aaks.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Aagu != null) {
          this.jdField_a_of_type_Aagu.setShareData("share_key_subscribe_user", new aabn(this.jdField_a_of_type_Aaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_Aaks);
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
    this.jdField_a_of_type_Aagu = new aagu(null);
    this.jdField_a_of_type_Aagu.b(false);
    this.jdField_a_of_type_Aagu.a(true);
    this.jdField_a_of_type_Aagu.a(new aalf(this));
    this.jdField_a_of_type_Aagu.setOnLoadDataDelegate(new aalg(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aagu);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, aaks paramaaks)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_Aaks = paramaaks;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aagu != null) {
      this.jdField_a_of_type_Aagu.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */