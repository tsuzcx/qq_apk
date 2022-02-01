package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pqu;
import qif;
import rsp;

public class VideoArticleModule$3
  implements Runnable
{
  public VideoArticleModule$3(qif paramqif, long paramLong1, boolean paramBoolean1, List paramList, int paramInt, boolean paramBoolean2, long paramLong2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    boolean bool;
    StringBuilder localStringBuilder1;
    label63:
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    String str;
    if (this.jdField_a_of_type_Long == -1L)
    {
      bool = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label374;
      }
      localStringBuilder1 = new StringBuilder("\n");
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label275;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      if (!localIterator.hasNext()) {
        break label275;
      }
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)localIterator.next();
      if (localWeiShiVideoArticleInfo == null) {
        break label446;
      }
      StringBuilder localStringBuilder2 = new StringBuilder().append("article【").append(i).append("】 id : ").append(localWeiShiVideoArticleInfo.articleID).append(" seq : ").append(localWeiShiVideoArticleInfo.recommendSeq).append(" title : ").append(pqu.a(localWeiShiVideoArticleInfo.title)).append(" rowkey : ").append(localWeiShiVideoArticleInfo.rowkey).append(" isUgc : ").append(localWeiShiVideoArticleInfo.isUgc).append(" vid : ");
      if (localWeiShiVideoArticleInfo.videoData != null) {
        break label263;
      }
      str = "";
      label192:
      localStringBuilder1.append(str + " feedsType : " + localWeiShiVideoArticleInfo.feedsType + " algorithmID : " + localWeiShiVideoArticleInfo.algorithmID + " strategyId : " + localWeiShiVideoArticleInfo.strategyID + " \n");
      i += 1;
    }
    label263:
    label275:
    label446:
    for (;;)
    {
      break label63;
      bool = false;
      break;
      str = localWeiShiVideoArticleInfo.videoData.a;
      break label192;
      QLog.i(qif.a, 1, "onGetChannelArticleList success=" + this.jdField_a_of_type_Boolean + " channelId=" + this.jdField_a_of_type_Int + " noMoreData=" + this.jdField_b_of_type_Boolean + " beginRecommendSeq=" + this.jdField_a_of_type_Long + " endRecommendSeq=" + this.jdField_b_of_type_Long + " isRefresh : " + bool + ", " + localStringBuilder1.toString());
      label374:
      if (bool)
      {
        qif.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
        return;
      }
      qif.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.3
 * JD-Core Version:    0.7.0.1
 */