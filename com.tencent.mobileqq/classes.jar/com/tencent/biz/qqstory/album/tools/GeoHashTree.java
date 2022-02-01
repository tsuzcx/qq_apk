package com.tencent.biz.qqstory.album.tools;

import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class GeoHashTree
{
  private GeoHashTree.TreeNode a = new GeoHashTree.TreeNode();
  
  public GeoHashTree(HashMap<String, List<StoryAlbum.PicInfo>> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject == null)
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "value is null key=%s", new Object[] { str });
      }
      else
      {
        localObject = (List)localObject;
        this.a.a(str, ((List)localObject).size());
      }
    }
  }
  
  public GeoHashTree.TreeNode a()
  {
    return this.a;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("AlbumTree=[\n");
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).add(this.a);
    while (((Queue)localObject1).size() > 0)
    {
      int j = ((Queue)localObject1).size();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = (GeoHashTree.TreeNode)((Queue)localObject1).poll();
        if (localObject2 != null)
        {
          localStringBuilder.append(" [");
          localStringBuilder.append(((GeoHashTree.TreeNode)localObject2).toString());
          localStringBuilder.append("];");
          localObject2 = ((GeoHashTree.TreeNode)localObject2).a.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Queue)localObject1).offer((GeoHashTree.TreeNode)((Iterator)localObject2).next());
          }
        }
        i += 1;
      }
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n]");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("traverse ");
    ((StringBuilder)localObject1).append(localStringBuilder.toString());
    SLog.d("Q.qqstory.recommendAlbum.logic.AlbumTree", ((StringBuilder)localObject1).toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree
 * JD-Core Version:    0.7.0.1
 */