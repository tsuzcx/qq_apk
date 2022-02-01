package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KBPreDownloadConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    paramString = AladdinParseUtils.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if ((str1.equals("md5")) && (str2 != null))
      {
        KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_latest_app_md5", str2.toLowerCase());
      }
      else if (str1.equals("version_name"))
      {
        KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_latest_app_version_name", str2);
      }
      else if ((str1.equals("download_url")) && (str2 != null))
      {
        str1 = ReadInJoyStringUtils.a(str2);
        KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_kb_download_url", str1);
      }
      else if (str1.equals("enable_predownload"))
      {
        KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_enable_pre_download", TextUtils.equals("1", str2));
      }
    }
    if (!paramString.containsKey("md5")) {
      KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_latest_app_md5", null);
    }
    KBPDUtils.a();
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_latest_app_md5", null);
    KBPDUtils.a(ReadInJoyUtils.a(), "sp_key_latest_app_version_name", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.KBPreDownloadConfigHandler
 * JD-Core Version:    0.7.0.1
 */