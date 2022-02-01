package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import android.os.SystemClock;
import bbns;
import bbnt;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import java.util.ArrayList;
import java.util.List;
import ykq;
import ypn;
import zeb;
import zfl;
import zfm;

class HWEditLocalVideoPlayer$2
  implements Runnable
{
  HWEditLocalVideoPlayer$2(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    Object localObject1;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject1 = null;
      if (this.this$0.jdField_a_of_type_Boolean) {
        localObject1 = zfl.a(HWEditLocalVideoPlayer.a(this.this$0), l1);
      }
      if (localObject1 != null) {
        break label641;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new zfm(i * l1, l1));
        i += 1;
      }
    }
    label641:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new zfm(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      label371:
      int j;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (zfm)((ArrayList)localObject1).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((zfm)localObject2).a + ((zfm)localObject2).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        ypn localypn = new ypn(i, bbnt.a(HWEditLocalVideoPlayer.a(this.this$0), (int)((zfm)localObject2).a));
        ypn.a(localypn, ((zfm)localObject2).a);
        ypn.b(localypn, l1);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localypn);
        ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create FRAGMENT info = %s, cost = %dms", localypn, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
      }
      else
      {
        ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
          break label621;
        }
        localObject1 = (ypn)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = zeb.a(HWEditLocalVideoPlayer.a(this.this$0));
        localObject2 = AppConstants.SDCARD_AUDIO_CACHE + (String)localObject2 + "_" + i + ".IFrames.audio";
        j = bbns.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)ypn.a((ypn)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)ypn.b((ypn)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        if (j != 0) {
          break label557;
        }
        ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((ypn)localObject1).b = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label371;
        i += 1;
        break;
        label557:
        ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(ypn.a((ypn)localObject1)), Long.valueOf(ypn.b((ypn)localObject1)) });
      }
      label621:
      HWEditLocalVideoPlayer.a(this.this$0).post(new HWEditLocalVideoPlayer.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */