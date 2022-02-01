package com.tencent.biz.qqstory.album.strategy;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.flter.RecommendAlbumFilter;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class GroupTreeSplitStrategy
  extends AbstractSplitStrategy<BaseSplitConfig>
{
  private SplitConfig.TreeGatherConfig a;
  private SplitConfig.TreeGatherConfig b;
  private SplitConfig.TreeGatherConfig c;
  
  public GroupTreeSplitStrategy()
  {
    int i = ((StoryScanManager)SuperManager.a(30)).a().b();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$TreeGatherConfig = new SplitConfig.TreeGatherConfig();
    SplitConfig.TreeGatherConfig localTreeGatherConfig = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$TreeGatherConfig;
    localTreeGatherConfig.a = 2;
    localTreeGatherConfig.b = 6;
    localTreeGatherConfig.d = i;
    localTreeGatherConfig.e = (i - 1);
    this.b = new SplitConfig.TreeGatherConfig();
    localTreeGatherConfig = this.b;
    localTreeGatherConfig.a = 4;
    localTreeGatherConfig.b = 10;
    localTreeGatherConfig.d = i;
    localTreeGatherConfig.e = -1;
    this.c = new SplitConfig.TreeGatherConfig();
    localTreeGatherConfig = this.c;
    localTreeGatherConfig.a = 3;
    localTreeGatherConfig.b = 6;
    localTreeGatherConfig = this.b;
    localTreeGatherConfig.d = i;
    localTreeGatherConfig.e = -1;
  }
  
  private List<StoryAlbum> a(List<StoryAlbum> paramList, int paramInt, SplitConfig.TreeGatherConfig paramTreeGatherConfig)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryAlbum localStoryAlbum = (StoryAlbum)paramList.next();
        if (RecommendAlbumFilter.a(localStoryAlbum, paramInt)) {
          localArrayList.add(localStoryAlbum);
        }
      }
      return a(localArrayList, paramTreeGatherConfig);
    }
    return new ArrayList(1);
  }
  
  private List<StoryAlbum> a(List<StoryAlbum> paramList, SplitConfig.TreeGatherConfig paramTreeGatherConfig)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (StoryAlbum)paramList.next();
      if (((HashMap)localObject1).containsKey(((StoryAlbum)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((StoryAlbum)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((StoryAlbum)localObject2).b, localArrayList1);
      }
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject4 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localArrayList1 = new ArrayList(((List)localObject4).size());
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = new ArrayList();
      if (((List)localObject4).size() == 1)
      {
        paramList.add(((List)localObject4).get(0));
      }
      else
      {
        long l3 = 2147483647L;
        long l1 = 0L;
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          StoryAlbum localStoryAlbum = (StoryAlbum)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localStoryAlbum.d)) {
            localArrayList1.add(localStoryAlbum.d);
          }
          if ((localStoryAlbum.a != null) && (localStoryAlbum.a.size() > 0)) {
            localArrayList2.addAll(localStoryAlbum.a);
          } else {
            SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localStoryAlbum.toString() });
          }
          ((List)localObject3).addAll(localStoryAlbum.a());
          long l2 = l3;
          if (localStoryAlbum.e() < l3) {
            l2 = localStoryAlbum.e();
          }
          long l4 = l1;
          if (localStoryAlbum.f() > l1) {
            l4 = localStoryAlbum.f();
          }
          l3 = l2;
          l1 = l4;
        }
        localObject3 = new StoryAlbum(paramTreeGatherConfig.a, (List)localObject3);
        ((StoryAlbum)localObject3).b = ((String)localObject2);
        ((StoryAlbum)localObject3).d = localArrayList1.toString();
        ((StoryAlbum)localObject3).a = localArrayList2;
        ((StoryAlbum)localObject3).a(l3, l1);
        ((StoryAlbum)localObject3).a(paramTreeGatherConfig);
        paramList.add(localObject3);
        SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((StoryAlbum)localObject3).toString() });
      }
    }
    return paramList;
  }
  
  private boolean a(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (paramAddressItem.poiType == 1);
  }
  
  private boolean b(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, HardCodeUtil.a(2131705489)));
  }
  
  protected List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (StoryAlbum.PicInfo)paramList.next();
      Object localObject5 = ((StoryAlbum.PicInfo)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localObject5 == null)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(((StoryAlbum.PicInfo)localObject4).c);
        ((StringBuilder)localObject5).append(((StoryAlbum.PicInfo)localObject4).jdField_a_of_type_JavaLangString);
        SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((StringBuilder)localObject5).toString() });
      }
      else if (a((AddressItem)localObject5))
      {
        ((List)localObject3).add(localObject4);
      }
      else if (b((AddressItem)localObject5))
      {
        ((List)localObject2).add(localObject4);
      }
      else
      {
        ((List)localObject1).add(localObject4);
      }
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new StoryAlbum(2, (List)localObject3);
      ((StoryAlbum)localObject3).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
      localObject4 = new CitySplitStrategy();
      ((CitySplitStrategy)localObject4).a((StoryAlbum)localObject3);
      ((CitySplitStrategy)localObject4).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$TreeGatherConfig);
      paramList.addAll(a(((CitySplitStrategy)localObject4).b(), 5, this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$TreeGatherConfig));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new StoryAlbum(4, (List)localObject2);
      ((StoryAlbum)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
      localObject3 = new GeoHashSplitStrategy();
      ((GeoHashSplitStrategy)localObject3).a(this.b);
      ((GeoHashSplitStrategy)localObject3).a((StoryAlbum)localObject2);
      paramList.addAll(a(((GeoHashSplitStrategy)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new StoryAlbum(3, (List)localObject1);
      ((StoryAlbum)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
      localObject2 = new GeoHashSplitStrategy();
      ((GeoHashSplitStrategy)localObject2).a(this.c);
      ((GeoHashSplitStrategy)localObject2).a((StoryAlbum)localObject1);
      paramList.addAll(a(((GeoHashSplitStrategy)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(SplitConfig.TreeGatherConfig paramTreeGatherConfig)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStrategySplitConfig$TreeGatherConfig = paramTreeGatherConfig;
  }
  
  public void b(SplitConfig.TreeGatherConfig paramTreeGatherConfig)
  {
    this.b = paramTreeGatherConfig;
  }
  
  public void c(SplitConfig.TreeGatherConfig paramTreeGatherConfig)
  {
    this.c = paramTreeGatherConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.GroupTreeSplitStrategy
 * JD-Core Version:    0.7.0.1
 */