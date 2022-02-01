package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleProfileCardChangeListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

class QCircleInsFeedItemView$1
  implements QCircleProfileCardChangeListener
{
  QCircleInsFeedItemView$1(QCircleInsFeedItemView paramQCircleInsFeedItemView) {}
  
  public void updateNickName(String paramString1, String paramString2)
  {
    if (QCirclePluginUtil.d(paramString2)) {
      QCirclePluginGlobalInfo.c().nick.set(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView.1
 * JD-Core Version:    0.7.0.1
 */