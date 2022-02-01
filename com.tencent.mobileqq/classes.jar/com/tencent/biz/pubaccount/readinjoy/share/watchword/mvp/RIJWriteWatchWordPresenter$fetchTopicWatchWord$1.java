package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rbw;
import rbx;
import rcd;
import rce;
import rcq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "watchWord", "", "jumpUrl", "isOpen", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJWriteWatchWordPresenter$fetchTopicWatchWord$1
  extends Lambda
  implements Function3<String, String, Boolean, Unit>
{
  public RIJWriteWatchWordPresenter$fetchTopicWatchWord$1(rcq paramrcq, String paramString1, String paramString2)
  {
    super(3);
  }
  
  public final void invoke(@Nullable String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    int i;
    Object localObject;
    if (paramString1 != null) {
      if (((CharSequence)paramString1).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label125;
        }
        localObject = rcq.a(this.this$0);
        if (localObject != null) {
          ((rce)localObject).showSuccessToast(rcq.a(this.this$0).a());
        }
        rcd localrcd = rcq.a(this.this$0);
        localObject = this.$title;
        if (localObject == null) {
          break label118;
        }
        label84:
        localrcd.a(paramString1, paramString2, (String)localObject, paramBoolean, 2);
        rbw.a.a().a(paramString1, this.$url);
      }
    }
    label118:
    label125:
    do
    {
      return;
      i = 0;
      break;
      localObject = "";
      break label84;
      paramString1 = rcq.a(this.this$0);
    } while (paramString1 == null);
    paramString1.showFailedToast(rcq.a(this.this$0).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchTopicWatchWord.1
 * JD-Core Version:    0.7.0.1
 */