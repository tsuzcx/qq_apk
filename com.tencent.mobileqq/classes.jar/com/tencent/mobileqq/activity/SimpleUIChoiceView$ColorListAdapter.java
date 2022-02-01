package com.tencent.mobileqq.activity;

import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SimpleUIChoiceView$ColorListAdapter
  extends RecyclerView.Adapter<SimpleUIChoiceView.ColorHolder>
{
  List<SimpleUIChoiceView.ColorItemInfo> a;
  private int c;
  
  public SimpleUIChoiceView$ColorListAdapter(List<SimpleUIChoiceView.ColorItemInfo> paramList)
  {
    Object localObject;
    this.a = localObject;
    this.c = SimpleUIUtil.i();
  }
  
  private void b(int paramInt)
  {
    SimpleUIChoiceView.ColorItemInfo localColorItemInfo = a(paramInt);
    if ((localColorItemInfo != null) && (a(localColorItemInfo, paramInt, localColorItemInfo.c ^ true)) && (SimpleUIChoiceView.c(this.b) != null)) {
      SimpleUIChoiceView.c(this.b).a(localColorItemInfo.f);
    }
  }
  
  public SimpleUIChoiceView.ColorHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = SimpleUIChoiceView.a(this.b).getLayoutInflater().inflate(2131629291, paramViewGroup, false);
    return new SimpleUIChoiceView.ColorHolder(this.b, paramViewGroup);
  }
  
  public SimpleUIChoiceView.ColorItemInfo a(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (SimpleUIChoiceView.ColorItemInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(SimpleUIChoiceView.ColorHolder paramColorHolder, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      if (((SimpleUIChoiceView.ColorItemInfo)localObject).c)
      {
        paramColorHolder.b.setVisibility(0);
        ViewCompat.setAccessibilityDelegate(paramColorHolder.a, new SimpleUIChoiceView.ColorListAdapter.1(this));
      }
      else
      {
        paramColorHolder.b.setVisibility(8);
        ViewCompat.setAccessibilityDelegate(paramColorHolder.a, new SimpleUIChoiceView.ColorListAdapter.2(this));
      }
      SimpleUIChoiceView.a(this.b, paramColorHolder.a, (SimpleUIChoiceView.ColorItemInfo)localObject);
      if (((SimpleUIChoiceView.ColorItemInfo)localObject).e)
      {
        paramColorHolder.c.setVisibility(0);
        ((Animatable)paramColorHolder.c.getBackground()).start();
      }
      else
      {
        paramColorHolder.c.setVisibility(8);
        ((Animatable)paramColorHolder.c.getBackground()).stop();
      }
      localObject = paramColorHolder.itemView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(SimpleUIChoiceView.a[paramInt]);
      localStringBuilder.append("按钮");
      ((View)localObject).setContentDescription(localStringBuilder.toString());
      paramColorHolder.itemView.setOnClickListener(new SimpleUIChoiceView.ColorListAdapter.3(this, paramInt));
      paramColorHolder.a();
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramColorHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<SimpleUIChoiceView.ColorItemInfo> paramList)
  {
    this.a = paramList;
  }
  
  public boolean a(SimpleUIChoiceView.ColorItemInfo paramColorItemInfo, int paramInt, boolean paramBoolean)
  {
    if (this.c == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramColorItemInfo.c = paramBoolean;
    if (paramColorItemInfo.c)
    {
      int i = this.c;
      if (i < 0)
      {
        this.c = paramInt;
      }
      else
      {
        paramColorItemInfo = a(i);
        if (paramColorItemInfo != null)
        {
          paramColorItemInfo.c = false;
          paramColorItemInfo.e = false;
          notifyItemChanged(this.c);
        }
        this.c = paramInt;
      }
    }
    notifyItemChanged(paramInt);
    return true;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter
 * JD-Core Version:    0.7.0.1
 */