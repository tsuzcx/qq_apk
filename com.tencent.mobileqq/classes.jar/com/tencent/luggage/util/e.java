package com.tencent.luggage.util;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/CronetDownloader;", "", "()V", "DEFAULT_TIMEOUT_MS", "", "TAG", "", "TASK_ID_HOLDER", "Ljava/util/concurrent/atomic/AtomicInteger;", "createCronetParams", "Lcom/tencent/mars/cdn/CronetLogic$CronetRequestParams;", "url", "savePath", "downloadSync", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a = new e();
  private static final AtomicInteger b = new AtomicInteger(0);
  
  static
  {
    CronetLogic.initializeNativeLib();
  }
  
  @NotNull
  public final CronetLogic.CronetRequestParams a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "savePath");
    CronetLogic.CronetRequestParams localCronetRequestParams = new CronetLogic.CronetRequestParams();
    localCronetRequestParams.url = paramString1;
    localCronetRequestParams.taskId = String.valueOf(b.getAndIncrement());
    localCronetRequestParams.followRedirect = true;
    localCronetRequestParams.savePath = k.c(paramString2, true);
    localCronetRequestParams.method = "GET";
    localCronetRequestParams.needWirteCache = true;
    localCronetRequestParams.useHttp2 = true;
    localCronetRequestParams.useQuic = true;
    localCronetRequestParams.useMemoryCache = false;
    paramString1 = (Map)new HashMap();
    paramString1.put("Accept-Encoding", "gzip,compress,br,deflate");
    paramString1.put("User-Agent", "");
    localCronetRequestParams.makeRequestHeader(paramString1);
    localCronetRequestParams.taskType = 2;
    return localCronetRequestParams;
  }
  
  public final int b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "savePath");
    long l = System.currentTimeMillis();
    Object localObject2 = a(paramString1, paramString2);
    paramString2 = ((CronetLogic.CronetRequestParams)localObject2).taskId;
    Object localObject1 = new AtomicInteger(2147483647);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    localObject2 = CronetLogic.startCronetDownloadTask((CronetLogic.CronetRequestParams)localObject2, (CronetLogic.CronetTaskCallback)new e.a(paramString2, l, (AtomicInteger)localObject1, localCountDownLatch));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadSync createRet is ");
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localStringBuilder.append(((CronetLogic.CronetHttpsCreateResult)localObject2).createRet);
    localStringBuilder.append(',');
    localStringBuilder.append(" taskId ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", createResult.taskId:");
    localStringBuilder.append(((CronetLogic.CronetHttpsCreateResult)localObject2).taskId);
    o.d("Luggage.CronetDownloader", localStringBuilder.toString());
    try
    {
      localCountDownLatch.await(1001000L, TimeUnit.MILLISECONDS);
      int i = ((AtomicInteger)localObject1).get();
      return i;
    }
    catch (Exception localException)
    {
      label184:
      break label184;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadSync url:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" fail, timeout");
    o.b("Luggage.CronetDownloader", ((StringBuilder)localObject1).toString());
    CronetLogic.cancelCronetTask(paramString2);
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.e
 * JD-Core Version:    0.7.0.1
 */