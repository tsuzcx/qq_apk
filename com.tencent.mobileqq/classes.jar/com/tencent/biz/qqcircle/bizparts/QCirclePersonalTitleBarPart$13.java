package com.tencent.biz.qqcircle.bizparts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

class QCirclePersonalTitleBarPart$13
  implements DialogInterface.OnClickListener
{
  QCirclePersonalTitleBarPart$13(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(QCirclePersonalTitleBarPart.c(this.a).id.get(), 1, 1, null), new QCirclePersonalTitleBarPart.13.1(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.13
 * JD-Core Version:    0.7.0.1
 */