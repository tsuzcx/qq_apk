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
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class amob
  extends Dialog
{
  int jdField_a_of_type_Int;
  amwm jdField_a_of_type_Amwm;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
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
  
  public amob(Activity paramActivity, MapView paramMapView, ARScanEntryView paramARScanEntryView)
  {
    super(paramActivity, 2131755801);
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
  
  private void a(amwm paramamwm)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getParent() == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap() == null)) {
      return;
    }
    Object localObject1 = new RelativeLayout.LayoutParams(-1, aekt.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131368311);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView, (ViewGroup.LayoutParams)localObject1);
    this.d = getLayoutInflater().inflate(2131560835, null);
    localObject1 = (TextView)this.d.findViewById(2131372122);
    Object localObject3 = (TextView)this.d.findViewById(2131365345);
    Object localObject2 = (TextView)this.d.findViewById(2131372121);
    ((TextView)localObject1).setText(alpo.a(2131701096));
    if (paramamwm.c < 1000)
    {
      ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698896, new Object[] { String.valueOf(paramamwm.c) }));
      localObject3 = new StringBuilder().append(paramamwm.jdField_a_of_type_JavaLangString).append("|");
      if (!TextUtils.isEmpty(paramamwm.jdField_b_of_type_JavaLangString)) {
        break label550;
      }
      localObject1 = "";
      label204:
      localObject1 = (String)localObject1;
      if (TextUtils.isEmpty(paramamwm.jdField_a_of_type_JavaLangString)) {
        break label558;
      }
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, paramamwm.jdField_a_of_type_JavaLangString.length(), 17);
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.d.setOnClickListener(new amod(this));
      localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.zoomTo(16.0F));
      paramamwm = new LatLng(paramamwm.jdField_a_of_type_Int * 1.0D / 1000000.0D, paramamwm.jdField_b_of_type_Int * 1.0D / 1000000.0D);
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramamwm));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.d)).position(paramamwm));
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.j))
      {
        paramamwm = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getProjection();
        if ((paramamwm != null) && (((TencentMap)localObject1).getCameraPosition() != null))
        {
          localObject2 = paramamwm.toScreenLocation(((TencentMap)localObject1).getCameraPosition().target);
          ((Point)localObject2).offset(0, aekt.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * -1);
          ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(paramamwm.fromScreenLocation((Point)localObject2)));
        }
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.onResume();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      float f = Math.round(paramamwm.c / 1000.0F * 100.0F) / 100.0F;
      ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698894, new Object[] { String.valueOf(f) }));
      break;
      label550:
      localObject1 = paramamwm.jdField_b_of_type_JavaLangString;
      break label204;
      label558:
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
  }
  
  private void c()
  {
    setContentView(2131560831);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368311));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131372124));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372134));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377413));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366267));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131372267));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372268));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372321));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364335));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new amoc(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364800));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372126);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363425);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370032);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370031));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a()
  {
    super.show();
    int i = getWindow().getAttributes().width;
    int j = getWindow().getAttributes().height;
    int k = (i - aekt.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    int m = (j - aekt.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
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
  
  public void a(amwm paramamwm, ArLBSActivity paramArLBSActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSPOIDialog", 2, "bindView");
    }
    this.jdField_a_of_type_Amwm = paramamwm;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    Object localObject;
    if (!TextUtils.isEmpty(paramArLBSActivity.d))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(170.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.d, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = aekt.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.c))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849999);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArLBSActivity.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramArLBSActivity.e)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramArLBSActivity.e);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131701097));
    a(paramamwm);
  }
  
  public void b()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - aekt.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - aekt.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new amoe(this));
  }
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  protected void onStop()
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
 * Qualified Name:     amob
 * JD-Core Version:    0.7.0.1
 */