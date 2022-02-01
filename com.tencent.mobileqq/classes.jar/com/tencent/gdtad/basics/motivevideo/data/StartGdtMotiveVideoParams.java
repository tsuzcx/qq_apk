package com.tencent.gdtad.basics.motivevideo.data;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;

public class StartGdtMotiveVideoParams
{
  public Activity a;
  public GdtMotiveVideoPageData b;
  public GdtMotiveVideoPageData c;
  public ResultReceiver d;
  public boolean e = false;
  public Bundle f = new Bundle();
  public int g = 101;
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.a = paramActivity;
    localStartGdtMotiveVideoParams.b = paramGdtMotiveVideoPageData;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.a = paramActivity;
    localStartGdtMotiveVideoParams.b = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.g = paramInt;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, ResultReceiver paramResultReceiver)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.a = paramActivity;
    localStartGdtMotiveVideoParams.b = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.d = paramResultReceiver;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.a = paramActivity;
    localStartGdtMotiveVideoParams.b = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.f.putString("arg_callback", paramString);
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams b(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, ResultReceiver paramResultReceiver)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.a = paramActivity;
    localStartGdtMotiveVideoParams.b = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.d = paramResultReceiver;
    localStartGdtMotiveVideoParams.e = true;
    return localStartGdtMotiveVideoParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams
 * JD-Core Version:    0.7.0.1
 */