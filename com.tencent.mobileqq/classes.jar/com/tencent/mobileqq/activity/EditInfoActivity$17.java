package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class EditInfoActivity$17
  extends TroopObserver
{
  EditInfoActivity$17(EditInfoActivity paramEditInfoActivity) {}
  
  public void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if (!this.a.j) {}
    for (;;)
    {
      return;
      this.a.j = false;
      this.a.b(false);
      if (paramBoolean) {
        try
        {
          paramObject = (Object[])paramObject;
          long l = ((Long)paramObject[0]).longValue();
          ((Integer)paramObject[1]).intValue();
          paramObject = (TroopMemberCard)paramObject[2];
          if ((l == Long.parseLong(this.a.e)) && (paramObject != null) && (paramObject.memberUin == Long.parseLong(this.a.f)))
          {
            this.a.a.postDelayed(new EditInfoActivity.17.2(this, paramObject), 700L);
            return;
          }
        }
        catch (Exception paramObject) {}
      }
    }
  }
  
  public void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (!this.a.j) {
      return;
    }
    this.a.j = false;
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.a.b(false);
      EditInfoActivity localEditInfoActivity = this.a;
      paramArrayList = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramArrayList = this.a.getString(2131694234);
      }
      QQToast.a(localEditInfoActivity, 1, paramArrayList, 0).b(this.a.getTitleBarHeight());
      this.a.a.postDelayed(new EditInfoActivity.17.1(this), 1500L);
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.a.e), "1", "", "");
      return;
    }
    ReportController.b(this.a.app, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_success", 0, 0, String.valueOf(this.a.e), "", "", "");
    paramArrayList = (TroopMemberInfoHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
    try
    {
      paramArrayList.a(Long.parseLong(this.a.e), Long.parseLong(this.a.f));
      this.a.j = true;
      return;
    }
    catch (Exception paramArrayList)
    {
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.17
 * JD-Core Version:    0.7.0.1
 */