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
  public static SparseArray<Pools.Pool<BannerVideoInfoWidget3.BannerVideoInfoController>> a;
  private BannerVideoInfoWidget3.BannerActivityLifeCycle a;
  public BannerVideoInfoWidget3.BannerVideoInfoController a;
  public BannerVideoInfoWidget3.BannerViewHolder a;
  private int b;
  
  public BannerVideoInfoWidget3(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    int k = 0;
    int i;
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.jdField_a_of_type_Int > 0))
    {
      i = paramStoryVideoItem.getOALinkInfo().jdField_a_of_type_Int;
      paramStoryVideoItem = null;
    }
    else
    {
      paramStoryVideoItem = paramStoryVideoItem.getVideoLinkInfo();
      if (paramStoryVideoItem != null) {
        i = paramStoryVideoItem.jdField_a_of_type_Int;
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
        if (paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo == null) {
          return j;
        }
        if (paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.a()) {
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
  
  private BannerVideoInfoWidget3.BannerVideoInfoController a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController;
    if ((localObject1 != null) && (this.jdField_b_of_type_Int == paramInt)) {
      return localObject1;
    }
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    Object localObject2 = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Pools.SimplePool(5);
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = (BannerVideoInfoWidget3.BannerVideoInfoController)((Pools.Pool)localObject1).acquire();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(paramInt);
    }
    if (localObject1 != null) {
      ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject1).b = true;
    }
    localObject2 = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localObject2 != null)
    {
      BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController;
      if (localBannerVideoInfoController != null)
      {
        ((Pools.Pool)localObject2).release(localBannerVideoInfoController);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController.b = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController = ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject1);
    return localObject1;
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
  
  public String a()
  {
    return "BannerVideoInfoWidget";
  }
  
  protected void a(View paramView)
  {
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
  }
  
  protected void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerViewHolder == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerViewHolder = new BannerVideoInfoWidget3.BannerViewHolder(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = a(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramStoryPlayerVideoData);
    }
  }
  
  protected void a(Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerActivityLifeCycle = new BannerVideoInfoWidget3.BannerActivityLifeCycle(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerActivityLifeCycle);
  }
  
  protected boolean a(StoryPlayerVideoData paramStoryPlayerVideoData, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = a().mUIStyle.hideBannerInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if ((paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null) && (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int == 13)) {
        return false;
      }
      bool1 = bool2;
      if (a(paramStoryVideoItem) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int b()
  {
    return 2131561810;
  }
  
  protected void f() {}
  
  public void g()
  {
    Object localObject = jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        localObject = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        for (;;)
        {
          BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = (BannerVideoInfoWidget3.BannerVideoInfoController)((Pools.Pool)localObject).acquire();
          if (localBannerVideoInfoController == null) {
            break;
          }
          localBannerVideoInfoController.a();
        }
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerActivityLifeCycle;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController;
    if (localBannerVideoInfoController != null) {
      localBannerVideoInfoController.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3
 * JD-Core Version:    0.7.0.1
 */