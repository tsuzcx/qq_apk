package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

class QQMapActivity$9
  extends LbsManagerServiceOnLocationChangeListener
{
  QQMapActivity$9(QQMapActivity paramQQMapActivity, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (paramSosoLbsInfo.mLocation.address != null)) {
      str = paramSosoLbsInfo.mLocation.address;
    } else {
      str = "";
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLocationFinish errCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("get_location", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      localObject1 = new GeoPoint((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      Object localObject2;
      double d1;
      double d2;
      if (this.a.mIsGetMyLocation)
      {
        if (!this.a.startWithPos)
        {
          localObject2 = this.a.tencentMap;
          d1 = ((GeoPoint)localObject1).getLatitudeE6();
          Double.isNaN(d1);
          d1 /= 1000000.0D;
          d2 = ((GeoPoint)localObject1).getLongitudeE6();
          Double.isNaN(d2);
          ((TencentMap)localObject2).moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
          localObject2 = this.a;
          ((QQMapActivity)localObject2).location = str;
          ((QQMapActivity)localObject2).pinView.setVisibility(0);
          this.a.updateLocationAddress((GeoPoint)localObject1);
        }
        this.a.onFetchDataSuceeded();
        this.a.mIsGetMyLocation = false;
      }
      if (!this.a.startWithPos)
      {
        this.a.addMyPosition((GeoPoint)localObject1, str);
      }
      else
      {
        this.a.addSelfLay();
        long l = System.currentTimeMillis();
        if (l - this.a.mLastUpdateSelfPoiTime > 5000L)
        {
          if ((this.a.mDistanceTxt != null) && (this.a.mPolyLine == null))
          {
            d1 = ((GeoPoint)localObject1).getLongitudeE6();
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = ((GeoPoint)localObject1).getLatitudeE6();
            Double.isNaN(d2);
            d1 = QQMapRoutingHelper.a(d1, d2 / 1000000.0D, this.a.longitude, this.a.latitude);
            this.a.listenDistanceChange();
            this.a.mDistanceTxt.setText(QQMapRoutingHelper.a(d1));
          }
          localObject2 = this.a;
          ((QQMapActivity)localObject2).mSelfGeoPoint = ((GeoPoint)localObject1);
          ((QQMapActivity)localObject2).mSelfAddress = str;
          ((QQMapActivity)localObject2).mSelfPoiName = paramSosoLbsInfo.mLocation.name;
          if (this.a.mSelfLocationMarker != null)
          {
            paramSosoLbsInfo = this.a.mSelfLocationMarker;
            d1 = this.a.mSelfGeoPoint.getLatitudeE6();
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = this.a.mSelfGeoPoint.getLongitudeE6();
            Double.isNaN(d2);
            paramSosoLbsInfo.setPosition(new LatLng(d1, d2 / 1000000.0D));
            this.a.mSelfLocationMarker.setSnippet("");
            QQMapActivity.showInfoWindow(this.a.mSelfLocationMarker);
          }
          if (QLog.isColorLevel())
          {
            paramSosoLbsInfo = new StringBuilder();
            paramSosoLbsInfo.append("onLocationFinish, mSelfPoint=");
            paramSosoLbsInfo.append(this.a.mSelfGeoPoint);
            paramSosoLbsInfo.append(",addr=");
            paramSosoLbsInfo.append(str);
            paramSosoLbsInfo.append(",poiName=");
            paramSosoLbsInfo.append(this.a.mSelfPoiName);
            QLog.d("get_location", 2, paramSosoLbsInfo.toString());
          }
          this.a.mLastUpdateSelfPoiTime = l;
        }
      }
    }
    else
    {
      this.a.onFetchDataFailed();
      new Handler().post(new QQMapActivity.9.1(this));
    }
    try
    {
      this.a.dismissDialog(0);
      return;
    }
    catch (IllegalArgumentException paramSosoLbsInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.9
 * JD-Core Version:    0.7.0.1
 */