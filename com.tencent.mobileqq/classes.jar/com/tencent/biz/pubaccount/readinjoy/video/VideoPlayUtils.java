package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class VideoPlayUtils
{
  public static final String a = String.valueOf(20160519);
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 10000;
    if (paramInt2 * 1000 > 60000) {
      if (paramInt1 <= paramInt2 * 1000 - 8000) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "getPreviewStartPosi(): forwardPosition=" + paramInt1 + ", videoDuration=" + paramInt2 + " => previewStartPosi=" + i);
      }
      return i;
      if (paramInt1 >= 8000)
      {
        i = paramInt1 - 8000;
        continue;
        i = 0;
      }
    }
  }
  
  public static int a(ListView paramListView, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam = paramListView.getChildAt(paramVideoPlayParam.a + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramVideoPlayParam != null) {
        return paramVideoPlayParam.getBottom() - AIOUtils.a(175.0F, paramListView.getResources());
      }
    }
    return 0;
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 0) {
      return 0L;
    }
    return paramInt2 * 512 + paramInt1 * paramInt3 / paramInt2;
  }
  
  public static String a()
  {
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOW ";
    case 0: 
      return " PLAY_STATE_IDLE ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    case 6: 
      return " PLAY_STATE_ERROR ";
    }
    return "PLAY_STATE_DESTORY";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103) {
        return HardCodeUtil.a(2131716156) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 108) {
        return HardCodeUtil.a(2131718441) + ": " + paramInt1 + "-" + paramInt2;
      }
      return HardCodeUtil.a(2131716170) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return HardCodeUtil.a(2131716166) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 202) {
        return HardCodeUtil.a(2131716159) + paramInt1 + "-" + paramInt2;
      }
      return HardCodeUtil.a(2131716146) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return HardCodeUtil.a(2131716158) + paramInt1 + "-" + paramInt2;
      }
      return HardCodeUtil.a(2131716148) + paramInt1 + "-" + paramInt2;
    }
    return HardCodeUtil.a(2131716154) + paramInt1 + "-" + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils
 * JD-Core Version:    0.7.0.1
 */