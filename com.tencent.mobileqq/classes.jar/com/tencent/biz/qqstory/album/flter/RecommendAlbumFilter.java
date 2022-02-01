package com.tencent.biz.qqstory.album.flter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.GroupTreeSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.KMeansSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TreeGatherConfig;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendAlbumFilter
  extends BaseAlbumFilter
{
  public RecommendAlbumFilter(int paramInt, ScanInfo paramScanInfo)
  {
    super(2);
    this.c = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.b = false;
    Object localObject = new KMeansSplitStrategy();
    ((KMeansSplitStrategy)localObject).a(paramInt);
    ((KMeansSplitStrategy)localObject).a(paramScanInfo);
    a((AbstractSplitStrategy)localObject);
    paramScanInfo = new GroupTreeSplitStrategy();
    localObject = ((StoryScanManager)SuperManager.a(30)).f();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SplitConfig.TreeGatherConfig localTreeGatherConfig = (SplitConfig.TreeGatherConfig)((Iterator)localObject).next();
        paramInt = localTreeGatherConfig.a;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              paramScanInfo.b(localTreeGatherConfig);
            }
          }
          else {
            paramScanInfo.c(localTreeGatherConfig);
          }
        }
        else {
          paramScanInfo.a(localTreeGatherConfig);
        }
      }
    }
    paramScanInfo.a(new BaseSplitConfig());
    a(paramScanInfo);
  }
  
  public static boolean a(@NonNull StoryAlbum paramStoryAlbum, int paramInt)
  {
    Object localObject2 = paramStoryAlbum.a();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = ((StoryAlbum.PicInfo)((List)localObject2).get(0)).o;
      localObject2 = ((StoryAlbum.PicInfo)((List)localObject2).get(((List)localObject2).size() - 1)).o;
      if ((localObject1 != null) && (localObject2 != null))
      {
        if ((paramInt <= 5) && (a(((AddressItem)localObject1).building, ((AddressItem)localObject2).building)))
        {
          paramStoryAlbum.f = ((AddressItem)localObject1).building;
          return true;
        }
        if ((paramInt <= 4) && (a(((AddressItem)localObject1).district, ((AddressItem)localObject2).district)))
        {
          paramStoryAlbum.f = ((AddressItem)localObject1).district;
          return true;
        }
        if ((paramInt <= 3) && (a(((AddressItem)localObject1).city, ((AddressItem)localObject2).city)))
        {
          paramStoryAlbum.f = ((AddressItem)localObject1).city;
          return true;
        }
        if ((paramInt <= 2) && (a(((AddressItem)localObject1).province, ((AddressItem)localObject2).province)))
        {
          paramStoryAlbum.f = ((AddressItem)localObject1).province;
          return true;
        }
        if ((paramInt <= 1) && (a(((AddressItem)localObject1).country, ((AddressItem)localObject2).country)))
        {
          paramStoryAlbum.f = ((AddressItem)localObject1).country;
          return true;
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initAlbumNameByPOI find no poi item :");
        ((StringBuilder)localObject1).append(paramStoryAlbum);
        SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", ((StringBuilder)localObject1).toString());
        paramStoryAlbum.f = "";
        return false;
      }
    }
    paramStoryAlbum.f = "";
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  protected List<StoryAlbum.PicInfo> a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get start Pic list=");
    ((StringBuilder)localObject1).append(super.a().size());
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList();
    Object localObject2 = super.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject2).next();
      if (localPicInfo.o != null) {
        ((List)localObject1).add(localPicInfo);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get end Pic list=");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  protected void c(List<StoryAlbum> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.flter.RecommendAlbumFilter
 * JD-Core Version:    0.7.0.1
 */