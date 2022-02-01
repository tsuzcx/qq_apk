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
  protected GeoPoint b;
  protected HttpClient c;
  
  public PoiMapActivity$PoiMapNameTask(PoiMapActivity paramPoiMapActivity) {}
  
  protected String a(Void... paramVarArgs)
  {
    this.d.mCurPoiAdr = "Unknown Address";
    int i = 0;
    while ((i < 3) && (!isCancelled()) && (this.b.getLatitudeE6() == this.d.m))
    {
      if (this.b.getLongitudeE6() != this.d.n) {
        return "Unknown Address";
      }
      paramVarArgs = this.d.getApplicationContext();
      double d1 = this.b.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.b.getLongitudeE6();
      Double.isNaN(d2);
      String str = ReverseGeocode.a(paramVarArgs, d1, d2 / 1000000.0D, 3, this.c);
      this.d.a("rec_locate", "call_googlestation", "", "", "", "");
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
    if (this.b.getLatitudeE6() == this.d.m)
    {
      if (this.b.getLongitudeE6() != this.d.n) {
        return;
      }
      Object localObject;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "Unknown Address";
      } else {
        localObject = paramString;
      }
      PoiMapActivity localPoiMapActivity = this.d;
      localPoiMapActivity.mCurPoiAdr = paramString;
      localPoiMapActivity.runOnUiThread(new PoiMapActivity.PoiMapNameTask.1(this, (String)localObject));
      if (this.a != null)
      {
        paramString = new PoiMapNameTask(this.d);
        paramString.a(this.a);
        localObject = this.d;
        ((PoiMapActivity)localObject).Y = paramString;
        ((PoiMapActivity)localObject).Y.execute(new Void[0]);
        this.a = null;
      }
    }
  }
  
  protected void onCancelled()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((GeoPoint)localObject).getLatitudeE6() == this.d.m) && (this.a.getLongitudeE6() == this.d.n))
    {
      localObject = new PoiMapNameTask(this.d);
      ((PoiMapNameTask)localObject).a(this.a);
      PoiMapActivity localPoiMapActivity = this.d;
      localPoiMapActivity.Y = ((PoiMapNameTask)localObject);
      localPoiMapActivity.Y.execute(new Void[0]);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiMapNameTask
 * JD-Core Version:    0.7.0.1
 */