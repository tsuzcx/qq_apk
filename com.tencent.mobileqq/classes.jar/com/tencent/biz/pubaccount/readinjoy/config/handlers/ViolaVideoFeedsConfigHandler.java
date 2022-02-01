package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/ViolaVideoFeedsConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ViolaVideoFeedsConfigHandler
  extends SimpleConfigHandler
{
  public static final ViolaVideoFeedsConfigHandler.Companion a = new ViolaVideoFeedsConfigHandler.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    return a.a();
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return a.a();
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        paramString = AladdinParseUtils.a(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
        paramString = paramString.entrySet().iterator();
        if (paramString.hasNext())
        {
          localEntry = (Map.Entry)paramString.next();
          if ("from_source".equals(localEntry.getKey())) {
            ReadInJoyHelper.a("viola_video_feeds_config", localEntry.getValue());
          }
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ViolaVideoFeedsConfigHandler", 1, "[ViolaVideoFeedsConfigHandler]: " + paramString.getMessage());
      }
      if ("videofeeds_version".equals(localEntry.getKey())) {
        ReadInJoyHelper.a("viola_video_feeds_version", localEntry.getValue());
      } else if ("ingore_native".equals(localEntry.getKey())) {
        ReadInJoyHelper.a("viola_video_ingore_native", localEntry.getValue());
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.a("viola_video_feeds_config", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaVideoFeedsConfigHandler
 * JD-Core Version:    0.7.0.1
 */