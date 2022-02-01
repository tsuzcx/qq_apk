package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.graphics.Paint;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class PhotoDanmakuDrawer$1
  extends LinkedHashMap<String, Paint>
{
  protected boolean removeEldestEntry(Map.Entry<String, Paint> paramEntry)
  {
    return size() > 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer.1
 * JD-Core Version:    0.7.0.1
 */