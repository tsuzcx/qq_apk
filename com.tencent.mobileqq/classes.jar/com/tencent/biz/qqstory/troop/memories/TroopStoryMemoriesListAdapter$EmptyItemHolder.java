package com.tencent.biz.qqstory.troop.memories;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;

class TroopStoryMemoriesListAdapter$EmptyItemHolder
{
  public View a;
  public View b;
  
  public TroopStoryMemoriesListAdapter$EmptyItemHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.a = paramView;
    this.b = paramView.findViewById(2131437197);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    Iterator localIterator = this.c.a.iterator();
    float f = 0.0F;
    while (localIterator.hasNext())
    {
      i = ((TroopStoryItemInfo)localIterator.next()).itemType;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              continue;
            }
            i = UIUtils.a(this.c.b, 95.0F);
          }
          else
          {
            i = UIUtils.a(this.c.b, 95.0F);
          }
        }
        else if ((!DateUtils.g(paramTroopStoryItemInfo.publishTime)) && (!DateUtils.h(paramTroopStoryItemInfo.publishTime))) {
          i = UIUtils.a(this.c.b, 71.0F);
        } else {
          i = UIUtils.a(this.c.b, 44.0F);
        }
      }
      else {
        i = UIUtils.a(this.c.b, 70.0F);
      }
      f += i;
    }
    int i = (int)(this.c.e - f);
    paramTroopStoryItemInfo = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    if (i <= 0)
    {
      paramTroopStoryItemInfo.height = 0;
      this.b.setLayoutParams(paramTroopStoryItemInfo);
      this.a.setVisibility(8);
      return;
    }
    paramTroopStoryItemInfo.height = i;
    this.b.setLayoutParams(paramTroopStoryItemInfo);
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.EmptyItemHolder
 * JD-Core Version:    0.7.0.1
 */