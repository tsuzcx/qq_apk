package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$13
  extends FriendListObserver
{
  AssociatedAccountActivity$13(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  private void a(String paramString, ArrayList<AssociatedAccountListItemData> paramArrayList, AssociatedAccountListAdapter paramAssociatedAccountListAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo  uin = " + paramString);
    }
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = false;
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    if (localIterator.hasNext())
    {
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)localIterator.next();
      if ((localAssociatedAccountListItemData.jdField_a_of_type_Int == 2) && (localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject != null) && ((localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof ArrayList)))
      {
        paramArrayList = ((ArrayList)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).iterator();
        do
        {
          bool2 = bool1;
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (!paramString.equals(((SubAccountInfo)((AssociatedAccountListItemData)paramArrayList.next()).jdField_a_of_type_JavaLangObject).subuin));
        String str = ContactUtils.d(this.a.app, paramString, true);
        paramArrayList = str;
        if (TextUtils.isEmpty(str)) {
          paramArrayList = paramString;
        }
        boolean bool2 = bool1;
        if (!paramArrayList.equals(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString))
        {
          localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString = paramArrayList;
          bool2 = true;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      break;
      if ((localAssociatedAccountListItemData.jdField_a_of_type_Int == 6) && (localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject != null) && ((localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof SimpleAccount)))
      {
        paramArrayList = (SimpleAccount)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
        if (paramString.equals(paramArrayList.getUin()))
        {
          paramArrayList = SubAccountControll.a(this.a.app, paramArrayList);
          if (!paramArrayList.equals(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString))
          {
            localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString = paramArrayList;
            bool1 = true;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo needUpdate = " + bool1);
            }
            if (bool1) {
              paramAssociatedAccountListAdapter.notifyDataSetInvalidated();
            }
            return;
          }
        }
      }
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    a(paramString, this.a.d, this.a.b);
    a(paramString, this.a.c, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.13
 * JD-Core Version:    0.7.0.1
 */