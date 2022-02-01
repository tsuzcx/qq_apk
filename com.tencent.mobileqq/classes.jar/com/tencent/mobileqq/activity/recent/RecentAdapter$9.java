package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecentAdapter$9
  implements View.OnClickListener
{
  RecentAdapter$9(RecentAdapter paramRecentAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i >= 0) && (i < this.a.getCount()))
      {
        Object localObject1 = this.a.getItem(i);
        if ((localObject1 != null) && ((localObject1 instanceof RecentBaseData)))
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localObject1;
          Object localObject2 = null;
          localObject1 = localObject2;
          if ((paramView instanceof TextView))
          {
            CharSequence localCharSequence = ((TextView)paramView).getText();
            localObject1 = localObject2;
            if (localCharSequence != null) {
              localObject1 = localCharSequence.toString();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.a.a(localRecentBaseData, (String)localObject1, "1");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.9
 * JD-Core Version:    0.7.0.1
 */