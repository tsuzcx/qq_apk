package com.tencent.comic.api.hippy;

import android.app.Activity;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

public abstract interface IBoodoModule
{
  public abstract void doPromiseCallback(Promise paramPromise, int paramInt, String paramString);
  
  public abstract void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject);
  
  public abstract void downloadComic(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract Activity getActivity();
  
  public abstract void getDownloadList(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract HippyEngine getHippyEngine();
  
  public abstract void getPageTrace(Promise paramPromise);
  
  public abstract void getReportInfo(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void mainTabAppear(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void modifyDownloadStatus(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void notifyWebStatus(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void openComicIntro(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void openDownloadDetail(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void popPage();
  
  public abstract void pushPage(HippyMap paramHippyMap);
  
  public abstract void pushPageStack(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void queryDownloadProgress(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void report(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void reportDC01327(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void startRead(HippyMap paramHippyMap, Promise paramPromise);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.hippy.IBoodoModule
 * JD-Core Version:    0.7.0.1
 */