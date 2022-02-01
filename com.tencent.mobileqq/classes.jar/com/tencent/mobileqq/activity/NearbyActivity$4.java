package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class NearbyActivity$4
  implements View.OnClickListener
{
  NearbyActivity$4(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < this.a.titleClickListeners.size())
    {
      ((View.OnClickListener)this.a.titleClickListeners.get(i)).onClick(paramView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.4
 * JD-Core Version:    0.7.0.1
 */