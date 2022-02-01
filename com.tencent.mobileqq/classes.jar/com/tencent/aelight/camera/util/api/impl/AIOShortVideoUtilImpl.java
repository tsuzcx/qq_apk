package com.tencent.aelight.camera.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class AIOShortVideoUtilImpl
  implements IAIOShortVideoUtil
{
  public long getBaseActivtiyCreateTime()
  {
    return AIOShortVideoUtil.e;
  }
  
  public long getBaseActivtiyResumeTime()
  {
    return AIOShortVideoUtil.i;
  }
  
  public long getBaseActivtiyStartTime()
  {
    return AIOShortVideoUtil.g;
  }
  
  public long getClickCameraTime()
  {
    return AIOShortVideoUtil.b;
  }
  
  public int getEntranceType(int paramInt)
  {
    return AIOShortVideoUtil.a(paramInt);
  }
  
  public long getPeakLoadTime()
  {
    return AIOShortVideoUtil.a;
  }
  
  public long getStartActivityTime()
  {
    return AIOShortVideoUtil.c;
  }
  
  public void handleSysCameraResult(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, Object paramObject, int paramInt1, int paramInt2)
  {
    AIOShortVideoUtil.a((QQAppInterface)paramAppInterface, paramActivity, paramIntent, (SessionInfo)paramObject, paramInt1, paramInt2);
  }
  
  public void setBaseActivtiyCreateTime(long paramLong)
  {
    AIOShortVideoUtil.e = paramLong;
  }
  
  public void setBaseActivtiyResumeTime(long paramLong)
  {
    AIOShortVideoUtil.i = paramLong;
  }
  
  public void setBaseActivtiyStartTime(long paramLong)
  {
    AIOShortVideoUtil.g = paramLong;
  }
  
  public void setClickCameraTime(long paramLong)
  {
    AIOShortVideoUtil.b = paramLong;
  }
  
  public void setPeakLoadTime(long paramLong)
  {
    AIOShortVideoUtil.a = paramLong;
  }
  
  public void setStartActivtiyTime(long paramLong)
  {
    AIOShortVideoUtil.c = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.AIOShortVideoUtilImpl
 * JD-Core Version:    0.7.0.1
 */