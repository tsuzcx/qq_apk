package com.tencent.aelight.camera.ae.play;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.ColorDrawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.AEPath;
import com.tencent.aelight.camera.ae.AEPath.PLAY.FILES;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge;
import com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class AEVideoShelfPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface, IVideoShelfPlayerListener
{
  private static final int AUDIO_UPDATE_PROGRESS_TIME = 200;
  public static final String FROM = "from";
  public static final String FROM_FLAG_BACK_FROM_QUDONG_TO_AIO = "FROM_FLAG_BACK_FROM_QUDONG_TO_AIO";
  private static final long INTERVAL_UPDATE_PROGRESS = 200L;
  public static final String IS_NEED_EDIT_BTN = "isNeedEditButton";
  private static final double PROCESS_STEP = 0.3D;
  public static final int REQUEST_CODE_EDIT = 22;
  private static final int STATUS_NONE = 0;
  private static final int STATUS_PLAY = 2;
  private static final int STATUS_READY = 1;
  private static final String TAG = "AEVideoShelfPreviewFragment";
  private static final int VIDEO_DEFAULT_HEIGHT = 960;
  private static final int VIDEO_DEFAULT_WIDTH = 540;
  private static PowerManager.WakeLock wakeLock;
  private Button editButton;
  private boolean isFromNewVideo = false;
  private String mAudioPath;
  private volatile boolean mCancelGenerateByUser = false;
  private Dialog mDialog;
  private VideoShelfEngine mEngine;
  private long mGenerateBegin;
  private boolean mHadEncodedStart = false;
  private String mInputVideo;
  private boolean mIsFirstVideoPlay = true;
  private boolean mIsNeedEditBtn = false;
  private boolean mIsNeedShowdialog = false;
  private boolean mIsPagPreview = false;
  private boolean mIsVideoComplete = false;
  private int mJumpFrom;
  private long mLastUpdateProgressTimeMs = 0L;
  private String mMaterialId;
  private String mMaterialName;
  private int mOutVideoHeight;
  private int mOutVideoWidth;
  private HashMap<String, int[]> mPagSettings;
  private TextView mPlayerRateView;
  private double mSaveDialogProcessLowValue = 0.0D;
  private double mSaveDialogProgress = 0.0D;
  private ArrayList<String> mSelectedPhotoList;
  private String mTakeSameName;
  private String mTemplatePath;
  private Timer mTimer;
  private String mVideoPath;
  private View playButton;
  ProgressPieDrawable ppd;
  private int status = 0;
  private View videoGroup;
  private VideoShelfPlayView videoView;
  
  private void bindData(Intent paramIntent)
  {
    if (this.mIsNeedEditBtn) {
      this.editButton.setVisibility(0);
    } else {
      this.editButton.setVisibility(8);
    }
    if (this.mJumpFrom == 2) {
      this.editButton.setVisibility(8);
    }
    this.videoView.setVideoType(this.mIsPagPreview ^ true);
    this.mIsVideoComplete = false;
    boolean bool1;
    if (this.mIsPagPreview)
    {
      bool1 = pagFileInit(paramIntent);
    }
    else
    {
      this.mInputVideo = paramIntent.getStringExtra("FinalVideoPath");
      boolean bool2 = TextUtils.isEmpty(this.mInputVideo) ^ true;
      bool1 = bool2;
      if (bool2)
      {
        this.videoView.setVideoFilePath(this.mInputVideo);
        this.mIsVideoComplete = true;
        this.mVideoPath = this.mInputVideo;
        bool1 = bool2;
      }
    }
    if (bool1) {
      this.videoView.start();
    }
  }
  
  private ProgressPieDrawable createProgressPie()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getBaseActivity());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, getBaseActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new AEVideoShelfPreviewFragment.3(this));
    return localProgressPieDrawable;
  }
  
  private void dismissProgressDialog()
  {
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  private void finishAudioVideoMerge()
  {
    if (this.mEngine == null) {
      return;
    }
    Object localObject1 = this.mAudioPath;
    if (localObject1 != null) {
      localObject1 = new File((String)localObject1);
    } else {
      localObject1 = null;
    }
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = AEVideoShelfEditFragment.hasStoragePermission(BaseApplicationImpl.getContext());
    }
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      localObject1 = this.mAudioPath;
      if ((localObject1 != null) && (((String)localObject1).toLowerCase().endsWith(".m4a")))
      {
        if (bool)
        {
          localObject1 = AEPath.a(AEPath.a());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AEPath.PLAY.FILES.f);
          ((StringBuilder)localObject1).append(File.separator);
          localObject1 = AEPath.a(((StringBuilder)localObject1).toString());
        }
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("outputDir: ");
        localStringBuilder.append((String)localObject1);
        Object localObject2;
        if (new File((String)localObject1).exists()) {
          localObject2 = " exist";
        } else {
          localObject2 = " not exist";
        }
        localStringBuilder.append((String)localObject2);
        AEQLog.b(str, localStringBuilder.toString());
        this.mTimer = new Timer();
        this.mTimer.schedule(new AEVideoShelfPreviewFragment.7(this), 0L, 200L);
        if (HwVideoMerge.a(this.mEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
        {
          localObject2 = new File(this.mEngine.getOutputVideoPath());
          if (((File)localObject2).exists())
          {
            AEQLog.b(TAG, "finishAudioVideoMerge done");
            ((File)localObject2).delete();
          }
          this.mVideoPath = ((String)localObject1);
        }
        this.mTimer.cancel();
        this.mTimer = null;
      }
    }
    if ((bool) && (this.mVideoPath != null)) {
      com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.mVideoPath));
    }
  }
  
  public static Bitmap getVideoThumbnail(String paramString, int paramInt1, int paramInt2)
  {
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt2);
    int i = paramString.getWidth();
    paramInt2 = paramString.getHeight();
    if (i > paramInt1)
    {
      double d1 = paramInt2;
      Double.isNaN(d1);
      double d2 = paramInt1;
      Double.isNaN(d2);
      double d3 = i;
      Double.isNaN(d3);
      paramInt2 = (int)(d1 * 1.0D * d2 / d3);
    }
    else
    {
      paramInt1 = i;
    }
    return ThumbnailUtils.extractThumbnail(paramString, paramInt1, paramInt2, 2);
  }
  
  private void initData(Intent paramIntent)
  {
    this.mIsFirstVideoPlay = true;
    this.mJumpFrom = paramIntent.getIntExtra("jump_in_from", 0);
    this.mTemplatePath = paramIntent.getStringExtra("MaterialPath");
    this.mMaterialName = paramIntent.getStringExtra("MaterialName");
    this.mMaterialId = paramIntent.getStringExtra("MaterialId");
    if (TextUtils.isEmpty(this.mTakeSameName)) {
      this.mTakeSameName = paramIntent.getStringExtra("loc_play_show_take_same_name");
    }
    getBaseActivity().getIntent().putExtra("key_camera_material_name", this.mTakeSameName);
    this.mSelectedPhotoList = paramIntent.getStringArrayListExtra("PhotoList");
    this.isFromNewVideo = paramIntent.getBooleanExtra("from", true);
    this.mIsNeedEditBtn = paramIntent.getBooleanExtra("isNeedEditButton", false);
    this.mIsPagPreview = paramIntent.getBooleanExtra("usePagPreview", false);
  }
  
  @TargetApi(14)
  private void initProgressDialog()
  {
    this.mDialog = new Dialog(getBaseActivity());
    Object localObject = this.mDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.mDialog.requestWindowFeature(1);
    this.mDialog.setContentView(2131628207);
    localObject = (ImageView)this.mDialog.findViewById(2131440726);
    this.ppd = createProgressPie();
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.ppd);
    }
    ((TextView)this.mDialog.findViewById(2131438908)).setText(2064187599);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new AEVideoShelfPreviewFragment.2(this));
    this.ppd.d(0);
  }
  
  private void initView()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getBaseActivity().getWindow();
      if (localObject != null) {
        ((Window)localObject).setStatusBarColor(-16777216);
      }
    }
    this.mPlayerRateView = ((TextView)getBaseActivity().findViewById(2063991318));
    this.mPlayerRateView.setText("0(fps)");
    this.mPlayerRateView.setTextColor(-65536);
    this.videoGroup = getBaseActivity().findViewById(2063991580);
    this.videoGroup.setOnClickListener(this);
    this.videoView = ((VideoShelfPlayView)this.videoGroup.findViewById(2063991583));
    this.videoView.setOnPlayerListener(this);
    this.playButton = this.videoGroup.findViewById(2063991315);
    this.editButton = ((Button)getBaseActivity().findViewById(2063991023));
    this.editButton.setOnClickListener(this);
    this.videoView.getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfPreviewFragment.1(this));
    getBaseActivity().findViewById(2063990900).setOnClickListener(this);
    Object localObject = (TextView)getBaseActivity().findViewById(2063990925);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setText(2064187586);
    initProgressDialog();
  }
  
  private void jumpToEditFragment()
  {
    if (this.mJumpFrom == 2)
    {
      getBaseActivity().finish();
      return;
    }
    AEVideoShelfEditFragment.jumpToMeForResult(getBaseActivity(), 22, this.mTemplatePath, this.mMaterialId, this.mMaterialName, this.mSelectedPhotoList, 3);
  }
  
  public static void jumpToMe(Context paramContext, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("jump_in_from", paramInt);
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AEVideoShelfPreviewFragment.class);
  }
  
  public static void keepScreenOn(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870922, TAG);
      wakeLock.acquire();
      AEQLog.b(TAG, "keepScreenOn!");
      return;
    }
    paramContext = wakeLock;
    if (paramContext != null)
    {
      paramContext.release();
      wakeLock = null;
    }
    AEQLog.b(TAG, "keepScreenOff!");
  }
  
  private void onCancelCompleted()
  {
    AEQLog.b(TAG, "Merge Video step onCancelCompleted");
    this.mGenerateBegin = 0L;
    this.mHadEncodedStart = false;
    this.mIsNeedShowdialog = false;
    Object localObject = this.mEngine.getOutputVideoPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        AEQLog.b(TAG, "onCancelCompleted---delete temp video because user cancel");
      }
    }
    UiThreadUtil.a(new AEVideoShelfPreviewFragment.10(this));
    this.mIsVideoComplete = false;
  }
  
  private void onError(int paramInt1, int paramInt2, String paramString)
  {
    AEQLog.c(TAG, "Merge Video step onError");
    this.mGenerateBegin = 0L;
    onError(paramInt1, paramString, null);
    this.mHadEncodedStart = false;
    keepScreenOn(getBaseActivity(), false);
  }
  
  private void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastUpdateProgressTimeMs > 200L)
    {
      UiThreadUtil.a(new AEVideoShelfPreviewFragment.9(this, paramInt));
      this.mLastUpdateProgressTimeMs = l;
    }
  }
  
  private void onStartGenerate()
  {
    AEQLog.b(TAG, "Merge Video step onStartGenerate");
    this.mGenerateBegin = System.currentTimeMillis();
    UiThreadUtil.a(new AEVideoShelfPreviewFragment.8(this));
  }
  
  private boolean pagFileInit(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.videoView != null))
    {
      this.mInputVideo = paramIntent.getStringExtra("pagFilePath");
      this.mAudioPath = paramIntent.getStringExtra("audioFilePath");
      if (paramIntent.getBooleanExtra("isFromAsset", false))
      {
        if (!TextUtils.isEmpty(this.mAudioPath)) {
          this.videoView.setAudioPathFromAsset(this.mAudioPath, getBaseActivity().getAssets());
        }
        if (!TextUtils.isEmpty(this.mInputVideo))
        {
          this.videoView.setVideoFilePathFromAsset(this.mInputVideo, getBaseActivity().getAssets());
        }
        else
        {
          AEQLog.c(TAG, "pagFileInit Asset Path error");
          return false;
        }
      }
      else
      {
        if (!TextUtils.isEmpty(this.mAudioPath)) {
          this.videoView.setAudioPath(this.mAudioPath);
        }
        if (TextUtils.isEmpty(this.mInputVideo)) {
          break label242;
        }
        this.videoView.setVideoFilePath(this.mInputVideo);
      }
      Object localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getSerializable("nodeImgList");
        if ((localObject instanceof HashMap))
        {
          this.mPagSettings = ((HashMap)localObject);
          this.videoView.setParam("imgGroup", new Object[] { this.mPagSettings });
        }
      }
      this.mOutVideoWidth = paramIntent.getIntExtra("videoOutWidth", 540);
      this.mOutVideoHeight = paramIntent.getIntExtra("videoOutHeight", 960);
      return true;
      label242:
      AEQLog.c(TAG, "pagFileInit not Asset Path error");
      return false;
    }
    AEQLog.c(TAG, "pagFileInit error");
    return false;
  }
  
  private void pauseVideo()
  {
    this.status = 1;
    this.videoView.pause();
    this.playButton.setVisibility(0);
    this.mPlayerRateView.setText("0(fps)");
  }
  
  private void playVideo()
  {
    this.status = 2;
    this.videoView.resume();
    this.playButton.setVisibility(8);
  }
  
  private void saveVideoTemplate()
  {
    if (this.videoView == null) {
      return;
    }
    if (this.mEngine == null) {
      try
      {
        this.mEngine = new VideoShelfEngine(false);
        VideoShelfEngine localVideoShelfEngine = this.mEngine;
        if (localVideoShelfEngine == null) {
          return;
        }
      }
      catch (PagNotSupportSystemException localPagNotSupportSystemException)
      {
        this.mEngine = null;
        AEQLog.d(TAG, localPagNotSupportSystemException.getMessage());
        UiThreadUtil.a(new AEVideoShelfPreviewFragment.11(this), 2000L);
        return;
      }
    }
    Object localObject = this.videoView.getPlayer();
    if ((localObject instanceof PagShelfPlayer))
    {
      localObject = (PagShelfPlayer)localObject;
      this.mEngine.setSrcPath(this.mInputVideo);
      this.mEngine.setParam("PagVideoShelfProcessor_4", this.mPagSettings);
      this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
      this.mEngine.setCallback(new AEVideoShelfPreviewFragment.EngineCallback(this));
      this.mEngine.save(this.mOutVideoWidth, this.mOutVideoHeight);
      this.mHadEncodedStart = true;
    }
  }
  
  private void sendVideo()
  {
    if (AETemplateInfoFragment.getFromType(getContext()) == AECameraEntry.e.a())
    {
      AEQLog.b(TAG, "sendVideo--aio case");
      Intent localIntent = new Intent(getContext(), QIMCameraCaptureActivity.class);
      localIntent.putExtra("FROM_FLAG_BACK_FROM_QUDONG_TO_AIO", "");
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("thumbfile_send_path", getThumbPath());
      localIntent.putExtra("file_send_path", this.mVideoPath);
      ShortVideoForwardManager.a(getActivity(), localIntent);
      startActivity(localIntent);
      return;
    }
    AEQLog.b(TAG, "sendVideo--non aio case");
    ShortVideoForwardManager.a(getBaseActivity(), this.mVideoPath, getThumbPath(), AECameraEntryManager.c(getBaseActivity()), "caller_aecamera");
  }
  
  private void showDialogIfNeed()
  {
    UiThreadUtil.a(new AEVideoShelfPreviewFragment.6(this));
  }
  
  private void showProgressDialog()
  {
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.show();
    }
  }
  
  private void toggleVideoStatus()
  {
    if (2 == this.status)
    {
      pauseVideo();
      return;
    }
    playVideo();
  }
  
  private void updateProgress(int paramInt)
  {
    ProgressPieDrawable localProgressPieDrawable = this.ppd;
    if (localProgressPieDrawable == null) {
      return;
    }
    localProgressPieDrawable.b();
    this.ppd.d(paramInt);
    this.ppd.b(true);
    this.ppd.d(false);
    localProgressPieDrawable = this.ppd;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localProgressPieDrawable.a(localStringBuilder.toString());
  }
  
  public String getThumbPath()
  {
    Bitmap localBitmap = getVideoThumbnail(this.mVideoPath, 300, 1);
    Object localObject = new File(AEPath.PLAY.FILES.e);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEPath.PLAY.FILES.e);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(Md5Utils.getMD5(this.mVideoPath));
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(new File((String)localObject));
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    return null;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22)
    {
      if (paramInt2 == -1)
      {
        initData(paramIntent);
        bindData(paramIntent);
      }
    }
    else if (paramInt1 == 21)
    {
      AEBaseDataReporter.a().a(this.mMaterialId);
      if (paramInt2 == -1)
      {
        if ((!AECameraEntryManager.c(getBaseActivity())) && (!AECameraEntryManager.g(getBaseActivity().getIntent()))) {
          paramIntent = new Intent(getBaseActivity(), SplashActivity.class);
        } else {
          paramIntent = new Intent(getBaseActivity(), QzoneFeedsPluginProxyActivity.class);
        }
        paramIntent.addFlags(67108864);
        paramIntent.addFlags(536870912);
        startActivity(paramIntent);
      }
    }
  }
  
  public void onBackPressed()
  {
    getBaseActivity().finish();
    AEBaseDataReporter.a().e();
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2063991580: 
      toggleVideoStatus();
      return;
    case 2063991023: 
      jumpToEditFragment();
      AEBaseDataReporter.a().m();
      return;
    case 2063990925: 
      if (!this.mIsVideoComplete)
      {
        pauseVideo();
        this.mIsNeedShowdialog = true;
        if (!this.mHadEncodedStart)
        {
          saveVideoTemplate();
          return;
        }
        showDialogIfNeed();
        return;
      }
      sendVideo();
      return;
    }
    onBackPressed();
  }
  
  public void onCompletion()
  {
    long l;
    if (this.mGenerateBegin > 0L) {
      l = System.currentTimeMillis() - this.mGenerateBegin;
    } else {
      l = 0L;
    }
    this.mGenerateBegin = 0L;
    finishAudioVideoMerge();
    UiThreadUtil.a(new AEVideoShelfPreviewFragment.5(this, l));
    this.mHadEncodedStart = false;
    this.mIsVideoComplete = true;
    AEQLog.b(TAG, "Merge Video step onCompletion");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056366, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    Object localObject = this.mPagSettings;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = this.mSelectedPhotoList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    this.videoView.setOnPlayerListener(null);
    this.videoView.stop();
    this.videoView = null;
    keepScreenOn(getBaseActivity(), false);
    super.onDestroy();
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    if (-3 == paramInt) {
      return true;
    }
    paramObject = null;
    long l2 = -1L;
    Object localObject = this.mInputVideo;
    if (localObject != null) {
      paramObject = new File((String)localObject);
    }
    long l1 = l2;
    if (paramObject != null)
    {
      l1 = l2;
      if (paramObject.exists())
      {
        l1 = l2;
        if (paramObject.isFile()) {
          l1 = paramObject.length();
        }
      }
    }
    paramObject = this.mInputVideo;
    if (paramObject != null) {
      if (paramObject.contains(File.separator))
      {
        paramObject = this.mInputVideo;
        paramObject = paramObject.substring(0, paramObject.lastIndexOf(File.separator));
        if (new File(paramObject).exists())
        {
          if (com.tencent.ttpic.baseutils.io.FileUtils.canWriteFile(paramObject, false)) {
            i = 0;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else
      {
        i = -1;
      }
    }
    paramObject = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fun video videoShelfPlayView onError: what: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", extra: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", FilePath: ");
    ((StringBuilder)localObject).append(this.mInputVideo);
    ((StringBuilder)localObject).append(", FileSize: ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" dirInfo: ");
    ((StringBuilder)localObject).append(i);
    AEQLog.d(paramObject, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public void onPause()
  {
    Log.i("VideoShelfPlayView", "onPause...");
    pauseVideo();
    if ((this.mHadEncodedStart) || (!this.mIsVideoComplete))
    {
      VideoShelfEngine localVideoShelfEngine = this.mEngine;
      if (localVideoShelfEngine != null) {
        localVideoShelfEngine.cancelSave();
      }
      this.mHadEncodedStart = false;
      this.mIsNeedShowdialog = false;
    }
    super.onPause();
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer)
  {
    if (paramIVideoShelfPlayer == null) {
      return;
    }
    paramIVideoShelfPlayer.setLooping(true);
    this.status = 2;
  }
  
  public void onResume()
  {
    Log.i("VideoShelfPlayView", "onResume...");
    super.onResume();
    this.videoView.flush();
    if (this.mIsFirstVideoPlay)
    {
      int i = this.status;
      if ((2 == i) || (1 == i)) {
        this.videoView.postDelayed(new AEVideoShelfPreviewFragment.4(this), 200L);
      }
      this.mIsFirstVideoPlay = false;
    }
  }
  
  public void onUpdateRate(long paramLong)
  {
    TextView localTextView = this.mPlayerRateView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("(fps)");
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initView();
    paramView = getBaseActivity().getIntent();
    if (paramView == null) {
      return;
    }
    initData(paramView);
    bindData(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment
 * JD-Core Version:    0.7.0.1
 */