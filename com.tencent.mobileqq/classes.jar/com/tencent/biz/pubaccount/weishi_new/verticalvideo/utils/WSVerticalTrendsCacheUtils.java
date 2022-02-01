package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Looper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class WSVerticalTrendsCacheUtils
{
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new WSVerticalTrendsCacheUtils.2(paramstSimpleMetaFeed));
  }
  
  public static void a(WSVerticalPageContract.View paramView)
  {
    if (paramView != null)
    {
      WSVerticalPageAdapter localWSVerticalPageAdapter = paramView.b();
      if (localWSVerticalPageAdapter == null) {
        return;
      }
      int i = localWSVerticalPageAdapter.h();
      Object localObject = localWSVerticalPageAdapter.b(i);
      paramView = (WSVerticalPageContract.View)localObject;
      if (localObject != null)
      {
        paramView = (WSVerticalPageContract.View)localObject;
        if (((stSimpleMetaFeed)localObject).video_type == 2) {
          paramView = localWSVerticalPageAdapter.b(i + 1);
        }
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = localWSVerticalPageAdapter.b(i - 1);
      }
      a((stSimpleMetaFeed)localObject);
      WSVideoPreloadManager.a((stSimpleMetaFeed)localObject);
    }
  }
  
  public static void a(boolean paramBoolean, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (!paramBoolean) {
      return;
    }
    List localList = b();
    if (localList.size() == 0) {
      return;
    }
    paramIFetchDataRspListener = new WSVerticalTrendsCacheUtils.1(paramIFetchDataRspListener, localList);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(paramIFetchDataRspListener);
      return;
    }
    paramIFetchDataRspListener.run();
  }
  
  private static List<WSVerticalItemData> b()
  {
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)WSFileUtils.b(new stSimpleGetFeedListRsp(), c());
    if (localstSimpleGetFeedListRsp == null) {
      return new ArrayList();
    }
    return WSVerticalDataUtil.a(localstSimpleGetFeedListRsp.feeds);
  }
  
  private static String c()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getCacheDir();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/file/weishi/ws_trends_data");
        return localStringBuilder.toString();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils
 * JD-Core Version:    0.7.0.1
 */