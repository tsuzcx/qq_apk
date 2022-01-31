package com.tencent.mobileqq.arcard;

import aanc;
import aanh;
import aani;
import aanj;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.armap.ARMapBaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ARVideoPreviewActivity
  extends ARMapBaseActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARCardLoadingProgressView jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView;
  private ARCardVideoPreview jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview;
  public ARRelationShipFileUpload a;
  public String a;
  private int jdField_b_of_type_Int;
  public long b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private int jdField_c_of_type_Int;
  public long c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  public long d;
  private String d;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  
  public ARVideoPreviewActivity()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Intent localIntent = new Intent(paramActivity, ARVideoPreviewActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("entrance", paramInt1);
    localIntent.putExtra("videoPreiviewPath", paramString1);
    localIntent.putExtra("videoWidth", paramInt2);
    localIntent.putExtra("videoHeight", paramInt3);
    localIntent.putExtra("aio_msg_title", paramString2);
    localIntent.putExtra("aio_msg_summary", paramString3);
    localIntent.putExtra("aio_msg_imageurl", paramString4);
    localIntent.putExtra("aio_msg_url", paramString5);
    localIntent.putExtra("send_msg_success_url", paramString6);
    localIntent.putExtra("taskId", paramString7);
    localIntent.putExtra("H5Source", paramString8);
    paramActivity.startActivityForResult(localIntent, 0);
    paramActivity.overridePendingTransition(0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ARVideoPreviewFragment", 2, "startARVideoPreviewActivity with entry 1");
    }
  }
  
  private void a(ARCardVideoPreview paramARCardVideoPreview, boolean paramBoolean)
  {
    if (paramARCardVideoPreview != null)
    {
      paramARCardVideoPreview.setFilePath(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      paramARCardVideoPreview.setVideoSize(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      paramARCardVideoPreview.b();
      paramARCardVideoPreview.setRepeat(paramBoolean);
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("entrance", 1);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("videoPreiviewPath");
    this.jdField_b_of_type_Int = localIntent.getIntExtra("videoWidth", 0);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("videoHeight", 0);
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("picturePath");
    this.e = localIntent.getExtras().getString("aio_msg_title");
    this.f = localIntent.getExtras().getString("aio_msg_summary");
    this.g = localIntent.getExtras().getString("aio_msg_imageurl");
    this.h = localIntent.getExtras().getString("aio_msg_url");
    this.i = localIntent.getExtras().getString("send_msg_success_url");
    this.j = localIntent.getExtras().getString("taskId");
    this.k = localIntent.getExtras().getString("H5Source");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369529));
    if (this.jdField_a_of_type_Int == 1) {
      e();
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369530));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369524));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369527));
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.b() + "arcard.jpg", localOptions));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.c() + "arcard_videorecord_bg.png", localOptions));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this).inflate(2130970202, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369526));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369228));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369532));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(225.0F, getActivity().getResources());
    localLayoutParams.height = AIOUtils.a(390.0F, getActivity().getResources());
    localLayoutParams.setMargins(0, AIOUtils.a(10.0F, getActivity().getResources()), 0, 0);
    localLayoutParams.addRule(14);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview = new ARCardVideoPreview(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview, 0, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview, true);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoPreviewFragment", 2, "sendBless");
    }
    if (!NetworkUtil.g(getApplicationContext()))
    {
      QQToast.a(this, 2131437530, 1).a();
      return;
    }
    a();
    ThreadManager.getSubThreadHandler().post(new aanc(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a();
    }
    b();
  }
  
  private void h()
  {
    DialogUtil.b(this, 233, null, "AR贺卡发送失败，请重新发送", 2131433015, 2131433031, new aanh(this), new aani(this)).show();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.width = AIOUtils.a(225.0F, getActivity().getResources());
      localLayoutParams.height = AIOUtils.a(400.0F, getActivity().getResources());
      localLayoutParams.setMargins(0, AIOUtils.a(8.0F, getActivity().getResources()), 0, 0);
      localLayoutParams.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView = new ARCardLoadingProgressView(this);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setBackgroundColor(637534208);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setScale(ScreenUtil.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView, localLayoutParams);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      paramInt = (int)((this.jdField_a_of_type_Long + this.jdField_c_of_type_Long) * 100L / (this.jdField_b_of_type_Long + this.jdField_d_of_type_Long));
      if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setTotalProgress(paramInt);
      }
      return;
      this.jdField_c_of_type_Long = paramLong;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    while ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    ThreadManager.getUIHandler().post(new aanj(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView = null;
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoPreviewFragment", 2, "doOnBackPressed");
    }
    setResult(100);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARVideoPreviewFragment", 2, "onCreate  this=");
    }
    getWindow().setFormat(-3);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970201);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return true;
    }
    c();
    d();
    this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload = new ARRelationShipFileUpload(getAppInterface());
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview.g();
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardVideoPreview.onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369532) {
      f();
    }
    do
    {
      return;
      if (paramView.getId() == 2131369530)
      {
        f();
        return;
      }
    } while (paramView.getId() != 2131369526);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */