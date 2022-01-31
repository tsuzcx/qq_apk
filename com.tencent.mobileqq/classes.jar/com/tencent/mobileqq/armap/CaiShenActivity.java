package com.tencent.mobileqq.armap;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.Camera.PreviewCallback;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class CaiShenActivity
  extends TreasureBaseActivity
  implements CameraSurfaceView.CameraSurfaceViewCallBack
{
  private static final int FIND_CAISHEN_MAX_TIME = 5000;
  private static final int MSG_FIND_CAISHEN_TIMEOUT = 2001;
  private static final int MSG_QUIT = 1100;
  private static final int MSG_REQUEST_TIMEOUT = 1002;
  private static final int MSG_SELECT_TIMEOUT = 1003;
  private static final int MSG_SHOW_LOADING_PROGRESS = 1001;
  public static final String TAG = "CaiShenActivity";
  public static final int TYPE_BOX = 4;
  public static final int TYPE_RED_POCKET = 6;
  public static final int TYPE_RED_POCKET_ENTERPRISE = 7;
  public boolean hasOpen;
  ArMapObserver mARMapObserver = new CaiShenActivity.12(this);
  private long mAdcode;
  private String mBannerPath;
  private String mBusiJumpUrl;
  private String mBusinessName;
  private View mCameraCover;
  private Dialog mCameraNoPermissionDialog;
  private CameraSurfaceView mCameraSurfaceView;
  private int mDistance;
  private ARGLSurfaceView mGLSurfaceView;
  private long mGameResumeTime;
  private long mGameTotalTime;
  Handler mHandler = new Handler(Looper.getMainLooper(), new CaiShenActivity.1(this));
  private boolean mHasReceived;
  private boolean mHolder;
  private ItemInfo mItemInfo;
  private Dialog mItemInfoDialog;
  private String mLogoPath;
  private ARTreasurePlayControl mPlayControl;
  private long mPoiId;
  private boolean mPossible;
  Camera.PreviewCallback mPreviewCallback = new CaiShenActivity.22(this);
  private ProgressDialog mProgressDialog;
  private String mResPath;
  SimpleSensorChangeListener mSensorChangeListener = new CaiShenActivity.6(this);
  private Sound mSound;
  private long mTaskId;
  private int mTaskType;
  private String mTextIconPath;
  private String mWishing;
  public boolean openFailed;
  public boolean openSuccess;
  int renderCount = 0;
  boolean renderisFrist = true;
  private boolean serverRespSuccess;
  private boolean treasureClicked;
  private byte[] yuvData;
  Runnable yuvDataTextureRunnable = new CaiShenActivity.21(this);
  ByteBuffer yuvDateBuffer = null;
  int[] yuvTextur;
  
  private void hideInfoDialog()
  {
    if ((this.mItemInfoDialog != null) && (this.mItemInfoDialog.isShowing()) && (!isFinishing()))
    {
      findViewById(2131369506).setVisibility(8);
      this.mItemInfoDialog.dismiss();
    }
  }
  
  private void hideLoadingProgress()
  {
    if ((this.mProgressDialog != null) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  private void initSurface()
  {
    if (this.mGLSurfaceView == null) {
      return;
    }
    this.mGLSurfaceView.getHolder().setFormat(-3);
    if (this.mTaskType == 4) {
      this.mGLSurfaceView.init(this, this.mResPath, 14);
    }
    for (;;)
    {
      this.mGLSurfaceView.initSensor(this.mSensorChangeListener, 4);
      this.mGLSurfaceView.setZOrderMediaOverlay(true);
      this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.7(this));
      return;
      this.mGLSurfaceView.init(this, this.mResPath, 20);
    }
  }
  
  private void showInfoDialog(ItemInfo paramItemInfo)
  {
    boolean bool = false;
    if ((paramItemInfo == null) || (isFinishing())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("showInfoDialog itemInfo == null ? ");
        if (paramItemInfo == null) {
          bool = true;
        }
        QLog.i("CaiShenActivity", 2, bool);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "showInfoDialog itemInfo: " + paramItemInfo);
      }
      findViewById(2131369506).setVisibility(0);
      if ((this.mTaskType == 6) || (this.mTaskType == 7) || (paramItemInfo.b == 2))
      {
        if (this.mItemInfoDialog == null) {
          this.mItemInfoDialog = new ARMapOpenRedPackDialog(this, this.app);
        }
        for (;;)
        {
          ((ARMapOpenRedPackDialog)this.mItemInfoDialog).a(this.mBusinessName, this.mLogoPath, this.mBannerPath, this.mWishing, paramItemInfo);
          this.mItemInfoDialog.show();
          return;
          if (this.mItemInfoDialog.isShowing()) {
            this.mItemInfoDialog.dismiss();
          }
        }
      }
      if ((this.mTaskType == 4) || (paramItemInfo.b == 4))
      {
        if (this.mItemInfoDialog == null) {
          this.mItemInfoDialog = new ARMapOpenKaquanDialog(this);
        }
        for (;;)
        {
          ((ARMapOpenKaquanDialog)this.mItemInfoDialog).a(this.mBusinessName, this.mLogoPath, paramItemInfo.jdField_a_of_type_JavaLangString, paramItemInfo.c);
          this.mItemInfoDialog.show();
          return;
          if (this.mItemInfoDialog.isShowing()) {
            this.mItemInfoDialog.dismiss();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("CaiShenActivity", 2, "showInfoDialog unkown type: " + this.mTaskType + ", itemInfo: " + paramItemInfo);
  }
  
  private void showLoadingProgress(String paramString)
  {
    if (this.mProgressDialog == null)
    {
      this.mProgressDialog = new ProgressDialog(this, 2131624515);
      this.mProgressDialog.setCanceledOnTouchOutside(false);
      this.mProgressDialog.show();
      this.mProgressDialog.setContentView(2130969181);
    }
    ((TextView)this.mProgressDialog.findViewById(2131363381)).setText(paramString);
    if (!isFinishing()) {
      this.mProgressDialog.show();
    }
  }
  
  private void showNoPermissionView(boolean paramBoolean)
  {
    if (this.mCameraCover == null) {
      return;
    }
    if (paramBoolean)
    {
      Drawable localDrawable = Drawable.createFromPath(this.mResPath + "/no_permission_bg@2x.jpg");
      if (localDrawable != null) {
        this.mCameraCover.setBackgroundDrawable(localDrawable);
      }
      this.mCameraCover.setVisibility(0);
      return;
    }
    this.mCameraCover.setVisibility(8);
  }
  
  public void OnModeSwitchCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "OnModeSwitchCallback");
    }
    this.mPlayControl.a = true;
    if (QLog.isColorLevel()) {
      QLog.i("ARTreasurePlayControl", 2, "initMode when modeswitch ready");
    }
    this.mPlayControl.b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130970191);
    paramBundle = (InterceptTouchEventLayout)findViewById(2131369497);
    paramBundle.setInterceptTouchEventFlag(true);
    paramBundle.setInterceptTouchEventListener(new CaiShenActivity.2(this));
    paramBundle = (Button)findViewById(2131369500);
    paramBundle.setOnClickListener(new CaiShenActivity.3(this));
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusDrawable(null);
      int i = ImmersiveUtils.a(this);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      localLayoutParams.topMargin = (i + localLayoutParams.topMargin);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.mTaskId = paramBundle.getLongExtra("task_id", 0L);
      this.mPoiId = paramBundle.getLongExtra("poi_id", 0L);
      this.mTaskType = paramBundle.getIntExtra("task_type", 0);
      this.mBusinessName = paramBundle.getStringExtra("business_name");
      this.mDistance = paramBundle.getIntExtra("distance", 0);
      this.mResPath = paramBundle.getStringExtra("resPath");
      this.mLogoPath = paramBundle.getStringExtra("logoPath");
      this.mTextIconPath = paramBundle.getStringExtra("textIconPath");
      this.mBannerPath = paramBundle.getStringExtra("bannerPath");
      this.mWishing = paramBundle.getStringExtra("wishing");
      this.mAdcode = paramBundle.getLongExtra("adcode", 0L);
      this.mBusiJumpUrl = paramBundle.getStringExtra("business_url");
    }
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "mTaskId: " + this.mTaskId + ", mPoiId: " + this.mPoiId + ", mTaskType: " + this.mTaskType + ", mBusinessName: " + this.mBusinessName + ", mResPath: " + this.mResPath + ", logoPath: " + this.mLogoPath + ", textIconPath: " + this.mTextIconPath + ", bannerPath: " + this.mBannerPath + ", wishing: " + this.mWishing);
    }
    this.mGLSurfaceView = ((ARGLSurfaceView)findViewById(2131365921));
    this.mCameraSurfaceView = ((CameraSurfaceView)findViewById(2131369498));
    this.mCameraSurfaceView.setPreviewCallback(this.mPreviewCallback);
    this.mCameraSurfaceView.setCameraSurfaceCallBack(this);
    this.mCameraSurfaceView.setDisplay(getWindowManager().getDefaultDisplay());
    this.mCameraCover = findViewById(2131369499);
    initSurface();
    initGuide(this.mResPath, this.mHandler);
    initArrowImageView(this.mResPath);
    addObserver(this.mARMapObserver);
    this.mSound = new Sound();
    if (this.mTaskType != 4)
    {
      this.mSound.a(this.mResPath + "/res/caishen/hello.mp3");
      this.mSound.a(this.mResPath + "/res/caishen/show.mp3");
      this.mSound.a(this.mResPath + "/res/caishen/guess.mp3");
      this.mSound.a(this.mResPath + "/res/caishen/unlucky.mp3");
      this.mSound.a(this.mResPath + "/res/caishen/repeat.mp3");
      this.mSound.a(this.mResPath + "/res/caishen/lucky.mp3");
      this.mPlayControl = new ARTreasurePlayControl(this, this.mGLSurfaceView, this.mTaskType);
      if ((this.mTaskType != 6) && (this.mTaskType != 7)) {
        break label916;
      }
      ((ArMapHandler)this.app.a(2)).a(this.mTaskId, this.mPoiId, 1, 2, this.mDistance);
      if (this.mPlayControl.e) {
        showGuide();
      }
      this.mHandler.sendEmptyMessageDelayed(2001, 5000L);
    }
    for (;;)
    {
      if (!NetworkUtil.d(this))
      {
        QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
        bool = false;
      }
      return bool;
      this.mSound.a(this.mResPath + "/res/box/unlucky.mp3");
      this.mSound.a(this.mResPath + "/res/box/repeat.mp3");
      break;
      label916:
      if (this.mTaskType == 4)
      {
        if (this.mGLSurfaceView != null) {
          this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.4(this));
        }
        this.mPossible = true;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.mTaskType == 7)
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A37", "0X8007A37", 0, 0, String.valueOf(this.mGameTotalTime), "", "", "");
      if (!this.hasOpen) {
        ReportController.b(null, "dc01440", "", "", "0X8007A45", "0X8007A45", 0, 0, "", "", "", "");
      }
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mCameraSurfaceView.c();
    this.mGLSurfaceView.onDestroy();
    this.mGLSurfaceView.stopSensor();
    this.mCameraSurfaceView.setCameraSurfaceCallBack(null);
    removeObserver(this.mARMapObserver);
    hideInfoDialog();
    this.mSound.c();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.mGameTotalTime += System.currentTimeMillis() - this.mGameResumeTime;
    this.mSound.b();
    this.mCameraSurfaceView.c();
    this.mGLSurfaceView.onPause();
    this.mGLSurfaceView.stopSensor();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (sIsLoadSoSuc)
    {
      this.mGLSurfaceView.onResume();
      this.mGLSurfaceView.resumeSensor();
    }
    for (;;)
    {
      this.mCameraSurfaceView.b();
      this.mSound.a();
      this.mGameResumeTime = System.currentTimeMillis();
      return;
      this.mGLSurfaceView.onPause();
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230, null, "资源加载失败！", getResources().getString(2131438732), "", null, new CaiShenActivity.8(this));
      localQQCustomDialog.setOnDismissListener(new CaiShenActivity.9(this));
      localQQCustomDialog.show();
    }
  }
  
  void drawYuvToTexture(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (this.yuvDateBuffer == null) {
      this.yuvDateBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    }
    if ((this.yuvDateBuffer == null) || (paramArrayOfByte == null)) {
      return;
    }
    this.yuvDateBuffer.position(0);
    this.yuvDateBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    this.yuvDateBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, this.yuvDateBuffer);
    this.yuvDateBuffer.position(0);
    this.yuvDateBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
    this.yuvDateBuffer.position(0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramArrayOfInt[1]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, this.yuvDateBuffer);
  }
  
  public void finish()
  {
    if (this.mTaskType == 7) {
      this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.11(this));
    }
    if ((this.mHolder) && (this.mPossible) && (this.mItemInfo != null)) {}
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("task_id", String.valueOf(this.mTaskId));
      ((JSONObject)localObject).put("item_id", this.mItemInfo.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("sig", this.mItemInfo.f);
      ((JSONObject)localObject).put("status", false);
      ((ArMapHandler)this.app.a(2)).a(3L, ((JSONObject)localObject).toString());
      this.mPossible = false;
      this.mHolder = false;
      localObject = new Intent();
      ((Intent)localObject).putExtra("flag_refresh_poi", false);
      ((Intent)localObject).putExtra("flag_open_failed", this.openFailed);
      ((Intent)localObject).putExtra("flag_open_success", this.openSuccess);
      ((Intent)localObject).putExtra("poi_id", this.mPoiId);
      ((Intent)localObject).putExtra("task_id", this.mTaskId);
      ((Intent)localObject).putExtra("task_type", this.mTaskType);
      if (this.mTaskType == 6) {
        ((Intent)localObject).putExtra("open_status", this.mHasReceived);
      }
      ((Intent)localObject).putExtra("flag_has_open", this.hasOpen);
      ((Intent)localObject).putExtra("flag_server_resp_success", this.serverRespSuccess);
      setResult(-1, (Intent)localObject);
      super.finish();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("CaiShenActivity", 2, "finish report", localException);
        }
      }
    }
  }
  
  protected void initGuide(String paramString, Handler paramHandler)
  {
    this.mGuideTips = ((TextView)findViewById(2131369505));
    this.mGuideLayout = findViewById(2131369502);
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapManager.a(paramString + "/phone.png");
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    if (localObject != null) {
      ((ImageView)findViewById(2131369503)).setImageBitmap((Bitmap)localObject);
    }
    try
    {
      paramString = BitmapManager.a(paramString + "/arrow_up.png");
      localObject = paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramString = (ImageView)findViewById(2131369504);
    if (localObject != null) {
      paramString.setImageBitmap((Bitmap)localObject);
    }
    localObject = AnimationUtils.loadAnimation(this, 2131034318);
    ((Animation)localObject).setAnimationListener(new CaiShenActivity.5(this, paramString, paramHandler, (Animation)localObject));
    paramString.startAnimation((Animation)localObject);
  }
  
  public void nativeCallback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "nativeCallback type: " + paramInt1 + ", value: " + paramInt2);
    }
    switch (paramInt1)
    {
    case 4: 
    default: 
    case 1: 
      do
      {
        return;
        Object localObject;
        if (this.mTaskType == 7)
        {
          if (paramInt2 != 0)
          {
            localObject = "1";
            ReportController.b(null, "dc01440", "", "", "0X8007A36", "0X8007A36", 0, 0, (String)localObject, "", "", "");
          }
        }
        else
        {
          if (this.mHandler.hasMessages(1003)) {
            this.mHandler.removeMessages(1003);
          }
          this.treasureClicked = true;
          if (paramInt2 == 0) {
            break label555;
          }
          this.hasOpen = true;
          if (!this.mPossible) {
            break;
          }
          localObject = (ArMapHandler)this.app.a(2);
          if (this.mItemInfo != null) {
            break label287;
          }
          ((ArMapHandler)localObject).a(this.mTaskId, this.mPoiId, 0, 2, this.mDistance);
          this.mHandler.sendEmptyMessageDelayed(1001, 2000L);
        }
        for (;;)
        {
          if ((this.mTaskType != 6) && (this.mTaskType != 7)) {
            break label441;
          }
          ReportController.b(null, "dc01440", "", "", "0X800784C", "0X800784C", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "1");
          return;
          localObject = "0";
          break;
          if (this.mHolder)
          {
            try
            {
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("task_id", String.valueOf(this.mTaskId));
              localJSONObject2.put("item_id", this.mItemInfo.jdField_a_of_type_Int);
              localJSONObject2.put("sig", this.mItemInfo.f);
              localJSONObject2.put("status", true);
              ((ArMapHandler)localObject).a(3L, localJSONObject2.toString());
              this.mHandler.sendEmptyMessageDelayed(1001, 2000L);
              this.mHolder = false;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.e("CaiShenActivity", 2, "report", localException1);
              }
            }
            if (this.mGLSurfaceView != null) {
              this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.13(this));
            }
          }
        }
      } while (this.mTaskType != 4);
      ReportController.b(null, "dc01440", "", "", "0X8007850", "0X8007850", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "");
      return;
      if (this.mGLSurfaceView != null) {
        this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.14(this));
      }
      ReportController.b(null, "dc01440", "", "", "0X800784C", "0X800784C", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "3");
      return;
      if ((this.mHolder) && (this.mPossible) && (this.mItemInfo != null)) {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("task_id", String.valueOf(this.mTaskId));
          localJSONObject1.put("item_id", this.mItemInfo.jdField_a_of_type_Int);
          localJSONObject1.put("sig", this.mItemInfo.f);
          localJSONObject1.put("status", false);
          ((ArMapHandler)this.app.a(2)).a(3L, localJSONObject1.toString());
          this.mHandler.sendEmptyMessageDelayed(1001, 2000L);
          this.mPossible = false;
          this.mHolder = false;
          ReportController.b(null, "dc01440", "", "", "0X800784C", "0X800784C", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "2");
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("CaiShenActivity", 2, "report", localException2);
            }
            if (this.mGLSurfaceView != null) {
              this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.15(this));
            }
          }
        }
      }
      if (this.mGLSurfaceView != null) {
        this.mGLSurfaceView.runOnGlThread(new CaiShenActivity.16(this));
      }
      ReportController.b(null, "dc01440", "", "", "0X800784C", "0X800784C", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "3");
      return;
    case 2: 
      if (this.mItemInfo != null)
      {
        runOnUiThread(new CaiShenActivity.17(this));
        return;
      }
      runOnUiThread(new CaiShenActivity.18(this));
      this.mHandler.sendEmptyMessageDelayed(1100, 3000L);
      return;
    case 3: 
      label287:
      label441:
      if (QLog.isColorLevel()) {
        QLog.i("ARTreasurePlayControl", 2, "caishen found");
      }
      label555:
      this.mPlayControl.c = true;
      this.mPlayControl.b = true;
      this.mHandler.removeMessages(2001);
      if (paramInt2 == 0) {
        ReportController.b(null, "dc01440", "", "", "0X800784B", "0X800784B", 0, 0, String.valueOf(this.mTaskId), String.valueOf(this.mPoiId), "", "1");
      }
      runOnUiThread(new CaiShenActivity.19(this));
      return;
    }
    ReportController.b(null, "dc01440", "", "", "0X8007A33", "0X8007A33", 0, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onMotionReport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ReportController.b(null, "dc01440", "", "", "0X8007A46", "0X8007A46", 0, 0, String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt4));
  }
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "onStartPreview isSucc:" + paramBoolean + ", tid:" + Thread.currentThread().getId());
    }
    runOnUiThread(new CaiShenActivity.10(this, paramBoolean));
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A3A", "0X8007A3A", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void onTreasureAudioCallback(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "onTreasureAudioCallback type " + paramInt1 + ", operationType:" + paramInt2 + ", mResPath:" + this.mResPath);
    }
    String str;
    if (paramInt2 == 0)
    {
      str = null;
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      try
      {
        Sound localSound = this.mSound;
        if (paramInt1 != 0) {
          break label458;
        }
        localSound.a(str, bool);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label457;
        }
        QLog.i("CaiShenActivity", 2, "onTreasureAudioCallback exception", localException);
      }
      str = this.mResPath + "/res/caishen/caishen.mp3";
      continue;
      if (this.mTaskType != 4)
      {
        str = this.mResPath + "/res/caishen/hello.mp3";
        continue;
        if (this.mTaskType != 4)
        {
          str = this.mResPath + "/res/caishen/show.mp3";
          continue;
          if (this.mTaskType != 4)
          {
            str = this.mResPath + "/res/caishen/guess.mp3";
            continue;
            str = this.mResPath + "/res/caishen/lucky.mp3";
            continue;
            if (this.mTaskType != 4)
            {
              str = this.mResPath + "/res/caishen/unlucky.mp3";
            }
            else
            {
              str = this.mResPath + "/res/box/unlucky.mp3";
              continue;
              if (this.mTaskType != 4)
              {
                str = this.mResPath + "/res/caishen/repeat.mp3";
              }
              else
              {
                str = this.mResPath + "/res/box/repeat.mp3";
                continue;
                if ((paramInt2 == 1) && (paramInt1 == 10))
                {
                  this.mSound.c();
                  return;
                }
                label457:
                return;
                label458:
                bool = false;
              }
            }
          }
        }
      }
    }
  }
  
  public void resizeSurface()
  {
    this.mHandler.post(new CaiShenActivity.20(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity
 * JD-Core Version:    0.7.0.1
 */