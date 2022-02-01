package com.tencent.biz.pubaccount.weishi_new.recommend.utils;

import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.Iterator;
import java.util.List;

public class WSGridPageUtils
{
  public static int a(XRecyclerView paramXRecyclerView)
  {
    int i = c(paramXRecyclerView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageUtils.java][getDefaultExposeCount] visibleHeaderCount: ");
    localStringBuilder.append(i);
    WSLog.d("WSGridUtils", localStringBuilder.toString());
    try
    {
      int j = b(paramXRecyclerView);
      return j - i + 1;
    }
    catch (Exception paramXRecyclerView)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridPageUtils.java][getDefaultExposeCount] error: ");
      localStringBuilder.append(paramXRecyclerView.getMessage());
      WSLog.d("WSGridUtils", localStringBuilder.toString());
    }
    return 4;
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt[0];
    int n = paramArrayOfInt.length;
    while (i < n)
    {
      int m = paramArrayOfInt[i];
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  @Nullable
  public static WSFollowDramaItemData a(@Nullable List<WSFollowDramaItemData> paramList, @Nullable String paramString)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WSFollowDramaItemData localWSFollowDramaItemData = (WSFollowDramaItemData)paramList.next();
        if (paramString.equals(localWSFollowDramaItemData.a())) {
          return localWSFollowDramaItemData;
        }
      }
    }
    return null;
  }
  
  public static String a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSRedDotPushMsg paramWSRedDotPushMsg, String paramString)
  {
    String str;
    boolean bool;
    if (paramWSRedDotPushMsg != null)
    {
      localObject = paramWSRedDotPushMsg.mFeedIds;
      str = paramWSRedDotPushMsg.mPushId;
      bool = WeishiUtils.a(paramWSRedDotPushMsg);
      paramWSRedDotPushMsg = (WSRedDotPushMsg)localObject;
    }
    else
    {
      paramWSRedDotPushMsg = "";
      str = "0";
      bool = false;
    }
    Object localObject = paramWSRedDotPushMsg;
    if (!paramBoolean)
    {
      localObject = paramWSRedDotPushMsg;
      if (TextUtils.isEmpty(paramWSRedDotPushMsg))
      {
        localObject = paramWSRedDotPushMsg;
        if (paramstSimpleMetaFeed != null) {
          localObject = paramstSimpleMetaFeed.id;
        }
      }
    }
    int i;
    if (bool) {
      i = WeiShiCacheManager.a().a();
    } else {
      i = 0;
    }
    int j;
    if (bool) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramBoolean) {
      k = 1;
    } else {
      k = 2;
    }
    WSReportDc00898.a(301, new Object[] { Integer.valueOf(paramInt), str, localObject, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(1) });
    WSGridBeaconReport.a(paramstSimpleMetaFeed, j, k, i, paramString);
    return localObject;
  }
  
  public static int b(XRecyclerView paramXRecyclerView)
  {
    if ((paramXRecyclerView != null) && (paramXRecyclerView.getRecyclerView() != null))
    {
      paramXRecyclerView = paramXRecyclerView.getRecyclerView().getLayoutManager();
      if ((paramXRecyclerView instanceof StaggeredGridLayoutManager))
      {
        paramXRecyclerView = (StaggeredGridLayoutManager)paramXRecyclerView;
        int[] arrayOfInt = new int[paramXRecyclerView.getSpanCount()];
        paramXRecyclerView.findLastVisibleItemPositions(arrayOfInt);
        i = a(arrayOfInt);
        break label54;
      }
    }
    int i = -1;
    label54:
    paramXRecyclerView = new StringBuilder();
    paramXRecyclerView.append("[WSGridPageUtils.java][getLastVisiblePosition] lastVisiblePosition:");
    paramXRecyclerView.append(i);
    WSLog.e("WSGridUtils", paramXRecyclerView.toString());
    return i;
  }
  
  private static int c(XRecyclerView paramXRecyclerView)
  {
    int i = 0;
    if ((paramXRecyclerView != null) && (paramXRecyclerView.getRecyclerView() != null))
    {
      if (!(paramXRecyclerView.getRecyclerView().getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
        return 0;
      }
      paramXRecyclerView = (RecyclerViewHeaderViewAdapter)paramXRecyclerView.getRecyclerView().getAdapter();
      int m = paramXRecyclerView.getHeaderCount();
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (paramXRecyclerView.getHeader(i).getVisibility() == 0) {
          k = j + 1;
        }
        i += 1;
      }
      return j;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils
 * JD-Core Version:    0.7.0.1
 */