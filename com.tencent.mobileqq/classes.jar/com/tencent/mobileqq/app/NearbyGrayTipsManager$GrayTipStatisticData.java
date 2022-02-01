package com.tencent.mobileqq.app;

import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class NearbyGrayTipsManager$GrayTipStatisticData
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int mId;
  public long mLastMarkDay;
  public int mOneDayCount;
  public int mTotalCount;
  
  public NearbyGrayTipsManager$GrayTipStatisticData() {}
  
  public NearbyGrayTipsManager$GrayTipStatisticData(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("nearby_aio_operation_gray_tips", 4, "GreetTipStaticData, " + paramInt);
    }
    this.mId = paramInt;
    this.mTotalCount = 0;
    this.mOneDayCount = 0;
    this.mLastMarkDay = 0L;
  }
  
  public static String getPath(String paramString, int paramInt)
  {
    paramString = MD5.toMD5(paramString + "_" + paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGrayTipsManager.a()).append(GrayTipStatisticData.class.getSimpleName()).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public void increase(long paramLong)
  {
    this.mTotalCount += 1;
    if (NearbyGrayTipsManager.a(paramLong, this.mLastMarkDay)) {}
    for (this.mOneDayCount += 1;; this.mOneDayCount = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "increase, " + toString());
      }
      return;
      this.mLastMarkDay = paramLong;
    }
  }
  
  public boolean isLimit(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramGrayTipsConfig.singleTaskMaxTipsCount > 0) {
      if (this.mTotalCount >= paramGrayTipsConfig.singleTaskMaxTipsCount) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((!bool1) && (paramGrayTipsConfig.singleTaskMaxTipsCountPerDay > 0) && (NearbyGrayTipsManager.a(paramLong, this.mLastMarkDay))) {
        if (this.mOneDayCount >= paramGrayTipsConfig.singleTaskMaxTipsCountPerDay) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("nearby_aio_operation_gray_tips", 4, "isLimit = " + bool1 + "," + paramGrayTipsConfig.toString() + "," + toString());
        }
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
      }
      bool1 = false;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[').append(this.mId).append(',').append(this.mTotalCount).append(',').append(this.mOneDayCount).append(',').append(this.mLastMarkDay).append(',').append(']');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipStatisticData
 * JD-Core Version:    0.7.0.1
 */