package com.qq.im.poi;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Camera.PreviewCallback;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARTreasurePlayControl;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.CameraSurfaceView;
import com.tencent.mobileqq.armap.CameraSurfaceView.CameraSurfaceViewCallBack;
import com.tencent.mobileqq.armap.Sound;
import com.tencent.mobileqq.armap.TreasureBaseActivity;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class LbsCaiShenActivity
  extends TreasureBaseActivity
  implements CameraSurfaceView.CameraSurfaceViewCallBack
{
  private static final int REQUEST_CODE_GRAP = 1;
  public static final String TAG = "LbsPack";
  private int clickCount;
  private View mCameraCover;
  private Dialog mCameraNoPermissionDialog;
  private CameraSurfaceView mCameraSurfaceView;
  private ARGLSurfaceView mGLSurfaceView;
  boolean mGuessSuccess = false;
  private Handler mHandler = new Handler();
  private boolean mHasReport;
  public LbsPackObserver mLbsPackObserver = new LbsCaiShenActivity.9(this);
  private TextView mNickNameView;
  private LbsPackInfo mPackInfo;
  private ARTreasurePlayControl mPlayControl;
  Camera.PreviewCallback mPreviewCallback = new LbsCaiShenActivity.8(this);
  private String mResPath;
  private Sound mSound;
  int renderCount = 0;
  boolean renderisFrist = true;
  private byte[] yuvData;
  Runnable yuvDataTextureRunnable = new LbsCaiShenActivity.7(this);
  ByteBuffer yuvDateBuffer = null;
  int[] yuvTextur;
  
  private void openLbsPackFailReport(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "openLbsPackErrReport, errCount" + paramInt + ", pid:" + this.mPackInfo.jdField_b_of_type_JavaLangString);
    }
    String str = "";
    if (paramInt == 1) {
      str = "0X8007A52";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.b(null, "dc01440", "", "", str, str, 0, 0, "", "", "", this.mPackInfo.jdField_b_of_type_JavaLangString);
      }
      return;
      if (paramInt == 2) {
        str = "0X8007A53";
      }
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
      QLog.i("LbsPack", 2, "OnModeSwitchCallback");
    }
    this.mPlayControl.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("ARTreasurePlayControl", 2, "initMode when modeswitch ready");
    }
    this.mPlayControl.b();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("result");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        label301:
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            paramInt1 = ((JSONObject)localObject).getInt("resultCode");
            String str = ((JSONObject)localObject).getString("retmsg");
            if (QLog.isColorLevel()) {
              QLog.d("LbsPack", 2, "CFT_HB_GRAP_resultCode= " + paramInt1 + "retMsg= " + str);
            }
            if (!((JSONObject)localObject).has("data")) {
              break;
            }
            localObject = ((JSONObject)localObject).getString("data");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramInt1 = new JSONObject((String)localObject).getInt("state");
              if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "CFT_HB_GRAP_state= " + paramInt1 + ", packInfo=" + this.mPackInfo.toString());
              }
              localObject = (LbsPackManager)getAppRuntime().getManager(214);
              if (paramInt1 != 0)
              {
                ((LbsPackManager)localObject).a(this.mPackInfo.jdField_b_of_type_Long, this.mPackInfo.jdField_b_of_type_JavaLangString, paramInt1);
                LbsPackStatsCollector.a("actLbsGetPackFailure", paramInt1);
                paramIntent.putExtra("k_pack_info", this.mPackInfo.jdField_b_of_type_JavaLangString);
                paramIntent.putExtra("k_lbs_key_state", paramInt1);
                if (!String.valueOf(this.mPackInfo.a).equals(this.app.getAccount())) {
                  break label301;
                }
              }
            }
            else
            {
              setResult(1, paramIntent);
              superFinish();
              return;
            }
            LbsPackStatsCollector.a("actLbsGetPackFailure");
            continue;
            ((LbsPackManager)localObject).a(((LbsPackManager)localObject).a.jdField_b_of_type_Long, ((LbsPackManager)localObject).a.jdField_b_of_type_JavaLangString);
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            return;
          }
        }
      }
      LbsPackStatsCollector.a("actLbsGetPackFailure", -10007);
      return;
    }
    if (paramInt2 == 0) {
      LbsPackStatsCollector.a("actLbsGetPackFailure", -10001);
    }
    superFinish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130970222);
    this.mNickNameView = ((TextView)super.findViewById(2131369588));
    this.mNickNameView.setVisibility(0);
    paramBundle = (Button)findViewById(2131369587);
    paramBundle.setOnClickListener(new LbsCaiShenActivity.1(this));
    Object localObject;
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
      int i = ImmersiveUtils.a(this);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin += i;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBundle = (RelativeLayout.LayoutParams)this.mNickNameView.getLayoutParams();
      paramBundle.topMargin += i;
      this.mNickNameView.setLayoutParams(paramBundle);
    }
    this.app.registObserver(this.mLbsPackObserver);
    this.mPackInfo = ((LbsPackInfo)getIntent().getParcelableExtra("k_pack_info"));
    this.mResPath = getIntent().getStringExtra("resPath");
    paramBundle = this.mPackInfo.c;
    if (TextUtils.isEmpty(paramBundle))
    {
      LbsPackManager localLbsPackManager = (LbsPackManager)getAppRuntime().getManager(214);
      localObject = localLbsPackManager.b(this.mPackInfo.a + "");
      paramBundle = (Bundle)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = this.mPackInfo.a + "";
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.mPackInfo.a + "");
        localLbsPackManager.a((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.mNickNameView = ((TextView)super.findViewById(2131369588));
      this.mNickNameView.setText(paramBundle + "的红包");
      if (QLog.isColorLevel()) {
        QLog.i("LbsPack", 2, "packInfo= " + this.mPackInfo.toString());
      }
      this.mCameraSurfaceView = ((CameraSurfaceView)findViewById(2131369585));
      this.mCameraSurfaceView.setPreviewCallback(this.mPreviewCallback);
      this.mCameraSurfaceView.setCameraSurfaceCallBack(this);
      this.mCameraSurfaceView.setDisplay(getWindowManager().getDefaultDisplay());
      this.mCameraCover = findViewById(2131369586);
      this.mGLSurfaceView = ((ARGLSurfaceView)findViewById(2131365953));
      this.mGLSurfaceView.getHolder().setFormat(-3);
      this.mGLSurfaceView.init(this, this.mResPath, 22);
      this.mGLSurfaceView.initSensor(new SimpleSensorChangeListener(), 4);
      this.mGLSurfaceView.setZOrderMediaOverlay(true);
      this.mGLSurfaceView.onResume();
      this.mGLSurfaceView.resumeSensor();
      this.mGLSurfaceView.runOnGlThread(new LbsCaiShenActivity.2(this));
      this.mPlayControl = new ARTreasurePlayControl(this, this.mGLSurfaceView, 12);
      this.mSound = new Sound();
      this.mSound.a(this.mResPath + "/res/lbscaishen/caishen.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/laile.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/2jihui.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/1jihui.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/newcaidui2.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/unlucky.mp3");
      this.mSound.a(this.mResPath + "/res/lbscaishen/repeat.mp3");
      initArrowImageView(this.mResPath);
      if (!NetworkUtil.d(this))
      {
        QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
        LbsPackStatsCollector.a("actLbsGetPackFailure", -10004);
        return false;
      }
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if (!this.mGuessSuccess)
    {
      if (this.clickCount <= 0) {
        break label80;
      }
      LbsPackStatsCollector.a("actLbsGetPackFailure", -10005);
    }
    for (;;)
    {
      this.mCameraSurfaceView.a(true);
      this.mGLSurfaceView.onDestroy();
      this.mGLSurfaceView.stopSensor();
      this.mCameraSurfaceView.setCameraSurfaceCallBack(null);
      this.mSound.c();
      this.app.unRegistObserver(this.mLbsPackObserver);
      reportAndClearData();
      super.doOnDestroy();
      return;
      label80:
      LbsPackStatsCollector.a("actLbsGetPackFailure", -10008);
    }
  }
  
  protected void doOnPause()
  {
    this.mSound.b();
    this.mCameraSurfaceView.a(true);
    this.mGLSurfaceView.onPause();
    this.mGLSurfaceView.stopSensor();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mGLSurfaceView.onResume();
    this.mGLSurfaceView.resumeSensor();
    this.mCameraSurfaceView.d();
    this.mSound.a();
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
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void nativeCallback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "nativeCallback type: " + paramInt1 + ", value: " + paramInt2);
    }
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        return;
        if (!NetworkUtil.d(this))
        {
          this.mHandler.post(new LbsCaiShenActivity.4(this));
          return;
        }
        this.clickCount += 1;
      } while (this.mGLSurfaceView == null);
      this.mGLSurfaceView.runOnGlThread(new LbsCaiShenActivity.5(this));
      return;
    }
    ((LbsPackManager)this.app.getManager(214)).a(this, 1, this.mPackInfo, this.clickCount);
    this.mHasReport = true;
    this.mGuessSuccess = true;
  }
  
  protected boolean onBackEvent()
  {
    reportAndClearData();
    superFinish();
    return true;
  }
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "onStartPreview isSucc:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.mPlayControl.jdField_a_of_type_Int = 1;
      if (this.mGLSurfaceView != null)
      {
        this.mGLSurfaceView.setZOrderMediaOverlay(false);
        this.mGLSurfaceView.setZOrderOnTop(true);
      }
      showNoPermissionView(true);
      if (this.mCameraNoPermissionDialog == null) {
        this.mCameraNoPermissionDialog = DialogUtil.a(this, 230, getResources().getString(2131438776), getResources().getString(2131438777), getResources().getString(2131438773), "", null, new LbsCaiShenActivity.3(this));
      }
      this.mCameraNoPermissionDialog.show();
    }
    do
    {
      return;
      this.mPlayControl.jdField_a_of_type_Int = 0;
      showNoPermissionView(false);
      if (QLog.isColorLevel()) {
        QLog.i("ARTreasurePlayControl", 2, "initMode when camera opensuccess");
      }
      this.mPlayControl.d = true;
      this.mPlayControl.b();
    } while ((this.mCameraNoPermissionDialog == null) || (!this.mCameraNoPermissionDialog.isShowing()));
    this.mCameraNoPermissionDialog.dismiss();
    this.mCameraNoPermissionDialog = null;
  }
  
  public void onTreasureAudioCallback(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "onTreasureAudioCallback type " + paramInt1 + ", operationType:" + paramInt2 + ", mResPath:" + this.mResPath);
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
          break label362;
        }
        localSound.a(str, bool);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label361;
        }
        QLog.i("LbsPack", 2, "onTreasureAudioCallback exception", localException);
      }
      str = this.mResPath + "/res/lbscaishen/caishen.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/laile.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/2jihui.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/1jihui.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/newcaidui2.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/unlucky.mp3";
      continue;
      str = this.mResPath + "/res/lbscaishen/repeat.mp3";
      continue;
      if ((paramInt2 == 1) && (paramInt1 == 10))
      {
        this.mSound.c();
        return;
      }
      label361:
      return;
      label362:
      bool = false;
    }
  }
  
  public void reportAndClearData()
  {
    if ((!this.mHasReport) && (this.clickCount > 0))
    {
      this.mHasReport = true;
      if (this.clickCount != 1) {
        break label152;
      }
    }
    label152:
    for (int i = 201;; i = 202)
    {
      if (!this.app.getAccount().equals(String.valueOf(this.mPackInfo.a)))
      {
        openLbsPackFailReport(this.clickCount);
        Object localObject = (LbsPackManager)this.app.getManager(214);
        ((LbsPackManager)localObject).a(this.mPackInfo.jdField_b_of_type_Long, this.mPackInfo.jdField_b_of_type_JavaLangString, i);
        ((LbsPackManager)localObject).a(this.mPackInfo.jdField_b_of_type_Long, this.mPackInfo.jdField_b_of_type_JavaLangString);
        localObject = new Intent();
        ((Intent)localObject).putExtra("k_pack_info", this.mPackInfo.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("k_lbs_key_state", i);
        setResult(1, (Intent)localObject);
      }
      return;
    }
  }
  
  public void resizeSurface()
  {
    this.mHandler.post(new LbsCaiShenActivity.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity
 * JD-Core Version:    0.7.0.1
 */