package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected boolean A = false;
  protected int B = 0;
  public QQProgressDialog C;
  public Handler D = new PhotoCropActivity.1(this);
  CardObserver E = new PhotoCropActivity.3(this);
  final long a = 10000L;
  ViewGroup b;
  PortraitImageview c;
  RegionView d;
  Button e;
  String f;
  Button g;
  TextView h;
  String i;
  int j;
  int k;
  String[] l;
  Intent m;
  View n;
  String o;
  String p;
  int q;
  int r;
  int s;
  int t;
  int u;
  int v;
  boolean w;
  boolean x;
  PhotoCropAction y;
  boolean z = false;
  
  private void a(int paramInt)
  {
    if (!isFinishing()) {
      QQToast.makeText(this, paramInt, 0).show(getTitleBarHeight());
    }
  }
  
  @SuppressLint({"NewApi"})
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.n = findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.n.setFitsSystemWindows(true);
    }
    this.b = ((ViewGroup)findViewById(2131440222));
    this.e = ((Button)findViewById(2131431556));
    this.g = ((Button)findViewById(2131429224));
    this.h = ((TextView)findViewById(2131447463));
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.p)) {
      this.g.setText(this.p);
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.i))
    {
      this.g.setText("");
      this.h.setText("调整QQ头像");
    }
    this.c = new PortraitImageview(this);
    this.c.addOnLayoutChangeListener(new PhotoCropActivity.2(this));
  }
  
  protected boolean a()
  {
    Object localObject = getIntent();
    this.m = ((Intent)localObject);
    this.i = ((Intent)localObject).getStringExtra("FROM_WHERE");
    ((Intent)localObject).removeExtra("FROM_WHERE");
    this.o = ((Intent)localObject).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.p = ((Intent)localObject).getStringExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE");
    this.q = ((Intent)localObject).getIntExtra("PhotoConst.CLIP_WIDTH", 400);
    this.r = ((Intent)localObject).getIntExtra("PhotoConst.CLIP_HEIGHT", 400);
    this.w = ((Intent)localObject).getBooleanExtra("PhotoConst.32_Bit_Config", false);
    this.s = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_WIDTH", 400);
    this.t = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_HEIGHT", 400);
    this.u = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1280);
    this.x = ((Intent)localObject).getBooleanExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", false);
    this.f = ((Intent)localObject).getStringExtra("PhotoConst.TARGET_PATH");
    this.j = ((Intent)localObject).getIntExtra("BUSINESS_ORIGIN_NEW", 0);
    if (this.f == null)
    {
      QQToast.makeText(this, 2131892546, 0).show();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhotoCropActivity", 2, String.format("initData path=%s target=%s", new Object[] { this.o, this.f }));
    }
    this.v = ((Intent)localObject).getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    this.k = ((Intent)localObject).getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.l = ((Intent)localObject).getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData from=");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(" targetSampleSize=");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(" keepClipInfo=");
      ((StringBuilder)localObject).append(this.x);
      QLog.d("PhotoCropActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.i)) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009B68", "0X8009B68", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  void b()
  {
    if (this.z) {
      return;
    }
    this.z = true;
    new PhotoCropActivity.StoreFileTask(this, null).execute(new Void[0]);
  }
  
  protected void c()
  {
    try
    {
      if (!isFinishing())
      {
        this.C = new QQProgressDialog(this, getTitleBarHeight());
        this.C.setCancelable(false);
        this.C.c(2131887775);
        this.C.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void d()
  {
    QQProgressDialog localQQProgressDialog = this.C;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.C.dismiss();
      label23:
      this.C = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625578);
    if (!a())
    {
      finish();
      return false;
    }
    a(this.o, this.q, this.r, this.s, this.t, this.v);
    addObserver(this.E);
    new PhotoCropActivity.LoadBitmapTask(this, null).execute(new Void[0]);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.E);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e("doOnNewIntent", 2, "get new intent");
    }
    setIntent(paramIntent);
    if (!a())
    {
      finish();
      return;
    }
    a(this.o, this.q, this.r, this.s, this.t, this.v);
    new PhotoCropActivity.LoadBitmapTask(this, null).execute(new Void[0]);
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent;
    if ("FROM_PHOTO_LIST".equals(this.i))
    {
      localIntent = getIntent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    else if ("FROM_NEARBY_PROFILE".equals(this.i))
    {
      PhotoUtils.sendPhoto(this, getIntent(), new ArrayList(), 0, false);
    }
    else if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.i))
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8009B69", "0X8009B69", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoCropActivity", 2, "onBackEvent");
      }
      localIntent = getIntent();
      localIntent.putExtra("key_from_sdk_set_avatar_result", false);
      setResult(0, localIntent);
    }
    finish();
    AlbumUtil.anim(this, true, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429224)
    {
      if (i1 == 2131431556)
      {
        if (this.l != null)
        {
          if (this.y == null)
          {
            this.y = new PhotoCropMenuForQzone(this);
            this.y.a(this.l);
          }
          if (this.d != null) {
            this.y.a();
          }
        }
        else if (this.d != null)
        {
          b();
        }
        AlbumUtil.clearSelectItemInfo();
        AlbumUtil.a(this.m);
        if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.i)) {
          ReportController.b(this.app, "dc00898", "", "", "0X8009B6A", "0X8009B6A", 0, 0, "", "", "", "");
        }
      }
    }
    else {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */