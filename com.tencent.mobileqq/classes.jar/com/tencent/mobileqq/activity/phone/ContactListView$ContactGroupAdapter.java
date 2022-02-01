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
    return 2131559545;
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.a.a != null) && (!this.a.a.isEmpty()) && (paramInt >= 0))
    {
      if (paramInt >= this.a.a.size()) {
        return;
      }
      PhoneContact localPhoneContact2 = (PhoneContact)this.a.a.get(paramInt);
      PhoneContact localPhoneContact1 = localPhoneContact2;
      if (localPhoneContact2 == null)
      {
        paramInt += 1;
        localPhoneContact1 = localPhoneContact2;
        if (paramInt < this.a.a.size()) {
          localPhoneContact1 = (PhoneContact)this.a.a.get(paramInt);
        }
      }
      if (localPhoneContact1 == null) {
        return;
      }
      ((TextView)paramView).setText(localPhoneContact1.pinyinFirst);
    }
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
    ArrayList localArrayList = this.a.a;
    int i = 1;
    if (localArrayList != null)
    {
      if (this.a.a.isEmpty()) {
        return 1;
      }
      if (this.a.a.get(paramInt) == null) {
        return 1;
      }
      i = 0;
    }
    return i;
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
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.a();
        localView.setOnClickListener(this.a);
      }
      paramView = (PhoneContact)this.a.a.get(paramInt);
      this.a.a(localView, paramView, false);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.ContactGroupAdapter
 * JD-Core Version:    0.7.0.1
 */