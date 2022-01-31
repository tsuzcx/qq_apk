package com.tencent.mobileqq.armap;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.PreviewCallback;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

@TargetApi(11)
public class SupercellActivity
  extends TreasureBaseActivity
  implements View.OnClickListener
{
  private static final int FIND_MAX_TIME = 3000;
  private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  private static final int MSG_FIND_TIMEOUT = 2001;
  private static final int MSG_QUIT = 1100;
  private static final int MSG_SHOW_LOADING_PROGRESS = 1001;
  public static final String TAG = "SupercellActivity";
  private static final int mediaDataCountMax = 10;
  CameraSurfaceView.CameraSurfaceViewCallBack cameraCallBack = new SupercellActivity.13(this);
  private boolean cameraStateOpen;
  int dataCount = 0;
  int dataEndCount = 0;
  public boolean hasOpen;
  boolean isFindSupercell = false;
  boolean isFristData = true;
  boolean isHaveSurfaceTexture = true;
  boolean isStartPlayEnd = false;
  float[] m2 = new float[16];
  ArMapObserver mARMapObserver = new SupercellActivity.9(this);
  private String mBannerPath;
  private String mBusiJumpUrl;
  private String mBusinessName;
  private int mCameraBgTextureId = -1;
  private Dialog mCameraNoPermissionDialog;
  private CameraSurfaceView mCameraSurfaceView;
  Dialog mCardDialog = null;
  private int mDistance;
  private ARGLSurfaceView mGLSurfaceView;
  private long mGameHanlder;
  private boolean mGetCardSuc;
  private Handler mHandler = new Handler(Looper.getMainLooper(), new SupercellActivity.1(this));
  private ItemInfo mItemInfo;
  private String mLogoPath;
  private MediaPlayer mMediaPlayer;
  private MediaPlayer mMediaPlayerEnd;
  private long mPoiId;
  Camera.PreviewCallback mPreviewCallback = new SupercellActivity.19(this);
  private QQProgressDialog mProgressDialog;
  private String mResPath;
  SimpleSensorChangeListener mSensor = new SupercellActivity.6(this);
  private SurfaceTexture mSurface;
  private SurfaceTexture mSurfaceEnd;
  private long mTaskId;
  private int mTaskType;
  private int mTextureID = -1;
  private int mTextureIDEnd = -1;
  private String mWishing;
  private String oldPath;
  int renderCount = 0;
  boolean renderisFrist = true;
  private boolean serverRespSuccess;
  ARGLSurfaceView.SurfaceStateListener surfaceListener = new SupercellActivity.10(this);
  private Runnable updateRunnable = new SupercellActivity.4(this);
  private Runnable updateRunnableEnd = new SupercellActivity.5(this);
  int videoHeight = 1136;
  int videoWidth = 640;
  private byte[] yuvData;
  Runnable yuvDataTextureRunnable = new SupercellActivity.18(this);
  ByteBuffer yuvDateBuffer = null;
  int[] yuvTextur;
  
  public static int checkError()
  {
    int i = GLES20.glGetError();
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d("SupercellActivity", 2, "checkError error 22 = " + i);
    }
    return i;
  }
  
  private String getResPathName(ItemInfo paramItemInfo)
  {
    int i;
    int j;
    if (paramItemInfo != null)
    {
      i = paramItemInfo.b;
      if (i != 6) {
        break label49;
      }
      j = 2;
    }
    for (;;)
    {
      return "type" + j + "/";
      i = 0;
      break;
      label49:
      if (i != 3)
      {
        j = i;
        if (i != 1) {}
      }
      else
      {
        j = 4;
      }
    }
  }
  
  private String getVideoSrcDirectory()
  {
    Object localObject = (ARMapManager)this.app.getManager(209);
    if (localObject != null) {}
    for (localObject = ((ARMapManager)localObject).e() + "/treasure/supercell/";; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      return localObject;
    }
  }
  
  private void hideLoadingProgress()
  {
    if ((this.mProgressDialog != null) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  @TargetApi(11)
  private void initArGLSurface()
  {
    this.mGLSurfaceView.getHolder().setFormat(-3);
    this.mGLSurfaceView.init(this, this.mResPath, 21);
    this.mGLSurfaceView.setZOrderMediaOverlay(true);
    this.mGLSurfaceView.onResume();
    this.mGLSurfaceView.setSurfaceStateListener(this.surfaceListener);
    this.mGLSurfaceView.initSensor(this.mSensor, 4);
    this.mGLSurfaceView.resumeSensor();
    this.mGLSurfaceView.runOnGlThread(new SupercellActivity.7(this));
    this.mGLSurfaceView.runOnGlThread(new SupercellActivity.8(this));
  }
  
  @TargetApi(14)
  private void initGLSurface()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "initGLSurface cameraStateOpen:" + this.cameraStateOpen);
    }
    if (!this.cameraStateOpen) {}
    while ((!this.isFindSupercell) || (this.mMediaPlayer == null) || (!this.isHaveSurfaceTexture)) {
      return;
    }
    if (this.mSurface != null) {
      this.mSurface.setOnFrameAvailableListener(null);
    }
    try
    {
      this.mSurface.release();
      this.mSurface = null;
      if (this.mTextureID < 1)
      {
        localObject = new int[1];
        GLES20.glGenTextures(1, (int[])localObject, 0);
        this.mTextureID = localObject[0];
        if (this.mTextureID < 1) {
          this.mTextureID = 10001;
        }
        GLES20.glBindTexture(36197, this.mTextureID);
        GLES20.glTexParameterf(36197, 10241, 9728.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
      }
      this.mSurface = new SurfaceTexture(this.mTextureID);
      this.mSurface.setOnFrameAvailableListener(new SupercellActivity.11(this));
      localObject = new Surface(this.mSurface);
    }
    catch (Exception localException3)
    {
      try
      {
        Object localObject;
        this.mMediaPlayer.setSurface((Surface)localObject);
        ((Surface)localObject).release();
        this.mMediaPlayer.setScreenOnWhilePlaying(false);
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            this.mMediaPlayer.prepare();
            try
            {
              this.mMediaPlayer.start();
              return;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              ReportController.b(null, "dc01440", "", "", "0X8007A34", "0X8007A34", 0, 0, "", "", "", "");
              return;
            }
            localException2 = localException2;
            localException2.printStackTrace();
          }
          localException3 = localException3;
          localException3.printStackTrace();
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            localException4.printStackTrace();
          }
        }
      }
    }
  }
  
  @TargetApi(14)
  private void initGLSurfaceEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "initGLSurface cameraStateOpen:" + this.cameraStateOpen);
    }
    if (!this.cameraStateOpen) {}
    while ((this.mMediaPlayerEnd == null) || (!this.isHaveSurfaceTexture)) {
      return;
    }
    if (this.mSurfaceEnd != null) {
      this.mSurfaceEnd.setOnFrameAvailableListener(null);
    }
    try
    {
      this.mSurfaceEnd.release();
      this.mSurfaceEnd = null;
      if (this.mTextureIDEnd < 1)
      {
        localObject = new int[1];
        GLES20.glGenTextures(1, (int[])localObject, 0);
        this.mTextureIDEnd = localObject[0];
        if (this.mTextureIDEnd < 1) {
          this.mTextureIDEnd = 10000;
        }
        GLES20.glBindTexture(36197, this.mTextureIDEnd);
        GLES20.glTexParameterf(36197, 10241, 9728.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
      }
      this.mSurfaceEnd = new SurfaceTexture(this.mTextureIDEnd);
      this.mSurfaceEnd.setOnFrameAvailableListener(new SupercellActivity.12(this));
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          localObject = new Surface(this.mSurfaceEnd);
        }
        catch (Exception localException3)
        {
          Object localObject;
          localException3.printStackTrace();
          continue;
        }
        try
        {
          this.mMediaPlayerEnd.setSurface((Surface)localObject);
          this.mMediaPlayerEnd.setScreenOnWhilePlaying(false);
          ((Surface)localObject).release();
          this.mMediaPlayerEnd.setLooping(true);
          this.mMediaPlayerEnd.prepare();
          try
          {
            this.mMediaPlayerEnd.start();
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            ReportController.b(null, "dc01440", "", "", "0X8007A34", "0X8007A34", 0, 0, "", "", "", "");
            return;
          }
          localException2 = localException2;
          localException2.printStackTrace();
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
        }
      }
    }
  }
  
  private void initOpenGLInfo()
  {
    try
    {
      String str = GLES20.glGetString(7939);
      if ((str != null) && (str.length() != 0))
      {
        i = str.indexOf("GL_OES_EGL_image_external");
        if (QLog.isColorLevel())
        {
          QLog.i("SupercellActivity", 2, "glGetString index  " + i);
          QLog.i("SupercellActivity", 2, "glGetString  context " + str);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        localException1.printStackTrace();
      }
      this.isHaveSurfaceTexture = false;
      this.videoWidth = 0;
      this.videoHeight = 0;
      localARGLSurfaceView = this.mGLSurfaceView;
      ARGLSurfaceView.setVideoSize(this.mGameHanlder, this.videoWidth, this.videoHeight);
      if (this.mMediaPlayer == null) {
        break label213;
      }
      this.mMediaPlayer.setOnCompletionListener(null);
    }
    i = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTextureSampler0;\nvoid main(void)\n{\ngl_FragColor = texture2D(uTextureSampler0, vTextureCoord);\n}\n");
    if (i > 0)
    {
      GLES20.glDeleteShader(i);
      this.isHaveSurfaceTexture = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SupercellActivity", 2, "loadShader id  " + i);
      }
      return;
      try
      {
        ARGLSurfaceView localARGLSurfaceView;
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        label213:
        this.mHandler.post(new SupercellActivity.20(this));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  private void showLoadingProgress(String paramString)
  {
    if (this.mProgressDialog == null) {
      this.mProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.mProgressDialog.a(paramString);
    if (!isFinishing()) {
      this.mProgressDialog.show();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, "doOnCreate");
    }
    setContentView(2130970254);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusDrawable(null);
    }
    this.mCameraSurfaceView = ((CameraSurfaceView)findViewById(2131369806));
    this.mCameraSurfaceView.setDisplay(getWindowManager().getDefaultDisplay());
    this.mCameraSurfaceView.setCameraSurfaceCallBack(this.cameraCallBack);
    this.mCameraSurfaceView.setPreviewCallback(this.mPreviewCallback);
    this.mGLSurfaceView = ((ARGLSurfaceView)findViewById(2131369807));
    this.mGLSurfaceView.setOnClickListener(this);
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
      this.mBannerPath = paramBundle.getStringExtra("bannerPath");
      this.mWishing = paramBundle.getStringExtra("wishing");
      this.mBusiJumpUrl = paramBundle.getStringExtra("business_url");
    }
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "mTaskId: " + this.mTaskId + ", mPoiId: " + this.mPoiId + ", mTaskType: " + this.mTaskType + ", mBusinessName: " + this.mBusinessName + ", mResPath: " + this.mResPath + ", logoPath: " + this.mLogoPath + ", bannerPath: " + this.mBannerPath + ", wishing: " + this.mWishing);
    }
    initArGLSurface();
    initGuide(this.mResPath, this.mHandler);
    initArrowImageView(this.mResPath);
    if (!NetworkUtil.d(this)) {
      QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
    }
    for (;;)
    {
      ((Button)findViewById(2131369587)).setOnClickListener(new SupercellActivity.3(this));
      if (ARTreasurePlayControl.a(this)) {
        showGuide();
      }
      this.mHandler.sendEmptyMessageDelayed(2001, 3000L);
      return true;
      showLoadingProgress("正在请求中...");
      addObserver(this.mARMapObserver);
      runOnUiThread(new SupercellActivity.2(this));
    }
  }
  
  @TargetApi(14)
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, "doOnDestroy:  mMediaPlayer  " + this.mMediaPlayer);
    }
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.stop();
    }
    catch (Exception localException5)
    {
      try
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer.setSurface(null);
        this.mMediaPlayer = null;
        if (this.mSurface != null) {
          this.mSurface.setOnFrameAvailableListener(null);
        }
      }
      catch (Exception localException5)
      {
        try
        {
          this.mSurface.release();
          this.mSurface = null;
          this.mGLSurfaceView.removeCallbacks(this.updateRunnable);
          if (this.mMediaPlayerEnd == null) {}
        }
        catch (Exception localException5)
        {
          try
          {
            this.mMediaPlayerEnd.setOnCompletionListener(null);
            this.mMediaPlayerEnd.stop();
          }
          catch (Exception localException5)
          {
            try
            {
              this.mMediaPlayerEnd.release();
              this.mMediaPlayerEnd.setSurface(null);
              this.mMediaPlayerEnd = null;
              if (this.mSurfaceEnd != null) {
                this.mSurfaceEnd.setOnFrameAvailableListener(null);
              }
            }
            catch (Exception localException5)
            {
              try
              {
                for (;;)
                {
                  this.mSurfaceEnd.release();
                  this.mSurfaceEnd = null;
                  this.mGLSurfaceView.removeCallbacks(this.updateRunnableEnd);
                  this.mGLSurfaceView.stopSensor();
                  removeObserver(this.mARMapObserver);
                  this.mGLSurfaceView.onDestroy();
                  this.mCameraSurfaceView.c();
                  this.mCameraSurfaceView.setCameraSurfaceCallBack(null);
                  super.doOnDestroy();
                  return;
                  localException1 = localException1;
                  localException1.printStackTrace();
                  continue;
                  localException2 = localException2;
                  localException2.printStackTrace();
                  continue;
                  localException3 = localException3;
                  localException3.printStackTrace();
                  continue;
                  localException4 = localException4;
                  localException4.printStackTrace();
                }
                localException5 = localException5;
                localException5.printStackTrace();
              }
              catch (Exception localException6)
              {
                for (;;)
                {
                  localException6.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, "doOnPause:  mMediaPlayer  " + this.mMediaPlayer);
    }
    if (this.mMediaPlayerEnd != null) {}
    try
    {
      if (this.mMediaPlayerEnd.isPlaying()) {
        this.mMediaPlayerEnd.pause();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying())) {
            this.mMediaPlayer.pause();
          }
          this.mGLSurfaceView.onPause();
          this.mGLSurfaceView.stopSensor();
          super.doOnPause();
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, "doOnResume:  mMediaPlayer  " + this.mMediaPlayer);
    }
    this.mGLSurfaceView.onResume();
    this.mGLSurfaceView.resumeSensor();
    this.cameraStateOpen = false;
    this.mCameraSurfaceView.b();
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, " doOnStop:  mMediaPlayer  " + this.mMediaPlayer);
    }
    super.doOnStop();
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
    Intent localIntent = new Intent();
    localIntent.putExtra("flag_refresh_poi", false);
    localIntent.putExtra("flag_open_success", this.hasOpen);
    localIntent.putExtra("task_id", this.mTaskId);
    localIntent.putExtra("poi_id", this.mPoiId);
    localIntent.putExtra("task_type", this.mTaskType);
    localIntent.putExtra("flag_has_open", true);
    localIntent.putExtra("flag_server_resp_success", this.serverRespSuccess);
    setResult(-1, localIntent);
    super.finish();
  }
  
  public String getVideoSrcPath(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if ((paramString == null) || (paramString.length == 0)) {
      return null;
    }
    int i = new Random().nextInt(paramString.length);
    int j = 0;
    for (;;)
    {
      j += 1;
      if (j > paramString.length) {
        return null;
      }
      Object localObject = paramString[i];
      if (localObject.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SupercellActivity", 2, "videoFilePath 2 fileName: " + localObject.getName());
        }
        if (localObject.getName().startsWith(".")) {
          i = (i + 1) % paramString.length;
        } else {
          return localObject.getName();
        }
      }
      else
      {
        i = (i + 1) % paramString.length;
      }
    }
  }
  
  protected void initGuide(String paramString, Handler paramHandler)
  {
    this.mGuideTips = ((TextView)findViewById(2131369592));
  }
  
  public boolean initMediaEnd(String paramString)
  {
    if (this.mMediaPlayerEnd != null) {}
    for (;;)
    {
      return true;
      this.mMediaPlayerEnd = new MediaPlayer();
      try
      {
        QLog.d("SupercellActivity", 2, "initMediaEnd videoFilePath:" + paramString);
        boolean bool = new File(paramString).exists();
        if (!bool)
        {
          if (0 != 0) {}
          try
          {
            throw new NullPointerException();
            return false;
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
        this.mMediaPlayerEnd.setDataSource(paramString);
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return true;
        }
        try
        {
          throw new NullPointerException();
          throw paramString;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (0 != 0) {}
        try
        {
          throw new NullPointerException();
          return false;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
      }
      finally
      {
        if (0 == 0) {}
      }
    }
  }
  
  int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt > 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      checkError();
      GLES20.glCompileShader(paramInt);
      checkError();
      paramString = new int[1];
      GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
      checkError();
      if (paramString[0] <= 0) {}
    }
    else
    {
      return paramInt;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "loadShader yesyes  " + paramString[0]);
    }
    GLES20.glDeleteShader(paramInt);
    checkError();
    return 0;
  }
  
  public void nativeCallback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "nativeCallback type: " + paramInt1 + ", value: " + paramInt2);
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      runOnUiThread(new SupercellActivity.14(this));
      return;
    }
    this.mHandler.removeMessages(2001);
    this.mGLSurfaceView.queueEvent(new SupercellActivity.15(this));
    runOnUiThread(new SupercellActivity.16(this));
  }
  
  public void onClick(View paramView) {}
  
  public void resizeSurface()
  {
    this.mHandler.post(new SupercellActivity.17(this));
  }
  
  @TargetApi(14)
  public void showSupercellCard()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SupercellActivity", 2, " showSupercellCard  " + this.mMediaPlayer);
    }
    if ((this.mGetCardSuc) && (this.mItemInfo != null))
    {
      if (this.mItemInfo.b > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SupercellActivity", 2, "showSupercellCard time mMediaPlayer " + this.mMediaPlayer);
        }
        if (this.mMediaPlayer == null) {}
      }
      try
      {
        this.mMediaPlayer.setOnCompletionListener(null);
        this.mMediaPlayer.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.mMediaPlayer.release();
            this.mMediaPlayer.setSurface(null);
            this.mMediaPlayer = null;
            switch (this.mItemInfo.b)
            {
            default: 
              this.hasOpen = false;
              this.mCardDialog = new ARMapOpenCardDialog(this);
              ((ARMapOpenCardDialog)this.mCardDialog).a(this.mItemInfo);
              if (this.mCardDialog != null) {
                break label364;
              }
              finish();
              return;
              localException1 = localException1;
              localException1.printStackTrace();
            }
          }
        }
        catch (Exception localException2)
        {
          label364:
          do
          {
            for (;;)
            {
              localException2.printStackTrace();
              continue;
              this.mCardDialog = new ARMapOpenRedPackDialog(this, this.app);
              ((ARMapOpenRedPackDialog)this.mCardDialog).a(this.mBusinessName, this.mLogoPath, this.mBannerPath, this.mWishing, this.mItemInfo);
              continue;
              this.mCardDialog = new ARMapOpenKaquanDialog(this);
              ((ARMapOpenKaquanDialog)this.mCardDialog).a(this.mBusinessName, this.mLogoPath, this.mItemInfo.a, this.mItemInfo.c);
              continue;
              this.mCardDialog = new ARMapOpenCardDialog(this);
              ((ARMapOpenCardDialog)this.mCardDialog).a(this.mItemInfo);
            }
            if (this.mCardDialog.isShowing()) {
              this.mCardDialog.dismiss();
            }
          } while (isFinishing());
          findViewById(2131369593).setVisibility(0);
          this.mCardDialog.show();
          return;
        }
      }
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity
 * JD-Core Version:    0.7.0.1
 */