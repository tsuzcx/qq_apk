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
  public static int a;
  public static String a;
  private int b = ImmersiveUtils.dpToPx(20.0F);
  private int jdField_c_of_type_Int = ImmersiveUtils.dpToPx(12.5F);
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BlankRecommendFeedsAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.dpToPx(12.0F);
  }
  
  public BlankRecommendFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558834, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131369781);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.e)
    {
      if (localURLImageView != null) {
        localURLImageView.setColorFilter(-1728053248);
      }
      ((TextView)paramViewGroup.findViewById(2131380725)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131365931).setBackgroundColor(-14540254);
    }
    while (localURLImageView == null) {
      return paramViewGroup;
    }
    localURLImageView.clearColorFilter();
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
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558833, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131370654);
    GradientDrawable localGradientDrawable;
    if (localLinearLayout != null)
    {
      localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      if (!this.e) {
        break label102;
      }
    }
    label102:
    for (int i = -13224394;; i = -460552)
    {
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new BlankRecommendFeedsAdapter.2(this));
      if (this.e) {
        ((TextView)paramViewGroup.findViewById(2131380724)).setTextColor(-5723992);
      }
      return paramViewGroup;
    }
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
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.b;
      paramRect.left = jdField_a_of_type_Int;
      paramRect.right = jdField_a_of_type_Int;
      paramRect.bottom = this.jdField_c_of_type_Int;
    }
    while (paramView.getId() != 2131377372) {
      return;
    }
    paramRect.top = ImmersiveUtils.dpToPx(19.5F);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = (-ImmersiveUtils.dpToPx(30.0F));
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
    if (ArrayUtils.a(i, b())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
      return;
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)b().get(i);
      ((BlankRecommendFeedsAdapter.RecommendFeedVH)paramViewHolder).a(localStFollowRcmd, i);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */