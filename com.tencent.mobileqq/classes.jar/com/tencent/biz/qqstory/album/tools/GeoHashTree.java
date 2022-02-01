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
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(this.a);
    while (localLinkedList.size() > 0)
    {
      int j = localLinkedList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (GeoHashTree.TreeNode)localLinkedList.poll();
        if (localObject != null)
        {
          localStringBuilder.append(" [").append(((GeoHashTree.TreeNode)localObject).toString()).append("];");
          localObject = ((GeoHashTree.TreeNode)localObject).a.iterator();
          while (((Iterator)localObject).hasNext()) {
            localLinkedList.offer((GeoHashTree.TreeNode)((Iterator)localObject).next());
          }
        }
        i += 1;
      }
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n]");
    SLog.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "traverse " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree
 * JD-Core Version:    0.7.0.1
 */