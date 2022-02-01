package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.kwstudio.office.preview.IHostInterface;
import java.util.HashMap;
import java.util.Map;

public final class Reporter
{
  private static final SparseArray<String> CGI_URLS;
  static final Map<String, Pair<Integer, Integer>> OP_CMDS = new HashMap();
  public static final String OP_PREVIEW_CONVERT_DOC = "convert_doc";
  public static final String OP_PREVIEW_CONVERT_SHEET = "convert_sheet";
  public static final String OP_PREVIEW_CONVERT_SLIDE = "convert_slide";
  public static final String OP_PREVIEW_IMPL = "preview_impl";
  public static final String OP_PREVIEW_OPEN_DOC = "open_doc";
  public static final String OP_PREVIEW_OPEN_PDF = "open_pdf";
  public static final String OP_PREVIEW_OPEN_SHEET = "open_sheet";
  public static final String OP_PREVIEW_OPEN_SLIDE = "open_slide";
  private static final String TAG = "Reporter";
  private static final int TYPE_FLOW = 2;
  private static final int TYPE_OP = 1;
  
  static
  {
    CGI_URLS = new SparseArray();
    Object localObject1 = OP_CMDS;
    Integer localInteger = Integer.valueOf(1001);
    ((Map)localObject1).put("preview_impl", new Pair(Integer.valueOf(10001), localInteger));
    localObject1 = OP_CMDS;
    Object localObject2 = Integer.valueOf(10011);
    ((Map)localObject1).put("open_doc", new Pair(localObject2, localInteger));
    Object localObject3 = OP_CMDS;
    localObject1 = Integer.valueOf(1002);
    ((Map)localObject3).put("convert_doc", new Pair(localObject2, localObject1));
    localObject2 = OP_CMDS;
    localObject3 = Integer.valueOf(10021);
    ((Map)localObject2).put("open_sheet", new Pair(localObject3, localInteger));
    OP_CMDS.put("convert_sheet", new Pair(localObject3, localObject1));
    localObject2 = OP_CMDS;
    localObject3 = Integer.valueOf(10031);
    ((Map)localObject2).put("open_slide", new Pair(localObject3, localInteger));
    OP_CMDS.put("convert_slide", new Pair(localObject3, localObject1));
    OP_CMDS.put("open_pdf", new Pair(Integer.valueOf(10041), localInteger));
    CGI_URLS.put(1, "https://preview-report.docs.qq.com/online_docs_cgi/preview/module_report");
    CGI_URLS.put(2, "https://preview-report.docs.qq.com/online_docs_cgi/preview/log_report");
  }
  
  private static void report(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = (String)CGI_URLS.get(paramInt);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Noumenon.sHostInterface.sendHttpRequest(str, true, paramString, new Reporter.1(paramInt));
  }
  
  public static void reportEvent(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Noumenon.sHostInterface.reportEvent(paramString1, paramInt, paramString2);
  }
  
  public static void reportFlow(ReportParam paramReportParam)
  {
    if (paramReportParam == null) {
      return;
    }
    report(2, paramReportParam.getFlow());
  }
  
  public static void reportOp(ReportParam paramReportParam)
  {
    if (paramReportParam == null) {
      return;
    }
    report(1, paramReportParam.getOp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Reporter
 * JD-Core Version:    0.7.0.1
 */