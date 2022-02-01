package com.tencent.mm.ui.widget.menu;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ui.base.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MMPopupMenu$SubmenuAdapter
  extends BaseAdapter
{
  private MMPopupMenu$SubmenuAdapter(MMPopupMenu paramMMPopupMenu) {}
  
  public int getCount()
  {
    return MMPopupMenu.a(this.a).size();
  }
  
  public String getItem(int paramInt)
  {
    return (String)((MenuItem)MMPopupMenu.a(this.a).getItemList().get(paramInt)).getTitle();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView;
    if (paramView == null) {
      localTextView = (TextView)MMPopupMenu.g(this.a).inflate(2131625594, paramViewGroup, false);
    } else if ((paramView instanceof TextView)) {
      localTextView = (TextView)paramView;
    } else {
      localTextView = null;
    }
    String str = getItem(paramInt);
    if (localTextView != null)
    {
      localTextView.setTag(str);
      localTextView.setText(str);
      localTextView.setBackgroundResource(2130842529);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu.SubmenuAdapter
 * JD-Core Version:    0.7.0.1
 */