package com.tencent.biz.pubaccount.readinjoy.biu;

import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRespData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserApproveModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class RIJNewBiuCardTransformManager
{
  private RIJNewBiuCardTransformManager.BiuInfo a = new RIJNewBiuCardTransformManager.BiuInfo();
  
  public static RIJNewBiuCardTransformManager.BiuInfo a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData, boolean paramBoolean)
  {
    RIJNewBiuCardTransformManager.BiuInfo localBiuInfo = new RIJNewBiuCardTransformManager.BiuInfo();
    if (paramRIJBiuAndCommentRespData == null) {
      return localBiuInfo;
    }
    QLog.d("RIJNewBiuCardTransformManager", 1, "convertRespToBiuInfo | respData : " + paramRIJBiuAndCommentRespData.toString() + " ,isFromRecommentFeeds:" + paramBoolean);
    localBiuInfo.jdField_a_of_type_Boolean = paramBoolean;
    localBiuInfo.jdField_a_of_type_Long = paramRIJBiuAndCommentRespData.a();
    localBiuInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramRIJBiuAndCommentRespData.a();
    localBiuInfo.jdField_a_of_type_JavaLangString = paramRIJBiuAndCommentRespData.c();
    localBiuInfo.b = paramRIJBiuAndCommentRespData.d();
    localBiuInfo.e = paramRIJBiuAndCommentRespData.f();
    localBiuInfo.c = paramRIJBiuAndCommentRespData.g();
    localBiuInfo.d = paramRIJBiuAndCommentRespData.b();
    localBiuInfo.jdField_a_of_type_Int = paramRIJBiuAndCommentRespData.e();
    return localBiuInfo;
  }
  
  public static RIJNewBiuCardTransformManager a()
  {
    return RIJNewBiuCardTransformManager.SingletonInstance.a();
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    int i = RIJItemViewType.a(paramArticleInfo, 0);
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | type : " + i);
    if ((i == 0) || (i == 3) || (i == 1) || (i == 5) || (i == 6) || (i == 126) || (b(paramArticleInfo)))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | valid type : " + i);
      return true;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList not in white list");
    return false;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType articleInfo is null");
      return false;
    }
    if (!paramArticleInfo.isPGCShortContent())
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | is not pgcShortContent");
      return false;
    }
    if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.a == null))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | socialFeedsInfo is null");
      return true;
    }
    int i = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Int;
    if ((i == 1) || (i == 3) || (i == 4) || (i == 2) || (i == 5))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | longContent out");
      return false;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | valid shortContent type");
    return true;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "transformCard | mBiuInfo is null");
      return;
    }
    ReadInJoyLogicEngine.a().a(this.a);
    QLog.d("RIJNewBiuCardTransformManager", 1, " transformCard | mBiuInfo " + this.a);
  }
  
  public void a(RIJNewBiuCardTransformManager.BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo != null)
    {
      this.a = paramBiuInfo;
      QLog.d("RIJNewBiuCardTransformManager", 2, "updateBiuInfo | mBiuInfo  : " + this.a);
      b();
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, biuInfo is null");
      return false;
    }
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, articleInfo is null");
      return false;
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | should refresh when out from related articles");
      return true;
    }
    if (!ReadInJoyLogicEngine.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (;;)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | shouldRefresh: " + bool);
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null)
    {
      Object localObject = (ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).a().a();
        if (localObject != null) {
          ((RIJUserApproveModule)localObject).a(localQQAppInterface.getLongAccountUin(), new RIJNewBiuCardTransformManager.1(this));
        }
      }
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager
 * JD-Core Version:    0.7.0.1
 */