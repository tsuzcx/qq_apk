package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.FriendListObserverCallback;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.subaccount.AssociatedAccountListItemData;>;
import java.util.Iterator;

class AssociatedAccountActivity$13
  implements ISubAccountApi.FriendListObserverCallback
{
  AssociatedAccountActivity$13(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  private void a(String paramString, ArrayList<AssociatedAccountListItemData> paramArrayList, AssociatedAccountListAdapter paramAssociatedAccountListAdapter)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAssociatedAccountInfo  uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = false;
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)localIterator.next();
        if ((localAssociatedAccountListItemData.a == 2) && (localAssociatedAccountListItemData.l != null) && ((localAssociatedAccountListItemData.l instanceof ArrayList)))
        {
          paramArrayList = ((ArrayList)localAssociatedAccountListItemData.l).iterator();
          if (!paramArrayList.hasNext()) {
            continue;
          }
          if (!paramString.equals(((SubAccountInfo)((AssociatedAccountListItemData)paramArrayList.next()).l).subuin)) {
            break;
          }
          localObject = ((IContactUtils)QRoute.api(IContactUtils.class)).getBuddyNickName(this.a.app, paramString, true);
          paramArrayList = (ArrayList<AssociatedAccountListItemData>)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramArrayList = paramString;
          }
          if (paramArrayList.equals(localAssociatedAccountListItemData.b)) {
            continue;
          }
        }
        for (localAssociatedAccountListItemData.b = paramArrayList;; localAssociatedAccountListItemData.b = paramArrayList)
        {
          bool = true;
          break;
          if ((localAssociatedAccountListItemData.a != 6) || (localAssociatedAccountListItemData.l == null) || (!(localAssociatedAccountListItemData.l instanceof SimpleAccount))) {
            break;
          }
          paramArrayList = (SimpleAccount)localAssociatedAccountListItemData.l;
          if (!paramString.equals(paramArrayList.getUin())) {
            break;
          }
          paramArrayList = SubAccountControllUtil.b(this.a.app, paramArrayList);
          if (paramArrayList.equals(localAssociatedAccountListItemData.b)) {
            break;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateAssociatedAccountInfo needUpdate = ");
      paramString.append(bool);
      QLog.d("AssociatedAccountActivity", 2, paramString.toString());
    }
    if (bool) {
      paramAssociatedAccountListAdapter.notifyDataSetInvalidated();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateFriendInfo  uin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" isSuccess = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
      }
      a(paramString, this.a.mItemDataList, this.a.mAdapter);
      a(paramString, this.a.thirdAccountsDataList, this.a.thirdAccountsAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.13
 * JD-Core Version:    0.7.0.1
 */