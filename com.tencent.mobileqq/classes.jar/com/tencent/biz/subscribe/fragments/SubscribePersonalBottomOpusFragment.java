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
  protected ExtraTypeInfo e;
  private RelativeFeedsAdapter f;
  
  private void a(SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if (getBaseActivity() == null) {
      return;
    }
    if (this.d == null) {
      return;
    }
    if ((paramBottomData != null) && ((paramBottomData.d == null) || (paramBottomData.d.size() <= 0)))
    {
      if (paramBottomData.e == null) {
        return;
      }
      StatusView localStatusView;
      StringBuilder localStringBuilder;
      if (paramBottomData.e.poster.type.get() == 0)
      {
        if (SubscribeUtils.a(paramBottomData.e.poster.attr.get(), 6))
        {
          this.d.a(new SubscribePersonalBottomOpusFragment.3(this, paramBottomData));
        }
        else
        {
          localStatusView = this.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(SubscribeUtils.b());
          localStringBuilder.append("/certified_account_feeds_empty.png");
          localStatusView.setHintImageFilePath(localStringBuilder.toString());
          if (SubscribeUtils.a(paramBottomData.e.poster.attr.get(), 1)) {
            this.d.a(HardCodeUtil.a(2131916925), 13, getResources().getColor(2131168245));
          } else {
            this.d.a(HardCodeUtil.a(2131910849), 13, getResources().getColor(2131168245));
          }
        }
      }
      else if (SubscribeUtils.a(paramBottomData.e.poster.attr.get(), 1))
      {
        this.d.a(new SubscribePersonalBottomOpusFragment.4(this, paramBottomData), new SubscribePersonalBottomOpusFragment.5(this, paramBottomData));
      }
      else
      {
        localStatusView = this.d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(SubscribeUtils.b());
        localStringBuilder.append("/certified_account_feeds_empty.png");
        localStatusView.setHintImageFilePath(localStringBuilder.toString());
        this.d.a(HardCodeUtil.a(2131910849), 13, getResources().getColor(2131168245));
      }
      VSReporter.b(paramBottomData.e.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
    }
    this.d.setVisibility(8);
  }
  
  private void c()
  {
    if (this.c != null)
    {
      if (this.c.d != null)
      {
        a(this.c.d, this.c.c, this.c.b);
        RelativeFeedsAdapter localRelativeFeedsAdapter = this.f;
        if (localRelativeFeedsAdapter != null) {
          localRelativeFeedsAdapter.b("share_key_subscribe_user", new BlockMerger.ShareData(this.c.f));
        }
      }
      a(this.c);
    }
  }
  
  protected void a()
  {
    this.f = new RelativeFeedsAdapter(null);
    this.f.b(false);
    this.f.a(true);
    this.f.a(new SubscribePersonalBottomOpusFragment.1(this));
    this.f.a(new SubscribePersonalBottomOpusFragment.2(this));
    this.b.a(this.f);
    this.b.e();
    c();
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.c = paramBottomData;
      c();
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    RelativeFeedsAdapter localRelativeFeedsAdapter = this.f;
    if (localRelativeFeedsAdapter != null) {
      localRelativeFeedsAdapter.a(paramList, paramStCommonExt, paramBoolean);
    }
  }
  
  ExtraTypeInfo b()
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
    this.e = new ExtraTypeInfo(7002, localExtraTypeInfo2.sourceType);
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */