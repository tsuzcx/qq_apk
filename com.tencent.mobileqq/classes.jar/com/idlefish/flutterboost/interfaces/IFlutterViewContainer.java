package com.idlefish.flutterboost.interfaces;

import android.app.Activity;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import java.util.Map;

public abstract interface IFlutterViewContainer
{
  public static final String RESULT_KEY = "_flutter_result_";
  
  public abstract void finishContainer(Map<String, Object> paramMap);
  
  public abstract FlutterSplashView getBoostFlutterView();
  
  public abstract String getContainerUrl();
  
  public abstract Map getContainerUrlParams();
  
  public abstract Activity getContextActivity();
  
  public abstract void onContainerHidden();
  
  public abstract void onContainerShown();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.interfaces.IFlutterViewContainer
 * JD-Core Version:    0.7.0.1
 */