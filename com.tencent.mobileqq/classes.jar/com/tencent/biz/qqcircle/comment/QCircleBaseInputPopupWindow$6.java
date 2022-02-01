package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

class QCircleBaseInputPopupWindow$6
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCircleBaseInputPopupWindow$6(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    HostSelectMemberUtils.onAtClick(paramContext, true, 1, QCircleConfigHelper.ak(), 257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */