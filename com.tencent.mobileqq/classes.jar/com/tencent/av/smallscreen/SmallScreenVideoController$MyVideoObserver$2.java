package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$MyVideoObserver$2
  implements Runnable
{
  SmallScreenVideoController$MyVideoObserver$2(SmallScreenVideoController.MyVideoObserver paramMyVideoObserver, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = SharedPreUtils.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_AndroidContentContext);
    if (!((SharedPreferences)localObject).getBoolean("kick_out_self", false)) {
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.c != 1) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.c != 2))
      {
        if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.c != 3) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.c != 4))
        {
          if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.c == 0) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.d == 1) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.d == 2)))
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.b = this.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.d();
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_ComTencentAvVideoController;
          String str = null;
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_ComTencentAvVideoController.a();
          }
          if (localObject == null) {
            localObject = str;
          } else {
            localObject = String.valueOf(((SessionInfo)localObject).f);
          }
          if (localObject != null)
          {
            str = this.jdField_a_of_type_JavaLangString;
            if ((str != null) && (((String)localObject).equals(str)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
              }
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.b = this.jdField_a_of_type_Boolean;
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.d();
            }
          }
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.b = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.d();
        }
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt("video_position", this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.h());
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.2
 * JD-Core Version:    0.7.0.1
 */