package com.qq.im.poi;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import java.io.File;

public class LbsDistancePOIDialog
  extends Dialog
  implements ResDownloadManager.IResDownloadListener, TencentMap.OnMapLoadedListener
{
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  ARMapActivity jdField_a_of_type_ComTencentMobileqqArmapARMapActivity;
  MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  RelativeLayout b;
  
  public void a(TencentMap paramTencentMap, int paramInt1, int paramInt2)
  {
    Projection localProjection = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getProjection();
    Point localPoint = localProjection.toScreenLocation(paramTencentMap.getMapCenter());
    localPoint.offset(paramInt1, paramInt2);
    paramTencentMap.setCenter(localProjection.fromScreenLocation(localPoint));
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(Drawable.createFromPath(paramString3 + File.separator + "banner.png"));
      this.b.setBackgroundDrawable(Drawable.createFromPath(paramString3 + File.separator + "background.png"));
    }
  }
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void onMapLoaded()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.e = true;
    a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getMap(), 0, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * -1);
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
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsDistancePOIDialog
 * JD-Core Version:    0.7.0.1
 */