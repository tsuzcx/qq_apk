package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetPinnedHeaderListView;
import com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment.ContactsPinnedHeaderExpandableListView;

public class HeaderScrollHelper
{
  private int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private HeaderScrollHelper.ScrollableContainer jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper$ScrollableContainer;
  
  private View a()
  {
    HeaderScrollHelper.ScrollableContainer localScrollableContainer = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper$ScrollableContainer;
    if (localScrollableContainer == null) {
      return null;
    }
    return localScrollableContainer.a();
  }
  
  private boolean a(android.widget.AdapterView paramAdapterView)
  {
    if ((paramAdapterView != null) && (paramAdapterView.getFirstVisiblePosition() == 0))
    {
      paramAdapterView = paramAdapterView.getChildAt(0);
      if ((paramAdapterView == null) || (paramAdapterView.getTop() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ScrollView paramScrollView)
  {
    boolean bool = true;
    if (paramScrollView != null)
    {
      if (paramScrollView.getScrollY() <= 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(com.tencent.widget.AdapterView paramAdapterView)
  {
    if ((paramAdapterView != null) && (paramAdapterView.getFirstVisiblePosition() == 0))
    {
      paramAdapterView = paramAdapterView.getChildAt(0);
      if ((paramAdapterView == null) || (paramAdapterView.getTop() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = a();
    if ((localView instanceof android.widget.AbsListView))
    {
      ((android.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
      return;
    }
    if ((localView instanceof com.tencent.widget.AbsListView))
    {
      ((com.tencent.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
      return;
    }
    if ((localView instanceof ScrollView))
    {
      ((ScrollView)localView).fling(paramInt1);
      return;
    }
    if ((localView instanceof WebView)) {
      ((WebView)localView).flingScroll(0, paramInt1);
    }
  }
  
  public void a(HeaderScrollHelper.ScrollableContainer paramScrollableContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollHelper$ScrollableContainer = paramScrollableContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = a();
    if (localView != null)
    {
      if ((localView instanceof ContactsFPSPinnedHeaderExpandableListView))
      {
        ((ContactsFPSPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
        return;
      }
      if ((localView instanceof TroopFragment.ContactsPinnedHeaderExpandableListView))
      {
        ((TroopFragment.ContactsPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
        return;
      }
      if ((localView instanceof AlphabetPinnedHeaderListView)) {
        ((AlphabetPinnedHeaderListView)localView).setChildViewCanAction(paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    View localView = a();
    if (localView == null) {
      return true;
    }
    if ((localView instanceof com.tencent.widget.AdapterView)) {
      return a((com.tencent.widget.AdapterView)localView);
    }
    if ((localView instanceof android.widget.AdapterView)) {
      return a((android.widget.AdapterView)localView);
    }
    if ((localView instanceof ScrollView)) {
      return a((ScrollView)localView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.HeaderScrollHelper
 * JD-Core Version:    0.7.0.1
 */