package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "watchWord", "", "jumpUrl", "isOpen", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWriteWatchWordPresenter$fetchVideoWatchWord$1
  extends Lambda
  implements Function3<String, String, Boolean, Unit>
{
  RIJWriteWatchWordPresenter$fetchVideoWatchWord$1(RIJWriteWatchWordPresenter paramRIJWriteWatchWordPresenter, String paramString1, String paramString2)
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
        localObject = RIJWriteWatchWordPresenter.a(this.this$0);
        if (localObject != null) {
          ((IRIJWriteWatchWordShareContract.IView)localObject).showSuccessToast(RIJWriteWatchWordPresenter.a(this.this$0).a());
        }
        IRIJWriteWatchWordShareContract.IModel localIModel = RIJWriteWatchWordPresenter.a(this.this$0);
        localObject = this.$title;
        if (localObject == null) {
          break label118;
        }
        label84:
        localIModel.a(paramString1, paramString2, (String)localObject, paramBoolean, 1);
        RIJWatchWordShareManager.a.a().a(paramString1, this.$url);
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
      paramString1 = RIJWriteWatchWordPresenter.a(this.this$0);
    } while (paramString1 == null);
    paramString1.showFailedToast(RIJWriteWatchWordPresenter.a(this.this$0).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchVideoWatchWord.1
 * JD-Core Version:    0.7.0.1
 */