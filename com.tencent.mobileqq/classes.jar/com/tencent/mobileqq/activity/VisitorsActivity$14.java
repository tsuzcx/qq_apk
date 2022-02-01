package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeResultItem;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import java.util.ArrayList;
import java.util.Iterator;

class VisitorsActivity$14
  extends NearbyCardObserver
{
  VisitorsActivity$14(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals("0", paramString)))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
      }
      if (this.a.b != null) {
        this.a.b.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.b(paramString2, paramInt1, false);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramString2, paramInt1, false);
        return;
      }
    } while (paramInt2 != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(Long.parseLong(paramString2));
  }
  
  public void a(boolean paramBoolean, ArrayList<NearbyLikeLimitManager.LikeResultItem> paramArrayList, int paramInt)
  {
    if ((paramBoolean) && (paramArrayList != null)) {}
    for (;;)
    {
      NearbyLikeLimitManager.LikeResultItem localLikeResultItem;
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          if (paramArrayList.hasNext())
          {
            localLikeResultItem = (NearbyLikeLimitManager.LikeResultItem)paramArrayList.next();
            if (paramInt != 511) {
              break label121;
            }
            if (localLikeResultItem.jdField_a_of_type_Int != 0) {
              continue;
            }
            VoteHelper localVoteHelper = this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper;
            String str = localLikeResultItem.jdField_a_of_type_Long + "";
            int i = localLikeResultItem.b;
            localVoteHelper.a(str, localLikeResultItem.c + i, false);
            continue;
          }
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
      label121:
      if (localLikeResultItem.jdField_a_of_type_Int == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(localLikeResultItem.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.14
 * JD-Core Version:    0.7.0.1
 */