package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.util.DanmakuUtils;
import java.io.Serializable;
import java.util.Comparator;

public final class DanmakuManager$DanmakuComparator
  implements Serializable, Comparator<BaseDanmaku>
{
  public int compare(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2)
  {
    return DanmakuUtils.a(paramBaseDanmaku1, paramBaseDanmaku2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.DanmakuComparator
 * JD-Core Version:    0.7.0.1
 */