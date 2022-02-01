package com.tencent.mm.ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class AnimatedExpandableListView
  extends ExpandableListView
{
  private static final String a = AnimatedExpandableListView.AnimatedExpandableListAdapter.class.getSimpleName();
  private AnimatedExpandableListView.AnimatedExpandableListAdapter b;
  
  public AnimatedExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimatedExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimatedExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getAnimationDuration()
  {
    return 150;
  }
  
  public boolean collapseGroupWithAnimation(int paramInt)
  {
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i >= 0) && (i < getChildCount()))
      {
        if (getChildAt(i).getBottom() >= getBottom()) {
          return collapseGroup(paramInt);
        }
      }
      else {
        return collapseGroup(paramInt);
      }
    }
    long l = getExpandableListPosition(getFirstVisiblePosition());
    i = getPackedPositionChild(l);
    int j = getPackedPositionGroup(l);
    if ((i == -1) || (j != paramInt)) {
      i = 0;
    }
    AnimatedExpandableListView.AnimatedExpandableListAdapter.b(this.b, paramInt, i);
    this.b.notifyDataSetChanged();
    return isGroupExpanded(paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public boolean expandGroupWithAnimation(int paramInt)
  {
    int i = getFlatListPosition(getPackedPositionForGroup(paramInt));
    if (i != -1)
    {
      i -= getFirstVisiblePosition();
      if ((i < getChildCount()) && (getChildAt(i).getBottom() >= getBottom()))
      {
        this.b.notifyGroupExpanded(paramInt);
        return expandGroup(paramInt);
      }
    }
    AnimatedExpandableListView.AnimatedExpandableListAdapter.a(this.b, paramInt, 0);
    return expandGroup(paramInt);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof AnimatedExpandableListView.AnimatedExpandableListAdapter))
    {
      this.b = ((AnimatedExpandableListView.AnimatedExpandableListAdapter)paramExpandableListAdapter);
      AnimatedExpandableListView.AnimatedExpandableListAdapter.a(this.b, this);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramExpandableListAdapter.toString());
    localStringBuilder.append(" must implement AnimatedExpandableListAdapter");
    throw new ClassCastException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView
 * JD-Core Version:    0.7.0.1
 */