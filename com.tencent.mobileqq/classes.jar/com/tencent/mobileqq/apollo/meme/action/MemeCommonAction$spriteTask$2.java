package com.tencent.mobileqq.apollo.meme.action;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
final class MemeCommonAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  MemeCommonAction$spriteTask$2(MemeCommonAction paramMemeCommonAction)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    Object localObject = QRoute.api(IApolloUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloUtil::class.java)");
    localObject = ((IApolloUtil)localObject).getAppInterface();
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = MemeCommonAction.a(this.this$0);
    localSpriteTaskParam.c = MemeCommonAction.b(this.this$0);
    localSpriteTaskParam.i = 1;
    localSpriteTaskParam.l = true;
    localSpriteTaskParam.e = (true ^ TextUtils.isEmpty((CharSequence)MemeCommonAction.c(this.this$0)));
    localSpriteTaskParam.j = MemeCommonAction.d(this.this$0);
    localSpriteTaskParam.k = MemeCommonAction.c(this.this$0);
    localSpriteTaskParam.t = MemeCommonAction.e(this.this$0);
    localSpriteTaskParam.A = this.this$0.f();
    localSpriteTaskParam.a = ((ISpriteScriptManager)((AppRuntime)localObject).getRuntimeService(ISpriteScriptManager.class, "all")).getTaskHandler().d();
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeCommonAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */