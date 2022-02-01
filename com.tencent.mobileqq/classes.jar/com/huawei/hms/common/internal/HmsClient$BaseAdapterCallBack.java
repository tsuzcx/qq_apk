package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hms.adapter.BaseAdapter.BaseCallBack;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class HmsClient$BaseAdapterCallBack
  implements BaseAdapter.BaseCallBack
{
  private final AnyClient.CallBack callback;
  private final WeakReference<HmsClient> hmsClient;
  
  HmsClient$BaseAdapterCallBack(HmsClient paramHmsClient, AnyClient.CallBack paramCallBack)
  {
    this.callback = paramCallBack;
    this.hmsClient = new WeakReference(paramHmsClient);
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    ResponseHeader localResponseHeader = new ResponseHeader();
    if (localResponseHeader.fromJson(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("receive msg ");
      paramString1.append(localResponseHeader);
      HMSLog.i("HmsClient", paramString1.toString());
      updateSessionId(localResponseHeader.getSessionId());
      this.callback.onCallback(localResponseHeader, paramString2);
      return;
    }
    this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
  
  private void doCallback(String paramString1, String paramString2, Parcelable paramParcelable)
  {
    ResponseHeader localResponseHeader = new ResponseHeader();
    if (localResponseHeader.fromJson(paramString1))
    {
      localResponseHeader.setParcelable(paramParcelable);
      paramString1 = new StringBuilder();
      paramString1.append("receive msg ");
      paramString1.append(localResponseHeader);
      HMSLog.i("HmsClient", paramString1.toString());
      updateSessionId(localResponseHeader.getSessionId());
      this.callback.onCallback(localResponseHeader, paramString2);
      return;
    }
    this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
  
  private void updateSessionId(String paramString)
  {
    HmsClient localHmsClient = (HmsClient)this.hmsClient.get();
    if (localHmsClient != null) {
      localHmsClient.updateSessionId(paramString);
    }
  }
  
  public void onComplete(String paramString1, String paramString2, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      doCallback(paramString1, paramString2);
      return;
    }
    doCallback(paramString1, paramString2, paramParcelable);
  }
  
  public void onError(String paramString)
  {
    ResponseWrap localResponseWrap = new ResponseWrap(new ResponseHeader());
    if (localResponseWrap.fromJson(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("receive msg ");
      paramString.append(localResponseWrap);
      HMSLog.i("HmsClient", paramString.toString());
      paramString = localResponseWrap.getResponseHeader();
      updateSessionId(paramString.getSessionId());
      this.callback.onCallback(paramString, localResponseWrap.getBody());
      return;
    }
    this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.HmsClient.BaseAdapterCallBack
 * JD-Core Version:    0.7.0.1
 */