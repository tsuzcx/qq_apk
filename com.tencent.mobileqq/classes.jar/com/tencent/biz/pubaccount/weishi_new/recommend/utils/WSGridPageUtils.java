package com.tencent.biz.pubaccount.weishi_new.recommend.utils;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class WSGridPageUtils
{
  public static int a(XRecyclerView paramXRecyclerView)
  {
    try
    {
      int i = b(paramXRecyclerView);
      return i + 1;
    }
    catch (Exception paramXRecyclerView)
    {
      WSLog.d("WSGridUtils", "[WSGridPageUtils.java][getDefaultExposeCount] error: " + paramXRecyclerView.getMessage());
    }
    return 4;
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label36;
      }
      i = k;
    }
    label36:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public static String a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSRedDotPushMsg paramWSRedDotPushMsg, String paramString)
  {
    String str1;
    boolean bool;
    if (paramWSRedDotPushMsg != null)
    {
      String str2 = paramWSRedDotPushMsg.mFeedIds;
      str1 = paramWSRedDotPushMsg.mPushId;
      bool = WeishiUtils.a(paramWSRedDotPushMsg);
      paramWSRedDotPushMsg = str2;
    }
    for (;;)
    {
      if ((!paramBoolean) && (TextUtils.isEmpty(paramWSRedDotPushMsg)) && (paramstSimpleMetaFeed != null)) {
        paramWSRedDotPushMsg = paramstSimpleMetaFeed.id;
      }
      for (;;)
      {
        int i;
        int j;
        if (bool)
        {
          i = WeiShiCacheManager.a().a();
          if (!bool) {
            break label152;
          }
          j = 1;
          label66:
          if (!paramBoolean) {
            break label158;
          }
        }
        label152:
        label158:
        for (int k = 1;; k = 2)
        {
          WSReportDc00898.a(301, new Object[] { Integer.valueOf(paramInt), str1, paramWSRedDotPushMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(1) });
          WSGridBeaconReport.a(paramstSimpleMetaFeed, j, k, i, paramString);
          return paramWSRedDotPushMsg;
          i = 0;
          break;
          j = 0;
          break label66;
        }
      }
      str1 = "0";
      paramWSRedDotPushMsg = "";
      bool = false;
    }
  }
  
  public static int b(XRecyclerView paramXRecyclerView)
  {
    int j = -1;
    int i = j;
    if (paramXRecyclerView != null)
    {
      i = j;
      if (paramXRecyclerView.a() != null)
      {
        paramXRecyclerView = paramXRecyclerView.a().getLayoutManager();
        i = j;
        if ((paramXRecyclerView instanceof StaggeredGridLayoutManager))
        {
          int[] arrayOfInt = new int[((StaggeredGridLayoutManager)paramXRecyclerView).getSpanCount()];
          ((StaggeredGridLayoutManager)paramXRecyclerView).findLastVisibleItemPositions(arrayOfInt);
          i = a(arrayOfInt);
        }
      }
    }
    WSLog.e("WSGridUtils", "[WSGridPageUtils.java][getLastVisiblePosition] lastVisiblePosition:" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils
 * JD-Core Version:    0.7.0.1
 */