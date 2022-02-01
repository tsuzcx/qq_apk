package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class MsgTabPlayPageLoader$MsgTabGroupId
  extends IDataProvider.GroupId
{
  public MsgTabNodeInfo a;
  public String d = "";
  public String e = "";
  public int f = 0;
  public boolean g = false;
  
  public MsgTabPlayPageLoader$MsgTabGroupId(String paramString)
  {
    super(paramString);
  }
  
  static MsgTabGroupId a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabGroupId localMsgTabGroupId = new MsgTabGroupId(paramMsgTabNodeInfo.d);
    localMsgTabGroupId.a = paramMsgTabNodeInfo;
    if (paramMsgTabNodeInfo.b == 12)
    {
      localMsgTabGroupId.e = paramMsgTabNodeInfo.n;
      localMsgTabGroupId.d = paramMsgTabNodeInfo.x;
    }
    return localMsgTabGroupId;
  }
  
  public String a()
  {
    MsgTabNodeInfo localMsgTabNodeInfo = this.a;
    if (localMsgTabNodeInfo != null) {
      return localMsgTabNodeInfo.d;
    }
    return this.b;
  }
  
  public boolean b()
  {
    MsgTabNodeInfo localMsgTabNodeInfo = this.a;
    return (localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.b == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId
 * JD-Core Version:    0.7.0.1
 */