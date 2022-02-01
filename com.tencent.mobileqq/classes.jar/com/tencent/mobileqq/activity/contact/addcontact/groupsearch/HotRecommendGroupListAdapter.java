package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class HotRecommendGroupListAdapter
  extends BaseAdapter
{
  private Context a;
  private List<HotRecommendGroupListAdapter.Keyword> b = new ArrayList();
  private HotRecommendGroupListAdapter.OnItemClickListener c;
  
  public HotRecommendGroupListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(paramFloat * 255.0F))) << 24) + (paramInt & 0xFFFFFF);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842919, 16842910 };
    int[] arrayOfInt2 = { 16842910 };
    int[] arrayOfInt3 = { 16842908 };
    int[] arrayOfInt4 = new int[0];
    return new ColorStateList(new int[][] { arrayOfInt1, { 16842910, 16842908 }, arrayOfInt2, arrayOfInt3, { 16842909 }, arrayOfInt4 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = b(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = b(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private Drawable b(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(42.0F);
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public HotRecommendGroupListAdapter.Keyword a(int paramInt)
  {
    return (HotRecommendGroupListAdapter.Keyword)this.b.get(paramInt);
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  void a(HotRecommendGroupListAdapter.Keyword paramKeyword)
  {
    this.b.add(paramKeyword);
  }
  
  public void a(HotRecommendGroupListAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
  }
  
  public int getCount()
  {
    return this.b.size();
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627466, null, false);
      paramView = new HotRecommendGroupListAdapter.ViewHolder(this);
      paramView.c = ((TextView)localView.findViewById(2131448793));
      paramView.c.setOnClickListener(paramView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (HotRecommendGroupListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    HotRecommendGroupListAdapter.Keyword localKeyword = a(paramInt);
    if (localKeyword != null)
    {
      paramView.b = localKeyword.a;
      paramView.a = paramInt;
      TextView localTextView = paramView.c;
      if (TextUtils.isEmpty(localKeyword.a)) {
        localObject = "";
      } else {
        localObject = localKeyword.a;
      }
      localTextView.setText((CharSequence)localObject);
      int i;
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
      {
        i = Color.parseColor("#A8A8A8");
        paramView.c.setBackgroundDrawable(this.a.getResources().getDrawable(2130846918));
      }
      else if (localKeyword.b == null)
      {
        i = Color.parseColor("#03081A");
        paramView.c.setBackgroundDrawable(this.a.getResources().getDrawable(2130846917));
      }
      else
      {
        i = Color.parseColor(localKeyword.b);
        paramView.c.setBackgroundDrawable(a(a(0.1F, i), a(0.2F, i)));
      }
      int j = a(0.5F, i);
      paramView.c.setTextColor(a(i, j, j, i));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.HotRecommendGroupListAdapter
 * JD-Core Version:    0.7.0.1
 */