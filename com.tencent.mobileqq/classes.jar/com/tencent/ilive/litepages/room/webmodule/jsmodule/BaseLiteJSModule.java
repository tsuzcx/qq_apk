package com.tencent.ilive.litepages.room.webmodule.jsmodule;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import org.json.JSONObject;

public abstract class BaseLiteJSModule
{
  private static final String TAG = "LiteBaseJSModule";
  protected boolean isInit = false;
  public Context mContext;
  protected JsBizAdapter mJsBizAdapter;
  
  public BaseLiteJSModule(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    this.mContext = paramContext;
    this.mJsBizAdapter = paramJsBizAdapter;
  }
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject)
  {
    if (this.mJsBizAdapter != null) {
      this.mJsBizAdapter.callJsFunctionByNative(paramString, paramJSONObject, null);
    }
  }
  
  public JsBizAdapter getJsBizAdapter()
  {
    return this.mJsBizAdapter;
  }
  
  public abstract String getName();
  
  public final boolean isInit()
  {
    return this.isInit;
  }
  
  protected void logD(String paramString1, String paramString2)
  {
    if ((this.mJsBizAdapter != null) && (this.mJsBizAdapter.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().d("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  public void logE(String paramString1, String paramString2)
  {
    if ((this.mJsBizAdapter != null) && (this.mJsBizAdapter.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().e("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  public void logI(String paramString1, String paramString2)
  {
    if ((this.mJsBizAdapter != null) && (this.mJsBizAdapter.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().i("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  public void onJsCreate() {}
  
  public void onJsDestroy() {}
  
  protected void postEvent(ModuleEventInterface paramModuleEventInterface)
  {
    if ((this.mJsBizAdapter != null) && (this.mJsBizAdapter.getModuleEvent() != null)) {
      this.mJsBizAdapter.getModuleEvent().post(paramModuleEventInterface);
    }
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.isInit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule
 * JD-Core Version:    0.7.0.1
 */