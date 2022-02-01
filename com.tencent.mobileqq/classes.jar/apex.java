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
import com.tencent.mobileqq.ar.ARLBSPOIDialog.1;
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

public class apex
  extends ReportDialog
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  apnc jdField_a_of_type_Apnc;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ARScanEntryView jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView;
  MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView;
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View d;
  
  public apex(Activity paramActivity, MapView paramMapView, ARScanEntryView paramARScanEntryView)
  {
    super(paramActivity, 2131755824);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = paramARScanEntryView;
    c();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView = paramMapView;
    paramMapView = getWindow();
    paramARScanEntryView = paramMapView.getAttributes();
    paramARScanEntryView.width = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramARScanEntryView.height = paramActivity.getResources().getDisplayMetrics().heightPixels;
    paramMapView.setAttributes(paramARScanEntryView);
    this.jdField_a_of_type_AndroidWidgetProgressBar.postDelayed(new ARLBSPOIDialog.1(this), 1500L);
  }
  
  private void a(apnc paramapnc)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getParent() == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap() == null)) {
      return;
    }
    Object localObject1 = new RelativeLayout.LayoutParams(-1, agej.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131368703);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView, (ViewGroup.LayoutParams)localObject1);
    this.d = getLayoutInflater().inflate(2131561093, null);
    localObject1 = (TextView)this.d.findViewById(2131372832);
    Object localObject3 = (TextView)this.d.findViewById(2131365624);
    Object localObject2 = (TextView)this.d.findViewById(2131372831);
    ((TextView)localObject1).setText(anzj.a(2131699640));
    if (paramapnc.c < 1000)
    {
      ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131697860, new Object[] { String.valueOf(paramapnc.c) }));
      localObject3 = new StringBuilder().append(paramapnc.jdField_a_of_type_JavaLangString).append("|");
      if (!TextUtils.isEmpty(paramapnc.jdField_b_of_type_JavaLangString)) {
        break label550;
      }
      localObject1 = "";
      label204:
      localObject1 = (String)localObject1;
      if (TextUtils.isEmpty(paramapnc.jdField_a_of_type_JavaLangString)) {
        break label558;
      }
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, paramapnc.jdField_a_of_type_JavaLangString.length(), 17);
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.d.setOnClickListener(new apez(this));
      localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.zoomTo(16.0F));
      paramapnc = new LatLng(paramapnc.jdField_a_of_type_Int * 1.0D / 1000000.0D, paramapnc.jdField_b_of_type_Int * 1.0D / 1000000.0D);
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramapnc));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.d)).position(paramapnc));
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.j))
      {
        paramapnc = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getProjection();
        if ((paramapnc != null) && (((TencentMap)localObject1).getCameraPosition() != null))
        {
          localObject2 = paramapnc.toScreenLocation(((TencentMap)localObject1).getCameraPosition().target);
          ((Point)localObject2).offset(0, agej.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * -1);
          ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramapnc.fromScreenLocation((Point)localObject2)));
        }
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.onResume();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      float f = Math.round(paramapnc.c / 1000.0F * 100.0F) / 100.0F;
      ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131697858, new Object[] { String.valueOf(f) }));
      break;
      label550:
      localObject1 = paramapnc.jdField_b_of_type_JavaLangString;
      break label204;
      label558:
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
  }
  
  private void c()
  {
    setContentView(2131561089);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368703));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131372834));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372844));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378459));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366572));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131372990));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372991));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373048));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364593));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new apey(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365079));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372836);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363643);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370596);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370595));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a()
  {
    super.show();
    int i = getWindow().getAttributes().width;
    int j = getWindow().getAttributes().height;
    int k = (i - agej.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    int m = (j - agej.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    this.jdField_a_of_type_Int = (i / 2);
    this.jdField_b_of_type_Int = (j / 2);
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, this.jdField_a_of_type_Int - k, 0, this.jdField_b_of_type_Int - m);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(1.5F));
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public void a(apnc paramapnc, ArLBSActivity paramArLBSActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSPOIDialog", 2, "bindView");
    }
    this.jdField_a_of_type_Apnc = paramapnc;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    Object localObject;
    if (!TextUtils.isEmpty(paramArLBSActivity.d))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = agej.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = agej.a(170.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.d, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = agej.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.c))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArLBSActivity.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramArLBSActivity.e)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramArLBSActivity.e);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131699641));
    a(paramapnc);
  }
  
  public void b()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - agej.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - agej.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new apfa(this));
  }
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getParent() != null))
    {
      if (this.d != null) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.removeView(this.d);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.onPause();
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apex
 * JD-Core Version:    0.7.0.1
 */