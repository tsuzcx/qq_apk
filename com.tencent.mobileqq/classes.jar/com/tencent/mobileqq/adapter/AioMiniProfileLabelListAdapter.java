package com.tencent.mobileqq.adapter;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AioMiniProfileLabelListAdapter
  extends BaseAdapter
{
  private Context a;
  private List<String> b = new ArrayList();
  
  public AioMiniProfileLabelListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842910 };
    int[] arrayOfInt2 = { 16842909 };
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, arrayOfInt1, { 16842908 }, arrayOfInt2, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
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
  
  private AioMiniProfileLabelListAdapter.LabelColor a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "seed";
    }
    paramString = new AioMiniProfileLabelListAdapter.LabelColor(null);
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968662);
    paramContext = paramContext.getResources().getStringArray(2130968661);
    boolean bool = TextUtils.isEmpty(str);
    int i = 0;
    if (!bool) {
      i = str.charAt(0);
    }
    paramString.a = arrayOfString[(i % arrayOfString.length)];
    paramString.b = paramContext[(i % paramContext.length)];
    return paramString;
  }
  
  private Drawable b(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(List<String> paramList)
  {
    this.b.addAll(paramList);
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
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627431, null, false);
      paramView = new AioMiniProfileLabelListAdapter.ViewHolder();
      paramView.b = ((TextView)localView.findViewById(2131448436));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (AioMiniProfileLabelListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView.a = paramInt;
      paramView.b.setText((CharSequence)localObject);
      localObject = a((String)localObject, this.a);
      int i = Color.parseColor(((AioMiniProfileLabelListAdapter.LabelColor)localObject).a);
      int j = Color.parseColor(((AioMiniProfileLabelListAdapter.LabelColor)localObject).b);
      paramView.b.setClickable(false);
      paramView.b.setFocusable(false);
      paramView.b.setBackgroundDrawable(a(j, j));
      paramView.b.setTextColor(a(i, i, i, i));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AioMiniProfileLabelListAdapter
 * JD-Core Version:    0.7.0.1
 */