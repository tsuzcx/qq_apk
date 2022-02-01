package com.tencent.luggage.util;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/util/CronetEx$send$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class f$a
  implements CronetLogic.CronetTaskCallback
{
  f$a(CancellableContinuation paramCancellableContinuation, String paramString1, String paramString2) {}
  
  public int onCronetReceiveHeader(@Nullable CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    paramResponseHeader = new StringBuilder();
    paramResponseHeader.append("onCronetReceiveHeader, url:");
    paramResponseHeader.append(this.b);
    paramResponseHeader.append(", status_code:");
    paramResponseHeader.append(paramInt);
    o.d("Luggage.CronetEx", paramResponseHeader.toString());
    return 0;
  }
  
  public void onCronetTaskCompleted(@Nullable String paramString, @Nullable CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    int j = -1;
    if (paramCronetTaskResult != null) {
      i = paramCronetTaskResult.errorCode;
    } else {
      i = -1;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 0)
    {
      if (paramCronetTaskResult == null) {
        Intrinsics.throwNpe();
      }
      bool1 = bool2;
      if (200 == paramCronetTaskResult.statusCode) {
        bool1 = true;
      }
    }
    paramString = new StringBuilder();
    paramString.append("onCronetTaskCompleted url:");
    paramString.append(this.b);
    paramString.append(", code:");
    if (paramCronetTaskResult != null) {
      i = paramCronetTaskResult.errorCode;
    } else {
      i = -1;
    }
    paramString.append(i);
    paramString.append(", statusCode:");
    int i = j;
    if (paramCronetTaskResult != null) {
      i = paramCronetTaskResult.statusCode;
    }
    paramString.append(i);
    o.d("Luggage.CronetEx", paramString.toString());
    paramString = this.a;
    paramCronetTaskResult = Result.Companion;
    paramString.resumeWith(Result.constructor-impl(Boolean.valueOf(bool1)));
  }
  
  public void onDownloadProgressChanged(@Nullable String paramString, @Nullable CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.f.a
 * JD-Core Version:    0.7.0.1
 */