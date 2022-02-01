package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Looper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
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
  private static List<WSVerticalItemData> a()
  {
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)WSFileUtils.a(new stSimpleGetFeedListRsp(), b());
    if (localstSimpleGetFeedListRsp == null) {
      return new ArrayList();
    }
    return WSVerticalDataUtil.a(localstSimpleGetFeedListRsp.feeds);
  }
  
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new WSVerticalTrendsCacheUtils.2(paramstSimpleMetaFeed));
  }
  
  public static void a(WSVerticalPageContract.View paramView)
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter;
    if (paramView != null)
    {
      localWSVerticalPageAdapter = paramView.a();
      if (localWSVerticalPageAdapter != null) {}
    }
    else
    {
      return;
    }
    int i = localWSVerticalPageAdapter.a();
    Object localObject = localWSVerticalPageAdapter.a(i);
    paramView = (WSVerticalPageContract.View)localObject;
    if (localObject != null)
    {
      paramView = (WSVerticalPageContract.View)localObject;
      if (((stSimpleMetaFeed)localObject).video_type == 2) {
        paramView = localWSVerticalPageAdapter.a(i + 1);
      }
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = localWSVerticalPageAdapter.a(i - 1);
    }
    a((stSimpleMetaFeed)localObject);
    WSVideoPreloadManager.b((stSimpleMetaFeed)localObject);
  }
  
  public static void a(boolean paramBoolean, IVerticalRspListener paramIVerticalRspListener)
  {
    if (!paramBoolean) {}
    List localList;
    do
    {
      return;
      localList = a();
    } while (localList.size() == 0);
    paramIVerticalRspListener = new WSVerticalTrendsCacheUtils.1(paramIVerticalRspListener, localList);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(paramIVerticalRspListener);
      return;
    }
    paramIVerticalRspListener.run();
  }
  
  private static String b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getCacheDir();
      if (localObject != null) {}
    }
    else
    {
      return "";
    }
    return ((File)localObject).getAbsolutePath() + "/file/weishi/ws_trends_data";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils
 * JD-Core Version:    0.7.0.1
 */