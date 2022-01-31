package com.tencent.biz.pubaccount;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;
import kzu;
import kzv;
import mqq.os.MqqHandler;

public class PublicAccountUnfollowTask
  extends PublicAccountObserver
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private PublicAccountUnfollowTask.UnFollowPublicAccountListenner jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this(paramQQAppInterface, paramString, paramContext, null);
  }
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, PublicAccountUnfollowTask.UnFollowPublicAccountListenner paramUnFollowPublicAccountListenner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner = paramUnFollowPublicAccountListenner;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int >= 3) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.d("PublicAccountUnfollowTask", 2, "retry count reach max value or app = null ! retryCount : " + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new kzu(this));
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 3)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account fail ! uin : " + this.jdField_a_of_type_JavaLangString + " , errCode : " + paramInt + ", retry : " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.post(new kzv(this));
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner.a(false, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account success ! uin : " + paramString + ",retry : " + this.jdField_a_of_type_Int);
      int i = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, 1008);
      ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a().e();
      if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountUnfollowTask$UnFollowPublicAccountListenner.a(true, paramString);
      }
      return;
    }
    a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountUnfollowTask
 * JD-Core Version:    0.7.0.1
 */