package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MsgTabHaloEntity
  extends Entity
{
  public String headUrl;
  public String jumpUrl;
  public String localSuccessVideoList;
  public int noUpdate;
  public long nodeInfoTimeStamp;
  public int nodeType;
  public String nodeVid;
  public long recommendId;
  public long reqTimeStamp;
  public String title;
  @unique
  public long uid;
  @unique
  public String unionId;
  public String videoCover;
  public String videoInfoList;
  
  public static String getSelection()
  {
    return "uid=?";
  }
  
  public static String[] getSelectionArgs(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    return new String[] { String.valueOf(paramMsgTabNodeInfo.c) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MsgTabHaloEntity{");
    localStringBuilder.append("nodeType=");
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
    localStringBuilder.append(", noUpdate=");
    localStringBuilder.append(this.noUpdate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity
 * JD-Core Version:    0.7.0.1
 */