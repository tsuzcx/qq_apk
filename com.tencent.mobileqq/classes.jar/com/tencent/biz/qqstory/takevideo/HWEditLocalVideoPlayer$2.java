package com.tencent.biz.qqstory.takevideo;

import ajsd;
import android.os.Handler;
import android.os.SystemClock;
import awag;
import awah;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import ved;
import vje;
import vyf;
import vzu;
import vzv;

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
        localObject1 = vzu.a(HWEditLocalVideoPlayer.a(this.this$0), l1);
      }
      if (localObject1 != null) {
        break label641;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new vzv(i * l1, l1));
        i += 1;
      }
    }
    label641:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new vzv(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      label371:
      int j;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (vzv)((ArrayList)localObject1).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((vzv)localObject2).a + ((vzv)localObject2).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        vje localvje = new vje(i, awah.a(HWEditLocalVideoPlayer.a(this.this$0), (int)((vzv)localObject2).a));
        vje.a(localvje, ((vzv)localObject2).a);
        vje.b(localvje, l1);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localvje);
        ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create FRAGMENT info = %s, cost = %dms", localvje, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
      }
      else
      {
        ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
          break label621;
        }
        localObject1 = (vje)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = vyf.a(HWEditLocalVideoPlayer.a(this.this$0));
        localObject2 = ajsd.cg + (String)localObject2 + "_" + i + ".IFrames.audio";
        j = awag.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)vje.a((vje)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)vje.b((vje)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        if (j != 0) {
          break label557;
        }
        ved.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((vje)localObject1).b = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label371;
        i += 1;
        break;
        label557:
        ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(vje.a((vje)localObject1)), Long.valueOf(vje.b((vje)localObject1)) });
      }
      label621:
      HWEditLocalVideoPlayer.a(this.this$0).post(new HWEditLocalVideoPlayer.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */