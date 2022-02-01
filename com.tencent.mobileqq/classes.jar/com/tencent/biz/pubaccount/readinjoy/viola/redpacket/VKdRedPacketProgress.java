package com.tencent.biz.pubaccount.readinjoy.viola.redpacket;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pmk;
import pmn;
import trc;

public class VKdRedPacketProgress
  extends VComponentContainer<VKdRedPacketLayout>
{
  private static final String TAG = "VKdRedPacketProgress";
  pmn mObserver;
  private RIJRedPacketProgressView mRedPacketProgressView;
  
  public VKdRedPacketProgress(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  @JSMethod
  public void endTiming()
  {
    if (this.mRedPacketProgressView != null)
    {
      this.mRedPacketProgressView.b();
      this.mRedPacketProgressView.c();
    }
  }
  
  @JSMethod
  public void getState(String paramString)
  {
    JSONObject localJSONObject;
    if ((this.mRedPacketProgressView != null) && (!TextUtils.isEmpty(paramString)) && (ViolaBridgeManager.getInstance() != null)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", this.mRedPacketProgressView.a());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public VKdRedPacketLayout initComponentHostView(Context paramContext)
  {
    VKdRedPacketLayout localVKdRedPacketLayout = new VKdRedPacketLayout(paramContext);
    localVKdRedPacketLayout.a(this);
    this.mRedPacketProgressView = new RIJRedPacketProgressView(paramContext);
    this.mRedPacketProgressView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localVKdRedPacketLayout.addView(this.mRedPacketProgressView);
    this.mRedPacketProgressView.a();
    this.mObserver = new trc(this);
    pmk.a().a(this.mObserver);
    return localVKdRedPacketLayout;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    pmk.a().b(this.mObserver);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.mRedPacketProgressView != null) {
      this.mRedPacketProgressView.c();
    }
  }
  
  public void removedByJs()
  {
    pmk.a().b(this.mObserver);
  }
  
  @JSMethod
  public void startTiming(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("rowkey"))) && (this.mRedPacketProgressView != null))
    {
      String str = paramJSONObject.optString("rowkey");
      int i = paramJSONObject.optInt("duration");
      this.mRedPacketProgressView.a(str, i, 2, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.redpacket.VKdRedPacketProgress
 * JD-Core Version:    0.7.0.1
 */