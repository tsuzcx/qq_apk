package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.tools.GeoHashTree;
import com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNode;
import com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNodeBean;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GeoHashSplitStrategy
  extends AbstractSplitStrategy<SplitConfig.TreeGatherConfig>
{
  public GeoHashSplitStrategy()
  {
    a(new SplitConfig.TreeGatherConfig());
  }
  
  private GeoHashTree a(HashMap<String, List<StoryAlbum.PicInfo>> paramHashMap)
  {
    paramHashMap = new GeoHashTree(paramHashMap);
    paramHashMap.b();
    return paramHashMap;
  }
  
  private List<StoryAlbum> a(GeoHashTree.TreeNode paramTreeNode, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramTreeNode.a.a >= paramInt1)) || (paramTreeNode.b.size() <= 0))
    {
      if (paramTreeNode.b() >= ((SplitConfig.TreeGatherConfig)a()).b)
      {
        localObject1 = new StoryAlbum(((SplitConfig.TreeGatherConfig)a()).a);
        ((StoryAlbum)localObject1).a(this.a);
        ((StoryAlbum)localObject1).i = paramTreeNode.a.b;
        ((StoryAlbum)localObject1).j = new ArrayList();
        localObject2 = paramTreeNode.c().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (GeoHashTree.TreeNode)((Iterator)localObject2).next();
          ((StoryAlbum)localObject1).j.add(((GeoHashTree.TreeNode)localObject3).a.b);
        }
        paramTreeNode.a();
        SLog.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramTreeNode = new ArrayList(1);
        paramTreeNode.add(localObject1);
        return paramTreeNode;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    int i = 0;
    Object localObject3 = paramTreeNode.b.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (GeoHashTree.TreeNode)((Iterator)localObject3).next();
      localObject5 = a((GeoHashTree.TreeNode)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0))
      {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      else
      {
        ((ArrayList)localObject2).add(localObject4);
        i += ((GeoHashTree.TreeNode)localObject4).b();
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((SplitConfig.TreeGatherConfig)a()).b) && (paramTreeNode.a.a >= paramInt2))
    {
      localObject3 = new StoryAlbum(((SplitConfig.TreeGatherConfig)a()).a);
      ((StoryAlbum)localObject3).a(this.a);
      ((StoryAlbum)localObject3).i = paramTreeNode.a.b;
      ((StoryAlbum)localObject3).j = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((GeoHashTree.TreeNode)((Iterator)localObject2).next()).c().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GeoHashTree.TreeNode)((Iterator)localObject4).next();
          ((StoryAlbum)localObject3).j.add(((GeoHashTree.TreeNode)localObject5).a.b);
        }
      }
      paramTreeNode.a();
      SLog.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  protected List<StoryAlbum> a(List<StoryAlbum.PicInfo> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (StoryAlbum.PicInfo)paramList.next();
      if (localHashMap.containsKey(((StoryAlbum.PicInfo)localObject1).l))
      {
        ((List)localHashMap.get(((StoryAlbum.PicInfo)localObject1).l)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((StoryAlbum.PicInfo)localObject1).l, localObject2);
      }
    }
    paramList = a(localHashMap);
    SLog.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((SplitConfig.TreeGatherConfig)a()).g), Integer.valueOf(((SplitConfig.TreeGatherConfig)a()).h));
    paramList = a(paramList.a(), ((SplitConfig.TreeGatherConfig)a()).g, ((SplitConfig.TreeGatherConfig)a()).h);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryAlbum)((Iterator)localObject1).next();
        Object localObject3;
        if ((((StoryAlbum)localObject2).j != null) && (((StoryAlbum)localObject2).j.size() != 0))
        {
          localObject3 = new ArrayList();
          Iterator localIterator = ((StoryAlbum)localObject2).j.iterator();
          while (localIterator.hasNext()) {
            ((List)localObject3).addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((StoryAlbum)localObject2).a((List)localObject3);
          ((StoryAlbum)localObject2).a(a());
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("check why? album:");
          ((StringBuilder)localObject3).append(localObject2);
          SLog.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", ((StringBuilder)localObject3).toString());
          AssertUtils.fail("check why? album:", new Object[0]);
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.GeoHashSplitStrategy
 * JD-Core Version:    0.7.0.1
 */