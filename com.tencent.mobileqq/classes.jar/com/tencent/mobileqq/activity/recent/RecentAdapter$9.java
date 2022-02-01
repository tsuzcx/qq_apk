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
    if (paramView == null) {}
    label109:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if ((i >= 0) && (i < this.a.getCount()))
      {
        Object localObject = this.a.getItem(i);
        if ((localObject != null) && ((localObject instanceof RecentBaseData)))
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localObject;
          if ((paramView instanceof TextView))
          {
            localObject = ((TextView)paramView).getText();
            if (localObject == null) {}
          }
          for (localObject = ((CharSequence)localObject).toString();; localObject = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label109;
            }
            this.a.a(localRecentBaseData, (String)localObject, "1");
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.9
 * JD-Core Version:    0.7.0.1
 */