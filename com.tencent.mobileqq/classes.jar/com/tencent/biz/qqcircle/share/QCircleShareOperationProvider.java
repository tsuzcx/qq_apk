package com.tencent.biz.qqcircle.share;

import com.tencent.biz.qqcircle.share.operation.QCircleBarrageOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleDeleteOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleDisLikeOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleHideOperation;
import com.tencent.biz.qqcircle.share.operation.QCirclePrivateChatOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleReportOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleSaveOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleUndoPushDisableOperation;
import com.tencent.biz.qqcircle.share.operation.QCircleUndoPushOperation;

public class QCircleShareOperationProvider
{
  static QCircleBaseShareOperation a(QCircleBaseShareOperation.Builder paramBuilder, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 12: 
      return new QCircleUndoPushDisableOperation(paramBuilder);
    case 11: 
      return new QCirclePrivateChatOperation(paramBuilder);
    case 10: 
      return new QCircleSaveOperation(paramBuilder);
    case 9: 
      return new QCircleUndoPushOperation(paramBuilder);
    case 8: 
      return new QCircleDeleteOperation(paramBuilder);
    case 7: 
      return new QCircleHideOperation(paramBuilder);
    case 6: 
      return new QCircleBarrageOperation(paramBuilder);
    case 5: 
      return new QCircleDisLikeOperation(paramBuilder);
    case 4: 
      return new QCircleReportOperation(paramBuilder);
    case 3: 
      return new QCircleWeChatShareOperation(paramBuilder);
    case 2: 
      return new QCircleSpecifiedFriendShareOperation(paramBuilder);
    case 1: 
      return new QCircleQZoneShareOperation(paramBuilder);
    }
    return new QCircleQQShareOperation(paramBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleShareOperationProvider
 * JD-Core Version:    0.7.0.1
 */