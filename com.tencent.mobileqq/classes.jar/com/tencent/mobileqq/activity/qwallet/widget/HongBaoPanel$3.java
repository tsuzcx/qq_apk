package com.tencent.mobileqq.activity.qwallet.widget;

import ahdc;
import ahix;
import android.view.View;
import android.view.View.OnClickListener;
import bbjw;
import org.json.JSONObject;

class HongBaoPanel$3
  implements View.OnClickListener
{
  HongBaoPanel$3(HongBaoPanel paramHongBaoPanel) {}
  
  public void onClick(View paramView)
  {
    do
    {
      try
      {
        paramView = (ahdc)paramView.getTag();
        if (paramView == null) {
          return;
        }
      }
      catch (Throwable paramView)
      {
        do
        {
          do
          {
            for (;;)
            {
              paramView.printStackTrace();
              paramView = null;
            }
            switch (paramView.jdField_a_of_type_Int)
            {
            default: 
              return;
            }
          } while (paramView.jdField_a_of_type_OrgJsonJSONObject == null);
          paramView = paramView.jdField_a_of_type_OrgJsonJSONObject.optString("url");
        } while (bbjw.a(paramView));
        ahix.b(this.this$0.mContext, paramView);
        return;
      }
      HongBaoPanel.access$200(this.this$0);
      return;
      paramView = paramView.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    } while (bbjw.a(paramView));
    ahix.b(this.this$0.mContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.3
 * JD-Core Version:    0.7.0.1
 */