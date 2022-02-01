package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import mqq.os.MqqHandler;

public class QQReportBridgeImpl
  implements QQReportBridge
{
  private final CommentArgumentModel a;
  
  public QQReportBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
  }
  
  public void asyncReport(Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new QQReportBridgeImpl.1(this, paramBundle));
  }
  
  public int getCommentLevel()
  {
    if ((this.a.e) || ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData))) {
      return 2;
    }
    if ((TextUtils.isEmpty(this.a.c)) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null)) {
      return 0;
    }
    return 1;
  }
  
  public long getConsumeTime()
  {
    return TimeSliceHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L;
  }
  
  public int getEntry()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) {
      i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d();
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager;
    do
    {
      return i;
      localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    } while (localReadInJoyCommentDataManager == null);
    return localReadInJoyCommentDataManager.a();
  }
  
  public int getFolderStatus()
  {
    return RIJKanDianFolderStatus.a;
  }
  
  public String getReportVersion()
  {
    return VideoReporter.a;
  }
  
  public int getScene()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) {
      i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b();
    }
    return i;
  }
  
  public void report(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("toUin");
    String str2 = paramBundle.getString("subAction");
    String str3 = paramBundle.getString("actionName");
    int i = paramBundle.getInt("fromType", 0);
    int j = paramBundle.getInt("result", 0);
    String str4 = paramBundle.getString("r2", "");
    String str5 = paramBundle.getString("r3", "");
    String str6 = paramBundle.getString("r4", "");
    String str7 = paramBundle.getString("r5", "");
    boolean bool = paramBundle.getBoolean("shouldEncode", false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str1, str2, str3, i, j, str4, str5, str6, str7, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQReportBridgeImpl
 * JD-Core Version:    0.7.0.1
 */