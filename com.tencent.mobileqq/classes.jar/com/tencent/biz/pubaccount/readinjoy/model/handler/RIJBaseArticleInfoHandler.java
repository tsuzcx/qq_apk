package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ExecutorService;

public abstract class RIJBaseArticleInfoHandler
{
  protected final Handler a;
  protected final ArticleInfoModule a;
  protected final ReadInJoyMSFService a;
  protected final AppInterface a;
  protected final EntityManager a;
  protected final ExecutorService a;
  
  public RIJBaseArticleInfoHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = paramArticleInfoModule;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = paramReadInJoyMSFService;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJBaseArticleInfoHandler
 * JD-Core Version:    0.7.0.1
 */