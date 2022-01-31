package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.SensorManager;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class SelfLocationOverlay
  extends Overlay
{
  protected float a;
  protected long a;
  protected Bitmap a;
  protected Paint a;
  protected Point a;
  protected Rect a;
  protected SensorManager a;
  protected SelfLocationOverlay.SensorListener a;
  protected GeoPoint a;
  protected QQMapView a;
  
  public SelfLocationOverlay(Context paramContext, Bitmap paramBitmap, GeoPoint paramGeoPoint, QQMapView paramQQMapView)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = paramQQMapView;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(3);
    this.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay$SensorListener = new SelfLocationOverlay.SensorListener(this, this.jdField_a_of_type_AndroidHardwareSensorManager);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay$SensorListener, paramContext, 2);
  }
  
  protected void a(float paramFloat)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 1000L)
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (QLog.isColorLevel()) {
        QLog.d("SelfLocationOverlay", 2, "onOrientationChanged:" + paramFloat);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidateOverLay();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidate();
      }
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint != null) {
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    try
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay$SensorListener);
      if (QLog.isColorLevel()) {
        QLog.d("SelfLocationOverlay", 2, "destroy:unregister sensorListener");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("SelfLocationOverlay", 2, "destroy:", localException);
    }
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = paramMapView.getProjection().toPixels(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint, this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsPoint.x - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, this.jdField_a_of_type_AndroidGraphicsPoint.y - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_AndroidGraphicsPoint.x + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, this.jdField_a_of_type_AndroidGraphicsPoint.y + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
    paramCanvas.save();
    paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.SelfLocationOverlay
 * JD-Core Version:    0.7.0.1
 */