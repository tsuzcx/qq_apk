package com.tencent.ilive;

import android.content.Context;
import android.util.Log;
import com.facebook.soloader.SoLoader;
import com.tencent.ilive.util.soloader.SoFileLoadManager;
import com.tencent.livesdk.soentry.ICheckResult;
import java.io.File;

final class LiveSDK$1
  implements ICheckResult
{
  LiveSDK$1(Context paramContext, ICheckResult paramICheckResult) {}
  
  public void progress(String paramString, int paramInt)
  {
    this.val$iInitCallback.progress(paramString, paramInt);
  }
  
  public void result(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("core init suc: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", msg: ");
    localStringBuilder.append(paramString);
    Log.i("livesdk", localStringBuilder.toString());
    if (paramBoolean) {}
    try
    {
      SoFileLoadManager.loadSoFile(this.val$context, LiveSDK.getLibCacheDir(this.val$context).getAbsolutePath());
      SoLoader.init(this.val$context, false);
      LiveSDK.access$000(this.val$context);
      this.val$iInitCallback.result(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.val$iInitCallback.result(false, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.LiveSDK.1
 * JD-Core Version:    0.7.0.1
 */