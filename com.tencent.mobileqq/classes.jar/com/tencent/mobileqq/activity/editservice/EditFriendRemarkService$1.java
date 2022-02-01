package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class EditFriendRemarkService$1
  implements OnItemSelectListener
{
  EditFriendRemarkService$1(EditFriendRemarkService paramEditFriendRemarkService) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      Object localObject = new QQText(EditFriendRemarkService.a(this.a).getText(), 3);
      paramView = ((QQText)localObject).toString();
      localObject = ((QQText)localObject).trim();
      if (TextUtils.isEmpty(paramView)) {
        QQToast.makeText(EditFriendRemarkService.b(this.a), EditFriendRemarkService.b(this.a).getString(2131890846), 0).show();
      }
      if (((String)localObject).equals(EditFriendRemarkService.c(this.a)))
      {
        EditFriendRemarkService.a(this.a).onFinish();
        return;
      }
      if (!NetworkUtil.isNetSupport(EditFriendRemarkService.d(this.a).getApplication().getApplicationContext()))
      {
        QQToast.makeText(EditFriendRemarkService.a(this.a).getContext(), 1, 2131892104, 0).show();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditFriendRemarkService", 2, String.format("edit friend remark, uin: %s, result: %s", new Object[] { EditFriendRemarkService.e(this.a), localObject }));
      }
      EditFriendRemarkService.a(this.a).loadingProgress(true);
      ((FriendListHandler)((QQAppInterface)EditFriendRemarkService.d(this.a)).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setFriendComment(EditFriendRemarkService.e(this.a), (String)localObject, false);
      EditFriendRemarkService.a(this.a, Boolean.valueOf(true));
      return;
    }
    EditFriendRemarkService.a(this.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService.1
 * JD-Core Version:    0.7.0.1
 */