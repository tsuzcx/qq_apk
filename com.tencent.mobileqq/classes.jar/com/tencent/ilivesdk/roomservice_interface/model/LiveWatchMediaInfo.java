package com.tencent.ilivesdk.roomservice_interface.model;

import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceFrameInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceStreamInfo;

public class LiveWatchMediaInfo
{
  public ServiceFrameInfo curServiceFrameInfo;
  public boolean firstPlayIsOrigin;
  public int firstPlayLevel;
  public String first_play_url;
  public boolean forceSwitch = false;
  public boolean isOriginStream;
  public boolean isPreload = false;
  public int mContentType;
  public String mFlv_url;
  public String mFlv_url_high;
  public String mFlv_url_low;
  public String mFlv_url_lowest;
  public String mHLS_url;
  public int mLevel;
  public int mLiveType;
  public int mRtmpType;
  public String mRtmp_url;
  public String mRtmp_url_high;
  public String mRtmp_url_low;
  public String mRtmp_url_lowest;
  public int mSdkType = 0;
  public String mUrl;
  public String mUrlHigh;
  public String mUrlLow;
  public String mUrlLowest;
  public LiveVideoStatus mVideoStatus = LiveVideoStatus.Start;
  public String record_url;
  public ServiceStreamInfo serviceStreamInfo;
  public byte[] sig;
  public long sigTimeOut;
  public int sugLevel;
  public ServiceFrameInfo sugServiceFrameInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveWatchMediaInfo{mVideoStatus=");
    localStringBuilder.append(this.mVideoStatus);
    localStringBuilder.append(", mRtmp_url='");
    localStringBuilder.append(this.mRtmp_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mHLS_url='");
    localStringBuilder.append(this.mHLS_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFlv_url='");
    localStringBuilder.append(this.mFlv_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", forceSwitch=");
    localStringBuilder.append(this.forceSwitch);
    localStringBuilder.append(", mUrl='");
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLevel=");
    localStringBuilder.append(this.mLevel);
    localStringBuilder.append(", mUrlHigh='");
    localStringBuilder.append(this.mUrlHigh);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUrlLow='");
    localStringBuilder.append(this.mUrlLow);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRtmpType=");
    localStringBuilder.append(this.mRtmpType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo
 * JD-Core Version:    0.7.0.1
 */