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
  
  public void onReqLikeRankingListResult(boolean paramBoolean1, String paramString, List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = "onReqLikeRankingListResult success:" + paramBoolean1;
      paramString = new StringBuilder().append(", uin:").append(paramString).append(", size:");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LikeRankingListActivity", 2, new Object[] { str, i + ", nextIndex: " + paramInt + ", isComplete:" + paramBoolean2 });
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label341;
      }
      if ((paramList == null) || ((paramList.size() <= 0) && (!paramBoolean2))) {
        break label284;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(paramList, paramInt, paramBoolean2);
      if ((!paramBoolean2) || (paramList.size() != 0)) {
        break label258;
      }
      this.a.e.setVisibility(0);
      label165:
      this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.a(paramList, true);
      if (this.a.jdField_a_of_type_Int == 0)
      {
        if (paramList.size() <= 0) {
          break label273;
        }
        this.a.a(String.valueOf(((LikeRankingInfo)paramList.get(0)).uin));
        LikeRankingListActivity.a(this.a, false);
      }
    }
    for (;;)
    {
      paramString = this.a;
      if (paramBoolean2) {
        paramInt = -1;
      }
      paramString.jdField_a_of_type_Int = paramInt;
      return;
      i = paramList.size();
      break;
      label258:
      this.a.e.setVisibility(8);
      break label165;
      label273:
      this.a.a(null);
      continue;
      label284:
      this.a.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.a = false;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.getCount() <= 1) {
        this.a.e.setVisibility(0);
      }
    }
    label341:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.a = false;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.notifyDataSetChanged();
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131706136), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.2
 * JD-Core Version:    0.7.0.1
 */