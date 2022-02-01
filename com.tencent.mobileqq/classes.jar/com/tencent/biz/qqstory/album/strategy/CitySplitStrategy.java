package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CitySplitStrategy
  extends AbstractSplitStrategy<BaseSplitConfig>
{
  public String a(AddressItem paramAddressItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("city:");
    localStringBuilder.append(paramAddressItem.city);
    localStringBuilder.append(" district:");
    localStringBuilder.append(paramAddressItem.district);
    localStringBuilder.append(" building:");
    localStringBuilder.append(paramAddressItem.building);
    return localStringBuilder.toString();
  }
  
  protected List<StoryAlbum> a(List<StoryAlbum.PicInfo> paramList)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (StoryAlbum.PicInfo)paramList.next();
      Object localObject3 = ((StoryAlbum.PicInfo)localObject2).o;
      if (localObject3 != null)
      {
        localObject3 = a((AddressItem)localObject3);
        if (((HashMap)localObject1).containsKey(localObject3))
        {
          ((List)((HashMap)localObject1).get(localObject3)).add(localObject2);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          ((HashMap)localObject1).put(localObject3, localArrayList);
        }
      }
      else
      {
        SLog.a("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit pic poi is null picPath=%s", ((StoryAlbum.PicInfo)localObject2).b);
      }
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (((List)localObject2).size() >= a().b)
      {
        localObject2 = new StoryAlbum(a().a, (List)localObject2);
        ((StoryAlbum)localObject2).a(this.a);
        ((StoryAlbum)localObject2).a(a());
        paramList.add(localObject2);
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.CitySplitStrategy
 * JD-Core Version:    0.7.0.1
 */