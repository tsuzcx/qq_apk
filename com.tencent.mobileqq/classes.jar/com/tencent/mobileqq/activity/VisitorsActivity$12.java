package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VisitorsActivity$12
  extends CardObserver
{
  VisitorsActivity$12(VisitorsActivity paramVisitorsActivity) {}
  
  public void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_b_of_type_JavaUtilArrayList;
      if (this.a.jdField_b_of_type_Boolean) {
        paramString = new ArrayList();
      }
      this.a.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      if (this.a.jdField_b_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramArrayOfByte = paramString;
        if (paramArrayList != null) {
          paramArrayOfByte = LbsPortraitUtil.a(paramString, paramArrayList);
        }
        this.a.b(paramArrayOfByte, paramLong1);
        return;
      }
    }
    this.a.d();
  }
  
  public void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  public void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("onReqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) }));
    }
    if (paramLong1 != Long.parseLong(this.a.app.getCurrentAccountUin())) {}
    while (paramBoolean) {
      return;
    }
    this.a.a(1, HardCodeUtil.a(2131716641));
  }
  
  public void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.b(paramString2, paramInt1, true);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramString2, paramInt1, true);
        return;
      }
    } while (paramInt2 != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(Long.parseLong(paramString2));
  }
  
  public void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  public void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2 + "todayVoteCount=" + paramInt3 + "todayVoteRank=" + paramInt4 + "totalVoteCount=" + paramInt5);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramArrayList1, paramInt1, paramInt2, paramLong1);
      paramString = this.a.jdField_a_of_type_JavaUtilArrayList;
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.app.getMessageFacade().c(AppConstants.VOTE_MSG_UIN, 1001);
        this.a.app.getMessageFacade().c(AppConstants.VOTE_MSG_UIN, 10002);
        paramString = new ArrayList();
      }
      this.a.jdField_a_of_type_Long = paramLong2;
      paramArrayList1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      if (this.a.jdField_a_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayList1.a(paramBoolean);
        paramArrayList1 = paramString;
        if (paramArrayList != null) {
          paramArrayList1 = LbsPortraitUtil.a(paramString, paramArrayList);
        }
        this.a.a(paramArrayList1, paramLong1);
        this.a.a(paramInt3, paramInt4, paramInt5);
        return;
      }
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.12
 * JD-Core Version:    0.7.0.1
 */