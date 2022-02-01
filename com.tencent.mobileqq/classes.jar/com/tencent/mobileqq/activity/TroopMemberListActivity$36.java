package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
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
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnKickOutBtnClickListener onclick");
      }
      int j = paramView.getId();
      Object localObject1 = (String)paramView.getTag();
      boolean bool1 = ((String)localObject1).equals(this.a.mTroopOwnerUin);
      Object localObject2 = this.a.mTroopAdminUins;
      boolean bool3 = false;
      boolean bool2 = false;
      int i;
      if ((localObject2 != null) && (this.a.mTroopAdminUins.contains((CharSequence)localObject1))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool4 = this.a.app.getCurrentAccountUin().equals(this.a.mTroopOwnerUin);
      if (((bool4) && (!((String)localObject1).equals(this.a.app.getCurrentAccountUin()))) || ((!bool4) && (!bool1) && (i == 0))) {
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
        localObject2 = this.a.findListItemHolderByUin((String)localObject1, bool1);
        if (this.a.mFrom == 20)
        {
          if (localObject2 != null)
          {
            localObject1 = ((TroopMemberListActivity.TmViewHolder)localObject2).a.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof Integer)))
            {
              i = ((Integer)localObject1).intValue();
              if (i >= 0)
              {
                localObject1 = (TroopMemberListActivity.ATroopMember)this.a.mAdapter.getItem(i);
                this.a.doItemClick((TroopMemberListActivity.ATroopMember)localObject1);
              }
            }
          }
        }
        else if (this.a.mIsInMultiDeleteState)
        {
          if (this.a.mAdapter.b.contains(localObject1)) {
            this.a.mAdapter.b.remove(localObject1);
          } else if (i != 0) {
            this.a.mAdapter.b.add(localObject1);
          }
          TroopMemberListActivity.access$200(this.a);
          this.a.mAdapter.notifyDataSetChanged();
        }
        else if (bool1)
        {
          if (!this.a.mSearchSlideLeftUin.equals(localObject1))
          {
            if (localObject2 != null) {
              ((TroopMemberListActivity.TmViewHolder)localObject2).a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.mSearchSlideLeftUin))
            {
              localObject2 = this.a;
              localObject2 = ((TroopMemberListActivity)localObject2).findListItemHolderByUin(((TroopMemberListActivity)localObject2).mSearchSlideLeftUin, bool1);
              if (localObject2 != null) {
                ((TroopMemberListActivity.TmViewHolder)localObject2).a.b(true);
              }
            }
            this.a.mSearchSlideLeftUin = ((String)localObject1);
          }
        }
        else if (!this.a.mSlideLeftUin.equals(localObject1))
        {
          if (localObject2 != null) {
            ((TroopMemberListActivity.TmViewHolder)localObject2).a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.mSlideLeftUin))
          {
            localObject2 = this.a;
            localObject2 = ((TroopMemberListActivity)localObject2).findListItemHolderByUin(((TroopMemberListActivity)localObject2).mSlideLeftUin, bool1);
            if (localObject2 != null) {
              ((TroopMemberListActivity.TmViewHolder)localObject2).a.b(true);
            }
          }
          this.a.mSlideLeftUin = ((String)localObject1);
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
        if (this.a.mIsInMultiDeleteState)
        {
          if (this.a.mAdapter.b.contains(localObject1)) {
            this.a.mAdapter.b.remove(localObject1);
          } else if (i != 0) {
            this.a.mAdapter.b.add(localObject1);
          }
          TroopMemberListActivity.access$200(this.a);
          this.a.mAdapter.notifyDataSetChanged();
        }
        if (bool1)
        {
          localObject1 = this.a;
          localObject1 = ((TroopMemberListActivity)localObject1).findListItemHolderByUin(((TroopMemberListActivity)localObject1).mSearchSlideLeftUin, bool1);
          if (localObject1 != null)
          {
            ((TroopMemberListActivity.TmViewHolder)localObject1).a.b(true);
            this.a.mSearchSlideLeftUin = "";
          }
          this.a.mSearchResultAdapter.notifyDataSetChanged();
        }
        else
        {
          localObject1 = this.a;
          localObject1 = ((TroopMemberListActivity)localObject1).findListItemHolderByUin(((TroopMemberListActivity)localObject1).mSlideLeftUin, bool1);
          if (localObject1 != null)
          {
            ((TroopMemberListActivity.TmViewHolder)localObject1).a.b(true);
            this.a.mSlideLeftUin = "";
          }
        }
      }
      else if ((j == 2131363963) && (this.a.mIsInDeleteState))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delBtn onClick, uin=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          if (this.a.isResume())
          {
            localObject1 = this.a;
            QQToast.a((Context)localObject1, ((TroopMemberListActivity)localObject1).getString(2131694424), 0).b(this.a.getTitleBarHeight());
          }
        }
        else if (this.a.mFrom == 1)
        {
          this.a.kickOutDiscussionMember((String)localObject1);
        }
        else if (this.a.mFrom == 13)
        {
          localObject2 = this.a.removeItem((String)localObject1);
          this.a.mDelList.add(localObject1);
          this.a.mAdapter.a();
          if (this.a.mSearchDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.mSearchResultList.remove(localObject2);
            }
            this.a.mSearchResultAdapter.notifyDataSetChanged();
          }
        }
        else if (this.a.mFrom == 21)
        {
          localObject2 = this.a.removeItem((String)localObject1);
          this.a.mDelList.add(localObject1);
          this.a.mAdapter.a();
          if (this.a.mSearchDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.mSearchResultList.remove(localObject2);
            }
            this.a.mSearchResultAdapter.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          TroopMemberListActivity.access$1800(this.a, (List)localObject2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.36
 * JD-Core Version:    0.7.0.1
 */