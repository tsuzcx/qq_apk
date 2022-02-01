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
      boolean bool1 = ((String)localObject1).equals(this.a.C);
      Object localObject2 = this.a.D;
      boolean bool3 = false;
      boolean bool2 = false;
      int i;
      if ((localObject2 != null) && (this.a.D.contains((CharSequence)localObject1))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool4 = this.a.bc.getCurrentAccountUin().equals(this.a.C);
      if (((bool4) && (!((String)localObject1).equals(this.a.bc.getCurrentAccountUin()))) || ((!bool4) && (!bool1) && (i == 0))) {
        i = 1;
      } else {
        i = 0;
      }
      if (j == 2131431693)
      {
        localObject2 = paramView.findViewById(2131431694);
        bool1 = bool2;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool2;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        localObject2 = this.a.a((String)localObject1, bool1);
        if (this.a.az == 20)
        {
          if (localObject2 != null)
          {
            localObject1 = ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).c.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof Integer)))
            {
              i = ((Integer)localObject1).intValue();
              if (i >= 0)
              {
                localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.K.getItem(i);
                this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject1);
              }
            }
          }
        }
        else if (this.a.A)
        {
          if (this.a.K.e.contains(localObject1)) {
            this.a.K.e.remove(localObject1);
          } else if (i != 0) {
            this.a.K.e.add(localObject1);
          }
          ChatHistoryTroopMemberFragment.c(this.a);
          this.a.K.notifyDataSetChanged();
        }
        else if (bool1)
        {
          if (!this.a.bs.equals(localObject1))
          {
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).c.a(true);
            }
            if (!TextUtils.isEmpty(this.a.bs))
            {
              localObject2 = this.a;
              localObject2 = ((ChatHistoryTroopMemberFragment)localObject2).a(((ChatHistoryTroopMemberFragment)localObject2).bs, bool1);
              if (localObject2 != null) {
                ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).c.b(true);
              }
            }
            this.a.bs = ((String)localObject1);
          }
        }
        else if (!this.a.br.equals(localObject1))
        {
          if (localObject2 != null) {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).c.a(true);
          }
          if (!TextUtils.isEmpty(this.a.br))
          {
            localObject2 = this.a;
            localObject2 = ((ChatHistoryTroopMemberFragment)localObject2).a(((ChatHistoryTroopMemberFragment)localObject2).br, bool1);
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject2).c.b(true);
            }
          }
          this.a.br = ((String)localObject1);
        }
      }
      else if (j == 2131446080)
      {
        localObject2 = paramView.findViewById(2131448581);
        bool1 = bool3;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool3;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        if (this.a.A)
        {
          if (this.a.K.e.contains(localObject1)) {
            this.a.K.e.remove(localObject1);
          } else if (i != 0) {
            this.a.K.e.add(localObject1);
          }
          ChatHistoryTroopMemberFragment.c(this.a);
          this.a.K.notifyDataSetChanged();
        }
        if (bool1)
        {
          localObject1 = this.a;
          localObject1 = ((ChatHistoryTroopMemberFragment)localObject1).a(((ChatHistoryTroopMemberFragment)localObject1).bs, bool1);
          if (localObject1 != null)
          {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).c.b(true);
            this.a.bs = "";
          }
          this.a.ad.notifyDataSetChanged();
        }
        else
        {
          localObject1 = this.a;
          localObject1 = ((ChatHistoryTroopMemberFragment)localObject1).a(((ChatHistoryTroopMemberFragment)localObject1).br, bool1);
          if (localObject1 != null)
          {
            ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).c.b(true);
            this.a.br = "";
          }
        }
      }
      else if ((j == 2131429919) && (this.a.z))
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
            QQToast.makeText(this.a.getBaseActivity(), this.a.getString(2131892104), 0).show(this.a.getBaseActivity().getTitleBarHeight());
          }
        }
        else if (this.a.az == 1)
        {
          this.a.g((String)localObject1);
        }
        else if (this.a.az == 13)
        {
          localObject2 = this.a.d((String)localObject1);
          this.a.av.add(localObject1);
          this.a.K.c();
          if (this.a.bm.isShowing())
          {
            if (localObject2 != null) {
              this.a.ac.remove(localObject2);
            }
            this.a.ad.notifyDataSetChanged();
          }
        }
        else if (this.a.az == 21)
        {
          localObject2 = this.a.d((String)localObject1);
          this.a.av.add(localObject1);
          this.a.K.c();
          if (this.a.bm.isShowing())
          {
            if (localObject2 != null) {
              this.a.ac.remove(localObject2);
            }
            this.a.ad.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          ChatHistoryTroopMemberFragment.b(this.a, (List)localObject2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.37
 * JD-Core Version:    0.7.0.1
 */