package com.tencent.biz.qqcircle.widgets;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

class QCircleSpecialFollowUserItemView$1
  implements DialogInterface.OnClickListener
{
  QCircleSpecialFollowUserItemView$1(QCircleSpecialFollowUserItemView paramQCircleSpecialFollowUserItemView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FeedCloudMeta.StUser();
    paramDialogInterface.id.set(QCircleSpecialFollowUserItemView.a(this.a));
    QCircleSpecialFollowManager.a().a(paramDialogInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView.1
 * JD-Core Version:    0.7.0.1
 */