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
    OP_CMDS.put("preview_impl", new Pair(Integer.valueOf(10001), Integer.valueOf(1001)));
    OP_CMDS.put("open_doc", new Pair(Integer.valueOf(10011), Integer.valueOf(1001)));
    OP_CMDS.put("convert_doc", new Pair(Integer.valueOf(10011), Integer.valueOf(1002)));
    OP_CMDS.put("open_sheet", new Pair(Integer.valueOf(10021), Integer.valueOf(1001)));
    OP_CMDS.put("convert_sheet", new Pair(Integer.valueOf(10021), Integer.valueOf(1002)));
    OP_CMDS.put("open_slide", new Pair(Integer.valueOf(10031), Integer.valueOf(1001)));
    OP_CMDS.put("convert_slide", new Pair(Integer.valueOf(10031), Integer.valueOf(1002)));
    OP_CMDS.put("open_pdf", new Pair(Integer.valueOf(10041), Integer.valueOf(1001)));
    CGI_URLS.put(1, "https://preview-report.docs.qq.com/online_docs_cgi/preview/module_report");
    CGI_URLS.put(2, "https://preview-report.docs.qq.com/online_docs_cgi/preview/log_report");
  }
  
  private static void report(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = (String)CGI_URLS.get(paramInt);
    } while (TextUtils.isEmpty(str));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Reporter
 * JD-Core Version:    0.7.0.1
 */