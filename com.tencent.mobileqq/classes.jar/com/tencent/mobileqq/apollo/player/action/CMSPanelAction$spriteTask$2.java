package com.tencent.mobileqq.apollo.player.action;

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
final class CMSPanelAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  CMSPanelAction$spriteTask$2(CMSPanelAction paramCMSPanelAction)
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
    localSpriteTaskParam.f = this.this$0.a().actionId;
    localSpriteTaskParam.jdField_c_of_type_Int = this.this$0.a().actionType;
    localSpriteTaskParam.h = 1;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    localSpriteTaskParam.e = this.this$0.a().personNum;
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.e();
    if (this.this$0.a().personNum != 0)
    {
      localObject = this.this$0.f();
      if (localObject == null) {
        localObject = "-1";
      }
    }
    else
    {
      localObject = null;
    }
    localSpriteTaskParam.b = ((String)localObject);
    localSpriteTaskParam.k = 15;
    localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
    localSpriteTaskParam.jdField_a_of_type_Int = ((ISpriteScriptManager)localAppRuntime.getRuntimeService(ISpriteScriptManager.class, "all")).getTaskHandler().b();
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSPanelAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */