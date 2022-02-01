package com.tencent.luggage.util;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/util/CronetDownloader$downloadSync$createResult$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e$a
  implements CronetLogic.CronetTaskCallback
{
  e$a(String paramString, long paramLong, AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch) {}
  
  public int onCronetReceiveHeader(@NotNull CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramResponseHeader, "header");
    paramResponseHeader = new StringBuilder();
    paramResponseHeader.append("onCronetReceiveHeader status: ");
    paramResponseHeader.append(paramInt);
    paramResponseHeader.append(" taskId:");
    paramResponseHeader.append(this.a);
    o.d("Luggage.CronetDownloader", paramResponseHeader.toString());
    return 0;
  }
  
  public void onCronetTaskCompleted(@NotNull String paramString, @NotNull CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filekey");
    Intrinsics.checkParameterIsNotNull(paramCronetTaskResult, "result");
    try
    {
      str = x.c(r.a());
      Intrinsics.checkExpressionValueIsNotNull(str, "NetStatusUtil.getFormate…tionContext.getContext())");
    }
    catch (Exception localException)
    {
      String str;
      label28:
      StringBuilder localStringBuilder;
      break label28;
    }
    str = "UNKNOWN";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCronetTaskCompleted, ");
    localStringBuilder.append("errorCode:");
    localStringBuilder.append(paramCronetTaskResult.errorCode);
    localStringBuilder.append(", ");
    localStringBuilder.append("errorMsg:");
    localStringBuilder.append(paramCronetTaskResult.errorMsg);
    localStringBuilder.append(", ");
    localStringBuilder.append("httpStatusCode:");
    localStringBuilder.append(paramCronetTaskResult.statusCode);
    localStringBuilder.append(", ");
    localStringBuilder.append("totalReceiveByte:");
    localStringBuilder.append(paramCronetTaskResult.totalReceiveByte);
    localStringBuilder.append(", ");
    localStringBuilder.append("taskId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("fileKey:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append("cost:");
    localStringBuilder.append(af.d() - this.b);
    localStringBuilder.append("ms, ");
    localStringBuilder.append("networkType:");
    localStringBuilder.append(str);
    o.d("Luggage.CronetDownloader", localStringBuilder.toString());
    this.c.set(paramCronetTaskResult.errorCode);
    this.d.countDown();
  }
  
  public void onDownloadProgressChanged(@NotNull String paramString, @NotNull CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filekey");
    Intrinsics.checkParameterIsNotNull(paramCronetDownloadProgress, "progress");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProgressChanged key:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", currentWriteByte:");
    localStringBuilder.append(paramCronetDownloadProgress.currentWriteByte);
    localStringBuilder.append(" totalByte:");
    localStringBuilder.append(paramCronetDownloadProgress.totalByte);
    o.f("Luggage.CronetDownloader", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.e.a
 * JD-Core Version:    0.7.0.1
 */