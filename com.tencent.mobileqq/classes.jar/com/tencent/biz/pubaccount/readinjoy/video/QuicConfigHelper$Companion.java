package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/QuicConfigHelper$Companion;", "", "()V", "PROTOCOL_QUIC", "", "connectionMigrationEnable", "", "getQuicHostList", "", "isUrlCanUseQuic", "url", "plainTextEnable", "quicCongestionType", "", "quicWifiEnable", "quicXgEnable", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QuicConfigHelper$Companion
{
  public final int a()
  {
    return Aladdin.getConfig(395).getIntegerFromString("quic_congestion_type", 0);
  }
  
  @NotNull
  public final List<String> a()
  {
    String str = Aladdin.getConfig(395).getString("quic_host_list", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "quicHostListStr");
    return StringsKt.split$default((CharSequence)str, new String[] { "," }, false, 0, 6, null);
  }
  
  public final boolean a()
  {
    return Aladdin.getConfig(395).getIntegerFromString("wifi_enable_quic", 0) == 1;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    Iterator localIterator = ((Companion)this).a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString != null)
      {
        CharSequence localCharSequence = (CharSequence)paramString;
        if (new Regex("http[s]?://" + str + ".*").matches(localCharSequence) == true) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    return Aladdin.getConfig(395).getIntegerFromString("xg_enable_quic", 0) == 1;
  }
  
  public final boolean c()
  {
    return Aladdin.getConfig(395).getIntegerFromString("enable_plain_text", 0) == 1;
  }
  
  public final boolean d()
  {
    return Aladdin.getConfig(395).getIntegerFromString("enable_connection_migration", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.QuicConfigHelper.Companion
 * JD-Core Version:    0.7.0.1
 */