package com.tencent.mobileqq.activity.editservice;

import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class EditMyNickService$1
  implements OnItemSelectListener
{
  EditMyNickService$1(EditMyNickService paramEditMyNickService) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      Object localObject = new QQText(EditMyNickService.a(this.a).getText(), 3);
      paramView = ((QQText)localObject).toString();
      localObject = ((QQText)localObject).trim();
      if (!EditMyNickService.a(this.a, paramView, (String)localObject)) {
        return;
      }
      if (((String)localObject).equals(EditMyNickService.b(this.a)))
      {
        EditMyNickService.a(this.a).onFinish();
        return;
      }
      if (!NetworkUtil.isNetSupport(EditMyNickService.c(this.a).getApplication().getApplicationContext()))
      {
        QQToast.makeText(EditMyNickService.d(this.a), 1, 2131892104, 0).show();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditMyNickService", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { EditMyNickService.e(this.a), localObject }));
      }
      if ((EditMyNickService.e(this.a) != null) && (!EditMyNickService.e(this.a).equals(EditMyNickService.c(this.a).getCurrentAccountUin()))) {
        return;
      }
      EditMyNickService.a(this.a).loadingProgress(true);
      paramView = new Bundle();
      paramView.putString("nick", (String)localObject);
      ((IProfileProtocolService)EditMyNickService.c(this.a).getRuntimeService(IProfileProtocolService.class, "all")).setProfileDetail(paramView);
      EditMyNickService.a(this.a, Boolean.valueOf(true));
      return;
    }
    EditMyNickService.a(this.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditMyNickService.1
 * JD-Core Version:    0.7.0.1
 */