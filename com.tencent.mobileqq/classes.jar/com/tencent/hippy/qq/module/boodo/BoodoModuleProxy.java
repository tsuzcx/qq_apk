package com.tencent.hippy.qq.module.boodo;

import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

public abstract interface BoodoModuleProxy
{
  public static final String METHOD_DOWNLOAD_COMIC = "downloadComic";
  public static final String METHOD_GET_DOWNLOAD_LIST = "getDownloadList";
  public static final String METHOD_GET_REPORT_INFO = "getReportInfo";
  public static final String METHOD_MAIN_TAB_APPEAR = "mainTabAppear";
  public static final String METHOD_MODIFY_DOWNLOAD_STATUS = "modifyDownloadStatus";
  public static final String METHOD_OPEN_COMIC_INTRO = "openComicIntro";
  public static final String METHOD_OPEN_DOWNLOAD_DETAIL = "openDownloadDetail";
  public static final String METHOD_PAGE_GET_TRACE = "getPageTrace";
  public static final String METHOD_PAGE_POP = "popPage";
  public static final String METHOD_PAGE_PUSH = "pushPage";
  public static final String METHOD_PUSH_PAGE_STACK = "pushPageStack";
  public static final String METHOD_QUERY_DOWNLOAD_PROGRESS = "queryDownloadProgress";
  public static final String METHOD_REPORT = "report";
  public static final String METHOD_REPORT_01327 = "reportDC01327";
  public static final String METHOD_START_READ = "startRead";
  
  public abstract void callModule(BoodoModule paramBoodoModule, String paramString, JSONObject paramJSONObject, Promise paramPromise);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.boodo.BoodoModuleProxy
 * JD-Core Version:    0.7.0.1
 */