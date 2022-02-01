package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import java.util.Comparator;

public class MsgTabNodeInfoComparator
  implements Comparator<MsgTabNodeInfo>
{
  public int a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2)
  {
    if (paramMsgTabNodeInfo1.a == 1)
    {
      if (paramMsgTabNodeInfo2.a == 1) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.a == 1) {
      return 1;
    }
    if (((paramMsgTabNodeInfo2.a == 13) && (paramMsgTabNodeInfo2.b == 0)) || ((paramMsgTabNodeInfo1.a == 13) && (paramMsgTabNodeInfo1.b > 0))) {
      return -1;
    }
    if (((paramMsgTabNodeInfo2.a == 13) && (paramMsgTabNodeInfo2.b > 0)) || ((paramMsgTabNodeInfo1.a == 13) && (paramMsgTabNodeInfo1.b == 0))) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.a == 2)
    {
      if (paramMsgTabNodeInfo2.a == 2) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.a == 2) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.a == 3)
    {
      if (paramMsgTabNodeInfo2.a == 3) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.a == 3) {
      return 1;
    }
    if ((paramMsgTabNodeInfo1.a == 5) && (paramMsgTabNodeInfo1.a() > 0))
    {
      if ((paramMsgTabNodeInfo2.a == 5) && (paramMsgTabNodeInfo2.a() > 0)) {
        return 0;
      }
      return -1;
    }
    if ((paramMsgTabNodeInfo2.a == 5) && (paramMsgTabNodeInfo2.a() > 0)) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.a == 4)
    {
      if (paramMsgTabNodeInfo2.a == 4) {
        return 0;
      }
      return 1;
    }
    if (paramMsgTabNodeInfo2.a == 4) {
      return -1;
    }
    if ((paramMsgTabNodeInfo1.b > 0) && (paramMsgTabNodeInfo2.b == 0)) {
      return -1;
    }
    if ((paramMsgTabNodeInfo1.b == 0) && (paramMsgTabNodeInfo2.b > 0)) {
      return 1;
    }
    return -MsgTabStoryUtil.a(paramMsgTabNodeInfo1.d, paramMsgTabNodeInfo2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfoComparator
 * JD-Core Version:    0.7.0.1
 */