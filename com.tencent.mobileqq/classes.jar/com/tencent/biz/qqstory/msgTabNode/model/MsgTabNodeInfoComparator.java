package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import java.util.Comparator;

public class MsgTabNodeInfoComparator
  implements Comparator<MsgTabNodeInfo>
{
  public int a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2)
  {
    if (paramMsgTabNodeInfo1.b == 1)
    {
      if (paramMsgTabNodeInfo2.b == 1) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.b == 1) {
      return 1;
    }
    if (((paramMsgTabNodeInfo2.b == 13) && (paramMsgTabNodeInfo2.i == 0)) || ((paramMsgTabNodeInfo1.b == 13) && (paramMsgTabNodeInfo1.i > 0))) {
      return -1;
    }
    if (((paramMsgTabNodeInfo2.b == 13) && (paramMsgTabNodeInfo2.i > 0)) || ((paramMsgTabNodeInfo1.b == 13) && (paramMsgTabNodeInfo1.i == 0))) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.b == 2)
    {
      if (paramMsgTabNodeInfo2.b == 2) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.b == 2) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.b == 3)
    {
      if (paramMsgTabNodeInfo2.b == 3) {
        return 0;
      }
      return -1;
    }
    if (paramMsgTabNodeInfo2.b == 3) {
      return 1;
    }
    if ((paramMsgTabNodeInfo1.b == 5) && (paramMsgTabNodeInfo1.c() > 0))
    {
      if ((paramMsgTabNodeInfo2.b == 5) && (paramMsgTabNodeInfo2.c() > 0)) {
        return 0;
      }
      return -1;
    }
    if ((paramMsgTabNodeInfo2.b == 5) && (paramMsgTabNodeInfo2.c() > 0)) {
      return 1;
    }
    if (paramMsgTabNodeInfo1.b == 4)
    {
      if (paramMsgTabNodeInfo2.b == 4) {
        return 0;
      }
      return 1;
    }
    if (paramMsgTabNodeInfo2.b == 4) {
      return -1;
    }
    if ((paramMsgTabNodeInfo1.i > 0) && (paramMsgTabNodeInfo2.i == 0)) {
      return -1;
    }
    if ((paramMsgTabNodeInfo1.i == 0) && (paramMsgTabNodeInfo2.i > 0)) {
      return 1;
    }
    return -MsgTabStoryUtil.a(paramMsgTabNodeInfo1.h, paramMsgTabNodeInfo2.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfoComparator
 * JD-Core Version:    0.7.0.1
 */