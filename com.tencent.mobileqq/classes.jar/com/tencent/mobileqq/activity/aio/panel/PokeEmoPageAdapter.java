package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class PokeEmoPageAdapter
  extends PagerAdapter
{
  private Context a;
  private List<View> b;
  
  public PokeEmoPageAdapter(Context paramContext, List<View> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.b.get(paramInt));
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.b.get(paramInt));
    return this.b.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    super.startUpdate(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeEmoPageAdapter
 * JD-Core Version:    0.7.0.1
 */