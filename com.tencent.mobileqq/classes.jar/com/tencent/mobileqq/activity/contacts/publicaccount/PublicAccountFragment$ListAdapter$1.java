package com.tencent.mobileqq.activity.contacts.publicaccount;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountFragment$ListAdapter$1
  implements View.OnClickListener
{
  PublicAccountFragment$ListAdapter$1(PublicAccountFragment.ListAdapter paramListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364234)
    {
      String str1 = (String)paramView.getTag(-1);
      String str2 = (String)paramView.getTag(-2);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        CrmUtils.a(PublicAccountFragment.a(this.a.a), PublicAccountFragment.b(this.a.a), str2, str1, "IvrEnterpriseDetailEngineFalse");
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick - uin = ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", name = ");
        localStringBuilder.append(str2);
        QLog.w("Contacts.PublicAccountFragment", 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.ListAdapter.1
 * JD-Core Version:    0.7.0.1
 */