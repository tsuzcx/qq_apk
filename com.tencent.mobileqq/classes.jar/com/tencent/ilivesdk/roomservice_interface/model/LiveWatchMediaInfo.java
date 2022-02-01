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
    return "LiveWatchMediaInfo{mVideoStatus=" + this.mVideoStatus + ", mRtmp_url='" + this.mRtmp_url + '\'' + ", mHLS_url='" + this.mHLS_url + '\'' + ", mFlv_url='" + this.mFlv_url + '\'' + ", forceSwitch=" + this.forceSwitch + ", mUrl='" + this.mUrl + '\'' + ", mLevel=" + this.mLevel + ", mUrlHigh='" + this.mUrlHigh + '\'' + ", mUrlLow='" + this.mUrlLow + '\'' + ", mRtmpType=" + this.mRtmpType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo
 * JD-Core Version:    0.7.0.1
 */