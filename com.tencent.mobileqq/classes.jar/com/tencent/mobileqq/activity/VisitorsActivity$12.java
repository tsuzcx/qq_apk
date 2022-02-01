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
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onFavoritorsList.isSuccess=");
      paramArrayOfByte.append(paramBoolean);
      paramArrayOfByte.append(";uin=");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(";startMid=");
      paramArrayOfByte.append(paramLong1);
      paramArrayOfByte.append(";nextMid=");
      paramArrayOfByte.append(paramLong2);
      QLog.d("VisitorsActivity", 2, paramArrayOfByte.toString());
      if (paramArrayList != null)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onFavoritorsList.voters.size=");
        paramArrayOfByte.append(paramArrayList.size());
        QLog.d("VisitorsActivity", 2, paramArrayOfByte.toString());
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
      paramArrayOfByte = this.a;
      paramArrayOfByte.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = paramArrayOfByte.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      if (this.a.jdField_b_of_type_Long != -1L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramArrayOfByte.a(paramBoolean);
      paramArrayOfByte = paramString;
      if (paramArrayList != null) {
        paramArrayOfByte = LbsPortraitUtil.a(paramString, paramArrayList);
      }
      this.a.b(paramArrayOfByte, paramLong1);
      return;
    }
    this.a.d();
  }
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetPartakeLikeRankingList.isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(";isOn=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("onReqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) }));
    }
    if (paramLong1 != Long.parseLong(this.a.app.getCurrentAccountUin())) {
      return;
    }
    if (!paramBoolean) {
      this.a.a(1, HardCodeUtil.a(2131716296));
    }
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {
      return;
    }
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
    if (paramInt2 == 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(Long.parseLong(paramString2));
    }
  }
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetPartakeLikeRankingList.isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(";isOn=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onVoterList.isSuccess=");
      paramArrayOfByte.append(paramBoolean);
      paramArrayOfByte.append(";uin=");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(";startMid=");
      paramArrayOfByte.append(paramLong1);
      paramArrayOfByte.append(";nextMid=");
      paramArrayOfByte.append(paramLong2);
      paramArrayOfByte.append("todayVoteCount=");
      paramArrayOfByte.append(paramInt3);
      paramArrayOfByte.append("todayVoteRank=");
      paramArrayOfByte.append(paramInt4);
      paramArrayOfByte.append("totalVoteCount=");
      paramArrayOfByte.append(paramInt5);
      QLog.d("VisitorsActivity", 2, paramArrayOfByte.toString());
      if (paramArrayList != null)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onVoterList.voters.size=");
        paramArrayOfByte.append(paramArrayList.size());
        QLog.d("VisitorsActivity", 2, paramArrayOfByte.toString());
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
        this.a.app.getMessageFacade().a(AppConstants.VOTE_MSG_UIN, 1001);
        this.a.app.getMessageFacade().a(AppConstants.VOTE_MSG_UIN, 10002);
        paramString = new ArrayList();
      }
      paramArrayList1 = this.a;
      paramArrayList1.jdField_a_of_type_Long = paramLong2;
      paramArrayList1 = paramArrayList1.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      if (this.a.jdField_a_of_type_Long != -1L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramArrayList1.a(paramBoolean);
      paramArrayList1 = paramString;
      if (paramArrayList != null) {
        paramArrayList1 = LbsPortraitUtil.a(paramString, paramArrayList);
      }
      this.a.a(paramArrayList1, paramLong1);
      this.a.a(paramInt3, paramInt4, paramInt5);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.12
 * JD-Core Version:    0.7.0.1
 */