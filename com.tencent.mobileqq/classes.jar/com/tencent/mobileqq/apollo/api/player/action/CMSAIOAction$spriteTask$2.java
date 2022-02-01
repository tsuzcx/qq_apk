package com.tencent.mobileqq.apollo.api.player.action;

import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
final class CMSAIOAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  CMSAIOAction$spriteTask$2(CMSAIOAction paramCMSAIOAction)
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
    int i;
    if (this.this$0.a().is3dAction())
    {
      i = this.this$0.a().mApollo3DMessage.actionID_3D;
      localSpriteTaskParam.f = i;
      localSpriteTaskParam.jdField_c_of_type_Int = this.this$0.a().actionType;
      localSpriteTaskParam.h = this.this$0.a();
      localSpriteTaskParam.jdField_a_of_type_Boolean = this.this$0.a().isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = this.this$0.a().uniseq;
      localSpriteTaskParam.i = this.this$0.a().audioId;
      localSpriteTaskParam.jdField_a_of_type_Float = this.this$0.a().audioStartTime;
      if (!this.this$0.a().isDoubleAction()) {
        break label326;
      }
      i = 1;
      label158:
      localSpriteTaskParam.e = i;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = this.this$0.a().inputText;
      localSpriteTaskParam.jdField_b_of_type_Boolean = this.this$0.a().isBarrageMode();
      localSpriteTaskParam.d = this.this$0.a().extendJson;
      localSpriteTaskParam.l = this.this$0.a().mSendSrc;
      localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
      localSpriteTaskParam.jdField_a_of_type_Int = ((ISpriteScriptManager)((AppRuntime)localObject).getRuntimeService(ISpriteScriptManager.class, "all")).getTaskHandler().b();
      if (!CmShowAioMatcher.a(localSpriteTaskParam.h, 1)) {
        break label361;
      }
      if (!this.this$0.a().isSend()) {
        break label331;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = this.this$0.a().frienduin;
    }
    label326:
    label331:
    label361:
    while (!CmShowAioMatcher.a(localSpriteTaskParam.h, 2))
    {
      return localSpriteTaskParam;
      i = this.this$0.a().mApolloMessage.id;
      break;
      i = 0;
      break label158;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = this.this$0.a().selfuin;
      return localSpriteTaskParam;
    }
    localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(this.this$0.a().mApolloMessage.peer_uin);
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().senderuin;
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.action.CMSAIOAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */