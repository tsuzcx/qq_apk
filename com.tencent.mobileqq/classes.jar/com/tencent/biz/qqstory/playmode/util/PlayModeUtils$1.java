package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

final class PlayModeUtils$1
  implements URLDrawable.URLDrawableListener
{
  PlayModeUtils$1(long paramLong, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.PlayModeUtils", 2, "urlDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$ImageViewLoadCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$ImageViewLoadCallback.b();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.PlayModeUtils", 2, "urlDrawable onLoadSuccessed");
    }
    StoryReportor.b("storypic", "load_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$ImageViewLoadCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$ImageViewLoadCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.1
 * JD-Core Version:    0.7.0.1
 */