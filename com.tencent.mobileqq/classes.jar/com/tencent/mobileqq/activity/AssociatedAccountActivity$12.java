package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$12
  extends AvatarObserver
{
  AssociatedAccountActivity$12(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = this.a.mSubAccountList;
      int k = 0;
      int i = 0;
      if ((localObject != null) && (this.a.mSubAccountList.size() > 0))
      {
        localObject = this.a.mSubAccountList.iterator();
        paramBoolean = false;
        for (;;)
        {
          bool = paramBoolean;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (TextUtils.equals(paramString, ((SubAccountInfo)((Iterator)localObject).next()).subuin)) {
            paramBoolean = true;
          }
        }
      }
      boolean bool = false;
      int j = k;
      if (this.a.mThirdAccountList != null)
      {
        j = k;
        if (this.a.mThirdAccountList.size() > 0)
        {
          localObject = this.a.mThirdAccountList.iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (TextUtils.equals(paramString, ((SimpleAccount)((Iterator)localObject).next()).getUin())) {
              i = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUpdateCustomHead uin = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" needUpdate=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        this.a.mAdapter.notifyDataSetInvalidated();
      }
      if (j != 0) {
        this.a.thirdAccountsAdapter.notifyDataSetInvalidated();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.12
 * JD-Core Version:    0.7.0.1
 */