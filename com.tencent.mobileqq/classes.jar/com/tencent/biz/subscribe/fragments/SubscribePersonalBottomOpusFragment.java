package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.videostory.support.VSReporter;
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
    if (getActivity() == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null);
      if ((paramBottomData == null) || ((paramBottomData.jdField_a_of_type_JavaUtilList != null) && (paramBottomData.jdField_a_of_type_JavaUtilList.size() > 0)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
        return;
      }
    } while (paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    if (paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type.get() == 0) {
      if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 6)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new SubscribePersonalBottomOpusFragment.3(this, paramBottomData));
      }
    }
    for (;;)
    {
      VSReporter.b(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(SubscribeUtils.a() + "/certified_account_feeds_empty.png");
      if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131719651), 13, getResources().getColor(2131167225));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131713328), 13, getResources().getColor(2131167225));
        continue;
        if (SubscribeUtils.a(paramBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get(), 1))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(new SubscribePersonalBottomOpusFragment.4(this, paramBottomData), new SubscribePersonalBottomOpusFragment.5(this, paramBottomData));
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setHintImageFilePath(SubscribeUtils.a() + "/certified_account_feeds_empty.png");
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(HardCodeUtil.a(2131713328), 13, getResources().getColor(2131167225));
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_NS_COMMCOMM$StCommonExt, this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.b("share_key_subscribe_user", new BlockMerger.ShareData(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser));
        }
      }
      a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData);
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
    if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */