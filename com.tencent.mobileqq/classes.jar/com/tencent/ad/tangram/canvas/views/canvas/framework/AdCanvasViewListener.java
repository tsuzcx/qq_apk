package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;

@Keep
public abstract interface AdCanvasViewListener
{
  public abstract void commonButtonClick(String paramString1, boolean paramBoolean, String paramString2, String paramString3);
  
  public abstract AdCanvasPageView getContentView();
  
  public abstract AdCanvasData getData();
  
  public abstract AdAppDownloadManager getDownloadManager();
  
  public abstract void hotAreaClick(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onLoaded(AdCanvasComponentData paramAdCanvasComponentData, long paramLong, boolean paramBoolean);
  
  public abstract void setPageViewTopMargin(int paramInt);
  
  public abstract void showProgressBar(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener
 * JD-Core Version:    0.7.0.1
 */