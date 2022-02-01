package com.tencent.biz.qqstory.album.flter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.GroupTreeSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.KMeansSplitStrategy;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.BaseSplitConfig;
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
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new KMeansSplitStrategy();
    ((KMeansSplitStrategy)localObject).a(paramInt);
    ((KMeansSplitStrategy)localObject).a(paramScanInfo);
    a((AbstractSplitStrategy)localObject);
    paramScanInfo = new GroupTreeSplitStrategy();
    localObject = ((StoryScanManager)SuperManager.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SplitConfig.TreeGatherConfig localTreeGatherConfig = (SplitConfig.TreeGatherConfig)((Iterator)localObject).next();
        switch (localTreeGatherConfig.a)
        {
        default: 
          break;
        case 2: 
          paramScanInfo.a(localTreeGatherConfig);
          break;
        case 4: 
          paramScanInfo.b(localTreeGatherConfig);
          break;
        case 3: 
          paramScanInfo.c(localTreeGatherConfig);
        }
      }
    }
    paramScanInfo.a(new SplitConfig.BaseSplitConfig());
    a(paramScanInfo);
  }
  
  public static boolean a(@NonNull StoryAlbum paramStoryAlbum, int paramInt)
  {
    Object localObject = paramStoryAlbum.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((StoryAlbum.PicInfo)((List)localObject).get(0)).a;
      localObject = ((StoryAlbum.PicInfo)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramStoryAlbum);
        paramStoryAlbum.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramStoryAlbum.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramStoryAlbum.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramStoryAlbum.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramStoryAlbum.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramStoryAlbum.b = localAddressItem.country;
        return true;
      }
    }
    paramStoryAlbum.b = "";
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  protected List<StoryAlbum.PicInfo> a()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)localIterator.next();
      if (localPicInfo.a != null) {
        localArrayList.add(localPicInfo);
      }
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<StoryAlbum> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.flter.RecommendAlbumFilter
 * JD-Core Version:    0.7.0.1
 */