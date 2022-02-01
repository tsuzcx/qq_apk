package com.tencent.mobileqq.activity.qwallet.widget;

import aktm;
import akwv;
import android.view.View;
import android.view.View.OnClickListener;
import bgsp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class HongBaoPanel$3
  implements View.OnClickListener
{
  HongBaoPanel$3(HongBaoPanel paramHongBaoPanel) {}
  
  public void onClick(View paramView)
  {
    try
    {
      aktm localaktm = (aktm)paramView.getTag();
      if (localaktm == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        String str = null;
        continue;
        switch (str.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 100: 
          if (str.jdField_a_of_type_OrgJsonJSONObject != null)
          {
            str = str.jdField_a_of_type_OrgJsonJSONObject.optString("url");
            if (!bgsp.a(str)) {
              akwv.b(this.this$0.mContext, str);
            }
          }
          break;
        case 101: 
          HongBaoPanel.access$200(this.this$0);
          break;
        case 102: 
          str = str.jdField_a_of_type_OrgJsonJSONObject.optString("url");
          if (!bgsp.a(str)) {
            akwv.b(this.this$0.mContext, str);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.3
 * JD-Core Version:    0.7.0.1
 */