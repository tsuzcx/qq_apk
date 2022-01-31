import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.Mp4VideoFragmentInfo;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil.FrameWithoutBlackResult;
import java.util.ArrayList;
import java.util.List;

public class anvv
  implements Runnable
{
  public anvv(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    HWEditImportVideoPlayer.a(this.a);
    if (this.a.jdField_a_of_type_Boolean) {}
    Object localObject2;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject2 = VideoUtils.a(HWEditImportVideoPlayer.a(this.a), l1);
      if (localObject2 != null) {
        break label948;
      }
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject2).add(new VideoUtils.VideoKeyFrameFragment(i * l1, l1));
        i += 1;
      }
    }
    label931:
    label948:
    for (;;)
    {
      if (((ArrayList)localObject2).size() <= 0) {
        ((ArrayList)localObject2).add(new VideoUtils.VideoKeyFrameFragment(0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject1;
      int j;
      if (i < ((ArrayList)localObject2).size())
      {
        localObject1 = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject2).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(HWEditImportVideoPlayer.a(this.a) + ((VideoUtils.VideoKeyFrameFragment)localObject1).b, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
          l1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        Object localObject3 = MediaUtil.a(HWEditImportVideoPlayer.a(this.a), HWEditImportVideoPlayer.a(this.a));
        localObject1 = localObject3;
        if (i == 0)
        {
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            float f = MediaCodecThumbnailGenerator.a((Bitmap)localObject3);
            SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
            localObject1 = localObject3;
            if (f > 0.9F)
            {
              MediaUtil.FrameWithoutBlackResult localFrameWithoutBlackResult = MediaUtil.a(HWEditImportVideoPlayer.a(this.a), HWEditImportVideoPlayer.a(this.a));
              localObject1 = localObject3;
              if (localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap != null)
              {
                localObject1 = localObject3;
                if (localFrameWithoutBlackResult.jdField_a_of_type_Long > 0L)
                {
                  localObject1 = localObject3;
                  if (MediaCodecThumbnailGenerator.a(localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap) <= 0.9F)
                  {
                    if (!((Bitmap)localObject3).isRecycled()) {
                      ((Bitmap)localObject3).recycle();
                    }
                    localObject1 = localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap;
                    HWEditImportVideoPlayer.a(this.a, (int)(localFrameWithoutBlackResult.jdField_a_of_type_Long / 1000L));
                    SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + HWEditImportVideoPlayer.a(this.a));
                  }
                }
              }
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          j = CaptureUtil.a(((Bitmap)localObject1).getWidth());
          int k = CaptureUtil.a(((Bitmap)localObject1).getHeight());
          if (j == ((Bitmap)localObject1).getWidth())
          {
            localObject3 = localObject1;
            if (k == ((Bitmap)localObject1).getHeight()) {}
          }
          else
          {
            SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
            localObject3 = BitmapUtils.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
          }
        }
        localObject1 = new HWEditImportVideoPlayer.Mp4VideoFragmentInfo(i, (Bitmap)localObject3);
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.a(this.a));
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.b(this.a));
        this.a.jdField_a_of_type_JavaUtilList.add(localObject1);
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        label694:
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label931;
        }
        localObject1 = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = HWEditImportVideoPlayer.a(this.a) + "_" + i + ".IFrames.audio";
        j = AudioDataUtil.a(HWEditImportVideoPlayer.b(this.a), (String)localObject2, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        if (j != 0) {
          break label867;
        }
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label694;
        i += 1;
        break;
        label867:
        SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
      }
      this.a.a(new anvw(this), 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */