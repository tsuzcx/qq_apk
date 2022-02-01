package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.util.List;

class RecommendBannerContentAdaper
  extends RecyclerView.Adapter<RecommendBannerContentAdaper.ViewHolder>
{
  protected List<RecommendInfoItem> a;
  protected CertifiedAccountMeta.StEntry b;
  private IRecommendBannerFlowListener c;
  private boolean d;
  private boolean e;
  private boolean f = false;
  
  public RecommendBannerContentAdaper.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    paramViewGroup = new RecyclerView.LayoutParams(DisplayUtil.a((Context)localObject, 144.0F), DisplayUtil.a((Context)localObject, 213.0F));
    if (paramInt == 3)
    {
      localObject = new RecommendBannerEntryItemView((Context)localObject);
      ((RecommendBannerEntryItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerEntryItemView)localObject).setIsCloseShadow(this.d);
      ((RecommendBannerEntryItemView)localObject).setInNightMode(this.e);
      return new RecommendBannerContentAdaper.ViewHolder(this, (View)localObject);
    }
    if (paramInt == 1)
    {
      localObject = new RecommendBannerItemView((Context)localObject);
      ((RecommendBannerItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerItemView)localObject).setIsCloseShadow(this.d);
      ((RecommendBannerItemView)localObject).setInNightMode(this.e);
      ((RecommendBannerItemView)localObject).setInNewFolderPage(this.f);
      return new RecommendBannerContentAdaper.ViewHolder(this, (View)localObject);
    }
    if (paramInt == 2)
    {
      localObject = new RecommendBannerFeedItemView((Context)localObject);
      ((RecommendBannerFeedItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerFeedItemView)localObject).setIsCloseShadow(this.d);
      ((RecommendBannerFeedItemView)localObject).setInNightMode(this.e);
      return new RecommendBannerContentAdaper.ViewHolder(this, (View)localObject);
    }
    return null;
  }
  
  public List<RecommendInfoItem> a()
  {
    return this.a;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList)
  {
    this.b = paramStEntry;
    this.a = paramList;
  }
  
  public void a(IRecommendBannerFlowListener paramIRecommendBannerFlowListener)
  {
    this.c = paramIRecommendBannerFlowListener;
  }
  
  public void a(RecommendBannerContentAdaper.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    int i = paramViewHolder.getAdapterPosition() - b();
    if ((!ArrayUtils.isOutOfArrayIndex(i, a())) && (a().get(i) != null)) {
      VSReporter.a(((RecommendInfoItem)a().get(i)).b.id.get(), "auth_page", "recom_exp", 0, 0, new String[] { "", "", String.valueOf(i), ((RecommendInfoItem)a().get(i)).b.nick.get() });
    }
  }
  
  public void a(RecommendBannerContentAdaper.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      if ((paramViewHolder.itemView instanceof RecommendBannerEntryItemView))
      {
        ((RecommendBannerEntryItemView)paramViewHolder.itemView).setEntry(this.b);
      }
      else
      {
        int i = paramInt - b();
        if ((paramViewHolder.itemView instanceof RecommendBannerItemView))
        {
          RecommendBannerItemView localRecommendBannerItemView = (RecommendBannerItemView)paramViewHolder.itemView;
          localRecommendBannerItemView.setData(((RecommendInfoItem)a().get(i)).b, i);
          localRecommendBannerItemView.setRecommendBannerFolwListener(this.c);
        }
        else if ((paramViewHolder.itemView instanceof RecommendBannerFeedItemView))
        {
          ((RecommendBannerFeedItemView)paramViewHolder.itemView).setData(((RecommendInfoItem)a().get(i)).c, i);
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected int b()
  {
    if (this.b != null) {
      return 1;
    }
    return 0;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (a() == null) {
      return b();
    }
    return a().size() + b();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.b != null)) {
      return 3;
    }
    return ((RecommendInfoItem)a().get(paramInt - b())).a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerContentAdaper
 * JD-Core Version:    0.7.0.1
 */