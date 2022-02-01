package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer$GetFrameImageListener;", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "listener", "Lcom/tencent/mobileqq/apollo/player/GetFrameCallback;", "timeStart", "", "(Lcom/tencent/mobileqq/apollo/player/GetFrameCallback;J)V", "callbackRef", "Ljava/lang/ref/WeakReference;", "onRecordDone", "", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "success", "", "recordKey", "", "recordPath", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSPlayer$GetFrameImageListener
  implements ICMSPlayerListener
{
  private final long jdField_a_of_type_Long;
  private final WeakReference<GetFrameCallback> jdField_a_of_type_JavaLangRefWeakReference;
  
  public CMSPlayer$GetFrameImageListener(@Nullable GetFrameCallback paramGetFrameCallback, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGetFrameCallback);
  }
  
  public void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    ICMSPlayerListener.DefaultImpls.a(this, paramCMSAction);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    ICMSPlayerListener.DefaultImpls.a(this, paramCMSAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramCMSActionStatus, "status");
    ICMSPlayerListener.DefaultImpls.a(this, paramCMSAction, paramCMSActionStatus);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    CMSAction.a(paramCMSAction, null, null, 3, null);
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage result, " + paramCMSAction.d() + ", success:" + paramBoolean + ", path:" + paramString2 + ", costTime:" + (l1 - l2));
    paramString1 = CMSHelper.a;
    paramString1 = (GetFrameCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString1 != null)
    {
      paramString1.a(paramBoolean, paramString2, paramCMSAction);
      return;
    }
    QLog.e("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage result, caller is null " + paramCMSAction.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.GetFrameImageListener
 * JD-Core Version:    0.7.0.1
 */