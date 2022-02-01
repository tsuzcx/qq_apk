package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.download.DownloadListener;
import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class KBPDUtils$KBDownloadListener
  implements DownloadListener
{
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onDownloadStateChanged] url=" + paramString1 + " savedPath=" + paramString2 + " errorCode=" + paramInt2 + " errorMsg=" + paramString3);
    if (!TextUtils.equals(paramString1, KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_kb_download_url"))) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 4: 
      long l = System.currentTimeMillis() - KBPDUtils.a();
      QLog.d("KBPreDownloadUtils", 2, "[onDownloadFinish] cost=" + l + "ms, info=" + paramString1);
      paramString3 = BaseApplicationImpl.getApplication();
      if (paramString3 != null)
      {
        KBPDUtils.a(paramString3, paramString2);
        KBPDUtils.a(true, l, 0);
        KBPDUtils.a(paramString1, paramString2);
        ReadInJoyDownloader.a().a(KBPDUtils.a());
        return;
      }
      QLog.e("KBPreDownloadUtils", 1, "[onDownloadStateChanged] return since context is null");
      return;
    }
    QLog.e("KBPreDownloadUtils", 1, "[onDownloadError] errorCode=" + paramInt2 + ", errorMsg=" + paramString3);
    KBPDUtils.a(false, System.currentTimeMillis() - KBPDUtils.a(), paramInt2);
    ReadInJoyDownloader.a().a(KBPDUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.KBDownloadListener
 * JD-Core Version:    0.7.0.1
 */