package com.tencent.biz;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import klz;
import org.apache.http.client.HttpClient;

public class PoiMapActivity$PoiMapNameTask
  extends AsyncTask
{
  protected GeoPoint a;
  protected HttpClient a;
  protected GeoPoint b;
  
  public PoiMapActivity$PoiMapNameTask(PoiMapActivity paramPoiMapActivity) {}
  
  protected String a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = "Unknown Address";
    int i = 0;
    if (i < 3)
    {
      if ((isCancelled()) || (this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
      {
        localObject = "Unknown Address";
        label60:
        return localObject;
      }
      paramVarArgs = ReverseGeocode.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getApplicationContext(), this.b.getLatitudeE6() / 1000000.0D, this.b.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("rec_locate", "call_googlestation", "", "", "", "");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (paramVarArgs != null) {
          break label187;
        }
      }
      label187:
      for (Object localObject = "";; localObject = paramVarArgs)
      {
        QLog.i("fetch_address", 2, (String)localObject);
        if (paramVarArgs != null)
        {
          localObject = paramVarArgs;
          if (paramVarArgs.length() > 0) {
            break label60;
          }
        }
        i += 1;
        break;
      }
    }
    return "Unknown Address";
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.b = paramGeoPoint;
  }
  
  protected void a(String paramString)
  {
    if ((this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i)) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = "Unknown Address";; str = paramString)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.runOnUiThread(new klz(this, str));
      if (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint == null) {
        break;
      }
      paramString = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramString.a(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = null;
      return;
    }
  }
  
  protected void onCancelled()
  {
    if ((this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint != null) && (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
    {
      PoiMapNameTask localPoiMapNameTask = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      localPoiMapNameTask.a(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = localPoiMapNameTask;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiMapNameTask
 * JD-Core Version:    0.7.0.1
 */