package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class ContactsFPSPinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private boolean a = true;
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void scrollItemView(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    if (this.a) {
      super.scrollItemView(paramInt1, paramInt2, paramView, paramInt3);
    }
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    ExpandableListAdapter localExpandableListAdapter = getExpandableListAdapter();
    if ((localExpandableListAdapter instanceof BuddyListAdapter)) {
      ((BuddyListAdapter)localExpandableListAdapter).a(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */