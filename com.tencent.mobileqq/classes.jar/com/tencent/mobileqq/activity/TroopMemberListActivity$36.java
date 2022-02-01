package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class TroopMemberListActivity$36
  implements View.OnClickListener
{
  TroopMemberListActivity$36(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnKickOutBtnClickListener onclick");
      }
      int j = paramView.getId();
      Object localObject1 = (String)paramView.getTag();
      boolean bool1 = ((String)localObject1).equals(this.a.e);
      int i;
      if ((this.a.f != null) && (this.a.f.contains((CharSequence)localObject1)))
      {
        i = 1;
        label100:
        boolean bool4 = this.a.app.getCurrentAccountUin().equals(this.a.e);
        if (((!bool4) || (((String)localObject1).equals(this.a.app.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0))) {
          break label314;
        }
        i = 1;
      }
      Object localObject2;
      for (;;)
      {
        if (j == 2131365634)
        {
          localObject2 = paramView.findViewById(2131365635);
          bool1 = bool2;
          if (((View)localObject2).getTag() != null)
          {
            bool1 = bool2;
            if ((((View)localObject2).getTag() instanceof Boolean)) {
              bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
            }
          }
          localObject2 = this.a.a((String)localObject1, bool1);
          if (this.a.jdField_d_of_type_Int == 20)
          {
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((TroopMemberListActivity.TmViewHolder)localObject2).a.getTag();
            if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
              break;
            }
            i = ((Integer)localObject1).intValue();
            if (i < 0) {
              break;
            }
            localObject1 = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.getItem(i);
            this.a.a((TroopMemberListActivity.ATroopMember)localObject1);
            break;
            i = 0;
            break label100;
            label314:
            i = 0;
            continue;
          }
          if (this.a.jdField_d_of_type_Boolean)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.remove(localObject1);
            }
            for (;;)
            {
              TroopMemberListActivity.a(this.a);
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
              break;
              if (i != 0) {
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.add(localObject1);
              }
            }
          }
          if (bool1)
          {
            if (this.a.u.equals(localObject1)) {
              break;
            }
            if (localObject2 != null) {
              ((TroopMemberListActivity.TmViewHolder)localObject2).a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.u))
            {
              localObject2 = this.a.a(this.a.u, bool1);
              if (localObject2 != null) {
                ((TroopMemberListActivity.TmViewHolder)localObject2).a.b(true);
              }
            }
            this.a.u = ((String)localObject1);
            break;
          }
          if (this.a.t.equals(localObject1)) {
            break;
          }
          if (localObject2 != null) {
            ((TroopMemberListActivity.TmViewHolder)localObject2).a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.t))
          {
            localObject2 = this.a.a(this.a.t, bool1);
            if (localObject2 != null) {
              ((TroopMemberListActivity.TmViewHolder)localObject2).a.b(true);
            }
          }
          this.a.t = ((String)localObject1);
          break;
        }
      }
      if (j == 2131378244)
      {
        localObject2 = paramView.findViewById(2131380459);
        bool1 = bool3;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool3;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        if (this.a.jdField_d_of_type_Boolean)
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
            break label767;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.remove(localObject1);
        }
        for (;;)
        {
          TroopMemberListActivity.a(this.a);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
          if (!bool1) {
            break label792;
          }
          localObject1 = this.a.a(this.a.u, bool1);
          if (localObject1 != null)
          {
            ((TroopMemberListActivity.TmViewHolder)localObject1).a.b(true);
            this.a.u = "";
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          break;
          label767:
          if (i != 0) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.add(localObject1);
          }
        }
        label792:
        localObject1 = this.a.a(this.a.t, bool1);
        if (localObject1 != null)
        {
          ((TroopMemberListActivity.TmViewHolder)localObject1).a.b(true);
          this.a.t = "";
        }
      }
      else if ((j == 2131364037) && (this.a.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "delBtn onClick, uin=" + (String)localObject1);
        }
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          if (this.a.isResume()) {
            QQToast.a(this.a, this.a.getString(2131694459), 0).b(this.a.getTitleBarHeight());
          }
        }
        else if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.d((String)localObject1);
        }
        else if (this.a.jdField_d_of_type_Int == 13)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          if (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          }
        }
        else if (this.a.jdField_d_of_type_Int == 21)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          if (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          TroopMemberListActivity.a(this.a, (List)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.36
 * JD-Core Version:    0.7.0.1
 */