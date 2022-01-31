package com.tencent.biz.common.offline.util;

import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import java.util.Map;

public abstract interface IOfflineDownloader
{
  public abstract int a(Context paramContext, String paramString);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.IOfflineDownloader
 * JD-Core Version:    0.7.0.1
 */