package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class SubscribeDraftAdapter
  extends MultiViewBlock<SubscribeDraftBean>
  implements SimpleEventReceiver
{
  public static String a = "SubscribeDraftAdapter";
  public static int b = ImmersiveUtils.dpToPx(4.0F);
  private int c = ImmersiveUtils.dpToPx(19.0F);
  private int d = ImmersiveUtils.dpToPx(3.0F);
  private String e;
  
  public SubscribeDraftAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a(int paramInt)
  {
    return 2;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0)
    {
      paramRect.left = b;
      paramRect.right = (this.d / 2);
    }
    else
    {
      paramRect.left = (this.d / 2);
      paramRect.right = b;
    }
    paramRect.bottom = this.c;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo)
  {
    if ((paramLoadInfo.d()) || (paramLoadInfo.c())) {
      d();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int c()
  {
    return 1;
  }
  
  public void d()
  {
    if ((B() != null) && (H() != null) && (((PublicFragmentActivity)H()).app != null))
    {
      this.e = ((PublicFragmentActivity)H()).app.getAccount();
      if (SubscribeDraftManager.a().a(this.e))
      {
        SubscribeDraftManager.a().a(this.e, new SubscribeDraftAdapter.1(this));
        return;
      }
      b();
      notifyDataSetChanged();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    return localArrayList;
  }
  
  public int getItemCount()
  {
    return this.j.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof SubscribeDraftAdapter.DraftVH)) {
      ((SubscribeDraftAdapter.DraftVH)paramViewHolder).a((SubscribeDraftBean)N().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new SubscribeDraftAdapter.DraftVH(this, new SubScribeDraftItemView(paramViewGroup.getContext(), this));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubDraftChangeEvent)) {
      d();
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter
 * JD-Core Version:    0.7.0.1
 */