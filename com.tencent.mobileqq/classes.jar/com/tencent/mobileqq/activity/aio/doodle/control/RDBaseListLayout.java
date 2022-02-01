package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public abstract class RDBaseListLayout<TItemData, TItemViewHolder>
  extends RelativeLayout
{
  private RDBaseListLayout<TItemData, TItemViewHolder>.RDBaseListAdapter a;
  private ArrayList<TItemData> b = new ArrayList();
  private int c = -1;
  private int d = 0;
  private View e;
  
  public RDBaseListLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.e = new HorizontalListView(getContext());
      ((HorizontalListView)this.e).setOverScrollMode(2);
      this.e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((HorizontalListView)this.e).setAdapter(this.a);
      addView(this.e);
      return;
    }
    ScrollView localScrollView = new ScrollView(getContext());
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(localScrollView);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localScrollView.addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    this.e = new ListView(getContext());
    this.e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((ListView)this.e).setAdapter(this.a);
    localLinearLayout.addView(this.e);
  }
  
  private RDBaseListLayout<TItemData, TItemViewHolder>.ViewTagData b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (Object localObject = paramView;; localObject = (View)localObject)
    {
      localObject = ((View)localObject).getTag();
      if ((localObject != null) && ((localObject instanceof RDBaseListLayout.ViewTagData))) {
        return (RDBaseListLayout.ViewTagData)localObject;
      }
      localObject = paramView.getParent();
      if (!(localObject instanceof View)) {
        break;
      }
    }
    return null;
  }
  
  public int a(View paramView)
  {
    paramView = b(paramView);
    if (paramView != null) {
      return paramView.b;
    }
    return -1;
  }
  
  public abstract TItemViewHolder a(int paramInt, TItemData paramTItemData);
  
  public abstract void a(int paramInt, @NonNull TItemData paramTItemData, @NonNull TItemViewHolder paramTItemViewHolder);
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.b.size()) {
        return;
      }
      if (!paramBoolean)
      {
        int i = this.c;
        if (i >= 0)
        {
          ((RDBaseItemData)this.b.get(i)).a(false);
          this.c = -1;
        }
      }
      Object localObject1 = this.b.get(paramInt);
      Object localObject2 = (RDBaseItemData)localObject1;
      ((RDBaseItemData)localObject2).a(true);
      ((RDBaseItemData)localObject2).a(true);
      localObject2 = this.e;
      if ((localObject2 instanceof ListView))
      {
        ((ListView)localObject2).setSelection(paramInt);
      }
      else if ((localObject2 instanceof HorizontalListView))
      {
        ((HorizontalListView)localObject2).setSelection(paramInt);
        ((HorizontalListView)this.e).smoothScrollToPosition(paramInt, 0, 1);
      }
      b(paramInt, localObject1);
      this.c = paramInt;
      d();
    }
  }
  
  public void a(TItemData paramTItemData, boolean paramBoolean)
  {
    this.b.add(paramTItemData);
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(List<TItemData> paramList, boolean paramBoolean)
  {
    this.b.addAll(paramList);
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void b(int paramInt, TItemData paramTItemData);
  
  public void b(TItemData paramTItemData, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.b.size())
    {
      Object localObject = this.b.get(i);
      if (paramTItemData.equals(localObject))
      {
        if (!paramBoolean)
        {
          int j = this.c;
          if (j >= 0)
          {
            ((RDBaseItemData)this.b.get(j)).a(false);
            this.c = -1;
          }
        }
        ((RDBaseItemData)localObject).a(true);
        paramTItemData = this.e;
        if ((paramTItemData instanceof ListView))
        {
          ((ListView)paramTItemData).setSelection(i);
        }
        else if ((paramTItemData instanceof HorizontalListView))
        {
          ((HorizontalListView)paramTItemData).setSelection(i);
          ((HorizontalListView)this.e).smoothScrollToPosition(i, 0, 1);
        }
        b(i, localObject);
        this.c = i;
        d();
        return;
      }
      i += 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    this.d = paramInt;
    this.a = new RDBaseListLayout.RDBaseListAdapter(this, null);
    this.a.a();
    a(this.d);
    boolean bool = a();
    if (bool) {
      this.a.notifyDataSetChanged();
    }
    return bool;
  }
  
  public TItemData c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public void c()
  {
    b();
    RDBaseListLayout.RDBaseListAdapter localRDBaseListAdapter = this.a;
    if (localRDBaseListAdapter != null) {
      localRDBaseListAdapter.b();
    }
  }
  
  public void d()
  {
    RDBaseListLayout.RDBaseListAdapter localRDBaseListAdapter = this.a;
    if (localRDBaseListAdapter != null) {
      localRDBaseListAdapter.notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public TItemData getSelectData()
  {
    if ((this.c >= 0) && (!this.b.isEmpty())) {
      return this.b.get(this.c);
    }
    return null;
  }
  
  public int getSelectIndex()
  {
    return this.c;
  }
  
  public int getType()
  {
    return this.d;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    View localView = this.e;
    if (localView != null) {
      localView.setOverScrollMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
 * JD-Core Version:    0.7.0.1
 */