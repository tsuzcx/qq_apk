package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.view.MotionEvent;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

class ServiceAccountFolderActivity$5
  implements TopGestureLayout.InterceptTouchEventListener
{
  ServiceAccountFolderActivity$5(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (ServiceAccountFolderActivity.b(this.a) != null)
    {
      float f = paramMotionEvent.getY();
      if ((f > ServiceAccountFolderActivity.b(this.a).getTop()) && (f < ServiceAccountFolderActivity.b(this.a).getBottom())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.5
 * JD-Core Version:    0.7.0.1
 */