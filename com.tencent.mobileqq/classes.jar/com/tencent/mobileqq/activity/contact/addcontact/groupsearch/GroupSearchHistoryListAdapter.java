package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GroupSearchHistoryListAdapter
  extends BaseAdapter
{
  protected Context a;
  protected View b;
  private String c;
  private List<String> d;
  private GroupSearchHistoryListAdapter.OnItemClickListener e;
  
  public GroupSearchHistoryListAdapter(Context paramContext, View paramView, String paramString)
  {
    this.a = paramContext;
    this.b = paramView;
    this.c = paramString;
    this.d = GroupSearchHistoryManager.a().a(paramString);
    paramContext = this.d;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  private boolean a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 != null) && (paramList2 != null) && (paramList1.size() == paramList2.size())) {
      return paramList1.equals(paramList2);
    }
    return false;
  }
  
  public String a(int paramInt)
  {
    return (String)this.d.get(paramInt);
  }
  
  public void a()
  {
    ArrayList localArrayList = GroupSearchHistoryManager.a().a(this.c);
    if (a(this.d, localArrayList)) {
      return;
    }
    this.d = localArrayList;
    if (this.d.isEmpty()) {
      this.b.setVisibility(8);
    } else {
      this.b.setVisibility(0);
    }
    notifyDataSetChanged();
  }
  
  public void a(GroupSearchHistoryListAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.e = paramOnItemClickListener;
  }
  
  public int getCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2131625851, paramViewGroup, false);
      paramView = new GroupSearchHistoryListAdapter.ViewHolder(this);
      paramView.c = ((ImageView)localView.findViewById(2131435058));
      paramView.d = ((TextView)localView.findViewById(2131435059));
      paramView.e = ((PressEffectImageView)localView.findViewById(2131444937));
      paramView.b = localView.findViewById(2131432033);
      paramView.a = localView;
      localObject = (LinearLayout.LayoutParams)paramView.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayHelper.dp2px(this.a, 16);
      paramView.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (GroupSearchHistoryListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    paramView.f = paramInt;
    if (this.d != null) {
      paramView.d.setText((CharSequence)this.d.get(paramInt));
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.d.setTextColor(Color.parseColor("#A8A8A8"));
      paramView.c.setImageResource(2130847898);
      paramView.a.setBackgroundResource(2130839569);
      paramView.e.setImageResource(2130847897);
    }
    else
    {
      paramView.d.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.c.setImageResource(2130847684);
      paramView.a.setBackgroundResource(2130839568);
      paramView.e.setImageResource(2130847682);
    }
    paramView.b.setVisibility(8);
    localView.setOnClickListener(paramView);
    paramView.e.setOnClickListener(paramView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryListAdapter
 * JD-Core Version:    0.7.0.1
 */