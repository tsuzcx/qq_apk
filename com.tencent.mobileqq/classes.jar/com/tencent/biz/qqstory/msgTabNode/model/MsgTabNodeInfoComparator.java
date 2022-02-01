package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import java.util.Comparator;

public class MsgTabNodeInfoComparator
  implements Comparator<MsgTabNodeInfo>
{
  public int a(MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2)
  {
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    int j = 1;
    if (paramMsgTabNodeInfo1.a == 1) {
      if (paramMsgTabNodeInfo2.a != 1) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    return i;
                    i = -1;
                  }
                  i = j;
                } while (paramMsgTabNodeInfo2.a == 1);
                if (((paramMsgTabNodeInfo2.a == 13) && (paramMsgTabNodeInfo2.b == 0)) || ((paramMsgTabNodeInfo1.a == 13) && (paramMsgTabNodeInfo1.b > 0))) {
                  return -1;
                }
                if (paramMsgTabNodeInfo2.a != 13) {
                  break;
                }
                i = j;
              } while (paramMsgTabNodeInfo2.b > 0);
              if (paramMsgTabNodeInfo1.a != 13) {
                break;
              }
              i = j;
            } while (paramMsgTabNodeInfo1.b == 0);
            if (paramMsgTabNodeInfo1.a == 2)
            {
              if (paramMsgTabNodeInfo2.a == 2) {}
              for (i = k;; i = -1) {
                return i;
              }
            }
            i = j;
          } while (paramMsgTabNodeInfo2.a == 2);
          if (paramMsgTabNodeInfo1.a == 3)
          {
            if (paramMsgTabNodeInfo2.a == 3) {}
            for (i = m;; i = -1) {
              return i;
            }
          }
          i = j;
        } while (paramMsgTabNodeInfo2.a == 3);
        if ((paramMsgTabNodeInfo1.a == 5) && (paramMsgTabNodeInfo1.a() > 0))
        {
          if ((paramMsgTabNodeInfo2.a == 5) && (paramMsgTabNodeInfo2.a() > 0)) {}
          for (i = n;; i = -1) {
            return i;
          }
        }
        if (paramMsgTabNodeInfo2.a != 5) {
          break;
        }
        i = j;
      } while (paramMsgTabNodeInfo2.a() > 0);
      if (paramMsgTabNodeInfo1.a == 4)
      {
        if (paramMsgTabNodeInfo2.a == 4) {}
        for (i = i1;; i = 1) {
          return i;
        }
      }
      if (paramMsgTabNodeInfo2.a == 4) {
        return -1;
      }
      if ((paramMsgTabNodeInfo1.b > 0) && (paramMsgTabNodeInfo2.b == 0)) {
        return -1;
      }
      if (paramMsgTabNodeInfo1.b != 0) {
        break;
      }
      i = j;
    } while (paramMsgTabNodeInfo2.b > 0);
    return -MsgTabStoryUtil.a(paramMsgTabNodeInfo1.d, paramMsgTabNodeInfo2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfoComparator
 * JD-Core Version:    0.7.0.1
 */