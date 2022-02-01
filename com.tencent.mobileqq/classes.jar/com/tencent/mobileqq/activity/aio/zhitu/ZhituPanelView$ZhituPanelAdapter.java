package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ZhituPanelView$ZhituPanelAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public List<ZhituPicData> a = new ArrayList();
  public List<ZhituPicData> b = new ArrayList();
  public String c;
  public int d;
  public boolean e = true;
  public View f;
  
  public ZhituPanelView$ZhituPanelAdapter(ZhituPanelView paramZhituPanelView)
  {
    int i = 0;
    while (i < ZhituPanelView.a)
    {
      this.b.add(new ZhituPicData());
      i += 1;
    }
    this.a.addAll(this.b);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.c(), 2, "loadMorePic");
    }
    int i = this.a.size();
    if (i != 0)
    {
      if (TextUtils.isEmpty(((ZhituPicData)this.a.get(i - 1)).f)) {
        return;
      }
      if (i > this.d)
      {
        this.d = i;
        ZhituManager.a(this.g.b.d).a(this.a.size(), this.c);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ZhituPicAdapter setPicItemCount: picCount = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mReqKey = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",this.mReqKey =");
      localStringBuilder.append(this.c);
      QLog.i("ZhituManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    if (paramInt > 0)
    {
      if (!paramString.equals(this.c))
      {
        this.a.clear();
        ReportController.b(this.g.b.d, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.a(ZhituManager.a(this.g.b.d).a()), 0, "", "", "", "");
      }
      this.c = paramString;
      while (i < paramInt)
      {
        this.a.add(new ZhituPicData());
        i += 1;
      }
      this.d = -1;
      this.e = true;
      notifyDataSetChanged();
      return;
    }
    this.e = false;
    notifyDataSetChanged();
  }
  
  public void a(View paramView)
  {
    this.f = paramView;
    notifyItemInserted(0);
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (paramZhituPicData != null)
    {
      int i = paramZhituPicData.g;
      if ((i >= 0) && (i < this.a.size()))
      {
        ZhituPicData localZhituPicData = (ZhituPicData)this.a.get(i);
        localZhituPicData.a(paramZhituPicData);
        if ((this.g.getZhituUIStyle() != 1) && (localZhituPicData.p))
        {
          if ((ZhituPanelView.b(this.g) != null) && (ZhituPanelView.b(this.g) != localZhituPicData)) {
            ZhituPanelView.b(this.g).p = false;
          }
          ZhituPanelView.a(this.g, localZhituPicData);
        }
      }
      notifyDataSetChanged();
      if ((this.g.getZhituUIStyle() != 1) && (i == 0))
      {
        ZhituPanelView.c(this.g).setEnabled(true);
        ZhituPanelView.c(this.g).setVisibility(0);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = ZhituPanelView.c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.a.clear();
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131450397);
      if (localObject != null)
      {
        this.e = false;
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramString);
        paramString = this.f.getLayoutParams();
        paramString.height = -1;
        this.f.setLayoutParams(paramString);
      }
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.c(), 2, "[ZhituPicAdapter]-resetData");
    }
    this.a.clear();
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131450397);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        localObject = this.f.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -2;
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.a.addAll(this.b);
    this.c = "";
    this.d = -1;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      j = 0;
    } else {
      j = localList.size();
    }
    int i = j;
    if (this.e) {
      i = j + 1;
    }
    int j = i;
    if (this.f != null) {
      j = i + 1;
    }
    return j;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.f != null) && (paramInt == 0)) {
      return 3;
    }
    if ((this.e) && (paramInt + 1 == getItemCount())) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ZhituPanelView.ZhituPanelAdapter.1(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((getItemViewType(paramInt) != 3) && ((paramViewHolder instanceof ZhituPanelView.ZhituViewHolder)))
    {
      int i;
      if (this.f == null) {
        i = paramInt;
      } else {
        i = paramInt - 1;
      }
      ZhituPanelView.ZhituViewHolder localZhituViewHolder = (ZhituPanelView.ZhituViewHolder)paramViewHolder;
      ZhituPicData localZhituPicData = (ZhituPicData)this.a.get(i);
      localZhituViewHolder.e = new WeakReference(localZhituPicData);
      localZhituViewHolder.c.setVisibility(0);
      localZhituViewHolder.d.setChecked(localZhituPicData.p);
      Object localObject3;
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localZhituPicData.e)
      {
        localObject3 = ZhituManager.a(this.g.b.d).f(localZhituPicData);
        localObject1 = ZhituManager.a((String)localObject3);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          ZhituManager.a(this.g.b.d).d(localZhituPicData);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = ZhituPanelView.c();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("get gif image from cache fail, ");
            localStringBuilder.append((String)localObject3);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
            localObject2 = localObject1;
          }
        }
      }
      else
      {
        localObject2 = null;
      }
      localZhituViewHolder.a.getLayoutParams().height = ZhituPanelView.d(this.g);
      if (this.g.getZhituUIStyle() == 1)
      {
        if ((localZhituPicData.i == null) && (localObject2 == null))
        {
          localObject1 = ZhituPanelView.c();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ZhituTest has no drawable data is ");
          ((StringBuilder)localObject2).append(localZhituPicData.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          localZhituViewHolder.b.setImageDrawable(ZhituPanelView.e(this.g));
          localZhituViewHolder.c.setVisibility(0);
          localZhituViewHolder.d.setVisibility(8);
        }
        else
        {
          localObject1 = ZhituPanelView.c();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ZhituTest has a drawable data is ");
          ((StringBuilder)localObject3).append(localZhituPicData.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject1 = localZhituPicData.i;
          localObject3 = localZhituViewHolder.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localZhituPicData.a);
          localStringBuilder.append(localZhituPicData.h);
          ((BubbleImageView)localObject3).setTag(localStringBuilder.toString());
          if (localObject2 != null) {
            localObject1 = new GifDrawable((AbstractGifImage)localObject2);
          }
          localZhituViewHolder.b.setImageDrawable((Drawable)localObject1);
          localZhituViewHolder.b.setBackgroundDrawable(null);
          localZhituViewHolder.c.setVisibility(8);
        }
      }
      else if ((localZhituPicData.i == null) && (localObject2 == null))
      {
        localZhituViewHolder.b.setImageDrawable(ZhituPanelView.e(this.g));
        localZhituViewHolder.c.setVisibility(0);
        localZhituViewHolder.d.setVisibility(8);
      }
      else
      {
        localZhituViewHolder.a.setMinimumWidth(0);
        localObject3 = localZhituPicData.i;
        localObject1 = localZhituViewHolder.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localZhituPicData.a);
        localStringBuilder.append(localZhituPicData.h);
        ((BubbleImageView)localObject1).setTag(localStringBuilder.toString());
        localObject1 = localObject3;
        if (!localZhituPicData.p)
        {
          localObject1 = localObject3;
          if (!localZhituPicData.q)
          {
            localObject1 = localObject3;
            if (localZhituPicData.j != null) {
              localObject1 = localZhituPicData.j;
            }
          }
        }
        if (localObject2 != null) {
          localObject1 = new GifDrawable((AbstractGifImage)localObject2);
        }
        localZhituViewHolder.b.setImageDrawable((Drawable)localObject1);
        localZhituViewHolder.b.setBackgroundDrawable(null);
        localZhituViewHolder.c.setVisibility(8);
        localZhituViewHolder.d.setVisibility(0);
      }
      localZhituViewHolder.a.getLayoutParams().width = ZhituPanelView.d(this.g);
      if ((localZhituPicData.l != null) && (!localZhituPicData.l.i))
      {
        ZhituManager.a(this.g.b.d).b(localZhituPicData);
        localZhituPicData.l.i = true;
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return new ZhituPanelView.LoadFootViewHolder(this.g, this.f);
      }
      paramViewGroup = LayoutInflater.from(this.g.getContext()).inflate(2131629728, paramViewGroup, false);
      paramViewGroup = new ZhituPanelView.LoadFootViewHolder(this.g, paramViewGroup);
    }
    else
    {
      paramViewGroup = LayoutInflater.from(this.g.getContext()).inflate(2131629729, paramViewGroup, false);
      paramViewGroup = new ZhituPanelView.ZhituViewHolder(this.g, paramViewGroup);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter
 * JD-Core Version:    0.7.0.1
 */