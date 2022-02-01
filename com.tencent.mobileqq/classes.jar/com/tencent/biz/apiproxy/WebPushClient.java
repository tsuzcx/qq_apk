package com.tencent.biz.apiproxy;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public class WebPushClient
{
  TroopMemberApiClient a;
  HashMap<Integer, WeakReference<WebPushClient.WebPushCallback>> b = new HashMap();
  
  public WebPushClient(TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.a = paramTroopMemberApiClient;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(int paramInt)
  {
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, WebPushClient.WebPushCallback paramWebPushCallback)
  {
    if (this.b.containsKey(Integer.valueOf(paramInt))) {
      this.b.remove(Integer.valueOf(paramInt));
    }
    this.b.put(Integer.valueOf(paramInt), new WeakReference(paramWebPushCallback));
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebPushClient", 2, "data is null");
      }
      return;
    }
    int i = paramBundle.getInt("msgType", -1);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebPushClient", 2, "type is 0");
      }
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.b.get(Integer.valueOf(i));
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((WebPushClient.WebPushCallback)localWeakReference.get()).a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.apiproxy.WebPushClient
 * JD-Core Version:    0.7.0.1
 */