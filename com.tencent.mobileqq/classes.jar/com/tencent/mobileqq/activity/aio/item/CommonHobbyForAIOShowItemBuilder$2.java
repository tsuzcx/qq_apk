package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonHobbyForAIOShowItemBuilder$2
  implements View.OnClickListener
{
  CommonHobbyForAIOShowItemBuilder$2(CommonHobbyForAIOShowItemBuilder paramCommonHobbyForAIOShowItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (!TextUtils.isEmpty(str)) {
      CommonHobbyForAIOShowItemBuilder.a(this.a, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */