package com.tencent.aelight.camera.aebase.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment;
import com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite;
import com.tencent.aelight.camera.api.ICaptureSoDownloadListener;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadActivity
  extends BaseActivity
  implements ICaptureSoDownloadListener
{
  public static final String a = "CaptureQmcfSoDownloadActivity";
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private BaseFragment jdField_a_of_type_ComTencentMobileqqAppBaseFragment;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    if (AECameraLauncher.a(paramBundle)) {
      localIntent.addFlags(603979776);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean1);
    localIntent.putExtra("key_wait_download_result", paramBoolean2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if ((i == AECameraEntry.l.a()) || (i == AECameraEntry.k.a())) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (!getIntent().getBooleanExtra("key_wait_download_result", false))
    {
      QLog.d("qqBaseActivity", 4, "in launch.");
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadActivity.1(this), 5L);
      return;
    }
    AEQLog.d(jdField_a_of_type_JavaLangString, "[onFinish] getBooleanExtra(KEY_JUST_WAIT_DOWNLOAD_RESULT");
    setResult(-1, null);
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561003);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment = new CaptureQmcfSoDownloadFragment();
    this.b = getIntent().getStringExtra("pendingIntentClass");
    if (getIntent().getBooleanExtra("pendingIntentAllWait", false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment = new CaptureQmcfSoDownloadFragmentAllWaite();
    }
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362027, this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment);
    paramBundle.commit();
    this.jdField_a_of_type_Boolean = getIntent().hasExtra("pendingIntentRequest");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int = getIntent().getIntExtra("pendingIntentRequest", 0);
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    AEQLog.b(jdField_a_of_type_JavaLangString, "【Activity doOnCreate】");
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AEQLog.b(jdField_a_of_type_JavaLangString, "【Activity doOnDestroy】");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */