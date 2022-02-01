package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertConfig;", "", "()V", "getDynamicInsertWatchInfoDelay", "", "reqSource", "isDynamicInsertConfigOpen", "", "isDynamicInsertEnable", "channelId", "(Ljava/lang/Integer;)Z", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertConfig
{
  public static final RIJFeedsDynamicInsertConfig a = new RIJFeedsDynamicInsertConfig();
  
  public final int a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      str = "";
    }
    for (;;)
    {
      return Aladdin.getConfig(439).getIntegerFromString(str, 3000);
      str = "main_tl_preload_time";
      continue;
      str = "article_page_preload_time";
      continue;
      str = "video_page_preload_time";
    }
  }
  
  public final boolean a()
  {
    return Aladdin.getConfig(439).getIntegerFromString("enable_switch", 0) == 1;
  }
  
  public final boolean a(@Nullable Integer paramInteger)
  {
    if (paramInteger == null) {}
    while (paramInteger.intValue() != 0) {
      return false;
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertConfig
 * JD-Core Version:    0.7.0.1
 */