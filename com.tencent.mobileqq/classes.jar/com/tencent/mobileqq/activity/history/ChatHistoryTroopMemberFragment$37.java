package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryTroopMemberFragment$37
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$37(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "mOnKickOutBtnClickListener onclick");
      }
      int j = paramView.getId();
      Object localObject1 = (String)paramView.getTag();
      boolean bool1 = ((String)localObject1).equals(this.a.jdField_f_of_type_JavaLangString);
      Object localObject2 = this.a.jdField_g_of_type_JavaLangString;
      boolean bool3 = false;
      boolean bool2 = false;
      int i;
      if ((localObject2 != null) && (this.a.jdField_g_of_type_JavaLangString.contains((CharSequence)localObject1))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool4 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_f_of_type_JavaLangString);
      if (((bool4) && (!((String)localObject1).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || ((!bool4) && (!bool1) && (i == 0))) {
        i = 1;
      } else {
        i = 0;
      }
      if (j == 2131365478)
      {
        localObject2 = paramView.findViewById(2131365479);
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
          if (localObject2 != null)
          {
            localObject1 = ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).a.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof Integer)))
            {
              i = ((Integer)localObject1).intValue();
              if (i >= 0)
              {
                localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.getItem(i);
                this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject1);
              }
            }
          }
        }
        else if (this.a.jdField_g_of_type_Boolean)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.remove(localObject1);
          } else if (i != 0) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.add(localObject1);
          }
          ChatHistoryTroopMemberFragment.a(this.a);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.notifyDataSetChanged();
        }
        else if (bool1)
        {
          if (!this.a.v.equals(localObject1))
          {
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.v))
            {
              localObject2 = this.a;
              localObject2 = ((ChatHistoryTroopMemberFragment)localObject2).a(((ChatHistoryTroopMemberFragment)localObject2).v, bool1);
              if (localObject2 != null) {
                ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).a.b(true);
              }
            }
            this.a.v = ((String)localObject1);
          }
        }
        else if (!this.a.u.equals(localObject1))
        {
          if (localObject2 != null) {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.u))
          {
            localObject2 = this.a;
            localObject2 = ((ChatHistoryTroopMemberFragment)localObject2).a(((ChatHistoryTroopMemberFragment)localObject2).u, bool1);
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).a.b(true);
            }
          }
          this.a.u = ((String)localObject1);
        }
      }
      else if (j == 2131377658)
      {
        localObject2 = paramView.findViewById(2131379771);
        bool1 = bool3;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool3;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        if (this.a.jdField_g_of_type_Boolean)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.remove(localObject1);
          } else if (i != 0) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_b_of_type_JavaUtilList.add(localObject1);
          }
          ChatHistoryTroopMemberFragment.a(this.a);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.notifyDataSetChanged();
        }
        if (bool1)
        {
          localObject1 = this.a;
          localObject1 = ((ChatHistoryTroopMemberFragment)localObject1).a(((ChatHistoryTroopMemberFragment)localObject1).v, bool1);
          if (localObject1 != null)
          {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).a.b(true);
            this.a.v = "";
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
        }
        else
        {
          localObject1 = this.a;
          localObject1 = ((ChatHistoryTroopMemberFragment)localObject1).a(((ChatHistoryTroopMemberFragment)localObject1).u, bool1);
          if (localObject1 != null)
          {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).a.b(true);
            this.a.u = "";
          }
        }
      }
      else if ((j == 2131363963) && (this.a.jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delBtn onClick, uin=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          if (this.a.getBaseActivity().isResume()) {
            QQToast.a(this.a.getBaseActivity(), this.a.getString(2131694424), 0).b(this.a.getBaseActivity().getTitleBarHeight());
          }
        }
        else if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.e((String)localObject1);
        }
        else if (this.a.jdField_d_of_type_Int == 13)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
          if (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
          }
        }
        else if (this.a.jdField_d_of_type_Int == 21)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
          if (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          ChatHistoryTroopMemberFragment.a(this.a, (List)localObject2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.37
 * JD-Core Version:    0.7.0.1
 */