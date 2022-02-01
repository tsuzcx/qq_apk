package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  boolean a;
  boolean b;
  String c = null;
  protected QQCustomDialog d;
  private ViewGroup e;
  private Gallery f;
  private CameraPreviewActivity.GalleryImageAdapter g;
  private Drawable h = new ColorDrawable(0);
  private ArrayList<String> i = new ArrayList();
  private int j;
  private int k;
  
  private void a()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    this.b = localIntent.getBooleanExtra("callFromFastImage", false);
    if (this.b) {
      StatisticConstants.c();
    } else {
      StatisticConstants.a();
    }
    this.i = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int m = localIntent.getIntExtra("uintype", 1003);
    if ((m == 0) || (m == 1) || (m == 3000) || (m == 7)) {
      bool = true;
    }
    this.a = bool;
    this.c = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
  }
  
  private void a(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt == 6)
    {
      localObject1 = getString(2131916080);
      localObject2 = getString(2131916079);
    }
    for (;;)
    {
      break;
      if (paramInt == 7)
      {
        localObject1 = getString(2131916082);
        localObject2 = getString(2131916081);
      }
      else
      {
        localObject1 = this.d;
        if (localObject1 != null)
        {
          ((QQCustomDialog)localObject1).dismiss();
          return;
        }
        localObject1 = null;
        localObject2 = localObject1;
      }
    }
    this.d = DialogUtil.a(this, 230, (String)localObject1, (String)localObject2, new CameraPreviewActivity.4(this), null);
    this.d.setOnCancelListener(new CameraPreviewActivity.5(this));
    this.d.setOnDismissListener(new CameraPreviewActivity.6(this));
    this.d.show();
  }
  
  private boolean a(String paramString)
  {
    long l1 = new File(paramString).length();
    long l2 = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
    boolean bool = false;
    if (l1 > l2)
    {
      QQToast.makeText(this, getResources().getString(2131892570), 0).show(getResources().getDimensionPixelSize(2131299920));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.f = new Gallery(this);
    this.f.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.e.addView(this.f, -1, -1);
    this.g = new CameraPreviewActivity.GalleryImageAdapter(this);
    this.f.setAdapter(this.g);
  }
  
  private boolean c()
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      a(7);
      return true;
    }
    if (AIOPhotoListUtils.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQCustomDialog localQQCustomDialog = this.d;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.d.hide();
    }
    this.d = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (getIntent().getIntExtra("uintype", 1003) == 8000)
    {
      PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", true));
      finish();
      return;
    }
    PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    this.e = ((ViewGroup)getLayoutInflater().inflate(2131625581, null));
    b();
    getLayoutInflater().inflate(2131625583, this.e);
    this.j = getResources().getDisplayMetrics().widthPixels;
    this.k = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.e);
    if (this.a) {
      setRightButton(2131892584, new CameraPreviewActivity.1(this));
    }
    setTitle(2131892721);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131436182));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.e.findViewById(2131440188);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("BUILD MODEL:");
    ((StringBuilder)localObject).append(Build.MODEL);
    QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null)
    {
      paramBundle.setText((CharSequence)localObject);
      if (Build.MODEL.equals("PAFM00"))
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, ViewUtils.dpToPx(12.0F), 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    paramBundle.setOnClickListener(new CameraPreviewActivity.2(this));
    paramBundle = this.e.findViewById(2131440186);
    if (Build.MODEL.equals("PAFM00"))
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.dpToPx(12.0F), 0, 0, 0);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramBundle.setOnClickListener(new CameraPreviewActivity.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */