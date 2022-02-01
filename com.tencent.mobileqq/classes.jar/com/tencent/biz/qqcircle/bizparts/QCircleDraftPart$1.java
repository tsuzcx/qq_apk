package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class QCircleDraftPart$1
  implements View.OnClickListener
{
  QCircleDraftPart$1(QCircleDraftPart paramQCircleDraftPart) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject = (DraftBean)paramView.getTag();
      if ((((DraftBean)localObject).getOriginPath() != null) && (!new File(((DraftBean)localObject).getOriginPath()).exists()))
      {
        this.a.a(((DraftBean)localObject).getMissionId());
      }
      else
      {
        localObject = ((DraftBean)localObject).getMissionId();
        Bundle localBundle = new Bundle();
        localBundle.putString("key_wink_video_mission_id", (String)localObject);
        localBundle.putInt("EDITOR_ENTRANCE", 3);
        ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchAEMutiCameraFromFS(this.a.a(this.a.c()), localBundle);
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleDraftPart", 1, localException, new Object[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDraftPart.1
 * JD-Core Version:    0.7.0.1
 */