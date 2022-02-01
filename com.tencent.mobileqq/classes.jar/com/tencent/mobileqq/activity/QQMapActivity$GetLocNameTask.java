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
  protected GeoPoint a;
  TextView b;
  protected HttpClient c;
  
  public QQMapActivity$GetLocNameTask(QQMapActivity paramQQMapActivity, GeoPoint paramGeoPoint, TextView paramTextView)
  {
    this.a = paramGeoPoint;
    this.b = paramTextView;
    this.b.setTag(this.a);
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
      Object localObject = this.d.getApplicationContext();
      double d1 = this.a.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.a.getLongitudeE6();
      Double.isNaN(d2);
      localObject = ReverseGeocode.a((Context)localObject, d1, d2 / 1000000.0D, 3, this.c);
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
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (GeoPoint)((TextView)localObject).getTag();
      if ((((GeoPoint)localObject).getLatitudeE6() == this.a.getLatitudeE6()) && (((GeoPoint)localObject).getLongitudeE6() == this.a.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
      {
        if (this.d.startWithPos)
        {
          this.b.setText(paramString);
          this.b.setVisibility(0);
          return;
        }
        this.d.location = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.GetLocNameTask
 * JD-Core Version:    0.7.0.1
 */