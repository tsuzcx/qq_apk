package com.tencent.mobileqq.activity.contacts.fragment;

import ails;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment$ContactsPinnedHeaderExpandableListView
  extends SwipPinnedHeaderExpandableListView
{
  private boolean a = true;
  
  public TroopFragment$ContactsPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopFragment$ContactsPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopFragment$ContactsPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    if (this.a) {
      super.a(paramInt1, paramInt2, paramView, paramInt3);
    }
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if ((localExpandableListAdapter instanceof ails)) {
      ((ails)localExpandableListAdapter).b(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.TroopFragment.ContactsPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */