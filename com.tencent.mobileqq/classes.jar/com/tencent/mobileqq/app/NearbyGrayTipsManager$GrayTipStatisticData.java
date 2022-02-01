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
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GreetTipStaticData, ");
      localStringBuilder.append(paramInt);
      QLog.i("nearby_aio_operation_gray_tips", 4, localStringBuilder.toString());
    }
    this.mId = paramInt;
    this.mTotalCount = 0;
    this.mOneDayCount = 0;
    this.mLastMarkDay = 0L;
  }
  
  public static String getPath(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramString = MD5.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGrayTipsManager.d());
    localStringBuilder.append(GrayTipStatisticData.class.getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void increase(long paramLong)
  {
    this.mTotalCount += 1;
    if (NearbyGrayTipsManager.a(paramLong, this.mLastMarkDay))
    {
      this.mOneDayCount += 1;
    }
    else
    {
      this.mLastMarkDay = paramLong;
      this.mOneDayCount = 1;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("increase, ");
      localStringBuilder.append(toString());
      QLog.i("nearby_aio_operation_gray_tips", 4, localStringBuilder.toString());
    }
  }
  
  public boolean isLimit(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, long paramLong)
  {
    boolean bool1;
    if ((paramGrayTipsConfig.singleTaskMaxTipsCount > 0) && (this.mTotalCount >= paramGrayTipsConfig.singleTaskMaxTipsCount)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramGrayTipsConfig.singleTaskMaxTipsCountPerDay > 0)
      {
        bool2 = bool1;
        if (NearbyGrayTipsManager.a(paramLong, this.mLastMarkDay)) {
          if (this.mOneDayCount >= paramGrayTipsConfig.singleTaskMaxTipsCountPerDay) {
            bool2 = true;
          } else {
            bool2 = false;
          }
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLimit = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramGrayTipsConfig.toString());
      localStringBuilder.append(",");
      localStringBuilder.append(toString());
      QLog.i("nearby_aio_operation_gray_tips", 4, localStringBuilder.toString());
    }
    return bool2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    localStringBuffer.append(this.mId);
    localStringBuffer.append(',');
    localStringBuffer.append(this.mTotalCount);
    localStringBuffer.append(',');
    localStringBuffer.append(this.mOneDayCount);
    localStringBuffer.append(',');
    localStringBuffer.append(this.mLastMarkDay);
    localStringBuffer.append(',');
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipStatisticData
 * JD-Core Version:    0.7.0.1
 */