package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.Comparator;

public class MsgTabNodeInfoPositionComparator
  implements Comparator<MsgTabNodeInfo>
{
  public int a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2)
  {
    if (paramMsgTabNodeInfo1.q < paramMsgTabNodeInfo2.q) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.q > paramMsgTabNodeInfo2.q) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfoPositionComparator
 * JD-Core Version:    0.7.0.1
 */