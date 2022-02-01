package com.tencent.common.danmaku.edit;

import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.common.danmaku.util.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/RichTextBridge;", "", "()V", "emoJiBridge", "Lcom/tencent/common/danmaku/edit/listener/IEmoJiBridge;", "getEmoJiBridge", "()Lcom/tencent/common/danmaku/edit/listener/IEmoJiBridge;", "emoJiBridgeImpl", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logger", "Lcom/tencent/common/danmaku/inject/VideoDanmakuConfig$ILogger;", "kotlin.jvm.PlatformType", "getLogger", "()Lcom/tencent/common/danmaku/inject/VideoDanmakuConfig$ILogger;", "initial", "", "Companion", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class RichTextBridge
{
  public static final RichTextBridge.Companion a = new RichTextBridge.Companion(null);
  private static final RichTextBridge c = new RichTextBridge();
  private final AtomicBoolean b = new AtomicBoolean(false);
  
  public final VideoDanmakuConfig.ILogger a()
  {
    return Logger.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.RichTextBridge
 * JD-Core Version:    0.7.0.1
 */