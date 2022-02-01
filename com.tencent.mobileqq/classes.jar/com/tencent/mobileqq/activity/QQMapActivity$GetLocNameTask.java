package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.HttpClient;

public class QQMapActivity$GetLocNameTask
  extends AsyncTask<GeoPoint, Void, String>
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected GeoPoint a;
  protected HttpClient a;
  
  public QQMapActivity$GetLocNameTask(QQMapActivity paramQQMapActivity, GeoPoint paramGeoPoint, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
  }
  
  protected String a(GeoPoint... paramVarArgs)
  {
    int i = 0;
    for (;;)
    {
      paramVarArgs = "";
      if (i >= 3) {
        break;
      }
      if (isCancelled()) {
        return "";
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.getApplicationContext();
      double d1 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
      Double.isNaN(d2);
      localObject = ReverseGeocode.a((Context)localObject, d1, d2 / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append(" time: ReverseGeocode.getFromLocation, address: ");
        if (localObject != null) {
          paramVarArgs = (GeoPoint[])localObject;
        }
        localStringBuilder.append(paramVarArgs);
        QLog.i("fetch_address", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        return localObject;
      }
      i += 1;
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get address finish, onPostExecute, result:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("fetch_address", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      localObject = (GeoPoint)((TextView)localObject).getTag();
      if ((((GeoPoint)localObject).getLatitudeE6() == this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6()) && (((GeoPoint)localObject).getLongitudeE6() == this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.startWithPos)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.location = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.GetLocNameTask
 * JD-Core Version:    0.7.0.1
 */