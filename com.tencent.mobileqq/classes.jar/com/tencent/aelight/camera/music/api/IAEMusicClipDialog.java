package com.tencent.aelight.camera.music.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IAEMusicClipDialog
  extends QRouteApi
{
  public abstract void setIsQCircle(boolean paramBoolean);
  
  public abstract void showMusicClipDialogOnWebView(JSONObject paramJSONObject, Context paramContext);
  
  public abstract void showMusicSelectLoadingOnWebView(JSONObject paramJSONObject, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.music.api.IAEMusicClipDialog
 * JD-Core Version:    0.7.0.1
 */