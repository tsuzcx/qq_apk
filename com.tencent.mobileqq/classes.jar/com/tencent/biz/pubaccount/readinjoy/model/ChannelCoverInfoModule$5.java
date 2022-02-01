package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import puf;

public class ChannelCoverInfoModule$5
  implements Runnable
{
  public ChannelCoverInfoModule$5(puf parampuf, int paramInt) {}
  
  public void run()
  {
    List localList = puf.a(this.this$0, this.a);
    if ((localList != null) && (localList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder("loadChannelCoverListFromDB size = " + localList.size() + "\n");
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo.mArticleId).append(", mChannelType=").append(localChannelCoverInfo.mChannelType).append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      this.this$0.d(localList, this.a);
      this.this$0.f(localList, this.a);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "loadChannelCoverListFromDB list is null");
      }
    } while (this.a != 41402);
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.5
 * JD-Core Version:    0.7.0.1
 */