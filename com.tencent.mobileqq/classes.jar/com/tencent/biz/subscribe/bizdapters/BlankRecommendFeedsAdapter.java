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
  public static int a = 0;
  public static String a = "BlankRecommendFeedsAdapter";
  private int b = ImmersiveUtils.dpToPx(20.0F);
  private int jdField_c_of_type_Int = ImmersiveUtils.dpToPx(12.5F);
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  
  static
  {
    jdField_a_of_type_Int = ImmersiveUtils.dpToPx(12.0F);
  }
  
  public BlankRecommendFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558732, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131369471);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.e)
    {
      if (localURLImageView != null) {
        localURLImageView.setColorFilter(-1728053248);
      }
      ((TextView)paramViewGroup.findViewById(2131379993)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131365768).setBackgroundColor(-14540254);
      return paramViewGroup;
    }
    if (localURLImageView != null) {
      localURLImageView.clearColorFilter();
    }
    return paramViewGroup;
  }
  
  private void a(List<CertifiedAccountMeta.StFollowRcmd> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a().a(paramBoolean);
    a().a(paramStCommonExt);
    if ((paramList != null) && (paramList.size() > 0)) {
      a((ArrayList)paramList);
    }
    d(true);
  }
  
  private View b(ViewGroup paramViewGroup)
  {
    VSReporter.b("auth_follow", "exp_more", 0, 0, new String[0]);
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558731, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131370297);
    if (localLinearLayout != null)
    {
      GradientDrawable localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      int i;
      if (this.e) {
        i = -13224394;
      } else {
        i = -460552;
      }
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new BlankRecommendFeedsAdapter.2(this));
    }
    if (this.e) {
      ((TextView)paramViewGroup.findViewById(2131379992)).setTextColor(-5723992);
    }
    return paramViewGroup;
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public COMM.StCommonExt a()
  {
    if (a().a() != null) {
      return a().a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.g = false;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.b;
      int i = jdField_a_of_type_Int;
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = this.jdField_c_of_type_Int;
      return;
    }
    if (paramView.getId() == 2131376824)
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
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int getItemCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (!this.g)
    {
      if (j > 0)
      {
        int i = j;
        if (this.jdField_c_of_type_Boolean) {
          i = j + 1;
        }
        j = i;
        if (this.d) {
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
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (!ArrayUtils.a(i, b())) {
      return 100002;
    }
    return 100001;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (!ArrayUtils.a(i, b()))
    {
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)b().get(i);
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
    paramViewGroup.setIsInNightMode(this.e);
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