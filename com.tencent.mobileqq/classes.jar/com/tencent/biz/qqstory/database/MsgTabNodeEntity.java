package com.tencent.biz.qqstory.database;

import atmo;
import atoc;

public class MsgTabNodeEntity
  extends atmo
{
  public long cacheSeq;
  public boolean firstExp = true;
  public String headUrl;
  public String jumpUrl;
  public String localSuccessVideoList;
  public String nodeFeedId;
  public long nodeInfoTimeStamp;
  public int nodePosition;
  public int nodeType;
  public String nodeVid;
  public String passthrough;
  public String recommandNameIconUrl;
  public long recommendId;
  public boolean redPoint;
  public long reqTimeStamp;
  public String title;
  public long uid;
  @atoc
  public String unionId;
  public String videoCover;
  public int videoCoverType;
  public String videoInfoList;
  
  public String toString()
  {
    return "MsgTabNodeEntity{nodeType=" + this.nodeType + ", uid=" + this.uid + ", unionId='" + this.unionId + '\'' + ", videoInfoList='" + this.videoInfoList + '\'' + ", reqTimeStamp=" + this.reqTimeStamp + ", nodeInfoTimeStamp=" + this.nodeInfoTimeStamp + ", localSuccessVideoList='" + this.localSuccessVideoList + '\'' + ", title='" + this.title + '\'' + ", headUrl='" + this.headUrl + '\'' + ", recommendId=" + this.recommendId + ", jumpUrl='" + this.jumpUrl + '\'' + ", nodeVid='" + this.nodeVid + '\'' + ", videoCover='" + this.videoCover + '\'' + ", nodePosition=" + this.nodePosition + '\'' + ", recommandNameIconUrl=" + this.recommandNameIconUrl + '\'' + ", cacheSeq='" + this.cacheSeq + '\'' + ", passthrough=" + this.passthrough + '\'' + ", redPoint=" + this.redPoint + '\'' + ", videoCoverType=" + this.videoCoverType + '\'' + ", firstExp=" + this.firstExp + '\'' + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.MsgTabNodeEntity
 * JD-Core Version:    0.7.0.1
 */