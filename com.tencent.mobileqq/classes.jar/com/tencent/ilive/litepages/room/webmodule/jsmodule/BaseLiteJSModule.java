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
  protected Context mContext;
  protected JsBizAdapter mJsBizAdapter;
  
  public BaseLiteJSModule(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    this.mContext = paramContext;
    this.mJsBizAdapter = paramJsBizAdapter;
  }
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject)
  {
    JsBizAdapter localJsBizAdapter = this.mJsBizAdapter;
    if (localJsBizAdapter != null) {
      localJsBizAdapter.callJsFunctionByNative(paramString, paramJSONObject, null);
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
    paramString1 = this.mJsBizAdapter;
    if ((paramString1 != null) && (paramString1.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().d("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  protected void logE(String paramString1, String paramString2)
  {
    paramString1 = this.mJsBizAdapter;
    if ((paramString1 != null) && (paramString1.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().e("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  protected void logI(String paramString1, String paramString2)
  {
    paramString1 = this.mJsBizAdapter;
    if ((paramString1 != null) && (paramString1.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().i("LiteBaseJSModule", paramString2, new Object[0]);
    }
  }
  
  public void onJsCreate() {}
  
  public void onJsDestroy() {}
  
  protected void postEvent(ModuleEventInterface paramModuleEventInterface)
  {
    JsBizAdapter localJsBizAdapter = this.mJsBizAdapter;
    if ((localJsBizAdapter != null) && (localJsBizAdapter.getModuleEvent() != null)) {
      this.mJsBizAdapter.getModuleEvent().post(paramModuleEventInterface);
    }
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.isInit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule
 * JD-Core Version:    0.7.0.1
 */