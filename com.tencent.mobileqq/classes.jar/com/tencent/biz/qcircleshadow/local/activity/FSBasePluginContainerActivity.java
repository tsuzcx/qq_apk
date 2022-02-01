package com.tencent.biz.qcircleshadow.local.activity;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants.BusinessKeyToUUID;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

public class FSBasePluginContainerActivity
  extends PluginContainerActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getUUID()
  {
    return (String)ASEngineConstants.BusinessKeyToUUID.sUUID.get("flash-show-app");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.activity.FSBasePluginContainerActivity
 * JD-Core Version:    0.7.0.1
 */