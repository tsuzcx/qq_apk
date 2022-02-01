package com.tencent.image;

import android.graphics.drawable.ColorDrawable;
import java.util.Arrays;

public class QQLiveDrawable$QQLiveDrawableParams
{
  public static final int DATA_SOURCE_TYPE_FILE = 3;
  public static final int DATA_SOURCE_TYPE_THIRD = 2;
  public static final int DATA_SOURCE_TYPE_URL = 1;
  public static final int DATA_SOURCE_TYPE_URL_LIST = 4;
  public static final int DATA_SOURCE_TYPE_VID = 0;
  public static final ColorDrawable DEFAULT_LOADING_DRAWABLE = new ColorDrawable(-2236446);
  public static final boolean DEFAULT_MUTE_VALUE = true;
  public static final int PLAY_TYPE_LOCAL_FILE = 2;
  public static final int PLAY_TYPE_ONLINE_LIVE = 1;
  public static final int PLAY_TYPE_ONLINE_VOD = 0;
  public static final int PLAY_TYPE_THIRD = 3;
  public int mCoverHeight = 0;
  public ColorDrawable mCoverLoadingDrawable = DEFAULT_LOADING_DRAWABLE;
  public String mCoverUrl;
  public int mCoverWidth = 0;
  public String mDataSource;
  public volatile AbsThirdDataSourceAdapter mDataSourceAdapter;
  public int mDataSourceType;
  public QQLiveDrawable.OnDownloadListener mDownloadListener;
  public int mDuraion;
  public QQLiveDrawable.OnStateListener mListener;
  public QQLiveDrawable.OnLoopBackListener mLoopBackListener;
  public boolean mLoopback = true;
  public int mMaxPlayTimeMs;
  public boolean mMute = true;
  public boolean mPlayPause;
  public int mPlayType = 0;
  public int mPreviewHeight;
  public int mPreviewWidth;
  public String mReportTag;
  public String mRequestFormat = "sd";
  public String mSavePath;
  public String mServerType;
  public int mStartPosi = 0;
  public String[] mUrls;
  public String mVid;
  public long mVideoTime;
  public long msgUniseq;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" QQLiveDrawableParams [");
    localStringBuilder.append("\n mMute: ");
    localStringBuilder.append(this.mMute);
    localStringBuilder.append("\n mRequestFormat: ");
    localStringBuilder.append(this.mRequestFormat);
    localStringBuilder.append("\n mPreviewWidth: ");
    localStringBuilder.append(this.mPreviewWidth);
    localStringBuilder.append("\n mPreviewHeight: ");
    localStringBuilder.append(this.mPreviewHeight);
    localStringBuilder.append("\n mStartPosi: ");
    localStringBuilder.append(this.mStartPosi);
    localStringBuilder.append("\n mPlayPause: ");
    localStringBuilder.append(this.mPlayPause);
    localStringBuilder.append("\n mListener: ");
    localStringBuilder.append(this.mListener);
    localStringBuilder.append("\n mDataSourceType: ");
    localStringBuilder.append(this.mDataSourceType);
    localStringBuilder.append("\n mDataSource: ");
    localStringBuilder.append(this.mDataSource);
    localStringBuilder.append("\n mCoverUrl: ");
    localStringBuilder.append(this.mCoverUrl);
    localStringBuilder.append("\n mLoopback: ");
    localStringBuilder.append(this.mLoopback);
    localStringBuilder.append("\n mMaxPlayTimeMs: ");
    localStringBuilder.append(this.mMaxPlayTimeMs);
    localStringBuilder.append("\n mPlayType: ");
    localStringBuilder.append(this.mPlayType);
    localStringBuilder.append("\n mUrls: ");
    localStringBuilder.append(Arrays.toString(this.mUrls));
    localStringBuilder.append("\n mServerType: ");
    localStringBuilder.append(this.mServerType);
    localStringBuilder.append("\n mSavePath: ");
    localStringBuilder.append(this.mSavePath);
    localStringBuilder.append("\n mVid: ");
    localStringBuilder.append(this.mVid);
    localStringBuilder.append("\n mDuraion: ");
    localStringBuilder.append(this.mDuraion);
    localStringBuilder.append("\n mVideoTime: ");
    localStringBuilder.append(this.mVideoTime);
    localStringBuilder.append("\n msgUniseq: ");
    localStringBuilder.append(this.msgUniseq);
    localStringBuilder.append("\n OnDownloadListener: ");
    localStringBuilder.append(this.mDownloadListener);
    localStringBuilder.append("\n OnLoopBackListener: ");
    localStringBuilder.append(this.mLoopBackListener);
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable.QQLiveDrawableParams
 * JD-Core Version:    0.7.0.1
 */