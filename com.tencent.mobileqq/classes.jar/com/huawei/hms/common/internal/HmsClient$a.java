package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hms.adapter.BaseAdapter.BaseCallBack;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class HmsClient$a
  implements BaseAdapter.BaseCallBack
{
  private final AnyClient.CallBack a;
  private final WeakReference<HmsClient> b;
  
  HmsClient$a(HmsClient paramHmsClient, AnyClient.CallBack paramCallBack)
  {
    this.a = paramCallBack;
    this.b = new WeakReference(paramHmsClient);
  }
  
  private void a(String paramString)
  {
    HmsClient localHmsClient = (HmsClient)this.b.get();
    if (localHmsClient != null) {
      localHmsClient.updateSessionId(paramString);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ResponseHeader localResponseHeader = new ResponseHeader();
    if (localResponseHeader.fromJson(paramString1))
    {
      HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
      a(localResponseHeader.getSessionId());
      this.a.onCallback(localResponseHeader, paramString2);
      return;
    }
    this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
  
  private void a(String paramString1, String paramString2, Parcelable paramParcelable)
  {
    ResponseHeader localResponseHeader = new ResponseHeader();
    if (localResponseHeader.fromJson(paramString1))
    {
      localResponseHeader.setParcelable(paramParcelable);
      HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
      a(localResponseHeader.getSessionId());
      this.a.onCallback(localResponseHeader, paramString2);
      return;
    }
    this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
  
  public void onComplete(String paramString1, String paramString2, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      a(paramString1, paramString2);
      return;
    }
    a(paramString1, paramString2, paramParcelable);
  }
  
  public void onError(String paramString)
  {
    ResponseHeader localResponseHeader = new ResponseHeader();
    if (localResponseHeader.fromJson(paramString))
    {
      HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
      a(localResponseHeader.getSessionId());
      this.a.onCallback(localResponseHeader, new JSONObject().toString());
      return;
    }
    this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.HmsClient.a
 * JD-Core Version:    0.7.0.1
 */