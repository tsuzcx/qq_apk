package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordPresenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$onAppForeground$1
  extends Lambda
  implements Function1<String, Unit>
{
  RIJWatchWordShareManager$onAppForeground$1(RIJWatchWordShareManager paramRIJWatchWordShareManager)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    if (QLog.isColorLevel()) {
      QLog.i("RIJWatchWordShareManager", 0, "onAppForeground clip board text " + paramString);
    }
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    Object localObject = this.this$0.a(paramString);
    if (((CharSequence)localObject).length() > 0) {}
    for (i = 1; i != 0; i = 0)
    {
      RIJWatchWordShareManager.a(this.this$0).a((String)localObject);
      return;
    }
    localObject = ((Iterable)RIJWatchWordShareManager.a(this.this$0)).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((RIJWatchWordShareManager.OnWatchWordCheck)((Iterator)localObject).next()).a(paramString)) {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.onAppForeground.1
 * JD-Core Version:    0.7.0.1
 */