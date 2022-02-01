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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
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
    int k = 0;
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    int i;
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.jdField_a_of_type_Int > 0))
    {
      i = paramStoryVideoItem.getOALinkInfo().jdField_a_of_type_Int;
      paramStoryVideoItem = null;
    }
    for (;;)
    {
      switch (i)
      {
      }
      label60:
      do
      {
        int j = i;
        do
        {
          do
          {
            return j;
            paramStoryVideoItem = paramStoryVideoItem.getVideoLinkInfo();
            if (paramStoryVideoItem == null) {
              break label118;
            }
            i = paramStoryVideoItem.jdField_a_of_type_Int;
            break;
            if (MediaCodecDPC.n()) {
              break label60;
            }
            return 0;
            j = k;
          } while (paramStoryVideoItem == null);
          j = k;
        } while (paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo == null);
      } while (!paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.a());
      return 0;
      label118:
      i = 0;
    }
  }
  
  private BannerVideoInfoWidget3.BannerVideoInfoController a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController != null) && (this.jdField_b_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController;
    }
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    Pools.Pool localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localPool;
    if (localPool == null)
    {
      localObject = new Pools.SimplePool(5);
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    }
    localObject = (BannerVideoInfoWidget3.BannerVideoInfoController)((Pools.Pool)localObject).acquire();
    if (localObject == null) {
      localObject = b(paramInt);
    }
    for (;;)
    {
      if (localObject != null) {
        ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject).b = true;
      }
      localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if ((localPool != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController != null))
      {
        localPool.release(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController.b = false;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController = ((BannerVideoInfoWidget3.BannerVideoInfoController)localObject);
      return localObject;
    }
  }
  
  public static void a(String paramString, @NonNull ImageView paramImageView, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mGifRoundCorner = 0.0F;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "link";
      Object localObject = null;
      if (HttpUtil.isValidUrl(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      while (paramString != null) {
        if (paramString.getStatus() == 1)
        {
          return;
          SLog.d("BannerVideoInfoWidget", "invalid url, failed to parse the url drawable " + paramString);
          paramImageView.setImageDrawable(paramDrawable);
          paramString = localObject;
        }
        else
        {
          paramString.setURLDrawableListener(new BannerVideoInfoWidget3.1(paramImageView, paramDrawable));
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      SLog.b("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  private BannerVideoInfoWidget3.BannerVideoInfoController b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return null;
    case 1: 
      return new LinkVideoInfoController();
    case 2: 
      return new GameBannerVideoInfoController();
    case 3: 
      return new CaptureTogetherBannerVideoInfoController();
    case 5: 
      return new VipForwardVideoInfoController();
    case 6: 
      return new WeiShiFlowBannerVideoInfoController();
    }
    return new CaptureBannerVideoInfoController();
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
    if ((a().mUIStyle.hideBannerInfo) || ((paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null) && (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int == 13))) {}
    while (a(paramStoryVideoItem) <= 0) {
      return false;
    }
    return true;
  }
  
  protected int b()
  {
    return 2131561966;
  }
  
  protected void f() {}
  
  public void g()
  {
    if ((jdField_a_of_type_AndroidUtilSparseArray != null) && (jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int i = 0;
      while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        Pools.Pool localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        for (;;)
        {
          BannerVideoInfoWidget3.BannerVideoInfoController localBannerVideoInfoController = (BannerVideoInfoWidget3.BannerVideoInfoController)localPool.acquire();
          if (localBannerVideoInfoController == null) {
            break;
          }
          localBannerVideoInfoController.a();
        }
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerActivityLifeCycle != null) {
      b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerActivityLifeCycle);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$BannerVideoInfoController.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3
 * JD-Core Version:    0.7.0.1
 */