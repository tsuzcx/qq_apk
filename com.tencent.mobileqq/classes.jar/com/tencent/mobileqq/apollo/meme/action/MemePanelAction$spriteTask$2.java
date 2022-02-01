package com.tencent.mobileqq.apollo.meme.action;

import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
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
final class MemePanelAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  MemePanelAction$spriteTask$2(MemePanelAction paramMemePanelAction)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    Object localObject = QRoute.api(IApolloUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloUtil::class.java)");
    AppRuntime localAppRuntime = ((IApolloUtil)localObject).getAppInterface();
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = this.this$0.d().actionId;
    localSpriteTaskParam.c = this.this$0.d().actionType;
    localSpriteTaskParam.i = 1;
    localSpriteTaskParam.l = true;
    localSpriteTaskParam.e = this.this$0.d().personNum;
    localSpriteTaskParam.j = this.this$0.e();
    if (this.this$0.d().personNum != 0)
    {
      localObject = this.this$0.n();
      if (localObject == null) {
        localObject = "-1";
      }
    }
    else
    {
      localObject = null;
    }
    localSpriteTaskParam.k = ((String)localObject);
    localSpriteTaskParam.v = 15;
    localSpriteTaskParam.A = this.this$0.f();
    localSpriteTaskParam.a = ((ISpriteScriptManager)localAppRuntime.getRuntimeService(ISpriteScriptManager.class, "all")).getTaskHandler().d();
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemePanelAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */