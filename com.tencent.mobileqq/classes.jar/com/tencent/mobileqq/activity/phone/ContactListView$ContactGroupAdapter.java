package com.tencent.mobileqq.activity.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ContactListView$ContactGroupAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private ContactListView$ContactGroupAdapter(ContactListView paramContactListView) {}
  
  public int a()
  {
    return 2131559667;
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.isEmpty()) || (paramInt < 0) || (paramInt >= this.a.a.size())) {}
    PhoneContact localPhoneContact1;
    do
    {
      return;
      PhoneContact localPhoneContact2 = (PhoneContact)this.a.a.get(paramInt);
      localPhoneContact1 = localPhoneContact2;
      if (localPhoneContact2 == null)
      {
        localPhoneContact1 = localPhoneContact2;
        if (paramInt + 1 < this.a.a.size()) {
          localPhoneContact1 = (PhoneContact)this.a.a.get(paramInt + 1);
        }
      }
    } while (localPhoneContact1 == null);
    ((TextView)paramView).setText(localPhoneContact1.pinyinFirst);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 1;
  }
  
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.isEmpty())) {}
    while (this.a.a.get(paramInt) == null) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItemViewType(paramInt) == 1)
    {
      localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(this.a.getContext()).inflate(a(), paramViewGroup, false);
      }
      a(localView, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.a();
        localView.setOnClickListener(this.a);
      }
      paramView = (PhoneContact)this.a.a.get(paramInt);
      this.a.a(localView, paramView, false);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.ContactGroupAdapter
 * JD-Core Version:    0.7.0.1
 */