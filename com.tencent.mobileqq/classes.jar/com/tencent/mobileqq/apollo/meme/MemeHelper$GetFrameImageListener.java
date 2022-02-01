package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/MemeHelper$GetFrameImageListener;", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "listener", "Lcom/tencent/mobileqq/apollo/meme/GetFrameCallback;", "timeStart", "", "(Lcom/tencent/mobileqq/apollo/meme/GetFrameCallback;J)V", "callbackRef", "Ljava/lang/ref/WeakReference;", "onRecordDone", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "success", "", "recordKey", "", "recordPath", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class MemeHelper$GetFrameImageListener
  implements IMemePlayerListener
{
  private final WeakReference<GetFrameCallback> a;
  private final long b;
  
  public MemeHelper$GetFrameImageListener(@Nullable GetFrameCallback paramGetFrameCallback, long paramLong)
  {
    this.b = paramLong;
    this.a = new WeakReference(paramGetFrameCallback);
  }
  
  public void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    IMemePlayerListener.DefaultImpls.a(this, paramMemeAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    paramString1 = new StringBuilder();
    paramString1.append("getFrameImage result, ");
    paramString1.append(paramMemeAction.h());
    paramString1.append(", success:");
    paramString1.append(paramBoolean);
    paramString1.append(", ");
    paramString1.append("status:");
    paramString1.append(paramMemeAction.k());
    paramString1.append(", path:");
    paramString1.append(paramString2);
    paramString1.append(", costTime:");
    paramString1.append(l1 - l2);
    QLog.w("[cmshow][MemePlayer]", 1, paramString1.toString());
    paramString1 = (GetFrameCallback)this.a.get();
    if (paramString1 != null)
    {
      paramString1.a(paramBoolean, paramString2, paramMemeAction);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("getFrameImage result, caller is null ");
    paramString1.append(paramMemeAction.h());
    QLog.e("[cmshow][MemePlayer]", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper.GetFrameImageListener
 * JD-Core Version:    0.7.0.1
 */