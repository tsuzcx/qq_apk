package com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
@TargetApi(11)
@RoutePage(desc="视频全屏播放界面", path="/business/shortvideoplay")
public class ShortVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack, DragView.OnGestureChangeListener
{
  private static final int MAX_PROGRESS = 10000;
  public static final int MSG_TYPE_MOBILE_2_WIFE = 5;
  public static final int MSG_TYPE_WIFI_2_MOBILE = 4;
  static final int OPERATOR_BAR_HIDE_DELAY = 2500;
  public static final int PLAY_STATE_BUFFERING = 4;
  public static final int PLAY_STATE_ERROR = 3;
  public static final int PLAY_STATE_IDLE = 0;
  public static final int PLAY_STATE_PAUSE = 2;
  public static final int PLAY_STATE_PLAYING = 1;
  static final int PROGRESS_REFRESH_INTERNAL = 50;
  private static final int REQUEST_TO_QZONE = 10001;
  public static final int SDK_INSTALL_FAILED = 3000;
  static final String STATE_PLAY_POSITION = "state_play_position";
  public static final String TAG = "ShortVideoPlayActivity";
  public static final String TAG2 = "ShortVideoPlayerInner";
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  static String mCfgString = SharedPreUtils.f(BaseApplication.getContext());
  static String[] mListString;
  String ad_gdt = "";
  boolean hasSeeked = false;
  private boolean hasUserSeeked = false;
  boolean isFromMultiMsg;
  private long mBufferCost;
  private RelativeLayout mBufferLayout;
  private long mBufferStart;
  private int mBufferTimes;
  Bundle mBundle;
  private int mCacheProgress;
  ImageView mCloseBtn;
  private boolean mCompleted = false;
  private String mContentType;
  Context mContext;
  URLImageView mCoverIV;
  private long mCurPlayPosition;
  public int mCurSessionType = -1;
  public String mCurSessionUin = "0";
  long mCurrentPosition;
  String mCurrentUin;
  private int mDataFromCacheSize;
  String mDomain;
  DragView mDragView;
  long mDuration = -1L;
  String mDurationStr;
  private int mErrCode = 0;
  public FavoriteActionSheet mFavActionSheet;
  long mFavGroupId;
  long mFavId;
  long mFileSize;
  int mFileType;
  final WeakReference<MqqHandler> mHandler;
  boolean mHidden;
  private String mHotVideoCertificatedIconUrl;
  private String mHotVideoIconUrl;
  private String mHotVideoJumpUrl;
  private String mHotVideoTitle;
  private int mHttpConnectCost;
  private long mHttpCost;
  private int mHttpDNSCost;
  private int mHttpDownloadCount;
  private int mHttpDownloadSum;
  private int mHttpFirstRecvCost;
  private int mHttpRedirectCostMs;
  private int mHttpRedirectNum;
  private long mHttpStart;
  private int mHttpStatus;
  private String mHttpUrl;
  boolean mInterrupted = false;
  private boolean mIsHotVideo = false;
  boolean mIsSDKInit = false;
  private boolean mIsUpdateSDK = false;
  boolean mIsUploading = false;
  TextView mLoadingText;
  String mMd5;
  WeakReference<TVK_IMediaPlayer> mMediaPlayer;
  protected ImageView mMenuBtn;
  private long mMessageClickCost;
  private long mMessageClickStart;
  MessageForShortVideo mMsg;
  boolean mNeedDownload = false;
  private boolean mNeedDownloadReport = true;
  boolean mNeedHideTitleBar;
  boolean mNeedPlay = false;
  private boolean mNeedReportAioVideo = true;
  boolean mNeedReportProgressive;
  private boolean mNeedUpdateMsg = true;
  int mNewSeekTimes;
  LinearLayout mNormalOperateLayout;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
  private long mOpenPlayerCost;
  private long mOpenPlayerStart;
  View mOperatorBar;
  ImageView mOperatorBtn;
  private int mPauseTimes;
  int mPlayCallerType = 0;
  private long mPlayCost;
  boolean mPlayFailReported = false;
  private int mPlayProgress;
  int mPlayReadyTime;
  int mPlayResult = 1;
  private long mPlayStart;
  int mPlayState = 0;
  boolean mPlaySucReported = false;
  long mPlayTimeCost = -1L;
  boolean mPlayTimeCostReported = false;
  private boolean mPlayWithDownload;
  final Runnable mProgressChecker;
  TextView mProgressTime;
  private TextView mRateText;
  private int mRealPlayTimes;
  BroadcastReceiver mReceiver;
  private int mReplayTimes;
  TextView mReturnBtn;
  RelativeLayout mRoot;
  private int mScreenDisplayHeight;
  private int mScreenDisplayWidth;
  private int mSdkDetailErrorCode;
  private int mSdkErrorCode;
  long mSec;
  SeekBar mSeekBar;
  int mSeekTimes;
  private int mSpeedKBS;
  final Runnable mStartHidingRunnable;
  long mStartPlayTime = -1L;
  private int mStatus = -1;
  private long mStepUrlCost;
  private boolean mSurfaceViewDestroyed = false;
  private long mTCOfMCFirstFrame;
  Bitmap mThumbBitmap;
  String mThumbMd5;
  RelativeLayout mTitleBar;
  TextView mTotalTime;
  long mTransferredSize;
  int mUinType;
  private long mUpdateSDKCost;
  private boolean mUpdateSDKResult = false;
  private long mUpdateSDKStart;
  RelativeLayout mUploadOperateLayout;
  TextView mUploadProgress;
  SeekBar mUploadingSeekBar;
  private boolean mUserDragging = false;
  private String mUserReturnCode;
  private String mUuid;
  ValueAnimator mValueAnimator = null;
  RelativeLayout mVideoController;
  String mVideoInfo;
  RelativeLayout mVideoLayout;
  String mVideoPath;
  TVK_IProxyFactory mVideoProxyFactory;
  String[] mVideoUrls;
  View mVideoView;
  private String mXRtFlag;
  String msg_id = "";
  Rect originRect;
  private long playDurationForReport = 0L;
  String publicAccountLocalPath;
  boolean seekFlagForCacheProgress;
  int sourceEntrance = -1;
  LinearLayout top_blackLH;
  
  static
  {
    String str = mCfgString;
    if ((str != null) && (str.length() > 0)) {
      mListString = mCfgString.split("\\|");
    }
  }
  
  public ShortVideoPlayActivity()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.mValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.mValueAnimator.setDuration(2500L);
      this.mValueAnimator.addUpdateListener(new ShortVideoPlayActivity.1(this));
    }
    this.mHandler = new WeakReference(new ShortVideoPlayActivity.2(this));
    this.mProgressChecker = new ShortVideoPlayActivity.5(this);
    this.mStartHidingRunnable = new ShortVideoPlayActivity.6(this);
    this.mHidden = true;
    this.mReceiver = new ShortVideoPlayActivity.7(this);
    this.mOnSeekBarChangeListener = new ShortVideoPlayActivity.21(this);
  }
  
  private boolean checkHaveSdCard(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    int i;
    if ((localFile.exists()) && (localFile.canWrite())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QQToast.a(paramContext, 1, 2131718574, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    return true;
  }
  
  private ShortVideoDownloadInfo creatDownloadInfo()
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.mVideoInfo);
      localShortVideoDownloadInfo.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
      localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
      String str = localJSONObject.getString("file_md5");
      localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString = str;
      this.mMd5 = str;
      localShortVideoDownloadInfo.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
      localShortVideoDownloadInfo.jdField_b_of_type_Int = this.mCurSessionType;
      localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.mCurrentUin;
      localShortVideoDownloadInfo.c = this.mCurSessionUin;
      localShortVideoDownloadInfo.d = this.mCurSessionUin;
      localShortVideoDownloadInfo.jdField_e_of_type_Int = 1001;
      this.mFileType = 1001;
      localShortVideoDownloadInfo.h = getPubAccountLocalPath(localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
      return localShortVideoDownloadInfo;
    }
    catch (Exception localException)
    {
      label132:
      break label132;
    }
    return null;
  }
  
  private void createActionSheet()
  {
    if (this.mPlayCallerType != 3) {
      return;
    }
    this.mFavActionSheet = new ShortVideoPlayActivity.29(this, this, new ShortVideoPlayActivity.28(this), getActionTypes(), 5, this.app);
  }
  
  private void forwardToQzone()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishMood(getActivity(), localUserInfo, this.mVideoPath, 10001);
    ReportController.b(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
  }
  
  private int getActionTypes()
  {
    int i;
    if (this.mFavId != -1L) {
      i = 16456;
    } else {
      i = 16392;
    }
    return i | 0x200;
  }
  
  private String getFileSizeString(long paramLong)
  {
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    if (paramLong < 1048576L)
    {
      f = (float)paramLong / 1024.0F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(f) }));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    float f = (float)paramLong / 1048576.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(f) }));
    localStringBuilder.append("M");
    return localStringBuilder.toString();
  }
  
  private void getHttpHeaderInfo(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return;
    }
    paramString = paramString.split("\r\n");
    if (paramString == null) {
      return;
    }
    int j = 0;
    this.mHttpStatus = getHttpResponseCode(paramString[0]);
    int k = 1;
    int i = 1;
    Object localObject1;
    while (i < paramString.length)
    {
      localObject1 = paramString[i];
      if (((String)localObject1).startsWith("User-ReturnCode")) {
        this.mUserReturnCode = getHttpValue((String)localObject1);
      } else if (((String)localObject1).startsWith("X-RtFlag")) {
        this.mXRtFlag = getHttpValue((String)localObject1);
      } else if (((String)localObject1).startsWith("Content-Type")) {
        this.mContentType = getHttpValue((String)localObject1);
      }
      i += 1;
    }
    paramString = mListString;
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = this.mContentType;
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = mListString;
        if ((paramString.length == 1) && (paramString[0] != null) && (paramString[0].toLowerCase().equals("allin")))
        {
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoPlayActivity", 2, "check content all in");
            i = k;
          }
        }
        else
        {
          paramString = mListString;
          int m = paramString.length;
          i = 0;
          while (i < m)
          {
            localObject1 = paramString[i];
            if ((localObject1 != null) && (this.mContentType.contains((CharSequence)localObject1)))
            {
              i = k;
              break label263;
            }
            i += 1;
          }
          i = 0;
        }
        label263:
        if (i == 0)
        {
          paramString = new StringBuilder();
          localObject1 = mListString;
          k = localObject1.length;
          i = j;
          while (i < k)
          {
            localObject2 = localObject1[i];
            if (localObject2 != null)
            {
              paramString.append((String)localObject2);
              paramString.append("|");
            }
            i += 1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("not accept content type: real:");
          ((StringBuilder)localObject1).append(this.mContentType);
          ((StringBuilder)localObject1).append(". whiteList_type :");
          ((StringBuilder)localObject1).append(paramString.toString());
          localObject1 = ((StringBuilder)localObject1).toString();
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, (String)localObject1);
          }
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
          ((HashMap)localObject2).put("Content-Type", this.mContentType);
          ((HashMap)localObject2).put("White-List", paramString.toString());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
          throw new IOException((String)localObject1);
        }
      }
    }
  }
  
  private int getHttpResponseCode(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      int i = paramString.indexOf(' ');
      if (i >= 0)
      {
        i += 1;
        if (i < paramString.length())
        {
          paramString = paramString.substring(i);
          if (paramString != null)
          {
            paramString = paramString.trim();
            paramString = paramString.substring(0, paramString.indexOf(' '));
            try
            {
              i = Integer.parseInt(paramString);
              return i;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
    }
    return -1;
  }
  
  private String getHttpValue(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf(':');
      if (i >= 0)
      {
        i += 1;
        if (i < paramString.length())
        {
          paramString = paramString.substring(i);
          if (paramString != null) {
            return paramString.trim();
          }
        }
      }
    }
    return null;
  }
  
  private String getPubAccountLocalPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("publicaccount");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mCurrentUin);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    localStringBuilder.append("mp4");
    return localStringBuilder.toString();
  }
  
  private void initVideoData()
  {
    Object localObject;
    if (this.mIsUploading)
    {
      localObject = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(this.mMsg.frienduin, this.mMsg.uniseq);
      if ((localObject instanceof IShortVideoUploadProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        updateUploadInfo(((BaseTransProcessor)localObject).getTransferedSize(), ((BaseTransProcessor)localObject).getFileSize());
      }
      localObject = FileTransferManager.a(this.app);
      if (localObject != null) {
        ((FileTransferManager)localObject).a(this.mRoot, this);
      }
      this.mVideoPath = SVUtils.a(this.mMsg, "mp4");
      if (new File(this.mVideoPath).exists())
      {
        long l = this.mMsg.videoFileSize;
        this.mFileSize = l;
        this.mTransferredSize = l;
        this.mCacheProgress = 10000;
      }
      else
      {
        showErrorDlg(HardCodeUtil.a(2131713957));
      }
      play(this.mCurrentPosition);
      return;
    }
    showAnimation();
    int i = this.mPlayCallerType;
    if ((i != 1) && (i != 2) && (i != 4) && (this.mUinType != 9501) && (i != 6))
    {
      if ((i == 0) || (i == 5))
      {
        if (this.mMsg.getBitValue(1) == 0)
        {
          this.mMsg.setBitValue(1, (byte)1);
          ThreadManager.getFileThreadHandler().post(new ShortVideoPlayActivity.15(this));
        }
        this.mVideoPath = SVUtils.a(this.mMsg, "mp4");
        localObject = new File(this.mVideoPath);
        if (((File)localObject).exists())
        {
          this.mTransferredSize = ((File)localObject).length();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=");
            ((StringBuilder)localObject).append(this.mTransferredSize);
            ((StringBuilder)localObject).append(" msg.size=");
            ((StringBuilder)localObject).append(this.mMsg.videoFileSize);
            ((StringBuilder)localObject).append(" status=");
            ((StringBuilder)localObject).append(this.mMsg.videoFileStatus);
            QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
          }
          this.mFileSize = this.mMsg.videoFileSize;
          this.mCacheProgress = 10000;
          this.mSeekBar.setSecondaryProgress(10000);
          this.mNeedReportProgressive = false;
          if (this.mTransferredSize < this.mFileSize) {
            this.mNeedDownload = true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
          }
          this.mNeedDownload = true;
        }
        if (this.mNeedDownload)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
          }
          if (checkHaveSdCard(this.mContext))
          {
            localObject = SVBusiUtil.a(this.app, this.mMsg, 1);
            if (localObject != null)
            {
              ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
              this.mFileType = ((ShortVideoReq)localObject).a.jdField_e_of_type_Int;
              reportDownloadVideo(this.mMsg);
            }
          }
          localObject = FileTransferManager.a(this.app);
          if (localObject != null) {
            ((FileTransferManager)localObject).a(this.mRoot, this);
          }
          this.mFileSize = this.mMsg.videoFileSize;
          this.mCacheProgress = ((int)(this.mTransferredSize * 10000L / this.mFileSize));
          this.mPlayProgress = 0;
          this.mCurPlayPosition = 0L;
          this.mNeedReportProgressive = true;
          this.mSeekBar.setSecondaryProgress(this.mCacheProgress);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onCreateVideoSdkView() mCacheProgress=");
            ((StringBuilder)localObject).append(this.mCacheProgress);
            ((StringBuilder)localObject).append(",mTransferredSize=");
            ((StringBuilder)localObject).append(this.mTransferredSize);
            QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
          }
        }
        if (this.mPlayCallerType == 5) {
          this.mMenuBtn.setVisibility(8);
        }
      }
    }
    else
    {
      this.mMenuBtn.setVisibility(8);
      if (this.mPlayCallerType == 2)
      {
        localObject = this.mVideoInfo;
        if (localObject == null) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.mFileType = 1001;
      this.mVideoPath = getPubAccountLocalPath(((JSONObject)localObject).getString("file_md5"));
      this.mFileSize = ((JSONObject)localObject).getInt("file_size");
      this.mUuid = ((JSONObject)localObject).getString("file_uuid");
      label799:
      localObject = new File(this.mVideoPath);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.mTransferredSize = ((File)localObject).length();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=");
          ((StringBuilder)localObject).append(this.mTransferredSize);
          ((StringBuilder)localObject).append(" msg.size=");
          ((StringBuilder)localObject).append(this.mFileSize);
          QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (this.mTransferredSize < this.mFileSize) {
          this.mNeedDownload = true;
        }
      }
      else
      {
        this.mNeedDownload = true;
      }
      if (this.mNeedDownload)
      {
        startDownLoadVideoForPubAccount();
        localObject = FileTransferManager.a(this.app);
        if (localObject != null) {
          ((FileTransferManager)localObject).a(this.mRoot, this);
        }
        this.mSeekBar.setSecondaryProgress(this.mCacheProgress);
      }
      boolean bool = this.mNeedDownload;
      this.mPlayWithDownload = bool;
      if (!bool)
      {
        play(this.mCurrentPosition);
        return;
      }
      dismissLoadingView();
      changePlayState(4);
      return;
    }
    catch (Exception localException)
    {
      break label799;
    }
  }
  
  private void installSDK()
  {
    this.mUpdateSDKStart = System.currentTimeMillis();
    this.mIsUpdateSDK = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new ShortVideoPlayActivity.13(this));
  }
  
  private void moveToGroup()
  {
    QfavHelper.a(this.mContext, this.app.getCurrentUin(), this.mFavId, this.mFavGroupId);
  }
  
  private void openWithOtherApp()
  {
    String str = getVideoPath();
    if (!isVideoExist(str))
    {
      QQToast.a(this.mContext, 0, 2131719067, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(str);
    localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "video/*");
    startActivity(localIntent);
    int i = this.mUinType;
    if (i == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.mPlaySucReported = true;
      return;
    }
    if (i == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.mPlaySucReported = true;
      return;
    }
    if (i == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.mPlaySucReported = true;
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.mPlaySucReported = true;
  }
  
  private void remindIfContinueDownload()
  {
    boolean bool = this.mNeedDownload;
    if ((SVBusiUtil.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - SVBusiUtil.jdField_a_of_type_Long < 300000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
      }
      bool = false;
    }
    if (bool)
    {
      Object localObject = this.mContext.getString(2131719087);
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.mContext, 230, null, (String)localObject, 2131694460, 2131720490, new ShortVideoPlayActivity.3(this), new ShortVideoPlayActivity.4(this));
      localObject = CUOpenCardGuideMng.a(this.mContext, this.app, 1, (String)localObject);
      if ((localObject instanceof SpannableString)) {
        localQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject);
      }
      pause();
      this.mNeedPlay = false;
      showDialogSafe(localQQCustomDialog);
    }
  }
  
  private void reportDownloadResult(boolean paramBoolean)
  {
    if (!this.mNeedDownloadReport) {
      return;
    }
    if (!this.mPlayWithDownload) {
      return;
    }
    if (this.mErrCode == 0) {
      paramBoolean = true;
    }
    if (this.mMsg == null) {
      return;
    }
    this.mNeedDownloadReport = false;
    HashMap localHashMap = new HashMap();
    int i = this.mFileType;
    if (i == 6) {}
    while ((i != 9) && (i != 17))
    {
      str = "actShortVideoDownloadVideo";
      break;
    }
    localHashMap.put("param_grpUin", this.mCurSessionUin);
    String str = "actShortVideoDiscussgroupDownloadVideo";
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportTag = ");
      localStringBuilder.append(str);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    localHashMap.put("param_uuid", this.mUuid);
    localHashMap.put("param_picSize", String.valueOf(this.mFileSize));
    localHashMap.put("param_fileMd5", this.mMd5);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPlayCallerType);
    localStringBuilder.append("");
    localHashMap.put("param_busiType", localStringBuilder.toString());
    localHashMap.put("param_videoDuration", String.valueOf(this.mMsg.videoFileTime));
    if (paramBoolean)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, this.mHttpCost, this.mFileSize, localHashMap, "");
      return;
    }
    if (this.mErrCode != -9527) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.mErrCode));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, false, this.mHttpCost, 0L, localHashMap, "");
  }
  
  private void saveToPhone()
  {
    String str = getVideoPath();
    if (!isVideoExist(str))
    {
      QQToast.a(this.mContext, 0, 2131719067, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (this.mHandler.get() != null)
    {
      MqqHandler localMqqHandler1 = ThreadManager.getFileThreadHandler();
      MqqHandler localMqqHandler2 = (MqqHandler)this.mHandler.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMd5);
      localStringBuilder.append(".mp4");
      localMqqHandler1.post(new ShortVideoUtils.VideoFileSaveRunnable(str, localMqqHandler2, localStringBuilder.toString(), false));
    }
    int i = this.mUinType;
    if (i == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
      this.mPlaySucReported = true;
    }
    else if (i == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
      this.mPlaySucReported = true;
    }
    else if (i == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
      this.mPlaySucReported = true;
    }
    else
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
      this.mPlaySucReported = true;
    }
    new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, this.mCurSessionType, this.mCurSessionUin);
    if (this.isFromMultiMsg) {
      MultiMsgUtil.a("0X8009ABD");
    }
  }
  
  private void setSystemUiVisibility()
  {
    if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
    {
      RelativeLayout localRelativeLayout = this.mRoot;
      if (localRelativeLayout != null) {
        localRelativeLayout.setSystemUiVisibility(1284);
      }
    }
  }
  
  private void showDialogSafe(Dialog paramDialog)
  {
    if ((BaseActivity.mAppForground) && (!isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void startDownLoadVideoForPubAccount()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownLoadVideoForPubAccount: ");
      ((StringBuilder)localObject).append(this.mVideoInfo);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QQToast.a(this.mContext, 1, 2131718574, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    localObject = SVBusiUtil.a(2, 0);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = creatDownloadInfo();
    if ((!AppNetConnInfo.isWifiConn()) && (localShortVideoDownloadInfo != null) && (localShortVideoDownloadInfo.jdField_b_of_type_Long > 204800L)) {
      showDialogSafe(DialogUtil.a(this, 230, getString(2131719088), getString(2131719089), new ShortVideoPlayActivity.16(this), new ShortVideoPlayActivity.17(this)));
    }
    if (localShortVideoDownloadInfo != null)
    {
      localShortVideoDownloadInfo.jdField_b_of_type_Boolean = true;
      ((ShortVideoReq)localObject).a = localShortVideoDownloadInfo;
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
      this.publicAccountLocalPath = localShortVideoDownloadInfo.h;
    }
  }
  
  private void switchToNormalPlayUI()
  {
    RelativeLayout localRelativeLayout = this.mUploadOperateLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
    this.mNormalOperateLayout.setVisibility(0);
  }
  
  private void updateMsgStatus()
  {
    Object localObject = this.mMsg;
    if ((localObject != null) && (this.mStatus != -1))
    {
      if (((MessageForShortVideo)localObject).videoFileStatus == 2003) {
        return;
      }
      if (!this.mNeedUpdateMsg) {
        return;
      }
      this.mNeedUpdateMsg = false;
      long l = this.mFileSize;
      int i;
      if (l == 0L) {
        i = 0;
      } else {
        i = (int)(this.mTransferredSize * 100L / l);
      }
      if (this.mMsg.videoFileProgress < 0) {
        this.mMsg.videoFileProgress = 0;
      }
      int j = this.mMsg.videoFileProgress;
      if (((this.mMsg.videoFileStatus == 1002) || (this.mMsg.videoFileStatus == 2002)) && (this.mMsg.videoFileStatus == this.mStatus) && (i - j < 10)) {
        return;
      }
      int k = this.mFileType;
      if ((k != 6) && (k != 17) && (k != 9))
      {
        j = i;
        if (k != 20) {}
      }
      else
      {
        if (this.mStatus == 2002) {
          this.mMsg.transferedSize = ((int)this.mTransferredSize);
        }
        j = i;
        if (this.mStatus == 2003)
        {
          this.mMsg.transferedSize = 0;
          j = 100;
        }
      }
      if ((this.mMsg.videoFileStatus == 2004) || (this.mMsg.videoFileStatus == 1004))
      {
        i = this.mStatus;
        if (i == 1002) {
          return;
        }
        if (i == 2002) {
          return;
        }
      }
      localObject = this.mMsg;
      ((MessageForShortVideo)localObject).videoFileStatus = this.mStatus;
      ((MessageForShortVideo)localObject).fileType = this.mFileType;
      ((MessageForShortVideo)localObject).videoFileProgress = j;
      if ((((MessageForShortVideo)localObject).mPreUpload) && (this.mStatus == 1003))
      {
        localObject = this.mMd5;
        if (localObject != null) {
          this.mMsg.md5 = ((String)localObject);
        }
      }
      if ((this.mStatus == 2003) && (!StringUtil.a(this.mVideoPath)))
      {
        localObject = new File(this.mVideoPath);
        this.mMsg.lastModified = ((File)localObject).lastModified();
      }
      this.mMsg.serial();
      this.app.getMessageFacade().a(this.mMsg.frienduin, this.mUinType, this.mMsg.uniseq, this.mMsg.msgData);
    }
  }
  
  private void updateUploadInfo(long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 != 0L) {
      i = (int)(100L * paramLong1 / paramLong2);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUploadInfo ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mUploadProgress;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getFileSizeString(paramLong1));
      localStringBuilder.append("/");
      localStringBuilder.append(getFileSizeString(paramLong2));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    localObject = this.mUploadingSeekBar;
    if (localObject != null) {
      ((SeekBar)localObject).setProgress(i);
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.getInt("callBackType");
      j = paramString.getInt("fileSize");
      long l1 = j;
      long l2 = this.mFileSize;
      if (l1 != l2)
      {
        this.mFileSize = l1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=");
        ((StringBuilder)localObject).append(this.mFileSize);
        QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
      }
      k = paramString.getInt("newFileSize");
      l1 = paramString.getInt("offset");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnDownloadCallback, offset = ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", seekFlagForCacheProgress = ");
        ((StringBuilder)localObject).append(this.seekFlagForCacheProgress);
        QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (l1 > 0L) {
        if (this.seekFlagForCacheProgress)
        {
          this.mTransferredSize = l1;
          this.seekFlagForCacheProgress = false;
        }
        else if (l1 > this.mTransferredSize)
        {
          this.mTransferredSize = l1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnDownloadCallback, mTransferredSize = ");
        ((StringBuilder)localObject).append(this.mTransferredSize);
        QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
      }
      m = paramString.getInt("httpDownloadSum");
      this.mHttpDownloadSum = m;
      if (m > 0) {
        this.mHttpDownloadCount += 1;
      }
      n = paramString.getInt("dataFromCacheSize");
      if (this.mDataFromCacheSize < n) {
        this.mDataFromCacheSize = n;
      }
      this.mSpeedKBS = paramString.getInt("speedKBS");
      if ((i != 7) && (i != 3))
      {
        if ((i != 1) || (!paramString.has("httpHeader"))) {
          break label1004;
        }
        localObject = paramString.getString("httpHeader");
      }
    }
    catch (JSONException paramString)
    {
      int i;
      int j;
      Object localObject;
      int k;
      int m;
      int n;
      label370:
      paramString.printStackTrace();
    }
    try
    {
      getHttpHeaderInfo((String)localObject);
    }
    catch (IOException localIOException)
    {
      break label370;
    }
    this.mErrCode = 9064;
    this.mStatus = 2005;
    updateMsgStatus();
    showErrorDlg(HardCodeUtil.a(2131713941));
    if ((!TextUtils.isEmpty(this.mUserReturnCode)) && (this.mUserReturnCode.equals("-5103059")))
    {
      this.mStatus = 5002;
      updateMsgStatus();
      showErrorDlg(HardCodeUtil.a(2131713936));
      break label1004;
      if (i != 7) {
        break label1007;
      }
      this.mNeedDownload = false;
      this.mTransferredSize = this.mFileSize;
      this.mStatus = 2003;
      updateMsgStatus();
    }
    label1004:
    label1007:
    for (;;)
    {
      if (this.mHttpStart != 0L)
      {
        this.mHttpCost = (System.currentTimeMillis() - this.mHttpStart);
        this.mHttpStart = 0L;
      }
      for (;;)
      {
        if (this.mHttpRedirectNum == 0) {
          this.mHttpRedirectNum = paramString.getInt("httpRedirectNum");
        }
        if (this.mHttpRedirectCostMs == 0) {
          this.mHttpRedirectCostMs = paramString.getInt("httpRedirectCostMs");
        }
        if ((paramString.has("httpDNSCostMs")) && (this.mHttpDNSCost == 0)) {
          this.mHttpDNSCost = paramString.getInt("httpDNSCostMs");
        }
        if ((paramString.has("httpConnectCostMs")) && (this.mHttpConnectCost == 0)) {
          this.mHttpConnectCost = paramString.getInt("httpConnectCostMs");
        }
        if ((paramString.has("httpFirstRecvCostMs")) && (this.mHttpFirstRecvCost == 0)) {
          this.mHttpFirstRecvCost = paramString.getInt("httpFirstRecvCostMs");
        }
        if ((paramString.has("httpURL")) && (this.mHttpUrl == null)) {
          this.mHttpUrl = paramString.getString("httpURL");
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder("[MediaPlayer] OnDownloadCallback:");
          paramString.append("callBackType=");
          paramString.append(i);
          paramString.append("|");
          paramString.append("fileSize=");
          paramString.append(j);
          paramString.append("|");
          paramString.append("newFileSize=");
          paramString.append(k);
          paramString.append("|");
          paramString.append("offset=");
          paramString.append(this.mTransferredSize);
          paramString.append("|");
          paramString.append("httpDownloadSum=");
          paramString.append(m);
          paramString.append("|");
          paramString.append("dataFromCacheSize=");
          paramString.append(n);
          paramString.append("|");
          paramString.append("speedKBS=");
          paramString.append(this.mSpeedKBS);
          paramString.append("|");
          paramString.append("HttpRedirectNum=");
          paramString.append(this.mHttpRedirectNum);
          paramString.append("|");
          paramString.append("HttpRedirectCostMs=");
          paramString.append(this.mHttpRedirectCostMs);
          paramString.append("|");
          paramString.append("HttpDNSCost=");
          paramString.append(this.mHttpDNSCost);
          paramString.append("|");
          paramString.append("HttpConnectCost=");
          paramString.append(this.mHttpConnectCost);
          paramString.append("|");
          paramString.append("HttpFirstRecvCost=");
          paramString.append(this.mHttpFirstRecvCost);
          paramString.append("|");
          paramString.append("mHttpUrl=");
          paramString.append(this.mHttpUrl);
          paramString.append("|");
          QLog.i("ShortVideoPlayActivity", 2, paramString.toString());
          return;
        }
        return;
      }
    }
  }
  
  public void adMsgVideoReport(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      paramString1 = str;
      if (!localJSONObject.has("ad_id")) {
        break label69;
      }
      paramString1 = localJSONObject.getString("ad_id");
    }
    catch (Exception paramString1)
    {
      label48:
      break label48;
    }
    paramString1 = str;
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoPlayActivity", 2, "parse ad_id error");
      paramString1 = str;
    }
    label69:
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
    return;
  }
  
  void changePlayState(int paramInt)
  {
    runOnUiThread(new ShortVideoPlayActivity.19(this, paramInt));
  }
  
  void delayStartHiding()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    if (this.mHandler.get() != null)
    {
      ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mStartHidingRunnable);
      if (this.mPlayState == 1)
      {
        WeakReference localWeakReference = this.mMediaPlayer;
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying())) {
          ((MqqHandler)this.mHandler.get()).postDelayed(this.mStartHidingRunnable, 2500L);
        }
      }
    }
  }
  
  void dismissLoadingImage()
  {
    URLImageView localURLImageView = this.mCoverIV;
    if ((localURLImageView != null) && (localURLImageView.getVisibility() == 0)) {
      this.mCoverIV.setVisibility(8);
    }
  }
  
  void dismissLoadingView()
  {
    TextView localTextView = this.mLoadingText;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.mLoadingText.setVisibility(8);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doNewReport()
  {
    if (!this.mNeedReportAioVideo) {
      return;
    }
    if (this.mMsg == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.mNeedDownload) {
      i = 1;
    } else {
      i = 2;
    }
    if (this.mPlayResult == 0) {
      i = 3;
    }
    localHashMap.put("player_state", String.valueOf(i));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" player_state ");
    ((StringBuilder)localObject1).append(i);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("Download", String.valueOf(this.mPlayWithDownload));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" Download");
    ((StringBuilder)localObject1).append(this.mPlayWithDownload);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("FileSize", String.valueOf(this.mFileSize));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" FileSize");
    ((StringBuilder)localObject1).append(this.mFileSize);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpDownloadSum", String.valueOf(this.mHttpDownloadSum));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpDownloadSum");
    ((StringBuilder)localObject1).append(this.mHttpDownloadSum);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    if (!this.mPlayWithDownload)
    {
      localHashMap.put("DataFromCacheSize", String.valueOf(this.mFileSize));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" DataFromCacheSize");
      ((StringBuilder)localObject1).append(this.mFileSize);
      localStringBuffer.append(((StringBuilder)localObject1).toString());
    }
    else
    {
      localHashMap.put("DataFromCacheSize", String.valueOf(this.mDataFromCacheSize));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" DataFromCacheSize");
      ((StringBuilder)localObject1).append(this.mDataFromCacheSize);
      localStringBuffer.append(((StringBuilder)localObject1).toString());
    }
    localHashMap.put("FileDuration", String.valueOf(this.mDuration));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" FileDuration");
    ((StringBuilder)localObject1).append(this.mDuration);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("PlayTime", String.valueOf(this.mPlayCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" PlayTime");
    ((StringBuilder)localObject1).append(this.mPlayCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("PlayStateCount", String.valueOf(this.mRealPlayTimes));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" PlayStateCount");
    ((StringBuilder)localObject1).append(this.mRealPlayTimes);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("PlayProgress", String.valueOf(this.mPlayProgress / 100));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" PlayProgress");
    ((StringBuilder)localObject1).append(this.mPlayProgress / 100);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("FirstPlayTime", String.valueOf(this.mMessageClickCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" FirstPlayTime");
    ((StringBuilder)localObject1).append(this.mMessageClickCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("FirstBufferTime", String.valueOf(this.mOpenPlayerCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" FirstBufferTime");
    ((StringBuilder)localObject1).append(this.mOpenPlayerCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("SeekTimes", String.valueOf(this.mNewSeekTimes));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" SeekTimes");
    ((StringBuilder)localObject1).append(this.mNewSeekTimes);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    int i = this.mBufferTimes;
    if (i != 0) {
      i -= 1;
    }
    localHashMap.put("BufferTimes", String.valueOf(i));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" BufferTimes");
    ((StringBuilder)localObject1).append(i);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("BufferCostTime", String.valueOf(this.mBufferCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" BufferCostTime");
    ((StringBuilder)localObject1).append(this.mBufferCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    if (this.mHttpStart != 0L)
    {
      this.mHttpCost = (System.currentTimeMillis() - this.mHttpStart);
      this.mHttpStart = 0L;
    }
    i = this.mHttpDownloadCount;
    if (i != 0) {
      i = this.mHttpDownloadSum / (i * 1000);
    } else {
      i = 0;
    }
    localHashMap.put("SpeedKBS", String.valueOf(i));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" SpeedKBS");
    ((StringBuilder)localObject1).append(i);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    i = this.mReplayTimes;
    String str = "1";
    if (i > 0) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localHashMap.put("IsRePlay", localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" IsRePlay");
    ((StringBuilder)localObject1).append(this.mReplayTimes);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("SuspendTimes", String.valueOf(this.mPauseTimes));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" SuspendTimes");
    ((StringBuilder)localObject1).append(this.mPauseTimes);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    i = this.mErrCode;
    boolean bool;
    if (i != 0)
    {
      localHashMap.put("param_FailCode", String.valueOf(i));
      bool = false;
    }
    else
    {
      bool = true;
    }
    localHashMap.put("ErrorCode", String.valueOf(this.mSdkErrorCode));
    localHashMap.put("ErrorDetailCode", String.valueOf(this.mSdkDetailErrorCode));
    localHashMap.put("HttpStatus", String.valueOf(this.mHttpStatus));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpStatus");
    ((StringBuilder)localObject1).append(this.mHttpStatus);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("User-ReturnCode", this.mUserReturnCode);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" User-ReturnCode");
    ((StringBuilder)localObject1).append(this.mUserReturnCode);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("X-RtFlag", this.mXRtFlag);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" X-RtFlag");
    ((StringBuilder)localObject1).append(this.mXRtFlag);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuffer("");
    localObject1 = null;
    if (!StringUtil.a(this.mHttpUrl)) {
      localObject1 = InnerDns.getHostFromUrl(this.mHttpUrl);
    }
    Object localObject3 = this.mVideoUrls;
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      i = 0;
      for (int j = -1;; j = k)
      {
        localObject3 = this.mVideoUrls;
        k = j;
        if (i >= localObject3.length) {
          break;
        }
        localObject3 = InnerDns.getHostFromUrl(localObject3[i]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(",");
        ((StringBuffer)localObject2).append(localStringBuilder.toString());
        k = j;
        if (j == -1)
        {
          k = j;
          if (!StringUtil.a((String)localObject1))
          {
            k = j;
            if (((String)localObject1).equals(localObject3)) {
              k = i;
            }
          }
        }
        i += 1;
      }
    }
    int k = -1;
    localHashMap.put("IpList", ((StringBuffer)localObject2).toString());
    i = k + 1;
    localHashMap.put("SuccIpIndex", String.valueOf(i));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" SuccIpIndex");
    ((StringBuilder)localObject1).append(i);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpDomain", this.mDomain);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpDomain");
    ((StringBuilder)localObject1).append(this.mDomain);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpRedirectNum", String.valueOf(this.mHttpRedirectNum));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpRedirectNum");
    ((StringBuilder)localObject1).append(this.mHttpRedirectNum);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.mHttpRedirectCostMs));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpRedirectCostMs");
    ((StringBuilder)localObject1).append(this.mHttpRedirectCostMs);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.mHttpDNSCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpDnsCostMs");
    ((StringBuilder)localObject1).append(this.mHttpDNSCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.mHttpConnectCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpConnectCostMs");
    ((StringBuilder)localObject1).append(this.mHttpConnectCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.mHttpFirstRecvCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpFirstRecvCostMs");
    ((StringBuilder)localObject1).append(this.mHttpFirstRecvCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.mStepUrlCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" ApplyCostTime");
    ((StringBuilder)localObject1).append(this.mStepUrlCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("HttpCostTime", String.valueOf(this.mHttpCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" HttpCostTime");
    ((StringBuilder)localObject1).append(this.mHttpCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", String.valueOf(this.mPlayCallerType));
    localHashMap.put("SubBusiType", String.valueOf(this.mMsg.subBusiType));
    localHashMap.put("FromUin", String.valueOf(this.mCurrentUin));
    localHashMap.put("GrpUin", String.valueOf(this.mCurSessionUin));
    localHashMap.put("Uuid", String.valueOf(this.mUuid));
    localHashMap.put("MsgFileMd5", String.valueOf(this.mMd5));
    localHashMap.put("DownFileMd5", String.valueOf(this.mMd5));
    localObject1 = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" NetworkInfo");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localHashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
    localHashMap.put("EncryptKey", "0");
    if (this.mIsUpdateSDK) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localHashMap.put("IsUpdateSuit", localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" IsUpdateSuit");
    if (this.mIsUpdateSDK) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localHashMap.put("UpdateSuitCostTime", String.valueOf(this.mUpdateSDKCost));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" UpdateSuitCostTime");
    ((StringBuilder)localObject1).append(this.mUpdateSDKCost);
    localStringBuffer.append(((StringBuilder)localObject1).toString());
    if (this.mUpdateSDKResult) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localHashMap.put("UpdateSuitResult", localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" UpdateSuitResult");
    if (this.mUpdateSDKResult) {
      localObject1 = str;
    } else {
      localObject1 = "0";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actStreamingVideoPlay", bool, this.mHttpCost, this.mFileSize, localHashMap, "");
    this.mNeedReportAioVideo = false;
    this.mRealPlayTimes = 0;
    this.mNewSeekTimes = 0;
    this.mBufferTimes = 0;
    this.mPauseTimes = 0;
    this.mBufferCost = 0L;
    this.mHttpCost = 0L;
    this.mPlayCost = 0L;
    this.mHttpConnectCost = 0;
    this.mHttpDNSCost = 0;
    this.mMessageClickCost = 0L;
    this.mOpenPlayerCost = 0L;
    this.mStepUrlCost = 0L;
    this.mHttpFirstRecvCost = 0;
    this.mHttpRedirectCostMs = 0;
    this.mUpdateSDKCost = 0L;
    this.mSdkErrorCode = 0;
    this.mSdkDetailErrorCode = 0;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001)
    {
      if (paramInt2 != -1) {
        return;
      }
      QQToast.a(this, 2131719081, 0).a();
      return;
    }
    if (paramInt1 == 21)
    {
      if (paramInt2 != -1) {
        return;
      }
      ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    releaseMediaPlayer();
    overridePendingTransition(0, 2130772405);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(this);
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131561482);
    getWindow().addFlags(128);
    this.mScreenDisplayWidth = getResources().getDisplayMetrics().widthPixels;
    this.mScreenDisplayHeight = getResources().getDisplayMetrics().heightPixels;
    this.top_blackLH = ((LinearLayout)findViewById(2131363668));
    Object localObject = this.top_blackLH;
    if (localObject != null)
    {
      localObject = ((LinearLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = LiuHaiUtils.jdField_a_of_type_Int;
      this.top_blackLH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.top_blackLH.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("DeviceInfo:");
      ((StringBuilder)localObject).append("PRODUCT=");
      ((StringBuilder)localObject).append(Build.PRODUCT);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("MODEL=");
      ((StringBuilder)localObject).append(Build.MODEL);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("BOARD=");
      ((StringBuilder)localObject).append(Build.BOARD);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("BOOTLOADER=");
      ((StringBuilder)localObject).append(Build.BOOTLOADER);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("CPU_ABI=");
      ((StringBuilder)localObject).append(Build.CPU_ABI);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("CPU_ABI2=");
      ((StringBuilder)localObject).append(Build.CPU_ABI2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("DEVICE=");
      ((StringBuilder)localObject).append(Build.DEVICE);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("DISPLAY=");
      ((StringBuilder)localObject).append(Build.DISPLAY);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("FLNGERPRINT=");
      ((StringBuilder)localObject).append(Build.FINGERPRINT);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("HARDWARE=");
      ((StringBuilder)localObject).append(Build.HARDWARE);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("ID=");
      ((StringBuilder)localObject).append(Build.ID);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("MANUFACTURER=");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("SDK_INT=");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).append("|");
      QLog.i("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle != null)
    {
      this.mCurrentPosition = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate(), savedInstanceState != null, mCurrentPosition : ");
        paramBundle.append(this.mCurrentPosition);
        QLog.d("ShortVideoPlayActivity", 2, paramBundle.toString());
      }
    }
    this.mContext = this;
    this.mBundle = super.getIntent().getExtras();
    initData(super.getIntent());
    if (this.mIsHotVideo)
    {
      paramBundle = (URLImageView)findViewById(2131369589);
      localObject = this.mHotVideoIconUrl;
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        try
        {
          paramBundle.setVisibility(0);
          paramBundle.setImageDrawable(URLDrawable.getDrawable(this.mHotVideoIconUrl));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "onCreate(), IsHotVideo  URLDrawable.getDrawable(mHotVideoIconUrl) Exception", localException1);
          }
          paramBundle.setVisibility(8);
        }
        str1 = this.mHotVideoJumpUrl;
        if ((str1 != null) && (!str1.isEmpty()))
        {
          paramBundle.setClickable(true);
          paramBundle.setOnClickListener(new ShortVideoPlayActivity.8(this));
        }
      }
      else
      {
        paramBundle.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreate(), IsHotVideo  mHotVideoIconUrl = null");
        }
      }
      paramBundle = (URLImageView)findViewById(2131364415);
      String str1 = this.mHotVideoCertificatedIconUrl;
      if ((str1 != null) && (!str1.isEmpty()))
      {
        try
        {
          paramBundle.setVisibility(0);
          paramBundle.setImageDrawable(URLDrawable.getDrawable(this.mHotVideoCertificatedIconUrl));
        }
        catch (Exception localException2)
        {
          paramBundle.setVisibility(8);
          if (!QLog.isColorLevel()) {
            break label767;
          }
        }
        QLog.d("ShortVideoPlayActivity", 2, "onCreate(), IsHotVideo  URLDrawable.getDrawable(mHotVideoCertificatedIconUrl) Exception", localException2);
      }
      else
      {
        paramBundle.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreate(), IsHotVideo  mHotVideoCertificatedIconUrl = null");
        }
      }
      label767:
      paramBundle = this.mHotVideoTitle;
      if ((paramBundle != null) && (!paramBundle.isEmpty()))
      {
        paramBundle = (TextView)findViewById(2131368311);
        paramBundle.setVisibility(0);
        paramBundle.setText(this.mHotVideoTitle);
        String str2 = this.mHotVideoJumpUrl;
        if ((str2 != null) && (!str2.isEmpty()))
        {
          paramBundle.setClickable(true);
          paramBundle.setOnClickListener(new ShortVideoPlayActivity.9(this));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPlayActivity", 2, "onCreate(), IsHotVideo  mHotVideoTitle = null");
      }
    }
    onCreateController();
    initSDK();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.mReceiver, paramBundle);
    this.app.setHandler(ShortVideoPlayActivity.class, (MqqHandler)this.mHandler.get());
    this.mStartPlayTime = System.currentTimeMillis();
    ReportController.b(this.app, "dc00898", "", "", "0X8007425", "0X8007425", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X8007427", "0X8007427", 0, 0, "", "", "", "");
    paramBundle = this.mTitleBar;
    if ((paramBundle != null) && (this.mNeedHideTitleBar)) {
      paramBundle.setVisibility(8);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    Object localObject = this.mMediaPlayer;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying())) {
      this.mCurrentPosition = ((TVK_IMediaPlayer)this.mMediaPlayer.get()).getCurrentPostion();
    }
    releaseMediaPlayer();
    TVK_SDKMgr.setOnLogListener(null);
    localObject = this.mVideoLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).removeView(this.mVideoView);
    }
    localObject = this.mVideoView;
    if (localObject != null)
    {
      ((IVideoViewBase)localObject).removeViewCallBack(this);
      this.mVideoView = null;
    }
    try
    {
      unregisterReceiver(this.mReceiver);
      label129:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.mStartPlayTime >= 0L)
      {
        this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
        if (!this.mPlayTimeCostReported)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.mDuration / 1000L), this.mCurSessionType, this.mCurSessionUin, this.mPlayTimeCost / 1000L);
          this.mPlayTimeCostReported = true;
        }
      }
      if (this.mNeedReportProgressive) {
        new DCShortVideo(BaseApplication.getContext()).a(true, this.mPlayReadyTime, this.mPlayProgress / 100, this.mCacheProgress / 100, (int)this.mDuration, (int)this.mFileSize, 0, this.mSeekTimes, this.mPlayResult, this.mPlayTimeCost);
      }
      if (!this.mIsUploading)
      {
        doNewReport();
        reportDownloadResult(true);
        updateMsgStatus();
      }
      localObject = this.mMsg;
      if ((localObject != null) && (((MessageForShortVideo)localObject).uiOperatorFlag == 2) && (this.mMsg.videoFileProgress != 100))
      {
        localObject = this.mMsg;
        ((MessageForShortVideo)localObject).videoFileStatus = 2009;
        ((MessageForShortVideo)localObject).serial();
        this.app.getMessageFacade().a(this.mMsg.frienduin, this.mUinType, this.mMsg.uniseq, this.mMsg.msgData);
      }
      if (this.mHandler.get() != null) {
        ((MqqHandler)this.mHandler.get()).removeCallbacksAndMessages(null);
      }
      localObject = this.mDragView;
      if (localObject != null)
      {
        ((DragView)localObject).removeAllViews();
        this.mDragView = null;
      }
      QQAppInterface localQQAppInterface = this.app;
      int i = this.mCurSessionType;
      localObject = this.mMsg;
      if (localObject != null) {
        localObject = ((MessageForShortVideo)localObject).frienduin;
      } else {
        localObject = "";
      }
      ShortVideoUtils.reportVideoPlayEvent(localQQAppInterface, i, (String)localObject, 2, 1, this.mDuration, this.playDurationForReport);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label129;
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (this.mOperatorBar.getVisibility() == 0))
    {
      if ((this.mUinType != 9501) || (this.mPlayCallerType == 5)) {
        showActionSheet();
      }
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    Object localObject = this.mMediaPlayer;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying()))
    {
      this.mCurrentPosition = ((TVK_IMediaPlayer)this.mMediaPlayer.get()).getCurrentPostion();
      this.mNeedPlay = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pause mCurrentPosition:");
        ((StringBuilder)localObject).append(this.mCurrentPosition);
        QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (isBuffering())
    {
      this.mNeedPlay = true;
    }
    pause();
    super.doOnPause();
  }
  
  @TargetApi(10)
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume: mInterrupted = ");
      ((StringBuilder)localObject).append(this.mInterrupted);
      ((StringBuilder)localObject).append(", mNeedPlay = ");
      ((StringBuilder)localObject).append(this.mNeedPlay);
      ((StringBuilder)localObject).append(" mSurfaceViewDestroyed=");
      ((StringBuilder)localObject).append(this.mSurfaceViewDestroyed);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    setSystemUiVisibility();
    if ((this.mInterrupted) || (this.mCompleted)) {
      if (this.mNeedPlay)
      {
        localObject = this.mMediaPlayer;
        if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying()) && (!resume())) {
          play(this.mCurrentPosition);
        }
      }
      else if (Build.VERSION.SDK_INT >= 10)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onResume, restore last pause, mCurrentPosition=");
          ((StringBuilder)localObject).append(this.mCurrentPosition);
          QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (!this.mSurfaceViewDestroyed)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onResume, restore last pause mSurfaceViewDestroyed=");
            ((StringBuilder)localObject).append(this.mSurfaceViewDestroyed);
            QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
        int i = this.mPlayCallerType;
        if ((i != 0) && (i != 5))
        {
          if (i == 1) {
            this.mCoverIV.setImageDrawable(new ColorDrawable(0));
          }
        }
        else if ((!TextUtils.isEmpty(this.mVideoPath)) && (FileUtils.fileExistsAndNotEmpty(this.mVideoPath))) {
          try
          {
            localObject = new MediaMetadataRetriever();
            ((MediaMetadataRetriever)localObject).setDataSource(this.mVideoPath);
            this.mThumbBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(this.mCurrentPosition * 1000L);
            this.mCoverIV.setImageBitmap(this.mThumbBitmap);
            ((MediaMetadataRetriever)localObject).release();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            this.mCoverIV.setImageDrawable(new ColorDrawable(0));
          }
        }
        this.mCoverIV.setVisibility(0);
      }
    }
  }
  
  protected void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  void forwardFavorite()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
    }
    Bundle localBundle = access$2501(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", SVUtils.a(this.mThumbMd5, "jpg"));
    localBundle.putString("file_send_path", getVideoPath());
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(this, localIntent);
    access$2601(this);
    if (this.isFromMultiMsg) {
      MultiMsgUtil.a("0X8009ABC");
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
  }
  
  public Intent getIntentForStartForwardRecentActivity()
  {
    Object localObject = getVideoPath();
    Bundle localBundle = access$2701(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", SVUtils.a(this.mThumbMd5, "jpg"));
    localBundle.putString("file_send_path", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    return localObject;
  }
  
  String getPlayStateStr(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "null";
            }
            return " buffering ";
          }
          return " error ";
        }
        return " pause ";
      }
      return " playing ";
    }
    return " idle ";
  }
  
  String getVideoPath()
  {
    if (this.mPlayCallerType == 0) {
      return SVUtils.a(this.mMsg, "mp4");
    }
    return this.mVideoPath;
  }
  
  void handleClick()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleClick: mPlayState = ");
      localStringBuilder.append(getPlayStateStr(this.mPlayState));
      localStringBuilder.append(", mCurrentPosition = ");
      localStringBuilder.append(this.mCurrentPosition);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    int i = this.mPlayState;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          play(0L);
          return;
        }
        resume();
        long l = this.mCurrentPosition;
        if ((l != 0L) && (this.mSurfaceViewDestroyed)) {
          play(l);
        }
      }
      else
      {
        pause();
      }
    }
    else {
      play(this.mCurrentPosition);
    }
  }
  
  void handleError(int paramInt1, int paramInt2)
  {
    int j = 0;
    this.mPlayResult = 0;
    this.mErrCode = 9001;
    Object localObject2 = getString(2131719095);
    Object localObject1;
    int k;
    Object localObject3;
    if ((paramInt1 == 101) && (this.mVideoUrls != null) && (!StringUtil.a(this.mDomain)))
    {
      localObject1 = this.mVideoUrls;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject3 = localObject1[i];
        if (!StringUtil.a((String)localObject3)) {
          InnerDns.getInstance().reportBadIp(this.mDomain, InnerDns.getHostFromUrl((String)localObject3), 1005);
        }
        i += 1;
      }
    }
    int i = this.mPlayCallerType;
    if (i == 1)
    {
      dismissLoadingView();
      dismissLoadingImage();
      localObject1 = getString(2131719092);
    }
    else if (i == 0)
    {
      localObject1 = localObject2;
      if (!this.mPlayFailReported)
      {
        k = (int)(DeviceInfoUtil.e() / 1024L);
        i = j;
        if (!StringUtil.a(this.mVideoPath)) {
          i = (int)(new File(this.mVideoPath).length() / 1024L);
        }
        localObject1 = DeviceInfoUtil.d();
        localObject3 = this.app;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(k);
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b((AppRuntime)localObject3, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, (String)localObject4, localStringBuilder.toString(), (String)localObject1, this.mMd5);
        this.mPlayFailReported = true;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = localObject2;
      if (i == 2)
      {
        adMsgVideoReport(this.ad_gdt, 0, 1002, this.msg_id);
        localObject1 = getString(2131719092);
      }
    }
    localObject2 = localObject1;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        localObject2 = localObject1;
        if (paramInt2 != 202) {}
      }
      else
      {
        localObject2 = getString(2131719092);
      }
    }
    showDialogSafe(DialogUtil.a(this, 232, null, (String)localObject2, new ShortVideoPlayActivity.20(this), null));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleError，mPlayCallerType = ");
      ((StringBuilder)localObject1).append(this.mPlayCallerType);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.mPlayTimeCost = -1L;
    this.mStartPlayTime = -1L;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = this.mMsg;
    if (((paramView == null) || (paramView.uniseq != paramFileMsg.uniseq)) && (this.mPlayCallerType != 2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append(" handleMessage what==");
      paramView.append(paramInt1);
      paramView.append(", arg1:");
      paramView.append(paramInt2);
      QLog.d("ShortVideoPlayActivity", 2, paramView.toString());
    }
    if ((QLog.isColorLevel()) && (this.mMsg != null))
    {
      paramView = new StringBuilder();
      paramView.append("handleMessage msg.uniseq:");
      paramView.append(this.mMsg.uniseq);
      paramView.append(",fileType:");
      paramView.append(SVUtils.a(paramFileMsg.fileType));
      paramView.append(" ===> fileStatus:");
      paramView.append(SVUtils.b(paramFileMsg.status));
      QLog.d("ShortVideoPlayActivity", 2, paramView.toString());
    }
    if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
    {
      paramInt2 = paramFileMsg.status;
      if (paramInt2 != 1002) {
        if (paramInt2 != 1003)
        {
          paramInt1 = 0;
          if (paramInt2 != 5001) {
            if (paramInt2 == 5002) {}
          }
        }
      }
      switch (paramInt2)
      {
      default: 
      case 2005: 
        QQToast.a(this.mContext, 2131719105, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
        this.mErrCode = paramFileMsg.errorCode;
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.mCacheProgress = 10000;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.mPlayReadyTime = ((int)(System.currentTimeMillis() - this.mStartPlayTime));
        if (paramFileMsg.urls != null)
        {
          this.mVideoUrls = paramFileMsg.urls;
          this.mDomain = paramFileMsg.domain;
          this.mStepUrlCost = paramFileMsg.stepUrlCost;
          while (paramInt1 < 1)
          {
            if (!StringUtil.a(this.mDomain))
            {
              paramView = new StringBuilder();
              paramFileMsg = this.mVideoUrls;
              paramView.append(paramFileMsg[paramInt1]);
              paramView.append("&txhost=");
              paramView.append(this.mDomain);
              paramFileMsg[paramInt1] = paramView.toString();
            }
            paramInt1 += 1;
          }
          play(0L);
          return;
          QQToast.a(this.mContext, 2131719104, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
          this.mErrCode = paramFileMsg.errorCode;
          return;
          QQToast.a(this.mContext, 2131719103, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
          this.mErrCode = paramFileMsg.errorCode;
          return;
          switchToNormalPlayUI();
          return;
          updateUploadInfo(paramFileMsg.transferedSize, paramFileMsg.fileSize);
        }
        break;
      }
    }
  }
  
  void initData(Intent paramIntent)
  {
    if (paramIntent.getExtras() == null) {
      return;
    }
    this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
    this.mPlayCallerType = paramIntent.getExtras().getInt("video_play_caller", 0);
    this.mFavId = paramIntent.getExtras().getLong("fav_id", 0L);
    this.mFavGroupId = paramIntent.getExtras().getInt("fav_group_id", 0);
    this.mNeedHideTitleBar = paramIntent.getExtras().getBoolean("video_title_bar_hide", false);
    this.ad_gdt = paramIntent.getExtras().getString("ad_gdt");
    this.msg_id = paramIntent.getExtras().getString("msg_id");
    this.mCurSessionType = paramIntent.getExtras().getInt("from_uin_type");
    this.mCurSessionUin = paramIntent.getExtras().getString("from_session_uin");
    this.mUinType = paramIntent.getExtras().getInt("uintype");
    this.mVideoInfo = paramIntent.getExtras().getString("struct_msg_video_info");
    this.mCurrentUin = paramIntent.getExtras().getString("from_uin");
    this.mMessageClickStart = paramIntent.getExtras().getLong("message_click_start");
    this.mUuid = paramIntent.getExtras().getString("file_uuid");
    this.mMd5 = paramIntent.getExtras().getString("file_shortvideo_md5");
    this.mThumbMd5 = paramIntent.getExtras().getString("thumbfile_md5");
    this.originRect = ((Rect)paramIntent.getExtras().getParcelable("KEY_THUMBNAL_BOUND"));
    this.sourceEntrance = paramIntent.getExtras().getInt("extra.EXTRA_ENTRANCE");
    this.isFromMultiMsg = paramIntent.getExtras().getBoolean("extra.IS_FROM_MULTI_MSG");
    this.mIsHotVideo = paramIntent.getExtras().getBoolean("is_hotVideo");
    this.mHotVideoIconUrl = paramIntent.getExtras().getString("hot_video_icon");
    this.mHotVideoCertificatedIconUrl = paramIntent.getExtras().getString("hot_video_icon_sub");
    this.mHotVideoJumpUrl = paramIntent.getExtras().getString("hot_video_url");
    this.mHotVideoTitle = paramIntent.getExtras().getString("hot_video_title");
    if (this.mFavId != -1L) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_jc_shoucang");
    }
    int i = this.mPlayCallerType;
    if ((i == 0) || (i == 5))
    {
      this.mMsg = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
      if (this.mMsg == null)
      {
        QQToast.a(this, 1, HardCodeUtil.a(2131713913), 0).b(getTitleBarHeight());
        finish();
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("initData(), PLAY_CALLER_SHORT_VIDEO, msg = ");
        paramIntent.append(this.mMsg.toLogString());
        paramIntent.append(", mUinType = ");
        paramIntent.append(this.mUinType);
        QLog.d("ShortVideoPlayActivity", 2, paramIntent.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("initData(): mVideoPath=");
      paramIntent.append(this.mVideoPath);
      paramIntent.append(", mPlayCallerType=");
      paramIntent.append(this.mPlayCallerType);
      paramIntent.append(", mCursessionType = ");
      paramIntent.append(this.mCurSessionType);
      paramIntent.append(", mCurSessionUin = ");
      paramIntent.append(this.mCurSessionUin);
      paramIntent.append(", mUinType = ");
      paramIntent.append(this.mUinType);
      QLog.d("ShortVideoPlayActivity", 2, paramIntent.toString());
    }
  }
  
  void initDuration()
  {
    Object localObject = this.mMediaPlayer;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      long l = ((TVK_IMediaPlayer)this.mMediaPlayer.get()).getDuration();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initDuration: duration=");
        ((StringBuilder)localObject).append(l);
        QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (l != 0L)
      {
        this.mDuration = ((int)l);
        this.mDurationStr = ShortVideoUtils.stringForTime(this.mDuration);
        localObject = this.mTotalTime;
        if ((localObject != null) && (!((TextView)localObject).getText().equals(this.mDurationStr))) {
          runOnUiThread(new ShortVideoPlayActivity.18(this));
        }
      }
    }
  }
  
  public void initSDK()
  {
    boolean bool = this.mIsSDKInit;
    int j = 1;
    if (!bool)
    {
      TVK_SDKMgr.initSdk(getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.mIsSDKInit = true;
    }
    if (TVK_SDKMgr.isInstalled(getApplicationContext()))
    {
      onCreateVideoSdkView();
      return;
    }
    int k = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int i = j;
    if (k != 1) {
      if (k == 4) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0)
    {
      installSDK();
      localContext = this.mContext;
      QQToast.a(localContext, localContext.getResources().getString(2131697738), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Context localContext = this.mContext;
    DialogUtil.a(localContext, 232, null, localContext.getResources().getString(2131697735), new ShortVideoPlayActivity.11(this), new ShortVideoPlayActivity.12(this)).show();
  }
  
  void innerChangePlayerState(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      return;
    }
    if (paramInt == this.mPlayState) {
      return;
    }
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, while finishing");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changePlayState, ");
      ((StringBuilder)localObject).append(getPlayStateStr(this.mPlayState));
      ((StringBuilder)localObject).append(" ==> ");
      ((StringBuilder)localObject).append(getPlayStateStr(paramInt));
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.mPlayState == 1) && (paramInt != 1))
    {
      if (this.mPlayStart != 0L) {
        this.mPlayCost += System.currentTimeMillis() - this.mPlayStart;
      }
    }
    else if ((this.mPlayState == 4) && (paramInt != 4) && (this.mBufferStart != 0L)) {
      this.mBufferCost += System.currentTimeMillis() - this.mBufferStart;
    }
    this.mPlayState = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.mBufferStart = System.currentTimeMillis();
            this.mBufferTimes += 1;
            if (this.mNeedDownload) {
              this.mBufferLayout.setVisibility(0);
            }
            if (this.mHandler.get() != null)
            {
              ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mProgressChecker);
              ((MqqHandler)this.mHandler.get()).postDelayed(this.mProgressChecker, 50L);
            }
          }
          else
          {
            this.mOperatorBtn.setImageResource(2130845892);
            this.mOperatorBtn.setContentDescription(HardCodeUtil.a(2131713931));
            if (this.mHandler.get() != null) {
              ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mProgressChecker);
            }
          }
        }
        else
        {
          this.mPauseTimes += 1;
          this.mOperatorBtn.setImageResource(2130845892);
          this.mOperatorBtn.setContentDescription(HardCodeUtil.a(2131713940));
        }
      }
      else
      {
        this.mPlayStart = System.currentTimeMillis();
        this.mRealPlayTimes += 1;
        this.mOperatorBtn.setImageResource(2130845894);
        this.mOperatorBtn.setContentDescription(HardCodeUtil.a(2131713938));
        this.mCoverIV.setVisibility(8);
        if (this.mHandler.get() != null)
        {
          ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mProgressChecker);
          ((MqqHandler)this.mHandler.get()).postDelayed(this.mProgressChecker, 50L);
        }
        delayStartHiding();
        dismissLoadingView();
        dismissLoadingImage();
        localObject = this.mBufferLayout;
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(8);
        }
      }
    }
    else
    {
      if (this.mHandler.get() != null) {
        ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mProgressChecker);
      }
      this.mOperatorBtn.setImageResource(2130845892);
      this.mOperatorBtn.setContentDescription(HardCodeUtil.a(2131713958));
    }
  }
  
  void innerOnCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onCompletion(), mPlayProgress=");
      paramTVK_IMediaPlayer.append(this.mPlayProgress);
      paramTVK_IMediaPlayer.append(", mCacheProgress=");
      paramTVK_IMediaPlayer.append(this.mCacheProgress);
      paramTVK_IMediaPlayer.append(", mCurPlayPosition");
      paramTVK_IMediaPlayer.append(this.mCurPlayPosition);
      paramTVK_IMediaPlayer.append(", mDuration=");
      paramTVK_IMediaPlayer.append(this.mDuration);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    this.mPlayProgress = 10000;
    if (!this.hasUserSeeked) {
      this.playDurationForReport = this.mDuration;
    }
    this.mSeekBar.setProgress(10000);
    if ((this.mPlayCallerType == 2) && (this.mPlayState == 1)) {
      adMsgVideoReport(this.ad_gdt, 2, 1002, this.msg_id);
    }
    changePlayState(0);
    this.mProgressTime.setText(this.mTotalTime.getText());
    startShowing();
    this.mCurrentPosition = 0L;
    this.mCompleted = true;
    if (this.mStartPlayTime >= 0L)
    {
      this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
      if (!this.mPlayTimeCostReported)
      {
        new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.mDuration / 1000L), this.mCurSessionType, this.mCurSessionUin, this.mPlayTimeCost / 1000L);
        this.mPlayTimeCostReported = true;
      }
    }
    doNewReport();
  }
  
  public void innerOnError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mSdkErrorCode = paramInt1;
    this.mSdkDetailErrorCode = paramInt2;
    doNewReport();
    reportDownloadResult(false);
    this.mStatus = 2005;
    changePlayState(3);
    reset();
    handleError(paramInt1, paramInt2);
  }
  
  boolean isBuffering()
  {
    return this.mPlayState == 4;
  }
  
  boolean isPlaying()
  {
    if (this.mPlayState == 1)
    {
      WeakReference localWeakReference = this.mMediaPlayer;
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying())) {
        return true;
      }
    }
    return false;
  }
  
  boolean isVideoExist(String paramString)
  {
    boolean bool = FileUtils.fileExists(paramString);
    if (this.mNeedDownload) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    userBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131374342: 
      userBackPressed();
      break;
    case 2131372192: 
      showAnimation();
      handleClick();
      break;
    case 2131370792: 
      showAnimation();
      if (this.mPlayState == 1) {
        pause();
      }
      this.mFavActionSheet.onClick(paramView);
      break;
    case 2131364704: 
      AioVideoTransFileController.b(this.app, this.mMsg.frienduin, this.mMsg.uniseq);
      userBackPressed();
      break;
    case 2131363340: 
      userBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClickDragView()
  {
    userBackPressed();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new ShortVideoPlayActivity.25(this, paramTVK_IMediaPlayer));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mIsHotVideo) {
      if (paramConfiguration.orientation == 2) {
        ((RelativeLayout)findViewById(2131368312)).setVisibility(8);
      } else {
        ((RelativeLayout)findViewById(2131368312)).setVisibility(0);
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onContentMove(float paramFloat)
  {
    Object localObject = this.mVideoLayout;
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getBackground();
      if (localObject != null) {
        ((Drawable)localObject).mutate().setAlpha((int)(255.0F * paramFloat));
      }
      if (paramFloat < 0.8F)
      {
        this.mVideoController.setVisibility(4);
        this.mTitleBar.setVisibility(4);
      }
    }
  }
  
  void onCreateController()
  {
    this.mVideoController = ((RelativeLayout)getLayoutInflater().inflate(2131561483, null, false));
    this.mRoot = ((RelativeLayout)this.mVideoController.findViewById(2131376809));
    this.mNormalOperateLayout = ((LinearLayout)this.mVideoController.findViewById(2131371936));
    setSystemUiVisibility();
    this.mOperatorBar = this.mVideoController.findViewById(2131372191);
    this.mOperatorBar.setOnClickListener(this);
    this.mCoverIV = ((URLImageView)this.mVideoController.findViewById(2131365285));
    this.mLoadingText = ((TextView)this.mVideoController.findViewById(2131370363));
    this.mMenuBtn = ((ImageView)this.mVideoController.findViewById(2131370792));
    this.mMenuBtn.setOnClickListener(this);
    this.mProgressTime = ((TextView)this.mVideoController.findViewById(2131373130));
    this.mTotalTime = ((TextView)this.mVideoController.findViewById(2131379063));
    this.mSeekBar = ((SeekBar)this.mVideoController.findViewById(2131377124));
    this.mSeekBar.setMax(10000);
    this.mOperatorBtn = ((ImageView)this.mVideoController.findViewById(2131372192));
    this.mOperatorBtn.setOnClickListener(this);
    this.mSeekBar.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mBufferLayout = ((RelativeLayout)this.mVideoController.findViewById(2131364130));
    this.mRateText = ((TextView)this.mVideoController.findViewById(2131375985));
    int i = this.mPlayCallerType;
    if ((i == 0) || (i == 5))
    {
      localObject = this.mMsg;
      if ((localObject != null) && ((((MessageForShortVideo)localObject).videoFileStatus == 1001) || (this.mMsg.videoFileStatus == 1002)) && (((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(this.mMsg.frienduin, this.mMsg.uniseq) != null))
      {
        this.mIsUploading = true;
        this.mUploadOperateLayout = ((RelativeLayout)this.mVideoController.findViewById(2131380237));
        this.mUploadOperateLayout.setVisibility(0);
        this.mNormalOperateLayout.setVisibility(4);
        this.mUploadingSeekBar = ((SeekBar)this.mVideoController.findViewById(2131380239));
        this.mUploadingSeekBar.setMax(100);
        this.mCloseBtn = ((ImageView)this.mVideoController.findViewById(2131364704));
        this.mCloseBtn.setOnClickListener(this);
        this.mUploadProgress = ((TextView)this.mVideoController.findViewById(2131380238));
      }
    }
    this.mDragView = new DragView(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.mDragView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mDragView.setGestureChangeListener(this);
    if (LiuHaiUtils.b()) {
      i = LiuHaiUtils.jdField_a_of_type_Int;
    } else {
      i = 0;
    }
    localObject = this.originRect;
    if (localObject != null)
    {
      ((Rect)localObject).top -= i;
      localObject = this.originRect;
      ((Rect)localObject).bottom -= i;
    }
    this.mDragView.setOriginRect(this.originRect);
    this.mVideoLayout = ((RelativeLayout)findViewById(2131374342));
    this.mVideoLayout.setOnClickListener(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.mVideoController.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mVideoLayout.addView(this.mVideoController);
    this.mTitleBar = ((RelativeLayout)this.mVideoLayout.findViewById(2131369874));
    this.mTitleBar.setVisibility(0);
    this.mTitleBar.bringToFront();
    localObject = (RelativeLayout)this.mVideoLayout.findViewById(2131369873);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getApplicationContext());
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    this.mReturnBtn = ((TextView)this.mVideoLayout.findViewById(2131363340));
    this.mReturnBtn.setOnClickListener(this);
    setProgressTime(0L);
    this.mTotalTime.setText(ShortVideoUtils.stringForTime(0L));
    showLoadingView();
    showLoadingImage();
    createActionSheet();
  }
  
  void onCreateVideoSdkView()
  {
    try
    {
      this.mVideoProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.mVideoProxyFactory != null)
      {
        this.mVideoView = ((View)this.mVideoProxyFactory.createVideoView_Scroll(this));
        this.mVideoView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mVideoView.setLayoutParams(localLayoutParams);
        this.mVideoView.setVisibility(0);
        ((IVideoViewBase)this.mVideoView).addViewCallBack(this);
        if (this.originRect != null)
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(13);
          this.mVideoView.setLayoutParams(localLayoutParams);
          this.mDragView.addView(this.mVideoView);
          this.mVideoLayout.addView(this.mDragView, 0);
        }
        else
        {
          this.mVideoLayout.addView(this.mVideoView, 0);
        }
        initVideoData();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MediaPlayer] onError what=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",extra=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",mCacheProgress=");
      localStringBuilder.append(this.mCacheProgress);
      localStringBuilder.append(", mPlayProgress=");
      localStringBuilder.append(this.mPlayProgress);
      localStringBuilder.append(", mCurPlayPosition=");
      localStringBuilder.append(this.mCurPlayPosition);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    runOnUiThread(new ShortVideoPlayActivity.26(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public void onGestureFinish()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009AB3", "0X8009AB3", this.sourceEntrance, 0, "", "", "", "");
    releaseMediaPlayer();
    finish();
    try
    {
      overridePendingTransition(2130772065, 2130772067);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MediaPlayer] overridePendingTransition=");
        localStringBuilder.append(localException);
        QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onInfo what=");
      paramTVK_IMediaPlayer.append(paramInt);
      paramTVK_IMediaPlayer.append(",extra=");
      paramTVK_IMediaPlayer.append(paramObject);
      paramTVK_IMediaPlayer.append(",mCacheProgress=");
      paramTVK_IMediaPlayer.append(this.mCacheProgress);
      paramTVK_IMediaPlayer.append(", mPlayProgress=");
      paramTVK_IMediaPlayer.append(this.mPlayProgress);
      paramTVK_IMediaPlayer.append(", mCurPlayPosition=");
      paramTVK_IMediaPlayer.append(this.mCurPlayPosition);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    if (paramInt != 21)
    {
      if (paramInt == 22)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "video end buffering !");
        }
        paramTVK_IMediaPlayer = this.mMediaPlayer;
        if ((paramTVK_IMediaPlayer != null) && (paramTVK_IMediaPlayer.get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying())) {
          changePlayState(1);
        } else {
          changePlayState(2);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video start buffering !");
      }
      changePlayState(4);
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onNetVideoInfo what=");
      paramTVK_IMediaPlayer.append(paramTVK_NetVideoInfo.getErrInfo());
      paramTVK_IMediaPlayer.append(",extra=");
      paramTVK_IMediaPlayer.append(paramTVK_NetVideoInfo.getState());
      paramTVK_IMediaPlayer.append(",mCacheProgress=");
      paramTVK_IMediaPlayer.append(this.mCacheProgress);
      paramTVK_IMediaPlayer.append(", mPlayProgress=");
      paramTVK_IMediaPlayer.append(this.mPlayProgress);
      paramTVK_IMediaPlayer.append(", mCurPlayPosition=");
      paramTVK_IMediaPlayer.append(this.mCurPlayPosition);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
  }
  
  public void onResetPosition()
  {
    this.mVideoController.setVisibility(0);
    this.mTitleBar.setVisibility(0);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    WeakReference localWeakReference = this.mMediaPlayer;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((TVK_IMediaPlayer)this.mMediaPlayer.get()).isPlaying()))
    {
      this.mCurrentPosition = ((TVK_IMediaPlayer)this.mMediaPlayer.get()).getCurrentPostion();
      this.mNeedPlay = true;
    }
    paramBundle.putLong("state_play_position", this.mCurrentPosition);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSaveInstanceState: mCurrentPosition: ");
      paramBundle.append(this.mCurrentPosition);
      QLog.d("ShortVideoPlayActivity", 2, paramBundle.toString());
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onSeekComplete mCacheProgress=");
      paramTVK_IMediaPlayer.append(this.mCacheProgress);
      paramTVK_IMediaPlayer.append(", mPlayProgress=");
      paramTVK_IMediaPlayer.append(this.mPlayProgress);
      paramTVK_IMediaPlayer.append(", mCurPlayPosition=");
      paramTVK_IMediaPlayer.append(this.mCurPlayPosition);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    paramTVK_IMediaPlayer = this.mMediaPlayer;
    if ((paramTVK_IMediaPlayer != null) && (paramTVK_IMediaPlayer.get() != null)) {
      ((TVK_IMediaPlayer)this.mMediaPlayer.get()).start();
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.mSurfaceViewDestroyed = true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onVideoPrepared: mDuration=");
      paramTVK_IMediaPlayer.append(this.mDuration);
      paramTVK_IMediaPlayer.append(" mInterrupted");
      paramTVK_IMediaPlayer.append(this.mInterrupted);
      paramTVK_IMediaPlayer.append(" mNeedPlay");
      paramTVK_IMediaPlayer.append(this.mNeedPlay);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    this.mSurfaceViewDestroyed = false;
    runOnUiThread(new ShortVideoPlayActivity.27(this));
    if (this.mPlayCallerType == 2) {
      adMsgVideoReport(this.ad_gdt, 1, 1002, this.msg_id);
    }
    if (this.mMessageClickStart != 0L)
    {
      this.mMessageClickCost = (System.currentTimeMillis() - this.mMessageClickStart);
      this.mMessageClickStart = 0L;
    }
    if (this.mOpenPlayerStart != 0L)
    {
      this.mOpenPlayerCost = (System.currentTimeMillis() - this.mOpenPlayerStart);
      this.mOpenPlayerStart = 0L;
    }
    if (this.mInterrupted)
    {
      this.mInterrupted = false;
      if (!this.mNeedPlay) {
        return;
      }
    }
    this.mNeedPlay = false;
    if (this.mDuration <= 0L) {
      initDuration();
    }
    paramTVK_IMediaPlayer = this.mMediaPlayer;
    if ((paramTVK_IMediaPlayer != null) && (paramTVK_IMediaPlayer.get() != null))
    {
      ((TVK_IMediaPlayer)this.mMediaPlayer.get()).start();
      if (this.mSec > 0L) {
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).seekTo((int)this.mSec);
      }
      changePlayState(1);
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("[MediaPlayer] onVideoPreparing mCacheProgress=");
      paramTVK_IMediaPlayer.append(this.mCacheProgress);
      paramTVK_IMediaPlayer.append(", mPlayProgress=");
      paramTVK_IMediaPlayer.append(this.mPlayProgress);
      paramTVK_IMediaPlayer.append(", mCurPlayPosition=");
      paramTVK_IMediaPlayer.append(this.mCurPlayPosition);
      QLog.d("ShortVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      setSystemUiVisibility();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWindowFocusChanged: hasFocus: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
  }
  
  void pause()
  {
    Object localObject;
    if (isPlaying())
    {
      localObject = this.mMediaPlayer;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        this.mCurrentPosition = ((TVK_IMediaPlayer)this.mMediaPlayer.get()).getCurrentPostion();
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).pause();
      }
    }
    changePlayState(2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#pause# , mCurrentPosition = ");
      ((StringBuilder)localObject).append(this.mCurrentPosition);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mStartPlayTime >= 0L) {
      this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
    }
  }
  
  void play(long paramLong)
  {
    long l2 = paramLong;
    for (;;)
    {
      try
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          l2 = paramLong;
          localObject1 = new StringBuilder();
          l2 = paramLong;
          ((StringBuilder)localObject1).append("#play#, msec=");
          l2 = paramLong;
          ((StringBuilder)localObject1).append(paramLong);
          l2 = paramLong;
          QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject1).toString());
        }
        l2 = paramLong;
        if (this.mVideoProxyFactory == null)
        {
          l2 = paramLong;
          QLog.e("ShortVideoPlayActivity", 2, "play, mVideoProxyFactory is null .");
          return;
        }
        l2 = paramLong;
        this.mSec = paramLong;
        l2 = paramLong;
        this.mNeedReportAioVideo = true;
        l2 = paramLong;
        if (this.mMediaPlayer != null)
        {
          l2 = paramLong;
          if (this.mMediaPlayer.get() != null) {
            break label1567;
          }
        }
        l2 = paramLong;
        this.mMediaPlayer = new WeakReference(this.mVideoProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.mVideoView));
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnCompletionListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnErrorListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnVideoPreparedListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnSeekCompleteListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnInfoListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnNetVideoInfoListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnVideoPreparingListener(this);
        l2 = paramLong;
        ((TVK_IMediaPlayer)this.mMediaPlayer.get()).setOnDownloadCallback(this);
        l2 = paramLong;
        this.mOpenPlayerStart = System.currentTimeMillis();
        i = 1;
        l2 = paramLong;
        if (this.mCompleted)
        {
          l2 = paramLong;
          this.mReplayTimes += 1;
          i = 1;
        }
        if (i != 0)
        {
          long l1 = paramLong;
          if (paramLong == 0L)
          {
            l1 = paramLong;
            l2 = paramLong;
            if (this.mSeekBar.getProgress() > 0)
            {
              l1 = paramLong;
              l2 = paramLong;
              if (this.mSeekBar.getProgress() < 10000)
              {
                l1 = paramLong;
                l2 = paramLong;
                if (this.mMsg != null)
                {
                  l2 = paramLong;
                  l1 = this.mMsg.videoFileTime * 1000 * this.mSeekBar.getProgress() / 100;
                }
              }
            }
          }
          l2 = l1;
          localObject1 = this.mVideoUrls;
          if (localObject1 != null)
          {
            l2 = l1;
            if (this.mNeedDownload)
            {
              l2 = l1;
              if (this.mPlayCallerType != 0)
              {
                l2 = l1;
                if (this.mPlayCallerType != 5) {}
              }
              else
              {
                l2 = l1;
                if (this.mMsg != null)
                {
                  l2 = l1;
                  localObject1 = SVUtils.a(this.mMsg, "mp4");
                  continue;
                }
              }
              l2 = l1;
              if (this.mPlayCallerType == 2)
              {
                l2 = l1;
                if (this.mVideoInfo != null)
                {
                  l2 = l1;
                  localObject1 = this.publicAccountLocalPath;
                  l2 = l1;
                  localObject2 = new TVK_PlayerVideoInfo();
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setConfigMap("file_dir", (String)localObject1);
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_servers_type", "20160518");
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
                  l2 = l1;
                  Object localObject3 = new HashMap();
                  l2 = l1;
                  ((Map)localObject3).put("shouq_bus_type", "bus_type_aio_long_fs");
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap((Map)localObject3);
                  l2 = l1;
                  if (this.mMsg != null)
                  {
                    l2 = l1;
                    ((TVK_PlayerVideoInfo)localObject2).setConfigMap("duration", String.valueOf(this.mMsg.videoFileTime));
                  }
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setVid(this.mMd5);
                  l2 = l1;
                  ((TVK_PlayerVideoInfo)localObject2).setPlayMode("cache_extend_video");
                  l2 = l1;
                  if (QLog.isColorLevel())
                  {
                    l2 = l1;
                    localObject3 = new StringBuilder();
                    l2 = l1;
                    ((StringBuilder)localObject3).append("#play#, setVid =");
                    l2 = l1;
                    ((StringBuilder)localObject3).append(this.mMd5);
                    l2 = l1;
                    ((StringBuilder)localObject3).append(" videoPath=");
                    l2 = l1;
                    ((StringBuilder)localObject3).append((String)localObject1);
                    l2 = l1;
                    QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject3).toString());
                    l2 = l1;
                    localObject1 = new StringBuilder();
                    l2 = l1;
                    ((StringBuilder)localObject1).append("#play#, url0 =");
                    l2 = l1;
                    ((StringBuilder)localObject1).append(this.mVideoUrls[0]);
                    l2 = l1;
                    QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject1).toString());
                  }
                  l2 = l1;
                  this.mHttpStart = System.currentTimeMillis();
                  l2 = l1;
                  ((TVK_IMediaPlayer)this.mMediaPlayer.get()).openMediaPlayerByUrl(this.mContext.getApplicationContext(), this.mVideoUrls, l1, 0L, (TVK_PlayerVideoInfo)localObject2, null);
                  paramLong = l1;
                  continue;
                }
              }
              l2 = l1;
              if (!QLog.isColorLevel()) {
                break;
              }
              l2 = l1;
              localObject1 = new StringBuilder();
              l2 = l1;
              ((StringBuilder)localObject1).append("#play#, mVideo caller type not right:");
              l2 = l1;
              ((StringBuilder)localObject1).append(this.mPlayCallerType);
              l2 = l1;
              QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject1).toString());
              return;
            }
          }
          l2 = l1;
          if (!TextUtils.isEmpty(this.mVideoPath))
          {
            l2 = l1;
            if (QLog.isColorLevel())
            {
              l2 = l1;
              localObject1 = new StringBuilder();
              l2 = l1;
              ((StringBuilder)localObject1).append("#play#, videoPath=");
              l2 = l1;
              ((StringBuilder)localObject1).append(this.mVideoPath);
              l2 = l1;
              QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject1).toString());
            }
            l2 = l1;
            localObject1 = new TVK_PlayerVideoInfo();
            l2 = l1;
            ((TVK_PlayerVideoInfo)localObject1).setConfigMap("keep_last_frame", "true");
            l2 = l1;
            ((TVK_PlayerVideoInfo)localObject1).setPlayType(4);
            l2 = l1;
            localObject2 = new HashMap();
            l2 = l1;
            ((Map)localObject2).put("shouq_bus_type", "bus_type_aio_long_fs");
            l2 = l1;
            ((TVK_PlayerVideoInfo)localObject1).setReportInfoMap((Map)localObject2);
            l2 = l1;
            ((TVK_IMediaPlayer)this.mMediaPlayer.get()).openMediaPlayerByUrl(this.mContext.getApplicationContext(), this.mVideoPath, l1, 0L, (TVK_PlayerVideoInfo)localObject1);
            paramLong = l1;
          }
          else
          {
            l2 = l1;
            if (!QLog.isColorLevel()) {
              return;
            }
            l2 = l1;
            QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
          }
        }
        else
        {
          l2 = paramLong;
          ((TVK_IMediaPlayer)this.mMediaPlayer.get()).seekTo((int)paramLong);
        }
        l2 = paramLong;
        this.mCompleted = false;
        l2 = paramLong;
        if (this.mPlayCallerType == 0)
        {
          l2 = paramLong;
          if (!this.mPlaySucReported)
          {
            l2 = paramLong;
            if (this.mUinType == 0)
            {
              l2 = paramLong;
              ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
              l2 = paramLong;
              this.mPlaySucReported = true;
            }
            else
            {
              l2 = paramLong;
              if (this.mUinType == 3000)
              {
                l2 = paramLong;
                ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
                l2 = paramLong;
                this.mPlaySucReported = true;
              }
              else
              {
                l2 = paramLong;
                if (this.mUinType == 1)
                {
                  l2 = paramLong;
                  ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
                  l2 = paramLong;
                  this.mPlaySucReported = true;
                }
                else
                {
                  l2 = paramLong;
                  ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
                  l2 = paramLong;
                  this.mPlaySucReported = true;
                }
              }
            }
          }
        }
        l2 = paramLong;
        if (this.mStartPlayTime >= 0L)
        {
          l2 = paramLong;
          this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
        }
        l2 = paramLong;
        this.mStartPlayTime = System.currentTimeMillis();
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("#play#, msec=");
        ((StringBuilder)localObject2).append(l2);
        QLog.d("ShortVideoPlayActivity", 1, ((StringBuilder)localObject2).toString(), localException);
        reset();
        handleError(0, 0);
        return;
      }
      label1567:
      int i = 0;
    }
    return;
  }
  
  void releaseMediaPlayer()
  {
    WeakReference localWeakReference = this.mMediaPlayer;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((TVK_IMediaPlayer)this.mMediaPlayer.get()).stop();
      ((TVK_IMediaPlayer)this.mMediaPlayer.get()).release();
      ((TVK_IMediaPlayer)this.mMediaPlayer.get()).removeAllListener();
      this.mMediaPlayer = null;
    }
    changePlayState(0);
  }
  
  protected void reportDownloadVideo(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.getNetTypeStr(NetworkUtil.getSystemNetwork(this.mContext));
    if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008))
    {
      if (paramMessageForShortVideo.istroop == 3000)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
        return;
      }
      if (paramMessageForShortVideo.istroop == 1)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void reset()
  {
    changePlayState(0);
  }
  
  boolean resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    boolean bool2 = false;
    WeakReference localWeakReference = this.mMediaPlayer;
    boolean bool1 = bool2;
    if (localWeakReference != null)
    {
      bool1 = bool2;
      if (localWeakReference.get() != null)
      {
        bool1 = bool2;
        if (this.mPlayState == 2)
        {
          ((TVK_IMediaPlayer)this.mMediaPlayer.get()).start();
          changePlayState(1);
          bool1 = true;
        }
      }
    }
    if (this.mStartPlayTime >= 0L) {
      this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
    }
    this.mStartPlayTime = System.currentTimeMillis();
    return bool1;
  }
  
  void setProgressTime(long paramLong)
  {
    if (this.mProgressTime != null)
    {
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      this.mProgressTime.setText(ShortVideoUtils.stringForTime(l));
    }
  }
  
  protected void shareToPC()
  {
    String str = AppConstants.DATALINE_PC_UIN;
    Intent localIntent = getIntentForStartForwardRecentActivity();
    localIntent.putExtra("toUin", str);
    localIntent.putExtra("uinType", 6000);
    localIntent.setClass(this.mContext, DirectForwardActivity.class);
    localIntent.putExtra("forward_filepath", getVideoPath());
    localIntent.putExtra("forward_extra", getVideoPath());
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    this.mContext.startActivity(localIntent);
  }
  
  protected void showActionSheet()
  {
    String str2 = getResources().getString(2131719114);
    String str3 = getResources().getString(2131719115);
    String str4 = getResources().getString(2131719074);
    String str5 = getResources().getString(2131719093);
    String str6 = getResources().getString(2131690728);
    String str1;
    if (this.mPlayCallerType == 0) {
      str1 = SVUtils.a(this.mMsg, "mp4");
    } else {
      str1 = this.mVideoPath;
    }
    boolean bool1 = FileUtils.fileExists(str1);
    boolean bool2 = this.mNeedDownload;
    int i = 0;
    if (bool2) {
      bool1 = false;
    }
    bool2 = "1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1"));
    if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
      i = 1;
    }
    ActionSheet localActionSheet = ActionSheet.create(this);
    if ((bool2) && (this.mUinType != 9501) && (i == 0)) {
      localActionSheet.addButton(str2);
    }
    MessageForShortVideo localMessageForShortVideo = this.mMsg;
    if ((localMessageForShortVideo != null) && (localMessageForShortVideo.videoFileStatus != 5001)) {
      localActionSheet.addButton(str3);
    }
    if (this.mPlayCallerType != 3) {
      if (bool1)
      {
        localActionSheet.addButton(str4);
        localActionSheet.addButton(str5);
      }
      else
      {
        localActionSheet.addButton(str4, 7);
        localActionSheet.addButton(str5, 7);
      }
    }
    localActionSheet.addCancelButton(str6);
    localActionSheet.show();
    localActionSheet.setOnButtonClickListener(new ShortVideoPlayActivity.22(this, localActionSheet, str2, str1, str3, bool1, str4, str1, str5));
  }
  
  public void showAnimation()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick surfaceView, mHidden=");
      localStringBuilder.append(this.mHidden);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    if (this.mHidden)
    {
      startShowing();
      delayStartHiding();
    }
  }
  
  public void showErrorDlg(String paramString)
  {
    if (this.mHandler.get() != null) {
      ((MqqHandler)this.mHandler.get()).post(new ShortVideoPlayActivity.14(this, paramString));
    }
  }
  
  void showLoadingImage()
  {
    Object localObject1 = this.mMsg;
    if (localObject1 != null)
    {
      localObject1 = SVUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(-16777216);
          localObject1 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
          this.mCoverIV.setImageDrawable((Drawable)localObject1);
        }
        catch (Exception localException)
        {
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("showLoadingImage crashed =");
            ((StringBuilder)localObject2).append(localException.toString());
            QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject2).toString());
          }
        }
        this.mCoverIV.setVisibility(0);
      }
    }
  }
  
  void showLoadingView()
  {
    if (this.mLoadingText.getVisibility() != 0) {
      this.mLoadingText.setVisibility(0);
    }
  }
  
  void showNetAlertDlg()
  {
    showDialogSafe(DialogUtil.a(this, 232, null, getString(2131719096), new ShortVideoPlayActivity.23(this), new ShortVideoPlayActivity.24(this)));
  }
  
  void startHiding()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startHiding : mHidden = ");
      localStringBuilder.append(this.mHidden);
      localStringBuilder.append(",playState:");
      localStringBuilder.append(getPlayStateStr(this.mPlayState));
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    if (this.mHidden) {
      return;
    }
    if (this.mPlayState != 1) {
      return;
    }
    this.mHidden = true;
    if (((this.mOperatorBar.getVisibility() == 0) || (this.mTitleBar.getVisibility() == 0)) && (Build.VERSION.SDK_INT >= 11))
    {
      this.mValueAnimator.cancel();
      this.mValueAnimator.start();
    }
  }
  
  void startShowing()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startShowing : mHidden = ");
      localStringBuilder.append(this.mHidden);
      QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    if (!this.mHidden) {
      return;
    }
    if (this.mHandler.get() != null) {
      ((MqqHandler)this.mHandler.get()).removeCallbacks(this.mStartHidingRunnable);
    }
    this.mOperatorBar.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.mOperatorBar.setAlpha(1.0F);
    }
    this.mTitleBar.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.mTitleBar.setAlpha(1.0F);
    }
    this.mHidden = false;
  }
  
  void userBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "userBackPressed");
    }
    releaseMediaPlayer();
    setResult(-1, getIntent());
    finish();
    try
    {
      overridePendingTransition(2130772065, 2130772067);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MediaPlayer] overridePendingTransition=");
        localStringBuilder.append(localException);
        QLog.d("ShortVideoPlayActivity", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */