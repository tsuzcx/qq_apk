package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import java.util.Comparator;

final class QQGameNoticeServiceImpl$1
  implements Comparator<GameNoticeInfo>
{
  public int a(GameNoticeInfo paramGameNoticeInfo1, GameNoticeInfo paramGameNoticeInfo2)
  {
    if (paramGameNoticeInfo1.startTime == paramGameNoticeInfo2.startTime) {
      return paramGameNoticeInfo1.bannerType - paramGameNoticeInfo2.bannerType;
    }
    if (paramGameNoticeInfo1.startTime < paramGameNoticeInfo2.startTime) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */