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
    paramHashMap.a();
    return paramHashMap;
  }
  
  private List<StoryAlbum> a(GeoHashTree.TreeNode paramTreeNode, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramTreeNode.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int >= paramInt1)) || (paramTreeNode.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramTreeNode.a() >= ((SplitConfig.TreeGatherConfig)a()).b)
      {
        localObject1 = new StoryAlbum(((SplitConfig.TreeGatherConfig)a()).jdField_a_of_type_Int);
        ((StoryAlbum)localObject1).a(this.a);
        ((StoryAlbum)localObject1).d = paramTreeNode.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString;
        ((StoryAlbum)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramTreeNode.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (GeoHashTree.TreeNode)((Iterator)localObject2).next();
          ((StoryAlbum)localObject1).jdField_a_of_type_JavaUtilList.add(((GeoHashTree.TreeNode)localObject3).jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString);
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
    Object localObject3 = paramTreeNode.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (GeoHashTree.TreeNode)((Iterator)localObject3).next();
      localObject5 = a((GeoHashTree.TreeNode)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((GeoHashTree.TreeNode)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((SplitConfig.TreeGatherConfig)a()).b) && (paramTreeNode.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new StoryAlbum(((SplitConfig.TreeGatherConfig)a()).jdField_a_of_type_Int);
      ((StoryAlbum)localObject3).a(this.a);
      ((StoryAlbum)localObject3).d = paramTreeNode.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString;
      ((StoryAlbum)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((GeoHashTree.TreeNode)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GeoHashTree.TreeNode)((Iterator)localObject4).next();
          ((StoryAlbum)localObject3).jdField_a_of_type_JavaUtilList.add(((GeoHashTree.TreeNode)localObject5).jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString);
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
      if (localHashMap.containsKey(((StoryAlbum.PicInfo)localObject1).c))
      {
        ((List)localHashMap.get(((StoryAlbum.PicInfo)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((StoryAlbum.PicInfo)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    SLog.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((SplitConfig.TreeGatherConfig)a()).d), Integer.valueOf(((SplitConfig.TreeGatherConfig)a()).e));
    paramList = a(paramList.a(), ((SplitConfig.TreeGatherConfig)a()).d, ((SplitConfig.TreeGatherConfig)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryAlbum)((Iterator)localObject1).next();
        if ((((StoryAlbum)localObject2).jdField_a_of_type_JavaUtilList == null) || (((StoryAlbum)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          SLog.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          AssertUtils.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((StoryAlbum)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((StoryAlbum)localObject2).a(localArrayList);
          ((StoryAlbum)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.GeoHashSplitStrategy
 * JD-Core Version:    0.7.0.1
 */