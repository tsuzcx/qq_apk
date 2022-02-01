package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;

public class GetQZonePhotoGuideCheck
  extends AsyncStep
{
  public static boolean a = false;
  
  protected int doStep()
  {
    a = true;
    QzoneAlbumRedTouchManager localQzoneAlbumRedTouchManager = (QzoneAlbumRedTouchManager)this.mAutomator.k.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH);
    if (localQzoneAlbumRedTouchManager != null) {
      localQzoneAlbumRedTouchManager.f();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck
 * JD-Core Version:    0.7.0.1
 */