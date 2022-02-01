package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.ConvertListener;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.RetCode;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MuiltiImageToVideo$1
  implements HWEncodeListener
{
  public long a;
  
  MuiltiImageToVideo$1(MuiltiImageToVideo paramMuiltiImageToVideo, List paramList, VideoStoryPicToVideo.ConvertListener paramConvertListener, VideoStoryPicToVideo.RetCode paramRetCode) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * MuiltiImageToVideo.c(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo);
      boolean bool1 = bool2;
      if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) != null)
      {
        bool1 = bool2;
        if (((Integer)MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) < MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) * 1000000L)
          {
            MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).a(3553, ((Integer)MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).get(0)).intValue(), null, null, MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo));
            MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo, MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).size());
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo.notifyAll();
      if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener != null)
      {
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(paramThrowable.getMessage());
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode.a(943001);
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener.b(this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo));
    }
    if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener != null) {
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$ConvertListener.a(this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryPicToVideo$RetCode);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) != null)
    {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).surfaceDestroyed();
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo, null);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) != null)
    {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).d();
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo, null);
    }
    if (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) != null) {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).clear();
    }
    synchronized (this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo) != null)) {
      MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).c();
    }
  }
  
  public void onEncodeStart()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo)) {}
      for (int i = MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo), MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo));; i = MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo, localBitmap, MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo), MuiltiImageToVideo.b(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo)))
      {
        MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + MuiltiImageToVideo.a(this.jdField_a_of_type_ComTencentBizVideostoryVideoMuiltiImageToVideo));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MuiltiImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */