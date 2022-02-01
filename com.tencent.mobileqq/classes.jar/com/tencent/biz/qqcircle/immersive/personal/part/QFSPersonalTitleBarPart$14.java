package com.tencent.biz.qqcircle.immersive.personal.part;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;

class QFSPersonalTitleBarPart$14
  implements DialogInterface.OnClickListener
{
  QFSPersonalTitleBarPart$14(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(QFSPersonalTitleBarPart.g(this.a).c, 1, 1, null), new QFSPersonalTitleBarPart.14.1(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.14
 * JD-Core Version:    0.7.0.1
 */