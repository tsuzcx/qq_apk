package com.tencent.mm.ui.widget.listview;

import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

public abstract class AnimatedExpandableListView$AnimatedExpandableListAdapter
  extends BaseExpandableListAdapter
{
  private SparseArray<AnimatedExpandableListView.GroupInfo> a = new SparseArray();
  private AnimatedExpandableListView b;
  
  private AnimatedExpandableListView.GroupInfo a(int paramInt)
  {
    AnimatedExpandableListView.GroupInfo localGroupInfo2 = (AnimatedExpandableListView.GroupInfo)this.a.get(paramInt);
    AnimatedExpandableListView.GroupInfo localGroupInfo1 = localGroupInfo2;
    if (localGroupInfo2 == null)
    {
      localGroupInfo1 = new AnimatedExpandableListView.GroupInfo(null);
      this.a.put(paramInt, localGroupInfo1);
    }
    return localGroupInfo1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AnimatedExpandableListView.GroupInfo localGroupInfo = a(paramInt1);
    localGroupInfo.a = true;
    localGroupInfo.c = paramInt2;
    localGroupInfo.b = true;
  }
  
  private void a(AnimatedExpandableListView paramAnimatedExpandableListView)
  {
    this.b = paramAnimatedExpandableListView;
  }
  
  private void b(int paramInt)
  {
    a(paramInt).a = false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AnimatedExpandableListView.GroupInfo localGroupInfo = a(paramInt1);
    localGroupInfo.a = true;
    localGroupInfo.c = paramInt2;
    localGroupInfo.b = false;
  }
  
  public final int getChildType(int paramInt1, int paramInt2)
  {
    if (a(paramInt1).a) {
      return 0;
    }
    return getRealChildType(paramInt1, paramInt2) + 1;
  }
  
  public final int getChildTypeCount()
  {
    return getRealChildTypeCount() + 1;
  }
  
  public final View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    AnimatedExpandableListView.GroupInfo localGroupInfo = a(paramInt1);
    if (localGroupInfo.a)
    {
      Object localObject = paramView;
      paramView = (View)localObject;
      if (!(localObject instanceof AnimatedExpandableListView.DummyView))
      {
        paramView = new AnimatedExpandableListView.DummyView(paramViewGroup.getContext(), null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      }
      if (paramInt2 < localGroupInfo.c)
      {
        paramView.getLayoutParams().height = 0;
        return paramView;
      }
      ExpandableListView localExpandableListView = (ExpandableListView)paramViewGroup;
      localObject = (AnimatedExpandableListView.DummyView)paramView;
      ((AnimatedExpandableListView.DummyView)localObject).clearViews();
      AnimatedExpandableListView.DummyView.a((AnimatedExpandableListView.DummyView)localObject, localExpandableListView.getDivider(), paramViewGroup.getMeasuredWidth(), localExpandableListView.getDividerHeight());
      int k = View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824);
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = paramViewGroup.getHeight();
      int i = getRealChildrenCount(paramInt1);
      int j = localGroupInfo.c;
      paramInt2 = 0;
      while (j < i)
      {
        if (j == i - 1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        View localView = getRealChildView(paramInt1, j, paramBoolean, null, paramViewGroup);
        localView.measure(k, m);
        paramInt2 += localView.getMeasuredHeight();
        if (paramInt2 < n)
        {
          ((AnimatedExpandableListView.DummyView)localObject).addFakeView(localView);
          j += 1;
        }
        else
        {
          ((AnimatedExpandableListView.DummyView)localObject).addFakeView(localView);
          paramInt2 += (i - j - 1) * (paramInt2 / (j + 1));
        }
      }
      paramViewGroup = ((AnimatedExpandableListView.DummyView)localObject).getTag();
      if (paramViewGroup == null) {
        i = 0;
      } else {
        i = ((Integer)paramViewGroup).intValue();
      }
      if ((localGroupInfo.b) && (i != 1))
      {
        paramViewGroup = new AnimatedExpandableListView.ExpandAnimation((View)localObject, 0, paramInt2, localGroupInfo, null);
        paramViewGroup.setDuration(AnimatedExpandableListView.a(this.b));
        paramViewGroup.setAnimationListener(new AnimatedExpandableListView.AnimatedExpandableListAdapter.1(this, paramInt1, (AnimatedExpandableListView.DummyView)localObject));
        ((AnimatedExpandableListView.DummyView)localObject).startAnimation(paramViewGroup);
        ((AnimatedExpandableListView.DummyView)localObject).setTag(Integer.valueOf(1));
        return paramView;
      }
      if ((!localGroupInfo.b) && (i != 2))
      {
        if (localGroupInfo.d == -1) {
          localGroupInfo.d = paramInt2;
        }
        paramViewGroup = new AnimatedExpandableListView.ExpandAnimation((View)localObject, localGroupInfo.d, 0, localGroupInfo, null);
        paramViewGroup.setDuration(AnimatedExpandableListView.a(this.b));
        paramViewGroup.setAnimationListener(new AnimatedExpandableListView.AnimatedExpandableListAdapter.2(this, paramInt1, localExpandableListView, localGroupInfo, (AnimatedExpandableListView.DummyView)localObject));
        ((AnimatedExpandableListView.DummyView)localObject).startAnimation(paramViewGroup);
        ((AnimatedExpandableListView.DummyView)localObject).setTag(Integer.valueOf(2));
      }
      return paramView;
    }
    return getRealChildView(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public final int getChildrenCount(int paramInt)
  {
    AnimatedExpandableListView.GroupInfo localGroupInfo = a(paramInt);
    if (localGroupInfo.a) {
      return localGroupInfo.c + 1;
    }
    return getRealChildrenCount(paramInt);
  }
  
  public int getRealChildType(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getRealChildTypeCount()
  {
    return 1;
  }
  
  public abstract View getRealChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup);
  
  public abstract int getRealChildrenCount(int paramInt);
  
  public void notifyGroupExpanded(int paramInt)
  {
    a(paramInt).d = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.AnimatedExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */