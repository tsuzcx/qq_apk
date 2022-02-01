package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$21
  extends AvatarObserver
{
  AccountDetailGroupListContainer$21(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (this.a.s == null) {
      return;
    }
    int j = this.a.s.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.a.s.getChildAt(i);
      if (((((View)localObject).getTag() instanceof String)) && ((localObject instanceof ImageView)) && (((String)((View)localObject).getTag()).equals(paramString)))
      {
        ((ImageView)localObject).setImageDrawable(this.a.b.getTroopFaceDrawable(paramString));
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUpdateTroopHead:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, ((StringBuilder)localObject).toString());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.21
 * JD-Core Version:    0.7.0.1
 */