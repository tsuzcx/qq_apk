package com.tencent.mobileqq.activity.qwallet.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelTabData;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;

class HongBaoPanel$2
  implements View.OnClickListener
{
  HongBaoPanel$2(HongBaoPanel paramHongBaoPanel) {}
  
  public void onClick(View paramView)
  {
    do
    {
      try
      {
        paramView = (PanelTabData)paramView.getTag();
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
        } while (StringUtil.a(paramView));
        QWalletRedPkgUtils.b(this.this$0.mContext, paramView);
        return;
      }
      HongBaoPanel.access$100(this.this$0);
      return;
      paramView = paramView.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    } while (StringUtil.a(paramView));
    QWalletRedPkgUtils.b(this.this$0.mContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.2
 * JD-Core Version:    0.7.0.1
 */