package com.tencent.biz.widgets;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PolyLineOverlay
  extends Overlay
{
  protected int a;
  protected Paint a;
  protected Path a;
  protected Point a;
  protected GeoPoint a;
  protected LatLngBounds a;
  protected List a;
  protected int b = -16777216;
  
  public PolyLineOverlay(List paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = new GeoPoint(0, 0);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    a(paramList);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      label41:
      LatLng localLatLng;
      for (paramList = null; localIterator.hasNext(); paramList = localLatLng)
      {
        localLatLng = (LatLng)localIterator.next();
        if ((localLatLng == null) || (localLatLng.equals(paramList))) {
          break label41;
        }
        this.jdField_a_of_type_JavaUtilList.add(localLatLng);
        localBuilder.include(localLatLng);
      }
    }
    this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLngBounds = localBuilder.build();
  }
  
  public boolean checkInBounds()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PolyLineOverlay", 2, "checkInBounds");
    }
    if (this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLngBounds == null) {}
    LatLngBounds localLatLngBounds;
    do
    {
      return false;
      localLatLngBounds = this.mapView.getProjection().getVisibleRegion().getLatLngBounds();
      if (localLatLngBounds == null) {
        return true;
      }
    } while ((!localLatLngBounds.contains(this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLngBounds)) && (!this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLngBounds.intersects(localLatLngBounds)));
    return true;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PolyLineOverlay", 2, "destroy");
    }
    super.destroy();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Int <= 0)) {}
    int j;
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.setLatitudeE6((int)(((LatLng)this.jdField_a_of_type_JavaUtilList.get(0)).getLatitude() * 1000000.0D));
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.setLongitudeE6((int)(((LatLng)this.jdField_a_of_type_JavaUtilList.get(0)).getLongitude() * 1000000.0D));
      paramMapView.getProjection().toPixels(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint, this.jdField_a_of_type_AndroidGraphicsPoint);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 1;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.setLatitudeE6((int)(((LatLng)this.jdField_a_of_type_JavaUtilList.get(i)).getLatitude() * 1000000.0D));
        this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.setLongitudeE6((int)(((LatLng)this.jdField_a_of_type_JavaUtilList.get(i)).getLongitude() * 1000000.0D));
        paramMapView.getProjection().toPixels(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint, this.jdField_a_of_type_AndroidGraphicsPoint);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
        i += 1;
      }
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (!QLog.isColorLevel());
    QLog.d("PolyLineOverlay", 2, "draw:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.PolyLineOverlay
 * JD-Core Version:    0.7.0.1
 */