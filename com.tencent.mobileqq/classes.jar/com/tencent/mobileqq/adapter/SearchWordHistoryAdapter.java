package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SearchWordHistoryAdapter
  extends BaseAdapter
{
  protected Context a;
  protected SearchWordHistoryManager b;
  protected QQAppInterface c;
  protected View d;
  public List<String> e;
  protected int f;
  
  public SearchWordHistoryAdapter(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, int paramInt)
  {
    this.a = paramContext;
    this.c = paramQQAppInterface;
    this.d = paramView;
    this.f = paramInt;
    this.b = ((SearchWordHistoryManager)this.c.getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER));
  }
  
  public String a(int paramInt)
  {
    return (String)this.e.get(paramInt);
  }
  
  public void a()
  {
    this.e = this.b.b();
    if (this.e.isEmpty()) {
      this.d.setVisibility(8);
    } else {
      this.d.setVisibility(0);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.e;
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
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2131625851, paramViewGroup, false);
      paramView = new SearchWordHistoryAdapter.ViewHolder(this);
      paramView.c = ((ImageView)localView.findViewById(2131435058));
      paramView.d = ((TextView)localView.findViewById(2131435059));
      paramView.e = ((PressEffectImageView)localView.findViewById(2131444937));
      paramView.b = localView.findViewById(2131432033);
      paramView.a = localView;
      localView.setTag(paramView);
    }
    else
    {
      SearchWordHistoryAdapter.ViewHolder localViewHolder = (SearchWordHistoryAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    paramView.f = paramInt;
    if (this.e != null) {
      paramView.d.setText((CharSequence)this.e.get(paramInt));
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.d.setTextColor(Color.parseColor("#6991B8"));
      paramView.b.setBackgroundColor(Color.parseColor("#040E1C"));
      paramView.c.setImageResource(2130847685);
      paramView.a.setBackgroundResource(2130839569);
      paramView.e.setImageResource(2130847683);
    }
    else
    {
      paramView.d.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.b.setBackgroundColor(Color.parseColor("#E6E6E6"));
      paramView.c.setImageResource(2130847684);
      paramView.a.setBackgroundResource(2130839568);
      paramView.e.setImageResource(2130847682);
    }
    localView.setOnClickListener(paramView);
    paramView.e.setOnClickListener(paramView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SearchWordHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */