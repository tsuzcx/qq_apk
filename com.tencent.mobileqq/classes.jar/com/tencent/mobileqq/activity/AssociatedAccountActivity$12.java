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
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int k = 0;
    int i = 0;
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Iterator localIterator;
    label54:
    boolean bool;
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramBoolean = false;
      bool = paramBoolean;
      if (!localIterator.hasNext()) {
        break label95;
      }
      if (!TextUtils.equals(paramString, ((SubAccountInfo)localIterator.next()).subuin)) {
        break label248;
      }
      paramBoolean = true;
    }
    label95:
    label248:
    for (;;)
    {
      break label54;
      bool = false;
      int j = k;
      if (this.a.jdField_b_of_type_JavaUtilArrayList != null)
      {
        j = k;
        if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localIterator = this.a.jdField_b_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            if (TextUtils.equals(paramString, ((SimpleAccount)localIterator.next()).getUin())) {
              i = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onUpdateCustomHead uin = " + paramString + " needUpdate=" + bool);
      }
      if (bool) {
        this.a.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetInvalidated();
      }
      if (j == 0) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetInvalidated();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.12
 * JD-Core Version:    0.7.0.1
 */