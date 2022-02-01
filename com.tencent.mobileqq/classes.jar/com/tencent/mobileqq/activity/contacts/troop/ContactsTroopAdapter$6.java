package com.tencent.mobileqq.activity.contacts.troop;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ContactsTroopAdapter$6
  implements ActionSheet.OnButtonClickListener
{
  ContactsTroopAdapter$6(ContactsTroopAdapter paramContactsTroopAdapter, boolean paramBoolean, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.d.b))
    {
      QQToast.makeText(this.d.b, 1, 2131889169, 0).show();
    }
    else
    {
      paramView = (ITroopCommonlyUsedHandler)this.d.a.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName());
      if (this.a)
      {
        paramView.a(this.b.troopcode, 1);
        ReportController.b(this.d.a, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.a(this.b.troopcode, 0);
        ReportController.b(this.d.a, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
      }
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.6
 * JD-Core Version:    0.7.0.1
 */