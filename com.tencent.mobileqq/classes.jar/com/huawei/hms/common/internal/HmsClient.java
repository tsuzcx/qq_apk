package com.huawei.hms.common.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONObject;

public abstract class HmsClient
  extends BaseHmsClient
  implements AnyClient
{
  private static final String TAG = "HmsClient";
  
  public HmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    super(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
  
  public void post(IMessageEntity paramIMessageEntity, String paramString, AnyClient.CallBack paramCallBack)
  {
    if (paramCallBack == null)
    {
      HMSLog.e("HmsClient", "callback is invalid, discard.");
      return;
    }
    if (((paramIMessageEntity instanceof RequestHeader)) && (paramString != null))
    {
      if (!isConnected())
      {
        HMSLog.e("HmsClient", "post failed for no connected.");
        paramCallBack.onCallback(new ResponseHeader(1, 907135001, "Not Connected"), new JSONObject().toString());
        return;
      }
      RequestHeader localRequestHeader = (RequestHeader)paramIMessageEntity;
      paramIMessageEntity = new StringBuilder();
      paramIMessageEntity.append("post msg ");
      paramIMessageEntity.append(localRequestHeader);
      HMSLog.i("HmsClient", paramIMessageEntity.toString());
      paramIMessageEntity = getClientSettings().getCpActivity();
      if (paramIMessageEntity == null) {
        paramIMessageEntity = new BaseAdapter(this);
      } else {
        paramIMessageEntity = new BaseAdapter(this, paramIMessageEntity);
      }
      paramIMessageEntity.baseRequest(localRequestHeader.toJson(), paramString, localRequestHeader.getParcelable(), new HmsClient.BaseAdapterCallBack(this, paramCallBack));
      return;
    }
    HMSLog.e("HmsClient", "arguments is invalid.");
    paramCallBack.onCallback(new ResponseHeader(1, 907135000, "Args is invalid"), new JSONObject().toString());
  }
  
  public void updateSessionId(String paramString)
  {
    if (TextUtils.isEmpty(this.sessionId)) {
      this.sessionId = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HmsClient
 * JD-Core Version:    0.7.0.1
 */