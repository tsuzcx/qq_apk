package com.tencent.biz.qqcircle.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;

public class QCircleCopyUtils
{
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
      if (paramContext == null)
      {
        QLog.e("QCircleCopyUtils", 1, "copyTextToClipboard  clipboardManager == null");
        return;
      }
      paramString = ClipData.newPlainText("", RichTextAtParser.a(paramString));
      ClipboardMonitor.setPrimaryClip(paramContext, paramString);
      paramContext.setPrimaryClip(paramString);
      return;
    }
    QLog.e("QCircleCopyUtils", 1, "copyTextToClipboard  context == null || TextUtils.isEmpty(text)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCopyUtils
 * JD-Core Version:    0.7.0.1
 */