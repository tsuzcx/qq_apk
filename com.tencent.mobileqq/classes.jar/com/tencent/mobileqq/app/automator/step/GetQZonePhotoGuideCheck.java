package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;

public class GetQZonePhotoGuideCheck
  extends AsyncStep
{
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    jdField_a_of_type_Boolean = true;
    QzoneAlbumRedTouchManager localQzoneAlbumRedTouchManager = (QzoneAlbumRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH);
    if (localQzoneAlbumRedTouchManager != null) {
      localQzoneAlbumRedTouchManager.c();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck
 * JD-Core Version:    0.7.0.1
 */