package com.tencent.mobileqq.activity.shortvideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.video.LocalVideoMediaPlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

@RoutePage(desc="短视频预览页面", path="/base/album/shortvideopreview")
public class ShortVideoPreviewActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  static final String C_TAG = "VideoCompressTask";
  public static final int DEST_TYPE_AIO = 0;
  public static final int DEST_TYPE_DATALINE = 4;
  public static final int DEST_TYPE_HEALTH = 7;
  public static final int DEST_TYPE_MP = 8;
  public static final int DEST_TYPE_QZONE = 1;
  public static final int DEST_TYPE_QZONE_VIDEO = 3;
  public static final int DEST_TYPE_TROOP_BAR = 2;
  public static final int DEST_TYPE_TROOP_REWARD = 5;
  public static final int DEST_TYPE_UP_MASTER = 10;
  public static final int DEST_TYPE_WEB = 6;
  public static final String INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY = "INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY";
  private static final String KEY_SIZE_AFTER_COMPRESS = "size_after_compress";
  private static final String KEY_THUMB_DIR = "thumb_dir";
  private static final String KEY_VIDEO_DIR = "video_dir";
  public static final String PREVIEW_ONLY = "preview_only";
  public static final int REQUEST_READINJOY_UGC_VIDEO_DELIVER = 101;
  static final String STATE_PLAY_POSITION = "state_play_position";
  static final String STATE_PLAY_STATE = "state_play_state";
  static final String TAG = "ShortVideoPreviewActivity";
  public static int mNoCompress;
  int duration = -1;
  String localImagePath;
  Bitmap mBitmap;
  SurfaceHolder.Callback mCallback = new ShortVideoPreviewActivity.4(this);
  TextView mCancelBtn;
  private IMediaPlayer.OnCompletionListener mCompleteListener = new ShortVideoPreviewActivity.7(this);
  ImageView mCover;
  int mDestType;
  long mDuration;
  String mFileSource;
  int mHeightInfo;
  boolean mIsFromSystemMedia;
  boolean mIsSupportVideoCheckbox;
  IMediaPlayer mMediaPlayer = new LocalVideoMediaPlayer();
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new ShortVideoPreviewActivity.22(this);
  ImageView mOperatorBtn;
  private IMediaPlayer.OnPlayStateListener mPlayStateListener = new ShortVideoPreviewActivity.8(this);
  private IMediaPlayer.OnPreparedListener mPreparedListener = new ShortVideoPreviewActivity.6(this);
  boolean mPreviewOnly = false;
  int mSavedCurPosition;
  int mSavedPlayState;
  BroadcastReceiver mScreenReceiver = new ShortVideoPreviewActivity.1(this);
  ArrayList<String> mSelectedVideoAndPhotoList;
  TextView mSendBtn;
  SurfaceView mSurfaceView;
  int mSurfaceViewHeight;
  int mSurfaceViewWidth;
  String mUin;
  int mUinType;
  String mVideoPath;
  long mVideoSize;
  int mWidthInfo;
  ImageView operatorBtnSeekBar;
  TextView progressTimeMp;
  LinearLayout seekBarLayout;
  SeekBar seekBarMp;
  TextView totalTimeMp;
  final MqqHandler updateBarHandler = new ShortVideoPreviewActivity.20(this);
  Runnable updateSeekBarThread = new ShortVideoPreviewActivity.21(this);
  
  public static HashMap<String, String> CompressPosition(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString);
    Object localObject1;
    int i;
    if ((localVideoConverterConfig != null) && (localVideoConverterConfig.isNeedCompress))
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject1 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject1).setDataSource(paramString);
        Object localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(9);
        ((MediaMetadataRetriever)localObject1).release();
        long l = Long.parseLong((String)localObject2);
        i = (int)(localVideoConverterConfig.srcBitrate * 1024L);
        j = (int)localVideoConverterConfig.srcFrameRate;
        localObject1 = "VideoCompressTask";
        localObject2 = new ShortVideoPreviewActivity.HWCompressProcessor(str, i, j, 0L, l);
        VideoConverter localVideoConverter = new VideoConverter(new VideoConverterLog());
        localVideoConverter.setCompressMode(1);
        i = localVideoConverter.startCompress(paramContext, paramString, (VideoConverter.Processor)localObject2, true);
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d((String)localObject1, 2, "CompressTask, step: compress completed using MediaCodec");
          }
          j = 0;
          break label232;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CompressTask, step: compress failed using MediaCodec, compressRet:");
          ((StringBuilder)localObject2).append(i);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      int j = -1;
      label232:
      localObject1 = str;
      i = j;
      if (j != 0)
      {
        localObject1 = str;
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          i = ShortVideoTrimmer.compressVideo(paramContext, paramString, str, localVideoConverterConfig);
          localObject1 = str;
        }
      }
    }
    else if ((localVideoConverterConfig != null) && (!localVideoConverterConfig.isNeedCompress))
    {
      i = 0;
      localObject1 = paramString;
    }
    else
    {
      i = -1;
      localObject1 = str;
    }
    localHashMap.put("outputPath", localObject1);
    localHashMap.put("ret", String.valueOf(i));
    return localHashMap;
  }
  
  /* Error */
  public static String coverToLocalImage(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 280	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 344	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   12: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: ldc_w 346
    //   20: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: new 348	java/io/File
    //   27: dup
    //   28: aload_3
    //   29: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 354	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokespecial 356	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 359	java/io/File:exists	()Z
    //   45: ifne +9 -> 54
    //   48: aload 5
    //   50: invokevirtual 362	java/io/File:mkdirs	()Z
    //   53: pop
    //   54: invokestatic 368	java/lang/System:currentTimeMillis	()J
    //   57: lstore_1
    //   58: aconst_null
    //   59: astore 8
    //   61: aconst_null
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 7
    //   67: aconst_null
    //   68: astore_3
    //   69: aconst_null
    //   70: astore 4
    //   72: aload_0
    //   73: ifnull +290 -> 363
    //   76: new 280	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   83: astore_3
    //   84: aload_3
    //   85: lload_1
    //   86: invokestatic 371	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   89: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_3
    //   94: ldc_w 373
    //   97: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: new 348	java/io/File
    //   104: dup
    //   105: aload 5
    //   107: aload_3
    //   108: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 376	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   114: astore 9
    //   116: aload 8
    //   118: astore_3
    //   119: aload 9
    //   121: invokevirtual 379	java/io/File:createNewFile	()Z
    //   124: ifeq +103 -> 227
    //   127: aload 8
    //   129: astore_3
    //   130: aload 9
    //   132: invokevirtual 382	java/io/File:getPath	()Ljava/lang/String;
    //   135: astore 5
    //   137: aload 8
    //   139: astore_3
    //   140: new 384	java/io/FileOutputStream
    //   143: dup
    //   144: aload 9
    //   146: invokevirtual 382	java/io/File:getPath	()Ljava/lang/String;
    //   149: invokespecial 385	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   152: astore 4
    //   154: aload_0
    //   155: getstatic 391	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   158: bipush 100
    //   160: aload 4
    //   162: invokevirtual 397	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   165: pop
    //   166: aload 5
    //   168: astore_0
    //   169: goto +66 -> 235
    //   172: astore_0
    //   173: aload 4
    //   175: astore_3
    //   176: goto +177 -> 353
    //   179: astore_3
    //   180: aload 5
    //   182: astore_0
    //   183: aload_3
    //   184: astore 5
    //   186: goto +78 -> 264
    //   189: astore_3
    //   190: aload 5
    //   192: astore_0
    //   193: aload_3
    //   194: astore 5
    //   196: goto +139 -> 335
    //   199: astore_3
    //   200: aload 5
    //   202: astore_0
    //   203: aload 6
    //   205: astore 4
    //   207: aload_3
    //   208: astore 5
    //   210: goto +54 -> 264
    //   213: astore_3
    //   214: aload 5
    //   216: astore_0
    //   217: aload 7
    //   219: astore 4
    //   221: aload_3
    //   222: astore 5
    //   224: goto +111 -> 335
    //   227: aconst_null
    //   228: astore_3
    //   229: aload 4
    //   231: astore_0
    //   232: aload_3
    //   233: astore 4
    //   235: aload_0
    //   236: astore_3
    //   237: aload 4
    //   239: ifnull +124 -> 363
    //   242: aload 4
    //   244: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   247: aload_0
    //   248: astore_3
    //   249: goto +114 -> 363
    //   252: astore_0
    //   253: goto +100 -> 353
    //   256: astore 5
    //   258: aconst_null
    //   259: astore_0
    //   260: aload 6
    //   262: astore 4
    //   264: aload 4
    //   266: astore_3
    //   267: new 280	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   274: astore 6
    //   276: aload 4
    //   278: astore_3
    //   279: aload 6
    //   281: ldc_w 402
    //   284: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 4
    //   290: astore_3
    //   291: aload 6
    //   293: aload 5
    //   295: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 4
    //   301: astore_3
    //   302: ldc 17
    //   304: iconst_1
    //   305: aload 6
    //   307: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 408	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: astore_3
    //   315: aload 4
    //   317: ifnull +46 -> 363
    //   320: aload 4
    //   322: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   325: aload_0
    //   326: areturn
    //   327: astore 5
    //   329: aconst_null
    //   330: astore_0
    //   331: aload 7
    //   333: astore 4
    //   335: aload 4
    //   337: astore_3
    //   338: aload 5
    //   340: invokevirtual 411	java/lang/OutOfMemoryError:printStackTrace	()V
    //   343: aload_0
    //   344: astore_3
    //   345: aload 4
    //   347: ifnull +16 -> 363
    //   350: goto -30 -> 320
    //   353: aload_3
    //   354: ifnull +7 -> 361
    //   357: aload_3
    //   358: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   361: aload_0
    //   362: athrow
    //   363: aload_3
    //   364: areturn
    //   365: astore_3
    //   366: aload_0
    //   367: astore_3
    //   368: goto -5 -> 363
    //   371: astore_3
    //   372: aload_0
    //   373: areturn
    //   374: astore_3
    //   375: goto -14 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramBitmap	Bitmap
    //   57	29	1	l	long
    //   7	169	3	localObject1	Object
    //   179	5	3	localException1	Exception
    //   189	5	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   199	9	3	localException2	Exception
    //   213	9	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   228	136	3	localObject2	Object
    //   365	1	3	localException3	Exception
    //   367	1	3	localBitmap	Bitmap
    //   371	1	3	localException4	Exception
    //   374	1	3	localException5	Exception
    //   70	276	4	localObject3	Object
    //   38	185	5	localObject4	Object
    //   256	38	5	localException6	Exception
    //   327	12	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   62	244	6	localStringBuilder	StringBuilder
    //   65	267	7	localObject5	Object
    //   59	79	8	localObject6	Object
    //   114	31	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   154	166	172	finally
    //   154	166	179	java/lang/Exception
    //   154	166	189	java/lang/OutOfMemoryError
    //   140	154	199	java/lang/Exception
    //   140	154	213	java/lang/OutOfMemoryError
    //   119	127	252	finally
    //   130	137	252	finally
    //   140	154	252	finally
    //   267	276	252	finally
    //   279	288	252	finally
    //   291	299	252	finally
    //   302	313	252	finally
    //   338	343	252	finally
    //   119	127	256	java/lang/Exception
    //   130	137	256	java/lang/Exception
    //   119	127	327	java/lang/OutOfMemoryError
    //   130	137	327	java/lang/OutOfMemoryError
    //   242	247	365	java/lang/Exception
    //   320	325	371	java/lang/Exception
    //   357	361	374	java/lang/Exception
  }
  
  private void handleSendVideo2Dataline()
  {
    this.mVideoSize = new File(this.mVideoPath).length();
    if ((NetworkUtil.isNetworkAvailable(this)) && (!NetworkUtil.isWifiConnected(this)) && (this.mVideoSize > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131889584, 2131889589, new ShortVideoPreviewActivity.17(this));
      return;
    }
    sendVideo();
    setResult(-1);
  }
  
  private void sendVideo()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME");
    String str1 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME");
    Object localObject = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      localObject = str2;
      if (str2 == null) {
        return;
      }
    }
    localIntent.setClassName(str1, (String)localObject);
    localIntent.putExtra("file_send_path", this.mVideoPath);
    localIntent.putExtra("file_send_duration", this.mDuration);
    localIntent.putExtra("file_send_size", this.mVideoSize);
    localIntent.putExtra("uin", this.mUin);
    localIntent.putExtra("uintype", this.mUinType);
    localIntent.putExtra("file_source", this.mFileSource);
    localIntent.putExtra("start_init_activity_after_sended", true);
    if (!this.mIsFromSystemMedia) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("custom_shortvideopreview_sendbtn_reportActionName")))
    {
      str2 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportActionName");
      str1 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportReverse2");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      if (str2 != null) {
        ReportController.b(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public static void showAlertDialog(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new ShortVideoPreviewActivity.18(), null).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    initData(super.getIntent());
    if (paramBundle != null)
    {
      this.mSavedPlayState = paramBundle.getInt("state_play_state");
      this.mSavedCurPosition = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCreate(), mSavedCurPosition : ");
        ((StringBuilder)localObject).append(this.mSavedCurPosition);
        ((StringBuilder)localObject).append(",mSavedPlayState : ");
        ((StringBuilder)localObject).append(getPlayStateStr(this.mSavedPlayState));
        QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    super.setContentView(2131627843);
    this.mSurfaceView = ((SurfaceView)findViewById(2131446641));
    this.mSurfaceView.getHolder().setType(3);
    this.mSurfaceView.getHolder().addCallback(this.mCallback);
    this.mSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new ShortVideoPreviewActivity.2(this));
    this.mCover = ((ImageView)findViewById(2131431458));
    this.mCancelBtn = ((TextView)findViewById(2131430273));
    this.mCancelBtn.setOnClickListener(this);
    this.mSendBtn = ((TextView)findViewById(2131445570));
    this.mSendBtn.setOnClickListener(this);
    this.mOperatorBtn = ((ImageView)findViewById(2131439679));
    this.mOperatorBtn.setOnClickListener(this);
    this.seekBarLayout = ((LinearLayout)findViewById(2131439382));
    this.progressTimeMp = ((TextView)findViewById(2131440736));
    this.totalTimeMp = ((TextView)findViewById(2131447788));
    this.operatorBtnSeekBar = ((ImageView)findViewById(2131439680));
    this.operatorBtnSeekBar.setImageResource(2130847780);
    this.operatorBtnSeekBar.setOnClickListener(this);
    this.seekBarMp = ((SeekBar)findViewById(2131445498));
    this.seekBarMp.setVisibility(0);
    this.seekBarMp.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mCover.getViewTreeObserver().addOnGlobalLayoutListener(new ShortVideoPreviewActivity.3(this));
    updateUIByDestType();
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.mScreenReceiver, (IntentFilter)localObject);
    if (this.mDestType == 10)
    {
      if (paramBundle == null)
      {
        play(0);
        return true;
      }
      if (this.mSavedPlayState == 1) {
        play(this.mSavedCurPosition);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.updateBarHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacks(this.updateSeekBarThread);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    releaseMediaPlayer();
    localObject = this.mBitmap;
    if (localObject != null)
    {
      if (!((Bitmap)localObject).isRecycled()) {
        this.mBitmap.recycle();
      }
      this.mBitmap = null;
    }
    unregisterReceiver(this.mScreenReceiver);
  }
  
  int getPlayState()
  {
    return this.mMediaPlayer.c();
  }
  
  String getPlayStateStr(int paramInt)
  {
    return LocalVideoMediaPlayer.b(paramInt);
  }
  
  void handleSendVideo()
  {
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
    this.mVideoSize = new File(this.mVideoPath).length();
    if (i != 0)
    {
      if (Utils.c() > 512000L)
      {
        boolean bool;
        if ((SVBusiUtil.c != 0L) && (System.currentTimeMillis() - SVBusiUtil.c < 300000L)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("upload video isConfirmed=");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(" allowUploadInXGTime=");
          ((StringBuilder)localObject).append(SVBusiUtil.c);
          QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((NetworkUtil.isMobileNetWork(this)) && (!bool))
        {
          long l = this.mVideoSize;
          if (l >= 1048576L)
          {
            localObject = ShortVideoUtils.stringForFileSize(this, l);
            localObject = String.format(getResources().getString(2131916620), new Object[] { localObject });
            ShortVideoPreviewActivity.13 local13 = new ShortVideoPreviewActivity.13(this);
            if (!FreeWifiHelper.a(this, 4, new ShortVideoPreviewActivity.14(this, local13))) {
              break label299;
            }
            DialogUtil.a(this, 232, null, (String)localObject, new ShortVideoPreviewActivity.15(this, local13), new ShortVideoPreviewActivity.16(this)).show();
            return;
          }
        }
        sendVideo();
      }
      else
      {
        showAlertDialog(this, 2131916644);
      }
      label299:
      return;
    }
    QQToast.makeText(this, 1, 2131916075, 0).show(getTitleBarHeight());
  }
  
  void initData(Intent paramIntent)
  {
    this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
    this.mDuration = paramIntent.getExtras().getLong("file_send_duration");
    this.mVideoSize = paramIntent.getExtras().getLong("file_send_size");
    this.mWidthInfo = paramIntent.getIntExtra("file_width", 0);
    this.mHeightInfo = paramIntent.getIntExtra("file_height", 0);
    paramIntent.removeExtra("file_width");
    paramIntent.removeExtra("file_height");
    this.mUin = paramIntent.getExtras().getString("uin");
    this.mUinType = paramIntent.getIntExtra("uintype", -1);
    this.mFileSource = paramIntent.getStringExtra("file_source");
    this.mPreviewOnly = paramIntent.getBooleanExtra("preview_only", false);
    this.mIsFromSystemMedia = paramIntent.getBooleanExtra("is_from_system_media", true);
    this.mIsSupportVideoCheckbox = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.mIsSupportVideoCheckbox) {
      this.mSelectedVideoAndPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (paramIntent == null) {
      this.mDestType = -1;
    } else if ((!paramIntent.contains("SplashActivity")) && (!paramIntent.contains("ChatActivity")))
    {
      if ((!paramIntent.contains("QZonePublishMoodTabActivity")) && (!paramIntent.contains("QZonePublishMoodRealActivity")))
      {
        if (paramIntent.contains("QZoneUploadPhotoRealActivity")) {
          this.mDestType = 1;
        } else if (bool1) {
          this.mDestType = 2;
        } else if (bool2) {
          this.mDestType = 5;
        } else if (paramIntent.contains("TrimVideoActivity")) {
          this.mDestType = 3;
        } else if (paramIntent.contains("LiteActivity")) {
          this.mDestType = 4;
        } else if ((!paramIntent.contains("QQBrowserActivity")) && (!paramIntent.contains("PublicAccountBrowser")))
        {
          if (paramIntent.contains("ReadInJoyDeliverVideoActivity")) {
            this.mDestType = 10;
          } else {
            this.mDestType = 0;
          }
        }
        else {
          this.mDestType = 6;
        }
      }
      else {
        this.mDestType = 1;
      }
    }
    else {
      this.mDestType = 0;
    }
    if (!TextUtils.isEmpty(this.mVideoPath))
    {
      int i = this.mDestType;
      if (((i == 2) || (i == 6) || (i == 10) || (!TextUtils.isEmpty(this.mUin))) && (FileUtils.fileExistsAndNotEmpty(this.mVideoPath))) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
      }
      QQToast.makeText(this, 2131916627, 0).show();
      super.finish();
    }
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    int i;
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131445570: 
      i = this.mDestType;
      if (i != 0)
      {
        if (i != 1)
        {
          double d;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  if (i != 7) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoPreviewActivity", 2, "ldStart Compress");
                  }
                  mNoCompress = -1;
                  new ShortVideoPreviewActivity.VideoCompressTask(this, this).execute(new String[] { this.mVideoPath });
                  break;
                }
                localObject = super.getIntent();
                ((Intent)localObject).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
                ((Intent)localObject).putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
                ((Intent)localObject).putExtra("file_send_duration", this.mDuration);
                localArrayList = new ArrayList();
                localArrayList.add(this.mVideoPath);
                d = this.mVideoSize;
                Double.isNaN(d);
                DialogUtil.a(this, 232, null, getString(2131895519, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(d / 1024.0D / 1024.0D) }) }), new ShortVideoPreviewActivity.9(this, (Intent)localObject, localArrayList), new ShortVideoPreviewActivity.10(this)).show();
                break;
              }
              handleSendVideo2Dataline();
              break;
            }
          }
          else
          {
            d = this.mVideoSize;
            Double.isNaN(d);
            DialogUtil.a(this, 232, null, getString(2131895519, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(d / 1024.0D / 1024.0D) }) }), new ShortVideoPreviewActivity.11(this), new ShortVideoPreviewActivity.12(this)).show();
            localObject = new Intent("key_video_select_apply_click");
            ((Intent)localObject).putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
            sendBroadcast((Intent)localObject);
            break;
          }
        }
        localObject = super.getIntent();
        ((Intent)localObject).putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        ((Intent)localObject).putExtra("PhotoConst.VIDEO_SIZE", this.mVideoSize);
        ((Intent)localObject).putExtra("file_send_duration", this.mDuration);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mVideoPath);
        PhotoUtils.sendPhoto(this, (Intent)localObject, localArrayList, 2, false);
      }
      else
      {
        handleSendVideo();
      }
      break;
    case 2131439680: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClick: mPlayState = ");
        ((StringBuilder)localObject).append(getPlayStateStr(getPlayState()));
        QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (this.mSavedPlayState == 2)
      {
        i = this.mSavedCurPosition;
        if (i > 0)
        {
          play(i);
          this.mSavedPlayState = 0;
          this.mSavedCurPosition = 0;
          break;
        }
      }
      i = getPlayState();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              play(0);
            }
          }
          else
          {
            this.operatorBtnSeekBar.setImageResource(2130847780);
            resume();
          }
        }
        else
        {
          this.operatorBtnSeekBar.setImageResource(2130847779);
          pause();
        }
      }
      else if (this.app.isVideoChatting()) {
        QQToast.makeText(this, 0, 2131916633, 0).show();
      } else {
        play(0);
      }
      break;
    case 2131439679: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleClick: mPlayState = ");
        ((StringBuilder)localObject).append(getPlayStateStr(getPlayState()));
        QLog.d("ShortVideoPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (this.mSavedPlayState == 2)
      {
        i = this.mSavedCurPosition;
        if (i > 0)
        {
          play(i);
          this.mSavedPlayState = 0;
          this.mSavedCurPosition = 0;
          break;
        }
      }
      i = getPlayState();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              play(0);
            }
          }
          else {
            resume();
          }
        }
        else {
          pause();
        }
      }
      else if (this.app.isVideoChatting()) {
        QQToast.makeText(this, 0, 2131916633, 0).show();
      } else {
        play(0);
      }
      break;
    case 2131430273: 
      super.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((getPlayState() == 1) || (getPlayState() == 2)) {
      this.mSavedCurPosition = this.mMediaPlayer.g();
    }
    this.mSavedPlayState = getPlayState();
    paramBundle.putInt("state_play_state", getPlayState());
    paramBundle.putInt("state_play_position", this.mSavedCurPosition);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSaveInstanceState: mSavedCurPosition: ");
      paramBundle.append(this.mSavedCurPosition);
      paramBundle.append(" ,playState = ");
      paramBundle.append(getPlayStateStr(getPlayState()));
      QLog.d("ShortVideoPreviewActivity", 2, paramBundle.toString());
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  void pause()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    this.mMediaPlayer.e();
  }
  
  void play(int paramInt)
  {
    if (!FileUtils.fileExistsAndNotEmpty(this.mVideoPath))
    {
      QQToast.makeText(this, 2131916627, 0).show();
      return;
    }
    this.mMediaPlayer.a(this.mCompleteListener);
    this.mMediaPlayer.a(this.mPreparedListener);
    this.mMediaPlayer.a(this.mPlayStateListener);
    if (this.mMediaPlayer.a(this.mVideoPath, paramInt))
    {
      if (VersionUtils.b()) {
        ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
      if (this.mDestType == 10) {
        return;
      }
      try
      {
        this.mMediaPlayer.a(this.mSurfaceView.getHolder());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ShortVideoPreviewActivity", 1, "play exception:", localException);
        return;
      }
    }
    DialogUtil.a(this, 232, null, getString(2131916653), new ShortVideoPreviewActivity.5(this), null).show();
  }
  
  void releaseMediaPlayer()
  {
    IMediaPlayer localIMediaPlayer = this.mMediaPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.f();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    this.mMediaPlayer.b();
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  public void run()
  {
    this.mBitmap = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath);
    runOnUiThread(new ShortVideoPreviewActivity.19(this));
  }
  
  void updateUIByDestType()
  {
    Object localObject = this.mSendBtn;
    if (localObject != null)
    {
      int i = this.mDestType;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            ((TextView)localObject).setText(2131892267);
          } else {
            ((TextView)localObject).setText(2131895050);
          }
        }
        else {
          ((TextView)localObject).setText(2131892267);
        }
      }
      else
      {
        localObject = new StringBuilder(HardCodeUtil.a(2131911494));
        if (this.mIsSupportVideoCheckbox)
        {
          ArrayList localArrayList = this.mSelectedVideoAndPhotoList;
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(this.mSelectedVideoAndPhotoList.size());
            ((StringBuilder)localObject).append(")");
          }
        }
        this.mSendBtn.setText((CharSequence)localObject);
      }
      if (this.mPreviewOnly)
      {
        this.mSendBtn.setVisibility(8);
        localObject = this.mCancelBtn;
        if (localObject != null) {
          ((TextView)localObject).setText(2131916399);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */