package com.tencent.mobileqq.armap;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class OpenBoxActivity
  extends ARMapBaseActivity
  implements View.OnClickListener, CameraSurfaceView.CameraSurfaceViewCallBack
{
  static final int MSG_SHOW_LOADING_PROGRESS = 1001;
  public static final String TAG = "OpenBoxActivity";
  ArMapObserver mARMapObserver = new OpenBoxActivity.4(this);
  private String mBannerPath;
  private String mBusiJumpUrl;
  private String mBusinessName;
  private CameraSurfaceView mCameraSurfaceView;
  private int mDistance;
  private ARGLSurfaceView mGLSurfaceView;
  Handler mHandler = new Handler(Looper.getMainLooper(), new OpenBoxActivity.1(this));
  private String mLogoPath;
  boolean mNeedFreshPOI;
  private long mPoiId;
  ARMapOpenPOIDialog mPrizeDialog;
  private QQProgressDialog mProgressDialog;
  ARMapOpenRedPackDialog mRedPackDialog;
  private String mResPath;
  SimpleSensorChangeListener mSensor = new OpenBoxActivity.2(this);
  private long mTaskId;
  private int mTaskType;
  private String mWishing;
  TextView tvAnim;
  
  private void hideLoadingProgress()
  {
    if ((this.mProgressDialog != null) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  private void hidePrizeInfoDialog()
  {
    if ((this.mPrizeDialog != null) && (this.mPrizeDialog.isShowing()) && (!isFinishing())) {
      this.mPrizeDialog.dismiss();
    }
    if ((this.mRedPackDialog != null) && (this.mRedPackDialog.isShowing()) && (!isFinishing())) {
      this.mRedPackDialog.dismiss();
    }
  }
  
  private void initSurface()
  {
    this.mGLSurfaceView.getHolder().setFormat(-3);
    this.mGLSurfaceView.init(this, this.mResPath, 14);
    this.mGLSurfaceView.initSensor(this.mSensor, 2);
    this.mGLSurfaceView.setZOrderMediaOverlay(true);
    this.mGLSurfaceView.onResume();
    this.mGLSurfaceView.resumeSensor();
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
  
  private void showPrizeInfoDialog(ItemInfo paramItemInfo)
  {
    if ((paramItemInfo == null) || (isFinishing())) {
      return;
    }
    if (this.mTaskType == 7)
    {
      if (this.mRedPackDialog == null) {
        this.mRedPackDialog = new ARMapOpenRedPackDialog(this, this.app);
      }
      for (;;)
      {
        this.mRedPackDialog.a(this.mBusinessName, this.mLogoPath, this.mBannerPath, this.mWishing, paramItemInfo);
        this.mRedPackDialog.show();
        return;
        if (this.mRedPackDialog.isShowing()) {
          this.mRedPackDialog.dismiss();
        }
      }
    }
    if (this.mPrizeDialog == null) {
      this.mPrizeDialog = new ARMapOpenPOIDialog(this);
    }
    for (;;)
    {
      this.mPrizeDialog.a(paramItemInfo);
      this.mPrizeDialog.show();
      return;
      if (this.mPrizeDialog.isShowing()) {
        this.mPrizeDialog.dismiss();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130970237);
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
    this.mGLSurfaceView = ((ARGLSurfaceView)findViewById(2131365953));
    this.mCameraSurfaceView = ((CameraSurfaceView)findViewById(2131369585));
    this.mCameraSurfaceView.setCameraSurfaceCallBack(this);
    findViewById(2131369710).setOnClickListener(this);
    this.tvAnim = ((TextView)findViewById(2131369711));
    initSurface();
    addObserver(this.mARMapObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.mCameraSurfaceView.c();
    this.mGLSurfaceView.onDestroy();
    this.mGLSurfaceView.stopSensor();
    this.mCameraSurfaceView.setCameraSurfaceCallBack(null);
    removeObserver(this.mARMapObserver);
    hidePrizeInfoDialog();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.mCameraSurfaceView.c();
    this.mGLSurfaceView.onPause();
    this.mGLSurfaceView.stopSensor();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mGLSurfaceView.onResume();
    this.mGLSurfaceView.resumeSensor();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  public int getBoxType()
  {
    getIntent().getIntExtra("task_type", 0);
    return 0;
  }
  
  public void nativeCallback(int paramInt1, int paramInt2) {}
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("flag_refresh_poi", false);
    setResult(-1, localIntent);
    super.finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369710) {
      this.mGLSurfaceView.runOnGlThread(new OpenBoxActivity.3(this));
    }
  }
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (!paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.OpenBoxActivity
 * JD-Core Version:    0.7.0.1
 */