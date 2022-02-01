package com.tencent.biz.qqcircle.immersive.model.barrage.cache;

import feedcloud.FeedCloudMeta.StComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QFSBarrageCachePack
{
  private Map<String, ArrayList<FeedCloudMeta.StComment>> a = new HashMap();
  private Map<String, QFSBarrageCachePack.FSBarrageResponse> b = new HashMap();
  private Map<String, Integer> c = new HashMap();
  
  public Map<String, ArrayList<FeedCloudMeta.StComment>> a()
  {
    return this.a;
  }
  
  public Map<String, QFSBarrageCachePack.FSBarrageResponse> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.model.barrage.cache.QFSBarrageCachePack
 * JD-Core Version:    0.7.0.1
 */