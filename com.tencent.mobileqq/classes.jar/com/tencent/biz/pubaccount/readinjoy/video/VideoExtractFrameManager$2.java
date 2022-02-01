package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class VideoExtractFrameManager$2
  implements VideoExtractFrameTask.Callback
{
  VideoExtractFrameManager$2(VideoExtractFrameManager.VideoInfo paramVideoInfo) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "执行结果，onResult code = " + paramInt);
    }
    try
    {
      int i = VideoExtractFrameManager.a().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      VideoExtractFrameManager.a().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      ReadInJoyHelper.a("kandian_video_extract_frame_local_result", VideoExtractFrameManager.a().toString());
      label66:
      VideoExtractFrameManager.a(System.currentTimeMillis() - VideoExtractFrameManager.a());
      VideoExtractFrameManager.b(paramLong);
      VideoExtractFrameManager.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!VideoExtractFrameManager.a().compareAndSet(false, true)) {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
      }
      while (VideoExtractFrameManager.a() == null) {
        return;
      }
      VideoExtractFrameManager.a().b();
      VideoExtractFrameManager.a(null);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameManager.2
 * JD-Core Version:    0.7.0.1
 */