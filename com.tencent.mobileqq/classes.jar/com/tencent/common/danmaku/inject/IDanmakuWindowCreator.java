package com.tencent.common.danmaku.inject;

import com.tencent.common.danmaku.core.AbsWindow;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import java.util.Comparator;

public abstract interface IDanmakuWindowCreator
{
  public abstract AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.inject.IDanmakuWindowCreator
 * JD-Core Version:    0.7.0.1
 */