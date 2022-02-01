package com.tencent.biz.qqcircle.publish.viewmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import java.util.HashMap;

class QCirclePublishViewModel$3
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCirclePublishViewModel$3(QCirclePublishViewModel paramQCirclePublishViewModel) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = (String)this.a.f.get(0);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_MEDIA_PATH(), str);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_VIDEO_MISSION_ID(), ((LocalMediaInfo)this.a.g.get(str)).missionID);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_POSITION(), ((LocalMediaInfo)this.a.g.get(str)).thumbnailProgress);
    QCircleHostLauncher.startWithPublicFragmentActivityForPeakForResult(paramContext, localIntent, QCircleHostClassHelper.getPublicFragmentActivityForPeakClass(), QCircleHostClassHelper.getAECoverSelectFragmentClass(), 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel.3
 * JD-Core Version:    0.7.0.1
 */