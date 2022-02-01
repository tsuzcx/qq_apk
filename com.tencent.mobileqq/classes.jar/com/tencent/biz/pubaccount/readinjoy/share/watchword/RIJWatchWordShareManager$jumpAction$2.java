package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"showToast", "", "text", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$jumpAction$2
  extends Lambda
  implements Function1<String, Unit>
{
  public static final 2 INSTANCE = new 2();
  
  RIJWatchWordShareManager$jumpAction$2()
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    QQToast.a((Context)BaseActivity.sTopActivity, 0, (CharSequence)paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.jumpAction.2
 * JD-Core Version:    0.7.0.1
 */