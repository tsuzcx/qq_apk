package com.tencent.aelight.camera.ae.cmshow;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.AppRuntime;

public class AECMShowGuideFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  
  private void a()
  {
    QIMCameraCaptureActivity.a(getBaseActivity(), getArguments(), 100);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AECMShowGuideFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2063991191));
    this.b = ((ImageView)paramView.findViewById(2063991192));
    this.c = ((TextView)paramView.findViewById(2063991541));
    this.c.setOnClickListener(this);
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    Drawable localDrawable;
    try
    {
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = ViewUtils.getScreenWidth();
      paramView.mRequestHeight = ViewUtils.getScreenHeight();
      localDrawable = getResources().getDrawable(2063794182);
      paramView.mFailedDrawable = localDrawable;
      paramView.mLoadingDrawable = localDrawable;
      paramView.mRetryCount = 3;
      paramView = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/AECMJoy/aecmjoy_guide_avatar@2x.png", paramView);
      if (paramView.getStatus() == 2) {
        paramView.restartDownload();
      }
      this.a.setImageDrawable(paramView);
    }
    catch (Exception paramView)
    {
      AEQLog.a("AECMShowGuideFragment", "set guide avatar image exception", paramView);
    }
    try
    {
      paramView = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = getResources().getDrawable(2063794182);
      paramView.mFailedDrawable = localDrawable;
      paramView.mLoadingDrawable = localDrawable;
      paramView.mRetryCount = 3;
      paramView = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/AECMJoy/aecmjoy_guide_title@2x.png", paramView);
      if (paramView.getStatus() == 2) {
        paramView.restartDownload();
      }
      this.b.setImageDrawable(paramView);
      return;
    }
    catch (Exception paramView)
    {
      AEQLog.a("AECMShowGuideFragment", "set guide title image exception", paramView);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(paramActivity.getWindow());
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult--requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", resultCode=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AECMShowGuideFragment", localStringBuilder.toString());
    getBaseActivity().setResult(paramInt2, paramIntent);
    getBaseActivity().finish();
  }
  
  public void onBackPressed()
  {
    AEQLog.b("AECMShowGuideFragment", "onBackPressed");
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2063991541)
    {
      a();
      AEBaseDataReporter.a().aH();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cmshow_first_guide_has_shown_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    paramBundle.a(localStringBuilder.toString(), true, 4);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056358, paramViewGroup, false);
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseDataReporter.a().aG();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowGuideFragment
 * JD-Core Version:    0.7.0.1
 */