package com.tencent.mobileqq.armap.map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.tencentmap.mapsdk.map.MapView;

public class ARMapPOIDialog
  extends Dialog
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public LbsPackObserver a;
  NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver;
  MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onPause();
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ARMapActivity)) && (((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).app != null))
    {
      ((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).app.a.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
      ((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).app.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapPOIDialog
 * JD-Core Version:    0.7.0.1
 */