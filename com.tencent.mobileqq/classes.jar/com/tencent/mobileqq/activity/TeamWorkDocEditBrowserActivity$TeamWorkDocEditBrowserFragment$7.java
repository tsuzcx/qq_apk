package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.qphone.base.util.QLog;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$7
  implements FaceObserver
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$7(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, ImageView paramImageView) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 4, "onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7
 * JD-Core Version:    0.7.0.1
 */