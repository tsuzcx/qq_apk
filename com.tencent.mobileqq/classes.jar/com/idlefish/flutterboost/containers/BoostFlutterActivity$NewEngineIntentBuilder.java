package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class BoostFlutterActivity$NewEngineIntentBuilder
{
  private final Class<? extends BoostFlutterActivity> activityClass;
  private String backgroundMode = BoostFlutterActivity.DEFAULT_BACKGROUND_MODE;
  private Map params = new HashMap();
  private String url = "";
  
  protected BoostFlutterActivity$NewEngineIntentBuilder(@NonNull Class<? extends BoostFlutterActivity> paramClass)
  {
    this.activityClass = paramClass;
  }
  
  public NewEngineIntentBuilder backgroundMode(@NonNull BoostFlutterActivity.BackgroundMode paramBackgroundMode)
  {
    this.backgroundMode = paramBackgroundMode.name();
    return this;
  }
  
  public Intent build(@NonNull Context paramContext)
  {
    BoostFlutterActivity.SerializableMap localSerializableMap = new BoostFlutterActivity.SerializableMap();
    localSerializableMap.setMap(this.params);
    return new Intent(paramContext, this.activityClass).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", false).putExtra("url", this.url).putExtra("params", localSerializableMap);
  }
  
  public NewEngineIntentBuilder params(@NonNull Map paramMap)
  {
    this.params = paramMap;
    return this;
  }
  
  public NewEngineIntentBuilder url(@NonNull String paramString)
  {
    this.url = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.BoostFlutterActivity.NewEngineIntentBuilder
 * JD-Core Version:    0.7.0.1
 */