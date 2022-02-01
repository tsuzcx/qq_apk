package com.tencent.comic.api.impl;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.comic.utils.AppHelper;
import com.tencent.qphone.base.util.QLog;

final class QQDcReporterImpl$2
  implements IAsyncQimeiListener
{
  public void onQimeiDispatch(Qimei paramQimei)
  {
    if ((paramQimei != null) && (TextUtils.isEmpty(QQDcReporterImpl.access$000()))) {
      QQDcReporterImpl.access$002(paramQimei.getQimeiNew());
    }
    if (QLog.isColorLevel())
    {
      paramQimei = new StringBuilder();
      paramQimei.append("getQimei onQimeiDispatch qimei:");
      paramQimei.append(QQDcReporterImpl.access$000());
      QLog.i("VipComicReportUtils", 1, paramQimei.toString());
    }
    AppHelper.a().getSharedPreferences("fileSystemInfo_", 4).edit().putString("qimei_new", QQDcReporterImpl.access$000()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQDcReporterImpl.2
 * JD-Core Version:    0.7.0.1
 */