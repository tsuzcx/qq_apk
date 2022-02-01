package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MsgTabNodeEntity
  extends Entity
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
  @unique
  public String unionId;
  public String videoCover;
  public int videoCoverType;
  public String videoInfoList;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeEntity{nodeType=");
    localStringBuilder.append(this.nodeType);
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoInfoList='");
    localStringBuilder.append(this.videoInfoList);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reqTimeStamp=");
    localStringBuilder.append(this.reqTimeStamp);
    localStringBuilder.append(", nodeInfoTimeStamp=");
    localStringBuilder.append(this.nodeInfoTimeStamp);
    localStringBuilder.append(", localSuccessVideoList='");
    localStringBuilder.append(this.localSuccessVideoList);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommendId=");
    localStringBuilder.append(this.recommendId);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nodeVid='");
    localStringBuilder.append(this.nodeVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCover='");
    localStringBuilder.append(this.videoCover);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nodePosition=");
    localStringBuilder.append(this.nodePosition);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommandNameIconUrl=");
    localStringBuilder.append(this.recommandNameIconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cacheSeq='");
    localStringBuilder.append(this.cacheSeq);
    localStringBuilder.append('\'');
    localStringBuilder.append(", passthrough=");
    localStringBuilder.append(this.passthrough);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redPoint=");
    localStringBuilder.append(this.redPoint);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCoverType=");
    localStringBuilder.append(this.videoCoverType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firstExp=");
    localStringBuilder.append(this.firstExp);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.MsgTabNodeEntity
 * JD-Core Version:    0.7.0.1
 */