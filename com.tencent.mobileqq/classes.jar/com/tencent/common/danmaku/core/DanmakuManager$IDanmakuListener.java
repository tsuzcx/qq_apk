package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.TouchPoint;
import java.util.List;

public abstract interface DanmakuManager$IDanmakuListener
{
  public abstract void a();
  
  public abstract void a(BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint, ClickResult paramClickResult);
  
  public abstract void a(List<BaseDanmaku> paramList);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.IDanmakuListener
 * JD-Core Version:    0.7.0.1
 */