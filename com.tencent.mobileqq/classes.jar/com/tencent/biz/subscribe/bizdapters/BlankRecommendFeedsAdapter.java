package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class BlankRecommendFeedsAdapter
  extends MultiViewBlock<CertifiedAccountMeta.StFollowRcmd>
{
  public static String a = "BlankRecommendFeedsAdapter";
  public static int b = ImmersiveUtils.dpToPx(12.0F);
  private int c = ImmersiveUtils.dpToPx(20.0F);
  private int d = ImmersiveUtils.dpToPx(12.5F);
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private boolean k = true;
  private boolean l = false;
  
  public BlankRecommendFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(H()).inflate(2131624352, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131436542);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.g)
    {
      if (localURLImageView != null) {
        localURLImageView.setColorFilter(-1728053248);
      }
      ((TextView)paramViewGroup.findViewById(2131448896)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131432025).setBackgroundColor(-14540254);
      return paramViewGroup;
    }
    if (localURLImageView != null) {
      localURLImageView.clearColorFilter();
    }
    return paramViewGroup;
  }
  
  private void a(List<CertifiedAccountMeta.StFollowRcmd> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    D().a(paramBoolean);
    D().a(paramStCommonExt);
    if ((paramList != null) && (paramList.size() > 0)) {
      b((ArrayList)paramList);
    }
    d(true);
  }
  
  private View b(ViewGroup paramViewGroup)
  {
    VSReporter.b("auth_follow", "exp_more", 0, 0, new String[0]);
    paramViewGroup = LayoutInflater.from(H()).inflate(2131624351, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131437542);
    if (localLinearLayout != null)
    {
      GradientDrawable localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      int i;
      if (this.g) {
        i = -13224394;
      } else {
        i = -460552;
      }
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new BlankRecommendFeedsAdapter.2(this));
    }
    if (this.g) {
      ((TextView)paramViewGroup.findViewById(2131448895)).setTextColor(-5723992);
    }
    return paramViewGroup;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.c;
      int i = b;
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = this.d;
      return;
    }
    if (paramView.getId() == 2131445155)
    {
      paramRect.top = ImmersiveUtils.dpToPx(19.5F);
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.bottom = (-ImmersiveUtils.dpToPx(30.0F));
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    super.b();
    this.l = false;
  }
  
  public int c()
  {
    return 2;
  }
  
  public COMM.StCommonExt d()
  {
    if (D().f() != null) {
      return D().f();
    }
    return null;
  }
  
  public int getItemCount()
  {
    int j = this.j.size();
    if (!this.l)
    {
      if (j > 0)
      {
        int i = j;
        if (this.e) {
          i = j + 1;
        }
        j = i;
        if (this.f) {
          j = i + 1;
        }
        return j;
      }
      return 0;
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.e) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (!ArrayUtils.isOutOfArrayIndex(i, N())) {
      return 100002;
    }
    return 100001;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.e) {
      i = paramInt - 1;
    }
    if (!ArrayUtils.isOutOfArrayIndex(i, N()))
    {
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)N().get(i);
      ((BlankRecommendFeedsAdapter.RecommendFeedVH)paramViewHolder).a(localStFollowRcmd, i);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new BlankRecommendFeedsAdapter.RecommendFeedVH(this, a(paramViewGroup));
    }
    if (paramInt == 100001) {
      return new BlankRecommendFeedsAdapter.RecommendFeedVH(this, b(paramViewGroup));
    }
    paramViewGroup = new BlankRecommendItemView(paramViewGroup.getContext());
    paramViewGroup.setIsInNightMode(this.g);
    return new BlankRecommendFeedsAdapter.RecommendFeedVH(this, paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */