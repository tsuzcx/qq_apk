package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class LikeRankingListActivity$2
  extends CardObserver
{
  LikeRankingListActivity$2(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  protected void onReqLikeRankingListResult(boolean paramBoolean1, String paramString, List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReqLikeRankingListResult success:");
      ((StringBuilder)localObject).append(paramBoolean1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", size:");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(", nextIndex: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isComplete:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("LikeRankingListActivity", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    if (paramBoolean1)
    {
      if ((paramList != null) && ((paramList.size() > 0) || (paramBoolean2)))
      {
        this.a.a.a(paramList, paramInt, paramBoolean2);
        if ((paramBoolean2) && (paramList.size() == 0)) {
          this.a.v.setVisibility(0);
        } else {
          this.a.v.setVisibility(8);
        }
        this.a.n.a(paramList, true);
        if (this.a.e == 0) {
          if (paramList.size() > 0)
          {
            this.a.a(String.valueOf(((LikeRankingInfo)paramList.get(0)).uin));
            LikeRankingListActivity.a(this.a, false);
          }
          else
          {
            this.a.a(null);
          }
        }
      }
      else
      {
        this.a.a(null);
        this.a.n.b = false;
        this.a.n.notifyDataSetChanged();
        if (this.a.n.getCount() <= 1) {
          this.a.v.setVisibility(0);
        }
      }
      paramString = this.a;
      if (paramBoolean2) {
        paramInt = -1;
      }
      paramString.e = paramInt;
      return;
    }
    this.a.n.b = false;
    this.a.n.notifyDataSetChanged();
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131904056), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.2
 * JD-Core Version:    0.7.0.1
 */