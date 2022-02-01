package com.tencent.ilive.sorely;

import android.content.Context;
import com.tencent.ilive.LiveSDK;
import com.tencent.livesdk.soentry.ICheckResult;
import com.tencent.livesdk.soentry.RelyConfig;
import com.tencent.livesdk.soentry.SoEntry;
import com.tencent.livesdk.soentry.SoEntry.ConfigBuilder;
import com.tencent.livesdk.soentry.func.SoRelyChecker;

public class SoRelyThirdEntry
{
  public static boolean checkRely(Context paramContext, ICheckResult paramICheckResult)
  {
    RelyConfig localRelyConfig = new SoEntry.ConfigBuilder().setSopath(LiveSDK.getLibCacheDir(paramContext)).build();
    return SoEntry.instanse().newEntry(paramContext, localRelyConfig, SoRelyUtil.getDownloader(paramContext)).setRelyAnnoClass(SoRelyThirdEntry.class).check(paramICheckResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.sorely.SoRelyThirdEntry
 * JD-Core Version:    0.7.0.1
 */