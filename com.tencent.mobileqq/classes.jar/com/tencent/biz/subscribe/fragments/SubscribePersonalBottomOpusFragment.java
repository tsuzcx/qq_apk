package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  protected ExtraTypeInfo a;
  private RelativeFeedsAdapter a;
  
  private void a(SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if (getBaseActivity() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null) {
      return;
    }
    if ((paramBottomData != null) && ((paramBottomData.jdField_a_of_type_JavaUtilList == null) || (paramBottomData.jdField_a_of_type_JavaUtilList.size() <= 0)))
    {
      if (paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
        return;
      }
      StatusView localStatusView;
      StringBuilder localStringBuilder;
      if (paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0)
      {
        if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new SubscribePersonalBottomOpusFragment.3(this, paramBottomData));
        }
        else
        {
          localStatusView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(SubscribeUtils.a());
          localStringBuilder.append("/certified_account_feeds_empty.png");
          localStatusView.setHintImageFilePath(localStringBuilder.toString());
          if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1)) {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131719370), 13, getResources().getColor(2131167250));
          } else {
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131713296), 13, getResources().getColor(2131167250));
          }
        }
      }
      else if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new SubscribePersonalBottomOpusFragment.4(this, paramBottomData), new SubscribePersonalBottomOpusFragment.5(this, paramBottomData));
      }
      else
      {
        localStatusView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(SubscribeUtils.a());
        localStringBuilder.append("/certified_account_feeds_empty.png");
        localStatusView.setHintImageFilePath(localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131713296), 13, getResources().getColor(2131167250));
      }
      VSReporter.b(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_Boolean);
        RelativeFeedsAdapter localRelativeFeedsAdapter = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
        if (localRelativeFeedsAdapter != null) {
          localRelativeFeedsAdapter.b("share_key_subscribe_user", new BlockMerger.ShareData(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData);
    }
  }
  
  ExtraTypeInfo a()
  {
    ExtraTypeInfo localExtraTypeInfo1;
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null)) {
      localExtraTypeInfo1 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
    } else {
      localExtraTypeInfo1 = null;
    }
    ExtraTypeInfo localExtraTypeInfo2 = localExtraTypeInfo1;
    if (localExtraTypeInfo1 == null) {
      localExtraTypeInfo2 = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7002, localExtraTypeInfo2.sourceType);
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter = new RelativeFeedsAdapter(null);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.b(false);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a(true);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a(new SubscribePersonalBottomOpusFragment.1(this));
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a(new SubscribePersonalBottomOpusFragment.2(this));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    b();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData = paramBottomData;
      b();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    RelativeFeedsAdapter localRelativeFeedsAdapter = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
    if (localRelativeFeedsAdapter != null) {
      localRelativeFeedsAdapter.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */