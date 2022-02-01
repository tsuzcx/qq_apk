package com.tencent.mobileqq.apollo.player.action;

import amvm;
import anci;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSAIOAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  public CMSAIOAction$spriteTask$2(amvm paramamvm)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = this.this$0.a().mApolloMessage.id;
    localSpriteTaskParam.jdField_c_of_type_Int = this.this$0.a().actionType;
    localSpriteTaskParam.h = 1;
    localSpriteTaskParam.jdField_a_of_type_Boolean = this.this$0.a().isSend();
    localSpriteTaskParam.jdField_a_of_type_Long = this.this$0.a().uniseq;
    localSpriteTaskParam.i = this.this$0.a().audioId;
    localSpriteTaskParam.jdField_a_of_type_Float = this.this$0.a().audioStartTime;
    int i;
    if (this.this$0.a().isDoubleAction())
    {
      i = 1;
      localSpriteTaskParam.e = i;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = this.this$0.a().inputText;
      localSpriteTaskParam.jdField_b_of_type_Boolean = this.this$0.a().isBarrageMode();
      localSpriteTaskParam.d = this.this$0.a().extendJson;
      localSpriteTaskParam.l = this.this$0.a().mSendSrc;
      localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
      anci.jdField_a_of_type_Int += 1;
      localSpriteTaskParam.jdField_a_of_type_Int = anci.jdField_a_of_type_Int;
      if (localSpriteTaskParam.h != 0) {
        break label287;
      }
      if (!this.this$0.a().isSend()) {
        break label257;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = this.this$0.a().frienduin;
    }
    label257:
    label287:
    while ((localSpriteTaskParam.h != 1) && (localSpriteTaskParam.h != 3000))
    {
      return localSpriteTaskParam;
      i = 0;
      break;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = this.this$0.a().selfuin;
      return localSpriteTaskParam;
    }
    localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(this.this$0.a().mApolloMessage.peer_uin);
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.a().senderuin;
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSAIOAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */