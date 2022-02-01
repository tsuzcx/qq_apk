package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.embedding.android.FlutterView.RenderMode;
import java.util.Map;

public abstract class Platform
{
  public FlutterBoost.BoostLifecycleListener lifecycleListener;
  
  public void closeContainer(IContainerRecord paramIContainerRecord, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (paramIContainerRecord == null) {
      return;
    }
    paramIContainerRecord.getContainer().finishContainer(paramMap1);
  }
  
  public abstract Application getApplication();
  
  public abstract String initialRoute();
  
  public abstract boolean isDebug();
  
  public abstract void openContainer(Context paramContext, String paramString, Map<String, Object> paramMap1, int paramInt, Map<String, Object> paramMap2);
  
  public abstract FlutterView.RenderMode renderMode();
  
  public abstract int whenEngineStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.Platform
 * JD-Core Version:    0.7.0.1
 */