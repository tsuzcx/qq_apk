package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.part.ViewUtils;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter.BaseVH;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.extendsblock.HorizontalRVBlock;
import com.tencent.biz.subscribe.part.extendsblock.HorizontalRVBlock.CommonRvVH;
import com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView;
import com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class CommodityAdapter
  extends HorizontalRVBlock
{
  private CertifiedAccountMeta.StFeed a;
  private FrameLayout b;
  
  public CommodityAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private FrameLayout f()
  {
    FrameLayout localFrameLayout = c(null);
    Object localObject = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = -1;
    ((FrameLayout.LayoutParams)localObject).height = -2;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = ImmersiveUtils.dpToPx(30.0F);
    ((FrameLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.dpToPx(20.0F);
    ((FrameLayout.LayoutParams)localObject).leftMargin = ImmersiveUtils.dpToPx(16.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = ImmersiveUtils.dpToPx(16.0F);
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(H());
    ((ImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(1.0F)));
    ((ImageView)localObject).setBackgroundColor(Color.parseColor("#D8D8D8"));
    localFrameLayout.addView((View)localObject);
    return localFrameLayout;
  }
  
  public HorizontalRVBlock.CommonRvVH a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(paramViewGroup.getContext());
    paramViewGroup.setCurrentFeed(this.a);
    return new HorizontalRVBlock.CommonRvVH(paramViewGroup);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject1 = paramStFeed.poster;
    this.a = paramStFeed;
    if ((((CertifiedAccountMeta.StUser)localObject1).youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)((CertifiedAccountMeta.StUser)localObject1).youZhan.get(0)).goodNum.get() > 0))
    {
      paramStFeed = new FrameLayout.LayoutParams(-2, -2);
      paramStFeed.gravity = 21;
      paramStFeed.rightMargin = ImmersiveUtils.dpToPx(14.0F);
      LinearLayout localLinearLayout = new LinearLayout(H());
      localLinearLayout.setOrientation(0);
      this.b.addView(localLinearLayout, paramStFeed);
      CommodityAdapter.1 local1 = new CommodityAdapter.1(this, (CertifiedAccountMeta.StUser)localObject1);
      paramStFeed = ((CertifiedAccountMeta.StUser)localObject1).id.get();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("auth_");
      ((StringBuilder)localObject2).append(SubscribeShareHelper.a(K()));
      VSReporter.a(paramStFeed, ((StringBuilder)localObject2).toString(), "exp_shop", 0, 0, new String[0]);
      localObject2 = G();
      if (SubscribeUtils.a(((CertifiedAccountMeta.StUser)localObject1).attr.get())) {
        paramStFeed = HardCodeUtil.a(2131900409);
      } else {
        paramStFeed = ((CertifiedAccountMeta.StUser)localObject1).nick.get();
      }
      paramStFeed = ViewUtils.a((Context)localObject2, 13.5F, "#878B99", String.format("%s", new Object[] { paramStFeed }));
      paramStFeed.setMaxLines(1);
      paramStFeed.setMaxWidth(ImmersiveUtils.dpToPx(150.0F));
      paramStFeed.setGravity(5);
      paramStFeed.setEllipsize(TextUtils.TruncateAt.END);
      paramStFeed.setOnClickListener(local1);
      localLinearLayout.addView(paramStFeed, new LinearLayout.LayoutParams(-2, -2));
      paramStFeed = ViewUtils.a(G(), 13.5F, "#878B99", "的小店");
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      paramStFeed.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
      localObject2 = G().getResources().getDrawable(2130839446);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
      paramStFeed.setCompoundDrawables(null, null, (Drawable)localObject2, null);
      paramStFeed.setOnClickListener(local1);
      localLinearLayout.addView(paramStFeed, (ViewGroup.LayoutParams)localObject1);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = ViewUtils.a(H(), 16.0F, "#222222", HardCodeUtil.a(2131899721));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    localLayoutParams.leftMargin = ImmersiveUtils.dpToPx(14.0F);
    paramBundle.setLayoutParams(localLayoutParams);
    this.b = c(paramBundle);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.isOutOfArrayIndex(paramInt, N()))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(N().get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).setExtraTypeInfo(K());
    }
  }
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void a(HorizontalRvInnerView paramHorizontalRvInnerView)
  {
    if (((B().a(0) instanceof DetailBaseBlock)) && (((DetailBaseBlock)B().a(0)).d() != null)) {
      ((DetailBaseBlock)B().a(0)).d().a(paramHorizontalRvInnerView);
    }
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.a(paramString, paramShareData);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramShareData.a != null))
    {
      this.a = ((CertifiedAccountMeta.StFeed)paramShareData.a);
      if (M() != null) {
        M().post(new CommodityAdapter.2(this));
      }
    }
  }
  
  public int c()
  {
    return 3;
  }
  
  public int d()
  {
    return N().size();
  }
  
  public int getItemCount()
  {
    if (N().size() > 0) {
      return 3;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 100001;
      }
      return 100002;
    }
    return 100000;
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    case 100001: 
      return new BaseListViewAdapter.BaseVH(this, f());
    }
    return new BaseListViewAdapter.BaseVH(this, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.CommodityAdapter
 * JD-Core Version:    0.7.0.1
 */