package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class ARLBSPOIDialog
  extends ReportDialog
{
  Activity a;
  MapView b;
  RelativeLayout c;
  RelativeLayout d;
  URLImageView e;
  TextView f;
  TextView g;
  URLImageView h;
  ImageView i;
  TextView j;
  Button k;
  ProgressBar l;
  View m;
  View n;
  RelativeLayout o;
  View p;
  View q;
  int r;
  int s;
  Context t;
  boolean u;
  ARCloudLBSLocationCheckResult.POIInfo v;
  private ARScanEntryView w;
  
  public ARLBSPOIDialog(Activity paramActivity, MapView paramMapView, ARScanEntryView paramARScanEntryView)
  {
    super(paramActivity, 2131953338);
    this.a = paramActivity;
    this.t = paramActivity;
    this.w = paramARScanEntryView;
    c();
    this.b = paramMapView;
    paramMapView = getWindow();
    paramARScanEntryView = paramMapView.getAttributes();
    paramARScanEntryView.width = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramARScanEntryView.height = paramActivity.getResources().getDisplayMetrics().heightPixels;
    paramMapView.setAttributes(paramARScanEntryView);
    this.l.postDelayed(new ARLBSPOIDialog.1(this), 1500L);
  }
  
  private void a(ARCloudLBSLocationCheckResult.POIInfo paramPOIInfo)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((MapView)localObject1).getParent() != null))
    {
      if (this.b.getMap() == null) {
        return;
      }
      localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(210.0F, this.t.getResources()));
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131435785);
      this.o.addView(this.b, (ViewGroup.LayoutParams)localObject1);
      this.q = getLayoutInflater().inflate(2131627318, null);
      localObject1 = (TextView)this.q.findViewById(2131440462);
      Object localObject3 = (TextView)this.q.findViewById(2131431993);
      Object localObject2 = (TextView)this.q.findViewById(2131440461);
      ((TextView)localObject1).setText(HardCodeUtil.a(2131898972));
      if (paramPOIInfo.e < 1000)
      {
        ((TextView)localObject3).setText(this.t.getString(2131896595, new Object[] { String.valueOf(paramPOIInfo.e) }));
      }
      else
      {
        float f1 = Math.round(paramPOIInfo.e / 1000.0F * 100.0F) / 100.0F;
        ((TextView)localObject3).setText(this.t.getString(2131896593, new Object[] { String.valueOf(f1) }));
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramPOIInfo.c);
      ((StringBuilder)localObject3).append("|");
      if (TextUtils.isEmpty(paramPOIInfo.d)) {
        localObject1 = "";
      } else {
        localObject1 = paramPOIInfo.d;
      }
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      if (!TextUtils.isEmpty(paramPOIInfo.c))
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, paramPOIInfo.c.length(), 17);
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      else
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      this.q.setOnClickListener(new ARLBSPOIDialog.3(this));
      localObject1 = this.b.getMap();
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.zoomTo(16.0F));
      double d1 = paramPOIInfo.a;
      Double.isNaN(d1);
      d1 = d1 * 1.0D / 1000000.0D;
      double d2 = paramPOIInfo.b;
      Double.isNaN(d2);
      paramPOIInfo = new LatLng(d1, d2 * 1.0D / 1000000.0D);
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramPOIInfo));
      this.b.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.q)).position(paramPOIInfo));
      if (this.a != null)
      {
        paramPOIInfo = this.w;
        if ((paramPOIInfo != null) && (paramPOIInfo.o))
        {
          paramPOIInfo = this.b.getMap().getProjection();
          if ((paramPOIInfo != null) && (((TencentMap)localObject1).getCameraPosition() != null))
          {
            localObject2 = paramPOIInfo.toScreenLocation(((TencentMap)localObject1).getCameraPosition().target);
            ((Point)localObject2).offset(0, AIOUtils.b(60.0F, this.t.getResources()) * -1);
            ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramPOIInfo.fromScreenLocation((Point)localObject2)));
          }
        }
      }
      this.b.onResume();
      this.p.setVisibility(8);
      this.n.setVisibility(8);
      this.m.setVisibility(8);
      this.o.setVisibility(0);
    }
  }
  
  private void c()
  {
    setContentView(2131627314);
    this.d = ((RelativeLayout)findViewById(2131435785));
    this.e = ((URLImageView)findViewById(2131440464));
    this.f = ((TextView)findViewById(2131440473));
    this.g = ((TextView)findViewById(2131446853));
    this.i = ((ImageView)findViewById(2131433070));
    this.h = ((URLImageView)findViewById(2131440658));
    this.j = ((TextView)findViewById(2131440659));
    this.l = ((ProgressBar)findViewById(2131440737));
    this.k = ((Button)findViewById(2131430817));
    this.k.setOnClickListener(new ARLBSPOIDialog.2(this));
    this.c = ((RelativeLayout)findViewById(2131431368));
    this.m = findViewById(2131440466);
    this.n = findViewById(2131429698);
    this.p = findViewById(2131437939);
    this.o = ((RelativeLayout)findViewById(2131437938));
    this.i.setVisibility(8);
  }
  
  public void a()
  {
    super.show();
    int i1 = getWindow().getAttributes().width;
    int i2 = getWindow().getAttributes().height;
    int i3 = (i1 - AIOUtils.b(320.0F, this.t.getResources())) / 2;
    int i4 = (i2 - AIOUtils.b(420.0F, this.t.getResources())) / 2;
    this.r = (i1 / 2);
    this.s = (i2 / 2);
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, this.r - i3, 0, this.s - i4);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(1.5F));
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.c.startAnimation(localAnimationSet);
  }
  
  public void a(ARCloudLBSLocationCheckResult.POIInfo paramPOIInfo, ArLBSActivity paramArLBSActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSPOIDialog", 2, "bindView");
    }
    this.v = paramPOIInfo;
    this.u = true;
    this.l.setVisibility(8);
    Object localObject;
    if (!TextUtils.isEmpty(paramArLBSActivity.d))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(140.0F, this.t.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(170.0F, this.t.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.t.getResources().getDrawable(2130853309);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.t.getResources().getDrawable(2130853309);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.d, (URLDrawable.URLDrawableOptions)localObject);
      this.h.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.b))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      int i1 = AIOUtils.b(31.0F, this.t.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.t.getResources().getDrawable(2130853309);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.t.getResources().getDrawable(2130853309);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.b, (URLDrawable.URLDrawableOptions)localObject);
      this.e.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.c))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.t.getResources().getDrawable(2130853309);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.t.getResources().getDrawable(2130853309);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.c, (URLDrawable.URLDrawableOptions)localObject);
      this.d.setBackgroundDrawable((Drawable)localObject);
    }
    this.f.setText(paramArLBSActivity.a);
    if (!TextUtils.isEmpty(paramArLBSActivity.e)) {
      this.j.setText(paramArLBSActivity.e);
    }
    this.g.setText(HardCodeUtil.a(2131898973));
    a(paramPOIInfo);
  }
  
  public void b()
  {
    int i2 = getWindow().getAttributes().width;
    int i1 = getWindow().getAttributes().height;
    i2 = (i2 - AIOUtils.b(320.0F, this.t.getResources())) / 2;
    i1 = (i1 - AIOUtils.b(420.0F, this.t.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.r - i2, 0, this.s - i1);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.c.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new ARLBSPOIDialog.4(this));
  }
  
  public void dismiss()
  {
    if (!this.a.isFinishing()) {
      super.dismiss();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Object localObject = this.b;
    if ((localObject != null) && (((MapView)localObject).getParent() != null))
    {
      localObject = this.q;
      if (localObject != null) {
        this.b.removeView((View)localObject);
      }
      this.o.removeView(this.b);
      this.b.onPause();
    }
  }
  
  public void show()
  {
    if (!this.a.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSPOIDialog
 * JD-Core Version:    0.7.0.1
 */