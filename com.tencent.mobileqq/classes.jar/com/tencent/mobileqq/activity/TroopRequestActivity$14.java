package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;

class TroopRequestActivity$14
  extends MessageObserver
{
  TroopRequestActivity$14(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839730, this.a.getString(2131719341));
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    this.a.a(2130839730, this.a.getString(2131719327));
  }
  
  public void onSendSystemMsgActionError(String paramString)
  {
    this.a.h();
    paramString = this.a.getString(2131719697);
    QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    while (!paramBoolean)
    {
      this.a.h();
      if (SystemMsgUtils.a(GroupSystemMsgController.a().a(paramString1), paramInt3, paramString2, paramString4)) {
        this.a.finish();
      }
      return;
      paramString1 = GroupSystemMsgController.a().b();
    }
    this.a.h();
    this.a.finish();
    SystemMsgUtils.a(GroupSystemMsgController.a().a(paramString1), paramInt1, paramString2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.14
 * JD-Core Version:    0.7.0.1
 */