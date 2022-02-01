package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

class SubscriptRecommendController$1
  extends SubscriptObserver
{
  SubscriptRecommendController$1(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  protected void a(boolean paramBoolean, List<SubscriptRecommendAccountInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecommendList isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" | data: ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(" | isShowRecommend: ");
      localStringBuilder.append(this.a.jdField_a_of_type_Boolean);
      QLog.d("SubscriptObserver", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.a(paramList);
        paramList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
        if ((paramList != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.a.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof SubscriptFeedsActivity))) {
          paramList.sendEmptyMessage(1004);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SubscriptObserver", 2, "onGetRecommendList data is null or empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.1
 * JD-Core Version:    0.7.0.1
 */