package com.tencent.mobileqq.arcard;

import aaei;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.armap.ARMapBaseActivity;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.hotpic.VideoItemEventManager.onVideoItemEventListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ARCardCameraRecordActivity
  extends ARMapBaseActivity
  implements OnCameraVideoRecordListener, VideoItemEventManager.onVideoItemEventListener
{
  private int jdField_a_of_type_Int = 1;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ARBlessWordFragment jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment;
  private ARCardCameraRecordActivity.VideoRecordResult jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity$VideoRecordResult;
  ARCardCameraRecordFragment jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment;
  ARCardHeadIconManager jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager;
  public String a;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  public ARCardCameraRecordActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt == 2) {
        d();
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment = new ARCardCameraRecordFragment();
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment.a(this);
    localFragmentTransaction.add(2131369448, this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment, "VideoRecord");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void d()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment = new ARBlessWordFragment();
    this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment.a(this);
    this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment.a(this.b, this.c, this.d, this.e, this.g, this.f, this.h, this.i);
    this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment.a(this);
    localFragmentTransaction.add(2131369448, this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment, "BlessText");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(ARCardCameraRecordActivity.VideoRecordResult paramVideoRecordResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARCardCameraRecordActivity", 2, "doOnActivityResult flag:" + paramVideoRecordResult.jdField_a_of_type_Int + ", path:" + paramVideoRecordResult.b);
    }
    if (paramVideoRecordResult.jdField_a_of_type_Int == 1) {
      ThreadManager.getUIHandler().post(new aaei(this, paramVideoRecordResult));
    }
    while ((paramVideoRecordResult.jdField_a_of_type_Int != 2) || (new File("/sdcard/test.mp4").exists())) {
      return;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.f);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      startActivity(localIntent);
      finish();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARCardCameraRecordActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCameraRecordActivity", 2, "doOnBackPressed");
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-3);
    VideoItemEventManager.a(getApplicationContext()).a(true);
    VideoItemEventManager.a(getApplicationContext()).a(this);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970183);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369447));
    try
    {
      paramBundle = new BitmapFactory.Options();
      paramBundle.inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.b() + "arcard.jpg", paramBundle));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369446));
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        int j = paramBundle.getIntExtra("entry_point", 1);
        this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("currentNickName");
        this.jdField_a_of_type_Int = j;
        this.b = paramBundle.getExtras().getString("aio_msg_title");
        this.c = paramBundle.getExtras().getString("aio_msg_summary");
        this.d = paramBundle.getExtras().getString("aio_msg_imageurl");
        this.e = paramBundle.getExtras().getString("aio_msg_url");
        this.f = paramBundle.getExtras().getString("send_msg_success_url");
        this.g = paramBundle.getExtras().getString("card_default_text");
        this.h = paramBundle.getExtras().getString("taskId");
        this.i = paramBundle.getExtras().getString("H5Source");
        b(j);
      }
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager = new ARCardHeadIconManager(this);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.a();
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.a(getCurrentAccountUin());
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    VideoItemEventManager.a(getApplicationContext()).a(false);
    VideoItemEventManager.a(getApplicationContext()).b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.b();
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardCameraRecordActivity
 * JD-Core Version:    0.7.0.1
 */