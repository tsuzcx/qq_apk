package com.tencent.biz;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.HttpClient;

public class PoiMapActivity$PoiMapNameTask
  extends AsyncTask<Void, Void, String>
{
  protected GeoPoint a;
  protected HttpClient a;
  protected GeoPoint b;
  
  public PoiMapActivity$PoiMapNameTask(PoiMapActivity paramPoiMapActivity) {}
  
  protected String a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.mCurPoiAdr = "Unknown Address";
    int i = 0;
    while ((i < 3) && (!isCancelled()) && (this.b.getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h))
    {
      if (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) {
        return "Unknown Address";
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getApplicationContext();
      double d1 = this.b.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.b.getLongitudeE6();
      Double.isNaN(d2);
      String str = ReverseGeocode.a(paramVarArgs, d1, d2 / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("rec_locate", "call_googlestation", "", "", "", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append(" time: ReverseGeocode.getFromLocation, address: ");
        if (str == null) {
          paramVarArgs = "";
        } else {
          paramVarArgs = str;
        }
        localStringBuilder.append(paramVarArgs);
        QLog.i("fetch_address", 2, localStringBuilder.toString());
      }
      if ((str != null) && (str.length() > 0)) {
        return str;
      }
      i += 1;
    }
    return "Unknown Address";
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.b = paramGeoPoint;
  }
  
  protected void a(String paramString)
  {
    if (this.b.getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h)
    {
      if (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) {
        return;
      }
      Object localObject;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "Unknown Address";
      } else {
        localObject = paramString;
      }
      PoiMapActivity localPoiMapActivity = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
      localPoiMapActivity.mCurPoiAdr = paramString;
      localPoiMapActivity.runOnUiThread(new PoiMapActivity.PoiMapNameTask.1(this, (String)localObject));
      if (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint != null)
      {
        paramString = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        paramString.a(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
        localObject = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
        ((PoiMapActivity)localObject).a = paramString;
        ((PoiMapActivity)localObject).a.execute(new Void[0]);
        this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = null;
      }
    }
  }
  
  protected void onCancelled()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint;
    if ((localObject != null) && (((GeoPoint)localObject).getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
    {
      localObject = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      ((PoiMapNameTask)localObject).a(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
      PoiMapActivity localPoiMapActivity = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
      localPoiMapActivity.a = ((PoiMapNameTask)localObject);
      localPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiMapNameTask
 * JD-Core Version:    0.7.0.1
 */