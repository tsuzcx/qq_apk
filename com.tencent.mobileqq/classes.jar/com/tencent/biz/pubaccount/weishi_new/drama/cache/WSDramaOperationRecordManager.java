package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSDramaFollowRequest;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSUpdateWatchDramaRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSDramaOperationRecordManager
{
  public static void a(String paramString, int paramInt, IFetchDataListener<Integer> paramIFetchDataListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[followDrama] dramaId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", followStatus:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSDramaOperationRecordManager", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WSNetService.a(new WSDramaFollowRequest(paramString, paramInt)).a(new WSDramaOperationRecordManager.2(paramString, paramIFetchDataListener));
  }
  
  public static boolean a(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDramaWatchRecord() dramaId = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", feedId = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", episodeNum = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", playSecond = ");
    localStringBuilder.append(paramInt2);
    WSLog.a("WSDramaOperationRecordManager", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      WSNetService.a(new WSUpdateWatchDramaRequest(paramString1, paramString2, paramInt1, paramInt2)).a(new WSDramaOperationRecordManager.1(paramString1, paramString2, paramInt1));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager
 * JD-Core Version:    0.7.0.1
 */