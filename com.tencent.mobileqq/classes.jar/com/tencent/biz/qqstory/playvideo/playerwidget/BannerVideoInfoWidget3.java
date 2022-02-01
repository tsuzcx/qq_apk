package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class BannerVideoInfoWidget3
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public static SparseArray<Pools.Pool<BannerVideoInfoWidget3.BannerVideoInfoController>> s;
  public BannerVideoInfoWidget3.BannerVideoInfoController t;
  public BannerVideoInfoWidget3.BannerViewHolder u;
  private int v;
  private BannerVideoInfoWidget3.BannerActivityLifeCycle w;
  
  public BannerVideoInfoWidget3(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    int k = 0;
    int i;
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a > 0))
    {
      i = paramStoryVideoItem.getOALinkInfo().a;
      paramStoryVideoItem = null;
    }
    else
    {
      paramStoryVideoItem = paramStoryVideoItem.getVideoLinkInfo();
      if (paramStoryVideoItem != null) {
        i = paramStoryVideoItem.a;
      } else {
        i = 0;
      }
    }
    if (i != 3)
    {
      if (i == 5)
      {
        j = k;
        if (paramStoryVideoItem == null) {
          return j;
        }
        j = k;
        if (paramStoryVideoItem.h == null) {
          return j;
        }
        if (paramStoryVideoItem.h.a()) {
          return 0;
        }
      }
    }
    else if (!((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isFollowCaptureSwitchOpen()) {
      return 0;
    }
    int j = i;
    return j;
  }
  
  public static void a(String paramString, @NonNull ImageView paramImageView, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "link";
      Object localObject1 = null;
      if (HttpUtil.isValidUrl(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("invalid url, failed to parse the url drawable ");
        ((StringBuilder)localObject2).append(paramString);
        SLog.d("BannerVideoInfoWidget", ((StringBuilder)localObject2).toString());
        paramImageView.setImageDrawable(paramDrawable);
        paramString = localObject1;
      }
      if (paramString != null)
      {
        if (paramString.getStatus() == 1) {
          return;
        }
        paramString.setURLDrawableListener(new BannerVideoInfoWidget3.1(paramImageView, paramDrawable));
        return;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      SLog.b("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
    }
  }
  
  private BannerVideoInfoWidget3.BannerVideoInfoController b(int paramInt)
  {
    Object localObject1 = this.t;
    if ((localObject1 != null) && (this.v == paramInt)) {
      return localObject1;
    }
    if (s == null) {
      s = new SparseArray();
    }
    Object localObject2 = (Pools.Pool)s.get(paramInt);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Pools.SimplePool(5);
      s.put(paramInt, localObject1);
    }
    localObject2 = (BannerVideoInfoWidget3.BannerVideoInfoController)((Pools.Pool)localObject1).acquire();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c(paramInt);
    }
    if (localObject1 != null) {
      ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject1).e = true;
    }
    localObject2 = (Pools.Pool)s.get(this.v);
    if (localObject2 != null)
    {
      BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = this.t;
      if (localBannerVideoInfoController != null)
      {
        ((Pools.Pool)localObject2).release(localBannerVideoInfoController);
        this.t.e = false;
      }
    }
    this.t = ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject1);
    return localObject1;
  }
  
  private BannerVideoInfoWidget3.BannerVideoInfoController c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7) {
                return null;
              }
              return new CaptureBannerVideoInfoController();
            }
            return new WeiShiFlowBannerVideoInfoController();
          }
          return new VipForwardVideoInfoController();
        }
        return new CaptureTogetherBannerVideoInfoController();
      }
      return new GameBannerVideoInfoController();
    }
    return new LinkVideoInfoController();
  }
  
  protected void a(View paramView)
  {
    if (s == null) {
      s = new SparseArray();
    }
  }
  
  protected void a(Map<Subscriber, String> paramMap)
  {
    this.w = new BannerVideoInfoWidget3.BannerActivityLifeCycle(this);
    a(this.w);
  }
  
  protected boolean a(StoryPlayerVideoData paramStoryPlayerVideoData, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = i().mUIStyle.hideBannerInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if ((paramStoryPlayerVideoData.a != null) && (paramStoryPlayerVideoData.a.b == 13)) {
        return false;
      }
      bool1 = bool2;
      if (a(paramStoryVideoItem) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.i, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramStoryPlayerVideoData.b, paramStoryVideoItem.mVid);
    if (this.u == null)
    {
      this.u = new BannerVideoInfoWidget3.BannerViewHolder(this.b);
      this.b.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = b(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramStoryPlayerVideoData);
    }
  }
  
  public void onClick(View paramView)
  {
    BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = this.t;
    if (localBannerVideoInfoController != null) {
      localBannerVideoInfoController.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  public void r()
  {
    Object localObject = s;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < s.size())
      {
        localObject = (Pools.Pool)s.valueAt(i);
        for (;;)
        {
          BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = (BannerVideoInfoWidget3.BannerVideoInfoController)((Pools.Pool)localObject).acquire();
          if (localBannerVideoInfoController == null) {
            break;
          }
          localBannerVideoInfoController.c();
        }
        i += 1;
      }
      s.clear();
    }
    localObject = this.w;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  protected int s()
  {
    return 2131628189;
  }
  
  public String t()
  {
    return "BannerVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3
 * JD-Core Version:    0.7.0.1
 */