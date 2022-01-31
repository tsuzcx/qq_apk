package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MsgTabNodeEntity
  extends Entity
{
  public String headUrl;
  public String jumpUrl;
  public String localSuccessVideoList;
  public long nodeInfoTimeStamp;
  public int nodeType;
  public String nodeVid;
  public long recommendId;
  public long reqTimeStamp;
  public String title;
  public long uid;
  @unique
  public String unionId;
  public String videoInfoList;
  
  public String toString()
  {
    return "MsgTabNodeEntity{nodeType=" + this.nodeType + ", uid=" + this.uid + ", unionId='" + this.unionId + '\'' + ", title='" + this.title + '\'' + ", recommondId='" + this.recommendId + '\'' + ", nodeVid='" + this.nodeVid + '\'' + ", reqTimeStamp=" + this.reqTimeStamp + ", nodeInfoTimeStamp=" + this.nodeInfoTimeStamp + ", \nvideoInfoList='" + this.videoInfoList + '\'' + ", \nlocalSuccessVideoList='" + this.localSuccessVideoList + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeEntity
 * JD-Core Version:    0.7.0.1
 */