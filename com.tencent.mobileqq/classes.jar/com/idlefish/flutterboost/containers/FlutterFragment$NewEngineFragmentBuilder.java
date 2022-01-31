package com.idlefish.flutterboost.containers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class FlutterFragment$NewEngineFragmentBuilder
{
  private final Class<? extends FlutterFragment> fragmentClass;
  private Map params = new HashMap();
  private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
  private FlutterShellArgs shellArgs = null;
  private boolean shouldAttachEngineToActivity = true;
  private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
  private String url = "";
  
  public FlutterFragment$NewEngineFragmentBuilder()
  {
    this.fragmentClass = FlutterFragment.class;
  }
  
  public FlutterFragment$NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass)
  {
    this.fragmentClass = paramClass;
  }
  
  @NonNull
  public <T extends FlutterFragment> T build()
  {
    try
    {
      Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localObject != null)
      {
        ((FlutterFragment)localObject).setArguments(createArgs());
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("The NewFlutterFragment subclass sent in the constructor (");
      ((StringBuilder)localObject).append(this.fragmentClass.getCanonicalName());
      ((StringBuilder)localObject).append(") does not match the expected return type.");
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not instantiate NewFlutterFragment subclass (");
      localStringBuilder.append(this.fragmentClass.getName());
      localStringBuilder.append(")");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
  
  @NonNull
  protected Bundle createArgs()
  {
    Bundle localBundle = new Bundle();
    if (this.shellArgs != null) {
      localBundle.putStringArray("initialization_args", this.shellArgs.toArray());
    }
    Object localObject = new BoostFlutterActivity.SerializableMap();
    ((BoostFlutterActivity.SerializableMap)localObject).setMap(this.params);
    localBundle.putString("url", this.url);
    localBundle.putSerializable("params", (Serializable)localObject);
    if (this.renderMode != null)
    {
      localObject = this.renderMode;
      localBundle.putString("flutterview_render_mode", ((FlutterView.RenderMode)localObject).name());
      if (this.transparencyMode == null) {
        break label121;
      }
    }
    label121:
    for (localObject = this.transparencyMode;; localObject = FlutterView.TransparencyMode.transparent)
    {
      localBundle.putString("flutterview_transparency_mode", ((FlutterView.TransparencyMode)localObject).name());
      localBundle.putBoolean("destroy_engine_with_fragment", true);
      return localBundle;
      localObject = FlutterView.RenderMode.surface;
      break;
    }
  }
  
  @NonNull
  public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs paramFlutterShellArgs)
  {
    this.shellArgs = paramFlutterShellArgs;
    return this;
  }
  
  public NewEngineFragmentBuilder params(@NonNull Map paramMap)
  {
    this.params = paramMap;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder renderMode(@NonNull FlutterView.RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder transparencyMode(@NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    this.transparencyMode = paramTransparencyMode;
    return this;
  }
  
  public NewEngineFragmentBuilder url(@NonNull String paramString)
  {
    this.url = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterFragment.NewEngineFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */