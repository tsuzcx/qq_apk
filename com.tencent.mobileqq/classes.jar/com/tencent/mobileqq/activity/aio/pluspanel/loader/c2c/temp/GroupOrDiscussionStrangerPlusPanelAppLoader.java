package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.CommonPlusPanelAppLoader;

public class GroupOrDiscussionStrangerPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  public void b(BaseChatPie paramBaseChatPie)
  {
    if (!BmqqSegmentUtil.c(paramBaseChatPie.ah.b)) {
      a(paramBaseChatPie.ah.a, 219);
    }
    a(paramBaseChatPie.ah.a, 205);
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 208);
    if (!BmqqSegmentUtil.c(paramBaseChatPie.ah.b)) {
      a(paramBaseChatPie.ah.a, 211);
    }
    a(paramBaseChatPie.ah.a, 212);
    a(paramBaseChatPie.ah.a, 213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.GroupOrDiscussionStrangerPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */