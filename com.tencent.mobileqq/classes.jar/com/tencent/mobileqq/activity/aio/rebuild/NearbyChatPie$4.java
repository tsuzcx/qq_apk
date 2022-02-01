package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyChatPie$4
  implements View.OnClickListener
{
  NearbyChatPie$4(NearbyChatPie paramNearbyChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.a.a.jdField_a_of_type_JavaLangString;
      if (this.a.a.jdField_a_of_type_Int == 1006) {
        str = this.a.a.f;
      }
      NearbyChatPie.a(this.a, (Integer)localObject, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.4
 * JD-Core Version:    0.7.0.1
 */